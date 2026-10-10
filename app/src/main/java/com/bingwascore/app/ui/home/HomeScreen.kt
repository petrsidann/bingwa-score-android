package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
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
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.DarkSnackbarHost
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.ui.components.StatusDot
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.ChartBlue
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.statusWash
import com.bingwascore.app.util.rememberHaptics
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
/** Masked money placeholder — six stars, never a half-drawn digit. */
private const val MASK = "******"

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
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
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
    val credits by viewModel.credits.collectAsStateWithLifecycle()
    val creditRows by viewModel.creditRows.collectAsStateWithLifecycle()
    var showCredits by remember { mutableStateOf(false) }
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

    // POLISH P1 — coming back to Home is the moment the number must be true, so
    // the silent *144# runs again on every ON_RESUME (the 30-minute worker covers
    // the stretches where the agent is elsewhere).
    // POLISH P2 — when a sale lands while the agent is watching, the status dot
    // lights with its 300ms fade and a single haptic tick: completion is *felt*,
    // not just read. One tick per completed transaction, never a burst.
    var celebratedCount by remember { mutableIntStateOf(successful) }
    LaunchedEffect(successful) {
        if (successful > celebratedCount) haptics.success()
        celebratedCount = successful
    }

    val lifecycleOwner = LocalLifecycleOwner.current
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

    // POLISH P1 — permissions are requested behind a themed prompt instead of
    // ambushing the agent with a system sheet they did not ask for.
    if (permissionsMissing) {
        PhoneAccessPrompt(
            onGrant = {
                haptics.press()
                permissionLauncher.launch(REQUIRED_PERMISSION_ARRAY)
            },
            onNotNow = { permissionsMissing = false }
        )
    }

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
                    bucket = greeting.first,
                    language = greeting.second,
                    credits = credits,
                    onCreditsClick = { showCredits = true }
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AutopilotPill(
                        engineState = engineState,
                        onOpenSheet = { showAutopilot = true },
                        onPause = { viewModel.pauseEngine() }
                    )
                    Text(
                        text = greeting.second.endonym,
                        color = TextDim,
                        fontSize = 11.sp
                    )
                }
            }

            if (permissionsMissing) {
                item {
                    PermissionCard {
                        haptics.press()
                        permissionLauncher.launch(
                            arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE)
                        )
                    }
                }
            }

            item {
                CountersRow(
                    completed = successful,
                    failed = failed,
                    pending = pending,
                    onOpenTransactions = onOpenTransactions
                )
            }

            item { CommissionChartCard(series = commission) }

            item {
                MoneyRow(
                    airtimeToday = airtimeToday,
                    balance = balance,
                    loading = balanceLoading,
                    valuesVisible = valuesVisible,
                    onToggleVisibility = {
                        haptics.tick()
                        valuesVisible = !valuesVisible
                    },
                    onRefresh = {
                        haptics.tick()
                        permissionsMissing = missingPermissions(context)
                        viewModel.refreshBalance()
                    },
                    onOpenDiagnostics = { showDiagnostics = true }
                )
            }

            item { SectionHeader("Transactions", "${transactions.size} total") }

            // R6 — shimmer ONLY where a list is actually loading.
            if (statsLoading) {
                items(4) { HomeRowSkeleton() }
            } else if (transactions.isEmpty()) {
                item {
                    Text(
                        "Nothing yet — every bundle you dial lands here.",
                        color = TextGrey,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                    )
                }
            } else {
                items(transactions, key = { it.id }) { tx -> HomeTransactionRow(tx) }
            }
        }

        DarkSnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

    // POLISH P2 — the two Home sheets and the Autopilot stop confirmation.
    if (showCredits) {
        CreditsSheet(
            credits = credits,
            rows = creditRows,
            onDismiss = { showCredits = false }
        )
    }

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

/** Sends the agent to this app's system page — the fastest route to permissions. */
private fun openAppSettings(context: Context) {
    runCatching {
        context.startActivity(
            android.content.Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                .setData(android.net.Uri.fromParts("package", context.packageName, null))
                .addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
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
 * "Airtime used today" | "Current balance" + eye toggle + circular refresh.
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
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
            MoneyCell(
                label = "Airtime used today",
                value = if (valuesVisible) "Ksh ${money(airtimeToday)}" else MASK,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(52.dp)
                    .background(Hairline)
            )
            // E1 — NEVER a fake number: null balance shows unavailable + link.
            if (balance == null && valuesVisible) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Current balance", color = TextGrey, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Balance unavailable", color = TextWhite, fontSize = 14.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                    Text(
                        "run Diagnostics",
                        color = AccentBlue, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable(onClick = onOpenDiagnostics)
                    )
                }
            } else {
                MoneyCell(
                    label = "Current balance",
                    value = if (valuesVisible) "Ksh ${money(balance ?: 0.0)}" else MASK,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            Spacer(modifier = Modifier.width(10.dp))
            RefreshButton(loading = loading, onClick = onRefresh)
        }
    }
}

@Composable
private fun MoneyCell(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            label,
            color = TextGrey,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            value,
            color = TextWhite,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}

/** Circular refresh that spins only while the balance read is in flight. */
@Composable
private fun RefreshButton(loading: Boolean, onClick: () -> Unit) {
    val transition = rememberInfiniteTransition(label = "refreshSpin")
    val spin by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(900, easing = LinearEasing)),
        label = "refreshAngle"
    )
    val angle = if (loading) spin else 0f

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


/** One activity row: status dot, who, how much, when. */
@Composable
private fun HomeTransactionRow(tx: Transaction) {
    val statusColor = StatusColors.color(tx.status)
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 14.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
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
                    tx.customerName?.takeIf { it.isNotBlank() } ?: tx.phoneNumber,
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "${tx.offerName} · ${timeAgo(tx.createdAt)}",
                    color = TextGrey,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
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

/** "just now", "12m ago", "3d ago", then an absolute stamp. */
private fun timeAgo(millis: Long): String {
    if (millis <= 0L) return "—"
    val minutes = (System.currentTimeMillis() - millis) / 60_000L
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

