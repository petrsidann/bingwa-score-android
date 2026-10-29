package com.bingwascore.app.data.auth

import com.bingwascore.app.data.auth.AuthConstants.LOCAL_SESSION_MILLIS
import com.bingwascore.app.data.auth.AuthConstants.MIN_PHONE_DIGITS
import com.bingwascore.app.data.auth.AuthConstants.MIN_PIN_LENGTH
import com.bingwascore.app.data.auth.AuthConstants.OTP_LENGTH
import com.bingwascore.app.data.auth.AuthConstants.PATH_EMAIL_OTP
import com.bingwascore.app.data.auth.AuthConstants.PATH_REFRESH
import com.bingwascore.app.data.auth.AuthConstants.PATH_SIGN_IN
import com.bingwascore.app.data.auth.AuthConstants.PATH_SIGN_UP
import com.bingwascore.app.data.auth.AuthConstants.PATH_VERIFY_OTP
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.OfflineFallback
import com.bingwascore.app.data.remote.RemoteConfig
import com.bingwascore.app.data.remote.RemoteHttpClient
import com.bingwascore.app.data.remote.RemoteResult
import kotlinx.coroutines.flow.first
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the offline stub.
 *
 * Local phone+PIN keeps working EXACTLY as PART A shipped it — that path never
 * touches the network. The server-backed paths (OTP, refresh) answer
 * [RemoteResult.Offline] until a backend is provisioned, so the EmailOtp and
 * PinSetup screens are fully navigable and testable today and flip to real the
 * moment keys land.
 */
