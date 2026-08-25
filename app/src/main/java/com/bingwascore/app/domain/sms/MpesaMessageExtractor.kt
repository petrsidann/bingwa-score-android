package com.bingwascore.app.domain.sms

import java.text.SimpleDateFormat
import java.util.Locale

data class MpesaMessage(
    val receiptCode: String,
    val phoneNumber: String,
    val senderName: String?,
    val amountInt: Int,
    val timestamp: Long?
)

object MpesaMessageExtractor {

    private val receiptRegex = Regex("^\\S+", RegexOption.IGNORE_CASE)
    private val fromRegex = Regex("from (.+?) ([0-9*]{10})", RegexOption.IGNORE_CASE)
    private val phoneRegex = Regex("([0-9*]{10})", RegexOption.IGNORE_CASE)
    private val amountRegex = Regex("Ksh([\\d,]+\\.\\d{2})", RegexOption.IGNORE_CASE)
    private val timeRegex = Regex(
        "on (\\d{1,2}/\\d{1,2}/\\d{2,4} at \\d{1,2}:\\d{2} [AP]M)",
        RegexOption.IGNORE_CASE
    )

    fun extract(body: String): MpesaMessage? {
        val receipt = receiptRegex.find(body)?.value ?: return null
        val amountMatch = amountRegex.find(body) ?: return null
        val amount = amountMatch.groupValues[1].replace(",", "").toDoubleOrNull() ?: return null

        val fromMatch = fromRegex.find(body)
        val phone = fromMatch?.groupValues?.get(2)
            ?: phoneRegex.find(body)?.groupValues?.get(1)
            ?: return null
        val name = fromMatch?.groupValues?.get(1)

        val timestamp = timeRegex.find(body)?.groupValues?.get(1)?.let {
            try {
                SimpleDateFormat("dd/MM/yy 'at' hh:mm a", Locale.ENGLISH).parse(it)?.time
            } catch (e: Exception) {
                null
            }
        }

        return MpesaMessage(
            receiptCode = receipt,
            phoneNumber = phone,
            senderName = name,
            amountInt = amount.toInt(),
            timestamp = timestamp
        )
    }
}
