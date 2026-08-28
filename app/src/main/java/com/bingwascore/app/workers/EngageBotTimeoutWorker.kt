package com.bingwascore.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.domain.engagebot.EngageBotSessionLifecycle
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber
import java.util.concurrent.TimeUnit

@HiltWorker
class EngageBotTimeoutWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val engageBot: EngageBotSessionLifecycle
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            engageBot.expireAll()
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "EngageBotTimeoutWorker failed")
            Result.retry()
        }
    }
}

object EngageBotTimeoutScheduler {
    fun schedule(context: Context) {
        val request = PeriodicWorkRequestBuilder<EngageBotTimeoutWorker>(5, TimeUnit.MINUTES).build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "engagebot_timeout", ExistingPeriodicWorkPolicy.KEEP, request
        )
    }
}
