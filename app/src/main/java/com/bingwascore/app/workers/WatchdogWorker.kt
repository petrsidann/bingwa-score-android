package com.bingwascore.app.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.data.preferences.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Periodic liveness probe running every 15 minutes. If the EngineService has been
 * killed (and the user wants it running) it is restarted, and every WorkManager
 * periodic worker is re-enqueued so a process death can't silently lose them.
 */
class WatchdogWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val prefs = UserPreferences(applicationContext)
            val engineWanted = prefs.engineEnabled.first()

            if (engineWanted && !EngineService.isRunning) {
                EngineService.start(applicationContext)
                Timber.i("Watchdog: EngineService was down — restarted")
            } else {
                Timber.d("Watchdog: EngineService running=%s", EngineService.isRunning)
            }

            // Re-enqueue all periodic workers so none stay missing after a purge.
            Schedulers.scheduleAll(applicationContext)
            Timber.d("Watchdog: schedulers re-enqueued")

            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "WatchdogWorker failed")
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "watchdog_worker"

        fun schedule(context: Context) {
            try {
                WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                    WORK_NAME,
                    ExistingPeriodicWorkPolicy.KEEP,
                    PeriodicWorkRequestBuilder<WatchdogWorker>(15, TimeUnit.MINUTES).build()
                )
                Timber.i("WatchdogWorker scheduled every 15 minutes")
            } catch (t: Throwable) {
                Timber.e(t, "Failed to schedule WatchdogWorker")
            }
        }
    }
}
