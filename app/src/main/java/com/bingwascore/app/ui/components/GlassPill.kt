package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 52 — premium glass pill.
 *
 * A GlassCard sibling: no blur (blur is sanctioned to ui/glass only), a
 * configurable fill, an optional hairline border, a Level1 shadow stack and an
 * optional spring press scale. Every surface reads from DesignTokens — zero
 * literals.
 */
@Composable
fun GlassPill(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(DesignTokens.Shape.RadiusFull),
    fill: Color = DesignTokens.Color.Card,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Transparent,
    elevation: List<DesignTokens.Elevation.Layer> = DesignTokens.Elevation.Level1,
    baseScale: Float = 1f,
    pressScale: Float = 1f,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) baseScale * pressScale else baseScale,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "GlassPillScale"
    )

    val density = LocalDensity.current
    val radiusPx = with(density) { DesignTokens.Shape.RadiusMd.toPx() }

    Box(
        modifier = modifier
            .clip(shape)
            .drawBehind {
                val cornerRadius = CornerRadius(radiusPx, radiusPx)
                for (layer in elevation) {
                    val offsetY = with(density) { layer.offsetY.toPx() }
                    withTransform({ translate(0f, offsetY) }) {
                        drawRoundRect(
                            brush = SolidColor(layer.color),
                            cornerRadius = cornerRadius
                        )
                    }
                }
            }
            .fillMaxSize()
            .background(fill)
            .let { if (borderWidth > 0.dp) it.border(borderWidth, borderColor, shape) else it }
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .let {
                if (onClick != null) {
                    it.clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        enabled = enabled,
                        onClick = onClick
                    )
                } else it
            }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { content() }
    }
}
