package com.bingwascore.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
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
    themeMode: ThemeMode = ThemeMode.PORCELAIN_DIM,
    content: @Composable () -> Unit
) {
    // Stage 21 — the palette is installed BEFORE the content composes.
    //
    // The colour tokens read the mode WHILE they draw, so a `SideEffect`
    // (which lands after the composition) painted the first frame in the
    // PREVIOUS theme: the light splash came up dark for one frame, and the
    // light onboarding wore a dark canvas under a white card. The write
    // happens here instead — it converges (the value only changes when the
    // theme really changed), so no extra frame is burned.
    installDisplayMode(themeMode)

    val scheme = remember(themeMode) {
        when (themeMode) {
            ThemeMode.PORCELAIN_DIM -> lightColorScheme(
                primary = PorcelainDimAccent,
                secondary = PorcelainDimAccent,
                tertiary = TickGreen,
                background = PorcelainDimBg,
                surface = PorcelainDimCard,
                onPrimary = Color.White,
                error = PorcelainDimFailed,
                outline = PorcelainDimSeparator,
                onBackground = PorcelainDimText,
                onSurface = PorcelainDimText
            )
            else -> darkColorScheme(
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

