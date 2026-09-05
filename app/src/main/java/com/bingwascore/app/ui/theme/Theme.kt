package com.bingwascore.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val PremiumDark = darkColorScheme(
    primary = EmeraldGreen,
    onPrimary = NightBlack,
    primaryContainer = NightSurface,
    onPrimaryContainer = TextPrimary,
    secondary = TealBlue,
    background = NightBlack,
    onBackground = TextPrimary,
    surface = NightSurface,
    onSurface = TextPrimary,
    surfaceVariant = GlassWhite,
    onSurfaceVariant = TextSecondary,
    error = ErrorRed
)

@Composable
fun BingwaScoreTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = PremiumDark, typography = Typography, content = content)
}
