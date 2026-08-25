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
import com.bingwascore.app.domain.model.Offer
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
    
    companion object {
        var isRunning = false
            private set
    }

    override fun onCreate() {
        super.onCreate()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
        isRunning = true
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val offerId = intent?.getStringExtra("OFFER_ID")
        val transactionId = intent?.getStringExtra("TRANSACTION_ID")
        val customerPhone = intent?.getStringExtra("CUSTOMER_PHONE")

        if (offerId != null && transactionId != null && customerPhone != null) {
            scope.launch {
                executeUssdFlow(offerId, transactionId, customerPhone)
            }
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private suspend fun executeUssdFlow(offerId: String, transactionId: String, customerPhone: String) {
        try {
            val offer = offerDao.getOfferById(offerId) ?: return
            
            Timber.d("🚀 Starting USSD flow for Offer: ${offer.name}, Code: ${offer.ussdCode}")
            
            // Update transaction status
            transactionDao.updateTransactionStatus(
                transactionId, 
                TransactionStatus.PROCESSING
            )

            // Dial the USSD code
            dialUssdCode(offer.ussdCode, transactionId)
            
        } catch (e: Exception) {
            Timber.e(e, "USSD flow failed")
            transactionDao.updateTransactionStatus(
                transactionId,
                TransactionStatus.FAILED
            )
        }
    }

    private fun dialUssdCode(ussdCode: String, transactionId: String) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Timber.e("USSD automation requires Android 8.0+")
            return
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Timber.e("Missing CALL_PHONE permission")
            return
        }

        Timber.d(" Dialing USSD: $ussdCode")

        val callback = object : TelephonyManager.UssdResponseCallback() {
            override fun onReceiveUssdResponse(tm: TelephonyManager, request: String, response: CharSequence) {
                super.onReceiveUssdResponse(tm, request, response)
                Timber.d("✅ USSD Response: $response")
                
                // Handle multi-step USSD (e.g., menu selections)
                handleUssdResponse(response.toString(), transactionId)
            }

            override fun onReceiveUssdResponseFailed(tm: TelephonyManager, request: String, failureCode: Int) {
                super.onReceiveUssdResponseFailed(tm, request, failureCode)
                Timber.e("❌ USSD Failed: Code $failureCode")
                
                scope.launch {
                    transactionDao.updateTransactionStatus(
                        transactionId,
                        TransactionStatus.FAILED
                    )
                }
            }
        }

        mainHandler.post {
            telephonyManager?.sendUssdRequest(ussdCode, callback, mainHandler)
        }
    }

    private fun handleUssdResponse(response: String, transactionId: String) {
        // Parse USSD response and determine next action
        // For multi-step USSD like "*180*5*2#", we might need to send additional codes
        
        when {
            response.contains("confirm", ignoreCase = true) -> {
                // Auto-confirm if needed
                Timber.d("Confirmation required - would auto-confirm here")
            }
            response.contains("success", ignoreCase = true) -> {
                Timber.d("USSD completed successfully")
                scope.launch {
                    transactionDao.updateTransactionStatus(
                        transactionId,
                        TransactionStatus.AWAITING_COMMISSION
                    )
                }
            }
            response.contains("error", ignoreCase = true) || 
            response.contains("failed", ignoreCase = true) -> {
                Timber.d("USSD failed")
                scope.launch {
                    transactionDao.updateTransactionStatus(
                        transactionId,
                        TransactionStatus.FAILED
                    )
                }
            }
        }
    }
}
