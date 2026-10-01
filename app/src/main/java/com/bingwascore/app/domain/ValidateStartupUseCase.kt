package com.bingwascore.app.domain

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.services.EngineService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA A — the cold-start gate.
 *
 * On every cold start this decides ONE thing: can the agent go straight to
 * Home, or must they pass through the Setup Checklist first? Without it the app
 * drops an unconfigured user into an empty Home screen and reads as broken.
 *
 * The check is cheap and side-effect-free apart from persisting the resulting
 * [AppState]: runtime permissions come from the package manager, the engine flag
 * from DataStore. It NEVER throws — a failed check resolves to "show the
 * checklist", which is the safe answer.
 */
@Singleton
class ValidateStartupUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences
) {

    /**
     * One checklist row. [done] renders as a DONE chip; a non-null [actionLabel]
     * renders as an ACTION chip the agent can tap to fix it.
     */
    data class StartupCheck(
        val id: String,
        val title: String,
        val subtitle: String,
        val done: Boolean,
        val actionLabel: String? = null
    )

    /** Outcome of a cold start. */
    data class StartupResult(
        val state: AppState,
        val checks: List<StartupCheck>
    ) {
        /** True only when every check is DONE — i.e. Home is safe to show. */
        val readyForHome: Boolean get() = state == AppState.STATE_RUNNING

        /** How many rows are still asking for an ACTION. */
        val pendingActions: Int get() = checks.count { !it.done }
    }

    /**
     * Evaluates permissions + engine state and persists the outcome to the
     * APP_STATE key so later launches (and the notification) agree with it.
     */
    suspend fun run(): StartupResult {
        val result = evaluate()
        // Persisting is best-effort: a DataStore hiccup must not block startup.
        runCatching { userPreferences.setAppState(result.state) }
        return result
    }

    /** Pure evaluation, no persistence — used by tests and previews. */
    suspend fun evaluate(): StartupResult {
        val engineEnabled = runCatching { userPreferences.engineEnabled.first() }
            .getOrDefault(true)

        val checks = listOf(
            permissionCheck(),
            engineCheck(engineEnabled),
            notificationCheck()
        )

        val state = when {
            checks.all { it.done } -> AppState.STATE_RUNNING
            checks.none { it.done } -> AppState.STATE_SETUP
            else -> AppState.STATE_INCOMPLETE
        }
        return StartupResult(state, checks)
    }

    private fun permissionCheck(): StartupCheck {
        val granted = REQUIRED_PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_GRANTED
        }
        return StartupCheck(
            id = "permissions",
            title = "Phone & SMS permissions",
            subtitle = if (granted) {
                "Bingwa can read payments, reply and dial"
            } else {
                "Needed to read M-Pesa alerts and dial USSD"
            },
            done = granted,
            actionLabel = if (granted) null else "Grant"
        )
    }

    private fun engineCheck(engineEnabled: Boolean): StartupCheck {
        val running = engineEnabled && EngineService.isRunning
        return StartupCheck(
            id = "engine",
            title = "Autopilot engine",
            subtitle = when {
                !engineEnabled -> "Switched off on the Home screen"
                running -> "Running — watching for payments"
                else -> "Starting in the background…"
            },
            done = running,
            actionLabel = if (running) null else "Start"
        )
    }

    private fun notificationCheck(): StartupCheck {
        val enabled = runCatching {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as? NotificationManager
            manager?.areNotificationsEnabled() == true
        }.getOrDefault(false)
        return StartupCheck(
            id = "notifications",
            title = "Notifications",
            subtitle = if (enabled) {
                "Progress notifications are on"
            } else {
                "Needed to show Processing status"
            },
            done = enabled,
            actionLabel = if (enabled) null else "Enable"
        )
    }

    companion object {
        /**
         * Runtime permissions the engine needs. READ_PHONE_STATE is what gates
         * the *144# balance dial, so it is included here too.
         */
        val REQUIRED_PERMISSIONS: List<String> = buildList {
            add(Manifest.permission.RECEIVE_SMS)
            add(Manifest.permission.READ_SMS)
            add(Manifest.permission.SEND_SMS)
            add(Manifest.permission.READ_PHONE_STATE)
            add(Manifest.permission.CALL_PHONE)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}