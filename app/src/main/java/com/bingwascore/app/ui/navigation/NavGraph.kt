package com.bingwascore.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.ui.auth.AuthViewModel
import com.bingwascore.app.ui.auth.LoginScreen
import com.bingwascore.app.ui.auth.SignupScreen
import com.bingwascore.app.ui.checkout.CheckoutScreen
import com.bingwascore.app.ui.checkout.CheckoutViewModel
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.home.HomeViewModel
import com.bingwascore.app.ui.orders.OrdersScreen
import com.bingwascore.app.ui.orders.OrdersViewModel
import com.bingwascore.app.ui.account.AccountScreen
import com.bingwascore.app.ui.account.AccountViewModel
import com.bingwascore.app.ui.settings.SettingsScreen
import com.bingwascore.app.ui.settings.SettingsViewModel
import com.bingwascore.app.ui.admin.AdminScreen
import com.bingwascore.app.ui.admin.AdminViewModel
import com.bingwascore.app.ui.splash.SplashScreen

@Composable
fun BingwaNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onFinished = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Login.route) {
            val vm: AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = vm,
                onLoginSuccess = { user ->
                    val target = if (user.role == "admin") Screen.Admin.route else Screen.Home.route
                    navController.navigate(target) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToSignup = { navController.navigate(Screen.Signup.route) }
            )
        }

        composable(Screen.Signup.route) {
            val vm: AuthViewModel = hiltViewModel()
            SignupScreen(
                viewModel = vm,
                onSignupSuccess = { user ->
                    val target = if (user.role == "admin") Screen.Admin.route else Screen.Home.route
                    navController.navigate(target) {
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
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) },
                onNavigateToAccount = { navController.navigate(Screen.Account.route) },
                onNavigateToOrders = { navController.navigate(Screen.Orders.route) },
                onNavigateToCheckout = { bundleId ->
                    navController.navigate(Screen.Checkout.createRoute(bundleId))
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Checkout.route) { backStackEntry ->
            val bundleId = backStackEntry.arguments?.getString("bundleId") ?: return@composable
            val vm: CheckoutViewModel = hiltViewModel()
            CheckoutScreen(
                viewModel = vm,
                bundleId = bundleId,
                onNavigateBack = { navController.popBackStack() },
                onSuccess = {
                    navController.popBackStack(Screen.Home.route, false)
                }
            )
        }

        composable(Screen.Orders.route) {
            val vm: OrdersViewModel = hiltViewModel()
            OrdersScreen(
                viewModel = vm,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Account.route) {
            val vm: AccountViewModel = hiltViewModel()
            AccountScreen(
                viewModel = vm,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Settings.route) {
            val vm: SettingsViewModel = hiltViewModel()
            SettingsScreen(
                viewModel = vm,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Admin.route) {
            val vm: AdminViewModel = hiltViewModel()
            AdminScreen(
                viewModel = vm,
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