@Singleton
class OfflineAuthRepository @Inject constructor(
    private val userPreferences: UserPreferences,
    private val remoteConfig: RemoteConfig,
    private val offlineFallback: OfflineFallback,
    private val remoteHttp: RemoteHttpClient
) : AuthRepository {

    override suspend fun signIn(phone: String, pin: String): RemoteResult<AuthSession> {
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(phone)
        if (!com.bingwascore.app.util.isTenDigitPhone(cleanPhone)) {
            return RemoteResult.Failure(400, "Enter a valid Kenyan phone number (e.g. 0712345678)")
        }
        if (pin.length != MIN_PIN_LENGTH) {
            return RemoteResult.Failure(400, "Your PIN must be exactly $MIN_PIN_LENGTH digits")
        }

        val storedPin = userPreferences.pin.first()
        val storedPhone = userPreferences.phone.first()
        if (storedPin.isNotEmpty() && pin != storedPin) {
            return RemoteResult.Failure(401, "That PIN doesn't match - try again")
        }
        if (storedPhone.isNotEmpty() && cleanPhone != storedPhone && storedPin.isNotEmpty()) {
            return RemoteResult.Failure(401, "Phone number or PIN is incorrect")
        }

        // Local sign-in
        userPreferences.setPhone(cleanPhone)
        userPreferences.setLoggedIn(true)
        val session = localSession(cleanPhone)

        // Only a configured backend would try to validate remotely.
        if (!remoteConfig.isActive(remoteConfig.serverAuthEnabled)) {
            return RemoteResult.Offline(OfflineFallback.OFFLINE_NO_BACKEND, session)
        }
        return offlineFallback.guard(
            flag = remoteConfig.serverAuthEnabled,
            operation = "signIn",
            fallback = session
        ) {
            parseSession(
                remoteHttp.postRaw(
                    path = PATH_SIGN_IN,
                    body = JSONObject().apply {
                        put("phone", cleanPhone)
                        put("pin", pin)
                    }.toString()
                ),
                cleanPhone
            )
        }
    }

    override suspend fun signUp(
        accountType: String,
        name: String,
        phone: String,
        email: String,
        pin: String
    ): RemoteResult<AuthSession> {
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(phone)
        if (!com.bingwascore.app.util.isTenDigitPhone(cleanPhone)) {
            return RemoteResult.Failure(400, "Enter a valid Kenyan phone number (e.g. 0712345678)")
        }
        if (name.isBlank()) {
            return RemoteResult.Failure(400, if (accountType.equals("Business", ignoreCase = true)) "Business name is required" else "Name is required")
        }
        if (!email.contains("@") || !email.contains(".")) {
            return RemoteResult.Failure(400, "Enter a valid email address")
        }
        if (pin.length != MIN_PIN_LENGTH) {
            return RemoteResult.Failure(400, "Your PIN must be exactly $MIN_PIN_LENGTH digits")
        }

        userPreferences.setAccountType(accountType)
        userPreferences.setUserName(name.trim())
        userPreferences.setPhone(cleanPhone)
        userPreferences.setEmail(email.trim())
        userPreferences.setPin(pin)
        userPreferences.setLoggedIn(true)

        val session = localSession(cleanPhone)
        return offlineFallback.guard(
            flag = remoteConfig.serverAuthEnabled,
            operation = "signUp",
            fallback = session
        ) {
            parseSession(
                remoteHttp.postRaw(
                    path = PATH_SIGN_UP,
                    body = JSONObject().apply {
                        put("accountType", accountType)
                        put("name", name.trim())
                        put("phone", cleanPhone)
                        put("email", email.trim())
                        put("pin", pin)
                    }.toString()
                ),
                cleanPhone
            )
        }
    }

    override suspend fun requestEmailOtp(email: String): RemoteResult<OtpChallenge> {
        if (!email.contains("@") || !email.contains(".")) {
            return RemoteResult.Failure(400, "Enter a valid email address")
        }
        // Offline: mint a local challenge so the 120s countdown is real and the
        // screen is usable today.
        val challenge = OtpChallenge(
            challengeId = "local_${System.currentTimeMillis()}",
            email = email,
            expiresAt = System.currentTimeMillis() + OtpChallenge.LIFETIME_MILLIS
        )
        return offlineFallback.guard(
            flag = remoteConfig.serverAuthEnabled,
            operation = "requestEmailOtp",
            fallback = challenge
        ) {
            val body = remoteHttp.postRaw(
                path = PATH_EMAIL_OTP,
                body = JSONObject().put("email", email).toString()
            )
            challenge.copy(challengeId = parseChallengeId(body) ?: challenge.challengeId)
        }
    }

    override suspend fun verifyEmailOtp(
        challengeId: String,
        code: String
    ): RemoteResult<AuthSession> {
        if (code.length < OTP_LENGTH) {
            return RemoteResult.Failure(400, "Enter the $OTP_LENGTH-digit code from your email")
        }
        val session = localSession(currentPhone())
        return offlineFallback.guard(
            flag = remoteConfig.serverAuthEnabled,
            operation = "verifyEmailOtp",
            fallback = session
        ) {
            parseSession(
                remoteHttp.postRaw(
                    path = PATH_VERIFY_OTP,
                    body = JSONObject().apply {
                        put("challengeId", challengeId)
                        put("code", code)
                    }.toString()
                ),
                session.phone
            )
        }
    }

    override suspend fun refresh(refreshToken: String): RemoteResult<AuthSession> {
        val session = localSession(currentPhone())
        return offlineFallback.guard(
            flag = remoteConfig.serverAuthEnabled,
            operation = "refresh",
            fallback = session
        ) {
            parseSession(
                remoteHttp.postRaw(
                    path = PATH_REFRESH,
                    body = JSONObject().put("refreshToken", refreshToken).toString()
                ),
                session.phone
            )
        }
    }

    // ---- Helpers ----------------------------------------------------------

    /**
     * The local session. Offline tokens are intentionally empty placeholders —
     * they are never sent anywhere, they just keep the shape honest.
     */
    private suspend fun localSession(phone: String): AuthSession {
        Timber.d("Local session for %s (offline stub)", phone)
        return AuthSession(
            userId = "local_$phone",
            phone = phone,
            accessToken = "",
            refreshToken = "",
            expiresAt = System.currentTimeMillis() + LOCAL_SESSION_MILLIS
        )
    }

    private suspend fun currentPhone(): String =
        runCatching { userPreferences.phone.first() }.getOrDefault("")

    private fun parseSession(body: String?, phone: String): AuthSession = runCatching {
        if (body.isNullOrBlank()) return localSync(phone)
        val json = JSONObject(body)
        AuthSession(
            userId = json.optString("userId", "local_$phone"),
            phone = json.optString("phone", phone),
            accessToken = json.optString("accessToken"),
            refreshToken = json.optString("refreshToken"),
            expiresAt = json.optLong("expiresAt", System.currentTimeMillis() + LOCAL_SESSION_MILLIS)
        )
    }.getOrElse { localSync(phone) }

    private fun parseChallengeId(body: String?): String? = runCatching {
        if (body.isNullOrBlank()) return null
        JSONObject(body).optString("challengeId").ifBlank { null }
    }.getOrNull()

    /** Non-suspend sibling of [localSession] for the parsing helpers. */
    private fun localSync(phone: String) = AuthSession(
        userId = "local_$phone",
        phone = phone,
        accessToken = "",
        refreshToken = "",
        expiresAt = System.currentTimeMillis() + LOCAL_SESSION_MILLIS
    )
}
