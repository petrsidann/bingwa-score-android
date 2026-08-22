package com.bingwascore.app.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignupRequest(
    @Json(name = "fullName") val fullName: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "email") val email: String? = null,
    @Json(name = "password") val password: String
)

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "phone") val phone: String? = null,
    @Json(name = "email") val email: String? = null,
    @Json(name = "password") val password: String
)

@JsonClass(generateAdapter = true)
data class AuthResponse(
    @Json(name = "user") val user: com.bingwascore.app.domain.model.User,
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String
)

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "error") val error: String? = null
)

@JsonClass(generateAdapter = true)
data class BundlesResponse(
    @Json(name = "bundles") val bundles: List<com.bingwascore.app.domain.model.Bundle>
)

@JsonClass(generateAdapter = true)
data class OrdersResponse(
    @Json(name = "orders") val orders: List<com.bingwascore.app.domain.model.Order>,
    @Json(name = "total") val total: Int = 0
)

@JsonClass(generateAdapter = true)
data class CheckoutRequest(
    @Json(name = "bundleId") val bundleId: String,
    @Json(name = "recipientPhone") val recipientPhone: String
)

@JsonClass(generateAdapter = true)
data class CheckoutResponse(
    @Json(name = "order") val order: com.bingwascore.app.domain.model.Order,
    @Json(name = "mpesa") val mpesa: MpesaInfo
)

@JsonClass(generateAdapter = true)
data class MpesaInfo(
    @Json(name = "checkoutRequestID") val checkoutRequestID: String,
    @Json(name = "responseDescription") val responseDescription: String?,
    @Json(name = "customerMessage") val customerMessage: String?,
    @Json(name = "simulated") val simulated: Boolean = false
)

@JsonClass(generateAdapter = true)
data class OrderResponse(
    @Json(name = "order") val order: com.bingwascore.app.domain.model.Order
)
