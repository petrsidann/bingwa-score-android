package com.bingwascore.app.ui.onboarding

import android.app.Activity
import android.view.View
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.bingwaPress as bingwaPressExt
import com.bingwascore.app.ui.theme.DesignTokens
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.vector.ImageVector

val SlideInk = Color(0xFF101014)

val SlideViolet70 = DesignTokens.Launch.violet.copy(alpha = 0.7f)
val SlideLime80 = DesignTokens.Launch.lime.copy(alpha = 0.8f)
val SlideWhite70 = Color.White.copy(alpha = 0.7f)

data class SlideSpec(
    val bg: Color,
    val fg: Color,
    val body: Color,
    val iconBg: Color,
    val iconTint: Color,
    val ctaBg: Color,
    val ctaLabel: Color,
    val showHeader: Boolean,
    val icon: ImageVector
)

val Slides = listOf(
    SlideSpec(
        bg = DesignTokens.Launch.lime,
        fg = DesignTokens.Launch.violet,
        body = SlideViolet70,
        iconBg = DesignTokens.Launch.violet,
        iconTint = DesignTokens.Launch.lime,
        ctaBg = DesignTokens.Launch.violet,
        ctaLabel = DesignTokens.Launch.lime,
        showHeader = true,
        icon = Icons.Rounded.Autorenew
    ),
    SlideSpec(
        bg = DesignTokens.Launch.violet,
        fg = DesignTokens.Launch.lime,
        body = SlideLime80,
        iconBg = DesignTokens.Launch.lime,
        iconTint = DesignTokens.Launch.violet,
        ctaBg = DesignTokens.Launch.lime,
        ctaLabel = DesignTokens.Launch.violet,
        showHeader = false,
        icon = Icons.Rounded.Cached
    ),
    SlideSpec(
        bg = SlideInk,
        fg = DesignTokens.Launch.lime,
        body = SlideWhite70,
        iconBg = DesignTokens.Launch.lime,
        iconTint = SlideInk,
        ctaBg = DesignTokens.Launch.lime,
        ctaLabel = SlideInk,
        showHeader = false,
        icon = Icons.Rounded.EmojiEvents
    )
)

@Composable
fun OnboardingSlides(
    onGetStarted: () -> Unit,
    onSkip: () -> Unit = onGetStarted,
    page: Int = 0,
    onPageChange: (Int) -> Unit = {}
) {
    val count = Slides.size
    val settledPage = page.coerceIn(0, count - 1)
    val pagerState = rememberPagerState(initialPage = settledPage, pageCount = { count })
    val scope = rememberCoroutineScope()

    LaunchedEffect(settledPage) {
        if (pagerState.currentPage != settledPage) pagerState.scrollToPage(settledPage)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress && pagerState.currentPage != settledPage) {
            onPageChange(pagerState.currentPage)
        }
    }

    val currentPage = pagerState.currentPage
    val context = LocalContext.current

    SideEffect {
        val activity = context as? Activity
        val decorView = activity?.window?.decorView
        if (currentPage != 0) {
            decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            decorView?.systemUiVisibility = 0
        }
    }

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fill,
        modifier = Modifier.fillMaxSize()
    ) { index ->
        SlidePage(Slides[index], index, pagerState, onGetStarted, onSkip, scope, count)
    }
}

@Composable
private fun SlidePage(
    spec: SlideSpec,
    page: Int,
    pagerState: PagerState,
    onGetStarted: () -> Unit,
    onSkip: () -> Unit,
    scope: CoroutineScope,
    count: Int
) {
    val haptic = LocalHapticFeedback.current
    val interactionSource = remember { MutableInteractionSource() }

    Box(Modifier.fillMaxSize().background(spec.bg)) {
        Column(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (spec.showHeader) {
                Spacer(modifier = Modifier.width(24.dp).height(24.dp))
                Text(
                    "Bingwa Score",
                    color = spec.fg,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = (-0.5).sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.width(8.dp).height(8.dp))
                Text(
                    "Your bundle business, automated.",
                    color = spec.fg.copy(alpha = 0.7f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                Modifier.width(160.dp).height(160.dp).clip(CircleShape).background(spec.iconBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = spec.icon,
                    contentDescription = null,
                    tint = spec.iconTint,
                    modifier = Modifier.width(72.dp).height(72.dp)
                )
            }
            Spacer(modifier = Modifier.width(28.dp).height(28.dp))
            Text(
                text = when (page) {
                    0 -> "Auto-pilot payments"
                    1 -> "Smart retries & fallbacks"
                    else -> "Score, streaks & rewards"
                },
                color = spec.fg,
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.width(12.dp).height(12.dp))
            Text(
                text = when (page) {
                    0 -> "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically."
                    1 -> "Failed transaction? We retry with fallbacks so your customers stay happy."
                    else -> "Earn points for every sale, build streaks and unlock achievements as you grow."
                },
                color = spec.body,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            IndicatorRow(pagerState, spec.fg, Modifier.align(Alignment.CenterHorizontally).padding(bottom = 20.dp))
        }

        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val ghostLabel = if (page == 0) "Skip" else "Back"
            Text(
                text = ghostLabel,
                color = spec.fg.copy(alpha = 0.6f),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .bingwaPressExt(
                        interactionSource = interactionSource,
                        haptic = HapticFeedbackType.TextHandleMove
                    )
                    .clickable {
                        if (page == 0) {
                            onSkip()
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(page - 1)
                            }
                        }
                    }
            )
            Box(
                Modifier
                    .widthIn(min = 200.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(spec.ctaBg)
                    .bingwaPressExt(
                        interactionSource = interactionSource,
                        haptic = HapticFeedbackType.LongPress
                    )
                    .clickable {
                        if (page == count - 1) {
                            onGetStarted()
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(page + 1)
                            }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                val ctaLabel = if (page == count - 1) "Get Started" else "Next"
                Text(
                    text = ctaLabel,
                    color = spec.ctaLabel,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun IndicatorRow(
    pagerState: PagerState,
    fg: Color,
    modifier: Modifier = Modifier
) {
    val currentPage = pagerState.currentPage
    val count = 3
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(count) { index ->
            val isActive = currentPage == index
            val width by animateFloatAsState(
                targetValue = if (isActive) 24f else 8f,
                animationSpec = spring(stiffness = 380f, dampingRatio = 0.86f),
                label = "indicatorWidth$index"
            )
            Box(
                modifier = Modifier
                    .width(width.dp)
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(if (isActive) fg else fg.copy(alpha = 0.35f))
            )
        }
    }
}
