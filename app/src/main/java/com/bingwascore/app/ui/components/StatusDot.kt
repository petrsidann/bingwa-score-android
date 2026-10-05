package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.Motion

/**
 * POLISH P2 — the status dot.
 *
 * One glance should tell the agent whether work is *done*, *waiting*, or
 * *broken*, from across a shop counter: a blue dot with a soft halo, a dim grey
 * dot that is switched off, or red. The dot is a light, not a label — the
 * wording next to it stays the source of truth.
 *
 * [lit] fades over [Motion.DOT_FADE] ms so a transaction that completes while
 * the agent is watching **lights up** instead of popping, which is why the caller
 * pairs it with a haptic tick at the moment the status flips.
 */
@Composable
fun StatusDot(
    color: Color,
    lit: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 10.dp
) {
    val glow by animateFloatAsState(
        targetValue = if (lit) 1f else 0f,
        animationSpec = tween(Motion.DOT_FADE),
        label = "statusDotGlow"
    )

    Box(modifier = modifier.size(size)) {
        Canvas(modifier = Modifier.size(size)) {
            val radius = this.size.minDimension / 2f
            val center = Offset(this.size.width / 2f, this.size.height / 2f)

            // Soft halo: a radial fade in the same hue, so the dot reads as a
            // light source rather than a flat circle pasted on the card.
            if (glow > 0.01f) {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(color.copy(alpha = 0.42f * glow), Color.Transparent),
                        center = center,
                        radius = radius * 2.1f
                    ),
                    radius = radius * 2.1f,
                    center = center
                )
            }

            // Off state keeps the footprint so nothing on the row ever shifts.
            val core = if (lit) color else color.copy(alpha = 0.32f)
            drawCircle(color = core, radius = radius * 0.62f, center = center)
        }
    }
}
