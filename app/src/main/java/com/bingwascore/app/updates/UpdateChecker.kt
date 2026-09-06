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
    data class UpdateAvailable(val latestVersion: String, val downloadUrl: String) : UpdateState

    /** The network/parse step failed — callers surface a generic message. */
    data object Error : UpdateState
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

                if (latestTag.isEmpty()) return@withContext UpdateState.Error

                if (latestTag == BuildConfig.VERSION_NAME) {
                    UpdateState.UpToDate
                } else {
                    UpdateState.UpdateAvailable(latestTag, htmlUrl)
                }
            } catch (_: Throwable) {
                UpdateState.Error
            }
        }
    }
}
