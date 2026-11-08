package com.bingwascore.app

import com.bingwascore.app.ui.navigation.StartDestination
import com.bingwascore.app.ui.navigation.decideStartDestination
import org.junit.Assert.assertEquals
import org.junit.Test

class StartDestinationTest {

    @Test fun firstLaunchAndSignedInGoesOnboarding() {
        assertEquals(StartDestination.Onboarding, decideStartDestination(firstLaunch = true, signedIn = true))
    }

    @Test fun firstLaunchNotSignedInGoesOnboarding() {
        assertEquals(StartDestination.Onboarding, decideStartDestination(firstLaunch = true, signedIn = false))
    }

    @Test fun notFirstLaunchSignedInGoesHome() {
        assertEquals(StartDestination.Main, decideStartDestination(firstLaunch = false, signedIn = true))
    }

    @Test fun notFirstLaunchNotSignedInGoesLogin() {
        assertEquals(StartDestination.Login, decideStartDestination(firstLaunch = false, signedIn = false))
    }
}
