package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.engagebot.EngageBotSessionLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Entry point of the engine. Routes every inbound SMS by sender/body:
 *
 *  - sender contains MPESA          -> [TransactionPipeline.onMpesaReceived]
 *  - SAFARICOM + "commission"       -> [TransactionPipeline.onCommissionSms]
 *  - "successfully recommended"     -> [TransactionPipeline.onCompletionSms]
 *  - plain phone number sender with an active engage session
 *                                   -> [EngageBotSessionLifecycle.onCustomerMessage]
 */
@AndroidEntryPoint
class SmsBroadcastReceiver : BroadcastReceiver() {

    @Inject lateinit var pipeline: TransactionPipeline
    @Inject lateinit var engageBot: EngageBotSessionLifecycle

    private val receiverScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        try {
            if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            if (messages.isNullOrEmpty()) return

            val sender = messages.firstNotNullOfOrNull { it.originatingAddress } ?: return
            val body = messages.joinToString("") { it.messageBody.orEmpty() }
            if (body.isBlank()) return

            Timber.d("SMS from %s: %s", sender, body)
            route(sender, body)
        } catch (t: Throwable) {
            Timber.e(t, "SmsBroadcastReceiver crashed in onReceive")
        }
    }

    private fun route(sender: String, body: String) {
        val upperSender = sender.uppercase()
        val senderIsPhoneNumber = phoneSenderRegex.matches(sender.trim())

        when {
            upperSender.contains(SENDER_MPESA) -> receiverScope.launch {
                try {
                    pipeline.onMpesaReceived(sender, body)
                } catch (t: Throwable) {
                    Timber.e(t, "Routing M-Pesa SMS failed")
                }
            }

            upperSender.contains(SENDER_SAFARICOM) &&
                body.contains(COMMISSION_KEYWORD, ignoreCase = true) -> {
                val amount = commissionAmountRegex.find(body)
                    ?.groupValues?.get(1)
                    ?.replace(",", "")?.toDoubleOrNull()
                receiverScope.launch {
                    try {
                        pipeline.onCommissionSms(amount)
                    } catch (t: Throwable) {
                        Timber.e(t, "Routing commission SMS failed")
                    }
                }
            }

            body.contains(COMPLETION_KEYWORD, ignoreCase = true) -> receiverScope.launch {
                try {
                    pipeline.onCompletionSms()
                } catch (t: Throwable) {
                    Timber.e(t, "Routing completion SMS failed")
                }
            }

            senderIsPhoneNumber -> receiverScope.launch {
                try {
                    // Only handles the message if an engage session is live for
                    // this sender; otherwise it is silently ignored.
                    if (engageBot.hasActiveSession(sender.trim())) {
                        engageBot.onCustomerMessage(sender.trim(), body)
                    }
                } catch (t: Throwable) {
                    Timber.e(t, "Routing engage reply failed")
                }
            }

            else -> Timber.d("Ignoring SMS from %s", sender)
        }
    }

    companion object {
        private const val SENDER_MPESA = "MPESA"
        private const val SENDER_SAFARICOM = "SAFARICOM"
        private const val COMMISSION_KEYWORD = "commission"
        private const val COMPLETION_KEYWORD = "successfully recommended"

        // Pure phone-number senders: 0712345678 / +254712345678 / 254712345678
        private val phoneSenderRegex = Regex("^(?:\\+?254|0)[17]\\d{8}$")

        // "Total Commission this week is Ksh.1825.1"
        private val commissionAmountRegex =
            Regex("Commission.*?Ksh\\.?\\s*([0-9][0-9,]*(?:\\.[0-9]+)?)", RegexOption.IGNORE_CASE)
    }
}
