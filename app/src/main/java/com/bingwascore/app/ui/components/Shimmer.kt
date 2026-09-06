package com.bingwascore.app.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged

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
        animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Restart),
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
