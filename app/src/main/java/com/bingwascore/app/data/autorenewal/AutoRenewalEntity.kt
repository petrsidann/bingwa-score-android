package com.bingwascore.app.data.autorenewal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auto_renewals")
data class AutoRenewalEntity(
    @PrimaryKey val id: String,
    val offerId: String,
    val customerId: String,
    val interval: String,
    val nextRenewalAtMillis: Long,
    val isActive: Boolean,
    val createdAtMillis: Long
)
