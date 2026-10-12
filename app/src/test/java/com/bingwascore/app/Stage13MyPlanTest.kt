package com.bingwascore.app

import com.bingwascore.app.domain.PlanCatalog
import com.bingwascore.app.domain.PlanState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 13 — My Plan: plan matrix, purchase -> plan state, expiry sweep.
 *
 * - The catalogue is two families at two currencies: four individual pulls
 *   plans (Starter/Basic/Noob/Pro) and four bulk unlimited plans
 *   (Small/Medium/Mega/Ultimate), both ascending by price.
 * - A confirmed purchase mints a receipt and writes a live [PlanState] with the
 *   right allowance; the expiry worker clears it once the window closes.
 * - UI wiring (M-Y monogram, confirm sheet, matrix rendering, expiry schedule)
 *   is pinned by source checks, the house style for Composable contracts here.
 */
class Stage13MyPlanTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    private val myPlanSrc: String by lazy {
        source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
    }

    // ── The matrix is two families, ascending by price ──────────────────────

    @Test
    fun `individual family is the four pulls plans in ascending price`() {
        val names = PlanCatalog.individual.map { it.displayName }
        assertEquals(listOf("Starter", "Basic", "Noob", "Pro"), names)
        val prices = PlanCatalog.individual.map { it.priceKes }
        assertEquals(listOf(99, 249, 449, 899), prices)
        assertTrue(
            "individual prices must ascend",
            prices.zipWithNext().all { (a, b) -> a < b }
        )
    }

    @Test
    fun `bulk family is the four unlimited plans in ascending price`() {
        val names = PlanCatalog.bulk.map { it.displayName }
        assertEquals(listOf("Small", "Medium", "Mega", "Ultimate"), names)
        val prices = PlanCatalog.bulk.map { it.priceKes }
        assertEquals(listOf(499, 999, 1_999, 3_499), prices)
        assertTrue(
            "bulk prices must ascend",
            prices.zipWithNext().all { (a, b) -> a < b }
        )
    }

    @Test
    fun `individual plans carry pulls and bulk plans are unlimited`() {
        PlanCatalog.individual.forEach {
            assertFalse("${it.displayName} is not bulk", it.bulk)
            assertFalse("${it.displayName} is not unlimited", it.unlimited)
            assertTrue("${it.displayName} sells pulls", it.pulls > 0)
        }
        PlanCatalog.bulk.forEach {
            assertTrue("${it.displayName} is bulk", it.bulk)
            assertTrue("${it.displayName} is unlimited", it.unlimited)
            assertEquals("${it.displayName} has no pulls count", 0, it.pulls)
        }
    }

    @Test
    fun `detail line reads the right currency per family`() {
        val starter = PlanCatalog.byId("starter")!!
        assertEquals("100 pulls · 7 days", starter.detail)
        val mega = PlanCatalog.byId("mega")!!
        assertEquals("Unlimited · 14 days", mega.detail)
    }

    @Test
    fun `lookup by id finds every plan and rejects unknowns`() {
        PlanCatalog.all.forEach { assertEquals(it, PlanCatalog.byId(it.planId)) }
        assertNull(PlanCatalog.byId("nonexistent"))
        assertNull(PlanCatalog.byId(""))
    }

    // ── Purchase -> live PlanState ──────────────────────────────────────────

    @Test
    fun `a pulls purchase becomes an active pulls plan`() {
        val now = 1_000_000_000_000L
        val state = PlanCatalog.byId("basic")!!.toPlanState(now)
        assertEquals("basic", state.planId)
        assertEquals("Basic", state.displayName)
        assertEquals(350, state.pullsLeft)
        assertFalse(state.unlimited)
        assertTrue(state.isActive)
        assertEquals(now + 14 * PlanState.DAY_MILLIS, state.expiresAtMillis)
    }

    @Test
    fun `a bulk purchase becomes an active unlimited plan`() {
        val now = 1_000_000_000_000L
        val state = PlanCatalog.byId("medium")!!.toPlanState(now)
        assertTrue(state.unlimited)
        assertEquals(0, state.pullsLeft)
        assertEquals(now + 7 * PlanState.DAY_MILLIS, state.expiresAtMillis)
    }

    // ── Expiry sweep ────────────────────────────────────────────────────────

    @Test
    fun `a fresh plan is not expired and a lapsed plan is`() {
        val now = 1_000_000_000_000L
        val fresh = PlanCatalog.byId("small")!!.toPlanState(now)
        assertFalse("a same-moment plan is not expired", fresh.isExpired(now))
        assertFalse("a plan mid-window is not expired", fresh.isExpired(now + PlanState.DAY_MILLIS))
        val lapsed = PlanCatalog.byId("small")!!.toPlanState(now)
        assertTrue("a plan past its window is expired", lapsed.isExpired(now + 4 * PlanState.DAY_MILLIS))
    }

    @Test
    fun `clearing a plan resets it to the inactive fallback`() {
        val cleared = PlanState()
        assertFalse(cleared.isActive)
        assertFalse("an inactive plan is never expired", cleared.isExpired(System.currentTimeMillis()))
        assertNull("no plan means the bubble falls back to credits", cleared.remainingLabel(0L))
    }

    // ── M-Pesa receipt + monogram ───────────────────────────────────────────

    @Test
    fun `receipt is deterministic and shaped like an M-Pesa code`() {
        val now = 1_700_000_000_000L
        val r1 = PlanCatalog.receiptFor("pro", now)
        assertEquals("receipt must be deterministic in (plan, time)", r1, PlanCatalog.receiptFor("pro", now))
        assertTrue("receipt starts with S", r1.startsWith("S"))
        assertEquals("receipt is S + 9 digits", 10, r1.length)
        assertTrue("receipt body is digits", r1.drop(1).all { it.isDigit() })
        assertNotEquals("a different time mints a different receipt", r1, PlanCatalog.receiptFor("pro", now + 60_000L))
    }

    @Test
    fun `monogram is the plan initials, MY with no plan`() {
        assertEquals("PR", PlanCatalog.monogramLetters("Pro"))
        assertEquals("BA", PlanCatalog.monogramLetters("Basic"))
        assertEquals("ME", PlanCatalog.monogramLetters("Medium"))
        assertEquals("MY", PlanCatalog.monogramLetters(""))
        assertEquals("MY", PlanCatalog.monogramLetters("   "))
    }

    // ── UI wiring (source guards) ───────────────────────────────────────────

    @Test
    fun `the screen renders both families through the matrix card`() {
        assertTrue(
            "individual family is rendered",
            myPlanSrc.contains("items(PlanCatalog.individual, key = { it.planId })")
        )
        assertTrue(
            "bulk family is rendered",
            myPlanSrc.contains("items(PlanCatalog.bulk, key = { it.planId })")
        )
        assertTrue(
            "each row taps into the confirm sheet",
            myPlanSrc.contains("PlanConfirmSheet(")
        )
    }

    @Test
    fun `the hero shows the M-Y monogram`() {
        assertTrue(
            "hero monogram reads the plan initials",
            myPlanSrc.contains("MonogramTile(letters = PlanCatalog.monogramLetters(plan.displayName))")
        )
        assertTrue(
            "monogram tile falls back to the MY mark when blank",
            source("app/src/main/java/com/bingwascore/app/domain/PlanCatalog.kt").contains("ifBlank { \"MY\" }")
        )
    }

    @Test
    fun `the confirm sheet walks idle paying and success`() {
        assertTrue("the sheet is a modal bottom sheet", myPlanSrc.contains("ModalBottomSheet("))
        assertTrue("paying shows a loading button", myPlanSrc.contains("loadingText = \"Waiting for M-Pesa"))
        assertTrue("success mints the receipt in the sheet", myPlanSrc.contains("success.receipt"))
        assertTrue("a tap runs the purchase", myPlanSrc.contains("viewModel.purchase(offer.planId)"))
    }

    @Test
    fun `the purchase writes plan state and the worker is scheduled`() {
        assertTrue(
            "purchase mints the receipt and activates the plan",
            myPlanSrc.contains("PlanCatalog.receiptFor(planId, now)") &&
                myPlanSrc.contains("userPreferences.setPlanState(offer.toPlanState(now))")
        )
        val workers = source("app/src/main/java/com/bingwascore/app/workers/Workers.kt")
        assertTrue("the expiry sweep is scheduled at startup", workers.contains("PlanExpiryWorker.schedule(context)"))
        val worker = source("app/src/main/java/com/bingwascore/app/workers/PlanExpiryWorker.kt")
        assertTrue(
            "the worker clears an expired plan",
            worker.contains("plan.isExpired(now)") && worker.contains("setPlanState(PlanState())")
        )
    }

    @Test
    fun `no import is stranded below the code it belongs above`() {
        // Stage 13 regression: the confirm sheet used to leave 12 imports dumped
        // after the composables. Imports must all live in the header block.
        val lines = myPlanSrc.lines()
        val lastImport = lines.indexOfLast { it.startsWith("import ") }
        val firstCode = lines.indexOfFirst {
            !it.startsWith("import ") &&
                !it.startsWith("package ") &&
                it.isNotBlank() &&
                !it.trimStart().startsWith("/*") &&
                !it.trimStart().startsWith("*") &&
                !it.trimStart().startsWith("//")
        }
        assertTrue(
            "every import must sit above the first line of code (stray import below line ${firstCode + 1})",
            lastImport < firstCode
        )
    }
}
