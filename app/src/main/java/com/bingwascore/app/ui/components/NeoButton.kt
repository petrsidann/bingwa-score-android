package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens
import androidx.compose.ui.hapticfeedback.HapticFeedbackType

/**
 * Stage 48 — Neo button.
 *
 * Primary CTA with a spring-driven press scale and mandatory haptic feedback
 * on press. Never a bare [clickable] without haptics.
 *
 * [pressScale] overrides the default 0.98f press scale (keypad keys use 0.95f).
 * [fillMaxWidth] and [height] control sizing; set [fillMaxWidth] = false and pass
 * a sized [modifier] for square keypad keys. [fill] overrides the brand-primary
 * background (keypad keys use Obsidian.card).
 */
@Composable
fun NeoButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    pressScale: Float = 0.98f,
    height: Dp = 56.dp,
    fillMaxWidth: Boolean = true,
    fill: Color = DesignTokens.Color.Brand.Primary,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) pressScale else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "NeoButtonScale"
    )
    val hapticFeedback = LocalHapticFeedback.current
    Box(
        modifier = modifier
            .then(if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier)
            .height(height)
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
            .background(
                if (enabled) fill
                else fill.copy(alpha = 0.5f)
            )
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                    onClick()
                }
            )
    ) {
        content()
    }
}
