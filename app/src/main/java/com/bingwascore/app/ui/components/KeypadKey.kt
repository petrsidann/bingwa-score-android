package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 57 — one tactile keypad key: 72dp circle in roles.keypadKey, digit in
 * roles.keypadDigit, TextHandleMove haptic on press.
 */
@Composable
fun KeypadKey(
    d: String,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onKey: (String) -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val haptic = LocalHapticFeedback.current
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(roles.keypadKey)
            .clickable(enabled = enabled) {
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                onKey(d)
            },
        contentAlignment = Alignment.Center
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = roles.keypadDigit,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Text(
                "$d",
                color = roles.keypadDigit,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
