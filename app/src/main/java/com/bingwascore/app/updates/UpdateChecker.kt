package com.bingwascore.app.updates

import com.bingwascore.app.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

/** Result of hitting the GitHub releases endpoint. */
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
 * Checks GitHub for the latest release and compares its tag to the installed
 * [BuildConfig.VERSION_NAME]. Runs entirely on Dispatchers.IO and never throws —
 * any failure becomes [UpdateState.Error].
 */
class UpdateChecker {

    companion object {
        private const val RELEASES_URL =
            "https://api.github.com/repos/petrsidann/bingwa-score-android/releases/latest"

        suspend fun check(): UpdateState = withContext(Dispatchers.IO) {
            try {
                val url = URL(RELEASES_URL)
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "GET"
                    setRequestProperty("Accept", "application/vnd.github+json")
                    setRequestProperty("User-Agent", "BingwaScore-Updater")
                    connectTimeout = 10_000
                    readTimeout = 10_000
                }

                val responseCode = connection.responseCode
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    return@withContext UpdateState.Error
                }

                val response = connection.inputStream.bufferedReader().use { it.readText() }
                connection.disconnect()

                val json = JSONObject(response)
                val latestTag = json.optString("tag_name", "").removePrefix("v").trim()
                val htmlUrl = json.optString(
                    "html_url",
                    "https://github.com/petrsidann/bingwa-score-android/releases"
                )
                val changelog = json.optString("body", "").trim().take(2000)

                if (latestTag.isEmpty()) return@withContext UpdateState.Error

                if (!isNewer(BuildConfig.VERSION_NAME, latestTag)) {
                    UpdateState.UpToDate
                } else {
                    UpdateState.UpdateAvailable(latestTag, htmlUrl, changelog)
                }
            } catch (e: java.net.UnknownHostException) {
                UpdateState.Offline
            } catch (_: Throwable) {
                UpdateState.Error
            }
        }
    }
}
