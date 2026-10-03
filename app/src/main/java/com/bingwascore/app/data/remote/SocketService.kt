package com.bingwascore.app.data.remote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the server's event vocabulary, preserved verbatim.
 *
 * Keeping these as constants means the wire contract is already pinned; only
 * the transport is missing. The socket layer parses into these and nothing else.
 */
object SocketEvents {
    /** Ack for an airtime-balance request. */
    const val AIRTIME_BALANCE_GET_ACK = "task.airtime_balance.get_ack"

    /** App-state command relayed to a paired device. */
    const val APP_STATE_SET = "app_state.set"

    /** Generic task acknowledgement. */
    const val TASK_ACK = "task.ack"

    /** Server heartbeat. */
    const val PING = "ping"
}

/**
 * MEGA B — the relay socket listener.
 *
 * Offline-safe by construction: [start] is a no-op unless the socket is both
 * configured and flag-enabled, and every connection attempt is bounded by the
 * client's own timeouts. A server that never answers simply produces no events.
 */
@Singleton
class SocketService @Inject constructor(
    private val http: RemoteHttpClient,
    private val remoteConfig: RemoteConfig,
    private val offlineFallback: OfflineFallback,
    private val deviceRelay: DeviceRelay
) {

    /** Inbound events, already parsed. Empty until a socket is configured. */
    private val _events = MutableSharedFlow<SocketEvent>(extraBufferCapacity = 32)
    val events: SharedFlow<SocketEvent> = _events.asSharedFlow()

    /** The running connection, if any. Cancelled by [stop]. */
    private var job: Job? = null
    private val scope = CoroutineScope(SupervisorJob())

    /** One decoded socket frame. */
    data class SocketEvent(val name: String, val payload: JSONObject)

    /**
     * Opens the relay socket if — and only if — a backend exists and the flag is
     * on. Safe to call repeatedly; a second call while connected is ignored.
     */
    fun start() {
        if (!remoteConfig.isActive(remoteConfig.relaySocketEnabled)) {
            Timber.i(TAG, "Relay socket disabled (configured=%s)", remoteConfig.isRemoteConfigured)
            return
        }
        if (job?.isActive == true) return

        job = scope.launch {
            http.connectSocket().collect { frame -> dispatch(frame) }
        }
    }

    /** Closes the socket. Safe when never started. */
    fun stop() {
        job?.cancel()
        job = null
    }

    /** Cancels every scope this service owns — called when the app shuts down. */
    fun shutdown() {
        stop()
        scope.cancel()
    }

    /**
     * Routes one raw frame to the right handler.
     *
     * Exposed (and pure enough to test) so the event names can be exercised
     * without a live server.
     */
    suspend fun dispatch(rawFrame: String) {
        val frame = parseFrame(rawFrame) ?: return
        when (frame.name) {
            SocketEvents.APP_STATE_SET -> handleAppStateSet(frame.payload)
            SocketEvents.AIRTIME_BALANCE_GET_ACK,
            SocketEvents.TASK_ACK,
            SocketEvents.PING -> emit(frame)
            else -> Timber.d(TAG, "Ignoring unknown event ${frame.name}")
        }
    }

    /**
     * Applies an `app_state.set` command through [DeviceRelay], then re-emits it
     * so observers (UI, diagnostics) see it too.
     */
    private suspend fun handleAppStateSet(payload: JSONObject) {
        val serverId = payload.optString("serverId")
        val message = payload.optString("message")
        val state = payload.optString("state")
        val applied = deviceRelay.handleAppStateSet(serverId, message, state)
        if (applied != null) {
            emit(
                SocketEvent(
                    SocketEvents.APP_STATE_SET,
                    JSONObject().apply {
                        put("serverId", applied.serverId)
                        put("message", applied.message)
                        put("state", applied.state.value)
                    }
                )
            )
        }
    }

    private fun emit(event: SocketEvent) {
        _events.tryEmit(event)
    }

    /** Parses `{"event":"<name>", ...}`; returns null on anything malformed. */
    private fun parseFrame(raw: String): SocketEvent? = runCatching {
        if (raw.isBlank()) return null
        val json = JSONObject(raw)
        val name = json.optString("event").ifBlank { json.optString("type") }
        if (name.isBlank()) {
            Timber.w(TAG, "Socket frame had no event name: ${raw.take(120)}")
            return null
        }
        SocketEvent(name, json)
    }.getOrNull()

    companion object {
        const val TAG = "SOCKET"
    }
}
