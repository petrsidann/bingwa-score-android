package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage P2A — D3: 54dp circular avatar/head standard.
 *
 * All circular avatars/heads across the app use this component for consistency.
 * Default size is 54dp with bold initials centered in a circle.
 */
@Composable
fun CircularHead(
    initials: String,
    backgroundColor: Color = DesignTokens.LocalBingwaRoles.current.brand,
    textColor: Color = DesignTokens.LocalBingwaRoles.current.onBrand,
    size: Dp = 54.dp
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials.take(2).uppercase(),
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
