package com.bingwascore.app.ui.glass

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * STEP 4 — GlassToggle: obsidian track with liquid-glass thumb.
 * Replaces all Switch/PremiumToggle app-wide.
 */
@Composable
fun GlassToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val trackColor = DesignTokens.LocalBingwaRoles.current.surfaceLowest
    val accentColor = DesignTokens.LocalBingwaRoles.current.brand
    val mutedColor = Color(0xFF475569)

    val currentTrackColor by animateColorAsState(
        targetValue = if (checked) accentColor else mutedColor,
        animationSpec = tween(200),
        label = "trackColor"
    )

    val thumbScale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "thumbScale"
    )

    val thumbOffsetX = if (checked) 22.dp else 0.dp

    Box(
        modifier = modifier
            .size(52.dp, 30.dp)
            .clip(CircleShape)
            .background(trackColor)
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.6f),
                shape = CircleShape
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onCheckedChange(!checked) }
    ) {
        // Glow ring when ON
        if (checked) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .border(
                        width = 2.dp,
                        color = accentColor.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
            )
        }

        // Thumb
        Box(
            modifier = Modifier
                .size(24.dp)
                .scale(thumbScale)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.15f))
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.6f),
                    shape = CircleShape
                )
        ) {
            // Specular dot
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.8f))
                    .align(androidx.compose.ui.Alignment.TopStart)
            )
        }
    }
}
