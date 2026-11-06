package com.bingwascore.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TextWhite

/**
 * A Material-3 [AlertDialog] themed as a solid bubble panel:
 * translucent container, rounded corners and a brand-blue confirm action.
 *
 * U4 — no orange/amber anywhere in the product; the confirm action is the brand
 * blue via the shared CTA tokens.
 *
 * Used to explain *why* Advanced Mode needs the accessibility service before
 * sending the user to the system picker (see Home / Settings processing-mode flow).
 */
@Composable
fun ExplanationDialog(
    title: String,
    message: String,
    confirmText: String = "Open Settings",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    GlassDialog(
        visible = true,
        onDismiss = onDismiss,
        title = title,
        body = {
            Text(
                message,
                color = TextWhite.copy(alpha = 0.8f),
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth()
            )
        },
        dismissLabel = "Not now",
        confirmLabel = confirmText,
        onConfirm = onConfirm
    )
}
