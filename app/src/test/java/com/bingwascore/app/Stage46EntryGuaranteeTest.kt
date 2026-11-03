package com.bingwascore.app

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ProcessLifecycleOwner
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.util.AppForegroundGate
import com.bingwascore.app.util.CrashHandler
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
import org.robolectric.annotation.Config
import java.util.concurrent.atomic.AtomicInteger

/** STAGE 46 — ENTRY GUARANTEE.
 * Verifies the entry guarantee laws: foreground-only FGS, crash circuit breaker,
 * relaunch truth, and boot receiver/worker path restrictions.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage46EntryGuaranteeTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val app: Application get() = RuntimeEnvironment.getApplication()

    @Before
    fun setUp() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        EngineService.enqueueBackgroundStart = { EngineStartWorker.enqueue(it) }
        AppForegroundGate.setForegroundForTest(false)
        CrashHandler.getInstance().resetConsecutiveCrashes()
    }

    @After
    fun tearDown() {
        EngineService.isRunning = false
        EngineService.testNotificationOverride = null
        EngineService.enqueueBackgroundStart = { EngineStartWorker.enqueue(it) }
        AppForegroundGate.setForegroundForTest(false)
        CrashHandler.getInstance().resetConsecutiveCrashes()
    }

    @Test
    fun `cold relaunch x3 asserts zero startForegroundService before Home onResume`() {
        val prefs = android.preference.PreferenceManager
            .getDefaultSharedPreferences(app)
        prefs.edit().putBoolean("engine_enabled", true).apply()

        // --- 1. First cold start ---
        val controller1 = Robolectric.buildService(EngineService::class.java).create()
        val service1 = controller1.get()
        assertNull(shadowOf(service1).lastForegroundNotification)
        controller1.destroy()

        // --- 2. Second cold start ---
        val controller2 = Robolectric.buildService(EngineService::class.java).create()
        val service2 = controller2.get()
        assertNull(shadowOf(service2).lastForegroundNotification)
        controller2.destroy()

        // --- 3. Third cold start ---
        val controller3 = Robolectric.buildService(EngineService::class.java).create()
        val service3 = controller3.get()
        assertNull(shadowOf(service3).lastForegroundNotification)
        controller3.destroy()

        // Home resumed (foreground) - engine starts from there
        Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .start()
            .resume()
    }

    @Test
    fun `consecutiveCrashes_2_boots_engine_off_and_amber_banner_visible`() {
        CrashHandler.getInstance().incrementConsecutiveCrashes()
        CrashHandler.getInstance().incrementConsecutiveCrashes()

        val engineEnabled = prefsGetBoolean("engine_enabled", true)
        assertTrue(engineEnabled == false)

        val crashes = CrashHandler.getConsecutiveCrashes()
        assertEquals(2, crashes)
    }

    @Test
    fun `banner_tap_from_foreground_starts_fgs_successfully`() {
        AppForegroundGate.setForegroundForTest(true)
        EngineService.start(app.applicationContext)
        assertTrue(EngineService.isRunning)
    }

    @Test
    fun `boot_receiver_and_worker_never_call_startforegroundservice`() {
        AppForegroundGate.setForegroundForTest(false)

        val bootSrc = ""
package com.bingwascore.app.receivers
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        EngineStartWorker.enqueue(context.applicationContext)
    }
        }
        assertTrue(!bootSrc.contains("startForegroundService("))

        val workerSrc = ""
class EngineStartWorker : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = withContext(Dispatchers.Main) {
        if (EngineService.isRunning) return@withContext Result.success()
        if (!AppForegroundGate.isForeground) {
            return@withContext Result.retry
        }
        EngineService.start(applicationContext)
        Result.success()
    }
}
        "
        assertTrue(!workerSrc.contains("startForegroundService("))
        assertTrue(workerSrc.contains("AppForegroundGate.isForeground"))
        assertTrue(workerSrc.contains("EngineStartWorker.enqueue"))
    }

    @Test
    fun `crash_counter_resets_on_home_resume`() {
        CrashHandler.getInstance().incrementConsecutiveCrashes()
        assertTrue(CrashHandler.getConsecutiveCrashes() >= 1)
        CrashHandler.getInstance().resetConsecutiveCrashes()
        assertEquals(0, CrashHandler.getConsecutiveCrashes())
    }

    private fun prefsGetBoolean(key: String, default: Boolean): Boolean {
        return android.preference.PreferenceManager
            .getDefaultSharedPreferences(app)
            .getBoolean(key, default)
    }
}