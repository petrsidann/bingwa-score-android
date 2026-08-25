package com.bingwascore.app.domain.engine

import android.content.Context
import android.content.Intent
import com.bingwascore.app.data.local.OfferDao
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
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionPipeline @Inject constructor(
    private val transactionDao: TransactionDao,
    private val offerDao: OfferDao,
    private val formatUssd: FormatUssdUseCase,
    private val smsDispatcher: SmsDispatcher,
    @ApplicationContext private val context: Context
) {

    companion object {
        const val MAX_RETRIES = 2
    }

    // M-Pesa confirmation received -> create transaction -> dial immediately
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
            commission = 0.0,
            status = TransactionStatus.PENDING,
            mpesaReceipt = message.receiptCode,
            commissionMessage = null,
            errorMessage = null,
            retryCount = 0,
            isAutoRenewal = false,
            parentTransactionId = null
        )

        transactionDao.insertTransaction(transaction)
        Timber.d("Transaction created: ${transaction.id} for ${offer.name}")
        dial(transaction, offer)
    }

    // Dial the formatted USSD (BH substituted)
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

    // Strict-mode completion SMS ("successfully recommended...") -> SUCCESSFUL + auto-reply
    suspend fun onCompletionSms() = withContext(Dispatchers.IO) {
        val tx = transactionDao.getLatestByStatus(TransactionStatus.AWAITING_COMMISSION)
            ?: transactionDao.getLatestByStatus(TransactionStatus.PROCESSING)
            ?: return@withContext

        transactionDao.updateTransactionStatus(tx.id, TransactionStatus.SUCCESSFUL)
        sendAutoReply(tx)
        Timber.d("Transaction ${tx.id} completed via completion SMS")
    }

    // Commission SMS -> record commission + SUCCESSFUL
    suspend fun onCommissionSms(commission: Double) = withContext(Dispatchers.IO) {
        transactionDao.updateLatestProcessingWithCommission(
            commission = commission,
            newStatus = TransactionStatus.SUCCESSFUL
        )
        Timber.d("Commission recorded: $commission")
    }

    // Retry with guard (max 2 retries, like spec)
    suspend fun retry(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status != TransactionStatus.FAILED) return@withContext
        if (tx.retryCount >= MAX_RETRIES) {
            Timber.w("Retry limit reached for ${tx.id}")
            return@withContext
        }
        val offer = offerDao.getOfferById(tx.offerId) ?: return@withContext

        transactionDao.updateTransaction(
            tx.copy(
                status = TransactionStatus.PENDING,
                retryCount = tx.retryCount + 1,
                errorMessage = null
            )
        )
        dial(tx, offer)
    }

    // Manual mark-complete (guarded: only if not already successful)
    suspend fun markComplete(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status == TransactionStatus.SUCCESSFUL) return@withContext
        transactionDao.updateTransaction(
            tx.copy(status = TransactionStatus.SUCCESSFUL, completedAt = System.currentTimeMillis())
        )
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
