package com.bingwascore.app.data.remote

import kotlinx.coroutines.withTimeoutOrNull
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The outcome of any remote call. Sealed so a caller physically cannot forget to
 * handle the offline branch — the compiler enforces it.
 */
sealed interface RemoteResult<out T> {

    /** The server answered. */
    data class Success<T>(val value: T) : RemoteResult<T>

    /** The server answered, but with an error status. */
    data class Failure(val code: Int, val message: String) : RemoteResult<Nothing>

    /**
     * No usable backend, or the network refused. [fallback] carries the local
     * answer so the caller still returns real data instead of an error.
     */
    data class Offline<T>(val reason: String, val fallback: T) : RemoteResult<T>

    /** True only when we genuinely reached the server and it said OK. */
    val isRemote: Boolean get() = this is Success
}

/**
 * The value whether we went remote or fell back.
 *
 * Deliberately an EXTENSION rather than an interface member: `Failure` is a
 * `RemoteResult<Nothing>` subtype, and an inherited generic member would make
 * the compiler emit a `valueOr(Object): Void` bridge on `Failure` that throws
 * ClassCastException the moment an `Int` is passed. A static extension has no
 * such bridge, so every variant behaves identically.
 */
fun <T> RemoteResult<T>.valueOr(fallback: T): T = when (this) {
    is RemoteResult.Success -> value
    is RemoteResult.Offline -> this.fallback
    else -> fallback
}

/**
 * MEGA B — the offline guarantee, in one place.
 *
 * Every network call in PART B goes through [guard], which guarantees three
 * things the task demands, no matter what the network does:
 *
 * 1. **Never suspends forever.** The call is wrapped in [TIMEOUT_MILLIS]; a
 *    hung socket resolves to an [RemoteResult.Offline], not a stuck coroutine.
 * 2. **Never crashes.** Every throw is caught, logged under [TAG], and turned
 *    into [RemoteResult.Offline] carrying the caller's local fallback.
 * 3. **Never phones home when unconfigured.** If [RemoteConfig.isRemoteConfigured]
 *    is false (or the flag is off) the remote block is not even invoked, so a
 *    default build makes zero network calls.
 */
@Singleton
class OfflineFallback @Inject constructor(
    private val remoteConfig: RemoteConfig
) {

    /**
     * Runs [remote] only when the backend is configured AND [flag] is enabled;
     * otherwise returns [RemoteResult.Offline] with [fallback] immediately.
     *
     * A remote call that succeeds returns [RemoteResult.Success]; one that
     * throws, times out, or returns a non-2xx status degrades to
     * [RemoteResult.Offline] carrying [fallback]. The app therefore behaves
     * identically online and offline from the caller's point of view.
     */
    suspend fun <T> guard(
        flag: Boolean,
        operation: String,
        fallback: T,
        remote: suspend () -> T
    ): RemoteResult<T> {
        if (!remoteConfig.isActive(flag)) {
            return RemoteResult.Offline(
                reason = OFFLINE_NO_BACKEND,
                fallback = fallback
            )
        }

        return try {
            val value = withTimeoutOrNull(TIMEOUT_MILLIS) { remote() }
            if (value == null) {
                Timber.w(TAG, "%s timed out after %dms — using local data", operation, TIMEOUT_MILLIS)
                RemoteResult.Offline(reason = OFFLINE_TIMEOUT, fallback = fallback)
            } else {
                RemoteResult.Success(value)
            }
        } catch (t: Throwable) {
            // Includes CancellationException-free failures: a socket error, a
            // JSON mismatch, a missing server. Never propagated to the caller.
            Timber.w(t, "%s failed (%s) — using local data", operation, t.message)
            RemoteResult.Offline(reason = OFFLINE_ERROR, fallback = fallback)
        }
    }

    /** True when a real backend exists — i.e. remote calls are even possible. */
    val isOnlineCapable: Boolean get() = remoteConfig.isRemoteConfigured

    companion object {
        const val TAG = "NETWORK"

        /** Hard ceiling on any single remote call. */
        const val TIMEOUT_MILLIS = 12_000L

        const val OFFLINE_NO_BACKEND = "no backend configured"
        const val OFFLINE_TIMEOUT = "request timed out"
        const val OFFLINE_ERROR = "request failed"
    }
}