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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
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
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.ScreenTransition
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.dialer.DialerScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.mesh.MeshScreen
import com.bingwascore.app.ui.mystore.MyStoreScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.screens.LoginScreen
import com.bingwascore.app.ui.screens.SplashScreen
import com.bingwascore.app.ui.onboarding.SetupChecklistScreen
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.subscriptions.SubscriptionsScreen
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.launch

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val SETUP_CHECKLIST = "setup_checklist"
    const val MAIN = "main"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
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
                }
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

/** Drawer indexes of the destinations built so far. */
private const val CUSTOMERS_DRAWER_INDEX = 0
private const val AUTO_RENEWALS_DRAWER_INDEX = 1
private const val SUBSCRIPTIONS_DRAWER_INDEX = 2
private const val BOTTED_REPLIES_DRAWER_INDEX = 3
private const val ENGAGE_BOT_DRAWER_INDEX = 4
private const val MY_STORE_DRAWER_INDEX = 5
private const val MESH_DRAWER_INDEX = 6
private const val BLACKLIST_DRAWER_INDEX = 7
private const val AUTHORIZED_SENDERS_DRAWER_INDEX = 8
private const val SETTINGS_DRAWER_INDEX = 9

private val drawerEntries = listOf(
    DrawerEntry("Customers", Icons.Rounded.People),
    DrawerEntry("Auto Renewals", Icons.Rounded.Autorenew),
    DrawerEntry("Subscriptions", Icons.Rounded.Subscriptions),
    DrawerEntry("Botted Replies", Icons.Rounded.SmartToy),
    DrawerEntry("Engage Bot", Icons.Rounded.Bolt),
    DrawerEntry("My Store", Icons.Rounded.Storefront),
    DrawerEntry("Bingwa Mesh", Icons.Rounded.DeviceHub),
    DrawerEntry("Blacklist", Icons.Rounded.Block),
    DrawerEntry("Authorized Senders", Icons.Rounded.VerifiedUser),
    DrawerEntry("Settings", Icons.Rounded.Settings)
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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = SurfaceDark) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    "Bingwa Score",
                    color = White,
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
                            tint = if (selected) EmeraldGreen else White.copy(alpha = 0.6f),
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.size(14.dp))
                        Text(
                            entry.label,
                            color = if (selected) White else White.copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    ) {
        Scaffold(
            containerColor = NightBlack,
            contentWindowInsets = WindowInsets.safeDrawing.only(
                WindowInsetsSides.Top + WindowInsetsSides.Horizontal
            ),
            bottomBar = {
                GlassBottomBar(
                    selected = selectedTab,
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
                selectedDrawerIndex == BOTTED_REPLIES_DRAWER_INDEX -> "bottedreplies"
                selectedDrawerIndex == ENGAGE_BOT_DRAWER_INDEX -> "engagebot"
                selectedDrawerIndex == MY_STORE_DRAWER_INDEX -> "mystore"
                selectedDrawerIndex == MESH_DRAWER_INDEX -> "mesh"
                selectedDrawerIndex == BLACKLIST_DRAWER_INDEX -> "blacklist"
                selectedDrawerIndex == AUTHORIZED_SENDERS_DRAWER_INDEX -> "authorizedsenders"
                selectedDrawerIndex == SETTINGS_DRAWER_INDEX -> "settings"
                else -> when (selectedTab) {
                    0 -> "home"
                    1 -> "offers"
                    3 -> "transactions"
                    else -> "profile"
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                ScreenTransition(screenKey = destination, modifier = Modifier.fillMaxSize()) {
                    when (destination) {
                        "dialer" -> DialerScreen(onClose = { showDialer = false })
                        "customers" -> CustomersScreen()
                        "autorenewals" -> AutoRenewalsScreen()
                        "subscriptions" -> SubscriptionsScreen()
                        "bottedreplies" -> AutoRepliesScreen()
                        "engagebot" -> PlaceholderScreen("Engage Bot")
                        "mystore" -> MyStoreScreen()
                        "mesh" -> MeshScreen()
                        "blacklist" -> BlacklistScreen()
                        "authorizedsenders" -> AuthorizedSendersScreen()
                        "settings" -> SettingsScreen()
                        "home" -> HomeScreen()
                        "offers" -> OffersScreen()
                        "transactions" -> TransactionsScreen()
                        else -> PlaceholderScreen("Profile")
                    }
                }
            }
        }
    }
}

@Composable
private fun GlassBottomBar(selected: Int, onSelect: (Int) -> Unit, onDialer: () -> Unit) {
    val shape = RoundedCornerShape(28.dp)
    val fabInteraction = remember { MutableInteractionSource() }
    val haptic = LocalHapticFeedback.current
    val tick = {
        try { haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove) } catch (_: Throwable) { }
    }

    // Infinite pulsing glow for the dialer FAB
    val glowTransition = rememberInfiniteTransition(label = "fabGlow")
    val glow by glowTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(1800), RepeatMode.Reverse),
        label = "fabGlowPulse"
    )

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Brush.verticalGradient(listOf(Color(0x33FFFFFF), Color.Transparent)), shape)
    ) {
        // 5 logical slots: Home | Offers | FAB | Transactions | Profile
        val slotWidth = maxWidth / 5f
        val pillWidth = slotWidth * 0.6f
        val pillOffset by animateDpAsState(
            targetValue = slotWidth * selected + (slotWidth - pillWidth) / 2f,
            animationSpec = spring(dampingRatio = Motion.DAMPING),
            label = "pillOffset"
        )

        // Animated pill behind the selected tab
        Box(
            modifier = Modifier
                .offset(x = pillOffset, y = 8.dp)
                .width(pillWidth)
                .height(50.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Brush.horizontalGradient(listOf(EmeraldGreen, TealBlue)))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(Icons.Rounded.Home, "Home", selected == 0) { tick(); onSelect(0) }
            BottomNavItem(Icons.Rounded.LocalOffer, "Offers", selected == 1) { tick(); onSelect(1) }

            // Dialer FAB — infinite pulsing glow behind the gradient button
            Box(modifier = Modifier.size(54.dp)) {
                // Glow ring that breathes behind the FAB
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(54.dp)
                        .graphicsLayer {
                            alpha = 0.25f + 0.15f * glow
                            scaleX = 1f + 0.35f * glow
                            scaleY = 1f + 0.35f * glow
                        }
                        .clip(CircleShape)
                        .background(EmeraldGreen.copy(alpha = 0.5f))
                )
                // Main FAB — gradient, press-scale 0.98, press feedback
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(54.dp)
                        .pressScale(fabInteraction)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
                        .clickable(
                            interactionSource = fabInteraction,
                            indication = null,
                            onClick = { try { haptic.performHapticFeedback(HapticFeedbackType.LongPress) } catch (_: Throwable) { }; onDialer() }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Call,
                        contentDescription = "Dialer",
                        tint = NightBlack,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }

            BottomNavItem(Icons.AutoMirrored.Rounded.ReceiptLong, "Transactions", selected == 3) { tick(); onSelect(3) }
            BottomNavItem(Icons.Rounded.Person, "Profile", selected == 4) { tick(); onSelect(4) }
        }
    }
}

@Composable
private fun BottomNavItem(icon: ImageVector, label: String, selected: Boolean, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val iconTint by animateColorAsState(
        targetValue = if (selected) EmeraldGreen else White.copy(alpha = 0.55f),
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "navIconTint"
    )
    val labelColor by animateColorAsState(
        targetValue = if (selected) White else White.copy(alpha = 0.55f),
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "navLabelColor"
    )
    val labelWeight by animateFloatAsState(
        targetValue = if (selected) 1f else 0.5f,
        animationSpec = spring(dampingRatio = Motion.DAMPING),
        label = "navLabelWeight"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .pressScale(interactionSource)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = iconTint,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            label,
            color = labelColor,
            fontSize = 10.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Text(title, color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("This section is coming in a later phase.", color = White.copy(alpha = 0.6f), fontSize = 14.sp)
        }
    }
}