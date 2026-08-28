package com.bingwascore.app.services

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class UssdAutomationService : Service() {

    @Inject lateinit var pipeline: TransactionPipeline
    @Inject lateinit var settingsRepository: SettingsRepository
    @Inject lateinit var transactionDao: TransactionDao

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val handler = Handler(Looper.getMainLooper())
    private val balanceRegex = Regex("Ksh\\.?\\s?([\\d,]+\\.\\d{2})", RegexOption.IGNORE_CASE)

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val code = intent?.getStringExtra("USSD_CODE")
        val txId = intent?.getStringExtra("TRANSACTION_ID")
        val timeout = intent?.getLongExtra("TIMEOUT_MS", 40000L) ?: 40000L
        val balanceCheck = intent?.getBooleanExtra("BALANCE_CHECK", false) ?: false

        if (code != null) dial(code, txId, timeout, balanceCheck)
        return START_NOT_STICKY
    }

    private fun dial(code: String, txId: String?, timeout: Long, balanceCheck: Boolean) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Timber.e("Missing CALL_PHONE permission")
            if (txId != null) scope.launch { pipeline.onUssdFailed(txId, "Missing phone permission") }
            return
        }
        val tm = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager ?: return

        val callback = object : TelephonyManager.UssdResponseCallback() {
            override fun onReceiveUssdResponse(tm: TelephonyManager, request: String, response: CharSequence) {
                val text = response.toString()
                Timber.d("USSD response: $text")
                scope.launch {
                    when {
                        balanceCheck -> {
                            val bal = balanceRegex.findAll(text).lastOrNull()?.groupValues?.get(1)
                            if (bal != null) {
                                settingsRepository.saveString(AppSetting.STATS_AIRTIME_BALANCE, bal)
                                Timber.d("Airtime balance saved: $bal")
                            }
                        }
                        txId != null -> when {
                            text.contains("already recommended", true) -> pipeline.onUssdAlreadyRecommended(txId)
                            text.contains("failed", true) || text.contains("error", true) ||
                            text.contains("invalid", true) || text.contains("not allowed", true) ->
                                pipeline.onUssdFailed(txId, text)
                            else -> pipeline.onUssdSuccess(txId)
                        }
                    }
                }
            }

            override fun onReceiveUssdResponseFailed(tm: TelephonyManager, request: String, failureCode: Int) {
                Timber.e("USSD failed code $failureCode")
                if (txId != null) scope.launch { pipeline.onUssdFailed(txId, "USSD failed ($failureCode)") }
            }
        }

        try {
            tm.sendUssdRequest(code, callback, handler)
        } catch (e: Exception) {
            Timber.e(e, "sendUssdRequest threw")
            if (txId != null) scope.launch { pipeline.onUssdFailed(txId, e.message ?: "Dial failed") }
            return
        }

        if (!balanceCheck && txId != null) {
            scope.launch {
                delay(timeout)
                val tx = transactionDao.getTransactionById(txId)
                if (tx != null && tx.status == TransactionStatus.PROCESSING) {
                    pipeline.onUssdFailed(txId, "USSD timeout")
                }
            }
        }
    }
}
