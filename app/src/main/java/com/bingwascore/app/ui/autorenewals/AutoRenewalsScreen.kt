package com.bingwascore.app.ui.autorenewals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.White

private data class RenewalRow(
    val id: String,
    val offerName: String,
    val phone: String,
    val price: Int,
    val renewAt: Long,
    val isActive: Boolean
)

/** Auto-renewal queue: bundles that will be re-dialled when their time is up. */
@Composable
fun AutoRenewalsScreen() {
    val now = remember { System.currentTimeMillis() }
    val renewals = remember {
        listOf(
            RenewalRow("r1", "1500SMS, 30Days", "0712345678", 50, now + 45L * 60_000, true),
            RenewalRow("r2", "250MBs, 24hrs", "0712000001", 20, now + 2L * 60 * 60_000, true),
            RenewalRow("r3", "750MBs+50SMS", "0733444555", 55, now + 26L * 60 * 60_000, false),
            RenewalRow("r4", "400MBs, 7Days", "0722333444", 49, now + 3L * 24 * 60 * 60_000, true),
            RenewalRow("r5", "1GB, 30Days", "0745566778", 300, now + 12L * 24 * 60 * 60_000, true)
        )
    }
    var activeStates by remember {
        mutableStateOf(renewals.associate { it.id to it.isActive })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Auto Renewals", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${activeStates.count { it.value }} active renewal(s)",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp),
        ) {
            items(renewals, key = { it.id }) { renewal ->
                val isActive = activeStates[renewal.id] ?: renewal.isActive
                RenewalCard(
                    renewal = renewal,
                    isActive = isActive,
                    now = now,
                    onToggle = {
                        activeStates = activeStates + (renewal.id to !isActive)
                    }
                )
            }
        }
    }
}

@Composable
private fun RenewalCard(renewal: RenewalRow, isActive: Boolean, now: Long, onToggle: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    renewal.offerName,
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    renewal.phone,
                    color = White.copy(alpha = 0.5f),
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                CountdownChip(
                    label = if (isActive) {
                        "Renews in ${formatCountdown(renewal.renewAt - now)}"
                    } else {
                        "Renewal paused"
                    },
                    urgent = isActive && renewal.renewAt - now < 60L * 60_000
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                "Ksh ${renewal.price}",
                color = White.copy(alpha = 0.7f),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = isActive,
                onCheckedChange = { onToggle() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = NightBlack,
                    checkedTrackColor = EmeraldGreen,
                    checkedBorderColor = EmeraldGreen,
                    uncheckedThumbColor = White.copy(alpha = 0.7f),
                    uncheckedTrackColor = Color(0x22FFFFFF),
                    uncheckedBorderColor = Color(0x33FFFFFF)
                )
            )
        }
    }
}

@Composable
private fun CountdownChip(label: String, urgent: Boolean) {
    val color = when {
        urgent -> ErrorRed
        label.startsWith("Renews") -> Orange500
        else -> White.copy(alpha = 0.5f)
    }
    Text(
        label,
        color = color,
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}

private fun formatCountdown(millis: Long): String {
    val totalSeconds = (millis / 1000).coerceAtLeast(0)
    val days = totalSeconds / 86_400
    val hours = (totalSeconds % 86_400) / 3_600
    val minutes = (totalSeconds % 3_600) / 60
    return when {
        days > 0 -> "${days}d ${hours}h"
        hours > 0 -> "${hours}h ${minutes}m"
        minutes > 0 -> "${minutes}m"
        else -> "any moment"
    }
}

