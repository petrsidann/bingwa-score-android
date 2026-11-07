package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 57 — single-outline glass input: one border (brand when focused), no
 * floating inner outline, placeholder shown inline while empty.
 */
@Composable
fun GlassInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    focused: Boolean = false,
    readOnly: Boolean = false,
    isPassword: Boolean = false,
    focusRequester: FocusRequester? = null,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val requester = remember { focusRequester ?: FocusRequester() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(roles.elevated.copy(alpha = 0.6f))
            .border(
                if (focused) 1.5.dp else 1.dp,
                if (focused) roles.brand else roles.border,
                RoundedCornerShape(12.dp)
            )
            .clickable(enabled = onClick != null, onClick = onClick)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            readOnly = readOnly,
            textStyle = TextStyle(color = roles.textPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .focusable()
                .focusRequester(requester),
            visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            decorationBox = { inner ->
                Box(Modifier.padding(horizontal = 16.dp), contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()) {
                        Text(placeholder, color = roles.textSecondary)
                    }
                    inner()
                }
            }
        )
    }
}
