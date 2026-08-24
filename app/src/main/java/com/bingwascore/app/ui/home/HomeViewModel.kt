package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.BundleRepository
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
    val bundles: List<Bundle> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val activeTab: String = "data"
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bundleRepository: BundleRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isLoading = true))
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadBundles()
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
}
