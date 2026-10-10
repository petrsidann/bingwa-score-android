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
import com.bingwascore.app.ui.theme.SemanticBlue
import com.bingwascore.app.ui.theme.SemanticGrey
import com.bingwascore.app.ui.theme.SemanticRed
import java.util.Locale

/**
 * Parity E — single source of truth for transaction status visuals.
 *
 * Every screen that renders a status (Transactions rows, detail sheet, Home
 * activity) reads colour + icon + label from here so a status can never look
 * different in two places.
 *
 * Palette (exact hex, and **identical in every display mode** since P5):
 * - Successful → `#3E6BFF` (semantic blue — success is brand, not a green dot)
 * - Failed / already recommended → `#FF5252`
 * - Pending / processing / scheduled → `#9E9E9E`
 * - Unmatched / cancelled / paused → dim grey
 *
 * Green is reserved for the "mark complete" tick ([TickGreen]) and nothing else.
 */
object StatusColors {

    /**
     * POLISH P5 — completed successfully.
     *
     * The *semantic* blue, not the chrome accent: in Grayscale a cleared sale is
     * still blue, because colour is the fastest signal a ledger has.
     */
    val Success: Color get() = SemanticBlue

    /** Queued for a future run — grey, same as pending. */
    val Scheduled: Color get() = SemanticGrey

    /** In flight / waiting on USSD — grey, it carries no verdict yet. */
    val Pending: Color get() = SemanticGrey

    /** Failed or already recommended — the semantic red, in every mode. */
    val Failed: Color get() = SemanticRed

    /** Unmatched / cancelled / paused — no signal either way. */
    val Neutral: Color get() = TextDim

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

    /**
     * Human label, e.g. `FAILED_ALREADY_RECOMMENDED` → "Failed Already Recommended".
     *
     * U3 — the UI never says "Pending": a row the engine has not dialed yet is
     * **Queued**, which is what it actually is. The stored enum value `PENDING`
     * is unchanged, so the database and every status comparison keep working.
     */
    fun label(status: String?): String {
        val raw = status?.takeIf { it.isNotBlank() } ?: return "Unknown"
        return when (raw.uppercase(Locale.ROOT)) {
            TransactionStatus.PENDING.value,
            TransactionStatus.PROCESSING.value -> "Queued"
            else -> raw.lowercase(Locale.ROOT)
                .split('_', ' ')
                .filter { it.isNotBlank() }
                .joinToString(" ") { part -> part.replaceFirstChar { it.uppercase(Locale.ROOT) } }
        }
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
