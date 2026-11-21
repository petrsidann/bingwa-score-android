package com.bingwascore.app.ui.onboarding

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material.icons.rounded.CloudUpload
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

private data class Slide(
    val bg: Color,
    val fg: Color,
    val title: String,
    val text: String,
    val ctaBg: Color,
    val ctaFg: Color
)

@Composable
fun OnboardingSlides(onCreateAccount: () -> Unit, onSignIn: () -> Unit) {
    val slides = listOf(
        Slide(
            bg = DesignTokens.Onboarding.slideBg[0],
            fg = DesignTokens.Onboarding.medallionFill[0],
            title = "Auto-pilot payments",
            text = "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.",
            ctaBg = DesignTokens.Onboarding.medallionFill[0],
            ctaFg = DesignTokens.Onboarding.iconTint[0]
        ),
        Slide(
            bg = DesignTokens.Onboarding.slideBg[1],
            fg = DesignTokens.Onboarding.medallionFill[1],
            title = "Smart retries & fallbacks",
            text = "Failed transaction? We retry with fallbacks so your customers stay happy.",
            ctaBg = DesignTokens.Onboarding.medallionFill[1],
            ctaFg = DesignTokens.Onboarding.iconTint[1]
        ),
        Slide(
            bg = DesignTokens.Onboarding.slideBg[2],
            fg = DesignTokens.Onboarding.medallionFill[2],
            title = "Score, streaks & rewards",
            text = "Earn points for every sale, build streaks and unlock achievements as you grow.",
            ctaBg = DesignTokens.Onboarding.medallionFill[2],
            ctaFg = DesignTokens.Onboarding.iconTint[2]
        ),
        Slide(
            bg = DesignTokens.Onboarding.slideBg[3],
            fg = DesignTokens.Onboarding.medallionFill[3],
            title = "Import your customers",
            text = "Upload a CSV of your saved contacts to restore your customers, offers and USSD plans in one tap.",
            ctaBg = DesignTokens.Onboarding.medallionFill[3],
            ctaFg = DesignTokens.Onboarding.iconTint[3]
        )
    )
    val pagerState = rememberPagerState(pageCount = { slides.size })
    val scope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current
    val context = LocalContext.current
    SideEffect {
        (view.context as? Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = pagerState.currentPage != 0
        }
    }
    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage > 0) haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
    }
    BackHandler(enabled = pagerState.currentPage == 0) { (context as? Activity)?.finish() }

    val slide = slides[pagerState.currentPage]

    Box(Modifier.fillMaxSize().background(slide.bg)) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            SlideContentOnly(slide = slides[page], page = page, pagerState = pagerState)
        }

        Skip(
            modifier = Modifier.align(Alignment.TopEnd),
            pagerState = pagerState,
            scope = scope,
            color = slide.fg
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CtaRow(
                slide = slide,
                page = pagerState.currentPage,
                scope = scope,
                pagerState = pagerState,
                haptic = haptic,
                onCreateAccount = onCreateAccount,
                onSignIn = onSignIn
            )
            Spacer(Modifier.height(10.dp))
            DragFollowDots(pagerState = pagerState, count = slides.size, dotColor = slide.fg)
        }
    }
}

