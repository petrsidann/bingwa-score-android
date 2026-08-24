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
import android.telephony.TelephonyManager.UssdResponseCallback
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import com.bingwascore.app.data.local.TransactionDao

@AndroidEntryPoint
class UssdDialerService : Service() {

    @Inject
    lateinit var transactionDao: TransactionDao

    private var telephonyManager: TelephonyManager? = null
    private var ussdCallback: UssdResponseCallback? = null
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
            Timber.e("USSD dialing requires API 26+")
            return
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Timber.e("CALL_PHONE permission not granted")
            return
        }

        Timber.d("Dialing USSD: $ussdCode for transaction: $transactionId")

        ussdCallback = object : UssdResponseCallback() {
            override fun onReceiveUssdResponse(
                telephonyManager: TelephonyManager,
                request: String,
                response: CharSequence
            ) {
                super.onReceiveUssdResponse(telephonyManager, request, response)
                Timber.d("USSD Response: $response")
                mainHandler.post {
                    // Handle USSD response (parse menu, select options, etc.)
                }
            }

            override fun onReceiveUssdResponseFailed(
                telephonyManager: TelephonyManager,
                request: String,
                failureCode: Int
            ) {
                super.onReceiveUssdResponseFailed(telephonyManager, request, failureCode)
                Timber.e("USSD Failed with code: $failureCode")
                mainHandler.post {
                    // Handle failure (retry, mark as failed, etc.)
                }
            }
        }

        // Use mainHandler (Handler) instead of executor
        telephonyManager?.sendUssdRequest(ussdCode, ussdCallback!!, mainHandler)
    }
}
