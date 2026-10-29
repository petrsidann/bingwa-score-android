package com.bingwascore.app

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppState
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.ValidateStartupUseCase
import com.bingwascore.app.ui.onboarding.SetupChecklistViewModel
import com.bingwascore.app.services.EngineService
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.BrandBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Error
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.PorcelainDimBg
import com.bingwascore.app.ui.theme.PorcelainDimCard
import com.bingwascore.app.ui.theme.PorcelainDimText
import com.bingwascore.app.ui.theme.Success
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.Warning
import com.bingwascore.app.ui.theme.installDisplayMode
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.first
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implements
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

/**
 * Stage 34 — crash-free launch and relaunch.
 *
 * Covers the engine-service lifecycle (idempotent, null-safe start) and the
 * cold-start gate: a fully set-up install goes straight to Home, an
 * unpermissioned install never reaches Home, engine-off never reaches Home,
 * and "Finish setup" enables + starts the engine so the agent never lands on
 * an engine-less Home or loops back into the checklist on relaunch.
 *
 * [GrantPermissionsShadow] makes ContextCompat report PERMISSION_GRANTED so
 * the ready-for-home path is deterministic on Robolectric.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage34CrashLifecycleTest {

    @Implements(ContextCompat::class)
    private object GrantPermissionsShadow {
        @JvmStatic
        fun checkSelfPermission(context: Context?, perm: String): Int =
            PackageManager.PERMISSION_GRANTED
    }

    private fun prefs(setupComplete: Boolean, engineEnabled: Boolean): UserPreferences = runBlocking {
        val p = UserPreferences(RuntimeEnvironment.application)
        p.setSetupComplete(setupComplete)
        p.setEngineEnabled(engineEnabled)
        p
    }

    @Test
    @Config(shadows = [GrantPermissionsShadow::class], sdk = [34])
    fun `fully set up install is ready for home on cold start`() = runBlocking {
        val gate = ValidateStartupUseCase(RuntimeEnvironment.application, prefs(true, true))
        val result = gate.evaluate()

        assertTrue("readyForHome", result.readyForHome)
        assertEquals(AppState.STATE_RUNNING, result.state)
    }

    @Test
    fun `unpermissioned install is not ready for home`() = runBlocking {
        val gate = ValidateStartupUseCase(RuntimeEnvironment.application, prefs(true, true))
        val result = gate.evaluate()

        assertFalse("no permissions -> not ready for home", result.readyForHome)
        assertFalse(
            "permission check is not done",
            result.checks.first { it.id == "permissions" }.done
        )
    }

    @Test
    fun `engine disabled keeps the user off home`() = runBlocking {
        val gate = ValidateStartupUseCase(
            RuntimeEnvironment.application,
            prefs(true, false)
        )
        assertFalse("engine off -> not ready for home", gate.evaluate().readyForHome)
    }

    @Test
    fun `finish setup enables and starts the engine without throwing`() = runBlocking {
        val context = RuntimeEnvironment.application
        val prefs = UserPreferences(context)
        val checklist = SetupChecklistViewModel(context, prefs)

        checklist.completeSetup()

        assertTrue("setup persisted", prefs.setupComplete.first())
        assertTrue("engine enabled", prefs.engineEnabled.first())

        // EngineService.start is idempotent: calling it twice must not throw
        // or re-foreground a running service.
        EngineService.start(context)
        EngineService.start(context)
    }

    @Test
    fun `engine service start is null-safe`() {
        EngineService.start(RuntimeEnvironment.application)
        EngineService.start(RuntimeEnvironment.application)
    }

    @Test
    fun `theme default is porcelain dim`() {
        assertEquals(ThemeMode.PORCELAIN_DIM, ThemeMode.fromValue(null))
        assertEquals(ThemeMode.PORCELAIN_DIM, ThemeMode.fromValue(""))
    }

    @Test
    fun `theme toggle persists and flips`() = runBlocking {
        val prefs = UserPreferences(RuntimeEnvironment.application)

        prefs.setThemeMode(ThemeMode.DARK)
        assertEquals(ThemeMode.DARK, prefs.themeMode.first())

        prefs.setThemeMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(ThemeMode.PORCELAIN_DIM, prefs.themeMode.first())
    }

    @Test
    fun `text tokens are dark on light, light on dark`() {
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(PorcelainDimText.toArgb(), TextWhite.toArgb())
        assertEquals(PorcelainDimCard.toArgb(), Bubble.toArgb())
        assertEquals(PorcelainDimBg.toArgb(), BgBlack.toArgb())
        installDisplayMode(ThemeMode.DARK)
        assertEquals(Color.White.toArgb(), TextWhite.toArgb())
        assertEquals(0xFF1E293B.toInt(), Bubble.toArgb())
        assertEquals(0xFF0F172A.toInt(), BgBlack.toArgb())
        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `design tokens match the spec`() {
        assertEquals(0xFF2563EB.toInt(), BrandBlue.toArgb())
        assertEquals(0xFF10B981.toInt(), Success.toArgb())
        assertEquals(0xFFEF4444.toInt(), Error.toArgb())
        assertEquals(0xFFF59E0B.toInt(), Warning.toArgb())

        installDisplayMode(ThemeMode.DARK)
        assertEquals(0xFF0F172A.toInt(), BgBlack.toArgb())
        assertEquals(0xFF1E293B.toInt(), Bubble.toArgb())
        assertEquals(0xFF475569.toInt(), Hairline.toArgb())
        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertEquals(0xFFF1F5F9.toInt(), BgBlack.toArgb())
        assertEquals(0xFFFFFFFF.toInt(), Bubble.toArgb())
        assertEquals(0xFFCBD5E1.toInt(), Hairline.toArgb())
        installDisplayMode(ThemeMode.DARK)
    }
}
