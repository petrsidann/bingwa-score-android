package com.bingwascore.app.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.brand.BrandWordmark
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.accentBrush
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.min
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
 * Stage 21 — the pager geometry, in ONE place, so the UI and the JVM tests
 * share the same numbers.
 */
object OnboardingPager {

    /** Three pages, always. */
    const val PAGE_COUNT: Int = 3

    /** The gap between two pages, in dp. */
    const val PAGE_GAP_DP: Float = 24f

    /** The card radius, in dp. */
    const val CARD_RADIUS_DP: Float = 24f

    /** The smallest legal touch target (Material), in dp. */
    const val MIN_TOUCH_TARGET_DP: Float = 44f

    /** The card height on a tall screen, in dp. */
    const val CARD_HEIGHT_DP: Float = 300f

    /** The card height on a short screen (landscape, a small phone), in dp. */
    const val CARD_HEIGHT_COMPACT_DP: Float = 168f

    /** Below this screen height the layout switches to the compact stack. */
    const val TIGHT_HEIGHT_DP: Float = 560f

    /** [startX, endX] per page; neighbours touch at most at the gap edge. */
    fun pageBounds(pageWidth: Float, gap: Float = PAGE_GAP_DP): List<Pair<Float, Float>> =
        List(PAGE_COUNT) { i ->
            val start = i * (pageWidth + gap)
            start to start + pageWidth
        }

    /** Inactive pages fade with their distance from the settled page. */
    fun pageAlpha(offset: Float): Float = 1f - 0.55f * offset.coerceIn(0f, 1f)

    /** Inactive text dims with offset: 1 at rest, 0.5 fully away. */
    fun textAlpha(offset: Float): Float = 1f - 0.5f * offset.coerceIn(0f, 1f)

    /**
     * The dot indicator weight per dot for a continuous pager [position]: the
     * active pill slides from dot to dot instead of jumping.
     */
    fun dotWeights(position: Float, count: Int = PAGE_COUNT): List<Float> {
        require(count > 0) { "the indicator needs at least one dot" }
        val p = position.coerceIn(0f, (count - 1).toFloat())
        return List(count) { i -> (1f - abs(i - p)).coerceIn(0f, 1f) }
    }

