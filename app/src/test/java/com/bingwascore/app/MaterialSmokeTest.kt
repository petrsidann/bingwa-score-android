package com.bingwascore.app

import com.bingwascore.app.ui.glass.MaterialSpec
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 18 ACCEPT — MaterialSmokeTest: layer order, perf guards and surface
 * wiring for the iOS 27 material engine. Pure JVM source assertions.
 */
class MaterialSmokeTest {

    private fun source(relative: String): String {
        val root = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        return File(root, relative).readText()
    }

    private val materials get() = source("app/src/main/java/com/bingwascore/app/ui/glass/Materials.kt")
    private val shell get() = source("app/src/main/java/com/bingwascore/app/ui/navigation/AppNavHost.kt")

    @Test
    fun `layer order is blur vibrancy sat-contrast content`() {
        assertEquals(listOf("blur", "vibrancy", "sat_contrast", "content"), MaterialSpec.LAYER_ORDER)
        // Source markers appear in execution order back→front.
        val i1 = materials.indexOf("// L1 — blur")
        val i2 = materials.indexOf("// L2 — vibrancy")
        val i3 = materials.indexOf("// L3 — saturation")
        val i4 = materials.indexOf("L4 — chrome glass fill")
        assertTrue("L1 blur marker missing", i1 >= 0)
        assertTrue("L2 vibrancy marker missing", i2 >= 0)
        assertTrue("L3 sat/contrast marker missing", i3 >= 0)
        assertTrue("L4 content marker missing", i4 >= 0)
        assertTrue("layers out of order", i1 < i2 && i2 < i3 && i3 < i4)
    }

    @Test
    fun `blur radius is capped and api31 only`() {
        assertEquals(24, MaterialSpec.BLUR_DP)
        assertTrue(MaterialSpec.BLUR_DP <= MaterialSpec.MAX_BLUR_DP)
        assertTrue(MaterialSpec.canBlur(31))
        assertTrue(!MaterialSpec.canBlur(30))
        assertTrue(materials.contains("if (!canMaterialBlur) return@drawWithContent"))
    }

    @Test
    fun `pill and drawer are backdrop regions in the shell`() {
        assertTrue("glassSource recorder on the shell", shell.contains("glassSource(glassBackdrop)"))
        assertTrue("pill is a backdrop region", shell.contains("glassBackdropRegion(glassBackdrop, \"pill\""))
        assertTrue("drawer is a backdrop region", shell.replace("\r\n", "\n").contains("glassBackdropRegion(\n                        glassBackdrop, \"drawer\""))
        assertTrue("pill shape radius 28dp", shell.contains("RoundedCornerShape(28.dp)"))
    }

    @Test
    fun `modal sheets own the backdrop and never nest blurs`() {
        listOf(
            "app/src/main/java/com/bingwascore/app/ui/home/HomeChrome.kt",
            "app/src/main/java/com/bingwascore/app/ui/autorenewals/AutoRenewalsScreen.kt",
            "app/src/main/java/com/bingwascore/app/ui/customers/CustomersScreen.kt",
        ).forEach { path ->
            val src = source(path)
            assertTrue("$path must push the modal backdrop", src.contains("pushModal()"))
            assertTrue("$path must pop on dispose", src.contains("popModal()"))
        }
        // Stage 20 — the My Plan paywall has no modal at all: the purchase runs
        // in place, so the screen never touches the glass backdrop.
        val myPlan = source("app/src/main/java/com/bingwascore/app/ui/myplan/MyPlanScreen.kt")
        assertTrue(
            "the paywall must not blur behind a modal",
            !myPlan.contains("pushModal()") && !myPlan.contains("glassSource(")
        )
        // Region passes stand down while a modal owns the backdrop: no nesting.
        assertTrue(materials.contains("if (state.modalDepth > 0) return@drawWithContent"))
    }

    @Test
    fun `blur lives only on chrome never in list items`() {
        val appRoot = File(sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found"), "app/src/main/java/com/bingwascore/app")
        val blurCallers = appRoot.walkTopDown()
            .filter { it.isFile && it.name.endsWith(".kt") }
            .filter { it.readText().contains(".blur(") }
            .map { it.name }
            .toList()
        // The engine is the only .blur() call site (modal backdrop, chrome-driven).
        assertEquals("blur leaked into other files: $blurCallers", listOf("Materials.kt"), blurCallers)
        assertTrue(!source("app/src/main/java/com/bingwascore/app/ui/home/HomeScreen.kt")
            .contains("glassSource("))
    }
}
