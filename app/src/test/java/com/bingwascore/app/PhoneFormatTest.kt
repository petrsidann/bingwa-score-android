package com.bingwascore.app

import com.bingwascore.app.util.formatPhoneToTenDigits
import com.bingwascore.app.util.isTenDigitPhone
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Parity E: dial-pad normaliser used by the Dialer (on blur) and `DialerViewModel`
 * before a USSD code is expanded. Pure JVM — no Android framework needed.
 */
class PhoneFormatTest {

    @Test
    fun format_stripsCountryCode() {
        assertEquals("0712345678", formatPhoneToTenDigits("+254 712 345 678"))
        assertEquals("0712345678", formatPhoneToTenDigits("254712345678"))
    }

    @Test
    fun format_addsTrunkZero() {
        assertEquals("0712345678", formatPhoneToTenDigits("712345678"))
        assertEquals("0112345678", formatPhoneToTenDigits("112345678"))
    }

    @Test
    fun format_keepsCanonicalNumber() {
        assertEquals("0712345678", formatPhoneToTenDigits("0712345678"))
        assertEquals("0712345678", formatPhoneToTenDigits("0712 345 678"))
    }

    @Test
    fun format_returnsBareDigitsForUnknownShapes() {
        assertEquals("", formatPhoneToTenDigits(""))
        assertEquals("", formatPhoneToTenDigits("no digits here"))
        // Too long to be a mobile number: passed through as bare digits so the
        // caller can reject it (isTenDigitPhone) instead of silently truncating.
        assertEquals("254712345678999", formatPhoneToTenDigits("+254 712 345 678 999"))
        // Short/partial input keeps whatever the user typed as digits.
        assertEquals("071234", formatPhoneToTenDigits("071234"))
    }

    @Test
    fun isTenDigitPhone_onlyAcceptsCanonicalForm() {
        assertTrue(isTenDigitPhone("0712345678"))
        assertFalse(isTenDigitPhone("712345678"))
        assertFalse(isTenDigitPhone("071234567"))
        assertFalse(isTenDigitPhone("071234567a"))
        assertFalse(isTenDigitPhone(""))
    }
}
