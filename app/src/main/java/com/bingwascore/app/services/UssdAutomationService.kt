package com.bingwascore.app.services

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import com.bingwascore.app.data.local.TransactionDao

@AndroidEntryPoint
class UssdAutomationService : Service() {

    @Inject
    lateinit var transactionDao: TransactionDao

    private var telephonyManager: TelephonyManager? = null
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate() {
        super.onCreate()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val ussdCode = intent?.getStringExtra("USSD_CODE")
        val transactionId = intent?.getStringExtra("TRANSACTION_ID")

        if (ussdCode != null && transactionId != null) {
            dialUssd(ussdCode, transactionId)
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun dialUssd(ussdCode: String, transactionId: String) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Timber.e("USSD automation requires Android 8.0+")
            return
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Timber.e("Missing CALL_PHONE permission")
            return
        }

        Timber.d(" Dialing USSD: $ussdCode for Transaction: $transactionId")

        val callback = object : TelephonyManager.UssdResponseCallback() {
            override fun onReceiveUssdResponse(tm: TelephonyManager, request: String, response: CharSequence) {
                super.onReceiveUssdResponse(tm, request, response)
                Timber.d("USSD Response: $response")
                // Future: Parse response and click next buttons automatically
            }

            override fun onReceiveUssdResponseFailed(tm: TelephonyManager, request: String, failureCode: Int) {
                super.onReceiveUssdResponseFailed(tm, request, failureCode)
                Timber.e("USSD Failed: Code $failureCode")
            }
        }

        telephonyManager?.sendUssdRequest(ussdCode, callback, mainHandler)
    }
}
