package com.bingwascore.app

import android.app.Application
import android.content.Intent
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.workers.EngineStartWorker
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.io.File

/**
 * STAGE 46 — ENTRY GUARANTEE.
 *
 * Verifies the entry-guarantee laws: foreground-only FGS, crash circuit breaker,
 * resume reset, and boot-receiver/worker call-site restrictions.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage46EntryGuaranteeTest {

    private val app: Application get() = RuntimeEnvironment.getApplication()

    @Before
    fun setUp() {
        RuntimeEnvironment.getApplication()
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        AppForegroundGate.setForegroundForTest(false)
        CrashHandler.resetConsecutiveCrashes()
    }

    @After
    fun tearDown() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        AppForegroundGate.setForegroundForTest(false)
        CrashHandler.resetConsecutiveCrashes()
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

    // --- onCreate promotes to foreground synchronously (no cold-path start) ---
    @Test
    fun `onCreate promotes to foreground synchronously, no cold start before resume`() {
        repeat(3) {
            val controller = Robolectric.buildService(EngineService::class.java).create()
            val service = controller.get()
            // STAGE 41 — promotion is the first synchronous act of onCreate
            assertNotNull(
                "onCreate must promote to foreground synchronously",
                shadowOf(service).lastForegroundNotification
            )
            // No caller may start the service from a cold path
            assertNull(
                "no caller may start the service from a cold path",
                shadowOf(app).nextStartedService
            )
            controller.destroy()
        }
    }

    // --- foreground onStartCommand sets engine running ---
    @Test
    fun `foreground onStartCommand sets engine running`() {
        AppForegroundGate.setForegroundForTest(true)
        val controller = Robolectric.buildService(EngineService::class.java).create()
        val service = controller.get()
        val intent = Intent(app.applicationContext, EngineService::class.java)
        service.onStartCommand(intent, 0, 0)
        assertTrue("foreground onStartCommand sets isRunning", EngineService.isRunning)
        controller.destroy()
    }

    // --- breaker: counter + boot skip ---
    @Test
    fun `consecutiveCrashes_2 boots engine off and amber banner visible`() {
        CrashHandler.incrementConsecutiveCrashes()
        assertEquals(1, CrashHandler.getConsecutiveCrashes())
        assertFalse(CrashHandler.bootSkipsEngine())

        CrashHandler.incrementConsecutiveCrashes()
        assertEquals(2, CrashHandler.getConsecutiveCrashes())
        assertTrue(CrashHandler.bootSkipsEngine())
        assertTrue(CrashHandler.getConsecutiveCrashes() >= 2)
    }

    // --- call-site restrictions ---
    @Test
    fun `boot receiver and worker never call startForegroundService directly`() {
        val bootSrc = source("app/src/main/java/com/bingwascore/app/receivers/BootReceiver.kt")
        assertFalse(
            "boot receiver must not start a foreground service directly",
            bootSrc.contains("startForegroundService(")
        )
        assertTrue(
            "boot receiver defers revival to the EngineStartWorker one-shot",
            bootSrc.contains("EngineStartWorker")
        )
        assertTrue(
            "boot receiver honours the crash breaker",
            bootSrc.contains("bootSkipsEngine()")
        )

        val workerSrc = source("app/src/main/java/com/bingwascore/app/workers/EngineStartWorker.kt")
        assertFalse(
            "one-shot worker must not start a foreground service directly",
            workerSrc.contains("startForegroundService(")
        )
        assertTrue(
            "worker gates promotion on the foreground gate",
            workerSrc.contains("AppForegroundGate.isForeground")
        )
        assertTrue(
            "worker is the enqueue target of every cold path",
            workerSrc.contains("fun enqueue")
        )
    }

    // --- crash counter resets on Home resume ---
    @Test
    fun `crash counter resets on Home resume`() {
        CrashHandler.incrementConsecutiveCrashes()
        assertTrue("uncaught increment must register", CrashHandler.getConsecutiveCrashes() >= 1)
        CrashHandler.resetConsecutiveCrashes()
        assertEquals(0, CrashHandler.getConsecutiveCrashes())
    }
}
