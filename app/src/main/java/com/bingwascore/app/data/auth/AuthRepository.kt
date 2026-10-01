package com.bingwascore.app.data.auth

import com.bingwascore.app.data.remote.RemoteResult

/**
 * MEGA B — the auth contract the server will implement.
 *
 * Modelled on the server's shape (signIn / signUp / refresh) so the wire format
 * is pinned now. Every method returns a [RemoteResult] and never throws.
 */
interface AuthRepository {

    /** Phone + PIN sign-in — the flow that already works locally today. */
    suspend fun signIn(phone: String, pin: String): RemoteResult<AuthSession>

    /** Registers a new agent by phone + PIN. */
    suspend fun signUp(phone: String, pin: String): RemoteResult<AuthSession>

    /** Requests a one-time code for [email]; the UI starts a 120s timer. */
    suspend fun requestEmailOtp(email: String): RemoteResult<OtpChallenge>

    /** Verifies an emailed OTP and exchanges it for a session. */
    suspend fun verifyEmailOtp(challengeId: String, code: String): RemoteResult<AuthSession>

    /** Exchanges a refresh token for a fresh session. */
    suspend fun refresh(refreshToken: String): RemoteResult<AuthSession>
}

/** A signed-in agent's tokens and identity. */
data class AuthSession(
    val userId: String,
    val phone: String,
    val accessToken: String,
    val refreshToken: String,
    val expiresAt: Long
)

/** An in-flight OTP request. [expiresAt] drives the 120s countdown. */
data class OtpChallenge(
    val challengeId: String,
    val email: String,
    val expiresAt: Long
) {
    /**
     * Seconds still left before the code expires (never negative). An instance
     * method because the deadline lives on the instance, not the companion.
     */
    fun secondsRemaining(now: Long): Long =
        ((expiresAt - now).coerceAtLeast(0L)) / 1000L

    companion object {
        /** The OTP lifetime the UI counts down, in millis. */
        const val LIFETIME_MILLIS = 120_000L
    }
}

/** Shared constants for the auth surface. */
object AuthConstants {
    const val MIN_PHONE_DIGITS = 9
    const val MIN_PIN_LENGTH = 4
    const val OTP_LENGTH = 6

    /** How long a locally-minted session stays nominally valid. */
    const val LOCAL_SESSION_MILLIS = 24L * 60 * 60 * 1000

    const val PATH_SIGN_IN = "/api/auth/sign-in"
    const val PATH_SIGN_UP = "/api/auth/sign-up"
    const val PATH_EMAIL_OTP = "/api/auth/email-otp"
    const val PATH_VERIFY_OTP = "/api/auth/verify-otp"
    const val PATH_REFRESH = "/api/auth/refresh"
}