package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class OfferType {
    DATA, MINUTES, SMS, BUNDLE, CUSTOM
}

enum class OfferTag {
    DAILY, WEEKLY, MONTHLY, POPULAR, BEST_VALUE
}

@Entity(tableName = "offers")
data class Offer(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val ussdCode: String,           // e.g., "*180*5*2#"
    val price: Int,                 // e.g., 20 (KES)
    val type: OfferType,
    val tag: OfferTag? = null,
    val description: String = "",
    val isActive: Boolean = true,
    val requiresTopUp: Boolean = false,
    val topUpAmount: Int? = null,
    val completionMessage: String? = null,  // Message to detect success
    val commissionMessage: String? = null,  // Message to detect commission
    val autoRenewable: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
