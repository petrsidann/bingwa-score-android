package com.bingwascore.app.updates

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

/** Stage 21 — APK download with progress notification + install intent on tap. */
object UpdateDownloader {

    fun enqueue(context: Context, url: String): Long {
        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle("Bingwa Score update")
            .setDescription("Downloading the latest release…")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "bingwa-score-latest.apk")
            .setMimeType("application/vnd.android.package-archive")
        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        return manager.enqueue(request)
    }
}
