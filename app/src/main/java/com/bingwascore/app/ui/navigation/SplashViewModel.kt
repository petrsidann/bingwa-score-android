package com.bingwascore.app.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Where the splash should route once its reveal animation finishes.
 *
 * Flow: splash -> onboarding (first launch only) -> login -> main.
 */
sealed interface StartDestination {
    data object Onboarding : StartDestination
    data object Login : StartDestination
    data object Main : StartDestination
}

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val prefs: UserPreferences
) : ViewModel() {

    /**
     * Cold-start target resolved from persisted preferences. Emits as soon as
     * [UserPreferences] has read both flags; splash holds its reveal until then.
     */
    val startDestination: Flow<StartDestination> =
        combine(prefs.onboardingDone, prefs.isLoggedIn) { onboarded, loggedIn ->
            when {
                !onboarded -> StartDestination.Onboarding
                loggedIn -> StartDestination.Main
                else -> StartDestination.Login
            }
        }

    /** Called from the onboarding carousel's Get Started. */
    fun markOnboardingDone() {
        viewModelScope.launch { prefs.setOnboardingDone(true) }
    }
}