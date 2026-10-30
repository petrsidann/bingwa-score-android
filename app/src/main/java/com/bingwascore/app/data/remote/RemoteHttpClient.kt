package com.bingwascore.app.data.remote

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the single Ktor client: OkHttp engine, WebSocket and SSE support.
 *
 * The base URL is the *effective* URL: the DataStore server-URL override when
 * one is stored, otherwise BuildConfig.BASE_URL. The client is rebuilt
 * reactively whenever the stored override changes; every rebuild bumps
 * [reconnectCount] so the UI can surface a "reconnected" signal.
 */
@Singleton
class RemoteHttpClient @Inject constructor(
    private val userPreferences: UserPreferences
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val lock = Any()
    private var client: HttpClient? = null
    private var currentBaseUrl: String = ""
    private val _reconnectCount = MutableStateFlow(0)
    val reconnectCount: StateFlow<Int> = _reconnectCount.asStateFlow()

    init {
        currentBaseUrl = BuildConfig.BASE_URL
        // Ktor client is built lazily on first use (and on URL change) so that
        // construction never blocks the main thread at startup.
        scope.launch {
            userPreferences.serverUrl.collect { stored ->
                val effective = stored.takeIf { it.isNotBlank() } ?: BuildConfig.BASE_URL
                synchronized(lock) {
                    if (effective == currentBaseUrl) return@collect
                    currentBaseUrl = effective
                    client?.close()
                    client = null
                }
                _reconnectCount.value = _reconnectCount.value + 1
            }
        }
    }

    /** The base URL the live client is pointing at. */
    val baseUrl: String
        get() = synchronized(lock) { currentBaseUrl }

    /** The live client, rebuilt on first use and whenever the stored URL changes. */
    fun client(): HttpClient = synchronized(lock) {
        client ?: buildClient(currentBaseUrl).also { client = it }
    }

    private fun buildClient(baseUrl: String): HttpClient =
        HttpClient(OkHttp) {
            expectSuccess = false
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = true
                    explicitNulls = false
                })
            }
            install(WebSockets)
            install(HttpTimeout) {
                requestTimeoutMillis = OfflineFallback.TIMEOUT_MILLIS
                connectTimeoutMillis = OfflineFallback.TIMEOUT_MILLIS
                socketTimeoutMillis = OfflineFallback.TIMEOUT_MILLIS
            }
        }

    /** Plain GET returning the raw body — used by [ApiService] implementations. */
    suspend fun getRaw(path: String, token: String? = null): String? =
        try {
            client().get("${baseUrl}$path") {
                token?.let { header(HttpHeaders.Authorization, "Bearer $it") }
            }.bodyAsText()
        } catch (t: Throwable) {
            Timber.w(TAG, "GET $path failed: ${t.message}")
            null
        }

    /** Plain POST returning the raw body — used by [ApiService] implementations. */
    suspend fun postRaw(path: String, body: String, token: String? = null): String? =
        try {
            client().post("${baseUrl}$path") {
                token?.let { header(HttpHeaders.Authorization, "Bearer $it") }
                contentType(ContentType.Application.Json)
                setBody(body)
            }.bodyAsText()
        } catch (t: Throwable) {
            Timber.w(TAG, "POST $path failed: ${t.message}")
            null
        }

    /**
     * Opens the relay WebSocket and emits every text frame.
     *
     * The flow COMPLETES in every failure mode (no backend, connect error, dead
     * socket), so a collector can never be left hanging on an open socket.
     */
    fun connectSocket(): Flow<String> = flow {
        val url = socketUrl
        if (url.isBlank()) {
            Timber.i("Socket disabled: no backend configured")
            return@flow
        }
        try {
            withTimeoutOrNull(SOCKET_OPEN_MILLIS) {
                client().webSocket(urlString = url) {
                    incoming.consumeEach { frame ->
                        // The protocol is text-only; binary frames are ignored.
                        val text = (frame as? Frame.Text)?.readText()
                        if (!text.isNullOrBlank()) emit(text)
                    }
                }
            }
        } catch (t: Throwable) {
            Timber.w(TAG, "Socket closed: ${t.message}")
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Subscribes to the Server-Sent Events stream and emits each `data:` line.
     *
     * Same contract as [connectSocket]: terminates promptly and quietly.
     */
    fun connectSse(): Flow<String> = flow {
        val url = sseUrl
        if (url.isBlank()) {
            Timber.i("SSE disabled: no backend configured")
            return@flow
        }
        try {
            withTimeoutOrNull(SOCKET_OPEN_MILLIS) {
                client().get(url) {
                    header(HttpHeaders.Accept, "text/event-stream")
                    header(HttpHeaders.CacheControl, "no-cache")
                }.bodyAsText().lines().forEach { line ->
                    // SSE framing: real payloads arrive as "data: <json>".
                    if (line.startsWith("data:")) {
                        val payload = line.removePrefix("data:").trim()
                        if (payload.isNotEmpty()) emit(payload)
                    }
                }
            }
        } catch (t: Throwable) {
            Timber.w(TAG, "SSE stream closed: ${t.message}")
        }
    }.flowOn(Dispatchers.IO)

    /** WebSocket endpoint for the relay socket, or "" when offline. */
    private val socketUrl: String
        get() = buildString {
            append(baseUrl.replaceFirst("http", "ws"))
            append("/socket")
        }

    /** Server-Sent Events endpoint for relay state pushes, or "" when offline. */
    private val sseUrl: String get() = "$baseUrl/events"

    companion object {
        const val TAG = "NETWORK"

        /** How long we wait for a socket/SSE connection before giving up. */
        const val SOCKET_OPEN_MILLIS = 10_000L
    }
}
