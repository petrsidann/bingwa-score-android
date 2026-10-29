package com.bingwascore.app.ui.settings

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.updates.UpdateChecker
import com.bingwascore.app.updates.UpdateState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import timber.log.Timber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

fun isValidServerUrl(url: String): Boolean {
    if (url.isBlank()) return false
    return runCatching { java.net.URL(url) }
        .map { it.protocol.equals("https", ignoreCase = true) && it.host.isNotBlank() }
        .getOrElse { false }
}

sealed interface UpdateCheckState {
    data object Idle : UpdateCheckState
    data object Checking : UpdateCheckState

    /** [latestVersion] is the version the manifest offers, when there is one. */
    data class Done(val upToDate: Boolean, val latestVersion: String? = null) : UpdateCheckState

    /** The server could not be reached (404 / offline). Show "Can't check right now" + Retry. */
    data object CannotCheck : UpdateCheckState
}

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences,
    private val pipeline: TransactionPipeline,
    private val updateChecker: UpdateChecker
) : ViewModel() {
    val themeMode: StateFlow<ThemeMode> = userPreferences.themeMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ThemeMode.PORCELAIN_DIM)

    val processingMode: StateFlow<AppProcessingMode> = userPreferences.processingMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), AppProcessingMode.EXPRESS)

    /** MEGA A — inbound routing switches shown on the Settings main page. */
    val processMpesaMessages: StateFlow<Boolean> = userPreferences.processMpesaMessages
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    val processSitelinkMessages: StateFlow<Boolean> = userPreferences.processSitelinkMessages
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    fun setProcessMpesaMessages(value: Boolean) {
        viewModelScope.launch { userPreferences.setProcessMpesaMessages(value) }
    }

    fun setProcessSitelinkMessages(value: Boolean) {
        viewModelScope.launch { userPreferences.setProcessSitelinkMessages(value) }
    }

    /** Stage 14 — master switch for the Customers autosave book (default ON). */
    val customersAutosave: StateFlow<Boolean> = userPreferences.customersAutosave
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    fun setCustomersAutosave(value: Boolean) {
        viewModelScope.launch { userPreferences.setCustomersAutosave(value) }
    }

    val simSelection: StateFlow<String> = userPreferences.simSelection
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UserPreferences.SIM_1)

    /** Stage 33 — server URL override persisted in DataStore; blank = build-time default. */
    val defaultServerUrl: String = BuildConfig.BASE_URL

    val serverUrl: StateFlow<String> = userPreferences.serverUrl
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    /** The URL the network client actually points at: the stored override, or the default. */
    val effectiveServerUrl: StateFlow<String> = serverUrl.map { stored ->
        stored.takeIf { isValidServerUrl(it) } ?: defaultServerUrl
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), defaultServerUrl)

    private val _serverUrlError = MutableStateFlow<String?>(null)
    val serverUrlError: StateFlow<String?> = _serverUrlError.asStateFlow()

    fun setServerUrl(value: String) {
        if (!isValidServerUrl(value)) {
            _serverUrlError.value = "Server URL must use https"
            return
        }
        _serverUrlError.value = null
        viewModelScope.launch { userPreferences.setServerUrl(value) }
    }

    fun resetServerUrl() {
        _serverUrlError.value = null
        viewModelScope.launch { userPreferences.setServerUrl("") }
    }

    private val _updateState = MutableStateFlow<UpdateCheckState>(UpdateCheckState.Idle)
    val updateState: StateFlow<UpdateCheckState> = _updateState.asStateFlow()

    private val _updateUrl = MutableStateFlow<String?>(null)
    val updateUrl: StateFlow<String?> = _updateUrl.asStateFlow()

    /** Stage 21 — release notes body for the changelog dialog. */
    var updateChangelog: String = ""
        private set

    val appVersion: String = BuildConfig.APP_VERSION

    private val _simulateResult = MutableStateFlow<String?>(null)
    val simulateResult: StateFlow<String?> = _simulateResult.asStateFlow()

    // Parity E — drives the success/error haptic on the simulate bench.
    private val _simulateFailed = MutableStateFlow(false)
    val simulateFailed: StateFlow<Boolean> = _simulateFailed.asStateFlow()

    /**
     * Dev hook (Audit G8): feeds a fake INCOMING payment into the real engine
     * so match -> dial -> status -> reply is testable with zero real money.
     */
    fun simulatePayment(phone: String, name: String, amount: Double) {
        viewModelScope.launch {
            try {
                val cleanPhone = phone.trim()
                if (cleanPhone.isBlank() || amount <= 0.0) {
                    _simulateFailed.value = true
                    _simulateResult.value = "Enter a phone number and an amount above 0."
                    return@launch
                }
                pipeline.simulateIncomingPayment(cleanPhone, name.trim(), amount)
                _simulateFailed.value = false
                _simulateResult.value =
                    "Simulated Ksh ${"%.2f".format(amount)} from $cleanPhone — watch Transactions."
            } catch (t: Throwable) {
                Timber.e(t, "simulatePayment failed")
                _simulateFailed.value = true
                _simulateResult.value = "Simulation failed: ${t.message}"
            }
        }
    }

    fun setThemeMode(value: ThemeMode) {
        viewModelScope.launch { userPreferences.setThemeMode(value) }
    }

        fun setProcessingMode(value: AppProcessingMode) {
        viewModelScope.launch { userPreferences.setProcessingMode(value) }
    }

    private val _showAdvancedExplanation = MutableStateFlow(false)
    val showAdvancedExplanation: StateFlow<Boolean> = _showAdvancedExplanation.asStateFlow()

    /** The user tapped "Advanced" — surface the explanation dialog before enabling. */
    fun requestAdvancedMode() {
        _showAdvancedExplanation.value = true
    }

    fun dismissAdvancedExplanation() {
        _showAdvancedExplanation.value = false
    }

    /** Confirmed: enable Advanced mode and open the system accessibility picker. */
    fun confirmAdvancedMode() {
        _showAdvancedExplanation.value = false
        viewModelScope.launch { userPreferences.setProcessingMode(AppProcessingMode.ADVANCED) }
        openAccessibilitySettings()
    }

    private fun openAccessibilitySettings() {
        try {
            context.startActivity(
                Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        } catch (t: Throwable) {
            Timber.e(t, "Could not open accessibility settings")
        }
    }

    fun setSimSelection(value: String) {
        viewModelScope.launch { userPreferences.setSimSelection(value) }
    }

    /** Stage 22 + 31 — reads `{BASE_URL}/updates/latest.json` and surfaces the answer. */
    fun checkForUpdates() {
        if (_updateState.value is UpdateCheckState.Checking) return
        viewModelScope.launch {
            _updateState.value = UpdateCheckState.Checking
            _updateUrl.value = null
            updateChangelog = ""
            try {
                when (val state = updateChecker.check()) {
                    is UpdateState.UpToDate ->
                        _updateState.value = UpdateCheckState.Done(upToDate = true)
                    is UpdateState.UpdateAvailable -> {
                        _updateUrl.value = state.downloadUrl
                        updateChangelog = state.changelog
                        _updateState.value = UpdateCheckState.Done(
                            upToDate = false,
                            latestVersion = state.latestVersion
                        )
                    }
                    is UpdateState.CannotCheck ->
                        _updateState.value = UpdateCheckState.CannotCheck
                }
            } catch (t: Throwable) {
                Timber.e(t, "UpdateChecker failed")
                _updateState.value = UpdateCheckState.CannotCheck
            }
        }
    }
}
