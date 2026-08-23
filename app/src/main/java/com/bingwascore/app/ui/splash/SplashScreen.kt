package com.bingwascore.app.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Pink500
import com.bingwascore.app.ui.theme.Purple600
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    val scale = remember { Animatable(0.6f) }
    val alpha = remember { Animatable(0f) }
    val glowAlpha = remember { Animatable(0.3f) }

    LaunchedEffect(Unit) {
        // Scale up animation
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(800, easing = FastOutSlowInEasing)
        )
        
        // Fade in text
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(600)
        )
        
        // Infinite glow pulse animation
        glowAlpha.animateTo(
            targetValue = 0.6f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        // Wait then finish
        delay(2000)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(Orange500, Pink500, Purple600),
                    radius = 1200f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value)
        ) {
            // Premium logo box with glow
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .graphicsLayer {
                        shadowElevation = 20f
                        ambientShadowColor = Color.White
                        spotShadowColor = Color.White
                    }
                    .alpha(glowAlpha.value)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.3f),
                                Color.White.copy(alpha = 0.15f)
                            )
                        ),
                        RoundedCornerShape(32.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "B",
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold,
                    color = White,
                    modifier = Modifier.graphicsLayer {
                        shadowElevation = 10f
                    }
                )
            }
            
            Spacer(Modifier.height(28.dp))
            
            // App name
            Text(
                text = "Bingwa Score",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = White,
                letterSpacing = 1.sp,
                modifier = Modifier.graphicsLayer {
                    shadowElevation = 8f
                }
            )
            
            Spacer(Modifier.height(8.dp))
            
            // Tagline
            Text(
                text = "Bundles, delivered in seconds.",
                style = MaterialTheme.typography.bodyLarge,
                color = White.copy(alpha = 0.9f),
                letterSpacing = 0.5.sp
            )
            
            Spacer(Modifier.height(40.dp))
            
            // Loading indicator
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .background(
                        color = White.copy(alpha = glowAlpha.value),
                        shape = RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}
