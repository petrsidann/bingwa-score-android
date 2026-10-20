package com.bingwascore.app.ui.home

import com.bingwascore.app.ui.theme.Motion

/**
 * Stage 12 — the Autopilot pill's guard, as pure logic.
 *
 * The pill's contract is asymmetric on purpose: a **tap** is free (it opens
 * the sheet, it NEVER pauses), and **pausing** takes a deliberate 600ms hold
 * whose progress is drawn on the pill as a ring. A stalled autopilot is a lost
 * sale every minute it stays off, so the destructive act gets a deliberate
 * gesture and the safe one gets none.
 *
 * Kept pure so the "tap never pauses" rule is unit-tested rather than trusted
 * to a gesture implementation.
 */
object AutopilotGuard {

    /** A tap NEVER pauses — it only opens the sheet. */
    const val TAP_PAUSES: Boolean = false

    /** The hold length that commits a pause, in ms. */
    const val HOLD_MILLIS: Long = Motion.ARM_HOLD_MILLIS

    /** 0f..1f ring progress for a hold of [elapsedMillis]. */
    fun holdProgress(elapsedMillis: Long): Float =
        (elapsedMillis.toFloat() / HOLD_MILLIS).coerceIn(0f, 1f)

    /** True only when the hold ran its full course — that alone pauses. */
    fun holdCompleted(elapsedMillis: Long): Boolean = elapsedMillis >= HOLD_MILLIS
}