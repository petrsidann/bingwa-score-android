package com.bingwascore.app

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteHttpClient
import com.bingwascore.app.di.NetworkModule
import com.bingwascore.app.ui.settings.isValidServerUrl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage33ServerUrlTest {

    private fun awaitBaseUrl(http: RemoteHttpClient, expected: String) = runBlocking {
        for (i in 1..200) {
            if (http.baseUrl == expected) return@runBlocking
            delay(20)
        }
        error("effective URL did not converge to $expected; was ${http.baseUrl}")
    }

    // ── Requirement: invalid URL rejected ──
    @Test
    fun `rejects non-https and blank server urls`() {
        assertFalse("blank is rejected", isValidServerUrl(""))
        assertFalse("whitespace is rejected", isValidServerUrl("   "))
        assertFalse("http is rejected", isValidServerUrl("http://example.com"))
        assertFalse("ftp is rejected", isValidServerUrl("ftp://example.com"))
        assertFalse("garbage is rejected", isValidServerUrl("not-a-url"))
        assertFalse("https without host is rejected", isValidServerUrl("https://"))
        assertTrue("https url is accepted", isValidServerUrl("https://example.com"))
        assertTrue("https url with port and path is accepted", isValidServerUrl("https://api.bingwascore.com:8443/v1"))
    }

    // ── Requirement: persistence across restart ──
    @Test
    fun `server url persists across a fresh preferences instance`() = runBlocking {
        val context = RuntimeEnvironment.application
        val prefs = UserPreferences(context)
        prefs.setServerUrl("https://restart.example.com")

        // Simulate restart: a new UserPreferences instance over the same store.
        val restarted = UserPreferences(context)
        assertEquals("https://restart.example.com", restarted.serverUrl.first())
    }

    // ── Requirement: client rebuild ──
    @Test
    fun `client is rebuilt when the server url changes`() = runBlocking {
        val context = RuntimeEnvironment.application
        val prefs = UserPreferences(context)
        val http = RemoteHttpClient(prefs)

        prefs.setServerUrl("https://alpha.example.com")
        awaitBaseUrl(http, "https://alpha.example.com")
        val client1 = http.client()

        prefs.setServerUrl("https://beta.example.com")
        awaitBaseUrl(http, "https://beta.example.com")
        val client2 = http.client()

        assertNotSame("client must be rebuilt on URL change", client1, client2)
    }

    // ── NetworkModule reads the effective URL (DataStore override of default) ──
    @Test
    fun `network module falls back to build config default when nothing is stored`() = runBlocking {
        val prefs = UserPreferences(RuntimeEnvironment.application)
        prefs.setServerUrl("")
        assertEquals(BuildConfig.BASE_URL, NetworkModule.provideBaseUrl(prefs))
    }
}
