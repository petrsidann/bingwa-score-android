package com.bingwascore.app.ui.theme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(primary = EmeraldGreen, secondary = TealBlue)
private val LightColorScheme = lightColorScheme(primary = EmeraldGreen, secondary = TealBlue)

@Composable
fun BingwaScoreTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
