package com.bingwascore.app.data.showcase

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Random

/**
 * SHOWCASE S2 — the demo dataset and the exact SMS text the simulator sends.
 *
 * Everything here is pure and deterministic given a seed, so the seeder and the
 * simulator's message format are unit-testable without Android, Room or a device.
 *
 * The strings are byte-for-byte Hybrid format: the simulator feeds them to the
 * **real** [com.bingwascore.app.utils.SmsParser] and the **real**
 * [com.bingwascore.app.domain.engine.TransactionPipeline]. If a demo message ever
 * failed to parse, that would be a real bug in the parser — never a special case.
 */
object DemoCatalog {

    /** A demo customer: display name + the phone the payment will come from. */
    data class DemoCustomer(val name: String, val phone: String)

    /** A demo offer with a real-looking Safaricom code. */
    data class DemoOffer(
        val name: String,
        val ussdCode: String,
        val price: Int,
        val type: String = "DATA",
        val validityHours: Int = 24
    )

    /** Six customers who feel like a real agent's book. */
    val CUSTOMERS: List<DemoCustomer> = listOf(
        DemoCustomer("JOHN DOE", "0712345678"),
        DemoCustomer("BAKARI OMAR", "0722987654"),
        DemoCustomer("AMINA WANJIKU", "0733112244"),
        DemoCustomer("PETER KIMANI", "0744556677"),
        DemoCustomer("GRACE NJOKI", "0755667788"),
        DemoCustomer("DANIEL MUTISO", "0766778899")
    )

    /** Five offers with codes shaped like the ones Safaricom actually answers. */
    val OFFERS: List<DemoOffer> = listOf(
        DemoOffer("Daily Data 1GB", "*544*1#", 20),
        DemoOffer("Weekly Data 5GB", "*544*5#", 100),
        DemoOffer("Monthly Data 20GB", "*544*20#", 300, validityHours = 720),
        DemoOffer("All Access Unlimited", "*999*1#", 1500, type = "COMBO", validityHours = 720),
        DemoOffer("M-Pesa Send Bundle", "*659*1#", 50)
    )

    /** Four auto-reply templates the demo customers can be answered with. */
    val AUTO_REPLIES: List<Pair<String, String>> = listOf(
        "THANKS" to "Thanks {name}. Your bundle is on the way.",
        "RECEIVED" to "Received. Enjoy your data bundle {name}!",
        "HELP" to "Hi {name}. Send your M-Pesa payment and we will dial for you.",
        "BALANCE" to "Your airtime balance is Ksh {balance}."
    )

    /** One blocked number and one trusted partner, so lists are not empty. */
    const val BLOCKED_CONTACT_NAME = "SPAM COLLECTOR"
    const val BLOCKED_CONTACT_PHONE = "0700000000"
    const val TRUSTED_PARTNER_NAME = "NAKURU SHOP"
    const val TRUSTED_PARTNER_PHONE = "0711000222"

    /** How many transactions the demo database starts with. */
    const val TRANSACTION_COUNT = 42
// ── SMS formatting (the part that must match Hybrid exactly) ─────────────

    /**
     * Builds an incoming-payment confirmation in the exact Hybrid shape:
     * `"<RECEIPT> Confirmed.on <d/M/yy at h:mm AM>Ksh<amount> received from
     *  <NAME> <phone>, on <...>New M-PESA balance is KES <bal>."`
     *
     * The parser keys off "Ksh<amount>", "from <name> <10-digit phone>" and the
     * "on d/M/yy at h:mm AM" stamp, so all three must be present and spaced the
     * same way the operator sends them.
     */
    fun incomingPaymentSms(
        receipt: String,
        name: String,
        phone: String,
        amount: Double,
        newBalance: Double,
        timestamp: Long
    ): String {
        val (stamp, confirmStamp) = hybridStamps(timestamp)
        return "${receipt} Confirmed.on ${stamp}Ksh${amount(amount)} received from " +
            "$name $phone, on ${confirmStamp}New M-PESA balance is KES ${amount(newBalance)}. " +
            "Transaction cost, KES 0.00."
    }

    /** Safaricom's commission summary, as the app parses it. */
    fun commissionSms(commission: Double, timestamp: Long): String {
        val (stamp, _) = hybridStamps(timestamp)
        return "M-PESA Commission is Ksh.${amount(commission)} on $stamp"
    }

    /** "1,825.50" -> "1,825.50"; 20.0 -> "20.00". Always two decimals. */
    fun amount(value: Double): String = String.format(Locale.US, "%,.2f", value)

    /**
     * Two stamps for one payment: when it was made, and when the confirmation
     * landed (one minute later, as the operator always reports).
     */
    private fun hybridStamps(timestamp: Long): Pair<String, String> =
        hybridStamp(timestamp) to hybridStamp(timestamp + 60_000L)

    /** "23/8/26 at 5:51 PM" — no leading zeros, exactly like the operator. */
    fun hybridStamp(millis: Long): String {
        val cal = Calendar.getInstance().apply { timeInMillis = millis }
        val hour24 = cal.get(Calendar.HOUR_OF_DAY)
        val meridiem = if (hour24 < 12) "AM" else "PM"
        val hour12 = when (hour24 % 12) {
            0 -> 12
            else -> hour24 % 12
        }
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH) + 1
        val year = SimpleDateFormat("yy", Locale.US).format(cal.time)
        val minute = cal.get(Calendar.MINUTE)
        return "$day/$month/$year at $hour12:$minute $meridiem"
    }

    // ── USSD reply formatting (demo dial responses) ──────────────────────────

    /** The success reply the real UssdResponses success-regex matches. */
    fun ussdSuccessReply(offerName: String): String =
        "You have successfully purchased $offerName. Kindly wait as we process your request."

    /** The rejection that maps to FAILED_ALREADY_RECOMMENDED. */
    fun ussdAlreadyRecommendedReply(): String =
        "Bundle for this number has already been recommended."

    /** The network failure that trips the retry path. */
    fun ussdConnectionProblemReply(): String = "Connection problem or invalid MMI code"

    // ── Seeding helpers ───────────────────────────────────────────────────────

    /** Statuses weighted the way a real month looks: mostly successful. */
    fun statusFor(random: Random): String {
        val roll = random.nextInt(100)
        return when {
            roll < 62 -> "SUCCESSFUL"
            roll < 74 -> "FAILED"
            roll < 82 -> "FAILED_ALREADY_RECOMMENDED"
            roll < 92 -> "PENDING"
            roll < 97 -> "PROCESSING"
            else -> "SCHEDULED"
        }
    }

    /** Commission is ~10% of the bundle, the usual M-Pesa agent rate. */
    /** How far back demo transactions are spread across the month. */
    const val HISTORY_DAYS = 30

    /** Commission summaries arrive on their own cadence. */
    fun simulatedBalance(current: Double, random: Random): Double {
        val drift = (random.nextDouble() - 0.35) * 60.0
        return Math.max(25.0, Math.min(5_000.0, current + drift))
    }

    fun commissionFor(price: Double): Double = Math.round(price * 0.1 * 100.0) / 100.0
}

    /** How far back those transactions are spread. */
