package com.bingwascore.app.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Purple900 = Color(0xFF1A0033)
val Purple400 = Color(0xFFBB86FC)
val Teal200 = Color(0xFF03DAC5)
val TealBlue = Color(0xFF00BCD4)
val Orange500 = Color(0xFFFF6D00)
val Orange600 = Color(0xFFF57C00)
val EmeraldGreen = Color(0xFF00C853)
val ErrorRed = Color(0xFFD50000)
val White = Color(0xFFFFFFFF)

private val LightColors = lightColorScheme(
    primary = Orange500,
    onPrimary = White,
    primaryContainer = Color(0xFFFFE3D0),
    onPrimaryContainer = Orange600,
    secondary = Orange600,
    background = Color(0xFFE4E4E9), // Silver/Grey
    onBackground = Color(0xFF1A1A1E),
    surface = Color(0xFFF2F2F5),
    onSurface = Color(0xFF1A1A1E),
    surfaceVariant = Color(0xFFDCDCE2),
    onSurfaceVariant = Color(0xFF5C5C66),
    outline = Color(0xFFC2C2CB)
)

private val DarkColors = darkColorScheme(
    primary = Purple500,
    onPrimary = White,
    primaryContainer = Purple900,
    onPrimaryContainer = Purple400,
    secondary = Orange500,
    background = Color(0xFF0B0B0F), // True Black
    onBackground = Color(0xFFF2F2F7),
    surface = Color(0xFF15151A),
    onSurface = Color(0xFFF2F2F7),
    surfaceVariant = Color(0xFF1F1F27),
    onSurfaceVariant = Color(0xFF98989D),
    outline = Color(0xFF2C2C34)
)

@Composable
fun BingwaTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    MaterialTheme(colorScheme = colorScheme, typography = BingwaTypography, content = content)
}
