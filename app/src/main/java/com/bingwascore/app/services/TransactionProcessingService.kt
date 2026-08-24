package com.bingwascore.app.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import com.bingwascore.app.R
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.TransactionStatus

@AndroidEntryPoint
class TransactionProcessingService : Service() {

    @Inject
    lateinit var transactionDao: TransactionDao

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val channelId = "transaction_processing_channel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.d("TransactionProcessingService started")
        
        // Start foreground to prevent being killed
        val notification = android.app.Notification.Builder(this, channelId)
            .setContentTitle("Bingwa Score")
            .setContentText("Processing transactions...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)

        scope.launch {
            processPendingTransactions()
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Transaction Processing",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private suspend fun processPendingTransactions() {
        Timber.d("Processing pending transactions...")
        // Implementation will process transactions from the database
        // This is where the USSD dialing logic will be triggered
    }
}
