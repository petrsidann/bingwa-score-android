package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.GlassBorderStrong
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.BrandColors
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.OnBrandInk
import com.bingwascore.app.util.rememberHaptics

/**
 * PREMIUM LOCK — the backdrop-blur radius for every glass surface.
 *
 * 24.dp is the value that reads as "frosted" rather than "mist": enough
 * separation to kill the flat-rectangle look, not so much that text sitting on
 * top starts to swim.
 */
val GlassBlurRadius: Dp = 24.dp

/**
 * PREMIUM LOCK — true glassmorphism, layered (never one translucent rectangle).
 *
 *  1. **Blur layer** — on API 31+ `Modifier.blur(24.dp)` over the content
 *     behind the card, so ambient blobs smear into real frosted glass. The
 *     blur is applied to a *background* layer, never to the card itself:
 *     blurring the card would blur its own text too.
 *  2. **Tint layer** — the colour that gives the glass its hue. On API 31+ it
 *     stays translucent so the blur shows through; below 31, where no
 *     RenderEffect blur exists, it climbs to a high-opacity solid surface so
 *     cards still read as raised panels instead of transparent holes.
 *  3. **Specular border** — the top-lit hairline that sells the material, and
 *     carries the load below API 31 where there is no blur to catch light.
 */
@Composable
fun Modifier.glassSurface(
    shape: Shape,
    tint: Color = GlassFill
): Modifier {
    val supportsBlur = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    // 1. Blur layer — clipped to the shape so the blur never bleeds past it.
    val blurLayer = if (supportsBlur) {
        Modifier.clip(shape).blur(GlassBlurRadius)
    } else {
        Modifier
    }

    // 2. Tint layer. Without blur a translucent fill reads as a hole, so we
    //    climb to ~14% white over the same base hue instead.
    val tintBrush = if (supportsBlur) {
        Brush.verticalGradient(
            listOf(tint.copy(alpha = (tint.alpha + 0.06f).coerceAtMost(1f)), tint.copy(alpha = 0.04f))
        )
    } else {
        Brush.verticalGradient(listOf(Color.White.copy(alpha = 0.14f), Color.White.copy(alpha = 0.08f)))
    }

    return this
        .clip(shape)
        .then(blurLayer)
        .background(tintBrush)
        // 3. Specular border — brighter without blur so the edge still reads.
        .border(
            width = 1.dp,
            brush = Brush.verticalGradient(
                listOf(
                    if (supportsBlur) GlassBorderStrong else Color.White.copy(alpha = 0.34f),
                    Color.Transparent
                )
            ),
            shape = shape
        )
}

/**
 * Frosted glass card. Every card fades + slides in on composition; when
 * [onClick] is provided the card also springs to 0.98 scale while pressed.
 * [enterDelayMillis] staggers lists (min(index, 6) * 35 reads naturally).
 *
 * Parity F: pass [onLongClick] for gesture-driven cards (Offers multi-select).
 * Tap and long-press are then resolved by a single gesture detector, so a long
 * press can never also fire the tap action.
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    enterDelayMillis: Int = 0,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()

    val visuals = Modifier
        .shadow(12.dp, shape, ambientColor = Color.Black.copy(0.35f))
        .glassSurface(shape = shape)

    val cardModifier = when {
        onLongClick != null -> Modifier
            .pressScale(interactionSource)
            .then(visuals)
            .pointerInput(onLongClick) {
                detectTapGestures(
                    onTap = { onClick?.invoke() },
                    onLongPress = {
                        haptics.press()
                        onLongClick()
                    }
                )
            }

        onClick != null -> Modifier
            .pressScale(interactionSource)
            .then(visuals)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )

        else -> visuals
    }

    Box(modifier = modifier.enterAnimation(enterDelayMillis).then(cardModifier)) {
        Column(modifier = Modifier.padding(20.dp)) { content() }
    }
}

/**
 * Full-width gradient action button with the same 0.98 press-scale feedback.
 *
 * Parity E: pass [loading] to swap the label for a spinning indicator (e.g.
 * "Dialing…") and block double taps while the work is in flight. The press
 * haptic comes from the shared `Haptics` vocabulary.
 */
@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    loadingText: String = text
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()
    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Brush.horizontalGradient(BrandColors))
            .clickable(
                enabled = enabled && !loading,
                interactionSource = interactionSource,
                indication = null
            ) {
                haptics.press()
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        if (loading) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    color = OnBrandInk,
                    strokeWidth = 2.dp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    loadingText,
                    color = OnBrandInk,
                    fontWeight = FontWeight.Bold,
                    fontSize = BingwaType.Body
                )
            }
        } else {
            Text(text, color = OnBrandInk, fontWeight = FontWeight.Bold, fontSize = BingwaType.Body)
        }
    }
}

/**
 * Switch with a haptic tick on every toggle. The haptic call is wrapped so a
 * device without haptics (or a framework quirk) can never crash the toggle —
 * the state change always goes through.
 */
@Composable
fun HapticSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    colors: SwitchColors = SwitchDefaults.colors()
) {
    val haptics = rememberHaptics()
    Switch(
        checked = checked,
        onCheckedChange = {
            haptics.tick()
            onCheckedChange(it)
        },
        modifier = modifier,
        colors = colors
    )
}
