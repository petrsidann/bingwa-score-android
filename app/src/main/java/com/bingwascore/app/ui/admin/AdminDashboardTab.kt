package com.bingwascore.app.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.Sp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.data.remote.dto.PeriodStats
import com.bingwascore.app.ui.components.Skeleton
import com.bingwascore.app.ui.theme.Emerald500
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Pink500
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.Sky500

@Composable
fun AdminDashboardTab(state: AdminState) {
    if (state.isLoading) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(4) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(20.dp)
                ) {
                    Column {
                        Skeleton(height = 12.dp, modifier = Modifier.width(80.dp))
                        Spacer(Modifier.height(12.dp))
                        Skeleton(height = 32.dp, modifier = Modifier.width(160.dp))
                        Spacer(Modifier.height(12.dp))
                        Skeleton(height = 14.dp, modifier = Modifier.width(120.dp))
                    }
                }
            }
        }
        return
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        StatCard("Today", state.dashboard.today, listOf(Orange500, Pink500))
        StatCard("This week", state.dashboard.week, listOf(Purple500, Pink500))
        StatCard("This month", state.dashboard.month, listOf(Sky500, Purple500))
        StatCard("All time", state.dashboard.allTime, listOf(Emerald500, Sky500))
    }
}

@Composable
private fun StatCard(label: String, stats: PeriodStats, colors: List<androidx.compose.ui.graphics.Color>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp)
    ) {
        Column {
            Text(
                label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                letterSpacing = TextUnit(1.5f, Sp)
            )
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    "KES ",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    stats.revenue.toInt().toString(),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "${stats.orders} orders",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    "+${stats.margin.toInt()} margin",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = Emerald500
                )
            }
        }
    }
}
