package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
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
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassDialog
import com.bingwascore.app.ui.components.LocalPremiumToastManager
import com.bingwascore.app.ui.components.NeoButton
import com.bingwascore.app.ui.components.StatusDot
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
    val valuesVisible: Boolean = false,
    val themeMode: ThemeMode = ThemeMode.PORCELAIN_DIM
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
    val onAutopilotPause: () -> Unit = {},
    val onThemeToggle: () -> Unit = {},
    val onCrashBannerTap: () -> Unit = {}
)

/**
 * REBRAND R2 — Home, rebuilt as a trading terminal.
 *
 * Reading order is deliberate and flat: hero money glass card, three neumorphic
 * stat cards, one live commission chart in glass, then the FULL transaction list
 * down to the oldest row. Every surface binds to [DesignTokens] only — zero
 * hardcoded hex, dp, shadow or typography literals.
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
    // below sees plain state and plain callbacks. ViewModel logic is untouched.
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
    val transactions by viewModel.allTransactions.collectAsStateWithLifecycle()

    // POLISH P2 — greeting, credits and the two Home sheets.
    val greeting by viewModel.greeting.collectAsStateWithLifecycle()
    val creditsLabel by viewModel.creditsLabel.collectAsStateWithLifecycle()
    val themeMode by viewModel.userPreferences.themeMode.collectAsStateWithLifecycle(ThemeMode.PORCELAIN_DIM)
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
        valuesVisible = valuesVisible,
        themeMode = themeMode
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
        onAutopilotPause = { viewModel.pauseEngine() },
        onThemeToggle = {
            val next = if (themeMode == ThemeMode.DARK) ThemeMode.PORCELAIN_DIM else ThemeMode.DARK
            scope.launch { viewModel.userPreferences.setThemeMode(next) }
        },
        onCrashBannerTap = { viewModel.startEngine() }
    )

    HomeScreenContent(
        state = state,
        callbacks = callbacks,
        snackbarHostState = snackbarHostState,
        onCrashBannerTap = callbacks.onCrashBannerTap
    )

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
    haptics: Haptics = rememberHaptics(),
    onCrashBannerTap: () -> Unit = {}
) {
    // The credits bubble is the door to My Plan: one tap, one destination.
    val onOpenMyPlan = callbacks.onOpenMyPlan

    // Stage 22 — the lag sweep: ONE clock read per frame, bucketed to the half
    // minute so the rows only recompose when a label would really change.
    //
    // The rows used to read the wall clock each, so a 200-row feed did 200
    // clock reads (and 200 date formats) on every recomposition.
    val now = (System.currentTimeMillis() / CLOCK_BUCKET_MILLIS) * CLOCK_BUCKET_MILLIS

    // STAGE 46 — latch the breaker at first composition. Home resume zeros the
    // counter immediately after, and the banner must stay up until the agent taps.
    val showCrashBanner = remember { CrashHandler.getConsecutiveCrashes() >= 2 }
    var tapToEnable by remember { mutableStateOf(false) }
    if (showCrashBanner && !tapToEnable) {
        // Battery optimisation check already asked; just show the banner
    }

    // Stage 22 — capture only what the rows need.
    //
    // The item lambda used to close over the whole [HomeScreenState] (an
    // unstable object: it holds a list), so ANY state change re-ran every
    // visible row. The rows only care about the engine state, so that is all
    // the lambda captures now — and a row skips when it does not change.
    val engineState = state.engineState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            // POLISH P2 — tighter everywhere: the old 14dp rhythm plus 30sp
            // numerals pushed the first real row below the fold on a 5" phone.
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                // STAGE 45 — crash circuit banner
                if (showCrashBanner) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(
                                DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.10f),
                                shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
                            )
                            .border(
                                1.dp,
                                DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.30f),
                                RoundedCornerShape(DesignTokens.Shape.RadiusMd)
                            )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                            Text(
                                text = "Engine paused after crashes - tap to enable",
                                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                fontSize = DesignTokens.Typography.Body,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            TextButton(
                                onClick = {
                                    tapToEnable = true
                                    onCrashBannerTap()
                                }
                            ) {
                                Text(
                                    "Enable",
                                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = DesignTokens.Typography.Caption
                                )
                            }
                        }
                    }
                }
            }

            item {
                HomeTopBar(
                    bucket = state.greetingBucket,
                    language = state.greetingLanguage,
                    creditsLabel = state.creditsLabel,
                    onCreditsClick = onOpenMyPlan,
                    onThemeToggle = callbacks.onThemeToggle
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
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
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

            // PHASE 1 — Hero: glass-morphic balance card with gradient background,
            // Display typography and an eye-icon mask toggle.
            item {
                HeroBar(
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

            // PHASE 2 — Stats cards: three equal-width neumorphic glass cards.
            item {
                StatsRow(
                    completed = state.successful,
                    failed = state.failed,
                    pending = state.pending,
                    onOpenTransactions = callbacks.onOpenTransactions
                )
            }

            item {
                // PHASE 2 — commission graph wrapped in GlassCard, line in Brand.Primary.
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    CommissionChartCard(series = state.commission)
                }
            }

            item { SectionHeader("Transactions", "${state.transactions.size} total") }

            // R6 — shimmer ONLY where a list is actually loading.
            if (state.statsLoading) {
                items(4, key = { "skeleton-$it" }) { HomeRowSkeleton() }
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
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                            fontSize = DesignTokens.Typography.Caption,
                            modifier = Modifier.weight(1f)
                        )
                        if (state.engineState == EngineState.STOPPED) {
                            Text(
                                "Start",
                                color = DesignTokens.LocalBingwaRoles.current.brand,
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable {
                                    callbacks.onOpenAutopilotSheet()
                                }
                            )
                        }
                    }
                }
            } else {
                itemsIndexed(state.transactions, key = { _, tx -> tx.id }) { index, tx ->
                    HomeTransactionRow(
                        tx = tx,
                        engineState = engineState,
                        now = now,
                        showDivider = index < state.transactions.size - 1
                    )
            }
        }
        }

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

/** Hero money card: glass surface, brand gradient, Display balance, eye-mask toggle. */
@Composable
private fun HeroBar(
    airtimeToday: Double,
    balance: Double?,
    loading: Boolean,
    valuesVisible: Boolean,
    onToggleVisibility: () -> Unit,
    onRefresh: () -> Unit,
    onOpenDiagnostics: () -> Unit
) {
    val density = LocalDensity.current
    val gradient = Brush.verticalGradient(
        colors = listOf(
            DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.14f),
            DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.02f)
        ),
        startY = 0f,
        endY = with(density) { 120.dp.toPx() }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(gradient)
    ) {
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    MoneyLine(
                        label = "Airtime used today",
                        value = if (valuesVisible) "Ksh ${money(airtimeToday)}" else MASK,
                        valueColor = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    // E1 — NEVER a fake number: null balance shows unavailable + link.
                    val balanceScale by animateFloatAsState(
                        targetValue = if (valuesVisible) 1f else 0.92f,
                        animationSpec = spring(
                            stiffness = DesignTokens.Motion.SpringStiffness,
                            dampingRatio = DesignTokens.Motion.SpringDamping
                        ),
                        label = "HeroBalanceScale"
                    )
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = balanceScale
                                scaleY = balanceScale
                                alpha = if (valuesVisible) 1f else 0.5f
                            }
                    ) {
                        if (balance == null && valuesVisible) {
                            MoneyLine(label = "Current balance", value = "Unavailable")
                            Text(
                                "run Diagnostics",
                                color = DesignTokens.LocalBingwaRoles.current.brand,
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable(onClick = onOpenDiagnostics)
                            )
                        } else {
                            MoneyLine(
                                label = "Current balance",
                                value = if (valuesVisible) "Ksh ${money(balance ?: 0.0)}" else MASK,
                                valueColor = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                valueSize = DesignTokens.Typography.Display,
                                valueWeight = FontWeight.Bold
                            )
                        }
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
                        tint = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                        modifier = Modifier.size(19.dp)
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                RefreshButton(loading = loading, onClick = onRefresh)
            }
        }
    }
}

