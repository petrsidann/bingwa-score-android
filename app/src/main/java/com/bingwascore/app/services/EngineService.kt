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
import com.bingwascore.app.domain.ProcessingActivity
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
        // MEGA A — the notification text tracks what the engine is doing right
        // now: "Processing" while a USSD dial is in flight, "Processing
        // transaction" while the reply goes out.
        val activity = processingActivity
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(
                if (activity == ProcessingActivity.IDLE) "Bingwa Engine running" else "Processing"
            )
            .setContentText(activity.notificationText)
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

        /**
         * What the engine is doing right now, mirrored onto the persistent
         * notification. Written by the USSD/SMS paths, read by [buildNotification].
         */
        @Volatile
        var processingActivity: ProcessingActivity = ProcessingActivity.IDLE

        /**
         * Switches the engine into a processing state and repaints the ongoing
         * notification so the agent can see the app working mid-dial. Safe to
         * call when the service is not running — it simply records the state.
         */
        fun setProcessing(activity: ProcessingActivity) {
            processingActivity = activity
            val app = appContext ?: return
            try {
                val manager = app.getSystemService(Context.NOTIFICATION_SERVICE)
                    as? NotificationManager ?: return
                if (!isRunning) return
                manager.notify(NOTIFICATION_ID, buildStaticNotification(app, activity))
            } catch (t: Throwable) {
                Timber.e(t, "Failed to update the processing notification")
            }
        }

        /** Builds the notification outside a Service instance (companion-safe). */
        private fun buildStaticNotification(
            context: Context,
            activity: ProcessingActivity
        ): Notification {
            val tapIntent = PendingIntent.getActivity(
                context,
                0,
                Intent(context, MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
            return NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(
                    if (activity == ProcessingActivity.IDLE) "Bingwa Engine running" else "Processing"
                )
                .setContentText(activity.notificationText)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setOngoing(true)
                .setContentIntent(tapIntent)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setShowWhen(false)
                .build()
        }

        /** Remembered by [start] so [setProcessing] can repaint while idle. */
        @Volatile
        private var appContext: Context? = null

        fun start(context: Context) {
            try {
                appContext = context.applicationContext
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