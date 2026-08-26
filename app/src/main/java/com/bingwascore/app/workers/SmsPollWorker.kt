package com.bingwascore.app.workers

import android.content.Context
import android.content.SharedPreferences
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bingwascore.app.domain.sms.MessageRouter
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class SmsPollWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val router: MessageRouter
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val prefs: SharedPreferences = applicationContext
                .getSharedPreferences("sms_poll", Context.MODE_PRIVATE)
            val lastPoll = prefs.getLong("last_poll", 0L)
            val now = System.currentTimeMillis()

            val cursor = applicationContext.contentResolver.query(
                android.provider.Telephony.Sms.Inbox.CONTENT_URI,
                arrayOf("address", "body", "date"),
                "date > ?",
                arrayOf(lastPoll.toString()),
                "date ASC"
            )

            cursor?.use {
                while (it.moveToNext()) {
                    val address = it.getString(0) ?: continue
                    val body = it.getString(1) ?: continue
                    router.route(address, body)
                }
            }

            prefs.edit().putLong("last_poll", now).apply()
            Timber.d("SmsPollWorker completed")
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "SmsPollWorker failed")
            Result.retry()
        }
    }
}

object SmsPollScheduler {
    fun schedule(context: Context) {
        val request = androidx.work.PeriodicWorkRequestBuilder<SmsPollWorker>(15, java.util.concurrent.TimeUnit.MINUTES)
            .build()
        androidx.work.WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "sms_poll",
            androidx.work.ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }
}
