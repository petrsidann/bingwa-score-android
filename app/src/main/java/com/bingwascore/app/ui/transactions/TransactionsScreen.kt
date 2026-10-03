package com.bingwascore.app.ui.transactions

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.FileDownload
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.components.shimmer
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.util.staggeredEnter
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextWhite
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TransactionsScreen(
    initialFilter: TransactionFilter = TransactionFilter.ALL,
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()
    val selectedFilter by viewModel.filter.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    var selectedTransaction by remember { mutableStateOf<Transaction?>(null) }

    // MEGA A — the Ghost Queue multi-select.
    val selectedIds by viewModel.selectedIds.collectAsStateWithLifecycle()
    val hasSelection by viewModel.hasSelection.collectAsStateWithLifecycle()
    val allSelected = transactions.isNotEmpty() && selectedIds.size == transactions.size

    LaunchedEffect(initialFilter) {
        // R2 — arriving from a Home counter applies that filter on entry.
        viewModel.setFilter(initialFilter)
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Transactions", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    if (hasSelection) {
                        "${selectedIds.size} in Ghost Queue"
                    } else {
                        "${transactions.size} record(s)"
                    },
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            // MEGA A — Select All lives beside Export so batch work is one tap.
            if (!isLoading && transactions.isNotEmpty()) {
                SelectAllChip(
                    label = if (allSelected) "Clear" else "Select All",
                    active = hasSelection,
                    onClick = {
                        haptics.tick()
                        viewModel.toggleSelectAll()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            ExportButton(onClick = viewModel::exportCsv)
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(TransactionFilter.entries.toList()) { filter ->
                FilterChip(
                    label = filter.label,
                    selected = selectedFilter == filter,
                    onClick = {
                        haptics.tick()
                        viewModel.setFilter(filter)
                        // Rows hidden by the new filter must leave the queue.
                        viewModel.pruneSelection()
                    }
                )
            }
        }

        if (isLoading) {
            // Parity E — shimmer skeletons while Room warms up.
            TransactionSkeleton()
        } else if (transactions.isEmpty()) {
            EmptyState(
                icon = if (selectedFilter == TransactionFilter.ALL) {
                    Icons.AutoMirrored.Rounded.ReceiptLong
                } else {
                    Icons.Rounded.SearchOff
                },
                title = if (selectedFilter == TransactionFilter.ALL) "No transactions yet" else "Nothing in this filter",
                message = if (selectedFilter == TransactionFilter.ALL) {
                    "Every bundle you dial gets recorded here — pending, completed, scheduled and failed."
                } else {
                    "No ${selectedFilter.label.lowercase(Locale.ROOT)} records yet — try another filter."
                },
                modifier = Modifier.padding(20.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(transactions, key = { _, tx -> tx.id }) { index, transaction ->
                    // Parity E — swipe left to tombstone the row (soft delete).
                    SwipeToDeleteRow(
                        index = index,
                        onDelete = { viewModel.softDelete(transaction) }
                    ) {
                        TransactionRow(
                            transaction = transaction,
                            enterDelayMillis = 0,
                            // A long-press ticks the row into the Ghost Queue;
                            // a plain tap still opens the detail sheet.
                            onClick = {
                                if (transaction.id in selectedIds) {
                                    haptics.tick()
                                    viewModel.toggleSelection(transaction.id)
                                } else {
                                    haptics.tick()
                                    selectedTransaction = transaction
                                }
                            },
                            onLongClick = {
                                haptics.press()
                                viewModel.toggleSelection(transaction.id)
                            }
                        )
                    }
                }
            }
        }

        // MEGA A — the Ghost Queue action bar: batch retry / complete / export
        // over every ticked row, then the queue empties itself.
        if (hasSelection) {
            GhostQueueBar(
                count = selectedIds.size,
                onRetry = {
                    haptics.press()
                    viewModel.forEachSelected { viewModel.retry(it) }
                },
                onComplete = {
                    haptics.press()
                    viewModel.forEachSelected { viewModel.complete(it) }
                },
                onClear = {
                    haptics.tick()
                    viewModel.clearSelection()
                }
            )
        }
    }

    selectedTransaction?.let { transaction ->
        ModalBottomSheet(
            onDismissRequest = { selectedTransaction = null },
            containerColor = Raised
        ) {
            TransactionDetailSheet(
                transaction = transaction,
                onRetry = {
                    viewModel.retry(transaction)
                    selectedTransaction = null
                },
                onComplete = {
                    viewModel.complete(transaction)
                    selectedTransaction = null
                },
                onSchedule = {
                    viewModel.schedule(transaction)
                    selectedTransaction = null
                },
                onDelete = {
                    viewModel.delete(transaction)
                    selectedTransaction = null
                }
            )
        }
    }
}

/**
 * Parity E — swipe-to-delete wrapper. Dragging a row from right to left reveals
 * a red tombstone rail and, once past the threshold, soft-deletes the record
 * (with a haptic thud) so the live list drops it immediately.
 */
@Composable
private fun SelectAllChip(label: String, active: Boolean, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(RoundedCornerShape(10.dp))
            .background(if (active) AccentBlue.copy(alpha = 0.18f) else Bubble)
            .border(
                1.dp,
                if (active) AccentBlue.copy(alpha = 0.55f) else Hairline,
                RoundedCornerShape(10.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            label,
            color = if (active) AccentBlue else TextWhite.copy(alpha = 0.75f),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * MEGA A — the Ghost Queue bar. Anchored under the list whenever rows are
 * ticked, so batch retry/complete is reachable without leaving the screen.
 */
@Composable
private fun GhostQueueBar(
    count: Int,
    onRetry: () -> Unit,
    onComplete: () -> Unit,
    onClear: () -> Unit
) {
    BubbleCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Ghost Queue",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "$count selected",
                    color = TextWhite.copy(alpha = 0.55f),
                    fontSize = 11.sp
                )
            }
            GhostQueueAction("Retry", Icons.Rounded.Refresh, onRetry)
            Spacer(modifier = Modifier.width(8.dp))
            GhostQueueAction("Complete", Icons.Rounded.CheckCircle, onComplete)
            Spacer(modifier = Modifier.width(8.dp))
            GhostQueueAction("Clear", Icons.Rounded.Close, onClear)
        }
    }
}

@Composable
private fun GhostQueueAction(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = AccentBlue,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            label,
            color = TextWhite.copy(alpha = 0.75f),
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun SwipeToDeleteRow(
    index: Int,
    onDelete: () -> Unit,
    content: @Composable () -> Unit
) {
    val haptics = rememberHaptics()
    val state = rememberSwipeToDismissBoxState(
        confirmValueChange = { value ->
            if (value == SwipeToDismissBoxValue.EndToStart) {
                haptics.error()
                onDelete()
                true
            } else {
                false
            }
        }
    )
    val shape = RoundedCornerShape(18.dp)

    SwipeToDismissBox(
        state = state,
        modifier = Modifier.staggeredEnter(index),
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape)
                    .background(FailRed.copy(alpha = 0.16f))
                    .border(1.dp, FailRed.copy(alpha = 0.45f), shape)
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.DeleteOutline,
                        contentDescription = "Delete transaction",
                        tint = FailRed,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Delete",
                        color = FailRed,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    ) {
        content()
    }
}

/**
 * Parity E — list skeleton shown while the first Room snapshot is in flight:
 * three frosted cards with shimmering value bars.
 */
@Composable
private fun TransactionSkeleton() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(3) { index ->
            BubbleCard(
                modifier = Modifier.fillMaxWidth(),
                cornerRadius = 18.dp,
                enterDelayMillis = index * Motion.STAGGER
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ShimmerBlock(modifier = Modifier.size(40.dp), cornerRadius = 14.dp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        ShimmerBlock(modifier = Modifier.fillMaxWidth(0.6f))
                        Spacer(modifier = Modifier.height(8.dp))
                        ShimmerBlock(modifier = Modifier.fillMaxWidth(0.4f), cornerRadius = 8.dp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    ShimmerBlock(modifier = Modifier.width(64.dp))
                }
            }
        }
    }
}

