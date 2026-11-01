package com.bingwascore.app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.brand.BrandWordmark
import com.bingwascore.app.ui.components.Monogram
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.isPorcelain
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.bingwascore.app.ui.theme.ObsidianBg
import com.bingwascore.app.ui.theme.SplashDimBg
import com.bingwascore.app.ui.theme.SplashDimInk
import com.bingwascore.app.ui.theme.SplashDimPastelBlue

object SplashBrand {
    /** Stage 21 — the wordmark is ONE constant for the whole app. */
    const val WORDMARK: String = BrandWordmark.TEXT
    const val TAGLINE = "Your bundle business, automated."
}

/**
 * Stage 43 — the splash ink, per theme:
 * white ink on obsidian, #1E293B ink on dim porcelain.
 */
internal fun splashInk(dark: Boolean): Color = if (dark) Color(0xFFFFFFFF) else SplashDimInk

/** Stage 43 — canvas color per theme: #0F172A on Obsidian, #EAF0F6 on Dim. */
internal fun splashCanvas(dark: Boolean): Color = if (dark) ObsidianBg else SplashDimBg

/**
 * Stage 21/43 — the resting halo behind the monogram.
 */
internal fun splashGlowAlpha(dark: Boolean): Float = if (dark) 0.35f else 0.45f

/** Stage 43 — radial glow color: #2563EB on Obsidian, pastel-blue on Dim. */
internal fun splashGlowColor(dark: Boolean): Color = if (dark) Color(0xFF2563EB) else SplashDimPastelBlue

/** Stage 20 — soft blue radial glow behind the monogram, both themes. */
internal val splashGlow: Brush
    get() = Brush.radialGradient(
        colors = listOf(AccentBlue.copy(alpha = 0.24f), Color.Transparent)
    )

/**
 * Stage 43 — AURORA SNAP SPLASH:
 *
 * 0.0-0.2s: aurora glow fades in (Obsidian: #0F172A canvas + #2563EB radial glow; Dim: #EAF0F6 canvas + pastel-blue glow)
 * 0.2-0.5s: 'B' monogram snaps in with spring overshoot + micro-ripple ring
 * 0.5-0.8s: monogram fills (white ink on Obsidian / #1E293B ink on Dim) + tagline "Your bundle business, automated." fades up
 * 0.8-1.3s: whole screen scales 1.0 -> 1.04 + cross-fades to next screen
 *
 * Total duration <= 1.3s ([Motion.SPLASH_TOTAL]).
 */
@Composable
fun SplashScreen(target: String?, onFinish: (String) -> Unit) {
    SplashScreenContent(target = target, onFinish = onFinish)
}

/**
 * Stage 43 — Aurora Snap Splash pure surface.
 *
 * [settled] renders the frame the choreography lands on.
 * [progressMs] renders the exact frame at millisecond timestamp (for 0.3s/0.6s/1.0s snapshots).
 */
