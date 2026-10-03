package com.bingwascore.app

import android.app.Application
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.DatabaseSeeder
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.showcase.DemoEngine
import com.bingwascore.app.data.showcase.DemoSeeder
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.CrashHandler
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

    @Inject
    lateinit var demoEngine: DemoEngine

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()

        // SHOWCASE S1 — must be the very first thing: it decides which database
        // file Room will open, and Room is built by Hilt right after this.
        DbNameHolder.loadFrom(this)

        CrashHandler.init(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        Timber.d("Bingwa Score online (showcase=%s, db=%s)", DbNameHolder.showcaseMode, DbNameHolder.dbName)

        Schedulers.scheduleAll(this)

        applicationScope.launch {
            try {
                // SHOWCASE S2 — demo installs get their own populated database and
                // then a live simulator; real installs are untouched.
                if (DbNameHolder.showcaseMode) {
                    DemoSeeder.seedIfEmpty(database)
                    demoEngine.attachContext(this@BingwaScoreApp)
                    demoEngine.start(applicationScope)
                } else {
                    DatabaseSeeder.seedIfEmpty(database)
                }
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

