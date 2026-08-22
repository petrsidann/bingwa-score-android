package com.bingwascore.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bingwascore.app.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_PREFERENCES)

class UserPreferences(private val context: Context) {

    private val accessTokenKey = stringPreferencesKey(Constants.KEY_ACCESS_TOKEN)
    private val refreshTokenKey = stringPreferencesKey(Constants.KEY_REFRESH_TOKEN)
    private val userIdKey = stringPreferencesKey(Constants.KEY_USER_ID)
    private val themeModeKey = intPreferencesKey(Constants.KEY_THEME_MODE)

    val accessToken: Flow<String?> = context.dataStore.data.map { it[accessTokenKey] }
    val refreshToken: Flow<String?> = context.dataStore.data.map { it[refreshTokenKey] }
    val userId: Flow<String?> = context.dataStore.data.map { it[userIdKey] }
    val themeMode: Flow<Int> = context.dataStore.data.map { it[themeModeKey] ?: 0 }

    suspend fun saveTokens(accessToken: String, refreshToken: String) {
        context.dataStore.edit {
            it[accessTokenKey] = accessToken
            it[refreshTokenKey] = refreshToken
        }
    }

    suspend fun saveUserId(id: String) {
        context.dataStore.edit { it[userIdKey] = id }
    }

    suspend fun setThemeMode(mode: Int) {
        context.dataStore.edit { it[themeModeKey] = mode }
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}
