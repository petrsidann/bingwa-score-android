package com.bingwascore.app.ui.blacklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlacklistViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    val blacklisted: StateFlow<List<Customer>> = customerRepository.blacklisted
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /** Removes the customer from the blacklist so offers can reach them again. */
    fun unblock(customer: Customer) {
        viewModelScope.launch {
            customerRepository.update(customer.copy(isBlacklisted = false))
        }
    }
}
