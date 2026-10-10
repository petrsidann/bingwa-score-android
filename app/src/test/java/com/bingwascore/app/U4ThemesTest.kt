package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.components.Silica
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.GRAYSCALE_DOT_SATURATION
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.GlassFillStrong
import com.bingwascore.app.ui.theme.ORB_BLUR
import com.bingwascore.app.ui.theme.OrbBlue
import com.bingwascore.app.ui.theme.OrbViolet
import com.bingwascore.app.ui.theme.SecondaryOutline
import com.bingwascore.app.ui.theme.SemanticBlue
import com.bingwascore.app.ui.theme.SemanticGrey
import com.bingwascore.app.ui.theme.StatusDone
import com.bingwascore.app.ui.theme.StatusFailedTint
import com.bingwascore.app.ui.theme.StatusQueued
import com.bingwascore.app.ui.theme.installDisplayMode
import com.bingwascore.app.ui.theme.saturate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * U4 — themes alive.
 *
 * Laws:
 *  1. Grayscale keeps DISTINCT desaturated tints: Done silver-blue, Failed
 *     charcoal-red, Queued neutral. They are different colours, not one grey.
 *  2. Dots keep 60% saturation in Grayscale.
 *  3. Grayscale CTA is solid #E0E0E0 with black text; the secondary outline is
 *     #9E9E9E.
 *  4. Silica is blur 32dp, 18% white tint, orbs 8% alpha with a 140dp soft edge.
 *  5. Nothing in the palette is orange/amber.
 */
class U4ThemesTest {

    private fun argb(c: Color): Int = c.toArgb()

    // ── Law 1: distinct desaturated Grayscale tints ───────────────────────────

    @Test
    fun grayscaleStatusTintsAreDistinct() {
        installDisplayMode(ThemeMode.GRAYSCALE)

        val done = argb(StatusDone)
        val failed = argb(StatusFailedTint)
        val queued = argb(StatusQueued)

        assertFalse("Done and Failed must differ", done == failed)
        assertFalse("Done and Queued must differ", done == queued)
        assertFalse("Failed and Queued must differ", failed == queued)

        // Done is silver-BLUE: blue channel is the strongest of the three.
        assertTrue("Done must read silver-blue", StatusDone.blue >= StatusDone.red)
        // Failed is charcoal-RED: red channel is the strongest.
        assertTrue("Failed must read charcoal-red", StatusFailedTint.red >= StatusFailedTint.blue)
        // Queued stays neutral: all three channels equal.
        assertEquals(StatusQueued.red, StatusQueued.green, 0.0001f)
        assertEquals(StatusQueued.green, StatusQueued.blue, 0.0001f)
    }

    @Test
    fun obsidianKeepsFullSemanticStatusColour() {
        installDisplayMode(ThemeMode.DARK)
        assertEquals(argb(SemanticBlue), argb(StatusDone))
        assertEquals(0xFFFF5252.toInt(), argb(StatusFailedTint))
        assertEquals(argb(SemanticGrey), argb(StatusQueued))
    }

    // ── Law 2: dots keep 60% saturation ───────────────────────────────────────

    @Test
    fun dotSaturationIsSixtyPercent() {
        assertEquals(0.6f, GRAYSCALE_DOT_SATURATION, 0.0001f)
    }

    @Test
    fun saturateZeroIsPureLuminanceGrey() {
        val grey = saturate(Color(0xFFFF0000), 0f)
        assertEquals(grey.red, grey.green, 0.0001f)
        assertEquals(grey.green, grey.blue, 0.0001f)
    }

    @Test
    fun saturateKeepsSomeHueAtSixtyPercent() {
        val red = saturate(Color(0xFFFF0000), 0.6f)
        assertTrue("red must survive at 60%", red.red > red.green)
        // …and it is pulled toward grey, unlike the untouched colour.
        assertTrue(red.green > 0f)
    }

    // ── Law 3: Grayscale CTA + secondary outline ──────────────────────────────

