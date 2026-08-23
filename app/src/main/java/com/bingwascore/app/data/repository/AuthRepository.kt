package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: ApiService,
    private val preferences: UserPreferences
) {
    suspend fun signup(
        fullName: String,
        phone: String,
        email: String?,
        password: String
    ): Resource<User> {
        delay(1500)
        
        if (fullName.isBlank() || phone.isBlank() || password.length < 6) {
            return Resource.Error("Invalid input data")
        }
        
        val mockUser = User(
            id = "mock_user_${System.currentTimeMillis()}",
            fullName = fullName,
            phone = phone,
            email = email,
            role = "customer"
        )
        
        preferences.saveTokens("mock_access_token", "mock_refresh_token")
        preferences.saveUserId(mockUser.id)
        
        return Resource.Success(mockUser)
    }

    suspend fun login(phone: String?, email: String?, password: String): Resource<User> {
        delay(1000)
        
        if (password.length < 6) {
            return Resource.Error("Password must be at least 6 characters")
        }
        
        val mockUser = User(
            id = "mock_user_123",
            fullName = phone?.substring(0, 4)?.uppercase() + " USER" ?: "MOCK USER",
            phone = phone ?: "0700000000",
            email = email,
            role = "customer"
        )
        
        preferences.saveTokens("mock_access_token", "mock_refresh_token")
        preferences.saveUserId(mockUser.id)
        
        return Resource.Success(mockUser)
    }

    suspend fun logout() {
        preferences.clear()
    }

    suspend fun getAccessToken(): String? = preferences.accessToken.first()

    suspend fun isLoggedIn(): Boolean = preferences.accessToken.first() != null

    fun authHeader(): String {
        val token = kotlinx.coroutines.runBlocking { preferences.accessToken.first() }
        return "Bearer ${token ?: "mock_token"}"
    }
}
