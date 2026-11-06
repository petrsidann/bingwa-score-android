package com.bingwascore.app.ui.transactions

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.background
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material.icons.automirrored.rounded.HelpOutline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Search
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.delay
import androidx.compose.animation.core.Animatable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.LocalPremiumToastManager
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.components.ToastType
import androidx.compose.material3.SnackbarHostState
import kotlin.math.roundToInt
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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
import com.bingwascore.app.ui.components.GlassPill
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.SecondaryButton
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.components.rememberAction
import com.bingwascore.app.ui.showcase.DemoChip
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.SelectTint
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.launch

/**
 * Stage 52 — the PURE Transactions surface: Stripe-dashboard ledger.
 *
 * GlassCard rows, glass filter pills, a glass search bar and tactile status
 * badges. The ViewModel, Hilt wiring and data fetching are untouched — only
 * UI composition changed.
 */
data class TransactionsScreenState(
    val transactions: List<Transaction> = emptyList(),
    val selectedFilter: TransactionFilter = TransactionFilter.ALL,
    val isLoading: Boolean = false,
    val selectedIds: Set<String> = emptySet(),
    val hasSelection: Boolean = false,
    val searchQuery: String = "",
    val searchOpen: Boolean = false,
    val phoneFilter: String? = null,
    val isRefreshing: Boolean = false,
    val focusTransaction: Transaction? = null
)

/** Stage 52 — every Transactions side effect as a plain callback. */
data class TransactionsScreenCallbacks(
    val onQueryChange: (String) -> Unit = {},
    val onOpenSearch: () -> Unit = {},
    val onCloseSearch: () -> Unit = {},
    val onExitSelection: () -> Unit = {},
    val onDeleteSelected: () -> Unit = {},
    val onExport: () -> Unit = {},
    val onFilterSelect: (TransactionFilter) -> Unit = {},
    val onRowClick: (Transaction) -> Unit = {},
    val onRowLongClick: (Transaction) -> Unit = {},
    val onClearPhoneFilter: () -> Unit = {},
    val onSelectAll: () -> Unit = {},
    val onRetrySelected: () -> Unit = {},
    val onFocusDismiss: () -> Unit = {},
    val onFocusRetry: (Transaction) -> Unit = {},
    val onFocusComplete: (Transaction) -> Unit = {},
    val onFocusSchedule: (Transaction) -> Unit = {},
    val onFocusDelete: (Transaction) -> Unit = {},
    val onFocusEditUssd: (Transaction, String) -> Unit = { _, _ -> },
    val onFocusViewAllFromNumber: (Transaction) -> Unit = {}
)

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
    // STAGE 19.7 — the wrapper owns the ViewModel, the Toast and every piece of
    // screen state the content only reads.
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
    // POLISH P3 — the inline search: top-centre icon, title fades, bar springs open.
    var searchQuery by remember { mutableStateOf("") }
    var searchOpen by remember { mutableStateOf(false) }
    var isRefreshing by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val toastManager = LocalPremiumToastManager.current
    val pullState = rememberPullToRefreshState { isRefreshing }

    val allSelected = transactions.isNotEmpty() && selectedIds.size == transactions.size

    LaunchedEffect(initialFilter) { viewModel.setFilter(initialFilter) }

    LaunchedEffect(Unit) {
        viewModel.events.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    val visible = remember(transactions, phoneFilter, searchQuery) {
        val byPhone = if (phoneFilter == null) {
            transactions
        } else {
            transactions.filter { it.phoneNumber == phoneFilter }
        }
        if (searchQuery.isBlank()) {
            byPhone
        } else {
            // POLISH P3 — one field matches name OR phone OR id,
            // because an agent looks a sale up by whichever one
            // they happen to have in front of them.
            byPhone.filter { it.matches(searchQuery) }
        }
    }

    val state = TransactionsScreenState(
        transactions = visible,
        selectedFilter = selectedFilter,
        isLoading = isLoading,
        selectedIds = selectedIds,
        hasSelection = hasSelection,
        searchQuery = searchQuery,
        searchOpen = searchOpen,
        phoneFilter = phoneFilter,
        isRefreshing = isRefreshing,
        focusTransaction = selectedTransaction
    )

    val callbacks = TransactionsScreenCallbacks(
        onQueryChange = { searchQuery = it },
        onOpenSearch = { searchOpen = true },
        onCloseSearch = {
            searchOpen = false
            searchQuery = ""
        },
        onExitSelection = {
            haptics.tick()
            viewModel.clearSelection()
        },
        onDeleteSelected = {
            haptics.press()
            viewModel.softDeleteSelected { removed ->
                scope.launch {
                    toastManager.show(ToastType.Info, "${removed.size} transaction(s) deleted")
                }
            }
        },
        onExport = viewModel::exportCsv,
        onFilterSelect = {
            haptics.tick()
            viewModel.setFilter(it)
            viewModel.pruneSelection()
        },
        onRowClick = { transaction ->
            if (hasSelection) {
                haptics.tick()
                viewModel.toggleSelection(transaction.id)
            } else {
                selectedTransaction = transaction
            }
        },
        onRowLongClick = { transaction ->
            // POLISH P3 — one long-press, one check.
            haptics.press()
            viewModel.beginSelection(transaction.id)
        },
        onClearPhoneFilter = { phoneFilter = null },
        onSelectAll = {
            haptics.press()
            viewModel.toggleSelectAll()
        },
        onRetrySelected = {
            haptics.press()
            viewModel.retrySelected()
        },
        onFocusDismiss = { selectedTransaction = null },
        onFocusRetry = {
            viewModel.retry(it)
            selectedTransaction = null
        },
        onFocusComplete = {
            viewModel.complete(it)
            selectedTransaction = null
        },
        onFocusSchedule = {
            viewModel.schedule(it)
            selectedTransaction = null
        },
        onFocusDelete = {
            viewModel.delete(it)
            selectedTransaction = null
        },
        onFocusEditUssd = { transaction, code -> viewModel.updateUssd(transaction, code) },
        onFocusViewAllFromNumber = { transaction ->
            phoneFilter = transaction.phoneNumber
            selectedTransaction = null
        }
    )

    TransactionsScreenContent(
        state = state,
        callbacks = callbacks,
        allSelected = allSelected,
        pullState = pullState,
        snackbarHostState = snackbarHostState
    )
}

