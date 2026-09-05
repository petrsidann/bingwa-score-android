package com.bingwascore.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "bingwa_prefs")

/**
 * Single source of truth for lightweight app state (login, theme, balance...).
 */
@Singleton
class UserPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object Keys {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val USER_NAME = stringPreferencesKey("user_name")
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val STATS_AIRTIME_BALANCE = doublePreferencesKey("stats_airtime_balance")
        val APP_PROCESSING_MODE = stringPreferencesKey("app_processing_mode")
        val ENGAGE_BOT_ACTIVE = booleanPreferencesKey("engage_bot_active")
        val STORE_LINK = stringPreferencesKey("store_link")
        val STORE_ACTIVE = booleanPreferencesKey("store_active")
        val DEVICE_ID = stringPreferencesKey("device_id")
        val MESH_SERVER_URL = stringPreferencesKey("mesh_server_url")
        val MESH_CONNECTED = booleanPreferencesKey("mesh_connected")
        val SIM_SELECTION = stringPreferencesKey("sim_selection")
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { it[Keys.IS_LOGGED_IN] ?: false }
    val userName: Flow<String> = context.dataStore.data.map { it[Keys.USER_NAME] ?: "Bingwa User" }
    val themeMode: Flow<ThemeMode> =
        context.dataStore.data.map { ThemeMode.fromValue(it[Keys.THEME_MODE]) }
    val airtimeBalance: Flow<Double> =
        context.dataStore.data.map { it[Keys.STATS_AIRTIME_BALANCE] ?: 0.0 }
    val processingMode: Flow<AppProcessingMode> =
        context.dataStore.data.map { AppProcessingMode.fromValue(it[Keys.APP_PROCESSING_MODE]) }
    val engageBotActive: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.ENGAGE_BOT_ACTIVE] ?: false }
    val storeLink: Flow<String> = context.dataStore.data.map { it[Keys.STORE_LINK] ?: "" }
    val storeActive: Flow<Boolean> = context.dataStore.data.map { it[Keys.STORE_ACTIVE] ?: false }
    val deviceId: Flow<String> = context.dataStore.data.map { it[Keys.DEVICE_ID] ?: "" }
    val meshServerUrl: Flow<String> = context.dataStore.data.map { it[Keys.MESH_SERVER_URL] ?: "" }
    val meshConnected: Flow<Boolean> = context.dataStore.data.map { it[Keys.MESH_CONNECTED] ?: false }
    val simSelection: Flow<String> = context.dataStore.data.map { it[Keys.SIM_SELECTION] ?: SIM_1 }

    suspend fun setLoggedIn(value: Boolean) = edit { it[Keys.IS_LOGGED_IN] = value }

    suspend fun setUserName(value: String) = edit { it[Keys.USER_NAME] = value }

    suspend fun setThemeMode(value: ThemeMode) = edit { it[Keys.THEME_MODE] = value.value }

    suspend fun setAirtimeBalance(value: Double) = edit { it[Keys.STATS_AIRTIME_BALANCE] = value }

    suspend fun setProcessingMode(value: AppProcessingMode) =
        edit { it[Keys.APP_PROCESSING_MODE] = value.value }

    suspend fun setEngageBotActive(value: Boolean) = edit { it[Keys.ENGAGE_BOT_ACTIVE] = value }

    suspend fun setStoreLink(value: String) = edit { it[Keys.STORE_LINK] = value }

    suspend fun setStoreActive(value: Boolean) = edit { it[Keys.STORE_ACTIVE] = value }

    suspend fun setDeviceId(value: String) = edit { it[Keys.DEVICE_ID] = value }

    suspend fun setMeshServerUrl(value: String) = edit { it[Keys.MESH_SERVER_URL] = value }

    suspend fun setMeshConnected(value: Boolean) = edit { it[Keys.MESH_CONNECTED] = value }

    suspend fun setSimSelection(value: String) = edit { it[Keys.SIM_SELECTION] = value }

    companion object {
        const val SIM_1 = "SIM 1"
        const val SIM_2 = "SIM 2"
    }

    private suspend fun edit(block: (androidx.datastore.preferences.core.MutablePreferences) -> Unit) {
        context.dataStore.edit { block(it) }
    }
}