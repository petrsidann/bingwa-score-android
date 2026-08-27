package com.bingwascore.app.ui.home

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.domain.stats.EngineHealth
import com.bingwascore.app.domain.stats.HealthCheck
import com.bingwascore.app.domain.stats.StatisticsEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class HomeState(
    val greeting: String = "",
    val successfulCount: Int = 0,
    val failedCount: Int = 0,
    val totalCommission: Double = 0.0,
    val airtimeUsedToday: Double = 0.0,
    val airtimeBalance: String = "Ksh 0.00",
    val healthIssues: List<HealthCheck> = emptyList(),
    val recent: List<com.bingwascore.app.domain.model.Transaction> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val health = MutableStateFlow(EngineHealth.checks(context))
    private val airtimeBalance = MutableStateFlow("Ksh 0.00")

    val state: StateFlow<HomeState> = combine(
        transactionRepository.getAllTransactions(),
        health,
        airtimeBalance
    ) { txs, healthChecks, balance ->
        val successful = txs.count { it.status == TransactionStatus.SUCCESSFUL }
        val failed = txs.count { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED }
        val commission = txs.filter { it.status == TransactionStatus.SUCCESSFUL }.sumOf { it.commission }
        
        // Calculate airtime used today
        val startOfDay = java.util.Calendar.getInstance().apply {
            set(java.util.Calendar.HOUR_OF_DAY, 0); set(java.util.Calendar.MINUTE, 0)
            set(java.util.Calendar.SECOND, 0); set(java.util.Calendar.MILLISECOND, 0)
        }.timeInMillis
        val airtimeUsed = txs.filter { it.status == TransactionStatus.SUCCESSFUL && it.createdAt >= startOfDay }.sumOf { it.amount }

        HomeState(
            greeting = greeting(),
            successfulCount = successful,
            failedCount = failed,
            totalCommission = commission,
            airtimeUsedToday = airtimeUsed,
            airtimeBalance = balance,
            healthIssues = healthChecks.filter { !it.ok },
            recent = txs.take(5)
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())

    fun refreshHealth() {
        health.value = EngineHealth.checks(context)
    }

    fun openSystemSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = android.net.Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    fun refreshAirtimeBalance() {
        // Placeholder: In Batch 5-B we will dial *100# via USSD and parse the response
        airtimeBalance.value = "Refreshing..."
        // Simulate delay for now
        viewModelScope.launch {
            kotlinx.coroutines.delay(1500)
            airtimeBalance.value = "Ksh 30,241.52" // Mock balance until USSD parsing is wired
        }
    }

    private fun greeting(): String {
        return when (java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)) {
            in 5..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
    }
}
