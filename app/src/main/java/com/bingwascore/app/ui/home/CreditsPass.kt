package com.bingwascore.app.ui.home

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus

/**
 * U7.1 — the rewards pass.
 *
 * Credits are earned one per completed bundle (the honest ledger in
 * [HomeViewModel.creditRows]); a pass is bought with them and unlocks every
 * tier up to it, like a snake that never loses the segments it grew.
 */
object CreditsPass {

    /** The price ladder in credits; tier 0 is free and always unlocked. */
    val TIER_COSTS = listOf(0, 30, 80, 150)

    const val PASS_CREDIT_COST = 30

    /** A credit is one SUCCESSFUL transaction — never anything else. */
    fun creditsEarned(transactions: List<Transaction>): Int =
        transactions.count { it.status == TransactionStatus.SUCCESSFUL.value }

    /** Highest tier index whose cost the balance covers; never below 0. */
    fun unlockedTier(credits: Int): Int {
        var tier = 0
        for (i in TIER_COSTS.indices) {
            if (credits >= TIER_COSTS[i]) tier = i
        }
        return tier
    }

    /** A pass purchase costs [PASS_CREDIT_COST] and cannot go below zero. */
    fun spendCredits(credits: Int, cost: Int = PASS_CREDIT_COST): Int =
        (credits - cost).coerceAtLeast(0)

    /** Whether a pass can be bought right now at the given balance. */
    fun canBuyPass(credits: Int): Boolean = credits >= PASS_CREDIT_COST

    /** Credits still needed before the next tier unlocks (0 when maxed). */
    fun creditsToNextTier(credits: Int): Int {
        val next = unlockedTier(credits) + 1
        if (next >= TIER_COSTS.size) return 0
        return TIER_COSTS[next] - credits
    }
}
