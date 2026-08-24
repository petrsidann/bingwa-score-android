package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "customers")
data class Customer(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val phoneNumber: String,
    val name: String,
    val email: String?,
    val totalTransactions: Int = 0,
    val totalCommission: Double = 0.0,
    val lastTransactionAt: Long? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val isBlacklisted: Boolean = false,
    val notes: String? = null
)
