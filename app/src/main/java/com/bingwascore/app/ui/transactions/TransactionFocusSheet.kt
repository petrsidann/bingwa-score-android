package com.bingwascore.app.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import java.util.Calendar
import java.util.Locale

/** What the sheet shows about one customer, derived from the live list. */
data class ClientStats(
    val purchasesToday: Int,
    val purchasesThisWeek: Int,
    val totalSpent: Double
)

/**
 * REBRAND R4 — the focus sheet.
 *
 * Everything about one transaction in one scrollable surface: who it was for,
 * what that customer is worth, the exact M-Pesa message that arrived, the USSD
 * code behind it (editable — a typo in the code is the most common real failure)
 * and the four actions that can move it forward.
 */
@Composable
fun TransactionFocusSheet(
    transaction: Transaction,
    stats: ClientStats,
    onRetry: () -> Unit,
    onComplete: () -> Unit,
    onSchedule: () -> Unit,
    onDelete: () -> Unit,
    onEditUssd: (String) -> Unit,
    onViewAllFromNumber: () -> Unit
) {
    val clipboard = LocalClipboardManager.current
    var editingUssd by remember { mutableStateOf(false) }
    val haptics = rememberHaptics()
    val statusColor = StatusColors.color(transaction.status)
    // U5 — one formatter, and the write actions follow the status rules.
    val rules = rulesFor(transaction.status)
    val name = formatCustomerName(transaction.customerName).ifBlank { transaction.phoneNumber }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        // ── Client header ─────────────────────────────────────────────────────
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(AccentBlue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    name.take(1).uppercase(Locale.ROOT),
                    color = TextWhite,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(name, color = TextWhite, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(transaction.phoneNumber, color = TextGrey, fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Rounded.ContentCopy,
                        contentDescription = "Copy number",
                        tint = TextDim,
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .clickable {
                                clipboard.setText(AnnotatedString(transaction.phoneNumber))
                            }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "View all from this number",
            color = AccentBlue,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onViewAllFromNumber)
                .padding(vertical = 6.dp, horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        // ── Client stats ──────────────────────────────────────────────────────
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatTile("Today", "${stats.purchasesToday}", Modifier.weight(1f))
            StatTile("This week", "${stats.purchasesThisWeek}", Modifier.weight(1f))
            StatTile("Total spent", "Ksh ${money(stats.totalSpent)}", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

// ── Status + amounts ──────────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Bubble)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = StatusColors.icon(transaction.status),
                contentDescription = null,
                tint = statusColor,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    StatusColors.label(transaction.status),
                    color = statusColor,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(transaction.offerName, color = TextGrey, fontSize = 12.sp)
            }
            Text(
                "Ksh ${money(transaction.amount)}",
                color = TextWhite,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ── USSD row (editable) ───────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Bubble)
                .clickable { editingUssd = true }
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("USSD code", color = TextGrey, fontSize = 12.sp)
                Text(
                    transaction.ussdCode,
                    color = TextWhite,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text("Tap to edit", color = AccentBlue, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ── The M-Pesa message, in full ───────────────────────────────────────
        Text("M-Pesa message", color = TextGrey, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Bubble)
                .border(1.dp, Hairline, RoundedCornerShape(14.dp))
                .padding(14.dp)
        ) {
            SelectionContainer {
                Text(
                    text = transaction.mpesaReceipt
                        ?: transaction.responseMessage
                        ?: "No message was captured for this transaction.",
                    color = if (transaction.mpesaReceipt != null) TextWhite else TextDim,
                    fontSize = 13.sp
                )
            }
        }

        transaction.errorMessage?.let { error ->
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(FailRed.copy(alpha = 0.12f))
                    .padding(14.dp)
            ) {
                Text(error, color = FailRed, fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // ── Actions ───────────────────────────────────────────────────────────
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // U5 — a finished sale offers neither Retry nor Complete: they are
            // greyed and answer a tap with a reject haptic (no silent no-op).
            SheetAction(
                icon = Icons.Rounded.Refresh,
                label = "Retry",
                tint = AccentBlue,
                enabled = rules.canRetry,
                onReject = haptics::error,
                modifier = Modifier.weight(1f),
                onClick = onRetry
            )
            SheetAction(Icons.Rounded.Schedule, "Schedule", TextGrey, Modifier.weight(1f), onSchedule)
            SheetAction(
                icon = Icons.Rounded.Check,
                label = "Complete",
                tint = TickGreen,
                enabled = rules.canComplete,
                onReject = haptics::error,
                modifier = Modifier.weight(1f),
                onClick = onComplete
            )
            SheetAction(Icons.Rounded.DeleteOutline, "Delete", FailRed, Modifier.weight(1f), onDelete)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }

if (editingUssd) {
        var draft by remember { mutableStateOf(transaction.ussdCode) }
        AlertDialog(
            onDismissRequest = { editingUssd = false },
            containerColor = Raised,
            title = { Text("Edit USSD code", color = TextWhite, fontWeight = FontWeight.Bold) },
            text = {
                TextField(
                    value = draft,
                    onValueChange = { draft = it },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = TextWhite,
                        unfocusedTextColor = TextWhite,
                        focusedContainerColor = Bubble,
                        unfocusedContainerColor = Bubble
                    )
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    onEditUssd(draft)
                    editingUssd = false
                }) { Text("Save", color = AccentBlue, fontWeight = FontWeight.SemiBold) }
            },
            dismissButton = {
                TextButton(onClick = { editingUssd = false }) { Text("Cancel", color = TextGrey) }
            }
        )
    }
}

@Composable
private fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Bubble)
            .padding(12.dp)
    ) {
        Text(value, color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.Bold, maxLines = 1)
        Spacer(modifier = Modifier.height(2.dp))
        Text(label, color = TextGrey, fontSize = 11.sp, maxLines = 1)
    }
}

/**
 * One sheet action. U5 — when [enabled] is false the action is greyed AND the tap
 * is answered with [onReject], so a disabled action is felt, not just ignored.
 */
@Composable
private fun SheetAction(
    icon: ImageVector,
    label: String,
    tint: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    // U5 — kept after `onClick` so the existing positional calls still bind and
    // the new enabled/reject pair is opt-in at each call site.
    enabled: Boolean = true,
    onReject: () -> Unit = {}
) {
    val ink = if (enabled) tint else TextDim
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Bubble)
            .clickable {
                if (enabled) onClick() else onReject()
            }
            .padding(vertical = 12.dp)
    ) {
        Icon(icon, contentDescription = label, tint = ink, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.height(6.dp))
        Text(label, color = ink, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}

/** Purchases today / this week / lifetime spend for one phone number. */
fun clientStatsFor(rows: List<Transaction>, phone: String): ClientStats {
    val today = startOfDay()
    val week = startOfWeek()
    val mine = rows.filter { it.phoneNumber == phone && it.status == "SUCCESSFUL" }
    return ClientStats(
        purchasesToday = mine.count { it.createdAt >= today },
        purchasesThisWeek = mine.count { it.createdAt >= week },
        totalSpent = mine.sumOf { it.amount }
    )
}

/** "1,234.56" — always two decimals, no locale surprises. */
fun money(value: Double): String = String.format(Locale.US, "%,.2f", value)

private fun startOfDay(): Long = Calendar.getInstance().apply {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}.timeInMillis

private fun startOfWeek(): Long = Calendar.getInstance().apply {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
    add(Calendar.DAY_OF_YEAR, -((get(Calendar.DAY_OF_WEEK) + 5) % 7))
}.timeInMillis

