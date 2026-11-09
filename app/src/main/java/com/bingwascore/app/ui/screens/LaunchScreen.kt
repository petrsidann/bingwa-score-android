package com.bingwascore.app.ui.screens

import android.app.Activity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    SideEffect {
        val window = (view.context as? Activity)?.window
        if (window != null) {
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
    val entered = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        entered.value = true
        delay(1400L)
        onFinished()
    }
    // BURST: Fast alpha, snappy spring from 0.5 scale
    val alpha by animateFloatAsState(
        if (entered.value) 1f else 0f, 
        tween(durationMillis = 200), 
        label = "launchAlpha"
    )
    val scale by animateFloatAsState(
        if (entered.value) 1f else 0.5f,
        spring(dampingRatio = 0.6f, stiffness = 500f), 
        label = "launchScale"
    )
    Box(
        modifier = Modifier.fillMaxSize().background(DesignTokens.Launch.lime),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Bingwa Score",
            color = DesignTokens.Launch.violet,
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
