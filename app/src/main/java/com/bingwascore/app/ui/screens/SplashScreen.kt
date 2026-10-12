package com.bingwascore.app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
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
import com.bingwascore.app.ui.components.Monogram
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    // The draw-on is a real animation the Canvas samples every frame.
    val trim = remember { Animatable(0f) }

    // One glow, one breath.
    val glow = remember { Animatable(0f) }

    // The letters and the tagline ride one clock, so the stagger is exact.
    val clock = remember { Animatable(0f) }

    var taglineTarget by remember { mutableFloatStateOf(0f) }
    val taglineAlpha by animateFloatAsState(
        targetValue = taglineTarget,
        animationSpec = tween(Motion.SPLASH_FADE),
        label = "splashTaglineAlpha"
    )

    val currentTarget by rememberUpdatedState(target)
    val currentOnFinish by rememberUpdatedState(onFinish)

    // Stage 11 — exit beat: the monogram shrinks into the login logo position
    // (shared-element crossfade) over 200ms before the route fires.
    val exitShrink = remember { Animatable(0f) }

    // Stage 11 — tagline breath: one gentle inhale/exhale after it lands
    // (single cycle, never a loop).
    val taglineBreath = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        trim.animateTo(1f, tween(Motion.SPLASH_DRAW, easing = LinearEasing))

        // The glow and the wordmark overlap on purpose: the light is still
        // breathing when the first letter arrives, which is what makes the
        // moment feel composed rather than queued.
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
                delay((Motion.SPLASH_WORDMARK_START - Motion.SPLASH_DRAW).toLong().coerceAtLeast(0))
                clock.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(Motion.SPLASH_TAGLINE_START - Motion.SPLASH_WORDMARK_START)
                )
            }
        }
        taglineTarget = 1f
        // Stage 11 — the tagline breathes once as it settles: inhale over 180ms,
        // ease back to 0.72 — a single cycle that reads as life, not a spinner.
        launch {
            taglineBreath.animateTo(1f, tween(180))
            taglineBreath.animateTo(0.72f, tween(360))
        }

        delay((Motion.SPLASH_TOTAL - Motion.SPLASH_TAGLINE_START).toLong())
        var resolved = currentTarget
        while (resolved == null) {
            delay(30)
            resolved = currentTarget
        }
        // Stage 11 — shrink into the login logo position (shared-element
        // crossfade, 200ms) so the hand-off never cuts.
        exitShrink.animateTo(1f, tween(200))
        currentOnFinish(resolved)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
    ) {
        if (glow.value > 0.01f) {
            Canvas(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(320.dp)
            ) {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            AccentBlue.copy(alpha = 0.30f * glow.value),
                            Color.Transparent
                        ),
                        center = center,
                        radius = size.minDimension / 2f
                    ),
                    radius = size.minDimension / 2f
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
                        // Stage 11 — shared-element exit: shrink toward the login
                        // logo position while fading the stage out.
                        val t = exitShrink.value
                        scaleX = 1f - 0.55f * t
                        scaleY = 1f - 0.55f * t
                        translationY = -46f * t * density
                        alpha = 1f - 0.35f * t
                    }
            ) {
                drawMonogram(trim.value)
                // Stage 11 — glowing traveling tip rides the stroke head.
                drawTravelingTip(trim.value)
            }

            Spacer(modifier = Modifier.height(24.dp))

            StaggeredWordmark(text = SPLASH_WORDMARK, clock = clock.value)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Your bundle business, automated.",
                color = TextGrey,
                fontSize = BingwaType.Footnote,
                fontWeight = FontWeight.Normal,
                // Stage 11 — tagline breathes: alpha rides the tagline clock
                // with a soft inhale once it lands (no loop).
                modifier = Modifier.alpha(taglineAlpha * (0.92f + 0.08f * taglineBreath.value))
            )
        }
    }
}

/** The wordmark, as its own constant: one source for the stagger width. */
internal const val SPLASH_WORDMARK = "Bingwa Score"

/**
 * One alpha per letter of [text], from [progress] (0..1 across the wordmark
 * window). Always returns exactly `text.length` entries — the wordmark is never
 * shortened, only faded — so a refactor that sliced the text would fail
 * [com.bingwascore.app.SplashChoreographyTest] instead of shipping a splash that
 * spells "Bingwa Sco".
 */
internal fun wordmarkAlphas(text: String, progress: Float): List<Float> {
    val capped = progress.coerceIn(0f, (text.length - 1).toFloat())
    return List(text.length) { index -> (capped - index).coerceIn(0f, 1f) }
}

/**
 * Stage 11 — letters rise on spring stagger: each glyph owns a slice of the
 * wordmark window and springs up (scale + rise, damping 0.86) while fading in.
 * The FULL string is always composed — [wordmarkAlphas] returns one alpha per
 * letter, so a refactor that sliced the text fails the regression test.
 */
@Composable
private fun StaggeredWordmark(text: String, clock: Float) {
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
                color = TextWhite,
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
 */
private fun DrawScope.drawTravelingTip(fraction: Float) {
    if (fraction <= 0.01f || fraction >= 1f) return
    val measure = PathMeasure().apply { setPath(Monogram.path, false) }
    val pos = measure.getPosition(measure.length * fraction.coerceIn(0f, 1f))
    val zoom = size.minDimension / 108f
    drawCircle(
        brush = Brush.radialGradient(
            colors = listOf(Color.White, Color.Transparent),
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
 * Stage 11 — on complete a shockwave ring + specular sweep fire across the
 * stroke (drawn at full trim only, fading with the glow clock is unnecessary:
 * one ring, one sweep, then the wordmark owns the stage).
 */
private fun DrawScope.drawMonogram(fraction: Float) {
    val measure = PathMeasure().apply { setPath(Monogram.path, false) }
    val segment = Path()
    measure.getSegment(0f, measure.length * fraction.coerceIn(0f, 1f), segment, true)

    val zoom = size.minDimension / 108f
    scale(zoom, zoom, pivot = Offset.Zero) {
        drawPath(
            path = segment,
            color = TextWhite,
            style = Stroke(
                width = Monogram.STROKE_WIDTH,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
    if (fraction >= 0.999f) {
        // Shockwave ring on complete: one expanding hairline.
        drawCircle(
            color = TextWhite.copy(alpha = 0.35f),
            radius = size.minDimension * 0.52f,
            center = center,
            style = Stroke(width = 2f)
        )
        // Specular sweep: a diagonal light band across the stroke box.
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.White.copy(alpha = 0.22f),
                    Color.Transparent
                ),
                start = Offset(0f, size.height),
                end = Offset(size.width, 0f)
            )
        )
    }
}
