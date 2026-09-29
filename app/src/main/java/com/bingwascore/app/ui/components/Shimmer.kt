package com.bingwascore.app.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import com.bingwascore.app.ui.theme.Motion

/**
 * Moving white highlight that sweeps left→right infinitely. Apply to a balance
 * value while loading, or to chart bars on first render — the native
 * "content is warming up" feel.
 */
@Composable
fun Modifier.shimmer(): Modifier {
    val transition = rememberInfiniteTransition(label = "shimmer")
    var size by remember { mutableStateOf(IntSize(0, 0)) }
    val x by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(Motion.SHIMMER), RepeatMode.Restart),
        label = "shimmerOffset"
    )

    val width = if (size.width > 0) size.width.toFloat() else 1f

    return this
        .onSizeChanged { size = it }
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.White.copy(alpha = 0.35f),
                    Color.Transparent
                ),
                // Highlight sweeps from off-screen-left to off-screen-right
                start = Offset((x * 2f - 1f) * width, 0f),
                end = Offset(x * 2f * width, 0f)
            )
        )
}

/**
 * Parity E convenience overload: shimmer only while [visible] is true, so a
 * loading flag can be piped straight into a modifier chain:
 * `Modifier.shimmer(isLoading)`.
 */
@Composable
fun Modifier.shimmer(visible: Boolean): Modifier = if (visible) shimmer() else this

/**
 * Parity E skeleton block: a soft frosted slab with the shimmer sweep on top.
 * Stack a few of these inside a [GlassCard] to build a list skeleton while the
 * real rows are still loading.
 */
@Composable
fun ShimmerBlock(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 12.dp
) {
    Box(
        modifier = modifier
            .height(14.dp)
            .clip(RoundedCornerShape(cornerRadius))
            .background(Color.White.copy(alpha = 0.08f))
            .shimmer()
    )
}
