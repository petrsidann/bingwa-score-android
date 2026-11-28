package com.bingwascore.app.ui.glass

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

/** Glass-system constants. Owned here per spec section 0 (glass lives only in ui/glass/). */
private val LensPill = Color(0xFF0B0B10)
private val LensIdle = Color(0xFF6B7280)

data class LensTab(val label: String, val icon: ImageVector)

val BingwaLensTabs = listOf(
    LensTab("Home", Icons.Rounded.Home),
    LensTab("Manage", Icons.Rounded.Dashboard),
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
    val density = LocalDensity.current
    BoxWithConstraints(modifier = modifier.fillMaxWidth().height(outerHeight)) {
        val tabWidth = maxWidth / BingwaLensTabs.size
        val lensWidth = minOf(88.dp, tabWidth + 4.dp)
        val targetPx = with(density) { (tabWidth * selectedIndex + (tabWidth - lensWidth) / 2).toPx() }
        val lensX = remember { Animatable(0f) }
        var primed by remember { mutableStateOf(false) }
        LaunchedEffect(targetPx) {
            if (!primed) {
                lensX.snapTo(targetPx)
                primed = true
            } else {
                lensX.animateTo(
                    targetPx,
                    spring(dampingRatio = 0.86f, stiffness = 260f, visibilityThreshold = 0.5f)
                )
            }
        }

        Box(
            Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(pillHeight)
                .shadow(18.dp, CircleShape, clip = false)
                .clip(CircleShape)
                .background(LensPill)
        )

        Box(
            Modifier
                .offset {
                    IntOffset(
                        lensX.value.roundToInt(),
                        with(density) { 9.dp.toPx() }.roundToInt()
                    )
                }
                .width(lensWidth).height(outerHeight)
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
                val tint by animateColorAsState(
                    targetValue = if (on) Color.White else LensIdle,
                    animationSpec = tween(180),
                    label = "tabTint"
                )
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
                        tint = tint,
                        modifier = Modifier.size(20.dp)
                    )
                    TabLabel(label = tab.label, visible = on)
                }
            }
        }
    }
}

@Composable
private fun TabLabel(label: String, visible: Boolean) {
    Box(Modifier.height(12.dp), contentAlignment = Alignment.TopCenter) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(140)),
            exit = fadeOut(tween(100))
        ) {
            Text(
                text = label,
                color = Color.White,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}