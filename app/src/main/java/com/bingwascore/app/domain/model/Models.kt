package com.bingwascore.app.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: String,
    @Json(name = "fullName") val fullName: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "email") val email: String? = null,
    @Json(name = "role") val role: String = "customer"
)

@JsonClass(generateAdapter = true)
data class Bundle(
    @Json(name = "id") val id: String,
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String,
    @Json(name = "size") val size: String,
    @Json(name = "validity") val validity: String,
    @Json(name = "costPrice") val costPrice: Double,
    @Json(name = "salePrice") val salePrice: Double,
    @Json(name = "active") val active: Boolean = true
)

@JsonClass(generateAdapter = true)
data class Order(
    @Json(name = "id") val id: String,
    @Json(name = "bundleId") val bundleId: String,
    @Json(name = "recipientPhone") val recipientPhone: String,
    @Json(name = "amount") val amount: Double,
    @Json(name = "status") val status: String,
    @Json(name = "mpesaReceiptNumber") val mpesaReceiptNumber: String? = null,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "bundle") val bundle: Bundle? = null
)
