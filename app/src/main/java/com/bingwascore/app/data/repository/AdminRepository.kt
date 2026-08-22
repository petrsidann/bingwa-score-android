package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.AdminApiService
import com.bingwascore.app.data.remote.dto.AdminBundleRequest
import com.bingwascore.app.data.remote.dto.AdminDashboardResponse
import com.bingwascore.app.data.remote.dto.AdminOrder
import com.bingwascore.app.data.remote.dto.AdminUser
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.util.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AdminRepository @Inject constructor(
    private val adminApi: AdminApiService,
    private val preferences: UserPreferences
) {
    private suspend fun authHeader(): String {
        val token = preferences.accessToken.first() ?: ""
        return "Bearer $token"
    }

    suspend fun getDashboard(): Resource<AdminDashboardResponse> = try {
        val response = adminApi.getDashboard(authHeader())
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error("Failed to load dashboard")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun getBundles(): Resource<List<Bundle>> = try {
        val response = adminApi.getBundles(authHeader())
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.bundles)
        } else {
            Resource.Error("Failed to load bundles")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun createBundle(request: AdminBundleRequest): Resource<Bundle> = try {
        val response = adminApi.createBundle(authHeader(), request)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error("Failed to create bundle")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun updateBundle(id: String, request: AdminBundleRequest): Resource<Bundle> = try {
        val response = adminApi.updateBundle(authHeader(), id, request)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error("Failed to update bundle")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun deleteBundle(id: String): Resource<Unit> = try {
        val response = adminApi.deleteBundle(authHeader(), id)
        if (response.isSuccessful) {
            Resource.Success(Unit)
        } else {
            Resource.Error("Failed to delete bundle")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun getOrders(status: String? = null): Resource<List<AdminOrder>> = try {
        val response = adminApi.getOrders(authHeader(), status)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.orders)
        } else {
            Resource.Error("Failed to load orders")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun getUsers(): Resource<List<AdminUser>> = try {
        val response = adminApi.getUsers(authHeader())
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.users)
        } else {
            Resource.Error("Failed to load users")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }
}
