package com.bingwascore.app.ui.subscriptions

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

private data class SubscriptionRow(
    val id: String,
    val offerName: String,
    val phone: String,
    val price: Int,
    val expiresAt: Long,
    val autoRenew: Boolean
)

/** Active customer subscriptions with expiry countdowns (demo data). */
@Composable
fun SubscriptionsScreen() {
    val now = remember { System.currentTimeMillis() }
    val subscriptions = remember {
        listOf(
            SubscriptionRow("s1", "1GB, 30Days", "0712000001", 300, now + 5L * 24 * 60 * 60_000, true),
            SubscriptionRow("s2", "400MBs, 7Days", "0722333444", 49, now + 2L * 24 * 60 * 60_000, true),
            SubscriptionRow("s3", "250MBs, 24hrs", "0712000001", 20, now + 9L * 60 * 60_000, false),
            SubscriptionRow("s4", "750MBs+50SMS", "0733444555", 55, now + 55L * 60_000, true),
            SubscriptionRow("s5", "All-net 100SMS", "0745566778", 30, now + 21L * 24 * 60 * 60_000, false)
        )
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
            Text("Subscriptions", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${subscriptions.size} subscription(s)",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp),
        ) {
            items(subscriptions, key = { it.id }) { subscription ->
                SubscriptionCard(subscription = subscription, now = now)
            }
        }
    }
}

@Composable
private fun SubscriptionCard(subscription: SubscriptionRow, now: Long) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    subscription.offerName,
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    subscription.phone,
                    color = White.copy(alpha = 0.5f),
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CountdownChip(label = "Expires in ${formatCountdown(subscription.expiresAt - now)}")
                    Spacer(modifier = Modifier.width(8.dp))
                    AutoRenewChip(autoRenew = subscription.autoRenew)
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                "Ksh ${subscription.price}",
                color = White.copy(alpha = 0.7f),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun CountdownChip(label: String) {
    Text(
        label,
        color = Orange500,
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}

@Composable
private fun AutoRenewChip(autoRenew: Boolean) {
    Text(
        if (autoRenew) "Auto-renew ON" else "Auto-renew OFF",
        color = if (autoRenew) EmeraldGreen else ErrorRed,
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 8.dp, vertical = 4.dp)
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
