package com.bingwascore.app.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.stats.AgentScore
import com.bingwascore.app.domain.stats.DayPoint
import com.bingwascore.app.domain.stats.EngineHealth
import com.bingwascore.app.domain.stats.HealthCheck
import com.bingwascore.app.domain.stats.StatisticsEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.util.Calendar
import javax.inject.Inject

data class HomeState(
    val greeting: String = "",
    val score: AgentScore = AgentScore(0, "Rookie", 0, 0.0, 0.0, 0.0, 0, 0),
    val weekCommission: List<DayPoint> = emptyList(),
    val healthIssues: List<HealthCheck> = emptyList(),
    val recent: List<Transaction> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val health = MutableStateFlow(EngineHealth.checks(context))

    val state: StateFlow<HomeState> = transactionRepository.getAllTransactions()
        .map { txs ->
            HomeState(
                greeting = greeting(),
                score = StatisticsEngine.compute(txs),
                weekCommission = StatisticsEngine.last7DaysCommission(txs),
                healthIssues = health.value.filter { !it.ok },
                recent = txs.take(8)
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())

    fun refreshHealth() {
        health.value = EngineHealth.checks(context)
    }

    private fun greeting(): String {
        return when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 5..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
    }
}
