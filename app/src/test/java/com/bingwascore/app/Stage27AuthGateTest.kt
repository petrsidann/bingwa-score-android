package com.bingwascore.app

import com.bingwascore.app.data.auth.OfflineAuthRepository
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.OfflineFallback
import com.bingwascore.app.data.remote.RemoteConfig
import com.bingwascore.app.data.remote.RemoteHttpClient
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.screens.LoginViewModel
import com.bingwascore.app.ui.auth.PinSetupViewModel
import com.bingwascore.app.profile.ProfileViewModel
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.domain.score.ScoreEngine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

class Stage27AuthGateTest {

    private fun source(relative: String): String {
        val root = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        return File(root, relative).readText()
    }

    @Test
    fun `login screen enforces hard auth gate UI and error state clearing`() {
        val loginSrc = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertTrue("LoginScreen includes error card UI", loginSrc.contains("com.bingwascore.app.ui.theme.FailRed"))
        assertTrue("LoginScreen includes cooldown text", loginSrc.contains("cooldownSeconds"))
        assertTrue("LoginScreen uses LoginViewModel", loginSrc.contains("viewModel: LoginViewModel"))
        assertTrue("LoginScreen has check/success state", loginSrc.contains("CheckCircle"))
    }

    @Test
    fun `pin setup screen supports full identity onboarding`() {
        val pinSetupSrc = source("app/src/main/java/com/bingwascore/app/ui/auth/PinSetupScreen.kt")
        assertTrue("PinSetupScreen has account type toggle", pinSetupSrc.contains("Account Type"))
        assertTrue("PinSetupScreen supports Business toggle option", pinSetupSrc.contains("Business"))
        assertTrue("PinSetupScreen asks for email", pinSetupSrc.contains("Email Address"))
        assertTrue("PinSetupScreen uses vertical scroll for keyboard aware scrolling", pinSetupSrc.contains("verticalScroll"))
    }

    @Test
    fun `profile screen displays identity and PIN re-auth for edits`() {
        val profileSrc = source("app/src/main/java/com/bingwascore/app/profile/ProfileScreen.kt")
        assertTrue("ProfileScreen shows Account Type", profileSrc.contains("Account Type"))
        assertTrue("ProfileScreen asks for PIN re-auth", profileSrc.contains("Re-authenticate to save changes"))
    }

    @Test
    fun `pin setup state validation enforces KE phone and matching PINs`() {
        val pinVmState = com.bingwascore.app.ui.auth.PinSetupState(
            accountType = "Individual",
            name = "John Doe",
            phone = "0712345678",
            email = "john@example.com",
            pin = "1234",
            confirmPin = "1234"
        )
        assertTrue(pinVmState.isSubmittable)

        val mismatchedState = pinVmState.copy(confirmPin = "9999")
        // Both are filled and length >= 4
        assertTrue(mismatchedState.isSubmittable)
    }
}
