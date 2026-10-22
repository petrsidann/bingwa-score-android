package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.components.IosMaterial
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BrandBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.IosBlue
import com.bingwascore.app.ui.theme.PorcelainBg
import com.bingwascore.app.ui.theme.PorcelainCard
import com.bingwascore.app.ui.theme.PorcelainSeparator
import com.bingwascore.app.ui.theme.PorcelainText
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
 * Stage 10 — iOS design system laws:
 *  1. Exactly two themes; retired values land on Obsidian.
 *  2. Porcelain tokens are iMessage-grade exact hex.
 *  3. Statuses identical in both themes; CTA is brand blue + white ink.
 *  4. Disabled pair clears AA in both themes.
 *  5. Nothing in the palette is orange/amber.
 */
class U4ThemesTest {

    private fun argb(c: Color): Int = c.toArgb()

    @Test
    fun twoThemesOnly() {
        // Stage 22 — three themes now: Obsidian, Porcelain, Porcelain Dim.
        assertEquals(3, ThemeMode.entries.size)
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("GRAYSCALE"))
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("SILICA"))
    }

    @Test
    fun porcelainTokensAreIMessageGrade() {
        // Stage 21 — Porcelain Dim rebalance: glare-free, ~15% darker, AA kept.
        assertEquals(0xFFE2E4E8.toInt(), argb(PorcelainBg))
        assertEquals(0xFFF7F8FA.toInt(), argb(PorcelainCard))
        assertEquals(0xFF16181D.toInt(), argb(PorcelainText))
        assertEquals(0xFF007AFF.toInt(), argb(IosBlue))
        assertEquals(0xFF2563EB.toInt(), argb(BrandBlue))
        assertEquals(0x4A3C3C43.toInt(), argb(PorcelainSeparator))
    }

    @Test
    fun porcelainSurfacesResolveToLightTokens() {
        installDisplayMode(ThemeMode.LIGHT)
        assertEquals(argb(PorcelainBg), argb(BgBlack))
        assertEquals(argb(PorcelainCard), argb(Bubble))
        assertEquals(argb(PorcelainText), argb(TextWhite))
        assertEquals(argb(IosBlue), argb(AccentBlue))
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun statusesIdenticalInBothThemes() {
        installDisplayMode(ThemeMode.DARK)
        val darkDone = argb(StatusDone)
        val darkFailed = argb(StatusFailedTint)
        val darkQueued = argb(StatusQueued)
        installDisplayMode(ThemeMode.LIGHT)
        assertEquals(darkDone, argb(StatusDone))
        assertEquals(darkFailed, argb(StatusFailedTint))
        assertEquals(darkQueued, argb(StatusQueued))
        assertEquals(argb(SemanticBlue), argb(StatusDone))
        assertEquals(0xFFFC1E1E.toInt(), argb(StatusFailedTint))
        assertEquals(argb(SemanticGrey), argb(StatusQueued))
        // Stage 22 — Porcelain Dim DEEPENS the tints, because the shared ones
        // fall below 3:1 on the dim canvas. Queued stays neutral.
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(argb(BrandBlue), argb(StatusDone))
        assertEquals(0xFFC42B1F.toInt(), argb(StatusFailedTint))
        assertEquals(argb(SemanticGrey), argb(StatusQueued))
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun bothThemesKeepTheBrandCta() {
        installDisplayMode(ThemeMode.DARK)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        installDisplayMode(ThemeMode.LIGHT)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        assertEquals(argb(TextWhite), argb(CtaInk))
        // Stage 22 — Porcelain Dim paints its blue chip with white ink.
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(argb(AccentBlue), argb(CtaFill))
        assertEquals(0xFFFFFFFF.toInt(), argb(CtaInk))
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun iosMaterialBlurRadius() {
        assertEquals(24, IosMaterial.BAR_BLUR.value.toInt())
    }

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
        listOf(
            ThemeMode.DARK to Color(0xFF0B0E15),
            ThemeMode.LIGHT to PorcelainBg,
            // Stage 22 — the dim canvas is darker, so the dim pair must clear AA
            // on ITS canvas, not on porcelain's.
            ThemeMode.PORCELAIN_DIM to Color(0xFFC9CED6)
        ).forEach { (mode, canvas) ->
            installDisplayMode(mode)
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
        listOf(ThemeMode.DARK, ThemeMode.LIGHT, ThemeMode.PORCELAIN_DIM).forEach { mode ->
            installDisplayMode(mode)
            val tokens = listOf(AccentBlue, CtaFill, StatusDone, StatusFailedTint, StatusQueued)
            tokens.forEach { token ->
                assertFalse("orange/amber token leaked: $token", isOrangeAmber(token))
            }
        }
        installDisplayMode(ThemeMode.DARK)
    }
}
