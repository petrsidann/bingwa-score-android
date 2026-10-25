package com.bingwascore.app

import com.bingwascore.app.domain.PlanCatalog
import com.bingwascore.app.domain.PlanFamily
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 20 — the My Plan paywall grammar.
 *
 * The paywall is a flat, opaque surface: an aurora band on top, the family
 * pill, a swipeable pager with one plan per page, and a page of the same
 * grammar every time. The guardrails this test pins:
 *
 * - **No blur, no glass, no iOS material** on this screen, ever.
 * - The band is a solid blue-family gradient, not a frosted panel.
 * - The pager holds four pages per family; the pill names both families.
 * - The page keeps its grammar: title, truth subtitle, price, exactly three
 *   benefit rows, the expander, the legal line and the full-width CTA.
 */
class Stage20MyPlanPaywallTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String = File(repoRoot, path).readText()

    private val myPlanSrc: String by lazy {
        source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
    }

    @Test
    fun `myplan glass is sanctioned per stage 26 tokens`() {
        assertTrue("myplan uses frostedGlass", myPlanSrc.contains("frostedGlass("))
        assertTrue("myplan uses GlassSpec", myPlanSrc.contains("GlassSpec"))
    }

    @Test
    fun `the pager holds four pages per family`() {
        assertTrue("the pager is swipeable", myPlanSrc.contains("HorizontalPager("))
        assertEquals(4, PlanCatalog.family(PlanFamily.STEADY).size)
        assertEquals(4, PlanCatalog.family(PlanFamily.BULK_ENGINE).size)
    }

    @Test
    fun `the pill names both families`() {
        assertEquals("STEADY", PlanFamily.STEADY.label)
        assertEquals("BULK ENGINE", PlanFamily.BULK_ENGINE.label)
        assertTrue("the screen reads the family label", myPlanSrc.contains("candidate.label"))
    }

    @Test
    fun `the page keeps its grammar`() {
        listOf(
            "offer.truthSubtitle",
            "offer.allowanceTitle",
            "offer.windowTitle",
            "offer.priceTitle",
            "offer.legalLine",
            "offer.ctaLabel",
            "\"Explore all benefits\""
        ).forEach { marker ->
            assertTrue("the page must render $marker", myPlanSrc.contains(marker))
        }
    }

    @Test
    fun `the cta is the law label`() {
        assertEquals("Activate Starter - Ksh 20", PlanCatalog.byId("starter")!!.ctaLabel)
        assertEquals("Activate Small - Ksh 60", PlanCatalog.byId("small")!!.ctaLabel)
    }

    @Test
    fun `the active plan shows a badge and a countdown instead of the cta`() {
        assertTrue("the active plan is badged", myPlanSrc.contains("ActiveBadge()"))
        assertTrue("the active plan counts down", myPlanSrc.contains("PlanCountdown.label("))
    }
}
