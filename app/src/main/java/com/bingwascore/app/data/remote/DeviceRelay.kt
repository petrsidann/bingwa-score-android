package com.bingwascore.app.data.remote

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the state a relay device may command this device into.
 *
 * These mirror the server's app-state vocabulary so the wire contract does not
 * change when a relay is provisioned.
 */
enum class RelayAppState(val value: String) {
    IDLE("IDLE"),
    PROCESSING("PROCESSING"),
    PAUSED("PAUSED"),
    STOPPED("STOPPED");

    companion object {
        fun fromValue(value: String?): RelayAppState =
            entries.firstOrNull { it.value.equals(value, ignoreCase = true) } ?: IDLE
    }
}

/** One inbound relay command, already parsed and validated. */
data class RelayCommand(
    val serverId: String,
    val message: String,
    val state: RelayAppState,
    val receivedAt: Long = System.currentTimeMillis()
)

/**
 * MEGA B — the relay contract.
 *
 * The interface exists now and has one real local implementation, so the engine
 * can depend on relay behaviour today and simply never receive a command until a
 * relay server is provisioned.
 */
interface DeviceRelay {

    /**
     * Handles an inbound app-state command addressed to a relay server.
     *
     * Returns the command that was applied, or null when it was rejected as
     * malformed (blank server id). Implementations MUST NOT throw.
     */
    suspend fun handleAppStateSet(serverId: String, message: String, state: String): RelayCommand?

    /** Commands this device has applied, newest last — surfaced in diagnostics. */
    val commands: SharedFlow<RelayCommand>

    /** True when a relay has actually driven this device at least once. */
    val isRelayed: Boolean
}

/**
 * MEGA B — the default relay: local-only until a relay server exists.
 *
 * It validates and records commands so the flow is testable end-to-end today,
 * but nothing upstream produces them while [RemoteConfig.relaySocketEnabled] is
 * off — which is the shipped default.
 */
@Singleton
class LocalDeviceRelay @Inject constructor(
    private val remoteConfig: RemoteConfig
) : DeviceRelay {

    private val _commands = MutableSharedFlow<RelayCommand>(extraBufferCapacity = 16)

    override val commands: SharedFlow<RelayCommand> = _commands.asSharedFlow()

    @Volatile
    override var isRelayed: Boolean = false
        private set

    override suspend fun handleAppStateSet(
        serverId: String,
        message: String,
        state: String
    ): RelayCommand? {
        return try {
            if (serverId.isBlank()) {
                Timber.w(TAG, "Rejected relay command with blank server id")
                return null
            }
            // Commands are only honoured when relay routing is actually enabled.
            if (!remoteConfig.isActive(remoteConfig.relayDialEnabled)) {
                Timber.i(TAG, "Relay command ignored (relayDialEnabled=%s)", remoteConfig.relayDialEnabled)
                return null
            }
            val command = RelayCommand(
                serverId = serverId,
                message = message,
                state = RelayAppState.fromValue(state)
            )
            isRelayed = true
            _commands.tryEmit(command)
            Timber.i(TAG, "Applied relay state=%s from %s", command.state.value, serverId)
            command
        } catch (t: Throwable) {
            Timber.e(t, "handleAppStateSet failed — ignoring")
            null
        }
    }

    companion object {
        const val TAG = "RELAY"
    }
}
