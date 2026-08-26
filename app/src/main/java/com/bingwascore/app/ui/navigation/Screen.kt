package com.bingwascore.app.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object Home : Screen("home")
    data object Score : Screen("score")
    data object Customers : Screen("customers")
    data object Transactions : Screen("transactions")
    data object Offers : Screen("offers")
    data object OfferSettings : Screen("offersettings/{offerId}") {
        fun createRoute(offerId: String) = "offersettings/$offerId"
    }
    data object OfferActions : Screen("offeractions/{offerId}") {
        fun createRoute(offerId: String) = "offeractions/$offerId"
    }
    data object QuickDial : Screen("quickdial")
    data object AutoRenewals : Screen("autorenewals")
    data object Subscriptions : Screen("subscriptions")
    data object AutoReplies : Screen("autoreplies")
    data object Community : Screen("community")
    data object Settings : Screen("settings")
    data object Appearance : Screen("appearance")
    data object Updates : Screen("updates")
    data object About : Screen("about")
    data object Terms : Screen("terms")
    data object Privacy : Screen("privacy")
}
