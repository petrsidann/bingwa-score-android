package com.bingwascore.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = Orange500,
    onPrimary = White,
    primaryContainer = Orange100,
    onPrimaryContainer = Orange600,
    secondary = Purple500,
    onSecondary = White,
    background = White,
    onBackground = Gray900,
    surface = White,
    onSurface = Gray900,
    surfaceVariant = Gray50,
    onSurfaceVariant = Gray600,
    outline = Gray200,
    error = Rose500,
    onError = White
)

private val DarkColors = darkColorScheme(
    primary = Purple500,
    onPrimary = White,
    primaryContainer = Purple900,
    onPrimaryContainer = Purple400,
    secondary = Orange500,
    onSecondary = White,
    background = Black,
    onBackground = Color(0xFFF5F5F5),
    surface = DarkCard,
    onSurface = Color(0xFFF5F5F5),
    surfaceVariant = Color(0xFF161616),
    onSurfaceVariant = Color(0xFF9CA3AF),
    outline = DarkBorder,
    error = Rose500,
    onError = White
)

@Composable
fun BingwaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = !darkTheme
                isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = BingwaTypography,
        content = content
    )
}
