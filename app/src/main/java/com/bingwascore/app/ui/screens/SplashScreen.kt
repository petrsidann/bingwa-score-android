package com.bingwascore.app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
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
import androidx.compose.ui.graphics.drawscope.DrawScope
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
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import kotlinx.coroutines.delay

/**
 * REBRAND R1 — splash choreography, 1.6s end to end:
 * 1. Pure black stage; the monogram *draws itself on* (PathMeasure trim 0 → 1,
 *    900ms) — one continuous stroke, exactly the launcher icon.
 * 2. The wordmark "Bingwa Score" fades up thick and white.
 * 3. The tagline fades up grey beneath it.
 * 4. After [Motion.SPLASH_TOTAL] the resolved [target] route is handed back.
 */
@Composable
fun SplashScreen(target: String?, onFinish: (String) -> Unit) {
    // 1. Trim 0 -> 1 drives the stroke reveal; [Animatable] so the draw-on is a
    //    real animation the Canvas can sample every frame.
    val trim = remember { Animatable(0f) }

    var wordTarget by remember { mutableFloatStateOf(0f) }
    val wordAlpha by animateFloatAsState(
        targetValue = wordTarget,
        animationSpec = tween(Motion.SPLASH_FADE),
        label = "splashWordAlpha"
    )

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

        wordTarget = 1f
        delay(Motion.SPLASH_FADE.toLong())
        taglineTarget = 1f

        // Hand off on the 1.6s mark; holds longer only if the start destination
        // has not resolved yet (a frame or two at most).
        delay((Motion.SPLASH_TOTAL - Motion.SPLASH_DRAW - Motion.SPLASH_FADE).toLong())
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
            .background(BgBlack)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(modifier = Modifier.size(132.dp)) {
                drawMonogram(trim.value)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Bingwa Score",
                color = TextWhite,
                fontSize = BingwaType.Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(wordAlpha)
            )

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