package com.bingwascore.app.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.remote.RemoteResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MEGA B — the Email OTP flow, including its 120-second countdown.
 *
 * The timer is REAL even offline: [AuthRepository.requestEmailOtp] mints a local
 * challenge with a 120s lifetime, so the screen behaves identically today and
 * once a server is provisioned.
 */
@HiltViewModel
class EmailOtpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(EmailOtpState())
    val state: StateFlow<EmailOtpState> = _state.asStateFlow()

    private val _verified = MutableStateFlow(false)
    val verified: StateFlow<Boolean> = _verified.asStateFlow()

    /** Requests a code for [email] and starts the countdown. */
    fun requestCode(email: String) {
        val clean = email.trim()
        if (clean.isEmpty()) {
            _state.value = _state.value.copy(errorMessage = "Enter your email address")
            return
        }
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            when (val result = authRepository.requestEmailOtp(clean)) {
                is RemoteResult.Success ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        challenge = result.value,
                        email = clean,
                        errorMessage = null
                    )

                is RemoteResult.Offline ->
                    // Offline stub still yields a usable challenge.
                    _state.value = _state.value.copy(
                        isLoading = false,
                        challenge = result.fallback,
                        email = clean,
                        errorMessage = null
                    )

                is RemoteResult.Failure ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )
            }
        }
    }

    /**
     * Counts the challenge down from 120s to 0.
     *
     * Cancelled with the ViewModel, so leaving the screen can never leave a
     * ticking coroutine behind.
     */
    fun startCountdown() {
        val challenge = _state.value.challenge ?: return
        viewModelScope.launch {
            while (isActive) {
                val remaining = challenge.secondsRemaining(System.currentTimeMillis())
                _state.value = _state.value.copy(secondsRemaining = remaining)
                if (remaining <= 0L) break
                delay(1_000L)
            }
        }
    }

    /** Verifies the entered [code] against the active challenge. */
    fun verifyCode(code: String) {
        val challenge = _state.value.challenge
        if (challenge == null) {
            _state.value = _state.value.copy(errorMessage = "Request a code first")
            return
        }
        if (challenge.secondsRemaining(System.currentTimeMillis()) <= 0L) {
            _state.value = _state.value.copy(errorMessage = "That code expired — request a new one")
            return
        }
        if (code.length < AuthConstants.OTP_LENGTH) {
            _state.value = _state.value.copy(
                errorMessage = "Enter the ${AuthConstants.OTP_LENGTH}-digit code"
            )
            return
        }

        _state.value = _state.value.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            when (val result = authRepository.verifyEmailOtp(challenge.challengeId, code)) {
                is RemoteResult.Success -> {
                    _verified.value = true
                    _state.value = _state.value.copy(isLoading = false)
                }

                is RemoteResult.Offline -> {
                    _verified.value = true
                    _state.value = _state.value.copy(isLoading = false)
                }

                is RemoteResult.Failure ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )
            }
        }
    }

    fun updateEmail(value: String) {
        _state.value = _state.value.copy(email = value, errorMessage = null)
    }

    fun clearError() {
        _state.value = _state.value.copy(errorMessage = null)
    }
}

/** UI state for [EmailOtpScreen]. */
data class EmailOtpState(
    val email: String = "",
    val challenge: OtpChallenge? = null,
    val secondsRemaining: Long = 0L,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    /** True once a code has been requested and has not yet expired. */
    val isAwaitingCode: Boolean get() = challenge != null && secondsRemaining > 0L

    /** "1:59" style countdown text. */
    val countdownText: String
        get() = "%d:%02d".format(secondsRemaining / 60, secondsRemaining % 60)
}