package com.bingwascore.app.data.updates

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import com.bingwascore.app.BuildConfig
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
    data class UpdateRequired(val latestVersion: String, val message: String, val apkUrl: String? = null) : UpdateState()
    data class Downloading(val progress: Int) : UpdateState()
    data class Error(val message: String) : UpdateState()
}

private data class UpdateJson(
    val version: String? = null,
    val versionCode: Int? = null,
    val apkUrl: String? = null,
    val message: String? = null
)

@Singleton
class AppUpdateRepository @Inject constructor(
    private val okHttpClient: OkHttpClient,
    @ApplicationContext private val context: Context
) {
    private val gson = Gson()
    private val _updateState = MutableStateFlow<UpdateState>(UpdateState.UpToDate)
    val updateState: StateFlow<UpdateState> = _updateState.asStateFlow()

    val currentVersion: String = BuildConfig.VERSION_NAME

    private val updateUrl =
        "https://raw.githubusercontent.com/petrsidann/bingwa-score-android/main/update.json"

    suspend fun checkForUpdates() {
        _updateState.value = UpdateState.Loading
        try {
            val response = okHttpClient.newCall(Request.Builder().url(updateUrl).get().build()).execute()
            val body = response.body?.string()
            if (response.isSuccessful && body != null) {
                val json = gson.fromJson(body, UpdateJson::class.java)
                val latestCode = json.versionCode ?: 0
                if (latestCode > BuildConfig.VERSION_CODE) {
                    _updateState.value = UpdateState.UpdateRequired(
                        latestVersion = json.version ?: "unknown",
                        message = json.message ?: "A new version is available.",
                        apkUrl = json.apkUrl
                    )
                } else {
                    _updateState.value = UpdateState.UpToDate
                }
            } else {
                _updateState.value = UpdateState.Error("Update server unreachable")
            }
        } catch (e: Exception) {
            _updateState.value = UpdateState.Error("Network error")
        }
    }

    suspend fun downloadAndInstall(url: String) = withContext(Dispatchers.IO) {
        try {
            val response = okHttpClient.newCall(Request.Builder().url(url).get().build()).execute()
            val body = response.body ?: return@withContext
            val file = File(context.cacheDir, "bingwa-score-update.apk")
            val length = body.contentLength()
            var total = 0L
            body.byteStream().use { input ->
                file.outputStream().use { out ->
                    val buf = ByteArray(8192)
                    var read: Int
                    while (input.read(buf).also { read = it } != -1) {
                        out.write(buf, 0, read)
                        total += read
                        if (length > 0) _updateState.value = UpdateState.Downloading(((total * 100) / length).toInt())
                    }
                }
            }
            install(file)
        } catch (e: Exception) {
            _updateState.value = UpdateState.Error("Download failed")
        }
    }

    fun install(file: File) {
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.android.package-archive")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
