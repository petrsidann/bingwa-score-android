package com.bingwascore.app

import com.bingwascore.app.domain.DuplicateOfferTransitionRuleException
import com.bingwascore.app.domain.InvalidSenderException
import com.bingwascore.app.domain.TransactionStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Parity F — pipeline guards. The money path throws these instead of silently
 * ignoring a rule violation, so their payloads must stay stable.
 */
class GuardsTest {

    @Test
    fun invalidSender_carriesTheSender() {
        val exception = InvalidSenderException("SAFARICOM")

        assertEquals("SAFARICOM", exception.sender)
        assertTrue(exception.message.orEmpty().contains("SAFARICOM"))
    }

    @Test
    fun duplicateRule_carriesFromAndTo() {
        val exception = DuplicateOfferTransitionRuleException("FAILED", "offer_20")

        assertEquals("FAILED", exception.from)
        assertEquals("offer_20", exception.to)
        assertTrue(exception.message.orEmpty().contains("FAILED"))
    }

    @Test
    fun ignoredStatus_roundTrips() {
        assertEquals("IGNORED", TransactionStatus.IGNORED.value)
        assertEquals(TransactionStatus.IGNORED, TransactionStatus.fromValue("IGNORED"))
    }
}
