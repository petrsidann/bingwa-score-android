package com.bingwascore.app

import com.bingwascore.app.ui.onboarding.SnakeCarousel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/** U6 — snake carousel logic (pure JVM, no Compose runtime needed). */
class U6SnakeCarouselTest {

    private val count = SnakeCarousel.SLIDES.size

    @Test fun `three slides fixed`() {
        assertEquals(3, count)
        assertTrue(SnakeCarousel.SLIDES.all { it.title.isNotBlank() && it.body.isNotBlank() })
    }

    @Test fun `page clamps at both ends and never wraps`() {
        assertEquals(0, SnakeCarousel.clampPage(-5, count))
        assertEquals(2, SnakeCarousel.clampPage(9, count))
        assertEquals(0, SnakeCarousel.previous(0, count))   // no wrap back to last
        assertEquals(2, SnakeCarousel.next(2, count))       // no wrap to first
    }

    @Test fun `settle advances on left drag past threshold`() {
        assertEquals(1, SnakeCarousel.settlePage(0, count, dragPx = -100f, widthPx = 300f))
        assertEquals(0, SnakeCarousel.settlePage(0, count, dragPx = -50f, widthPx = 300f))  // below 25%
        assertEquals(0, SnakeCarousel.settlePage(0, count, dragPx = -74f, widthPx = 300f))
    }

    @Test fun `settle goes back on right drag past threshold`() {
        assertEquals(1, SnakeCarousel.settlePage(2, count, dragPx = 100f, widthPx = 300f))
        assertEquals(2, SnakeCarousel.settlePage(2, count, dragPx = 50f, widthPx = 300f))
    }

    @Test fun `settle at edges stays put`() {
        assertEquals(0, SnakeCarousel.settlePage(0, count, dragPx = 200f, widthPx = 300f))
        assertEquals(2, SnakeCarousel.settlePage(2, count, dragPx = -200f, widthPx = 300f))
    }

    @Test fun `zero width guard returns clamped page`() {
        assertEquals(1, SnakeCarousel.settlePage(1, count, dragPx = -999f, widthPx = 0f))
    }

    @Test fun `offsets ordered left to right around focus`() {
        val o = SnakeCarousel.offsetsDp(position = 1f, count = count, spacingDp = 46f)
        assertEquals(listOf(-46f, 0f, 46f), o)
        assertEquals(0f, o[1], 0.001f)
    }

    @Test fun `alphas peak at focus`() {
        val a = SnakeCarousel.alphas(position = 0f, count = count)
        assertEquals(1f, a[0], 0.001f)
        assertTrue(a[0] > a[1] && a[1] >= a[2])
    }

    @Test fun `scales shrink away from focus and floor at 84 percent`() {
        val s = SnakeCarousel.scales(position = 1f, count = 5)
        assertEquals(1f, s[1], 0.001f)
        assertEquals(0.84f, s[0], 0.001f)
        assertEquals(0.84f, s[4], 0.001f)
        assertTrue(s.all { it in 0.84f..1f })
    }

    @Test fun `dots have exactly one active segment`() {
        val d = SnakeCarousel.dotWidthsDp(activePage = 1, count = count)
        assertEquals(count, d.size)
        assertEquals(1, d.count { it == 18f })
        assertEquals(2, d.count { it == 8f })
    }

    @Test fun `continuous position between pages keeps monotonic offsets`() {
        val o = SnakeCarousel.offsetsDp(position = 0.5f, count = count, spacingDp = 46f)
        assertTrue(o[0] < o[1] && o[1] < o[2])
    }
}
