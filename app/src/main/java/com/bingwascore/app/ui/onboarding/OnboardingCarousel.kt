package com.bingwascore.app.ui.onboarding

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoMode
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

private data class OnboardingSlide(val icon: ImageVector, val title: String, val body: String)

@Composable
fun OnboardingCarousel(
    onGetStarted: () -> Unit,
    page: Int = 0,
    onPageChange: (Int) -> Unit = {}
) {
    val slides = remember {
        listOf(
            OnboardingSlide(Icons.Rounded.AutoMode, "Auto-pilot payments",
                "Bingwa Score watches for M-Pesa confirmations and dials bundles automatically."),
            OnboardingSlide(Icons.Rounded.Refresh, "Smart retries & fallbacks",
                "Failed transaction? We retry with fallbacks so your customers stay happy."),
            OnboardingSlide(Icons.Rounded.EmojiEvents, "Score, streaks & rewards",
                "Earn points for every sale, build streaks and unlock achievements as you grow.")
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().background(NightBlack).statusBarsPadding()
            .navigationBarsPadding().padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text("Bingwa Score", color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Your bundle business, automated.", color = White.copy(alpha = 0.5f), fontSize = 13.sp)
        Spacer(modifier = Modifier.height(48.dp))

        val slide = slides[page]
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.size(80.dp).clip(CircleShape)
                    .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue))),
                    contentAlignment = Alignment.Center) {
                    Icon(slide.icon, contentDescription = null, tint = NightBlack, modifier = Modifier.size(40.dp))
                }
                Spacer(modifier = Modifier.height(28.dp))
                Text(slide.title, color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(12.dp))
                Text(slide.body, color = White.copy(alpha = 0.6f), fontSize = 14.sp, textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp))
            }
        }

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            slides.forEachIndexed { index, _ ->
                Box(modifier = Modifier.padding(horizontal = 4.dp)
                    .size(if (index == page) 10.dp else 8.dp).clip(CircleShape)
                    .background(if (index == page) EmeraldGreen else White.copy(alpha = 0.3f)))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (page > 0) {
                GradientButton(text = "Back", onClick = { onPageChange(page - 1) }, modifier = Modifier.width(120.dp))
            } else Spacer(modifier = Modifier.width(120.dp))
            GradientButton(
                text = if (page == slides.lastIndex) "Get Started" else "Next",
                onClick = { if (page == slides.lastIndex) onGetStarted() else onPageChange(page + 1) },
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}
