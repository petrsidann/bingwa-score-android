package com.bingwascore.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.ui.auth.LoginScreen
import com.bingwascore.app.ui.auth.SignupScreen
import com.bingwascore.app.ui.auth.AuthViewModel
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.splash.SplashScreen
import dagger.hilt.android.EntryPointAccessors
import androidx.compose.ui.platform.LocalContext

@Composable
fun BingwaNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferences = remember {
        EntryPointAccessors.fromApplication(
            context.applicationContext,
            PreferencesEntryPoint::class.java
        ).userPreferences()
    }
    val hasToken by preferences.accessToken.collectAsState(initial = null)

    LaunchedEffect(hasToken) {
        val startRoute = if (hasToken != null) Screen.Home.route else Screen.Login.route
        if (navController.currentDestination == null) {
            navController.navigate(startRoute) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen()
        }
        composable(Screen.Login.route) {
            val vm: AuthViewModel = hiltViewModel()
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
            val vm: AuthViewModel = hiltViewModel()
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
            HomeScreen(
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) },
                onNavigateToAccount = { navController.navigate(Screen.Account.route) },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Settings.route) {
            com.bingwascore.app.ui.settings.SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

@dagger.hilt.EntryPoint
@InstallIn(dagger.hilt.android.components.ApplicationComponent::class)
interface PreferencesEntryPoint {
    fun userPreferences(): UserPreferences
}
