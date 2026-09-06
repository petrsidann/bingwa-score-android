package com.bingwascore.app.ui.onboarding

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.PowerUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Backing state for [SetupChecklistScreen]: recomputes the four live checklist
 * checks (permissions, notifications, battery, engine) and toggles the engine
 * foreground service / setup_complete flag.
 */
@HiltViewModel
class SetupChecklistViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences
) : ViewModel() {

    /** Auto-forwards to Home once the user taps "Start Earning". */
    val setupComplete: StateFlow<Boolean> = userPreferences.setupComplete
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    /** Mirrors the Home engine toggle / app-start engine state. */
    val engineEnabled: StateFlow<Boolean> = userPreferences.engineEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    private val _permissionsGranted = MutableStateFlow(arePermissionsGranted())
    val permissionsGranted: StateFlow<Boolean> = _permissionsGranted.asStateFlow()

    private val _notificationsEnabled = MutableStateFlow(areNotificationsEnabled())
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled.asStateFlow()

    private val _batteryIgnored = MutableStateFlow(isBatteryOptimizationIgnored())
    val batteryIgnored: StateFlow<Boolean> = _batteryIgnored.asStateFlow()

    /** Re-reads every check (call after an external settings change returns). */
    fun refreshChecks() {
        _permissionsGranted.value = arePermissionsGranted()
        _notificationsEnabled.value = areNotificationsEnabled()
        _batteryIgnored.value = isBatteryOptimizationIgnored()
    }

    private fun arePermissionsGranted(): Boolean =
        REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }

    private fun areNotificationsEnabled(): Boolean =
        try {
            (context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)
                ?.areNotificationsEnabled() == true
        } catch (t: Throwable) {
            false
        }

    private fun isBatteryOptimizationIgnored(): Boolean =
        PowerUtils.isIgnoringBatteryOptimizations(context)

    /** Enables the engine preference and boots the foreground keep-alive service. */
    fun startEngine() {
        viewModelScope.launch { userPreferences.setEngineEnabled(true) }
        EngineService.start(context)
        refreshChecks()
    }

    /** Marks setup complete so the checklist advances to the Home screen. */
    fun completeSetup() {
        viewModelScope.launch { userPreferences.setSetupComplete(true) }
    }

    companion object {
        /** Runtime permissions the engine needs to read, reply to and dial for SMS. */
        val REQUIRED_PERMISSIONS: List<String> = buildList {
            add(Manifest.permission.RECEIVE_SMS)
            add(Manifest.permission.READ_SMS)
            add(Manifest.permission.SEND_SMS)
            add(Manifest.permission.READ_PHONE_STATE)
            add(Manifest.permission.CALL_PHONE)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}
