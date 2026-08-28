package com.bingwascore.app.data.statistics

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.telephony.TelephonyManager
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume

@Singleton
class BalanceRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val settingsRepository: SettingsRepository
) {

    private val _balance = MutableStateFlow(settingsRepository.getString(AppSetting.STATS_AIRTIME_BALANCE))
    val balance: StateFlow<String?> = _balance.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val balanceRegex = Regex("airtime balance is Ksh\\s?([\\d,]+\\.\\d{2})", RegexOption.IGNORE_CASE)
    private val fallbackRegex = Regex("Ksh\\s?([\\d,]+\\.\\d{2})", RegexOption.IGNORE_CASE)

    fun refresh() {
        if (_loading.value) return
        _loading.value = true
        kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.IO).launch {
            val response = querySilently("*144#")
            val parsed = parse(response)
            if (parsed != null) {
                _balance.value = parsed
                settingsRepository.saveString(AppSetting.STATS_AIRTIME_BALANCE, parsed) // save last balance
            }
            _loading.value = false
        }
    }

    private fun parse(response: String?): String? {
        if (response == null) return null
        return balanceRegex.find(response)?.groupValues?.get(1)
            ?: fallbackRegex.findAll(response).lastOrNull()?.groupValues?.get(1)
    }

    private suspend fun querySilently(code: String): String? = withTimeoutOrNull(15000) {
        suspendCancellableCoroutine { cont ->
            try {
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
                if (tm == null) { cont.resume(null); return@suspendCancellableCoroutine }
                val callback = object : TelephonyManager.UssdResponseCallback() {
                    override fun onReceiveUssdResponse(tm: TelephonyManager, request: String, response: CharSequence) {
                        cont.resume(response.toString())
                    }
                    override fun onReceiveUssdResponseFailed(tm: TelephonyManager, request: String, failureCode: Int) {
                        cont.resume(null)
                    }
                }
                // Uses default (SIM 1) voice subscription, matching DIAL_USSD_VIA_SIM_1
                tm.sendUssdRequest(code, callback, Handler(Looper.getMainLooper()))
            } catch (e: Exception) {
                Timber.e(e, "Balance query failed")
                cont.resume(null)
            }
        }
    }

    private fun kotlinx.coroutines.CoroutineScope.launch(block: suspend () -> Unit) {
        launch(kotlinx.coroutines.Dispatchers.IO) { block() }
    }
}
