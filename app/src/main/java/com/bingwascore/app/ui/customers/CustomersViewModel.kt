package com.bingwascore.app.ui.customers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    val customers: StateFlow<List<Customer>> =
        combine(customerRepository.allCustomers, _query) { list, query ->
            val needle = query.trim().lowercase(Locale.ROOT)
            if (needle.isEmpty()) {
                list
            } else {
                list.filter { customer ->
                    customer.name?.lowercase(Locale.ROOT)?.contains(needle) == true ||
                        customer.phoneNumber.lowercase(Locale.ROOT).contains(needle)
                }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setQuery(value: String) {
        _query.value = value
    }

    /** Flips the customer's blacklist flag in Room. */
    fun toggleBlacklisted(customer: Customer) {
        viewModelScope.launch {
            customerRepository.update(customer.copy(isBlacklisted = !customer.isBlacklisted))
        }
    }
}