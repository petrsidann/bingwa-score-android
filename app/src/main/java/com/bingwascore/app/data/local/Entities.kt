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
    // ── Parity F ──
    /**
     * Silent batch dial: when true the offer is queued from the Offers
     * multi-select without any per-dial confirmation dialog. When false the
     * batch dial asks once for the whole "advanced" group.
     */
    val silentBatch: Boolean = false
)

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
