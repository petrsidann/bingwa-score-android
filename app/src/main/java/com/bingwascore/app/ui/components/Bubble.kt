package com.bingwascore.app.ui.components

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.CtaBorder
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.util.rememberHaptics

/**
 * REBRAND R1 — the surface vocabulary.
 *
 * The frosted cards are gone: no backdrop blur, no specular border, no shadow
 * glow, no drifting ambient blobs. What is left is a *bubble* — one flat fill,
 * one radius, zero tricks — which is what makes the numbers on Home read like a
 * trading terminal instead of a wallpaper.
 */

/** The one surface modifier: flat fill, clipped to [shape]. */
@Composable
fun Modifier.bubbleSurface(
    shape: Shape,
    fill: Color = Bubble
): Modifier = this
    .clip(shape)
    .background(fill)

/**
 * Flat bubble card. Fades + slides in on composition; when [onClick] is provided
 * it also springs to 0.98 scale while pressed, and [enterDelayMillis] staggers
 * lists. Pass [onLongClick] for gesture-driven cards (multi-select rows) — tap
 * and long-press are then resolved by a single gesture detector so a long press
 * can never also fire the tap.
 */
@Composable
fun BubbleCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    fill: Color = Bubble,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    enterDelayMillis: Int = 0,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()

    val visuals = Modifier.bubbleSurface(shape = shape, fill = fill)

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
 * Primary CTA — solid accent, white bold label, 14dp radius.
 *
 * In GRAYSCALE / BLUE LIGHT FILTER the accent is no longer a usable hue, so the
 * button becomes a solid near-black chip separated by a hairline.
 *
 * Pass [loading] to swap the label for a spinner (e.g. "Dialing…") and block
 * double taps while the work is in flight.
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    loadingText: String = text
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()
    val shape = RoundedCornerShape(14.dp)
    val fill = if (enabled && !loading) CtaFill else Raised
    val ink = if (enabled && !loading) CtaInk else CtaInk.copy(alpha = 0.45f)

    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .background(fill)
            .border(1.dp, CtaBorder, shape)
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
                    color = ink,
                    strokeWidth = 2.dp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(loadingText, color = ink, fontWeight = FontWeight.Bold, fontSize = BingwaType.Body)
            }
        } else {
            Text(text, color = ink, fontWeight = FontWeight.Bold, fontSize = BingwaType.Body)
        }
    }
}

/**
 * Secondary action — no fill, one hairline. Used for "Cancel", "Later",
 * "Select All" and everything that must not compete with the primary CTA.
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()
    val shape = RoundedCornerShape(14.dp)

    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .background(Color.Transparent)
            .border(1.dp, Hairline, shape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null
            ) {
                haptics.tick()
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = if (enabled) CtaInk else CtaInk.copy(alpha = 0.4f),
            fontWeight = FontWeight.SemiBold,
            fontSize = BingwaType.Body
        )
    }
}

/**
 * Switch with a haptic tick on every toggle. The haptic call is wrapped so a
 * device without haptics (or a framework quirk) can never crash the toggle — the
 * state change always goes through.
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
