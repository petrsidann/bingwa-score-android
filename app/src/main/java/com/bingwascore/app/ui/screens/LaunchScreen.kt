package com.bingwascore.app.ui.screens

import android.app.Activity
import android.view.View
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(onFinished: () -> Unit) {
    val entered = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        entered.value = true
        delay(1400L)
        onFinished()
    }
    val alpha by animateFloatAsState(if (entered.value) 1f else 0f, tween(300), label = "launchAlpha")
    val scale by animateFloatAsState(if (entered.value) 1f else 0.92f, spring(dampingRatio = 0.86f, stiffness = 380f), label = "launchScale")
    val context = LocalContext.current

    SideEffect {
        val activity = context as? Activity
        val decorView = activity?.window?.decorView
        decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    Box(
        Modifier.fillMaxSize().background(DesignTokens.Launch.lime),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Bingwa Score",
            color = DesignTokens.Launch.violet,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
                .graphicsLayer { this.alpha = alpha; scaleX = scale; scaleY = scale }
        )
    }
}
