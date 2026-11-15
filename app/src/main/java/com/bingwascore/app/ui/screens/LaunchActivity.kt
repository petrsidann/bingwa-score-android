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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.view.WindowCompat
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay
import kotlin.math.hypot

/**
 * Stage 59.3 — DEFINITIVE InstanT reveal.
 * The lil violet dot exists from the first frame (the theme starting window
 * shows it too, so a cold start never shows a blank lime void). The wordmark
 * stays visible and inverts violet->lime exactly as the true circle sweeps
 * behind it. One continuous motion; no hide/rebirth, no oval, no void.
 */
private object LaunchChoreography {
    const val WORDMARK_IN = 420L
    const val DOT_HOLD = 300L
    const val REVEAL = 620L
    const val END_HOLD = 420L
    const val DOT_RADIUS_DP = 14f
    const val WM_OFFSET = 0.12f      // wordmark sits this fraction of height above centre
    const val WM_HALF = 0.045f       // wordmark half-height fraction (inversion window)
    val RevealEasing = CubicBezierEasing(0.3f, 0f, 0.2f, 1f)
}

class LaunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BingwaScore_Launch)
        super.onCreate(savedInstanceState)
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

    // phase 0 = dot hold + wordmark in · 1 = reveal · 2 = end hold
    var phase by remember { mutableStateOf(if (landed) 2 else 0) }
    var boxSize by remember { mutableStateOf(IntSize.Zero) }

    LaunchedEffect(Unit) {
        if (inspection) return@LaunchedEffect
        if (reducedMotion) { delay(900L); onComplete(); return@LaunchedEffect }
        delay(LaunchChoreography.WORDMARK_IN + LaunchChoreography.DOT_HOLD); phase = 1
        delay(LaunchChoreography.REVEAL); phase = 2
        delay(LaunchChoreography.END_HOLD); onComplete()
    }

    val wordmarkInAlpha by animateFloatAsState(
        targetValue = if (landed) 1f else 1f,
        animationSpec = if (inspection) snap() else tween(150), label = "wmA"
    )
    val wordmarkInScale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = if (inspection) snap() else keyframes {
            durationMillis = LaunchChoreography.WORDMARK_IN.toInt()
            0.4f at 0; 1.12f at 260; 1.0f at LaunchChoreography.WORDMARK_IN.toInt()
        }, label = "wmS"
    )
    val reveal by animateFloatAsState(
        targetValue = if (phase >= 1) 1f else 0f,
        animationSpec = if (inspection) snap() else tween(LaunchChoreography.REVEAL.toInt(), easing = LaunchChoreography.RevealEasing),
        label = "reveal"
    )

    val lime = DesignTokens.Launch.lime
    val violet = DesignTokens.Launch.violet
    val dotPx = with(LocalDensity.current) { LaunchChoreography.DOT_RADIUS_DP.dp.toPx() }

    val w = boxSize.width.toFloat()
    val h = boxSize.height.toFloat()
    val maxR = if (w > 0f && h > 0f) hypot(w, h) / 2f + 2f else 0f
    val radius = when {
        landed -> maxR
        phase < 1 -> dotPx
        else -> lerp(dotPx, maxR, reveal)
    }
    // Wordmark inverts exactly as the circle's edge crosses it.
    val coverStart = h * (LaunchChoreography.WM_OFFSET - LaunchChoreography.WM_HALF)
    val coverEnd = h * (LaunchChoreography.WM_OFFSET + LaunchChoreography.WM_HALF)
    val limeAlpha = if (h > 0f && coverEnd > coverStart) ((radius - coverStart) / (coverEnd - coverStart)).coerceIn(0f, 1f) else 0f
    val barsCovered = h > 0f && radius >= h * 0.49f

    SideEffect {
        (view.context as? android.app.Activity)?.window?.let { cw ->
            WindowCompat.getInsetsController(cw, view).apply {
                isAppearanceLightStatusBars = !barsCovered
                isAppearanceLightNavigationBars = !barsCovered
            }
        }
    }

    Box(
        Modifier.fillMaxSize().background(lime).onSizeChanged { boxSize = it },
        contentAlignment = Alignment.Center
    ) {
        Canvas(Modifier.fillMaxSize()) {
            if (radius > 0f) drawCircle(color = violet, radius = radius, center = Offset(size.width / 2f, size.height / 2f))
        }
        // Violet wordmark (fades out as the circle arrives behind it).
        Text(
            text = "Bingwa Score", color = violet, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer {
                alpha = wordmarkInAlpha * (1f - limeAlpha)
                translationY = -LaunchChoreography.WM_OFFSET * size.height
                scaleX = wordmarkInScale; scaleY = wordmarkInScale
            }
        )
        // Lime wordmark (fades in on the violet, same position).
        Text(
            text = "Bingwa Score", color = lime, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer {
                alpha = limeAlpha
                translationY = -LaunchChoreography.WM_OFFSET * size.height
                scaleX = wordmarkInScale; scaleY = wordmarkInScale
            }
        )
        if (BuildConfig.DEBUG) {
            Text(
                text = "s59.3", fontSize = 10.sp, fontWeight = FontWeight.Bold,
                color = if (barsCovered) lime else violet,
                modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp)
            )
        }
    }
}
