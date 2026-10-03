package com.bingwascore.app.ui.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ReceiptLong
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.DeviceHub
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SmartToy
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.bingwascore.app.ui.autorenewals.AutoRenewalsScreen
import com.bingwascore.app.ui.autoreplies.AutoRepliesScreen
import com.bingwascore.app.ui.authorizedsenders.AuthorizedSendersScreen
import com.bingwascore.app.ui.blacklist.BlacklistScreen
import com.bingwascore.app.ui.components.ScreenTransition
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.dialer.DialerScreen
import com.bingwascore.app.ui.engagebot.EngageBotScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.mesh.MeshScreen
import com.bingwascore.app.ui.mystore.MyStoreScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.screens.LoginScreen
import com.bingwascore.app.ui.screens.SplashScreen
import com.bingwascore.app.ui.onboarding.SetupChecklistScreen
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.subscriptions.SubscriptionsScreen
import com.bingwascore.app.ui.transactions.TransactionFilter
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.score.ScoreScreen
import com.bingwascore.app.util.rememberHaptics
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.QrCodeScanner
import com.bingwascore.app.ui.community.CommunityScreen
import com.bingwascore.app.ui.qr.QrScannerScreen
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
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextWhite
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

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
fun AppNavHost() {
    val navController = rememberNavController()
    val splashViewModel: SplashViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val startDestination by splashViewModel.startDestination.collectAsState(initial = null)

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
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
            MainScreen()
        }
    }
}

private data class DrawerEntry(val label: String, val icon: ImageVector)

/**
 * Drawer indexes of the destinations built so far. These MUST stay in the same
 * order as [drawerEntries] — the index is the route key.
 */
private const val CUSTOMERS_DRAWER_INDEX = 0
private const val AUTO_RENEWALS_DRAWER_INDEX = 1
private const val SUBSCRIPTIONS_DRAWER_INDEX = 2
private const val SMART_FOLLOW_UP_DRAWER_INDEX = 3
private const val AUTOPILOT_DRAWER_INDEX = 4
private const val AGENT_PORTAL_DRAWER_INDEX = 5
private const val MESH_DRAWER_INDEX = 6
private const val BLOCKED_CONTACTS_DRAWER_INDEX = 7
private const val TRUSTED_PARTNERS_DRAWER_INDEX = 8
private const val REDEEM_COUPON_DRAWER_INDEX = 9
private const val SETTINGS_DRAWER_INDEX = 10
private const val ANNOUNCEMENTS_DRAWER_INDEX = 11
private const val COMMISSION_PULSE_DRAWER_INDEX = 12
private const val COMMUNITY_DRAWER_INDEX = 13
private const val QR_SCANNER_DRAWER_INDEX = 14

private val drawerEntries = listOf(
    DrawerEntry("Customers", Icons.Rounded.People),
    DrawerEntry("Auto Renewals", Icons.Rounded.Autorenew),
    DrawerEntry("Subscriptions", Icons.Rounded.Subscriptions),
    DrawerEntry("Smart Follow-Up", Icons.Rounded.SmartToy),
    DrawerEntry("Autopilot", Icons.Rounded.Bolt),
    DrawerEntry("Agent Portal", Icons.Rounded.Storefront),
    DrawerEntry("Bingwa Mesh", Icons.Rounded.DeviceHub),
    DrawerEntry("Blocked Contacts", Icons.Rounded.Block),
    DrawerEntry("Trusted Partners", Icons.Rounded.VerifiedUser),
    DrawerEntry("Redeem Coupon", Icons.Rounded.Redeem),
    DrawerEntry("Settings", Icons.Rounded.Settings),
    DrawerEntry("Announcements", Icons.Rounded.Campaign),
    DrawerEntry("Commission Pulse", Icons.Rounded.EmojiEvents),
    DrawerEntry("Community", Icons.Rounded.Groups),
    DrawerEntry("QR Scanner", Icons.Rounded.QrCodeScanner)
)

