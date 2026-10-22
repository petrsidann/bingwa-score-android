package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.DarkSnackbarHost
import com.bingwascore.app.ui.components.StatusDot
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.statusWash
import com.bingwascore.app.util.Haptics
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.rememberHaptics
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Masked money placeholder — six stars, never a half-drawn digit. */
private const val MASK = "******"

/**
 * Stage 22 — the clock bucket: the relative labels only need half-minute
 * resolution, and bucketing keeps every row's timestamp stable between
 * frames (so a row skips instead of recomposing for a label that did not move).
 */
private const val CLOCK_BUCKET_MILLIS = 30_000L

/**
 * U3 — the compact Home activity row. 44dp is ~30% shorter than the old padded
 * row: the numbers are the interface, and a home feed that shows four rows
 * instead of three is a better feed.
 */
private val HOME_ROW_HEIGHT = 44.dp

/**
 * Stage 19.7 — the PURE Home surface.
 *
 * Everything the screen renders comes from here: no ViewModel, no Activity, no
 * lifecycle. The wrapper ([HomeScreen]) collects the state and hands it over, so
 * a snapshot test can render the exact Home an agent sees with fake numbers.
 */
data class HomeScreenState(
    val greetingBucket: Greetings.Bucket = Greetings.Bucket.MORNING,
    val greetingLanguage: Greetings.Language = Greetings.Language.SWAHILI,
    val creditsLabel: String = "0",
    val successful: Int = 0,
    val failed: Int = 0,
    val pending: Int = 0,
    val commission: List<Double> = List(7) { 0.0 },
    val airtimeToday: Double = 0.0,
    val balance: Double? = null,
    val balanceLoading: Boolean = false,
    val balanceError: String? = null,
    val statsLoading: Boolean = false,
    val engineState: EngineState = EngineState.RUNNING,
    val transactions: List<Transaction> = emptyList(),
    val permissionsMissing: Boolean = false,
    val valuesVisible: Boolean = false
)

/**
 * Stage 19.7 — every side effect Home can fire, as a plain callback.
 *
 * The pure content never reaches for a ViewModel or a system dialog: it asks.
 */
data class HomeScreenCallbacks(
    val onOpenTransactions: (String?) -> Unit = {},
    val onOpenMyPlan: () -> Unit = {},
    val onOpenDiplomatics: () -> Unit = {},
    val onRequestPermissions: () -> Unit = {},
    val onPermissionNotNow: () -> Unit = {},
    val onRefreshBalance: () -> Unit = {},
    val onToggleValues: () -> Unit = {},
    val onOpenDiagnostics: () -> Unit = {},
    val onOpenAutopilotSheet: () -> Unit = {},
    val onAutopilotPause: () -> Unit = {}
)

/**
 * REBRAND R2 — Home, rebuilt as a trading terminal.
 *
 * Reading order is deliberate and flat: three counters you can drill into, one
 * live commission chart, one money row (airtime spent / balance, masked until you
 * ask), then the FULL transaction list down to the oldest row. No hero image, no
 * rings, no confetti — the numbers are the interface.
 */
