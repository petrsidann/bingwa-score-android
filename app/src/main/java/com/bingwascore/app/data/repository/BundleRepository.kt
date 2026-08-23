package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.domain.model.Order
import com.bingwascore.app.util.Resource
import kotlinx.coroutines.delay
import javax.inject.Inject

class BundleRepository @Inject constructor(
    private val api: ApiService,
    private val preferences: UserPreferences
) {
    suspend fun getBundles(type: String? = null): Resource<List<Bundle>> {
        // MOCK - Return sample bundles
        delay(800)
        
        val mockBundles = listOf(
            Bundle(
                id = "1",
                type = "data",
                name = "500MB Daily",
                size = "500MB",
                validity = "24 hours",
                costPrice = 45.0,
                salePrice = 50.0,
                active = true
            ),
            Bundle(
                id = "2",
                type = "data",
                name = "1GB Weekly",
                size = "1GB",
                validity = "7 days",
                costPrice = 90.0,
                salePrice = 100.0,
                active = true
            ),
            Bundle(
                id = "3",
                type = "minutes",
                name = "100 Minutes",
                size = "100 mins",
                validity = "30 days",
                costPrice = 90.0,
                salePrice = 100.0,
                active = true
            ),
            Bundle(
                id = "4",
                type = "sms",
                name = "200 SMS",
                size = "200 SMS",
                validity = "30 days",
                costPrice = 45.0,
                salePrice = 50.0,
                active = true
            )
        )
        
        val filtered = if (type != null) {
            mockBundles.filter { it.type == type }
        } else {
            mockBundles
        }
        
        return Resource.Success(filtered)
    }

    suspend fun checkout(bundleId: String, recipientPhone: String): Resource<Order> {
        // MOCK - Simulate checkout
        delay(1000)
        
        val mockOrder = Order(
            id = "order_${System.currentTimeMillis()}",
            bundleId = bundleId,
            recipientPhone = recipientPhone,
            amount = 50.0,
            status = "pending",
            mpesaReceiptNumber = null,
            createdAt = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", java.util.Locale.getDefault()).format(java.util.Date()),
            bundle = null
        )
        
        return Resource.Success(mockOrder)
    }

    suspend fun getOrder(orderId: String): Resource<Order> {
        // MOCK - Simulate order status progression
        delay(500)
        
        val mockOrder = Order(
            id = orderId,
            bundleId = "1",
            recipientPhone = "0700000000",
            amount = 50.0,
            status = "delivered",
            mpesaReceiptNumber = "MPS${System.currentTimeMillis()}",
            createdAt = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", java.util.Locale.getDefault()).format(java.util.Date()),
            bundle = Bundle(
                id = "1",
                type = "data",
                name = "500MB Daily",
                size = "500MB",
                validity = "24 hours",
                costPrice = 45.0,
                salePrice = 50.0,
                active = true
            )
        )
        
        return Resource.Success(mockOrder)
    }

    suspend fun getOrders(type: String? = null): Resource<List<Order>> {
        // MOCK - Return empty list
        delay(500)
        return Resource.Success(emptyList())
    }
}
