package com.bingwascore.app.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity
import timber.log.Timber

/**
 * Foreground keep-alive for the engine.
 *
 * While the engine is enabled this service pins an unobtrusive notification
 * ("engine" channel, tap opens MainActivity) so SMS reception, USSD automation
 * and the WorkManager retry queue keep running reliably. The system notices
 * nothing and the service is never idle-killed while charging (and only rarely
 * on battery, thanks to the Phase 12 battery-optimisation flow).
 */
class EngineService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        createChannel()
        isRunning = true
        Timber.d("EngineService online")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            if (intent?.action == ACTION_STOP) {
                Timber.i("EngineService stopping")
                isRunning = false
                stopForeground(STOP_FOREGROUND_REMOVE)
                stopSelf()
                return START_NOT_STICKY
            }

            isRunning = true
            val notification = buildNotification()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startForeground(
                    NOTIFICATION_ID,
                    notification,
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
                )
            } else {
                @Suppress("DEPRECATION")
                startForeground(NOTIFICATION_ID, notification)
            }
            Timber.d("EngineService foregrounded (id=%d)", startId)
            return START_STICKY
        } catch (t: Throwable) {
            Timber.e(t, "EngineService onStartCommand failed")
            stopSelf()
            return START_NOT_STICKY
        }
    }

    override fun onDestroy() {
        isRunning = false
        Timber.d("EngineService offline")
        super.onDestroy()
    }

    private fun buildNotification(): Notification {
        val tapIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Bingwa Engine running")
            .setContentText("Watching for M-Pesa payments and keeping USSD automation alive.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setContentIntent(tapIntent)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setShowWhen(false)
            .build()
    }

    private fun createChannel() {
        val manager = getSystemService(NotificationManager::class.java) ?: return
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Bingwa Engine",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Keeps the Bingwa purchase engine alive in the background."
            setShowBadge(false)
        }
        manager.createNotificationChannel(channel)
    }

    companion object {
        const val CHANNEL_ID = "engine"

        private const val ACTION_STOP = "com.bingwascore.app.action.STOP_ENGINE"
        private const val NOTIFICATION_ID = 0x4E47_0001 // "NG01"

        /** Live running state, read by the Home engine card and onboarding checklist. */
        @Volatile
        var isRunning: Boolean = false

        fun start(context: Context) {
            try {
                val intent = Intent(context, EngineService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(intent)
                } else {
                    @Suppress("DEPRECATION")
                    context.startService(intent)
                }
            } catch (t: Throwable) {
                Timber.e(t, "Failed to start EngineService")
            }
        }

        fun stop(context: Context) {
            isRunning = false
            try {
                context.stopService(Intent(context, EngineService::class.java).setAction(ACTION_STOP))
            } catch (t: Throwable) {
                Timber.e(t, "Failed to stop EngineService")
            }
        }
    }
}