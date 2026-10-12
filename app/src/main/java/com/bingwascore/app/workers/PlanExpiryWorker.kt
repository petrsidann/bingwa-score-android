package com.bingwascore.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.PlanState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Stage 13 — the plan expiry sweep.
 *
 * When a plan's validity window closes, the credits bubble must stop lying:
 * it falls back to the earned-credit count the moment the plan lapses. This
 * worker runs twice a day and clears any expired plan from [UserPreferences],
 * which is the single source the Home bubble and My Plan hero read.
 *
 * Like [BalanceWorker], a failed sweep is deliberately not retried — the next
 * tick is the retry, and a lapsed plan is not an emergency.
 */
@HiltWorker
class PlanExpiryWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val userPreferences: UserPreferences
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        return try {
            val now = System.currentTimeMillis()
            val plan = userPreferences.planState.first()
            if (plan.isExpired(now)) {
                userPreferences.setPlanState(PlanState())
                Timber.i("PlanExpiryWorker: cleared expired plan %s", plan.planId)
            }
            Result.success()
        } catch (t: Throwable) {
            Timber.e(t, "PlanExpiryWorker failed")
            Result.success()
        }
    }

    companion object {
        const val WORK_NAME = "plan_expiry_worker"

        /** Twice a day: a lapsed plan never survives to the next morning. */
        const val INTERVAL_HOURS = 12L

        fun schedule(context: Context) {
            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                PeriodicWorkRequestBuilder<PlanExpiryWorker>(INTERVAL_HOURS, TimeUnit.HOURS)
                    .build()
            )
        }
    }
}