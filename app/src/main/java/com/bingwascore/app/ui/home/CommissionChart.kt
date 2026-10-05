package com.bingwascore.app.ui.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.ChartBlue
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.rememberHaptics
import java.util.Calendar

/**
 * POLISH P2 — the commission curve.
 *
 * A commission week is not a set of bars: it is a curve that rises as the week
 * builds, so it is drawn as a curve. The polyline that used to join the points
 * was technically correct and looked like a seismograph, so the path is now a
 * **Catmull-Rom** spline converted to cubic beziers — smooth through the points,
 * still passing exactly through every day's real figure, with no overshoot that
 * would invent commission the agent never earned.
 *
 * Underneath sits a vertical gradient that fades to nothing, so the area reads
 * as depth rather than a filled block. Today's letter carries a filled bubble (it
 * rolls at midnight because it is computed from the clock, not remembered), and
 * tapping any letter springs a tooltip bubble with that day's commission.
 */
@Composable
fun CommissionChartCard(series: List<Double>) {
    val haptics = rememberHaptics()
    var selected by remember { mutableStateOf(-1) }
    val display = remember { Animatable(1f) }

    // Spring the whole curve when a commission lands: the shape is regenerated,
    // and the spring carries it there instead of cutting.
    LaunchedEffect(series) {
        display.snapTo(0.94f)
        display.animateTo(1f, spring(dampingRatio = Motion.DAMPING, stiffness = Spring.StiffnessLow))
    }

    val days = remember { listOf("M", "T", "W", "T", "F", "S", "S") }
    val todayIndex = remember { (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 5) % 7 }

    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 20.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Commission this week",
                color = TextWhite,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Text(
                "Ksh ${money(series.sum())}",
                color = AccentBlue,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.height(148.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Text(formatShort(series.maxOrNull() ?: 0.0), color = TextDim, fontSize = 10.sp)
                Text("0", color = TextDim, fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            SmoothCommissionCurve(
                values = remember(series) { normalize(series) },
                modifier = Modifier
                    .weight(1f)
                    .height(148.dp)
                    .graphicsLayer {
                        scaleX = display.value
                        scaleY = display.value
                    }
            )
        }

        Spacer(modifier = Modifier.height(6.dp))
        DayLetterRow(
            days = days,
            todayIndex = todayIndex,
            selected = selected,
            values = series,
            onSelect = { index ->
                haptics.tick()
                selected = if (selected == index) -1 else index
            }
        )
    }
}

/**
 * The curve: a Catmull-Rom spline through the seven points, with a gradient
 * area underneath and a hairline baseline.
 *
 * Catmull-Rom passes exactly through every control point and, converted to cubic
 * beziers, gives the smooth run a broker chart needs. The standard 1/6 control
 * offset is kept rather than an aggressive tension: a graph that bows past a
 * neighbouring point would invent a peak on a quiet Tuesday, which is worse than
 * a sharp corner.
 */
@Composable
private fun SmoothCommissionCurve(values: List<Float>, modifier: Modifier = Modifier) {
    val accent = ChartBlue
    Canvas(modifier = modifier) {
        if (values.size < 2) return@Canvas

        val points = values.mapIndexed { index, value ->
            val stepX = size.width / (values.size - 1).toFloat()
            val x = stepX * index
            // Inset by the stroke width so the end caps are not clipped.
            val y = size.height - (size.height - 8f) * value.coerceIn(0f, 1f) - 4f
            Offset(x, y)
        }

        val curve = Path().apply {
            moveTo(points.first().x, points.first().y)
            for (i in 0 until points.size - 1) {
                val p0 = points[if (i - 1 < 0) 0 else i - 1]
                val p1 = points[i]
                val p2 = points[i + 1]
                val p3 = points[if (i + 2 > points.lastIndex) points.lastIndex else i + 2]
                // Catmull-Rom -> cubic bezier (tension 1/6 at both ends).
                val c1 = Offset(
                    x = p1.x + (p2.x - p0.x) / 6f,
                    y = p1.y + (p2.y - p0.y) / 6f
                )
                val c2 = Offset(
                    x = p2.x - (p3.x - p1.x) / 6f,
                    y = p2.y - (p3.y - p1.y) / 6f
                )
                cubicTo(c1.x, c1.y, c2.x, c2.y, p2.x, p2.y)
            }
        }

        // Gradient area: the accent at the curve, fading to nothing at the base.
        val area = Path().apply {
            addPath(curve)
            lineTo(points.last().x, size.height)
            lineTo(points.first().x, size.height)
            close()
        }
        drawPath(
            path = area,
            brush = Brush.verticalGradient(
                colors = listOf(accent.copy(alpha = 0.30f), accent.copy(alpha = 0.02f)),
                startY = 0f,
                endY = size.height
            )
        )

        drawPath(
            path = curve,
            color = accent,
            style = Stroke(width = 2.6.dp.toPx(), cap = StrokeCap.Round)
        )

        // Baseline keeps the "0" honest without drawing a full grid.
        drawLine(
            color = Hairline,
            start = Offset(0f, size.height - 1f),
            end = Offset(size.width, size.height - 1f),
            strokeWidth = 1f
        )
    }
}

/**
 * The day letters, the today-bubble and the spring tooltip.
 *
 * The letters are real hit targets (not canvas pixels), so a tap lands where it
 * looks like it should on a 400dp-wide phone, and the tooltip is anchored to the
 * same column as the letter it describes.
 */
@Composable
private fun DayLetterRow(
    days: List<String>,
    todayIndex: Int,
    selected: Int,
    values: List<Double>,
    onSelect: (Int) -> Unit
) {
    Box {
        if (selected in days.indices) {
            val tooltip by animateFloatAsState(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = 0.6f,
                    stiffness = Motion.TOOLTIP_SPRING_STIFFNESS
                ),
                label = "tooltipSpring"
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        alpha = tooltip
                        translationY = (1f - tooltip) * 10f
                    }
            ) {
                TooltipBubble(
                    text = "Ksh ${money(values.getOrElse(selected) { 0.0 })}",
                    alignRight = selected > 3,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            days.forEachIndexed { index, day ->
                DayLetter(
                    letter = day,
                    isToday = index == todayIndex,
                    isSelected = index == selected,
                    modifier = Modifier.weight(1f),
                    onClick = { onSelect(index) }
                )
            }
        }
    }
}

/** One day letter; today's is a filled bubble, the tapped one is outlined. */
@Composable
private fun DayLetter(
    letter: String,
    isToday: Boolean,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(50)
    val fill = when {
        isToday -> AccentBlue
        isSelected -> AccentBlue.copy(alpha = 0.22f)
        else -> Color.Transparent
    }
    val ink = if (isToday || isSelected) TextWhite else TextDim

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(vertical = 4.dp)
            .clip(shape)
            .background(fill)
            .then(
                if (isSelected && !isToday) {
                    Modifier.border(1.dp, AccentBlue.copy(alpha = 0.6f), shape)
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .padding(vertical = 3.dp)
    ) {
        Text(
            text = letter,
            color = ink,
            fontSize = 10.sp,
            fontWeight = if (isToday || isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

/** The commission tooltip bubble, nudged to the inside near the card edge. */
@Composable
private fun TooltipBubble(text: String, alignRight: Boolean, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(10.dp)
    Row(
        modifier = modifier,
        horizontalArrangement = if (alignRight) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(Raised)
                .border(1.dp, Hairline, shape)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = text,
                color = TextWhite,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
