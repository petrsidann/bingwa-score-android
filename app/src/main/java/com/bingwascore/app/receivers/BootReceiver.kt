package com.bingwascore.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.workers.Schedulers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Revives the whole engine after a reboot: re-registers the periodic workers
 * and, when the user has engine_enabled on, brings the foreground keep-alive
 * back up so SMS + USSD automation never silently die.
 */
@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var userPreferences: UserPreferences

    private val receiverScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        try {
            if (intent.action != Intent.ACTION_BOOT_COMPLETED) return
            Timber.i("Device booted — reviving Bingwa engine")

            Schedulers.scheduleAll(context)

            receiverScope.launch {
                try {
                    if (userPreferences.engineEnabled.first()) {
                        EngineService.start(context.applicationContext)
                    }
                } catch (t: Throwable) {
                    Timber.e(t, "Engine start on boot failed")
                }
            }
        } catch (t: Throwable) {
            Timber.e(t, "BootReceiver crashed in onReceive")
        }
    }
}