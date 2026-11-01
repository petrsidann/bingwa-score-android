package com.bingwascore.app

import app.cash.paparazzi.Paparazzi
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.screens.SplashScreenContent
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import com.bingwascore.app.ui.theme.installDisplayMode
import org.junit.After
import org.junit.Rule
import org.junit.Test

/**
 * Stage 43 — Aurora Snap Splash Paparazzi Golden Suite.
 *
 * Renders snapshots at 0.3s (300ms), 0.6s (600ms), and 1.0s (1000ms)
 * across BOTH themes: Obsidian (`ThemeMode.DARK`) and Porcelain Dim (`ThemeMode.PORCELAIN_DIM`).
 */
class Stage43SplashSnapshotTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @After
    fun resetDisplayMode() {
        installDisplayMode(ThemeMode.DARK)
    }

    // ── Obsidian (Dark) ──────────────────────────────────────────────────────

    @Test
    fun splashDark03s() = snapshot(ThemeMode.DARK, 300)

    @Test
    fun splashDark06s() = snapshot(ThemeMode.DARK, 600)

    @Test
    fun splashDark10s() = snapshot(ThemeMode.DARK, 1000)

    // ── Porcelain Dim ────────────────────────────────────────────────────────

    @Test
    fun splashPorcelainDim03s() = snapshot(ThemeMode.PORCELAIN_DIM, 300)

    @Test
    fun splashPorcelainDim06s() = snapshot(ThemeMode.PORCELAIN_DIM, 600)

    @Test
    fun splashPorcelainDim10s() = snapshot(ThemeMode.PORCELAIN_DIM, 1000)

    private fun snapshot(mode: ThemeMode, progressMs: Int) {
        paparazzi.snapshot {
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalInspectionMode provides true
            ) {
                BingwaScoreTheme(themeMode = mode) {
                    SplashScreenContent(
                        target = "main",
                        onFinish = {},
                        settled = false,
                        progressMs = progressMs
                    )
                }
            }
        }
    }
}
