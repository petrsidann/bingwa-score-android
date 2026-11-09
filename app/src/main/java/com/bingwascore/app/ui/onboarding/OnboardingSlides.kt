package com.bingwascore.app.ui.onboarding

import android.app.Activity
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.BackHandler
import androidx.core.view.WindowCompat
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.launch

private data class Slide(
    val bg: Color, 
    val fg: Color, 
    val body: Color,
    val iconBg: Color, 
    val iconTint: Color, 
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
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
        Slide(
            bg = lime, 
            fg = violet, 
            body = violet.copy(alpha = 0.7f),
            iconBg = violet, 
            iconTint = lime, 
            icon = Icons.Rounded.Autorenew,
            title = "Auto-pilot payments",
            text = "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.",
            ctaBg = violet, 
            ctaFg = lime, 
            header = true
        ),
        Slide(
            bg = violet, 
            fg = lime, 
            body = lime.copy(alpha = 0.8f),
            iconBg = lime, 
            iconTint = violet, 
            icon = Icons.Rounded.Cached,
            title = "Smart retries & fallbacks",
            text = "Failed transaction? We retry with fallbacks so your customers stay happy.",
            ctaBg = lime, 
            ctaFg = violet, 
            header = false
        ),
        Slide(
            bg = ink, 
            fg = lime, 
            body = Color.White.copy(alpha = 0.7f),
            iconBg = lime, 
            iconTint = Color.Black, 
            icon = Icons.Rounded.EmojiEvents,
            title = "Score, streaks & rewards",
            text = "Earn points for every sale, build streaks and unlock achievements as you grow.",
            ctaBg = lime, 
            ctaFg = Color.Black, 
            header = false
        )
    )
    
    val pagerState = rememberPagerState(pageCount = { slides.size })
    val scope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current
    
    val lightIcons = pagerState.currentPage != 0
    SideEffect {
        (view.context as? Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = !lightIcons
        }
    }
    
    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage > 0) {
            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
        }
    }
    
    val context = LocalContext.current
    BackHandler(enabled = pagerState.currentPage == 0) {
        (context as? Activity)?.finish()
    }
    
    Box(
        Modifier.fillMaxSize().background(slides[pagerState.currentPage].bg)
    ) {
        HorizontalPager(
            state = pagerState, 
            pageSize = PageSize.Fill, 
            modifier = Modifier.fillMaxSize()
        ) { page ->
            SlidePage(
                slide = slides[page], 
                page = page, 
                pagerState = pagerState, 
                scope = scope, 
                onCreateAccount = onCreateAccount, 
                onSignIn = onSignIn
            )
        }
    }
}

@Composable
private fun SlidePage(
    slide: Slide, 
    page: Int, 
    pagerState: androidx.compose.foundation.pager.PagerState,
    scope: kotlinx.coroutines.CoroutineScope, 
    onCreateAccount: () -> Unit, 
    onSignIn: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    
    Box(Modifier.fillMaxSize().background(slide.bg)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 32.dp, end = 32.dp, bottom = 108.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (slide.header) {
                Spacer(Modifier.height(24.dp))
                Text(
                    "Bingwa Score", 
                    color = slide.fg, 
                    fontSize = 28.sp, 
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = (-0.5).sp, 
                    textAlign = TextAlign.Center, 
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Your bundle business, automated.", 
                    color = slide.fg.copy(alpha = 0.7f), 
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center, 
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            Spacer(Modifier.weight(1f))
            
            Box(
                Modifier.size(160.dp).clip(CircleShape).background(slide.iconBg), 
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    slide.icon, 
                    contentDescription = null, 
                    tint = slide.iconTint, 
                    modifier = Modifier.size(72.dp)
                )
            }
            
            Spacer(Modifier.height(28.dp))
            Text(
                slide.title, 
                color = slide.fg, 
                fontSize = 26.sp, 
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center, 
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(Modifier.height(12.dp))
            Text(
                slide.text, 
                color = slide.body, 
                fontSize = 15.sp, 
                lineHeight = 24.sp,
                textAlign = TextAlign.Center, 
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(Modifier.weight(1f))
            
            // Page indicator
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp), 
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(3) { i ->
                    val active = i == page
                    val w by animateDpAsState(
                        if (active) 24.dp else 8.dp,
                        spring(dampingRatio = 0.86f, stiffness = 380f), 
                        label = "dot$i"
                    )
                    Box(
                        Modifier
                            .height(8.dp)
                            .width(w)
                            .clip(RoundedCornerShape(50))
                            .background(slide.fg.copy(alpha = if (active) 1f else 0.35f))
                    )
                }
            }
        }
        
        // Bottom buttons
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (page < 2) {
                Text(
                    "Skip", 
                    color = slide.fg.copy(alpha = 0.7f), 
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { 
                            scope.launch { 
                                pagerState.animateScrollToPage(2) 
                            } 
                        }
                )
                Box(
                    Modifier
                        .widthIn(min = 200.dp)
                        .height(64.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(slide.ctaBg)
                        .clickable {
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            scope.launch { 
                                pagerState.animateScrollToPage(page + 1) 
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Next", 
                        color = slide.ctaFg, 
                        fontSize = 18.sp, 
                        fontWeight = FontWeight.SemiBold
                    )
                }
            } else {
                Text(
                    "Sign in", 
                    color = slide.fg.copy(alpha = 0.8f), 
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onSignIn() }
                )
                Box(
                    Modifier
                        .widthIn(min = 200.dp)
                        .height(64.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(slide.ctaBg)
                        .clickable { 
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            onCreateAccount() 
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Create Account", 
                        color = slide.ctaFg, 
                        fontSize = 18.sp, 
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
