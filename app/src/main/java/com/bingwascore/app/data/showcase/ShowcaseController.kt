package com.bingwascore.app.data.showcase

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Process
import android.provider.Settings
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.ui.MainActivity
import timber.log.Timber

/**
 * SHOWCASE S1 — the only place allowed to switch Showcase Mode on or off.
 *
 * Switching is deliberately heavy-handed: the database file is chosen at process
 * start, so a change means a restart. We schedule the relaunch through
 * AlarmManager (survives the process being killed) and only then exit.
 */
object ShowcaseController {

    /** Persists the flag. The swap itself happens on the next launch. */
    fun setEnabled(context: Context, enabled: Boolean) {
        DbNameHolder.persist(context, enabled)
        Timber.i("Showcase mode persisted as %s (applies after restart)", enabled)
    }

    fun isEnabled(context: Context): Boolean = DbNameHolder.loadFrom(context).let {
        DbNameHolder.showcaseMode
    }

    /**
     * Relaunches the app, then kills this process.
     *
     * The alarm is set first so the relaunch survives `Runtime.exit`; if anything
     * goes wrong the fallback still ends the process so the next user tap starts
     * a clean one with the new database.
     */
    fun restart(context: Context) {
        try {
            val intent = Intent(context, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                data = Uri.parse("bingwa://restart/${System.currentTimeMillis()}")
            }
            val pending = PendingIntent.getActivity(
                context,
                1_000,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
            val alarms = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
            val triggerAt = System.currentTimeMillis() + 120L
            if (alarms != null) {
                alarms.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerAt,
                    pending
                )
            }
            Timber.i("Showcase restart scheduled")
        } catch (t: Throwable) {
            Timber.e(t, "Could not schedule Showcase restart")
        } finally {
            Runtime.getRuntime().exit(0)
            Process.killProcess(Process.myPid())
        }
    }

    /**
     * S3 — wipes and rebuilds the demo dataset. Only ever touches the demo file,
     * so real agent data is untouchable.
     */
    fun requestDemoReseed(context: Context) {
        DbNameHolder.deleteDemoDatabase(context)
        Timber.i("Demo database dropped — it will be reseeded on next launch")
    }

    /** S1 — send a denied permission straight to this app's settings page. */
    fun openAppSettings(context: Context) {
        runCatching {
            context.startActivity(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.fromParts("package", context.packageName, null))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}