/**
 * Stage 52 — the pure Transactions body: glass header, pill filter row,
 * GlassCard ledger and the selection bar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreenContent(
    state: TransactionsScreenState,
    callbacks: TransactionsScreenCallbacks = TransactionsScreenCallbacks(),
    allSelected: Boolean = false,
    pullState: androidx.compose.material3.pulltorefresh.PullToRefreshState = rememberPullToRefreshState { state.isRefreshing },
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().background(BgBlack)) {
        Column(modifier = Modifier.fillMaxSize().screenEnter()) {
            TransactionsTopBar(
                selecting = state.hasSelection,
                count = state.selectedIds.size,
                recordCount = state.transactions.size,
                query = state.searchQuery,
                onQueryChange = callbacks.onQueryChange,
                onOpenSearch = callbacks.onOpenSearch,
                onCloseSearch = callbacks.onCloseSearch,
                onExit = callbacks.onExitSelection,
                onDelete = callbacks.onDeleteSelected,
                onExport = callbacks.onExport
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = transactionFilterChips,
                    key = { it.name }
                ) { filter ->
                    FilterPill(
                        label = filter.label,
                        selected = state.selectedFilter == filter,
                        onClick = { callbacks.onFilterSelect(filter) }
                    )
                }
            }

                Box(modifier = Modifier.fillMaxSize()) {
                // Stage 22 — the lag sweep: the membership test keeps its
                // identity, so the ledger does not re-run when only the
                // selection changed (and vice versa).
                val selectedIds = state.selectedIds
                val isSelected = remember(selectedIds) { { tx: Transaction -> tx.id in selectedIds } }
                TransactionBody(
                    transactions = state.transactions,
                    searchQuery = state.searchQuery,
                    phoneFilter = state.phoneFilter,
                    onClearPhoneFilter = callbacks.onClearPhoneFilter,
                    selectedFilter = state.selectedFilter,
                    isLoading = state.isLoading,
                    hasSelection = state.hasSelection,
                    isSelected = isSelected,
                    onRowClick = callbacks.onRowClick,
                    onRowLongClick = callbacks.onRowLongClick
                )

                PullToRefreshContainer(
                    state = pullState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        AnimatedVisibility(
            visible = state.hasSelection,
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
            // Stage 22 — the lag sweep: the retry rule is derived ONCE per
            // change, not once per recomposition over the whole ledger.
            val selectedStatuses = remember(state.transactions, state.selectedIds) {
                state.transactions.filter { it.id in state.selectedIds }.map { it.status }
            }
            SelectionBottomBar(
                count = state.selectedIds.size,
                allSelected = allSelected,
                retryEnabled = rulesForSelection(selectedStatuses).canRetry,
                onSelectAll = callbacks.onSelectAll,
                onRetry = callbacks.onRetrySelected
            )
        }
    }

    // REBRAND R4 — the focus sheet. The list behind it dims toward black (a
    // focus shift, not a modal veil) and the sheet itself can be dragged down.
    state.focusTransaction?.let { sheet ->
        val dim by animateFloatAsState(
            targetValue = 1f,
            // U5 — the focus dim rides the same 220ms morph window.
            animationSpec = tween(Motion.MORPH_SPRING_MILLIS),
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
                    ) { callbacks.onFocusDismiss() }
            )

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
                                        callbacks.onFocusDismiss()
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
                    stats = remember(sheet.id, state.transactions.size) {
                        clientStatsFor(state.transactions, sheet.phoneNumber)
                    },
                    onRetry = { callbacks.onFocusRetry(sheet) },
                    onComplete = { callbacks.onFocusComplete(sheet) },
                    onSchedule = { callbacks.onFocusSchedule(sheet) },
                    onDelete = { callbacks.onFocusDelete(sheet) },
                    onEditUssd = { code -> callbacks.onFocusEditUssd(sheet, code) },
                    onViewAllFromNumber = { callbacks.onFocusViewAllFromNumber(sheet) }
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
    searchQuery: String,
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
            title = if (searchQuery.isNotBlank()) "No available records" else {
                if (selectedFilter == TransactionFilter.ALL) {
                    "No transactions yet"
                } else {
                    "Nothing in this filter"
                }
            },
            message = if (searchQuery.isNotBlank()) {
                "No name, phone number or transaction ID matches \"${searchQuery.trim()}\"."
            } else if (selectedFilter == TransactionFilter.ALL) {
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
                            color = DesignTokens.Color.Ink,
                            fontSize = BingwaType.Label,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            "Clear search",
                            color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                            fontSize = DesignTokens.Typography.Caption,
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
                                // Stage 22 — the lag sweep: the row's actions keep
                                // their identity, so a new transaction never re-runs
                                // every visible row.
                                onClick = rememberAction(transaction.id) { onRowClick(transaction) },
                                onLongClick = rememberAction(transaction.id) { onRowLongClick(transaction) }
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
private fun TransactionsTopBar(
    selecting: Boolean,
    count: Int,
    recordCount: Int,
    query: String,
    onQueryChange: (String) -> Unit,
    onOpenSearch: () -> Unit,
    onCloseSearch: () -> Unit,
    onExit: () -> Unit,
    onDelete: () -> Unit,
    onExport: () -> Unit
) {
    var openRequested by remember { mutableStateOf(false) }
    var barOpen by remember { mutableStateOf(false) }
    val titleShiftPx = with(LocalDensity.current) { -16.dp.toPx() }

    val titleAlpha by animateFloatAsState(
        targetValue = if (barOpen) 0f else 1f,
        animationSpec = tween(TITLE_FADE_MILLIS),
        label = "titleFade"
    )
    val barProgress by animateFloatAsState(
        targetValue = if (barOpen) 1f else 0f,
        animationSpec = spring(dampingRatio = 0.85f, stiffness = 500f),
        label = "searchBarSpring"
    )

    // Fade first, then grow — the title is gone before the bar moves.
    LaunchedEffect(openRequested) {
        if (openRequested) {
            delay(TITLE_FADE_MILLIS.toLong())
            barOpen = true
        } else {
            barOpen = false
        }
    }
    // Leaving selection mode closes the search: two modes, one header.
    LaunchedEffect(selecting) {
        if (!selecting && openRequested) {
            openRequested = false
            onCloseSearch()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer { alpha = titleAlpha }
        ) {
            AnimatedVisibility(
                visible = selecting,
                enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.5f),
                exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.5f)
            ) {
                BarIconButton(Icons.Rounded.Close, "Exit selection", DesignTokens.Color.Ink, onExit)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .graphicsLayer {
                        alpha = 1f - titleAlpha
                        translationX = titleAlpha * titleShiftPx
                    }
            ) {
                Text(
                    "Transactions",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Headline,
                    fontWeight = FontWeight.Bold
                )
                Text("$recordCount record(s)", color = DesignTokens.Color.Ink.copy(alpha = 0.6f), fontSize = DesignTokens.Typography.Caption)
            }

            AnimatedVisibility(
                visible = !selecting,
                enter = fadeIn(tween(Motion.FADE)),
                exit = fadeOut(tween(Motion.FADE))
            ) {
                Box(
                    modifier = Modifier.size(42.dp),
                    contentAlignment = Alignment.Center
                ) {
                    BarIconButton(
                        Icons.Rounded.Search,
                        "Search transactions",
                        DesignTokens.Color.Ink,
                        onClick = { openRequested = true }
                    )
                }
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
                BarIconButton(Icons.Rounded.Delete, "Delete selected", DesignTokens.Color.Brand.Error, onDelete)
            }

            AnimatedVisibility(
                visible = !selecting,
                enter = fadeIn(tween(Motion.FADE)) + scaleIn(initialScale = 0.8f),
                exit = fadeOut(tween(Motion.FADE)) + scaleOut(targetScale = 0.8f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    DemoChip()
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = onExport) {
                        Text(
                            "Export",
                            color = DesignTokens.Color.Brand.Primary,
                            fontSize = BingwaType.Label,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        GlassSearchBar(
            query = query,
            progress = barProgress,
            onQueryChange = onQueryChange,
            onClose = {
                openRequested = false
                onCloseSearch()
            }
        )
    }
}

/** POLISH P3 — how long the title takes to fade before the bar grows. */
// U5 — the title fade and the bar expansion share the 200–260ms morph window, so
// opening search reads as one connected motion instead of a fade into a jump.
private const val TITLE_FADE_MILLIS = Motion.MORPH_SPRING_MILLIS

