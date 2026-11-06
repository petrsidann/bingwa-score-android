package com.bingwascore.app.ui.components

import android.content.Context
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 55 — shared press grammar for every tappable row, card and chip.
 *
 * Springs down to [DesignTokens.Motion.PressScale] while held and bounces back
 * on release. Optionally fires a haptic on press per the haptic grammar:
 * - Light / TextHandleMove — select, navigate, toggle
 * - LongPress / Heavy — commit, destructive
 */
@Composable
fun Modifier.bingwaPress(
    interactionSource: MutableInteractionSource,
    haptic: HapticFeedbackType? = null,
    enabled: Boolean = true
): Modifier {
    val context = LocalContext.current
    val isPressed by interactionSource.collectIsPressedAsState()
    val feedback = LocalHapticFeedback.current
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) DesignTokens.Motion.PressScale else 1f,
        animationSpec = springSpec(DesignTokens.Motion.SpringStiffness, DesignTokens.Motion.SpringDamping, context),
        label = "BingwaPressScale"
    )
    return graphicsLayer { scaleX = scale; scaleY = scale }
        .then(
            if (enabled) {
                clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        haptic?.let { feedback?.performHapticFeedback(it) }
                    }
                )
            } else Modifier
        )
}

/**
 * Reads the LocalContext accessibility manager and collapses to a 1ms crossfade
 * when the system "remove animations" setting is on. Never throws.
 */
fun reducedMotionEnabled(context: Context): Boolean {
    return try {
        val manager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as? AccessibilityManager
        (manager?.isTouchExplorationEnabled == true) ||
            Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) == 0f
    } catch (_: Throwable) {
        false
    }
}

/** Spring spec that collapses to a 1ms crossfade under reduced motion. */
fun springSpec(stiffness: Float, damping: Float, context: Context): FiniteAnimationSpec<Float> {
    return if (reducedMotionEnabled(context)) {
        tween(durationMillis = 1)
    } else {
        spring(stiffness = stiffness, dampingRatio = damping)
    }
}

/** Tween that collapses to 1ms under reduced motion. */
fun crossfadeSpec(durationMillis: Int, context: Context): TweenSpec<Float> {
    return if (reducedMotionEnabled(context)) {
        tween(durationMillis = 1)
    } else {
        tween(durationMillis = durationMillis)
    }
}
