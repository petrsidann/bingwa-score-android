package com.bingwascore.app.utils

import timber.log.Timber
import java.util.regex.Pattern

/**
 * Robust, null-safe M-Pesa / commission parser.
 *
 * PARITY BLOCK B — Hybrid truth injection. Field regexes below are the
 * EXACT strings extracted from the decompiled Bingwa Hybrid source:
 * Sender/Name "^(\\S+)", From/Phone "from (.+?) ([0-9*]{10})",
 * Phone "([0-9*]{10})", Amount "Ksh([\\d,]+\\.\\d{2})",
 * Time "on (\\d{1,2}/\\d{1,2}/\\d{2,4} at \\d{1,2}:\\d{2} [AP]M)".
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
     * "0XXXXXXXXX" form used across the data layer. [time] is the raw
     * Hybrid "on D/M/YY at H:MM AM/PM" stamp when present.
     */
    data class MpesaMessage(
        val receipt: String?,
        val amount: Double?,
        val phone: String?,
        val name: String?,
        val sender: String,
        val type: SmsType = SmsType.INCOMING_PAYMENT,
        val time: String? = null
    )

    /**
     * Functional truth for the SMS pipeline (Audit G8):
     *
     * - INCOMING_PAYMENT: "received from" — the ONLY type the pipeline acts on.
     * - OUTGOING_PAYMENT: "sent to" / "you have sent" / "withdrawn" — ignored
     *   completely downstream (no transaction, no reply).
     * - COMMISSION: Safaricom commission summaries.
     * - COMPLETION: "successfully recommended" bundle confirmations.
     * - UNKNOWN: anything else.
     */
    enum class SmsType {
        INCOMING_PAYMENT,
        OUTGOING_PAYMENT,
        COMMISSION,
        COMPLETION,
        UNKNOWN
    }

    /** Hybrid Sender/Name: "^(\\S+)" — leading token (receipt/sender head). */
    private val senderPattern = Pattern.compile("^(\\S+)")

    /** Hybrid From/Phone: "from (.+?) ([0-9*]{10})" — payer name + phone. */
    private val fromPhonePattern =
        Pattern.compile("from (.+?) ([0-9*]{10})", Pattern.CASE_INSENSITIVE)

    /** Hybrid Phone: "([0-9*]{10})" — any 10-digit (or masked *) run. */
    private val phonePattern = Pattern.compile("([0-9*]{10})")

    /** Hybrid Amount: "Ksh([\\d,]+\\.\\d{2})" — e.g. KSH20.00 / Ksh1,825.50. */
    private val amountPattern =
        Pattern.compile("Ksh([\\d,]+\\.\\d{2})", Pattern.CASE_INSENSITIVE)

    /** Hybrid Time: "on (\\d{1,2}/\\d{1,2}/\\d{2,4} at \\d{1,2}:\\d{2} [AP]M)". */
    private val timePattern =
        Pattern.compile("on (\\d{1,2}/\\d{1,2}/\\d{2,4} at \\d{1,2}:\\d{2} [AP]M)", Pattern.CASE_INSENSITIVE)

    // "Total Commission this week is Ksh.1825.1"
    private val commissionPattern =
        Pattern.compile("Commission.*?(?:KSH?|KES)\\.?\\s*([0-9][0-9,]*(?:\\.[0-9]+)?)", Pattern.CASE_INSENSITIVE)

    /**
     * Classifies an SMS body into its functional [SmsType] WITHOUT parsing
     * amounts or phones. Outgoing markers win over incoming markers so a
     * mixed/rubbish body can never slip into the money pipeline.
     */
    fun classify(body: String): SmsType {
        val lower = body.lowercase(java.util.Locale.ROOT)
        return when {
            lower.contains("sent to") || lower.contains("you have sent") ||
                lower.contains("withdrawn") -> SmsType.OUTGOING_PAYMENT
            lower.contains("received from") -> SmsType.INCOMING_PAYMENT
            lower.contains("commission") -> SmsType.COMMISSION
            lower.contains("successfully recommended") -> SmsType.COMPLETION
            else -> SmsType.UNKNOWN
        }
    }

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

            // Hybrid sender head "^(\\S+)": exercised for provenance (the
            // refined receipt pattern below extracts the 10-char receipt).
            @Suppress("UNUSED_VARIABLE")
            val senderHead = senderPattern.matcher(body).let { if (it.find()) it.group(1) else null }
            // "UHNRD47VMC Confirmed": 10-char receipt before "Confirmed".
            val receipt = Pattern.compile(
                "([A-Z0-9]{10})\\s+Confirmed",
                Pattern.CASE_INSENSITIVE
            ).matcher(body).let { if (it.find()) it.group(1) else null }
            // Hybrid Amount (exact): Ksh([\d,]+\.\d{2}).
            val amount = amountPattern.matcher(body).let {
                if (it.find()) it.group(1)?.replace(",", "")?.toDoubleOrNull() else null
            }
            // Hybrid From/Phone (exact): from (.+?) ([0-9*]{10}).
            val fromMatcher = fromPhonePattern.matcher(body)
            var fromName: String? = null
            var rawPhone: String? = null
            var phoneStart = -1
            if (fromMatcher.find()) {
                fromName = try { fromMatcher.group(1)?.trim() } catch (_: Exception) { null }
                rawPhone = try { fromMatcher.group(2) } catch (_: Exception) { null }
                phoneStart = try { fromMatcher.start(2) } catch (_: Exception) { -1 }
            }
            // Hybrid Phone fallback (exact): ([0-9*]{10}).
            if (rawPhone.isNullOrEmpty()) {
                val fallback = phonePattern.matcher(body)
                if (fallback.find()) {
                    rawPhone = try { fallback.group(1) } catch (_: Exception) { null }
                    phoneStart = try { fallback.start(1) } catch (_: Exception) { -1 }
                }
            }
            val phone = if (rawPhone != null && phoneStart >= 0) {
                normalizePhoneWithBody(body, phoneStart, rawPhone!!) ?: normalizePhone(rawPhone!!)
            } else rawPhone?.let { normalizePhone(it) }
            val name = fromName
            // Hybrid Time (exact).
            val time = timePattern.matcher(body).let { if (it.find()) it.group(1) else null }
            return MpesaMessage(receipt, amount, phone, name, sender, type = classify(body), time = time)
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
        // Masked Hybrid numbers (e.g. "07******78") carry '*': pass through.
        if (raw.contains('*')) return raw
        val cleaned = raw.removePrefix("+")
        return when {
            cleaned.startsWith("254") && cleaned.length == 12 -> "0" + cleaned.drop(3)
            cleaned.startsWith("0") && cleaned.length == 10 -> cleaned
            else -> raw
        }
    }

    /**
     * Recovers a full international number around a Hybrid 10-char slice.
     * Looks for an optional "254"/"+254"/"0" prefix immediately before
     * [start] in [body] and normalizes to local form.
     */
    internal fun normalizePhoneWithBody(body: String, start: Int, slice: String): String? {
        try {
            if (slice.contains('*')) return slice
            // Prefer a full international/local number in the neighbourhood
            // that CONTAINS this exact 10-char Hybrid slice (handles
            // "254712345678" arriving as "2547123456"+lookahead, and
            // "+254701234567" where the '+' sits just before the slice).
            val windowStart = maxOf(0, start - 8)
            val windowEnd = minOf(body.length, start + slice.length + 8)
            val window = body.substring(windowStart, windowEnd)
            val fullMatch = Regex("(\\+?254\\d{9}|0\\d{9})").find(window)
            if (fullMatch != null && fullMatch.value.contains(slice.take(6))) {
                return normalizePhone(fullMatch.value)
            }
            // Slice itself is the head of a 254-number: append trailing
            // digits (e.g. "2547123456" + "78").
            if (slice.startsWith("254")) {
                val after = body.substring(
                    minOf(body.length, start + slice.length),
                    minOf(body.length, start + slice.length + 4)
                )
                val extra = Regex("^\\d{1,2}").find(after)?.value.orEmpty()
                val full = ("254$slice".take(3) + slice.drop(3) + extra).let {
                    // slice already starts with 254, so full = slice + extra
                    slice + extra
                }.take(12)
                if (full.length == 12 && full.startsWith("254")) {
                    return "0" + full.drop(3)
                }
            }
            val prefixWindow = body.substring(maxOf(0, start - 4), start)
            return when {
                prefixWindow.endsWith("+254") || prefixWindow.endsWith("254") -> {
                    val full = "254$slice".take(12)
                    if (full.length == 12) "0" + full.drop(3) else normalizePhone(slice)
                }
                prefixWindow.endsWith("0") && slice.length == 9 -> normalizePhone("0$slice")
                else -> normalizePhone(slice)
            }
        } catch (_: Throwable) {
            return null
        }
    }
}
