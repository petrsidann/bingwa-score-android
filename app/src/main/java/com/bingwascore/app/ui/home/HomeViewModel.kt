package com.bingwascore.app.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.telephony.TelephonyManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.EngineService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    companion object {
        private const val BALANCE_USSD = "*144#"

        /**
         * Primary pattern: Safaricom's *144# reply labels the line
         * "Airtime Bal: 1,234.56 Ksh..." — match across the label so a reply that
         * also contains other Ksh figures still yields the airtime balance.
         */
        private const val BALANCE_REGEX = "Airtime Bal\\s*:.*?Ksh([\\d,]+\\.\\d{2})"

        /** Fallback for providers that omit the "Airtime Bal:" label entirely. */
        private const val BALANCE_REGEX_FALLBACK = "Ksh\\.?\\s?([\\d,]+\\.\\d{2})"

        /** Shown when *144# cannot be issued because READ_PHONE_STATE is denied. */
        const val GRANT_PHONE_PERMISSION = "Grant Phone permission to check balance"
    }

    private val _balance = MutableStateFlow(0.0)
    val balance: StateFlow<Double> = _balance.asStateFlow()

    private val _balanceLoading = MutableStateFlow(false)
    val balanceLoading: StateFlow<Boolean> = _balanceLoading.asStateFlow()

    /**
     * Why the balance could not be read, or null when it is fine. The Home
     * screen renders this as a snackbar so a 0.00 balance is always explained —
     * "Grant Phone permission to check balance" when READ_PHONE_STATE is
     * missing, a retry hint when the operator reply was unreadable.
     */
    private val _balanceError = MutableStateFlow<String?>(null)
    val balanceError: StateFlow<String?> = _balanceError.asStateFlow()

    // Parity E — true until the first Room snapshot lands, so the stat tiles
    // shimmer instead of flashing 0 on cold start.
    private val _statsLoading = MutableStateFlow(true)
    val statsLoading: StateFlow<Boolean> = _statsLoading.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                transactionRepository.liveTransactions.first()
            } catch (t: Throwable) {
                Timber.e(t, "Initial home stats load failed")
            }
            _statsLoading.value = false
        }
    }

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    val advancedMode: StateFlow<Boolean> = userPreferences.processingMode
        .map { it == AppProcessingMode.ADVANCED }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

        val botPaused: StateFlow<Boolean> = userPreferences.engageBotActive
        .map { !it }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    /** Whether the foreground engine service is enabled (and therefore should be running). */
    val engineEnabled: StateFlow<Boolean> = userPreferences.engineEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), true)

    /** One-shot flag surfaced as a glass dialog before Advanced Mode is turned on. */
    private val _showAdvancedExplanation = MutableStateFlow(false)
    val showAdvancedExplanation: StateFlow<Boolean> = _showAdvancedExplanation.asStateFlow()

    // Parity D — Home renders REAL Room data via the live (soft-delete-safe)
    // flow: every tile + recent list derives from liveTransactions.
    val successfulCount: StateFlow<Int> = transactionRepository
        .liveTransactions
        .map { list -> list.count { it.status == TransactionStatus.SUCCESSFUL.value } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val failedCount: StateFlow<Int> = transactionRepository
        .liveTransactions
        .map { list ->
            list.count {
                it.status == TransactionStatus.FAILED.value ||
                    it.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED.value
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    /** R2 — the third Home counter: everything still queued, dialing or scheduled. */
    val pendingCount: StateFlow<Int> = transactionRepository
        .liveTransactions
        .map { list ->
            list.count {
                it.status == TransactionStatus.PENDING.value ||
                    it.status == TransactionStatus.PROCESSING.value ||
                    it.status == TransactionStatus.SCHEDULED.value
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val airtimeUsedToday: StateFlow<Double> = transactionRepository.liveTransactions
        .map { list ->
            val startOfDay = startOfDayMillis()
            list.filter {
                it.status == TransactionStatus.SUCCESSFUL.value && it.createdAt >= startOfDay
            }.sumOf { it.amount }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0.0)

    /** Commission per weekday (Monday-first, Mon..Sun) for the current calendar week. */
    val weeklyCommissionByDay: StateFlow<List<Double>> = transactionRepository.liveTransactions
        .map { list ->
            val weekStart = startOfWeekMillis()
            val cal = Calendar.getInstance()
            val buckets = DoubleArray(7)
            list.forEach { tx ->
                if (tx.status == TransactionStatus.SUCCESSFUL.value && tx.createdAt >= weekStart) {
                    cal.timeInMillis = tx.createdAt
                    buckets[(cal.get(Calendar.DAY_OF_WEEK) + 5) % 7] += tx.commission
                }
            }
            buckets.toList()
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), List(7) { 0.0 })

    val weeklyCommission: StateFlow<Double> = weeklyCommissionByDay
        .map { it.sum() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0.0)

    // Parity D — Recent Activity: last 5 live rows (DAO already ORDERs BY createdAt DESC).
/**
     * Dials *144# and parses the "Airtime Bal: … Ksh 1,234.56" reply into a
     * Double cached in [UserPreferences] and emitted immediately as [balance].
     *
     * The balance is NEVER left silently at 0.00: every failure path (no
     * telephony, missing permission, malformed reply, operator rejection) sets
     * [balanceError] so the UI can tell the agent exactly what to fix instead of
     * showing a fake zero.
     */
    @SuppressLint("MissingPermission")
    fun refreshBalance() {
        if (_balanceLoading.value) return
        _balanceLoading.value = true
        _balanceError.value = null
        try {
            val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            if (telephony == null) {
                failBalance("Could not read your balance on this device")
                return
            }
            telephony.sendUssdRequest(
                BALANCE_USSD,
                object : TelephonyManager.UssdResponseCallback() {
                    override fun onReceiveUssdResponse(
                        telephonyManager: TelephonyManager,
                        request: String?,
                        response: CharSequence?
                    ) {
                        val parsed = parseBalance(response?.toString())
                        if (parsed == null) {
                            failBalance("Could not read the balance — try again")
                            return
                        }
                        _balance.value = parsed
                        _balanceLoading.value = false
                        viewModelScope.launch {
                            userPreferences.setAirtimeBalance(parsed)
                        }
                    }

                    override fun onReceiveUssdResponseFailed(
                        telephonyManager: TelephonyManager,
                        request: String?,
                        failureCode: Int
                    ) {
                        failBalance("Could not read the balance — try again")
                    }
                },
                Handler(Looper.getMainLooper())
            )
        } catch (_: SecurityException) {
            // READ_PHONE_STATE revoked — tell the agent exactly what to grant.
            failBalance(GRANT_PHONE_PERMISSION)
        } catch (_: Throwable) {
            failBalance(GRANT_PHONE_PERMISSION)
        }
    }

    /** Clears the snackbar once the UI has shown it. */
    fun consumeBalanceError() {
        _balanceError.value = null
    }

    /** Single exit for every failure: stops the spinner AND surfaces the reason. */
    private fun failBalance(message: String) {
        _balanceLoading.value = false
        _balanceError.value = message
    }
    val recentTransactions: StateFlow<List<Transaction>> = transactionRepository.liveTransactions
        .map { it.take(5) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /**
     * R2 — the FULL activity list under the "Transactions" header, straight from
     * the live DAO (soft-deleted rows excluded), newest first, all the way back
     * to the oldest transaction the agent has.
     */
    val allTransactions: StateFlow<List<Transaction>> = transactionRepository.liveTransactions
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    init {
        viewModelScope.launch {
            _balance.value = userPreferences.airtimeBalance.first()
        }
    }

    /**
     * Extracts the airtime balance from a *144# reply.
     *
     * Tries the labelled pattern first ("Airtime Bal: 1,234.56 Ksh") because a
     * real reply can carry several Ksh figures; falls back to a bare "Ksh 12.34"
     * match for providers that omit the label. Returns null when neither
     * matches so the caller can report a failure instead of showing 0.00.
     */
    private fun parseBalance(response: String?): Double? {
        if (response.isNullOrBlank()) return null
        Regex(BALANCE_REGEX).find(response)?.let { return it.digitsAsDouble() }
        Regex(BALANCE_REGEX_FALLBACK).find(response)?.let { return it.digitsAsDouble() }
        return null
    }

    /** "1,234.56" -> 1234.56 (null when unparseable). */
    private fun MatchResult.digitsAsDouble(): Double? =
        groupValues.getOrNull(1)?.replace(",", "")?.toDoubleOrNull()

    fun openSystemSettings() {
        try {
            context.startActivity(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", context.packageName, null)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        } catch (_: Throwable) {
            try {
                context.startActivity(
                    Intent(Settings.ACTION_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            } catch (_: Throwable) {
                // No settings activity available — nothing else to do
            }
        }
    }

        fun toggleAdvanced() {
        viewModelScope.launch {
            val current = userPreferences.processingMode.first()
            if (current == AppProcessingMode.ADVANCED) {
                userPreferences.setProcessingMode(AppProcessingMode.EXPRESS)
            } else {
                // Turning Advanced on requires the accessibility service, so gate
                // it behind an explanation dialog that opens the system picker.
                _showAdvancedExplanation.value = true
            }
        }
    }

    /** Starts/stops the foreground engine service and persists the preference. */
    fun toggleEngine() {
        viewModelScope.launch {
            val current = userPreferences.engineEnabled.first()
            userPreferences.setEngineEnabled(!current)
            if (!current) {
                EngineService.start(context.applicationContext)
            } else {
                EngineService.stop(context.applicationContext)
            }
        }
    }

    fun dismissAdvancedExplanation() {
        _showAdvancedExplanation.value = false
    }

    /** Confirmed the explanation dialog: enable Advanced + open the accessibility picker. */
    fun enableAdvancedMode() {
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

    fun togglePause() {
        viewModelScope.launch {
            val active = userPreferences.engageBotActive.first()
            userPreferences.setEngageBotActive(!active)
        }
    }

    private fun startOfDayMillis(): Long = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis

    private fun startOfWeekMillis(): Long = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
        add(Calendar.DAY_OF_YEAR, -((get(Calendar.DAY_OF_WEEK) + 5) % 7))
    }.timeInMillis
}
