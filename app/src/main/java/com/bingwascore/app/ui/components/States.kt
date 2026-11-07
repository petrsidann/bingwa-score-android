package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 55 — empty state: icon 64dp Brand.Primary 25% alpha, Headline, Caption
 * 0.7, optional ghost NeoButton action.
 */
@Composable
fun GlassEmptyState(
    icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Rounded.Inbox,
    title: String,
    message: String? = null,
    action: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = DesignTokens.Spacing.Lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(DesignTokens.Spacing.EmptyIconSize)
                    .clip(CircleShape)
                    .background(roles.brand.copy(alpha = DesignTokens.Spacing.EmptyIconAlpha)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = roles.brand,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Text(
                text = title,
                color = roles.textPrimary,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            if (!message.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                Text(
                    text = message,
                    color = roles.textSecondary.copy(alpha = 0.7f),
                    fontSize = DesignTokens.Typography.Caption,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
            if (action != null) {
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    action()
                }
            }
        }
    }
}

/**
 * Stage 55 — error state: Error-tinted icon, Caption reason, filled NeoButton
 * "Retry" wired to the existing ViewModel refresh lambda passed in [onRetry].
 */
@Composable
fun GlassErrorState(
    icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Rounded.ErrorOutline,
    reason: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = DesignTokens.Spacing.Lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(DesignTokens.Spacing.EmptyIconSize)
                    .clip(CircleShape)
                    .background(roles.error.copy(alpha = DesignTokens.Spacing.EmptyIconAlpha)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = roles.error,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Text(
                text = reason,
                color = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                fontSize = DesignTokens.Typography.Caption,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NeoButton(
                    onClick = onRetry,
                    fillMaxWidth = false,
                    height = 44.dp,
                    fill = roles.brand
                ) {
                    Text(
                        text = "Retry",
                        color = roles.onBrand,
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

/**
 * Stage 55 — offline state: cloud-off icon + retry.
 */
@Composable
fun GlassOfflineState(
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    GlassErrorState(
        icon = Icons.Rounded.CloudOff,
        reason = "You're offline — check your connection and retry.",
        onRetry = onRetry,
        modifier = modifier
    )
}
