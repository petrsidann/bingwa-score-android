package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.TealBlue

/**
 * Animated progress ring — the sweep animates 0 → [progress] with a soft
 * spring, gradient stroke EmeraldGreen→TealBlue, rounded caps.
 *
 * Used in the Home hero card to visualise weekly-goal progress.
 *
 * @param progress 0f → 1f
 * @param size     Outer diameter of the ring (default 120 dp)
 */
@Composable
fun AnimatedRing(
    progress: Float,
    modifier: Modifier = Modifier,
    size: Dp = 120.dp
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "ringProgress"
    )

    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 16.dp.toPx()
        val inset = strokeWidth / 2f
        val diameter = this.size.minDimension - strokeWidth

        // Track — faint
        drawArc(
            color = androidx.compose.ui.graphics.Color(0x1FFFFFFF),
            startAngle = -90f,
            sweepAngle = 360f,
            useCenter = false,
            topLeft = Offset(inset, inset),
            size = Size(diameter, diameter),
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )

        // Progress — gradient
        if (animatedProgress > 0f) {
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(EmeraldGreen, TealBlue),
                    center = Offset(inset + diameter / 2f, inset + diameter / 2f)
                ),
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                topLeft = Offset(inset, inset),
                size = Size(diameter, diameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }
    }
}
