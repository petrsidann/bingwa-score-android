package com.bingwascore.app

import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.AuthSession
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.auth.PinSetupViewModel
import com.bingwascore.app.ui.screens.LoginField
import com.bingwascore.app.ui.screens.LoginViewModel
import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File

/**
 * STAGE 44 — INPUT TRUTH.
 *
 * Login: PIN cap 4 / phone cap 10 with inline errors, keypad routes to the
 * focused field. Signup: PIN + Confirm PIN keypad-only (cap 4, mismatch
 * inline), one account type AGENT, disabled button always shows its reason.
 * Splash: 1600ms minimum-visible window.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage44InputTruthTest {

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

    private fun source(relative: String): String {
        val root = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        return File(root, relative).readText()
    }

    private fun prefs() = UserPreferences(RuntimeEnvironment.application)

    // ── Login caps ──────────────────────────────────────────────────────────

    @Test
    fun `pin cap 4 - fifth press shows inline error without appending`() {
        val vm = LoginViewModel(FakeAuthRepository(), prefs())
        "1234".forEach { vm.appendPinDigit(it) }
        assertEquals("1234", vm.state.value.pin)

        vm.appendPinDigit('5')

        assertEquals("no 5th digit may be appended", "1234", vm.state.value.pin)
        assertEquals("PIN is 4 digits", vm.state.value.errorMessage)
    }

    @Test
    fun `phone cap 10 - eleventh press shows inline error without appending`() {
        val vm = LoginViewModel(FakeAuthRepository(), prefs())
        "0712345678".forEach { vm.appendPhoneDigit(it) }
        assertEquals("0712345678", vm.state.value.phone)

        vm.appendPhoneDigit('9')

        assertEquals("no 11th digit may be appended", "0712345678", vm.state.value.phone)
        assertEquals("Phone number is 10 digits", vm.state.value.errorMessage)
    }

    @Test
    fun `keypad routes digits to the focused login field`() {
        val vm = LoginViewModel(FakeAuthRepository(), prefs())
        var focusedField = LoginField.PIN
        val digit = { d: Char ->
            when (focusedField) {
                LoginField.PHONE -> vm.appendPhoneDigit(d)
                LoginField.PIN -> vm.appendPinDigit(d)
            }
        }

        digit('7')
        assertEquals("", vm.state.value.phone)
        assertEquals("7", vm.state.value.pin)

        focusedField = LoginField.PHONE
        digit('0')
        assertEquals("0", vm.state.value.phone)
        assertEquals("7", vm.state.value.pin)
    }

    // ── Signup: keypad-only PINs ────────────────────────────────────────────

    @Test
    fun `signup pins are keypad-only with cap 4 and inline mismatch`() {
        val vm = PinSetupViewModel(FakeAuthRepository(), prefs())

        "1234".forEach { vm.appendPinDigit(it) }
        vm.appendPinDigit('5')
        assertEquals("no 5th PIN digit may be appended", "1234", vm.state.value.pin)
        assertEquals("PIN is 4 digits", vm.state.value.pinError)

        "9999".forEach { vm.appendConfirmPinDigit(it) }
        vm.appendConfirmPinDigit('0')
        assertEquals("9999", vm.state.value.confirmPin)
        assertEquals("PIN is 4 digits", vm.state.value.confirmPinError)

        assertTrue("both PINs full and unequal = inline mismatch", vm.state.value.pinsMismatch)
        assertFalse(vm.state.value.isSubmittable)

        vm.backspacePin()
        assertEquals("123", vm.state.value.pin)
        assertNull(vm.state.value.pinError)

        // With the rest of the form valid, mismatch is THE blocking reason.
        vm.updateName("Jane Doe")
        vm.updatePhone("0712345678")
        vm.updateEmail("agent@example.com")
        "1234".forEach { vm.appendPinDigit(it) }
        assertEquals("PINs don't match", vm.state.value.submitDisabledReason)
    }

    @Test
    fun `signup pin fields never use the system keyboard`() {
        val src = source("app/src/main/java/com/bingwascore/app/ui/auth/PinSetupScreen.kt")
        assertTrue(
            "PIN + Confirm PIN must be keypad-driven dot readouts",
            src.contains("PinDotField(") && src.contains("SignUpKeypad(")
        )
        assertFalse(
            "the old system-keyboard NumberPassword PIN TextFields are deleted",
            src.contains("KeyboardType.NumberPassword")
        )
        assertFalse(
            "no text-field updater for PINs may remain",
            src.contains("updatePin(") || src.contains("updateConfirmPin(")
        )
    }

    // ── Signup: one account type ────────────────────────────────────────────

    @Test
    fun `signup sends exactly one account type AGENT`() {
        val vm = PinSetupViewModel(FakeAuthRepository(), prefs())
        assertEquals(AuthConstants.ACCOUNT_TYPE_AGENT, vm.state.value.accountType)
        assertEquals("AGENT", AuthConstants.ACCOUNT_TYPE_AGENT)

        val src = source("app/src/main/java/com/bingwascore/app/ui/auth/PinSetupScreen.kt")
        assertFalse("the Individual/Business toggle is deleted", src.contains("\"Individual\""))
        assertFalse("the Individual/Business toggle is deleted", src.contains("\"Business\""))
        assertFalse("no account-type updater may remain", src.contains("updateAccountType"))
        assertTrue(
            "the single name field covers both cases",
            src.contains("Your name or business name")
        )
    }

    @Test
    fun `create account is disabled with a visible reason until all valid`() {
        val vm = PinSetupViewModel(FakeAuthRepository(), prefs())
        assertNotNull(vm.state.value.submitDisabledReason)
        assertEquals("Enter your name or business name", vm.state.value.submitDisabledReason)

        vm.updateName("Jane Doe")
        assertEquals("Enter a valid 10-digit phone number", vm.state.value.submitDisabledReason)

        vm.updatePhone("0712345678")
        assertEquals("Enter a valid email address", vm.state.value.submitDisabledReason)

        vm.updateEmail("agent@example.com")
        assertNull(vm.state.value.emailError)
        assertEquals("Enter your 4-digit PIN", vm.state.value.submitDisabledReason)

        "1234".forEach { vm.appendPinDigit(it) }
        assertEquals("Confirm your 4-digit PIN", vm.state.value.submitDisabledReason)

        "1234".forEach { vm.appendConfirmPinDigit(it) }
        assertNull(vm.state.value.submitDisabledReason)
        assertTrue(vm.state.value.isSubmittable)
    }

    @Test
    fun `signup email is validated inline with a reason`() {
        val vm = PinSetupViewModel(FakeAuthRepository(), prefs())
        vm.updateEmail("agent")
        assertEquals("Email needs an @ (e.g. agent@example.com)", vm.state.value.emailError)

        vm.updateEmail("agent@example")
        assertEquals("Email needs a domain (e.g. agent@example.com)", vm.state.value.emailError)

        vm.updateEmail("agent@example.com")
        assertNull(vm.state.value.emailError)
    }

    // ── Splash window ───────────────────────────────────────────────────────

    @Test
    fun `splash is visible for at least 1600ms and hands off inside 2s`() {
        assertEquals(
            "the 1600ms constant is both the floor and the total",
            1600,
            Motion.SPLASH_TOTAL
        )
        assertTrue(Motion.SPLASH_TOTAL <= 2_000)
    }
}

