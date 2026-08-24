package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.utils.SmsMessageParser

@AndroidEntryPoint
class SmsBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var transactionDao: TransactionDao

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = getMessagesFromIntent(intent) ?: return

        for (message in messages) {
            val sender = message.displayOriginatingAddress ?: continue
            val body = message.messageBody ?: continue

            Timber.d("SMS Received from: $sender | Body: $body")

            scope.launch {
                processSms(sender, body)
            }
        }
    }

    private fun getMessagesFromIntent(intent: Intent): Array<SmsMessage>? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Telephony.Sms.Intents.getMessagesFromIntent(intent)
        } else {
            @Suppress("DEPRECATION")
            val pduExtra = intent.extras?.get("pdus") as? Array<*>
            pduExtra?.map { pdu ->
                SmsMessage.createFromPdu(pdu as ByteArray)
            }?.toTypedArray()
        }
    }

    private suspend fun processSms(sender: String, body: String) {
        val parsedMessage = SmsMessageParser.parse(body)

        when (parsedMessage.type) {
            SmsMessageParser.MessageType.MPESA_CONFIRMATION -> {
                Timber.d("M-Pesa Confirmation detected: ${parsedMessage.receiptNumber}")
                // Update transaction with M-Pesa receipt
                if (parsedMessage.receiptNumber != null) {
                    transactionDao.updateMpesaReceipt(parsedMessage.receiptNumber, parsedMessage.amount)
                }
            }
            SmsMessageParser.MessageType.COMMISSION -> {
                Timber.d("Commission Message detected: ${parsedMessage.commissionAmount}")
                // Mark transaction as successful and await commission
                if (parsedMessage.commissionAmount != null) {
                    transactionDao.updateCommission(parsedMessage.commissionAmount)
                }
            }
            SmsMessageParser.MessageType.BUNDLE_DELIVERY -> {
                Timber.d("Bundle Delivery detected")
                // Mark transaction as successful
                transactionDao.updateStatus(TransactionStatus.SUCCESSFUL)
            }
            SmsMessageParser.MessageType.UNKNOWN -> {
                Timber.d("Unknown SMS type")
            }
        }
    }
}