/**
 * Stage 52 — the glass search field: Obsidian card at 0.8 alpha with a 12dp
 * backdrop blur, a 1dp Brand.Primary border and a soft glow on focus.
 */
@Composable
private fun GlassSearchBar(
    query: String,
    progress: Float,
    onQueryChange: (String) -> Unit,
    onClose: () -> Unit
) {
    val shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
    val glowRadius = with(LocalDensity.current) { DesignTokens.Shape.RadiusMd.toPx() }
    val focusRequester = remember { FocusRequester() }
    var focused by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(progress.coerceIn(0.001f, 1f))
            .clip(shape)
            .background(DesignTokens.Color.Obsidian.Card.copy(alpha = 0.8f))
            .blur(12.dp)
            .border(
                if (focused) 1.dp else 0.dp,
                DesignTokens.Color.Brand.Primary,
                shape
            )
            .drawBehind {
                if (focused) {
                    drawRoundRect(
                        brush = SolidColor(DesignTokens.Color.Brand.Primary.copy(alpha = 0.18f)),
                        cornerRadius = CornerRadius(glowRadius, glowRadius)
                    )
                }
            }
            .height(42.dp)
            .padding(start = 12.dp, end = 4.dp)
            .onFocusChanged { focused = it.isFocused }
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = null,
            tint = if (focused) DesignTokens.Color.Brand.Primary else DesignTokens.Color.Ink,
            modifier = Modifier.size(17.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.weight(1f)) {
            if (query.isEmpty()) {
                Text(
                    "Name, phone or transaction ID",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Body,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = TextStyle(color = DesignTokens.Color.Ink, fontSize = 14.sp),
                cursorBrush = SolidColor(DesignTokens.Color.Brand.Primary),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            )
        }
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .clickable(onClick = onClose),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Cancel search",
                tint = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                modifier = Modifier.size(18.dp)
            )
        }
    }

    // The keyboard arrives with the bar, not before it.
    LaunchedEffect(progress) {
        if (progress > 0.99f) runCatching { focusRequester.requestFocus() }
    }
}

