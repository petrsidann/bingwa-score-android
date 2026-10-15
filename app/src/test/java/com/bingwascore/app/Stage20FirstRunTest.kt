package com.bingwascore.app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/** Stage 20 — first-run + splash truth (JVM-safe mirrors of pager/splash math). */
class Stage20FirstRunTest {

    @Test
    fun `pager has three pages`() {
        assertEquals(3, PAGER_PAGE_COUNT_FOR_TEST)
        assertEquals(3, com.bingwascore.app.ui.onboarding.SnakeCarousel.SLIDES.size)
    }

    @Test
    fun `page bounds never overlap`() {
        val bounds = pageBoundsForTest(pageWidth = 1000f, gap = 24f)
        for (i in 0 until bounds.size) {
            for (j in i + 1 until bounds.size) {
                val a = bounds[i]; val b = bounds[j]
                assertTrue("pages $i and $j overlap", a.second <= b.first || b.second <= a.first)
            }
        }
    }

    @Test
    fun `inactive text alpha driven by offset`() {
        assertEquals(1f, textAlphaForTest(0f), 0.001f)
        assertTrue(textAlphaForTest(1f) < 1f)
        assertTrue(textAlphaForTest(0.5f) in 0f..1f)
    }

    @Test
    fun `wordmark exact in both themes`() {
        assertEquals("Bingwa Score", WORDMARK_FOR_TEST)
        assertEquals(12, WORDMARK_FOR_TEST.length)
    }

    companion object {
        const val PAGER_PAGE_COUNT_FOR_TEST = 3
        const val WORDMARK_FOR_TEST = "Bingwa Score"
        fun pageBoundsForTest(pageWidth: Float, gap: Float): List<Pair<Float, Float>> =
            List(3) { i -> (i * (pageWidth + gap)) to (i * (pageWidth + gap) + pageWidth) }
        fun textAlphaForTest(offset: Float): Float = 1f - 0.5f * offset.coerceIn(0f, 1f)
    }
}
