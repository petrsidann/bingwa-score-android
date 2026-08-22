package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.AuthRepository
import com.bingwascore.app.data.repository.BundleRepository
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
    val user: User? = null,
    val bundles: List<Bundle> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val activeTab: String = "data"
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bundleRepository: BundleRepository,
    private val authRepository: AuthRepository,
    private val preferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isLoading = true))
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadUser()
        loadBundles()
    }

    private fun loadUser() {
        viewModelScope.launch {
            // Load user info from preferences (simplified)
            val userId = preferences.userId.first()
            if (userId != null) {
                try {
                    val response = com.bingwascore.app.data.remote.ApiService::class.java
                    // For now, we'll keep user info minimal
                } catch (e: Exception) {
                    // ignore
                }
            }
        }
    }

    fun loadBundles() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = bundleRepository.getBundles(_state.value.activeTab)) {
                is Resource.Success -> _state.value = _state.value.copy(
                    bundles = result.data,
                    isLoading = false
                )
                is Resource.Error -> _state.value = _state.value.copy(
                    error = result.message,
                    isLoading = false
                )
                is Resource.Loading -> {}
            }
        }
    }

    fun setTab(tab: String) {
        _state.value = _state.value.copy(activeTab = tab)
        loadBundles()
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }
}
