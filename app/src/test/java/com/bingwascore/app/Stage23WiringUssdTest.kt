package com.bingwascore.app

import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.engine.UssdSessionChain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Stage23WiringUssdTest {

    @Test
    fun ussdChainParser_splitsFullCodeIntoRootAndSegments() {
        val code = "*544*1*1*6*0712345678*1#"
        val parsed = UssdSessionChain.parse(code)

        assertEquals("*544#", parsed.rootDial)
        assertEquals(listOf("1", "1", "6", "0712345678", "1"), parsed.segments)
        assertEquals(6, parsed.totalHops)
    }

    @Test
    fun ussdChainParser_handlesSingleRootCode() {
        val code = "*544#"
        val parsed = UssdSessionChain.parse(code)

        assertEquals("*544#", parsed.rootDial)
        assertTrue(parsed.segments.isEmpty())
        assertEquals(1, parsed.totalHops)
    }

    @Test
    fun ussdChain_autoSubmitsNextSegmentsAndLogsHops() {
        val code = "*544*1*1*6*0712345678*1#"
        val parsed = UssdSessionChain.parse(code)
        val chain = UssdSessionChain(parsed)

        val root = chain.start()
        assertEquals("*544#", root)

        // Hop 0 response -> Menu choice 1
        var outcome = chain.onResponse("1. Data Deals\n2. Daily\nMORE")
        assertTrue("Expected HopOutcome.Next but was $outcome", outcome is UssdSessionChain.HopOutcome.Next)
        assertEquals("1", (outcome as UssdSessionChain.HopOutcome.Next).nextSegment)

        // Hop 1 response -> Menu choice 1
        outcome = chain.onResponse("1. 100MB 24hr\n2. 500MB\nMORE")
        assertTrue(outcome is UssdSessionChain.HopOutcome.Next)
        assertEquals("1", (outcome as UssdSessionChain.HopOutcome.Next).nextSegment)

        // Hop 2 response -> Menu choice 6
        outcome = chain.onResponse("1. Buy for me\n6. Buy for another\nMORE")
        assertTrue(outcome is UssdSessionChain.HopOutcome.Next)
        assertEquals("6", (outcome as UssdSessionChain.HopOutcome.Next).nextSegment)

        // Hop 3 response -> Phone
        outcome = chain.onResponse("Enter phone number:\nREPLY")
        assertTrue(outcome is UssdSessionChain.HopOutcome.Next)
        assertEquals("0712345678", (outcome as UssdSessionChain.HopOutcome.Next).nextSegment)

        // Hop 4 response -> Final choice 1
        outcome = chain.onResponse("Confirm purchase?\n1. Yes\n2. No\nREPLY")
        assertTrue(outcome is UssdSessionChain.HopOutcome.Next)
        assertEquals("1", (outcome as UssdSessionChain.HopOutcome.Next).nextSegment)

        // Final response -> Success
        outcome = chain.onResponse("You have successfully purchased 100MB 24hr")
        assertTrue(outcome is UssdSessionChain.HopOutcome.Complete)
        assertEquals(TransactionStatus.SUCCESSFUL, (outcome as UssdSessionChain.HopOutcome.Complete).status)

        assertEquals(6, chain.logs.size)
        assertEquals("*544#", chain.logs[0].sent)
        assertEquals("1", chain.logs[0].next)
    }

    @Test
    fun ussdChain_timeoutRetriesAndFails() {
        val parsed = UssdSessionChain.parse("*544*1#")
        val chain = UssdSessionChain(parsed)
        chain.start()

        // Hop 0 times out once -> retry
        var outcome = chain.onTimeout()
        assertTrue(outcome is UssdSessionChain.HopOutcome.Retry)

        // Hop 0 times out second time -> fail
        outcome = chain.onTimeout()
        assertTrue(outcome is UssdSessionChain.HopOutcome.Failed)
        assertEquals(UssdSessionChain.State.FAILED, chain.state)
    }

    @Test
    fun ussdChain_abortStopsChain() {
        val parsed = UssdSessionChain.parse("*544*1#")
        val chain = UssdSessionChain(parsed)
        chain.start()

        val outcome = chain.abort()
        assertTrue(outcome is UssdSessionChain.HopOutcome.Aborted)
        assertEquals(UssdSessionChain.State.ABORTED, chain.state)

        val nextOutcome = chain.onResponse("1. Data\nMORE")
        assertTrue(nextOutcome is UssdSessionChain.HopOutcome.Aborted)
    }

    @Test
    fun authConstants_containsOfflineBanner() {
        assertEquals("Offline - local mode", AuthConstants.OFFLINE_BANNER)
    }
}
