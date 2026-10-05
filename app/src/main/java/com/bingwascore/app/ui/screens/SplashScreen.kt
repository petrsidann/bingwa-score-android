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
 * POLISH P6 — splash choreography, 1.9s end to end (inside the 2.0s budget):
 *
 * 1. **0 → 900ms** — pure black stage; the monogram *draws itself on* (PathMeasure
 *    trim 0 → 1), one continuous stroke, exactly the launcher icon.
 * 2. **880 → 1340ms** — a *single* soft radial glow pulses behind the mark. One
 *    pulse, not a loop: a looping glow on a splash is a loading spinner wearing
 *    a nicer costume, and it told the agent the app was busy rather than ready.
 * 3. **1150 → 1480ms** — the wordmark letters stagger in, 30ms apart.
 * 4. **1530 → 1830ms** — the tagline fades up, grey, beneath it.
 * 5. **1900ms** — hand off to the resolved route.
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

        delay((Motion.SPLASH_TOTAL - Motion.SPLASH_TAGLINE_START).toLong())
        var resolved = currentTarget
        while (resolved == null) {
            delay(30)
            resolved = currentTarget
        }
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
            Canvas(modifier = Modifier.size(132.dp)) {
                drawMonogram(trim.value)
            }

            Spacer(modifier = Modifier.height(24.dp))

            StaggeredWordmark(text = WORDMARK, clock = clock.value)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Your bundle business, automated.",
                color = TextGrey,
                fontSize = BingwaType.Footnote,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.alpha(taglineAlpha)
            )
        }
    }
}

/** The wordmark, as its own constant: one source for the stagger width. */
private const val WORDMARK = "Bingwa Score"

/** How long one letter takes to arrive, as a fraction of the letter window. */
private const val LETTER_WINDOW = 0.34f

/**
 * Letters that arrive 30ms apart.
 *
 * Each glyph owns a slice of the wordmark window and fades up while rising a few
 * dp — enough to read as a word being written, not as a slideshow. Built from
 * one `Row` of `Text`s driven by a single clock, so the stagger is deterministic
 * and the whole wordmark stays one layout pass.
 */
@Composable
private fun StaggeredWordmark(text: String, clock: Float) {
    // The clock runs across the wordmark window; map it onto 0..1.
    val windowMillis = Motion.SPLASH_TAGLINE_START - Motion.SPLASH_WORDMARK_START
    val elapsed = (clock * windowMillis).toInt()
    val progress = (elapsed / Motion.SPLASH_LETTER_STAGGER.toFloat())
        .coerceIn(0f, (text.length - 1).toFloat())

    Row {
        text.forEachIndexed { index, char ->
            val local = (progress - index).coerceIn(0f, 1f)
            Text(
                text = char.toString(),
                color = TextWhite,
                fontSize = BingwaType.Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer {
                    alpha = local
                    translationY = (1f - local) * 6f * density
                }
            )
        }
    }
}
/**
 * Strokes the leading [fraction] of the monogram, scaled from its 108-unit
 * authoring grid to whatever box it was given. Round caps, no fill.
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
}
