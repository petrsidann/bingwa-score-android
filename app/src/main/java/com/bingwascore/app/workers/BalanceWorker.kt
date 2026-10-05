package com.bingwascore.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.services.BalanceReader
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume

/**
 * POLISH P1 — the silent balance sweep.
 *
 * Runs `*144#` through [BalanceReader] every 30 minutes with **no UI at all**:
 * no dialog, no toast, no foreground service. The parsed figure is written to
 * [UserPreferences] so Home renders a fresh balance the moment the agent opens
 * it. A failed read is deliberately *not* retried by WorkManager — the next tick
 * in half an hour is the retry, and a storm of redials would eat airtime.
 */
@HiltWorker
class BalanceWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val userPreferences: UserPreferences
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        return try {
            val sim = runCatching { userPreferences.simSelection.first() }
                .getOrDefault(UserPreferences.SIM_1)
            val outcome = suspendCancellableCoroutine { continuation ->
                BalanceReader.read(applicationContext, sim) { continuation.resume(it) }
            }
            when (outcome) {
                is BalanceReader.Outcome.Ok -> {
                    userPreferences.setAirtimeBalance(outcome.amount)
                    Timber.i("BalanceWorker: refreshed to %.2f", outcome.amount)
                }
                is BalanceReader.Outcome.Failed ->
                    Timber.w("BalanceWorker: %s", outcome.reason)
            }
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "BalanceWorker failed")
            Result.success()
        }
    }

    companion object {
        const val WORK_NAME = "balance_refresh_worker"

        /** Half an hour: frequent enough to stay honest, cheap enough to ignore. */
        const val INTERVAL_MINUTES = 30L

        fun schedule(context: Context) {
            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                PeriodicWorkRequestBuilder<BalanceWorker>(INTERVAL_MINUTES, TimeUnit.MINUTES)
                    .build()
            )
        }
    }
}
