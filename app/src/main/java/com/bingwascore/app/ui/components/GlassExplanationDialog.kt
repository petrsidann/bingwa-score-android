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
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.White

/**
 * A Material-3 [AlertDialog] themed to read like a frosted glass panel:
 * translucent container, rounded corners and a green confirm action.
 *
 * Used to explain *why* Advanced Mode needs the accessibility service before
 * sending the user to the system picker (see Home / Settings processing-mode flow).
 */
@Composable
fun GlassExplanationDialog(
    title: String,
    message: String,
    confirmText: String = "Open Settings",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    confirmText,
                    color = EmeraldGreen,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    "Not now",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 14.sp
                )
            }
        },
        title = {
            Text(
                title,
                color = White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        },
        text = {
            Text(
                message,
                color = White.copy(alpha = 0.8f),
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = Color(0x14FFFFFF),
        tonalElevation = 8.dp,
        shape = RoundedCornerShape(24.dp)
    )
}
