package com.bingwascore.app

import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.deduplicated
import com.bingwascore.app.domain.engine.UssdSessionEngine
import com.bingwascore.app.domain.engine.UssdSessionHolder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Stage 9 — dial truth round 2.
 * - Escalation law: 8s silence OR onFailure escalates.
 * - Escalation URI: `#` -> `%23`.
 * - Same-price offers coexist: uniqueness = name+ussdCode, never amount.
 * - Console: holder keeps a capped live step log.
 * - Menus auto-continue (max 6 steps) — engine MAX_STEPS guard.
 */
class Stage9DialTruthTest {

    private fun offer(name: String, code: String, price: Int) =
        Offer(id = "offer_${name}_$code", name = name, ussdCode = code, price = price)

    @Test
    fun samePriceOffersCoexist() {
        val shelf = listOf(
            offer("Alpha", "*544*1*ph#", 20),
            offer("Beta", "*544*2*ph#", 20)
        )
        assertEquals(2, shelf.deduplicated().size)
    }

    @Test
    fun trueDuplicatesStillCollapse() {
        val twin = offer("Alpha", "*544*1*ph#", 20)
        assertEquals(1, listOf(twin, twin.copy(id = "other")).deduplicated().size)
    }

    @Test
    fun silenceEscalationLaw() {
        assertFalse(UssdSessionEngine.shouldEscalateOnSilence(7_999L, false))
        assertTrue(UssdSessionEngine.shouldEscalateOnSilence(8_000L, false))
        assertTrue(UssdSessionEngine.shouldEscalateOnSilence(0L, true))
        assertEquals(8_000L, UssdSessionEngine.ESCALATION_TIMEOUT_MILLIS)
    }

    @Test
    fun escalationUriEncodesHash() {
        val uri = UssdSessionEngine.escalationDialUri("*544*1*0712000001#")
        assertTrue("hash must be %23: $uri", uri.contains("%23"))
        assertTrue(uri.startsWith("tel:"))
    }

    @Test
    fun menuCapIsSixSteps() {
        assertEquals(6, UssdSessionEngine.MAX_STEPS)
        val verdict = UssdSessionEngine.classify("1. Data\n2. Back\nMORE", emptyList(), 0)
        assertTrue(verdict is UssdSessionEngine.Verdict.Menu)
    }

    @Test
    fun consoleAppendsAndCaps() {
        val holder = UssdSessionHolder()
        holder.appendConsole("code", "sent *544#")
        holder.appendConsole("response", "welcome")
        holder.appendConsole("input", "step 1 -> 1")
        holder.appendConsole("escalation", "8s -> ACTION_CALL")
        assertEquals(4, holder.console.value.size)
        assertEquals("escalation", holder.console.value.last().kind)
    }
}
