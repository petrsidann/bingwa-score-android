package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.ChartBlue
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.PorcelainDimAccent
import com.bingwascore.app.ui.theme.PorcelainDimBg
import com.bingwascore.app.ui.theme.PorcelainDimCard
import com.bingwascore.app.ui.theme.PorcelainDimText
import com.bingwascore.app.ui.theme.StatusDone
import com.bingwascore.app.ui.theme.StatusFailedTint
import com.bingwascore.app.ui.theme.StatusQueued
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.installDisplayMode
import com.bingwascore.app.ui.theme.isPorcelain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 22 — PORCELAIN DIM: the lights dimmed, not the sun turned off.
 *
 * The law: a THIRD theme that is unmistakably dimmer than Porcelain, still a
 * light canvas (never an Obsidian-black takeover), keeps the brand blue family
 * as a SOFT accent, and clears WCAG on every one of its own surfaces.
 */
class Stage22PorcelainDimTest {

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
        return (maxOf(la, lb) + 0.05) / (minOf(la, lb) + 0.05)
    }

    private fun over(fg: Color, bg: Color): Color = Color(
        red = fg.red * fg.alpha + bg.red * (1f - fg.alpha),
        green = fg.green * fg.alpha + bg.green * (1f - fg.alpha),
        blue = fg.blue * fg.alpha + bg.blue * (1f - fg.alpha),
        alpha = 1f
    )

    // ── The theme exists, and it is a LIGHT canvas ────────────────────────────

    @Test
    fun `porcelain dim is a real third theme`() {
        assertEquals(3, ThemeMode.entries.size)
        assertEquals("Porcelain Dim", ThemeMode.PORCELAIN_DIM.label)
        assertEquals(ThemeMode.PORCELAIN_DIM, ThemeMode.fromValue("PORCELAIN_DIM"))
    }

    @Test
    fun `porcelain dim is dimmed, never a black takeover`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        val dim = luminance(BgBlack)
        // Dimmer than porcelain, lighter than obsidian by a wide margin.
        assertTrue("porcelain dim must be dimmer than porcelain ($dim)", dim < 0.75)
        assertTrue("porcelain dim must not be a dark theme ($dim)", dim > 0.3)
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `porcelain dim counts as a porcelain canvas`() {
        // The splash draws dark ink on a light canvas — that must hold in Dim.
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertTrue("dim mode is a light canvas", isPorcelain)
        installDisplayMode(ThemeMode.DARK)
        assertFalse("obsidian is not porcelain", isPorcelain)
    }

    @Test
    fun `porcelain dim surfaces are dimmed porcelain, not obsidian`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(PorcelainDimBg, BgBlack)
        assertEquals(PorcelainDimCard, Bubble)
        assertEquals(PorcelainDimText, TextWhite)
        // The cards sit ABOVE the canvas, so the layout still reads.
        assertTrue("cards must lift off the dim canvas", luminance(Bubble) > luminance(BgBlack))
        installDisplayMode(ThemeMode.DARK)
    }

    // ── The accent: soft, blue, still the brand family ───────────────────────

    @Test
    fun `porcelain dim keeps a soft blue accent`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        val accent = AccentBlue
        assertEquals(PorcelainDimAccent, accent)
        // Blue-dominant (never orange/amber) and softer than pure brand blue.
        assertTrue("the accent must stay blue", accent.blue > accent.red && accent.blue > accent.green)
        assertTrue("the accent must be softened", luminance(accent) > luminance(Color(0xFF2563EB)))
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `the dim canvas never goes orange or amber`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        listOf(AccentBlue, CtaFill, ChartBlue, StatusDone, StatusFailedTint, StatusQueued).forEach { token ->
            val orange = token.red > token.green && token.green > token.blue && token.red > 0.5f &&
                (token.red - token.blue) > 0.25f
            assertFalse("orange/amber leaked into the dim theme: $token", orange)
        }
        installDisplayMode(ThemeMode.DARK)
    }

    // ── Contrast: every token clears AA ON THE DIM CANVAS ────────────────────

    @Test
    fun `text tokens clear AA on the dim canvas`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        val canvas = BgBlack
        listOf("TextWhite" to TextWhite, "TextGrey" to TextGrey).forEach { (name, ink) ->
            val ratio = contrast(over(ink, canvas), canvas)
            assertTrue("$name fails AA ($ratio) in Porcelain Dim", ratio >= 4.5)
        }
        val dimRatio = contrast(over(TextDim, canvas), canvas)
        assertTrue("TextDim below 3:1 ($dimRatio) in Porcelain Dim", dimRatio >= 3.0)
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `status tints clear 3 to 1 on the dim canvas`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        val canvas = BgBlack
        listOf(StatusDone, StatusFailedTint, StatusQueued).forEach { tint ->
            val ratio = contrast(over(tint, canvas), canvas)
            assertTrue("status tint $tint fails 3:1 ($ratio) in Porcelain Dim", ratio >= 3.0)
        }
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `the cta and the disabled pair clear AA on the dim canvas`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        val canvas = BgBlack
        val fill = over(CtaFill, canvas)
        val cta = contrast(over(CtaInk, fill), fill)
        assertTrue("CTA ink/fill too low ($cta) in Porcelain Dim", cta >= 4.5)

        val disabledFill = over(DisabledFill, canvas)
        val disabled = contrast(over(DisabledInk, disabledFill), disabledFill)
        assertTrue("disabled pair too low ($disabled) in Porcelain Dim", disabled >= 4.0)
        installDisplayMode(ThemeMode.DARK)
    }
}
