package com.bingwascore.app

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.di.NetworkModule
import com.bingwascore.app.data.preferences.UserPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Stage30BaseUrlTest {

    @Test
    fun `buildConfig defines BASE_URL`() {
        val baseUrl = BuildConfig.BASE_URL
        assertNotNull(baseUrl)
        // Default fallback value check
        assertEquals("http://10.0.2.2:8080", baseUrl)
    }

    @Test
    fun `networkModule provides buildConfig default when nothing is stored`() {
        val prefs = UserPreferences(RuntimeEnvironment.application)
        assertEquals(BuildConfig.BASE_URL, NetworkModule.provideBaseUrl(prefs))
    }
}
