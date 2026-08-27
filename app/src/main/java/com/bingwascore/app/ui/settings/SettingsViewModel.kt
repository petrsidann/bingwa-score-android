package com.bingwascore.app.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.updates.AppUpdateRepository
import com.bingwascore.app.data.updates.UpdateState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val updateRepository: AppUpdateRepository
) : ViewModel() {

    val updateState: StateFlow<UpdateState> = updateRepository.updateState

    fun checkForUpdates() {
        viewModelScope.launch {
            updateRepository.checkForUpdates()
        }
    }

    fun downloadAndInstall(url: String) {
        viewModelScope.launch {
            updateRepository.downloadAndInstall(url)
        }
    }
}
