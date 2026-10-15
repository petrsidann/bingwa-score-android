package com.bingwascore.app

import com.bingwascore.app.ui.glass.MaterialSpec
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/** Stage 18 — iOS 27 material engine: layer order + perf guards. */
class Stage18MaterialTest {

    @Test
    fun `layer order is blur vibrancy sat-contrast content`() {
        assertEquals(listOf("blur", "vibrancy", "sat_contrast", "content"), MaterialSpec.LAYER_ORDER)
    }

    @Test
    fun `blur radius capped at 28dp`() {
        assertTrue(MaterialSpec.BLUR_DP <= MaterialSpec.MAX_BLUR_DP)
        assertEquals(24, MaterialSpec.BLUR_DP)
    }

    @Test
    fun `vibrancy is accent at 8 to 12 percent`() {
        assertTrue(MaterialSpec.vibrancyAlpha() in 0.08f..0.12f)
    }

    @Test
    fun `sat contrast matches apple recipe`() {
        assertEquals(1.2f, MaterialSpec.SATURATION, 0.001f)
        assertEquals(1.1f, MaterialSpec.CONTRAST, 0.001f)
        assertEquals(16, MaterialSpec.colorMatrix().size)
    }

    @Test
    fun `blur only on api31 plus`() {
        assertTrue(MaterialSpec.canBlur(33))
        assertTrue(!MaterialSpec.canBlur(30))
    }
}
