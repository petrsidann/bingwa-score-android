package com.bingwascore.app.ui.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        (view.context as? Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = false
        }
    }
    LaunchedEffect(Unit) { delay(350L); onFinished() }
    Box(Modifier.fillMaxSize().background(DesignTokens.Launch.violet), contentAlignment = Alignment.Center) {
        Text(
            text = "Bingwa Score", color = DesignTokens.Launch.lime, fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold, letterSpacing = (-1).sp, maxLines = 1,
            textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}
