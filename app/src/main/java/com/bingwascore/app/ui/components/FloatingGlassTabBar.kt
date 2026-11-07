package com.bingwascore.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics

private data class NavTabItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

private val TAB_ITEMS = listOf(
    NavTabItem("Home", Icons.Rounded.Home),
    NavTabItem("Offers", Icons.Rounded.LocalOffer),
    NavTabItem("Dial", Icons.Rounded.Call),
    NavTabItem("Transactions", Icons.AutoMirrored.Rounded.ReceiptLong),
    NavTabItem("Profile", Icons.Rounded.Person)
)

/**
 * Stage 57 — the floating glass pill tab bar: one explicit 72dp Row that can
 * never fill the screen. Five tabs: icon 24dp + label 10sp, active brand /
 * inactive textSecondary, light haptic on switch.
 */
@Composable
fun FloatingGlassTabBar(
    selected: Int,
    dialerOpen: Boolean = false,
    onSelect: (Int) -> Unit,
    onDialer: () -> Unit = {},
    onMenu: () -> Unit = {}
) {
    val haptics = rememberHaptics()
    val roles = DesignTokens.LocalBingwaRoles.current
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .navigationBarsPadding()
            .padding(bottom = 16.dp)
            .height(72.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(999.dp))
            .background(roles.card.copy(alpha = 0.7f))
            .border(1.dp, roles.border.copy(alpha = 0.35f), RoundedCornerShape(999.dp))
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TAB_ITEMS.forEachIndexed { index, item ->
            val active = selected == index
            val tint = if (active) roles.brand else roles.textSecondary
            Box(
                modifier = Modifier
                    .clickable(enabled = true) {
                        haptics.tick()
                        onSelect(index)
                    }
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = tint,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.label,
                        color = tint,
                        fontSize = 10.sp,
                        fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
    }
}
