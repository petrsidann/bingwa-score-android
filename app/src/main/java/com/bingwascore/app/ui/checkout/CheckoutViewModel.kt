package com.bingwascore.app.ui.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.BundleRepository
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.domain.model.Order
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class CheckoutStep { IDLE, PUSHING, CONFIRMING, DELIVERING, DELIVERED, ERROR }

data class CheckoutState(
    val bundle: Bundle? = null,
    val order: Order? = null,
    val recipientPhone: String = "",
    val userPhone: String = "",
    val step: CheckoutStep = CheckoutStep.IDLE,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val bundleRepository: BundleRepository,
    private val preferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(CheckoutState())
    val state: StateFlow<CheckoutState> = _state.asStateFlow()

    private var pollingJob: Job? = null

    fun init(bundleId: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val userPhone = preferences.userId.first() ?: ""
            _state.value = _state.value.copy(userPhone = userPhone, recipientPhone = userPhone)

            // Load bundle from the list (simplified — in production, fetch by ID)
            when (val result = bundleRepository.getBundles()) {
                is Resource.Success -> {
                    val bundle = result.data.find { it.id == bundleId }
                    _state.value = _state.value.copy(bundle = bundle, isLoading = false)
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message, isLoading = false)
                }
                is Resource.Loading -> {}
            }
        }
    }

    fun setRecipient(phone: String) {
        _state.value = _state.value.copy(recipientPhone = phone)
    }

    fun checkout() {
        val bundle = _state.value.bundle ?: return
        viewModelScope.launch {
            _state.value = _state.value.copy(step = CheckoutStep.PUSHING, error = null)
            when (val result = bundleRepository.checkout(bundle.id, _state.value.recipientPhone)) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(order = result.data)
                    startPolling(result.data.id)
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        step = CheckoutStep.ERROR,
                        error = result.message
                    )
                }
                is Resource.Loading -> {}
            }
        }
    }

    private fun startPolling(orderId: String) {
        pollingJob?.cancel()
        pollingJob = viewModelScope.launch {
            _state.value = _state.value.copy(step = CheckoutStep.CONFIRMING)
            var attempts = 0
            while (attempts < 40) {
                delay(2500)
                when (val result = bundleRepository.getOrder(orderId)) {
                    is Resource.Success -> {
                        val order = result.data
                        _state.value = _state.value.copy(order = order)
                        when (order.status) {
                            "paid" -> _state.value = _state.value.copy(step = CheckoutStep.DELIVERING)
                            "delivered" -> {
                                _state.value = _state.value.copy(step = CheckoutStep.DELIVERED)
                                return@launch
                            }
                            "failed" -> {
                                _state.value = _state.value.copy(
                                    step = CheckoutStep.ERROR,
                                    error = "Payment or delivery failed"
                                )
                                return@launch
                            }
                        }
                    }
                    is Resource.Error -> {
                        // Keep polling
                    }
                    is Resource.Loading -> {}
                }
                attempts++
            }
            _state.value = _state.value.copy(
                step = CheckoutStep.ERROR,
                error = "Timed out waiting for confirmation"
            )
        }
    }

    fun resetError() {
        _state.value = _state.value.copy(step = CheckoutStep.IDLE, error = null)
    }

    override fun onCleared() {
        pollingJob?.cancel()
        super.onCleared()
    }
}
