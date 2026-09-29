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
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.components.shimmer
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.util.staggeredEnter
import com.bingwascore.app.ui.theme.GlassBorderStrong
import com.bingwascore.app.ui.theme.GlassBorder
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.Amber
import com.bingwascore.app.ui.theme.BingwaOrange
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TransactionsScreen(viewModel: TransactionsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()
    val selectedFilter by viewModel.filter.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    var selectedTransaction by remember { mutableStateOf<Transaction?>(null) }

    LaunchedEffect(Unit) {
        viewModel.events.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Transactions", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "${transactions.size} record(s)",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
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
                            onClick = {
                                haptics.tick()
                                selectedTransaction = transaction
                            }
                        )
                    }
                }
            }
        }
    }

    selectedTransaction?.let { transaction ->
        ModalBottomSheet(
            onDismissRequest = { selectedTransaction = null },
            containerColor = SurfaceDark
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
                    .background(ErrorRed.copy(alpha = 0.16f))
                    .border(1.dp, ErrorRed.copy(alpha = 0.45f), shape)
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.DeleteOutline,
                        contentDescription = "Delete transaction",
                        tint = ErrorRed,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Delete",
                        color = ErrorRed,
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
            GlassCard(
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
private fun TransactionRow(transaction: Transaction, enterDelayMillis: Int, onClick: () -> Unit) {
    val color = statusColor(transaction.status)
    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 18.dp,
        onClick = onClick,
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
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "${transaction.offerName} • ${timeAgo(transaction.createdAt)}",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 11.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    formatKsh(transaction.amount),
                    color = White,
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
                    color = White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    transaction.phoneNumber,
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(GlassFill)
                .border(1.dp, GlassBorder, RoundedCornerShape(18.dp))
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
            SheetAction(Icons.Rounded.Refresh, "Retry now", Amber, onRetry)
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (canComplete(transaction.status)) {
            SheetAction(Icons.Rounded.CheckCircle, "Mark as completed", EmeraldGreen, onComplete)
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (canSchedule(transaction.status)) {
            SheetAction(
                Icons.Rounded.Schedule,
                "Schedule tomorrow 01:00",
                Orange500,
                onSchedule
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        SheetAction(Icons.Rounded.DeleteOutline, "Delete transaction", ErrorRed, onDelete)
    }
}

@Composable
private fun ColumnScope.DetailRow(label: String, value: String) {
    Row {
        Text(
            label,
            color = White.copy(alpha = 0.5f),
            fontSize = 12.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            value,
            color = White,
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
            .background(GlassFill)
            .border(1.dp, GlassBorder, shape)
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
        Text(label, color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
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
            .background(if (selected) BingwaOrange.copy(alpha = 0.18f) else GlassFill)
            .border(
                1.dp,
                if (selected) BingwaOrange.copy(alpha = 0.55f) else GlassBorder,
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
            color = if (selected) BingwaOrange else White.copy(alpha = 0.65f),
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
            .background(GlassFill)
            .border(1.dp, GlassBorderStrong, shape)
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
                tint = BingwaOrange,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "CSV",
                color = EmeraldGreen,
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