package com.bingwascore.app.services

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.bingwascore.app.domain.sms.MessageRouter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class BingwaNotificationListener : NotificationListenerService() {

    @Inject
    lateinit var router: MessageRouter

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        val pkg = sbn?.packageName ?: return

        val isRelevant = pkg.contains("safaricom", true) ||
                pkg.contains("mpesa", true) ||
                pkg.contains("messaging", true) ||
                pkg.contains("android.mms", true) ||
                pkg.contains("google.android.apps.messaging", true)

        if (!isRelevant) return

        val extras = sbn.notification?.extras ?: return
        val text = extras.getCharSequence("android.text")?.toString()
            ?: extras.getCharSequence("android.title")?.toString()
            ?: return

        if (!text.contains("M-PESA", true) && !text.contains("Confirmed", true)) return

        Timber.d("Notification captured from $pkg")
        scope.launch { router.route("MPESA", text) }
    }
}