@Composable
fun HomeScreen(
    onOpenTransactions: (statusFilter: String?) -> Unit = {},
    onOpenMyPlan: () -> Unit = {},
    onOpenDiplomatics: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    // STAGE 19.7 — the wrapper owns every platform binding: the ViewModel, the
    // Activity context, the lifecycle and the permission launcher. The content
    // below sees plain state and plain callbacks.
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val haptics = rememberHaptics()

    val successful by viewModel.successfulCount.collectAsStateWithLifecycle()
    val failed by viewModel.failedCount.collectAsStateWithLifecycle()
    val pending by viewModel.pendingCount.collectAsStateWithLifecycle()
    val commission by viewModel.weeklyCommissionByDay.collectAsStateWithLifecycle()
    val airtimeToday by viewModel.airtimeUsedToday.collectAsStateWithLifecycle()
    val balance by viewModel.balance.collectAsStateWithLifecycle()
    val balanceLoading by viewModel.balanceLoading.collectAsStateWithLifecycle()
    val balanceError by viewModel.balanceError.collectAsStateWithLifecycle()
    val statsLoading by viewModel.statsLoading.collectAsStateWithLifecycle()
    val engineState by viewModel.engineState.collectAsStateWithLifecycle()
    val transactions by viewModel.allTransactions.collectAsStateWithLifecycle()

    // POLISH P2 — greeting, credits and the two Home sheets.
    val greeting by viewModel.greeting.collectAsStateWithLifecycle()
    val creditsLabel by viewModel.creditsLabel.collectAsStateWithLifecycle()
    var showAutopilot by remember { mutableStateOf(false) }
    var showDiagnostics by remember { mutableStateOf(false) }

    var valuesVisible by remember { mutableStateOf(false) }
    var permissionsMissing by remember { mutableStateOf(missingPermissions(context)) }

    val snackbarHostState = remember { SnackbarHostState() }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        permissionsMissing = missingPermissions(context)
        viewModel.refreshBalance()
    }

    // POLISH P1 — the balance never raises a dialog. It explains itself once, in
    // a dark bubble, and then it leaves the number alone.
    LaunchedEffect(balanceError) {
        val message = balanceError ?: return@LaunchedEffect
        snackbarHostState.showSnackbar(message = message, duration = SnackbarDuration.Short)
        viewModel.consumeBalanceError()
    }

    LaunchedEffect(Unit) {
        permissionsMissing = missingPermissions(context)
        viewModel.refreshBalance()
    }

    // POLISH P2 — when a sale lands while the agent is watching, the status dot
    // lights with its 300ms fade and a single haptic tick: completion is *felt*,
    // not just read. One tick per completed transaction, never a burst.
    var celebratedCount by remember { mutableIntStateOf(successful) }
    LaunchedEffect(successful) {
        if (successful > celebratedCount) haptics.success()
        celebratedCount = successful
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                permissionsMissing = missingPermissions(context)
                viewModel.onForeground()
                // POLISH P2 — the greeting follows the clock across a long shift.
                viewModel.refreshGreeting()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    val state = HomeScreenState(
        greetingBucket = greeting.first,
        greetingLanguage = greeting.second,
        creditsLabel = creditsLabel,
        successful = successful,
        failed = failed,
        pending = pending,
        commission = commission,
        airtimeToday = airtimeToday,
        balance = balance,
        balanceLoading = balanceLoading,
        balanceError = balanceError,
        statsLoading = statsLoading,
        engineState = engineState,
        transactions = transactions,
        permissionsMissing = permissionsMissing,
        valuesVisible = valuesVisible
    )

    val callbacks = HomeScreenCallbacks(
        onOpenTransactions = onOpenTransactions,
        onOpenMyPlan = onOpenMyPlan,
        onOpenDiplomatics = onOpenDiplomatics,
        onRequestPermissions = { permissionLauncher.launch(REQUIRED_PERMISSION_ARRAY) },
        onPermissionNotNow = { permissionsMissing = false },
        onRefreshBalance = {
            permissionsMissing = missingPermissions(context)
            viewModel.refreshBalance()
        },
        onToggleValues = { valuesVisible = !valuesVisible },
        onOpenDiagnostics = { showDiagnostics = true },
        onOpenAutopilotSheet = { showAutopilot = true },
        onAutopilotPause = { viewModel.pauseEngine() }
    )

    HomeScreenContent(state = state, callbacks = callbacks, snackbarHostState = snackbarHostState)

    // The two Home surfaces that need a live platform context stay in the
    // wrapper: the diagnostics dialog reads the device, the sheet drives the
    // engine.
    if (showDiagnostics) {
        EngineDiagnosticsDialog(onDismiss = { showDiagnostics = false })
    }

    if (showAutopilot) {
        AutopilotSheet(
            engineState = engineState,
            onDismiss = { showAutopilot = false },
            onStart = {
                showAutopilot = false
                viewModel.startEngine()
            },
            onPause = {
                showAutopilot = false
                viewModel.pauseEngine()
            },
            onResume = {
                showAutopilot = false
                viewModel.resumeEngine()
            },
            onStop = {
                showAutopilot = false
                viewModel.stopEngine()
            }
        )
    }
}

/**
 * Stage 19.7 — the pure Home body.
 *
 * No ViewModel, no Activity, no lifecycle: given a [HomeScreenState] and a
 * [HomeScreenCallbacks] this renders the whole screen, which is exactly what a
 * snapshot test needs to see.
 */
