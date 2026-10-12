package com.bingwascore.app.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.domain.MyScore
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen

/**
 * Stage 15 — "My Score" analytics card (bolt-in-trophy logo). One honest,
 * actionable read of the last 24 hours: top offers (most→least), the busiest
 * and quietest hour ranges, a success-rate ring and the best weekday.
 */
@Composable
fun MyScoreCard(viewModel: MyScoreViewModel = hiltViewModel()) {
    val score by viewModel.score.collectAsStateWithLifecycle()

    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BoltTrophyLogo(size = 34.dp)
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("My Score", color = TextWhite, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Text("Last 24 hours", color = TextFaint, fontSize = 11.sp)
            }
            SuccessRateRing(rate = score.successRate)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (score.topOffers.isEmpty() && score.successRate == null) {
            Text(
                "No activity in the last 24 hours yet — your score builds as bundles complete.",
                color = TextFaint,
                fontSize = 13.sp
            )
            return@BubbleCard
        }

        // Top offers, most → least.
        if (score.topOffers.isNotEmpty()) {
            SectionLabel("Top offers")
            score.topOffers.take(3).forEach { (offer, count) ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(offer, color = TextWhite, fontSize = 13.sp, modifier = Modifier.weight(1f), maxLines = 1)
                    Text(
                        "$count sold",
                        color = TextWhite.copy(alpha = 0.6f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        // Busiest + quietest hour ranges side by side.
        Row(modifier = Modifier.fillMaxWidth()) {
            HourPanel("Busiest", score.busiestHours, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(10.dp))
            HourPanel("Quietest", score.quietestHours, Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Bubble)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Best weekday", color = TextFaint, fontSize = 12.sp, modifier = Modifier.weight(1f))
            Text(
                score.bestWeekday?.let { MyScore.weekdayName(it) } ?: "—",
                color = TextWhite,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(text, color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
private fun HourPanel(title: String, buckets: List<MyScore.HourBucket>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Bubble)
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Text(title, color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(6.dp))
        if (buckets.isEmpty()) {
            Text("—", color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
        } else {
            buckets.forEach { bucket ->
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)) {
                    Text(bucket.label, color = TextWhite, fontSize = 12.sp, modifier = Modifier.weight(1f))
                    Text("${bucket.count}", color = TextWhite.copy(alpha = 0.6f), fontSize = 12.sp)
                }
            }
        }
    }
}

/** A success-rate ring: brand-blue arc over a track, whole-percent in the middle. */
@Composable
private fun SuccessRateRing(rate: Float?, size: Dp = 52.dp) {
    val sweep = ((rate ?: 0f).coerceIn(0f, 1f)) * 360f
    Box(modifier = Modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(size)) {
            val stroke = 6.dp.toPx()
            val inset = stroke / 2
            val arcSize = Size(this.size.width - stroke, this.size.height - stroke)
            drawArc(
                color = Raised,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(inset, inset),
                size = arcSize,
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )
            if (sweep > 0f) {
                drawArc(
                    color = AccentBlue,
                    startAngle = -90f,
                    sweepAngle = sweep,
                    useCenter = false,
                    topLeft = Offset(inset, inset),
                    size = arcSize,
                    style = Stroke(width = stroke, cap = StrokeCap.Round)
                )
            }
        }
        Text(
            MyScore.successRateLabel(rate),
            color = TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Stage 15 — the bolt-in-trophy logo: a lightning bolt punched through a small
 * trophy cup. Drawn with a Path so it stays crisp at any size and needs no asset.
 */
@Composable
private fun BoltTrophyLogo(size: Dp) {
    Box(modifier = Modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(size)) {
            val w = this.size.width
            val h = this.size.height
            // Trophy cup (top half): rim + bowl.
            val cup = Path().apply {
                moveTo(w * 0.24f, h * 0.24f)
                lineTo(w * 0.76f, h * 0.24f)
                lineTo(w * 0.70f, h * 0.56f)
                quadraticBezierTo(w * 0.5f, h * 0.66f, w * 0.30f, h * 0.56f)
                close()
            }
            drawPath(cup, color = AccentBlue)
            // Stem + base.
            drawRect(
                color = AccentBlue,
                topLeft = Offset(w * 0.46f, h * 0.66f),
                size = Size(w * 0.08f, h * 0.18f)
            )
            drawRect(
                color = AccentBlue,
                topLeft = Offset(w * 0.32f, h * 0.84f),
                size = Size(w * 0.36f, h * 0.06f)
            )
            // Lightning bolt punched through the cup.
            val bolt = Path().apply {
                moveTo(w * 0.56f, h * 0.20f)
                lineTo(w * 0.40f, h * 0.50f)
                lineTo(w * 0.50f, h * 0.50f)
                lineTo(w * 0.44f, h * 0.74f)
                lineTo(w * 0.62f, h * 0.44f)
                lineTo(w * 0.52f, h * 0.44f)
                lineTo(w * 0.60f, h * 0.20f)
                close()
            }
            drawPath(bolt, color = TickGreen)
        }
    }
}

