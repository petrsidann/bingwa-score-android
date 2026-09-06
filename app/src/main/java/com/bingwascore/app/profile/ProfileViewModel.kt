package com.bingwascore.app.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.domain.score.ScoreEngine
import com.bingwascore.app.services.EngineService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import android.content.Context
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences,
    transactionRepository: TransactionRepository,
    customerRepository: CustomerRepository,
    private val scoreEngine: ScoreEngine
) : ViewModel() {

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    val phone: StateFlow<String> = userPreferences.phone
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val engineEnabled: StateFlow<Boolean> = userPreferences.engineEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    private val scoreState = combine(transactionRepository.allTransactions, customerRepository.allCustomers) { txns, customers ->
        scoreEngine.compute(txns, customers)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000),
        com.bingwascore.app.domain.score.ScoreState(0, "Bronze", 500, 0f, 0, 0f, 0.0, 0))

    val levelName: StateFlow<String> = scoreState
        .map { it.levelName }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bronze")

    val score: StateFlow<Int> = scoreState
        .map { it.score }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    fun toggleEngine() {
        viewModelScope.launch {
            val current = userPreferences.engineEnabled.first()
            userPreferences.setEngineEnabled(!current)
            if (!current) EngineService.start(context.applicationContext)
            else EngineService.stop(context.applicationContext)
        }
    }
}