@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    callbacks: HomeScreenCallbacks = HomeScreenCallbacks(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    haptics: Haptics = rememberHaptics()
) {
    // The credits bubble is the door to My Plan: one tap, one destination.
    val onOpenMyPlan = callbacks.onOpenMyPlan

    // Stage 22 — the lag sweep: ONE clock read per frame, bucketed to the half
    // minute so the rows only recompose when a label would really change.
    //
    // The rows used to read the wall clock each, so a 200-row feed did 200
    // clock reads (and 200 date formats) on every recomposition.
    val now = (System.currentTimeMillis() / CLOCK_BUCKET_MILLIS) * CLOCK_BUCKET_MILLIS

    // Stage 22 — capture only what the rows need.
    //
    // The item lambda used to close over the whole [HomeScreenState] (an
    // unstable object: it holds a list), so ANY state change re-ran every
    // visible row. The rows only care about the engine state, so that is all
    // the lambda captures now — and a row skips when it does not change.
    val engineState = state.engineState

    Box(modifier = Modifier.fillMaxSize().background(BgBlack)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            // POLISH P2 — tighter everywhere: the old 14dp rhythm plus 30sp
            // numerals pushed the first real row below the fold on a 5" phone.
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                HomeTopBar(
                    bucket = state.greetingBucket,
                    language = state.greetingLanguage,
                    creditsLabel = state.creditsLabel,
                    onCreditsClick = onOpenMyPlan
                )
            }

            item {
                // Stage 19 — Home has zero score UI; autopilot pill owns this slot.
                AutopilotPill(
                    engineState = state.engineState,
                    onOpenSheet = callbacks.onOpenAutopilotSheet,
                    onPause = callbacks.onAutopilotPause
                )
            }

            item {
                // Stage 12/15 — the language label opens Diplomatics (rotation,
                // pinning, cadence); it is a door, not decoration.
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = state.greetingLanguage.endonym,
                        color = TextDim,
                        fontSize = 11.sp,
                        modifier = Modifier.clickable {
                            haptics.tick()
                            callbacks.onOpenDiplomatics()
                        }
                    )
                }
            }

            if (state.permissionsMissing) {
                item {
                    PermissionCard {
                        haptics.press()
                        callbacks.onRequestPermissions()
                    }
                }
            }

            item {
                CountersRow(
                    completed = state.successful,
                    failed = state.failed,
                    pending = state.pending,
                    onOpenTransactions = callbacks.onOpenTransactions
                )
            }

            item { CommissionChartCard(series = state.commission) }

            item {
                MoneyRow(
                    airtimeToday = state.airtimeToday,
                    balance = state.balance,
                    loading = state.balanceLoading,
                    valuesVisible = state.valuesVisible,
                    onToggleVisibility = {
                        haptics.tick()
                        callbacks.onToggleValues()
                    },
                    onRefresh = {
                        haptics.tick()
                        callbacks.onRefreshBalance()
                    },
                    onOpenDiagnostics = callbacks.onOpenDiagnostics
                )
            }

            item { SectionHeader("Transactions", "${state.transactions.size} total") }

            // R6 — shimmer ONLY where a list is actually loading.
            if (state.statsLoading) {
                items(4) { HomeRowSkeleton() }
            } else if (state.transactions.isEmpty()) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            when (state.engineState) {
                                EngineState.STOPPED ->
                                    "Autopilot stopped — history lives in Transactions."
                                else -> "Nothing yet — every bundle you dial lands here."
                            },
                            color = TextGrey,
                            fontSize = 12.sp,
                            modifier = Modifier.weight(1f)
                        )
                        if (state.engineState == EngineState.STOPPED) {
                            Text(
                                "Start",
                                color = AccentBlue,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable {
                                    callbacks.onOpenAutopilotSheet()
                                }
                            )
                        }
                    }
                }
            } else {
                items(state.transactions, key = { it.id }) { tx ->
                    HomeTransactionRow(tx = tx, engineState = engineState, now = now)
                }
            }
        }

        DarkSnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

    // POLISH P1 — permissions are requested behind a themed prompt instead of
    // ambushing the agent with a system sheet they did not ask for.
    if (state.permissionsMissing) {
        PhoneAccessPrompt(
            onGrant = {
                haptics.press()
                callbacks.onRequestPermissions()
            },
            onNotNow = callbacks.onPermissionNotNow
        )
    }
}

/** Three counters. Each one is a door: tap it to open Transactions filtered. */
@Composable
private fun CountersRow(
    completed: Int,
    failed: Int,
    pending: Int,
    onOpenTransactions: (String?) -> Unit
) {
    val haptics = rememberHaptics()
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CounterTile(completed, "Done", StatusColors.Success, lit = completed > 0, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("SUCCESSFUL")
        }
        CounterTile(failed, "Failed", StatusColors.Failed, lit = failed > 0, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("FAILED")
        }
        CounterTile(pending, "Queued", StatusColors.Pending, lit = false, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("PENDING")
        }
    }
}

/**
 * POLISH P2 — one compact status tile.
 *
 * Roughly 40% shorter than the old 30sp card: the number sits beside its label
 * instead of above it, and the card wears a **wash** of its own status colour
 * (12% alpha) so the row reads at a glance instead of being three dead grey
 * rectangles. The dot is lit only when there is something to report — a queued
 * tile is a light that is deliberately off, not a zero that looks like failure.
 */