@Composable
private fun SlideContentOnly(
    slide: Slide,
    page: Int,
    pagerState: PagerState
) {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val pageWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val off = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer {
                alpha = (1f - abs(off) * 0.7f).coerceIn(0f, 1f)
                translationX = -off * pageWidthPx * 0.25f
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 32.dp, end = 32.dp, bottom = 108.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            when (page) {
                0 -> EyeToggleIcon(
                    bgColor = DesignTokens.Onboarding.medallionFill[0],
                    fgColor = DesignTokens.Onboarding.iconTint[0]
                )
                3 -> Box(
                    Modifier.size(160.dp).clip(CircleShape)
                        .background(DesignTokens.Onboarding.medallionFill[3]),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CloudUpload,
                        contentDescription = null,
                        tint = DesignTokens.Onboarding.iconTint[3],
                        modifier = Modifier.size(72.dp)
                    )
                }
                else -> Box(
                    Modifier.size(160.dp).clip(CircleShape)
                        .background(DesignTokens.Onboarding.medallionFill[page]),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (page == 1) Icons.Rounded.Cached else Icons.Rounded.EmojiEvents,
                        contentDescription = null,
                        tint = DesignTokens.Onboarding.iconTint[page],
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            Spacer(Modifier.height(28.dp))
            Text(slide.title, color = slide.fg, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(12.dp))
            Text(slide.text, color = slide.fg.copy(alpha = 0.7f), fontSize = 15.sp, lineHeight = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
private fun EyeToggleIcon(bgColor: Color, fgColor: Color) {
    Box(Modifier.size(160.dp).clip(CircleShape).background(bgColor), contentAlignment = Alignment.Center) {
        Box(Modifier.size(width = 96.dp, height = 52.dp).clip(RoundedCornerShape(26.dp)).background(fgColor), contentAlignment = Alignment.CenterEnd) {
            Box(Modifier.padding(end = 4.dp).size(44.dp).clip(CircleShape).background(bgColor), contentAlignment = Alignment.Center) {
                Icon(Icons.Filled.Visibility, contentDescription = null, tint = fgColor, modifier = Modifier.size(28.dp))
            }
        }
    }
}

@Composable
private fun Skip(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    color: Color
) {
    Text(
        "Skip",
        color = color.copy(alpha = 0.7f),
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
            .statusBarsPadding()
            .padding(top = 12.dp, end = 24.dp)
            .clickable { scope.launch { pagerState.animateScrollToPage(pagerState.pageCount - 1) } }
    )
}

@Composable
private fun CtaRow(
    slide: Slide,
    page: Int,
    scope: CoroutineScope,
    pagerState: PagerState,
    haptic: HapticFeedback,
    onCreateAccount: () -> Unit,
    onSignIn: () -> Unit
) {
    val ctaBg = slide.ctaBg
    val ctaFg = slide.ctaFg

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (page < 3) Arrangement.Center else Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (page < 3) {
            Box(
                Modifier
                    .widthIn(min = 200.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(ctaBg)
                    .clickable {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        scope.launch { pagerState.animateScrollToPage(page + 1) }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Next", color = ctaFg, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        } else {
            Text(
                "Sign in",
                color = slide.fg.copy(alpha = 0.8f),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(8.dp).clickable { onSignIn() }
            )
            Box(
                Modifier
                    .widthIn(min = 200.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(ctaBg)
                    .clickable {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        onCreateAccount()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Create account", color = ctaFg, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun DragFollowDots(pagerState: PagerState, count: Int, dotColor: Color) {
    val density = LocalDensity.current
    val slot = 24.dp
    val gap = 8.dp
    val dotSize = 7.dp
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    val rawFrac = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val animatedFrac by animateFloatAsState(
        targetValue = rawFrac,
        animationSpec = spring(dampingRatio = 0.86f, stiffness = 300f),
        label = "dotFrac"
    )
    val frac = if (isDragged) rawFrac else animatedFrac
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .offset {
                    val x = frac * (slot + gap).value * density.density
                    IntOffset(x.roundToInt(), 0)
                }
                .size(slot, dotSize),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .size(slot, dotSize)
                    .clip(RoundedCornerShape(50))
                    .background(DesignTokens.Launch.lime)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(gap), verticalAlignment = Alignment.CenterVertically) {
            repeat(count) {
                Box(Modifier.size(slot, dotSize), contentAlignment = Alignment.Center) {
                    Box(Modifier.size(dotSize).clip(CircleShape).background(dotColor.copy(alpha = 0.35f)))
                }
            }
        }
    }
}
