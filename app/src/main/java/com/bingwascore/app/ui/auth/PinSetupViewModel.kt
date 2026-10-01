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

    fun updatePhone(value: String) {
        _state.value = _state.value.copy(phone = value.filter { it.isDigit() }, errorMessage = null)
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
        if (current.phone.length < AuthConstants.MIN_PHONE_DIGITS) {
            _state.value = current.copy(errorMessage = "Enter a valid phone number")
            return
        }
        if (current.pin.length < AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(
                errorMessage = "Your PIN must be at least ${AuthConstants.MIN_PIN_LENGTH} digits"
            )
            return
        }
        if (current.pin != current.confirmPin) {
            _state.value = current.copy(errorMessage = "The two PINs don't match")
            return
        }

        _state.value = current.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            when (val result = authRepository.signUp(current.phone, current.pin)) {
                is RemoteResult.Success -> {
                    // The stub persists the phone; keep the local name too.
                    userPreferences.setLoggedIn(true)
                    _state.value = _state.value.copy(isLoading = false)
                    _completed.value = true
                }

                is RemoteResult.Offline -> {
                    userPreferences.setLoggedIn(true)
                    _state.value = _state.value.copy(isLoading = false)
                    _completed.value = true
                }

                is RemoteResult.Failure ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )
            }
        }
    }
}

/** UI state for [PinSetupScreen]. */
data class PinSetupState(
    val phone: String = "",
    val pin: String = "",
    val confirmPin: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    /** Both PINs are filled, long enough, and identical. */
    val isSubmittable: Boolean
        get() = phone.length >= AuthConstants.MIN_PHONE_DIGITS &&
            pin.length >= AuthConstants.MIN_PIN_LENGTH &&
            pin == confirmPin
}