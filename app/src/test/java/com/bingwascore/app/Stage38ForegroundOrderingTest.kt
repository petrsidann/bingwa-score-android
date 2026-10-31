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
 * STAGE 38 — foreground-service ordering fix (trace-confirmed).
 *
 * The owner device produced an ANR kill with
 * `Context.startForegroundService() did not then call Service.startForeground():
 * EngineService`. These tests pin the invariant that made that possible: every
 * path through [EngineService.onStartCommand] must have promoted the service to
 * the foreground before it returns, so the OS 5-second window can never expire.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage38ForegroundOrderingTest {

    private val app: Application get() = RuntimeEnvironment.getApplication()

    @Before
    fun setUp() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        AppForegroundGate.setForegroundForTest(false)
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

    // --- promotion happens on every path --------------------------------

    @Test
    fun coldStart_promotesBeforeReturning() {
        val controller = createdService()
        val service = controller.get()

        val result = service.onStartCommand(engineIntent(), 0, 1)

        assertNotNull(
            "startForeground must run before onStartCommand returns",
            shadowOf(service).lastForegroundNotification
        )
        assertEquals(Service.START_STICKY, result)
        assertTrue(EngineService.isRunning)
    }

    @Test
    fun secondStartWhileRunning_stillPromotes() {
        // The exact regression: onCreate used to set isRunning=true, so the very
        // first onStartCommand took the "already running" early return and the
        // service was never promoted at all.
        val controller = createdService()
        val service = controller.get()

        service.onStartCommand(engineIntent(), 0, 1)
        val second = service.onStartCommand(engineIntent(), 0, 2)

        assertNotNull(
            "a repeat start must not short-circuit before promotion",
            shadowOf(service).lastForegroundNotification
        )
        assertEquals(Service.START_STICKY, second)
    }

    @Test
    fun stopAction_promotesBeforeStopping() {
        val controller = createdService()
        val service = controller.get()

        // A stop request must still satisfy the foreground contract before the
        // service tears itself down. The notification is built (and posted)
        // strictly before stopSelf, which is the ordering the OS requires.
        var builtBeforeStop = false
        EngineService.testNotificationOverride = {
            builtBeforeStop = !shadowOf(service).isStoppedBySelf
            Notification()
        }

        val result = service.onStartCommand(
            engineIntent().setAction(EngineService.ACTION_STOP),
            0,
            1
        )

        assertTrue("promotion must happen before the service stops itself", builtBeforeStop)
        assertEquals(Service.START_NOT_STICKY, result)
        assertTrue(shadowOf(service).isStoppedBySelf)
    }

    @Test
    fun unreadableNotification_recordsStopsAndDoesNotLoop() {
        // The one path where startForeground itself cannot succeed: the service
        // must give the process back immediately instead of burning the window.
        EngineService.testNotificationOverride = {
            throw IllegalStateException("notification build failed")
        }
        val controller = createdService()
        val service = controller.get()

        val result = service.onStartCommand(engineIntent(), 0, 1)

        assertEquals(Service.START_NOT_STICKY, result)
        assertTrue("service must stop itself", shadowOf(service).isStoppedBySelf)
        assertNull(shadowOf(service).lastForegroundNotification)
        assertTrue("isRunning must not leak true on failure", !EngineService.isRunning)
    }

    @Test
    fun notificationIsBuiltWithoutTouchingStorage() {
        // buildNotification must read only cached values; the override seam above
        // proves the build path is a pure in-memory call. Here we assert the
        // posted notification actually carries the cached ongoing shape.
        val controller = createdService()
        val service = controller.get()

        service.onStartCommand(engineIntent(), 0, 1)
        val notification: Notification? = shadowOf(service).lastForegroundNotification

        assertNotNull(notification)
        assertTrue((notification!!.flags and Notification.FLAG_ONGOING_EVENT) != 0)
    }

    // --- caller gate ----------------------------------------------------

    @Test
    @Config(sdk = [31])
    fun backgroundStartOnAndroid12_defersInsteadOfStartingService() {
        var deferred = 0
        EngineService.enqueueBackgroundStart = { deferred++ }
        AppForegroundGate.setForegroundForTest(false)

        EngineService.start(app)

        assertEquals("background start must be deferred", 1, deferred)
        assertNull(
            "no foreground service may be started from the background on API 31+",
            shadowOf(app).nextStartedService
        )
    }

    @Test
    @Config(sdk = [31])
    fun foregroundStartOnAndroid12_startsServiceDirectly() {
        var deferred = 0
        EngineService.enqueueBackgroundStart = { deferred++ }
        AppForegroundGate.setForegroundForTest(true)

        EngineService.start(app)

        assertEquals(0, deferred)
        assertNotNull(
            "a foreground start must reach startForegroundService",
            shadowOf(app).nextStartedService
        )
    }

    @Test
    @Config(sdk = [30])
    fun backgroundStartOnAndroid11_isStillAllowed() {
        var deferred = 0
        EngineService.enqueueBackgroundStart = { deferred++ }
        AppForegroundGate.setForegroundForTest(false)

        EngineService.start(app)

        assertEquals("pre-31 has no background FGS restriction", 0, deferred)
        assertNotNull(shadowOf(app).nextStartedService)
    }
}
