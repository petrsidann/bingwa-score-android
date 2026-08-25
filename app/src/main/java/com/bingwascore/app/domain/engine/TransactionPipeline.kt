package com.bingwascore.app.domain.engine

import android.content.Context
import android.content.Intent
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.OfferTransitionRuleDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.domain.sms.MpesaMessage
import com.bingwascore.app.domain.sms.SmsDispatcher
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.Calendar
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionPipeline @Inject constructor(
    private val transactionDao: TransactionDao,
    private val offerDao: OfferDao,
    private val ruleDao: OfferTransitionRuleDao,
    private val formatUssd: FormatUssdUseCase,
    private val smsDispatcher: SmsDispatcher,
    @ApplicationContext private val context: Context
) {

    companion object {
        const val MAX_RETRIES = 2
    }

    suspend fun onMpesaReceived(message: MpesaMessage) = withContext(Dispatchers.IO) {
        val offer = offerDao.getOfferByPrice(message.amountInt)
        if (offer == null) {
            Timber.w("No active offer matches KES ${message.amountInt}")
            return@withContext
        }

        val transaction = Transaction(
            id = UUID.randomUUID().toString(),
            phoneNumber = message.phoneNumber,
            customerName = message.senderName,
            offerId = offer.id,
            offerName = offer.name,
            ussdCode = offer.ussdCode,
            amount = message.amountInt.toDouble(),
            status = TransactionStatus.PENDING,
            mpesaReceipt = message.receiptCode
        )

        transactionDao.insertTransaction(transaction)
        Timber.d("Transaction created: ${transaction.id} for ${offer.name}")
        dial(transaction, offer)
    }

    private suspend fun dial(transaction: Transaction, offer: Offer) {
        val code = formatUssd.format(offer.ussdCode, transaction.phoneNumber)
        transactionDao.updateTransactionStatus(transaction.id, TransactionStatus.PROCESSING)

        val intent = Intent(context, UssdAutomationService::class.java).apply {
            putExtra("USSD_CODE", code)
            putExtra("TRANSACTION_ID", transaction.id)
            putExtra("CUSTOMER_PHONE", transaction.phoneNumber)
        }
        context.startService(intent)
        Timber.d("Dialing $code for ${transaction.id}")
    }

    // "Already recommended" detected -> fallback rule OR auto-reschedule to 01:00
    suspend fun onUssdAlreadyRecommended(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        transactionDao.updateTransactionStatus(tx.id, TransactionStatus.FAILED_ALREADY_RECOMMENDED)
        Timber.d("Transaction ${tx.id} already recommended")

        val rule = ruleDao
            .getRulesFor(tx.offerId, TransactionStatus.FAILED_ALREADY_RECOMMENDED.name)
            .firstOrNull()

        if (rule != null) {
            val nextOffer = offerDao.getOfferById(rule.nextOfferId)
            if (nextOffer != null && nextOffer.isActive) {
                val fallback = tx.copy(
                    id = UUID.randomUUID().toString(),
                    offerId = nextOffer.id,
                    offerName = nextOffer.name,
                    ussdCode = nextOffer.ussdCode,
                    amount = nextOffer.price.toDouble(),
                    status = TransactionStatus.PENDING,
                    retryCount = 0,
                    parentTransactionId = tx.id,
                    errorMessage = null
                )
                transactionDao.insertTransaction(fallback)
                dial(fallback, nextOffer)
                Timber.d("Fallback rule fired: ${nextOffer.name}")
                return@withContext
            }
        }

        val offer = offerDao.getOfferById(tx.offerId)
        if (offer?.autoReschedule == true) {
            transactionDao.updateTransaction(
                tx.copy(
                    status = TransactionStatus.SCHEDULED,
                    scheduledAt = nextRunTime(offer.autoRescheduleRunTime)
                )
            )
            Timber.d("Auto-rescheduled for ${offer.autoRescheduleRunTime}")
        }
    }

    // Redial scheduled transactions whose time has come
    suspend fun processDueScheduled() = withContext(Dispatchers.IO) {
        val due = transactionDao.getDueScheduled(System.currentTimeMillis())
        due.forEach { tx ->
            val offer = offerDao.getOfferById(tx.offerId) ?: return@forEach
            transactionDao.updateTransaction(tx.copy(status = TransactionStatus.PENDING, scheduledAt = null))
            dial(tx, offer)
        }
    }

    suspend fun onCompletionSms() = withContext(Dispatchers.IO) {
        val tx = transactionDao.getLatestByStatus(TransactionStatus.AWAITING_COMMISSION)
            ?: transactionDao.getLatestByStatus(TransactionStatus.PROCESSING)
            ?: return@withContext

        transactionDao.updateTransactionStatus(tx.id, TransactionStatus.SUCCESSFUL)
        sendAutoReply(tx)
        Timber.d("Transaction ${tx.id} completed via completion SMS")
    }

    suspend fun onCommissionSms(commission: Double) = withContext(Dispatchers.IO) {
        transactionDao.updateLatestProcessingWithCommission(
            commission = commission,
            newStatus = TransactionStatus.SUCCESSFUL
        )
        Timber.d("Commission recorded: $commission")
    }

    suspend fun retry(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status != TransactionStatus.FAILED) return@withContext
        if (tx.retryCount >= MAX_RETRIES) return@withContext
        val offer = offerDao.getOfferById(tx.offerId) ?: return@withContext

        transactionDao.updateTransaction(
            tx.copy(status = TransactionStatus.PENDING, retryCount = tx.retryCount + 1, errorMessage = null)
        )
        dial(tx, offer)
    }

    suspend fun markComplete(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status == TransactionStatus.SUCCESSFUL) return@withContext
        transactionDao.updateTransaction(
            tx.copy(status = TransactionStatus.SUCCESSFUL, completedAt = System.currentTimeMillis())
        )
    }

    private fun nextRunTime(timeStr: String): Long {
        val cal = Calendar.getInstance()
        val parts = timeStr.split(":")
        cal.set(Calendar.HOUR_OF_DAY, parts.getOrNull(0)?.toIntOrNull() ?: 1)
        cal.set(Calendar.MINUTE, parts.getOrNull(1)?.toIntOrNull() ?: 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        if (cal.timeInMillis <= System.currentTimeMillis()) {
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        return cal.timeInMillis
    }

    private suspend fun sendAutoReply(tx: Transaction) {
        val offer = offerDao.getOfferById(tx.offerId) ?: return
        val template = offer.completionMessage ?: return
        if (!OfferSignature.hasPhonePlaceholder(template)) return

        smsDispatcher.send(
            destination = tx.phoneNumber,
            template = template,
            values = mapOf(
                "phone" to tx.phoneNumber,
                "amount" to tx.amount.toInt().toString(),
                "offerName" to tx.offerName,
                "mpesaCode" to (tx.mpesaReceipt ?: ""),
                "offerPrice" to tx.amount.toInt().toString()
            )
        )
    }
}
