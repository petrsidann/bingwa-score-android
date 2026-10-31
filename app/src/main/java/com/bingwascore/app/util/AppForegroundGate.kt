package com.bingwascore.app.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.annotation.VisibleForTesting

/**
 * STAGE 38 — tracks whether any Activity is currently started.
 *
 * Android 12+ refuses `startForegroundService` from the background and kills
 * the caller. Callers ask this gate first instead of finding out the hard way.
 * It is deliberately the cheap, dependency-free ActivityLifecycleCallbacks
 * form: no ProcessLifecycleOwner, no extra artifact.
 */
object AppForegroundGate {

    @Volatile
    var isForeground: Boolean = false
        private set

    private var startedActivities = 0

    /** Installs the tracker. Safe to call more than once. */
    fun install(application: Application) {
        if (installed) return
        installed = true
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityStarted(activity: Activity) {
                startedActivities++
                isForeground = true
            }

            override fun onActivityStopped(activity: Activity) {
                startedActivities = (startedActivities - 1).coerceAtLeast(0)
                isForeground = startedActivities > 0
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
            override fun onActivityResumed(activity: Activity) = Unit
            override fun onActivityPaused(activity: Activity) = Unit
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
            override fun onActivityDestroyed(activity: Activity) = Unit
        })
    }

    @VisibleForTesting
    internal fun setForegroundForTest(foreground: Boolean) {
        isForeground = foreground
    }

    private var installed = false
}
