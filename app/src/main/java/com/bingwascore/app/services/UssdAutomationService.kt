package com.bingwascore.app.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.telephony.TelephonyManager
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.ProcessingActivity
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

    /** Every log line is tagged [ENGINE_TAG] so `adb logcat -s ENGINE` traces the dial. */
    private val log = Timber.tag(TransactionPipeline.ENGINE_TAG)

    /**
     * Per-offer personality resolved once per dial, read fresh from Room.
     *
     * This is what makes an offer "feel" like its owner configured it:
     * - [timeoutMillis] — the watchdog budget (ussdTimeoutSeconds * 1000).
     * - [strictMode] — the operator already recommended this bundle; never retry.
     * - [retries] / [retryIntervalMins] — how the pipeline reschedules failures.
     * - [retryOnConnectionProblem] — network failures are retryable regardless.
     */
    private data class OfferPersonality(
        val timeoutMillis: Long,
        val strictMode: Boolean,
        val retries: Int,
        val retryIntervalMins: Int,
        val retryOnConnectionProblem: Boolean
    ) {
        companion object {
            /** Used when the offer row cannot be read — never blocks the dial. */
            val DEFAULT = OfferPersonality(
                timeoutMillis = UssdAutomationService.DEFAULT_USSD_TIMEOUT_MILLIS,
                strictMode = false,
                retries = 0,
                retryIntervalMins = 5,
                retryOnConnectionProblem = false
            )
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            val ussdCode = intent?.getStringExtra(EXTRA_USSD_CODE)
            val transactionId = intent?.getStringExtra(EXTRA_TRANSACTION_ID)
            val customerPhone = intent?.getStringExtra(EXTRA_CUSTOMER_PHONE)

            if (ussdCode.isNullOrBlank() || transactionId.isNullOrBlank()) {
                log.w("UssdAutomationService started without required extras")
                stopSelf()
                return START_NOT_STICKY
            }

            log.i("USSD dial starting for %s (%s)", transactionId, ussdCode)

            // MEGA A — repaint the persistent notification to "Processing" for the
            // whole time a dial/SMS is in flight, then back to idle on finalize.
            EngineService.setProcessing(ProcessingActivity.DIALING)

            serviceScope.launch {
                try {
                    // Flip the freshly inserted PENDING transaction to PROCESSING so
                    // the row animates LIVE in Transactions while the USSD runs.
                    transactionRepository.getLiveTransaction(transactionId)?.let { transaction ->
                        transactionRepository.update(
                            transaction.copy(status = TransactionStatus.PROCESSING.value)
                        )
                    }
                } catch (t: Throwable) {
                    log.e(t, "Failed to mark transaction %s PROCESSING", transactionId)
                }
                runUssd(ussdCode, transactionId, customerPhone)
            }
        } catch (t: Throwable) {
            log.e(t, "UssdAutomationService crashed while handling intent")
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
        serviceScope.launch {
            val personality = resolvePersonality(transactionId)
            log.i(
                "dial tx=%s timeoutMs=%s strict=%s retries=%s",
                transactionId, personality.timeoutMillis,
                personality.strictMode, personality.retries
            )
            sendUssd(ussdCode, transactionId, personality)
        }
    }

    /**
     * Loads the offer behind [transactionId] and projects its 19 personality
     * fields onto the handful the dial itself needs. Any failure degrades to
     * [OfferPersonality.DEFAULT] so a missing offer row never blocks the dial.
     */
    private suspend fun resolvePersonality(transactionId: String): OfferPersonality {
        return try {
            val transaction = transactionRepository.getLiveTransaction(transactionId)
            val offer = transaction?.let { offerRepository.getOffer(it.offerId) }
            if (offer == null) {
                OfferPersonality.DEFAULT
            } else {
                OfferPersonality(
                    timeoutMillis = Offer.timeoutMillisFor(offer),
                    strictMode = offer.strictMode,
                    retries = if (offer.autoRetry) offer.numberOfRetries else 0,
                    retryIntervalMins = offer.retryIntervalMins,
                    retryOnConnectionProblem = offer.autoRetryConnectionProblems
                )
            }
        } catch (t: Throwable) {
            log.e(t, "Failed to read offer personality for %s", transactionId)
            OfferPersonality.DEFAULT
        }
    }

    private suspend fun sendUssd(
        ussdCode: String,
        transactionId: String,
        personality: OfferPersonality
    ) {
        try {
            val telephony = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
            if (telephony == null) {
                log.w("Telephony service unavailable for transaction %s", transactionId)
                finalizeTransaction(transactionId, TransactionStatus.FAILED, "Telephony service unavailable")
                stopSelf()
                return
            }

            startTimeoutWatchdog(transactionId, personality)

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
                            val status = classifyResponse(body, personality)
                            log.d("USSD response for %s -> %s: %s", transactionId, status.value, body)
                            finalizeTransaction(transactionId, status, null)
                        } catch (t: Throwable) {
                            log.e(t, "Failed handling USSD response for %s", transactionId)
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
                            log.w("USSD request failed for %s (code %d)", transactionId, failureCode)
                            finalizeTransaction(
                                transactionId,
                                TransactionStatus.FAILED,
                                "USSD request failed (code $failureCode)"
                            )
                        } catch (t: Throwable) {
                            log.e(t, "Failed handling USSD failure for %s", transactionId)
                        } finally {
                            stopSelf()
                        }
                    }
                },
                Handler(Looper.getMainLooper())
            )
        } catch (t: Throwable) {
            log.e(t, "sendUssdRequest threw for transaction %s", transactionId)
            finalizeTransaction(transactionId, TransactionStatus.FAILED, "USSD error: ${t.message}")
            stopSelf()
        }
    }

    /** Fails the transaction if the offer's USSD timeout elapses with no answer. */
    private fun startTimeoutWatchdog(transactionId: String, personality: OfferPersonality) {
        serviceScope.launch {
            try {
                delay(personality.timeoutMillis)
                if (finalized.compareAndSet(false, true)) {
                    log.w("USSD timeout for transaction %s", transactionId)
                    finalizeTransaction(transactionId, TransactionStatus.FAILED, "USSD session timed out")
                    stopSelf()
                }
            } catch (t: Throwable) {
                Timber.e(t, "Timeout watchdog failed for transaction %s", transactionId)
            }
        }
    }

    /**
     * Maps a raw USSD reply onto a [TransactionStatus] via [UssdResponses]
     * (exact SUCCESS regex + 10 failure literals, unit-tested on the JVM).
     *
     * The offer's personality then adjusts the verdict:
     * - `strictMode` turns ANY failure into FAILED_ALREADY_RECOMMENDED, because
     *   the agent asked us never to resell a bundle the operator already pushed.
     * - `autoRetryConnectionProblems` promotes a network-class failure to
     *   FAILED so the retry worker picks it up instead of dropping it.
     */
    private fun classifyResponse(
        response: String,
        personality: OfferPersonality
    ): TransactionStatus {
        val base = UssdResponses.classify(response)
        return when {
            base == TransactionStatus.SUCCESSFUL -> base
            personality.strictMode -> TransactionStatus.FAILED_ALREADY_RECOMMENDED
            personality.retryOnConnectionProblem &&
                base == TransactionStatus.FAILED &&
                UssdResponses.isConnectionProblem(response) -> TransactionStatus.FAILED
            else -> base
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
        // The dial is over — drop the notification back to its idle wording.
        EngineService.setProcessing(ProcessingActivity.IDLE)
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

        // Legacy keyword list kept for reference; classification lives in
        // UssdResponses (Parity Block B Hybrid truth).
        @Suppress("unused")
        private val FAILURE_KEYWORDS = listOf("failed", "error", "invalid", "not allowed")
    }
}
