package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BrandBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.PorcelainDimAccent
import com.bingwascore.app.ui.theme.PorcelainDimBg
import com.bingwascore.app.ui.theme.PorcelainDimCard
import com.bingwascore.app.ui.theme.PorcelainDimText
import com.bingwascore.app.ui.theme.SemanticBlue
import com.bingwascore.app.ui.theme.SemanticGrey
import com.bingwascore.app.ui.theme.StatusDone
import com.bingwascore.app.ui.theme.StatusFailedTint
import com.bingwascore.app.ui.theme.StatusQueued
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.installDisplayMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 24 — iOS design system laws:
 *  1. Exactly two themes; retired values land on Porcelain Dim.
 *  2. Statuses identical in both themes; CTA is brand blue + white ink.
 *  3. Disabled pair clears AA in both themes.
 *  4. Nothing in the palette is orange/amber.
 */
class U4ThemesTest {

    @Test
    fun twoThemesOnly() {
        assertEquals(2, ThemeMode.entries.size)
        assertEquals(ThemeMode.PORCELAIN_DIM, ThemeMode.fromValue("GRAYSCALE"))
        assertEquals(ThemeMode.PORCELAIN_DIM, ThemeMode.fromValue("SILICA"))
    }

    @Test
    fun statusesIdenticalInBothThemes() {
        installDisplayMode(ThemeMode.DARK)
        val darkDone = StatusDone
        val darkFailed = StatusFailedTint
        val darkQueued = StatusQueued
        assertEquals(argb(SemanticBlue), argb(darkDone))
        assertEquals(0xFFEF4444.toInt(), argb(darkFailed))
        assertEquals(argb(SemanticGrey), argb(darkQueued))
        // Stage 22 — Porcelain Dim DEEPENS the tints, because the shared ones
        // fall below 3:1 on the dim canvas. Queued stays neutral.
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(argb(BrandBlue), argb(StatusDone))
        assertEquals(0xFFDC2626.toInt(), argb(StatusFailedTint))
        assertEquals(argb(SemanticGrey), argb(StatusQueued))
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun bothThemesKeepTheBrandCta() {
        installDisplayMode(ThemeMode.DARK)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        assertEquals(0xFFFFFFFF.toInt(), argb(CtaInk))
        installDisplayMode(ThemeMode.DARK)
    }

    private fun argb(c: Color): Int = c.toArgb()

    private fun isOrangeAmber(c: Color): Boolean =
        c.red > c.green && c.green > c.blue && c.red > 0.5f && (c.red - c.blue) > 0.25f

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
    fun disabledPairClearsAaInBothThemes() {
        listOf(ThemeMode.DARK, ThemeMode.PORCELAIN_DIM).forEach { mode ->
            installDisplayMode(mode)
            val canvas = BgBlack
            val fill = over(DisabledFill, canvas)
            val ink = over(DisabledInk, fill)
            val ratio = contrast(ink, fill)
            assertTrue(
                "disabled ink/fill contrast $ratio too low in $mode",
                ratio >= 4.0
            )
        }
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun paletteHasNoOrangeOrAmber() {
        listOf(ThemeMode.DARK, ThemeMode.PORCELAIN_DIM).forEach { mode ->
            installDisplayMode(mode)
            val tokens = listOf(AccentBlue, CtaFill, StatusDone, StatusFailedTint, StatusQueued)
            tokens.forEach { token ->
                assertFalse("orange/amber token leaked: $token", isOrangeAmber(token))
            }
        }
        installDisplayMode(ThemeMode.DARK)
    }
}
