package com.bingwascore.app.domain.engine

import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsManager
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.AutoReplyRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The engine. Receives parsed SMS events from
 * [com.bingwascore.app.receivers.SmsBroadcastReceiver] and drives the whole
 * purchase lifecycle: classify inbound M-Pesa money, match an offer, persist
 * the transaction, dial the USSD code through [UssdAutomationService],
 * finalize the outcome and auto-reply.
 *
 * Every public method is safe to call from any thread and swallows its own
 * exceptions — a crashed pipeline must never take the SMS receiver down.
 */
@Singleton
class TransactionPipeline @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository,
    private val offerRepository: OfferRepository,
    private val customerRepository: CustomerRepository,
    private val autoReplyRepository: AutoReplyRepository,
    private val userPreferences: UserPreferences,
    private val engageBot: EngageBotSessionLifecycle
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    // ------------------------------------------------------------------
    // Inbound entry points
    // ------------------------------------------------------------------

    /**
     * An M-Pesa credit landed. Blacklist check -> CANCELLED + reply; paused
     * bot -> PAUSED + reply; no offer matching the price -> UNMATCHED + reply;
     * recent successful duplicate -> engage/fallback; else insert PENDING and
     * kick off the USSD automation.
     */
    suspend fun onMpesaReceived(sender: String, body: String) {
        try {
            val parsed = parseMpesa(body) ?: run {
                Timber.w("M-Pesa SMS could not be parsed: %s", body)
                return
            }
            val phone = parsed.phone ?: run {
                Timber.w("M-Pesa SMS without customer phone ignored")
                return
            }
            val amount = parsed.amount ?: run {
                Timber.w("M-Pesa SMS without amount ignored")
                return
            }

            // 1. Blacklist check
            val customer = customerRepository.getCustomerOnce(phone)
            if (customer?.isBlacklisted == true) {
                record(phone, parsed.name, amount, TransactionStatus.CANCELLED, null, parsed)
                sendReply(
                    phone, amount, offerName = "", mpesaCode = parsed.receipt.orEmpty(),
                    firstName = parsed.name?.firstName(), type = TransactionStatus.CANCELLED.value
                )
                return
            }

            // 2. Paused bot check (paused == engage bot switch off)
            if (!engageBot.isEnabled()) {
                record(phone, parsed.name, amount, TransactionStatus.PAUSED, null, parsed)
                sendReply(
                    phone, amount, offerName = "", mpesaCode = parsed.receipt.orEmpty(),
                    firstName = parsed.name?.firstName(), type = TransactionStatus.PAUSED.value
                )
                return
            }

            // 3. Offer match by price
            val offer = offerRepository.getOfferByPriceOnce(amount.toInt())
            if (offer == null) {
                record(phone, parsed.name, amount, TransactionStatus.UNMATCHED, null, parsed)
                sendReply(
                    phone, amount, offerName = "", mpesaCode = parsed.receipt.orEmpty(),
                    firstName = parsed.name?.firstName(), type = TransactionStatus.UNMATCHED.value
                )
                return
            }

            // 4. Duplicate recent successful -> hand to engage bot / fallback reply
            val duplicates = transactionRepository.getRecentSuccessfulOnce(
                phone, amount, System.currentTimeMillis() - DUPLICATE_WINDOW_MILLIS
            )
            if (duplicates.isNotEmpty()) {
                Timber.i("Duplicate purchase from %s — routing to engage bot", phone)
                engageBot.engageForTransaction(
                    phone, parsed.name, amount, parsed.receipt ?: duplicates.first().id
                )
                sendReply(
                    phone, amount, offerName = offer.name,
                    mpesaCode = parsed.receipt.orEmpty(),
                    firstName = parsed.name?.firstName(),
                    type = TransactionStatus.FAILED_ALREADY_RECOMMENDED.value
                )
                return
            }

            // 5. Fresh sale -> insert PENDING and dial
            val transaction = Transaction(
                id = parsed.receipt ?: "TX-${UUID.randomUUID()}",
                phoneNumber = phone,
                customerName = parsed.name,
                offerId = offer.id,
                offerName = offer.name,
                ussdCode = offer.ussdCode,
                amount = amount,
                commission = 0.0,
                status = TransactionStatus.PENDING.value,
                createdAt = System.currentTimeMillis(),
                mpesaReceipt = parsed.receipt
            )
            transactionRepository.insert(transaction)
            Timber.i("PENDING transaction %s for %s (%s)", transaction.id, phone, offer.name)
            startUssdAutomation(transaction)
        } catch (t: Throwable) {
            Timber.e(t, "onMpesaReceived failed")
        }
    }

    /** Safaricom commission summary — fold into the tracked balance. */
    suspend fun onCommissionSms(amount: Double?) {
        try {
            if (amount == null || amount <= 0.0) return
            val current = userPreferences.airtimeBalance.first()
            userPreferences.setAirtimeBalance(current + amount)
            Timber.i("Commission received: Ksh %.2f (balance now %.2f)", amount, current + amount)
        } catch (t: Throwable) {
            Timber.e(t, "onCommissionSms failed")
        }
    }

    /** Safaricom "successfully recommended" confirmation — finalize whatever is in flight. */
    suspend fun onCompletionSms() {
        try {
            val inFlight = transactionRepository
                .transactionsByStatus(TransactionStatus.PROCESSING.value)
                .first()
                .firstOrNull()
                ?: transactionRepository
                    .transactionsByStatus(TransactionStatus.PENDING.value)
                    .first()
                    .firstOrNull()
            if (inFlight == null) {
                Timber.d("Completion SMS received with no in-flight transaction")
                return
            }
            onUssdSuccess(inFlight.id)
        } catch (t: Throwable) {
            Timber.e(t, "onCompletionSms failed")
        }
    }

    // ------------------------------------------------------------------
    // USSD outcome callbacks (called by UssdAutomationService)
    // ------------------------------------------------------------------

    suspend fun onUssdSuccess(transactionId: String) {
        try {
            val transaction = transactionRepository.getTransaction(transactionId) ?: return
            transactionRepository.update(
                transaction.copy(
                    status = TransactionStatus.SUCCESSFUL.value,
                    errorMessage = null
                )
            )
            Timber.i("Transaction %s SUCCESSFUL", transactionId)
            sendReply(
                transaction.phoneNumber, transaction.amount, transaction.offerName,
                transaction.mpesaReceipt ?: transaction.id, transaction.customerName?.firstName(),
                TransactionStatus.SUCCESSFUL.value
            )
            // Completed sale -> open the engage bot conversation if enabled.
            engageBot.engageForTransaction(
                transaction.phoneNumber,
                transaction.customerName,
                transaction.amount,
                transaction.id
            )
        } catch (t: Throwable) {
            Timber.e(t, "onUssdSuccess failed for %s", transactionId)
        }
    }

    suspend fun onUssdFailed(transactionId: String, errorMessage: String?) {
        try {
            val transaction = transactionRepository.getTransaction(transactionId) ?: return
            val offer = offerRepository.getOffer(transaction.offerId)
            val canRetry = offer?.autoRetry == true &&
                transaction.retryCount < offer.numberOfRetries.coerceAtLeast(0)

            if (canRetry) {
                val next = transaction.copy(
                    retryCount = transaction.retryCount + 1,
                    status = TransactionStatus.PENDING.value,
                    errorMessage = errorMessage ?: transaction.errorMessage
                )
                transactionRepository.update(next)
                Timber.i(
                    "Auto-retry %d for %s in %d mins",
                    next.retryCount, transactionId, offer.retryIntervalMins
                )
                scope.launch {
                    try {
                        delay(offer.retryIntervalMins * 60_000L)
                        startUssdAutomation(next)
                    } catch (t: Throwable) {
                        Timber.e(t, "Auto-retry failed for %s", transactionId)
                    }
                }
            } else {
                transactionRepository.update(
                    transaction.copy(
                        status = TransactionStatus.FAILED.value,
                        errorMessage = errorMessage ?: transaction.errorMessage
                    )
                )
                Timber.i("Transaction %s FAILED", transactionId)
                sendReply(
                    transaction.phoneNumber, transaction.amount, transaction.offerName,
                    transaction.mpesaReceipt ?: transaction.id, transaction.customerName?.firstName(),
                    TransactionStatus.FAILED.value
                )
            }
        } catch (t: Throwable) {
            Timber.e(t, "onUssdFailed failed for %s", transactionId)
        }
    }

    suspend fun onAlreadyRecommended(transactionId: String) {
        try {
            val transaction = transactionRepository.getTransaction(transactionId) ?: return
            transactionRepository.update(
                transaction.copy(status = TransactionStatus.FAILED_ALREADY_RECOMMENDED.value)
            )
            Timber.i("Transaction %s ALREADY_RECOMMENDED", transactionId)
            sendReply(
                transaction.phoneNumber, transaction.amount, transaction.offerName,
                transaction.mpesaReceipt ?: transaction.id, transaction.customerName?.firstName(),
                TransactionStatus.FAILED_ALREADY_RECOMMENDED.value
            )
        } catch (t: Throwable) {
            Timber.e(t, "onAlreadyRecommended failed for %s", transactionId)
        }
    }

    // ------------------------------------------------------------------
    // Control surface
    // ------------------------------------------------------------------

    /** Re-dials a failed/pending transaction, bumping its retry count. */
    suspend fun retry(transactionId: String) {
        try {
            val transaction = transactionRepository.getTransaction(transactionId) ?: return
            val next = transaction.copy(
                status = TransactionStatus.PENDING.value,
                retryCount = transaction.retryCount + 1,
                errorMessage = null
            )
            transactionRepository.update(next)
            startUssdAutomation(next)
            Timber.i("Manual retry queued for %s", transactionId)
        } catch (t: Throwable) {
            Timber.e(t, "retry failed for %s", transactionId)
        }
    }

    /** Marks a transaction SUCCESSFUL without triggering replies (pollers/cron). */
    suspend fun markComplete(transactionId: String) {
        try {
            val transaction = transactionRepository.getTransaction(transactionId) ?: return
            if (transaction.status != TransactionStatus.SUCCESSFUL.value) {
                transactionRepository.update(
                    transaction.copy(status = TransactionStatus.SUCCESSFUL.value)
                )
                Timber.i("Transaction %s marked complete", transactionId)
            }
        } catch (t: Throwable) {
            Timber.e(t, "markComplete failed for %s", transactionId)
        }
    }

    /** Kicks every SCHEDULED transaction whose time has come. */
    suspend fun processDueScheduled() {
        try {
            transactionRepository.getDueScheduledOnce(System.currentTimeMillis())
                .forEach { scheduled ->
                    val next = scheduled.copy(status = TransactionStatus.PENDING.value)
                    transactionRepository.update(next)
                    startUssdAutomation(next)
                    Timber.i("Processing scheduled transaction %s", next.id)
                }
        } catch (t: Throwable) {
            Timber.e(t, "processDueScheduled failed")
        }
    }

    // ------------------------------------------------------------------
    // Reply engine
    // ------------------------------------------------------------------

    /**
     * Sends the active AutoReply template of [type] to [phone] with the
     * standard placeholders filled in. Falls back to a canned message when
     * no active template matches.
     */
    suspend fun sendReply(
        phone: String,
        amount: Double,
        offerName: String,
        mpesaCode: String,
        firstName: String?,
        type: String
    ) {
        try {
            val template = autoReplyRepository.getActive().firstOrNull { it.type == type }
            val message = fillPlaceholders(
                template?.message ?: fallbackFor(type),
                firstName, phone, amount, offerName, mpesaCode
            )
            sendSms(phone, message)
        } catch (t: Throwable) {
            Timber.e(t, "sendReply failed for %s (%s)", phone, type)
        }
    }

    private fun fillPlaceholders(
        message: String,
        firstName: String?,
        phone: String,
        amount: Double,
        offerName: String,
        mpesaCode: String
    ): String = message
        .replace("<firstName>", firstName ?: "customer")
        .replace("<phone>", phone)
        .replace("<amount>", formatAmount(amount))
        .replace("<offerName>", offerName)
        .replace("<mpesaCode>", mpesaCode)

    private fun fallbackFor(type: String): String = when (type) {
        TransactionStatus.SUCCESSFUL.value ->
            "Your bundle is live. Asante for choosing Bingwa Score!"
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value ->
            "That number already has this bundle. No double charging today."
        TransactionStatus.FAILED.value ->
            "We could not complete your bundle purchase. We will retry shortly."
        TransactionStatus.UNMATCHED.value ->
            "That bundle is temporarily unavailable. Please try again later."
        TransactionStatus.PAUSED.value ->
            "Your auto-renewal is paused. Reply RESUME to turn it back on."
        TransactionStatus.CANCELLED.value ->
            "You have been unsubscribed from Bingwa Score messages."
        else -> "Thank you for choosing Bingwa Score."
    }

    private fun sendSms(phone: String, body: String) {
        try {
            val smsManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                context.getSystemService(SmsManager::class.java)
            } else {
                @Suppress("DEPRECATION")
                SmsManager.getDefault()
            }
            if (smsManager == null) {
                Timber.w("SmsManager unavailable — reply not sent to %s", phone)
                return
            }
            smsManager.sendTextMessage(phone, null, body, null, null)
            Timber.d("Reply sent to %s: %s", phone, body)
        } catch (t: Throwable) {
            // Missing SEND_SMS runtime permission, no SIM, invalid number, etc.
            Timber.e(t, "Failed to send reply to %s", phone)
        }
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    private fun startUssdAutomation(transaction: Transaction) {
        try {
            context.startService(
                Intent(context, UssdAutomationService::class.java)
                    .putExtra(UssdAutomationService.EXTRA_USSD_CODE, transaction.ussdCode)
                    .putExtra(UssdAutomationService.EXTRA_TRANSACTION_ID, transaction.id)
                    .putExtra(UssdAutomationService.EXTRA_CUSTOMER_PHONE, transaction.phoneNumber)
            )
        } catch (t: Throwable) {
            Timber.e(t, "Failed to start USSD automation for %s", transaction.id)
        }
    }

    private suspend fun record(
        phone: String,
        name: String?,
        amount: Double,
        status: TransactionStatus,
        offer: Offer?,
        parsed: ParsedMpesa
    ) {
        try {
            transactionRepository.insert(
                Transaction(
                    id = parsed.receipt ?: "TX-${UUID.randomUUID()}",
                    phoneNumber = phone,
                    customerName = name,
                    offerId = offer?.id ?: "",
                    offerName = offer?.name ?: "",
                    ussdCode = offer?.ussdCode ?: "",
                    amount = amount,
                    commission = 0.0,
                    status = status.value,
                    createdAt = System.currentTimeMillis(),
                    mpesaReceipt = parsed.receipt
                )
            )
        } catch (t: Throwable) {
            Timber.e(t, "Failed to record %s transaction", status.value)
        }
    }

    private fun formatAmount(amount: Double): String =
        if (amount == amount.toLong().toDouble()) amount.toLong().toString()
        else String.format(java.util.Locale.ROOT, "%.1f", amount)

    private fun String.firstName(): String =
        trim().split(Regex("\\s+")).firstOrNull() ?: this

    // ------------------------------------------------------------------
    // M-Pesa parsing
    // ------------------------------------------------------------------

    data class ParsedMpesa(
        val receipt: String?,
        val phone: String?,
        val name: String?,
        val amount: Double?
    )

    private fun parseMpesa(body: String): ParsedMpesa? {
        val receipt = receiptRegex.find(body)?.groupValues?.get(1)
        val amount = amountRegex.find(body)
            ?.groupValues?.get(1)?.replace(",", "")?.toDoubleOrNull()
        val phone = body.findKenyanPhone()
        val name = nameRegex.find(body)?.groupValues?.get(1)?.trim()
        if (receipt == null && amount == null && phone == null) return null
        return ParsedMpesa(receipt, phone, name, amount)
    }

    /** Best-effort extraction of a Kenyan customer number (07.. / 2547.. / +2547..). */
    private fun String.findKenyanPhone(): String? =
        phoneRegex.findAll(this)
            .map { it.groupValues[1] }
            .firstOrNull { it.length == 9 && (it.startsWith("7") || it.startsWith("1")) }
            ?.let { "0$it" }

    companion object {
        /** How far back a duplicate check looks. */
        private const val DUPLICATE_WINDOW_MILLIS = 12L * 60 * 60 * 1000

        // UHNRD47VMC Confirmed...
        private val receiptRegex =
            Regex("([A-Z0-9]{10})\\s*Confirmed", RegexOption.IGNORE_CASE)

        // KSH20.00 / Ksh 1,825.1
        private val amountRegex =
            Regex("KSH?\\s*([0-9][0-9,]*(?:\\.[0-9]+)?)", RegexOption.IGNORE_CASE)

        // group(1) = the 9 subscriber digits
        private val phoneRegex = Regex("(?:(?:\\+?254)|0)?([17]\\d{8})")

        // ...received from JOHN DOE 0712345678...
        private val nameRegex =
            Regex("from\\s+([A-Z0-9 .'&-]+?)\\s+(?:(?:\\+?254)|0)?[17]\\d{8}", RegexOption.IGNORE_CASE)
    }
}
