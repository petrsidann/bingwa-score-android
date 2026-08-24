package com.bingwascore.app.domain.usecase

import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.utils.SmsParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProcessSmsUseCase @Inject constructor(
    private val transactionDao: TransactionDao
) {

    suspend fun execute(parsedSms: SmsParser.ParsedSms) = withContext(Dispatchers.IO) {
        try {
            when (parsedSms.type) {
                SmsParser.MessageType.MPESA_CONFIRMATION -> {
                    Timber.d("Processing M-Pesa Payment...")
                    // Update the most recent pending transaction with the receipt
                    transactionDao.updateLatestPendingWithMpesa(
                        receipt = parsedSms.receiptNumber ?: "",
                        amount = parsedSms.amount ?: 0.0,
                        newStatus = TransactionStatus.PROCESSING
                    )
                }

                SmsParser.MessageType.COMMISSION_RECEIVED -> {
                    Timber.d("Processing Commission Message...")
                    // Mark the transaction as successful and save commission
                    transactionDao.updateLatestProcessingWithCommission(
                        commission = parsedSms.commissionAmount ?: 0.0,
                        newStatus = TransactionStatus.SUCCESSFUL
                    )
                }

                SmsParser.MessageType.BUNDLE_DELIVERED -> {
                    Timber.d("Processing Bundle Delivery...")
                    transactionDao.updateLatestPendingStatus(TransactionStatus.SUCCESSFUL)
                }

                SmsParser.MessageType.UNKNOWN -> {
                    Timber.d("Ignoring unknown SMS")
                }
            }
        } catch (e: Exception) {
            Timber.e(e, "Error processing SMS")
        }
    }
}
