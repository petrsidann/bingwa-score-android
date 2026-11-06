package com.bingwascore.app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics

/**
 * Stage 55 — glass dialog. Replaces [androidx.compose.material3.AlertDialog].
 *
 * Optics per the STANDING DESIGN LAW: RadiusLg, Card surface at Glass.TintAlpha,
 * 1dp top specular (Ink 12% alpha), hairline border, Level 2 layered shadow
 * stack, Ink 40% scrim. Enter: scale 0.92->1.0 spring(380,0.86) + alpha 0->1
 * (120ms). Exit: scale ->0.96 spring(500,1.0) + alpha ->0 (90ms).
 *
 * Anatomy: Title (Headline), Body (composable slot), actions end-aligned:
 * dismiss = ghost NeoButton, confirm = filled NeoButton.
 * Haptics: Light on open/dismiss, Heavy on confirm.
 */
@Composable
fun GlassDialog(
    visible: Boolean,
    onDismiss: () -> Unit,
    title: String,
    body: @Composable () -> Unit,
    dismissLabel: String = "Cancel",
    confirmLabel: String,
    onConfirm: () -> Unit,
    confirmDangerous: Boolean = false,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    val density = LocalDensity.current

    LaunchedEffect(visible) {
        if (visible) haptics.tick()
    }

    val scrimAlpha by androidx.compose.animation.core.animateFloatAsState(
        targetValue = if (visible) DesignTokens.Glass.ScrimInkAlpha else 0f,
        animationSpec = tween(durationMillis = DesignTokens.Motion.DialogEnterDuration.toInt()),
        label = "GlassDialogScrim"
    )

    AnimatedVisibility(
        visible = visible,
        modifier = modifier,
        enter = scaleIn(
            initialScale = 0.92f,
            animationSpec = springSpec(
                DesignTokens.Motion.DialogEnterStiffness,
                DesignTokens.Motion.DialogEnterDamping,
                context
            )
        ) + fadeIn(
            animationSpec = crossfadeSpec(DesignTokens.Motion.DialogEnterDuration.toInt(), context)
        ),
        exit = scaleOut(
            animationSpec = springSpec(
                DesignTokens.Motion.DialogExitStiffness,
                DesignTokens.Motion.DialogExitDamping,
                context
            )
        ) + fadeOut(
            animationSpec = crossfadeSpec(DesignTokens.Motion.DialogExitDuration.toInt(), context)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Scrim: Ink 40%.
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DesignTokens.Color.Ink.copy(alpha = scrimAlpha))
            )
            // Dialog surface: one glass layer in this region.
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.88f)
                    .wrapContentHeight()
                    .padding(horizontal = DesignTokens.Spacing.Md, vertical = DesignTokens.Spacing.Lg)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusLg))
                    .background(DesignTokens.Color.Card.copy(alpha = DesignTokens.Glass.TintAlpha))
                    .border(1.dp, DesignTokens.Color.Border, RoundedCornerShape(DesignTokens.Shape.RadiusLg))
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
                // 1dp top specular highlight: Ink 12% alpha.
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(DesignTokens.Color.Ink.copy(alpha = DesignTokens.Glass.SpecularAlpha))
                )
                Column(
                    modifier = Modifier.padding(vertical = DesignTokens.Spacing.Sm, horizontal = DesignTokens.Spacing.Md)
                ) {
                    Text(
                        text = title,
                        color = DesignTokens.Color.Ink,
                        fontSize = DesignTokens.Typography.Headline,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                    body()
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        NeoButton(
                            onClick = { haptics.tick(); onDismiss() },
                            fillMaxWidth = false,
                            height = 40.dp,
                            fill = Color.Transparent
                        ) {
                            Text(
                                text = dismissLabel,
                                color = DesignTokens.Color.Ink,
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Spacer(modifier = Modifier.width(DesignTokens.Spacing.Xs))
                        NeoButton(
                            onClick = { haptics.press(); onConfirm() },
                            fillMaxWidth = false,
                            height = 40.dp,
                            fill = if (confirmDangerous) DesignTokens.Color.Brand.Error else DesignTokens.Color.Brand.Primary
                        ) {
                            Text(
                                text = confirmLabel,
                                color = Color.White,
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}
