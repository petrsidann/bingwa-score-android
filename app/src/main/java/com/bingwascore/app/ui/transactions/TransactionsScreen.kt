package com.bingwascore.app.ui.transactions

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.HelpOutline
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.FileDownload
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
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
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TransactionsScreen(viewModel: TransactionsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()
    val selectedFilter by viewModel.filter.collectAsStateWithLifecycle()
    var selectedTransaction by remember { mutableStateOf<Transaction?>(null) }

    LaunchedEffect(Unit) {
        viewModel.events.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    onClick = { viewModel.setFilter(filter) }
                )
            }
        }

        if (transactions.isEmpty()) {
            GlassCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    "Nothing here",
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "No transactions match this filter yet.",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 12.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(transactions, key = { it.id }) { transaction ->
                    TransactionRow(
                        transaction = transaction,
                        onClick = { selectedTransaction = transaction }
                    )
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

@Composable
private fun TransactionRow(transaction: Transaction, onClick: () -> Unit) {
    val color = statusColor(transaction.status)
    GlassCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 18.dp) {
        Row(
            modifier = Modifier.clickable(onClick = onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                .background(Color(0x14FFFFFF))
                .border(1.dp, Color(0x1FFFFFFF), RoundedCornerShape(18.dp))
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
            transaction.errorMessage?.let { DetailRow("Error", it) }
            DetailRow("Retries", transaction.retryCount.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (canRetry(transaction.status)) {
            SheetAction(Icons.Rounded.Refresh, "Retry now", TealBlue, onRetry)
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x1FFFFFFF), shape)
            .clickable(onClick = onClick)
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
    Box(
        modifier = Modifier
            .clip(shape)
            .background(if (selected) EmeraldGreen.copy(alpha = 0.18f) else Color(0x14FFFFFF))
            .border(
                1.dp,
                if (selected) EmeraldGreen.copy(alpha = 0.55f) else Color(0x1FFFFFFF),
                shape
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            label,
            color = if (selected) EmeraldGreen else White.copy(alpha = 0.65f),
            fontSize = 12.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun ExportButton(onClick: () -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    Box(
        modifier = Modifier
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x33FFFFFF), shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.FileDownload,
                contentDescription = null,
                tint = EmeraldGreen,
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

private fun statusColor(status: String): Color = when (status) {
    TransactionStatus.SUCCESSFUL.value -> EmeraldGreen
    TransactionStatus.FAILED.value, TransactionStatus.FAILED_ALREADY_RECOMMENDED.value -> ErrorRed
    TransactionStatus.SCHEDULED.value -> TealBlue
    else -> Orange500
}

private fun statusIcon(status: String): ImageVector = when (status) {
    TransactionStatus.SUCCESSFUL.value -> Icons.Rounded.CheckCircle
    TransactionStatus.FAILED.value, TransactionStatus.FAILED_ALREADY_RECOMMENDED.value ->
        Icons.Rounded.ErrorOutline
    TransactionStatus.SCHEDULED.value -> Icons.Rounded.Schedule
    TransactionStatus.UNMATCHED.value -> Icons.AutoMirrored.Rounded.HelpOutline
    else -> Icons.Rounded.HourglassTop
}

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