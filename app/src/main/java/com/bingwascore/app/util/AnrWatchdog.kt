package com.bingwascore.app.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.bingwascore.app.util.CrashHandler

/**
 * Background heartbeat that pings the main thread every second. If the main
 * thread stays unresponsive for more than 3 seconds, the main-thread stack is
 * dumped into the crash-report file so traces survive without a bug report.
 */
object AnrWatchdog {

    private const val PING_INTERVAL_MS = 1000L
    private const val ANR_THRESHOLD_MS = 3000L

    @Volatile
    private var lastBeat: Long = 0L

    fun start(context: Context) {
        lastBeat = System.currentTimeMillis()
        val appContext = context.applicationContext
        val mainHandler = Handler(Looper.getMainLooper())

        val beat = object : Runnable {
            override fun run() {
                lastBeat = System.currentTimeMillis()
                mainHandler.postDelayed(this, PING_INTERVAL_MS)
            }
        }
        mainHandler.post(beat)

        val thread = Thread {
            while (true) {
                try {
                    Thread.sleep(PING_INTERVAL_MS)
                } catch (_: InterruptedException) {
                    return@Thread
                }
                if (System.currentTimeMillis() - lastBeat > ANR_THRESHOLD_MS) {
                    dumpMainThread(appContext)
                    lastBeat = System.currentTimeMillis()
                }
            }
        }
        thread.isDaemon = true
        thread.name = "AnrWatchdog"
        thread.start()
    }

    private fun dumpMainThread(context: Context) {
        val mainThread = Looper.getMainLooper().thread
        val throwable = Throwable("ANR: main thread unresponsive > ${ANR_THRESHOLD_MS}ms")
        throwable.stackTrace = mainThread.stackTrace
        CrashHandler.recordAnr(context, throwable)
    }
}