package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import com.bingwascore.app.ui.theme.DesignTokens
import kotlin.math.pow
import org.junit.Test
import org.junit.Assert.assertTrue

class ContrastGuardTest {
    private fun lum(c: Color): Float {
        fun ch(x: Float) = if (x <= 0.03928f) x / 12.92f else ((x + 0.055f) / 1.055f).pow(2.4f)
        return 0.2126f * ch(c.red) + 0.7152f * ch(c.green) + 0.0722f * ch(c.blue)
    }
    private fun ratio(a: Color, b: Color): Float {
        val l1 = maxOf<Float>(lum(a), lum(b)); val l2 = minOf<Float>(lum(a), lum(b))
        return (l1 + 0.05f) / (l2 + 0.05f)
    }
    @Test fun obsidian_pairs() { with(DesignTokens.Role.Obsidian) {
        assertTrue(ratio(textPrimary, bg) >= 4.5f); assertTrue(ratio(textPrimary, card) >= 4.5f)
        assertTrue(ratio(textPrimary, elevated) >= 4.5f); assertTrue(ratio(textSecondary, bg) >= 4.5f)
        assertTrue(ratio(keypadDigit, keypadKey) >= 4.5f); assertTrue(ratio(onBrand, brand) >= 4.5f)
        assertTrue(ratio(onSuccess, success) >= 4.5f); assertTrue(ratio(onError, error) >= 4.5f) } }
    @Test fun dim_pairs() { with(DesignTokens.Role.Dim) {
        assertTrue(ratio(textPrimary, bg) >= 4.5f); assertTrue(ratio(textPrimary, card) >= 4.5f)
        assertTrue(ratio(textPrimary, elevated) >= 4.5f); assertTrue(ratio(textSecondary, bg) >= 4.5f)
        assertTrue(ratio(keypadDigit, keypadKey) >= 4.5f); assertTrue(ratio(onBrand, brand) >= 4.5f)
        assertTrue(ratio(onSuccess, success) >= 4.5f); assertTrue(ratio(onError, error) >= 4.5f) } }
}
