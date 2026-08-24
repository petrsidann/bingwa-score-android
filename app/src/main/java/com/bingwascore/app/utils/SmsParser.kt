package com.bingwascore.app.utils

import timber.log.Timber
import java.util.regex.Pattern

object SmsParser {

    enum class MessageType {
        MPESA_CONFIRMATION,
        COMMISSION_RECEIVED,
        BUNDLE_DELIVERED,
        UNKNOWN
    }

    data class ParsedSms(
        val type: MessageType,
        val receiptNumber: String? = null,
        val amount: Double? = null,
        val commissionAmount: Double? = null,
        val senderNumber: String? = null
    )

    // Regex for M-Pesa: "UHNRD47VMC Confirmed... KSH20.00"
    private val mpesaPattern = Pattern.compile("([A-Z0-9]{10})\\s*Confirmed.*?KSH?([0-9,.]+)", Pattern.CASE_INSENSITIVE)
    
    // Regex for Commission: "Total Commission this week is Ksh.1825.1"
    private val commissionPattern = Pattern.compile("Commission.*?Ksh\\.?([0-9,.]+)", Pattern.CASE_INSENSITIVE)
    
    // Regex for Bundle: "You have successfully purchased..."
    private val bundlePattern = Pattern.compile("successfully\\s+(purchased|recommended|activated)", Pattern.CASE_INSENSITIVE)

    fun parse(sender: String, body: String): ParsedSms {
        Timber.d("Parsing SMS from $sender: $body")

        // 1. Check M-Pesa
        val mpesaMatcher = mpesaPattern.matcher(body)
        if (mpesaMatcher.find()) {
            val receipt = mpesaMatcher.group(1)
            val amountStr = mpesaMatcher.group(2)?.replace(",", "")
            val amount = amountStr?.toDoubleOrNull()
            Timber.d("✅ M-Pesa Detected: Receipt=$receipt, Amount=$amount")
            return ParsedSms(MessageType.MPESA_CONFIRMATION, receipt, amount, senderNumber = sender)
        }

        // 2. Check Commission
        val commMatcher = commissionPattern.matcher(body)
        if (commMatcher.find()) {
            val commStr = commMatcher.group(1)?.replace(",", "")
            val commission = commStr?.toDoubleOrNull()
            Timber.d(" Commission Detected: Amount=$commission")
            return ParsedSms(MessageType.COMMISSION_RECEIVED, commissionAmount = commission, senderNumber = sender)
        }

        // 3. Check Bundle Delivery
        val bundleMatcher = bundlePattern.matcher(body)
        if (bundleMatcher.find()) {
            Timber.d(" Bundle Delivery Detected")
            return ParsedSms(MessageType.BUNDLE_DELIVERED, senderNumber = sender)
        }

        return ParsedSms(MessageType.UNKNOWN, senderNumber = sender)
    }
}