@Composable
fun SplashScreenContent(
    target: String?,
    onFinish: (String) -> Unit,
    settled: Boolean = false,
    progressMs: Int? = null
) {
    val currentTarget by rememberUpdatedState(target)
    val currentOnFinish by rememberUpdatedState(onFinish)
    val scope = rememberCoroutineScope()

    if (settled || progressMs != null) {
        val ms = progressMs ?: 800
        val isDark = !isPorcelain

        // 0.0 - 0.2s: glow fades in 0 -> 1
        val glowVal = (ms / 200f).coerceIn(0f, 1f)

        // 0.2 - 0.5s: monogram snaps in with spring overshoot
        val (snapScaleVal, monogramAlphaVal) = when {
            ms < 200 -> 0f to 0f
            ms < 380 -> {
                val f = (ms - 200) / 180f
                (0.3f + 0.78f * f) to 1f
            }
            ms < 500 -> {
                val f = (ms - 380) / 120f
                (1.08f - 0.08f * f) to 1f
            }
            else -> 1.0f to 1f
        }

        // micro-ripple ring expands 0.2s - 0.5s
        val rippleVal = if (ms < 200) 0f else ((ms - 200) / 300f).coerceIn(0f, 1f)

        // 0.5 - 0.8s: monogram fill & tagline fade up
        val fillVal = if (ms < 500) 0f else ((ms - 500) / 300f).coerceIn(0f, 1f)
        val taglineVal = if (ms < 500) 0f else ((ms - 500) / 300f).coerceIn(0f, 1f)

        // 0.8 - 1.3s: whole screen scales 1.0 -> 1.04 and cross-fades out
        val exitT = if (ms < 800) 0f else ((ms - 800) / 500f).coerceIn(0f, 1f)
        val screenScaleVal = 1.0f + 0.04f * exitT
        val screenAlphaVal = 1.0f - exitT

        SplashStageSnap(
            isDark = isDark,
            glowAlpha = glowVal,
            snapScale = snapScaleVal,
            monogramAlpha = monogramAlphaVal,
            ripple = rippleVal,
            fillAlpha = fillVal,
            taglineAlpha = taglineVal,
            screenScale = screenScaleVal,
            screenAlpha = screenAlphaVal,
            skipReady = true
        )
        return
    }

    val glow = remember { Animatable(0f) }
    val snapScale = remember { Animatable(0f) }
    val monogramAlpha = remember { Animatable(0f) }
    val ripple = remember { Animatable(0f) }
    val fillAlpha = remember { Animatable(0f) }
    val taglineAlpha = remember { Animatable(0f) }
    val screenScale = remember { Animatable(1.0f) }
    val screenAlpha = remember { Animatable(1.0f) }
    val exitShrink = remember { Animatable(0f) }
    var skipReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // 0.0 - 0.2s: aurora glow fades in
        launch {
            glow.animateTo(1f, tween(200, easing = LinearEasing))
        }

        // 0.2 - 0.5s: 'B' monogram snaps in with spring overshoot + micro-ripple ring
        launch {
            delay(200)
            launch {
                monogramAlpha.animateTo(1f, tween(100))
            }
            launch {
                snapScale.snapTo(0.3f)
                snapScale.animateTo(1.08f, spring(dampingRatio = 0.45f, stiffness = 900f))
                snapScale.animateTo(1f, tween(120, easing = FastOutSlowInEasing))
            }
            launch {
                ripple.animateTo(1f, tween(300, easing = FastOutSlowInEasing))
            }
        }

        // 0.5 - 0.8s: monogram fills + tagline fades up
        launch {
            delay(500)
            launch {
                fillAlpha.animateTo(1f, tween(300, easing = FastOutSlowInEasing))
            }
            launch {
                taglineAlpha.animateTo(1f, tween(300, easing = FastOutSlowInEasing))
            }
        }

        launch {
            delay(900)
            skipReady = true
        }

        // 0.8 - 1.3s: whole screen scales 1.0 -> 1.04 + cross-fades to next screen
        delay(800)
        launch {
            exitShrink.animateTo(1f, tween(200))
        }
        launch {
            screenScale.animateTo(1.04f, tween(500, easing = FastOutSlowInEasing))
        }
        screenAlpha.animateTo(0f, tween(500, easing = FastOutSlowInEasing))

        var resolved = currentTarget
        while (resolved == null) {
            delay(20)
            resolved = currentTarget
        }
        currentOnFinish(resolved)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(enabled = skipReady, onClick = {
                scope.launch {
                    exitShrink.animateTo(1f, tween(150))
                    screenAlpha.animateTo(0f, tween(150))
                    currentOnFinish(currentTarget ?: "")
                }
            })
    ) {
        SplashStageSnap(
            isDark = !isPorcelain,
            glowAlpha = glow.value,
            snapScale = snapScale.value,
            monogramAlpha = monogramAlpha.value,
            ripple = ripple.value,
            fillAlpha = fillAlpha.value,
            taglineAlpha = taglineAlpha.value,
            screenScale = screenScale.value,
            screenAlpha = screenAlpha.value,
            skipReady = skipReady
        )
    }
}

