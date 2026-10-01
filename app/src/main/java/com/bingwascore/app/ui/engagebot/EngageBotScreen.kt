package com.bingwascore.app.ui.engagebot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.engagebot.BotLogKind
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.theme.BingwaOrange
import com.bingwascore.app.ui.theme.GlassBorderStrong
import com.bingwascore.app.ui.theme.GlassFillStrong
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.White

/**
 * Engage Bot: master switch, session stats and live bot activity. The bot
 * texts each customer after a sale to ask which number the bundle is for.
 */
@Composable
fun EngageBotScreen(viewModel: EngageBotViewModel = hiltViewModel()) {
    val isEnabled by viewModel.isEnabled.collectAsStateWithLifecycle()
    val logs by viewModel.logs.collectAsStateWithLifecycle()

    val engagedCount = logs.count { it.kind == BotLogKind.ENGAGE }
    val completedCount = logs.count { it.kind == BotLogKind.SUCCESS }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Autopilot", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    if (isEnabled) "Bot is live — asking customers who the bundle is for"
                    else "Bot is paused — flip the switch to start engaging",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            Icon(
                Icons.Rounded.Bolt,
                contentDescription = null,
                tint = if (isEnabled) BingwaOrange else White.copy(alpha = 0.4f),
                modifier = Modifier.size(30.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                GlassCard(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                "Engage Bot",
                                color = White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                "After each sale the bot texts the customer to ask which " +
                                    "number the bundle is for, then completes the purchase.",
                                color = White.copy(alpha = 0.5f),
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        HapticSwitch(
                            checked = isEnabled,
                            onCheckedChange = { viewModel.setEnabled(it) },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = NightBlack,
                                checkedTrackColor = BingwaOrange,
                                checkedBorderColor = BingwaOrange,
                                uncheckedThumbColor = White.copy(alpha = 0.7f),
                                uncheckedTrackColor = GlassFillStrong,
                                uncheckedBorderColor = GlassBorderStrong
                            )
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard("Engaged", engagedCount.toString(), Modifier.weight(1f))
                    StatCard("Completed", completedCount.toString(), Modifier.weight(1f))
                }
            }

            if (logs.isEmpty()) {
                item {
                    EmptyState(
                        icon = Icons.Rounded.Bolt,
                        title = "No bot activity yet",
                        message = "Every engage message and customer reply will be logged here.",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                    )
                }
            } else {
                item {
                    Text(
                        "Live Activity",
                        color = White.copy(alpha = 0.5f),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
                    )
                }
                items(logs, key = { it.id }) { log ->
                    BotLogRow(modifier = Modifier.padding(horizontal = 20.dp), log = log)
                }
            }
        }
    }
}

@Composable
private fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    GlassCard(modifier = modifier) {
        Text(value, color = BingwaOrange, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, color = White.copy(alpha = 0.55f), fontSize = 11.sp)
    }
}