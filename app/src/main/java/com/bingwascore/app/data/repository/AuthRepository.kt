package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.util.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
) {
    suspend fun login(phone: String?, email: String?, password: String): Resource<User> {
        return try {
            // Mock login for now
            val mockUser = User(
                id = "mock_user_123",
                fullName = "Test User",
                phone = phone ?: "0700000000",
                email = email,
                role = "customer"
            )
            userPreferences.saveTokens("mock_access_token", "mock_refresh_token")
            userPreferences.saveUserId(mockUser.id)
            Resource.Success(mockUser)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Login failed")
        }
    }
    
    suspend fun signup(fullName: String, phone: String, email: String?, password: String): Resource<User> {
        return try {
            // Mock signup for now
            val mockUser = User(
                id = "mock_user_${System.currentTimeMillis()}",
                fullName = fullName,
                phone = phone,
                email = email,
                role = "customer"
            )
            userPreferences.saveTokens("mock_access_token", "mock_refresh_token")
            userPreferences.saveUserId(mockUser.id)
            Resource.Success(mockUser)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Signup failed")
        }
    }
    
    suspend fun logout() {
        userPreferences.clear()
    }
    
    suspend fun getAccessToken(): String? = userPreferences.accessToken.first()
    
    suspend fun isLoggedIn(): Boolean = userPreferences.isLoggedIn.first()
    
    fun authHeader(): String {
        val token = kotlinx.coroutines.runBlocking { userPreferences.accessToken.first() }
        return "Bearer ${token ?: "mock_token"}"
    }
}
