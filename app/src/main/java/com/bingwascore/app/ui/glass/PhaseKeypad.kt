package com.bingwascore.app.ui.glass

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Backspace
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Glass-system constants (spec 0: glass surfaces live only in ui/glass/). */
private val PadSurface = Color(0xFF0B0B10)
private val PadKey = Color(0xFF1A1A22)
private val PadInk = Color(0xFFF8FAFC)
private val PadLime = Color(0xFFA4F510)

/**
 * PIN readout. A tappable Box, deliberately NOT a text field, so the system
 * keyboard can never be summoned by it.
 */
@Composable
fun PhasePinDots(
    count: Int,
    active: Boolean,
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    total: Int = 4
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(PadSurface)
            .border(
                width = if (active) 2.dp else 1.dp,
                color = if (active) PadLime else Color.White.copy(alpha = 0.14f),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onTap
            )
            .padding(horizontal = 18.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(total) { i ->
            Box(
                Modifier.size(12.dp).clip(CircleShape)
                    .background(if (i < count) PadLime else Color.White.copy(alpha = 0.22f))
            )
        }
    }
}

/** Shared dark-glass keypad. Consumed by Login and Create Account so they match exactly. */
@Composable
fun PhaseKeypad(
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(PadSurface)
            .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(24.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        listOf("123", "456", "789").forEach { row ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                row.forEach { ch ->
                    PhaseKeyCell(Modifier.weight(1f), { onDigit(ch) }) {
                        Text(ch.toString(), color = PadInk, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Spacer(Modifier.weight(1f).height(68.dp))
            PhaseKeyCell(Modifier.weight(1f), { onDigit('0') }) {
                Text("0", color = PadInk, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }
            PhaseKeyCell(Modifier.weight(1f), onBackspace) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.Backspace,
                    contentDescription = "Backspace",
                    tint = PadInk,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
private fun PhaseKeyCell(
    modifier: Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.94f else 1f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 600f),
        label = "phaseKeyScale"
    )
    Box(modifier.height(68.dp), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .graphicsLayer { scaleX = scale; scaleY = scale }
                .clip(CircleShape)
                .background(if (pressed) PadLime.copy(alpha = 0.18f) else PadKey)
                .border(
                    width = 1.dp,
                    color = if (pressed) PadLime else Color.White.copy(alpha = 0.10f),
                    shape = CircleShape
                )
                .clickable(interactionSource = source, indication = null, onClick = onClick),
            contentAlignment = Alignment.Center
        ) { content() }
    }
}