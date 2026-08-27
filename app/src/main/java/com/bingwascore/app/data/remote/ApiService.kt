package com.bingwascore.app.data.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/signup")
    suspend fun signup(@Body request: SignupRequest): SignupResponse

    @GET("offers")
    suspend fun getOffers(): List<OfferDto>

    @POST("transactions")
    suspend fun createTransaction(@Body request: TransactionRequest): TransactionResponse
}

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String, val userId: String)
data class SignupRequest(val email: String, val password: String)
data class SignupResponse(val token: String, val userId: String)
data class OfferDto(val id: String, val name: String, val ussdCode: String, val price: Int)
data class TransactionRequest(val phoneNumber: String, val offerId: String, val amount: Double)
data class TransactionResponse(val id: String, val status: String)
