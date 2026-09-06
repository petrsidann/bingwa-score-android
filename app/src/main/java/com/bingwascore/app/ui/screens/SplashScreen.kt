package com.bingwascore.app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.AmbientBackground
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Splash reveal — staggered hero entrance:
 *   logo scale 0.8→1 (spring) → wordmark fade-up → tagline fade-up.
 *
 * Total animation chain stays under 1.6 s. Behind everything the
 * [AmbientBackground] blobs drift slowly.
 */
@Composable
fun SplashScreen(onNavigateToLogin: () -> Unit) {
    val logoScale = remember { Animatable(0.8f) }
    val logoAlpha = remember { Animatable(0f) }
    val wordAlpha = remember { Animatable(0f) }
    val wordOffset = remember { Animatable(24f) }
    val taglineAlpha = remember { Animatable(0f) }
    val taglineOffset = remember { Animatable(16f) }

    LaunchedEffect(Unit) {
        // Logo: fade in + springy scale-up
        launch { logoAlpha.animateTo(1f, tween(300)) }
        launch { logoScale.animateTo(1f, spring(dampingRatio = Motion.DAMPING)) }
        delay(250)

        // Wordmark: fade up
        launch { wordAlpha.animateTo(1f, tween(300)) }
        launch { wordOffset.animateTo(0f, tween(300)) }
        delay(150)

        // Tagline: fade up
        launch { taglineAlpha.animateTo(1f, tween(250)) }
        launch { taglineOffset.animateTo(0f, tween(250)) }
        delay(200)

        onNavigateToLogin()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        AmbientBackground()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = logoScale.value
                        scaleY = logoScale.value
                        alpha = logoAlpha.value
                    }
                    .size(96.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue))),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "B",
                    color = NightBlack,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Bingwa Score",
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer {
                    alpha = wordAlpha.value
                    translationY = wordOffset.value
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Your M-Pesa business, automated.",
                color = White.copy(alpha = 0.5f),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.graphicsLayer {
                    alpha = taglineAlpha.value
                    translationY = taglineOffset.value
                }
            )
        }
    }
}

