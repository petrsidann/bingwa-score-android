package com.bingwascore.app.ui.glass

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Glass-system constants. Owned here per spec section 0 (glass lives only in ui/glass/). */
private val LensPill = Color(0xFF0B0B10)
private val LensIdle = Color(0xFF6B7280)

data class LensTab(val label: String, val icon: ImageVector)

val BingwaLensTabs = listOf(
    LensTab("Home", Icons.Rounded.Home),
    LensTab("Store", Icons.Rounded.Link),
    LensTab("Settings", Icons.Rounded.Settings),
    LensTab("Community", Icons.Rounded.People)
)

/**
 * Spec 3 — black pill + morphing liquid-glass lens.
 * Pill 64dp; lens 88x82 sitting 9dp above the pill; spring with overshoot.
 * The lens holds no pointer input, so taps fall through to the tabs beneath it.
 */
@Composable
fun LensTabBar(
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val outerHeight = 82.dp
    val pillHeight = 64.dp
    BoxWithConstraints(modifier = modifier.fillMaxWidth().height(outerHeight)) {
        val tabWidth = maxWidth / BingwaLensTabs.size
        val lensWidth = minOf(88.dp, tabWidth + 4.dp)
        val target = tabWidth * selectedIndex + (tabWidth - lensWidth) / 2
        val lensLeft by animateDpAsState(
            targetValue = target,
            animationSpec = spring(dampingRatio = 0.62f, stiffness = 380f),
            label = "lensLeft"
        )

        Box(
            Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(pillHeight)
                .shadow(18.dp, CircleShape, clip = false)
                .clip(CircleShape)
                .background(LensPill)
        )

        Box(
            Modifier.offset(x = lensLeft, y = 9.dp).width(lensWidth).height(outerHeight)
                .shadow(14.dp, RoundedCornerShape(26.dp), clip = false)
                .clip(RoundedCornerShape(26.dp))
                .background(Color.White.copy(alpha = 0.08f))
                .border(1.5.dp, Color.White.copy(alpha = 0.66f), RoundedCornerShape(26.dp))
        ) {
            val arc = Brush.horizontalGradient(
                listOf(Color.Transparent, Color.White.copy(alpha = 0.92f), Color.Transparent)
            )
            Box(
                Modifier.align(Alignment.TopCenter).fillMaxWidth(0.84f).height(10.dp)
                    .offset(y = (-2).dp).clip(CircleShape).background(arc)
            )
            Box(
                Modifier.align(Alignment.BottomCenter).fillMaxWidth(0.84f).height(10.dp)
                    .offset(y = 2.dp).clip(CircleShape).background(arc)
            )
        }

        Row(Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(pillHeight)) {
            BingwaLensTabs.forEachIndexed { i, tab ->
                val on = i == selectedIndex
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight().clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onSelect(i) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.label,
                        tint = if (on) Color.White else LensIdle,
                        modifier = Modifier.size(20.dp)
                    )
                    if (on) {
                        Spacer(Modifier.height(3.dp))
                        Text(
                            text = tab.label,
                            color = Color.White,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}