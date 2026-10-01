package com.bingwascore.app.domain

import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.util.formatPhoneToTenDigits
import com.bingwascore.app.util.isTenDigitPhone

/** One queued dial inside a silent batch. */
data class BatchDialTarget(
    val offerId: String,
    val offerName: String,
    val phoneNumber: String,
    /** USSD code with the customer number already expanded in. */
    val ussdCode: String,
    /** Offer price in Ksh — written onto the queued transaction. */
    val price: Int,
    /** True when the offer is flagged `silentBatch` (no per-dial confirmation). */
    val silent: Boolean
)

/**
 * Parity F — silent batch dial planner.
 *
 * Pure planning logic for the Offers multi-select: it normalises the batch
 * phone, expands each offer's USSD code and orders the queue so the *silent*
 * offers go first, followed by the "advanced" ones the agent had to confirm.
 * The screen/ViewModel only decides *when* to ask; the ordering and expansion
 * rules live here so they can be unit-tested without Android.
 */
object BatchDialPlanner {

    /** Gap between two queued dials so consecutive USSD sessions never overlap. */
    const val GAP_MILLIS = 3_000L

    /** True when any selected offer is not flagged silent (one confirm dialog). */
    fun requiresConfirmation(offers: List<Offer>): Boolean = offers.any { !it.silentBatch }

    /** The offers that force the single confirmation dialog, in list order. */
    fun confirmationTargets(offers: List<Offer>): List<Offer> = offers.filter { !it.silentBatch }

    /** Dialog body: one line per advanced offer, e.g. "- Ksh 20 Data". */
    fun confirmationMessage(offers: List<Offer>): String =
        confirmationTargets(offers).joinToString(separator = "\n") { "- ${it.name}" }

    /**
     * PREMIUM LOCK — "Ghost Queue": the toast shown once the queue is running.
     * Runs in the background, one dial at a time, with no per-dial prompts.
     */
    fun queuedMessage(queued: Int): String = "Ghost Queue running — $queued dial(s) queued"

    /**
     * Expands the customer number into [ussdCode] (`ph`, and legacy `BH`, both
     * case-insensitive) exactly like the dialer does.
     */
    fun expand(ussdCode: String, phone: String): String =
        ussdCode.replace("ph", phone).replace("BH", phone, true)

    /**
     * Builds the dial queue for [offers] against [phoneRaw]: silent offers
     * first, then the advanced ones, each with its USSD code expanded. Returns
     * an empty list when the phone is not a canonical ten-digit number, so a
     * bad number can never start a queue.
     */
    fun plan(offers: List<Offer>, phoneRaw: String): List<BatchDialTarget> {
        val phone = formatPhoneToTenDigits(phoneRaw)
        if (!isTenDigitPhone(phone)) return emptyList()
        val ordered = offers.filter { it.silentBatch } + offers.filter { !it.silentBatch }
        return ordered.map { offer ->
            BatchDialTarget(
                offerId = offer.id,
                offerName = offer.name,
                phoneNumber = phone,
                ussdCode = expand(offer.ussdCode, phone),
                price = offer.price,
                silent = offer.silentBatch
            )
        }
    }
}