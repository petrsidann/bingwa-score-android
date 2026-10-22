package com.bingwascore.app

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.resources.ScreenOrientation
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.onboarding.OnboardingCarouselContent
import com.bingwascore.app.ui.onboarding.OnboardingCarouselState
import com.bingwascore.app.ui.screens.SplashScreenContent
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import com.bingwascore.app.ui.theme.installDisplayMode
import org.junit.After
import org.junit.Rule
import org.junit.Test

/**
 * Stage 21 — the EYES of the first run.
 *
 * Every onboarding page and the splash, in BOTH themes: obsidian and dim
 * porcelain must carry the SAME first impression. The landscape suite is the
 * rotation proof — the pages fit, they never overlap, and they never clip.
 */
class Stage21FirstRunPreviewTest {

    @get:Rule
    val paparazzi = Paparazzi()

    /** The display mode is global state: hand it back clean after every shot. */
    @After
    fun resetDisplayMode() {
        installDisplayMode(ThemeMode.DARK)
    }


    // ── Onboarding — three pages, both themes ────────────────────────────────

    @Test
    fun onboardingPage1Dark() = snapshot(ThemeMode.DARK) { onboarding(0) }

    @Test
    fun onboardingPage1Light() = snapshot(ThemeMode.LIGHT) { onboarding(0) }

    @Test
    fun onboardingPage2Dark() = snapshot(ThemeMode.DARK) { onboarding(1) }

    @Test
    fun onboardingPage2Light() = snapshot(ThemeMode.LIGHT) { onboarding(1) }

    @Test
    fun onboardingPage3Dark() = snapshot(ThemeMode.DARK) { onboarding(2) }

    @Test
    fun onboardingPage3Light() = snapshot(ThemeMode.LIGHT) { onboarding(2) }

    // ── Splash — both themes ─────────────────────────────────────────────────

    @Test
    fun splashDark() = snapshot(ThemeMode.DARK) { splash() }

    @Test
    fun splashLight() = snapshot(ThemeMode.LIGHT) { splash() }

    @androidx.compose.runtime.Composable
    private fun onboarding(page: Int) {
        OnboardingCarouselContent(state = OnboardingCarouselState(page = page))
    }

    @androidx.compose.runtime.Composable
    private fun splash() {
        SplashScreenContent(target = "main", onFinish = {}, settled = true)
    }

    private fun snapshot(mode: ThemeMode, content: @androidx.compose.runtime.Composable () -> Unit) {
        paparazzi.snapshot {
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalInspectionMode provides true
            ) {
                BingwaScoreTheme(themeMode = mode) {
                    content()
                }
            }
        }
    }
}

/**
 * Stage 21 — the same first run in LANDSCAPE.
 *
 * A rotated phone has the width but not the height: this is where the pages
 * used to smash into each other. Every golden here must show whole pages.
 */
class Stage21FirstRunLandscapePreviewTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.NEXUS_5.copy(orientation = ScreenOrientation.LANDSCAPE)
    )

    /** The display mode is global state: hand it back clean after every shot. */
    @After
    fun resetDisplayMode() {
        installDisplayMode(ThemeMode.DARK)
    }


    @Test
    fun onboardingPage1Dark() = snapshot(ThemeMode.DARK) { onboarding(0) }

    @Test
    fun onboardingPage1Light() = snapshot(ThemeMode.LIGHT) { onboarding(0) }

    @Test
    fun onboardingPage3Dark() = snapshot(ThemeMode.DARK) { onboarding(2) }

    @Test
    fun onboardingPage3Light() = snapshot(ThemeMode.LIGHT) { onboarding(2) }

    @Test
    fun splashDark() = snapshot(ThemeMode.DARK) { splash() }

    @Test
    fun splashLight() = snapshot(ThemeMode.LIGHT) { splash() }

    @androidx.compose.runtime.Composable
    private fun onboarding(page: Int) {
        OnboardingCarouselContent(state = OnboardingCarouselState(page = page))
    }

    @androidx.compose.runtime.Composable
    private fun splash() {
        SplashScreenContent(target = "main", onFinish = {}, settled = true)
    }

    private fun snapshot(mode: ThemeMode, content: @androidx.compose.runtime.Composable () -> Unit) {
        paparazzi.snapshot {
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalInspectionMode provides true
            ) {
                BingwaScoreTheme(themeMode = mode) {
                    content()
                }
            }
        }
    }
}
