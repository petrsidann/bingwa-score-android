package com.bingwascore.app.util

import android.content.Context
import android.content.SharedPreferences
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Global crash handler. Writes the stack trace plus a timestamp to
 * getExternalFilesDir("crashes")/crash_<timestamp>.txt so the agent can pull the
 * file for debugging, then hands off to the previously-installed default handler
 * (which terminates the process). Every step is wrapped so the handler itself can
 * never crash the app a second time.
 *
 * STAGE 45 — crash circuit breaker: tracks consecutive crashes and pauses
 * the engine after 2 consecutive crashes to prevent a death loop.
 */
class CrashHandler(
    private val context: Context,
    private val defaultHandler: Thread.UncaughtExceptionHandler? = null
) : Thread.UncaughtExceptionHandler {

    private val prefs: SharedPreferences
        = context.getSharedPreferences("crash_circuit", Context.MODE_PRIVATE)

    private val CONSECUTIVE_CRASHES_KEY = "consecutive_crashes"

    // Current consecutive crash count (in-memory, persisted via prefs)
    @Volatile
    private var consecutiveCrashes: Int = prefs.getInt(CONSECUTIVE_CRASHES_KEY, 0)

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        writeCrashReport(thread, throwable)
        // Increment consecutive crash counter on every uncaught exception
        incrementConsecutiveCrashes()
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
        incrementConsecutiveCrashes()
    }

    /** Writes an ANR dump (main-thread stack) into the crash-report file. */
    fun writeAnrReport(throwable: Throwable) {
        writeCrashReport(Looper.getMainLooper().thread, throwable)
        incrementConsecutiveCrashes()
    }

    /** Increments the consecutive crash counter and persists it. */
    private fun incrementConsecutiveCrashes() {
        consecutiveCrashes = (consecutiveCrashes + 1).coerceAtLeast(0)
        prefs.edit().putInt(CONSECUTIVE_CRASHES_KEY, consecutiveCrashes).apply()
    }

    /** Returns the current consecutive crash count. */
    fun getConsecutiveCrashes(): Int = consecutiveCrashes

    /** Resets the consecutive crash counter to zero. Must be called on successful Home resume. */
    fun resetConsecutiveCrashes() {
        consecutiveCrashes = 0
        prefs.edit().putInt(CONSECUTIVE_CRASHES_KEY, 0).apply()
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

        /** Returns the current consecutive crash count. */
        fun getConsecutiveCrashes(): Int = consecutiveCrashes

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