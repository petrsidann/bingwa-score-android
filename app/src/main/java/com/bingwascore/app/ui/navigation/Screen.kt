package com.bingwascore.app.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object Home : Screen("home")
    data object Score : Screen("score")
    data object Customers : Screen("customers")
    data object Offers : Screen("offers")
    data object QuickDial : Screen("quickdial")
    data object AutoRenewals : Screen("autorenewals")
    data object Subscriptions : Screen("subscriptions")
    data object AutoReplies : Screen("autoreplies")
    data object Community : Screen("community")
    data object Settings : Screen("settings")
    data object Orders : Screen("orders")
    data object Account : Screen("account")
    data object Admin : Screen("admin")
    data object Checkout : Screen("checkout/{bundleId}") {
        fun createRoute(bundleId: String) = "checkout/$bundleId"
    }
}
