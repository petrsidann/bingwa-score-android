package com.bingwascore.app.ui.components

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.mystore.OrderStatus
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.theme.SemanticBlue

/**
 * Stage P2A — D1: Unified status style.
 *
 * Single source of truth for transaction/status visuals across all screens.
 * Replaces per-screen status colour/icon/label logic with one composable helper.
 */
@Immutable
data class StatusStyle(
    val tileColor: Color,
    val glyph: String,
    val chipLabel: String,
    val chipColor: Color
)

/**
 * Resolve a [TransactionStatus] into its visual tokens.
 *
 * - SUCCESSFUL → success tile (0.2 alpha), check glyph, "Completed" label, success chip
 * - FAILED / FAILED_ALREADY_RECOMMENDED → error tile (0.2 alpha), cross glyph, "Failed" label, error chip
 * - PENDING / PROCESSING → brand tile (0.2 alpha), clock glyph, "Queued" label, brand chip
 * - SCHEDULED → info tile (0.2 alpha), hourglass glyph, "Awaiting" label, info chip
 * - UNMATCHED / CANCELLED / PAUSED / IGNORED → neutral tile (0.2 alpha), "?" glyph, raw label, neutral chip
 */
@Composable
fun forStatus(status: TransactionStatus): StatusStyle {
    val roles = DesignTokens.LocalBingwaRoles.current
    return when (status) {
        TransactionStatus.SUCCESSFUL -> StatusStyle(
            tileColor = roles.success.copy(alpha = 0.2f),
            glyph = "✓",
            chipLabel = "Completed",
            chipColor = roles.success
        )
        TransactionStatus.FAILED,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED -> StatusStyle(
            tileColor = roles.error.copy(alpha = 0.2f),
            glyph = "✗",
            chipLabel = "Failed",
            chipColor = roles.error
        )
        TransactionStatus.PENDING,
        TransactionStatus.PROCESSING -> StatusStyle(
            tileColor = roles.brand.copy(alpha = 0.2f),
            glyph = "⧗",
            chipLabel = "Queued",
            chipColor = roles.brand
        )
        TransactionStatus.SCHEDULED -> StatusStyle(
            tileColor = SemanticBlue.copy(alpha = 0.2f),
            glyph = "⏲",
            chipLabel = "Awaiting",
            chipColor = SemanticBlue
        )
        else -> StatusStyle(
            tileColor = roles.textSecondary.copy(alpha = 0.2f),
            glyph = "?",
            chipLabel = status.value.lowercase().replaceFirstChar { it.uppercase() },
            chipColor = roles.textSecondary
        )
    }
}

/**
 * Resolve an [OrderStatus] into its visual tokens (MyStore orders).
 *
 * Maps to the same visual language as TransactionStatus for consistency.
 */
@Composable
fun forStatus(status: OrderStatus): StatusStyle {
    val roles = DesignTokens.LocalBingwaRoles.current
    return when (status) {
        OrderStatus.COMPLETED -> StatusStyle(
            tileColor = roles.success.copy(alpha = 0.2f),
            glyph = "✓",
            chipLabel = "Completed",
            chipColor = roles.success
        )
        OrderStatus.FAILED -> StatusStyle(
            tileColor = roles.error.copy(alpha = 0.2f),
            glyph = "✗",
            chipLabel = "Failed",
            chipColor = roles.error
        )
        OrderStatus.QUEUED -> StatusStyle(
            tileColor = roles.brand.copy(alpha = 0.2f),
            glyph = "⧗",
            chipLabel = "Queued",
            chipColor = roles.brand
        )
        OrderStatus.AWAITING -> StatusStyle(
            tileColor = SemanticBlue.copy(alpha = 0.2f),
            glyph = "⏲",
            chipLabel = "Awaiting",
            chipColor = SemanticBlue
        )
    }
}
