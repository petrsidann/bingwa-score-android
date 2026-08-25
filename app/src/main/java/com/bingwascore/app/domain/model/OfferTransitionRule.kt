package com.bingwascore.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "offer_transition_rules")
data class OfferTransitionRule(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val sourceOfferId: String,
    val sourceStatus: String,
    val requireTopUp: Boolean = false,
    val topUpMessage: String? = null,
    val nextOfferId: String,
    val priority: Int = 0
)
