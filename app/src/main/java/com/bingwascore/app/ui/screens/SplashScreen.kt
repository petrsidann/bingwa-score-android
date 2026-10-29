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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import java.util.Random

object SplashBrand {
    /** Stage 21 — the wordmark is ONE constant for the whole app. */
    const val WORDMARK: String = BrandWordmark.TEXT
    const val TAGLINE = "Your bundle business, automated."
}

/**
 * Stage 21 — the splash ink, per theme, WITHOUT asking the global display
 * mode: white ink on obsidian, dark ink on dim porcelain. The splash draws
 * the same mark in both themes, so the ink is a decision, not a lookup.
 */
internal fun splashInk(dark: Boolean): Color = if (dark) Color(0xFFFFFFFF) else Color(0xFF16181D)

/**
 * Stage 21 — the resting halo behind the monogram.
 *
 * Blue in both themes; a touch stronger on dim porcelain, where the glow has
 * less of the frame to fight against than it does on obsidian.
 */
internal fun splashGlowAlpha(dark: Boolean): Float = if (dark) 0.10f else 0.17f

/** Stage 20 — soft blue radial glow behind the monogram, both themes. */
internal val splashGlow: Brush
    get() = Brush.radialGradient(
        colors = listOf(AccentBlue.copy(alpha = 0.24f), Color.Transparent)
    )

/**
 * Stage 11 — "Stroke & Ignite" launch cinematic:
 *
 * 1. **0 → 900ms** — PathMeasure draw with a glowing traveling tip.
 * 2. **on complete** — shockwave ring + specular sweep across the stroke.
 * 3. **wordmark** — the FULL "Bingwa Score" string rises on spring stagger
 *    ([wordmarkAlphas] guarantees no letter is ever dropped; the regression
 *    test asserts the full text).
 * 4. **tagline** — breathes (gentle alpha pulse, never a loop that reads busy).
 * 5. **hand-off** — the monogram shrinks into the login logo position
 *    (shared-element crossfade, 200ms).
 *
 * Budget: hands off inside 2.0s ([Motion.SPLASH_TOTAL]).
 */
@Composable
fun SplashScreen(target: String?, onFinish: (String) -> Unit) {
    // STAGE 19.7 — thin wrapper: the splash has no ViewModel, so the wrapper
    // only hands the target and the hand-off to the pure content.
    SplashScreenContent(target = target, onFinish = onFinish)
}

/**
 * Stage 19.7 — the PURE splash surface.
 *
 * [settled] renders the frame the choreography lands on (full monogram, full
 * wordmark, tagline in) without waiting for the animation clock, which is what
 * a snapshot test needs to see.
 */
@Composable
fun SplashScreenContent(
    target: String?,
    onFinish: (String) -> Unit,
    settled: Boolean = false
) {
    if (settled) {
        val trim = remember { Animatable(1f) }
        val glow = remember { Animatable(0f) }
        val bloom = remember { Animatable(1f) }
        val sweep = remember { Animatable(1f) }
        val taglineBreath = remember { Animatable(0.72f) }
        val exitShrink = remember { Animatable(0f) }
        SplashStage(
            trim = trim,
            glow = glow,
            bloom = bloom,
            sweep = sweep,
            taglineAlpha = 1f,
            taglineBreath = taglineBreath,
            exitShrink = exitShrink,
            skipReady = true
        )
        return
    }

    val trim = remember { Animatable(0f) }
    val glow = remember { Animatable(0f) }
    val bloom = remember { Animatable(0f) }
    val sweep = remember { Animatable(0f) }
    var taglineTarget by remember { mutableFloatStateOf(0f) }
    val taglineAlpha by animateFloatAsState(
        targetValue = taglineTarget,
        animationSpec = tween(Motion.SPLASH_FADE),
        label = "splashTaglineAlpha"
    )
    val currentTarget by rememberUpdatedState(target)
    val currentOnFinish by rememberUpdatedState(onFinish)
    val exitShrink = remember { Animatable(0f) }
    val taglineBreath = remember { Animatable(0f) }
    var skipReady by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        trim.animateTo(1f, tween(Motion.SPLASH_DRAW, easing = LinearEasing))
        coroutineScope {
            launch {
                delay((Motion.SPLASH_GLOW_START - Motion.SPLASH_DRAW).toLong().coerceAtLeast(0))
                glow.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(Motion.SPLASH_GLOW_PULSE / 2, easing = FastOutSlowInEasing)
                )
                glow.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(Motion.SPLASH_GLOW_PULSE / 2, easing = LinearOutSlowInEasing)
                )
            }
            launch {
                delay(Motion.SPLASH_DRAW.toLong())
                bloom.animateTo(1f, tween(400))
            }
            launch {
                delay(Motion.SPLASH_WORDMARK_START.toLong())
                sweep.animateTo(1f, tween(400))
            }
            launch {
                delay(Motion.SPLASH_TAGLINE_START.toLong())
                taglineTarget = 1f
                taglineBreath.animateTo(1f, tween(180))
                taglineBreath.animateTo(0.72f, tween(360))
            }
        }
        launch {
            delay(1000)
            skipReady = true
        }
        delay(Motion.SPLASH_TOTAL.toLong())
        var resolved = currentTarget
        while (resolved == null) {
            delay(30)
            resolved = currentTarget
        }
        exitShrink.animateTo(1f, tween(200))
        currentOnFinish(resolved)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(enabled = skipReady, onClick = {
                scope.launch {
                    exitShrink.animateTo(1f, tween(200))
                    delay(200)
                    currentOnFinish(currentTarget ?: "")
                }
            })
    ) {
        SplashStage(
            trim = trim,
            glow = glow,
            bloom = bloom,
            sweep = sweep,
            taglineAlpha = taglineAlpha,
            taglineBreath = taglineBreath,
            exitShrink = exitShrink,
            skipReady = skipReady
        )
    }
}


