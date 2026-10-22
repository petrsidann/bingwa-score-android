package com.bingwascore.app.domain

/**
 * Stage 20 — the live countdown on the active plan page.
 *
 * The paywall never shows a plan as "active" without saying how much of it is
 * left: the agent is buying dials, and the number of dials (or hours) still
 * live is the whole point of the badge. Pure formatting, so it is pinned by
 * `PlanMatrixTest`.
 */
object PlanCountdown {

    /**
     * The countdown as the agent reads it:
     * "3d 4h left", "4h 12m left", "42m left" — and "Expired" once the window
     * has closed.
     */
    fun label(remainingMillis: Long): String {
        if (remainingMillis <= 0L) return "Expired"
        val totalMinutes = remainingMillis / 60_000L
        val days = totalMinutes / (60L * 24L)
        val hours = (totalMinutes / 60L) % 24L
        val minutes = totalMinutes % 60L
        return when {
            days > 0L -> "${days}d ${hours}h left"
            hours > 0L -> "${hours}h ${minutes}m left"
            else -> "${minutes}m left"
        }
    }
}
