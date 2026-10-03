package com.bingwascore.app.ui.engagebot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.engagebot.BotLog
import com.bingwascore.app.engagebot.BotLogKind
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.TextWhite
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Severity color for a bot activity line — shared across bot screens. */
fun botLogColor(kind: BotLogKind): Color = when (kind) {
    BotLogKind.ENGAGE -> PendGrey
    BotLogKind.SUCCESS -> TickGreen
    BotLogKind.INVALID -> PendGrey
    BotLogKind.ERROR -> FailRed
    BotLogKind.INFO -> TextWhite.copy(alpha = 0.5f)
}

/**
 * One line of bot activity — colored kind dot, message and timestamp.
 * Shared by the Botted Replies and Engage Bot screens.
 */
@Composable
fun BotLogRow(log: BotLog, modifier: Modifier = Modifier) {
    val timeFormat = remember { SimpleDateFormat("HH:mm:ss", Locale.getDefault()) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Bubble)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(botLogColor(log.kind))
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(log.message, color = TextWhite.copy(alpha = 0.85f), fontSize = 12.sp)
            Text(
                timeFormat.format(Date(log.timestamp)),
                color = TextWhite.copy(alpha = 0.4f),
                fontSize = 10.sp
            )
        }
    }
}
