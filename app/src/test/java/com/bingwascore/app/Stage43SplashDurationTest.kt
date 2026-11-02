package com.bingwascore.app

import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 43 — Splash duration test.
 *
 * Stage 44 superseded the 1.3s ceiling with the device-law FLOOR: the splash
 * must stay visible at least 1600ms (no flash-blank) and still hand off
 * inside the 2.0s usability budget.
 */
class Stage43SplashDurationTest {

    @Test
    fun `splash is visible for at least 1600ms`() {
        assertTrue(
            "Splash total duration ${Motion.SPLASH_TOTAL}ms is below the 1600ms minimum-visible law",
            Motion.SPLASH_TOTAL >= 1600
        )
    }

    @Test
    fun `splash total duration is positive and within budget`() {
        assertTrue(Motion.SPLASH_TOTAL > 0)
        assertTrue(Motion.SPLASH_TOTAL <= 2000)
    }
}
