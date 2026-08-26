package com.bingwascore.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sitelink")
data class SiteLinkEntity(
    @PrimaryKey
    val id: String,
    val siteName: String,
    val accountType: String,
    val accountNumber: String,
    val siteLinkURL: String,
    val isActive: Boolean,
    val username: String
)
