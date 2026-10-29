package com.bingwascore.app

import app.cash.paparazzi.Paparazzi
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.AuthSession
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.auth.PinSetupScreen
import com.bingwascore.app.ui.screens.LoginScreen
import com.bingwascore.app.ui.screens.LoginViewModel
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment
import androidx.compose.runtime.Composable

/**
 * Stage 34 — goldens for the sign-in / sign-up screens in BOTH themes.
 *
 * Paparazzi renders the real ViewModels (fake repository + real DataStore-backed
 * preferences) inside BingwaScoreTheme, so every token, colour and text contrast
 * is exercised on Obsidian and on Porcelain Dim.
 *
 * SetupChecklistScreen is audited by source review instead: it uses theme tokens
 * only (TextWhite/TextGrey/PendGrey/TickGreen) and draws no launcher in a
 * headless render.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage34GoldensTest {

    @get:Rule val paparazzi = Paparazzi()

    private class FakeAuthRepository : AuthRepository {
        override suspend fun signIn(phone: String, pin: String): RemoteResult<AuthSession> =
            RemoteResult.Offline("offline", AuthSession("u1", phone, "", "", 0L))
        override suspend fun signUp(
            accountType: String,
            name: String,
            phone: String,
            email: String,
            pin: String
        ): RemoteResult<AuthSession> =
            RemoteResult.Offline("offline", AuthSession("u1", phone, "", "", 0L))
        override suspend fun requestEmailOtp(email: String): RemoteResult<OtpChallenge> =
            throw NotImplementedError()
        override suspend fun verifyEmailOtp(challengeId: String, code: String): RemoteResult<AuthSession> =
            throw NotImplementedError()
        override suspend fun refresh(refreshToken: String): RemoteResult<AuthSession> =
            throw NotImplementedError()
    }

    private fun prefs() = UserPreferences(RuntimeEnvironment.application)

    @Composable
    private fun theme(mode: ThemeMode, content: @Composable () -> Unit) =
        BingwaScoreTheme(themeMode = mode) { content() }

    private fun repo() = FakeAuthRepository()

    @Test
    fun signInDark() = paparazzi.snapshot { theme(ThemeMode.DARK) {
        LoginScreen(
            viewModel = LoginViewModel(repo(), prefs()),
            onSignIn = {},
            onCreateAccount = {}
        )
    } }

    @Test
    fun signInPorcelainDim() = paparazzi.snapshot { theme(ThemeMode.PORCELAIN_DIM) {
        LoginScreen(
            viewModel = LoginViewModel(repo(), prefs()),
            onSignIn = {},
            onCreateAccount = {}
        )
    } }

    @Test
    fun signUpDark() = paparazzi.snapshot { theme(ThemeMode.DARK) {
        PinSetupScreen(
            viewModel = com.bingwascore.app.ui.auth.PinSetupViewModel(repo(), prefs()),
            onComplete = {}
        )
    } }

    @Test
    fun signUpPorcelainDim() = paparazzi.snapshot { theme(ThemeMode.PORCELAIN_DIM) {
        PinSetupScreen(
            viewModel = com.bingwascore.app.ui.auth.PinSetupViewModel(repo(), prefs()),
            onComplete = {}
        )
    } }
}
