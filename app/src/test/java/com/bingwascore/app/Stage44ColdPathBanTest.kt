package com.bingwascore.app

import android.app.Application
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.workers.EngineStartWorker
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.io.File

/**
 * STAGE 44 — COLD-PATH BAN.
 *
 * Device law (Transsion X693, cold spawn ~12s): startForegroundService() may
 * NEVER be called from a cold path — Application.onCreate (relaunch
 * auto-start), BootReceiver, or the watchdog. The engine starts ONLY from a
 * foreground Activity (Start Earning) or a WorkManager one-shot in an
 * already-alive process. These tests pin the ban two ways:
 *  1) Source assertions: no cold-path file may reference a direct engine start.
 *  2) A Robolectric shadow-service assertion: a background start attempt never
 *     reaches startForegroundService — it defers to EngineStartWorker.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage44ColdPathBanTest {

    private val app: Application get() = RuntimeEnvironment.getApplication()

    @Before
    fun setUp() {
        EngineService.isRunning = false
        AppForegroundGate.setForegroundForTest(false)
    }

    @After
    fun tearDown() {
        EngineService.isRunning = false
        EngineService.enqueueBackgroundStart = { EngineStartWorker.enqueue(it) }
        AppForegroundGate.setForegroundForTest(false)
    }

    private fun source(relative: String): String {
        val root = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        return File(root, relative).readText()
    }

    @Test
    fun `cold paths never start the engine service directly`() {
        val coldPaths = mapOf(
            "app/src/main/java/com/bingwascore/app/BingwaScoreApp.kt" to "Application.onCreate relaunch auto-start",
            "app/src/main/java/com/bingwascore/app/receivers/BootReceiver.kt" to "boot receiver",
            "app/src/main/java/com/bingwascore/app/workers/WatchdogWorker.kt" to "watchdog"
        )
        coldPaths.forEach { (path, label) ->
            val src = source(path)
            assertFalse(
                "$label must never call EngineService.start()",
                src.contains("EngineService.start(")
            )
            assertFalse(
                "$label must never call startForegroundService()",
                src.contains("startForegroundService(")
            )
            assertTrue(
                "$label must defer engine revival to the EngineStartWorker one-shot",
                src.contains("EngineStartWorker.enqueue")
            )
        }
    }

    @Test
    @Config(sdk = [31])
    fun `a background engine start never reaches startForegroundService`() {
        var deferred = 0
        EngineService.enqueueBackgroundStart = { deferred++ }
        AppForegroundGate.setForegroundForTest(false)

        EngineService.start(app)

        assertTrue("background start must defer to the WorkManager one-shot", deferred == 1)
        assertNull(
            "shadow-service assertion: no service may be started from the background",
            shadowOf(app).nextStartedService
        )
    }

    @Test
    @Config(sdk = [31])
    fun `a foreground engine start is the only direct path`() {
        AppForegroundGate.setForegroundForTest(true)

        EngineService.start(app)

        assertTrue(
            "foreground Activity start is the sanctioned direct path",
            shadowOf(app).nextStartedService != null
        )
    }
}
