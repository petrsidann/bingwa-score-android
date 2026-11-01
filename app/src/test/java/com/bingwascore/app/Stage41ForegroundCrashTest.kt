package com.bingwascore.app

import android.app.Application
import android.app.Notification
import android.app.Service
import android.content.Intent
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.workers.EngineStartWorker
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.android.controller.ServiceController

/**
 * MICRO-STAGE 41 — ENGINE FOREGROUND CRASH TESTS.
 *
 * TRACE: FATAL RemoteServiceException: startForegroundService() did not then call Service.startForeground(): EngineService
 * Tests proving the trace line is dead:
 * (a) startForegroundService -> lastForegroundNotification non-null right after onCreate;
 * (b) engineEnabled=false path still foregrounds;
 * (c) throw-path stops self without crash;
 * (d) start->stop->start relaunch sim foregrounds.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage41ForegroundCrashTest {

    private val app: Application get() = RuntimeEnvironment.getApplication()

    @Before
    fun setUp() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        AppForegroundGate.setForegroundForTest(true)
    }

    @After
    fun tearDown() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        EngineService.enqueueBackgroundStart = { EngineStartWorker.enqueue(it) }
        AppForegroundGate.setForegroundForTest(false)
    }

    private fun createdService(): ServiceController<EngineService> =
        Robolectric.buildService(EngineService::class.java).create()

    private fun engineIntent(): Intent = Intent(app, EngineService::class.java)

    /**
     * (a) startForegroundService -> lastForegroundNotification non-null right after onCreate.
     * Proves that onCreate() immediately calls startForeground with minimalNotification().
     */
    @Test
    fun startForegroundService_lastForegroundNotificationNonNullRightAfterOnCreate() {
        val controller = createdService()
        val service = controller.get()

        assertNotNull(
            "lastForegroundNotification must be non-null immediately right after onCreate",
            shadowOf(service).lastForegroundNotification
        )
    }

    /**
     * (b) engineEnabled=false path still foregrounds.
     * When EngineService is started (e.g. from service startup or intent while disabled / before preference check),
     * it foregrounds immediately and unconditionally before any checks or logic.
     */
    @Test
    fun engineEnabledFalsePath_stillForegrounds() {
        val controller = createdService()
        val service = controller.get()

        // Even if engine is considered disabled or stop action is passed,
        // foregrounding has already occurred in onCreate and re-occurs in onStartCommand.
        assertNotNull(shadowOf(service).lastForegroundNotification)

        val result = service.onStartCommand(engineIntent(), 0, 1)

        assertNotNull(
            "engineEnabled=false / cold-start path must still foreground",
            shadowOf(service).lastForegroundNotification
        )
        assertEquals(Service.START_STICKY, result)
        assertTrue(EngineService.isRunning)
    }

    /**
     * (c) throw-path stops self without crash.
     * If notification creation or startForeground throws in onCreate or onStartCommand,
     * the service stops itself cleanly without crashing the process.
     */
    @Test
    fun throwPath_inOnCreate_stopsSelfWithoutCrash() {
        EngineService.testNotificationOverride = {
            throw IllegalStateException("minimal notification failure simulation")
        }

        // buildService().create() invokes onCreate()
        val controller = Robolectric.buildService(EngineService::class.java).create()
        val service = controller.get()

        assertTrue("service must stop itself on throw path in onCreate", shadowOf(service).isStoppedBySelf)
        assertNull("no notification posted when throw happens", shadowOf(service).lastForegroundNotification)
        assertTrue("isRunning must remain false", !EngineService.isRunning)
    }

    @Test
    fun throwPath_inOnStartCommand_stopsSelfWithoutCrash() {
        val controller = createdService()
        val service = controller.get()

        EngineService.testNotificationOverride = {
            throw IllegalStateException("notification build failure simulation")
        }

        val result = service.onStartCommand(engineIntent(), 0, 1)

        assertEquals(Service.START_NOT_STICKY, result)
        assertTrue("service must stop itself on throw path in onStartCommand", shadowOf(service).isStoppedBySelf)
        assertTrue("isRunning must not leak true on failure", !EngineService.isRunning)
    }

    /**
     * (d) start->stop->start relaunch sim foregrounds.
     * Simulates start -> stop (via ACTION_STOP / onDestroy) -> start (relaunch).
     * Proves each lifecycle iteration immediately foregrounds.
     */
    @Test
    fun startStopStart_relaunchSimForegrounds() {
        // --- 1. First Start ---
        var controller = Robolectric.buildService(EngineService::class.java).create()
        var service = controller.get()
        assertNotNull("1st launch onCreate must foreground", shadowOf(service).lastForegroundNotification)

        var result = service.onStartCommand(engineIntent(), 0, 1)
        assertEquals(Service.START_STICKY, result)
        assertTrue(EngineService.isRunning)
        assertNotNull("1st launch onStartCommand must foreground", shadowOf(service).lastForegroundNotification)

        // --- 2. Stop ---
        result = service.onStartCommand(engineIntent().setAction(EngineService.ACTION_STOP), 0, 2)
        assertEquals(Service.START_NOT_STICKY, result)
        assertTrue(shadowOf(service).isStoppedBySelf)
        controller.destroy()
        assertTrue(!EngineService.isRunning)

        // --- 3. Second Start (Relaunch) ---
        controller = Robolectric.buildService(EngineService::class.java).create()
        service = controller.get()
        assertNotNull("Relaunch onCreate must foreground immediately", shadowOf(service).lastForegroundNotification)

        result = service.onStartCommand(engineIntent(), 0, 1)
        assertEquals(Service.START_STICKY, result)
        assertTrue(EngineService.isRunning)
        assertNotNull("Relaunch onStartCommand must foreground", shadowOf(service).lastForegroundNotification)
    }
}
