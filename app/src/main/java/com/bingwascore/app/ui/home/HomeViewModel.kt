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

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    companion object {
        private const val BALANCE_USSD = "*144#"
        private const val BALANCE_REGEX = "Ksh\\.?\\s?([\\d,]+\\.\\d{2})"
    }

    private val _balance = MutableStateFlow(0.0)
    val balance: StateFlow<Double> = _balance.asStateFlow()

    private val _balanceLoading = MutableStateFlow(false)
    val balanceLoading: StateFlow<Boolean> = _balanceLoading.asStateFlow()

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    val advancedMode: StateFlow<Boolean> = userPreferences.processingMode
        .map { it == AppProcessingMode.ADVANCED }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    val botPaused: StateFlow<Boolean> = userPreferences.engageBotActive
        .map { !it }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    val successfulCount: StateFlow<Int> = transactionRepository
        .transactionsByStatus(TransactionStatus.SUCCESSFUL.value)
        .map { it.size }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val failedCount: StateFlow<Int> = transactionRepository
        .transactionsByStatus(TransactionStatus.FAILED.value)
        .map { it.size }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val airtimeUsedToday: StateFlow<Double> = transactionRepository.allTransactions
        .map { list ->
            val startOfDay = startOfDayMillis()
            list.filter {
                it.status == TransactionStatus.SUCCESSFUL.value && it.createdAt >= startOfDay
            }.sumOf { it.amount }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0.0)

    /** Commission per weekday (Monday-first, Mon..Sun) for the current calendar week. */
    val weeklyCommissionByDay: StateFlow<List<Double>> = transactionRepository.allTransactions
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

    val recentTransactions: StateFlow<List<Transaction>> = transactionRepository.allTransactions
        .map { it.take(5) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    init {
        viewModelScope.launch {
            _balance.value = userPreferences.airtimeBalance.first()
        }
    }

    /**
     * Dials *144# and parses the "Ksh 1,234.56" reply into a Double that is
     * cached in [UserPreferences]. Every path is guarded: missing permissions,
     * missing telephony hardware or malformed replies never crash the app.
     */
    @SuppressLint("MissingPermission")
    fun refreshBalance() {
        if (_balanceLoading.value) return
        _balanceLoading.value = true
        try {
            val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            if (telephony == null) {
                _balanceLoading.value = false
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
                        try {
                            parseBalance(response?.toString())?.let { parsed ->
                                _balance.value = parsed
                                viewModelScope.launch {
                                    userPreferences.setAirtimeBalance(parsed)
                                }
                            }
                        } catch (_: Throwable) {
                            // Malformed operator response — ignore
                        } finally {
                            _balanceLoading.value = false
                        }
                    }

                    override fun onReceiveUssdResponseFailed(
                        telephonyManager: TelephonyManager,
                        request: String?,
                        failureCode: Int
                    ) {
                        _balanceLoading.value = false
                    }
                },
                Handler(Looper.getMainLooper())
            )
        } catch (_: Throwable) {
            // SecurityException (permission not granted), no telephony hardware, etc.
            _balanceLoading.value = false
        }
    }

    private fun parseBalance(response: String?): Double? {
        if (response.isNullOrBlank()) return null
        return Regex(BALANCE_REGEX).find(response)
            ?.groupValues
            ?.get(1)
            ?.replace(",", "")
            ?.toDoubleOrNull()
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
            userPreferences.setProcessingMode(
                if (current == AppProcessingMode.ADVANCED) {
                    AppProcessingMode.EXPRESS
                } else {
                    AppProcessingMode.ADVANCED
                }
            )
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