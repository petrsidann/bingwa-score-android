package com.bingwascore.app.infrastructure.hybridconnect

import com.bingwascore.app.domain.messaging.DeviceMessage
import com.bingwascore.app.domain.messaging.DeviceMessageParser
import com.google.gson.JsonObject
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HybridConnectClient @Inject constructor(
    okHttpClient: OkHttpClient
) {

    private val client = okHttpClient.newBuilder()
        .pingInterval(5, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(0, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val sessions = ConcurrentHashMap<String, WebSocket>()
    private val jobs = ConcurrentHashMap<String, Job>()

    var eventListener: ((DeviceMessage) -> Unit)? = null

    fun connect(serverId: String, wsUrl: String, autoReconnect: Boolean = true) {
        jobs[serverId]?.cancel()
        jobs[serverId] = scope.launch {
            val backoff = AtomicLong(2000L)
            val maxBackoff = 60000L

            while (isActive) {
                val closed = CompletableDeferred<Unit>()
                val request = Request.Builder().url(wsUrl).build()

                val webSocket = client.newWebSocket(request, object : WebSocketListener() {
                    override fun onOpen(webSocket: WebSocket, response: Response) {
                        sessions[serverId] = webSocket
                        backoff.set(2000L)
                        Timber.d("HybridConnect opened: $serverId")
                    }

                    override fun onMessage(webSocket: WebSocket, text: String) {
                        DeviceMessageParser.parse(text)?.let { message ->
                            if (message.type == DeviceMessage.PING) {
                                webSocket.send(
                                    DeviceMessageParser.toJson(
                                        DeviceMessage(type = DeviceMessage.PONG)
                                    )
                                )
                            } else {
                                eventListener?.invoke(message)
                            }
                        }
                    }

                    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                        Timber.e(t, "HybridConnect failed: $serverId")
                        sessions.remove(serverId)
                        closed.complete(Unit)
                    }

                    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                        sessions.remove(serverId)
                        closed.complete(Unit)
                    }
                })

                closed.await()
                webSocket.cancel()

                if (!autoReconnect) break
                delay(backoff.get())
                backoff.set((backoff.get() * 2).coerceAtMost(maxBackoff))
            }
        }
    }

    fun sendConnectMessage(serverId: String, connectId: String) {
        val payload = JsonObject().apply {
            addProperty("connectId", connectId)
            addProperty("appName", "Bingwa Score")
        }
        sendMessage(serverId, DeviceMessage(type = DeviceMessage.CONNECT, payload = payload))
    }

    fun sendMessage(serverId: String, message: DeviceMessage) {
        sessions[serverId]?.send(DeviceMessageParser.toJson(message))
    }

    fun disconnect(serverId: String) {
        sessions[serverId]?.close(1000, "disconnect")
        jobs[serverId]?.cancel()
    }

    fun disconnectAll() {
        sessions.values.forEach { it.close(1000, "disconnect") }
        sessions.clear()
        jobs.values.forEach { it.cancel() }
        jobs.clear()
    }
}
