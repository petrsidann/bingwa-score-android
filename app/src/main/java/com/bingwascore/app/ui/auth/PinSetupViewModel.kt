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
@HiltViewModel
class PinSetupViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(PinSetupState())
    val state: StateFlow<PinSetupState> = _state.asStateFlow()

    private val _completed = MutableStateFlow(false)
    val completed: StateFlow<Boolean> = _completed.asStateFlow()

    fun updateAccountType(value: String) {
        _state.value = _state.value.copy(accountType = value, errorMessage = null)
    }

    fun updateName(value: String) {
        _state.value = _state.value.copy(name = value, errorMessage = null)
    }

    fun updatePhone(value: String) {
        _state.value = _state.value.copy(phone = value, errorMessage = null)
    }

    fun updateEmail(value: String) {
        _state.value = _state.value.copy(email = value, errorMessage = null)
    }

    fun updatePin(value: String) {
        _state.value = _state.value.copy(pin = value.filter { it.isDigit() }, errorMessage = null)
    }

    fun updateConfirmPin(value: String) {
        _state.value = _state.value.copy(confirmPin = value.filter { it.isDigit() }, errorMessage = null)
    }

    /** Validates locally first, then asks the repository to create the account. */
    fun submit() {
        val current = _state.value
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(current.phone)

        if (current.name.isBlank()) {
            _state.value = current.copy(
                errorMessage = if (current.accountType == "Business") "Business name is required" else "Name is required"
            )
            return
        }

        if (!com.bingwascore.app.util.isTenDigitPhone(cleanPhone)) {
            _state.value = current.copy(errorMessage = "Enter a valid Kenyan phone number (e.g. 0712345678)")
            return
        }

        if (!current.email.contains("@") || !current.email.contains(".")) {
            _state.value = current.copy(errorMessage = "Enter a valid email address")
            return
        }

        if (current.pin.length < AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(
                errorMessage = "Your PIN must be at least ${AuthConstants.MIN_PIN_LENGTH} digits"
            )
            return
        }

        if (current.pin != current.confirmPin) {
            _state.value = current.copy(errorMessage = "That PIN doesn't match - try again")
            return
        }

        _state.value = current.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            when (val result = authRepository.signUp(
                accountType = current.accountType,
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
    val accountType: String = "Individual",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val pin: String = "",
    val confirmPin: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
) {
    val isSubmittable: Boolean
        get() = name.isNotBlank() &&
            phone.isNotBlank() &&
            email.isNotBlank() &&
            pin.length >= AuthConstants.MIN_PIN_LENGTH &&
            confirmPin.length >= AuthConstants.MIN_PIN_LENGTH
}