@Composable
private fun TransactionRow(
    transaction: Transaction,
    enterDelayMillis: Int,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null
) {
    val color = statusColor(transaction.status)
    BubbleCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 18.dp,
        onClick = onClick,
        onLongClick = onLongClick,
        enterDelayMillis = enterDelayMillis
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(color.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = statusIcon(transaction.status),
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    transaction.customerName ?: transaction.phoneNumber,
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "${transaction.offerName} • ${timeAgo(transaction.createdAt)}",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 11.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    formatKsh(transaction.amount),
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    transaction.status.lowercase(Locale.ROOT)
                        .replaceFirstChar { it.uppercase(Locale.ROOT) },
                    color = color,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun TransactionDetailSheet(
    transaction: Transaction,
    onRetry: () -> Unit,
    onComplete: () -> Unit,
    onSchedule: () -> Unit,
    onDelete: () -> Unit
) {
    val iso = remember { SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) }
    val color = statusColor(transaction.status)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 28.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = statusIcon(transaction.status),
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(22.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    transaction.customerName ?: transaction.phoneNumber,
                    color = TextWhite,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    transaction.phoneNumber,
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(Bubble)
                .border(1.dp, Hairline, RoundedCornerShape(18.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DetailRow(
                "Status",
                transaction.status.lowercase(Locale.ROOT)
                    .replaceFirstChar { it.uppercase(Locale.ROOT) }
            )
            DetailRow("Offer", transaction.offerName)
            DetailRow("Amount", formatKsh(transaction.amount))
            DetailRow("Commission", formatKsh(transaction.commission))
            DetailRow("USSD", transaction.ussdCode)
            DetailRow("Created", iso.format(Date(transaction.createdAt)))
            transaction.scheduledAt?.let {
                DetailRow("Scheduled for", iso.format(Date(it)))
            }
            transaction.mpesaReceipt?.let { DetailRow("M-Pesa receipt", it) }
            // Parity C hybrid field: the raw USSD/MPesa reply that closed the row.
            transaction.responseMessage
                ?.takeIf { it.isNotBlank() }
                ?.let { DetailRow("Response", it) }
            transaction.errorMessage?.let { DetailRow("Error", it) }
            DetailRow("Retries", transaction.retryCount.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (canRetry(transaction.status)) {
            SheetAction(Icons.Rounded.Refresh, "Retry now", PendGrey, onRetry)
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (canComplete(transaction.status)) {
            SheetAction(Icons.Rounded.CheckCircle, "Mark as completed", TickGreen, onComplete)
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (canSchedule(transaction.status)) {
            SheetAction(
                Icons.Rounded.Schedule,
                "Schedule tomorrow 01:00",
                PendGrey,
                onSchedule
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        SheetAction(Icons.Rounded.DeleteOutline, "Delete transaction", FailRed, onDelete)
    }
}

@Composable
private fun ColumnScope.DetailRow(label: String, value: String) {
    Row {
        Text(
            label,
            color = TextWhite.copy(alpha = 0.5f),
            fontSize = 12.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            value,
            color = TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(2.2f)
        )
    }
}

@Composable
private fun SheetAction(icon: ImageVector, label: String, tint: Color, onClick: () -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .pressScale(interactionSource)
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(label, color = TextWhite, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun FilterChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(shape)
            .background(if (selected) AccentBlue.copy(alpha = 0.18f) else Bubble)
            .border(
                1.dp,
                if (selected) AccentBlue.copy(alpha = 0.55f) else Hairline,
                shape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            label,
            color = if (selected) AccentBlue else TextWhite.copy(alpha = 0.65f),
            fontSize = 12.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun ExportButton(onClick: () -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.FileDownload,
                contentDescription = null,
                tint = AccentBlue,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "CSV",
                color = TickGreen,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

/** Parity E — status visuals come from the shared [StatusColors] palette. */
private fun statusColor(status: String): Color = StatusColors.color(status)

private fun statusIcon(status: String): ImageVector = StatusColors.icon(status)

private fun canRetry(status: String): Boolean =
    status != TransactionStatus.SUCCESSFUL.value &&
        status != TransactionStatus.SCHEDULED.value

private fun canComplete(status: String): Boolean =
    status != TransactionStatus.SUCCESSFUL.value

private fun canSchedule(status: String): Boolean =
    status != TransactionStatus.SCHEDULED.value

private fun formatKsh(value: Double): String =
    "Ksh " + String.format(Locale.US, "%,.2f", value)

private fun timeAgo(then: Long, now: Long = System.currentTimeMillis()): String {
    val minutes = (now - then) / 60_000
    return when {
        minutes < 1 -> "Just now"
        minutes < 60 -> "${minutes}m ago"
        minutes < 24 * 60 -> "${minutes / 60}h ago"
        minutes < 30 * 24 * 60 -> "${minutes / (24 * 60)}d ago"
        else -> "${minutes / (30 * 24 * 60)}mo ago"
    }
}
