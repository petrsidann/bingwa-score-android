package com.bingwascore.app.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.data.statistics.BalanceRepository
import com.bingwascore.app.domain.enums.AppState
import com.bingwascore.app.domain.enums.ProcessingMode
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.domain.stats.EngineHealth
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.Calendar
import javax.inject.Inject

data class HomeState(
    val greeting: String = "",
    val successful: Int = 0,
    val failed: Int = 0,
    val airtimeUsedToday: Double = 0.0,
    val weeklyCommission: Double = 0.0,
    val healthIssues: List<String> = emptyList(),
    val recent: List<Transaction> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val settingsRepository: SettingsRepository,
    private val balanceRepository: BalanceRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val balance = balanceRepository.balance
    val balanceLoading = balanceRepository.loading

    private val _advanced = MutableStateFlow(settingsRepository.getProcessingMode() == ProcessingMode.ADVANCED)
    val advanced: StateFlow<Boolean> = _advanced.asStateFlow()

    val state: StateFlow<HomeState> = transactionRepository.getAllTransactions()
        .map { txs ->
            val startToday = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }.timeInMillis
            val weekAgo = System.currentTimeMillis() - 7 * 86_400_000L
            HomeState(
                greeting = when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
                    in 5..11 -> "Good Morning"
                    in 12..16 -> "Good Afternoon"
                    else -> "Good Evening"
                },
                successful = txs.count { it.status == TransactionStatus.SUCCESSFUL },
                failed = txs.count { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED },
                airtimeUsedToday = txs.filter { it.status == TransactionStatus.SUCCESSFUL && it.createdAt >= startToday }.sumOf { it.amount },
                weeklyCommission = txs.filter { it.status == TransactionStatus.SUCCESSFUL && it.createdAt >= weekAgo }.sumOf { it.commission },
                healthIssues = EngineHealth.checks(context).filter { !it.ok }.map { it.advice },
                recent = txs.take(8)
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())

    fun refreshBalance() = balanceRepository.refresh()

    fun toggleAdvanced() {
        val next = !_advanced.value
        _advanced.value = next
        settingsRepository.setProcessingMode(if (next) ProcessingMode.ADVANCED else ProcessingMode.EXPRESS)
    }

    fun openSystemSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
