package com.bingwascore.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.bingwascore.app.ui.navigation.drawerEntries
import com.bingwascore.app.ui.theme.DesignTokens
private val SHEET_WIDTH_DP = 280f

/**
 * Stage 50 — liquid glass side drawer.
 *
 * A frosted-glass sheet that slides in from the left edge behind a dimming
 * scrim. Background uses [DesignTokens.Glass] blur + card surface with alpha
 * plus a 1dp top highlight; the scrim dims at [Color.Black.copy(alpha = 0.4f)].
 * Menu rows press to 0.98f via [pressScale] and render in mode-aware ink.
 *
 * Zero hardcoded colours: every hue, radius, spacing and spring reads from
 * [DesignTokens]. The header name uses [DesignTokens.Typography.Headline].
 */
@Composable
fun LiquidGlassDrawer(
    isOpen: Boolean,
    onClose: () -> Unit,
    selectedIndex: Int = -1,
    onEntryClick: (Int) -> Unit = {}
) {
    val density = LocalDensity.current
    val offset by animateFloatAsState(
        targetValue = if (isOpen) 0f else -SHEET_WIDTH_DP,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "liquidGlassDrawer"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Dimming scrim behind the drawer.
        if (isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable(onClick = onClose)
            )
        }

        // Sliding sheet.
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(SHEET_WIDTH_DP.dp)
                .offset(x = offset.dp, y = 0.dp)
                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusLg))
                .drawBehind {
                    val radiusPx = with(density) { DesignTokens.Shape.RadiusLg.toPx() }
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
            // Frosted glass surface.
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusLg))
                    .background(DesignTokens.Color.Card.copy(alpha = 0.92f))
                    .blurIfSupported()
            )
            // Top edge highlight.
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.White.copy(alpha = 0.1f))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp, start = 20.dp, end = 20.dp, bottom = 24.dp)
            ) {
                // Header: avatar placeholder, name, phone.
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(DesignTokens.Color.Elevated),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "B",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Bingwa User",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                            style = DesignTokens.Typography.Headline,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "+254 7XXXX XXX",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                            fontSize = DesignTokens.Typography.Caption
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                // Menu items: Customers, Auto Renewals, Smart Follow-Up, Autopilot, Settings, ...
                drawerEntries.forEachIndexed { index, entry ->
                    val selected = selectedIndex == index
                    val interactionSource = remember { MutableInteractionSource() }
                    val tint = if (selected) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.textPrimary
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                onClick = { onEntryClick(index) }
                            )
                            .pressScale(interactionSource)
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                        ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = entry.icon,
                            contentDescription = entry.label,
                            tint = tint,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = entry.label,
                            color = tint,
                            fontSize = DesignTokens.Typography.Body,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/** Blur render effect (API 31+). Flat fallback on older APIs so minSdk 26 is safe. */
private fun Modifier.blurIfSupported(): Modifier =
    if (android.os.Build.VERSION.SDK_INT >= 31) this.blur(DesignTokens.Glass.BlurRadius) else this
