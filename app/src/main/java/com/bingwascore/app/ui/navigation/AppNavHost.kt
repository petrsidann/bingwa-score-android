package com.bingwascore.app.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import com.bingwascore.app.ui.glass.GlassSpec
import com.bingwascore.app.ui.glass.iosMaterial
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.glass.canMaterialBlur
import com.bingwascore.app.ui.glass.glassBackdropRegion
import com.bingwascore.app.ui.glass.glassSource
import com.bingwascore.app.ui.glass.rememberGlassBackdrop
import com.bingwascore.app.ui.theme.isPorcelain
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.DeviceHub
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SmartToy
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material.icons.rounded.WorkspacePremium
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import com.bingwascore.app.BuildConfig
import com.bingwascore.app.ui.autorenewals.AutoRenewalsScreen
import com.bingwascore.app.ui.autoreplies.AutoRepliesScreen
import com.bingwascore.app.ui.components.DarkSnackbarHost
import com.bingwascore.app.ui.components.ScreenTransition
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.dialer.DialerScreen
import com.bingwascore.app.ui.diplomatics.DiplomaticsScreen
import com.bingwascore.app.ui.engagebot.EngageBotScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.mesh.MeshScreen
import com.bingwascore.app.ui.myplan.MyPlanScreen
import com.bingwascore.app.ui.mystore.MyStoreScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.screens.LoginScreen
import com.bingwascore.app.ui.screens.SplashScreen
import com.bingwascore.app.ui.onboarding.SetupChecklistScreen
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.transactions.TransactionFilter
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.data.remote.RemoteHttpClient
import com.bingwascore.app.score.ScoreScreen
import com.bingwascore.app.util.rememberHaptics
import androidx.compose.material.icons.rounded.Groups
import com.bingwascore.app.ui.community.CommunityScreen
import com.bingwascore.app.profile.ProfileScreen
import com.bingwascore.app.referral.ReferralScreen
import com.bingwascore.app.announcements.AnnouncementsScreen
import com.bingwascore.app.ui.auth.EmailOtpScreen
import com.bingwascore.app.ui.auth.PinSetupScreen
import com.bingwascore.app.ui.coupons.RedeemCouponScreen
import com.bingwascore.app.ui.onboarding.OnboardingCarousel
import androidx.compose.material.icons.rounded.Redeem
import androidx.compose.material.icons.rounded.Campaign
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.EmojiEvents
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.showcase.DemoChip
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.DisplayModeState
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextWhite
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import com.bingwascore.app.ui.home.HomePreWarmViewModel

object Routes {
    const val SPLASH = "splash"
    const val ONBOARDING = "onboarding"
    const val LOGIN = "login"
    const val EMAIL_OTP = "email_otp"
    const val PIN_SETUP = "pin_setup"
    const val SETUP_CHECKLIST = "setup_checklist"
    const val MAIN = "main"
}

