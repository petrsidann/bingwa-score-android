package com.bingwascore.app.data.showcase

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.bingwascore.app.R
import com.bingwascore.app.ui.MainActivity

/**
 * SHOWCASE S2 — the "it just worked" beat.
 *
 * Every processed demo payment posts one short notification, so a screen-share
 * shows the app reacting in real time even when the phone is not being touched.
 */
object DemoNotifier {

    private const val CHANNEL_ID = "showcase"
    private const val NOTIFICATION_ID = 0x5348_0001 // "SH01"

    fun notify(context: Context?, customerName: String, offerName: String, amount: Double) {
        val app = context ?: return
        if (ContextCompat.checkSelfPermission(app, Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        try {
            val manager = app.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
                ?: return
            ensureChannel(manager)

            val tap = PendingIntent.getActivity(
                app,
                0,
                Intent(app, MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val notification = NotificationCompat.Builder(app, CHANNEL_ID)
                .setContentTitle("Ksh ${DemoCatalog.amount(amount)} from $customerName")
                .setContentText("$offerName delivered")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentIntent(tap)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build()

            manager.notify(NOTIFICATION_ID, notification)
        } catch (_: Throwable) {
            // Notifications are a nicety; never let one break the simulator.
        }
    }

    private fun ensureChannel(manager: NotificationManager) {
        manager.createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                "Showcase activity",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Live demo payments processed by Showcase Mode."
                setShowBadge(false)
            }
        )
    }
}