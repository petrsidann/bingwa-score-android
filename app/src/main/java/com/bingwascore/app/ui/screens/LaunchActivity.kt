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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.view.WindowCompat
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity
import com.bingwascore.app.ui.theme.DesignTokens
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.hypot
import kotlin.math.sin
import kotlin.math.sqrt

private object LaunchChoreography {
    const val WORDMARK_IN = 180L
    const val POP = 700L
    const val DOT_HOLD = 80L
    const val REVEAL = 420L
    const val END_HOLD = 180L
    const val DOT_RADIUS_DP = 16f
    const val NATURAL_PERIOD = 340L
    const val DAMPING_RATIO = 0.20f
    const val OVERSHOOT = 1.32f
    const val SQUASH = 0.38f
    const val SCALE_LAG = 180L
    const val ASPECT_LAG = 240L
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

private class OvalRevealShape(private val rx: Float, private val ry: Float) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val cx = size.width / 2f
        val cy = size.height / 2f
        val path = Path()
        path.addOval(Rect(cx - rx, cy - ry, cx + rx, cy + ry))
        return Outline.Generic(path)
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

    var phase by remember { mutableStateOf(if (landed) 2 else 0) }
    var boxSize by remember { mutableStateOf(IntSize.Zero) }
    var physicsScale by remember { mutableStateOf(0f) }
    var physicsAspect by remember { mutableStateOf(1f) }

    LaunchedEffect(Unit) {
        if (inspection) return@LaunchedEffect
        if (reducedMotion) { delay(900L); onComplete(); return@LaunchedEffect }
        delay(LaunchChoreography.WORDMARK_IN + LaunchChoreography.POP + LaunchChoreography.DOT_HOLD); phase = 1
        delay(LaunchChoreography.REVEAL); phase = 2
        delay(LaunchChoreography.END_HOLD); onComplete()
    }

    LaunchedEffect(Unit) {
        if (inspection || reducedMotion) return@LaunchedEffect
        val wn = 2.0 * PI / (LaunchChoreography.NATURAL_PERIOD / 1000.0)
        val z = LaunchChoreography.DAMPING_RATIO.toDouble()
        val target = LaunchChoreography.OVERSHOOT.toDouble()
        val wd = wn * sqrt(1.0 - z * z)
        val maxV = (wn * target * 0.4).coerceAtLeast(0.0001)
        val popSec = LaunchChoreography.POP / 1000.0
        val lagS = LaunchChoreography.SCALE_LAG / 1000.0
        val lagA = LaunchChoreography.ASPECT_LAG / 1000.0
        var t = 0.0
        var smoothS = 0.0
        var smoothA = 1.0

        fun raw(u: Double): Double {
            if (u <= 0.0) return 0.0
            return target * (1.0 - exp(-z * wn * u) * (cos(wd * u) + (z * wn / wd) * sin(wd * u)))
        }

        while (t < popSec) {
            val r = raw(t)
            val alphaS = 1.0 - exp(-t / lagS)
            smoothS += (r - smoothS) * alphaS
            val tNext = (t + 0.004).coerceAtMost(popSec)
            val v = (raw(tNext) - r) / (tNext - t + 0.0001)
            val k = (v / maxV).coerceIn(-1.5, 1.5)
            val rawAspect = 1.0 + LaunchChoreography.SQUASH.toDouble() * k
            val alphaA = 1.0 - exp(-t / lagA)
            smoothA = (smoothA + (rawAspect - smoothA) * alphaA).coerceIn(0.3, 2.2)
            physicsScale = smoothS.toFloat()
            physicsAspect = smoothA.toFloat()
            t += 1.0 / 60.0
            delay(16)
        }
        physicsScale = 1f
        physicsAspect = 1f
    }

    val wordmarkInAlpha by animateFloatAsState(targetValue = 1f, animationSpec = if (inspection) snap() else tween(150), label = "wmA")
    val wordmarkInScale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = if (inspection) snap() else tween(LaunchChoreography.WORDMARK_IN.toInt()),
        label = "wmS"
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
        phase < 1 -> dotPx * physicsScale
        else -> lerp(dotPx, maxR, reveal)
    }
    val aspect = if (phase < 1) physicsAspect else 1f
    val rx = radius * aspect
    val ry = radius / aspect
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
            if (radius > 0f) drawOval(color = violet, topLeft = Offset(center.x - rx, center.y - ry), size = Size(rx * 2f, ry * 2f))
        }
        Text(
            text = "Bingwa Score", color = violet, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer { alpha = wordmarkInAlpha; scaleX = wordmarkInScale; scaleY = wordmarkInScale }
        )
        Text(
            text = "Bingwa Score", color = lime, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-1).sp, maxLines = 1, textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp).graphicsLayer {
                alpha = if (radius > 0f) 1f else 0f
                clip = radius > 0f
                shape = OvalRevealShape(rx, ry)
            }
        )
        if (BuildConfig.DEBUG) {
            Text(text = "s59.10", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = if (barsCovered) lime else violet, modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp))
        }
    }
}
