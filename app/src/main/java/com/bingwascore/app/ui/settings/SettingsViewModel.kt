package com.bingwascore.app.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VersionInfo(
    val currentVersion: String = "",
    val latestVersion: String = "",
    val isOutdated: Boolean = false,
    val isUnsupported: Boolean = false,
    val title: String = "",
    val summary: String = "",
    val changelog: List<ChangelogEntry> = emptyList(),
    val updateKeyValid: Boolean = false
)

data class ChangelogEntry(val type: String, val text: String)

data class SettingsState(
    val themeMode: Int = 0,
    val currentVersion: String = BuildConfig.APP_VERSION,
    val updateKey: String = "",
    val isChecking: Boolean = false,
    val isInstalling: Boolean = false,
    val installProgress: Int = 0,
    val versionInfo: VersionInfo? = null,
    val error: String? = null
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val mode = preferences.themeMode.first()
            val key = loadKey()
            _state.value = _state.value.copy(themeMode = mode, updateKey = key)
        }
    }

    fun setTheme(mode: Int) {
        viewModelScope.launch {
            preferences.setThemeMode(mode)
            _state.value = _state.value.copy(themeMode = mode)
        }
    }

    fun generateKey() {
        val chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
        val key = buildString {
            append("BINGWA-")
            repeat(8) { append(chars.random()) }
        }
        viewModelScope.launch {
            saveKey(key)
            _state.value = _state.value.copy(updateKey = key)
        }
    }

    fun setKey(key: String) {
        _state.value = _state.value.copy(updateKey = key.uppercase())
    }

    fun checkForUpdates() {
        val key = _state.value.updateKey
        if (key.isBlank() || !key.matches(Regex("^BINGWA-[A-Z0-9]{8}$"))) {
            _state.value = _state.value.copy(error = "Invalid update key")
            return
        }

        viewModelScope.launch {
            _state.value = _state.value.copy(isChecking = true, error = null)
            // Simulate network call
            kotlinx.coroutines.delay(1200)

            // For now, we're always up to date (real check will hit backend)
            _state.value = _state.value.copy(
                isChecking = false,
                versionInfo = VersionInfo(
                    currentVersion = _state.value.currentVersion,
                    latestVersion = _state.value.currentVersion,
                    isOutdated = false,
                    updateKeyValid = true,
                    title = "You're up to date",
                    summary = "Running the latest stable release"
                )
            )
        }
    }

    fun installUpdate() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isInstalling = true, installProgress = 0)
            for (i in 0..100 step 5) {
                kotlinx.coroutines.delay(60)
                _state.value = _state.value.copy(installProgress = i)
            }
            _state.value = _state.value.copy(isInstalling = false)
            // In production: clear caches, reload
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(error = null)
    }

    private suspend fun saveKey(key: String) {
        // Persist in DataStore — extend UserPreferences if needed
    }

    private suspend fun loadKey(): String = ""
}
