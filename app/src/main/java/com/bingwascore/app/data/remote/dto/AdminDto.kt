package com.bingwascore.app.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdminBundleRequest(
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String,
    @Json(name = "size") val size: String,
    @Json(name = "validity") val validity: String,
    @Json(name = "costPrice") val costPrice: Double,
    @Json(name = "salePrice") val salePrice: Double,
    @Json(name = "active") val active: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class AdminBundlesResponse(
    @Json(name = "bundles") val bundles: List<com.bingwascore.app.domain.model.Bundle>
)

@JsonClass(generateAdapter = true)
data class AdminDashboardResponse(
    @Json(name = "today") val today: PeriodStats,
    @Json(name = "week") val week: PeriodStats,
    @Json(name = "month") val month: PeriodStats,
    @Json(name = "allTime") val allTime: PeriodStats
)

@JsonClass(generateAdapter = true)
data class PeriodStats(
    @Json(name = "revenue") val revenue: Double,
    @Json(name = "margin") val margin: Double,
    @Json(name = "orders") val orders: Int
)

@JsonClass(generateAdapter = true)
data class AdminOrdersResponse(
    @Json(name = "orders") val orders: List<AdminOrder>,
    @Json(name = "total") val total: Int
)

@JsonClass(generateAdapter = true)
data class AdminOrder(
    @Json(name = "id") val id: String,
    @Json(name = "recipientPhone") val recipientPhone: String,
    @Json(name = "amount") val amount: Double,
    @Json(name = "status") val status: String,
    @Json(name = "mpesaReceiptNumber") val mpesaReceiptNumber: String? = null,
    @Json(name = "deliveryTimeMs") val deliveryTimeMs: Int? = null,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "bundle") val bundle: com.bingwascore.app.domain.model.Bundle? = null,
    @Json(name = "user") val user: AdminOrderUser? = null
)

@JsonClass(generateAdapter = true)
data class AdminOrderUser(
    @Json(name = "id") val id: String,
    @Json(name = "fullName") val fullName: String,
    @Json(name = "phone") val phone: String
)

@JsonClass(generateAdapter = true)
data class AdminUsersResponse(
    @Json(name = "users") val users: List<AdminUser>,
    @Json(name = "total") val total: Int
)

@JsonClass(generateAdapter = true)
data class AdminUser(
    @Json(name = "id") val id: String,
    @Json(name = "fullName") val fullName: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "email") val email: String? = null,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "orderCount") val orderCount: Int = 0,
    @Json(name = "lifetimeSpend") val lifetimeSpend: Double = 0.0
)
