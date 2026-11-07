package com.bingwascore.app

import com.bingwascore.app.ui.auth.PinErrorLogic
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Stage 57 — pure JUnit test for PinErrorLogic. No Robolectric, no Android.
 */
class PinErrorLogicTest {

    @Test
    fun `len 4 unsubmitted has no error`() {
        val logic = PinErrorLogic()
        "1234".forEach { logic.press(it) }
        assertEquals("1234", logic.pin)
        assertNull(logic.pinError)
    }

    @Test
    fun `5th press sets overflow error without appending`() {
        val logic = PinErrorLogic()
        "1234".forEach { logic.press(it) }
        logic.press('5')
        assertEquals("no 5th digit may be appended", "1234", logic.pin)
        assertEquals("PIN is 4 digits", logic.pinError)
    }

    @Test
    fun `submit with len 3 sets error`() {
        val logic = PinErrorLogic()
        "123".forEach { logic.press(it) }
        logic.submit()
        assertEquals("PIN is 4 digits", logic.pinError)
    }

    @Test
    fun `backspace below 5 clears overflow flag immediately`() {
        val logic = PinErrorLogic()
        "1234".forEach { logic.press(it) }
        logic.press('5')
        assertEquals("PIN is 4 digits", logic.pinError)
        logic.backspace()
        assertEquals("123", logic.pin)
        assertNull(logic.pinError)
    }

    @Test
    fun `error clears once fixed back to 4 before submit`() {
        val logic = PinErrorLogic()
        "1234".forEach { logic.press(it) }
        logic.press('5')
        assertEquals("PIN is 4 digits", logic.pinError)
        logic.backspace()
        logic.press('4')
        assertNull(logic.pinError)
    }
}
