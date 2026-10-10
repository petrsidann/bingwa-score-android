package com.bingwascore.app

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.home.clampedCurveY
import com.bingwascore.app.ui.home.millisUntilNextMidnight
import com.bingwascore.app.ui.home.weekdayIndexMonFirst
import com.bingwascore.app.ui.screens.SPLASH_WORDMARK
import com.bingwascore.app.ui.screens.wordmarkAlphas
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.transactions.TransactionFilter
import com.bingwascore.app.ui.transactions.transactionFilterChips
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * U3 — Home/Graph/Splash right-size acceptance.
 *
 * Laws:
 *  1. The splash wordmark is always the FULL "Bingwa Score" — per-letter alpha,
 *     never a substring.
 *  2. The UI says "Queued" for PENDING everywhere; the stored enum is unchanged.
 *  3. The Transactions filter row emits exactly one chip per filter (no stray dot).
 *  4. The today-bubble index rolls from the clock (Mon-first), and there is a
 *     bounded time-to-midnight.
 *  5. The commission spline is clamped at/above the zero baseline.
 */
class U3RightSizeTest {

    // ── Law 1: splash wordmark is never a substring ───────────────────────────

    @Test
    fun wordmarkIsTheFullString() {
        assertEquals("Bingwa Score", SPLASH_WORDMARK)
        assertEquals(12, SPLASH_WORDMARK.length)
    }

    @Test
    fun wordmarkAlphasAlwaysCoverEveryLetter() {
        listOf(0f, 0.25f, 0.5f, 1f, 99f, -5f).forEach { progress ->
            assertEquals(
                "letters missing at progress=$progress",
                SPLASH_WORDMARK.length,
                wordmarkAlphas(SPLASH_WORDMARK, progress).size
            )
        }
    }

    @Test
    fun wordmarkRevealsEveryLetterWhenFullyDrawn() {
        val alphas = wordmarkAlphas(SPLASH_WORDMARK, 99f)
        // Every position has an alpha and no letter is dropped from the string.
        assertTrue(alphas.all { it in 0f..1f })
        assertTrue("the wordmark never fully drew", alphas.any { it >= 1f })
        assertEquals(SPLASH_WORDMARK.length, alphas.size)
    }

    @Test
    fun wordmarkStartsFullyHidden() {
        val alphas = wordmarkAlphas(SPLASH_WORDMARK, 0f)
        assertEquals(0f, alphas.first(), 0.0001f)
        assertEquals(0f, alphas.last(), 0.0001f)
        assertTrue("nothing may be visible before the stagger starts", alphas.all { it == 0f })
    }

    @Test
    fun wordmarkShowsTheFirstLetterAsSoonAsTheStaggerBegins() {
        val alphas = wordmarkAlphas(SPLASH_WORDMARK, 1f)
        assertEquals(1f, alphas.first(), 0.0001f)
        assertEquals(0f, alphas.last(), 0.0001f)
    }

    // ── Law 2: PENDING reads as "Queued" in the UI ────────────────────────────

    @Test
    fun pendingFilterChipReadsQueued() {
        assertEquals("Queued", TransactionFilter.PENDING.label)
        // The enum value itself is unchanged, so stored rows still round-trip.
        assertEquals(TransactionStatus.PENDING.value, "PENDING")
    }

    @Test
    fun statusLabelMapsPendingAndProcessingToQueued() {
        assertEquals("Queued", StatusColors.label(TransactionStatus.PENDING.value))
        assertEquals("Queued", StatusColors.label(TransactionStatus.PROCESSING.value))
        assertEquals("Successful", StatusColors.label(TransactionStatus.SUCCESSFUL.value))
        assertEquals("Failed", StatusColors.label(TransactionStatus.FAILED.value))
    }

    @Test
    fun noChipIsLabelledPending() {
        assertFalse(
            "the UI must never say Pending",
            transactionFilterChips.any { it.label.equals("Pending", ignoreCase = true) }
        )
    }

    // ── Law 3: the filter row is exactly one chip per filter ──────────────────

    @Test
    fun filterRowEmitsExactlyOneChipPerFilter() {
        assertEquals(TransactionFilter.entries.size, transactionFilterChips.size)
        assertEquals(
            TransactionFilter.entries.toList(),
            transactionFilterChips
        )
    }

    // ── Law 4: today-bubble rolls from the clock ──────────────────────────────

    @Test
    fun weekdayIndexIsMondayFirst() {
        // Calendar: SUNDAY=1, MONDAY=2 ... SATURDAY=7
        assertEquals(0, weekdayIndexMonFirst(2)) // Monday
        assertEquals(1, weekdayIndexMonFirst(3)) // Tuesday
        assertEquals(6, weekdayIndexMonFirst(1)) // Sunday
    }

    @Test
    fun timeToMidnightIsBoundedAndPositive() {
        val remaining = millisUntilNextMidnight(System.currentTimeMillis())
        assertTrue("midnight must be in the future", remaining > 0L)
        assertTrue("midnight must be within 24h", remaining <= 24L * 60 * 60 * 1000)
    }

    // ── Law 5: the spline never dips below the baseline ───────────────────────

    @Test
    fun clampedCurveYStaysOnCanvas() {
        val height = 148f
        listOf(-1f, 0f, 0.5f, 1f, 2f).forEach { value ->
            val y = clampedCurveY(value, height)
            assertTrue("y must be >= 0 for value=$value (was $y)", y >= 0f)
            assertTrue("y must be <= height for value=$value (was $y)", y <= height)
        }
    }

    @Test
    fun clampedCurveYIsMonotonicDownAsValueGrows() {
        val height = 148f
        val top = clampedCurveY(1f, height)
        val bottom = clampedCurveY(0f, height)
        assertTrue(top < bottom)
    }
}
