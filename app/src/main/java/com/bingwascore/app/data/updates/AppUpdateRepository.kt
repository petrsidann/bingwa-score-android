package com.bingwascore.app.data.updates

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

sealed class UpdateState {
    object Loading : UpdateState()
    object UpToDate : UpdateState()
    data class UpdateRequired(
        val latestVersion: String,
        val message: String,
        val apkUrl: String? = null
    ) : UpdateState()
    data class Downloading(val progress: Int) : UpdateState()
    data class Error(val message: String) : UpdateState()
}

private data class LatestVersionResponse(
    val version: String? = null,
    val apkUrl: String? = null,
    val message: String? = null
)

@Singleton
class AppUpdateRepository @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val settingsRepository: SettingsRepository,
    @ApplicationContext private val context: Context
) {

    private val gson = Gson()
    private val _updateState = MutableStateFlow<UpdateState>(UpdateState.UpToDate)
    val updateState: StateFlow<UpdateState> = _updateState.asStateFlow()

    val currentAppVersion: String = "1.0.0"

    suspend fun checkForUpdates() {
        _updateState.value = UpdateState.Loading
        try {
            val request = Request.Builder()
                .url("https://api.bingwascore.com/app/latest")
                .get()
                .build()

            val response = okHttpClient.newCall(request).execute()
            val body = response.body?.string()

            if (response.isSuccessful && body != null) {
                val latest = gson.fromJson(body, LatestVersionResponse::class.java)
                val latestVersion = latest.version ?: currentAppVersion
                if (compareVersionStrings(currentAppVersion, latestVersion) < 0) {
                    _updateState.value = UpdateState.UpdateRequired(
                        latestVersion = latestVersion,
                        message = latest.message ?: "A new version is available.",
                        apkUrl = latest.apkUrl
                    )
                } else {
                    _updateState.value = UpdateState.UpToDate
                }
            } else {
                _updateState.value = UpdateState.Error("Update check failed")
            }
        } catch (e: Exception) {
            val updateRequired = settingsRepository.getBoolean(AppSetting.APP_UPDATE_REQUIRED)
            _updateState.value = if (updateRequired) {
                UpdateState.UpdateRequired(
                    latestVersion = "",
                    message = "A new version is available. Please connect to the internet to download the update."
                )
            } else {
                UpdateState.Error("Network error")
            }
        }
    }

    fun compareVersionStrings(currentVersion: String, latestVersion: String): Int {
        val c = currentVersion.split(".").mapNotNull { it.toIntOrNull() }
        val l = latestVersion.split(".").mapNotNull { it.toIntOrNull() }
        for (i in 0 until maxOf(c.size, l.size)) {
            val cv = c.getOrElse(i) { 0 }
            val lv = l.getOrElse(i) { 0 }
            if (cv != lv) return cv.compareTo(lv)
        }
        return 0
    }

    suspend fun downloadApk(url: String): File? = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder().url(url).get().build()
            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) return@withContext null

            val body = response.body ?: return@withContext null
            val file = File(context.cacheDir, "bingwa-score-update.apk")
            val contentLength = body.contentLength()
            var total = 0L

            body.byteStream().use { input ->
                file.outputStream().use { output ->
                    val buffer = ByteArray(8192)
                    var read: Int
                    while (input.read(buffer).also { read = it } != -1) {
                        output.write(buffer, 0, read)
                        total += read
                        if (contentLength > 0) {
                            _updateState.value = UpdateState.Downloading(
                                ((total * 100) / contentLength).toInt()
                            )
                        }
                    }
                }
            }
            file
        } catch (e: Exception) {
            null
        }
    }

    fun requestInstallPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intent = Intent(
                Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                Uri.parse("package:${context.packageName}")
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
