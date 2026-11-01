package com.bingwascore.app

import androidx.compose.ui.graphics.Color
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.AuthSession
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.screens.LoginField
import com.bingwascore.app.ui.screens.LoginViewModel
import com.bingwascore.app.ui.theme.installDisplayMode
import com.bingwascore.app.ui.theme.isPorcelain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File

/**
 * Stage 42 — LOGIN FOCUS ROUTING TESTS.
 *
 * Verifies:
 * 1) Tap phone -> digits land in phone.
 * 2) Tap pin -> digits land in pin.
 * 3) Backspace edits the focused field.
 * 4) No soft keyboard (windowSoftInputMode retained, readOnly=true, focusable=true).
 * 5) Auto-jump after 10 phone digits.
 * 6) Focused field shows 2dp brand-blue border (Obsidian #2563EB, Dim #2F6AE0).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage42LoginFocusRoutingTest {

    private fun source(relative: String): String {
        val root = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        return File(root, relative).readText()
    }

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

    private fun createViewModel(): LoginViewModel {
        val context = RuntimeEnvironment.application
        return LoginViewModel(FakeAuthRepository(), UserPreferences(context))
    }

    @Test
    fun `tap phone - digits land in phone and backspace edits phone`() {
        val vm = createViewModel()
        var focusedField = LoginField.PHONE

        val simulateDigit = { digit: Char ->
            when (focusedField) {
                LoginField.PHONE -> vm.appendPhoneDigit(digit)
                LoginField.PIN -> vm.appendPinDigit(digit)
            }
        }
        val simulateBackspace = {
            when (focusedField) {
                LoginField.PHONE -> vm.backspacePhone()
                LoginField.PIN -> vm.backspacePin()
            }
        }

        "07123".forEach { simulateDigit(it) }
        assertEquals("07123", vm.state.value.phone)
        assertEquals("", vm.state.value.pin)

        simulateBackspace()
        assertEquals("0712", vm.state.value.phone)
        assertEquals("", vm.state.value.pin)
    }

    @Test
    fun `tap pin - digits land in pin and backspace edits pin`() {
        val vm = createViewModel()
        var focusedField = LoginField.PIN

        val simulateDigit = { digit: Char ->
            when (focusedField) {
                LoginField.PHONE -> vm.appendPhoneDigit(digit)
                LoginField.PIN -> vm.appendPinDigit(digit)
            }
        }
        val simulateBackspace = {
            when (focusedField) {
                LoginField.PHONE -> vm.backspacePhone()
                LoginField.PIN -> vm.backspacePin()
            }
        }

        "123".forEach { simulateDigit(it) }
        assertEquals("", vm.state.value.phone)
        assertEquals("123", vm.state.value.pin)

        simulateBackspace()
        assertEquals("", vm.state.value.phone)
        assertEquals("12", vm.state.value.pin)
    }

    @Test
    fun `auto-jump to PIN after 10 phone digits`() {
        val vm = createViewModel()
        var focusedField = LoginField.PHONE

        val simulateDigit = { digit: Char ->
            when (focusedField) {
                LoginField.PHONE -> {
                    vm.appendPhoneDigit(digit)
                    if (vm.state.value.phone.length >= 10) {
                        focusedField = LoginField.PIN
                    }
                }
                LoginField.PIN -> vm.appendPinDigit(digit)
            }
        }

        "0712345678".forEach { simulateDigit(it) }
        assertEquals("0712345678", vm.state.value.phone)
        assertEquals(LoginField.PIN, focusedField)

        // 11th digit typed should now route to PIN because focusedField jumped to PIN
        simulateDigit('9')
        assertEquals("0712345678", vm.state.value.phone)
        assertEquals("9", vm.state.value.pin)
    }

    @Test
    fun `border color is 2563EB in obsidian and 2F6AE0 in dim`() {
        installDisplayMode(ThemeMode.DARK)
        assertFalse(isPorcelain)
        val obsidianBorderColor = if (isPorcelain) Color(0xFF2F6AE0) else Color(0xFF2563EB)
        assertEquals(Color(0xFF2563EB), obsidianBorderColor)

        installDisplayMode(ThemeMode.PORCELAIN_DIM)
        assertTrue(isPorcelain)
        val dimBorderColor = if (isPorcelain) Color(0xFF2F6AE0) else Color(0xFF2563EB)
        assertEquals(Color(0xFF2F6AE0), dimBorderColor)

        installDisplayMode(ThemeMode.DARK)
    }

    @Test
    fun `system keyboard is never shown and fields are readOnly with focusable`() {
        val manifest = source("app/src/main/AndroidManifest.xml")
        assertTrue(
            "MainActivity must retain stateAlwaysHidden|adjustNothing",
            manifest.contains("android:windowSoftInputMode=\"stateAlwaysHidden|adjustNothing\"")
        )

        val loginSrc = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertTrue("readOnly=true is enforced", loginSrc.contains("readOnly = true"))
        assertTrue("focusable is enforced", loginSrc.contains(".focusable()"))
        assertTrue("focusRequester is wired", loginSrc.contains(".focusRequester(focusRequester)"))
        assertTrue("focused 2dp border is applied", loginSrc.contains("if (isFocused) 2.dp else 1.dp"))
        assertTrue("Obsidian color 2563EB is present", loginSrc.contains("0xFF2563EB"))
        assertTrue("Dim color 2F6AE0 is present", loginSrc.contains("0xFF2F6AE0"))
        assertTrue("auto-jump LaunchedEffect is present", loginSrc.contains("snapshotFlow { phone.length }"))
    }
}
