package com.bingwascore.app.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.data.statistics.BalanceRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.enums.ProcessingMode
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.domain.stats.EngineHealth
import com.bingwascore.app.domain.stats.HealthCheck
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltAndroidApp
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
    val successful: Int = 0,
    val failed: Int = 0,
    val airtimeUsedToday: Double = 0.0,
    val weekCommission: Double = 0.0,
    val recent: List<Transaction> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val balanceRepository: BalanceRepository,
    private val settingsRepository: SettingsRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _advanced = MutableStateFlow(settingsRepository.getProcessingMode() == ProcessingMode.ADVANCED)
    val advanced: StateFlow<Boolean> = _advanced.asStateFlow()

    val balance = balanceRepository.balance
    val balanceLoading = balanceRepository.loading

    private val _health = MutableStateFlow(EngineHealth.checks(context))
    val health: StateFlow<List<HealthCheck>> = _health.asStateFlow()

    val state: StateFlow<HomeState> = transactionRepository.getAllTransactions()
        .map { txs ->
            val startToday = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }.timeInMillis
            val weekAgo = System.currentTimeMillis() - 7 * 86_400_000L
            HomeState(
                successful = txs.count { it.status == TransactionStatus.SUCCESSFUL },
                failed = txs.count { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED },
                airtimeUsedToday = txs.filter { it.status == TransactionStatus.SUCCESSFUL && it.createdAt >= startToday }.sumOf { it.amount },
                weekCommission = txs.filter { it.status == TransactionStatus.SUCCESSFUL && it.createdAt >= weekAgo }.sumOf { it.commission },
                recent = txs.take(8)
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())

    fun refreshBalance() = balanceRepository.refresh()
    fun refreshHealth() { _health.value = EngineHealth.checks(context) }

    fun toggleAdvanced() {
        val v = !_advanced.value
        _advanced.value = v
        settingsRepository.setProcessingMode(if (v) ProcessingMode.ADVANCED else ProcessingMode.EXPRESS)
    }

    fun openSystemSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
