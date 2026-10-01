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
    val name: String = "",
    val phone: String = "",
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

    val phone: StateFlow<String> = userPreferences.phone
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val engineEnabled: StateFlow<Boolean> = userPreferences.engineEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

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
                name = userPreferences.userName.first(),
                phone = userPreferences.phone.first()
            )
        }
    }

    /** Abandons the edit and restores the card to its read-only form. */
    fun cancelEditing() {
        _editState.value = ProfileEditState()
    }

    /** Updates one field and clears any stale error so the agent can retry. */
    fun updateName(value: String) {
        _editState.value = _editState.value.copy(name = value, errorMessage = null)
    }

    fun updatePhone(value: String) {
        _editState.value = _editState.value.copy(phone = value, errorMessage = null)
    }

    /**
     * Validates and persists the profile.
     *
     * Rejects a blank name and a malformed phone BEFORE writing, so the stored
     * profile can never be left in a half-edited, unusable state.
     */
    fun saveProfile() {
        val current = _editState.value
        val name = current.name.trim()
        val phoneDigits = current.phone.filter { it.isDigit() }

        if (name.isEmpty()) {
            _editState.value = current.copy(errorMessage = "Name cannot be empty")
            return
        }
        if (phoneDigits.length !in 9..12) {
            _editState.value = current.copy(
                errorMessage = "Enter a valid phone number — 10 digits, e.g. 0712345678"
            )
            return
        }

        _editState.value = current.copy(isSaving = true, errorMessage = null)
        viewModelScope.launch {
            try {
                userPreferences.setUserName(name)
                userPreferences.setPhone(phoneDigits)
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
