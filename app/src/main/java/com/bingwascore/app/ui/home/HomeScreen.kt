package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassDialog
import com.bingwascore.app.ui.components.LocalPremiumToastManager
import com.bingwascore.app.ui.components.ToastType
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.util.Haptics
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.rememberHaptics
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.max

private const val MASK = "******"
private const val CLOCK_BUCKET_MILLIS = 30_000L
private val HOME_ROW_HEIGHT = 44.dp

/**
 * S68 — pure Home state. Everything the screen renders comes from here.
 */
data class HomeScreenState(
    val greetingBucket: Greetings.Bucket = Greetings.Bucket.MORNING,
    val greetingLanguage: Greetings.Language = Greetings.Language.SWAHILI,
    val creditsLabel: String = "0",
    val creditsPlanName: String = "",
    val completedToday: Int = 0,
    val unseenFailed: Int = 0,
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
    val offers: List<Offer> = emptyList(),
    val customers: List<Customer> = emptyList(),
    val permissionsMissing: Boolean = false,
    val valuesVisible: Boolean = false,
    val themeMode: ThemeMode = ThemeMode.PORCELAIN_DIM,
    val isMeshConnected: Boolean = false,
    val isOffline: Boolean = false,
    val queuedCount: Int = 0,
    val balanceBelowCheapestOffer: Boolean = false,
    val ladderEngineArmed: Boolean = false,
    val ladderTestDriveDone: Boolean = false,
    val ladderImportBookDone: Boolean = false,
    val ladderRecoverFailureDone: Boolean = false
)

data class HomeScreenCallbacks(
    val onOpenTransactions: (String?) -> Unit = {},
    val onOpenMyPlan: () -> Unit = {},
    val onOpenDiplomatics: () -> Unit = {},
    val onOpenDial: () -> Unit = {},
    val onOpenStats: () -> Unit = {},
    val onOpenManage: () -> Unit = {},
    val onRequestPermissions: () -> Unit = {},
    val onPermissionNotNow: () -> Unit = {},
    val onRefreshBalance: () -> Unit = {},
    val onToggleValues: () -> Unit = {},
    val onOpenDiagnostics: () -> Unit = {},
    val onThemeToggle: () -> Unit = {},
    val onCrashBannerTap: () -> Unit = {},
    val onClearUnseenFailures: () -> Unit = {},
    val onLadderEngineArmed: () -> Unit = {},
    val onLadderTestDrive: () -> Unit = {},
    val onLadderImportBook: () -> Unit = {},
    val onLadderRecoverFailure: () -> Unit = {}
)