/**
 * Stage 24 — the splash stage: monogram stroke-draw with glowing tip + spark
 * particles, completion bloom ring, mask-sweep wordmark, tagline fade-up,
 * shared-element hand-off.
 */
@Composable
private fun SplashStage(
    trim: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    glow: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    bloom: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    sweep: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    taglineAlpha: Float,
    taglineBreath: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    exitShrink: Animatable<Float, androidx.compose.animation.core.AnimationVector1D>,
    skipReady: Boolean
) {
    val ink = splashInk(dark = !isPorcelain)
    val density = LocalDensity.current.density
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
    ) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(320.dp)
        ) {
            val pulse = glow.value
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        AccentBlue.copy(alpha = splashGlowAlpha(dark = !isPorcelain) * (1f + 0.8f * pulse)),
                        Color.Transparent
                    ),
                    center = center,
                    radius = size.minDimension / 2f
                ),
                radius = size.minDimension / 2f
            )
            if (pulse > 0.01f) {
                drawCircle(
                    color = AccentBlue.copy(alpha = 0.35f * pulse),
                    radius = size.minDimension * (0.22f + 0.16f * pulse),
                    center = center,
                    style = Stroke(width = 2f)
                )
            }
            // Stage 24 — spark particles: bright dots that flash along the
            // stroke while the monogram draws.
            val spark = trim.value
            if (spark > 0.01f) {
                val measure = PathMeasure().apply { setPath(Monogram.path, false) }
                val len = measure.length
                val rnd = Random(42)
                for (i in 0 until 6) {
                    val f = ((i * 0.13f + spark * 0.05f) % 1f).coerceIn(0f, 1f)
                    val pos = measure.getPosition(len * f)
                    val zoom = size.minDimension / 108f
                    val alpha = (1f - (spark * 0.8f).coerceIn(0f, 1f)) * 0.9f
                    drawCircle(
                        color = ink.copy(alpha = alpha),
                        radius = 3f * zoom,
                        center = Offset(pos.x * zoom, pos.y * zoom)
                    )
                }
            }
            // Stage 24 — completion bloom ring: expands once the stroke is done.
            val b = bloom.value
            if (b > 0.01f) {
                drawCircle(
                    color = AccentBlue.copy(alpha = 0.25f * b),
                    radius = size.minDimension * (0.5f + 0.9f * b),
                    center = center,
                    style = Stroke(width = 3f)
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
                        val t = exitShrink.value
                        scaleX = 1f - 0.55f * t
                        scaleY = 1f - 0.55f * t
                        translationY = -46f * t * density
                        alpha = 1f - 0.35f * t
                    }
            ) {
                drawMonogram(trim.value, glow.value, ink)
                drawTravelingTip(trim.value, ink)
            }

            Spacer(modifier = Modifier.height(24.dp))

            MaskSweepWordmark(text = BrandWordmark.TEXT, sweep = sweep.value, ink = ink)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Your bundle business, automated.",
                color = TextGrey,
                fontSize = BingwaType.Footnote,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .alpha(taglineAlpha * (0.92f + 0.08f * taglineBreath.value))
                    .graphicsLayer { translationY = (1f - taglineAlpha) * 10f * density }
            )
        }
    }
}

/** Stage 24 — wordmark revealed by a left-to-right mask sweep (not typewriter). */
@Composable
private fun MaskSweepWordmark(text: String, sweep: Float, ink: Color) {
    val density = LocalDensity.current.density
    Box(
        modifier = Modifier
            .size(260.dp, 40.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(BgBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
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
    // Mask sweep: a canvas-coloured curtain that wipes left-to-right across the
    // wordmark, revealing it. Painted in the canvas colour so it reads as a
    // mask sweep on Obsidian and Porcelain Dim alike — never a white rectangle.
    Box(
        modifier = Modifier
            .size(260.dp, 40.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(BgBlack)
            .graphicsLayer {
                scaleX = 1f - sweep
                translationX = (1f - sweep) * 260f * density
                alpha = 1f - sweep
            }
    )
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
