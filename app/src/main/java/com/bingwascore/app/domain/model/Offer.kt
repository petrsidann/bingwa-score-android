package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class OfferType { DATA, MINUTES, SMS, BUNDLE, CUSTOM }

enum class OfferTag { DAILY, WEEKLY, MONTHLY, POPULAR, BEST_VALUE }

@Entity(tableName = "offers")
data class Offer(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val ussdCode: String,
    val price: Int,
    val type: OfferType,
    val tag: OfferTag? = null,
    val description: String = "",
    val isActive: Boolean = true,
    val requiresTopUp: Boolean = false,
    val topUpAmount: Int? = null,
    val completionMessage: String? = null,
    val commissionMessage: String? = null,
    val autoRenewable: Boolean = false,
    val validityHours: Int = 24,
    val autoReschedule: Boolean = false,
    val autoRescheduleRunTime: String = "01:00",
    val isVerified: Boolean = false,
    val isDirty: Boolean = false,
    val autoRetryConnectionProblems: Boolean = false,
    val autoRetry: Boolean = true,
    val numberOfRetries: Int = 2,
    val retryIntervalMins: Int = 1,
    val ussdTimeoutMillis: Long = 40000L,
    val relayDevice: String? = null,
    val strictMode: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
