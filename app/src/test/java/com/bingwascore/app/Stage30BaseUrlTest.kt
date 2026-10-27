package com.bingwascore.app

import com.bingwascore.app.di.NetworkModule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class Stage30BaseUrlTest {

    @Test
    fun `buildConfig defines BASE_URL`() {
        val baseUrl = BuildConfig.BASE_URL
        assertNotNull(baseUrl)
        // Default fallback value check
        assertEquals("http://10.0.2.2:8080", baseUrl)
    }

    @Test
    fun `networkModule provides base url from buildConfig`() {
        val baseUrl = NetworkModule.provideBaseUrl()
        assertEquals(BuildConfig.BASE_URL, baseUrl)
    }
}
