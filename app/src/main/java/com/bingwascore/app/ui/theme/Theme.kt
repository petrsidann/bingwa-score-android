package com.bingwascore.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = EmeraldGreen,
    secondary = TealBlue,
    background = Color(0xFF0A0A0F),
    surface = Color(0xFF12121A)
)

@Composable
fun BingwaScoreTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = DarkColors, content = content)
}
