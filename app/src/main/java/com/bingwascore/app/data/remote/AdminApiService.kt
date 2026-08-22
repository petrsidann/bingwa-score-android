package com.bingwascore.app.data.remote

import com.bingwascore.app.data.remote.dto.AdminBundleRequest
import com.bingwascore.app.data.remote.dto.AdminBundlesResponse
import com.bingwascore.app.data.remote.dto.AdminDashboardResponse
import com.bingwascore.app.data.remote.dto.AdminOrdersResponse
import com.bingwascore.app.data.remote.dto.AdminUsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AdminApiService {

    @GET("api/admin/dashboard")
    suspend fun getDashboard(
        @Header("Authorization") token: String
    ): Response<AdminDashboardResponse>

    @GET("api/admin/bundles")
    suspend fun getBundles(
        @Header("Authorization") token: String
    ): Response<AdminBundlesResponse>

    @POST("api/admin/bundles")
    suspend fun createBundle(
        @Header("Authorization") token: String,
        @Body request: AdminBundleRequest
    ): Response<com.bingwascore.app.domain.model.Bundle>

    @PUT("api/admin/bundles/{id}")
    suspend fun updateBundle(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body request: AdminBundleRequest
    ): Response<com.bingwascore.app.domain.model.Bundle>

    @DELETE("api/admin/bundles/{id}")
    suspend fun deleteBundle(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<Map<String, String>>

    @GET("api/admin/orders")
    suspend fun getOrders(
        @Header("Authorization") token: String,
        @Query("status") status: String? = null,
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 0
    ): Response<AdminOrdersResponse>

    @GET("api/admin/users")
    suspend fun getUsers(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 0
    ): Response<AdminUsersResponse>
}