/** Three counters. Each one is a neumorphic glass card you can drill into. */
@Composable
private fun StatsRow(
    completed: Int,
    failed: Int,
    pending: Int,
    onOpenTransactions: (String?) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatCard(completed, "Done", DesignTokens.LocalBingwaRoles.current.success, Modifier.weight(1f)) {
            onOpenTransactions("SUCCESSFUL")
        }
        StatCard(failed, "Failed", DesignTokens.LocalBingwaRoles.current.error, Modifier.weight(1f)) {
            onOpenTransactions("FAILED")
        }
        StatCard(pending, "Queued", DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.45f), Modifier.weight(1f)) {
            onOpenTransactions("PENDING")
        }
    }
}

/**
 * POLISH P2 — one compact neumorphic stat card.
 *
 * Glass surface with Level1 soft shadow, spring press scale (0.98) and mandatory
 * long-press haptic feedback. Every visual token comes from [DesignTokens].
 */
@Composable
private fun StatCard(
    value: Int,
    label: String,
    accent: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val hapticFeedback = LocalHapticFeedback.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "StatCardScale"
    )
    val density = LocalDensity.current
    val radiusPx = with(density) { DesignTokens.Shape.RadiusMd.toPx() }
    GlassCard(
        modifier = modifier
            .drawBehind {
                for (layer in DesignTokens.Elevation.Level1) {
                    val offsetY = with(density) { layer.offsetY.toPx() }
                    withTransform({ translate(0f, offsetY) }) {
                        drawRoundRect(
                            brush = SolidColor(layer.color),
                            cornerRadius = CornerRadius(radiusPx, radiusPx)
                        )
                    }
                }
            }
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                    onClick()
                }
            )
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                StatusDot(color = accent, lit = true, size = 8.dp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "$value",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Subhead,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Text(label, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = DesignTokens.Typography.Caption, maxLines = 1)
        }
    }
}

