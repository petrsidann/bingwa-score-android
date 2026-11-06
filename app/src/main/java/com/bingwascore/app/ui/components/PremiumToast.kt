package com.bingwascore.app.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class ToastType {
    Success, Error, Info
}

data class ToastData(val type: ToastType, val message: String)

/** App-wide toast bus. Screens show toasts imperatively via [LocalPremiumToastManager]. */
class PremiumToastManager {
    var current by mutableStateOf<ToastData?>(null)

    fun show(type: ToastType, message: String) {
        current = ToastData(type, message)
    }

    fun clear() {
        current = null
    }
}

val LocalPremiumToastManager = staticCompositionLocalOf { PremiumToastManager() }

/** Host placed once in the Scaffold (replaces the snackbar host). Renders max one toast. */
@Composable
fun PremiumToastHost() {
    val manager = LocalPremiumToastManager.current
    val current = manager.current
    AnimatedContent(
        targetState = current,
        modifier = Modifier.fillMaxWidth()
    ) { data ->
        data?.let { toast ->
            PremiumToast(toast) { manager.clear() }
        }
    }
}

/** Floating glass pill: bottom offset 96dp, horizontal margin 16dp, icon + body. */
@Composable
fun PremiumToast(data: ToastData, onDismiss: () -> Unit) {
    val haptics = rememberHaptics()
    LaunchedEffect(Unit) { haptics.tick() } // TextHandleMove — light
    LaunchedEffect(Unit) {
        delay(DesignTokens.Motion.ToastAutoDismiss)
        onDismiss()
    }

    val density = LocalDensity.current
    val context = LocalContext.current
    val slideDistance = with(density) { 16.dp.toPx() }
    var slideTarget by remember { mutableStateOf(slideDistance) }
    LaunchedEffect(Unit) { slideTarget = 0f }
    val slideY by animateFloatAsState(
        targetValue = slideTarget,
        animationSpec = springSpec(DesignTokens.Motion.ToastEnterStiffness, DesignTokens.Motion.ToastEnterDamping, context),
        label = "PremiumToastSlide"
    )
    var alphaTarget by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) { alphaTarget = 1f }
    val alphaAnim by animateFloatAsState(
        targetValue = alphaTarget,
        animationSpec = crossfadeSpec(DesignTokens.Motion.DialogEnterDuration.toInt(), context),
        label = "PremiumToastFade"
    )

    val (icon, tint) = when (data.type) {
        ToastType.Success -> Icons.Rounded.CheckCircle to DesignTokens.Color.Brand.Success
        ToastType.Error -> Icons.Rounded.ErrorOutline to DesignTokens.Color.Brand.Error
        ToastType.Info -> Icons.Rounded.Info to DesignTokens.Color.Brand.Primary
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = DesignTokens.Spacing.ToastHorizontalMargin)
                .padding(bottom = DesignTokens.Spacing.ToastBottomOffset)
                .graphicsLayer { translationY = slideY; alpha = alphaAnim }
                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                .background(DesignTokens.Color.Elevated)
                .border(1.dp, DesignTokens.Color.Border, RoundedCornerShape(DesignTokens.Shape.RadiusFull))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = tint,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = data.message,
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Body
                )
            }
        }
    }
}
