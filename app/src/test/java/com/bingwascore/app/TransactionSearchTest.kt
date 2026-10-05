package com.bingwascore.app

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.ui.transactions.matches
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * POLISH P3 — the transaction search.
 *
 * One field has to answer for three different things an agent might have in
 * their hand: the customer's name (from a receipt book), the phone number (from
 * a call), or the transaction id (from Safaricom support). A query that matches
 * nothing must return false so the screen can say "No available records"
 * instead of rendering an empty list that reads like a broken app.
 */
class TransactionSearchTest {

    private fun tx(
        id: String = "tx_9f3c2a",
        phone: String = "0712345678",
        name: String? = "Amina Wanjiru"
    ) = Transaction(
        id = id,
        phoneNumber = phone,
        customerName = name,
        offerId = "offer_1",
        offerName = "1GB Daily",
        ussdCode = "*544*1#",
        amount = 20.0,
        commission = 2.0,
        status = "SUCCESSFUL",
        createdAt = 1_700_000_000_000L
    )

    @Test
    fun `an empty query matches everything`() {
        assertTrue(tx().matches(""))
        assertTrue(tx().matches("   "))
    }

    @Test
    fun `matches on the customer name regardless of case`() {
        assertTrue(tx().matches("amina"))
        assertTrue(tx().matches("WANJIRU"))
        assertFalse(tx().matches("wanjiru kamau"))
    }

    @Test
    fun `matches on the phone number`() {
        assertTrue(tx().matches("0712"))
        assertTrue(tx().matches("345678"))
        assertFalse(tx().matches("0700000000"))
    }

    @Test
    fun `matches on the transaction id`() {
        assertTrue(tx().matches("tx_9f3c2a"))
        assertTrue(tx().matches("9F3C2A"))
    }

    @Test
    fun `still matches when the transaction has no customer name`() {
        assertTrue(tx(name = null).matches("0712"))
        assertFalse(tx(name = null).matches("amina"))
    }
}
