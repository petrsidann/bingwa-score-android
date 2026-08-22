package com.bingwascore.app.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.AuthRepository
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun signup(fullName: String, phone: String, email: String?, password: String) {
        viewModelScope.launch {
            _state.value = AuthState(isLoading = true)
            when (val result = repository.signup(fullName, phone, email, password)) {
                is Resource.Success -> _state.value = AuthState(user = result.data)
                is Resource.Error -> _state.value = AuthState(error = result.message)
                is Resource.Loading -> {}
            }
        }
    }

    fun login(phone: String?, email: String?, password: String) {
        viewModelScope.launch {
            _state.value = AuthState(isLoading = true)
            when (val result = repository.login(phone, email, password)) {
                is Resource.Success -> _state.value = AuthState(user = result.data)
                is Resource.Error -> _state.value = AuthState(error = result.message)
                is Resource.Loading -> {}
            }
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(error = null)
    }
}
