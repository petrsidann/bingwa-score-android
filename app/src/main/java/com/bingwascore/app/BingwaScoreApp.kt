package com.bingwascore.app

import android.app.Application
import com.bingwascore.app.workers.AutoRenewalScheduler
import com.bingwascore.app.workers.DailyArchiveScheduler
import com.bingwascore.app.workers.EngageBotTimeoutScheduler
import com.bingwascore.app.workers.SmsPollScheduler
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BingwaScoreApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        SmsPollScheduler.schedule(this)
        AutoRenewalScheduler.schedule(this)
        DailyArchiveScheduler.schedule(this)
        EngageBotTimeoutScheduler.schedule(this)

        Timber.d("Bingwa Score engine online: SMS engine + renewals + archive + engagebot")
    }
}
