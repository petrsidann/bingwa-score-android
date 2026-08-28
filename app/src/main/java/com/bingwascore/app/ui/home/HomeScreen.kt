package com.bingwascore.app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.TealBlue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onOpenDrawer: () -> Unit,
    onNavigateToTransactions: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val balance by viewModel.balance.collectAsState()
    val balanceLoading by viewModel.balanceLoading.collectAsState()
    val advanced by viewModel.advanced.collectAsState()
    var showBalance by remember { mutableStateOf(true) }
    val onSurface = MaterialTheme.colorScheme.onSurface
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("${state.greeting},", color = onSurfaceVariant, fontSize = 13.sp)
                        Text("Dashboard", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                },
                navigationIcon = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, null, tint = onSurface) } },
                actions = { IconButton(onClick = onToggleTheme) { Icon(if (isDarkTheme) Icons.Default.WbSunny else Icons.Default.DarkMode, null, tint = onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                    Text("Advanced Mode", color = onSurface, fontSize = 13.sp)
                    Spacer(Modifier.width(8.dp))
                    Switch(checked = advanced, onCheckedChange = { viewModel.toggleAdvanced() }, colors = SwitchDefaults.colors(checkedTrackColor = EmeraldGreen))
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    StatCard("${state.successful}", "Completed", EmeraldGreen, Modifier.weight(1f))
                    StatCard("${state.failed}", "Failed", ErrorRed, Modifier.weight(1f))
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    StatCard("Ksh %.0f".format(state.airtimeUsedToday), "Airtime Used Today", TealBlue, Modifier.weight(1f))
                    StatCard("Ksh %.2f".format(state.weeklyCommission), "Weekly Commission", Orange500, Modifier.weight(1f))
                }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Airtime Balance", color = onSurfaceVariant, fontSize = 13.sp)
                            Text(
                                if (showBalance) (balance?.let { "Ksh $it" } ?: "Ksh --") else "Ksh ••••",
                                color = onSurface, fontWeight = FontWeight.Bold, fontSize = 18.sp
                            )
                        }
                        IconButton(onClick = { showBalance = !showBalance }) {
                            Icon(if (showBalance) Icons.Default.Visibility else Icons.Default.VisibilityOff, null, tint = onSurfaceVariant, modifier = Modifier.size(20.dp))
                        }
                        IconButton(onClick = { viewModel.refreshBalance() }) {
                            if (balanceLoading) CircularProgressIndicator(modifier = Modifier.size(22.dp), color = EmeraldGreen, strokeWidth = 2.dp)
                            else Icon(Icons.Default.Refresh, null, tint = EmeraldGreen, modifier = Modifier.size(22.dp))
                        }
                    }
                }
            }
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Recent Activity", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text("View All", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, modifier = Modifier.clickable { onNavigateToTransactions() })
                }
            }
            items(state.recent) { tx ->
                val (icon, tint) = when (tx.status) {
                    TransactionStatus.SUCCESSFUL -> Icons.Default.CheckCircle to EmeraldGreen
                    TransactionStatus.FAILED, TransactionStatus.FAILED_ALREADY_RECOMMENDED -> Icons.Default.Error to ErrorRed
                    else -> Icons.Default.Refresh to TealBlue
                }
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(icon, null, tint = tint, modifier = Modifier.size(22.dp))
                    Spacer(Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(tx.customerName ?: tx.phoneNumber, color = onSurface, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                        Text(tx.offerName, color = onSurfaceVariant, fontSize = 12.sp)
                    }
                    Text("Ksh %.0f".format(tx.amount), color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
            item { Spacer(Modifier.height(80.dp)) }
        }
    }
}

@Composable
private fun StatCard(value: String, label: String, tint: Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier.height(90.dp).clip(RoundedCornerShape(18.dp)).background(tint), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(label, color = Color.White.copy(alpha = 0.85f), fontSize = 11.sp)
        }
    }
}
