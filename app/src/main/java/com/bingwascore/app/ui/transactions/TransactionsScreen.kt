package com.bingwascore.app.ui.transactions

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.FileDownload
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.unit.IntOffset
import com.bingwascore.app.ui.theme.Raised
import kotlin.math.roundToInt
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
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
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.SecondaryButton
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.SelectTint
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.launch

/**
 * REBRAND R3 — Transactions.
 *
 * The list is the product: sticky day headers, pull-to-refresh, and a long-press
 * that turns the whole screen into a multi-select surface — Telegram style.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(
    initialFilter: TransactionFilter = TransactionFilter.ALL,
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    val scope = rememberCoroutineScope()

    val transactions by viewModel.transactions.collectAsStateWithLifecycle()
    val selectedFilter by viewModel.filter.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val selectedIds by viewModel.selectedIds.collectAsStateWithLifecycle()
    val hasSelection by viewModel.hasSelection.collectAsStateWithLifecycle()

    var selectedTransaction by remember { mutableStateOf<Transaction?>(null) }
    // R4 — "View all from this number" prefills the list search.
    var phoneFilter by remember { mutableStateOf<String?>(null) }
    var isRefreshing by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val pullState = rememberPullToRefreshState { isRefreshing }

    val allSelected = transactions.isNotEmpty() && selectedIds.size == transactions.size

    LaunchedEffect(initialFilter) { viewModel.setFilter(initialFilter) }

    LaunchedEffect(Unit) {
        viewModel.events.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(BgBlack)) {
        Column(modifier = Modifier.fillMaxSize().screenEnter()) {
            SelectionTopBar(
                selecting = hasSelection,
                count = selectedIds.size,
                recordCount = transactions.size,
                onExit = {
                    haptics.tick()
                    viewModel.clearSelection()
                },
                onDelete = {
                    haptics.press()
                    viewModel.softDeleteSelected { removed ->
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "${removed.size} transaction(s) deleted",
                                actionLabel = "Undo",
                                duration = SnackbarDuration.Short
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                viewModel.restoreAll(removed)
                            }
                        }
                    }
                },
                onExport = viewModel::exportCsv
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(TransactionFilter.entries.toList()) { filter ->
                    FilterChip(
                        label = filter.label,
                        selected = selectedFilter == filter,
                        onClick = {
                            haptics.tick()
                            viewModel.setFilter(filter)
                            viewModel.pruneSelection()
                        }
                    )
                }
            }
Box(modifier = Modifier.fillMaxSize().nestedScroll(pullState.nestedScrollConnection)) {
                TransactionBody(
                    transactions = remember(transactions, phoneFilter) {
                        if (phoneFilter == null) transactions
                        else transactions.filter { it.phoneNumber == phoneFilter }
                    },
                    phoneFilter = phoneFilter,
                    onClearPhoneFilter = { phoneFilter = null },
                    selectedFilter = selectedFilter,
                    isLoading = isLoading,
                    hasSelection = hasSelection,
                    isSelected = { it.id in selectedIds },
                    onRowClick = { transaction ->
                        if (hasSelection) {
                            haptics.tick()
                            viewModel.toggleSelection(transaction.id)
                        } else {
                            selectedTransaction = transaction
                        }
                    },
                    onRowLongClick = { transaction ->
                        haptics.press()
                        viewModel.toggleSelection(transaction.id)
                    }
                )

                PullToRefreshContainer(
                    state = pullState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        AnimatedVisibility(
            visible = hasSelection,
            enter = fadeIn(tween(Motion.FADE)) + scaleIn(
                animationSpec = spring(dampingRatio = Motion.DAMPING),
                initialScale = 0.94f
            ),
            exit = fadeOut(tween(Motion.FADE)) + scaleOut(
                animationSpec = spring(dampingRatio = Motion.DAMPING),
                targetScale = 0.94f
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            SelectionBottomBar(
                count = selectedIds.size,
                allSelected = allSelected,
                onSelectAll = {
                    haptics.press()
                    viewModel.toggleSelectAll()
                },
                onRetry = {
                    haptics.press()
                    viewModel.retrySelected()
                }
            )
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

    // REBRAND R4 — the focus sheet. The list behind it dims toward black (a
    // focus shift, not a modal veil) and the sheet itself can be dragged down.
    if (selectedTransaction != null) {
        val dim by animateFloatAsState(
            targetValue = 1f,
            animationSpec = tween(180),
            label = "focusDim"
        )
        val sheetOffset = remember { Animatable(0f) }

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BgBlack.copy(alpha = dim * 0.92f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { selectedTransaction = null }
            )

            val sheet = selectedTransaction ?: return@Box
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .offset { IntOffset(0, sheetOffset.value.roundToInt()) }
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Raised)
                    .pointerInput(Unit) {
                        val heightPx = size.height.toFloat()
                        detectVerticalDragGestures(
                            onDragEnd = {
                                scope.launch {
                                    val shouldClose = sheetOffset.value > heightPx * 0.2f
                                    if (shouldClose) {
                                        sheetOffset.animateTo(
                                            heightPx,
                                            spring(dampingRatio = 0.9f, stiffness = 500f)
                                        )
                                        selectedTransaction = null
                                    } else {
                                        sheetOffset.animateTo(
                                            0f,
                                            spring(dampingRatio = 0.6f)
                                        )
                                    }
                                }
                            },
                            onVerticalDrag = { _, dragAmount ->
                                scope.launch {
                                    sheetOffset.snapTo(
                                        (sheetOffset.value + dragAmount).coerceAtLeast(0f)
                                    )
                                }
                            }
                        )
                    }
            ) {
                // Drag handle + header: long-pressing the header also dismisses.
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Hairline)
                    )
                }

                TransactionFocusSheet(
                    transaction = sheet,
                    stats = remember(sheet.id, transactions.size) {
                        clientStatsFor(transactions, sheet.phoneNumber)
                    },
                    onRetry = { viewModel.retry(sheet); selectedTransaction = null },
                    onComplete = { viewModel.complete(sheet); selectedTransaction = null },
                    onSchedule = { viewModel.schedule(sheet); selectedTransaction = null },
                    onDelete = { viewModel.delete(sheet); selectedTransaction = null },
                    onEditUssd = { code -> viewModel.updateUssd(sheet, code) },
                    onViewAllFromNumber = {
                        phoneFilter = sheet.phoneNumber
                        selectedTransaction = null
                    }
                )
            }
        }
    }
}

/** Loading / empty / list, chosen once so the refresh box never reflows. */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TransactionBody(
    transactions: List<Transaction>,
    phoneFilter: String?,
    onClearPhoneFilter: () -> Unit,
    selectedFilter: TransactionFilter,
    isLoading: Boolean,
    hasSelection: Boolean,
    isSelected: (Transaction) -> Boolean,
    onRowClick: (Transaction) -> Unit,
    onRowLongClick: (Transaction) -> Unit
) {
    when {
        isLoading -> TransactionSkeleton()

        transactions.isEmpty() -> EmptyState(
            icon = Icons.AutoMirrored.Rounded.ReceiptLong,
            title = if (selectedFilter == TransactionFilter.ALL) {
                "No transactions yet"
            } else {
                "Nothing in this filter"
            },
            message = if (selectedFilter == TransactionFilter.ALL) {
                "Every bundle you dial gets recorded here — pending, completed, scheduled and failed."
            } else {
                "No ${selectedFilter.label.lowercase(Locale.ROOT)} records yet — try another filter."
            },
            modifier = Modifier.padding(20.dp)
        )

        else -> {
            val grouped = remember(transactions) { groupByDay(transactions) }
            Column(modifier = Modifier.fillMaxSize()) {
                if (phoneFilter != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "$phoneFilter",
                            color = AccentBlue,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            "Clear search",
                            color = TextGrey,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable(onClick = onClearPhoneFilter)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
                LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 8.dp,
                    bottom = if (hasSelection) 104.dp else 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                grouped.forEach { (day, rows) ->
                    stickyHeader(key = "day-$day") { DayHeader(day) }
                    items(rows, key = { it.id }) { transaction ->
                        TransactionRow(
                            transaction = transaction,
                            selecting = hasSelection,
                            selected = isSelected(transaction),
                            onClick = { onRowClick(transaction) },
                            onLongClick = { onRowLongClick(transaction) }
                        )
                    }
                }
                }
            }
        }
    }
}

