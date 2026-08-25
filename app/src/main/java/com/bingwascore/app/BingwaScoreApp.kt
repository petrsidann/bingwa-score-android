package com.bingwascore.app

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BingwaScoreApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workManagerConfiguration: Configuration

    override fun getWorkManagerConfiguration(): Configuration {
        return workManagerConfiguration
    }

    override fun onCreate() {
        super.onCreate()
        
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        
        Timber.d("Bingwa Score App initialized")
    }
}
