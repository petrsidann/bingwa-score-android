package com.bingwascore.app.util

import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** E1 — every diagnostics result + USSD escalation lands here. */
object EngineLog {
    private const val DIR = "crashes"
    private const val FILE = "engine.log"

    fun append(context: Context, line: String) {
        runCatching {
            val dir = context.getExternalFilesDir(DIR) ?: context.filesDir
            if (!dir.exists()) dir.mkdirs()
            val ts = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())
            File(dir, FILE).appendText("[$ts] $line\n")
        }
    }
}
