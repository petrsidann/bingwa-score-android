package com.bingwascore.app.ui.screens

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.view.WindowCompat
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay
import kotlin.math.hypot

/**
 * Stage 59 — InstanT-style launch reveal.
 *
 * A true circle (Canvas.drawCircle, never a clipped box) seeds at dead centre
 * and sweeps to the screen half-diagonal. The wordmark yields to the seed dot,
 * then is reborn in lime on violet as the sweep passes. All beats are tuned
 * here — nothing else in the app references these numbers.
 */
private object LaunchChoreography {
    const val WORDMARK_IN = 420L        // violet wordmark spring-in
    const val DOT_POP = 260L            // seed dot pop (overshoot 1.15)
    const val DOT_HOLD = 220L           // the "lil circle" beat
    const val REVEAL = 620L             // circular sweep to full bleed
    const val END_HOLD = 420L           // settle on violet before hand-off
    const val DOT_RADIUS_DP = 14f       // 28dp seed dot
    const val REBORN_FROM = 0.70f       // lime wordmark starts at 70% sweep
    const val REBORN_TO = 0.95f         // ...fully landed by 95%
    const val BARS_FLIP_AT = 0.85f      // bar icons flip light at 85% sweep
    val RevealEasing = CubicBezierEasing(0.3f, 0f, 0.2f, 1f)
}

class LaunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BingwaScore_Launch)
        super.onCreate(savedInstanceState)
        // Full-bleed: the lime field (and later the violet sweep) draws behind
        // transparent bars; icon tint is flipped by the choreography below.
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT)
        )
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
    val view = LocalView.current
    val context = LocalContext.current
    val inspection = LocalInspectionMode.current
    val reducedMotion = remember(context) {
        Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) == 0f
    }
    val landed = inspection || reducedMotion

    // phase: 0 wordmark-in · 1 dot pop+hold · 2 reveal · 3 end hold
    var phase by remember { mutableStateOf(if (landed) 3 else 0) }
    var started by remember { mutableStateOf(landed) }

    LaunchedEffect(Unit) {
        if (inspection) return@LaunchedEffect
        if (reducedMotion) { delay(900L); onComplete(); return@LaunchedEffect }
        started = true
        delay(LaunchChoreography.WORDMARK_IN); phase = 1
        delay(LaunchChoreography.DOT_POP + LaunchChoreography.DOT_HOLD); phase = 2
        delay(LaunchChoreography.REVEAL); phase = 3
        delay(LaunchChoreography.END_HOLD); onComplete()
    }

    val wordmarkInAlpha by animateFloatAsState(
        targetValue = if (started) 1f else 0f,
        animationSpec = if (inspection) snap() else tween(150), label = "wmInA"
    )
    val wordmarkInScale by animateFloatAsState(
        targetValue = if (started) 1f else 0.4f,
        animationSpec = if (inspection) snap() else keyframes {
            durationMillis = LaunchChoreography.WORDMARK_IN.toInt()
            0.4f at 0; 1.12f at 260; 1.0f at LaunchChoreography.WORDMARK_IN.toInt()
        }, label = "wmInS"
    )
    val wordmarkYield by animateFloatAsState(
        targetValue = if (phase >= 1) 0f else 1f,
        animationSpec = if (inspection) snap() else tween(120), label = "wmYield"
    )
    val dotScale by animateFloatAsState(
        targetValue = if (phase >= 1) 1f else 0f,
        animationSpec = if (inspection) snap() else keyframes {
            durationMillis = LaunchChoreography.DOT_POP.toInt()
            0f at 0; 1.15f at 160; 1f at LaunchChoreography.DOT_POP.toInt()
        }, label = "dot"
    )
    val reveal by animateFloatAsState(
        targetValue = if (phase >= 2) 1f else 0f,
        animationSpec = if (inspection) snap() else tween(LaunchChoreography.REVEAL.toInt(), easing = LaunchChoreography.RevealEasing),
        label = "reveal"
    )
    val reborn = ((reveal - LaunchChoreography.REBORN_FROM) / (LaunchChoreography.REBORN_TO - LaunchChoreography.REBORN_FROM)).coerceIn(0f, 1f)
    val barsCovered = phase >= 2 && reveal >= LaunchChoreography.BARS_FLIP_AT

    SideEffect {
        (view.context as? android.app.Activity)?.window?.let { w ->
            WindowCompat.getInsetsController(w, view).apply {
                isAppearanceLightStatusBars = !barsCovered
                isAppearanceLightNavigationBars = !barsCovered
            }
        }
    }

    val lime = DesignTokens.Launch.lime
    val violet = DesignTokens.Launch.violet
    val dotPx = with(LocalDensity.current) { LaunchChoreography.DOT_RADIUS_DP.dp.toPx() }
    val risePx = with(LocalDensity.current) { 6.dp.toPx() }

    Box(Modifier.fillMaxSize().background(lime), contentAlignment = Alignment.Center) {
        // The reveal: a mathematical circle at every frame — no clipped boxes,
        // no giant offscreen layers, no oval possible.
        Canvas(Modifier.fillMaxSize()) {
            if (phase >= 1) {
                val maxRadius = hypot(size.width, size.height) / 2f + 2f
                val radius = if (phase < 2) dotPx * dotScale else lerp(dotPx, maxRadius, reveal)
                if (radius > 0f) drawCircle(color = violet, radius = radius, center = center)
            }
        }
        // Violet wordmark: springs in on lime, yields as the seed dot pops.
        Text(
            text = "Bingwa Score", color = violet, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer {
                alpha = wordmarkInAlpha * wordmarkYield
                scaleX = wordmarkInScale; scaleY = wordmarkInScale
            }
        )
        // Lime wordmark: reborn on violet as the sweep passes behind it.
        Text(
            text = "Bingwa Score", color = lime, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer {
                alpha = reborn
                translationY = (1f - reborn) * risePx
                val s = 0.96f + 0.04f * reborn
                scaleX = s; scaleY = s
            }
        )
    }
}
