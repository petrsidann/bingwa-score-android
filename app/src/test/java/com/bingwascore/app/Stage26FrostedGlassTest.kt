package com.bingwascore.app

import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.glass.GlassSpec
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 26 — Frosted Glass System System & UX Audit Tests.
 *
 * Asserts GlassSpec token values and their application to MyPlan header + nav pill.
 */
class Stage26FrostedGlassTest {

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
    fun `glass spec tokens match stage 26 requirements`() {
        assertEquals(28, GlassSpec.BACKDROP_BLUR_INT)
        assertEquals(28.dp, GlassSpec.backdropBlurDp)
        assertEquals(0.62f, GlassSpec.SCRIM_ALPHA_OBSIDIAN, 0.001f)
        assertEquals(0.55f, GlassSpec.SCRIM_ALPHA_PORCELAIN_DIM, 0.001f)
        assertEquals(0.10f, GlassSpec.INNER_TOP_HIGHLIGHT_ALPHA, 0.001f)
        assertEquals(1.dp, GlassSpec.INNER_TOP_HIGHLIGHT_WIDTH)
        assertEquals(12.dp, GlassSpec.OUTER_SHADOW_ELEVATION)
        assertEquals(24.dp, GlassSpec.OUTER_SHADOW_RADIUS)
        assertEquals(0.35f, GlassSpec.OUTER_SHADOW_ALPHA, 0.001f)

        assertEquals(0.62f, GlassSpec.scrimAlpha(isPorcelain = false), 0.001f)
        assertEquals(0.55f, GlassSpec.scrimAlpha(isPorcelain = true), 0.001f)
    }

    @Test
    fun `myplan header and plan card apply frosted glass tokens`() {
        val myPlanSrc = source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
        assertTrue("MyPlan imports frostedGlass", myPlanSrc.contains("import com.bingwascore.app.ui.glass.frostedGlass"))
        assertTrue("MyPlan imports GlassSpec", myPlanSrc.contains("import com.bingwascore.app.ui.glass.GlassSpec"))
        assertTrue("PlanBand applies frostedGlass", myPlanSrc.contains("frostedGlass("))
    }

    @Test
    fun `nav pill applies glass spec scrim`() {
        val navHostSrc = source("app/src/main/java/com/bingwascore/app/ui/navigation/AppNavHost.kt")
        assertTrue("AppNavHost uses GlassSpec", navHostSrc.contains("GlassSpec"))
        assertTrue("BottomNavBar applies GlassSpec scrim color", navHostSrc.contains("tint = GlassSpec.scrimColor("))
    }
}
