package com.bingwascore.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.AppState
import com.bingwascore.app.domain.ProcessingActivity
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
        val ENGINE_ENABLED = booleanPreferencesKey("engine_enabled")
        val ENGINE_STATE = stringPreferencesKey("engine_state")
        val SETUP_COMPLETE = booleanPreferencesKey("setup_complete")
        val PHONE = stringPreferencesKey("user_phone")
        // Parity F — last dialled customer number, prefilled into the silent batch.
        val LAST_DIAL_PHONE = stringPreferencesKey("last_dial_phone")
        val REFERRAL_CODE = stringPreferencesKey("referral_code")
        val REFERRAL_COUNT = stringPreferencesKey("referral_count")
        val ONBOARDING_DONE = booleanPreferencesKey("onboarding_done")
        val ANNOUNCEMENTS_SEEDED = booleanPreferencesKey("announcements_seeded")
        // ── MEGA A — startup gate + aliveness ──
        /** Mirrors their APP_STATE key: STATE_RUNNING / STATE_STOPPED / STATE_SETUP. */
        val APP_STATE = stringPreferencesKey("app_state")
        /** Engine activity shown on the persistent notification (idle/dialing/reply). */
        val ENGINE_ACTIVITY = stringPreferencesKey("app_processing_mode")
        /** MEGA A — inbound message routing switches (both default ON). */
        val PROCESS_MPESA_MESSAGES = booleanPreferencesKey("process_mpesa_messages")
        val PROCESS_SITELINK_MESSAGES = booleanPreferencesKey("process_sitelink_messages")
        /** MEGA B — the push token, stored locally even when no server exists. */
        val FCM_TOKEN = stringPreferencesKey("fcm_token")
        /** POLISH P2 — cold-start counter that keys the rotating greeting. */
        val GREETING_SESSION = intPreferencesKey("greeting_session")
        // ── Stage 12 — Diplomatics + plan-backed credits ──
        /** Pinned greeting language (Language.name); blank = keep rotating. */
        val GREETING_PINNED_LANGUAGE = stringPreferencesKey("greeting_pinned_language")
        /** Rotation cadence: "session" (default) or "day". */
        val GREETING_CADENCE = stringPreferencesKey("greeting_cadence")
        /** Active plan, as the credits bubble reads it (Stage 13 fills on purchase). */
        val PLAN_ID = stringPreferencesKey("plan_id")
        val PLAN_DISPLAY_NAME = stringPreferencesKey("plan_display_name")
        val PLAN_PULLS_LEFT = intPreferencesKey("plan_pulls_left")
        val PLAN_UNLIMITED = booleanPreferencesKey("plan_unlimited")
        val PLAN_EXPIRES_AT = longPreferencesKey("plan_expires_at")
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

    /**
     * MEGA A — inbound message routing. Both default ON so the engine behaves
     * exactly as before until an agent deliberately narrows it; turning M-Pesa
     * off is the panic switch, SiteLink off keeps the agent focused on one
     * channel.
     */
    val processMpesaMessages: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.PROCESS_MPESA_MESSAGES] ?: true }

    val processSitelinkMessages: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.PROCESS_SITELINK_MESSAGES] ?: true }

    /** MEGA B — the locally-stored push token (empty until FCM delivers one). */
    val fcmToken: Flow<String> = context.dataStore.data.map { it[Keys.FCM_TOKEN] ?: "" }
    val storeLink: Flow<String> = context.dataStore.data.map { it[Keys.STORE_LINK] ?: "" }
    val storeActive: Flow<Boolean> = context.dataStore.data.map { it[Keys.STORE_ACTIVE] ?: false }
    val deviceId: Flow<String> = context.dataStore.data.map { it[Keys.DEVICE_ID] ?: "" }
    val meshServerUrl: Flow<String> = context.dataStore.data.map { it[Keys.MESH_SERVER_URL] ?: "" }
    val meshConnected: Flow<Boolean> = context.dataStore.data.map { it[Keys.MESH_CONNECTED] ?: false }
    val simSelection: Flow<String> = context.dataStore.data.map { it[Keys.SIM_SELECTION] ?: SIM_1 }
    val engineEnabled: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.ENGINE_ENABLED] ?: true }
    val engineState: Flow<com.bingwascore.app.domain.EngineState> =
        context.dataStore.data.map {
            val raw = it[Keys.ENGINE_STATE]
            if (raw != null) {
                com.bingwascore.app.domain.EngineState.fromValue(raw)
            } else {
                if (it[Keys.ENGINE_ENABLED] == false) com.bingwascore.app.domain.EngineState.STOPPED
                else com.bingwascore.app.domain.EngineState.RUNNING
            }
        }
    val setupComplete: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.SETUP_COMPLETE] ?: false }

    val phone: Flow<String> = context.dataStore.data.map { it[Keys.PHONE] ?: "" }

    /** Parity F — phone of the most recent dial, prefilled in the batch dial sheet. */
    val lastDialPhone: Flow<String> =
        context.dataStore.data.map { it[Keys.LAST_DIAL_PHONE] ?: "" }

    val referralCode: Flow<String> = context.dataStore.data.map { it[Keys.REFERRAL_CODE] ?: "" }

    val referralCount: Flow<Int> = context.dataStore.data.map { (it[Keys.REFERRAL_COUNT] ?: "0").toIntOrNull() ?: 0 }

    val onboardingDone: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.ONBOARDING_DONE] ?: false }

    val announcementsSeeded: Flow<Boolean> =
        context.dataStore.data.map { it[Keys.ANNOUNCEMENTS_SEEDED] ?: false }

    /**
     * POLISH P2 — how many cold starts this install has seen. Combined with the
     * day of the year it keys the rotating greeting: stable within a session,
     * surprising the next day.
     */
    val greetingSession: Flow<Int> = context.dataStore.data.map { it[Keys.GREETING_SESSION] ?: 0 }

    suspend fun setGreetingSession(value: Int) = edit { it[Keys.GREETING_SESSION] = value }

    // ── Stage 12 — Diplomatics (greeting language) + plan state ──────────────

    /** Pinned greeting language as [com.bingwascore.app.ui.home.Greetings.Language.name]; "" = rotating. */
    val greetingPinnedLanguage: Flow<String> =
        context.dataStore.data.map { it[Keys.GREETING_PINNED_LANGUAGE] ?: "" }

    /** Rotation cadence, parsed through the domain enum (unknown -> SESSION). */
    val greetingCadence: Flow<com.bingwascore.app.ui.home.Greetings.Cadence> =
        context.dataStore.data.map {
            com.bingwascore.app.ui.home.Greetings.Cadence.fromValue(it[Keys.GREETING_CADENCE])
        }

    suspend fun setGreetingPinnedLanguage(value: String) =
        edit { it[Keys.GREETING_PINNED_LANGUAGE] = value }

    suspend fun setGreetingCadence(value: com.bingwascore.app.ui.home.Greetings.Cadence) =
        edit { it[Keys.GREETING_CADENCE] = value.value }

    /** The active plan as the credits bubble reads it; inactive PlanState when none. */
    val planState: Flow<com.bingwascore.app.domain.PlanState> = context.dataStore.data.map { prefs ->
        com.bingwascore.app.domain.PlanState(
            planId = prefs[Keys.PLAN_ID] ?: "",
            displayName = prefs[Keys.PLAN_DISPLAY_NAME] ?: "",
            pullsLeft = prefs[Keys.PLAN_PULLS_LEFT] ?: 0,
            unlimited = prefs[Keys.PLAN_UNLIMITED] ?: false,
            expiresAtMillis = prefs[Keys.PLAN_EXPIRES_AT] ?: 0L
        )
    }

    suspend fun setPlanState(state: com.bingwascore.app.domain.PlanState) = edit { p ->
        p[Keys.PLAN_ID] = state.planId
        p[Keys.PLAN_DISPLAY_NAME] = state.displayName
        p[Keys.PLAN_PULLS_LEFT] = state.pullsLeft
        p[Keys.PLAN_UNLIMITED] = state.unlimited
        p[Keys.PLAN_EXPIRES_AT] = state.expiresAtMillis
    }

    /**
     * MEGA A — cold-start gate. `STATE_RUNNING` only once the Setup Checklist
     * has been fully satisfied, which is what lets [ValidateStartupUseCase]
     * route straight to Home on subsequent launches.
     */
    val appState: Flow<AppState> =
        context.dataStore.data.map { AppState.fromValue(it[Keys.APP_STATE]) }

    /** What the engine is doing right now — drives the persistent notification. */
    val processingActivity: Flow<ProcessingActivity> =
        context.dataStore.data.map { ProcessingActivity.fromValue(it[Keys.ENGINE_ACTIVITY]) }

    suspend fun setAppState(value: AppState) = edit { it[Keys.APP_STATE] = value.value }

    suspend fun setProcessingActivity(value: ProcessingActivity) =
        edit { it[Keys.ENGINE_ACTIVITY] = value.value }

    suspend fun setLoggedIn(value: Boolean) = edit { it[Keys.IS_LOGGED_IN] = value }

    suspend fun setUserName(value: String) = edit { it[Keys.USER_NAME] = value }

    suspend fun setThemeMode(value: ThemeMode) = edit { it[Keys.THEME_MODE] = value.value }

    suspend fun setAirtimeBalance(value: Double) = edit { it[Keys.STATS_AIRTIME_BALANCE] = value }

    suspend fun setProcessingMode(value: AppProcessingMode) =
        edit { it[Keys.APP_PROCESSING_MODE] = value.value }

    suspend fun setEngageBotActive(value: Boolean) = edit { it[Keys.ENGAGE_BOT_ACTIVE] = value }

    suspend fun setProcessMpesaMessages(value: Boolean) =
        edit { it[Keys.PROCESS_MPESA_MESSAGES] = value }

    suspend fun setProcessSitelinkMessages(value: Boolean) =
        edit { it[Keys.PROCESS_SITELINK_MESSAGES] = value }

    suspend fun setFcmToken(value: String) = edit { it[Keys.FCM_TOKEN] = value }

    suspend fun setStoreLink(value: String) = edit { it[Keys.STORE_LINK] = value }

    suspend fun setStoreActive(value: Boolean) = edit { it[Keys.STORE_ACTIVE] = value }

    suspend fun setDeviceId(value: String) = edit { it[Keys.DEVICE_ID] = value }

    suspend fun setMeshServerUrl(value: String) = edit { it[Keys.MESH_SERVER_URL] = value }

    suspend fun setMeshConnected(value: Boolean) = edit { it[Keys.MESH_CONNECTED] = value }

        suspend fun setSimSelection(value: String) = edit { it[Keys.SIM_SELECTION] = value }

    suspend fun setEngineEnabled(value: Boolean) = edit {
        it[Keys.ENGINE_ENABLED] = value
        it[Keys.ENGINE_STATE] = if (value) com.bingwascore.app.domain.EngineState.RUNNING.value else com.bingwascore.app.domain.EngineState.STOPPED.value
    }

    suspend fun setEngineState(state: com.bingwascore.app.domain.EngineState) = edit {
        it[Keys.ENGINE_STATE] = state.value
        it[Keys.ENGINE_ENABLED] = state != com.bingwascore.app.domain.EngineState.STOPPED
    }

    suspend fun setSetupComplete(value: Boolean) = edit { it[Keys.SETUP_COMPLETE] = value }

    suspend fun setPhone(value: String) = edit { it[Keys.PHONE] = value }

    /** Parity F — remember the last dialled customer for the silent batch dial. */
    suspend fun setLastDialPhone(value: String) = edit { it[Keys.LAST_DIAL_PHONE] = value }

    suspend fun setReferralCode(value: String) = edit { it[Keys.REFERRAL_CODE] = value }

    suspend fun setReferralCount(value: Int) = edit { it[Keys.REFERRAL_COUNT] = value.toString() }

    suspend fun setOnboardingDone(value: Boolean) = edit { it[Keys.ONBOARDING_DONE] = value }

    suspend fun setAnnouncementsSeeded(value: Boolean) = edit { it[Keys.ANNOUNCEMENTS_SEEDED] = value }

    companion object {
        const val SIM_1 = "SIM 1"
        const val SIM_2 = "SIM 2"
    }

    private suspend fun edit(block: (androidx.datastore.preferences.core.MutablePreferences) -> Unit) {
        context.dataStore.edit { block(it) }
    }
}
