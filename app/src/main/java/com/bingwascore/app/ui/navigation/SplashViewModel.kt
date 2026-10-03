package com.bingwascore.app.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.ValidateStartupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Where the splash should route once its reveal animation finishes.
 *
 * Flow: splash -> onboarding (first launch only) -> login -> setup checklist
 * (permissions/engine incomplete) -> main.
 */
sealed interface StartDestination {
    data object Onboarding : StartDestination
    data object Login : StartDestination
    data object Main : StartDestination

    /** MEGA A — permissions or engine incomplete; the checklist runs before Home. */
    data object SetupChecklist : StartDestination
}

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val prefs: UserPreferences,
    private val validateStartup: ValidateStartupUseCase
) : ViewModel() {

    /**
     * Cold-start target resolved from persisted preferences + a live gate check.
     *
     * The gate is the reason an unconfigured agent never lands on an empty Home:
     * if any permission is missing or the engine is not running, we route to the
     * Setup Checklist instead of Main.
     */
    val startDestination: Flow<StartDestination> =
        combine(prefs.onboardingDone, prefs.isLoggedIn) { onboarded, loggedIn ->
            when {
                !onboarded -> StartDestination.Onboarding
                !loggedIn -> StartDestination.Login
                // Gate first: only a fully-satisfied startup may open Home.
                else -> runCatching { validateStartup.run() }
                    .fold(
                        onSuccess = { if (it.readyForHome) StartDestination.Main else StartDestination.SetupChecklist },
                        // Gate itself failed — the checklist is the safe answer.
                        onFailure = { StartDestination.SetupChecklist }
                    )
            }
        }

    /** Called from the onboarding carousel's Get Started. */
    fun markOnboardingDone() {
        viewModelScope.launch { prefs.setOnboardingDone(true) }
    }
}
