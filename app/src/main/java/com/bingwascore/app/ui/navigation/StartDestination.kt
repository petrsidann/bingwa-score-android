package com.bingwascore.app.ui.navigation

/**
 * Stage 58 — cold-start destination decision.
 *
 * Adaptation: this codebase has no `Route` sealed class; navigation destinations are
 * modelled by the existing [StartDestination] sealed interface (defined in
 * SplashViewModel.kt) and string routes in [com.bingwascore.app.ui.navigation.Routes].
 *   - Route.Onboarding        -> StartDestination.Onboarding
 *   - Route.Home              -> StartDestination.Main   (no Home route exists; Main is the shell)
 *   - Route.Login             -> StartDestination.Login
 *   - Route.Launch            -> Routes.LAUNCH           (start destination, added to Routes)
 *
 * [decideStartDestination] is pure and JVM-testable: first launch wins over signed-in.
 */
fun decideStartDestination(firstLaunch: Boolean, signedIn: Boolean): StartDestination = when {
    firstLaunch -> StartDestination.Onboarding
    signedIn -> StartDestination.Main
    else -> StartDestination.Login
}
