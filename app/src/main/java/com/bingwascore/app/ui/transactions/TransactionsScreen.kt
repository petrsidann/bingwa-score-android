package com.bingwascore.app.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.TealBlue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    transactionRepository: TransactionRepository,
    private val transactionDao: TransactionDao,
    private val pipeline: TransactionPipeline
) : ViewModel() {

    private val filter = androidx.compose.runtime.MutableStateFlow("all")

    val transactions: StateFlow<List<Transaction>> =
        combine(transactionRepository.getAllTransactions(), filter) { list, f -> applyFilter(list, f) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun setFilter(f: String) { filter.value = f }

    fun delete(id: String) = viewModelScope.launch { transactionDao.deleteTransactionById(id) }
    fun retry(id: String) = viewModelScope.launch { pipeline.retry(id) }
    fun markComplete(id: String) = viewModelScope.launch { pipeline.markComplete(id) }

    fun schedule(id: String, millis: Long) = viewModelScope.launch {
        val tx = transactionDao.getTransactionById(id) ?: return@launch
        transactionDao.updateTransaction(
            tx.copy(status = TransactionStatus.SCHEDULED, scheduledAt = millis)
        )
    }

    private fun applyFilter(list: List<Transaction>, f: String): List<Transaction> {
        val now = System.currentTimeMillis()
        val startToday = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        return when (f) {
            "today" -> list.filter { it.createdAt >= startToday }
            "yesterday" -> list.filter { it.createdAt >= startToday - 86_400_000 && it.createdAt < startToday }
            "7d" -> list.filter { it.createdAt >= now - 7 * 86_400_000L }
            "30d" -> list.filter { it.createdAt >= now - 30 * 86_400_000L }
            "successful" -> list.filter { it.status == TransactionStatus.SUCCESSFUL }
            "failed" -> list.filter { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED }
            "scheduled" -> list.filter { it.status == TransactionStatus.SCHEDULED }
            else -> list
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(onNavigateBack: () -> Unit) {
    val vm: TransactionsViewModel = hiltViewModel()
    val transactions by vm.transactions.collectAsState()
    var selected by remember { mutableStateOf<Transaction?>(null) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Transactions", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            LazyRow(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    listOf(
                        "all" to "All", "today" to "Today", "yesterday" to "Yesterday",
                        "7d" to "Last 7 days", "30d" to "Last 30 days",
                        "successful" to "Successful", "failed" to "Failed", "scheduled" to "Scheduled"
                    )
                ) { (id, label) ->
                    FilterChipLocal(label, id, vm)
                }
            }

            LazyColumn(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(transactions) { tx ->
                    val (icon, tint) = when (tx.status) {
                        TransactionStatus.SUCCESSFUL -> Icons.Default.CheckCircle to EmeraldGreen
                        TransactionStatus.FAILED, TransactionStatus.FAILED_ALREADY_RECOMMENDED -> Icons.Default.Error to ErrorRed
                        else -> Icons.Default.Schedule to TealBlue
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { selected = tx }
                            .padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(icon, null, tint = tint, modifier = androidx.compose.ui.Modifier.size(22.dp))
                            Spacer(Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(tx.customerName ?: tx.phoneNumber, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                                Text("${tx.offerName} - ${tx.status.name}", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
                            }
                            Text("Ksh %.0f".format(tx.amount), color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                    }
                }
            }
        }

        selected?.let { tx ->
            AlertDialog(
                onDismissRequest = { selected = null },
                title = { Text(tx.customerName ?: tx.phoneNumber) },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("Offer: ${tx.offerName}", fontSize = 13.sp)
                        Text("Status: ${tx.status.name}", fontSize = 13.sp)
                        Text("Amount: Ksh %.0f".format(tx.amount), fontSize = 13.sp)
                        Text("USSD: ${tx.ussdCode}", fontSize = 12.sp)
                    }
                },
                confirmButton = {
                    Row {
                        if (tx.status == TransactionStatus.FAILED) {
                            TextButton(onClick = { vm.retry(tx.id); selected = null }) { Text("Retry") }
                        }
                        if (tx.status != TransactionStatus.SUCCESSFUL) {
                            TextButton(onClick = { vm.markComplete(tx.id); selected = null }) { Text("Complete") }
                        }
                        if (tx.status != TransactionStatus.SUCCESSFUL && tx.status != TransactionStatus.SCHEDULED) {
                            TextButton(onClick = {
                                val tomorrow = Calendar.getInstance().apply {
                                    add(Calendar.DAY_OF_YEAR, 1)
                                    set(Calendar.HOUR_OF_DAY, 1); set(Calendar.MINUTE, 0)
                                }.timeInMillis
                                vm.schedule(tx.id, tomorrow)
                                selected = null
                            }) { Text("Schedule") }
                        }
                        TextButton(onClick = { vm.delete(tx.id); selected = null }) { Text("Delete", color = ErrorRed) }
                    }
                },
                dismissButton = { TextButton(onClick = { selected = null }) { Text("Close") } }
            )
        }
    }
}

@Composable
private fun androidx.compose.foundation.lazy.LazyRowScope.FilterChipLocal(
    label: String,
    id: String,
    vm: TransactionsViewModel
) {
    // rendered by caller below
}

@Composable
private fun FilterChipLocal(label: String, id: String, vm: TransactionsViewModel) {
    val selected by vm.transactions.collectAsState()
    // simple chip; selection state kept in VM filter via setFilter
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable { vm.setFilter(id) }
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
    }
}
