package com.bingwascore.app.ui.manage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.CustomerBook
import com.bingwascore.app.domain.PlanCatalog
import com.bingwascore.app.domain.PlanOffer
import com.bingwascore.app.domain.PlanState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

enum class ManageTab {
    OVERVIEW, OFFERS, CUSTOMERS, RENEWALS, REPLIES
}

@HiltViewModel
class ManageViewModel @Inject constructor(
    customerRepository: CustomerRepository,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(ManageTab.OVERVIEW)
    val selectedTab: StateFlow<ManageTab> = _selectedTab.asStateFlow()

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _selected = MutableStateFlow<Customer?>(null)
    val selected: StateFlow<Customer?> = _selected.asStateFlow()

    val customers: StateFlow<List<Customer>> =
        combine(customerRepository.allCustomers, _query) { list, query ->
            CustomerBook.search(CustomerBook.recentFirst(list), query)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val selectedStats: StateFlow<CustomerBook.Stats?> =
        _selected.flatMapLatest { customer ->
            if (customer == null) {
                MutableStateFlow(null)
            } else {
                transactionRepository.successfulByPhone(customer.phoneNumber)
                    .map { it.toStats() }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    val planState: StateFlow<PlanState> = userPreferences.planState
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), PlanState())

    val allPlans: List<PlanOffer> = PlanCatalog.all

    fun selectTab(tab: ManageTab) {
        _selectedTab.value = tab
    }

    fun setQuery(value: String) {
        _query.value = value
    }

    fun selectCustomer(customer: Customer) {
        _selected.value = customer
    }

    fun closeDetail() {
        _selected.value = null
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
