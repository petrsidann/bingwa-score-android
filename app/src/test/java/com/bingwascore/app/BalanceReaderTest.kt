package com.bingwascore.app

import com.bingwascore.app.services.BalanceReader
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * POLISH P1 — the `*144#` reply parser.
 *
 * The balance is now *only* ever read from the network, so the parser is the
 * difference between an honest number and a wrong one: it must prefer the
 * labelled "Airtime Bal:" figure when the reply carries several Ksh amounts, and
 * it must return null (never 0.0) when it cannot read the reply, so the UI can
 * say "unavailable" instead of confidently showing an empty wallet.
 */
class BalanceReaderTest {

    @Test
    fun `parses the labelled airtime balance when the currency trails the amount`() {
        val reply = "Airtime Bal: Ksh 1,234.56\nM-Pesa Bal: Ksh 2,000.00"
        assertEquals(1234.56, BalanceReader.parse(reply)!!, 0.001)
    }

    @Test
    fun `parses the labelled balance when the amount trails the currency`() {
        val reply = "Airtime Bal: 1,234.56 Ksh\nM-Pesa Bal: 2,000.00 Ksh"
        assertEquals(1234.56, BalanceReader.parse(reply)!!, 0.001)
    }

    @Test
    fun `parses a single decimal amount without thousands separators`() {
        assertEquals(87.50, BalanceReader.parse("Airtime Bal: Ksh 87.50")!!, 0.001)
    }

    @Test
    fun `falls back to a bare Ksh figure when the label is missing`() {
        assertEquals(340.75, BalanceReader.parse("Your balance is Ksh 340.75")!!, 0.001)
    }

    @Test
    fun `returns null for a reply with no money in it`() {
        assertNull(BalanceReader.parse("You have no active bundles."))
    }

    @Test
    fun `returns null for blank and null replies`() {
        assertNull(BalanceReader.parse(null))
        assertNull(BalanceReader.parse(""))
        assertNull(BalanceReader.parse("   "))
    }

    @Test
    fun `the unavailable sentence is the one the agent reads`() {
        assertEquals(
            "Balance unavailable - check SIM/permissions",
            BalanceReader.UNAVAILABLE_MESSAGE
        )
    }
}
