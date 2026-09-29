package com.bingwascore.app.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.HelpOutline
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.bingwascore.app.domain.TransactionStatus
import java.util.Locale

/**
 * Parity E — single source of truth for transaction status visuals.
 *
 * Every screen that renders a status (Transactions rows, detail sheet, Home
 * activity) reads colour + icon + label from here so a status can never look
 * different in two places.
 *
 * Palette (exact hex):
 * - Success / check  → `#00C853` (green)
 * - Scheduled / clock → `#2979FF` (blue)
 * - Pending / hourglass → `#FF9800` (orange)
 * - Failed / cross → `#FF453A` (red)
 * - Neutral (unmatched / cancelled / paused) → silver
 */
object StatusColors {

    /** Completed successfully — `#00C853`. */
    val Success: Color = EmeraldGreen

    /** Queued for a future run — `#2979FF`. */
    val Scheduled: Color = Color(0xFF2979FF)

    /** In flight / waiting on USSD — `#FF9800`. */
    val Pending: Color = Orange500

    /** Failed or already recommended — `#FF453A`. */
    val Failed: Color = ErrorRed

    /** Unmatched / cancelled / paused — no signal either way. */
    val Neutral: Color = Amber

    /** Colour for a raw Room status string (never throws on unknown values). */
    fun color(status: String?): Color = when (status) {
        TransactionStatus.SUCCESSFUL.value -> Success
        TransactionStatus.SCHEDULED.value -> Scheduled
        TransactionStatus.PENDING.value, TransactionStatus.PROCESSING.value -> Pending
        TransactionStatus.FAILED.value,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value -> Failed
        else -> Neutral
    }

    /** Icon for a raw Room status string (never throws on unknown values). */
    fun icon(status: String?): ImageVector = when (status) {
        TransactionStatus.SUCCESSFUL.value -> Icons.Rounded.CheckCircle
        TransactionStatus.SCHEDULED.value -> Icons.Rounded.Schedule
        TransactionStatus.FAILED.value,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value -> Icons.Rounded.ErrorOutline
        TransactionStatus.UNMATCHED.value -> Icons.AutoMirrored.Rounded.HelpOutline
        TransactionStatus.CANCELLED.value -> Icons.Rounded.Close
        else -> Icons.Rounded.HourglassTop
    }

    /** Human label, e.g. `FAILED_ALREADY_RECOMMENDED` → "Failed Already Recommended". */
    fun label(status: String?): String {
        val raw = status?.takeIf { it.isNotBlank() } ?: return "Unknown"
        return raw.lowercase(Locale.ROOT)
            .split('_', ' ')
            .filter { it.isNotBlank() }
            .joinToString(" ") { part -> part.replaceFirstChar { it.uppercase(Locale.ROOT) } }
    }

    /** True for statuses that should read as a problem (used for error haptics). */
    fun isFailure(status: String?): Boolean = when (status) {
        TransactionStatus.FAILED.value,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value,
        TransactionStatus.UNMATCHED.value,
        TransactionStatus.CANCELLED.value -> true
        else -> false
    }
}
