package com.bingwascore.app.domain.sms

import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.engine.TransactionPipeline
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRouter @Inject constructor(
    private val settings: SettingsRepository,
    private val pipeline: TransactionPipeline,
    private val cache: ReceivedSmsCache
) {

    private val commissionRegex = Regex("Ksh\\.?([\\d,]+\\.?\\d*)", RegexOption.IGNORE_CASE)

    suspend fun route(sender: String, body: String) {
        if (cache.isSeen(sender, body)) {
            Timber.d("Duplicate message ignored from $sender")
            return
        }
        cache.mark(sender, body)

        val normalized = sender.uppercase()

        when {
            normalized.contains("MPESA") -> {
                if (settings.getBoolean(AppSetting.PROCESS_MPESA_MESSAGES, true)) {
                    MpesaMessageExtractor.extract(body)?.let { pipeline.onMpesaReceived(it) }
                }
            }

            normalized.contains("SAFARICOM") || normalized == "334" -> {
                when {
                    body.contains("commission", ignoreCase = true) -> {
                        val amount = commissionRegex.find(body)
                            ?.groupValues?.get(1)
                            ?.replace(",", "")
                            ?.toDoubleOrNull() ?: 0.0
                        pipeline.onCommissionSms(amount)
                    }
                    body.contains("successfully recommended", ignoreCase = true) ||
                    body.contains("submitted successfully", ignoreCase = true) -> {
                        pipeline.onCompletionSms()
                    }
                }
            }

            else -> Timber.d("Ignoring sender: $sender")
        }
    }
}
