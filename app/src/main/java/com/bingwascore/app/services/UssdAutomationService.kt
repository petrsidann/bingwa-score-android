package com.bingwascore.app.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.telephony.TelephonyManager
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.engine.TransactionPipeline
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/**
 * Dials a single USSD bundle code for one transaction and records the outcome.
 *
 * Started with extras [EXTRA_USSD_CODE], [EXTRA_TRANSACTION_ID] and
 * [EXTRA_CUSTOMER_PHONE]. The response is classified as
 * [TransactionStatus.FAILED_ALREADY_RECOMMENDED], [TransactionStatus.FAILED]
 * or [TransactionStatus.SUCCESSFUL] and persisted through
 * [TransactionRepository]. A watchdog coroutine fails the transaction if the
 * offer's [com.bingwascore.app.data.local.Offer.ussdTimeoutMillis] elapses
 * before the network answers.
 */
@AndroidEntryPoint
class UssdAutomationService : Service() {

    @Inject lateinit var transactionRepository: TransactionRepository
    @Inject lateinit var offerRepository: OfferRepository
    @Inject lateinit var transactionPipeline: TransactionPipeline

    /** Cancellable scope for intent handling + watchdog, tied to the service lifetime. */
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    /**
     * Scope used only for final status writes. Deliberately NOT cancelled in
     * [onDestroy] so the last database update always lands even if the system
     * tears the short-lived service down mid-write.
     */
    private val writeScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val finalized = AtomicBoolean(false)

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            val ussdCode = intent?.getStringExtra(EXTRA_USSD_CODE)
            val transactionId = intent?.getStringExtra(EXTRA_TRANSACTION_ID)
            val customerPhone = intent?.getStringExtra(EXTRA_CUSTOMER_PHONE)

            if (ussdCode.isNullOrBlank() || transactionId.isNullOrBlank()) {
                Timber.w("UssdAutomationService started without required extras")
                stopSelf()
                return START_NOT_STICKY
            }

            Timber.d("USSD dial starting for %s (%s)", transactionId, ussdCode)

