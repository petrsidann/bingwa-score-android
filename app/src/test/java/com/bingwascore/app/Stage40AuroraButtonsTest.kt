package com.bingwascore.app

import com.bingwascore.app.ui.auth.PinSetupState
import com.bingwascore.app.ui.screens.LoginUiState
import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertTrue
import org.junit.Test

class Stage40AuroraButtonsTest {
    @Test
    fun `launch completes under 1500ms`() {
        assertTrue(Motion.SPLASH_TOTAL < 1500)
    }

    @Test
    fun `login state is submittable with valid data`() {
        val state = LoginUiState(phone = "0712345678", pin = "1234")
        assertTrue(state.isSubmittable)
    }

    @Test
    fun `pin setup state is submittable with valid data`() {
        val state = PinSetupState(name = "Agent", phone = "0712345678", email = "agent@example.com", pin = "1234", confirmPin = "1234")
        assertTrue(state.isSubmittable)
    }
}
