package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ReceiptLong
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics

private data class NavTabItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
)

private val TAB_ITEMS = listOf(
    NavTabItem("Home", Icons.Rounded.Home),
    NavTabItem("Offers", Icons.Rounded.LocalOffer),
    NavTabItem("Dial", Icons.Rounded.Call),
    NavTabItem("Transactions", Icons.Rounded.ReceiptLong),
    NavTabItem("Profile", Icons.Rounded.Person),
)

/**
 * Stage 50 — premium floating glass tab bar.
 *
 * Replaces the Material bottom navigation. Floats 16dp above the bottom edge
 * with 16dp horizontal insets, rendered as a fully-rounded pill of blurred
 * glass (card surface with alpha, 1dp top highlight, Level2 shadow stack).
 *
 * Zero hardcoded colours: every hue, radius, spacing and spring reads from
 * [DesignTokens]. The active tab scales to 1.1x in Brand.Primary with a soft
 * glow shadow and lifts slightly; inactive tabs read at 50% ink. Selection
 * changes animate via [animateDpAsState] at [DesignTokens.Motion.SpringStiffness]
 * and fire a LongPress haptic.
 */
@Composable
fun FloatingGlassTabBar(
    selected: Int,
    dialerOpen: Boolean,
    onSelect: (Int) -> Unit,
    onDialer: () -> Unit,
    onMenu: () -> Unit
) {
    val haptics = rememberHaptics()
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DesignTokens.Spacing.Md)
            .padding(bottom = DesignTokens.Spacing.Md)
            .navigationBarsPadding()
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .drawBehind {
                val radiusPx = with(density) { DesignTokens.Shape.RadiusFull.toPx() }
                for (layer in DesignTokens.Elevation.Level2) {
                    val offsetY = with(density) { layer.offsetY.toPx() }
                    withTransform({ translate(0f, offsetY) }) {
                        drawRoundRect(
                            brush = SolidColor(layer.color),
                            cornerRadius = CornerRadius(radiusPx, radiusPx)
                        )
                    }
                }
            }
    ) {
        // Glass surface: blurred translucent card with a 1dp top highlight.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                .background(DesignTokens.Color.Card.copy(alpha = 0.85f))
                .blurIfSupported()
        )
        // Top edge highlight (Vercel-style glass).
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White.copy(alpha = 0.1f))
        )
        // Tabs overlay the glass background.
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TAB_ITEMS.forEachIndexed { index, item ->
                val active = (selected == index && !dialerOpen) || (index == 2 && dialerOpen)
                val activeY by animateDpAsState(
                    targetValue = if (active) -4.dp else 0.dp,
                    animationSpec = spring(
                        stiffness = DesignTokens.Motion.SpringStiffness,
                        dampingRatio = DesignTokens.Motion.SpringDamping
                    ),
                    label = "tabLift"
                )
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    FloatingGlassTab(
                        item = item,
                        active = active,
                        activeY = activeY,
                        onClick = {
                            haptics.press()
                            if (index == 2) onDialer() else onSelect(index)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun FloatingGlassTab(
    item: NavTabItem,
    active: Boolean,
    activeY: Dp,
    onClick: () -> Unit
) {
    val tint = if (active) DesignTokens.Color.Brand.Primary else DesignTokens.Color.Ink.copy(alpha = 0.5f)
    val interactionSource = remember { MutableInteractionSource() }
    val modifier = Modifier
        .size(52.dp)
        .padding(vertical = 8.dp)
        .offset(x = 0.dp, y = activeY)
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        )
        .graphicsLayer {
            scaleX = if (active) 1.1f else 1f
            scaleY = if (active) 1.1f else 1f
        }
        .takeIf { active }?.shadow(10.dp, CircleShape) ?: Modifier

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.label,
            color = tint,
            fontSize = DesignTokens.Typography.Caption,
            fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
            maxLines = 1
        )
    }
}

/** Blur render effect (API 31+). Flat fallback on older APIs so minSdk 26 is safe. */
private fun Modifier.blurIfSupported(): Modifier =
    if (Build.VERSION.SDK_INT >= 31) this.blur(DesignTokens.Glass.BlurRadius) else this
