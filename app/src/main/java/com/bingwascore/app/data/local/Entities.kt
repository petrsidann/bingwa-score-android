package com.bingwascore.app.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A single airtime/bundle purchase attempt.
 * [status] is one of [com.bingwascore.app.domain.TransactionStatus] values, stored as String.
 *
 * Indices: status-filtered lists (incl. scheduled jobs ordered by scheduledAt),
 * per-phone duplicate checks, and createdAt-ordered feeds.
 */
@Entity(
    tableName = "transactions",
    indices = [
        Index("status", "createdAt"),
        Index("status", "scheduledAt"),
        Index("phoneNumber"),
        Index("createdAt")
    ]
)
data class Transaction(
    @PrimaryKey val id: String,
    val phoneNumber: String,
    val customerName: String? = null,
    val offerId: String,
    val offerName: String,
    val ussdCode: String,
    val amount: Double,
    val commission: Double,
    val status: String,
    val createdAt: Long,
    val scheduledAt: Long? = null,
    val mpesaReceipt: String? = null,
    val errorMessage: String? = null,
    val retryCount: Int = 0,
    val isAutoRenewal: Boolean = false,
    val parentTransactionId: String? = null,
    // ── Parity C (Hybrid schema): split retry counters ──
    /** Internal (engine/validation) retry attempts — Hybrid `internalRetries`. */
    val internalRetries: Int = 0,
    /** External (USSD dial / network) retry attempts — Hybrid `externalRetries`. */
    val externalRetries: Int = 0,
    /** Soft-delete tombstone (epoch millis) — Hybrid `deletedAt`; null = live row. */
    val deletedAt: Long? = null,
    /** Raw USSD/SMS reply text captured for this transaction — Hybrid `responseMessage`. */
    val responseMessage: String? = null
)

/** A purchasable Safaricom bundle exposed in the Offers tab / dialer. */
@Entity(
    tableName = "offers",
    indices = [Index("isActive")]
)
data class Offer(
    @PrimaryKey val id: String,
    val name: String,
    val ussdCode: String,
    val price: Int,
    val isActive: Boolean = true,
    val autoRenewable: Boolean = false,
    val validityHours: Int = 24,
    val isVerified: Boolean = false,
    val completionMessage: String? = null,
    val strictMode: Boolean = false,
    val autoRetry: Boolean = false,
    val numberOfRetries: Int = 3,
    val retryIntervalMins: Int = 5,
    val ussdTimeoutMillis: Long = 15000L,
    val autoReschedule: Boolean = false,
    val autoRescheduleRunTime: String = "08:00",
    // ── Parity C (Hybrid schema) ──
    /** Offer tag bucket (Hybrid OfferTag OFFER_1..OFFER_4) — null = untagged. */
    val tag: String? = null,
    /** Hybrid Connect relay device id/name that should serve this offer — null = local. */
    val relayDevice: String? = null,
    // ── U1 — multi-step USSD menu continuation ──
    /**
     * Comma-separated menu steps for this offer's USSD flow ("1,2,1"). Blank
     * means the engine's default choice (`1`) is sent at every menu — never a
     * hard-coded `2`; the wrong parameter is the "Invalid choice" killer.
     */
    val ussdSteps: String = "",
    // ── Parity F ──
    /**
     * Silent batch dial: when true the offer is queued from the Offers
     * multi-select without any per-dial confirmation dialog. When false the
     * batch dial asks once for the whole "advanced" group.
     */
    val silentBatch: Boolean = false,
    // ── MEGA A — full per-offer personality ──
    /**
     * Offer type bucket (AIRTIME / DATA / SMS / COMBO). Drives which tab of the
     * Agent Portal an offer is listed under and how the completion message is
     * worded. Defaults to [TYPE_DATA] so existing offers keep their behaviour.
     */
    val type: String = TYPE_DATA,
    /**
     * Per-offer USSD timeout in SECONDS. The engine multiplies by 1000 when it
     * arms the watchdog — the UI edits seconds (a human-friendly unit) while the
     * engine works in millis.
     */
    val ussdTimeoutSeconds: Int = 20,
    /**
     * When true, a USSD failure caused by the network ("No network", "Unable to
     * process", "Try again later") is treated as retryable even when the offer
     * has [autoRetry] switched off.
     */
    val autoRetryConnectionProblems: Boolean = false,
    /**
     * Locally edited and not yet synced to the server. Set by the offer editor
     * and cleared once a push lands — lets PART B's sync skip dirty rows until
     * the backend is actually configured.
     */
    val isDirty: Boolean = false
) {
    /**
     * True when this offer is redeemable with a promo code on the Redeem Coupon
     * screen. Derived from the tag bucket so it needs no extra column: tagging
     * an offer [TAG_COUPON] is what makes it appear there.
     */
    val isCoupon: Boolean get() = tag == TAG_COUPON

    companion object {
        /** Tag value that marks an offer as coupon-redeemable. */
        const val TAG_COUPON = "COUPON"

        const val TYPE_AIRTIME = "AIRTIME"
        const val TYPE_DATA = "DATA"
        const val TYPE_SMS = "SMS"
        const val TYPE_COMBO = "COMBO"

        /** Types offered in the editor's type dropdown. */
        val TYPES = listOf(TYPE_AIRTIME, TYPE_DATA, TYPE_SMS, TYPE_COMBO)

        /**
         * Effective dial timeout in millis. Prefers the per-offer
         * [ussdTimeoutSeconds]; falls back to the legacy [ussdTimeoutMillis] when
         * an offer predates the seconds field and was never edited.
         */
        fun timeoutMillisFor(offer: Offer): Long =
            if (offer.ussdTimeoutSeconds > 0) offer.ussdTimeoutSeconds * 1000L
            else offer.ussdTimeoutMillis
    }
}

/** A customer identified by phone number. */
@Entity(
    tableName = "customers",
    indices = [Index("isBlacklisted")]
)
data class Customer(
    @PrimaryKey val phoneNumber: String,
    val name: String? = null,
    val isBlacklisted: Boolean = false,
    val createdAt: Long
)

/** A canned SMS reply template used by the auto-reply engine. */
@Entity(
    tableName = "auto_replies",
    indices = [Index("type")]
)
data class AutoReply(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val message: String,
    val type: String,
    val isActive: Boolean = true
)

/**
 * Parity F — commission ledger. One row per Safaricom commission summary SMS
 * ("Total Commission this week is Ksh.1825.1"), mirrored onto the transaction
 * it belongs to ([txId] is blank when no un-commissioned sale was found).
 */
@Entity(
    tableName = "agent_commissions",
    indices = [Index("createdAt")]
)
data class AgentCommission(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    /** Transaction the commission was stamped onto — blank for orphan summaries. */
    val txId: String,
    /** Airtime/bundle amount of that transaction (0.0 for orphan summaries). */
    val amount: Double,
    /** Commission amount reported by Safaricom. */
    val commission: Double,
    val createdAt: Long
)
