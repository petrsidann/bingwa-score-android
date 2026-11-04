package com.bingwascore.app

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.di.NetworkModule
import com.bingwascore.app.ui.settings.isValidServerUrl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * STAGE 33 — runtime server URL.
 *
 * Pure/synchronous assertions only: [isValidServerUrl] validation, the
 * blank default, and [NetworkModule.provideBaseUrl] falling back to
 * [BuildConfig.BASE_URL] when no override is stored. No DataStore writes
 * (which hang under Robolectric due to a pre-existing cold-flow/initial-read
 * issue) and no coroutines.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage33ServerUrlTest {

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

    // ── Requirement: blank default ──
    @Test
    fun `server url defaults to blank`() {
        val prefs = UserPreferences(RuntimeEnvironment.getApplication())
        assertEquals("", prefs.serverUrl.value)
    }

    // ── Requirement: fallback to build config default ──
    @Test
    fun `network module falls back to build config default when nothing is stored`() {
        val prefs = UserPreferences(RuntimeEnvironment.getApplication())
        assertEquals(BuildConfig.BASE_URL, NetworkModule.provideBaseUrl(prefs))
    }
}