/**
 * POLISH P3 — one search box, three kinds of answer: a customer's name, the
 * number they paid from, or the transaction id Safaricom quoted. An agent looks
 * a sale up by whichever of the three they happen to have in front of them.
 */
internal fun Transaction.matches(query: String): Boolean {
    val needle = query.trim().lowercase(Locale.ROOT)
    if (needle.isEmpty()) return true
    return customerName?.lowercase(Locale.ROOT)?.contains(needle) == true ||
        phoneNumber.lowercase(Locale.ROOT).contains(needle) ||
        id.lowercase(Locale.ROOT).contains(needle)
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
    val pop = remember { Animatable(1f) }
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
            color = DesignTokens.Color.Ink,
            fontSize = DesignTokens.Typography.Caption,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * The morphing footer: Select All + Retry, only while selecting.
 *
 * U5 — the batch Retry follows the same rule as the sheet: if any selected row is
 * already SUCCESSFUL (or otherwise not retryable) the batch action is disabled, so
 * one completed sale in the selection can never be re-dialed.
 */
@Composable
private fun SelectionBottomBar(
    count: Int,
    allSelected: Boolean,
    retryEnabled: Boolean,
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
            enabled = retryEnabled,
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
        Text(day, color = DesignTokens.Color.Ink.copy(alpha = 0.6f), fontSize = DesignTokens.Typography.Caption, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Hairline)
        )
    }
}

