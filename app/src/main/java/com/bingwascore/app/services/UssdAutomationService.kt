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
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.engine.OfferSignature
import com.bingwascore.app.domain.model.TransactionStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class UssdAutomationService : Service() {

    @Inject
    lateinit var offerDao: OfferDao

    @Inject
    lateinit var transactionDao: TransactionDao

    private var telephonyManager: TelephonyManager? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate() {
        super.onCreate()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val ussdCode = intent?.getStringExtra("USSD_CODE")
        val transactionId = intent?.getStringExtra("TRANSACTION_ID")

        if (ussdCode != null && transactionId != null) {
            dialUssdCode(ussdCode, transactionId)
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun dialUssdCode(ussdCode: String, transactionId: String) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Timber.e("USSD automation requires Android 8.0+")
            return
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Timber.e("Missing CALL_PHONE permission")
            return
        }

        Timber.d("Dialing USSD: $ussdCode")

        val callback = object : TelephonyManager.UssdResponseCallback() {
            override fun onReceiveUssdResponse(tm: TelephonyManager, request: String, response: CharSequence) {
                super.onReceiveUssdResponse(tm, request, response)
                Timber.d("USSD Response: $response")
                scope.launch { onUssdSuccess(transactionId) }
            }

            override fun onReceiveUssdResponseFailed(tm: TelephonyManager, request: String, failureCode: Int) {
                super.onReceiveUssdResponseFailed(tm, request, failureCode)
                Timber.e("USSD Failed: $failureCode")
                scope.launch {
                    transactionDao.updateTransactionStatus(transactionId, TransactionStatus.FAILED)
                }
            }
        }

        mainHandler.post {
            telephonyManager?.sendUssdRequest(ussdCode, callback, mainHandler)
        }
    }

    private suspend fun onUssdSuccess(transactionId: String) {
        val tx = transactionDao.getTransactionById(transactionId) ?: return
        val offer = offerDao.getOfferById(tx.offerId)

        val awaiting = offer != null && OfferSignature.awaitingCompletionMessage(
            code = offer.ussdCode,
            strictMode = true,
            completionMessage = offer.completionMessage
        )

        transactionDao.updateTransactionStatus(
            transactionId,
            if (awaiting) TransactionStatus.AWAITING_COMMISSION else TransactionStatus.SUCCESSFUL
        )
        Timber.d("Transaction $transactionId -> ${if (awaiting) "AWAITING_COMMISSION" else "SUCCESSFUL"}")
    }
}
