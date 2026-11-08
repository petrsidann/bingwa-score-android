package com.bingwascore.app.ui.onboarding

import android.app.Activity
import android.provider.Settings
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics
import androidx.core.view.WindowCompat
import androidx.compose.runtime.getValue
import kotlinx.coroutines.launch
import kotlin.math.abs

private data class SlideSpec(
    val bg: Color,
    val fg: Color,
    val bodyColor: Color,
    val iconBg: Color,
    val iconTint: Color,
    val icon: ImageVector,
    val title: String,
    val body: String,
    val ctaBg: Color,
    val ctaLabel: Color,
    val showHeader: Boolean
)

private val slides = listOf(
    SlideSpec(
        bg = DesignTokens.Launch.lime,
        fg = DesignTokens.Launch.violet,
        bodyColor = DesignTokens.Launch.violet.copy(alpha = 0.7f),
        iconBg = DesignTokens.Launch.violet,
        iconTint = DesignTokens.Launch.lime,
        icon = Icons.Rounded.Autorenew,
        title = "Auto-pilot payments",
        body = "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.",
        ctaBg = DesignTokens.Launch.violet,
        ctaLabel = DesignTokens.Launch.lime,
        showHeader = true
    ),
    SlideSpec(
        bg = DesignTokens.Launch.violet,
        fg = DesignTokens.Launch.lime,
        bodyColor = DesignTokens.Launch.lime.copy(alpha = 0.8f),
        iconBg = DesignTokens.Launch.lime,
        iconTint = DesignTokens.Launch.violet,
        icon = Icons.Rounded.Cached,
        title = "Smart retries & fallbacks",
        body = "Failed transaction? We retry with fallbacks so your customers stay happy.",
        ctaBg = DesignTokens.Launch.lime,
        ctaLabel = DesignTokens.Launch.violet,
        showHeader = false
    ),
    SlideSpec(
        bg = DesignTokens.Launch.ink,
        fg = DesignTokens.Launch.lime,
        bodyColor = Color.White.copy(alpha = 0.7f),
        iconBg = DesignTokens.Launch.lime,
        iconTint = DesignTokens.Launch.ink,
        icon = Icons.Rounded.EmojiEvents,
        title = "Score, streaks & rewards",
        body = "Earn points for every sale, build streaks and unlock achievements as you grow.",
        ctaBg = DesignTokens.Launch.lime,
        ctaLabel = DesignTokens.Launch.ink,
        showHeader = false
    )
)

@Composable
fun OnboardingSlides(onSignIn: () -> Unit, onSignUp: () -> Unit) {
    val count = slides.size
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { count })
    val page = pagerState.currentPage
    val scope = rememberCoroutineScope()
    val haptics = rememberHaptics()
    val context = LocalContext.current
    val reducedMotion = try {
        Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) == 0f
    } catch (_: Throwable) {
        false
    }
    val parallaxFactor = if (reducedMotion) 0f else 0.15f

    var firstSettle = remember { mutableStateOf(true) }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (firstSettle.value) { firstSettle.value = false; return@LaunchedEffect }
        if (!pagerState.isScrollInProgress) haptics.tick()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        val view = LocalView.current
        SideEffect {
            val controller = WindowCompat.getInsetsController((context as Activity).window, view)
            controller?.isAppearanceLightStatusBars = page != 0
        }
        BackHandler {
            if (page == 0) (context as Activity).finish()
            else scope.launch { pagerState.animateScrollToPage(page - 1) }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSize = PageSize.Fill,
            key = { it }
        ) { index ->
            val slide = slides[index]
            val pageOffset = abs((pagerState.currentPage - index) + pagerState.currentPageOffsetFraction)
            val pageWidthState = remember { mutableStateOf(0f) }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .onSizeChanged { size -> pageWidthState.value = size.width.toFloat() }
                    .graphicsLayer {
                        translationX = if (reducedMotion) 0f else pageOffset * pageWidthState.value * parallaxFactor
                        alpha = 1f - pageOffset.coerceAtMost(1f) * 0.6f
                    }
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    if (slide.showHeader) {
                        Column(
                            modifier = Modifier.statusBarsPadding().padding(top = 28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Bingwa Score",
                                color = slide.fg,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = (-1).sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Your bundle business, automated.",
                                color = slide.fg.copy(alpha = 0.7f),
                                fontSize = 15.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier.size(160.dp).clip(CircleShape).background(slide.iconBg),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = slide.icon,
                            contentDescription = null,
                            tint = slide.iconTint,
                            modifier = Modifier.size(72.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(28.dp))
                    Text(
                        text = slide.title,
                        color = slide.fg,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = slide.body,
                        color = slide.bodyColor,
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 40.dp),
                        maxLines = 3
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.padding(bottom = 28.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        (0 until count).forEach { i ->
                            val width = animateDpAsState(
                                targetValue = if (i == page) 24.dp else 8.dp,
                                animationSpec = if (reducedMotion) tween(durationMillis = 0) else spring(dampingRatio = 0.86f, stiffness = 380f)
                            )
                            Box(
                                modifier = Modifier
                                    .width(width.value)
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                                    .background(slide.fg.copy(alpha = if (i == page) 1f else 0.35f))
                            )
                        }
                    }
                    if (index < count - 1) {
                        Row(
                            modifier = Modifier.navigationBarsPadding().padding(horizontal = 24.dp, vertical = 20.dp).height(64.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Skip",
                                color = slide.fg.copy(alpha = 0.7f),
                                fontSize = 16.sp,
                                modifier = Modifier.clickable(onClick = {
                                    scope.launch { pagerState.animateScrollToPage(count - 1) }
                                })
                            )
                            Box(
                                modifier = Modifier
                                    .width(220.dp)
                                    .height(64.dp)
                                    .clip(RoundedCornerShape(32.dp))
                                    .background(slide.ctaBg)
                                    .clickable(onClick = {
                                        haptics.press()
                                        scope.launch { pagerState.animateScrollToPage((index + 1).coerceAtMost(count - 1)) }
                                    }),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Next",
                                    color = slide.ctaLabel,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier.navigationBarsPadding().padding(horizontal = 24.dp, vertical = 20.dp).height(64.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Sign in",
                                color = slide.fg.copy(alpha = 0.8f),
                                fontSize = 16.sp,
                                modifier = Modifier.clickable(onClick = {
                                    onSignIn()
                                })
                            )
                            Box(
                                modifier = Modifier
                                    .width(260.dp)
                                    .height(64.dp)
                                    .clip(RoundedCornerShape(32.dp))
                                    .background(slide.ctaBg)
                                    .clickable(onClick = {
                                        haptics.press()
                                        onSignUp()
                                    }),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Create Account",
                                    color = slide.ctaLabel,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
