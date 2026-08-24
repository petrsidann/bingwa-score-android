package com.bingwascore.app.utils

import timber.log.Timber
import java.util.regex.Pattern

object SmsMessageParser {

    enum class MessageType {
        MPESA_CONFIRMATION,
        COMMISSION,
        BUNDLE_DELIVERY,
        UNKNOWN
    }

    data class ParsedMessage(
        val type: MessageType,
        val receiptNumber: String? = null,
        val amount: Double? = null,
        val commissionAmount: Double? = null,
        val sender: String? = null
    )

    // M-Pesa Confirmation Pattern
    // Example: "UHNRD47VMC Confirmed.on 23/8/26 at 5:51 PMKSH20.00 received from..."
    private val mpesaPattern = Pattern.compile(
        "([A-Z0-9]{10})\\s+Confirmed.*?KSH([0-9.]+)",
        Pattern.CASE_INSENSITIVE
    )

    // Commission Message Pattern
    // Example: "Total Commission this week is Ksh.1825.1"
    private val commissionPattern = Pattern.compile(
        "Commission.*?Ksh\\.?([0-9.]+)",
        Pattern.CASE_INSENSITIVE
    )

    // Bundle Delivery Pattern
    // Example: "You have successfully purchased 250Mbs, 24hrs!"
    private val bundlePattern = Pattern.compile(
        "successfully\\s+(purchased|recommended|activated)",
        Pattern.CASE_INSENSITIVE
    )

    fun parse(messageBody: String): ParsedMessage {
        Timber.d("Parsing SMS: $messageBody")

        // Check M-Pesa Confirmation
        val mpesaMatcher = mpesaPattern.matcher(messageBody)
        if (mpesaMatcher.find()) {
            val receipt = mpesaMatcher.group(1)
            val amount = mpesaMatcher.group(2)?.toDoubleOrNull()
            Timber.d("M-Pesa Confirmation: Receipt=$receipt, Amount=$amount")
            return ParsedMessage(
                type = MessageType.MPESA_CONFIRMATION,
                receiptNumber = receipt,
                amount = amount
            )
        }

        // Check Commission Message
        val commissionMatcher = commissionPattern.matcher(messageBody)
        if (commissionMatcher.find()) {
            val commission = commissionMatcher.group(1)?.toDoubleOrNull()
            Timber.d("Commission Message: Amount=$commission")
            return ParsedMessage(
                type = MessageType.COMMISSION,
                commissionAmount = commission
            )
        }

        // Check Bundle Delivery
        val bundleMatcher = bundlePattern.matcher(messageBody)
        if (bundleMatcher.find()) {
            Timber.d("Bundle Delivery detected")
            return ParsedMessage(type = MessageType.BUNDLE_DELIVERY)
        }

        Timber.d("Unknown SMS type")
        return ParsedMessage(type = MessageType.UNKNOWN)
    }
}
