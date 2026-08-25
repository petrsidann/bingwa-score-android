package com.bingwascore.app.domain.usecase

import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.domain.model.TransactionType
import com.bingwascore.app.services.UssdAutomationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProcessIncomingTransactionUseCase @Inject constructor(
    private val transactionDao: TransactionDao,
    private val offerDao: OfferDao,
    private val startUssdAutomation: StartUssdAutomationUseCase
) {

    /**
     * Called when M-Pesa confirmation is received.
     * Finds the matching offer by price and triggers USSD automation.
     */
    suspend fun execute(
        mpesaReceipt: String,
        amount: Double,
        customerPhone: String,
        customerName: String? = null
    ) = withContext(Dispatchers.IO) {
        try {
            Timber.d("💰 Processing M-Pesa payment: $amount KES from $customerPhone")

            // Find offer matching this price
            val matchingOffer = offerDao.getOfferByPrice(amount.toInt())
            
            if (matchingOffer == null) {
                Timber.e(" No offer found for price: $amount")
                return@withContext
            }

            Timber.d("✅ Matched offer: ${matchingOffer.name} (${matchingOffer.ussdCode})")

            // Create transaction record
            val transaction = Transaction(
                id = UUID.randomUUID().toString(),
                phoneNumber = customerPhone,
                customerName = customerName,
                offerId = matchingOffer.id,
                offerName = matchingOffer.name,
                ussdCode = matchingOffer.ussdCode,
                amount = amount,
                commission = 0.0, // Will be updated when commission SMS arrives
                status = TransactionStatus.PENDING,
                mpesaReceipt = mpesaReceipt,
                commissionMessage = null,
                errorMessage = null,
                retryCount = 0,
                isAutoRenewal = false,
                parentTransactionId = null
            )

            transactionDao.insertTransaction(transaction)

            // Trigger USSD automation immediately
            startUssdAutomation.execute(
                offerId = matchingOffer.id,
                transactionId = transaction.id,
                customerPhone = customerPhone
            )

            Timber.d("🚀 USSD automation started for transaction: ${transaction.id}")

        } catch (e: Exception) {
            Timber.e(e, "Failed to process incoming transaction")
        }
    }
}