@Composable
fun HomeScreen(
    onOpenTransactions: (statusFilter: String?) -> Unit = {},
    onOpenMyPlan: () -> Unit = {},
    onOpenDiplomatics: () -> Unit = {},
    onOpenDial: () -> Unit = {},
    onOpenStats: () -> Unit = {},
    onOpenManage: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val haptics = rememberHaptics()
    val scope = rememberCoroutineScope()

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
    val transactions by viewModel.recentTransactions.collectAsStateWithLifecycle()
    val offers by viewModel.activeOffers.collectAsStateWithLifecycle()
    val customers by viewModel.repeatBuyers.collectAsStateWithLifecycle()
    val completedToday by viewModel.completedToday.collectAsStateWithLifecycle()
    val unseenFailed by viewModel.unseenFailedCount.collectAsStateWithLifecycle()
    val cheapestOffer by viewModel.cheapestActiveOfferPrice.collectAsStateWithLifecycle()

    val greeting by viewModel.greeting.collectAsStateWithLifecycle()
    val creditsLabel by viewModel.creditsLabel.collectAsStateWithLifecycle()
    val planState by viewModel.planState.collectAsStateWithLifecycle()
    val themeMode by viewModel.userPreferences.themeMode.collectAsStateWithLifecycle(ThemeMode.PORCELAIN_DIM)
    val meshConnected by viewModel.userPreferences.meshConnected.collectAsStateWithLifecycle(false)
    var valuesVisible by remember { mutableStateOf(false) }
    var permissionsMissing by remember { mutableStateOf(missingPermissions(context)) }

    val ladderEngineArmed by viewModel.ladderEngineArmed.collectAsStateWithLifecycle()
    val ladderTestDriveDone by viewModel.ladderTestDriveDone.collectAsStateWithLifecycle()
    val ladderImportBookDone by viewModel.ladderImportBookDone.collectAsStateWithLifecycle()
    val ladderRecoverFailureDone by viewModel.ladderRecoverFailureDone.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        permissionsMissing = missingPermissions(context)
        viewModel.refreshBalance()
    }

    val toastManager = LocalPremiumToastManager.current
    LaunchedEffect(balanceError) {
        val message = balanceError ?: return@LaunchedEffect
        toastManager.show(ToastType.Error, message)
        viewModel.consumeBalanceError()
    }

    LaunchedEffect(Unit) {
        permissionsMissing = missingPermissions(context)
        viewModel.refreshBalance()
    }

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
        creditsPlanName = planState.displayName.ifBlank { "Credits" },
        completedToday = completedToday,
        unseenFailed = unseenFailed,
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
        offers = offers,
        customers = customers,
        permissionsMissing = permissionsMissing,
        valuesVisible = valuesVisible,
        themeMode = themeMode,
        isMeshConnected = meshConnected,
        isOffline = !meshConnected,
        queuedCount = pending,
        balanceBelowCheapestOffer = (balance ?: 0.0) > 0 && (balance ?: 0.0) < cheapestOffer,
        ladderEngineArmed = ladderEngineArmed,
        ladderTestDriveDone = ladderTestDriveDone,
        ladderImportBookDone = ladderImportBookDone,
        ladderRecoverFailureDone = ladderRecoverFailureDone
    )

    val callbacks = HomeScreenCallbacks(
        onOpenTransactions = onOpenTransactions,
        onOpenMyPlan = onOpenMyPlan,
        onOpenDiplomatics = onOpenDiplomatics,
        onOpenDial = onOpenDial,
        onOpenStats = onOpenStats,
        onOpenManage = onOpenManage,
        onRequestPermissions = { permissionLauncher.launch(REQUIRED_PERMISSION_ARRAY) },
        onPermissionNotNow = { permissionsMissing = false },
        onRefreshBalance = {
            permissionsMissing = missingPermissions(context)
            viewModel.refreshBalance()
        },
        onToggleValues = { valuesVisible = !valuesVisible },
        onOpenDiagnostics = { },
        onThemeToggle = {
            val next = if (themeMode == ThemeMode.DARK) ThemeMode.PORCELAIN_DIM else ThemeMode.DARK
            scope.launch { viewModel.userPreferences.setThemeMode(next) }
        },
        onCrashBannerTap = { viewModel.startEngine() },
        onClearUnseenFailures = { viewModel.clearUnseenFailures() },
        onLadderEngineArmed = { viewModel.setLadderEngineArmed(true) },
        onLadderTestDrive = { viewModel.setLadderTestDriveDone(true) },
        onLadderImportBook = { viewModel.setLadderImportBookDone(true) },
        onLadderRecoverFailure = { viewModel.setLadderRecoverFailureDone(true) }
    )

    HomeScreenContent(state = state, callbacks = callbacks, snackbarHostState = snackbarHostState)
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    callbacks: HomeScreenCallbacks = HomeScreenCallbacks(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    haptics: Haptics = rememberHaptics(),
    onCrashBannerTap: () -> Unit = {}
) {
    val now = (System.currentTimeMillis() / CLOCK_BUCKET_MILLIS) * CLOCK_BUCKET_MILLIS
    val showCrashBanner = remember { CrashHandler.getConsecutiveCrashes() >= 2 }
    var tapToEnable by remember { mutableStateOf(false) }
    var selectedSubtab by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize().background(DesignTokens.LocalBingwaRoles.current.bg)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (showCrashBanner && !tapToEnable) {
                item {
                    CrashBanner(onTap = {
                        tapToEnable = true
                        onCrashBannerTap()
                    })
                }
            }

            item {
                HeroSection(state = state, callbacks = callbacks)
            }

            if (state.isOffline) {
                item { OfflineMeshBanner(queuedCount = state.queuedCount, onFlush = {}) }
            }

            if (state.balanceBelowCheapestOffer) {
                item { FloatGuardBanner(onTopUp = callbacks.onOpenMyPlan) }
            }

            item {
                ActivationLadder(
                    engineArmed = state.ladderEngineArmed,
                    testDriveDone = state.ladderTestDriveDone,
                    importBookDone = state.ladderImportBookDone,
                    recoverFailureDone = state.ladderRecoverFailureDone,
                    onEngineArmedClick = callbacks.onLadderEngineArmed,
                    onTestDriveClick = callbacks.onLadderTestDrive,
                    onImportBookClick = callbacks.onLadderImportBook,
                    onRecoverFailureClick = callbacks.onLadderRecoverFailure
                )
            }

            item {
                Subtabs(selected = selectedSubtab, onSelect = { selectedSubtab = it })
            }

            when (selectedSubtab) {
                0 -> offersSection(state = state, callbacks = callbacks, now = now)
                else -> settingsSection(callbacks = callbacks)
            }
        }
    }
}

