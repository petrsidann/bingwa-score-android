package com.bingwascore.app.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface UpdateCheckState {
    data object Idle : UpdateCheckState
    data object Checking : UpdateCheckState
    data class Done(val upToDate: Boolean) : UpdateCheckState
}

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    val themeMode: StateFlow<ThemeMode> = userPreferences.themeMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ThemeMode.DARK)

    val processingMode: StateFlow<AppProcessingMode> = userPreferences.processingMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), AppProcessingMode.EXPRESS)

    val simSelection: StateFlow<String> = userPreferences.simSelection
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UserPreferences.SIM_1)

    private val _updateState = MutableStateFlow<UpdateCheckState>(UpdateCheckState.Idle)
    val updateState: StateFlow<UpdateCheckState> = _updateState.asStateFlow()

    val appVersion: String = BuildConfig.APP_VERSION

    fun setThemeMode(value: ThemeMode) {
        viewModelScope.launch { userPreferences.setThemeMode(value) }
    }

    fun setProcessingMode(value: AppProcessingMode) {
        viewModelScope.launch { userPreferences.setProcessingMode(value) }
    }

    fun setSimSelection(value: String) {
        viewModelScope.launch { userPreferences.setSimSelection(value) }
    }

    /** Placeholder release check — swap for a real endpoint later. */
    fun checkForUpdates() {
        if (_updateState.value is UpdateCheckState.Checking) return
        viewModelScope.launch {
            _updateState.value = UpdateCheckState.Checking
            delay(CHECK_DELAY_MS)
            _updateState.value = UpdateCheckState.Done(upToDate = true)
        }
    }

    private companion object {
        const val CHECK_DELAY_MS = 1_200L
    }
}
