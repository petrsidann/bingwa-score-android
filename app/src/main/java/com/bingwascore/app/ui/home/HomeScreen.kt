package com.bingwascore.app.ui.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WbSunny
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
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.TealBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToAccount: () -> Unit,
    onNavigateToOrders: () -> Unit,
    onNavigateToCheckout: (String) -> Unit,
    onLogout: () -> Unit,
    onOpenDrawer: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val onSurface = MaterialTheme.colorScheme.onSurface
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(state.greeting, color = onSurfaceVariant, fontSize = 13.sp)
                        Text("Dashboard", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = onSurface)
                    }
                },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(
                            if (isDarkTheme) Icons.Default.WbSunny else Icons.Default.DarkMode,
                            contentDescription = "Toggle theme",
                            tint = onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Health Warning
            if (state.healthIssues.isNotEmpty()) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(ErrorRed.copy(alpha = 0.12f)).padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Warning, null, tint = ErrorRed, modifier = Modifier.size(20.dp))
                            Spacer(Modifier.width(10.dp))
                            Text(state.healthIssues.first().advice, color = onSurface, fontSize = 12.sp, modifier = Modifier.weight(1f))
                            IconButton(onClick = { viewModel.openSystemSettings() }) {
                                Text("Fix", color = ErrorRed, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }

            // 4 Cards Grid
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        StatCard("${state.successfulCount}", "Completed", EmeraldGreen, Modifier.weight(1f))
                        StatCard("${state.failedCount}", "Failed", ErrorRed, Modifier.weight(1f))
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        StatCard("Ksh %.0f".format(state.airtimeUsedToday), "Airtime Used", TealBlue, Modifier.weight(1f))
                        StatCard("Ksh %.2f".format(state.totalCommission), "Commission", Orange500, Modifier.weight(1f))
                    }
                }
            }

            // Airtime Balance Card with Refresh
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Airtime Balance", color = onSurfaceVariant, fontSize = 13.sp)
                            Spacer(Modifier.height(4.dp))
                            Text(state.airtimeBalance, color = onSurface, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        }
                        IconButton(onClick = { viewModel.refreshAirtimeBalance() }) {
                            Icon(Icons.Default.Refresh, null, tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }

            // Recent Activity Header
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Recent Activity", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text("View All", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                }
            }

            // Recent Transactions List
            if (state.recent.isEmpty()) {
                item {
                    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 48.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("No transactions yet", color = onSurface, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    }
                }
            } else {
                items(state.recent) { tx ->
                    val (icon, tint) = when (tx.status) {
                        TransactionStatus.SUCCESSFUL -> Icons.Default.CheckCircle to EmeraldGreen
                        TransactionStatus.FAILED, TransactionStatus.FAILED_ALREADY_RECOMMENDED -> Icons.Default.Error to ErrorRed
                        else -> Icons.Default.Schedule to TealBlue
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(icon, null, tint = tint, modifier = Modifier.size(22.dp))
                        Spacer(Modifier.width(14.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(tx.customerName ?: tx.phoneNumber, color = onSurface, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                            Text(tx.offerName, color = onSurfaceVariant, fontSize = 12.sp)
                        }
                        Text("Ksh %.0f".format(tx.amount), color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }
                }
            }
            item { Spacer(Modifier.height(80.dp)) }
        }
    }
}

@Composable
private fun StatCard(value: String, label: String, tint: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier.height(90.dp).clip(RoundedCornerShape(18.dp)).background(tint.copy(alpha = 0.14f)).padding(14.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = tint, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(Modifier.height(4.dp))
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
        }
    }
}
