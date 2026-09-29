package com.bingwascore.app.ui.mesh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.util.DeviceIdProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

import javax.inject.Inject

@HiltViewModel
class MeshViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    private val deviceIdProvider: DeviceIdProvider
) : ViewModel() {

    val deviceId: StateFlow<String> = userPreferences.deviceId
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val serverUrl: StateFlow<String> = userPreferences.meshServerUrl
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val connected: StateFlow<Boolean> = userPreferences.meshConnected
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    private val _connecting = MutableStateFlow(false)
    val connecting: StateFlow<Boolean> = _connecting.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        viewModelScope.launch {
            // Parity F — the shown id is now a permanent digest of an
            // AndroidKeyStore key pair (DeviceIdProvider), not a random
            // per-install string. Keystore access happens off the main thread.
            try {
                val permanent = withContext(Dispatchers.IO) { deviceIdProvider.deviceId() }
                if (userPreferences.deviceId.first() != permanent) {
                    userPreferences.setDeviceId(permanent)
                }
            } catch (t: Throwable) {
                Timber.e(t, "Could not resolve the permanent device id")
            }
        }
    }

    /** Validates the URL, persists it and flips the node online. */
    fun connect(rawUrl: String) {
        val url = rawUrl.trim()
        if (url.isEmpty()) {
            _error.value = "Enter a server URL first"
            return
        }
        if (!url.startsWith("http://") && !url.startsWith("https://") && !url.startsWith("ws://") && !url.startsWith("wss://")) {
            _error.value = "URL must start with http(s):// or ws(s)://"
            return
        }
        _error.value = null
        viewModelScope.launch {
            _connecting.value = true
            delay(CONNECT_DELAY_MS) // handshake placeholder
            userPreferences.setMeshServerUrl(url)
            userPreferences.setMeshConnected(true)
            _connecting.value = false
        }
    }

    fun disconnect() {
        viewModelScope.launch {
            userPreferences.setMeshConnected(false)
        }
    }

    fun clearError() {
        _error.value = null
    }

    private companion object {
        const val CONNECT_DELAY_MS = 900L
    }
}
