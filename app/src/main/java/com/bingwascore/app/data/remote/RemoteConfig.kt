package com.bingwascore.app.data.remote

import android.content.Context
import android.content.pm.PackageManager
import com.bingwascore.app.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — Unleash-style remote configuration.
 *
 * Every flag defaults to OFF and every endpoint defaults to BLANK. That is the
 * whole safety story of PART B: with no keys provisioned the app behaves exactly
 * as PART A shipped it, purely local. Turning anything on is a deliberate act.
 *
 * [baseUrl] is blank unless the build actually carries one, which is what
 * [OfflineFallback] keys off to decide whether a call may even be attempted.
 */
@Singleton
class RemoteConfig @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val pkgInfo: android.content.pm.PackageInfo? = runCatching {
        context.packageManager.getPackageInfo(context.packageName, 0)
    }.getOrNull()

    /** True when the package manager could describe this install. */
    val isInstalledPackageKnown: Boolean get() = pkgInfo != null

    /**
     * The backend root, or "" when none is configured. Deliberately NOT the
     * literal BuildConfig placeholder — an un-provisioned build must look
     * exactly like an offline build.
     */
    val baseUrl: String = BuildConfig.API_BASE_URL.trim().trimEnd('/')
        .takeIf { it.isNotBlank() && !it.contains("example.com", ignoreCase = true) }
        ?: ""

    /**
     * Installed package version name, or the BuildConfig value when the package
     * manager refuses. Used for diagnostics and `X-App-Version` headers.
     */
    val packageVersion: String = runCatching {
        @Suppress("DEPRECATION")
        context.packageManager
            .getPackageInfo(context.packageName, 0)
            .versionName
    }.getOrNull() ?: BuildConfig.APP_VERSION

    /** True only when a real backend URL has been provisioned. */
    val isRemoteConfigured: Boolean get() = baseUrl.isNotEmpty()

    /** WebSocket endpoint for the relay socket, or "" when offline. */
    val socketUrl: String get() =
        if (!isRemoteConfigured) "" else buildString {
            append(baseUrl.replaceFirst("http", "ws"))
            append("/socket")
        }

    /** Server-Sent Events endpoint for relay state pushes, or "" when offline. */
    val sseUrl: String get() =
        if (!isRemoteConfigured) "" else "$baseUrl/events"

    val appVersion: String = BuildConfig.APP_VERSION

    /** Package name used to scope feature flags per app build. */
    val appId: String = context.packageName

    // ---- Feature flags: ALL default OFF ----------------------------------

    /** Master switch. Even when this is on, every flag below still gates itself. */
    var remoteFeaturesEnabled: Boolean = false

    /** Pull the verified-offer catalogue from the server. */
    var offerSyncEnabled: Boolean = false

    /** Open the relay WebSocket and apply inbound app-state commands. */
    var relaySocketEnabled: Boolean = false

    /** Subscribe to the SSE event stream. */
    var sseEnabled: Boolean = false

    /** Register for FCM push and upload the device token. */
    var pushEnabled: Boolean = false

    /** Route USSD dials through a paired relay device instead of this phone. */
    var relayDialEnabled: Boolean = false

    /** Use server-side email OTP / PIN auth instead of the local phone+PIN. */
    var serverAuthEnabled: Boolean = false

    /**
     * True only when [flag] may actually change behaviour — i.e. the master
     * switch is on AND the specific flag is on AND a backend exists.
     */
    fun isActive(flag: Boolean): Boolean = remoteFeaturesEnabled && flag && isRemoteConfigured

    /**
     * Lets tests and a future in-app debug toggle flip flags without a rebuild.
     * Never called from production code paths.
     */
    fun applyOverrides(
        remote: Boolean = remoteFeaturesEnabled,
        offers: Boolean = offerSyncEnabled,
        socket: Boolean = relaySocketEnabled,
        sse: Boolean = sseEnabled,
        push: Boolean = pushEnabled,
        relayDial: Boolean = relayDialEnabled,
        serverAuth: Boolean = serverAuthEnabled
    ) {
        remoteFeaturesEnabled = remote
        offerSyncEnabled = offers
        relaySocketEnabled = socket
        sseEnabled = sse
        pushEnabled = push
        relayDialEnabled = relayDial
        serverAuthEnabled = serverAuth
    }

    /** Restores every flag to its shipped default (all OFF). */
    fun resetToDefaults() {
        applyOverrides(
            remote = false, offers = false, socket = false, sse = false,
            push = false, relayDial = false, serverAuth = false
        )
    }
}
