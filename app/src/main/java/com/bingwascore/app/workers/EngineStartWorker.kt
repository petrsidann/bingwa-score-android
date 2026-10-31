package com.bingwascore.app.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AppForegroundGate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * STAGE 38 — one-shot deferral for an engine start that was requested while the
 * app was in the background.
 *
 * On Android 12+ a background process may not start a foreground service, so the
 * request cannot be honoured where it was made. This worker runs later on
 * WorkManager's schedule and promotes the engine as soon as an Activity has
 * become visible; until then it simply returns and the next launch revives the
 * engine through [EngineService.start] anyway.
 */
class EngineStartWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.Main) {
        try {
            if (EngineService.isRunning) return@withContext Result.success()
            if (!AppForegroundGate.isForeground) {
                Timber.d("Engine start still deferred — no visible Activity yet")
                return@withContext Result.success()
            }
            // An Activity is visible, so a foreground-service start is legal.
            EngineService.start(applicationContext)
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "EngineStartWorker failed")
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "engine_start_one_shot"

        fun enqueue(context: Context) {
            try {
                WorkManager.getInstance(context).enqueueUniqueWork(
                    WORK_NAME,
                    // KEEP: a start requested while this job is already queued or
                    // running must not stack another promotion attempt.
                    ExistingWorkPolicy.KEEP,
                    OneTimeWorkRequestBuilder<EngineStartWorker>().build()
                )
            } catch (t: Throwable) {
                Timber.e(t, "Failed to enqueue EngineStartWorker")
            }
        }
    }
}
