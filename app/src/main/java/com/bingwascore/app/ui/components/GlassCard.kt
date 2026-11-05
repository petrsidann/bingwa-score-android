package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 48 — Glass card.
 *
 * A blurred, elevated surface with a top highlight (Vercel-style layered shadow
 * stack, Level 2). Blur is gated behind API 31 (RenderEffect); older APIs fall
 * back to the flat card surface so the card never crashes on minSdk 26.
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd),
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current
    Box(
        modifier = modifier
            .clip(shape)
            .drawBehind {
                val radiusPx = with(density) { DesignTokens.Shape.RadiusMd.toPx() }
                for (layer in DesignTokens.Elevation.Level2) {
                    val offsetY = with(density) { layer.offsetY.toPx() }
                    withTransform({ translate(0f, offsetY) }) {
                        drawRoundRect(
                            brush = SolidColor(layer.color),
                            cornerRadius = CornerRadius(radiusPx, radiusPx)
                        )
                    }
                }
            }
    ) {
        // Blurred glass surface; content stays crisp on top.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
                .background(DesignTokens.Color.Card)
                .let { it.blurIfSupported() }
        )
        // Top border highlight: 1dp white 10%.
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White.copy(alpha = 0.1f))
        )
        Box(modifier = Modifier.fillMaxSize()) { content() }
    }
}

/** Blur render effect (API 31+). Flat fallback on older APIs. */
private fun Modifier.blurIfSupported(): Modifier =
    if (Build.VERSION.SDK_INT >= 31) this.blur(DesignTokens.Glass.BlurRadius) else this
