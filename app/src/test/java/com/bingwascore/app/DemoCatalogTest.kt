package com.bingwascore.app

import com.bingwascore.app.data.showcase.DemoCatalog
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdResponses
import com.bingwascore.app.utils.SmsParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar
import java.util.Random

/**
 * SHOWCASE S2 — the demo reel must be indistinguishable from the real thing.
 *
 * These tests pin the two halves that can silently rot: the seeded dataset's
 * shape, and the exact Hybrid format of the simulated SMS — asserted by feeding
 * it through the **production** parser and classifier, not a mock.
 */
class DemoCatalogTest {

    // ── Simulator SMS format ──────────────────────────────────────────────────

    @Test
    fun `incoming payment sms matches Hybrid format`() {
        val body = DemoCatalog.incomingPaymentSms(
            receipt = "UHNRD47VMC",
            name = "JOHN DOE",
            phone = "0712345678",
            amount = 20.0,
            newBalance = 100.0,
            timestamp = 1_756_000_000_000L
        )

        assertTrue(body.startsWith("UHNRD47VMC Confirmed.on "))
        assertTrue(body.contains("Ksh20.00 received from JOHN DOE 0712345678"))
        assertTrue(body.contains("New M-PESA balance is KES 100.00"))
        assertTrue(body.endsWith("Transaction cost, KES 0.00."))
    }

    @Test
    fun `simulated sms is classified by the real parser as an incoming payment`() {
        val body = DemoCatalog.incomingPaymentSms(
            receipt = "SJ2KD81LM",
            name = "BAKARI OMAR",
            phone = "0722987654",
            amount = 49.0,
            newBalance = 250.0,
            timestamp = System.currentTimeMillis()
        )

        assertEquals(SmsParser.SmsType.INCOMING_PAYMENT, SmsParser.classify(body))

        val parsed = SmsParser.parse("MPESA", body)
        assertTrue(parsed != null)
        assertEquals(49.0, parsed!!.amount!!, 0.001)
        assertEquals("0722987654", parsed.phone)
        assertEquals("BAKARI OMAR", parsed.name?.trim())
    }

    @Test
    fun `grouped amounts still parse`() {
        val body = DemoCatalog.incomingPaymentSms(
            receipt = "QK7GH2X1P",
            name = "AMINA WANJIKU",
            phone = "0733112244",
            amount = 1825.5,
            newBalance = 940.25,
            timestamp = System.currentTimeMillis()
        )
        assertTrue(body.contains("Ksh1,825.50"))
        assertEquals(1825.5, SmsParser.parse("MPESA", body)?.amount!!, 0.001)
    }

    @Test
    fun `duplicate payment text is byte identical so the bot can dedupe`() {
        val stamp = 1_756_000_000_000L
        val first = DemoCatalog.incomingPaymentSms(
            "DEMO123456", "GRACE NJOKI", "0755667788", 100.0, 400.0, stamp
        )
        val second = DemoCatalog.incomingPaymentSms(
            "DEMO123456", "GRACE NJOKI", "0755667788", 100.0, 400.0, stamp
        )
        assertEquals(first, second)
    }

    @Test
    fun `hybrid stamp has no leading zeros and a 12 hour clock`() {
        val cal = Calendar.getInstance().apply {
            set(2026, Calendar.AUGUST, 23, 17, 51, 0)
            set(Calendar.MILLISECOND, 0)
        }
        assertEquals("23/8/26 at 5:51 PM", DemoCatalog.hybridStamp(cal.timeInMillis))
    }

    @Test
    fun `commission sms is recognised by the real commission parser`() {
        val body = DemoCatalog.commissionSms(1825.1, System.currentTimeMillis())
        assertTrue(body.contains("Commission"))
        assertEquals(1825.1, SmsParser.parseCommission(body)!!, 0.001)
    }

    // ── Fake USSD replies classify like the real ones ─────────────────────────
    @Test
    fun `fake ussd replies classify with the production classifier`() {
        assertEquals(
            TransactionStatus.SUCCESSFUL,
            UssdResponses.classify(DemoCatalog.ussdSuccessReply("Daily Data 1GB"))
        )
        assertEquals(
            TransactionStatus.FAILED_ALREADY_RECOMMENDED,
            UssdResponses.classify(DemoCatalog.ussdAlreadyRecommendedReply())
        )
        assertEquals(
            TransactionStatus.FAILED,
            UssdResponses.classify(DemoCatalog.ussdConnectionProblemReply())
        )
    }
// ── Seeded dataset shape ──────────────────────────────────────────────────

    @Test
    fun `catalog matches the showcase brief`() {
        assertEquals(6, DemoCatalog.CUSTOMERS.size)
        assertEquals(5, DemoCatalog.OFFERS.size)
        assertEquals(4, DemoCatalog.AUTO_REPLIES.size)
        assertEquals(42, DemoCatalog.TRANSACTION_COUNT)
        assertEquals(30, DemoCatalog.HISTORY_DAYS)
    }

    @Test
    fun `every customer phone is a parsable ten digit number`() {
        DemoCatalog.CUSTOMERS.forEach { customer ->
            assertTrue(
                "bad demo phone ${customer.phone}",
                Regex("^[0-9]{10}$").matches(customer.phone)
            )
        }
    }

    @Test
    fun `offer codes look like real ussd codes`() {
        DemoCatalog.OFFERS.forEach { offer ->
            assertTrue(
                "bad demo code ${offer.ussdCode}",
                Regex("^\\*[0-9]+\\*[0-9]+#$").matches(offer.ussdCode)
            )
            assertTrue(offer.price > 0)
        }
    }

    @Test
    fun `seeded statuses are only real statuses and mostly successful`() {
        val random = Random(7L)
        val statuses = (0 until 2_000).map { DemoCatalog.statusFor(random) }
        val valid = TransactionStatus.entries.map { it.value }.toSet()
        assertTrue(statuses.all { it in valid })

        val successfulShare = statuses.count { it == "SUCCESSFUL" } / statuses.size.toDouble()
        assertTrue("expected mostly successful, got $successfulShare", successfulShare > 0.5)
    }

    @Test
    fun `commission is a tenth of the bundle price`() {
        assertEquals(2.0, DemoCatalog.commissionFor(20.0), 0.001)
        assertEquals(150.0, DemoCatalog.commissionFor(1500.0), 0.001)
    }

    @Test
    fun `simulated balance random walk stays in a believable range`() {
        val random = Random(11L)
        var balance = 500.0
        repeat(500) { balance = DemoCatalog.simulatedBalance(balance, random) }
        assertTrue(balance >= 25.0 && balance <= 5_000.0)
    }
}
