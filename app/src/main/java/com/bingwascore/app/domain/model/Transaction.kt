package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class TransactionStatus {
    PENDING,
    UNMATCHED,
    SCHEDULED,
    PROCESSING,
    AWAITING_COMMISSION,
    SUCCESSFUL,
    FAILED,
    FAILED_ALREADY_RECOMMENDED,
    PAUSED,
    CANCELLED
}

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val phoneNumber: String,
    val customerName: String? = null,
    val offerId: String,
    val offerName: String,
    val ussdCode: String,
    val amount: Double,
    val commission: Double = 0.0,
    val status: TransactionStatus,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val scheduledAt: Long? = null,
    val completedAt: Long? = null,
    val mpesaReceipt: String? = null,
    val commissionMessage: String? = null,
    val errorMessage: String? = null,
    val retryCount: Int = 0,
    val isAutoRenewal: Boolean = false,
    val parentTransactionId: String? = null
)
