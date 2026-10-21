package com.bingwascore.app.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoMode
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.accentBrush
import kotlinx.coroutines.launch
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

/**
 * Stage 19.7 — the PURE onboarding surface: the page index and the two doors.
 */
data class OnboardingCarouselState(
    val page: Int = 0
)

/** Stage 19.7 — every onboarding side effect as a plain callback. */
data class OnboardingCarouselCallbacks(
    val onGetStarted: () -> Unit = {},
    val onPageChange: (Int) -> Unit = {}
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingCarousel(
    onGetStarted: () -> Unit,
    page: Int = 0,
    onPageChange: (Int) -> Unit = {}
) {
    // STAGE 19.7 — thin wrapper: the carousel has no ViewModel, so the wrapper
    // only hands the state and the callbacks to the pure content.
    OnboardingCarouselContent(
        state = OnboardingCarouselState(page = page),
        callbacks = OnboardingCarouselCallbacks(
            onGetStarted = onGetStarted,
            onPageChange = onPageChange
        )
    )
}

/**
 * Stage 19.7 — the pure onboarding body: the wordmark, the pager and the
 * Back / Next doors.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingCarouselContent(
    state: OnboardingCarouselState = OnboardingCarouselState(),
    callbacks: OnboardingCarouselCallbacks = OnboardingCarouselCallbacks()
) {
    val icons = listOf(Icons.Rounded.AutoMode, Icons.Rounded.Refresh, Icons.Rounded.EmojiEvents)
    val slides = SnakeCarousel.SLIDES
    val count = slides.size
    val settledPage = SnakeCarousel.clampPage(state.page, count)
    val pagerState = rememberPagerState(initialPage = settledPage, pageCount = { count })
    val scope = rememberCoroutineScope()

    LaunchedEffect(settledPage) {
        if (pagerState.currentPage != settledPage) pagerState.scrollToPage(settledPage)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress && pagerState.currentPage != settledPage) {
            callbacks.onPageChange(pagerState.currentPage)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(BgBlack).statusBarsPadding()
            .navigationBarsPadding().padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text("Bingwa Score", color = TextWhite, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Your bundle business, automated.", color = TextWhite.copy(alpha = 0.5f), fontSize = 13.sp)
        Spacer(modifier = Modifier.height(32.dp))

        // Stage 20 — one page fills the viewport; neighbours never overlap.
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 24.dp),
            pageSpacing = 24.dp,
            verticalAlignment = Alignment.CenterVertically,
            key = { it }
        ) { index ->
            val pageOffset = abs(
                (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            ).coerceIn(0f, 1f)
            PagerCard(
                icon = icons[index % icons.size],
                title = slides[index].title,
                body = slides[index].body,
                dim = pageOffset
            )
        }

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            val dots = SnakeCarousel.dotWidthsDp(pagerState.currentPage, count)
            dots.forEachIndexed { index, widthDp ->
                Box(modifier = Modifier.padding(horizontal = 4.dp)
                    .width(widthDp.dp).height(8.dp).clip(CircleShape)
                    .background(if (index == pagerState.currentPage) AccentBlue else TextDim))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (settledPage > 0) {
                PrimaryButton(text = "Back", onClick = { scope.launch { pagerState.animateScrollToPage(SnakeCarousel.previous(settledPage, count)) } }, modifier = Modifier.width(120.dp))
            } else Spacer(modifier = Modifier.width(120.dp))
            PrimaryButton(
                text = if (settledPage == count - 1) "Get Started" else "Next",
                onClick = {
                    if (settledPage == count - 1) callbacks.onGetStarted()
                    else scope.launch { pagerState.animateScrollToPage(SnakeCarousel.next(settledPage, count)) }
                },
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

/** Stage 20 — fixed-height page card: icon/title/body column, zero overlap. */
@Composable
private fun PagerCard(
    icon: ImageVector,
    title: String,
    body: String,
    dim: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Bubble),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Box(modifier = Modifier.size(72.dp).clip(CircleShape).background(accentBrush()),
                contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = null, tint = BgBlack, modifier = Modifier.size(36.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(title, color = TextWhite.copy(alpha = 1f - 0.5f * dim), fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(body, color = TextWhite.copy(alpha = 0.6f * (1f - 0.5f * dim)), fontSize = 13.sp, textAlign = TextAlign.Center)
        }
    }
}

/** Stage 20 — pager math: Fill pages with fixed gaps, zero overlap. */
object OnboardingPager {

    const val PAGE_COUNT = 3
    const val PAGE_GAP_DP = 24f

    /** [startX, endX] per page; neighbours touch at most at the gap edge. */
    fun pageBounds(pageWidth: Float, gap: Float = PAGE_GAP_DP): List<Pair<Float, Float>> =
        List(PAGE_COUNT) { i ->
            val start = i * (pageWidth + gap)
            start to start + pageWidth
        }

    /** Inactive text dims with offset: 1 at rest, 0.5 fully away. */
    fun textAlpha(offset: Float): Float = (1f - 0.5f * offset.coerceIn(0f, 1f))
}

/** Stage 20 — legacy snake card kept for reference; pager owns the UI now. */
@Composable
private fun SnakeCard(
    icon: ImageVector,
    title: String,
    body: String,
    offsetX: androidx.compose.ui.unit.Dp,
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
