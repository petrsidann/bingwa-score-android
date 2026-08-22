package com.bingwascore.app.data.repository

import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.data.remote.dto.LoginRequest
import com.bingwascore.app.data.remote.dto.SignupRequest
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.util.Resource
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
    ): Resource<User> = try {
        val response = api.signup(SignupRequest(fullName, phone, email, password))
        if (response.isSuccessful && response.body() != null) {
            val body = response.body()!!
            preferences.saveTokens(body.accessToken, body.refreshToken)
            preferences.saveUserId(body.user.id)
            Resource.Success(body.user)
        } else {
            Resource.Error(response.errorBody()?.string() ?: "Signup failed")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun login(phone: String?, email: String?, password: String): Resource<User> = try {
        val response = api.login(LoginRequest(phone, email, password))
        if (response.isSuccessful && response.body() != null) {
            val body = response.body()!!
            preferences.saveTokens(body.accessToken, body.refreshToken)
            preferences.saveUserId(body.user.id)
            Resource.Success(body.user)
        } else {
            Resource.Error(response.errorBody()?.string() ?: "Login failed")
        }
    } catch (e: Exception) {
        Resource.Error(e.localizedMessage ?: "Network error")
    }

    suspend fun logout() {
        preferences.clear()
    }

    suspend fun getAccessToken(): String? = preferences.accessToken.first()

    suspend fun isLoggedIn(): Boolean = preferences.accessToken.first() != null

    fun authHeader(): String {
        val token = kotlinx.coroutines.runBlocking { preferences.accessToken.first() }
        return "Bearer $token"
    }
}
