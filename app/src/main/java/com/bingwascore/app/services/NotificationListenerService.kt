package com.bingwascore.app.services

import android.app.Notification
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import com.bingwascore.app.data.local.TransactionDao

@AndroidEntryPoint
class NotificationListenerService : NotificationListenerService() {

    @Inject
    lateinit var transactionDao: TransactionDao

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val packageName = sbn.packageName
        val notification = sbn.notification

        // Check if notification is from M-Pesa or Safaricom
        if (isMpesaNotification(packageName, notification)) {
            val text = extractNotificationText(notification)
            Timber.d("M-Pesa Notification detected: $text")
            
            // Process the notification text similar to SMS
            // This is a fallback if SMS broadcast fails
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // Handle notification removal if needed
    }

    private fun isMpesaNotification(packageName: String, notification: Notification): Boolean {
        // Check for M-Pesa package name or notification content
        return packageName.contains("mpesa", ignoreCase = true) ||
               packageName.contains("safaricom", ignoreCase = true)
    }

    private fun extractNotificationText(notification: Notification): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val extras = notification.extras
            val title = extras?.getCharSequence(Notification.EXTRA_TITLE)?.toString() ?: ""
            val text = extras?.getCharSequence(Notification.EXTRA_TEXT)?.toString() ?: ""
            return "$title $text"
        }
        return ""
    }
}
