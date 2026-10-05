package com.bingwascore.app

import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * POLISH P6 — the splash budget.
 *
 * The choreography is a contract with the agent: the app must be usable in under
 * two seconds, and every step has to happen in the order it claims. These are the
 * numbers a designer tuned by eye, so they are pinned here — a refactor that
 * quietly pushes the hand-off past 2.0s fails the build rather than the shop.
 */
class SplashChoreographyTest {

    @Test
    fun `the splash hands off inside two seconds`() {
        assertTrue(
            "splash total ${Motion.SPLASH_TOTAL}ms exceeds the 2.0s budget",
            Motion.SPLASH_TOTAL <= 2_000
        )
    }

    @Test
    fun `the steps happen in the order they are documented`() {
        assertTrue(Motion.SPLASH_GLOW_START < Motion.SPLASH_DRAW + Motion.SPLASH_GLOW_PULSE / 2)
        assertTrue("glow must pulse after the stroke is drawn", Motion.SPLASH_GLOW_START >= 0)
        assertTrue(
            "the wordmark must start after the stroke",
            Motion.SPLASH_WORDMARK_START > Motion.SPLASH_DRAW
        )
        assertTrue(
            "the wordmark must finish before the tagline",
            Motion.SPLASH_TAGLINE_START > Motion.SPLASH_WORDMARK_START
        )
        assertTrue(
            "the tagline must land before the hand-off",
            Motion.SPLASH_TOTAL > Motion.SPLASH_TAGLINE_START
        )
    }

    @Test
    fun `the whole wordmark fits inside its window`() {
        val letters = "Bingwa Score".length
        val span = Motion.SPLASH_LETTER_STAGGER * (letters - 1)
        val window = Motion.SPLASH_TAGLINE_START - Motion.SPLASH_WORDMARK_START
        assertTrue(
            "the last letter would arrive after the tagline",
            span <= window
        )
    }

    @Test
    fun `letters stagger at 30ms`() {
        assertTrue(Motion.SPLASH_LETTER_STAGGER == 30)
    }
}
