package com.bingwascore.app

import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 43 — Splash duration test.
 *
 * Verifies that the splash total duration is strictly <= 1300ms.
 */
class Stage43SplashDurationTest {

    @Test
    fun `splash total duration is at most 1300ms`() {
        assertTrue(
            "Splash total duration ${Motion.SPLASH_TOTAL}ms exceeds 1300ms",
            Motion.SPLASH_TOTAL <= 1300
        )
    }

    @Test
    fun `splash total duration is positive and within budget`() {
        assertTrue(Motion.SPLASH_TOTAL > 0)
        assertTrue(Motion.SPLASH_TOTAL <= 1300)
    }
}
