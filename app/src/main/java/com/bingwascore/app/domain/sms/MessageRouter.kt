package com.bingwascore.app.domain.sms

import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.domain.engine.TransactionPipeline
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRouter @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val pipeline: TransactionPipeline,
    private val mpesaExtractor: MpesaMessageExtractor,
    private val engageBot: EngageBotSessionLifecycle,
    private val customerDao: CustomerDao
) {

    private val phoneSenderRegex = Regex("^(0\\d{9}|\\+?254\\d{9})$")
    private val commissionRegex = Regex("Ksh\\.?\\s?([\\d,]+\\.?\\d*)", RegexOption.IGNORE_CASE)

    suspend fun route(sender: String, body: String) {
        val normalizedSender = sender.trim()
        val upper = normalizedSender.uppercase()

        when {
            upper.contains("MPESA") || upper.contains("M-PESA") -> {
                val msg = mpesaExtractor.extract(body)
                if (msg != null) {
                    Timber.d("M-Pesa payment Ksh${msg.amountInt} from ${msg.phoneNumber}")
                    pipeline.onMpesaReceived(msg)
                } else {
                    Timber.w("M-Pesa SMS not parsed: $body")
                }
            }

            upper.contains("SAFARICOM") || normalizedSender == "334" -> {
                when {
                    body.contains("commission", ignoreCase = true) -> {
                        val amount = commissionRegex.find(body)?.groupValues?.get(1)
                            ?.replace(",", "")?.toDoubleOrNull() ?: 0.0
                        pipeline.onCommissionSms(amount)
                    }
                    body.contains("successfully recommended", ignoreCase = true) ||
                    body.contains("submitted successfully", ignoreCase = true) -> {
                        pipeline.onCompletionSms()
                    }
                }
            }

            phoneSenderRegex.matches(normalizedSender) -> {
                if (engageBot.isEnabled() && engageBot.hasActiveSession(normalizedSender)) {
                    engageBot.onCustomerMessage(normalizedSender, body)
                }
            }

            else -> Timber.d("Ignoring sender: $sender")
        }
    }
}
