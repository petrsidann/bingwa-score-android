package com.bingwascore.app

import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.domain.BatchDialPlanner
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Parity F — silent batch dial planner: phone normalisation, USSD expansion,
 * queue ordering (silent first) and the single-confirmation rule. Pure JVM.
 */
class BatchDialPlannerTest {

    private fun offer(
        id: String,
        price: Int = 20,
        silent: Boolean = true,
        code: String = "*544*1*ph#"
    ) = Offer(
        id = id,
        name = "Offer $id",
        ussdCode = code,
        price = price,
        silentBatch = silent
    )

    @Test
    fun plan_expandsPhoneIntoUssdCode() {
        val plan = BatchDialPlanner.plan(listOf(offer("a")), "0712345678")

        assertEquals(1, plan.size)
        assertEquals("*544*1*0712345678#", plan.first().ussdCode)
        assertEquals("0712345678", plan.first().phoneNumber)
        assertEquals(20, plan.first().price)
        assertTrue(plan.first().silent)
    }

    @Test
    fun plan_normalisesPhoneFormats() {
        val plus = BatchDialPlanner.plan(listOf(offer("a")), "+254 712 345 678")
        val trunkless = BatchDialPlanner.plan(listOf(offer("a")), "712345678")

        assertEquals("0712345678", plus.first().phoneNumber)
        assertEquals("0712345678", trunkless.first().phoneNumber)
    }

    @Test
    fun plan_rejectsInvalidPhone() {
        assertTrue(BatchDialPlanner.plan(listOf(offer("a")), "071234").isEmpty())
        assertTrue(BatchDialPlanner.plan(listOf(offer("a")), "").isEmpty())
        assertTrue(BatchDialPlanner.plan(listOf(offer("a")), "not a phone").isEmpty())
    }

    @Test
    fun plan_ordersSilentOffersFirst() {
        val plan = BatchDialPlanner.plan(
            listOf(offer("advanced", silent = false), offer("silent", silent = true)),
            "0712345678"
        )

        assertEquals(listOf("silent", "advanced"), plan.map { it.offerId })
        assertEquals(listOf(true, false), plan.map { it.silent })
    }

    @Test
    fun requiresConfirmation_onlyForAdvancedOffers() {
        assertFalse(BatchDialPlanner.requiresConfirmation(listOf(offer("a"))))
        assertTrue(
            BatchDialPlanner.requiresConfirmation(
                listOf(offer("a"), offer("b", silent = false))
            )
        )
    }

    @Test
    fun confirmationMessage_listsAdvancedOffersOnly() {
        val message = BatchDialPlanner.confirmationMessage(
            listOf(offer("a"), offer("b", silent = false))
        )

        assertEquals("- Offer b", message)
    }

    @Test
    fun queuedMessage_matchesToastCopy() {
        assertEquals("Queued 3 silent dials", BatchDialPlanner.queuedMessage(3))
    }

    @Test
    fun expand_handlesLegacyBhPlaceholder() {
        assertEquals("*100*0712345678#", BatchDialPlanner.expand("*100*BH#", "0712345678"))
    }

    @Test
    fun gap_keepsUssdSessionsFromOverlapping() {
        assertEquals(3_000L, BatchDialPlanner.GAP_MILLIS)
    }

    /** Offers are "advanced" (commission-safe) unless the agent opts in. */
    @Test
    fun offer_defaultsToAdvancedMode() {
        assertFalse(Offer(id = "x", name = "X", ussdCode = "*544#", price = 20).silentBatch)
    }
}