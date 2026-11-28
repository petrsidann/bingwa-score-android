package com.bingwascore.app.domain.autorenewal

import androidx.compose.runtime.Immutable
import java.time.Instant

@Immutable
data class AutoRenewal(
    val id: String,
    val offerId: String,
    val customerId: String,
    val interval: RenewInterval,
    val nextRenewalAt: Instant,
    val isActive: Boolean,
    val createdAt: Instant
)

enum class RenewInterval { DAILY, WEEKLY, BIWEEKLY, MONTHLY }
