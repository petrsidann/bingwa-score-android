package com.bingwascore.app.ui.transactions

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.TransactionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

/** Filter chips shown on the Transactions screen. */
enum class TransactionFilter(val label: String) {
    ALL("All"),
    TODAY("Today"),
    YESTERDAY("Yesterday"),
    LAST_7_DAYS("7d"),
    LAST_30_DAYS("30d"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    SCHEDULED("Scheduled"),
    UNMATCHED("Unmatched")
}

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _filter = MutableStateFlow(TransactionFilter.ALL)
    val filter: StateFlow<TransactionFilter> = _filter.asStateFlow()

    val transactions: StateFlow<List<Transaction>> =
        combine(transactionRepository.allTransactions, _filter) { list, filter ->
            val now = System.currentTimeMillis()
            list.filter { filter.matches(it, now) }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _events = MutableSharedFlow<String>(extraBufferCapacity = 1)
    val events: SharedFlow<String> = _events.asSharedFlow()

    fun setFilter(filter: TransactionFilter) {
        _filter.value = filter
    }

    /** Re-queue the transaction: back to PENDING with a bumped retry count. */
    fun retry(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.update(
                transaction.copy(
                    status = TransactionStatus.PENDING.value,
                    retryCount = transaction.retryCount + 1,
                    errorMessage = null,
                    scheduledAt = null
                )
            )
        }
    }

    /** Manually mark the transaction as completed. */
    fun complete(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.update(
                transaction.copy(
                    status = TransactionStatus.SUCCESSFUL.value,
                    errorMessage = null,
                    scheduledAt = null
                )
            )
        }
    }

    /** Push the transaction to tomorrow at 01:00. */
    fun schedule(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.update(
                transaction.copy(
                    status = TransactionStatus.SCHEDULED.value,
                    scheduledAt = tomorrowAtOneAm(System.currentTimeMillis()),
                    errorMessage = null
                )
            )
        }
    }

    fun delete(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.deleteById(transaction.id)
        }
    }

    /** Writes every transaction row to a CSV file in exports/ and toasts the result. */
    fun exportCsv() {
        viewModelScope.launch {
            try {
                val rows = transactionRepository.allTransactions.first()
                val dir = withContext(Dispatchers.IO) {
                    context.getExternalFilesDir(EXPORT_DIR)?.apply { if (!exists()) mkdirs() }
                } ?: throw IllegalStateException("External storage unavailable")
                val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                val file = File(dir, "bingwa_transactions_$stamp.csv")
                withContext(Dispatchers.IO) { file.writeText(buildCsv(rows)) }
                _events.tryEmit("Exported ${rows.size} transactions to exports/${file.name}")
            } catch (t: Throwable) {
                Timber.e(t, "CSV export failed")
                _events.tryEmit("Export failed: ${t.message ?: "unknown error"}")
            }
        }
    }

    private fun TransactionFilter.matches(transaction: Transaction, now: Long): Boolean {
        val statusOk = when (this) {
            TransactionFilter.COMPLETED -> transaction.status == TransactionStatus.SUCCESSFUL.value
            TransactionFilter.FAILED -> transaction.status == TransactionStatus.FAILED.value
            TransactionFilter.SCHEDULED -> transaction.status == TransactionStatus.SCHEDULED.value
            TransactionFilter.UNMATCHED -> transaction.status == TransactionStatus.UNMATCHED.value
            else -> true
        }
        if (!statusOk) return false
        return when (this) {
            TransactionFilter.TODAY -> transaction.createdAt >= startOfDay(now, 0)
            TransactionFilter.YESTERDAY -> transaction.createdAt >= startOfDay(now, -1) &&
                transaction.createdAt < startOfDay(now, 0)
            TransactionFilter.LAST_7_DAYS -> transaction.createdAt >= now - 7L * DAY_MILLIS
            TransactionFilter.LAST_30_DAYS -> transaction.createdAt >= now - 30L * DAY_MILLIS
            else -> true
        }
    }

    companion object {
        private const val EXPORT_DIR = "exports"
        private const val DAY_MILLIS = 24L * 60 * 60 * 1000

        private fun startOfDay(now: Long, dayOffset: Int): Long = Calendar.getInstance().apply {
            timeInMillis = now
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.DAY_OF_YEAR, dayOffset)
        }.timeInMillis

        private fun tomorrowAtOneAm(now: Long): Long = Calendar.getInstance().apply {
            timeInMillis = now
            add(Calendar.DAY_OF_YEAR, 1)
            set(Calendar.HOUR_OF_DAY, 1)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        private fun buildCsv(transactions: List<Transaction>): String {
            val iso = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
            val header = "id,phone,customer,offer,ussd,amount,commission,status," +
                "created_at,scheduled_at,mpesa_receipt,error,retries,auto_renewal"
            return header + "\n" + transactions.joinToString("\n") { tx ->
                listOf(
                    tx.id,
                    tx.phoneNumber,
                    tx.customerName.orEmpty(),
                    tx.offerName,
                    tx.ussdCode,
                    tx.amount.toString(),
                    tx.commission.toString(),
                    tx.status,
                    iso.format(Date(tx.createdAt)),
                    tx.scheduledAt?.let { iso.format(Date(it)) }.orEmpty(),
                    tx.mpesaReceipt.orEmpty(),
                    tx.errorMessage.orEmpty(),
                    tx.retryCount.toString(),
                    tx.isAutoRenewal.toString()
                ).joinToString(",") { csvEscape(it) }
            }
        }

        private fun csvEscape(value: String): String =
            if (value.contains(',') || value.contains('"') || value.contains('\n')) {
                "\"" + value.replace("\"", "\"\"") + "\""
            } else {
                value
            }
    }
}