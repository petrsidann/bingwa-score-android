package com.bingwascore.app

import android.app.Application
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.DatabaseSeeder
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BingwaScoreApp : Application() {

    @Inject
    lateinit var database: AppDatabase

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        Timber.d("Bingwa Score online")

        applicationScope.launch {
            try {
                DatabaseSeeder.seedIfEmpty(database)
            } catch (t: Throwable) {
                Timber.e(t, "Seeding failed")
            }
        }
    }
}

