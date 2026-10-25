package com.bingwascore.app.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.domain.score.ScoreEngine
import com.bingwascore.app.services.EngineService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import android.content.Context
import javax.inject.Inject

/**
 * MEGA A — the profile edit form's state.
 *
 * Mirrors the OfferSettings contract: a flag for "the form is open", a flag for
 * "the write is in flight", and an inline [errorMessage] so a rejected save is
 * always explained instead of silently ignored.
 */
data class ProfileEditState(
    val isEditing: Boolean = false,
    val isSaving: Boolean = false,
    val isReauthenticating: Boolean = false,
    val accountType: String = "Individual",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val pinToConfirm: String = "",
    val errorMessage: String? = null,
    val savedMessage: String? = null
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences,
    transactionRepository: TransactionRepository,
    customerRepository: CustomerRepository,
    private val scoreEngine: ScoreEngine
) : ViewModel() {

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    val accountType: StateFlow<String> = userPreferences.accountType
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Individual")

    val phone: StateFlow<String> = userPreferences.phone
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val email: StateFlow<String> = userPreferences.email
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val engineEnabled: StateFlow<Boolean> = userPreferences.engineEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    val engineState: StateFlow<com.bingwascore.app.domain.EngineState> = userPreferences.engineState
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), com.bingwascore.app.domain.EngineState.RUNNING)

    private val scoreState = combine(transactionRepository.allTransactions, customerRepository.allCustomers) { txns, customers ->
        scoreEngine.compute(txns, customers)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000),
        com.bingwascore.app.domain.score.ScoreState(0, "Bronze", 500, 0f, 0, 0f, 0.0, 0))

    val levelName: StateFlow<String> = scoreState
        .map { it.levelName }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bronze")

    val score: StateFlow<Int> = scoreState
        .map { it.score }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    /**
     * MEGA A — the editable-profile form state.
     *
     * [isEditing] gates the inputs, [errorMessage] explains a rejected save, and
     * [isSaving] disables Save until the write lands. Level and score stay
     * READ-ONLY: they are earned from real transactions, never typed in.
     */
    private val _editState = MutableStateFlow(ProfileEditState())
    val editState: StateFlow<ProfileEditState> = _editState.asStateFlow()

    /** Opens the editor, seeding the fields with the current persisted values. */
    fun startEditing() {
        viewModelScope.launch {
            _editState.value = ProfileEditState(
                isEditing = true,
                accountType = userPreferences.accountType.first(),
                name = userPreferences.userName.first(),
                phone = userPreferences.phone.first(),
                email = userPreferences.email.first()
            )
        }
    }

    /** Abandons the edit and restores the card to its read-only form. */
    fun cancelEditing() {
        _editState.value = ProfileEditState()
    }

    /** Updates one field and clears any stale error so the agent can retry. */
    fun updateAccountType(value: String) {
        _editState.value = _editState.value.copy(accountType = value, errorMessage = null)
    }

    fun updateName(value: String) {
        _editState.value = _editState.value.copy(name = value, errorMessage = null)
    }

    fun updatePhone(value: String) {
        _editState.value = _editState.value.copy(phone = value, errorMessage = null)
    }

    fun updateEmail(value: String) {
        _editState.value = _editState.value.copy(email = value, errorMessage = null)
    }

    fun updatePinToConfirm(value: String) {
        _editState.value = _editState.value.copy(pinToConfirm = value.filter { it.isDigit() }, errorMessage = null)
    }

    fun promptReauth() {
        val current = _editState.value
        val name = current.name.trim()
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(current.phone)

        if (name.isEmpty()) {
            _editState.value = current.copy(errorMessage = "Name cannot be empty")
            return
        }
        if (!com.bingwascore.app.util.isTenDigitPhone(cleanPhone)) {
            _editState.value = current.copy(
                errorMessage = "Enter a valid Kenyan phone number (e.g. 0712345678)"
            )
            return
        }
        if (!current.email.contains("@") || !current.email.contains(".")) {
            _editState.value = current.copy(errorMessage = "Enter a valid email address")
            return
        }

        _editState.value = current.copy(isReauthenticating = true, errorMessage = null)
    }

    fun cancelReauth() {
        _editState.value = _editState.value.copy(isReauthenticating = false, pinToConfirm = "", errorMessage = null)
    }

    fun saveProfile() {
        val current = _editState.value
        val name = current.name.trim()
        val cleanPhone = com.bingwascore.app.util.formatPhoneToTenDigits(current.phone)

        viewModelScope.launch {
            val storedPin = userPreferences.pin.first()
            if (storedPin.isNotEmpty() && current.pinToConfirm != storedPin) {
                _editState.value = current.copy(
                    isSaving = false,
                    errorMessage = "That PIN doesn't match - try again"
                )
                return@launch
            }

            _editState.value = current.copy(isSaving = true, errorMessage = null)
            try {
                userPreferences.setAccountType(current.accountType)
                userPreferences.setUserName(name)
                userPreferences.setPhone(cleanPhone)
                userPreferences.setEmail(current.email.trim())
                _editState.value = ProfileEditState(savedMessage = "Profile updated")
            } catch (t: Throwable) {
                _editState.value = current.copy(
                    isSaving = false,
                    errorMessage = "Could not save your profile — try again"
                )
            }
        }
    }

    fun toggleEngine() {
        viewModelScope.launch {
            val current = userPreferences.engineEnabled.first()
            userPreferences.setEngineEnabled(!current)
            if (!current) EngineService.start(context.applicationContext)
            else EngineService.stop(context.applicationContext)
        }
    }
}
