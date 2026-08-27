package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
) {
    suspend fun login(email: String, password: String) {
        // Mock login for now
        userPreferences.saveTokens("mock_access_token", "mock_refresh_token")
        userPreferences.saveUserId("mock_user_id")
        userPreferences.saveUserInfo("0712345678", "Bingwa Agent")
    }

    suspend fun signup(email: String, password: String) {
        // Mock signup
        userPreferences.saveTokens("mock_access_token", "mock_refresh_token")
        userPreferences.saveUserId("mock_user_id")
        userPreferences.saveUserInfo("0712345678", "Bingwa Agent")
    }

    suspend fun logout() {
        userPreferences.clear()
    }
}
