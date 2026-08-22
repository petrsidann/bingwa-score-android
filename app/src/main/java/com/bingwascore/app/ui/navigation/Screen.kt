package com.bingwascore.app.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object Home : Screen("home")
    data object Orders : Screen("orders")
    data object Account : Screen("account")
    data object Settings : Screen("settings")
    data object Admin : Screen("admin")
    data object Checkout : Screen("checkout/{bundleId}") {
        fun createRoute(bundleId: String) = "checkout/$bundleId"
    }
}
