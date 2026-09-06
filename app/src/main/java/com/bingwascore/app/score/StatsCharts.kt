package com.bingwascore.app.score

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.delay

/**
 * Canvas line chart of the last 7 days of commission. Gradient stroke with a
 * soft area fill underneath; the draw animates in with [animateFloat].
 */
@Composable
fun CommissionLineChart(
    values: List<Double>,
    modifier: Modifier = Modifier
) {
    val maxVal = (values.maxOrNull() ?: 1.0).coerceAtLeast(1.0)
    var started by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (started) 1f else 0f,
        animationSpec = tween(900),
        label = "chartDraw"
    )

    LaunchedEffect(Unit) { delay(150); started = true }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        val w = size.width * progress
        val h = size.height
        val stepX = if (values.size > 1) w / (values.size - 1) else w
        val points = values.mapIndexed { i, v ->
            Offset(x = i * stepX, y = h - (v / maxVal).toFloat() * h)
        }
        if (points.size < 2) return@Canvas

        // Soft area fill
        val areaPath = Path().apply {
            moveTo(points.first().x, h)
            points.forEach { lineTo(it.x, it.y) }
            lineTo(points.last().x, h)
            close()
        }
        drawPath(
            path = areaPath,
            brush = Brush.verticalGradient(
                colors = listOf(TealBlue.copy(alpha = 0.25f), Color.Transparent),
                startY = 0f, endY = h
            )
        )

        // Gradient stroke
        val linePath = Path().apply {
            points.forEachIndexed { i, p -> if (i == 0) moveTo(p.x, p.y) else lineTo(p.x, p.y) }
        }
        drawPath(
            path = linePath,
            brush = Brush.horizontalGradient(listOf(EmeraldGreen, TealBlue)),
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
        )

        // Dots
        points.forEach { p ->
            drawCircle(color = White, radius = 4.dp.toPx(), center = p)
        }
    }
}

/**
 * Success-rate donut. A faint track with a gradient sweep showing the rate;
 * the percentage is centered inside.
 */
@Composable
fun SuccessRateDonut(
    rate: Float,
    modifier: Modifier = Modifier
) {
    val clamped = rate.coerceIn(0f, 1f)
    var started by remember { mutableStateOf(false) }
    val sweep by animateFloatAsState(
        targetValue = if (started) clamped else 0f,
        animationSpec = tween(900),
        label = "donutDraw"
    )

    LaunchedEffect(Unit) { delay(150); started = true }

    Box(modifier = modifier.size(120.dp), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(120.dp)) {
            val stroke = 14.dp.toPx()
            val r = (this.size.minDimension - stroke) / 2f
            val center = Offset(this.size.width / 2f, this.size.height / 2f)
            drawCircle(
                color = Color(0x1FFFFFFF),
                radius = r,
                center = center,
                style = Stroke(width = stroke)
            )
            if (sweep > 0f) {
                drawArc(
                    brush = Brush.sweepGradient(listOf(EmeraldGreen, TealBlue), center),
                    startAngle = -90f,
                    sweepAngle = 360f * sweep,
                    useCenter = false,
                    style = Stroke(width = stroke, cap = StrokeCap.Round)
                )
            }
        }
        Text(
            "${(clamped * 100).toInt()}%",
            color = White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
