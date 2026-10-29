package com.bingwascore.app

import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.AuthSession
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.ui.auth.PinSetupViewModel
import com.bingwascore.app.ui.onboarding.SetupChecklistViewModel
import com.bingwascore.app.ui.screens.LoginViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Stage 31 — crash triage walk test.
 *
 * Walks Sign-in -> Sign-up -> Setup checklist -> (home gate) and fails if any
 * step throws. Exercises the PIN-exactly-4 path and the offline/local auth
 * fallback so the sign-in -> setup -> home chain is covered without a device or adb.
 * Robolectric supplies the Android Context so UserPreferences/DataStore and the
 * ViewModels can be constructed and exercised directly.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage31WalkTest {

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

    @Test
    fun `sign in then sign up then setup checklist then home gate does not throw`() = runBlocking {
        val context = RuntimeEnvironment.application
        val prefs = UserPreferences(context)
        val repo = FakeAuthRepository()

        // Sign in: valid phone + 4-digit PIN -> loading, then Verified!.
        val login = LoginViewModel(repo, prefs)
        login.updatePhone("0712345678")
        login.updatePin("1234")
        var signedIn = false
        login.signIn { signedIn = true }
        assertTrue("sign-in accepted the 4-digit PIN", login.state.value.isLoading || login.state.value.isSuccess)
        assertFalse("sign-in must not be in cooldown yet", login.state.value.cooldownSeconds > 0)

        // Sign up: phone + exactly-4 PIN + matching confirm -> accepted.
        val setup = PinSetupViewModel(repo, prefs)
        setup.updateName("John Doe")
        setup.updatePhone("0712345678")
        setup.updateEmail("john@example.com")
        setup.updatePin("1234")
        setup.updateConfirmPin("1234")
        assertTrue("sign-up form is submittable", setup.state.value.isSubmittable)
        setup.submit()
        assertTrue("sign-up was accepted", setup.state.value.isLoading || setup.state.value.isSuccess)

        // Setup checklist: complete setup -> home gate satisfied, no throw.
        val checklist = SetupChecklistViewModel(context, prefs)
        checklist.completeSetup()
    }
}
