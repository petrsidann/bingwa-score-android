package com.bingwascore.app

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.home.CreditsPass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * U7.1 — credits + pass.
 *
 * Laws:
 *  1. A credit is exactly one SUCCESSFUL transaction (E1 honesty: failed,
 *     queued or scheduled rows never mint credits).
 *  2. The pass ladder is monotonic; tier unlocks at >= cost, never below 0.
 *  3. Buying a pass spends PASS_CREDIT_COST and can never go negative.
 */
class U7CreditsPassTest {

    private fun tx(status: TransactionStatus, id: String = "id-${status.name}-${(0..999).random()}") =
        Transaction(
            id = id,
            phoneNumber = "0700000000",
            customerName = "TEST USER",
            offerId = "o1",
            offerName = "Bundle 1GB",
            ussdCode = "*144*2#",
            amount = 50.0,
            commission = 5.0,
            status = status.value,
            createdAt = System.currentTimeMillis()
        )

    @Test
    fun creditIsExactlyOneSuccessfulTransaction() {
        val list = listOf(
            tx(TransactionStatus.SUCCESSFUL),
            tx(TransactionStatus.SUCCESSFUL),
            tx(TransactionStatus.FAILED),
            tx(TransactionStatus.PENDING),
            tx(TransactionStatus.PROCESSING),
            tx(TransactionStatus.SCHEDULED)
        )
        assertEquals(2, CreditsPass.creditsEarned(list))
    }

    @Test
    fun emptyLedgerEarnsNothing() {
        assertEquals(0, CreditsPass.creditsEarned(emptyList()))
    }

    @Test
    fun tierLadderIsMonotonic() {
        for (i in 1 until CreditsPass.TIER_COSTS.size) {
            assertTrue(CreditsPass.TIER_COSTS[i] > CreditsPass.TIER_COSTS[i - 1])
        }
    }

    @Test
    fun unlockedTierFollowsTheLadder() {
        assertEquals(0, CreditsPass.unlockedTier(-5))
        assertEquals(0, CreditsPass.unlockedTier(0))
        assertEquals(0, CreditsPass.unlockedTier(29))
        assertEquals(1, CreditsPass.unlockedTier(30))   // exact cost unlocks
        assertEquals(1, CreditsPass.unlockedTier(79))
        assertEquals(2, CreditsPass.unlockedTier(80))
        assertEquals(3, CreditsPass.unlockedTier(150))
        assertEquals(3, CreditsPass.unlockedTier(9999)) // capped at last tier
    }

    @Test
    fun buyingAPassSpendsTheCostAndNeverGoesNegative() {
        assertEquals(0, CreditsPass.spendCredits(30))
        assertEquals(70, CreditsPass.spendCredits(100))
        assertEquals(0, CreditsPass.spendCredits(10))  // insufficient: floors at 0
        assertFalse(CreditsPass.canBuyPass(29))
        assertTrue(CreditsPass.canBuyPass(30))
    }

    @Test
    fun creditsToNextTierCountsUpAndMaxesAtZero() {
        assertEquals(30, CreditsPass.creditsToNextTier(0))
        assertEquals(1, CreditsPass.creditsToNextTier(29))
        assertEquals(50, CreditsPass.creditsToNextTier(30))
        assertEquals(0, CreditsPass.creditsToNextTier(150)) // maxed
    }
}
