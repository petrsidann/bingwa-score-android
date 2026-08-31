package com.bingwascore.app.data.statistics

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.telephony.TelephonyManager
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val _balance = MutableStateFlow(settingsRepository.getString(AppSetting.STATS_AIRTIME_BALANCE))
    val balance: StateFlow<String?> = _balance.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val balanceRegex = Regex("Ksh\\.?\\s?([\\d,]+\\.\\d{2})", RegexOption.IGNORE_CASE)

    fun refresh() {
        if (_loading.value) return
        _loading.value = true
        scope.launch {
            try {
                val text = querySilently("*144#")
                if (text != null) {
                    balanceRegex.findAll(text).lastOrNull()?.groupValues?.get(1)?.let { parsed ->
                        _balance.value = parsed
                        settingsRepository.saveString(AppSetting.STATS_AIRTIME_BALANCE, parsed)
                    }
                }
            } catch (e: Exception) {
                Timber.e(e, "Balance refresh failed")
            }
            _loading.value = false
        }
    }

    private suspend fun querySilently(code: String): String? = withTimeoutOrNull(15000) {
        suspendCancellableCoroutine { cont ->
            try {
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
                if (tm == null) {
                    cont.resume(null)
                    return@suspendCancellableCoroutine
                }
                tm.sendUssdRequest(code, object : TelephonyManager.UssdResponseCallback() {
                    override fun onReceiveUssdResponse(t: TelephonyManager, request: String, response: CharSequence) {
                        cont.resume(response.toString())
                    }
                    override fun onReceiveUssdResponseFailed(t: TelephonyManager, request: String, failureCode: Int) {
                        cont.resume(null)
                    }
                }, Handler(Looper.getMainLooper()))
            } catch (e: Exception) {
                Timber.e(e, "sendUssdRequest failed")
                cont.resume(null)
            }
        }
    }
}
