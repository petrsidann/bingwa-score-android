package com.bingwascore.app.ui.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions.asStateFlow()

    private val _filter = MutableStateFlow("All")
    val filter: StateFlow<String> = _filter.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllTransactions().collect {
                _transactions.value = it
            }
        }
    }

    fun setFilter(filter: String) {
        _filter.value = filter
    }

    fun getFilteredTransactions(): List<Transaction> {
        return when (_filter.value) {
            "Successful" -> _transactions.value.filter { it.status == TransactionStatus.SUCCESSFUL }
            "Failed" -> _transactions.value.filter { it.status == TransactionStatus.FAILED || it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED }
            "Pending" -> _transactions.value.filter { it.status == TransactionStatus.PENDING || it.status == TransactionStatus.PROCESSING }
            else -> _transactions.value
        }
    }
    
    fun deleteTransaction(id: String) {
        viewModelScope.launch {
            repository.deleteTransaction(id)
        }
    }
}