/**
 * App shell: tabs (Home / Offers / Transactions / Profile) behind a glass
 * bottom navigation bar with a center gradient dialer FAB, plus a drawer for
 * the secondary destinations.
 */
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedDrawerIndex by remember { mutableStateOf(-1) }
    var showDialer by remember { mutableStateOf(false) }
    var showReferral by remember { mutableStateOf(false) }
    // R2: Home counters hand a status filter over to the Transactions tab.
    var transactionFilter by remember { mutableStateOf(TransactionFilter.ALL) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Raised) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    "Bingwa Score",
                    color = TextWhite,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                drawerEntries.forEachIndexed { index, entry ->
                    val selected = selectedDrawerIndex == index
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedDrawerIndex = index
                                scope.launch { drawerState.close() }
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
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    ) {
        Scaffold(
            containerColor = BgBlack,
            contentWindowInsets = WindowInsets.safeDrawing.only(
                WindowInsetsSides.Top + WindowInsetsSides.Horizontal
            ),
            bottomBar = {
                BottomNavBar(
                    selected = selectedTab,
                    dialerOpen = showDialer,
                    onSelect = {
                        selectedTab = it
                        selectedDrawerIndex = -1
                    },
                    onDialer = { showDialer = true }
                )
            }
        ) { innerPadding ->
            val destination = when {
                showDialer -> "dialer"
                selectedDrawerIndex == CUSTOMERS_DRAWER_INDEX -> "customers"
                selectedDrawerIndex == AUTO_RENEWALS_DRAWER_INDEX -> "autorenewals"
                selectedDrawerIndex == SUBSCRIPTIONS_DRAWER_INDEX -> "subscriptions"
                selectedDrawerIndex == SMART_FOLLOW_UP_DRAWER_INDEX -> "smartfollowup"
                selectedDrawerIndex == AUTOPILOT_DRAWER_INDEX -> "autopilot"
                selectedDrawerIndex == AGENT_PORTAL_DRAWER_INDEX -> "agentportal"
                selectedDrawerIndex == MESH_DRAWER_INDEX -> "mesh"
                selectedDrawerIndex == BLOCKED_CONTACTS_DRAWER_INDEX -> "blockedcontacts"
                selectedDrawerIndex == TRUSTED_PARTNERS_DRAWER_INDEX -> "trustedpartners"
                selectedDrawerIndex == REDEEM_COUPON_DRAWER_INDEX -> "coupon"
                selectedDrawerIndex == SETTINGS_DRAWER_INDEX -> "settings"
                selectedDrawerIndex == ANNOUNCEMENTS_DRAWER_INDEX -> "announcements"
                selectedDrawerIndex == COMMISSION_PULSE_DRAWER_INDEX -> "commissionpulse"
                selectedDrawerIndex == COMMUNITY_DRAWER_INDEX -> "community"
                selectedDrawerIndex == QR_SCANNER_DRAWER_INDEX -> "qrscanner"
                else -> when (selectedTab) {
                    0 -> "home"
                    1 -> "offers"
                    3 -> "transactions"
                    else -> "profile"
                }
            }

            val resolved = if (showReferral) "referral" else destination

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
                        "subscriptions" -> SubscriptionsScreen()
                        "smartfollowup" -> AutoRepliesScreen()
                        "autopilot" -> EngageBotScreen()
                        "agentportal" -> MyStoreScreen()
                        "mesh" -> MeshScreen()
                        "blockedcontacts" -> BlacklistScreen()
                        "trustedpartners" -> AuthorizedSendersScreen()
                        "coupon" -> RedeemCouponScreen()
                        "settings" -> SettingsScreen()
                        "announcements" -> AnnouncementsScreen()
                        "commissionpulse" -> ScoreScreen()
                        "community" -> CommunityScreen()
                        "qrscanner" -> QrScannerScreen()
                        "referral" -> ReferralScreen()
                        "home" -> HomeScreen(onOpenTransactions = { status ->
                    transactionFilter = TransactionFilter.fromStatus(status)
                    selectedTab = 3
                    selectedDrawerIndex = -1
                })
                        "offers" -> OffersScreen()
                        "transactions" -> TransactionsScreen(initialFilter = transactionFilter)
                        "profile" -> ProfileScreen(
                            onMyStore = { selectedDrawerIndex = AGENT_PORTAL_DRAWER_INDEX },
                            onReferEarn = { showReferral = true },
                            onSettings = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX },
                            onAuthorizedSenders = { selectedDrawerIndex = TRUSTED_PARTNERS_DRAWER_INDEX },
                            onBlacklist = { selectedDrawerIndex = BLOCKED_CONTACTS_DRAWER_INDEX },
                            onAbout = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX }
                        )
                        else -> ProfileScreen(
                            onMyStore = { selectedDrawerIndex = AGENT_PORTAL_DRAWER_INDEX },
                            onReferEarn = { showReferral = true },
                            onSettings = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX },
                            onAuthorizedSenders = { selectedDrawerIndex = TRUSTED_PARTNERS_DRAWER_INDEX },
                            onBlacklist = { selectedDrawerIndex = BLOCKED_CONTACTS_DRAWER_INDEX },
                            onAbout = { selectedDrawerIndex = SETTINGS_DRAWER_INDEX }
                        )
                    }
                }
            }
        }
    }
}
/**
 * REBRAND R2 — the MT5 shell bar.
 *
 * Solid `#000000`, five equal tabs, icon + 11sp label. Active = accent blue,
 * inactive = grey. No FAB, no floating pill, no gap, no blur: the bar is a rail,
 * not a floating object.
 */
@Composable
private fun BottomNavBar(
    selected: Int,
    dialerOpen: Boolean,
    onSelect: (Int) -> Unit,
    onDialer: () -> Unit
) {
    val haptics = rememberHaptics()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgBlack)
            .navigationBarsPadding()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavTab(Icons.Rounded.Home, "Home", selected == 0) {
            haptics.tick(); onSelect(0)
        }
        NavTab(Icons.Rounded.LocalOffer, "Offers", selected == 1) {
            haptics.tick(); onSelect(1)
        }
        NavTab(Icons.Rounded.Call, "Dial", dialerOpen) {
            haptics.press(); onDialer()
        }
        NavTab(Icons.AutoMirrored.Rounded.ReceiptLong, "Transactions", selected == 3) {
            haptics.tick(); onSelect(3)
        }
        NavTab(Icons.Rounded.Person, "Profile", selected == 4) {
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

