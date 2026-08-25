package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.domain.sms.MpesaMessageExtractor
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
    lateinit var pipeline: TransactionPipeline

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val commissionRegex = Regex("Ksh\\.?([\\d,]+\\.?\\d*)", RegexOption.IGNORE_CASE)

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent) ?: return

        for (message in messages) {
            val sender = message.displayOriginatingAddress ?: continue
            val body = message.messageBody ?: continue

            Timber.d("SMS from $sender")

            when {
                sender.equals("MPESA", ignoreCase = true) -> {
                    MpesaMessageExtractor.extract(body)?.let { mpesa ->
                        scope.launch { pipeline.onMpesaReceived(mpesa) }
                    }
                }
                sender.equals("Safaricom", ignoreCase = true) || sender == "334" -> {
                    when {
                        body.contains("commission", ignoreCase = true) -> {
                            val amount = commissionRegex.find(body)
                                ?.groupValues?.get(1)
                                ?.replace(",", "")
                                ?.toDoubleOrNull() ?: 0.0
                            scope.launch { pipeline.onCommissionSms(amount) }
                        }
                        body.contains("successfully recommended", ignoreCase = true) ||
                        body.contains("submitted successfully", ignoreCase = true) -> {
                            scope.launch { pipeline.onCompletionSms() }
                        }
                    }
                }
            }
        }
    }
}
