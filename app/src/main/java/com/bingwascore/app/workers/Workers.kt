package com.bingwascore.app.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.engagebot.EngageBotSessionLifecycle
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Nightly housekeeping: exports every transaction older than today to a CSV
 * file, then clears them from the local database.
 */
class DailyArchiveWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val database = AppDatabase.getDatabase(applicationContext)
            val startOfToday = startOfTodayMillis()
            val expired = database.transactionDao().getOlderThan(startOfToday)

            if (expired.isEmpty()) {
                Timber.d("DailyArchive: nothing older than today")
                return@withContext Result.success()
            }

            val csv = exportCsv(expired)
            database.transactionDao().deleteOlderThan(startOfToday)
            Timber.i("DailyArchive: archived %d transactions to %s", expired.size, csv.absolutePath)
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "DailyArchiveWorker failed")
            Result.failure()
        }
    }

    private fun exportCsv(rows: List<Transaction>): File {
        val dir = applicationContext.getExternalFilesDir(null) ?: applicationContext.filesDir
        val file = File(dir, "archive_${archiveDateFormat.format(Date())}.csv")
        file.bufferedWriter().use { writer ->
            writer.appendLine(CSV_HEADER)
            rows.forEach { row ->
                writer.appendLine(
                    listOf(
                        row.id, row.phoneNumber, row.customerName.orEmpty(), row.offerId,
                        row.offerName, row.ussdCode, row.amount.toString(), row.commission.toString(),
                        row.status, row.createdAt.toString(), row.scheduledAt?.toString().orEmpty(),
                        row.mpesaReceipt.orEmpty(), row.errorMessage.orEmpty(),
                        row.retryCount.toString(), row.isAutoRenewal.toString(),
                        row.parentTransactionId.orEmpty()
                    ).joinToString(",") { csvEscape(it) }
                )
            }
        }
        return file
    }

    private fun csvEscape(value: String): String =
        if (value.contains(',') || value.contains('"') || value.contains('\n')) {
            "\"" + value.replace("\"", "\"\"") + "\""
        } else value

    private fun startOfTodayMillis(): Long =
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

    companion object {
        const val WORK_NAME = "daily_archive_worker"

        private const val CSV_HEADER =
            "id,phone,customer,offerId,offerName,ussdCode,amount,commission,status," +
                "createdAt,scheduledAt,mpesaReceipt,error,retryCount,isAutoRenewal,parentTx"

        private val archiveDateFormat = SimpleDateFormat("yyyyMMdd", Locale.US)
    }
}

/** Keeps the engage bot session table clean by expiring idle conversations. */
class EngageBotTimeoutWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface EngageBotEntryPoint {
        fun engageBot(): EngageBotSessionLifecycle
    }

    override suspend fun doWork(): Result = try {
        val entryPoint = EntryPointAccessors.fromApplication(
            applicationContext, EngageBotEntryPoint::class.java
        )
        entryPoint.engageBot().expireAll()
        Result.success()
    } catch (t: Throwable) {
        Timber.e(t, "EngageBotTimeoutWorker failed")
        Result.failure()
    }

    companion object {
        const val WORK_NAME = "engage_bot_timeout_worker"
    }
}

/**
 * Placeholder heartbeat for future SMS inbox polling. Deliberately a no-op:
 * the engine is push-driven via SmsBroadcastReceiver.
 */
class SmsPollWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        Timber.d("SmsPollWorker heartbeat (no-op)")
        return Result.success()
    }

    companion object {
        const val WORK_NAME = "sms_poll_worker"
    }
}

/** One place to register every periodic worker. Called from app start-up. */
object Schedulers {

    fun scheduleAll(context: Context) {
        try {
            scheduleDailyArchive(context)
            scheduleEngageBotTimeout(context)
            scheduleSmsPoll(context)
        } catch (t: Throwable) {
            Timber.e(t, "Failed to schedule workers")
        }
    }

    private fun scheduleDailyArchive(context: Context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            DailyArchiveWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<DailyArchiveWorker>(24, TimeUnit.HOURS).build()
        )
    }

    private fun scheduleEngageBotTimeout(context: Context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            EngageBotTimeoutWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<EngageBotTimeoutWorker>(15, TimeUnit.MINUTES).build()
        )
    }

    private fun scheduleSmsPoll(context: Context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            SmsPollWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<SmsPollWorker>(15, TimeUnit.MINUTES).build()
        )
    }
}
