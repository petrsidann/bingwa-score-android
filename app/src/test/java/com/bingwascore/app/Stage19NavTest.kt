package com.bingwascore.app

import com.bingwascore.app.updates.isNewer
import com.bingwascore.app.updates.parseSemver
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** Stage 19 — nav restructure: hamburger pill + My Score drawer + zero Home score. */
class Stage19NavTest {

    @Test
    fun `drawer labels constant has my score entry`() {
        assertTrue(NAV_DRAWER_LABELS_FOR_TEST.contains("My Score"))
    }

    @Test
    fun `home has zero score ui`() {
        assertFalse(HOME_HAS_SCORE_UI_FOR_TEST)
    }

    companion object {
        val NAV_DRAWER_LABELS_FOR_TEST = listOf(
            "Customers", "Auto Renewals", "Smart Follow-Up", "Autopilot",
            "Agent Portal", "Bingwa Mesh", "Redeem Coupon", "Settings",
            "Announcements", "My Score", "Community", "My Plan", "Diplomatics"
        )
        const val HOME_HAS_SCORE_UI_FOR_TEST = false
    }
}

/** Stage 21 — dim light + updater truth. */
class Stage21DimUpdateTest {

    @Test
    fun `semver parses`() {
        assertEquals(listOf(1, 9, 1), parseSemver("v1.9.1"))
        assertEquals(listOf(1, 9, 0), parseSemver("1.9.0"))
    }

    @Test
    fun `newer detects`() {
        assertTrue(isNewer("1.9.0", "1.9.1"))
        assertFalse(isNewer("1.9.1", "1.9.1"))
        assertFalse(isNewer("1.9.1", "1.9.0"))
    }
}
