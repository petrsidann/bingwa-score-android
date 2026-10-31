package com.bingwascore.app

import android.app.Application
import android.os.StrictMode
import android.util.Log
import androidx.core.content.ContextCompat
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.DatabaseSeeder
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.showcase.DemoEngine
import com.bingwascore.app.data.showcase.DemoSeeder
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AnrWatchdog
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.workers.Schedulers
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.Executors
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

        // STRICTMODE — debug builds only: any main-thread disk/network IO dies
        // here, in our testing, instead of on the owner's phone.
        if (BuildConfig.DEBUG) {
            val executor = Executors.newSingleThreadExecutor()
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyDeath()
                    .penaltyListener(executor) { violation ->
                        CrashHandler.record(this@BingwaScoreApp, violation)
                    }
                    .build()
            )
        }

        // SHOWCASE S1 — read the flag on an IO thread so the main thread never
        // touches disk; Room is still built lazily afterwards.
        runBlocking(Dispatchers.IO) { DbNameHolder.loadFrom(this@BingwaScoreApp) }

        CrashHandler.init(this)
        // STAGE 38 — background Activity tracking so no caller ever attempts a
        // foreground-service start that Android 12+ will refuse.
        AppForegroundGate.install(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        Timber.d("Bingwa Score online (showcase=%s, db=%s)", DbNameHolder.showcaseMode, DbNameHolder.dbName)

        // ANR watchdog — permanent main-thread traces without bug reports.
        AnrWatchdog.start(this)

        applicationScope.launch {
            try {
                Schedulers.scheduleAll(this@BingwaScoreApp)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to schedule workers")
            }
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

