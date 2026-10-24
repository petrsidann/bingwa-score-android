package com.bingwascore.app.ui.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.glass.canMaterialBlur
import com.bingwascore.app.ui.glass.iosMaterial
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.DisplayModeState
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.util.rememberHaptics

data class NavMorphItem(
    val id: Int,
    val label: String,
    val icon: ImageVector
)

val NAV_ITEMS = listOf(
    NavMorphItem(0, "Home", Icons.Rounded.Home),
    NavMorphItem(1, "Offers", Icons.Rounded.LocalOffer),
    NavMorphItem(2, "Dial", Icons.Rounded.Call),
    NavMorphItem(3, "Transactions", Icons.AutoMirrored.Rounded.ReceiptLong),
    NavMorphItem(4, "Profile", Icons.Rounded.Person)
)

/**
 * Shared navigation tab item used in both bottom pill and morphed drawer rail.
 */
@Composable
fun SharedNavTab(
    item: NavMorphItem,
    selected: Boolean,
    modifier: Modifier = Modifier,
    isRail: Boolean = false,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val tint by animateColorAsState(
        targetValue = if (selected) AccentBlue else TextGrey,
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "navTint"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .pressScale(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(vertical = if (isRail) 10.dp else 6.dp, horizontal = if (isRail) 12.dp else 4.dp)
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            tint = tint,
            modifier = Modifier.size(if (isRail) 24.dp else 22.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = item.label,
            color = tint,
            fontSize = if (isRail) 10.sp else BingwaType.Micro,
            maxLines = 1,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

/**
 * Vertical navigation rail docked to the right edge of SideDrawerSheet.
 * Morphs in with staggered ~20ms spring damping when drawer opens.
 */
@Composable
fun VerticalNavRail(
    isOpen: Boolean,
    selected: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val haptics = rememberHaptics()

    Column(
        modifier = modifier
            .width(64.dp)
            .fillMaxHeight()
            .padding(vertical = 24.dp, horizontal = 4.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .iosMaterial(
                shape = RoundedCornerShape(16.dp),
                tint = if (DisplayModeState.mode == ThemeMode.DARK) Color(0xD80B0E15) else Color(0xD8E2E4E8),
                vibrancy = !canMaterialBlur
            )
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        NAV_ITEMS.forEachIndexed { index, item ->
            // Staggered ~20ms delay simulation per item using spring damping
            val itemOffset by animateFloatAsState(
                targetValue = if (isOpen) 0f else 40f,
                animationSpec = spring(
                    dampingRatio = Motion.DAMPING,
                    stiffness = Spring.StiffnessHigh - (index * 100f)
                ),
                label = "railItemOffset_$index"
            )
            val itemAlpha by animateFloatAsState(
                targetValue = if (isOpen) 1f else 0f,
                animationSpec = spring(dampingRatio = Motion.DAMPING),
                label = "railItemAlpha_$index"
            )

            SharedNavTab(
                item = item,
                selected = selected == item.id,
                isRail = true,
                modifier = Modifier
                    .offset(x = itemOffset.dp)
                    .alpha(itemAlpha)
            ) {
                haptics.tick()
                onSelect(item.id)
            }
        }
    }
}
