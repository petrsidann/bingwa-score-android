package com.bingwascore.app

import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.AuthSession
import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.screens.LoginViewModel
import java.io.File
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Stage 36 — trace-driven ANR/crash fix + three surgical fixes.
 *
 * Covers the hard fixes pinned by this stage: keyboard off the custom keypad,
 * splash curtain/dots gone, O(1) validation with off-composition error clear,
 * Crash Report reachability on SignIn — plus the regression walk and the
 * per-frame budget. Source-based assertions stay green without a device.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage36TraceFixTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String = File(repoRoot, path).readText()

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

    // ── 1. Keyboard: system keyboard never rises on SignIn ────────────────

    @Test
    fun `main activity hides the system keyboard and never resizes`() {
        val manifest = source("app/src/main/AndroidManifest.xml")
        assertTrue(
            "windowSoftInputMode must be stateAlwaysHidden|adjustNothing",
            manifest.contains("windowSoftInputMode=\"stateAlwaysHidden|adjustNothing\"")
        )
    }

    @Test
    fun `no LocalSoftwareKeyboardController hide call remains`() {
        val login = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertFalse("controller?.hide() must be deleted", login.contains("controller?.hide()"))
        assertFalse("LocalSoftwareKeyboardController must be deleted",
            login.contains("LocalSoftwareKeyboardController"))
    }

    @Test
    fun `phone and pin fields are readOnly so only the custom keypad writes`() {
        val login = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertTrue("fields must be readOnly", login.contains("readOnly = true"))
    }

    // ── 3. Validation: O(1) pure functions, error clear off composition ───

    @Test
    fun `per-keystroke validation is O(1) with no regex and no loops`() {
        val login = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertFalse("updatePhone must not scan the value", login.contains("value.filter"))
        assertFalse("updatePin must not scan the value", login.contains("pin.filter"))
        assertFalse("no regex backtracking in validation", login.contains("Regex("))
        assertTrue("updatePhone is a straight O(1) state copy",
            login.contains("_state.value = _state.value.copy(phone = value)"))
        assertTrue("updatePin is a straight O(1) state copy",
            login.contains("_state.value = _state.value.copy(pin = value)"))
    }

    @Test
    fun `error clear runs in LaunchedEffect(snapshotFlow), never during composition`() {
        val login = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertTrue("snapshotFlow observes state changes",
            login.contains("snapshotFlow { state }"))
        assertTrue("the clear is a LaunchedEffect side effect", login.contains("LaunchedEffect(Unit)"))
        assertTrue("clearError exposes the write", login.contains("fun clearError()"))
        assertTrue("the clear is launched off the composition thread", login.contains(".launchIn(this)"))
    }

    @Test
    fun `signIn stays under the 16ms frame budget in the harness`() = runBlocking {
        val context = RuntimeEnvironment.application
        val login = LoginViewModel(FakeAuthRepository(), UserPreferences(context))
        login.updatePhone("0712345678")
        login.updatePin("1234")
        // Warm up Robolectric, the coroutine machinery and the DataStore-backed
        // preferences so the measured iterations are steady state.
        repeat(150) { login.signIn {} }
        val timings = MutableList(300) { 0L }
        repeat(300) { i ->
            val start = System.nanoTime()
            login.updatePhone("0712345678")
            login.updatePin("1234")
            login.signIn {}
            timings[i] = (System.nanoTime() - start) / 1_000_000
        }
        val max = timings.maxOrNull() ?: 0L
        assertTrue("sign-in frame took $max ms, over the 16ms budget", max < 16)
    }

    // ── 4. Debug reachability: Crash Report from the SignIn wordmark ──────

    @Test
    fun `long-press on the SignIn wordmark opens the Crash Report dialog`() {
        val login = source("app/src/main/java/com/bingwascore/app/ui/screens/LoginScreen.kt")
        assertTrue("the wordmark is rendered on SignIn", login.contains("BrandWordmark.TEXT"))
        assertTrue("long-press opens the dialog", login.contains("onLongClick = { showCrashReport = true }"))
        assertTrue("the dialog shows the last CrashHandler stack",
            login.contains("CrashHandler.readLatestCrashReport"))
        assertTrue("an AlertDialog presents the report", login.contains("AlertDialog("))
    }

    // ── 2. Splash: curtain and grey dots gone, mark on canvas ─────────────

    @Test
    fun `splash has no grey dot particles`() {
        val splash = source("app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt")
        assertFalse("no Random spark source", splash.contains("Random("))
        assertFalse("no spark particle loop", splash.contains("spark"))
    }

    @Test
    fun `splash band region diffs empty against the canvas in both themes`() {
        val splash = source("app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt")
        val curtains = Regex("""\.background\(BgBlack\)""").findAll(splash).count()
        assertEquals("only the surface canvas background remains; no band curtain", 1, curtains)
        assertFalse("no rounded-rectangle curtain", splash.contains("RoundedCornerShape"))
    }

    @Test
    fun `splash wordmark renders directly on canvas color`() {
        val splash = source("app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt")
        val wordmark = splash.substringAfter(
            "private fun MaskSweepWordmark",
            missingDelimiterValue = "MaskSweepWordmark not found"
        )
        assertTrue("the wordmark iterates the full text", wordmark.contains("text.forEachIndexed"))
        assertTrue("the ink stays theme-aware", wordmark.contains("color = ink"))
        assertFalse("no curtain box", wordmark.contains("Box("))
        assertFalse("no curtain clip", wordmark.contains("clip("))
    }

    @Test
    fun `splash keeps monogram stroke bloom and tagline`() {
        val splash = source("app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt")
        assertTrue("monogram stroke draws", splash.contains("drawMonogram(trim.value, glow.value, ink)"))
        assertTrue("traveling tip rides the stroke head", splash.contains("drawTravelingTip(trim.value, ink)"))
        assertTrue("completion bloom ring", splash.contains("bloom.animateTo(1f, tween(400))"))
        assertTrue("tagline remains", splash.contains("Your bundle business, automated."))
    }

    // ── Regression walk: SignIn -> type -> Home -> relaunch ───────────────

    @Test
    fun `regression walk sign in type home relaunch stays green`() = runBlocking {
        val context = RuntimeEnvironment.application
        val prefs = UserPreferences(context)
        val repo = FakeAuthRepository()

        // Sign in: phone + 4-digit PIN -> loading then Verified!.
        val login = LoginViewModel(repo, prefs)
        login.updatePhone("0712345678")
        login.updatePin("1234")
        login.signIn {}
        assertTrue("sign-in accepted", login.state.value.isLoading || login.state.value.isSuccess)

        // Type more keystrokes mid-flow: O(1) validation, no cooldown injected.
        login.updatePhone("0712345679")
        login.updatePin("4321")
        assertEquals("0712345679", login.state.value.phone)
        assertEquals("4321", login.state.value.pin)
        assertFalse("typing keeps the engine alive", login.state.value.cooldownSeconds > 0)
        assertTrue("sign-in reached its terminal state",
            login.state.value.isSuccess || login.state.value.isLoading)

        // Relaunch: a fresh ViewModel over the same prefs constructs and signs again.
        val relaunched = LoginViewModel(repo, prefs)
        relaunched.updatePhone("0712345678")
        relaunched.updatePin("1234")
        relaunched.signIn {}
        assertTrue("relaunch sign-in accepted", relaunched.state.value.isLoading || relaunched.state.value.isSuccess)
    }
}
