package com.bingwascore.app.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.showcase.DemoCatalog
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.BalanceReader
import com.bingwascore.app.services.EngineService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
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
        /** R5 — shared logcat tag for the whole USSD surface. */
        const val USSD_TAG = BalanceReader.TAG

        /**
         * POLISH P1 — the balance is ALWAYS read from the network now. This is
         * the sentence the agent sees when `*144#` cannot be issued or parsed.
         */
        const val BALANCE_UNAVAILABLE = BalanceReader.UNAVAILABLE_MESSAGE
    }

    /** R5 — every USSD log line carries this tag: db logcat -s USSD. */
    private val ussdTag = Timber.tag(USSD_TAG)

    /** R5 — the SIM the agent picked, cached so the balance read can use it sync. */
    private val simSelection: StateFlow<String> = userPreferences.simSelection
        .stateIn(viewModelScope, SharingStarted.Eagerly, UserPreferences.SIM_1)

    private val _balance = MutableStateFlow(0.0)
    val balance: StateFlow<Double> = _balance.asStateFlow()

    private val _balanceLoading = MutableStateFlow(false)
    val balanceLoading: StateFlow<Boolean> = _balanceLoading.asStateFlow()

    /**
     * POLISH P1 — why the balance could not be read, or null when it is fine.
     *
     * The Home screen renders this as a dark bubble with no action: a missing
     * permission is resolved by the themed prompt *before* the read is even
     * attempted, so by the time a failure reaches the agent the network itself
     * is what let them down.
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

    // ── POLISH P2 — credits + greeting ────────────────────────────────────────

    /**
     * POLISH P2 — one credit per **completed** bundle.
     *
     * Counted from live transactions rather than kept in a counter, so a credit
     * can never drift away from the sale that earned it (and deleting a
     * transaction, by mistake or on purpose, is reflected honestly).
     */
    val credits: StateFlow<Int> = transactionRepository.liveTransactions
        .map { list -> list.count { it.status == TransactionStatus.SUCCESSFUL.value } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    /** The ledger behind the credits bubble: the most recent completed sales. */
    val creditRows: StateFlow<List<CreditRow>> = transactionRepository.liveTransactions
        .map { list ->
            list.filter { it.status == TransactionStatus.SUCCESSFUL.value }
                .take(HomeChrome.MAX_CREDIT_ROWS)
                .map { tx ->
                    CreditRow(
                        title = tx.customerName?.takeIf { it.isNotBlank() } ?: tx.phoneNumber,
                        subtitle = "${tx.offerName} · ${tx.phoneNumber}",
                        amount = tx.commission
                    )
                }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /**
     * POLISH P2 — the greeting for this session.
     *
     * The rotation key is `dayOfYear + sessionIndex`: the line holds still for
     * the whole session (no flip on rotation, no flip on resume) and moves on
     * tomorrow, when it is a different day and deserves a different sentence.
     */
    private val _sessionIndex = MutableStateFlow(0)

    private val _greeting = MutableStateFlow(greetingForSession())
    val greeting: StateFlow<Pair<Greetings.Bucket, Greetings.Language>> = _greeting.asStateFlow()

    /** Called from the screen on resume so the bucket follows the clock. */
    fun refreshGreeting() {
        _greeting.value = Greetings.currentBucket() to
            Greetings.languageFor(Greetings.todayIndex(), _sessionIndex.value)
    }

    private fun greetingForSession(): Pair<Greetings.Bucket, Greetings.Language> =
        Greetings.currentBucket() to
            Greetings.languageFor(Greetings.todayIndex(), _sessionIndex.value)

    // Parity D — Recent Activity: last 5 live rows (DAO already ORDERs BY createdAt DESC).
    /**
     * POLISH P1 — reads the airtime balance from `*144#` and never lies about it.
     *
     * The manual "type the balance in" escape hatch is **gone**: a number the
     * agent typed is a number the network never confirmed, and one quietly wrong
     * balance is worse than an honest gap. [silent] is true for automatic passes
     * (foreground return, the 30-minute worker sweep) — those never raise a
     * toast, because a background refresh that complains is just noise.
     */
    fun refreshBalance(silent: Boolean = false) {
        // SHOWCASE S2 — in demo mode the balance is simulated; no USSD is dialled.
        if (DbNameHolder.showcaseMode) {
            simulatedBalanceRefresh()
            return
        }
        if (_balanceLoading.value) return
        _balanceLoading.value = true
        _balanceError.value = null

        // POLISH P1 — every read is silent *144# through the shared reader:
        // main looper, default-subscription fallback, exactly one retry.
        BalanceReader.read(context, simSelection.value) { outcome ->
            _balanceLoading.value = false
            when (outcome) {
                is BalanceReader.Outcome.Ok -> {
                    _balance.value = outcome.amount
                    viewModelScope.launch { userPreferences.setAirtimeBalance(outcome.amount) }
                }
                is BalanceReader.Outcome.Failed -> {
                    ussdTag.w("USSD: balance unavailable (%s)", outcome.reason)
                    if (!silent) _balanceError.value = outcome.reason
                }
            }
        }
    }

    /**
     * POLISH P1 — called when Home comes back to the foreground: the agent has
     * been selling bundles in another app (or on another screen) and the figure
     * on the money row must be the one that is true *now*.
     */
    fun onForeground() = refreshBalance(silent = true)

    /** SHOWCASE S2 — simulated *144#: a short pause, then a random-walk balance. */
    private fun simulatedBalanceRefresh() {
        if (_balanceLoading.value) return
        _balanceLoading.value = true
        viewModelScope.launch {
            delay(900)
            val next = DemoCatalog.simulatedBalance(_balance.value, java.util.Random(System.nanoTime()))
            _balance.value = next
            _balanceLoading.value = false
            userPreferences.setAirtimeBalance(next)
        }
    }

    /** POLISH P1 - the agent has seen the dark balance bubble; drop it. */
    fun consumeBalanceError() {
        _balanceError.value = null
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
        // POLISH P2 — bump the greeting's session counter once per cold start, so
        // the line is stable while the agent works and moves on tomorrow.
        viewModelScope.launch {
            val next = runCatching { userPreferences.greetingSession.first() }.getOrDefault(0) + 1
            _sessionIndex.value = next
            userPreferences.setGreetingSession(next)
            refreshGreeting()
        }
    }

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
