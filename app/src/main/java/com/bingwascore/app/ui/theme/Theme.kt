package com.bingwascore.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.bingwascore.app.domain.ThemeMode

private val DarkColors = darkColorScheme(
    primary = EmeraldGreen,
    secondary = TealBlue,
    background = Color(0xFF0A0A0F),
    surface = Color(0xFF12121A)
)

private val LightColors = lightColorScheme(
    primary = EmeraldGreen,
    secondary = TealBlue,
    background = Color(0xFFF4F6F5),
    surface = Color(0xFFFFFFFF)
)

/**
 * Dark-first theme. [themeMode] comes from UserPreferences so the Settings
 * toggle takes effect immediately (SYSTEM follows the device setting).
 */
@Composable
fun BingwaScoreTheme(
    themeMode: ThemeMode = ThemeMode.DARK,
    content: @Composable () -> Unit
) {
    val useDark = when (themeMode) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
    }
    MaterialTheme(
        colorScheme = if (useDark) DarkColors else LightColors,
        content = content
    )
}

