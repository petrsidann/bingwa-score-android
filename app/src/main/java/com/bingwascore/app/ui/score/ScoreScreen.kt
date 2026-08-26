package com.bingwascore.app.ui.score

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.stats.DayPoint
import com.bingwascore.app.domain.stats.StatisticsEngine
import com.bingwascore.app.domain.stats.AgentScore
import com.bingwascore.app.ui.components.HeatmapGrid
import com.bingwascore.app.ui.components.ScoreRing
import com.bingwascore.app.ui.components.WeeklyBars
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.TealBlue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class ScoreState(
    val score: AgentScore = AgentScore(0, "Rookie", 0, 0.0, 0.0, 0.0, 0, 0),
    val weekCommission: List<DayPoint> = emptyList(),
    val weekAirtime: List<DayPoint> = emptyList(),
    val heatmap: List<List<Int>> = emptyList(),
    val bestWindow: String = "-"
)

@HiltViewModel
class ScoreViewModel @Inject constructor(
    transactionRepository: TransactionRepository
) : ViewModel() {

    val state: StateFlow<ScoreState> = transactionRepository.getAllTransactions()
        .map { txs ->
            ScoreState(
                score = StatisticsEngine.compute(txs),
                weekCommission = StatisticsEngine.last7DaysCommission(txs),
                weekAirtime = StatisticsEngine.last7DaysAirtime(txs),
                heatmap = StatisticsEngine.heatmap(txs),
                bestWindow = StatisticsEngine.bestSellingWindow(txs)
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ScoreState())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(onNavigateBack: () -> Unit) {
    val vm: ScoreViewModel = hiltViewModel()
    val state by vm.state.collectAsState()
    val onSurface = MaterialTheme.colorScheme.onSurface
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Bingwa Score", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ScoreRing(state.score.score, state.score.level, size = 160.dp)
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Next level at ${StatisticsEngine.nextLevelTarget(state.score.score)}",
                        color = onSurfaceVariant,
                        fontSize = 12.sp
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                StatBox("${state.score.successfulCount}", "Successful", EmeraldGreen, Modifier.weight(1f))
                StatBox("${state.score.failedCount}", "Failed", MaterialTheme.colorScheme.error, Modifier.weight(1f))
                StatBox("%.0f%%".format(state.score.successRate), "Rate", TealBlue, Modifier.weight(1f))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                StatBox("Ksh %.0f".format(state.score.totalCommission), "Commission", EmeraldGreen, Modifier.weight(1f))
                StatBox("Ksh %.0f".format(state.score.totalAirtimeUsed), "Airtime sold", TealBlue, Modifier.weight(1f))
            }

            ChartCard("Commission - last 7 days") {
                WeeklyBars(state.weekCommission, EmeraldGreen)
            }

            ChartCard("Airtime sold - last 7 days") {
                WeeklyBars(state.weekAirtime, TealBlue)
            }

            ChartCard("Activity heatmap (7 days x 4 windows)") {
                HeatmapGrid(state.heatmap)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                Column {
                    Text("Best selling window", color = onSurfaceVariant, fontSize = 13.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(state.bestWindow, color = onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
private fun StatBox(value: String, label: String, tint: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(tint.copy(alpha = 0.14f))
            .padding(14.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = tint, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
        }
    }
}

@Composable
private fun ChartCard(title: String, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Column {
            Text(title, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 13.sp)
            Spacer(Modifier.height(12.dp))
            content()
        }
    }
}
