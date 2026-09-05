package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.BrandGradientEnd
import com.bingwascore.app.ui.theme.BrandGradientStart
import com.bingwascore.app.ui.theme.GlassHighlight
import com.bingwascore.app.ui.theme.GlassWhite
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TextPrimary

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    Box(
        modifier = modifier
            .shadow(12.dp, shape, ambientColor = Color.Black.copy(0.35f), spotColor = Color.Black.copy(0.35f))
            .clip(shape)
            .background(GlassWhite)
            .border(1.dp, Brush.verticalGradient(listOf(GlassHighlight, Color.Transparent)), shape)
    ) {
        Column(modifier = Modifier.padding(20.dp)) { content() }
    }
}

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Brush.horizontalGradient(listOf(BrandGradientStart, BrandGradientEnd)))
            .clickable(enabled = enabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = NightBlack, fontWeight = FontWeight.Bold, fontSize = 17.sp, letterSpacing = 0.3.sp)
    }
}
