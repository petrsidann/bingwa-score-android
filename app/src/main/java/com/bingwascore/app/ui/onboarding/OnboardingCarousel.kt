package com.bingwascore.app.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoMode
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.accentBrush
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * U6 — the onboarding slides. Pure data so the carousel logic is JVM-testable
 * without touching Compose icons at runtime.
 */
data class OnboardingSlideData(val title: String, val body: String)

object SnakeCarousel {

    /** Fixed three-slide set; the UI maps these to icons in order. */
    val SLIDES: List<OnboardingSlideData> = listOf(
        OnboardingSlideData(
            "Auto-pilot payments",
            "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically."
        ),
        OnboardingSlideData(
            "Smart retries & fallbacks",
            "Failed transaction? We retry with fallbacks so your customers stay happy."
        ),
        OnboardingSlideData(
            "Score, streaks & rewards",
            "Earn points for every sale, build streaks and unlock achievements as you grow."
        )
    )

    /** A drag must cross this fraction of the card width to change pages. */
    const val SWIPE_THRESHOLD_FRACTION = 0.25f

    /** The snake never wraps: clamped to [0, count-1]. */
    fun clampPage(page: Int, count: Int): Int {
        if (count <= 0) return 0
        return page.coerceIn(0, count - 1)
    }

    fun next(page: Int, count: Int): Int = clampPage(page + 1, count)

    fun previous(page: Int, count: Int): Int = clampPage(page - 1, count)

    /**
     * The settled page after a drag of [dragPx] on a card of [widthPx]:
     * left-drag advances, right-drag goes back, but only past the threshold.
     */
    fun settlePage(page: Int, count: Int, dragPx: Float, widthPx: Float): Int {
        if (widthPx <= 0f) return clampPage(page, count)
        val travel = abs(dragPx) / widthPx
        if (travel < SWIPE_THRESHOLD_FRACTION) return clampPage(page, count)
        return if (dragPx < 0f) next(page, count) else previous(page, count)
    }

    /**
     * Per-card horizontal offset in dp for a continuous [position] on the
     * snake: the focused card sits at 0, its neighbours trail by ±[spacingDp],
     * further cards stack behind them (never off-screen, always ordered).
     */
    fun offsetsDp(position: Float, count: Int, spacingDp: Float): List<Float> {
        require(count > 0) { "carousel needs at least one slide" }
        val p = position.coerceIn(0f, (count - 1).toFloat())
        return List(count) { i -> (i - p) * spacingDp }
    }

    /** Alpha per card: focus full, immediate neighbour dimmed, rest quieter. */
    fun alphas(position: Float, count: Int): List<Float> {
        require(count > 0) { "carousel needs at least one slide" }
        val p = position.coerceIn(0f, (count - 1).toFloat())
        return List(count) { i ->
            when (abs(i - p).roundToInt()) {
                0 -> 1f
                1 -> 0.45f
                else -> 0.2f
            }
        }
    }

    /** Scale per card: focus full size, neighbours shrink toward 84%. */
    fun scales(position: Float, count: Int): List<Float> {
        require(count > 0) { "carousel needs at least one slide" }
        val p = position.coerceIn(0f, (count - 1).toFloat())
        return List(count) { i ->
            val d = abs(i - p)
            if (d >= 2f) 0.84f else (1f - 0.16f * d)
        }
    }

    /** Dot widths (dp): the active dot stretches into a snake segment. */
    fun dotWidthsDp(activePage: Int, count: Int, activeDp: Float = 18f, idleDp: Float = 8f): List<Float> {
        require(count > 0) { "carousel needs at least one slide" }
        val page = clampPage(activePage, count)
        return List(count) { i -> if (i == page) activeDp else idleDp }
    }
}

@Composable
fun OnboardingCarousel(
    onGetStarted: () -> Unit,
    page: Int = 0,
    onPageChange: (Int) -> Unit = {}
) {
    val icons = listOf(Icons.Rounded.AutoMode, Icons.Rounded.Refresh, Icons.Rounded.EmojiEvents)
    val slides = SnakeCarousel.SLIDES
    val count = slides.size
    val settledPage = SnakeCarousel.clampPage(page, count)

    // Live drag travel, in px, reset on release.
    var dragPx by remember { mutableFloatStateOf(0f) }
    val density = LocalDensity.current
    val cardWidthPx = with(density) { 340.dp.toPx() }
    // Drag fraction -> live slide of the snake, capped at half a card each way.
    val dragFraction = (dragPx / cardWidthPx).coerceIn(-0.5f, 0.5f)
    val continuousPosition = settledPage - dragFraction * 2f

    val offsets = SnakeCarousel.offsetsDp(continuousPosition, count, spacingDp = 46f)
    val alphas = SnakeCarousel.alphas(continuousPosition, count)
    val scales = SnakeCarousel.scales(continuousPosition, count)

    Column(
        modifier = Modifier.fillMaxSize().background(BgBlack).statusBarsPadding()
            .navigationBarsPadding().padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text("Bingwa Score", color = TextWhite, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Your bundle business, automated.", color = TextWhite.copy(alpha = 0.5f), fontSize = 13.sp)
        Spacer(modifier = Modifier.height(48.dp))

        // U6 — the snake: three cards flowing side by side, drag to advance.
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f)
                .pointerInput(settledPage) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            val target = SnakeCarousel.settlePage(settledPage, count, dragPx, size.width.toFloat())
                            dragPx = 0f
                            if (target != settledPage) onPageChange(target)
                        },
                        onDragCancel = { dragPx = 0f }
                    ) { _, dragAmount ->
                        dragPx += dragAmount
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            slides.forEachIndexed { index, slide ->
                SnakeCard(
                    icon = icons[index % icons.size],
                    title = slide.title,
                    body = slide.body,
                    offsetX = offsets[index].dp,
                    alpha = alphas[index],
                    scale = scales[index],
                    onClick = {
                        if (index != settledPage) onPageChange(index)
                    }
                )
            }
        }

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            val dots = SnakeCarousel.dotWidthsDp(settledPage, count)
            dots.forEachIndexed { index, widthDp ->
                Box(modifier = Modifier.padding(horizontal = 4.dp)
                    .width(widthDp.dp).height(8.dp).clip(CircleShape)
                    .background(if (index == settledPage) AccentBlue else TextDim))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (settledPage > 0) {
                PrimaryButton(text = "Back", onClick = { onPageChange(SnakeCarousel.previous(settledPage, count)) }, modifier = Modifier.width(120.dp))
            } else Spacer(modifier = Modifier.width(120.dp))
            PrimaryButton(
                text = if (settledPage == count - 1) "Get Started" else "Next",
                onClick = { if (settledPage == count - 1) onGetStarted() else onPageChange(SnakeCarousel.next(settledPage, count)) },
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SnakeCard(
    icon: ImageVector,
    title: String,
    body: String,
    offsetX: Dp,
    alpha: Float,
    scale: Float,
    onClick: () -> Unit
) {
    val density = LocalDensity.current
    val translationPx = with(density) { offsetX.toPx() }
    Box(
        modifier = Modifier
            .graphicsLayer {
                translationX = translationPx
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
            }
            .size(width = 300.dp, height = 340.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Bubble)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Box(modifier = Modifier.size(72.dp).clip(CircleShape).background(accentBrush()),
                contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = null, tint = BgBlack, modifier = Modifier.size(36.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(title, color = TextWhite.copy(alpha = alpha), fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(body, color = TextWhite.copy(alpha = 0.6f * alpha), fontSize = 13.sp, textAlign = TextAlign.Center)
        }
    }
}
