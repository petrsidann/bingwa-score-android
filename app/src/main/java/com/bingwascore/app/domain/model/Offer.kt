package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class OfferType {
    DATA,
    MINUTES,
    SMS,
    BUNDLE,
    CUSTOM
}

@Entity(tableName = "offers")
data class Offer(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: OfferType,
    val description: String,
    val ussdCode: String,
    val completionMessage: String,
    val commissionMessage: String?,
    val price: Double,
    val commissionRate: Double,
    val isActive: Boolean = true,
    val isAutoRenewable: Boolean = false,
    val autoRenewInterval: Long? = null, // in milliseconds
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val category: String? = null,
    val validity: String? = null,
    val size: String? = null
)