/**
 * The morphing header.
 *
 * Idle: "Transactions", record count, export. Selecting: the title fades and
 * slides out, an X scales in on the left, a "N Selected" bubble takes the
 * middle and the trash scales in on the right — all on one 220ms spring so the
 * mode never feels like a different screen.
 */
@Composable
private fun SelectionTopBar(
    selecting: Boolean,
    count: Int,
    recordCount: Int,
    onExit: () -> Unit,
    onDelete: () -> Unit,
    onExport: () -> Unit
) {
    val morph by animateFloatAsState(
        targetValue = if (selecting) 1f else 0f,
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 700f),
        label = "topBarMorph"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(
            visible = selecting,
            enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.5f),
            exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.5f)
        ) {
            BarIconButton(Icons.Rounded.Close, "Exit selection", TextWhite, onExit)
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .graphicsLayer {
                    alpha = 1f - morph
                    translationX = -morph * 24f * density
                }
        ) {
            Text(
                "Transactions",
                color = TextWhite,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text("$recordCount record(s)", color = TextGrey, fontSize = 12.sp)
        }

        AnimatedVisibility(
            visible = selecting,
            enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.6f),
            exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.6f)
        ) {
            CountBubble(count = count)
        }

        AnimatedVisibility(
            visible = selecting,
            enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.5f),
            exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.5f)
        ) {
            BarIconButton(Icons.Rounded.Delete, "Delete selected", FailRed, onDelete)
        }

        AnimatedVisibility(
            visible = !selecting,
            enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.8f),
            exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.8f)
        ) {
            TextButton(onClick = onExport) {
                Text("Export", color = AccentBlue, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
private fun BarIconButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    description: String,
    tint: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .size(42.dp)
            .pressScale(interactionSource)
            .clip(CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = description, tint = tint, modifier = Modifier.size(22.dp))
    }
}

/** The "N Selected" pill — it pops when the number changes. */
@Composable
private fun CountBubble(count: Int) {
    var previous by remember { mutableStateOf(count) }
    val pop = remember { androidx.compose.animation.core.Animatable(1f) }
    LaunchedEffect(count) {
        if (count != previous) {
            pop.snapTo(1.15f)
            pop.animateTo(1f, spring(dampingRatio = 0.45f))
        }
        previous = count
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Bubble)
            .graphicsLayer {
                scaleX = pop.value
                scaleY = pop.value
            }
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            "$count Selected",
            color = TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/** The morphing footer: Select All + Retry, only while selecting. */
@Composable
private fun SelectionBottomBar(
    count: Int,
    allSelected: Boolean,
    onSelectAll: () -> Unit,
    onRetry: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgBlack)
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SecondaryButton(
            text = if (allSelected) "Clear All" else "Select All",
            onClick = onSelectAll,
            modifier = Modifier.weight(1f)
        )
        PrimaryButton(
            text = "Retry ($count)",
            onClick = onRetry,
            modifier = Modifier.weight(1f)
        )
    }
}

