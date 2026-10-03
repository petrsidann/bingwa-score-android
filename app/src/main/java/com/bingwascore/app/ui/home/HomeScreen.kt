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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.ChartBlue
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
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
    val engineEnabled by viewModel.engineEnabled.collectAsStateWithLifecycle()
    val transactions by viewModel.allTransactions.collectAsStateWithLifecycle()

    var valuesVisible by remember { mutableStateOf(false) }
    var permissionsMissing by remember { mutableStateOf(missingPermissions(context)) }
    // R5 — manual balance entry, offered whenever the network gives up.
    var manualEntryFor by remember { mutableStateOf<Double?>(null) }

    val snackbarHostState = remember { SnackbarHostState() }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { viewModel.refreshBalance() }

    LaunchedEffect(balanceError) {
        val message = balanceError ?: return@LaunchedEffect
        // R5 — the reason is a sentence now; the escape hatch is the action.
        val result = snackbarHostState.showSnackbar(
            message = message,
            actionLabel = "Open Settings",
            duration = SnackbarDuration.Long
        )
        viewModel.consumeBalanceError()
        if (result == SnackbarResult.ActionPerformed) {
            openAppSettings(context)
        } else {
            // Dismissed: the agent may know the balance better than the network does.
            manualEntryFor = balance
        }
    }

    LaunchedEffect(Unit) {
        permissionsMissing = missingPermissions(context)
        viewModel.refreshBalance()
    }

    Box(modifier = Modifier.fillMaxSize().background(BgBlack)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item { EngineCard(enabled = engineEnabled, onToggle = viewModel::toggleEngine) }

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
                    }
                )
            }

            item { SectionHeader("Transactions", "${transactions.size} total") }

            item { Spacer(modifier = Modifier.height(4.dp)) }

            items(transactions, key = { it.id }) { tx -> HomeTransactionRow(tx) }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

    // R5 — the last resort when USSD will not answer: type the balance in.
    val manualFor = manualEntryFor
    if (manualFor != null) {
        var entry by remember { mutableStateOf("") }
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { manualEntryFor = null },
            containerColor = Bubble,
            title = {
                Text("Enter balance manually", color = TextWhite, fontWeight = FontWeight.Bold)
            },
            text = {
                androidx.compose.material3.TextField(
                    value = entry,
                    onValueChange = { entry = it.filter { c -> c.isDigit() || c == '.' } },
                    singleLine = true,
                    placeholder = {
                        Text("0.00", color = TextDim)
                    },
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        focusedTextColor = TextWhite,
                        unfocusedTextColor = TextWhite
                    )
                )
            },
            confirmButton = {
                androidx.compose.material3.TextButton(onClick = {
                    entry.toDoubleOrNull()?.let { viewModel.setManualBalance(it) }
                    manualEntryFor = null
                }) {
                    Text("Save", color = AccentBlue, fontWeight = FontWeight.SemiBold)
                }
            },
            dismissButton = {
                androidx.compose.material3.TextButton(onClick = { manualEntryFor = null }) {
                    Text("Cancel", color = TextGrey)
                }
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
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CounterTile(completed, "Completed", AccentBlue, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("SUCCESSFUL")
        }
        CounterTile(failed, "Failed", FailRed, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("FAILED")
        }
        CounterTile(pending, "Pending", PendGrey, Modifier.weight(1f)) {
            haptics.tick()
            onOpenTransactions("PENDING")
        }
    }
}

@Composable
private fun CounterTile(
    value: Int,
    label: String,
    accent: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BubbleCard(modifier = modifier, cornerRadius = 18.dp, onClick = onClick) {
        Text(
            "$value",
            color = accent,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(label, color = TextGrey, fontSize = 12.sp, maxLines = 1)
    }
}

@Composable
private fun EngineCard(enabled: Boolean, onToggle: () -> Unit) {
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 18.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(if (enabled) TickGreen.copy(alpha = 0.15f) else Bubble),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Bolt,
                    contentDescription = null,
                    tint = if (enabled) TickGreen else TextDim,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Bingwa Autopilot",
                    color = TextWhite,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    if (enabled) "Running — watching for M-Pesa payments" else "Stopped — tap to start",
                    color = TextGrey,
                    fontSize = 12.sp
                )
            }
            HapticSwitch(checked = enabled, onCheckedChange = { onToggle() })
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
    balance: Double,
    loading: Boolean,
    valuesVisible: Boolean,
    onToggleVisibility: () -> Unit,
    onRefresh: () -> Unit
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
            MoneyCell(
                label = "Current balance",
                value = if (valuesVisible) "Ksh ${money(balance)}" else MASK,
                modifier = Modifier.weight(1f)
            )
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
            .background(Bubble)
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
 * The live commission chart card.
 *
 * A Canvas line chart: one ChartBlue stroke over a gradient area fill that fades
 * .35 → 0, hairline grid, grey y-labels. When a commission lands the series
 * re-springs to its new shape, and tapping any point pops that day's value in a
 * bubble above it.
 */
