package com.bingwascore.app.updates

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.remote.RemoteConfig
import com.bingwascore.app.data.remote.RemoteHttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/** Result of the version check. */
sealed interface UpdateState {
    /** Installed version matches the latest published release. */
    data object UpToDate : UpdateState

    /** A newer release is published. [downloadUrl] opens it in the browser. */
    data class UpdateAvailable(
        val latestVersion: String,
        val downloadUrl: String,
        val changelog: String = ""
    ) : UpdateState

    /** The server is unreachable (404 / offline). Callers show "Can't check right now" + Retry. */
    data object CannotCheck : UpdateState
}

/** Stage 21 — semver compare: "1.9.1" > "1.9.0", prefixes tolerated. */
fun parseSemver(tag: String): List<Int> =
    tag.removePrefix("v").trim().split(".").map { it.filter(Char::isDigit).toIntOrNull() ?: 0 }

/** True when [latest] is strictly newer than [installed]. */
fun isNewer(installed: String, latest: String): Boolean {
    val a = parseSemver(installed); val b = parseSemver(latest)
    for (i in 0 until maxOf(a.size, b.size)) {
        val x = a.getOrElse(i) { 0 }; val y = b.getOrElse(i) { 0 }
        if (y != x) return y > x
    }
    return false
}

/** The release manifest: the shape of `/updates/latest.json`. */
data class UpdateManifest(
    val versionName: String,
    val versionCode: Int,
    val downloadUrl: String,
    val changelog: String,
    val mandatory: Boolean
) {
    fun isNewerThan(installed: String): Boolean = isNewer(installed, versionName)
}

fun parseUpdateManifest(json: String): UpdateManifest? {
    if (json.isBlank()) return null
    return try {
        val obj = org.json.JSONObject(json)
        val version = obj.optString("versionName", "").removePrefix("v").trim()
        if (version.isEmpty()) return null
        UpdateManifest(
            versionName = version,
            versionCode = obj.optInt("versionCode", 0),
            downloadUrl = obj.optString("downloadUrl", "").trim(),
            changelog = obj.optString("changelog", "").trim().take(2000),
            mandatory = obj.optBoolean("mandatory", false)
        )
    } catch (_: Throwable) {
        null
    }
}

/**
 * Stage 22 + 31 — the in-app version check.
 *
 * Hits `{BASE_URL}/updates/latest.json`. When no backend is configured, or the
 * fetch returns 404 / offline / unparsable, the result is [UpdateState.CannotCheck]
 * and the UI shows "Can't check right now" with a Retry button.
 */
@Singleton
class UpdateChecker @Inject constructor(
    private val http: RemoteHttpClient,
    private val remoteConfig: RemoteConfig
) {

    companion object {
        /** The bundled mock of the release manifest (shipped offline fallback). */
        const val ASSET_PATH = "updates/latest.json"
    }

    /**
     * Runs the check on the IO dispatcher and never throws: any failure becomes
     * [UpdateState.CannotCheck].
     */
    suspend fun check(): UpdateState = withContext(Dispatchers.IO) {
        if (remoteConfig.baseUrl.isBlank()) return@withContext UpdateState.CannotCheck
        try {
            val json = http.getRaw("/updates/latest.json") ?: return@withContext UpdateState.CannotCheck
            val manifest = parseUpdateManifest(json) ?: return@withContext UpdateState.CannotCheck
            if (!manifest.isNewerThan(BuildConfig.VERSION_NAME)) {
                UpdateState.UpToDate
            } else {
                UpdateState.UpdateAvailable(
                    latestVersion = manifest.versionName,
                    downloadUrl = manifest.downloadUrl,
                    changelog = manifest.changelog
                )
            }
        } catch (_: Throwable) {
            UpdateState.CannotCheck
        }
    }
}
