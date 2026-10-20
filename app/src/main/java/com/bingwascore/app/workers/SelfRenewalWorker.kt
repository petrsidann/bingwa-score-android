package com.bingwascore.app.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.bingwascore.app.domain.engine.TransactionPipeline
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Stage 15 — Self-Renewal alarm.
 *
 * A renewal is a SCHEDULED ledger row (offer + phone + datetime). Arming one
 * enqueues a delayed one-shot for its exact `fireAt`; when it fires this worker
 * hands the due rows to [TransactionPipeline.processDueScheduled], which flips
 * them to PENDING and dials through the SAME USSD automation as a live sale.
 * On success the row becomes SUCCESSFUL and drops out of the Self-Renewal list
 * (it now lives in Completed transactions) — no special "remove" step needed.
 *
 * Survives process death (WorkManager), exactly like [RetryWorker].
 */
class SelfRenewalWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface SelfRenewalEntryPoint {
        fun pipeline(): TransactionPipeline
    }

    override suspend fun doWork(): Result {
        val transactionId = inputData.getString(KEY_TX_ID)
        return try {
            val entryPoint = EntryPointAccessors.fromApplication(
                applicationContext,
                SelfRenewalEntryPoint::class.java
            )
            // The pipeline picks up every SCHEDULED row whose time has come, so a
            // specific id is a fast-path hint and a blank id is a full sweep.
            entryPoint.pipeline().processDueScheduled()
            Timber.i("SelfRenewalWorker fired for %s", transactionId ?: "all due")
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "SelfRenewalWorker failed for %s", transactionId)
            Result.retry()
        }
    }

    companion object {
        const val KEY_TX_ID = "self_renewal_tx_id"
        const val WORK_NAME_PREFIX = "self_renewal_"

        /**
         * Arms the exact alarm for a scheduled renewal, firing after [delayMins]
         * minutes. REPLACE keeps a re-scheduled renewal from stacking alarms.
         */
        fun arm(context: Context, transactionId: String, delayMins: Long) {
            try {
                val request = OneTimeWorkRequestBuilder<SelfRenewalWorker>()
                    .setInputData(workDataOf(KEY_TX_ID to transactionId))
                    .setInitialDelay(delayMins.coerceAtLeast(0L), TimeUnit.MINUTES)
                    .build()
                WorkManager.getInstance(context).enqueueUniqueWork(
                    WORK_NAME_PREFIX + transactionId,
                    ExistingWorkPolicy.REPLACE,
                    request
                )
                Timber.i("Self-renewal %s armed in %d min(s)", transactionId, delayMins)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to arm self-renewal %s", transactionId)
            }
        }

        /** Cancels a pending alarm (e.g. the agent deleted the renewal). */
        fun cancel(context: Context, transactionId: String) {
            try {
                WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME_PREFIX + transactionId)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to cancel self-renewal %s", transactionId)
            }
        }
    }
}
