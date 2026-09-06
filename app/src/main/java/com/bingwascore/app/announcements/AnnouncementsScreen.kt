package com.bingwascore.app.announcements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Campaign
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter

data class Announcement(
    val id: String,
    val date: String,
    val title: String,
    val body: String,
    val unread: Boolean
)

@Composable
fun AnnouncementsScreen(viewModel: AnnouncementsViewModel = hiltViewModel()) {
    val announcements by viewModel.announcements.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().screenEnter().background(NightBlack).verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text("Announcements", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Tips & updates for agents", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        }
        announcements.forEachIndexed { index, a ->
            AnnouncementCard(a, enterDelayMillis = minOf(index, 6) * 35,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(bottom = 12.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun AnnouncementCard(a: Announcement, enterDelayMillis: Int, modifier: Modifier = Modifier) {
    GlassCard(modifier = modifier, enterDelayMillis = enterDelayMillis) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Rounded.Campaign, contentDescription = null, tint = Orange500, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(a.date, color = White.copy(alpha = 0.45f), fontSize = 11.sp, modifier = Modifier.weight(1f))
            if (a.unread) {
                Spacer(modifier = Modifier.width(6.dp))
                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(EmeraldGreen))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(a.title, color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(a.body, color = White.copy(alpha = 0.6f), fontSize = 13.sp)
    }
}
