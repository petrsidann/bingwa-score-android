package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.GlassBorderStrong
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.BrandColors
import com.bingwascore.app.ui.theme.OnBrandInk
import com.bingwascore.app.util.rememberHaptics

/**
 * Frosted glass card. Every card fades + slides in on composition; when
 * [onClick] is provided the card also springs to 0.98 scale while pressed.
 * [enterDelayMillis] staggers lists (min(index, 6) * 35 reads naturally).
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    onClick: (() -> Unit)? = null,
    enterDelayMillis: Int = 0,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    val interactionSource = remember { MutableInteractionSource() }

    val visuals = Modifier
        .shadow(12.dp, shape, ambientColor = Color.Black.copy(0.35f))
        .clip(shape)
        .background(GlassFill)
        .border(1.dp, Brush.verticalGradient(listOf(GlassBorderStrong, Color.Transparent)), shape)

    val cardModifier = if (onClick != null) {
        Modifier
            .pressScale(interactionSource)
            .then(visuals)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    } else {
        visuals
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
                    fontSize = 17.sp
                )
            }
        } else {
            Text(text, color = OnBrandInk, fontWeight = FontWeight.Bold, fontSize = 17.sp)
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
