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
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DarkCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.TextMuted
import com.bingwascore.app.ui.theme.TextPrimary
import com.bingwascore.app.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToSettings: () -> Unit,
    onNavigateToAccount: () -> Unit,
    onNavigateToOrders: () -> Unit,
    onNavigateToCheckout: (String) -> Unit,
    onLogout: () -> Unit,
    onOpenDrawer: () -> Unit // New parameter for drawer
) {
    val state by viewModel.state.collectAsState()
    var balanceVisible by remember { mutableStateOf(true) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Good Evening,", color = TextSecondary, fontSize = 14.sp)
                        Text("Vibez", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(
                            imageVector = Icons.Default.Schedule, // Placeholder for menu icon
                            contentDescription = "Menu",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Stats Cards Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard("Successful", state.stats.successfulCount.toString(), EmeraldGreen, Modifier.weight(1f))
                    StatCard("Failed", state.stats.failedCount.toString(), ErrorRed, Modifier.weight(1f))
                    StatCard("Tokens", state.stats.tokensRemaining, TealBlue, Modifier.weight(1f))
                }
            }

            // 2. Balance Card
            item {
                BalanceCard(
                    airtimeUsed = state.stats.airtimeUsedToday,
                    airtimeBalance = state.stats.airtimeBalance,
                    isVisible = balanceVisible,
                    onToggleVisibility = { balanceVisible = !balanceVisible }
                )
            }

            // 3. Commission Chart Placeholder
            item {
                CommissionChartCard(weeklyCommission = state.stats.weeklyCommission)
            }

            // 4. Recent Transactions Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Recent Transactions", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("All →", color = EmeraldGreen, fontWeight = FontWeight.SemiBold)
                }
            }

            // 5. Transaction List
            items(state.recentTransactions) { transaction ->
                TransactionRow(transaction = transaction)
            }
            
            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }
}

@Composable
private fun StatCard(title: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color.copy(alpha = 0.2f)) // Tinted background
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(Modifier.height(4.dp))
            Text(title, color = TextSecondary, fontSize = 12.sp)
        }
    }
}

@Composable
private fun BalanceCard(
    airtimeUsed: String,
    airtimeBalance: String,
    isVisible: Boolean,
    onToggleVisibility: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(DarkCard)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Airtime Used Today", color = TextSecondary, fontSize = 12.sp)
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (isVisible) airtimeUsed else "Ksh ****", color = TextPrimary, fontWeight = FontWeight.SemiBold)
                    IconButton(onClick = onToggleVisibility, modifier = Modifier.size(24.dp)) {
                        Icon(
                            if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Balance",
                            tint = TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            Spacer(Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("Airtime Balance", color = TextSecondary, fontSize = 12.sp)
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (isVisible) airtimeBalance else "Ksh ****", color = TextPrimary, fontWeight = FontWeight.SemiBold)
                    IconButton(onClick = onToggleVisibility, modifier = Modifier.size(24.dp)) {
                        Icon(
                            if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Balance",
                            tint = TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CommissionChartCard(weeklyCommission: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(DarkCard)
            .padding(16.dp)
    ) {
        Column {
            Text("This week's commission ($weeklyCommission)", color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            Spacer(Modifier.height(16.dp))
            // Visual placeholder for chart
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Transparent)
            ) {
                // Draw a simple dashed line or grid here later
                Text("Chart Visualization", color = TextMuted, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
private fun TransactionRow(transaction: TransactionItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Status Icon
        Icon(
            imageVector = if (transaction.status == "SUCCESS") Icons.Default.CheckCircle else Icons.Default.Schedule,
            contentDescription = null,
            tint = if (transaction.status == "SUCCESS") EmeraldGreen else TextSecondary,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(Modifier.width(12.dp))
        
        // Details
        Column(modifier = Modifier.weight(1f)) {
            Text(transaction.customerName, color = TextPrimary, fontWeight = FontWeight.Medium, fontSize = 14.sp)
            Text(transaction.bundleName, color = EmeraldGreen, fontSize = 12.sp)
        }
        
        // Time & Amount
        Column(horizontalAlignment = Alignment.End) {
            Text(transaction.timeAgo, color = TextSecondary, fontSize = 12.sp)
            Text(transaction.amount, color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
    }
}
