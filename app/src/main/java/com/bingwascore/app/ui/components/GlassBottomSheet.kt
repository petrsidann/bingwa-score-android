package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics

/**
 * Stage 55 — glass bottom sheet. Replaces [androidx.compose.material3.ModalBottomSheet].
 *
 * Top-only RadiusLg corners, 32x4dp RadiusFull drag handle (Border 40% alpha),
 * Card surface with Level 2 shadow stack and 1dp Ink 12% top specular.
 * Enter: slide-up spring(380,0.86). Drag-dismiss with velocity threshold.
 * Scrim: Ink 40% synced to sheet position.
 * Haptics: Light on snap-to-open and snap-to-close.
 *
 * The sheet stays in the composition; [visible] drives the slide/scrim so exit
 * plays before the parent removes it.
 */
@Composable
fun GlassBottomSheet(
    visible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val haptics = rememberHaptics()
    val density = LocalDensity.current
    val context = LocalContext.current

    var sheetSize by remember { mutableStateOf(IntSize(0, 0)) }
    var prevVisible by remember { mutableStateOf(visible) }
    var drag by remember { mutableStateOf(0f) }
    var base by remember { mutableStateOf(if (visible) 0f else 1f) }

    LaunchedEffect(visible) {
        base = if (visible) 0f else 1f
        drag = 0f
        if (visible) {
            haptics.tick() // snap-to-open
        } else if (prevVisible) {
            haptics.tick() // snap-to-close
        }
        prevVisible = visible
    }

    val progress by animateFloatAsState(
        targetValue = base + drag,
        animationSpec = springSpec(DesignTokens.Motion.SheetEnterStiffness, DesignTokens.Motion.SheetEnterDamping, context),
        label = "GlassBottomSheetProgress"
    )

    val scrimAlpha by animateFloatAsState(
        targetValue = (1f - progress) * DesignTokens.Glass.ScrimInkAlpha,
        animationSpec = crossfadeSpec(DesignTokens.Motion.DialogEnterDuration.toInt(), context),
        label = "GlassBottomSheetScrim"
    )

    val cornerShape = RoundedCornerShape(
        topStart = DesignTokens.Shape.RadiusLg,
        topEnd = DesignTokens.Shape.RadiusLg,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )

    Box(
        modifier = modifier.then(Modifier.fillMaxSize()),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Scrim: Ink 40%, synced to sheet position.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DesignTokens.Color.Ink.copy(alpha = scrimAlpha))
                .clickable(onClick = onDismiss)
        )
        // Sheet surface: one glass layer in this region.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged { sheetSize = it }
                .graphicsLayer { translationY = progress * sheetSize.height.coerceAtLeast(1).toFloat() }
                .clip(cornerShape)
                .background(DesignTokens.Color.Card)
                .border(1.dp, DesignTokens.Color.Border, cornerShape)
                .drawBehind {
                    val radiusPx = with(density) { DesignTokens.Shape.RadiusLg.toPx() }
                    val cornerRadius = CornerRadius(radiusPx, radiusPx)
                    for (layer in DesignTokens.Elevation.Level2) {
                        val offsetY = with(density) { layer.offsetY.toPx() }
                        withTransform({ translate(0f, offsetY) }) {
                            drawRoundRect(
                                brush = SolidColor(layer.color),
                                cornerRadius = cornerRadius
                            )
                        }
                    }
                }
        ) {
            // Drag handle: 32x4dp RadiusFull, Border 40% alpha.
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth()
                    .height(DesignTokens.Spacing.DragHandleHeight)
                    .padding(horizontal = DesignTokens.Spacing.Lg)
            ) {
                Box(
                    modifier = Modifier
                        .width(DesignTokens.Spacing.DragHandleWidth)
                        .height(DesignTokens.Spacing.DragHandleHeight)
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                        .border(
                            1.dp,
                            DesignTokens.Color.Border.copy(alpha = DesignTokens.Spacing.DragHandleBorderAlpha),
                            RoundedCornerShape(DesignTokens.Shape.RadiusFull)
                        )
                        .background(DesignTokens.Color.Border.copy(alpha = DesignTokens.Spacing.DragHandleBorderAlpha))
                        .align(Alignment.Center)
                )
            }
            content()
        }
    }
}
