package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.TealBlue

/**
 * Frosted glass card. Every card fades + slides in on composition; when
 * [onClick] is provided the card also springs to 0.98 scale while pressed.
 * [enterDelayMillis] staggers lists (min(index, 6) * 35 reads naturally).
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    onClick: (() -> Unit)? = null,
    enterDelayMillis: Int = 0,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)
    val interactionSource = remember { MutableInteractionSource() }

    val visuals = Modifier
        .shadow(12.dp, shape, ambientColor = Color.Black.copy(0.35f))
        .clip(shape)
        .background(Color(0x14FFFFFF))
        .border(1.dp, Brush.verticalGradient(listOf(Color(0x33FFFFFF), Color.Transparent)), shape)

    val cardModifier = if (onClick != null) {
        Modifier
            .pressScale(interactionSource)
            .then(visuals)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    } else {
        visuals
    }

    Box(modifier = modifier.enterAnimation(enterDelayMillis).then(cardModifier)) {
        Column(modifier = Modifier.padding(20.dp)) { content() }
    }
}

/**
 * Full-width gradient action button with the same 0.98 press-scale feedback.
 */
@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Brush.horizontalGradient(listOf(EmeraldGreen, TealBlue)))
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color(0xFF0A0A0F), fontWeight = FontWeight.Bold, fontSize = 17.sp)
    }
}
