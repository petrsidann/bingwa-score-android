package com.bingwascore.app.ui.customers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.CustomerBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val customerRepository: CustomerRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    /** Stage 14 — the "Blacklisted" filter chip inside the top bar. */
    private val _blacklistFilter = MutableStateFlow(false)
    val blacklistFilter: StateFlow<Boolean> = _blacklistFilter.asStateFlow()

    /** The customer whose detail sheet is open, or null. */
    private val _selected = MutableStateFlow<Customer?>(null)
    val selected: StateFlow<Customer?> = _selected.asStateFlow()

    /** Recent-first, filter-chip + search applied. */
    val customers: StateFlow<List<Customer>> =
        combine(
            customerRepository.allCustomers,
            _query,
            _blacklistFilter
        ) { list, query, blacklistedOnly ->
            var out = CustomerBook.recentFirst(list)
            if (blacklistedOnly) out = out.filter { it.isBlacklisted }
            CustomerBook.search(out, query)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /**
     * Detail-sheet roll-up for the open customer, computed from their SUCCESSFUL
     * ledger rows (so the numbers are always honest even if a roll-up column
     * lags). Null until a customer is selected.
     */
    val selectedStats: StateFlow<CustomerBook.Stats?> =
        _selected.flatMapLatest { customer ->
            if (customer == null) {
                MutableStateFlow(null)
            } else {
                transactionRepository.successfulByPhone(customer.phoneNumber)
                    .map { rows -> rows.toStats() }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun setQuery(value: String) {
        _query.value = value
    }

    fun toggleBlacklistFilter() {
        _blacklistFilter.value = !_blacklistFilter.value
    }

    fun openDetail(customer: Customer) {
        _selected.value = customer
    }

    fun closeDetail() {
        _selected.value = null
    }

    /** Flips the customer's blacklist flag in Room; keeps the detail row in sync. */
    fun toggleBlacklisted(customer: Customer) {
        viewModelScope.launch {
            val updated = customer.copy(isBlacklisted = !customer.isBlacklisted)
            customerRepository.update(updated)
            if (_selected.value?.phoneNumber == customer.phoneNumber) {
                _selected.value = updated
            }
        }
    }

    private fun List<Transaction>.toStats(): CustomerBook.Stats =
        CustomerBook.stats(
            map {
                CustomerBook.Sale(
                    phone = it.phoneNumber,
                    name = it.customerName,
                    offerName = it.offerName,
                    amount = it.amount,
                    at = it.createdAt
                )
            }
        )
}

