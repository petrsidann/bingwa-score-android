package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class TransactionStatus {
    PENDING,
    PROCESSING,
    AWAITING_COMMISSION,
    SUCCESSFUL,
    FAILED,
    SCHEDULED,
    CANCELLED
}

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val phoneNumber: String,
    val customerName: String?,
    val offerId: String,
    val offerName: String,
    val ussdCode: String,
    val amount: Double,
    val commission: Double,
    val status: TransactionStatus,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val scheduledAt: Long? = null,
    val completedAt: Long? = null,
    val mpesaReceipt: String?,
    val commissionMessage: String?,
    val errorMessage: String?,
    val retryCount: Int = 0,
    val isAutoRenewal: Boolean = false,
    val parentTransactionId: String? = null
)
