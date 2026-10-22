package com.bingwascore.app.updates

import android.content.Context
import com.bingwascore.app.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException

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

    /** Offline or unparsable: callers show the graceful "latest" state. */
    data object Offline : UpdateState

    /** The network/parse step failed — callers surface a generic message. */
    data object Error : UpdateState
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

/**
 * Stage 22 — the release manifest: the shape of `/updates/latest.json`.
 *
 * The file is ONE document the app reads to decide whether a newer build
 * exists. Today it ships inside the APK as a local mock; the moment a server
 * hosts it, the same document is fetched from [UpdateChecker.REMOTE_URL] and
 * nothing else changes.
 */
data class UpdateManifest(
    val versionName: String,
    val versionCode: Int,
    val downloadUrl: String,
    val changelog: String,
    val mandatory: Boolean
) {
    /** True when this manifest is newer than [installed]. */
    fun isNewerThan(installed: String): Boolean = isNewer(installed, versionName)
}

/**
 * Stage 22 — parses `/updates/latest.json`.
 *
 * A manifest without a version is unusable and returns null (the caller shows
 * the graceful "could not check" state); everything else is optional.
 */
fun parseUpdateManifest(json: String): UpdateManifest? {
    if (json.isBlank()) return null
    return try {
        val obj = JSONObject(json)
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
 * Stage 22 — the in-app version check.
 *
 * Reads the release manifest (`/updates/latest.json`) and compares it to the
 * installed [BuildConfig.VERSION_NAME]. Today the manifest is bundled in the
 * APK as a local mock, so the check works offline; the day the file is hosted
 * remotely, [REMOTE_URL] is fetched instead and this class is unchanged.
 */
class UpdateChecker {

    companion object {
        /** The bundled mock of the release manifest. */
        const val ASSET_PATH = "updates/latest.json"

        /** Where the manifest will live once a server hosts it. */
        const val REMOTE_URL = "https://bingwascore.com/updates/latest.json"

        /**
         * Runs the check on the IO dispatcher and never throws: any failure
         * becomes [UpdateState.Error] or [UpdateState.Offline].
         */
        suspend fun check(context: Context): UpdateState = withContext(Dispatchers.IO) {
            try {
                val json = context.assets.open(ASSET_PATH).bufferedReader().use { it.readText() }
                val manifest = parseUpdateManifest(json) ?: return@withContext UpdateState.Error
                if (!manifest.isNewerThan(BuildConfig.VERSION_NAME)) {
                    UpdateState.UpToDate
                } else {
                    UpdateState.UpdateAvailable(
                        latestVersion = manifest.versionName,
                        downloadUrl = manifest.downloadUrl,
                        changelog = manifest.changelog
                    )
                }
            } catch (e: IOException) {
                UpdateState.Offline
            } catch (_: Throwable) {
                UpdateState.Error
            }
        }
    }
}
