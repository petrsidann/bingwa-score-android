package com.bingwascore.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Press feedback: the node springs down to [pressedScale] (0.98 by default)
 * while held and bounces back on release. Pair with a [clickable] that shares
 * the same [interactionSource] so the press state is observed.
 */
@Composable
fun Modifier.pressScale(
    interactionSource: MutableInteractionSource,
    pressedScale: Float = 0.98f
): Modifier {
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) pressedScale else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "pressScale"
    )
    return graphicsLayer {
        scaleX = scale
        scaleY = scale
    }
}

/**
 * Enter transition: fade in + slide up + springy scale. Plays each time the
 * modified node is first composed — every new GlassCard or list row inherits
 * the animation automatically.
 */
@Composable
fun Modifier.enterAnimation(delayMillis: Int = 0): Modifier {
    val fade = remember(delayMillis) { Animatable(0f) }
    val slideY = remember(delayMillis) { Animatable(28f) }
    val enterScale = remember(delayMillis) { Animatable(0.96f) }

    LaunchedEffect(delayMillis) {
        if (delayMillis > 0) delay(delayMillis.toLong())
        launch { fade.animateTo(1f, tween(320)) }
        launch { slideY.animateTo(0f, tween(360)) }
        launch {
            enterScale.animateTo(
                1f,
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        }
    }

    return graphicsLayer {
        alpha = fade.value
        translationY = slideY.value
        scaleX = enterScale.value
        scaleY = enterScale.value
    }
}

/**
 * Wraps the app shell's destination content. Whenever [screenKey] changes the
 * old content is thrown away and the new screen plays its enter animation.
 */
@Composable
fun ScreenTransition(
    screenKey: Any,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    key(screenKey) {
        Box(modifier = modifier.enterAnimation()) { content() }
    }
}

/**
 * Friendly empty state: a tinted icon in a soft circle, a short title and a
 * helpful hint. Used on list screens when there is nothing to show.
 */
@Composable
fun EmptyState(
    icon: ImageVector,
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    iconTint: Color = EmeraldGreen
) {
    GlassCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(iconTint.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                title,
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                message,
                color = White.copy(alpha = 0.55f),
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}