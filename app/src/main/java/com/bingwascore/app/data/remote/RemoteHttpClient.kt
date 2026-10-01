package com.bingwascore.app.data.remote

import android.util.Log
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
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.channels.consumeEach
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the single Ktor client: OkHttp engine, WebSocket and SSE support.
 *
 * It is created lazily and is NEVER used unless [RemoteConfig.isRemoteConfigured]
 * is true, so an un-provisioned build constructs no sockets at all.
 *
 * Both streaming helpers ([connectSocket], [connectSse]) are wrapped in
 * `withTimeoutOrNull` and swallow every throw, so a dead server yields an
 * immediately-closing flow instead of a leaked coroutine.
 */
@Singleton
class RemoteHttpClient @Inject constructor(
    private val remoteConfig: RemoteConfig
) {

    /** Lazily built so an offline app never allocates an HTTP stack. */
    private val client: HttpClient by lazy {
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
    }

    /** Plain GET returning the raw body — used by [ApiService] implementations. */
    suspend fun getRaw(path: String, token: String? = null): String? =
        try {
            client.get("${remoteConfig.baseUrl}$path") {
                token?.let { header(HttpHeaders.Authorization, "Bearer $it") }
            }.bodyAsText()
        } catch (t: Throwable) {
            Timber.w(TAG, "GET $path failed: ${t.message}")
            null
        }

    /** Plain POST returning the raw body — used by [ApiService] implementations. */
    suspend fun postRaw(path: String, body: String, token: String? = null): String? =
        try {
            client.post("${remoteConfig.baseUrl}$path") {
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
        val url = remoteConfig.socketUrl
        if (url.isBlank()) {
            Timber.i("Socket disabled: no backend configured")
            return@flow
        }
        try {
            withTimeoutOrNull(SOCKET_OPEN_MILLIS) {
                client.webSocket(urlString = url) {
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
        val url = remoteConfig.sseUrl
        if (url.isBlank()) {
            Timber.i("SSE disabled: no backend configured")
            return@flow
        }
        try {
            withTimeoutOrNull(SOCKET_OPEN_MILLIS) {
                client.get(url) {
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

    companion object {
        const val TAG = "NETWORK"

        /** How long we wait for a socket/SSE connection before giving up. */
        const val SOCKET_OPEN_MILLIS = 10_000L
    }
}