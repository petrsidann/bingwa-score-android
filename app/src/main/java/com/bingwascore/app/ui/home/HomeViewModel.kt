package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import java.util.Calendar
import javax.inject.Inject

data class HomeState(
    val greeting: String = "",
    val successfulCount: Int = 0,
    val failedCount: Int = 0,
    val pendingCount: Int = 0,
    val totalCommission: Double = 0.0,
    val recentTransactions: List<Transaction> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val state: StateFlow<HomeState> = combine(
        transactionRepository.getTransactionCountByStatus(TransactionStatus.SUCCESSFUL),
        transactionRepository.getTransactionCountByStatus(TransactionStatus.FAILED),
        transactionRepository.getTransactionCountByStatus(TransactionStatus.PROCESSING),
        transactionRepository.getTotalCommission(),
        transactionRepository.getAllTransactions()
    ) { success, failed, pending, commission, all ->
        HomeState(
            greeting = greeting(),
            successfulCount = success,
            failedCount = failed,
            pendingCount = pending,
            totalCommission = commission ?: 0.0,
            recentTransactions = all.take(8)
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        HomeState(greeting = greeting())
    )

    private fun greeting(): String {
        return when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 5..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
    }
}