@Composable
private fun CounterTile(
    value: Int,
    label: String,
    accent: Color,
    lit: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(16.dp)
    Box(
        modifier = modifier
            .clip(shape)
            .background(statusWash(accent))
            .border(1.dp, accent.copy(alpha = 0.22f), shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                StatusDot(color = accent, lit = lit, size = 8.dp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "$value",
                    color = TextWhite,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Text(label, color = TextGrey, fontSize = 11.sp, maxLines = 1)
        }
    }
}

@Composable
private fun PermissionCard(onGrant: () -> Unit) {
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 18.dp, onClick = onGrant) {
        Text(
            "Phone permission needed",
            color = TextWhite,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Grant call and phone access so dial and balance can work. Tap to grant.",
            color = TextGrey,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun SectionHeader(title: String, trailing: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = TextWhite, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Text(trailing, color = TextDim, fontSize = 12.sp)
    }
}

/**
 * The money row: labels + values on the left, eye + refresh on the right — one
 * medium row (U3), not the old two-cell card with a divider and a second button
 * strip. Two compact label/value lines read faster than a side-by-side split and
 * the card stops being the tallest thing on Home.
 *
 * Both values stay masked behind six stars until the eye opens, so the row can
 * sit on a shop counter without leaking numbers. The refresh button spins for as
 * long as the USSD read is in flight.
 */
@Composable
private fun MoneyRow(
    airtimeToday: Double,
    balance: Double?,
    loading: Boolean,
    valuesVisible: Boolean,
    onToggleVisibility: () -> Unit,
    onRefresh: () -> Unit,
    onOpenDiagnostics: () -> Unit
) {
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 20.dp) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                MoneyLine(
                    label = "Airtime used today",
                    value = if (valuesVisible) "Ksh ${money(airtimeToday)}" else MASK
                )
                Spacer(modifier = Modifier.height(6.dp))
                // E1 — NEVER a fake number: null balance shows unavailable + link.
                if (balance == null && valuesVisible) {
                    MoneyLine(label = "Current balance", value = "Unavailable")
                    Text(
                        "run Diagnostics",
                        color = AccentBlue, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable(onClick = onOpenDiagnostics)
                    )
                } else {
                    MoneyLine(
                        label = "Current balance",
                        value = if (valuesVisible) "Ksh ${money(balance ?: 0.0)}" else MASK
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onToggleVisibility),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (valuesVisible) Icons.Rounded.VisibilityOff
                    else Icons.Rounded.Visibility,
                    contentDescription = if (valuesVisible) "Hide amounts" else "Show amounts",
                    tint = TextGrey,
                    modifier = Modifier.size(19.dp)
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            RefreshButton(loading = loading, onClick = onRefresh)
        }
    }
}

/** U3 — one label/value line inside the single money row. */
@Composable
private fun MoneyLine(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            color = TextGrey,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            value,
            color = TextWhite,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}

/** Circular refresh that spins only while the balance read is in flight. Stage 21 — no always-on loop: static when idle. */
@Composable
private fun RefreshButton(loading: Boolean, onClick: () -> Unit) {
    // Gated spin: one-shot rotation while loading, static icon when idle.
    val spin = remember { Animatable(0f) }
    LaunchedEffect(loading) {
        if (loading) {
            spin.animateTo(360f, animationSpec = tween(900, easing = LinearEasing))
            spin.snapTo(0f)
        } else {
            spin.snapTo(0f)
        }
    }
    val angle = if (loading) spin.value else 0f

    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(BgBlack)
            .border(1.dp, Hairline, CircleShape)
            .clickable(enabled = !loading, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = "Refresh balance",
            tint = if (loading) AccentBlue else TextGrey,
            modifier = Modifier
                .size(18.dp)
                .graphicsLayer { rotationZ = angle }
        )
    }
}


/**
 * One activity row: status dot, who, how much, when — plus a "Paused" badge when
 * the row is still queued and the engine is paused (U2: money accepted, not yet
 * dialed). The badge is deliberately inline with the amount so the reason the row
 * has not moved is never more than a glance away.
 */
