package com.bingwascore.app.util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.bingwascore.app.ui.theme.Motion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Screen-level enter animation: fade in from 0 → 1 and slide up from 24px → 0,
 * both with a soft spring (`dampingRatio = Motion.DAMPING`).
 *
 * Apply to the root [Modifier] of **every** screen so each navigation fades +
 * slides in. The optional [delayMs] staggers the start — use [stagger] for
 * list rows.
 */
@Composable
fun Modifier.screenEnter(delayMs: Int = 0): Modifier {
    val alphaAnim = remember(delayMs) { Animatable(0f) }
    val offsetAnim = remember(delayMs) { Animatable(24f) }

    LaunchedEffect(delayMs) {
        if (delayMs > 0) delay(delayMs.toLong())
        launch { alphaAnim.animateTo(1f, spring(dampingRatio = Motion.DAMPING)) }
        launch { offsetAnim.animateTo(0f, spring(dampingRatio = Motion.DAMPING)) }
    }

    return graphicsLayer {
        alpha = alphaAnim.value
        translationY = offsetAnim.value
    }
}

/**
 * Staggered enter: item `[index]` starts [Motion.STAGGER] ms after the
 * previous one, producing a satisfying cascade down the list.
 */
@Composable
fun Modifier.stagger(index: Int): Modifier = screenEnter(index * Motion.STAGGER)
