package com.bingwascore.app.score

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.LocalFireDepartment
import androidx.compose.material.icons.rounded.Lock
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.domain.score.Achievement
import com.bingwascore.app.domain.score.ScoreState
import com.bingwascore.app.ui.components.AnimatedRing
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.Bronze
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Gold
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Platinum
import com.bingwascore.app.ui.theme.Silver
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter
import kotlinx.coroutines.delay

@Composable
fun ScoreScreen(viewModel: ScoreViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val achievements by viewModel.achievements.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().screenEnter().background(NightBlack).verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text("My Score", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Your agent growth & rewards", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        }
        GlassCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center) {
                    AnimatedRing(progress = state.progress, size = 160.dp)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CountUpScore(target = state.score)
                        Text("points", color = White.copy(alpha = 0.5f), fontSize = 11.sp)
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                LevelBadge(levelName = state.levelName)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    if (state.nextLevelAt == state.score) "Max level!" else "${state.nextLevelAt - state.score} pts to next level",
                    color = White.copy(alpha = 0.5f), fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                StreakRow(days = state.streakDays)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatChip("Success Rate", "${(state.successRate * 100).toInt()}%", EmeraldGreen, Modifier.weight(1f))
            StatChip("Commission", "Ksh ${state.totalCommission.toInt()}", TealBlue, Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatChip("Transactions", "${state.customersServed}", Orange500, Modifier.weight(1f))
            StatChip("Customers", "${state.customersServed}", Platinum, Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Achievements", color = White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(8.dp))
        achievements.forEachIndexed { index, a ->
            AchievementCard(a, enterDelayMillis = minOf(index, 6) * 35,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(bottom = 12.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun CountUpScore(target: Int) {
    var current by remember(target) { mutableStateOf(0) }
    val animated by animateFloatAsState(targetValue = current.toFloat(), animationSpec = tween(700), label = "scoreCount")
    LaunchedEffect(target) { current = target }
    Text(animated.toInt().toString(), color = White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
}

@Composable
private fun LevelBadge(levelName: String) {
    val color = when (levelName) {
        "Bronze" -> Bronze
        "Silver" -> Silver
        "Gold" -> Gold
        "Platinum" -> Platinum
        else -> EmeraldGreen
    }
    Box(
        modifier = Modifier.clip(RoundedCornerShape(20.dp))
            .background(Brush.horizontalGradient(listOf(color, color.copy(alpha = 0.7f))))
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(levelName, color = NightBlack, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun StreakRow(days: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Rounded.LocalFireDepartment, contentDescription = null, tint = Orange500, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("$days-day streak", color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun StatChip(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    GlassCard(modifier = modifier) {
        Text(label, color = White.copy(alpha = 0.55f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Text(value, color = color, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun AchievementCard(a: Achievement, enterDelayMillis: Int, modifier: Modifier = Modifier) {
    GlassCard(modifier = modifier, enterDelayMillis = enterDelayMillis) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(40.dp).clip(CircleShape)
                    .background(if (a.unlocked) EmeraldGreen.copy(alpha = 0.15f) else Color(0x0DFFFFFF)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    if (a.unlocked) Icons.Rounded.EmojiEvents else Icons.Rounded.Lock,
                    contentDescription = null,
                    tint = if (a.unlocked) EmeraldGreen else White.copy(alpha = 0.35f),
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(a.title, color = if (a.unlocked) White else White.copy(alpha = 0.5f),
                    fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(a.description, color = White.copy(alpha = 0.45f), fontSize = 11.sp)
            }
            if (a.unlocked) {
                Text("UNLOCKED", color = EmeraldGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