@Composable
private fun CommissionChartCard(series: List<Double>) {
    val haptics = rememberHaptics()
    val display = remember { mutableStateOf(normalize(series)) }
    var selected by remember { mutableStateOf(-1) }

    // Spring every point to its new value so a landed commission is *felt*.
    LaunchedEffect(series) {
        val from = display.value
        val target = normalize(series)
        target.indices.forEach { index ->
            val animator = Animatable(from.getOrElse(index) { 0f })
            animator.animateTo(
                targetValue = target[index],
                animationSpec = spring(dampingRatio = 0.65f, stiffness = Spring.StiffnessLow)
            )
            display.value = display.value.toMutableList().also { list ->
                if (index < list.size) list[index] = animator.value
            }
        }
    }

    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 20.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Commission this week",
                color = TextWhite,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Text(
                "Ksh ${money(series.sum())}",
                color = AccentBlue,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.height(150.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Text(formatShort(series.maxOrNull() ?: 0.0), color = TextDim, fontSize = 10.sp)
                Text("0", color = TextDim, fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            ChartCanvas(
                values = display.value,
                raw = series,
                selected = selected,
                modifier = Modifier.weight(1f),
                onPointTapped = { index ->
                    haptics.tick()
                    selected = if (selected == index) -1 else index
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            listOf("M", "T", "W", "T", "F", "S", "S").forEach { day ->
                Text(day, color = TextDim, fontSize = 10.sp, modifier = Modifier.width(28.dp))
            }
        }
    }
}

/**
 * The line itself. Points sit on a fixed column so the day labels underneath
 * line up; a tap resolves to the nearest column and the selected point gets a
 * value bubble drawn above it.
 */
@Composable
private fun ChartCanvas(
    values: List<Float>,
    raw: List<Double>,
    selected: Int,
    modifier: Modifier = Modifier,
    onPointTapped: (Int) -> Unit
) {
    val stroke = 2.5.dp
    val pointRadius = 3.5.dp
    val accent = ChartBlue
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
            .height(150.dp)
            .pointerInput(values.size) {
                detectTapGestures { tap ->
                    val slot = size.width / values.size.coerceAtLeast(1).toFloat()
                    val index = (tap.x / slot)
                        .toInt()
                        .coerceIn(0, (values.size - 1).coerceAtLeast(0))
                    onPointTapped(index)
                }
            }
    ) {
        if (values.isEmpty()) return@Canvas
        val valuesMax = values.maxOrNull()?.takeIf { it > 0f } ?: 1f
        val stepX = size.width / (values.size - 1).coerceAtLeast(1).toFloat()
        val topInset = (pointRadius * 2).toPx()
        val usable = size.height - topInset * 2f

        fun pointAt(index: Int): Offset {
            val x = stepX * index
            val y = topInset + usable * (1f - values[index].coerceIn(0f, valuesMax) / valuesMax)
            return Offset(x, y)
        }

        // Hairline grid: four horizontal rules.
        repeat(4) { row ->
            val y = size.height * row / 3f
            drawLine(color = Hairline, start = Offset(0f, y), end = Offset(size.width, y), strokeWidth = 1f)
        }

        val line = Path()
        values.indices.forEach { index ->
            val point = pointAt(index)
            if (index == 0) line.moveTo(point.x, point.y) else line.lineTo(point.x, point.y)
        }

        // Area fill under the line, 0.35 at the top fading to nothing.
        val area = Path().apply {
            addPath(line)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        drawPath(
            path = area,
            brush = Brush.verticalGradient(
                colors = listOf(accent.copy(alpha = 0.35f), accent.copy(alpha = 0f)),
                startY = 0f,
                endY = size.height
            )
        )

        drawPath(path = line, color = accent, style = Stroke(width = stroke.toPx(), cap = StrokeCap.Round))
        values.indices.forEach { index ->
            drawCircle(color = accent, radius = pointRadius.toPx(), center = pointAt(index))
        }

        // Value bubble for the tapped point.
        if (selected in values.indices) {
            val amount = raw.getOrElse(selected) { 0.0 }
            val layout = textMeasurer.measure(
                text = "Ksh ${money(amount)}",
                style = TextStyle(color = TextWhite, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            )
            val centre = pointAt(selected)
            val padH = 6.dp.toPx()
            val padV = 3.dp.toPx()
            val bubbleW = layout.size.width + padH * 2
            val bubbleH = layout.size.height + padV * 2
            val left = (centre.x - bubbleW / 2f).coerceIn(0f, (size.width - bubbleW).coerceAtLeast(0f))
            val topY = (centre.y - bubbleH - 10.dp.toPx()).coerceAtLeast(0f)

            drawRoundRect(
                color = Bubble,
                topLeft = Offset(left, topY),
                size = Size(bubbleW, bubbleH),
                cornerRadius = CornerRadius(8.dp.toPx())
            )
            drawRoundRect(
                color = Hairline,
                topLeft = Offset(left, topY),
                size = Size(bubbleW, bubbleH),
                cornerRadius = CornerRadius(8.dp.toPx()),
                style = Stroke(width = 1f)
            )
            drawText(textLayoutResult = layout, topLeft = Offset(left + padH, topY + padV))
        }
    }
}

/** One activity row: status dot, who, how much, when. */
@Composable
private fun HomeTransactionRow(tx: Transaction) {
    BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 16.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(StatusColors.color(tx.status))
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
private fun normalize(series: List<Double>): List<Float> {
    val padded = (series + List((7 - series.size).coerceAtLeast(0)) { 0.0 }).take(7)
    val max = padded.maxOrNull() ?: 0.0
    if (max <= 0.0) return padded.map { 0f }
    return padded.map { (it / max).toFloat() }
}

/** Axis label: 1,200 / 45 — short enough for a 40dp gutter. */
private fun formatShort(value: Double): String = when {
    value >= 1000 -> String.format(Locale.US, "%,.0f", value)
    value >= 10 -> String.format(Locale.US, "%.0f", value)
    else -> String.format(Locale.US, "%.1f", value)
}

/** "1,234.56" — always two decimals, no locale surprises. */
private fun money(value: Double): String = String.format(Locale.US, "%,.2f", value)

/** Permissions the dial + balance paths genuinely need. */
private fun missingPermissions(context: Context): Boolean =
    REQUIRED_PERMISSIONS.any {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }

private val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.CALL_PHONE,
    Manifest.permission.READ_PHONE_STATE
)

