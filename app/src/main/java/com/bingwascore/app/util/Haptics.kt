package com.bingwascore.app.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

/**
 * Parity E — one tiny wrapper around [LocalHapticFeedback] so the whole app
 * speaks the same haptic vocabulary instead of open-coding `try/catch` blocks:
 *
 * - [tick] — light confirmation: bottom-nav taps, switches, filter chips.
 * - [press] — heavier commit: gradient CTAs, the dialer FAB.
 * - [success] — a job landed: dial fired, payment simulated.
 * - [error] — a job failed: invalid input, failed transaction.
 *
 * Every call is guarded: a device without a vibrator (or a framework quirk)
 * can never crash a click — the action always goes through.
 */
class Haptics(private val feedback: HapticFeedback? = null) {

    /** Light tick — navigation, toggles, selections. */
    fun tick() = perform(HapticFeedbackType.TextHandleMove)

    /** Stronger press — primary buttons and the dialer FAB. */
    fun press() = perform(HapticFeedbackType.LongPress)

    /** Positive outcome — dial accepted, payment simulated. */
    fun success() = perform(HapticFeedbackType.LongPress)

    /** Negative outcome — validation error, failed dial. */
    fun error() = perform(HapticFeedbackType.LongPress)

    private fun perform(type: HapticFeedbackType) {
        try {
            feedback?.performHapticFeedback(type)
        } catch (_: Throwable) {
            // Haptics are optional polish; never block the interaction.
        }
    }

    companion object {
        /** No-op instance for previews / tests where no vibrator exists. */
        val Disabled: Haptics = Haptics(null)
    }
}

/** Remembers a [Haptics] bound to the current composition's feedback service. */
@Composable
fun rememberHaptics(): Haptics {
    val feedback = LocalHapticFeedback.current
    return remember(feedback) { Haptics(feedback) }
}
