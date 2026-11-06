package com.bingwascore.app.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 55 — glass spinner. Replaces [androidx.compose.material3.CircularProgressIndicator].
 *
 * 24dp ring, 2.5dp stroke, 270-degree sweeping arc, rotation 900ms Linear
 * (rotation only — Linear is permitted here), pulse glow alpha 0.4->0.8 spring.
 * Inline actions ONLY: lists must use [SkeletonLoader], never a bare spinner.
 */
@Composable
fun GlassSpinner(
    modifier: Modifier = Modifier,
    color: Color = DesignTokens.Color.Brand.Primary
) {
    val transition = rememberInfiniteTransition()
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = DesignTokens.Motion.SpinnerRotationDuration.toInt(),
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "GlassSpinnerRotation"
    )
    val glow by transition.animateFloat(
        initialValue = DesignTokens.Motion.SpinnerGlowMinAlpha,
        targetValue = DesignTokens.Motion.SpinnerGlowMaxAlpha,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = DesignTokens.Motion.SpinnerRotationDuration.toInt(),
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "GlassSpinnerGlow"
    )
    val density = LocalDensity.current
    val strokeWidth = with(density) { 2.5.dp.toPx() }
    val ringSize = 24.dp

    Canvas(
        modifier = modifier
            .size(ringSize)
            .graphicsLayer { rotationZ = rotation },
        onDraw = {
            val cx = size.width / 2f
            val cy = size.height / 2f
            val radius = (size.minDimension - strokeWidth) / 2f
            drawArc(
                brush = SolidColor(color.copy(alpha = glow)),
                startAngle = -90f,
                sweepAngle = 270f,
                useCenter = false,
                topLeft = Offset(cx - radius, cy - radius),
                size = Size(radius * 2f, radius * 2f),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth, cap = androidx.compose.ui.graphics.StrokeCap.Round)
            )
        }
    )
}
