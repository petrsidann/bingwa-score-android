package com.bingwascore.app.ui.glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.theme.isPorcelain

/**
 * Stage S72 — canonical glass card.
 *
 * Spec recipe (from ui/glass/ only):
 * - fill card@tint (scrim alpha from GlassSpec)
 * - backdrop blur via frostedGlass modifier
 * - 1dp border@60% alpha
 * - inset 1dp top specular white 60% gradient highlight
 *
 * No other file may declare a glass recipe.
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(DesignTokens.Shape.RadiusLg)
    val isPorcelainTheme = isPorcelain
    val scrim = GlassSpec.scrimColor(isPorcelainTheme)
    val borderColor = DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.6f)
    val highlight = GlassSpec.innerTopHighlightColor()

    Box(
        modifier = modifier
            .clip(shape)
            .background(scrim)
            .border(1.dp, borderColor, shape)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(highlight, androidx.compose.ui.graphics.Color.Transparent)
                ),
                shape = shape
            ),
        content = { content() }
    )
}
