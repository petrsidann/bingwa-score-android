package com.bingwascore.app.ui.onboarding

import android.app.Activity
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.bingwascore.app.ui.glass.PhaseCta
import com.bingwascore.app.ui.glass.PhaseMedallion
import com.bingwascore.app.ui.glass.PhaseSpringDots
import com.bingwascore.app.ui.glass.PhaseSurface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private data class Slide(
    val icon: ImageVector,
    val title: String,
    val body: String,
    val violet: Boolean
)

@Composable
fun OnboardingSlides(onCreateAccount: () -> Unit, onSignIn: () -> Unit) {
    val slides = listOf(
        Slide(lime, violet, violet.copy(alpha = 0.7f), "Auto-pilot payments", "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically.", violet, lime, header = true),
        Slide(violet, lime, lime.copy(alpha = 0.8f), "Smart retries & fallbacks", "Failed transaction? We retry with fallbacks so your customers stay happy.", lime, violet, header = false),
        Slide(ink, lime, Color.White.copy(alpha = 0.7f), "Score, streaks & rewards", "Earn points for every sale, build streaks and unlock achievements as you grow.", lime, ink, header = false),
        Slide(DesignTokens.Launch.ink, lime, Color.White.copy(alpha = 0.7f), "Import your customers", "Upload a CSV of your saved contacts to restore your customers, offers and USSD plans in one tap.", lime, CsvBlue, header = false)
    )
    val pagerState = rememberPagerState(pageCount = { slides.size })
    val scope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current
    val view = LocalView.current
    val context = LocalContext.current
    SideEffect {
        (view.context as? Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = false
        }
    }
    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage > 0) haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
    }
    BackHandler(enabled = pagerState.currentPage == 0) { (context as? Activity)?.finish() }

    Box(Modifier.fillMaxSize().background(PhaseSurface.Bg)) {
        HorizontalPager(state = pagerState, pageSize = PageSize.Fill, modifier = Modifier.fillMaxSize()) { page ->
            SlidePage(slides[page], page, pagerState, scope, onCreateAccount, onSignIn)
        }
    }
}

@Composable
private fun SlidePage(
    slide: Slide,
    page: Int,
    pagerState: PagerState,
    scope: CoroutineScope,
    onCreateAccount: () -> Unit,
    onSignIn: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    Box(Modifier.fillMaxSize().background(PhaseSurface.Bg)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 24.dp, end = 24.dp, bottom = 108.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "Skip",
                    color = PhaseSurface.Mut,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable { scope.launch { pagerState.animateScrollToPage(pagerState.pageCount - 1) } }
                )
            }
            Spacer(Modifier.weight(1f))
            PhaseMedallion(icon = slide.icon, violet = slide.violet)
            Spacer(Modifier.height(28.dp))
            Text(
                slide.title,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            Text(
                slide.body,
                color = PhaseSurface.Mut,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.weight(1f))
            PhaseSpringDots(count = 4, selected = page)
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = if (page < 3) Arrangement.Center else Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (page < 3) {
                PhaseCta(
                    label = "Next",
                    ready = true,
                    onClick = { scope.launch { pagerState.animateScrollToPage(page + 1) } }
                )
            } else {
                Text(
                    "Sign in",
                    color = PhaseSurface.Mut,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable { onSignIn() }
                )
                Spacer(Modifier.width(12.dp))
                Box(Modifier.widthIn(min = 200.dp)) {
                    PhaseCta(
                        label = "Create account",
                        ready = true,
                        onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); onCreateAccount() }
                    )
                }
            }
        }
    }
}
