package com.bingwascore.app.util

import android.content.Context
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Global crash handler. Writes the stack trace plus a timestamp to
 * getExternalFilesDir("crashes")/crash_<timestamp>.txt so the agent can pull the
 * file for debugging, then hands off to the previously-installed default handler
 * (which terminates the process). Every step is wrapped so the handler itself can
 * never crash the app a second time.
 */
class CrashHandler(
    private val context: Context,
    private val defaultHandler: Thread.UncaughtExceptionHandler? = null
) : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        writeCrashReport(thread, throwable)
        // Hand off to the system (or previous) handler so the process dies normally.
        defaultHandler?.uncaughtException(thread, throwable)
    }

    private fun writeCrashReport(thread: Thread, throwable: Throwable) {
        try {
            val dir = context.getExternalFilesDir("crashes") ?: context.filesDir
            if (!dir.exists()) dir.mkdirs()

            val timestamp = TIMESTAMP_FORMAT.format(Date())
            val file = File(dir, "crash_$timestamp.txt")

            file.printWriter().use { writer ->
                writer.println("Bingwa Score crash report")
                writer.println("Timestamp : $timestamp")
                writer.println("Thread    : ${thread.name}")
                writer.println("App version: ${com.bingwascore.app.BuildConfig.VERSION_NAME}")
                writer.println("----------------------------------------")
                writer.println()
                throwable.printStackTrace(PrintWriter(writer))
            }
        } catch (_: Throwable) {
            // Swallow everything — never let the crash handler throw.
        }
    }

    /** Returns the contents of the most recent crash report, or null when none exists. */
    fun latestCrashReport(): String? = runBlocking(Dispatchers.IO) {
        try {
            val dir = context.getExternalFilesDir("crashes") ?: return@runBlocking null
            if (!dir.exists()) return@runBlocking null
            dir.listFiles()
                ?.filter { it.name.startsWith("crash_") && it.name.endsWith(".txt") }
                ?.maxByOrNull { it.lastModified() }
                ?.readText()
        } catch (_: Throwable) {
            null
        }
    }

    /** Records a StrictMode violation or ANR trace into the crash-report file. */
    fun recordViolation(throwable: Throwable?) {
        if (throwable == null) return
        writeCrashReport(Thread.currentThread(), throwable)
    }

    /** Writes an ANR dump (main-thread stack) into the crash-report file. */
    fun writeAnrReport(throwable: Throwable) {
        writeCrashReport(Looper.getMainLooper().thread, throwable)
    }

    companion object {
        private val TIMESTAMP_FORMAT = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US)

        /** Installs this handler, remembering whatever was there before. */
        fun init(context: Context) {
            try {
                val previous = Thread.getDefaultUncaughtExceptionHandler()
                Thread.setDefaultUncaughtExceptionHandler(
                    CrashHandler(context.applicationContext, previous)
                )
            } catch (_: Throwable) {
                // Initialization is best-effort only.
            }
        }

        /** Top-level entry point so settings can read the last report without constructing the handler. */
        fun readLatestCrashReport(context: Context): String? =
            CrashHandler(context).latestCrashReport()

        /** Records a throwable (StrictMode violation, ANR, etc.) on the calling thread. */
        fun record(context: Context, throwable: Throwable?) =
            CrashHandler(context.applicationContext).recordViolation(throwable)

        /** Alias used by StrictMode penalty listeners. */
        fun recordStrictModeViolation(context: Context, violation: Throwable?) =
            record(context, violation)

        /** Alias used by the ANR watchdog. */
        fun recordAnr(context: Context, throwable: Throwable?) =
            CrashHandler(context.applicationContext).writeAnrReport(
                throwable ?: Throwable("ANR")
            )
    }
}