@Composable
fun AppNavHost(remoteHttpClient: RemoteHttpClient) {
    val navController = rememberNavController()
    val splashViewModel: SplashViewModel = hiltViewModel()
    // Stage 11 — open Room (first snapshot) during the splash cinematic so the
    // sign-in → home hand-off lands on warm data, never a blank frame.
    val homePreWarm: HomePreWarmViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val startDestination by splashViewModel.startDestination.collectAsState(initial = null)

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH,
        // Stage 11 — 200ms crossfade on every hand-off: the outgoing route
        // fades out while the incoming one fades in, so no frame ever renders
        // between two destinations (the sign-in → home black gap, gone).
        enterTransition = { fadeIn(tween(Motion.NAV_CROSSFADE)) },
        exitTransition = { fadeOut(tween(Motion.NAV_CROSSFADE)) },
        popEnterTransition = { fadeIn(tween(Motion.NAV_CROSSFADE)) },
        popExitTransition = { fadeOut(tween(Motion.NAV_CROSSFADE)) }
    ) {
        composable(Routes.SPLASH) {
            // Single decision point: splash -> onboarding (first launch only) -> login -> main.
            val targetRoute = when (startDestination) {
                StartDestination.Onboarding -> Routes.ONBOARDING
                StartDestination.Login -> Routes.LOGIN
                StartDestination.SetupChecklist -> Routes.SETUP_CHECKLIST
                StartDestination.Main -> Routes.MAIN
                null -> null
            }
            SplashScreen(target = targetRoute, onFinish = { route ->
                navController.navigate(route) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
        composable(Routes.ONBOARDING) {
            var page by remember { mutableStateOf(0) }
            OnboardingCarousel(
                onGetStarted = {
                    scope.launch { splashViewModel.markOnboardingDone() }
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                page = page,
                onPageChange = { page = it }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen(
                onSignIn = {
                    // After sign-in the user lands on the setup checklist, which
                    // auto-forwards to the main screen once setup is complete.
                    navController.navigate(Routes.SETUP_CHECKLIST) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                onCreateAccount = {
                    navController.navigate(Routes.PIN_SETUP)
                }
            )
        }

        // MEGA B — server-backed auth scaffolds. Reachable today, fully
        // functional offline; they flip to real once BASE_URL + keys land.
        composable(Routes.EMAIL_OTP) {
            EmailOtpScreen(
                onVerified = {
                    navController.navigate(Routes.SETUP_CHECKLIST) {
                        popUpTo(Routes.EMAIL_OTP) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.PIN_SETUP) {
            PinSetupScreen(
                onComplete = {
                    navController.navigate(Routes.SETUP_CHECKLIST) {
                        popUpTo(Routes.PIN_SETUP) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.SETUP_CHECKLIST) {
            SetupChecklistScreen(
                onSetupComplete = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.SETUP_CHECKLIST) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.MAIN) {
            MainScreen(remoteHttpClient)
        }
    }
}

internal data class DrawerEntry(val label: String, val icon: ImageVector)

/**
 * Drawer indexes of the destinations built so far. These MUST stay in the same
 * order as [drawerEntries] — the index is the route key.
 *
 * Stage 14 cleanup: Trusted Partners, QR Scanner, Blocked Contacts and
 * Subscriptions were retired (blocking now lives inside the Customers book as a
 * filter chip), so the list below is one shorter and re-indexed.
 */
private const val CUSTOMERS_DRAWER_INDEX = 0
private const val AUTO_RENEWALS_DRAWER_INDEX = 1
private const val SMART_FOLLOW_UP_DRAWER_INDEX = 2
private const val AUTOPILOT_DRAWER_INDEX = 3
private const val AGENT_PORTAL_DRAWER_INDEX = 4
private const val MESH_DRAWER_INDEX = 5
private const val REDEEM_COUPON_DRAWER_INDEX = 6
private const val SETTINGS_DRAWER_INDEX = 7
private const val ANNOUNCEMENTS_DRAWER_INDEX = 8
private const val MY_SCORE_DRAWER_INDEX = 9
private const val COMMUNITY_DRAWER_INDEX = 10
private const val MY_PLAN_DRAWER_INDEX = 11
private const val DIPLOMATICS_DRAWER_INDEX = 12

internal val drawerEntries = listOf(
    DrawerEntry("Customers", Icons.Rounded.People),
    DrawerEntry("Auto Renewals", Icons.Rounded.Autorenew),
    DrawerEntry("Smart Follow-Up", Icons.Rounded.SmartToy),
    DrawerEntry("Autopilot", Icons.Rounded.Bolt),
    DrawerEntry("Agent Portal", Icons.Rounded.Storefront),
    DrawerEntry("Bingwa Mesh", Icons.Rounded.DeviceHub),
    DrawerEntry("Redeem Coupon", Icons.Rounded.Redeem),
    DrawerEntry("Settings", Icons.Rounded.Settings),
    DrawerEntry("Announcements", Icons.Rounded.Campaign),
    DrawerEntry("My Score", Icons.Rounded.EmojiEvents),
    DrawerEntry("Community", Icons.Rounded.Groups),
    DrawerEntry("My Plan", Icons.Rounded.WorkspacePremium),
    DrawerEntry("Diplomatics", Icons.Rounded.Language)
)

/**
 * App shell: tabs (Home / Offers / Transactions / Profile) behind a glass
 * bottom navigation bar with a center gradient dialer FAB, plus a drawer for
 * the secondary destinations.
 */
@Composable
fun MainScreen(remoteHttpClient: RemoteHttpClient) {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedDrawerIndex by remember { mutableStateOf(-1) }
    var drawerOpen by remember { mutableStateOf(false) }
    var showDialer by remember { mutableStateOf(false) }
    var showReferral by remember { mutableStateOf(false) }
    // R2: Home counters hand a status filter over to the Transactions tab.
    var transactionFilter by remember { mutableStateOf(TransactionFilter.ALL) }
    val scope = rememberCoroutineScope()
    // Stage 33 — surface a "reconnected" snackbar whenever the network client
    // is rebuilt after a server URL change.
    val snackbarHostState = remember { SnackbarHostState() }
    val reconnectCount by remoteHttpClient.reconnectCount.collectAsState(initial = 0)
    LaunchedEffect(reconnectCount) {
        if (reconnectCount == 0) return@LaunchedEffect
        snackbarHostState.showSnackbar(
            message = "Reconnected to server",
            duration = SnackbarDuration.Short
        )
    }
    // Stage 18 — one backdrop registry for the shell: pill blur over the screens
    // recorded by glassSource (chrome sits outside the recorder).
    val glassBackdrop = rememberGlassBackdrop()

    // Stage 25 — System back handling across sheets, drawers, secondary routes, and tabs.
    // Zero dead ends: close active drawer/sheets first, return secondary drawer routes
    // or referral back to main, or return non-Home main tabs to Home (0).
    val hasBackAction = drawerOpen || showDialer || showReferral || selectedDrawerIndex != -1 || selectedTab != 0
    BackHandler(enabled = hasBackAction) {
        when {
            drawerOpen -> drawerOpen = false
            showDialer -> showDialer = false
            showReferral -> showReferral = false
            selectedDrawerIndex != -1 -> selectedDrawerIndex = -1
            selectedTab != 0 -> selectedTab = 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        CompositionLocalProvider(LocalGlassBackdrop provides glassBackdrop) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = BgBlack,
                contentWindowInsets = WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Top + WindowInsetsSides.Horizontal
                ),
                snackbarHost = { DarkSnackbarHost(hostState = snackbarHostState) },
                bottomBar = {
                    // U1 — single-active truth: the highlight is derived ONLY from
                    // the current route. Dialer open -> Dial (2). Drawer open ->
                    // no tab (-1). Otherwise the active tab.
                    val navSelected = when {
                        showDialer -> 2
                        drawerOpen -> -1
                        else -> selectedTab
                    }
                    BottomNavBar(
                        selected = navSelected,
                        dialerOpen = showDialer,
                        onSelect = {
                            // POLISH P1 — the dialer is a real destination, not an
                            // overlay: choosing any tab leaves it.
                            selectedTab = it
                            drawerOpen = false
                            showDialer = false
                        },
                        onDialer = {
                            drawerOpen = false
                            showDialer = true
                        },
                        onMenu = { drawerOpen = true }
                    )
                }
            ) { innerPadding ->
                val destination = when {
                    showDialer -> "dialer"
                    selectedDrawerIndex == CUSTOMERS_DRAWER_INDEX -> "customers"
                    selectedDrawerIndex == AUTO_RENEWALS_DRAWER_INDEX -> "autorenewals"
                    selectedDrawerIndex == SMART_FOLLOW_UP_DRAWER_INDEX -> "smartfollowup"
                    selectedDrawerIndex == AUTOPILOT_DRAWER_INDEX -> "autopilot"
                    selectedDrawerIndex == AGENT_PORTAL_DRAWER_INDEX -> "agentportal"
                    selectedDrawerIndex == MESH_DRAWER_INDEX -> "mesh"
                    selectedDrawerIndex == REDEEM_COUPON_DRAWER_INDEX -> "coupon"
                    selectedDrawerIndex == SETTINGS_DRAWER_INDEX -> "settings"
                    selectedDrawerIndex == ANNOUNCEMENTS_DRAWER_INDEX -> "announcements"
                    selectedDrawerIndex == MY_SCORE_DRAWER_INDEX -> "myscore"
                    selectedDrawerIndex == COMMUNITY_DRAWER_INDEX -> "community"
                    selectedDrawerIndex == MY_PLAN_DRAWER_INDEX -> "myplan"
                    selectedDrawerIndex == DIPLOMATICS_DRAWER_INDEX -> "diplomatics"
                    else -> when (selectedTab) {
                        0 -> "home"
                        1 -> "offers"
                        3 -> "transactions"
                        else -> "profile"
                    }
                }

                val resolved = if (showReferral) "referral" else destination

                // Stage 10 — flat canvas, no orbs: grouped cards carry the design.
                // Stage 18 — glassSource records this content as the backdrop the
                // pill/drawer blur passes replay (transactions move blurred behind).
                Box(modifier = Modifier.glassSource(glassBackdrop).fillMaxSize().background(BgBlack)) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        ScreenTransition(screenKey = resolved, modifier = Modifier.fillMaxSize()) {
                            when (resolved) {
                                "dialer" -> DialerScreen(onClose = { showDialer = false })
                                "customers" -> CustomersScreen()
                                "autorenewals" -> AutoRenewalsScreen()
                                "smartfollowup" -> AutoRepliesScreen()
                                "autopilot" -> EngageBotScreen()
                                "agentportal" -> MyStoreScreen()
                                "mesh" -> MeshScreen()
                                "coupon" -> RedeemCouponScreen()
                                "settings" -> SettingsScreen()
                                "announcements" -> AnnouncementsScreen()
                                "myscore" -> ScoreScreen()
                                "community" -> CommunityScreen()
                                "myplan" -> MyPlanScreen()
                                "diplomatics" -> DiplomaticsScreen()
                                "referral" -> ReferralScreen()
                                "home" -> HomeScreen(
                                    onOpenTransactions = { status ->
                                        transactionFilter = TransactionFilter.fromStatus(status)
                                        selectedTab = 3
                                        selectedDrawerIndex = -1
                                    },
                                    onOpenMyPlan = { selectedDrawerIndex = MY_PLAN_DRAWER_INDEX },
                                    onOpenDiplomatics = { selectedDrawerIndex = DIPLOMATICS_DRAWER_INDEX }
                                )
                                "offers" -> OffersScreen()
                                "transactions" -> TransactionsScreen(initialFilter = transactionFilter)
                                "profile" -> ProfileScreen(
                                    onMyStore = { selectedDrawerIndex = AGENT_PORTAL_DRAWER_INDEX },
                                    onReferEarn = { showReferral = true },
                                    onSettings = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX },
                                    onAbout = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX }
                                )
                                else -> ProfileScreen(
                                    onMyStore = { selectedDrawerIndex = AGENT_PORTAL_DRAWER_INDEX },
                                    onReferEarn = { showReferral = true },
                                    onSettings = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX },
                                    onAbout = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX }
                                )
                            }
                        }
                    }
                }
            }
        }

        // Stage 19 — spring side-sheet drawer (primary): hamburger tap opens the
        // drawer as an iosMaterial side-sheet with a spring slide (<300ms).
        // Stage 25 — Bottom-Nav Morph: vertical rail docked to drawer's right edge.
        SideDrawerSheet(
            isOpen = drawerOpen,
            onClose = { drawerOpen = false },
            glassBackdrop = glassBackdrop,
            selectedTab = selectedTab,
            showDialer = showDialer,
            onTabSelect = { tab ->
                selectedTab = tab
                drawerOpen = false
                showDialer = (tab == 2)
            }
        ) {
            DrawerContent(
                selectedIndex = selectedDrawerIndex,
                onEntryClick = { index ->
                    selectedDrawerIndex = index
                    drawerOpen = false
                }
            )
        }
    }
}
/**
 * Stage 10 — floating rounded tab pill (club.com style): inset 12dp margins,
 * 28dp corner radius, elevated shadow, 5 tabs, active = AccentBlue.
 *
 * U1 — single-active truth: every tab (including Dial) takes the SAME
 * resolved [selected] id, so two tabs can never light at once. Dial is
 * id 2; a drawer destination resolves to -1 (nothing lit). The pill body is
 * a translucent iOS material (blur ONLY here + sheets).
 */
@Composable
private fun BottomNavBar(
    selected: Int,
    dialerOpen: Boolean,
    onSelect: (Int) -> Unit,
    onDialer: () -> Unit,
    onMenu: () -> Unit
) {
    val haptics = rememberHaptics()
    // Stage 18 — the pill is a backdrop region: rows scroll BLURRED beneath it.
    val glassBackdrop = LocalGlassBackdrop.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            // U1 — sheet open = pill dimmed; the one lit tab still reads.
            .graphicsLayer { alpha = if (dialerOpen) 0.55f else 1f }
            .padding(horizontal = 12.dp)
            .navigationBarsPadding()
            .padding(bottom = 12.dp)
            // Stage 18 — backdrop region matches the pill's visual bounds.
            .glassBackdropRegion(glassBackdrop, "pill", RoundedCornerShape(28.dp))
            .shadow(12.dp, RoundedCornerShape(28.dp))
            .iosMaterial(
                shape = RoundedCornerShape(28.dp),
                tint = GlassSpec.scrimColor(isPorcelain),
                vibrancy = !canMaterialBlur
            )
            .padding(start = 2.dp, end = 8.dp, top = 6.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Menu",
            tint = TextGrey,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable { haptics.tick(); onMenu() }
                .padding(9.dp)
        )
        NavTab(Icons.Rounded.Home, "Home", selected == 0 && !dialerOpen) {
            haptics.tick(); onSelect(0)
        }
        NavTab(Icons.Rounded.LocalOffer, "Offers", selected == 1 && !dialerOpen) {
            haptics.tick(); onSelect(1)
        }
        NavTab(Icons.Rounded.Call, "Dial", dialerOpen) {
            haptics.press(); onDialer()
        }
        NavTab(Icons.AutoMirrored.Rounded.ReceiptLong, "Transactions", selected == 3 && !dialerOpen) {
            haptics.tick(); onSelect(3)
        }
        NavTab(Icons.Rounded.Person, "Profile", selected == 4 && !dialerOpen) {
            haptics.tick(); onSelect(4)
        }
    }
}

@Composable
private fun RowScope.NavTab(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val tint by animateColorAsState(
        targetValue = if (selected) AccentBlue else TextGrey,
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "navTint"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .weight(1f)
            .pressScale(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = tint,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            label,
            color = tint,
            fontSize = BingwaType.Micro,
            maxLines = 1,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

/**
 * Stage 19 — spring side-sheet drawer (primary): slides in from the left edge
 * with an iosMaterial background when [isOpen] is true; sits off-screen when
 * closed. A dimming backdrop taps to close. Hamburger→drawer <300ms spring.
 * Edge-pull is demoted to secondary — no longer the primary open gesture.
 */
@Composable
fun SideDrawerSheet(
    isOpen: Boolean,
    onClose: () -> Unit,
    glassBackdrop: com.bingwascore.app.ui.glass.GlassBackdropState? = null,
    selectedTab: Int = 0,
    showDialer: Boolean = false,
    onTabSelect: (Int) -> Unit = {},
    content: @Composable () -> Unit
) {
    val sheetWidth = 280f
    val offset by animateFloatAsState(
        targetValue = if (isOpen) 0f else -sheetWidth,
        animationSpec = spring(
            dampingRatio = Motion.DAMPING,
            stiffness = Spring.StiffnessHigh
        ),
        label = "sideDrawerSheet"
    )

    val currentTab = if (showDialer) 2 else selectedTab

    Box(modifier = Modifier.fillMaxSize()) {
        if (isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.35f))
                    .clickable(onClick = onClose)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .offset(x = offset.dp, y = 0.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(sheetWidth.dp)
                    .background(BgBlack)
                    .glassBackdropRegion(
                        glassBackdrop, "drawer",
                        RoundedCornerShape(0.dp), enabled = isOpen
                    )
                    .iosMaterial(
                        shape = RoundedCornerShape(0.dp),
                        tint = GlassSpec.scrimColor(isPorcelain),
                        vibrancy = !canMaterialBlur
                    )
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(top = 28.dp)) {
                    Row(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Bingwa Score",
                            color = TextWhite,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        DemoChip()
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    content()
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            VerticalNavRail(
                isOpen = isOpen,
                selected = currentTab,
                onSelect = onTabSelect
            )
        }
    }
}

/**
 * Stage 19 — drawer entry list: Customers → Diplomatics, including My Score
 * (analytics + achievements screen) at [MY_SCORE_DRAWER_INDEX].
 */
@Composable
fun DrawerContent(
    selectedIndex: Int,
    onEntryClick: (Int) -> Unit
) {
    drawerEntries.forEachIndexed { index, entry ->
        val selected = selectedIndex == index
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onEntryClick(index)
                }
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = entry.icon,
                contentDescription = entry.label,
                tint = if (selected) AccentBlue else TextWhite.copy(alpha = 0.6f),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.size(14.dp))
            Text(
                entry.label,
                color = if (selected) TextWhite else TextWhite.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )
            // Unread dot for Announcements
            if (index == ANNOUNCEMENTS_DRAWER_INDEX) {
                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(PendGrey))
            }
        }
    }
}

