package com.bingwascore.app.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.TealBlue

/**
 * Subtle animated background: 2-3 soft radial gradient blobs (EmeraldGreen,
 * TealBlue, Purple500 at 8-12 % alpha) whose centres drift endlessly using a
 * [rememberInfiniteTransition].
 *
 * Drop this behind Splash, Login and Home for a premium iOS feel.
 */
@Composable
fun AmbientBackground(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "ambientBg")

    val driftA by transition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(22_000), RepeatMode.Reverse),
        label = "driftA"
    )
    val driftB by transition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(28_000), RepeatMode.Reverse),
        label = "driftB"
    )
    val driftC by transition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(34_000), RepeatMode.Reverse),
        label = "driftC"
    )

    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Blob 1 — EmeraldGreen, bottom-left
        val cx1 = w * (0.15f + 0.12f * driftA)
        val cy1 = h * (0.75f + 0.12f * driftB)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(EmeraldGreen.copy(alpha = 0.10f), EmeraldGreen.copy(alpha = 0f)),
                center = Offset(cx1, cy1),
                radius = w * 0.45f
            ),
            center = Offset(cx1, cy1),
            radius = w * 0.45f
        )

        // Blob 2 — TealBlue, top-right
        val cx2 = w * (0.80f + 0.10f * driftC)
        val cy2 = h * (0.20f + 0.10f * driftA)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(TealBlue.copy(alpha = 0.11f), TealBlue.copy(alpha = 0f)),
                center = Offset(cx2, cy2),
                radius = w * 0.40f
            ),
            center = Offset(cx2, cy2),
            radius = w * 0.40f
        )

        // Blob 3 — Purple500, top-left
        val cx3 = w * (0.25f + 0.12f * driftB)
        val cy3 = h * (0.12f + 0.12f * driftC)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Purple500.copy(alpha = 0.09f), Purple500.copy(alpha = 0f)),
                center = Offset(cx3, cy3),
                radius = w * 0.38f
            ),
            center = Offset(cx3, cy3),
            radius = w * 0.38f
        )
    }
}
