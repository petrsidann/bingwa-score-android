package com.bingwascore.app.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.bingwascore.app.R
import com.bingwascore.app.ui.components.AmbientBackground
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TextSecondary
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter

/**
 * PARITY D — Cinematic splash:
 * - Background [NightBlack]; center app icon scales 0.8 → 1.0
 *   (spring, damping 0.7) with a fade-in.
 * - "Bingwa Score" (28sp bold white) fades in with 200ms delay.
 * - "Your bundle business, automated." (14sp [TextSecondary]) fades in
 *   with 400ms delay.
 * - Auto-navigates to Login (or Onboarding if first launch) after 1.5s
 *   via [LaunchedEffect]; holds longer only until [target] resolves.
 *
 * Total animation chain stays under 1.6 s. Behind everything the
 * [AmbientBackground] blobs drift slowly.
 */
@Composable
fun SplashScreen(target: String?, onFinish: (String) -> Unit) {
    // Cinematic tokens: icon scale 0.8 -> 1.0 (spring, damping 0.7);
    // wordmark alpha 0 -> 1 @200ms; tagline alpha 0 -> 1 @400ms.
    var iconTarget by remember { mutableStateOf(0.8f) }
    val iconScale by animateFloatAsState(
        targetValue = iconTarget,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = Spring.StiffnessLow),
        label = "splashIconScale"
    )
    var wordTarget by remember { mutableStateOf(0f) }
    val wordAlpha by animateFloatAsState(
        targetValue = wordTarget,
        animationSpec = tween(Motion.SPLASH_FADE),
        label = "splashWordAlpha"
    )
    var taglineTarget by remember { mutableStateOf(0f) }
    val taglineAlpha by animateFloatAsState(
        targetValue = taglineTarget,
        animationSpec = tween(Motion.SPLASH_FADE),
        label = "splashTaglineAlpha"
    )
    val currentTarget by rememberUpdatedState(target)
    val currentOnFinish by rememberUpdatedState(onFinish)

    LaunchedEffect(Unit) {
        // Kick the icon pop immediately (initial 0.8 -> 1.0).
        launch { iconTarget = 1f }
        // Wordmark fades in with 200ms delay…
        delay(200)
        wordTarget = 1f
        // …tagline with 400ms delay…
        delay(200)
        taglineTarget = 1f
        // …then auto-navigate after 1.5s total. Holds longer only
        // until UserPreferences resolves (a frame or two at most).
        delay(1100)
        var resolved = currentTarget
        while (resolved == null) {
            delay(50)
            resolved = currentTarget
        }
        currentOnFinish(resolved)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        AmbientBackground()

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Center: real app icon, 0.8 -> 1.0 spring pop.
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Bingwa Score",
                modifier = Modifier
                    .size(108.dp)
                    .scale(iconScale)
                    .alpha(iconScale.coerceIn(0f, 1f))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Below icon: wordmark 28sp bold white, alpha 0 -> 1 @200ms.
            Text(
                "Bingwa Score",
                color = White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(wordAlpha)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Below text: tagline 14sp secondary, alpha 0 -> 1 @400ms.
            Text(
                "Your bundle business, automated.",
                color = TextSecondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.alpha(taglineAlpha)
            )
        }
    }
}

