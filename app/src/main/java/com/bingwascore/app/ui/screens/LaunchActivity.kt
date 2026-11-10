package com.bingwascore.app.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay

class LaunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BingwaScore_Launch)
        super.onCreate(savedInstanceState)
        setContent {
            LaunchAnimation(onComplete = {
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(0, 0)
                finish()
            })
        }
    }
}

@Composable
private fun LaunchAnimation(onComplete: () -> Unit) {
    var phase by remember { mutableStateOf(0) }
    val entered = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { entered.value = true }
    LaunchedEffect(Unit) {
        delay(1200L); phase = 1
        delay(860L); phase = 2
        delay(700L); onComplete()
    }
    val alpha by animateFloatAsState(if (entered.value) 1f else 0f, tween(120), label = "a")
    val scale by animateFloatAsState(if (entered.value) 1f else 0.4f, keyframes { durationMillis = 420; 0.4f at 0; 1.12f at 260; 1.0f at 420 }, label = "s")
    val circleScale by animateFloatAsState(
        targetValue = when { phase == 0 -> 0f; phase == 1 -> 0.22f; else -> 1f },
        animationSpec = if (phase == 1) tween(260) else tween(700, easing = FastOutLinearInEasing),
        label = "c"
    )
    val wordmarkColor = if (phase >= 1) DesignTokens.Launch.lime else DesignTokens.Launch.violet
    Box(Modifier.fillMaxSize().background(DesignTokens.Launch.lime), contentAlignment = Alignment.Center) {
        Box(Modifier.size(2400.dp).clip(CircleShape).background(DesignTokens.Launch.violet).graphicsLayer { scaleX = circleScale; scaleY = circleScale })
        Text("Bingwa Score", color = wordmarkColor, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer { this.alpha = alpha; scaleX = scale; scaleY = scale })
    }
}
