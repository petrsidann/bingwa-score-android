package com.bingwascore.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A single airtime/bundle purchase attempt.
 * [status] is one of [com.bingwascore.app.domain.TransactionStatus] values, stored as String.
 */
@Entity(tableName = "transactions")
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
    val parentTransactionId: String? = null
)

/** A purchasable Safaricom bundle exposed in the Offers tab / dialer. */
@Entity(tableName = "offers")
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
    val autoRescheduleRunTime: String = "08:00"
)

/** A customer identified by phone number. */
@Entity(tableName = "customers")
data class Customer(
    @PrimaryKey val phoneNumber: String,
    val name: String? = null,
    val isBlacklisted: Boolean = false,
    val createdAt: Long
)

/** A canned SMS reply template used by the auto-reply engine. */
@Entity(tableName = "auto_replies")
data class AutoReply(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val message: String,
    val type: String,
    val isActive: Boolean = true
)