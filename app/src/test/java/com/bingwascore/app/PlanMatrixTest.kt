package com.bingwascore.app

import com.bingwascore.app.domain.PlanCatalog
import com.bingwascore.app.domain.PlanCountdown
import com.bingwascore.app.domain.PlanFamily
import com.bingwascore.app.domain.PlanState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 20 — THE PRICE LAW.
 *
 * The paywall sells eight plans and the numbers on screen are the contract:
 *
 * - **STEADY** — Starter: unlimited USSD pulls, 1 day, Ksh 20 · Basic: 1,000
 *   pulls, Ksh 25 · Noob: 2,500 pulls, Ksh 55 · Pro: 5,000 pulls, Ksh 110.
 * - **BULK ENGINE** — Small: unlimited, 3 days, Ksh 60 · Medium: unlimited,
 *   7 days, Ksh 140 · Mega: unlimited, 1 month, Ksh 600 · Ultimate: unlimited,
 *   3 months, Ksh 1,800.
 *
 * Every price, pull count and window on the paywall comes from this table, and
 * the copy on a plan page may only quote the plan's own numbers.
 */
class PlanMatrixTest {

    // ── The law, verbatim ────────────────────────────────────────────────────

    @Test
    fun `steady family is the four pull packs at the law prices`() {
        assertEquals(
            listOf("Starter", "Basic", "Noob", "Pro"),
            PlanCatalog.steady.map { it.displayName }
        )
        assertEquals(
            listOf(20, 25, 55, 110),
            PlanCatalog.steady.map { it.priceKes }
        )
        assertEquals(
            listOf(0, 1_000, 2_500, 5_000),
            PlanCatalog.steady.map { it.pulls }
        )
    }

    @Test
    fun `bulk engine family is the four unlimited plans at the law prices`() {
        assertEquals(
            listOf("Small", "Medium", "Mega", "Ultimate"),
            PlanCatalog.bulkEngine.map { it.displayName }
        )
        assertEquals(
            listOf(60, 140, 600, 1_800),
            PlanCatalog.bulkEngine.map { it.priceKes }
        )
        assertEquals(
            listOf(0, 0, 0, 0),
            PlanCatalog.bulkEngine.map { it.pulls }
        )
    }

    @Test
    fun `the windows are the ones the law names`() {
        assertEquals("1 day", PlanCatalog.byId("starter")!!.durationLabel)
        assertEquals("3 days", PlanCatalog.byId("small")!!.durationLabel)
        assertEquals("7 days", PlanCatalog.byId("medium")!!.durationLabel)
        assertEquals("1 month", PlanCatalog.byId("mega")!!.durationLabel)
        assertEquals("3 months", PlanCatalog.byId("ultimate")!!.durationLabel)
    }

    @Test
    fun `starter is the one-day unlimited plan`() {
        val starter = PlanCatalog.byId("starter")!!
        assertEquals(20, starter.priceKes)
        assertEquals(1, starter.days)
        assertTrue("starter dials without a cap", starter.unlimited)
        assertEquals("Unlimited USSD pulls", starter.allowanceLabel)
    }

    @Test
    fun `every bulk plan dials without a cap`() {
        PlanCatalog.bulkEngine.forEach {
            assertTrue("${it.displayName} is unlimited", it.unlimited)
            assertEquals("${it.displayName} has no pull count", 0, it.pulls)
        }
    }

    @Test
    fun `prices ascend inside each family`() {
        listOf(PlanCatalog.steady, PlanCatalog.bulkEngine).forEach { family ->
            val prices = family.map { it.priceKes }
            assertTrue(
                "prices must ascend: $prices",
                prices.zipWithNext().all { (a, b) -> a < b }
            )
        }
    }

    @Test
    fun `the family pill names both families`() {
        assertEquals("STEADY", PlanFamily.STEADY.label)
        assertEquals("BULK ENGINE", PlanFamily.BULK_ENGINE.label)
        assertEquals(PlanCatalog.steady, PlanCatalog.family(PlanFamily.STEADY))
        assertEquals(PlanCatalog.bulkEngine, PlanCatalog.family(PlanFamily.BULK_ENGINE))
    }

    // ── The truth on the page ────────────────────────────────────────────────

    @Test
    fun `the truth subtitle is allowance plus window`() {
        assertEquals("Unlimited USSD pulls · 1 day", PlanCatalog.byId("starter")!!.truthSubtitle)
        assertEquals("1,000 pulls · 7 days", PlanCatalog.byId("basic")!!.truthSubtitle)
        assertEquals("2,500 pulls · 1 month", PlanCatalog.byId("noob")!!.truthSubtitle)
        assertEquals("5,000 pulls · 1 month", PlanCatalog.byId("pro")!!.truthSubtitle)
        assertEquals("Unlimited USSD pulls · 3 months", PlanCatalog.byId("ultimate")!!.truthSubtitle)
    }

    @Test
    fun `the cta names the plan and the price`() {
        assertEquals("Activate Starter - Ksh 20", PlanCatalog.byId("starter")!!.ctaLabel)
        assertEquals("Activate Pro - Ksh 110", PlanCatalog.byId("pro")!!.ctaLabel)
        assertEquals("Activate Ultimate - Ksh 1800", PlanCatalog.byId("ultimate")!!.ctaLabel)
    }

    @Test
    fun `a plan page only quotes its own numbers`() {
        PlanCatalog.all.forEach { offer ->
            val copy = listOf(
                offer.truthSubtitle,
                offer.allowanceTitle,
                offer.allowanceDesc,
                offer.windowTitle,
                offer.windowDesc,
                offer.priceTitle,
                offer.priceDesc,
                offer.legalLine,
                offer.ctaLabel
            ).joinToString(" ")
            val allowed = buildSet {
                add(offer.pulls)
                add(offer.priceKes)
                add(offer.days)
                if (offer.monthCount > 0) add(offer.monthCount)
            }
            val quoted = numbersIn(copy)
            assertTrue(
                "${offer.displayName} quotes $quoted, which is not its own fact ($allowed)",
                quoted.all { it in allowed }
            )
        }
    }

    @Test
    fun `a purchase writes the allowance and the window`() {
        val now = 1_000_000_000_000L
        val basic = PlanCatalog.byId("basic")!!.toPlanState(now)
        assertEquals(1_000, basic.pullsLeft)
        assertEquals(now + 7 * PlanState.DAY_MILLIS, basic.expiresAtMillis)
        val mega = PlanCatalog.byId("mega")!!.toPlanState(now)
        assertTrue(mega.unlimited)
        assertEquals(now + 30 * PlanState.DAY_MILLIS, mega.expiresAtMillis)
    }

    // ── The live countdown ───────────────────────────────────────────────────

    @Test
    fun `the countdown reads in days hours and minutes`() {
        assertEquals(
            "3d 4h left",
            PlanCountdown.label(3 * PlanState.DAY_MILLIS + 4 * 3_600_000L)
        )
        assertEquals("4h 12m left", PlanCountdown.label(4 * 3_600_000L + 12 * 60_000L))
        assertEquals("42m left", PlanCountdown.label(42 * 60_000L))
        assertEquals("Expired", PlanCountdown.label(0L))
        assertEquals("Expired", PlanCountdown.label(-1L))
    }

    /** Every number the copy prints, with the thousands separator removed. */
    private fun numbersIn(text: String): Set<Int> =
        Regex("\\d[\\d,]*")
            .findAll(text)
            .map { it.value.replace(",", "").toInt() }
            .toSet()
}
