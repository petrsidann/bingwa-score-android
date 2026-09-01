package com.bingwascore.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.ui.auth.LoginScreen
import com.bingwascore.app.ui.auth.SignupScreen
import com.bingwascore.app.ui.autoreplies.AutoRepliesScreen
import com.bingwascore.app.ui.autorenewals.AutoRenewalsScreen
import com.bingwascore.app.ui.blacklist.BlacklistScreen
import com.bingwascore.app.ui.authorizedsenders.AuthorizedSendersScreen
import com.bingwascore.app.ui.community.CommunityScreen
import com.bingwascore.app.ui.customers.CustomersScreen
import com.bingwascore.app.ui.dialer.DialerScreen
import com.bingwascore.app.ui.engagebot.EngageBotScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.home.HomeViewModel
import com.bingwascore.app.ui.mesh.MeshScreen
import com.bingwascore.app.ui.mystore.MyStoreScreen
import com.bingwascore.app.ui.offers.OffersScreen
import com.bingwascore.app.ui.offers.OffersViewModel
import com.bingwascore.app.ui.offers.OfferSettingsScreen
import com.bingwascore.app.ui.offers.OfferActionsScreen
import com.bingwascore.app.ui.score.ScoreScreen
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.settings.pages.AboutScreen
import com.bingwascore.app.ui.settings.pages.AppearanceScreen
import com.bingwascore.app.ui.settings.pages.PrivacyScreen
import com.bingwascore.app.ui.settings.pages.TermsScreen
import com.bingwascore.app.ui.settings.pages.UpdatesScreen
import com.bingwascore.app.ui.splash.SplashScreen
import com.bingwascore.app.ui.subscriptions.SubscriptionsScreen
import com.bingwascore.app.ui.transactions.TransactionsScreen
import com.bingwascore.app.ui.theme.ThemeViewModel

@Composable
fun BingwaNavHost() {
    val navController = rememberNavController()
    val themeViewModel: ThemeViewModel = hiltViewModel()
    val isDark by themeViewModel.isDark.collectAsState()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(onFinished = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Login.route) {
            val vm: com.bingwascore.app.ui.auth.AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = vm,
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToSignup = { navController.navigate(Screen.Signup.route) }
            )
        }
        composable(Screen.Signup.route) {
            val vm: com.bingwascore.app.ui.auth.AuthViewModel = hiltViewModel()
            SignupScreen(
                viewModel = vm,
                onSignupSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Home.route) {
            val vm: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = vm,
                isDarkTheme = isDark,
                onToggleTheme = { themeViewModel.toggle() },
                onOpenDrawer = { /* Handled by scaffold in real app, stub here */ },
                onNavigateToTransactions = { navController.navigate(Screen.Transactions.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) }
            )
        }
        composable(Screen.Score.route) { ScoreScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Transactions.route) { TransactionsScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Customers.route) { CustomersScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Offers.route) {
            val vm: OffersViewModel = hiltViewModel()
            OffersScreen(
                viewModel = vm,
                onNavigateBack = { navController.popBackStack() },
                onOpenOfferSettings = { id -> navController.navigate(Screen.OfferSettings.createRoute(id)) },
                onOpenOfferActions = { id -> navController.navigate(Screen.OfferActions.createRoute(id)) }
            )
        }
        composable(Screen.OfferSettings.route) { backStack ->
            val id = backStack.arguments?.getString("offerId") ?: return@composable
            OfferSettingsScreen(offerId = id, onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.OfferActions.route) { backStack ->
            val id = backStack.arguments?.getString("offerId") ?: return@composable
            OfferActionsScreen(offerId = id, onNavigateBack = { navController.popBackStack() })
        }
        composable(Screen.Dialer.route) { DialerScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.AutoRenewals.route) { AutoRenewalsScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Subscriptions.route) { SubscriptionsScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.AutoReplies.route) { AutoRepliesScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.EngageBot.route) { EngageBotScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Community.route) { CommunityScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.MyStore.route) { MyStoreScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Mesh.route) { MeshScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Blacklist.route) { BlacklistScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.AuthorizedSenders.route) { AuthorizedSendersScreen(onNavigateBack = { navController.popBackStack() }) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Appearance.route) { AppearanceScreen(onBack = { navController.popBackStack() }) }
        composable(Screen.Updates.route) { UpdatesScreen(onBack = { navController.popBackStack() }) }
        composable(Screen.About.route) { AboutScreen(onBack = { navController.popBackStack() }) }
        composable(Screen.Terms.route) { TermsScreen(onBack = { navController.popBackStack() }) }
        composable(Screen.Privacy.route) { PrivacyScreen(onBack = { navController.popBackStack() }) }
    }
}
