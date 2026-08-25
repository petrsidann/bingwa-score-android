package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import com.bingwascore.app.domain.usecase.ProcessIncomingTransactionUseCase
import com.bingwascore.app.utils.SmsParser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SmsBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var processIncomingTransactionUseCase: ProcessIncomingTransactionUseCase

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = getMessagesFromIntent(intent) ?: return

        for (message in messages) {
            val sender = message.displayOriginatingAddress ?: continue
            val body = message.messageBody ?: continue

            Timber.d("📨 SMS Received from: $sender")

            val parsed = SmsParser.parse(sender, body)
            
            // Only process M-Pesa confirmations for transaction automation
            if (parsed.type == SmsParser.MessageType.MPESA_CONFIRMATION && 
                parsed.receiptNumber != null && 
                parsed.amount != null) {
                
                Timber.d("💰 M-Pesa detected: ${parsed.receiptNumber} - KES ${parsed.amount}")
                
                scope.launch {
                    processIncomingTransactionUseCase.execute(
                        mpesaReceipt = parsed.receiptNumber!!,
                        amount = parsed.amount!!,
                        customerPhone = parsed.senderNumber ?: sender,
                        customerName = null // Could extract from SMS if needed
                    )
                }
            } else if (parsed.type == SmsParser.MessageType.COMMISSION_RECEIVED) {
                Timber.d("💵 Commission detected: KES ${parsed.commissionAmount}")
                // Commission processing will be handled separately
            }
        }
    }

    private fun getMessagesFromIntent(intent: Intent): Array<SmsMessage>? {
        return try {
            Telephony.Sms.Intents.getMessagesFromIntent(intent)
        } catch (e: Exception) {
            Timber.e(e, "Failed to parse SMS intent")
            null
        }
    }
}
