package com.bingwascore.app.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.ui.auth.AuthViewModel
import com.bingwascore.app.ui.auth.LoginScreen
import com.bingwascore.app.ui.auth.SignupScreen
import com.bingwascore.app.ui.autoreplies.AutoRepliesScreen
import com.bingwascore.app.ui.autorenewals.AutoRenewalsScreen
import com.bingwascore.app.ui.community.CommunityScreen
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.home.HomeViewModel
import com.bingwascore.app.ui.mesh.MeshScreen
import com.bingwascore.app.ui.mystore.MyStoreScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.offers.OffersViewModel
import com.bingwascore.app.ui.offers.OfferSettingsScreen
import com.bingwascore.app.ui.offers.OfferActionsScreen
import com.bingwascore.app.ui.quickdial.QuickDialScreen
import com.bingwascore.app.ui.score.ScoreScreen
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.settings.pages.AboutScreen
import com.bingwascore.app.ui.settings.pages.AppearanceScreen
import com.bingwascore.app.ui.settings.pages.PrivacyScreen
import com.bingwascore.app.ui.settings.pages.TermsScreen
import com.bingwascore.app.ui.settings.pages.UpdatesScreen
import com.bingwascore.app.ui.subscriptions.SubscriptionsScreen
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.ui.splash.SplashScreen
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.ThemeViewModel
import com.bingwascore.app.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BingwaNavHost() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val themeViewModel: ThemeViewModel = hiltViewModel()
    val isDark by themeViewModel.isDark.collectAsState()

    fun closeDrawer() { scope.launch { drawerState.close() } }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(48.dp).background(Brush.linearGradient(listOf(Orange500, Purple500)), RoundedCornerShape(14.dp)),
                            contentAlignment = Alignment.Center
                        ) { Text("B", color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
                        Spacer(Modifier.width(12.dp))
                        Text("Bingwa Score", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(8.dp))
                }
                DrawerItem(Icons.Default.Home, "Home") { closeDrawer(); navController.navigate(Screen.Home.route) }
                DrawerItem(Icons.Default.EmojiEvents, "My Score") { closeDrawer(); navController.navigate(Screen.Score.route) }
                DrawerItem(Icons.Default.Receipt, "Transactions") { closeDrawer(); navController.navigate(Screen.Transactions.route) }
                DrawerItem(Icons.Default.People, "Customers") { closeDrawer(); navController.navigate(Screen.Customers.route) }
                DrawerItem(Icons.Default.LocalOffer, "Offers") { closeDrawer(); navController.navigate(Screen.Offers.route) }
                DrawerItem(Icons.Default.Dialpad, "Dialer") { closeDrawer(); navController.navigate(Screen.QuickDial.route) }
                DrawerItem(Icons.Default.Cached, "Auto Renewals") { closeDrawer(); navController.navigate(Screen.AutoRenewals.route) }
                DrawerItem(Icons.Default.Subscriptions, "Subscriptions") { closeDrawer(); navController.navigate(Screen.Subscriptions.route) }
                DrawerItem(Icons.Default.Email, "Botted Replies") { closeDrawer(); navController.navigate(Screen.AutoReplies.route) }
                DrawerItem(Icons.Default.Group, "Intelligent USSD") { closeDrawer(); navController.navigate(Screen.Community.route) }
                DrawerItem(Icons.Default.Store, "My Store") { closeDrawer(); navController.navigate(Screen.MyStore.route) }
                DrawerItem(Icons.Default.Wifi, "Bingwa Mesh") { closeDrawer(); navController.navigate(Screen.Mesh.route) }
                DrawerItem(Icons.Default.Settings, "Settings") { closeDrawer(); navController.navigate(Screen.Settings.route) }
                DrawerItem(Icons.Default.Update, "Check For Updates") { closeDrawer(); navController.navigate(Screen.Updates.route) }
                DrawerItem(Icons.Default.Logout, "Logout") {
                    closeDrawer()
                    navController.navigate(Screen.Login.route) { popUpTo(0) { inclusive = true } }
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.Splash.route) {
            composable(Screen.Splash.route) {
                SplashScreen(onFinished = {
                    navController.navigate(Screen.Home.route) { popUpTo(Screen.Splash.route) { inclusive = true } }
                })
            }
            composable(Screen.Login.route) {
                val vm: AuthViewModel = hiltViewModel()
                LoginScreen(vm, onLoginSuccess = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Login.route) { inclusive = true } } }, onNavigateToSignup = { navController.navigate(Screen.Signup.route) })
            }
            composable(Screen.Signup.route) {
                val vm: AuthViewModel = hiltViewModel()
                SignupScreen(vm, onSignupSuccess = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Login.route) { inclusive = true } } }, onNavigateBack = { navController.popBackStack() })
            }
            composable(Screen.Home.route) {
                val vm: HomeViewModel = hiltViewModel()
                HomeScreen(vm, isDark, { themeViewModel.toggle() }, { navController.navigate(Screen.Settings.route) }, { }, { navController.navigate(Screen.Transactions.route) }, { }, { navController.navigate(Screen.Login.route) { popUpTo(0) { inclusive = true } } }, { scope.launch { drawerState.open() } })
            }
            composable(Screen.Score.route) { ScoreScreen { navController.popBackStack() } }
            composable(Screen.Transactions.route) { TransactionsScreen { navController.popBackStack() } }
            composable(Screen.Customers.route) { CustomersScreen { navController.popBackStack() } }
            composable(Screen.Offers.route) {
                val vm: OffersViewModel = hiltViewModel()
                OffersScreen(vm, { navController.popBackStack() }, { id -> navController.navigate(Screen.OfferSettings.createRoute(id)) }, { id -> navController.navigate(Screen.OfferActions.createRoute(id)) })
            }
            composable(Screen.OfferSettings.route) { backStack ->
                val id = backStack.arguments?.getString("offerId") ?: return@composable
                OfferSettingsScreen(id) { navController.popBackStack() }
            }
            composable(Screen.OfferActions.route) { backStack ->
                val id = backStack.arguments?.getString("offerId") ?: return@composable
                OfferActionsScreen(id) { navController.popBackStack() }
            }
            composable(Screen.QuickDial.route) { QuickDialScreen { navController.popBackStack() } }
            composable(Screen.AutoRenewals.route) { AutoRenewalsScreen { navController.popBackStack() } }
            composable(Screen.Subscriptions.route) { SubscriptionsScreen { navController.popBackStack() } }
            composable(Screen.AutoReplies.route) { AutoRepliesScreen { navController.popBackStack() } }
            composable(Screen.Community.route) { CommunityScreen { navController.popBackStack() } }
            composable(Screen.MyStore.route) { MyStoreScreen { navController.popBackStack() } }
            composable(Screen.Mesh.route) { MeshScreen { navController.popBackStack() } }
            composable(Screen.Settings.route) { SettingsScreen(navController) }
            composable(Screen.Appearance.route) { AppearanceScreen { navController.popBackStack() } }
            composable(Screen.Updates.route) { UpdatesScreen { navController.popBackStack() } }
            composable(Screen.About.route) { AboutScreen { navController.popBackStack() } }
            composable(Screen.Terms.route) { TermsScreen { navController.popBackStack() } }
            composable(Screen.Privacy.route) { PrivacyScreen { navController.popBackStack() } }
        }
    }
}

@Composable
private fun DrawerItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    NavigationDrawerItem(icon = { Icon(icon, null) }, label = { Text(label) }, selected = false, onClick = onClick)
}
