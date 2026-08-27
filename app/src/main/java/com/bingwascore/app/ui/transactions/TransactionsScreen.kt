package com.bingwascore.app.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val allTransactions by viewModel.transactions.collectAsState()
    val currentFilter by viewModel.filter.collectAsState()
    
    // Apply filter logic in UI for simplicity or use VM method
    val displayedTransactions = when (currentFilter) {
        "Successful" -> allTransactions.filter { it.status == TransactionStatus.SUCCESSFUL }
        "Failed" -> allTransactions.filter { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED }
        "Pending" -> allTransactions.filter { it.status == TransactionStatus.PENDING || it.status == TransactionStatus.PROCESSING }
        else -> allTransactions
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Transactions") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Filters
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("All", "Successful", "Failed", "Pending").forEach { filter ->
                    FilterChip(
                        selected = currentFilter == filter,
                        onClick = { viewModel.setFilter(filter) },
                        label = { Text(filter) }
                    )
                }
            }

            LazyColumn {
                items(displayedTransactions) { transaction ->
                    TransactionItem(transaction, onDelete = { viewModel.deleteTransaction(transaction.id) })
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: com.bingwascore.app.domain.model.Transaction, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(transaction.offerName, style = MaterialTheme.typography.titleMedium)
                Text(transaction.phoneNumber, style = MaterialTheme.typography.bodyMedium)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "KES ${transaction.amount.toInt()}", 
                        color = if (transaction.status == TransactionStatus.SUCCESSFUL) EmeraldGreen else ErrorRed,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                    Text(" • ${transaction.status.name}", style = MaterialTheme.typography.bodySmall)
                }
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = ErrorRed)
            }
        }
    }
}