/**
 * Stage 43 — Aurora Snap Splash layout.
 */
@Composable
private fun SplashStageSnap(
    isDark: Boolean,
    glowAlpha: Float,
    snapScale: Float,
    monogramAlpha: Float,
    ripple: Float,
    fillAlpha: Float,
    taglineAlpha: Float,
    screenScale: Float,
    screenAlpha: Float,
    skipReady: Boolean
) {
    val canvasBg = splashCanvas(isDark)
    val glowColor = splashGlowColor(isDark)
    val ink = splashInk(dark = isDark)
    val density = LocalDensity.current.density

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(canvasBg)
            .graphicsLayer {
                scaleX = screenScale
                scaleY = screenScale
                alpha = screenAlpha
            }
    ) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(340.dp)
        ) {
            val maxAlpha = splashGlowAlpha(isDark)
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        glowColor.copy(alpha = maxAlpha * glowAlpha),
                        glowColor.copy(alpha = maxAlpha * 0.4f * glowAlpha),
                        Color.Transparent
                    ),
                    center = center,
                    radius = size.minDimension / 1.7f
                ),
                radius = size.minDimension / 1.7f
            )

            // Micro-ripple ring from snap (0.2s - 0.5s)
            if (ripple > 0.01f && ripple < 1f) {
                drawCircle(
                    color = glowColor.copy(alpha = 0.45f * (1f - ripple)),
                    radius = size.minDimension * (0.22f + 0.48f * ripple),
                    center = center,
                    style = Stroke(width = 2f)
                )
            }
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier
                    .size(132.dp)
                    .graphicsLayer {
                        scaleX = snapScale
                        scaleY = snapScale
                        alpha = monogramAlpha
                    }
            ) {
                drawSnapMonogram(fillAlpha = fillAlpha, ink = ink)
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = SplashBrand.TAGLINE,
                color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B),
                fontSize = BingwaType.Footnote,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .alpha(taglineAlpha)
                    .graphicsLayer { translationY = (1f - taglineAlpha) * 12f * density }
            )
        }
    }
}

/**
 * Stage 43 — Draws the 'B' monogram with stroke and smooth fill transition (0.5s - 0.8s).
 */
