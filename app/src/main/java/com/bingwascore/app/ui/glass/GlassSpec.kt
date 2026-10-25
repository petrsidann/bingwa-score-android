package com.bingwascore.app.ui.glass

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Stage 26 — Frosted Glass System Tokens.
 *
 * Per-theme GlassSpec:
 * - Scrim alpha 0.62 (Obsidian: near-black frost; Porcelain Dim: white frost 0.55)
 * - Backdrop blur 28dp
 * - 1dp inner top border highlight (white 10%)
 * - Outer shadow elevation 12dp radius 24dp alpha 0.35
 * NO clear/transparent glass anywhere.
 */
object GlassSpec {
    val backdropBlurDp: Dp = 28.dp
    const val BACKDROP_BLUR_INT: Int = 28

    const val SCRIM_ALPHA_OBSIDIAN: Float = 0.62f
    const val SCRIM_ALPHA_PORCELAIN_DIM: Float = 0.55f

    const val INNER_TOP_HIGHLIGHT_ALPHA: Float = 0.10f
    val INNER_TOP_HIGHLIGHT_WIDTH: Dp = 1.dp

    val OUTER_SHADOW_ELEVATION: Dp = 12.dp
    val OUTER_SHADOW_RADIUS: Dp = 24.dp
    const val OUTER_SHADOW_ALPHA: Float = 0.35f

    fun scrimAlpha(isPorcelain: Boolean): Float =
        if (isPorcelain) SCRIM_ALPHA_PORCELAIN_DIM else SCRIM_ALPHA_OBSIDIAN

    fun scrimColor(isPorcelain: Boolean): Color =
        if (isPorcelain) {
            Color.White.copy(alpha = SCRIM_ALPHA_PORCELAIN_DIM)
        } else {
            Color(0xFF0B0E15).copy(alpha = SCRIM_ALPHA_OBSIDIAN)
        }

    fun innerTopHighlightColor(): Color = Color.White.copy(alpha = INNER_TOP_HIGHLIGHT_ALPHA)
}