@Composable
private fun HeroSection(state: HomeScreenState, callbacks: HomeScreenCallbacks) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(DesignTokens.Hero.surface)
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AutopilotEye(engineState = state.engineState)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Good ${state.greetingBucket.name.lowercase().replaceFirstChar { it.uppercase() }}",
                    color = DesignTokens.Hero.ink.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                CreditsBox(label = state.creditsLabel, planName = state.creditsPlanName, onClick = callbacks.onOpenMyPlan)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${state.completedToday}",
                        color = DesignTokens.Hero.ink,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-1.5).sp
                    )
                    Text(
                        text = "completed today",
                        color = DesignTokens.Hero.ink.copy(alpha = 0.6f),
                        fontSize = 14.sp
                    )
                }
                FailedBulb(count = state.unseenFailed, onClick = {
                    callbacks.onClearUnseenFailures()
                    callbacks.onOpenTransactions("FAILED")
                })
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                QuickActionTile(icon = {}, label = "Dial", onClick = callbacks.onOpenDial)
                QuickActionTile(icon = {}, label = "Stats", onClick = callbacks.onOpenStats)
                QuickActionTile(icon = {}, label = "Manage", onClick = callbacks.onOpenManage)
            }
        }
    }
}

@Composable
private fun AutopilotEye(engineState: EngineState) {
    val on = engineState == EngineState.RUNNING
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(if (on) DesignTokens.Semantic.complete else DesignTokens.Semantic.failed)
            .border(2.dp, DesignTokens.Hero.ink.copy(alpha = 0.2f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(DesignTokens.Hero.ink.copy(alpha = if (on) 1f else 0.5f))
        )
    }
}

@Composable
private fun FailedBulb(count: Int, onClick: () -> Unit) {
    val blinking = count > 0
    val blinkAlpha by animateFloatAsState(
        targetValue = if (blinking) 1f else 0.4f,
        animationSpec = if (blinking) infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ) else tween(200),
        label = "FailedBulbBlink"
    )
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(DesignTokens.Semantic.failed.copy(alpha = blinkAlpha))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (count > 0) {
            Text(
                text = "$count",
                color = DesignTokens.Hero.ink,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CreditsBox(label: String, planName: String, onClick: () -> Unit) {
    GlassCard(modifier = Modifier.clickable(onClick = onClick)) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            Text(
                text = "CREDITS EXPIRE",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = label,
                color = DesignTokens.Semantic.complete,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = planName.ifBlank { "Get credits" },
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun QuickActionTile(icon: @Composable () -> Unit, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
            .background(DesignTokens.LocalBingwaRoles.current.card.copy(alpha = 0.3f))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Box(modifier = Modifier.size(24.dp)) { icon() }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = DesignTokens.Hero.ink,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun OfflineMeshBanner(queuedCount: Int, onFlush: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Box(modifier = Modifier.size(4.dp).background(DesignTokens.Semantic.info).padding(end = 8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Offline mesh", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "$queuedCount queued", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
            Text(
                text = "Flush now",
                color = DesignTokens.LocalBingwaRoles.current.brand,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable(onClick = onFlush)
            )
        }
    }
}

@Composable
private fun FloatGuardBanner(onTopUp: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth(), content = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Box(modifier = Modifier.size(4.dp).background(DesignTokens.Semantic.awaiting).padding(end = 8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Float guard", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Balance below cheapest enabled offer", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
            Text(
                text = "Top up",
                color = DesignTokens.LocalBingwaRoles.current.brand,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable(onClick = onTopUp)
            )
        }
    })
}

@Composable
private fun Subtabs(selected: Int, onSelect: (Int) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf("Offers", "Settings").forEachIndexed { index, label ->
            val active = index == selected
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50))
                    .background(if (active) DesignTokens.Hero.surface else Color.Transparent)
                    .clickable { onSelect(index) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = if (active) DesignTokens.Hero.ink else DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.offersSection(
    state: HomeScreenState,
    callbacks: HomeScreenCallbacks,
    now: Long
) {
    item { PayoutCard() }

    item {
        var selectedCategory by remember { mutableStateOf("All") }
        val categories = listOf("All", "Data", "Minutes", "SMS")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            categories.forEach { cat ->
                val active = cat == selectedCategory
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(if (active) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.card)
                        .clickable { selectedCategory = cat }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = cat,
                        color = if (active) DesignTokens.LocalBingwaRoles.current.onBrand else DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }

    items(state.offers) { offer ->
        OfferRow(offer = offer, onToggle = { })
    }

    item { RepeatBuyersCard(customers = state.customers) }

    item { SectionHeader("Recent transactions", "${state.transactions.size} total") }

    if (state.transactions.isEmpty()) {
        item {
            Text(
                text = "Nothing yet — every bundle you dial lands here.",
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = 14.sp
            )
        }
    } else {
        itemsIndexed(state.transactions, key = { _, tx -> tx.id }) { index, tx ->
            HomeTransactionRow(tx = tx, now = now, showDivider = index < state.transactions.size - 1)
        }
    }
}

@Composable
private fun PayoutCard() {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Payout", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Weekly countdown + commission/goal gradient bar", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
        }
    }
}

@Composable
private fun OfferRow(offer: Offer, onToggle: (Boolean) -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = offer.name, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "${offer.type} · ${offer.ussdCode}", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
            Text(text = "Ksh ${offer.price}", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(40.dp, 24.dp)
                    .clip(RoundedCornerShape(50))
                    .background(if (offer.isActive) DesignTokens.Semantic.complete else DesignTokens.LocalBingwaRoles.current.border)
                    .clickable { onToggle(!offer.isActive) }
            ) {
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).background(DesignTokens.LocalBingwaRoles.current.onBrand).align(Alignment.CenterStart))
            }
        }
    }
}

