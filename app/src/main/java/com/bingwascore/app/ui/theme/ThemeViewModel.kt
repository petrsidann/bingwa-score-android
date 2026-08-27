package com.bingwascore.app.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    // 0 = Light, 1 = Dark
    val themeMode: StateFlow<Int> = userPreferences.themeMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1)

    val isDark: StateFlow<Boolean> = userPreferences.themeMode
        .map { it == 1 }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    fun setTheme(mode: Int) {
        viewModelScope.launch {
            userPreferences.setThemeMode(mode)
        }
    }

    fun toggle() {
        viewModelScope.launch {
            val current = themeMode.value
            userPreferences.setThemeMode(if (current == 1) 0 else 1)
        }
    }
}
