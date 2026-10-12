package com.bingwascore.app.domain

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.util.isTenDigitPhone
import java.util.Calendar
import java.util.UUID

/**
 * Stage 15 — Self-Renewal scheduling, as pure logic.
 *
 * A renewal is a SCHEDULED transaction: the agent picks an offer, a phone and a
 * datetime; the app stores a row the engine already understands (`SCHEDULED` +
 * `scheduledAt`), arms a WorkManager alarm for that instant, and when it fires
 * the normal pipeline dials it. On success the row becomes SUCCESSFUL and drops
 * out of the Self-Renewal list (it now lives in Completed transactions) — so
 * "the item auto-removes" is just the ledger telling the truth.
 *
 * Pure + JVM-tested; persistence is Room and the dial is [TransactionPipeline].
 */
object SelfRenewalSchedule {

    /** The agent's draft before it becomes a SCHEDULED row. */
    data class Draft(
        val offerId: String,
        val offerName: String,
        val ussdCode: String,
        val phone: String,
        val amount: Double,
        val commission: Double,
        val fireAt: Long
    )

    /**
     * Validation, returns null when the draft is schedulable or the exact reason
     * it is not. A renewal must have an offer, a real ten-digit phone and a fire
     * time in the future (never "now" — the alarm needs lead time).
     */
    fun validate(draft: Draft, now: Long): String? = when {
        draft.offerId.isBlank() || draft.offerName.isBlank() -> "Pick an offer to renew"
        draft.phone.isBlank() -> "Enter the customer's phone number"
        !isTenDigitPhone(draft.phone) -> "That phone number is not a valid 10-digit number"
        draft.fireAt <= now -> "Pick a time in the future"
        else -> null
    }

    /** True once the alarm instant has arrived. */
    fun isDue(fireAt: Long, now: Long): Boolean = fireAt <= now

    /** Milliseconds until [fireAt] (never negative) — the alarm's initial delay. */
    fun delayMillis(fireAt: Long, now: Long): Long = (fireAt - now).coerceAtLeast(0L)

    /**
     * Builds the SCHEDULED ledger row for [draft]. The USSD code carries only the
     * phone substituted (never a raw `ph`), matching the live purchase path.
     */
    fun toScheduledTx(draft: Draft, now: Long): Transaction = Transaction(
        id = "SR-${UUID.randomUUID()}",
        phoneNumber = draft.phone,
        customerName = null,
        offerId = draft.offerId,
        offerName = draft.offerName,
        ussdCode = draft.ussdCode,
        amount = draft.amount,
        commission = draft.commission,
        status = TransactionStatus.SCHEDULED.value,
        createdAt = now,
        scheduledAt = draft.fireAt,
        isAutoRenewal = true
    )

    /**
     * The countdown chip label: "2d 3h", "5h 12m", "45m", or "any moment" once
     * it is due. Shared so the list and any future notification read the same.
     */
    fun countdownLabel(fireAt: Long, now: Long): String {
        val totalSeconds = ((fireAt - now).coerceAtLeast(0L)) / 1000
        val days = totalSeconds / 86_400
        val hours = (totalSeconds % 86_400) / 3_600
        val minutes = (totalSeconds % 3_600) / 60
        return when {
            days > 0 -> "${days}d ${hours}h"
            hours > 0 -> "${hours}h ${minutes}m"
            minutes > 0 -> "${minutes}m"
            else -> "any moment"
        }
    }

    /** True when the countdown is under an hour — the chip turns urgent. */
    fun isUrgent(fireAt: Long, now: Long): Boolean =
        isDue(fireAt, now) || (fireAt - now) < 60L * 60 * 1000

    /** The hour-of-day (0..23) a fire time lands on — used by the picker chips. */
    fun hourOfDay(at: Long): Int =
        Calendar.getInstance().apply { timeInMillis = at }.get(Calendar.HOUR_OF_DAY)
}
