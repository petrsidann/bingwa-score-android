package com.bingwascore.app

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdResponses
import com.bingwascore.app.utils.CsvEscapes
import com.bingwascore.app.utils.SmsParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Audit G9: functional-truth + pipeline-helper unit tests. Pure JVM — no
 * Android framework, no Hilt, no Room.
 */
class SmsParserTest {

    private val incomingBody =
        "UHNRD47VMC Confirmed.on 23/8/26 at 5:51 PMKSH20.00 received from " +
            "JOHN DOE 0712345678. New M-PESA balance is KES 100.00."

    @Test
    fun classify_incomingPayment() {
        assertEquals(SmsParser.SmsType.INCOMING_PAYMENT, SmsParser.classify(incomingBody))
        val parsed = SmsParser.parse("MPESA", incomingBody)!!
        assertEquals(SmsParser.SmsType.INCOMING_PAYMENT, parsed.type)
        assertEquals(20.0, parsed.amount!!, 0.001)
        assertEquals("0712345678", parsed.phone)
    }

    @Test
    fun classify_outgoingVariants_areOutgoing() {
        listOf(
            "QK7GH2X1P Confirmed. Ksh100.00 sent to JANE 0711223344 on 2/8/26.",
            "You have sent Ksh50.00 to 0722333444.",
            "Ksh200.00 withdrawn from M-PESA agent 12345."
        ).forEach { body ->
            assertEquals("body=$body", SmsParser.SmsType.OUTGOING_PAYMENT, SmsParser.classify(body))
        }
    }

    @Test
    fun classify_outgoingWinsOverIncoming() {
        val mixed = "$incomingBody You have sent Ksh5.00 to 0700000000."
        assertEquals(SmsParser.SmsType.OUTGOING_PAYMENT, SmsParser.classify(mixed))
    }

    @Test
    fun simulatePaymentBody_passesIncomingGate() {
        // Parity C: exact string built by TransactionPipeline.simulateIncomingPayment
        // ("from [Name] [Phone]... Ksh[Amount]...") must classify INCOMING and
        // parse name/phone/amount via the Hybrid regexes.
        val receipt = "SIM1234567"
        val body = "$receipt Confirmed. on 29/9/26 at 12:00 PM " +
            "Ksh20.00 received from JOHN DOE 0712345678, on 29/9/26 at 12:01 PM. " +
            "New M-PESA balance is KES 1,000.00."
        assertEquals(SmsParser.SmsType.INCOMING_PAYMENT, SmsParser.classify(body))
        val parsed = SmsParser.parse("MPESA", body)!!
        assertEquals(SmsParser.SmsType.INCOMING_PAYMENT, parsed.type)
        assertEquals(20.0, parsed.amount!!, 0.001)
        assertEquals("0712345678", parsed.phone)
        assertEquals("JOHN DOE", parsed.name)
        assertEquals(receipt, parsed.receipt)
    }

    @Test
    fun classify_commissionAndCompletion() {
        assertEquals(
            SmsParser.SmsType.COMMISSION,
            SmsParser.classify("Total Commission this week is Ksh.1825.10")
        )
        assertEquals(
            SmsParser.SmsType.COMPLETION,
            SmsParser.classify("You have successfully recommended 1GB to 0712345678.")
        )
        assertEquals(SmsParser.SmsType.UNKNOWN, SmsParser.classify("Hello, how are you?"))
    }

    @Test
    fun parse_nonMpesaSender_returnsNull() {
        assertNull(SmsParser.parse("0712345678", "hello there"))
    }

    @Test
    fun ussdResponses_classify() {
        assertEquals(
            TransactionStatus.FAILED_ALREADY_RECOMMENDED,
            UssdResponses.classify("This number was already recommended today")
        )
        assertEquals(TransactionStatus.FAILED, UssdResponses.classify("Request failed, try again"))
        assertEquals(TransactionStatus.FAILED, UssdResponses.classify("Error processing request"))
        assertEquals(TransactionStatus.SUCCESSFUL, UssdResponses.classify("You have successfully purchased 1GB"))
    }

    @Test
    fun csvEscape_quotesSpecials() {
        assertEquals("plain", CsvEscapes.escape("plain"))
        assertEquals("\"a,b\"", CsvEscapes.escape("a,b"))
        assertEquals("\"a\"\"b\"", CsvEscapes.escape("a\"b"))
        assertTrue(CsvEscapes.escape("a\nb").startsWith("\""))
    }
}
