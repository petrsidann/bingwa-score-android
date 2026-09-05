package com.bingwascore.app.ui.navigation

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.dialer.DialerScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.screens.LoginScreen
import com.bingwascore.app.ui.screens.SplashScreen
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.launch

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
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
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
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

/** Drawer index of the Customers entry — the only drawer destination built so far. */
private const val CUSTOMERS_DRAWER_INDEX = 0

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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when {
                    showDialer -> DialerScreen(onClose = { showDialer = false })
                    selectedDrawerIndex == CUSTOMERS_DRAWER_INDEX -> CustomersScreen()
                    else -> when (selectedTab) {
                        0 -> HomeScreen()
                        1 -> OffersScreen()
                        3 -> TransactionsScreen()
                        4 -> PlaceholderScreen("Profile")
                    }
                }
            }
        }
    }
}

@Composable
private fun GlassBottomBar(selected: Int, onSelect: (Int) -> Unit, onDialer: () -> Unit) {
    val shape = RoundedCornerShape(28.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Brush.verticalGradient(listOf(Color(0x33FFFFFF), Color.Transparent)), shape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(Icons.Rounded.Home, "Home", selected == 0) { onSelect(0) }
            BottomNavItem(Icons.Rounded.LocalOffer, "Offers", selected == 1) { onSelect(1) }
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
                    .clickable(onClick = onDialer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = "Dialer",
                    tint = NightBlack,
                    modifier = Modifier.size(26.dp)
                )
            }
            BottomNavItem(Icons.AutoMirrored.Rounded.ReceiptLong, "Transactions", selected == 3) { onSelect(3) }
            BottomNavItem(Icons.Rounded.Person, "Profile", selected == 4) { onSelect(4) }
        }
    }
}

@Composable
private fun BottomNavItem(icon: ImageVector, label: String, selected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) EmeraldGreen else White.copy(alpha = 0.55f),
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            label,
            color = if (selected) White else White.copy(alpha = 0.55f),
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
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Text(title, color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("This section is coming in a later phase.", color = White.copy(alpha = 0.6f), fontSize = 14.sp)
        }
    }
}