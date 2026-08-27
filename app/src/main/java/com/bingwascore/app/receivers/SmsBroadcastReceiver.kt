package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.bingwascore.app.domain.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.domain.sms.MessageRouter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SmsBroadcastReceiver : BroadcastReceiver() {

    @Inject lateinit var router: MessageRouter
    @Inject lateinit var engageBot: EngageBotSessionLifecycle

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent) ?: return

        for (message in messages) {
            val sender = message.displayOriginatingAddress ?: continue
            val body = message.messageBody ?: continue

            Timber.d("SMS Received from: $sender")

            scope.launch {
                // 1. Route to transaction pipeline (M-Pesa, Commission, etc.)
                router.route(sender, body)

                // 2. Route to EngageBot for customer replies (Botted Replies)
                // Only if it's not a system message (MPESA, Safaricom, etc.)
                if (!sender.equals("MPESA", true) && !sender.equals("Safaricom", true) && sender != "334") {
                    engageBot.onCustomerMessage(sender, body, null)
                }
            }
        }
    }
}
