package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.GlassFillStrong
import com.bingwascore.app.ui.theme.ORB_BLUR
import com.bingwascore.app.ui.theme.OrbBlue
import com.bingwascore.app.ui.theme.OrbViolet
import com.bingwascore.app.ui.theme.glassBorderBrush
import com.bingwascore.app.ui.theme.isSilica

/**
 * POLISH P5 — Silica, the glass mode.
 *
 * Reference points: the iOS Control Center and visionOS panels — panes of glass
 * floating over colour, not rectangles drawn on a dark background. Three things
 * make it read as glass rather than as a translucent box:
 *
 * 1. **Something behind it.** [AmbientOrbs] paints two large, slow, out-of-focus
 *    colour fields. Glass with nothing behind it is just grey plastic.
 * 2. **A real blur.** `Modifier.blur` does nothing below API 31, so on those
 *    devices the translucent fill carries the look instead of faking a blur the
 *    platform cannot perform.
 * 3. **A gradient hairline.** A flat 1px border reads as a bug; a border that
 *    fades across the shape reads as an edge catching light.
 */
object Silica {

    /**
     * U4 — the blur radius used on devices that can actually blur. 32dp is deep
     * enough that the pane reads as frosted glass rather than as a translucent
     * rectangle, and it is the one number that makes the mode unmistakable.
     */
    val CARD_BLUR: Dp = 32.dp

    /** True when the running device can render a real backdrop blur. */
    val canBlur: Boolean get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
}

/**
 * The glass card modifier: frosted fill, gradient hairline, and a backdrop blur
 * where the platform can do one. In the other two modes this is a plain bubble,
 * so every existing `BubbleCard` can adopt it without branching at the call site.
 */
@Composable
fun Modifier.glassSurface(
    shape: Shape,
    fill: Color = Color.Transparent,
    strong: Boolean = false
): Modifier {
    val glass = isSilica
    val resolvedFill = when {
        glass && strong -> GlassFillStrong
        glass -> GlassFill
        else -> fill
    }
    val resolved = this
        .clip(shape)
        .background(resolvedFill)
        .then(
            if (glass) Modifier.border(1.dp, glassBorderBrush(strong), shape) else Modifier
        )
    return if (glass && Silica.canBlur) {
        // U4 — full 32dp frost, not a half-strength hint.
        resolved.blur(Silica.CARD_BLUR)
    } else {
        resolved
    }
}

/**
 * The ambient field behind a Silica screen: one blue orb top-left, one violet
 * bottom-right, each drifting on a slow loop. It is drawn once, behind
 * everything, and it is the only decoration in the product — so it is quiet.
 */
@Composable
fun AmbientOrbs(modifier: Modifier = Modifier) {
    if (!isSilica) return
    val transition = rememberInfiniteTransition(label = "orbs")
    val driftX by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(18_000), RepeatMode.Reverse),
        label = "orbX"
    )
    val driftY by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(23_000), RepeatMode.Reverse),
        label = "orbY"
    )
    Box(modifier = modifier.fillMaxSize().background(BgBlack)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawOrb(OrbBlue, 420.dp, 0.18f, 0.22f, driftX - 0.5f, driftY - 0.5f)
            drawOrb(OrbViolet, 520.dp, 0.86f, 0.78f, driftY - 0.5f, driftX - 0.5f)
        }
    }
}

/**
 * One soft orb: a radial fade positioned by fraction and nudged by its drift.
 *
 * U4 — the orb holds full strength out to `radius - ORB_BLUR`, then falls away
 * over the last [ORB_BLUR] (140dp). That is what makes the field read as a
 * blurred light rather than a flat disc, which is the whole difference between
 * an ambient wash and a sticker.
 */
private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawOrb(
    color: Color,
    diameter: Dp,
    baseX: Float,
    baseY: Float,
    driftX: Float,
    driftY: Float
) {
    val radius = diameter.toPx() / 2f
    val softPx = ORB_BLUR.toPx().coerceAtMost(radius)
    val holdStop = ((radius - softPx) / radius).coerceIn(0f, 0.98f)
    val center = Offset(
        x = size.width * (baseX + driftX * 0.06f),
        y = size.height * (baseY + driftY * 0.06f)
    )
    drawCircle(
        brush = Brush.radialGradient(
            colorStops = arrayOf(
                0f to color,
                holdStop to color,
                1f to Color.Transparent
            ),
            center = center,
            radius = radius
        ),
        radius = radius,
        center = center
    )
}
