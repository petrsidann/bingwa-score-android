package com.bingwascore.app.ui.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.remote.dto.AdminBundleRequest
import com.bingwascore.app.data.remote.dto.AdminOrder
import com.bingwascore.app.data.remote.dto.AdminUser
import com.bingwascore.app.data.remote.dto.PeriodStats
import com.bingwascore.app.data.repository.AdminRepository
import com.bingwascore.app.data.repository.AuthRepository
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardStats(
    val today: PeriodStats = PeriodStats(0.0, 0.0, 0),
    val week: PeriodStats = PeriodStats(0.0, 0.0, 0),
    val month: PeriodStats = PeriodStats(0.0, 0.0, 0),
    val allTime: PeriodStats = PeriodStats(0.0, 0.0, 0)
)

data class AdminState(
    val activeTab: String = "dashboard",
    val dashboard: DashboardStats = DashboardStats(),
    val bundles: List<Bundle> = emptyList(),
    val orders: List<AdminOrder> = emptyList(),
    val users: List<AdminUser> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null,
    val orderFilter: String = "all",
    val isBundleFormVisible: Boolean = false,
    val editingBundle: Bundle? = null
)

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val adminRepository: AdminRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AdminState(isLoading = true))
    val state: StateFlow<AdminState> = _state.asStateFlow()

    init {
        loadDashboard()
    }

    fun setTab(tab: String) {
        _state.value = _state.value.copy(activeTab = tab, error = null, successMessage = null)
        when (tab) {
            "dashboard" -> loadDashboard()
            "bundles" -> loadBundles()
            "orders" -> loadOrders()
            "users" -> loadUsers()
        }
    }

    fun loadDashboard() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = adminRepository.getDashboard()) {
                is Resource.Success -> {
                    val d = result.data
                    _state.value = _state.value.copy(
                        dashboard = DashboardStats(d.today, d.week, d.month, d.allTime),
                        isLoading = false
                    )
                }
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun loadBundles() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = adminRepository.getBundles()) {
                is Resource.Success -> _state.value = _state.value.copy(
                    bundles = result.data, isLoading = false
                )
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun showBundleForm(bundle: Bundle? = null) {
        _state.value = _state.value.copy(isBundleFormVisible = true, editingBundle = bundle)
    }

    fun hideBundleForm() {
        _state.value = _state.value.copy(isBundleFormVisible = false, editingBundle = null)
    }

    fun saveBundle(
        type: String,
        name: String,
        size: String,
        validity: String,
        costPrice: Double,
        salePrice: Double
    ) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            val request = AdminBundleRequest(type, name, size, validity, costPrice, salePrice)
            val editing = _state.value.editingBundle

            val result = if (editing != null) {
                adminRepository.updateBundle(editing.id, request)
            } else {
                adminRepository.createBundle(request)
            }

            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        isBundleFormVisible = false,
                        editingBundle = null,
                        successMessage = if (editing != null) "Bundle updated" else "Bundle created"
                    )
                    loadBundles()
                }
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun deleteBundle(id: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = adminRepository.deleteBundle(id)) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        successMessage = "Bundle deleted"
                    )
                    loadBundles()
                }
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun toggleBundleActive(bundle: Bundle) {
        viewModelScope.launch {
            val request = AdminBundleRequest(
                type = bundle.type,
                name = bundle.name,
                size = bundle.size,
                validity = bundle.validity,
                costPrice = bundle.costPrice,
                salePrice = bundle.salePrice,
                active = !bundle.active
            )
            adminRepository.updateBundle(bundle.id, request)
            loadBundles()
        }
    }

    fun loadOrders() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            val status = _state.value.orderFilter.takeIf { it != "all" }
            when (val result = adminRepository.getOrders(status)) {
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

    fun setOrderFilter(filter: String) {
        _state.value = _state.value.copy(orderFilter = filter)
        loadOrders()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = adminRepository.getUsers()) {
                is Resource.Success -> _state.value = _state.value.copy(
                    users = result.data, isLoading = false
                )
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message, isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun clearMessages() {
        _state.value = _state.value.copy(error = null, successMessage = null)
    }

    fun logout() {
        viewModelScope.launch { authRepository.logout() }
    }
}
