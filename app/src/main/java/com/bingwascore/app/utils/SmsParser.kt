package com.bingwascore.app.utils

import timber.log.Timber
import java.util.regex.Pattern

/**
 * Robust, null-safe M-Pesa / commission parser.
 *
 * Real-format sample bodies it must handle:
 *
 * 1. Confirmation (standard):
 *    "UHNRD47VMC Confirmed.on 23/8/26 at 5:51 PMKSH20.00 received from
 *     JOHN DOE 0712345678, on 23/8/26 at 5:52 PMNew M-PESA balance is KES
 *     100.00. Transaction cost, KES 0.00."
 *
 * 2. Confirmation with full international number:
 *    "SJ2KD81LM Confirmed. on 12/7/26 at 9:15 AMKsh49.00 received from
 *     BAKARI OMAR 254712345678, on 12/7/26 at 9:16 AMNew M-PESA balance is
 *     KES 250.00."
 *
 * 3. Large amount with thousands separator:
 *    "QK7GH2X1P Confirmed.on 2/8/26 at 8:03 PMKsh1,825.50 received from
 *     AMINA WANJIKU +254701234567, of safaricom..."
 */
object SmsParser {

    /**
     * A single parsed M-Pesa credit. [phone] is normalized to the local
     * "0XXXXXXXXX" form used across the data layer.
     */
    data class MpesaMessage(
        val receipt: String?,
        val amount: Double?,
        val phone: String?,
        val name: String?,
        val sender: String
    )

    // "UHNRD47VMC Confirmed" — 10-char receipt right before the "Confirmed".
    private val receiptPattern =
        Pattern.compile("([A-Z0-9]{10})\\s+Confirmed", Pattern.CASE_INSENSITIVE)

    // "KSH20.00", "Ksh49.00", "Ksh 1,825.1", "KES 1825.10"
    private val amountPattern =
        Pattern.compile("(?:KSH?|KES)\\.?\\s*([0-9][0-9,]*(?:\\.[0-9]+)?)", Pattern.CASE_INSENSITIVE)

    // "0712345678" | "254712345678" | "+254712345678" | "0722333444"
    private val phonePattern =
        Pattern.compile("(?<![0-9])((?:0|(?:\\+?254))[17][0-9]{8})(?![0-9])")

    // "...received from JOHN DOE 0712345678..." — capture up to the phone.
    private val namePattern =
        Pattern.compile("from\\s+([A-Z0-9 .'&\\-]+?)\\s+(?:(?:\\+?254)|0)?[17][0-9]{8}", Pattern.CASE_INSENSITIVE)

    // "Total Commission this week is Ksh.1825.1"
    private val commissionPattern =
        Pattern.compile("Commission.*?(?:KSH?|KES)\\.?\\s*([0-9][0-9,]*(?:\\.[0-9]+)?)", Pattern.CASE_INSENSITIVE)

    /**
     * Parses an inbound SMS as an M-Pesa confirmation. Returns null (never
     * throws) when the message is not an M-Pesa message at all: detection is
     * triggered when [sender] contains "MPESA" or [body] contains "M-PESA".
     */
    fun parse(sender: String, body: String): MpesaMessage? {
        try {
            val senderUpper = sender.uppercase()
            val looksLikeMpesa =
                senderUpper.contains("MPESA") || body.contains("M-PESA", ignoreCase = true)
            if (!looksLikeMpesa) {
                Timber.d("SmsParser: not an M-Pesa message (sender=%s)", sender)
                return null
            }

            val receipt = receiptPattern.matcher(body).let { if (it.find()) it.group(1) else null }
            val amount = amountPattern.matcher(body).let {
                if (it.find()) it.group(1)?.replace(",", "")?.toDoubleOrNull() else null
            }
                        val phone = phonePattern.matcher(body).let {
                if (it.find()) it.group(1)?.let { normalizePhone(it) } else null
            }
            val name = namePattern.matcher(body).let {
                if (it.find()) it.group(1)?.trim() else null
            }
            return MpesaMessage(receipt, amount, phone, name, sender)
        } catch (t: Throwable) {
            Timber.e(t, "SmsParser.parse crashed for %s", sender)
            return null
        }
    }

    /**
     * Extracts a commission amount from a Safaricom summary SMS (e.g.
     * "Total Commission this week is Ksh.1825.1"). Returns null when the body
     * does not mention commission or no amount can be found.
     */
    fun parseCommission(body: String): Double? {
        try {
            if (!body.contains("commission", ignoreCase = true)) return null
            val matcher = commissionPattern.matcher(body)
            if (!matcher.find()) return null
            return matcher.group(1)?.replace(",", "")?.toDoubleOrNull()
        } catch (t: Throwable) {
            Timber.e(t, "SmsParser.parseCommission crashed")
            return null
        }
    }

    /** "254712345678"/"+254712345678" -> "0712345678"; "0712345678" stays. */
    private fun normalizePhone(raw: String): String {
        val cleaned = raw.removePrefix("+")
        return when {
            cleaned.startsWith("254") && cleaned.length == 12 -> "0" + cleaned.drop(3)
            cleaned.startsWith("0") && cleaned.length == 10 -> cleaned
            else -> raw
        }
    }
}
