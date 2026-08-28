package com.bingwascore.app.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _isDark = MutableStateFlow(true)
    val isDark: StateFlow<Boolean> = _isDark.asStateFlow()

    init {
        viewModelScope.launch {
            userPreferences.themeMode.collect { mode -> _isDark.value = mode == 1 }
        }
    }

    fun setTheme(mode: Int) {
        _isDark.value = mode == 1
        viewModelScope.launch { userPreferences.setThemeMode(mode) }
    }

    fun toggle() {
        setTheme(if (_isDark.value) 0 else 1)
    }
}
