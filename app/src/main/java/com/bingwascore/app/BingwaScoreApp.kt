package com.bingwascore.app

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import com.bingwascore.app.workers.AutoRenewalScheduler
import com.bingwascore.app.workers.SmsPollScheduler
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BingwaScoreApp : Application(), androidx.work.Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): androidx.work.Configuration {
        return androidx.work.Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        SmsPollScheduler.schedule(this)
        AutoRenewalScheduler.schedule(this)
        Timber.d("Bingwa Score engine online")
    }
}
