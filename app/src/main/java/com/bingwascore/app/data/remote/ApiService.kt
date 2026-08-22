package com.bingwascore.app.data.remote

import com.bingwascore.app.data.remote.dto.AuthResponse
import com.bingwascore.app.data.remote.dto.BundlesResponse
import com.bingwascore.app.data.remote.dto.CheckoutRequest
import com.bingwascore.app.data.remote.dto.CheckoutResponse
import com.bingwascore.app.data.remote.dto.LoginRequest
import com.bingwascore.app.data.remote.dto.OrderResponse
import com.bingwascore.app.data.remote.dto.OrdersResponse
import com.bingwascore.app.data.remote.dto.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("api/auth/signup")
    suspend fun signup(@Body request: SignupRequest): Response<AuthResponse>

    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("api/auth/refresh")
    suspend fun refresh(@Body body: Map<String, String>): Response<AuthResponse>

    @GET("api/auth/me")
    suspend fun me(@Header("Authorization") token: String): Response<AuthResponse>

    @GET("api/checkout/bundles")
    suspend fun getBundles(
        @Header("Authorization") token: String,
        @Query("type") type: String? = null
    ): Response<BundlesResponse>

    @POST("api/checkout/create")
    suspend fun checkout(
        @Header("Authorization") token: String,
        @Body request: CheckoutRequest
    ): Response<CheckoutResponse>

    @GET("api/checkout/order/{orderId}")
    suspend fun getOrder(
        @Header("Authorization") token: String,
        @Path("orderId") orderId: String
    ): Response<OrderResponse>

    @GET("api/checkout/orders")
    suspend fun getOrders(
        @Header("Authorization") token: String,
        @Query("type") type: String? = null
    ): Response<OrdersResponse>
}
