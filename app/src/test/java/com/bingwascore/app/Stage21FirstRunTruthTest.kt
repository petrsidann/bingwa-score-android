package com.bingwascore.app

import com.bingwascore.app.ui.brand.BrandWordmark
import com.bingwascore.app.ui.onboarding.OnboardingPager
import com.bingwascore.app.ui.onboarding.SnakeCarousel
import com.bingwascore.app.ui.screens.SPLASH_WORDMARK
import com.bingwascore.app.ui.screens.SplashBrand
import com.bingwascore.app.ui.screens.splashGlowAlpha
import com.bingwascore.app.ui.screens.splashInk
import com.bingwascore.app.ui.screens.wordmarkAlphas
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 21 — first-run + splash TRUTH.
 *
 * The wordmark is a STRING, never a picture: the splash and the onboarding
 * render one shared constant, and this test asserts that constant by value
 * in BOTH themes — the "Bingwa Scor" drop-letter bug cannot come back.
 *
 * The pager is a real pager: three pages, 24dp apart, an inactive page that
 * fades with its offset, an indicator that follows the pager, and touch
 * targets that clear 44dp. The copy inside a card FITS: it is scaled, never
 * clipped, so no rotation can cut a page in half.
 */
class Stage21FirstRunTruthTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String = File(repoRoot, path).readText()

    /** The code of a file, comments stripped — a doc comment is not a literal. */
    private fun codeOf(src: String): String = src
        .replace(Regex("""/\*.*?\*/""", RegexOption.DOT_MATCHES_ALL), " ")
        .replace(Regex("""//.*"""), " ")

    // ── The wordmark: one string, in both themes ──────────────────────────────

    @Test
    fun `the wordmark is exactly Bingwa Score`() {
        assertEquals("Bingwa Score", BrandWordmark.TEXT)
        assertEquals(12, BrandWordmark.TEXT.length)
        assertEquals("Bingwa Score", BrandWordmark.LETTERS.joinToString(""))
        assertEquals(12, BrandWordmark.LETTERS.size)
        assertEquals(BrandWordmark.TEXT, SplashBrand.WORDMARK)
        assertEquals(BrandWordmark.TEXT, SPLASH_WORDMARK)
    }

    @Test
    fun `every letter of the wordmark rises`() {
        // The last letter must reach full ink — the drop-letter bug left the
        // final glyph at zero alpha, which shipped "Bingwa Scor".
        listOf(BrandWordmark.TEXT.length.toFloat(), 99f).forEach { progress ->
            val alphas = wordmarkAlphas(BrandWordmark.TEXT, progress)
            assertEquals("a letter went missing at progress=$progress", 12, alphas.size)
            alphas.forEachIndexed { index, alpha ->
                assertEquals("letter $index never rose at progress=$progress", 1f, alpha, 0.0001f)
            }
        }
    }

    @Test
    fun `the wordmark is invisible before the stagger starts`() {
        val alphas = wordmarkAlphas(BrandWordmark.TEXT, 0f)
        assertEquals(12, alphas.size)
        assertTrue("nothing may show before the stagger", alphas.all { it == 0f })
    }

    @Test
    fun `the wordmark ink is opaque in both themes`() {
        // The string is legible in both themes: full ink, and NOT one ink
        // shared by both canvases (light ink on obsidian, dark ink on porcelain).
        listOf(true, false).forEach { dark ->
            assertEquals("ink must be opaque in dark=$dark", 1f, splashInk(dark).alpha, 0.0001f)
        }
        assertNotEquals("the two themes must not share one ink", splashInk(true), splashInk(false))
    }

    @Test
    fun `both screens render the shared wordmark constant`() {
        val splash = codeOf(source("app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt"))
        val onboarding = codeOf(source("app/src/main/java/com/bingwascore/app/ui/onboarding/OnboardingCarousel.kt"))
        listOf(splash, onboarding).forEach { src ->
            assertTrue("a screen must render the shared wordmark", src.contains("BrandWordmark.TEXT"))
            assertFalse("no screen may hard-code its own wordmark", src.contains("\"Bingwa Score\""))
        }
    }

    @Test
    fun `the splash glow is a soft blue in both themes`() {
        listOf(true, false).forEach { dark ->
            val alpha = splashGlowAlpha(dark)
            assertTrue("the glow must be visible in dark=$dark", alpha > 0f)
            assertTrue("the glow must stay soft in dark=$dark", alpha <= 0.5f)
        }
    }

    // ── The pager: three pages, 24dp apart, no overlap ────────────────────────

    @Test
    fun `the pager has three pages`() {
        assertEquals(3, OnboardingPager.PAGE_COUNT)
        assertEquals(3, SnakeCarousel.SLIDES.size)
        assertEquals(24f, OnboardingPager.PAGE_GAP_DP, 0.001f)
    }

    @Test
    fun `pages never overlap and sit exactly one gap apart`() {
        val bounds = OnboardingPager.pageBounds(pageWidth = 1000f)
        assertEquals(3, bounds.size)
        for (i in 0 until bounds.size) {
            for (j in i + 1 until bounds.size) {
                assertTrue(
                    "pages $i and $j overlap",
                    bounds[i].second <= bounds[j].first || bounds[j].second <= bounds[i].first
                )
            }
        }
        assertEquals(24f, bounds[1].first - bounds[0].second, 0.001f)
    }

    @Test
    fun `an inactive page fades with its offset`() {
        assertEquals(1f, OnboardingPager.pageAlpha(0f), 0.001f)
        assertTrue(OnboardingPager.pageAlpha(1f) < 1f)
        assertTrue(OnboardingPager.pageAlpha(0.5f) in 0f..1f)
        assertEquals(1f, OnboardingPager.textAlpha(0f), 0.001f)
        assertTrue(OnboardingPager.textAlpha(1f) < 1f)
    }

    @Test
    fun `the indicator follows the pager position`() {
        val atRest = OnboardingPager.dotWeights(0f, 3)
        assertEquals(1f, atRest[0], 0.001f)
        assertEquals(0f, atRest[1], 0.001f)
        assertEquals(0f, atRest[2], 0.001f)
        // Halfway between two dots: the pill is shared by both.
        val sliding = OnboardingPager.dotWeights(0.5f, 3)
        assertTrue(sliding[0] > 0f && sliding[1] > 0f)
        assertEquals(0f, sliding[2], 0.001f)
    }

    @Test
    fun `the touch targets clear 44dp`() {
        assertTrue(
            "skip/next touch targets must clear 44dp",
            OnboardingPager.MIN_TOUCH_TARGET_DP >= 44f
        )
    }

    @Test
    fun `the page copy fits instead of clipping`() {
        // A landscape phone leaves far less room: the content is scaled down
        // to fit, never cut off.
        val scale = OnboardingPager.fitScale(contentHeight = 240f, availableHeight = 120f)
        assertEquals(0.5f, scale, 0.001f)
        assertTrue("the content must fit", 240f * scale <= 120f)
        // A tall screen never blows the content up.
        assertEquals(1f, OnboardingPager.fitScale(contentHeight = 200f, availableHeight = 400f), 0.001f)
        // Degenerate input never divides by zero.
        assertEquals(1f, OnboardingPager.fitScale(contentHeight = 0f, availableHeight = 0f), 0.001f)
    }
}