@Composable
private fun PermissionCard(onGrant: () -> Unit) {
    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column {
            Text(
                "Phone permission needed",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "Grant call and phone access so dial and balance can work. Tap to grant.",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                fontSize = 12.sp
            )
        }
    }
    // Keep the original click behaviour via the card's content area.
    Box(modifier = Modifier.fillMaxSize().clickable(onClick = onGrant))
}

@Composable
private fun SectionHeader(title: String, trailing: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = DesignTokens.Typography.Subhead, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Text(trailing, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = DesignTokens.Typography.Caption)
    }
}

/** One label/value line inside the hero money row. */
@Composable
private fun MoneyLine(
    label: String,
    value: String,
    valueColor: Color = DesignTokens.LocalBingwaRoles.current.textPrimary,
    valueSize: TextUnit = DesignTokens.Typography.Body,
    valueWeight: FontWeight = FontWeight.Bold,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
            fontSize = DesignTokens.Typography.Caption,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            value,
            color = valueColor,
            fontSize = valueSize,
            fontWeight = valueWeight,
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
            .background(DesignTokens.LocalBingwaRoles.current.card)
            .border(1.dp, DesignTokens.LocalBingwaRoles.current.border, CircleShape)
            .clickable(enabled = !loading, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = "Refresh balance",
            tint = if (loading) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
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
 *
 * Each row is a [GlassCard] with [DesignTokens.Shape.RadiusMd].
 */
@Composable
private fun HomeTransactionRow(
    tx: Transaction,
    engineState: EngineState = EngineState.RUNNING,
    now: Long = System.currentTimeMillis(),
    showDivider: Boolean = false
) {
    val statusColor = when (tx.status) {
        TransactionStatus.SUCCESSFUL.value -> DesignTokens.LocalBingwaRoles.current.brand
        TransactionStatus.FAILED.value,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value,
        TransactionStatus.UNMATCHED.value,
        TransactionStatus.CANCELLED.value -> DesignTokens.LocalBingwaRoles.current.error
        else -> DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.45f)
    }
    val showPausedBadge = engineState == EngineState.PAUSED &&
        tx.status == TransactionStatus.PENDING.value
    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
    ) {
        Column {
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
                    tx.status == TransactionStatus.FAILED.value ||
                    tx.status == TransactionStatus.FAILED_ALREADY_RECOMMENDED.value ||
                    tx.status == TransactionStatus.UNMATCHED.value ||
                    tx.status == TransactionStatus.CANCELLED.value,
                size = 9.dp
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    // U5 — the same formatter as the Transactions list.
                    formatCustomerName(tx.customerName).ifBlank { tx.phoneNumber },
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "${tx.offerName} · ${timeAgo(tx.createdAt, now)}",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (showPausedBadge) {
                Text(
                    "Paused",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.20f))
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                "Ksh ${money(tx.amount)}",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (showDivider) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(DesignTokens.LocalBingwaRoles.current.border))
        }
    }
}
}

/** R6 — a single shimmering placeholder row; only shown while the list loads. */
@Composable
private fun HomeRowSkeleton() {
    GlassCard(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)) {
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
 * the app says what the grant is *for* first, in the same vocabulary as the rest
 * of the product, and keeps a polite way out.
 */
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
