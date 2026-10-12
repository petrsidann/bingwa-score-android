package com.bingwascore.app

import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.ui.home.AutopilotGuard
import com.bingwascore.app.ui.home.Greetings
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 12 — home guards + diplomatics acceptance.
 *
 * - The Autopilot pill's TAP never pauses: pausing requires the full 600ms
 *   hold, and the progress ring is drawn from the same pure function.
 * - The credits bubble reflects PLAN state: pulls-left as a count, "N days"
 *   for unlimited, earned-credit fallback when no plan is active.
 * - Diplomatics: pinned language beats rotation, DAY cadence ignores the
 *   session index, SESSION cadence keeps the old behaviour.
 * - UI wiring (ring on pill, label in bubble, screen reachable) is pinned by
 *   source checks, the house style for Composable contracts here.
 */
class Stage12HomeGuardsTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    // ── Tap never pauses ────────────────────────────────────────────────────

    @Test
    fun `tap on the pill never pauses - only the full hold does`() {
        assertFalse("a tap must never pause the engine", AutopilotGuard.TAP_PAUSES)
    }

    @Test
    fun `hold must run the full 600ms before it commits`() {
        assertEquals(600L, AutopilotGuard.HOLD_MILLIS)
        assertFalse(AutopilotGuard.holdCompleted(AutopilotGuard.HOLD_MILLIS - 1))
        assertTrue(AutopilotGuard.holdCompleted(AutopilotGuard.HOLD_MILLIS))
    }

    @Test
    fun `hold progress is a clamped zero to one ramp`() {
        assertEquals(0f, AutopilotGuard.holdProgress(0), 0.0001f)
        assertEquals(0.5f, AutopilotGuard.holdProgress(300), 0.0001f)
        assertEquals(1f, AutopilotGuard.holdProgress(600), 0.0001f)
        assertEquals(1f, AutopilotGuard.holdProgress(9_000), 0.0001f)
    }

    @Test
    fun `pill draws the ring from the guard and opens the sheet on early release`() {
        val chrome = source("app/src/main/java/com/bingwascore/app/ui/home/HomeChrome.kt")
        assertTrue(
            "the pill must animate the ring over AutopilotGuard.HOLD_MILLIS",
            chrome.contains("AutopilotGuard.HOLD_MILLIS")
        )
        assertTrue(
            "the ring must be drawn on the pill",
            chrome.contains("ringProgress")
        )
        assertTrue(
            "early release must open the sheet, never pause",
            chrome.contains("that is a tap, and a tap only opens the sheet")
        )
        assertTrue(
            "completion must fire one haptic then pause",
            chrome.contains("haptics.press()") && chrome.contains("onPause()")
        )
    }

    // ── Credits reflect plan state ──────────────────────────────────────────

    @Test
    fun `no plan means the bubble falls back to earned credits`() {
        val plan = PlanState()
        assertFalse(plan.isActive)
        assertNull("inactive plan must not produce a label", plan.remainingLabel(0L))
    }

    @Test
    fun `pulls plan shows pulls left as a bare count`() {
        val plan = PlanState(planId = "basic", displayName = "Basic", pullsLeft = 417)
        assertEquals("417", plan.remainingLabel(0L))
    }

    @Test
    fun `unlimited plan shows days left, counting the current day`() {
        val now = 1_000_000_000_000L
        val threeDays = PlanState(
            planId = "small", displayName = "Small",
            unlimited = true, expiresAtMillis = now + 3 * PlanState.DAY_MILLIS
        )
        assertEquals("4 days", threeDays.remainingLabel(now))
        val lastDay = PlanState(
            planId = "small", displayName = "Small",
            unlimited = true, expiresAtMillis = now + 1
        )
        assertEquals("1 day", lastDay.remainingLabel(now))
    }

    @Test
    fun `expired unlimited plan reads one day, never negative`() {
        val now = 1_000_000_000_000L
        val expired = PlanState(
            planId = "mega", displayName = "Mega",
            unlimited = true, expiresAtMillis = now - 10 * PlanState.DAY_MILLIS
        )
        assertEquals("1 day", expired.remainingLabel(now))
    }

    @Test
    fun `home bubble is driven by the plan label - source check`() {
        val vm = source("app/src/main/java/com/bingwascore/app/ui/home/HomeViewModel.kt")
        assertTrue(
            "creditsLabel must combine plan state with earned credits",
            vm.contains("plan.remainingLabel")
        )
        val screen = source("app/src/main/java/com/bingwascore/app/ui/home/HomeScreen.kt")
        assertTrue(
            "the bubble tap must open My Plan",
            screen.contains("onCreditsClick = onOpenMyPlan")
        )
    }

    // ── Diplomatics: pin + cadence ──────────────────────────────────────────

    @Test
    fun `pinned language beats the rotation`() {
        Greetings.Language.entries.forEach { pinned ->
            assertEquals(
                "pin must win for ${pinned.name}",
                pinned,
                Greetings.languageFor(120, 3, Greetings.Cadence.SESSION, pinned)
            )
        }
    }

    @Test
    fun `day cadence ignores the session index`() {
        val first = Greetings.languageFor(120, 0, Greetings.Cadence.DAY)
        val second = Greetings.languageFor(120, 7, Greetings.Cadence.DAY)
        assertEquals("per-day cadence must not move within the day", first, second)
    }

    @Test
    fun `session cadence keeps the original advance`() {
        val first = Greetings.languageFor(120, 0, Greetings.Cadence.SESSION)
        val second = Greetings.languageFor(120, 1, Greetings.Cadence.SESSION)
        assertFalse("per-session cadence must advance with the session", first == second)
    }

    @Test
    fun `cadence parse falls back to session on unknown values`() {
        assertEquals(Greetings.Cadence.SESSION, Greetings.Cadence.fromValue(null))
        assertEquals(Greetings.Cadence.SESSION, Greetings.Cadence.fromValue("hourly"))
        assertEquals(Greetings.Cadence.DAY, Greetings.Cadence.fromValue("day"))
    }

    @Test
    fun `diplomatics screen exists and exposes rotation choices`() {
        val screen = source("app/src/main/java/com/bingwascore/app/ui/diplomatics/DiplomaticsScreen.kt")
        assertTrue("must offer keep-rotating", screen.contains("Keep rotating"))
        assertTrue("must offer pin-one", screen.contains("Pin one language"))
        assertTrue("must offer per-session cadence", screen.contains("Per session"))
        assertTrue("must offer per-day cadence", screen.contains("Per day"))
        assertTrue("must show the current language", screen.contains("Now greeting in"))
        assertTrue(
            "must list every language's own words",
            screen.contains("Greetings.text(Greetings.Bucket.MORNING, language)")
        )
    }
}