package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.TrendingUp
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.SimCard
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val userName by viewModel.userName.collectAsStateWithLifecycle()
    val successfulCount by viewModel.successfulCount.collectAsStateWithLifecycle()
    val failedCount by viewModel.failedCount.collectAsStateWithLifecycle()
    val airtimeUsedToday by viewModel.airtimeUsedToday.collectAsStateWithLifecycle()
    val weeklyCommission by viewModel.weeklyCommission.collectAsStateWithLifecycle()
    val weeklyBars by viewModel.weeklyCommissionByDay.collectAsStateWithLifecycle()
    val recentTransactions by viewModel.recentTransactions.collectAsStateWithLifecycle()
    val balance by viewModel.balance.collectAsStateWithLifecycle()
    val balanceLoading by viewModel.balanceLoading.collectAsStateWithLifecycle()
    val advancedMode by viewModel.advancedMode.collectAsStateWithLifecycle()
    val botPaused by viewModel.botPaused.collectAsStateWithLifecycle()

    var balanceVisible by remember { mutableStateOf(true) }
    var missingPermissions by remember { mutableStateOf(computeMissingPermissions(context)) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        missingPermissions = computeMissingPermissions(context)
    }

    val refreshTransition = rememberInfiniteTransition(label = "balanceRefresh")
    val refreshAngle by refreshTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(durationMillis = 1000, easing = LinearEasing)),
        label = "refreshAngle"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        GreetingHeader(userName = userName)

        Spacer(modifier = Modifier.height(16.dp))

        if (missingPermissions.isNotEmpty()) {
            HealthBanner(
                missingCount = missingPermissions.size,
                onFix = { permissionLauncher.launch(requiredPermissions().toTypedArray()) },
                onOpenSettings = { viewModel.openSystemSettings() }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatTile(
                modifier = Modifier.weight(1f),
                icon = Icons.Rounded.CheckCircle,
                iconTint = EmeraldGreen,
                label = "Completed",
                value = successfulCount.toString()
            )
            StatTile(
                modifier = Modifier.weight(1f),
                icon = Icons.Rounded.ErrorOutline,
                iconTint = ErrorRed,
                label = "Failed",
                value = failedCount.toString()
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatTile(
                modifier = Modifier.weight(1f),
                icon = Icons.Rounded.SimCard,
                iconTint = TealBlue,
                label = "Airtime Used Today",
                value = formatKsh(airtimeUsedToday)
            )
            StatTile(
                modifier = Modifier.weight(1f),
                icon = Icons.AutoMirrored.Rounded.TrendingUp,
                iconTint = Orange500,
                label = "Weekly Commission",
                value = formatKsh(weeklyCommission)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AirtimeBalanceCard(
            balance = balance,
            balanceVisible = balanceVisible,
            balanceLoading = balanceLoading,
            refreshAngle = refreshAngle,
            onToggleVisibility = { balanceVisible = !balanceVisible },
            onRefresh = { viewModel.refreshBalance() }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ModeChip(
                modifier = Modifier.weight(1f),
                title = "Processing",
                subtitle = if (advancedMode) "ADVANCED" else "EXPRESS",
                active = advancedMode,
                onClick = { viewModel.toggleAdvanced() }
            )
            ModeChip(
                modifier = Modifier.weight(1f),
                title = "Auto Bot",
                subtitle = if (botPaused) "PAUSED" else "ACTIVE",
                active = !botPaused,
                onClick = { viewModel.togglePause() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        WeeklyChart(weeklyBars = weeklyBars, weeklyCommission = weeklyCommission)

        Spacer(modifier = Modifier.height(16.dp))

        RecentActivity(transactions = recentTransactions)

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun GreetingHeader(userName: String) {
    val greeting = remember {
        when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 5..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            else -> "Good evening"
        }
    }
    val initials = remember(userName) {
        userName.trim().take(1).uppercase(Locale.ROOT).ifEmpty { "B" }
    }

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text("$greeting,", color = White.copy(alpha = 0.6f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(userName, color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Box {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue))),
                contentAlignment = Alignment.Center
            ) {
                Text(initials, color = NightBlack, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
            }
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(EmeraldGreen)
                    .border(2.dp, NightBlack, CircleShape)
            )
        }
    }
}

@Composable
private fun HealthBanner(missingCount: Int, onFix: () -> Unit, onOpenSettings: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.Warning,
                contentDescription = null,
                tint = Orange500,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text("App health check", color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "$missingCount permission(s) missing. SMS parsing and balance refresh need them.",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 11.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        GradientButton(text = "Fix", onClick = onFix, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Denied before? Open system settings",
            color = TealBlue,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(onClick = onOpenSettings)
        )
    }
}

@Composable
private fun AirtimeBalanceCard(
    balance: Double,
    balanceVisible: Boolean,
    balanceLoading: Boolean,
    refreshAngle: Float,
    onToggleVisibility: () -> Unit,
    onRefresh: () -> Unit
) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Airtime Balance", color = White.copy(alpha = 0.55f), fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    if (balanceVisible) formatKsh(balance) else "Ksh • • • • • •",
                    color = White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Icon(
                imageVector = if (balanceVisible) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                contentDescription = if (balanceVisible) "Hide balance" else "Show balance",
                tint = White.copy(alpha = 0.7f),
                modifier = Modifier
                    .size(22.dp)
                    .clickable(onClick = onToggleVisibility)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Icon(
                imageVector = Icons.Rounded.Refresh,
                contentDescription = "Refresh balance",
                tint = EmeraldGreen,
                modifier = Modifier
                    .size(22.dp)
                    .graphicsLayer { rotationZ = if (balanceLoading) refreshAngle else 0f }
                    .clickable(onClick = onRefresh)
            )
        }
    }
}

@Composable
private fun ModeChip(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    active: Boolean,
    onClick: () -> Unit
) {
    GlassCard(modifier = modifier, cornerRadius = 18.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (active) EmeraldGreen else Color(0x40FFFFFF))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(title, color = White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    subtitle,
                    color = if (active) EmeraldGreen else White.copy(alpha = 0.55f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun StatTile(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconTint: Color,
    label: String,
    value: String
) {
    GlassCard(modifier = modifier) {
        Icon(imageVector = icon, contentDescription = label, tint = iconTint, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(value, color = White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(3.dp))
        Text(label, color = White.copy(alpha = 0.55f), fontSize = 11.sp)
    }
}

@Composable
private fun WeeklyChart(weeklyBars: List<Double>, weeklyCommission: Double) {
    val dayLabels = remember { listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun") }

    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Weekly Commission", color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Text("Earned per day this week", color = White.copy(alpha = 0.55f), fontSize = 11.sp)
            }
            Text(
                formatKsh(weeklyCommission),
                color = EmeraldGreen,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        val maxValue = (weeklyBars.maxOrNull() ?: 0.0).coerceAtLeast(1.0)

        Canvas(modifier = Modifier.fillMaxWidth().height(140.dp)) {
            val count = weeklyBars.size.coerceAtLeast(1)
            val slot = size.width / count
            val barWidth = slot * 0.45f
            val baseline = size.height

            drawLine(
                color = Color(0x1FFFFFFF),
                start = Offset(0f, baseline),
                end = Offset(size.width, baseline),
                strokeWidth = 1.dp.toPx()
            )

            weeklyBars.forEachIndexed { index, value ->
                val ratio = (value / maxValue).toFloat().coerceIn(0f, 1f)
                val barHeight = (baseline * ratio).coerceAtLeast(if (value > 0.0) 6.dp.toPx() else 3.dp.toPx())
                val left = index * slot + (slot - barWidth) / 2f
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(EmeraldGreen, TealBlue),
                        startY = baseline - barHeight,
                        endY = baseline
                    ),
                    topLeft = Offset(left, baseline - barHeight),
                    size = Size(barWidth, barHeight),
                    cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx())
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            dayLabels.forEach { label ->
                Text(label, color = White.copy(alpha = 0.45f), fontSize = 10.sp)
            }
        }
    }
}

@Composable
private fun RecentActivity(transactions: List<Transaction>) {
    val timeFormat = remember { SimpleDateFormat("HH:mm", Locale.US) }

    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Text("Recent Activity", color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(14.dp))
        if (transactions.isEmpty()) {
            Text("No activity yet.", color = White.copy(alpha = 0.5f), fontSize = 13.sp)
        }
        transactions.forEachIndexed { index, tx ->
            val statusColor = when (tx.status) {
                TransactionStatus.SUCCESSFUL.value -> EmeraldGreen
                TransactionStatus.FAILED.value -> ErrorRed
                else -> Orange500
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(statusColor.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        (tx.customerName ?: tx.phoneNumber).trim().take(1).uppercase(Locale.ROOT),
                        color = statusColor,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        tx.customerName ?: tx.phoneNumber,
                        color = White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "${tx.offerName} • ${timeFormat.format(Date(tx.createdAt))}",
                        color = White.copy(alpha = 0.5f),
                        fontSize = 11.sp
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(formatKsh(tx.amount), color = White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(3.dp))
                    StatusChip(text = tx.status, color = statusColor)
                }
            }
            if (index < transactions.lastIndex) {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0x0DFFFFFF))
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun StatusChip(text: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(alpha = 0.14f))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text.lowercase(Locale.ROOT).replaceFirstChar { it.uppercase(Locale.ROOT) },
            color = color,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

private fun formatKsh(value: Double): String = "Ksh " + String.format(Locale.US, "%,.2f", value)

private fun requiredPermissions(): List<String> {
    val base = listOf(
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.READ_SMS,
        Manifest.permission.SEND_SMS,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.CALL_PHONE
    )
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        base + Manifest.permission.POST_NOTIFICATIONS
    } else {
        base
    }
}

private fun computeMissingPermissions(context: Context): List<String> =
    requiredPermissions().filter {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }