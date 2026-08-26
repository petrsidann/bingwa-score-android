package com.bingwascore.app.data.settings

import android.content.Context
import android.content.SharedPreferences
import com.bingwascore.app.domain.enums.AppState
import com.bingwascore.app.domain.enums.ProcessingMode
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

enum class AppSetting(val key: String) {
    DB_INITIALIZED("DB_INITIALIZED"),
    RECEIVE_PAYMENTS_VIA_SIM_1("RECEIVE_PAYMENTS_VIA_SIM_1"),
    RECEIVE_PAYMENTS_VIA_SIM_2("RECEIVE_PAYMENTS_VIA_SIM_2"),
    DIAL_USSD_VIA_SIM_1("DIAL_USSD_VIA_SIM_1"),
    DIAL_USSD_VIA_SIM_2("DIAL_USSD_VIA_SIM_2"),
    SEND_SMS_VIA_SIM_1("SEND_SMS_VIA_SIM_1"),
    SEND_SMS_VIA_SIM_2("SEND_SMS_VIA_SIM_2"),
    PROCESS_MPESA_MESSAGES("PROCESS_MPESA_MESSAGES"),
    PROCESS_TILL_MESSAGES("PROCESS_TILL_MESSAGES"),
    PROCESS_PAY_BILL_MESSAGES("PROCESS_PAY_BILL_MESSAGES"),
    PROCESS_SITE_LINK_MESSAGES("PROCESS_SITE_LINK_MESSAGES"),
    AGENT_ID("AGENT_ID"),
    ADMIN_PAYMENT_NUMBER("ADMIN_PAYMENT_NUMBER"),
    ADMIN_SITE_LINK_NUMBER("ADMIN_SITE_LINK_NUMBER"),
    APP_CONNECT_ID("APP_CONNECT_ID"),
    APP_STATE("APP_STATE"),
    APP_PROCESSING_MODE("APP_PROCESSING_MODE"),
    APP_UPDATE_REQUIRED("APP_UPDATE_REQUIRED"),
    STATS_TRANSACTED_AMOUNT("STATS_TRANSACTED_AMOUNT"),
    STATS_AIRTIME_BALANCE("STATS_AIRTIME_BALANCE"),
    AUTO_SAVE_CONTACTS("AUTO_SAVE_CONTACTS"),
    AUTO_SAVE_CONTACTS_SUFFIX("AUTO_SAVE_CONTACTS_SUFFIX"),
    HYBRID_PORTAL_ACTIVE("HYBRID_PORTAL_ACTIVE"),
    ENGAGE_BOT_ACTIVE("ENGAGE_BOT_ACTIVE")
}

@Singleton
class SettingsRepository @Inject constructor(
    @ApplicationContext context: Context
) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("bingwa_settings", Context.MODE_PRIVATE)

    fun getString(setting: AppSetting): String? = prefs.getString(setting.key, null)

    fun saveString(setting: AppSetting, value: String?) {
        prefs.edit().putString(setting.key, value).apply()
    }

    fun getBoolean(setting: AppSetting, default: Boolean = false): Boolean =
        prefs.getBoolean(setting.key, default)

    fun saveBoolean(setting: AppSetting, value: Boolean) {
        prefs.edit().putBoolean(setting.key, value).apply()
    }

    fun getProcessingMode(): ProcessingMode {
        return try {
            ProcessingMode.valueOf(
                getString(AppSetting.APP_PROCESSING_MODE) ?: ProcessingMode.EXPRESS.name
            )
        } catch (e: Exception) {
            ProcessingMode.EXPRESS
        }
    }

    fun setProcessingMode(mode: ProcessingMode) {
        saveString(AppSetting.APP_PROCESSING_MODE, mode.name)
    }

    fun getAppState(): AppState {
        return try {
            AppState.valueOf(getString(AppSetting.APP_STATE) ?: AppState.STATE_RUNNING.name)
        } catch (e: Exception) {
            AppState.STATE_RUNNING
        }
    }

    fun setAppState(state: AppState) {
        saveString(AppSetting.APP_STATE, state.name)
    }

    fun getConnectId(): String? = getString(AppSetting.APP_CONNECT_ID)

    fun saveConnectId(id: String) = saveString(AppSetting.APP_CONNECT_ID, id)
}
