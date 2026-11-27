package com.bingwascore.app.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material.icons.rounded.BarChart
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
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
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.max
import kotlinx.coroutines.delay

private const val MASK = "******"
private const val CLOCK_BUCKET_MILLIS = 30_000L
private val HOME_ROW_HEIGHT = 44.dp

/**
 * S68 — pure Home state. Everything the screen renders comes from here.
 */
data class HomeScreenState(
    val greetingBucket: Greetings.Bucket = Greetings.Bucket.MORNING,
    val greetingLanguage: Greetings.Language = Greetings.Language.SWAHILI,
    val userName: String = "",
    val creditsLabel: String = "0",
    val creditsPlanName: String = "",
    val creditsExpiry: Long = 0L,
    val payoutCommission: Double = 0.0,
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
    val cheapestOfferPrice: Double = 0.0,
    val ladderEngineArmed: Boolean = false,
    val ladderTestDriveDone: Boolean = false,
    val ladderImportBookDone: Boolean = false,
    val ladderRecoverFailureDone: Boolean = false,
    val ladderHidden: Boolean = false
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
    val onLadderRecoverFailure: () -> Unit = {},
    val onLadderHide: () -> Unit = {}
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
    val creditsExpiry by viewModel.creditsExpiry.collectAsStateWithLifecycle(0L)
    val weeklyCommission by viewModel.weeklyCommission.collectAsStateWithLifecycle()
    val planState by viewModel.planState.collectAsStateWithLifecycle()
    val themeMode by viewModel.userPreferences.themeMode.collectAsStateWithLifecycle(ThemeMode.PORCELAIN_DIM)
    val meshConnected by viewModel.userPreferences.meshConnected.collectAsStateWithLifecycle(false)
    var valuesVisible by remember { mutableStateOf(false) }
    var permissionsMissing by remember { mutableStateOf(missingPermissions(context)) }

    val ladderEngineArmed by viewModel.ladderEngineArmed.collectAsStateWithLifecycle()
    val ladderTestDriveDone by viewModel.ladderTestDriveDone.collectAsStateWithLifecycle()
    val ladderImportBookDone by viewModel.ladderImportBookDone.collectAsStateWithLifecycle()
    val ladderRecoverFailureDone by viewModel.ladderRecoverFailureDone.collectAsStateWithLifecycle()
    val ladderHidden by viewModel.ladderHidden.collectAsStateWithLifecycle()
    val userName by viewModel.userName.collectAsStateWithLifecycle()

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
        userName = userName,
        creditsLabel = creditsLabel,
        creditsPlanName = planState.displayName.ifBlank { "Credits" },
        creditsExpiry = creditsExpiry,
        payoutCommission = weeklyCommission,
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
        cheapestOfferPrice = cheapestOffer,
        ladderEngineArmed = ladderEngineArmed,
        ladderTestDriveDone = ladderTestDriveDone,
        ladderImportBookDone = ladderImportBookDone,
        ladderRecoverFailureDone = ladderRecoverFailureDone,
        ladderHidden = ladderHidden
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
        onLadderRecoverFailure = { viewModel.setLadderRecoverFailureDone(true) },
        onLadderHide = { viewModel.setLadderHidden(true) }
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

            item {
                Subtabs(selected = selectedSubtab, onSelect = { selectedSubtab = it })
            }

            if (state.isOffline) {
                item { OfflineMeshBanner(queuedCount = state.queuedCount, onFlush = {}) }
            }

            if (state.balanceBelowCheapestOffer) {
                item { FloatGuardBanner(balance = state.balance ?: 0.0, cheapestPrice = state.cheapestOfferPrice, onTopUp = callbacks.onOpenMyPlan) }
            }

            item {
                ActivationLadderCard(
                    engineArmed = state.ladderEngineArmed,
                    testDriveDone = state.ladderTestDriveDone,
                    importBookDone = state.ladderImportBookDone,
                    recoverFailureDone = state.ladderRecoverFailureDone,
                    ladderHidden = state.ladderHidden,
                    onEngineArmedClick = callbacks.onLadderEngineArmed,
                    onTestDriveClick = callbacks.onLadderTestDrive,
                    onImportBookClick = callbacks.onLadderImportBook,
                    onRecoverFailureClick = callbacks.onLadderRecoverFailure,
                    onHide = callbacks.onLadderHide
                )
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
    val heroShape = RoundedCornerShape(DesignTokens.HomeTokens.HeroRadius)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(heroShape)
            .background(DesignTokens.HomeTokens.HeroBackground)
            .drawBehind {
                drawCircle(
                    color = Color(0xFF7C3AED).copy(alpha = 0.38f),
                    radius = size.width * 0.45f,
                    center = Offset(size.width * 0.9f, size.height * 0.02f)
                )
                drawCircle(
                    color = Color(0xFFA4F510).copy(alpha = 0.16f),
                    radius = size.width * 0.38f,
                    center = Offset(size.width * 0.02f, size.height * 0.98f)
                )
            }
            .padding(DesignTokens.HomeTokens.HeroPadding)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.HRowGap),
                verticalAlignment = Alignment.Top
            ) {
                AutopilotEye(engineState = state.engineState)
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = greetingText(state.greetingBucket),
                        color = DesignTokens.HomeTokens.TileInk.copy(alpha = DesignTokens.HomeTokens.GreetingOpacity),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = state.userName,
                        color = DesignTokens.HomeTokens.TileInk,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = DesignTokens.HomeTokens.GreetingNLetterSpacing,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                CreditsBox(expiry = state.creditsExpiry, planName = state.creditsPlanName, onClick = callbacks.onOpenMyPlan)
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.BalrowGap),
                modifier = Modifier.padding(bottom = 2.dp)
            ) {
                Text(
                    text = "${state.completedToday}",
                    color = DesignTokens.HomeTokens.TileInk,
                    fontSize = DesignTokens.HomeTokens.BignumSize,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = DesignTokens.HomeTokens.BignumLetterSpacing,
                    lineHeight = 34.5.sp
                )
                FailedBulb(count = state.unseenFailed, onClick = {
                    callbacks.onClearUnseenFailures()
                    callbacks.onOpenTransactions("FAILED")
                })
            }

            Text(
                text = "completed today",
                color = DesignTokens.HomeTokens.TileInk.copy(alpha = DesignTokens.HomeTokens.SublblOpacity),
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = DesignTokens.HomeTokens.SublblMarginBottom)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.TilesGap),
                modifier = Modifier.fillMaxWidth()
            ) {
                QuickActionTile(icon = Icons.Rounded.Phone, label = "Dial", onClick = callbacks.onOpenDial, modifier = Modifier.weight(1f))
                QuickActionTile(icon = Icons.Rounded.BarChart, label = "Stats", onClick = callbacks.onOpenStats, modifier = Modifier.weight(1f))
                QuickActionTile(icon = Icons.Rounded.GridView, label = "Manage", onClick = callbacks.onOpenManage, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun AutopilotEye(engineState: EngineState) {
    val on = engineState == EngineState.RUNNING
    val shape = RoundedCornerShape(DesignTokens.HomeTokens.EyeRadius)
    Box(
        modifier = Modifier
            .size(DesignTokens.HomeTokens.EyeSize)
            .clip(shape)
            .background(if (on) DesignTokens.HomeTokens.EyeOnFill else DesignTokens.HomeTokens.EyeOffFill)
            .border(1.dp, if (on) DesignTokens.HomeTokens.EyeOnBorder else DesignTokens.HomeTokens.EyeOffBorder, shape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (on) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
            contentDescription = if (on) "Autopilot on" else "Autopilot off",
            tint = if (on) DesignTokens.HomeTokens.EyeOnBorder else DesignTokens.HomeTokens.EyeOffBorder,
            modifier = Modifier.size(19.dp)
        )
    }
}

@Composable
private fun FailedBulb(count: Int, onClick: () -> Unit) {
    val blinking = count > 0
    val infiniteTransition = rememberInfiniteTransition(label = "bulbBlink")
    val glow by infiniteTransition.animateFloat(
        initialValue = 0.28f,
        targetValue = 0.55f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bulbGlow"
    )
    val alpha = if (blinking) glow else DesignTokens.HomeTokens.BulbColdOpacity
    Box(
        modifier = Modifier
            .size(DesignTokens.HomeTokens.BulbSize)
            .clip(CircleShape)
            .background(DesignTokens.HomeTokens.BulbHotFill.copy(alpha = alpha))
            .border(1.dp, DesignTokens.HomeTokens.BulbHotBorder, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (count > 0) {
            Text(
                text = "$count",
                color = DesignTokens.HomeTokens.TileInk,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CreditsBox(expiry: Long, planName: String, onClick: () -> Unit) {
    var now by remember { mutableLongStateOf(System.currentTimeMillis()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(60_000L)
            now = System.currentTimeMillis()
        }
    }
    val remaining = (expiry - now).coerceAtLeast(0L)
    val days = remaining / 86_400_000L
    val hours = (remaining % 86_400_000L) / 3_600_000L
    val minutes = (remaining % 3_600_000L) / 60_000L
    val countdown = String.format(Locale.US, "%dd %02dh %02dm", days, hours, minutes)
    val shape = RoundedCornerShape(DesignTokens.HomeTokens.CredboxRadius)

    Column(
        modifier = Modifier
            .width(DesignTokens.HomeTokens.CredboxWidth)
            .clip(shape)
            .background(Color(0x1AFFFFFF))
            .border(1.dp, DesignTokens.HomeTokens.CredboxBorder, shape)
            .clickable(onClick = onClick)
            .padding(horizontal = DesignTokens.HomeTokens.CredboxPaddingHorizontal, vertical = DesignTokens.HomeTokens.CredboxPaddingVertical)
    ) {
        Text(
            text = "CREDITS EXPIRE",
            color = DesignTokens.HomeTokens.TileInk.copy(alpha = DesignTokens.HomeTokens.CredboxLabelOpacity),
            fontSize = 9.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.5.sp,
            maxLines = 1
        )
        Text(
            text = countdown,
            color = DesignTokens.HomeTokens.CredboxCountdownColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            maxLines = 1
        )
        Text(
            text = planName.ifBlank { "Starter plan" },
            color = DesignTokens.HomeTokens.TileInk.copy(alpha = DesignTokens.HomeTokens.CredboxPlanOpacity),
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun QuickActionTile(icon: ImageVector, label: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val scale = remember { Animatable(1f) }
    val shape = RoundedCornerShape(DesignTokens.HomeTokens.TileRadius)
    Column(
        modifier = modifier
            .height(48.dp)
            .clip(shape)
            .background(DesignTokens.HomeTokens.TileFill)
            .border(1.dp, DesignTokens.HomeTokens.TileBorder, shape)
            .clickable {
                scope.launch {
                    scale.animateTo(DesignTokens.HomeTokens.TilePressScale, tween(DesignTokens.HomeTokens.TilePressDuration, easing = FastOutLinearInEasing))
                    scale.animateTo(1f, spring(stiffness = 400f, dampingRatio = 0.5f))
                }
                onClick()
            }
            .graphicsLayer { scaleX = scale.value; scaleY = scale.value }
            .padding(vertical = DesignTokens.HomeTokens.TilePaddingVertical, horizontal = DesignTokens.HomeTokens.TilePaddingHorizontal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = DesignTokens.HomeTokens.TileInk,
            modifier = Modifier.size(DesignTokens.HomeTokens.TileIconSize)
        )
        Text(
            text = label,
            color = Color(0xFFF8FAFC),
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun OfflineMeshBanner(queuedCount: Int, onFlush: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.BannerGap),
            modifier = Modifier.padding(DesignTokens.HomeTokens.BannerPadding)
        ) {
            Box(modifier = Modifier.width(DesignTokens.HomeTokens.BannerLeftRule).fillMaxHeight().background(DesignTokens.HomeTokens.BannerInfoColor))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Offline mesh", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "$queuedCount queued locally - they send on reconnect", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(DesignTokens.HomeTokens.HeroBackground)
                    .clickable(onClick = onFlush)
                    .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
                Text(
                    text = "Flush now",
                    color = DesignTokens.HomeTokens.TileInk,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun FloatGuardBanner(balance: Double, cheapestPrice: Double, onTopUp: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.BannerGap),
            modifier = Modifier.padding(DesignTokens.HomeTokens.BannerPadding)
        ) {
            Box(modifier = Modifier.width(DesignTokens.HomeTokens.BannerLeftRule).fillMaxHeight().background(DesignTokens.Semantic.failed))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Float too low to dial", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Ksh ${money(balance)} left - cheapest offer needs Ksh ${money(cheapestPrice)}", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(DesignTokens.HomeTokens.HeroBackground)
                    .clickable(onClick = onTopUp)
                    .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
                Text(
                    text = "Top up",
                    color = DesignTokens.HomeTokens.TileInk,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun Subtabs(selected: Int, onSelect: (Int) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.SubtabsGap), modifier = Modifier.fillMaxWidth()) {
        listOf("Offers", "Settings").forEachIndexed { index, label ->
            val active = index == selected
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.HomeTokens.SubtabsButtonRadius))
                    .background(if (active) DesignTokens.HomeTokens.SubtabsActiveFill else DesignTokens.HomeTokens.SubtabsInactiveFill)
                    .border(1.dp, if (active) DesignTokens.HomeTokens.SubtabsActiveFill else DesignTokens.LocalBingwaRoles.current.border, RoundedCornerShape(DesignTokens.HomeTokens.SubtabsButtonRadius))
                    .clickable { onSelect(index) }
                    .padding(vertical = DesignTokens.HomeTokens.SubtabsButtonPaddingVertical),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = if (active) DesignTokens.HomeTokens.SubtabsActiveInk else DesignTokens.HomeTokens.SubtabsInactiveInk,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun ActivationLadderCard(
    engineArmed: Boolean,
    testDriveDone: Boolean,
    importBookDone: Boolean,
    recoverFailureDone: Boolean,
    ladderHidden: Boolean,
    onEngineArmedClick: () -> Unit,
    onTestDriveClick: () -> Unit,
    onImportBookClick: () -> Unit,
    onRecoverFailureClick: () -> Unit,
    onHide: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tasks = listOf(
        LadderItem("Arm the engine", "Grant SMS + Phone so autopilot can dial.", engineArmed, onEngineArmedClick),
        LadderItem("Test drive a payment", "One sandbox credit, zero real money.", testDriveDone, onTestDriveClick),
        LadderItem("Import your book", "CSV or link existing customers.", importBookDone, onImportBookClick),
        LadderItem("Recover a failure", "Retry one failed transaction.", recoverFailureDone, onRecoverFailureClick)
    )
    val completed = tasks.count { it.done }
    val allDone = completed == tasks.size
    var showArmed by remember { mutableStateOf(false) }
    LaunchedEffect(allDone) {
        if (allDone) {
            showArmed = true
            delay(2500L)
            showArmed = false
            onHide()
        }
    }

    AnimatedVisibility(
        visible = !ladderHidden,
        exit = shrinkVertically(animationSpec = tween(220)) + fadeOut(animationSpec = tween(220)),
        modifier = modifier
    ) {
        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ProgressRing(completed = completed, total = tasks.size)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Activation ladder",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Four first wins arm the autopilot",
                            color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                tasks.forEach { task ->
                    TaskRow(task = task)
                    Spacer(modifier = Modifier.height(10.dp))
                }

                AnimatedVisibility(visible = showArmed, enter = fadeIn() + expandVertically()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(DesignTokens.HomeTokens.ArmedRadius))
                            .background(DesignTokens.HomeTokens.ArmedFill)
                            .padding(horizontal = DesignTokens.HomeTokens.ArmedPaddingHorizontal, vertical = DesignTokens.HomeTokens.ArmedPaddingVertical)
                    ) {
                        Text(
                            text = "Autopilot armed · streak day 1 · retry queue active",
                            color = DesignTokens.HomeTokens.ArmedInk,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

private data class LadderItem(val title: String, val caption: String, val done: Boolean, val onClick: () -> Unit)

@Composable
private fun TaskRow(task: LadderItem) {
    val tileShape = RoundedCornerShape(DesignTokens.HomeTokens.LadderTaskTileRadius)
    val tileColor = if (task.done) DesignTokens.HomeTokens.LadderTaskDoneFill else Color.Transparent
    val iconTint = if (task.done) DesignTokens.HomeTokens.ArmedInk else DesignTokens.LocalBingwaRoles.current.textSecondary

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = task.onClick)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(DesignTokens.HomeTokens.LadderTaskTileSize)
                .clip(tileShape)
                .background(tileColor)
                .border(1.dp, if (task.done) DesignTokens.HomeTokens.LadderTaskDoneFill else DesignTokens.LocalBingwaRoles.current.border, tileShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (task.done) Icons.Rounded.Check else Icons.Rounded.Add,
                contentDescription = if (task.done) "Done" else "Pending",
                tint = iconTint,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = task.title,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = task.caption,
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = 12.sp
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (task.done) DesignTokens.HomeTokens.ApillDoneFill else DesignTokens.HomeTokens.ApillActionFill)
                .padding(horizontal = DesignTokens.HomeTokens.ApillPaddingHorizontal, vertical = DesignTokens.HomeTokens.ApillPaddingVertical)
        ) {
            Text(
                text = if (task.done) "DONE" else "ACTION",
                color = if (task.done) DesignTokens.HomeTokens.ArmedInk else DesignTokens.HomeTokens.TileInk,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ProgressRing(completed: Int, total: Int) {
    val allDone = completed == total
    val progress = completed.toFloat() / total.toFloat().coerceAtLeast(1f)
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(DesignTokens.HomeTokens.LadderRingSize),
            color = if (allDone) DesignTokens.HomeTokens.LadderRingAllDone else DesignTokens.HomeTokens.LadderRingProgress,
            trackColor = DesignTokens.HomeTokens.LadderRingTrack,
            strokeWidth = DesignTokens.HomeTokens.LadderRingStroke
        )
        Text(
            text = "$completed",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.offersSection(
    state: HomeScreenState,
    callbacks: HomeScreenCallbacks,
    now: Long
) {
    item { PayoutCard(state.payoutCommission) }

    item {
        var selectedCategory by remember { mutableStateOf("All") }
        val categories = listOf("All", "Data", "Minutes", "SMS")
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.HomeTokens.CatsGap),
            modifier = Modifier.fillMaxWidth()
        ) {
            categories.forEach { cat ->
                val active = cat == selectedCategory
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DesignTokens.HomeTokens.CatsButtonRadius))
                        .background(if (active) DesignTokens.HomeTokens.CatsActiveFill else DesignTokens.HomeTokens.CatsInactiveFill)
                        .border(1.dp, if (active) DesignTokens.HomeTokens.CatsActiveFill else DesignTokens.LocalBingwaRoles.current.border, RoundedCornerShape(DesignTokens.HomeTokens.CatsButtonRadius))
                        .clickable { selectedCategory = cat }
                        .padding(horizontal = DesignTokens.HomeTokens.CatsButtonPaddingHorizontal, vertical = DesignTokens.HomeTokens.CatsButtonPaddingVertical)
                ) {
                    Text(
                        text = cat,
                        color = if (active) DesignTokens.HomeTokens.CatsActiveInk else DesignTokens.HomeTokens.CatsInactiveInk,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }

    if (state.offers.isNotEmpty()) {
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "My offers", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                Text(
                    text = "+ Add",
                    color = DesignTokens.HomeTokens.LinkColor,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.clickable { }
                )
            }
        }
        item {
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    state.offers.forEachIndexed { index, offer ->
                        OfferRow(offer = offer, onToggle = { })
                        if (index < state.offers.size - 1) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(DesignTokens.LocalBingwaRoles.current.border))
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
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
        item {
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    state.transactions.forEachIndexed { index, tx ->
                        HomeTransactionRow(tx = tx, now = now, showDivider = index < state.transactions.size - 1)
                    }
                }
            }
        }
    }
}

@Composable
private fun PayoutCard(commission: Double) {
    var now by remember { mutableLongStateOf(System.currentTimeMillis()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(60_000L)
            now = System.currentTimeMillis()
        }
    }
    val calendar = java.util.Calendar.getInstance()
    calendar.timeInMillis = now
    val daysUntilFriday = ((Calendar.FRIDAY - calendar.get(Calendar.DAY_OF_WEEK) + 7) % 7).coerceAtLeast(1)
    val target = calendar.apply {
        add(Calendar.DAY_OF_WEEK, daysUntilFriday)
        set(Calendar.HOUR_OF_DAY, 17)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis
    val remaining = (target - now).coerceAtLeast(0L)
    val days = remaining / 86_400_000L
    val hours = (remaining % 86_400_000L) / 3_600_000L
    val minutes = (remaining % 3_600_000L) / 60_000L
    val countdown = String.format(Locale.US, "%dd %02dh %02dm", days, hours, minutes)
    val goal = 1000.0
    val progress = (commission / goal).toFloat().coerceIn(0f, 1f)

    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Payout day", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
                Text(
                    text = countdown,
                    color = DesignTokens.LocalBingwaRoles.current.brand,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Commission this week Ksh ${money(commission)}",
                    color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                    fontSize = 12.sp
                )
                Text(
                    text = "goal Ksh 1,000",
                    color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DesignTokens.HomeTokens.PayoutBarHeight)
                    .clip(RoundedCornerShape(DesignTokens.HomeTokens.PayoutBarRadius))
                    .background(DesignTokens.LocalBingwaRoles.current.border)
            ) {
                val barWidth = (progress * maxWidth.value).dp.coerceAtLeast(DesignTokens.HomeTokens.PayoutBarMinWidth)
                Box(
                    modifier = Modifier
                        .width(barWidth)
                        .fillMaxHeight()
                        .background(
                            Brush.horizontalGradient(
                                listOf(DesignTokens.HomeTokens.PayoutBarGradientStart, DesignTokens.HomeTokens.PayoutBarGradientEnd)
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(DesignTokens.HomeTokens.PayoutBarGoalTickWidth)
                        .fillMaxHeight()
                        .background(Color(0xFF0B0B10).copy(alpha = 0.5f))
                )
            }
        }
    }
}

@Composable
private fun OfferRow(offer: Offer, onToggle: (Boolean) -> Unit) {
    var active by remember { mutableStateOf(offer.isActive) }
    val knobOffset = if (active) DesignTokens.HomeTokens.TglWidth - DesignTokens.HomeTokens.TglKnobSize - 3.dp else 3.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = offer.name, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "${offer.type.uppercase()} · ${offer.ussdCode}", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
        }
        Text(text = "Ksh ${offer.price}", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .size(width = DesignTokens.HomeTokens.TglWidth, height = DesignTokens.HomeTokens.TglHeight)
                .clip(RoundedCornerShape(DesignTokens.HomeTokens.TglRadius))
                .background(if (active) DesignTokens.HomeTokens.TglOnFill else DesignTokens.HomeTokens.TglOffFill)
                .clickable { active = !active; onToggle(active) }
        ) {
            Box(
                modifier = Modifier
                    .size(DesignTokens.HomeTokens.TglKnobSize)
                    .offset(x = knobOffset)
                    .clip(CircleShape)
                    .background(Color(0xFF0B0B10))
                    .align(Alignment.CenterStart)
            )
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
                    val atRisk = customer.txCount <= 2
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(DesignTokens.HomeTokens.CustAvatarSize)
                                .clip(CircleShape)
                                .background(DesignTokens.HomeTokens.CustAvatarFill),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = initials(formatCustomerName(customer.name)),
                                color = DesignTokens.HomeTokens.TileInk,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = formatCustomerName(customer.name),
                                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Ksh ${money(customer.totalSpent)} · ${customer.txCount} purchases",
                                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                                fontSize = 12.sp
                            )
                        }
                        if (atRisk) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .background(DesignTokens.HomeTokens.RiskFill)
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(text = "at risk", color = DesignTokens.HomeTokens.RiskInk, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Follow up",
                                color = DesignTokens.HomeTokens.LinkColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable { }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun initials(name: String): String {
    val parts = name.trim().split(" ").filter { it.isNotBlank() }
    return when {
        parts.size >= 2 -> "${parts.first().first().uppercaseChar()}${parts.last().first().uppercaseChar()}"
        parts.isNotEmpty() -> parts.first().take(2).uppercase()
        else -> "?"
    }
}

/** Maps a greeting bucket to a plain English sentence — never the enum name. */
private fun greetingText(bucket: Greetings.Bucket): String = when (bucket) {
    Greetings.Bucket.EARLY_MORNING,
    Greetings.Bucket.MORNING,
    Greetings.Bucket.MID_MORNING -> "Good morning"
    Greetings.Bucket.AFTERNOON,
    Greetings.Bucket.LATE_AFTERNOON -> "Good afternoon"
    Greetings.Bucket.EVENING -> "Good evening"
    Greetings.Bucket.NIGHT -> "Good night"
}

private fun androidx.compose.foundation.lazy.LazyListScope.settingsSection(callbacks: HomeScreenCallbacks) {
    item { GroupHeader("MESSAGE PROCESSING") }
    item {
        SettingsCard {
            ToggleRow(title = "Process M-Pesa messages")
            ToggleRow(title = "Process SiteLink messages")
        }
    }
    item { GroupHeader("CUSTOMERS BOOK") }
    item {
        SettingsCard {
            ToggleRow(title = "Auto-save customers", caption = "Add every completed buyer to the book")
        }
    }
    item { GroupHeader("PREFERENCES") }
    item {
        SettingsCard {
            LinkRow(title = "Appearance", caption = "Light, dark or follow system")
            LinkRow(title = "Processing mode", caption = "How transactions execute")
            LinkRow(title = "SIM selection", caption = "Line used for dialing")
            LinkRow(title = "Test Drive", caption = "Sandbox credits, zero real money")
            LinkRow(title = "Server", caption = "Backend base URL")
        }
    }
    item { GroupHeader("ACCOUNT & DATA") }
    item {
        SettingsCard {
            LinkRow(title = "Backup & Restore", caption = "Export or import your data as JSON")
            LinkRow(title = "Feature blueprint", caption = "Trigger - surface - metric map")
            LinkRow(title = "Activation", caption = "Armed · 4/4 complete")
        }
    }
}

@Composable
private fun GroupHeader(label: String) {
    Text(
        text = label,
        color = DesignTokens.HomeTokens.GrouphColor,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = DesignTokens.HomeTokens.GrouphLetterSpacing,
        modifier = Modifier.padding(start = DesignTokens.HomeTokens.GrouphMarginHorizontal, top = DesignTokens.HomeTokens.GrouphMarginTop, bottom = DesignTokens.HomeTokens.GrouphMarginBottom)
    )
}

@Composable
private fun SettingsCard(content: @Composable ColumnScope.() -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) { content() }
    }
}

@Composable
private fun LinkRow(title: String, caption: String, onClick: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = caption, color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
        }
        Text(text = "Open", color = DesignTokens.HomeTokens.LinkColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ToggleRow(title: String, caption: String? = null) {
    var on by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { on = !on }
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            if (caption != null) {
                Text(text = caption, color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp)
            }
        }
        Box(
            modifier = Modifier
                .size(width = DesignTokens.HomeTokens.TglWidth, height = DesignTokens.HomeTokens.TglHeight)
                .clip(RoundedCornerShape(DesignTokens.HomeTokens.TglRadius))
                .background(if (on) DesignTokens.HomeTokens.TglOnFill else DesignTokens.HomeTokens.TglOffFill)
        ) {
            Box(
                modifier = Modifier
                    .size(DesignTokens.HomeTokens.TglKnobSize)
                    .offset(x = if (on) DesignTokens.HomeTokens.TglWidth - DesignTokens.HomeTokens.TglKnobSize - 3.dp else 3.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0B0B10))
                    .align(Alignment.CenterStart)
            )
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
    val status = TransactionStatus.fromValue(tx.status)
    val (statusColor, statusIcon, statusLabel) = when (status) {
        TransactionStatus.SUCCESSFUL -> Triple(DesignTokens.Semantic.complete, Icons.Rounded.Check, "Completed")
        TransactionStatus.FAILED,
        TransactionStatus.FAILED_ALREADY_RECOMMENDED,
        TransactionStatus.CANCELLED,
        TransactionStatus.UNMATCHED -> Triple(DesignTokens.Semantic.failed, Icons.Rounded.Close, "Failed")
        TransactionStatus.PENDING,
        TransactionStatus.PROCESSING -> Triple(DesignTokens.Semantic.scheduled, Icons.Rounded.HourglassTop, "Queued")
        else -> Triple(DesignTokens.Semantic.info, Icons.Rounded.Schedule, "Awaiting")
    }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().height(HOME_ROW_HEIGHT).padding(horizontal = 12.dp)
        ) {
            Box(
                modifier = Modifier.size(40.dp).clip(RoundedCornerShape(8.dp)).background(statusColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = statusIcon, contentDescription = statusLabel, tint = DesignTokens.Hero.ink, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = formatCustomerName(tx.customerName).ifBlank { tx.phoneNumber }, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = "${tx.offerName} · ${timeAgo(tx.createdAt, now)}", color = DesignTokens.LocalBingwaRoles.current.textSecondary, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
            Text(text = "Ksh ${money(tx.amount)}", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(statusColor)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = statusLabel, color = DesignTokens.Hero.ink, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
        if (showDivider) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(DesignTokens.LocalBingwaRoles.current.border))
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
