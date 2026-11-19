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
import androidx.compose.foundation.layout.width
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

private val CsvBlue = Color(0xFF1E3A8A)

private data class Slide(
    val bg: Color,
    val fg: Color,
    val body: Color,
    val title: String,
    val text: String,
    val ctaBg: Color,
    val ctaFg: Color,
    val header: Boolean
)

@Composable
fun OnboardingSlides(onCreateAccount: () -> Unit, onSignIn: () -> Unit) {
    val lime = DesignTokens.Launch.lime
    val violet = DesignTokens.Launch.violet
    val ink = DesignTokens.Launch.ink
    val slides = listOf(
        Slide(lime, violet, violet.copy(alpha = 0.7f), "Auto-pilot payments", "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.", violet, lime, header = true),
        Slide(violet, lime, lime.copy(alpha = 0.8f), "Smart retries & fallbacks", "Failed transaction? We retry with fallbacks so your customers stay happy.", lime, violet, header = false),
        Slide(ink, lime, Color.White.copy(alpha = 0.7f), "Score, streaks & rewards", "Earn points for every sale, build streaks and unlock achievements as you grow.", lime, ink, header = false),
        Slide(CsvBlue, lime, Color.White.copy(alpha = 0.7f), "Import your customers", "Upload a CSV of your saved contacts to restore your customers, offers and USSD plans in one tap.", lime, CsvBlue, header = false)
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
            if (slide.header) {
                Spacer(Modifier.height(24.dp))
                Text("Bingwa Score", color = slide.fg, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.5).sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                Text("Your bundle business, automated.", color = slide.fg.copy(alpha = 0.7f), fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
            Spacer(Modifier.weight(1f))
            when (page) {
                0 -> EyeToggleIcon(bgColor = DesignTokens.Launch.violet, fgColor = DesignTokens.Launch.lime)
                3 -> CsvUploadIcon(circleColor = DesignTokens.Launch.lime, docColor = Color.White, inkColor = CsvBlue)
                else -> Box(Modifier.size(160.dp).clip(CircleShape).background(DesignTokens.Launch.lime), contentAlignment = Alignment.Center) {
                    Icon(if (page == 1) Icons.Rounded.Cached else Icons.Rounded.EmojiEvents, contentDescription = null, tint = if (page == 1) DesignTokens.Launch.violet else Color.Black, modifier = Modifier.size(72.dp))
                }
            }
            Spacer(Modifier.height(28.dp))
            Text(slide.title, color = slide.fg, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(12.dp))
            Text(slide.text, color = slide.body, fontSize = 15.sp, lineHeight = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
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
private fun CsvUploadIcon(circleColor: Color, docColor: Color, inkColor: Color) {
    Box(Modifier.size(160.dp).clip(CircleShape).background(circleColor), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.size(width = 72.dp, height = 84.dp).clip(RoundedCornerShape(6.dp)).background(docColor)) {
                Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(Modifier.width(44.dp).height(4.dp).background(inkColor))
                    Box(Modifier.width(52.dp).height(4.dp).background(inkColor))
                    Box(Modifier.width(48.dp).height(4.dp).background(inkColor))
                    Box(Modifier.width(36.dp).height(4.dp).background(inkColor))
                }
            }
            Box(Modifier.padding(top = 6.dp).clip(RoundedCornerShape(4.dp)).background(inkColor).padding(horizontal = 10.dp, vertical = 3.dp)) {
                Text("CSV", color = circleColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
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
