package com.bingwascore.app.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.content.pm.PackageManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.TransactionStatus
import androidx.core.content.ContextCompat
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.services.UssdResponses
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

        /** R5 — shared logcat tag for the whole USSD surface. */
        const val USSD_TAG = "USSD"

        private val BALANCE_PERMISSIONS = arrayOf(
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.CALL_PHONE
        )

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

    /** R5 — every USSD log line carries this tag: db logcat -s USSD. */
    private val ussdTag = Timber.tag(USSD_TAG)
    private val mainHandler = Handler(Looper.getMainLooper())

    /** R5 — the SIM the agent picked, cached so the balance read can use it sync. */
    private val simSelection: StateFlow<String> = userPreferences.simSelection
        .stateIn(viewModelScope, SharingStarted.Eagerly, UserPreferences.SIM_1)

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
     * REBRAND R5 — dials *144# and parses the "Airtime Bal: … Ksh 1,234.56"
     * reply into a Double cached in [UserPreferences] and emitted as [balance].
     *
     * The old version reported "failed code 1" verbatim and gave up. Now the
     * failure code becomes a sentence, a failure is retried exactly once on the
     * default subscription, and a second failure surfaces the reason so the agent
     * is never stuck at 0.00 with no way out.
     */
    @SuppressLint("MissingPermission")
    fun refreshBalance() {
        if (_balanceLoading.value) return
        _balanceLoading.value = true
        _balanceError.value = null

        val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
        if (telephony == null) {
            failBalance("Could not read your balance on this device")
            return
        }
        if (missingBalancePermissions().isNotEmpty()) {
            failBalance(GRANT_PHONE_PERMISSION)
            return
        }

        // R5 — Settings picks the SIM; the default subscription is the fallback.
        val requested = simSelection.value
        val defaultSub = runCatching { SubscriptionManager.getDefaultSubscriptionId() }.getOrDefault(-1)
        val preferredSub = resolveSimSubscription(requested, defaultSub)
        val scoped = preferredSub?.let { runCatching { telephony.createForSubscriptionId(it) }.getOrNull() }
            ?: telephony
        Timber.tag(USSD_TAG).i("USSD: balance request on subscription %s", preferredSub ?: defaultSub)

        sendBalanceRequest(scoped, "sim=$requested", onFailure = { code ->
            Timber.tag(USSD_TAG).w("USSD: balance failed on %s (code %d)", requested, code)
            if (preferredSub != null && preferredSub != defaultSub) {
                // Retry once on the default subscription before giving up.
                val fallback = runCatching { telephony.createForSubscriptionId(defaultSub) }
                    .getOrDefault(telephony)
                Timber.tag(USSD_TAG).i("USSD: retrying balance on default subscription %s", defaultSub)
                sendBalanceRequest(fallback, "default=$defaultSub", onFailure = { retryCode ->
                    failBalance(UssdResponses.failureReason(retryCode))
                })
            } else {
                failBalance(UssdResponses.failureReason(code))
            }
        })
    }

    /** Issues the USSD on the main looper, exactly like the dial path does. */
    private fun sendBalanceRequest(
        manager: TelephonyManager,
        label: String,
        onFailure: (Int) -> Unit
    ) {
        try {
            mainHandler.post {
                try {
                    manager.sendUssdRequest(
                        BALANCE_USSD,
                        object : TelephonyManager.UssdResponseCallback() {
                            override fun onReceiveUssdResponse(
                                telephonyManager: TelephonyManager,
                                request: String?,
                                response: CharSequence?
                            ) {
                                val parsed = parseBalance(response?.toString())
                                if (parsed == null) {
                                    Timber.tag(USSD_TAG).w("USSD: unreadable balance reply: %s", response)
                                    failBalance("Could not read the balance — try again")
                                    return
                                }
                                Timber.tag(USSD_TAG).i("USSD: balance ok (%s) = %.2f", label, parsed)
                                _balance.value = parsed
                                _balanceLoading.value = false
                                viewModelScope.launch { userPreferences.setAirtimeBalance(parsed) }
                            }

                            override fun onReceiveUssdResponseFailed(
                                telephonyManager: TelephonyManager,
                                request: String?,
                                failureCode: Int
                            ) {
                                onFailure(failureCode)
                            }
                        },
                        mainHandler
                    )
                } catch (t: Throwable) {
                    Timber.e(t, "USSD: balance request threw")
                    failBalance("Could not read the balance — try again")
                }
            }
        } catch (t: Throwable) {
            Timber.e(t, "USSD: could not post balance request")
            failBalance("Could not read the balance — try again")
        }
    }

    /** Maps "SIM 1" / "SIM 2" onto a real subscription id, or null to use default. */
    private fun resolveSimSubscription(selected: String, defaultSub: Int): Int? {
        if (selected != UserPreferences.SIM_2) return defaultSub
        val slots = runCatching {
            context.getSystemService(SubscriptionManager::class.java)?.activeSubscriptionInfoList
        }.getOrNull()
        return slots?.getOrNull(1)?.subscriptionId
            ?.takeIf { it != SubscriptionManager.INVALID_SUBSCRIPTION_ID }
    }

    private fun missingBalancePermissions(): List<String> = BALANCE_PERMISSIONS.filter {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }

    /**
     * R5 — manual entry fallback: when the network will not answer, the agent can
     * type the balance they already know and the app stops lying about it.
     */
    fun setManualBalance(value: Double) {
        if (value <= 0.0) return
        viewModelScope.launch {
            _balance.value = value
            userPreferences.setAirtimeBalance(value)
            _balanceError.value = null
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
