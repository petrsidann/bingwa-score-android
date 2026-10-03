package com.bingwascore.app.services

import android.content.Context
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.data.remote.FcmMessageRequest
import com.bingwascore.app.data.remote.RemoteConfig
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.util.DeviceIdProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — push registration.
 *
 * With no backend configured this class still works: it stores the token locally
 * and reports `registeredLocallyOnly = true`, so the flow is testable today and
 * starts syncing the moment a server exists.
 *
 * The registration itself is time-boxed and guarded, so it can never hang the
 * caller or crash the app.
 */
@Singleton
class FcmService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences,
    private val remoteConfig: RemoteConfig,
    private val apiService: ApiService,
    private val deviceIdProvider: DeviceIdProvider
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val _token = MutableStateFlow("")
    val token: StateFlow<String> = _token.asStateFlow()

    /** True when the token exists locally but was NOT uploaded to a server. */
    private val _registeredLocallyOnly = MutableStateFlow(false)
    val registeredLocallyOnly: StateFlow<Boolean> = _registeredLocallyOnly.asStateFlow()

    /**
     * Registers [token] for this device.
     *
     * Always succeeds locally: the token is persisted first, then an upload is
     * ATTEMPTED only when push is configured and enabled. Returns true whenever
     * the token is stored, regardless of whether the server took it.
     */
    suspend fun registerToken(token: String): Boolean {
        val trimmed = token.trim()
        if (trimmed.isEmpty()) {
            Timber.w(TAG, "Refusing to register an empty FCM token")
            return false
        }
        return try {
            _token.value = trimmed
            userPreferences.setFcmToken(trimmed)
            _registeredLocallyOnly.value = true

            // Only reach for the network when push is actually switched on.
            if (!remoteConfig.isActive(remoteConfig.pushEnabled)) {
                Timber.i(TAG, "FCM token stored locally (push not enabled)")
                return true
            }

            val deviceId = runCatching { deviceIdProvider.deviceId() }.getOrDefault("")
            val result = withTimeoutOrNull(REGISTRATION_TIMEOUT_MILLIS) {
                apiService.sendMessageToDevice(
                    request = FcmMessageRequest(
                        deviceId = deviceId,
                        title = "Bingwa Score",
                        body = "Device registered",
                        data = mapOf("kind" to "device_registration", "token" to trimmed)
                    )
                )
            }
            _registeredLocallyOnly.value = result !is RemoteResult.Success
            Timber.i(TAG, "FCM token upload: $result")
            true
        } catch (t: Throwable) {
            Timber.e(t, "FCM registration failed — token kept locally")
            _registeredLocallyOnly.value = true
            false
        }
    }

    /**
     * Handles an inbound push payload. Safe to call with anything at all — a
     * malformed payload is logged and dropped, never thrown.
     */
    fun onMessageReceived(remoteMessage: Map<String, String>) {
        try {
            val kind = remoteMessage["kind"].orEmpty()
            Timber.i(TAG, "FCM message received (kind=$kind)")
            // Task-specific handling lands here once the backend is live.
        } catch (t: Throwable) {
            Timber.e(t, "Failed handling FCM message")
        }
    }

    /** Fire-and-forget registration for a token delivered outside a coroutine. */
    fun registerTokenAsync(token: String) {
        scope.launch { registerToken(token) }
    }

    companion object {
        const val TAG = "PUSH"

        /** Upper bound on the server upload; never blocks the caller. */
        const val REGISTRATION_TIMEOUT_MILLIS = 10_000L
    }
}
