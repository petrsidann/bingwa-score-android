package com.bingwascore.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auto_replies")
data class AutoReplyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val message: String,
    val isActive: Boolean = false,
    val type: String,
    val amount: Int? = null
)