/** Stage 52 — glass filter pill: active reads Brand.Primary on Ink, inactive is transparent. */
@Composable
private fun FilterPill(label: String, selected: Boolean, onClick: () -> Unit) {
    GlassPill(
        fill = if (selected) DesignTokens.Color.Brand.Primary else Color.Transparent,
        pressScale = 1.05f,
        onClick = onClick
    ) {
        Text(
            label,
            color = if (selected) DesignTokens.Color.Ink else DesignTokens.Color.Obsidian.Ink.copy(alpha = 0.6f),
            fontSize = BingwaType.Label,
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

/** Stage 52 — one fixed row height, so ticking never reflows the list. */
private val ROW_HEIGHT = 88.dp

/** U3 — the row's leading status avatar. 40dp fits the premium row. */
private val ROW_AVATAR = 40.dp

/** Stage 52 — the 200ms spring behind the tick morph. */
private val MORPH_SPRING = spring<Float>(dampingRatio = 0.78f, stiffness = 900f)

/** The same spring for the row wash, which animates a colour rather than a float. */
private val MORPH_SPRING_COLOR =
    spring<androidx.compose.ui.graphics.Color>(dampingRatio = 0.78f, stiffness = 900f)

/**
 * Stage 52 — one transaction row. A GlassCard with a glowing status avatar:
 *
 * - Success: green circle with a checkmark and a soft green glow
 * - Failed: red circle with an X and a soft red glow
 * - Queued: blue circle with a clock, pulsing 1.0f -> 1.1f forever
 *
 * Amounts render in Headline: Success green for positive amounts, Error red for
 * failed or negative amounts.
 */
@Composable
private fun TransactionRow(
    transaction: Transaction,
    selecting: Boolean,
    selected: Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val status = transaction.status
    val isFailed = status == TransactionStatus.FAILED.value || status == TransactionStatus.FAILED_ALREADY_RECOMMENDED.value
    val isQueued = status == TransactionStatus.PENDING.value || status == TransactionStatus.PROCESSING.value
    val statusColor = when {
        status == TransactionStatus.SUCCESSFUL.value -> DesignTokens.Color.Brand.Success
        isFailed -> DesignTokens.Color.Brand.Error
        isQueued || status == TransactionStatus.SCHEDULED.value -> DesignTokens.Color.Brand.Primary
        else -> DesignTokens.Color.Ink.copy(alpha = 0.5f)
    }
    val statusIcon = when {
        status == TransactionStatus.SUCCESSFUL.value -> Icons.Rounded.CheckCircle
        isFailed -> Icons.Rounded.Close
        isQueued || status == TransactionStatus.SCHEDULED.value -> Icons.Rounded.HourglassTop
        else -> Icons.AutoMirrored.Rounded.HelpOutline
    }

    val checkIn by animateFloatAsState(
        targetValue = if (selecting) 1f else 0f,
        animationSpec = MORPH_SPRING,
        label = "checkIn"
    )
    val tick by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = MORPH_SPRING,
        label = "tickMorph"
    )
    val rowFill by animateColorAsState(
        targetValue = if (selected) SelectTint else Bubble,
        animationSpec = MORPH_SPRING_COLOR,
        label = "rowFill"
    )

    val amountColor = if (isFailed || transaction.amount < 0) DesignTokens.Color.Brand.Error else DesignTokens.Color.Brand.Success

    val pulseTarget = if (isQueued) 1.1f else 1f
    val pulse by animateFloatAsState(
        targetValue = pulseTarget,
            animationSpec =             repeatable(
                animation = tween(DesignTokens.Motion.DurationNormal.toInt()),
            repeatMode = RepeatMode.Reverse,
            iterations = Int.MAX_VALUE
        ),
        label = "TransactionRowPulse"
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressAnim by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "TransactionRowPress"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ROW_HEIGHT)
            .graphicsLayer { scaleX = pressAnim; scaleY = pressAnim }
            .combinedClickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
                onLongClick = onLongClick
            ),
        contentAlignment = Alignment.Center
    ) {
        GlassCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.fillMaxSize().background(rowFill)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Fixed-size slot: the tick slides and scales inside it.
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer {
                                alpha = checkIn
                                scaleX = 0.6f + 0.4f * tick
                                scaleY = 0.6f + 0.4f * tick
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = null,
                            tint = DesignTokens.Color.Brand.Success,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    // Glowing status avatar: a soft status-coloured disc behind a solid disc.
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(statusColor.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(ROW_AVATAR)
                                .clip(CircleShape)
                                .background(statusColor)
                                .graphicsLayer { scaleX = pulse; scaleY = pulse }
                        ) {
                            Icon(
                                imageVector = statusIcon,
                                contentDescription = null,
                                tint = DesignTokens.Color.Ink,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            formatCustomerName(transaction.customerName).ifBlank { transaction.phoneNumber },
                            color = DesignTokens.Color.Ink,
                            fontSize = BingwaType.Label,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            "${transaction.offerName} · ${relativeTime(transaction.createdAt)}",
                            color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                            fontSize = DesignTokens.Typography.Caption,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            "Ksh ${money(transaction.amount)}",
                            color = amountColor,
                            fontSize = DesignTokens.Typography.Headline,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            StatusColors.label(transaction.status),
                            color = statusColor,
                            fontSize = DesignTokens.Typography.Caption
                        )
                    }
                }
            }
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
