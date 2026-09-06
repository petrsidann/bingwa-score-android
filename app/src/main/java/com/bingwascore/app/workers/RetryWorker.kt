package com.bingwascore.app.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bingwascore.app.domain.engine.TransactionPipeline
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import timber.log.Timber

/**
 * One-shot retry driver. Respected by [Schedulers.enqueueRetry] with an
 * initial delay of the offer's `retryIntervalMins`; loads the transaction by
 * id and lets the pipeline re-dial it through the normal automation flow.
 *
 * Survives process death (unlike the old in-memory coroutine delay), which is
 * exactly what a persistence-focused engine needs.
 */
class RetryWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface RetryEntryPoint {
        fun pipeline(): TransactionPipeline
    }

    override suspend fun doWork(): Result {
        val transactionId = inputData.getString(KEY_TX_ID) ?: run {
            Timber.e("RetryWorker started without a transaction id")
            return Result.failure()
        }
        return try {
            val entryPoint = EntryPointAccessors.fromApplication(
                applicationContext,
                RetryEntryPoint::class.java
            )
            entryPoint.pipeline().retry(transactionId)
            Timber.i("RetryWorker re-dialed transaction %s", transactionId)
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "RetryWorker failed for transaction %s", transactionId)
            Result.retry()
        }
    }

    companion object {
        const val KEY_TX_ID = "retry_tx_id"
        const val WORK_NAME_PREFIX = "tx_retry_"
    }
}