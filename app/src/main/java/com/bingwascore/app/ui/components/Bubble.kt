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
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.CtaBorder
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.SecondaryOutline
import com.bingwascore.app.util.rememberHaptics

/**
 * REBRAND R1 — the surface vocabulary.
 *
 * The old frosted cards are gone: no blur, no specular border, no shadow
 * glow, no drifting ambient blobs. What is left is a *bubble* — one flat fill,
 * one radius, zero tricks — which is what makes the numbers on Home read like a
 * trading terminal instead of a wallpaper.
 */

/**
 * The one surface modifier: flat fill, clipped to [shape].
 *
 * POLISH P5 — in Silica this resolves to frosted glass instead of a flat fill,
 * so every card in the app becomes a pane without a single screen having to
 * branch on the theme.
 */
@Composable
fun Modifier.bubbleSurface(
    shape: Shape,
    fill: Color = Bubble
): Modifier = glassSurface(shape = shape, fill = fill)

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
 * U4 — Grayscale has no usable hue, so the button becomes a solid **#E0E0E0**
 * chip with **black** text: the one figure/ground pair that stays unambiguous
 * when the accent is gone.
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
    // POLISH P5 — a disabled CTA used to be `Raised` + 45% white ink (~2.4:1),
    // which read as broken. DisabledFill + DisabledInk clear 4.5:1 in all three
    // modes, so "Dial Now" looks *unavailable*, not *broken*.
    val enabledNow = enabled && !loading
    val fill = if (enabledNow) CtaFill else DisabledFill
    val ink = if (enabledNow) CtaInk else DisabledInk

    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .background(fill)
            .border(1.dp, if (enabledNow) CtaBorder else Hairline, shape)
            .clickable(
                enabled = enabledNow,
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
            // U4 — Grayscale outlines the secondary action at #9E9E9E so it is
            // visible against the monochrome canvas.
            .border(1.dp, SecondaryOutline, shape)
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
            color = if (enabled) CtaInk else DisabledInk,
            fontWeight = FontWeight.SemiBold,
            fontSize = BingwaType.Body
        )
    }
}

/**
 * Switch with a haptic tick on every toggle. The haptic call is wrapped so a
 * device without haptics (or a framework quirk) can never crash the toggle — the
 * state change always goes through.
 *
 * POLISH P6 — the default colours were Material's, which on a black surface put
 * a 40%-white thumb on a near-black track: invisible in Obsidian, worse on
 * Silica's translucent fill, and the single most common "is this on?" moment in
 * the app. These defaults clear 3:1 against their own track in all three modes.
 */
@Composable
fun HapticSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    colors: SwitchColors = statusSwitchColors()
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

/**
 * The one switch palette.
 *
 * On: the accent track with a black thumb — the strongest figure/ground pair the
 * product has. Off: a raised track, a visible hairline and a [DisabledInk] thumb,
 * so "off" reads as *off* rather than as *broken*.
 */
@Composable
fun statusSwitchColors(): SwitchColors = SwitchDefaults.colors(
    checkedThumbColor = BgBlack,
    checkedTrackColor = AccentBlue,
    checkedBorderColor = AccentBlue,
    uncheckedThumbColor = DisabledInk,
    uncheckedTrackColor = Raised,
    uncheckedBorderColor = Hairline
)
