package com.bingwascore.app.ui.screens

import android.app.Activity
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(onFinished: () -> Unit) {
    val view = LocalView.current
    var phase by remember { mutableStateOf(0) }
    val entered = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { entered.value = true }
    LaunchedEffect(Unit) {
        delay(1400L)
        phase = 1
        delay(600L)
        phase = 2
        delay(200L)
        onFinished()
    }
    SideEffect {
        (view.context as? Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = phase < 1
        }
    }
    val alpha by animateFloatAsState(
        targetValue = if (entered.value) 1f else 0f,
        animationSpec = tween(durationMillis = 120),
        label = "launchAlpha"
    )
    val scale by animateFloatAsState(
        targetValue = if (entered.value) 1f else 0.4f,
        animationSpec = keyframes {
            durationMillis = 420
            0.4f at 0
            1.12f at 260
            1.0f at 420
        },
        label = "launchScale"
    )
    val wordmarkColor by animateColorAsState(
        targetValue = if (phase >= 1) DesignTokens.Launch.lime else DesignTokens.Launch.violet,
        animationSpec = tween(durationMillis = 200),
        label = "wordmarkColor"
    )
    val circleScale by animateFloatAsState(
        targetValue = if (phase >= 1) 1f else 0f,
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing),
        label = "circleScale"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DesignTokens.Launch.lime),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(2400.dp)
                .clip(CircleShape)
                .background(DesignTokens.Launch.violet)
                .graphicsLayer {
                    scaleX = circleScale
                    scaleY = circleScale
                }
        )
        Text(
            text = "Bingwa Score",
            color = wordmarkColor,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .graphicsLayer {
                    this.alpha = alpha
                    scaleX = scale
                    scaleY = scale
                }
        )
    }
}
