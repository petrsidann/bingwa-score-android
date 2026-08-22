package com.bingwascore.app.data.repository

import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.data.remote.dto.CheckoutRequest
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.domain.model.Order
import com.bingwascore.app.util.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class BundleRepository @Inject constructor(
    private val api: ApiService,
    private val authRepository: AuthRepository
) {
    suspend fun getBundles(type: String? = null): Resource<List<Bundle>> = try {
        val response = api.getBundles(authRepository.authHeader(), type)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.bundles)
        } else {
            Resource.Error("Failed to load bundles")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun checkout(bundleId: String, recipientPhone: String): Resource<Order> = try {
        val response = api.checkout(
            authRepository.authHeader(),
            CheckoutRequest(bundleId, recipientPhone)
        )
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.order)
        } else {
            Resource.Error("Checkout failed")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun getOrder(orderId: String): Resource<Order> = try {
        val response = api.getOrder(authRepository.authHeader(), orderId)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.order)
        } else {
            Resource.Error("Failed to load order")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun getOrders(type: String? = null): Resource<List<Order>> = try {
        val response = api.getOrders(authRepository.authHeader(), type)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.orders)
        } else {
            Resource.Error("Failed to load orders")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }
}
