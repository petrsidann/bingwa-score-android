package com.bingwascore.app.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.domain.score.ScoreEngine
import com.bingwascore.app.domain.score.ScoreState
import com.bingwascore.app.domain.score.Achievement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    transactionRepository: TransactionRepository,
    customerRepository: CustomerRepository,
    private val scoreEngine: ScoreEngine
) : ViewModel() {

    val state: StateFlow<ScoreState> =
        combine(transactionRepository.allTransactions, customerRepository.allCustomers) { txns, customers ->
            scoreEngine.compute(txns, customers)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ScoreState(0, "Bronze", 500, 0f, 0, 0f, 0.0, 0))

    val achievements: StateFlow<List<Achievement>> =
        combine(transactionRepository.allTransactions, customerRepository.allCustomers) { txns, customers ->
            scoreEngine.achievements(txns, customers)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
