package com.bingwascore.app

import app.cash.paparazzi.Paparazzi
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.screens.SplashScreenContent
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * STAGE 44 — splash goldens at 0.4s / 0.9s / 1.5s in BOTH themes.
 *
 * 0.4s = aurora glow + monogram mid-snap; 0.9s = fill + tagline mid-fade;
 * 1.5s = exit scale + cross-fade. Every PNG is VIEWED via read_file before
 * the stage is called shippable (design constitution).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage44SplashGoldensTest {

    @get:Rule val paparazzi = Paparazzi()

    private fun splash(mode: ThemeMode, progressMs: Int) = paparazzi.snapshot {
        BingwaScoreTheme(themeMode = mode) {
            SplashScreenContent(target = "home", onFinish = {}, progressMs = progressMs)
        }
    }

    @Test fun splash0400msObsidian() = splash(ThemeMode.DARK, 400)
    @Test fun splash0400msPorcelainDim() = splash(ThemeMode.PORCELAIN_DIM, 400)

    @Test fun splash0900msObsidian() = splash(ThemeMode.DARK, 900)
    @Test fun splash0900msPorcelainDim() = splash(ThemeMode.PORCELAIN_DIM, 900)

    @Test fun splash1500msObsidian() = splash(ThemeMode.DARK, 1500)
    @Test fun splash1500msPorcelainDim() = splash(ThemeMode.PORCELAIN_DIM, 1500)
}
