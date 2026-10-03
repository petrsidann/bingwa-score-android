package com.bingwascore.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.bingwascore.app.domain.ThemeMode
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.lightColorScheme

/**
 * REBRAND R1 — dark-only theming.
 *
 * There is no light scheme and no system following: the three display modes all
 * render on pure black. [BingwaScoreTheme] publishes the active mode to the
 * colour tokens on every composition, so an Appearance switch repaints the whole
 * app instantly without a restart.
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
        val base = darkColorScheme(
            primary = AccentBlue,
            secondary = ChartBlue,
            tertiary = TickGreen,
            background = BgBlack,
            surface = Bubble,
            onPrimary = CtaInk,
            error = FailRed,
            outline = Hairline,
            onBackground = TextWhite,
            onSurface = TextWhite
        )
        base
    }

    MaterialTheme(
        colorScheme = scheme,
        typography = Typography,
        content = content
    )
}

