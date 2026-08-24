package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import com.bingwascore.app.domain.usecase.ProcessSmsUseCase
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
    lateinit var processSmsUseCase: ProcessSmsUseCase

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = getMessagesFromIntent(intent) ?: return

        for (message in messages) {
            val sender = message.displayOriginatingAddress ?: continue
            val body = message.messageBody ?: continue

            Timber.d(" SMS Received from: $sender")

            val parsed = SmsParser.parse(sender, body)
            
            if (parsed.type != SmsParser.MessageType.UNKNOWN) {
                scope.launch {
                    processSmsUseCase.execute(parsed)
                }
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
