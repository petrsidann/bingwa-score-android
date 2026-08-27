package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val score: Int = 0,
    val totalCommission: Double = 0.0,
    val successfulCount: Int = 0,
    val failedCount: Int = 0,
    val isLoading: Boolean = true
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            transactionRepository.getAllTransactions().collect { transactions ->
                val successful = transactions.filter { it.status == TransactionStatus.SUCCESSFUL }
                val failed = transactions.filter { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED }
                
                // Score Logic: 
                // Base: 10 points per success
                // Bonus: 50 points per 1000 KES commission
                // Penalty: -5 per failure
                val commission = successful.sumOf { it.commission }
                val rawScore = (successful.size * 10) + (commission / 1000 * 50).toInt() - (failed.size * 5)
                val finalScore = rawScore.coerceIn(0, 1000)

                _uiState.value = HomeUiState(
                    score = finalScore,
                    totalCommission = commission,
                    successfulCount = successful.size,
                    failedCount = failed.size,
                    isLoading = false
                )
            }
        }
    }
}
