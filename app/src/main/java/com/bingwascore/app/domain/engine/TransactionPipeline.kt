package com.bingwascore.app.domain.engine

import android.content.Context
import android.content.Intent
import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.OfferTransitionRuleDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.domain.enums.AppState
import com.bingwascore.app.domain.enums.AutoReplyType
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
    private val autoReplyDao: AutoReplyDao,
    private val customerDao: CustomerDao,
    private val smsDispatcher: SmsDispatcher,
    private val settingsRepository: SettingsRepository,
    private val engageBot: EngageBotSessionLifecycle,
    @ApplicationContext private val context: Context
) {

    suspend fun onMpesaReceived(msg: MpesaMessage) = withContext(Dispatchers.IO) {
        val phone = normalize(msg.phoneNumber)
        val customer = customerDao.getCustomerByPhone(phone)

        if (customer?.isBlacklisted == true) {
            val tx = createTx(msg, null, TransactionStatus.CANCELLED)
            sendReply(tx, AutoReplyType.CUSTOMER_BLACKLISTED)
            return@withContext
        }
        if (settingsRepository.getAppState() == AppState.STATE_PAUSED) {
            val tx = createTx(msg, null, TransactionStatus.PAUSED)
            sendReply(tx, AutoReplyType.APP_PAUSED)
            return@withContext
        }

        val offer = offerDao.getOfferByPrice(msg.amountInt)
        if (offer == null) {
            val tx = createTx(msg, null, TransactionStatus.UNMATCHED)
            sendReply(tx, AutoReplyType.UNAVAILABLE_OFFER)
            return@withContext
        }

        val duplicate = transactionDao.getRecentSuccessful(phone, msg.amountInt.toDouble(), System.currentTimeMillis() - 5 * 60 * 1000)
        if (duplicate != null) {
            val tx = createTx(msg, offer, TransactionStatus.FAILED_ALREADY_RECOMMENDED)
            handleAlreadyRecommended(tx, offer)
            return@withContext
        }

        val tx = createTx(msg, offer, TransactionStatus.PENDING)
        dial(tx, offer)
    }

    suspend fun onUssdSuccess(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        val offer = offerDao.getOfferById(tx.offerId)
        val awaiting = offer?.strictMode == true &&
                (OfferSignature.canEnableStrictMode(offer.completionMessage) || OfferSignature.isBingwaOffer(offer.ussdCode))
        if (awaiting) {
            transactionDao.updateTransactionStatus(transactionId, TransactionStatus.AWAITING_COMMISSION)
        } else {
            transactionDao.completeTransaction(transactionId, tx.commission, TransactionStatus.SUCCESSFUL, System.currentTimeMillis())
            sendReply(tx, AutoReplyType.SUCCESSFUL_RESPONSE)
        }
    }

    suspend fun onUssdFailed(transactionId: String, reason: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status == TransactionStatus.SUCCESSFUL) return@withContext
        val offer = offerDao.getOfferById(tx.offerId)

        if (offer != null && offer.autoRetry && tx.retryCount < offer.numberOfRetries) {
            val retryAt = System.currentTimeMillis() + offer.retryIntervalMins * 60_000L
            transactionDao.updateTransaction(
                tx.copy(status = TransactionStatus.SCHEDULED, scheduledAt = retryAt, retryCount = tx.retryCount + 1, errorMessage = reason)
            )
            return@withContext
        }

        transactionDao.updateTransaction(tx.copy(status = TransactionStatus.FAILED, errorMessage = reason))
        sendReply(tx, AutoReplyType.FAILED_REQUEST)
        applyFallbackRule(tx, TransactionStatus.FAILED)
    }

    suspend fun onUssdAlreadyRecommended(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        transactionDao.updateTransactionStatus(transactionId, TransactionStatus.FAILED_ALREADY_RECOMMENDED)
        val offer = offerDao.getOfferById(tx.offerId)
        if (offer != null) handleAlreadyRecommended(tx, offer)
    }

    suspend fun onCommissionSms(commission: Double) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getLatestByStatus(TransactionStatus.AWAITING_COMMISSION)
            ?: transactionDao.getLatestByStatus(TransactionStatus.PROCESSING)
            ?: return@withContext
        transactionDao.completeTransaction(tx.id, commission, TransactionStatus.SUCCESSFUL, System.currentTimeMillis())
        sendReply(tx, AutoReplyType.SUCCESSFUL_RESPONSE)
    }

    suspend fun onCompletionSms() = withContext(Dispatchers.IO) {
        val tx = transactionDao.getLatestByStatus(TransactionStatus.AWAITING_COMMISSION) ?: return@withContext
        transactionDao.completeTransaction(tx.id, tx.commission, TransactionStatus.SUCCESSFUL, System.currentTimeMillis())
        sendReply(tx, AutoReplyType.SUCCESSFUL_RESPONSE)
    }

    suspend fun processDueScheduled() = withContext(Dispatchers.IO) {
        transactionDao.getDueScheduled(System.currentTimeMillis()).forEach { tx ->
            val offer = offerDao.getOfferById(tx.offerId) ?: return@forEach
            dial(tx, offer)
        }
    }

    suspend fun retry(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status != TransactionStatus.FAILED) return@withContext
        val offer = offerDao.getOfferById(tx.offerId) ?: return@withContext
        transactionDao.updateTransaction(tx.copy(status = TransactionStatus.PENDING, errorMessage = null))
        dial(tx, offer)
    }

    suspend fun markComplete(transactionId: String) = withContext(Dispatchers.IO) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return@withContext
        if (tx.status == TransactionStatus.SUCCESSFUL) return@withContext
        transactionDao.completeTransaction(transactionId, tx.commission, TransactionStatus.SUCCESSFUL, System.currentTimeMillis())
    }

    private suspend fun handleAlreadyRecommended(tx: Transaction, offer: Offer) {
        if (engageBot.isEnabled()) {
            engageBot.engageForTransaction(tx.phoneNumber, tx.customerName, tx.amount.toInt(), tx.id)
        } else {
            sendReply(tx, AutoReplyType.OFFER_ALREADY_RECOMMENDED)
        }
        val applied = applyFallbackRule(tx, TransactionStatus.FAILED_ALREADY_RECOMMENDED)
        if (!applied && offer.autoReschedule) {
            transactionDao.updateTransaction(
                tx.copy(status = TransactionStatus.SCHEDULED, scheduledAt = nextRunTime(offer.autoRescheduleRunTime))
            )
        }
    }

    private suspend fun applyFallbackRule(tx: Transaction, status: TransactionStatus): Boolean {
        val rule = ruleDao.getRulesFor(tx.offerId, status.name).firstOrNull() ?: return false
        val next = offerDao.getOfferById(rule.nextOfferId) ?: return false
        if (!next.isActive) return false
        val fallback = tx.copy(
            id = UUID.randomUUID().toString(),
            offerId = next.id,
            offerName = next.name,
            ussdCode = next.ussdCode,
            amount = next.price.toDouble(),
            status = TransactionStatus.PENDING,
            retryCount = 0,
            parentTransactionId = tx.id,
            errorMessage = null,
            scheduledAt = null
        )
        transactionDao.insertTransaction(fallback)
        dial(fallback, next)
        return true
    }

    private suspend fun dial(tx: Transaction, offer: Offer) {
        val code = offer.ussdCode
            .replace("BH", tx.phoneNumber, ignoreCase = true)
            .replace("ph", tx.phoneNumber)
        transactionDao.updateTransactionStatus(tx.id, TransactionStatus.PROCESSING)
        context.startService(
            Intent(context, UssdAutomationService::class.java).apply {
                putExtra("USSD_CODE", code)
                putExtra("TRANSACTION_ID", tx.id)
                putExtra("CUSTOMER_PHONE", tx.phoneNumber)
                putExtra("TIMEOUT_MS", offer.ussdTimeoutMillis)
            }
        )
    }

    private suspend fun createTx(msg: MpesaMessage, offer: Offer?, status: TransactionStatus): Transaction {
        val tx = Transaction(
            id = UUID.randomUUID().toString(),
            phoneNumber = normalize(msg.phoneNumber),
            customerName = msg.senderName,
            offerId = offer?.id ?: "",
            offerName = offer?.name ?: "Unmatched Ksh${msg.amountInt}",
            ussdCode = offer?.ussdCode ?: "",
            amount = msg.amountInt.toDouble(),
            status = status,
            mpesaReceipt = msg.receiptCode
        )
        transactionDao.insertTransaction(tx)
        return tx
    }

    private suspend fun sendReply(tx: Transaction, type: AutoReplyType) {
        val template = autoReplyDao.getActiveByType(type.name)?.message ?: return
        val customer = customerDao.getCustomerByPhone(tx.phoneNumber)
        val firstName = (customer?.name ?: tx.customerName)?.split(" ")?.firstOrNull() ?: "customer"
        smsDispatcher.send(
            destination = tx.phoneNumber,
            template = template,
            values = mapOf(
                "firstName" to firstName,
                "phone" to tx.phoneNumber,
                "amount" to tx.amount.toInt().toString(),
                "offerName" to tx.offerName,
                "offerPrice" to tx.amount.toInt().toString(),
                "mpesaCode" to (tx.mpesaReceipt ?: "")
            )
        )
    }

    private fun nextRunTime(timeStr: String): Long {
        val cal = Calendar.getInstance()
        val parts = timeStr.split(":")
        cal.set(Calendar.HOUR_OF_DAY, parts.getOrNull(0)?.toIntOrNull() ?: 1)
        cal.set(Calendar.MINUTE, parts.getOrNull(1)?.toIntOrNull() ?: 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        if (cal.timeInMillis <= System.currentTimeMillis()) cal.add(Calendar.DAY_OF_YEAR, 1)
        return cal.timeInMillis
    }

    private fun normalize(phone: String): String = phone.replace(" ", "").replace("-", "")
}
