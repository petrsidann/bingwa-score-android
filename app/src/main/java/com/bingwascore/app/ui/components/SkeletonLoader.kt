package com.bingwascore.app.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 48 — Skeleton loader.
 *
 * Shimmering placeholder built from [DesignTokens.Color.Obsidian] card/elevated
 * tokens, animated with an [InfiniteTransition].
 */
@Composable
fun SkeletonLoader(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(DesignTokens.Shape.RadiusSm),
    height: Dp = 16.dp
) {
    val transition = rememberInfiniteTransition()
    var size by remember { mutableStateOf(IntSize(0, 0)) }
    val x by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = DesignTokens.Motion.DurationNormal.toInt(),
                delayMillis = DesignTokens.Motion.DurationFast.toInt()
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "SkeletonShimmer"
    )
    val width = if (size.width > 0) size.width.toFloat() else 1f
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape)
            .onSizeChanged { size = it }
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        DesignTokens.Color.Obsidian.Card,
                        DesignTokens.Color.Obsidian.Elevated,
                        DesignTokens.Color.Obsidian.Card
                    ),
                    start = Offset((x * 2f - 1f) * width, 0f),
                    end = Offset(x * 2f * width, 0f)
                )
            )
    )
}
