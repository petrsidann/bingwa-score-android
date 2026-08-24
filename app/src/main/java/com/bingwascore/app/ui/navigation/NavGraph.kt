package com.bingwascore.app.ui.navigation

import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bingwascore.app.ui.auth.AuthViewModel
import com.bingwascore.app.ui.auth.LoginScreen
import com.bingwascore.app.ui.auth.SignupScreen
import com.bingwascore.app.ui.home.HomeScreen
import com.bingwascore.app.ui.home.HomeViewModel
import com.bingwascore.app.ui.splash.SplashScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BingwaNavHost() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(280.dp)) {
                Text("Bingwa Score", modifier = Modifier.padding(16.dp))
                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = true,
                    onClick = { scope.launch { drawerState.close() } }
                )
                NavigationDrawerItem(
                    label = { Text("Offers") },
                    selected = false,
                    onClick = { /* TODO */ }
                )
                NavigationDrawerItem(
                    label = { Text("Settings") },
                    selected = false,
                    onClick = { /* TODO */ }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(
                    onFinished = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Splash.route) { inclusive = true }
                        }
                    }
                )
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
                val vm: HomeViewModel = hiltViewModel()
                HomeScreen(
                    viewModel = vm,
                    onNavigateToSettings = { /* TODO */ },
                    onNavigateToAccount = { /* TODO */ },
                    onNavigateToOrders = { /* TODO */ },
                    onNavigateToCheckout = { /* TODO */ },
                    onLogout = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    },
                    onOpenDrawer = { scope.launch { drawerState.open() } }
                )
            }
        }
    }
}
