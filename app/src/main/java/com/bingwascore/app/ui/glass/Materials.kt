package com.bingwascore.app.ui.glass

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.components.Silica
import com.bingwascore.app.ui.theme.isSilica

/**
 * STAGE 18 — the iOS material engine.
 *
 * One modifier, [iosMaterial], that renders an Apple-style vibrancy pane:
 *
 *  1. a real backdrop blur at [Materials.BLUR] (24dp) where the platform can
 *     do one (API 31+),
 *  2. a translucent scrim fill below API 31 so the pane still reads as glass,
 *  3. a vibrancy tint in the 8-12% white band over the pane,
 *  4. a ColorMatrix that lifts saturation x[SATURATION] and contrast
 *     x[CONTRAST] on everything painted through the layer — the "vibrant" look
 *     that makes content behind iOS bars pop through them.
 *
 * Chrome-only: this is for the floating pill nav (both themes get the pane;
 * Obsidian falls back to the scrim), drawer, sheets and scrolling top bars.
 * Content rows never carry it, and it must never be nested inside another
 * blurred surface — one blur per visual stack, radius <= 28dp.
 */
object Materials {

    /** The one blur radius of the engine: 24dp, within the <=28dp chrome budget. */
    val BLUR: Dp = 24.dp

    /** Colour-matrix saturation boost (law: 1.2). */
    const val SATURATION: Float = 1.2f

    /** Colour-matrix contrast boost (law: 1.1). */
    const val CONTRAST: Float = 1.1f

    /** Vibrancy tint alpha band: 8-12% white. */
    const val VIBRANCY_ALPHA_MIN: Float = 0.08f
    const val VIBRANCY_ALPHA_MAX: Float = 0.12f

    /** The default vibrancy tint: 10% white — dead centre of the band. */
    val VibrancyTint: Color = Color.White.copy(alpha = 0.10f)

    /** Scrim fallback under API 31: same family as the Silica glass fill (18%). */
    val ScrimFallback: Color = Color.White.copy(alpha = 0.18f)

    /**
     * The 4x5 colour-matrix values (row-major, Android order) that combine
     * contrast about mid-grey with the saturation lift:
     *   out = S * (C * (in - 0.5) + 0.5)  in luminance-preserving form.
     */
    fun colorMatrixValues(): FloatArray {
        val c = CONTRAST
        val s = SATURATION
        val bias = (1f - c) / 2f          // contrast shift around mid-grey
        val cs = c * s                    // combined diagonal scale
        // Saturation matrix applied on top of the contrast scale:
        //   M = satMatrix * diag(c,c,c); offset = sat * (bias + 0.5*(1-c)) ... simplified:
        val lr = 0.2126f
        val lg = 0.7152f
        val lb = 0.0722f
        val off = bias + 0.5f             // pre-shift constant per channel
        fun row(sr: Float, sg: Float, sb: Float) = floatArrayOf(
            cs * (sr + (1f - s)), cs * sg, cs * sb, 0f, cs * off * (if (sr > 0f) 1f else 1f) * 0f +
                (off * cs - 0.5f * cs * 1f) * 0f + 0f
        )
        // Build explicitly instead: out_r = cs*((1-s)*L_r*in + s*in_r) + cs*bias... keep it readable:
        val k = 1f - s
        val m00 = cs * (lr * k + s); val m01 = cs * lg * k; val m02 = cs * lb * k
        val m10 = cs * lr * k;       val m11 = cs * (lg * k + s); val m12 = cs * lb * k
        val m20 = cs * lr * k;       val m21 = cs * lg * k;       val m22 = cs * (lb * k + s)
        val o = cs * bias            // same shift on every channel (contrast about 0.5)
        return floatArrayOf(
            m00, m01, m02, 0f, o,
            m10, m11, m12, 0f, o,
            m20, m21, m22, 0f, o,
            0f,  0f,  0f,  1f, 0f,
        )
    }
}

/**
 * The iOS material pane modifier — the Stage 18 engine. On Silica it paints:
 * clip -> 24dp blur (API 31+) or scrim fill (below) -> vibrancy tint ->
 * gradient hairline, with the 1.2/1.1 colour matrix on the render layer.
 * In Obsidian/Grayscale it returns an opaque [base] fill (no blur, no glass —
 * the guardrail that keeps blur exclusive to Silica).
 */
@Composable
fun Modifier.iosMaterial(
    shape: Shape,
    base: Color,
    tint: Color = Materials.VibrancyTint,
    hairline: Boolean = true
): Modifier {
    check(tint.alpha >= Materials.VIBRANCY_ALPHA_MIN &&
          tint.alpha <= Materials.VIBRANCY_ALPHA_MAX) {
        "Stage 18: vibrancy tint must sit in the 8-12% white band"
    }
    var m: Modifier = this.clip(shape)
    if (isSilica) {
        if (Silica.canBlur) {
            // Real backdrop blur on the pane itself (chrome layer only).
            m = m.graphicsLayer {
                colorMatrix = android.graphics.ColorMatrix().apply {
                    set(*Materials.colorMatrixValues())
                }
            }.blur(Materials.BLUR)
        } else {
            // API < 31 cannot blur: the scrim carries the glass look instead.
            m = m.background(Materials.ScrimFallback)
        }
        m = m.background(tint)
        if (hairline) {
            m = m.border(1.dp, com.bingwascore.app.ui.theme.glassBorderBrush(), shape)
        }
    } else {
        m = m.background(base)
    }
    return m
}