    /**
     * The scale that fits [contentHeight] inside [availableHeight].
     *
     * Never larger than one (content is never blown up) and never smaller
     * than the fit (content is never clipped) — this is what keeps the pages
     * whole in ANY rotation.
     */
    fun fitScale(contentHeight: Float, availableHeight: Float): Float {
        if (contentHeight <= 0f || availableHeight <= 0f) return 1f
        return min(1f, availableHeight / contentHeight)
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
    val onSkip: () -> Unit = {},
    val onPageChange: (Int) -> Unit = {}
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingCarousel(
    onGetStarted: () -> Unit,
    page: Int = 0,
    onPageChange: (Int) -> Unit = {},
    onSkip: () -> Unit = onGetStarted
) {
    // STAGE 19.7 — thin wrapper: the carousel has no ViewModel, so the wrapper
    // only hands the state and the callbacks to the pure content.
    OnboardingCarouselContent(
        state = OnboardingCarouselState(page = page),
        callbacks = OnboardingCarouselCallbacks(
            onGetStarted = onGetStarted,
            onSkip = onSkip,
            onPageChange = onPageChange
        )
    )
}

/**
 * Stage 21 — the onboarding body, rebuilt as a real pager.
 *
 * One `HorizontalPager` with `PageSize.Fill`: every page owns the full
 * width, the pages are 24dp apart, and an inactive page fades with its
 * offset from the settled page. The card has a FIXED height, and the copy
 * inside it is measured at its natural size and scaled down to fit — so a
 * landscape phone shows the same page, slightly smaller, instead of a
 * cut-off title. Nothing overlaps and nothing clips, in either theme.
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

    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(BgBlack)) {
        // Stage 21 — one layout for every screen: a short screen (landscape,
        // a small phone) drops the tagline and shrinks the card; a tall
        // screen keeps the full stack.
        val tight = maxHeight < OnboardingPager.TIGHT_HEIGHT_DP.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(if (tight) 8.dp else 40.dp))
            Text(
                BrandWordmark.TEXT,
                color = TextWhite,
                fontSize = if (tight) 20.sp else 24.sp,
                fontWeight = FontWeight.Bold
            )
            if (!tight) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Your bundle business, automated.",
                    color = TextGrey,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.height(if (tight) 12.dp else 24.dp))

            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                // The card never grows past the room it was given.
                val cardHeight = minOf(
                    if (tight) OnboardingPager.CARD_HEIGHT_COMPACT_DP.dp else OnboardingPager.CARD_HEIGHT_DP.dp,
                    maxHeight
                )
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth().height(cardHeight),
                    pageSize = PageSize.Fill,
                    contentPadding = PaddingValues(horizontal = 24.dp),
                    pageSpacing = OnboardingPager.PAGE_GAP_DP.dp,
                    verticalAlignment = Alignment.CenterVertically,
                    key = { it }
                ) { index ->
                    val pageOffset = abs(
                        (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                    ).coerceIn(0f, 1f)
                    OnboardingPage(
                        icon = icons[index % icons.size],
                        title = slides[index].title,
                        body = slides[index].body,
                        offset = pageOffset,
                        compact = tight,
                        height = cardHeight
                    )
                }
            }

            Spacer(modifier = Modifier.height(if (tight) 12.dp else 20.dp))

            // Stage 21 — the indicator follows the pager, dot by dot.
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val position = pagerState.currentPage + pagerState.currentPageOffsetFraction
                OnboardingPager.dotWeights(position, count).forEachIndexed { index, weight ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width((8f + 12f * weight).dp)
                            .height(8.dp)
                            .clip(CircleShape)
                            .background(if (weight > 0.02f) AccentBlue else TextDim)
                    )
                }
            }

            Spacer(modifier = Modifier.height(if (tight) 12.dp else 20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (settledPage > 0) {
                    OnboardingGhostButton(
                        text = "Back",
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(SnakeCarousel.previous(settledPage, count))
                            }
                        }
                    )
                } else {
                    OnboardingGhostButton(text = "Skip", onClick = callbacks.onSkip)
                }
                Spacer(modifier = Modifier.width(12.dp))
                PrimaryButton(
                    text = if (settledPage == count - 1) "Get Started" else "Next",
                    onClick = {
                        if (settledPage == count - 1) {
                            callbacks.onGetStarted()
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(SnakeCarousel.next(settledPage, count))
                            }
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(if (tight) 12.dp else 24.dp))
        }
    }
}

/**
 * Stage 21 — one page: the glyph, the title and the body, in one column,
 * on a fixed-height card. The whole card fades with the page offset.
 */
@Composable
private fun OnboardingPage(
    icon: ImageVector,
    title: String,
    body: String,
    offset: Float,
    compact: Boolean,
    height: Dp
) {
    val textAlpha = OnboardingPager.textAlpha(offset)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .graphicsLayer { alpha = OnboardingPager.pageAlpha(offset) }
            .clip(RoundedCornerShape(OnboardingPager.CARD_RADIUS_DP.dp))
            .background(Bubble),
        contentAlignment = Alignment.Center
    ) {
        FittedContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            maxHeight = height - 32.dp
        ) {
            // Stage 21 — ONE page grammar in every rotation: the glyph, the
            // title and the body, centred. A short screen (landscape, a small
            // phone) simply uses smaller type — the page never smashes and
            // never clips.
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OnboardingGlyph(
                    icon = icon,
                    size = if (compact) 48.dp else 72.dp
                )
                Spacer(modifier = Modifier.height(if (compact) 12.dp else 20.dp))
                Text(
                    title,
                    color = TextWhite.copy(alpha = textAlpha),
                    fontSize = if (compact) 17.sp else 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(if (compact) 4.dp else 10.dp))
                Text(
                    body,
                    color = TextGrey.copy(alpha = textAlpha),
                    fontSize = if (compact) 12.sp else 13.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

/** Stage 21 — the blue glyph disc that opens every page. */
@Composable
private fun OnboardingGlyph(icon: ImageVector, size: Dp) {
    Box(
        modifier = Modifier.size(size).clip(CircleShape).background(accentBrush()),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = BgBlack,
            modifier = Modifier.size(size * 0.5f)
        )
    }
}

/**
 * Stage 21 — content that FITS, never clips.
 *
 * The card has a fixed height, but the copy inside it is measured at its
 * natural size and then scaled down to whatever the card can hold. A short
 * screen therefore shows the SAME page, slightly smaller, instead of a
 * title with its last line cut off.
 */
@Composable
private fun FittedContent(
    maxHeight: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .wrapContentSize(align = Alignment.Center)
                .layout { measurable, constraints ->
                    val natural = measurable.measure(
                        constraints.copy(minHeight = 0, maxHeight = Constraints.Infinity)
                    )
                    val scale = OnboardingPager.fitScale(
                        contentHeight = natural.height.toFloat(),
                        availableHeight = constraints.maxHeight.toFloat()
                    )
                    layout(
                        (natural.width * scale).roundToInt(),
                        (natural.height * scale).roundToInt()
                    ) {
                        natural.placeWithLayer(0, 0) {
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                }
        ) {
            content()
        }
    }
}

/**
 * Stage 21 — the quiet door (Skip / Back): no fill, one hairline of space,
 * and a touch target that clears 44dp.
 */
@Composable
private fun OnboardingGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = OnboardingPager.MIN_TOUCH_TARGET_DP.dp,
                minHeight = OnboardingPager.MIN_TOUCH_TARGET_DP.dp
            )
            .clip(RoundedCornerShape(22.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = TextGrey, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
    }
}