@Composable
private fun HomeTransactionRow(
    tx: Transaction,
    engineState: EngineState = EngineState.RUNNING,
    now: Long = System.currentTimeMillis()
) {
    val statusColor = StatusColors.color(tx.status)
    val showPausedBadge = engineState == EngineState.PAUSED &&
        tx.status == TransactionStatus.PENDING.value
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 14.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(HOME_ROW_HEIGHT)
                .padding(horizontal = 12.dp)
        ) {
            // POLISH P2 — the same status dot the tiles use: lit for a finished
            // sale, dim for queued work, red for a failure. It lights with a
            // 300ms fade as the engine closes the row.
            StatusDot(
                color = statusColor,
                lit = tx.status == TransactionStatus.SUCCESSFUL.value ||
                    StatusColors.isFailure(tx.status),
                size = 9.dp
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    // U5 — the same formatter as the Transactions list.
                    formatCustomerName(tx.customerName).ifBlank { tx.phoneNumber },
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "${tx.offerName} · ${timeAgo(tx.createdAt, now)}",
                    color = TextGrey,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (showPausedBadge) {
                Text(
                    "Paused",
                    color = TextGrey,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(TextDim.copy(alpha = 0.20f))
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                "Ksh ${money(tx.amount)}",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/** R6 — a single shimmering placeholder row; only shown while the list loads. */
@Composable
private fun HomeRowSkeleton() {
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 16.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            com.bingwascore.app.ui.components.ShimmerBlock(
                modifier = Modifier.width(90.dp),
                cornerRadius = 8.dp
            )
            Spacer(modifier = Modifier.width(12.dp))
            com.bingwascore.app.ui.components.ShimmerBlock(
                modifier = Modifier.weight(1f),
                cornerRadius = 8.dp
            )
        }
    }
}

private val timeFormat = SimpleDateFormat("d MMM, HH:mm", Locale.getDefault())

/**
 * "just now", "12m ago", "3d ago", then an absolute stamp.
 *
 * Stage 22 — [now] is passed IN: the row never reads the clock itself, so a
 * long feed costs one clock read per frame instead of one per row.
 */
private fun timeAgo(millis: Long, now: Long = System.currentTimeMillis()): String {
    if (millis <= 0L) return "—"
    val minutes = (now - millis) / 60_000L
    return when {
        minutes < 1 -> "just now"
        minutes < 60 -> "${minutes}m ago"
        minutes < 1440 -> "${minutes / 60}h ago"
        minutes < 10080 -> "${minutes / 1440}d ago"
        else -> timeFormat.format(Date(millis))
    }
}

/** Scales the series to 0..1 so the chart springs instead of jumping. */
internal fun normalize(series: List<Double>): List<Float> {
    val padded = (series + List((7 - series.size).coerceAtLeast(0)) { 0.0 }).take(7)
    val max = padded.maxOrNull() ?: 0.0
    if (max <= 0.0) return padded.map { 0f }
    return padded.map { (it / max).toFloat() }
}

/** Axis label: 1,200 / 45 — short enough for a 40dp gutter. */
internal fun formatShort(value: Double): String = when {
    value >= 1000 -> String.format(Locale.US, "%,.0f", value)
    value >= 10 -> String.format(Locale.US, "%.0f", value)
    else -> String.format(Locale.US, "%.1f", value)
}

/** "1,234.56" — always two decimals, no locale surprises. */
internal fun money(value: Double): String = String.format(Locale.US, "%,.2f", value)

/** Permissions the dial + balance paths genuinely need. */
private fun missingPermissions(context: Context): Boolean =
    REQUIRED_PERMISSIONS.any {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }

private val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.CALL_PHONE,
    Manifest.permission.READ_PHONE_STATE
)

/** The exact array handed to the system prompt — never a subset. */
private val REQUIRED_PERMISSION_ARRAY = REQUIRED_PERMISSIONS

/**
 * POLISH P1 — the themed pre-flight for phone access.
 *
 * `*144#` and every silent dial need `CALL_PHONE` + `READ_PHONE_STATE`. Throwing
 * a system sheet at an agent who only opened the app trains them to tap Deny, so
 * the app says what the grant is *for* first, in the same black-and-blue
 * vocabulary as the rest of the product, and keeps a polite way out.
 */
@Composable
private fun PhoneAccessPrompt(onGrant: () -> Unit, onNotNow: () -> Unit) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onNotNow,
        containerColor = BgBlack,
        titleContentColor = TextWhite,
        textContentColor = TextGrey,
        title = {
            Text(
                "Allow phone access?",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
        },
        text = {
            Text(
                "Bingwa Score needs Call and Phone state to read your airtime balance " +
                    "and dial bundles in the background. Nothing is ever shown to " +
                    "the customer.",
                color = TextGrey,
                fontSize = 13.sp
            )
        },
        confirmButton = {
            androidx.compose.material3.TextButton(onClick = onGrant) {
                Text("Allow", color = AccentBlue, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            androidx.compose.material3.TextButton(onClick = onNotNow) {
                Text("Not now", color = TextGrey)
            }
        }
    )
}