@Composable
private fun RepeatBuyersCard(customers: List<Customer>) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Repeat buyers", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            if (customers.isEmpty()) {
                Text(text = "No repeat buyers yet", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            } else {
                customers.forEach { customer ->
                    Text(text = formatCustomerName(customer.name), color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp)
                }
            }
        }
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.settingsSection(callbacks: HomeScreenCallbacks) {
    item {
        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Settings", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                listOf("M-Pesa", "SiteLink", "Auto-save", "Test Drive", "Processing Mode", "SIM Selection", "Server", "Backup & Restore").forEach { setting ->
                    Text(text = setting, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, modifier = Modifier.padding(vertical = 8.dp))
                }
                Text(text = "Feature blueprint", color = DesignTokens.LocalBingwaRoles.current.brand, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
private fun CrashBanner(onTap: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.10f), shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd))
            .border(1.dp, DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.30f), RoundedCornerShape(DesignTokens.Shape.RadiusMd))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Text(
                text = "Engine paused after crashes - tap to enable",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick = onTap) {
                Text("Enable", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String, trailing: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Text(trailing, color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
    }
}

@Composable
private fun HomeTransactionRow(
    tx: Transaction,
    now: Long = System.currentTimeMillis(),
    showDivider: Boolean = false
) {
    val statusColor = when (tx.status) {
        TransactionStatus.SUCCESSFUL.value -> DesignTokens.Semantic.complete
        TransactionStatus.FAILED.value,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value,
        TransactionStatus.UNMATCHED.value,
        TransactionStatus.CANCELLED.value -> DesignTokens.Semantic.failed
        else -> DesignTokens.Semantic.scheduled
    }
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(HOME_ROW_HEIGHT).padding(horizontal = 12.dp)
            ) {
                Box(modifier = Modifier.size(40.dp).clip(RoundedCornerShape(8.dp)).background(statusColor), contentAlignment = Alignment.Center) {
                    Text(text = "●", color = DesignTokens.Hero.ink, fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = formatCustomerName(tx.customerName).ifBlank { tx.phoneNumber }, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(text = "${tx.offerName} · ${timeAgo(tx.createdAt, now)}", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Text(text = "Ksh ${money(tx.amount)}", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            if (showDivider) {
                Spacer(modifier = Modifier.height(4.dp))
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(DesignTokens.LocalBingwaRoles.current.border))
            }
        }
    }
}

private val timeFormat = SimpleDateFormat("d MMM, HH:mm", Locale.getDefault())
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

internal fun money(value: Double): String = String.format(Locale.US, "%,.2f", value)

/** Axis label: 1,200 / 45 — short enough for a 40dp gutter. */
internal fun formatShort(value: Double): String = when {
    value >= 1000 -> String.format(Locale.US, "%,.0f", value)
    value >= 10 -> String.format(Locale.US, "%.0f", value)
    else -> String.format(Locale.US, "%.1f", value)
}

/** Scales the series to 0..1 so the chart springs instead of jumping. */
internal fun normalize(series: List<Double>): List<Float> {
    val padded = (series + List((7 - series.size).coerceAtLeast(0)) { 0.0 }).take(7)
    val max = padded.maxOrNull() ?: 0.0
    if (max <= 0.0) return padded.map { 0f }
    return padded.map { (it / max).toFloat() }
}

private fun missingPermissions(context: Context): Boolean =
    REQUIRED_PERMISSIONS.any { ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED }

private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE)
private val REQUIRED_PERMISSION_ARRAY = REQUIRED_PERMISSIONS

@Composable
private fun PhoneAccessPrompt(onGrant: () -> Unit, onNotNow: () -> Unit) {
    GlassDialog(
        visible = true,
        onDismiss = onNotNow,
        title = "Allow phone access?",
        body = {
            Text(
                text = "Bingwa Score needs Call and Phone state to read your airtime balance and dial bundles in the background. Nothing is ever shown to the customer.",
                fontSize = 13.sp
            )
        },
        dismissLabel = "Not now",
        confirmLabel = "Allow",
        onConfirm = onGrant
    )
}
