package com.bingwascore.app

import com.bingwascore.app.ui.qr.VCardParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * PREMIUM LOCK — QR Scanner payload parsing.
 *
 * Covers the two shapes a shared contact QR actually uses (vCard 3.0 and
 * MECARD) plus a bare number, and the null cases that must never silently
 * import garbage.
 */
class VCardParserTest {

    @Test
    fun parsesVCardWithFullNameAndCellNumber() {
        val raw = """
            BEGIN:VCARD
            VERSION:3.0
            N:Bett;Ann;;;
            FN:Ann Bett
            TEL;TYPE=CELL:+254712345678
            END:VCARD
        """.trimIndent()

        val contact = VCardParser.parse(raw)

        assertEquals("Ann Bett", contact?.name)
        assertEquals("+254712345678", contact?.phone)
    }

    @Test
    fun fallsBackToStructuredNameWhenNoFullName() {
        val raw = "BEGIN:VCARD\nN:Wanjiku;Mary;;;\nTEL:0712345678\nEND:VCARD"

        val contact = VCardParser.parse(raw)

        assertEquals("Wanjiku", contact?.name)
        assertEquals("0712345678", contact?.phone)
    }

    @Test
    fun parsesMecardPayload() {
        val raw = "MECARD:N:Peter;TEL:+254733000111;EMAIL:peter@example.com;"

        val contact = VCardParser.parse(raw)

        assertEquals("Peter", contact?.name)
        assertEquals("+254733000111", contact?.phone)
    }

    @Test
    fun mcardFallsBackToPhoneWhenNameMissing() {
        val contact = VCardParser.parse("MECARD:TEL:0712000000;")

        assertEquals("Scanned contact", contact?.name)
        assertEquals("0712000000", contact?.phone)
    }

    @Test
    fun parsesBareNumberAndStripsFormatting() {
        val contact = VCardParser.parse("+254 712-345 678")

        assertEquals("Scanned contact", contact?.name)
        assertEquals("+254712345678", contact?.phone)
    }

    @Test
    fun returnsNullForNonContactPayload() {
        assertNull(VCardParser.parse("https://example.com/menu"))
    }

    @Test
    fun returnsNullForEmptyPayload() {
        assertNull(VCardParser.parse("   "))
    }

    @Test
    fun vcardWithoutTelIsRejected() {
        assertNull(VCardParser.parse("BEGIN:VCARD\nFN:No Phone\nEND:VCARD"))
    }
}
