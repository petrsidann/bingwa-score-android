package com.bingwascore.app

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.transactions.TransactionFilter
import com.bingwascore.app.ui.transactions.rulesFor
import com.bingwascore.app.ui.transactions.rulesForSelection
import com.bingwascore.app.ui.transactions.transactionFilterChips
import com.bingwascore.app.util.formatCustomerName
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * U5 — Transactions surgical.
 *
 * Laws:
 *  1. SUCCESSFUL disables Retry AND Complete; Retry is only for
 *     FAILED/QUEUED/SCHEDULED; Complete is for anything not SUCCESSFUL.
 *  2. A selection may only be batch-retried when every row is retryable.
 *  3. `formatCustomerName` renders "DENNIS K WACHIRA" as "Dennis K. Wachira".
 *  4. The filter row emits exactly one chip per filter (no stray dot).
 *  5. The morph/dim window sits in the 200–260ms band.
 */
class U5TransactionsTest {

    private val successful = TransactionStatus.SUCCESSFUL.value
    private val failed = TransactionStatus.FAILED.value
    private val already = TransactionStatus.FAILED_ALREADY_RECOMMENDED.value
    private val queued = TransactionStatus.PENDING.value
    private val processing = TransactionStatus.PROCESSING.value
    private val scheduled = TransactionStatus.SCHEDULED.value
    private val unmatched = TransactionStatus.UNMATCHED.value

    // ── Law 1: a completed sale is finished ──────────────────────────────────

    @Test
    fun successfulDisablesRetryAndComplete() {
        val rules = rulesFor(successful)
        assertFalse("SUCCESSFUL must not allow Retry", rules.canRetry)
        assertFalse("SUCCESSFUL must not allow Complete", rules.canComplete)
    }

    @Test
    fun retryIsOnlyForFailedQueuedOrScheduled() {
        listOf(failed, already, queued, processing, scheduled).forEach { status ->
            assertTrue("$status must allow Retry", rulesFor(status).canRetry)
        }
        listOf(successful, unmatched).forEach { status ->
            assertFalse("$status must not allow Retry", rulesFor(status).canRetry)
        }
    }

    @Test
    fun completeIsAllowedForAnythingNotSuccessful() {
        listOf(failed, already, queued, processing, scheduled, unmatched).forEach { status ->
            assertTrue("$status must allow Complete", rulesFor(status).canComplete)
        }
        assertFalse(rulesFor(successful).canComplete)
    }

    @Test
    fun unknownStatusAllowsNothing() {
        assertFalse(rulesFor(null).canRetry)
        assertFalse(rulesFor(null).canComplete)
        assertFalse(rulesFor("").canRetry)
        assertFalse(rulesFor("").canComplete)
    }

    // ── Law 2: batch rules only when every row allows it ─────────────────────

    @Test
    fun batchRetryRejectedWhenSelectionContainsASuccessfulSale() {
        val rules = rulesForSelection(listOf(failed, successful))
        assertFalse("a completed sale must block batch Retry", rules.canRetry)
    }

    @Test
    fun batchRetryAllowedWhenEveryRowIsRetryable() {
        val rules = rulesForSelection(listOf(failed, queued, scheduled))
        assertTrue(rules.canRetry)
        assertTrue(rules.canComplete)
    }

    @Test
    fun emptySelectionAllowsNothing() {
        val rules = rulesForSelection(emptyList())
        assertFalse(rules.canRetry)
        assertFalse(rules.canComplete)
    }

    // ── Law 3: one customer-name formatter ───────────────────────────────────

    @Test
    fun operatorCasingBecomesAWrittenName() {
        assertEquals("Dennis K. Wachira", formatCustomerName("DENNIS K WACHIRA"))
    }

    @Test
    fun singleTokenIsTitleCased() {
        assertEquals("Dennis", formatCustomerName("dennis"))
    }

    @Test
    fun twoTokensKeepBothWords() {
        assertEquals("Dennis Wachira", formatCustomerName("DENNIS WACHIRA"))
    }

    @Test
    fun multipleMiddleTokensBecomeInitials() {
        assertEquals("John P. K. Ngigi", formatCustomerName("JOHN PETER KAMAU NGIGI"))
    }

    @Test
    fun blankOrNullYieldsEmpty() {
        assertEquals("", formatCustomerName(null))
        assertEquals("", formatCustomerName("   "))
    }

    // ── Law 4: the filter row is exactly the chips ───────────────────────────

    @Test
    fun filterRowEmitsExactlyOneChipPerFilter() {
        assertEquals(TransactionFilter.entries.size, transactionFilterChips.size)
        assertEquals(TransactionFilter.entries.toList(), transactionFilterChips)
    }

    // ── Law 5: the morph window ──────────────────────────────────────────────

    @Test
    fun morphWindowSitsInTheTwoHundredToTwoSixtyBand() {
        assertTrue(
            "morph ${Motion.MORPH_SPRING_MILLIS}ms outside 200..260",
            Motion.MORPH_SPRING_MILLIS in 200..260
        )
    }
}
