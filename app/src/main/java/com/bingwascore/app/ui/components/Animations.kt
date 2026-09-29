package com.bingwascore.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.util.screenEnter
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
    val density = LocalDensity.current
    val slideDistance = with(density) { 16.dp.toPx() }
    val fade = remember(delayMillis) { Animatable(0f) }
    val slideY = remember(delayMillis, slideDistance) { Animatable(slideDistance) }
    val enterScale = remember(delayMillis) { Animatable(0.96f) }

    LaunchedEffect(delayMillis) {
        if (delayMillis > 0) delay(delayMillis.toLong())
        launch { fade.animateTo(1f, tween(Motion.FADE)) }
        launch { slideY.animateTo(0f, tween(Motion.SLIDE)) }
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
        Box(modifier = modifier.screenEnter()) { content() }
    }
}
// Parity E — the EmptyState composable moved to EmptyState.kt.