            serviceScope.launch {
                try {
                    // Flip the freshly inserted PENDING transaction to PROCESSING.
                    transactionRepository.getTransaction(transactionId)?.let { transaction ->
                        transactionRepository.update(
                            transaction.copy(status = TransactionStatus.PROCESSING.value)
                        )
                    }
                } catch (t: Throwable) {
                    Timber.e(t, "Failed to mark transaction %s PROCESSING", transactionId)
                }
                runUssd(ussdCode, transactionId, customerPhone)
            }
        } catch (t: Throwable) {
            Timber.e(t, "UssdAutomationService crashed while handling intent")
            intent?.getStringExtra(EXTRA_TRANSACTION_ID)?.let { transactionId ->
                finalizeTransaction(transactionId, TransactionStatus.FAILED, "Service error: ${t.message}")
            }
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        serviceScope.cancel()
        super.onDestroy()
    }

    private fun runUssd(ussdCode: String, transactionId: String, customerPhone: String?) {
        try {
            val telephony = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
            if (telephony == null) {
                Timber.w("Telephony service unavailable for transaction %s", transactionId)
                finalizeTransaction(transactionId, TransactionStatus.FAILED, "Telephony service unavailable")
                stopSelf()
                return
            }

            startTimeoutWatchdog(transactionId)

            telephony.sendUssdRequest(
                ussdCode,
                object : TelephonyManager.UssdResponseCallback() {
                    override fun onReceiveUssdResponse(
                        telephonyManager: TelephonyManager,
                        request: String?,
                        response: CharSequence?
                    ) {
                        try {
                            val body = response?.toString().orEmpty()
                            Timber.d("USSD response for %s: %s", transactionId, body)
                            finalizeTransaction(transactionId, classifyResponse(body), null)
                        } catch (t: Throwable) {
                            Timber.e(t, "Failed handling USSD response for %s", transactionId)
                            finalizeTransaction(transactionId, TransactionStatus.FAILED, "Response error: ${t.message}")
                        } finally {
                            stopSelf()
                        }
                    }

                    override fun onReceiveUssdResponseFailed(
                        telephonyManager: TelephonyManager,
                        request: String?,
                        failureCode: Int
                    ) {
                        try {
                            finalizeTransaction(
                                transactionId,
                                TransactionStatus.FAILED,
                                "USSD request failed (code $failureCode)"
                            )
                        } catch (t: Throwable) {
                            Timber.e(t, "Failed handling USSD failure for %s", transactionId)
                        } finally {
                            stopSelf()
                        }
                    }
                },
                Handler(Looper.getMainLooper())
            )
        } catch (t: Throwable) {
            Timber.e(t, "sendUssdRequest threw for transaction %s", transactionId)
            finalizeTransaction(transactionId, TransactionStatus.FAILED, "USSD error: ${t.message}")
            stopSelf()
        }
    }

    /** Fails the transaction if the offer's USSD timeout elapses with no answer. */
    private fun startTimeoutWatchdog(transactionId: String) {
        serviceScope.launch {
            try {
                delay(resolveTimeoutMillis(transactionId))
                if (finalized.compareAndSet(false, true)) {
                    Timber.w("USSD timeout for transaction %s", transactionId)
                    finalizeTransaction(transactionId, TransactionStatus.FAILED, "USSD session timed out")
                    stopSelf()
                }
            } catch (t: Throwable) {
                Timber.e(t, "Timeout watchdog failed for transaction %s", transactionId)
            }
        }
    }

    private suspend fun resolveTimeoutMillis(transactionId: String): Long {
        return try {
            val transaction = transactionRepository.getTransaction(transactionId)
            val offer = transaction?.let { offerRepository.getOffer(it.offerId) }
            offer?.ussdTimeoutMillis ?: DEFAULT_USSD_TIMEOUT_MILLIS
        } catch (t: Throwable) {
            Timber.e(t, "Failed to resolve offer timeout for transaction %s", transactionId)
            DEFAULT_USSD_TIMEOUT_MILLIS
        }
    }

    /**
     * Maps a raw USSD reply onto a [TransactionStatus]:
     * "already recommended" first, then generic failure keywords, else success.
     */
    private fun classifyResponse(response: String): TransactionStatus {
        val body = response.lowercase(Locale.ROOT)
        return when {
            body.contains("already recommended") -> TransactionStatus.FAILED_ALREADY_RECOMMENDED
            FAILURE_KEYWORDS.any { body.contains(it) } -> TransactionStatus.FAILED
            else -> TransactionStatus.SUCCESSFUL
        }
    }

    /**
     * Routes the terminal status into the pipeline: it persists the final
     * state, sends the matching auto-reply and runs engage/retry side
     * effects. Called at most once per service instance.
     */
    private fun finalizeTransaction(
        transactionId: String,
        status: TransactionStatus,
        errorMessage: String?
    ) {
        if (!finalized.compareAndSet(false, true)) return
        writeScope.launch {
            try {
                when (status) {
                    TransactionStatus.SUCCESSFUL ->
                        transactionPipeline.onUssdSuccess(transactionId)
                    TransactionStatus.FAILED_ALREADY_RECOMMENDED ->
                        transactionPipeline.onAlreadyRecommended(transactionId)
                    else ->
                        transactionPipeline.onUssdFailed(transactionId, errorMessage)
                }
            } catch (t: Throwable) {
                Timber.e(t, "Failed to persist final status for transaction %s", transactionId)
            }
        }
    }


    companion object {
        const val EXTRA_USSD_CODE = "USSD_CODE"
        const val EXTRA_TRANSACTION_ID = "TRANSACTION_ID"
        const val EXTRA_CUSTOMER_PHONE = "CUSTOMER_PHONE"

        private const val DEFAULT_USSD_TIMEOUT_MILLIS = 20_000L

        private val FAILURE_KEYWORDS = listOf("failed", "error", "invalid", "not allowed")
    }
}
