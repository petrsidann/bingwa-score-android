package com.bingwascore.app.workers

import android.content.Context
import android.content.Intent
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.engine.FormatUssdUseCase
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.services.UssdAutomationService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import timber.log.Timber
import java.util.UUID
import java.util.concurrent.TimeUnit

@HiltWorker
class AutoRenewalWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val transactionDao: TransactionDao,
    private val offerDao: OfferDao,
    private val formatUssd: FormatUssdUseCase
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val successful = transactionDao
                .getTransactionsByStatus(TransactionStatus.SUCCESSFUL)
                .first()

            val renewedIds = successful.mapNotNull { it.parentTransactionId }.toSet()

            successful
                .sortedByDescending { it.createdAt }
                .forEach { tx ->
                    val offer = offerDao.getOfferById(tx.offerId) ?: return@forEach
                    if (!offer.autoRenewable) return@forEach
                    if (renewedIds.contains(tx.id)) return@forEach

                    val dueAt = tx.createdAt + offer.validityHours * 3600_000L
                    if (System.currentTimeMillis() >= dueAt - 3600_000L) {
                        val renewal = Transaction(
                            id = UUID.randomUUID().toString(),
                            phoneNumber = tx.phoneNumber,
                            customerName = tx.customerName,
                            offerId = offer.id,
                            offerName = offer.name,
                            ussdCode = offer.ussdCode,
                            amount = offer.price.toDouble(),
                            status = TransactionStatus.PENDING,
                            isAutoRenewal = true,
                            parentTransactionId = tx.id
                        )
                        transactionDao.insertTransaction(renewal)

                        val code = formatUssd.format(offer.ussdCode, tx.phoneNumber)
                        applicationContext.startService(
                            Intent(applicationContext, UssdAutomationService::class.java).apply {
                                putExtra("USSD_CODE", code)
                                putExtra("TRANSACTION_ID", renewal.id)
                                putExtra("CUSTOMER_PHONE", tx.phoneNumber)
                            }
                        )
                        Timber.d("Auto-renewal fired for ${tx.phoneNumber}: ${offer.name}")
                    }
                }

            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "AutoRenewalWorker failed")
            Result.retry()
        }
    }
}

object AutoRenewalScheduler {
    fun schedule(context: Context) {
        val request = PeriodicWorkRequestBuilder<AutoRenewalWorker>(1, TimeUnit.HOURS).build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "auto_renewal",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }
}
