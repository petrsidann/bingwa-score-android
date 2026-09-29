package com.bingwascore.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.bingwascore.app.domain.ThemeMode

private val DarkColors = darkColorScheme(
    primary = BingwaOrange,
    secondary = Amber,
    tertiary = OrangeDark,
    background = NightBlack,
    surface = SurfaceDark
)

private val LightColors = lightColorScheme(
    primary = BingwaOrange,
    secondary = Amber,
    tertiary = OrangeDark,
    background = LightBackground,
    surface = LightSurface
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

