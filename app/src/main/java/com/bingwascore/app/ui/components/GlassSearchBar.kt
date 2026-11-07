package com.bingwascore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

/**
 * Stage 52 — the glass search field: Obsidian card at 0.8 alpha with a 12dp
 * backdrop blur, a 1dp Brand.Primary border and a soft glow on focus.
 *
 * Extracted as a shared component so Stage 53 (Customers) reuses the exact
 * Stage 52 logic instead of duplicating it.
 */
@Composable
fun GlassSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String = "Name, phone or transaction ID",
    onClose: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
    val glowRadius = with(LocalDensity.current) { DesignTokens.Shape.RadiusMd.toPx() }
    var focused by remember { mutableStateOf(false) }
    val roles = DesignTokens.LocalBingwaRoles.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(roles.card.copy(alpha = 0.8f))
            .blur(12.dp)
            .border(
                if (focused) 1.dp else 0.dp,
                roles.brand,
                shape
            )
            .drawBehind {
                if (focused) {
                    drawRoundRect(
                        brush = SolidColor(roles.brand.copy(alpha = 0.18f)),
                        cornerRadius = CornerRadius(glowRadius, glowRadius)
                    )
                }
            }
            .height(42.dp)
            .padding(start = 12.dp, end = 4.dp)
            .onFocusChanged { focused = it.isFocused }
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = null,
            tint = if (focused) roles.brand else roles.textPrimary,
            modifier = Modifier.size(17.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.weight(1f)) {
            if (query.isEmpty()) {
                Text(
                    placeholder,
                    color = roles.textPrimary.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Body,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp),
                cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            )
        }
        if (query.isNotEmpty()) {
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onClose),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Clear search",
                    tint = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