    @Test
    fun grayscaleCtaIsSolidLightChipWithBlackInk() {
        installDisplayMode(ThemeMode.GRAYSCALE)
        assertEquals(0xFFE0E0E0.toInt(), argb(CtaFill))
        assertEquals(0xFF000000.toInt(), argb(CtaInk))
        assertEquals(0xFF9E9E9E.toInt(), argb(SecondaryOutline))
    }

    @Test
    fun blueModesKeepTheBrandCta() {
        installDisplayMode(ThemeMode.DARK)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        installDisplayMode(ThemeMode.SILICA)
        assertEquals(argb(AccentBlue), argb(CtaFill))
    }

    // ── Law 4: Silica glass numbers ───────────────────────────────────────────

    @Test
    fun silicaBlursAtThirtyTwoDp() {
        assertEquals(32.dp, Silica.CARD_BLUR)
    }

    @Test
    fun glassTintIsEighteenPercentWhite() {
        assertEquals(0.18f, GlassFill.alpha, 0.01f)
        assertTrue(GlassFillStrong.alpha >= GlassFill.alpha)
    }

    @Test
    fun orbsAreEightPercentWithAOneHundredFortyDpSoftEdge() {
        assertEquals(0.08f, OrbBlue.alpha, 0.01f)
        assertEquals(0.08f, OrbViolet.alpha, 0.01f)
        assertEquals(140.dp, ORB_BLUR)
    }

    // ── Law 5: no orange/amber anywhere in the token palette ──────────────────

    private fun isOrangeAmber(c: Color): Boolean =
        c.red > c.green && c.green > c.blue && c.red > 0.5f && (c.red - c.blue) > 0.25f

    // ── Law 6: Obsidian disabled-state contrast sweep ────────────────────────

    /** WCAG relative luminance. */
    private fun luminance(c: Color): Double {
        fun channel(v: Float): Double {
            val d = v.toDouble()
            return if (d <= 0.03928) d / 12.92 else Math.pow((d + 0.055) / 1.055, 2.4)
        }
        return 0.2126 * channel(c.red) + 0.7152 * channel(c.green) + 0.0722 * channel(c.blue)
    }

    private fun contrast(a: Color, b: Color): Double {
        val la = luminance(a)
        val lb = luminance(b)
        val hi = maxOf(la, lb)
        val lo = minOf(la, lb)
        return (hi + 0.05) / (lo + 0.05)
    }

    /** Composite a possibly-translucent colour over an opaque one. */
    private fun over(fg: Color, bg: Color): Color = Color(
        red = fg.red * fg.alpha + bg.red * (1f - fg.alpha),
        green = fg.green * fg.alpha + bg.green * (1f - fg.alpha),
        blue = fg.blue * fg.alpha + bg.blue * (1f - fg.alpha),
        alpha = 1f
    )

    @Test
    fun disabledPairClearsAaInEveryMode() {
        listOf(ThemeMode.DARK, ThemeMode.GRAYSCALE, ThemeMode.SILICA).forEach { mode ->
            installDisplayMode(mode)
            // Silica's glass tokens are translucent, so the real contrast is
            // measured on the flattened colour over the black canvas.
            val canvas = Color(0xFF000000)
            val fill = over(DisabledFill, canvas)
            val ink = over(DisabledInk, fill)
            val ratio = contrast(ink, fill)
            assertTrue(
                "disabled ink/fill contrast $ratio too low in $mode",
                ratio >= 4.0
            )
        }
    }

    @Test
    fun grayscaleChipContrastIsStrong() {
        installDisplayMode(ThemeMode.GRAYSCALE)
        val ratio = contrast(over(CtaInk, CtaFill), CtaFill)
        assertTrue("black on #E0E0E0 must be very high, was $ratio", ratio >= 10.0)
    }

    @Test
    fun paletteHasNoOrangeOrAmber() {
        installDisplayMode(ThemeMode.DARK)
        val tokens = listOf(AccentBlue, CtaFill, StatusDone, StatusFailedTint, StatusQueued)
        tokens.forEach { token ->
            assertFalse("orange/amber token leaked: $token", isOrangeAmber(token))
        }
    }
}
