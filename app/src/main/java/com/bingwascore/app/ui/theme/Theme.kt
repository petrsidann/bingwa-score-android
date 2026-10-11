package com.bingwascore.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.bingwascore.app.domain.ThemeMode

/**
 * Stage 10 — iOS design system theming: Obsidian (dark) + Porcelain (light).
 *
 * [BingwaScoreTheme] publishes the active mode to the colour tokens on every
 * composition, so an Appearance switch repaints the whole app instantly.
 * Springs: response 0.35 / damping 0.86; press scale 0.98.
 */
@Composable
fun BingwaScoreTheme(
    themeMode: ThemeMode = ThemeMode.DARK,
    content: @Composable () -> Unit
) {
    // SideEffect (not a direct write) keeps the state change outside the
    // composition pass: the new palette lands on the very next frame.
    SideEffect { installDisplayMode(themeMode) }

    val scheme = remember(themeMode) {
        if (themeMode == ThemeMode.LIGHT) {
            lightColorScheme(
                primary = IosBlue,
                secondary = IosBlue,
                tertiary = TickGreen,
                background = PorcelainBg,
                surface = PorcelainCard,
                onPrimary = Color.White,
                error = FailRed,
                outline = PorcelainSeparator,
                onBackground = PorcelainText,
                onSurface = PorcelainText
            )
        } else {
            darkColorScheme(
                primary = BrandBlue,
                secondary = ChartBlue,
                tertiary = TickGreen,
                background = Color(0xFF0B0E15),
                surface = Color(0xFF131824),
                onPrimary = Color.White,
                error = FailRed,
                outline = Color(0xFF232C42),
                onBackground = Color.White,
                onSurface = Color.White
            )
        }
    }

    MaterialTheme(
        colorScheme = scheme,
        typography = Typography,
        content = content
    )
}

