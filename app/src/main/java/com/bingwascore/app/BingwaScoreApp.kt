package com.bingwascore.app

import android.app.Application
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.DatabaseSeeder
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.workers.Schedulers
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BingwaScoreApp : Application() {

    @Inject
    lateinit var database: AppDatabase

    @Inject
    lateinit var userPreferences: UserPreferences

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        Timber.d("Bingwa Score online")

        Schedulers.scheduleAll(this)

        applicationScope.launch {
            try {
                DatabaseSeeder.seedIfEmpty(database)
            } catch (t: Throwable) {
                Timber.e(t, "Seeding failed")
            }
            // Foreground keep-alive: bring the engine back up when the user has
            // engine_enabled on so SMS parsing + the retry queue run reliably.
            try {
                if (userPreferences.engineEnabled.first()) {
                    EngineService.start(this@BingwaScoreApp)
                    Timber.i("Engine foreground service started")
                }
            } catch (t: Throwable) {
                Timber.e(t, "Engine start on app-create failed")
            }
        }
    }
}