/** Sticky day separator: Today / Yesterday / an absolute date. */
@Composable
private fun DayHeader(day: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(day, color = TextGrey, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Hairline)
        )
    }
}

@Composable
private fun FilterChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(shape)
            .background(if (selected) AccentBlue else Bubble)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            label,
            color = if (selected) TextWhite else TextGrey,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/** R3 — shimmer only while the list itself is loading. */
@Composable
private fun TransactionSkeleton() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        repeat(6) {
            BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 16.dp) {
                Column {
                    ShimmerBlock(modifier = Modifier.width(140.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    ShimmerBlock(modifier = Modifier.width(90.dp), cornerRadius = 6.dp)
                }
            }
        }
    }
}

/**
 * One transaction row.
 *
 * A tinted 22dp status icon on the left, the customer's name in white semibold
 * with grey meta under it, and the amount in bold white with the coloured status
 * word beneath. While selecting, a check-circle slides in from the left and the
 * row washes with [SelectTint] when ticked.
 */
@Composable
private fun TransactionRow(
    transaction: Transaction,
    selecting: Boolean,
    selected: Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val statusColor = StatusColors.color(transaction.status)
    val checkIn by animateFloatAsState(
        targetValue = if (selecting) 1f else 0f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 700f),
        label = "checkIn"
    )
    val rowFill by animateColorAsState(
        targetValue = if (selected) SelectTint else Bubble,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 700f),
        label = "rowFill"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(rowFill)
            .pointerInput(selecting, selected) {
                detectTapGestures(
                    onTap = { onClick() },
                    onLongPress = { onLongClick() }
                )
            }
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Check-circle slides in from the left while selecting.
        Box(
            modifier = Modifier
                .size(22.dp)
                .graphicsLayer {
                    translationX = -(1f - checkIn) * 30f * density
                    alpha = checkIn
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = null,
                tint = if (selected) TickGreen else TextDim,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            imageVector = StatusColors.icon(transaction.status),
            contentDescription = null,
            tint = statusColor,
            modifier = Modifier.size(22.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                transaction.customerName?.takeIf { it.isNotBlank() }
                    ?: transaction.phoneNumber,
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "${transaction.offerName} · ${relativeTime(transaction.createdAt)}",
                color = TextGrey,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(horizontalAlignment = Alignment.End) {
            Text(
                "Ksh ${money(transaction.amount)}",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                StatusColors.label(transaction.status),
                color = statusColor,
                fontSize = 11.sp
            )
        }
    }
}

private val dayFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault())

/** Groups newest-first rows under Today / Yesterday / absolute date headers. */
private fun groupByDay(rows: List<Transaction>): List<Pair<String, List<Transaction>>> {
    val today = startOfDayMillis(System.currentTimeMillis())
    val yesterday = today - 86_400_000L
    return rows
        .groupBy { tx ->
            val day = startOfDayMillis(tx.createdAt)
            when (day) {
                today -> "Today"
                yesterday -> "Yesterday"
                else -> dayFormat.format(Date(day))
            }
        }
        .toList()
        .sortedByDescending { (_, group) -> group.maxOf { it.createdAt } }
}

private fun startOfDayMillis(millis: Long): Long = Calendar.getInstance().apply {
    timeInMillis = millis
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}.timeInMillis

/** "just now", "12m ago", "3d ago", then an absolute stamp. */
private fun relativeTime(millis: Long): String {
    if (millis <= 0L) return "—"
    val minutes = (System.currentTimeMillis() - millis) / 60_000L
    return when {
        minutes < 1 -> "just now"
        minutes < 60 -> "${minutes}m ago"
        minutes < 1440 -> "${minutes / 60}h ago"
        minutes < 10080 -> "${minutes / 1440}d ago"
        else -> dayFormat.format(Date(millis))
    }
}
