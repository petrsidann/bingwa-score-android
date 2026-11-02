package com.bingwascore.app.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MEGA B — creating and confirming a PIN for a new agent account.
 *
 * Like the offer-settings and profile forms, the PIN is validated BEFORE any
 * write so a mismatched or too-short PIN never reaches storage.
 */
/** STAGE 44 — phone cap, same law as login. */
private const val MAX_SIGNUP_PHONE_LENGTH = 10

@HiltViewModel
class PinSetupViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(PinSetupState())
    val state: StateFlow<PinSetupState> = _state.asStateFlow()

    private val _completed = MutableStateFlow(false)
    val completed: StateFlow<Boolean> = _completed.asStateFlow()

    fun updateName(value: String) {
        _state.value = _state.value.copy(name = value, errorMessage = null)
    }

    fun updatePhone(value: String) {
        val digits = value.filter { it.isDigit() }
        if (digits.length > MAX_SIGNUP_PHONE_LENGTH) {
            // STAGE 44 — INPUT TRUTH: cap 10 with an inline reason, no append.
            _state.value = _state.value.copy(
                phone = digits.take(MAX_SIGNUP_PHONE_LENGTH),
                phoneError = "Phone number is 10 digits",
                errorMessage = null
            )
        } else {
            _state.value = _state.value.copy(phone = digits, phoneError = null, errorMessage = null)
        }
    }

    fun updateEmail(value: String) {
        // STAGE 44 — inline email validation with the reason under the field.
        val trimmed = value.trim()
        val error = when {
            trimmed.isEmpty() -> null
            !trimmed.contains("@") -> "Email needs an @ (e.g. agent@example.com)"
            !trimmed.substringAfter('@').contains(".") -> "Email needs a domain (e.g. agent@example.com)"
            else -> null
        }
        _state.value = _state.value.copy(email = value, emailError = error, errorMessage = null)
    }

    // ── STAGE 44 — keypad-only PIN entry ────────────────────────────────────
    // The PIN and Confirm PIN fields are driven by the SAME custom 4-dot keypad
    // as login; the system keyboard never appears for them. Cap 4 each: a 5th
    // press is an inline error, never an append.

    fun appendPinDigit(digit: Char) {
        val current = _state.value
        if (current.isLoading || current.isSuccess) return
        if (current.pin.length < AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(pin = current.pin + digit, pinError = null, errorMessage = null)
        } else {
            _state.value = current.copy(pinError = "PIN is 4 digits")
        }
    }

    fun backspacePin() {
        val current = _state.value
        if (current.isLoading || current.isSuccess) return
        if (current.pin.isNotEmpty()) {
            _state.value = current.copy(pin = current.pin.dropLast(1), pinError = null, errorMessage = null)
        }
    }

    fun appendConfirmPinDigit(digit: Char) {
        val current = _state.value
        if (current.isLoading || current.isSuccess) return
        if (current.confirmPin.length < AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(confirmPin = current.confirmPin + digit, confirmPinError = null, errorMessage = null)
        } else {
            _state.value = current.copy(confirmPinError = "PIN is 4 digits")
        }
    }

    fun backspaceConfirmPin() {
        val current = _state.value
        if (current.isLoading || current.isSuccess) return
        if (current.confirmPin.isNotEmpty()) {
            _state.value = current.copy(confirmPin = current.confirmPin.dropLast(1), confirmPinError = null, errorMessage = null)
        }
    }

    /** Validates locally first, then asks the repository to create the account. */
    fun submit() {
        val current = _state.value
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(current.phone)

        if (current.name.isBlank()) {
            _state.value = current.copy(errorMessage = "Name is required")
            return
        }

        if (!com.bingwascore.app.util.isTenDigitPhone(cleanPhone)) {
            _state.value = current.copy(errorMessage = "Enter a valid Kenyan phone number (e.g. 0712345678)")
            return
        }

        if (!current.isEmailValid) {
            _state.value = current.copy(errorMessage = "Enter a valid email address")
            return
        }

        if (current.pin.length != AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(
                errorMessage = "Your PIN must be exactly ${AuthConstants.MIN_PIN_LENGTH} digits"
            )
            return
        }

        if (current.confirmPin.length != AuthConstants.MIN_PIN_LENGTH || current.pin != current.confirmPin) {
            _state.value = current.copy(errorMessage = "That PIN doesn't match - try again")
            return
        }

        _state.value = current.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            when (val result = authRepository.signUp(
                // STAGE 44 — ONE account type: the payload always sends AGENT.
                accountType = AuthConstants.ACCOUNT_TYPE_AGENT,
                name = current.name,
                phone = cleanPhone,
                email = current.email,
                pin = current.pin
            )) {
                is RemoteResult.Success, is RemoteResult.Offline -> {
                    _state.value = _state.value.copy(isLoading = false, isSuccess = true)
                    kotlinx.coroutines.delay(800)
                    _completed.value = true
                }
                is RemoteResult.Failure -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
            }
        }
    }
}

/** UI state for [PinSetupScreen]. */
data class PinSetupState(
    /** STAGE 44 — ONE account type, always [AuthConstants.ACCOUNT_TYPE_AGENT]. */
    val accountType: String = AuthConstants.ACCOUNT_TYPE_AGENT,
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val pin: String = "",
    val confirmPin: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null,
    val phoneError: String? = null,
    val emailError: String? = null,
    val pinError: String? = null,
    val confirmPinError: String? = null
) {
    val isEmailValid: Boolean
        get() {
            val trimmed = email.trim()
            return trimmed.contains("@") && trimmed.substringAfter('@').contains(".")
        }

    /** Inline mismatch: both PINs full and unequal. */
    val pinsMismatch: Boolean
        get() = pin.length == AuthConstants.MIN_PIN_LENGTH &&
            confirmPin.length == AuthConstants.MIN_PIN_LENGTH &&
            pin != confirmPin

    val isSubmittable: Boolean
        get() = name.isNotBlank() &&
            com.bingwascore.app.util.isTenDigitPhone(com.bingwascore.app.util.formatPhoneToTenDigits(phone)) &&
            isEmailValid &&
            pin.length == AuthConstants.MIN_PIN_LENGTH && pin.all { it.isDigit() } &&
            confirmPin.length == AuthConstants.MIN_PIN_LENGTH && confirmPin.all { it.isDigit() } &&
            pin == confirmPin

    /** STAGE 44 — the visible reason "Create Account" stays disabled. */
    val submitDisabledReason: String?
        get() = when {
            name.isBlank() -> "Enter your name or business name"
            !com.bingwascore.app.util.isTenDigitPhone(com.bingwascore.app.util.formatPhoneToTenDigits(phone)) ->
                "Enter a valid 10-digit phone number"
            !isEmailValid -> "Enter a valid email address"
            pin.length != AuthConstants.MIN_PIN_LENGTH -> "Enter your 4-digit PIN"
            confirmPin.length != AuthConstants.MIN_PIN_LENGTH -> "Confirm your 4-digit PIN"
            pin != confirmPin -> "PINs don't match"
            else -> null
        }
}
