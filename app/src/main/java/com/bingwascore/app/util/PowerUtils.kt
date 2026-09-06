package com.bingwascore.app.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.PowerManager
import android.provider.Settings
import timber.log.Timber

/**
 * Battery + autostart helpers.
 *
 * OEMs love killing background receivers for "security", so Bingwa Score
 * walks the user through disabling battery optimisation and, where the vendor
 * exposes an autostart whitelist (Xiaomi / Oppo / Vivo / Huawei), opens it
 * explicitly so the boot receiver survives.
 */
object PowerUtils {

    /** True when the app is exempt from Doze battery restrictions. */
    fun isIgnoringBatteryOptimizations(context: Context): Boolean {
        return try {
            val pm = context.getSystemService(Context.POWER_SERVICE) as? PowerManager
            pm?.isIgnoringBatteryOptimizations(context.packageName) ?: true
        } catch (t: Throwable) {
            Timber.e(t, "Battery optimisation check failed")
            true // fail-open: never block the checklist on a flaky system call
        }
    }

    /**
     * Sends the user to the "allow background" toggle via
     * ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS (the app holds
     * REQUEST_IGNORE_BATTERY_OPTIMIZATIONS). Falls back to the app details
     * screen when the system does not expose the flow.
     */
    fun requestIgnoreBatteryOptimizations(activity: Activity) {
        try {
            val pm = activity.getSystemService(Context.POWER_SERVICE) as? PowerManager
            if (pm?.isIgnoringBatteryOptimizations(activity.packageName) == true) return
            activity.startActivity(
                Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
                    data = Uri.fromParts("package", activity.packageName, null)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        } catch (t: Throwable) {
            Timber.e(t, "Battery request failed — opening app details instead")
            openAppDetailsSettings(activity)
        }
    }

    /**
     * Opens the OEM autostart screen. Each brand intent is tried in a guarded
     * try/catch; the first one the device can resolve wins, everything else
     * falls back to the app details settings page.
     */
    fun openAutostartSettings(context: Context) {
        val appIntent = appDetailsIntent(context.packageName)

        val brandIntents = listOf(
            // Xiaomi / Redmi / POCO
            Intent().setComponent(
                ComponentName(
                    "com.miui.securitycenter",
                    "com.miui.permcenter.autostart.AutoStartManagementActivity"
                )
            ),
            // Oppo / Realme (ColorOS)
            Intent().setComponent(
                ComponentName(
                    "com.coloros.safecenter",
                    "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                )
            ),
            // Vivo / iQOO (FunTouch OS)
            Intent().setComponent(
                ComponentName(
                    "com.vivo.permissionmanager",
                    "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                )
            ),
            // Huawei / Honor (EMUI)
            Intent().setComponent(
                ComponentName(
                    "com.huawei.systemmanager",
                    "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"
                )
            ),
            // Samsung — no public autostart screen; resolve to app details.
            appIntent
        )

        for (intent in brandIntents) {
            try {
                context.startActivity(intent.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) })
                return
            } catch (t: Throwable) {
                // Unresolved on this device — try the next brand screen.
            }
        }

        // Nothing matched: hard fallback to the application details page.
        openAppDetailsSettings(context)
    }

    /** Deep links to the app's "app info" settings page. */
    fun openAppDetailsSettings(context: Context) {
        try {
            context.startActivity(
                appDetailsIntent(context.packageName)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        } catch (t: Throwable) {
            Timber.e(t, "Could not open app details settings")
        }
    }

    private fun appDetailsIntent(packageName: String): Intent =
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", packageName, null)
        }
}