private fun DrawScope.drawSnapMonogram(fillAlpha: Float, ink: Color) {
    val zoom = size.minDimension / 108f
    scale(zoom, zoom, pivot = Offset.Zero) {
        drawPath(
            path = Monogram.path,
            color = ink,
            style = Stroke(
                width = Monogram.STROKE_WIDTH,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
        if (fillAlpha > 0.01f) {
            drawPath(
                path = Monogram.path,
                color = ink.copy(alpha = fillAlpha)
            )
        }
    }
}

/** Stage 24 — wordmark rendered directly on the canvas colour (no curtain). */
@Composable
private fun MaskSweepWordmark(text: String, sweep: Float, ink: Color) {
    val density = LocalDensity.current.density
    Row(
        modifier = Modifier
            .size(260.dp, 40.dp)
            .graphicsLayer {
                scaleX = 0.92f + 0.08f * sweep
                scaleY = 0.92f + 0.08f * sweep
                translationY = (1f - sweep) * 8f * density
                alpha = sweep
            }
    ) {
        text.forEachIndexed { index, char ->
            Text(
                text = char.toString(),
                color = ink,
                fontSize = BingwaType.Title,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

internal val SPLASH_WORDMARK: String = BrandWordmark.TEXT

/**
 * One alpha per letter of [text], from [progress] (0..1 across the wordmark
 * window). Always returns exactly `text.length` entries — the wordmark is never
 * shortened, only faded — so a refactor that sliced the text would fail
 * the splash choreography test instead of shipping a splash that
 * spells "Bingwa Scor".
 */
internal fun wordmarkAlphas(text: String, progress: Float): List<Float> {
    // Stage 21 — the window reaches the FULL length: capping it at
    // `length - 1` left the last letter stuck at zero alpha, which is how the
    // splash shipped "Bingwa Scor" instead of "Bingwa Score".
    val capped = progress.coerceIn(0f, text.length.toFloat())
    return List(text.length) { index -> (capped - index).coerceIn(0f, 1f) }
}

/**
 * Stage 11 — letters rise on spring stagger: each glyph owns a slice of the
 * wordmark window and springs up (scale + rise, damping 0.86) while fading in.
 * The FULL string is always composed — [wordmarkAlphas] returns one alpha per
 * letter, so a refactor that sliced the text fails the regression test.
 */
@Composable
private fun StaggeredWordmark(text: String, clock: Float, ink: Color = TextWhite) {
    // The clock runs across the wordmark window; map it onto 0..1.
    val windowMillis = Motion.SPLASH_TAGLINE_START - Motion.SPLASH_WORDMARK_START
    val elapsed = (clock * windowMillis).toInt()
    val progress = (elapsed / Motion.SPLASH_LETTER_STAGGER.toFloat())

    val alphas = wordmarkAlphas(text, progress)

    Row {
        text.forEachIndexed { index, char ->
            val local = alphas.getOrElse(index) { 0f }
            Text(
                text = char.toString(),
                color = ink,
                fontSize = BingwaType.Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer {
                    alpha = local
                    // Spring stagger: rise + settle (overshoot reads as spring).
                    val settle = (local * 1.06f).coerceAtMost(1f)
                    translationY = (1f - settle) * 10f * density
                    scaleX = 0.92f + 0.08f * settle
                    scaleY = 0.92f + 0.08f * settle
                }
            )
        }
    }
}
/**
 * Stage 11 — glowing traveling tip: a hot dot riding the stroke head while
 * the PathMeasure draws. Position is sampled from the same [Monogram.path].
 * [ink] is theme-aware: dark ink on porcelain, white on obsidian.
 */
private fun DrawScope.drawTravelingTip(fraction: Float, ink: Color) {
    if (fraction <= 0.01f || fraction >= 1f) return
    val measure = PathMeasure().apply { setPath(Monogram.path, false) }
    val pos = measure.getPosition(measure.length * fraction.coerceIn(0f, 1f))
    val zoom = size.minDimension / 108f
    drawCircle(
        brush = Brush.radialGradient(
            colors = listOf(ink, AccentBlue.copy(alpha = 0.9f), Color.Transparent),
            center = Offset(pos.x * zoom, pos.y * zoom),
            radius = 14f * zoom
        ),
        radius = 14f * zoom,
        center = Offset(pos.x * zoom, pos.y * zoom)
    )
}

/**
 * Strokes the leading [fraction] of the monogram, scaled from its 108-unit
 * authoring grid to whatever box it was given. Round caps, no fill.
 *
 * Stage 21 — the ignite is a brand-blue band that rides the STROKE itself
 * (a rectangle sweep leaves a visible box edge on the canvas) and it burns
 * only while the glow pulses.
 */
private fun DrawScope.drawMonogram(fraction: Float, pulse: Float = 0f, ink: Color = TextWhite) {
    val measure = PathMeasure().apply { setPath(Monogram.path, false) }
    val segment = Path()
    measure.getSegment(0f, measure.length * fraction.coerceIn(0f, 1f), segment, true)

    val zoom = size.minDimension / 108f
    scale(zoom, zoom, pivot = Offset.Zero) {
        drawPath(
            path = segment,
            color = ink,
            style = Stroke(
                width = Monogram.STROKE_WIDTH,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
    if (pulse > 0.01f) {
        scale(zoom, zoom, pivot = Offset.Zero) {
            drawPath(
                path = segment,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Transparent,
                        AccentBlue.copy(alpha = 0.9f * pulse),
                        Color.Transparent
                    ),
                    start = Offset(0f, 108f),
                    end = Offset(108f, 0f)
                ),
                style = Stroke(
                    width = Monogram.STROKE_WIDTH,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )
        }
    }
}
