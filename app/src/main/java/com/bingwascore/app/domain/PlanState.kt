package com.bingwascore.app.domain

/**
 * Stage 12 — the agent's plan state, as the Home credits bubble reads it.
 *
 * The bubble used to show a raw count of successful transactions, which is a
 * scoreboard, not a balance: what an agent actually needs to know is what they
 * have LEFT. A pulls plan shows pulls remaining; an unlimited plan shows days
 * remaining. With no plan at all the label falls back to the earned-credit
 * count (nothing to debit against yet).
 *
 * Pure data + pure formatting, so it is unit-tested like everything else here.
 * Persistence lives in [com.bingwascore.app.data.preferences.UserPreferences];
 * Stage 13's purchase flow is what fills this in.
 */
data class PlanState(
    val planId: String = "",
    val displayName: String = "",
    val pullsLeft: Int = 0,
    val unlimited: Boolean = false,
    val expiresAtMillis: Long = 0L
) {
    /** No plan purchased (or plan cleared): the bubble shows earned credits. */
    val isActive: Boolean get() = planId.isNotBlank()

    /**
     * Stage 13 — the expiry worker's question: has the validity window closed?
     * Inactive plans are never "expired" (there is nothing to lapse), and a
     * zero timestamp (legacy data) is treated as open-ended, never expired.
     */
    fun isExpired(nowMillis: Long): Boolean =
        isActive && expiresAtMillis in 1..nowMillis

    /**
     * What the credits bubble shows, or null when no plan is active and the
     * caller should fall back to the earned-credit count.
     *
     * - pulls plan  -> "417" (pulls left as a bare count)
     * - unlimited   -> "3 days" (singular for one day left)
     */
    fun remainingLabel(nowMillis: Long): String? = when {
        !isActive -> null
        unlimited -> {
            val daysLeft = ((expiresAtMillis - nowMillis).coerceAtLeast(0L) / DAY_MILLIS) + 1
            if (daysLeft == 1L) "1 day" else "$daysLeft days"
        }
        else -> "$pullsLeft"
    }

    companion object {
        const val DAY_MILLIS: Long = 24L * 60 * 60 * 1000
    }
}