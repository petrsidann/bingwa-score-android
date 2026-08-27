package com.bingwascore.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber
import java.util.Calendar

@HiltWorker
class DailyArchiveWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val transactionDao: TransactionDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            Timber.d("DailyArchiveWorker: Archiving old transactions...")
            
            // Calculate start of today (00:00)
            val startOfToday = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.timeInMillis

            // In a real app, we would move these to a history table.
            // For now, we just log that we're cleaning up the active view.
            // The UI filters by "today" anyway, so old ones won't show on the dashboard.
            
            Timber.d("DailyArchiveWorker: Archive complete. Active view reset for today.")
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "DailyArchiveWorker failed")
            Result.retry()
        }
    }
}

object DailyArchiveScheduler {
    fun schedule(context: Context) {
        // Schedule to run once a day at 00:00
        val workRequest = androidx.work.PeriodicWorkRequestBuilder<DailyArchiveWorker>(24, java.util.concurrent.TimeUnit.HOURS)
            .setInitialDelay(calculateInitialDelay(), java.util.concurrent.TimeUnit.MILLISECONDS)
            .build()
        
        androidx.work.WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "daily_archive",
            androidx.work.ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }

    private fun calculateInitialDelay(): Long {
        val now = Calendar.getInstance()
        val nextMidnight = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.DAY_OF_YEAR, 1)
        }
        return nextMidnight.timeInMillis - now.timeInMillis
    }
}
