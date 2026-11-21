package com.bingwascore.app.ui.onboarding

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
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
import kotlin.math.sin

private val CsvBlue = Color(0xFF1E3A8A)
private val DarkOlive = Color(0xFF4D7C0F)

private data class Slide(
    val bg: Color,
    val fg: Color,
    val body: Color,
    val title: String,
    val text: String,
    val ctaBg: Color,
    val ctaFg: Color,
    val header: Boolean,
    val accent: Color
)

@Composable
fun OnboardingSlides(onCreateAccount: () -> Unit, onSignIn: () -> Unit) {
    val lime = DesignTokens.Launch.lime
    val violet = DesignTokens.Launch.violet
    val ink = DesignTokens.Launch.ink
    val slides = listOf(
        Slide(lime, violet, violet.copy(alpha = 0.7f), "Auto-pilot payments", "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.", violet, lime, header = true, accent = violet),
        Slide(violet, lime, lime.copy(alpha = 0.8f), "Smart retries & fallbacks", "Failed transaction? We retry with fallbacks so your customers stay happy.", lime, violet, header = false, accent = lime),
        Slide(ink, lime, Color.White.copy(alpha = 0.7f), "Score, streaks & rewards", "Earn points for every sale, build streaks and unlock achievements as you grow.", lime, ink, header = false, accent = lime),
        Slide(CsvBlue, lime, Color.White.copy(alpha = 0.7f), "Import your customers", "Upload a CSV of your saved contacts to restore your customers, offers and USSD plans in one tap.", lime, violet, header = false, accent = lime)
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

    val rawPage = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val roundedPage = rawPage.roundToInt().coerceIn(0, slides.lastIndex)
    val chromeInk by animateColorAsState(
        targetValue = if (roundedPage == 0) DarkOlive else Color.White,
        animationSpec = tween(durationMillis = 300),
        label = "chromeInk"
    )

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
            color = chromeInk
        )

        CompositionLocalProvider(LocalContentColor provides chromeInk) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(start = 16.dp, end = 16.dp, bottom = 18.dp),
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
                Spacer(Modifier.height(12.dp))
                Dots(pagerState = pagerState)
            }
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
                alpha = 1f
                translationX = -off * pageWidthPx * 0.10f
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
            Medallion(page = page, accent = slide.accent)
            Spacer(Modifier.height(28.dp))
            Text(slide.title, color = slide.fg, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(12.dp))
            Text(slide.text, color = slide.body, fontSize = 15.sp, lineHeight = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
private fun Medallion(page: Int, accent: Color, modifier: Modifier = Modifier) {
    val icon: ImageVector = when (page) {
        0 -> Icons.Rounded.Autorenew
        1 -> Icons.Rounded.Cached
        2 -> Icons.Rounded.EmojiEvents
        3 -> Icons.Rounded.Cached
        else -> Icons.Rounded.Autorenew
    }
    Box(
        modifier = modifier
            .size(160.dp)
            .clip(CircleShape)
            .background(accent.copy(alpha = 0.14f))
            .border(width = 1.dp, color = accent.copy(alpha = 0.5f), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(accent.copy(alpha = 0.10f), Color.Transparent),
                        center = Offset(0.5f, 0f),
                        radius = 0.8f
                    )
                )
        )
        Icon(icon, contentDescription = null, tint = accent, modifier = Modifier.size(72.dp))
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
            .clickable {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.pageCount - 1,
                        animationSpec = spring(dampingRatio = 0.86f, stiffness = 300f)
                    )
                }
            }
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
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page + 1,
                                animationSpec = spring(dampingRatio = 0.86f, stiffness = 300f)
                            )
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Next", color = ctaFg, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        } else {
            Text(
                "Sign in",
                color = LocalContentColor.current.copy(alpha = 0.8f),
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
private fun Dots(pagerState: PagerState) {
    val lime = DesignTokens.Launch.lime
    val violet = DesignTokens.Launch.violet
    val rawPage = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val roundedPage = rawPage.roundToInt().coerceIn(0, 3)
    val pillColor = if (roundedPage == 0) violet else lime
    val frac = abs(pagerState.currentPageOffsetFraction)
    val pillWidth = (24 + 10 * sin(Math.PI * frac)).dp
    val prog = rawPage

    Box(
        modifier = Modifier
            .width(72.dp)
            .height(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) {
                Box(
                    Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(LocalContentColor.current.copy(alpha = 0.35f))
                )
            }
        }

        val density = LocalDensity.current
        Box(
            modifier = Modifier
                .offset {
                    val x = with(density) { (prog * 16).dp.toPx() }
                    IntOffset(x.roundToInt(), 0)
                }
                .width(pillWidth)
                .height(8.dp)
                .clip(RoundedCornerShape(99.dp))
                .background(pillColor)
        )
    }
}
