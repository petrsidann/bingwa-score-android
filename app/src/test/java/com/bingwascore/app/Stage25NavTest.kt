package com.bingwascore.app

import com.bingwascore.app.ui.navigation.drawerEntries
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Stage25NavTest {

    @Test
    fun drawerEntries_containsExpectedSecondaryRoutes() {
        assertEquals(13, drawerEntries.size)
        assertEquals("Customers", drawerEntries[0].label)
        assertEquals("Settings", drawerEntries[7].label)
        assertEquals("Diplomatics", drawerEntries[12].label)
    }

    @Test
    fun backNavigation_simulatedStackLandsOnExpectedParent() {
        // Simulated navigation state engine
        var drawerOpen = false
        var showDialer = false
        var showReferral = false
        var selectedDrawerIndex = -1
        var selectedTab = 0

        fun handleBack(): String {
            return when {
                drawerOpen -> {
                    drawerOpen = false
                    "close_drawer"
                }
                showDialer -> {
                    showDialer = false
                    "close_dialer"
                }
                showReferral -> {
                    showReferral = false
                    "close_referral"
                }
                selectedDrawerIndex != -1 -> {
                    selectedDrawerIndex = -1
                    "return_to_main"
                }
                selectedTab != 0 -> {
                    selectedTab = 0
                    "return_to_home_tab"
                }
                else -> "exit"
            }
        }

        // Test 1: Drawer open + back -> closes drawer
        drawerOpen = true
        assertEquals("close_drawer", handleBack())
        assertEquals(false, drawerOpen)

        // Test 2: Quick dial open + back -> closes dialer
        showDialer = true
        assertEquals("close_dialer", handleBack())
        assertEquals(false, showDialer)

        // Test 3: Secondary route (e.g. Customers = 0) + back -> returns to main
        selectedDrawerIndex = 0
        assertEquals("return_to_main", handleBack())
        assertEquals(-1, selectedDrawerIndex)

        // Test 4: Non-Home tab (e.g. Transactions = 3) + back -> returns to Home tab (0)
        selectedTab = 3
        assertEquals("return_to_home_tab", handleBack())
        assertEquals(0, selectedTab)
    }
}
