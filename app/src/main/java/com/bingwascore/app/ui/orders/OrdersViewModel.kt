package com.bingwascore.app.ui.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.BundleRepository
import com.bingwascore.app.domain.model.Order
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OrdersState(
    val orders: List<Order> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val filter: String = "all"
)

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val bundleRepository: BundleRepository
) : ViewModel() {

    private val _state = MutableStateFlow(OrdersState(isLoading = true))
    val state: StateFlow<OrdersState> = _state.asStateFlow()

    init { loadOrders() }

    fun loadOrders() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            val type = _state.value.filter.takeIf { it != "all" }
            when (val result = bundleRepository.getOrders(type)) {
                is Resource.Success -> _state.value = _state.value.copy(
                    orders = result.data, isLoading = false
                )
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun setFilter(filter: String) {
        _state.value = _state.value.copy(filter = filter)
        loadOrders()
    }
}
