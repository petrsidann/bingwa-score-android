package com.bingwascore.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

@HiltWorker
class DailyArchiveWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val transactionDao: TransactionDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val startToday = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }.timeInMillis

            val all = transactionDao.getAllTransactions().first()
            val old = all.filter { it.createdAt < startToday }
            if (old.isNotEmpty()) {
                // Save data to CSV first, then remove from active table
                val dir = File(applicationContext.getExternalFilesDir(null), "archives").apply { mkdirs() }
                val stamp = SimpleDateFormat("yyyyMMdd-HHmmss", Locale.getDefault()).format(Date())
                val csv = File(dir, "archive-$stamp.csv")
                val sb = StringBuilder("id,phone,offer,amount,status,date\n")
                old.forEach { t ->
                    sb.append("${t.id},${t.phoneNumber},${t.offerName},${t.amount},${t.status.name},${Date(t.createdAt)}\n")
                }
                csv.writeText(sb.toString())
                old.forEach { t -> transactionDao.deleteTransactionById(t.id) }
                Timber.d("DailyArchive: archived ${old.size} transactions to ${csv.name}")
            }
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "DailyArchiveWorker failed")
            Result.retry()
        }
    }
}

object DailyArchiveScheduler {
    fun schedule(context: Context) {
        val now = Calendar.getInstance()
        val nextMidnight = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            add(Calendar.DAY_OF_YEAR, 1)
        }
        val delay = nextMidnight.timeInMillis - now.timeInMillis
        val request = PeriodicWorkRequestBuilder<DailyArchiveWorker>(24, TimeUnit.HOURS)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("daily_archive", ExistingPeriodicWorkPolicy.KEEP, request)
    }
}
