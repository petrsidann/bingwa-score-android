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
import androidx.annotation.VisibleForTesting
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import com.bingwascore.app.R
import com.bingwascore.app.domain.ProcessingActivity
import com.bingwascore.app.ui.MainActivity
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.workers.EngineStartWorker
import timber.log.Timber

/**
 * Foreground keep-alive for the engine.
 *
 * While the engine is enabled this service pins an unobtrusive notification
 * ("engine" channel, tap opens MainActivity) so SMS reception, USSD automation
 * and the WorkManager retry queue keep running reliably. The system notices
 * nothing and the service is never idle-killed while charging (and only rarely
 * on battery, thanks to the Phase 12 battery-optimisation flow).
 *
 * STAGE 38 — ORDERING LAW. The owner device produced
 * `Context.startForegroundService() did not then call Service.startForeground()`
 * followed by an ANR kill. On this platform the OS gives a service started via
 * startForegroundService exactly 5 seconds to promote itself, and any code that
 * runs before `startForeground` spends that budget. Prior to this stage the
 * cold-start path returned early on an `isRunning` flag set by `onCreate`, so
 * promotion *never* happened. Hence: `startForeground` is now the first
 * synchronous statement of [onStartCommand], before every early return, every
 * validation and every coroutine launch — with no exceptions.
 */
class EngineService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        // =====================================================================
        // STAGE 41 — ZERO WORK BEFORE PROMOTION.
        // Channel creation is synchronous and required before notification post.
        // startForeground(ID, minimalNotification()) is called IMMEDIATELY.
        // No DataStore, no coroutines, no DI build.
        // =====================================================================
        createChannel()
        try {
            val minimal = minimalNotification()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startForeground(
                    NOTIFICATION_ID,
                    minimal,
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
                )
            } else {
                @Suppress("DEPRECATION")
                startForeground(NOTIFICATION_ID, minimal)
            }
        } catch (t: Throwable) {
            CrashHandler.record(this, t)
            isRunning = false
            Timber.e(t, "EngineService could not promote to foreground in onCreate")
            stopSelf()
            return
        }

        // Built once, here — the notification path below must never touch disk,
        // network, DataStore or the notification manager again.
        tapIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        Timber.d("EngineService online")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // =====================================================================
        // STAGE 41 / STAGE 38 — IDEMPOTENT startForeground RE-CALL IN TRY/CATCH
        // BEFORE ANY LOGIC.
        // No intent inspection, no flag check, no early return, no coroutine
        // launch precedes it.
        // =====================================================================
        try {
            promoteToForeground()
        } catch (t: Throwable) {
            // We could not honour the foreground contract — give the process
            // back rather than sitting in the window until the ANR fires.
            CrashHandler.record(this, t)
            isRunning = false
            Timber.e(t, "EngineService could not promote to foreground")
            stopSelf()
            return START_NOT_STICKY
        }

        // =====================================================================
        // Promotion is done. Ordinary logic may start here.
        // =====================================================================
        isRunning = true

        if (intent?.action == ACTION_STOP) {
            Timber.i("EngineService stopping")
            isRunning = false
            ServiceCompat.stopForeground(this, ServiceCompat.STOP_FOREGROUND_REMOVE)
            stopSelf()
            return START_NOT_STICKY
        }

        Timber.d("EngineService foregrounded (id=%d)", startId)
        return START_STICKY
    }

    override fun onDestroy() {
        isRunning = false
        Timber.d("EngineService offline")
        super.onDestroy()
    }

    /**
     * Minimal notification used for synchronous promotion in [onCreate].
     * Uses static strings + cached icon only. Zero disk, zero network, zero DI.
     */
    private fun minimalNotification(): Notification {
        testNotificationOverride?.let { return it() }
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Bingwa Engine")
            .setContentText("Engine running in background")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setShowWhen(false)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .build()
    }

    /**
     * Posts the ongoing notification. Only cached, in-memory values are read —
     * a literal title, the [processingActivity] volatile and a PendingIntent
     * created in [onCreate]. Zero disk, zero network, zero binder round-trips
     * beyond the notification post itself.
     */
    private fun buildNotification(): Notification {
        testNotificationOverride?.let { return it() }
        // MEGA A — the notification text tracks what the engine is doing right
        // now: "Processing" while a USSD dial is in flight, "Processing
        // transaction" while the reply goes out.
        val activity = processingActivity
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(
                if (activity == ProcessingActivity.IDLE) "Bingwa Engine running" else "Processing"
            )
            .setContentText(activity.notificationText)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setShowWhen(false)
            // Show the notification immediately instead of letting the system
            // defer it — the same deferral that trips the promotion watchdog.
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
        if (::tapIntent.isInitialized) {
            builder.setContentIntent(tapIntent)
        }
        return builder.build()
    }

    private fun promoteToForeground() {
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
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = getSystemService(NotificationManager::class.java) ?: return
        if (manager.getNotificationChannel(CHANNEL_ID) != null) return
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Bingwa Engine",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Keeps Bingwa Autopilot alive in the background."
            setShowBadge(false)
        }
        manager.createNotificationChannel(channel)
    }

    private lateinit var tapIntent: PendingIntent

    companion object {
        const val CHANNEL_ID = "engine"

        @VisibleForTesting
        internal const val ACTION_STOP = "com.bingwascore.app.action.STOP_ENGINE"

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

        /** Test seam so the failure path can be exercised without a device. */
        @VisibleForTesting
        internal var testNotificationOverride: (() -> Notification)? = null

        /**
         * How a refused/background start is deferred. Swappable in tests so the
         * caller contract can be asserted without a WorkManager scheduler.
         */
        @VisibleForTesting
        internal var enqueueBackgroundStart: (Context) -> Unit = { EngineStartWorker.enqueue(it) }

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

        /**
         * STAGE 38 — caller gate.
         *
         * Android 12+ forbids starting a foreground service from the background.
         * An app that tries anyway is killed with
         * ForegroundServiceStartNotAllowedException, so the attempt is refused
         * here *before* it is made: in the foreground we promote immediately,
         * otherwise the work is deferred to a one-shot WorkManager job that
         * promotes the moment an Activity is visible again.
         */
        fun start(context: Context) {
            if (isRunning) return
            val app = context.applicationContext
            appContext = app

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !AppForegroundGate.isForeground) {
                Timber.d("EngineService start deferred — app is in the background on API 31+")
                runCatching { enqueueBackgroundStart(app) }
                    .onFailure { Timber.e(it, "Failed to defer the engine start") }
                return
            }

            try {
                ContextCompat.startForegroundService(
                    app,
                    Intent(app, EngineService::class.java)
                )
            } catch (e: IllegalStateException) {
                // ForegroundServiceStartNotAllowedException (API 31+) extends
                // IllegalStateException, so this catch is safe to reference on
                // every API level, including those where the type does not exist.
                Timber.e(e, "Foreground service start refused — deferring")
                CrashHandler.record(app, e)
                runCatching { enqueueBackgroundStart(app) }
                    .onFailure { Timber.e(it, "Failed to defer the engine start") }
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
