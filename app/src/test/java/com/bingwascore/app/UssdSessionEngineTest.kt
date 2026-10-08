package com.bingwascore.app

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.engine.UssdSessionEngine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * U1 — USSD session truth. The two laws this class exists to protect:
 *  1. the dial string is the stored offer code with ONLY the phone placeholder
 *     substituted (kills the wrong-parameter "Invalid choice" bug);
 *  2. a MENU continues with the offer's step list (default `1`, never a
 *     hard-coded `2`), bounded and classified, terminal closes.
 */
class UssdSessionEngineTest {

    // ── Law 1: code generation ────────────────────────────────────────────────

    @Test
    fun generatedDialString_equalsStoredCodeWithPhoneOnly() {
        val stored = "*544*1*1*ph#"
        val phone = "0712345678"
        // Byte-for-byte the stored code; ONLY `ph` moved — the `1` parameters
        // are untouched (a `2` appearing here is the Invalid-choice bug).
        assertEquals("*544*1*1*0712345678#", UssdSessionEngine.generateDialString(stored, phone))
    }

    @Test
    fun generatedDialString_neverRewritesParameters() {
        val cases = mapOf(
            "*544*1*1*ph#" to "*544*1*1*0712345678#",
            "*682*1*ph#" to "*682*1*0712345678#",
            "*999*1*ph#" to "*999*1*0712345678#",
            "*544*5*1*PH#" to "*544*5*1*0712345678#",
            "*100*BH#" to "*100*0712345678#"
        )
        cases.forEach { (stored, expected) ->
            assertEquals(expected, UssdSessionEngine.generateDialString(stored, "0712345678"))
        }
    }

    // ── Law 2: menu continuation ──────────────────────────────────────────────

    @Test
    fun menuScreens_areDetected() {
        assertTrue(UssdSessionEngine.isMenu("1. Buy bundle\n2. Check balance\nMORE"))
        assertTrue(UssdSessionEngine.isMenu("Reply with option\n1) Data\n2) Airtime"))
        assertTrue(UssdSessionEngine.isMenu("Send MORE for options or BACK to return"))
        assertTrue(UssdSessionEngine.isMenu("Enter amount and REPLY"))
    }

    @Test
    fun terminalScreens_areNotMenus() {
        assertFalse(UssdSessionEngine.isMenu("You have successfully purchased 1GB Daily."))
        assertFalse(UssdSessionEngine.isMenu("Bundle for this number has already been recommended."))
        assertFalse(UssdSessionEngine.isMenu(""))
    }

    @Test
    fun terminalResponse_completesWithClassification() {
        val verdict = UssdSessionEngine.classify(
            "You have successfully purchased 1GB.", emptyList(), 0
        )
        assertTrue(verdict is UssdSessionEngine.Verdict.Complete)
        assertEquals(
            TransactionStatus.SUCCESSFUL,
            (verdict as UssdSessionEngine.Verdict.Complete).status
        )
    }

    @Test
    fun menuResponse_usesOfferStepList_notAHardCodedTwo() {
        val verdict = UssdSessionEngine.classify(
            "1. Buy\n2. Check", listOf("1", "2", "1"), 1
        )
        assertTrue(verdict is UssdSessionEngine.Verdict.Menu)
        assertEquals("2", (verdict as UssdSessionEngine.Verdict.Menu).choice)
    }

    @Test
    fun menuResponse_defaultsToOneWhenOfferDeclaresNoSteps() {
        val verdict = UssdSessionEngine.classify("1. Buy\n2. Check", emptyList(), 0)
        assertEquals("1", (verdict as UssdSessionEngine.Verdict.Menu).choice)
        assertEquals("1", UssdSessionEngine.nextChoice(emptyList(), 5))
    }

    @Test
    fun stepCap_isSix() {
        assertEquals(6, UssdSessionEngine.MAX_STEPS)
    }

    @Test
    fun appendStep_landsBeforeTheHash() {
        assertEquals("*544*1*ph*1#", UssdSessionEngine.appendStep("*544*1*ph#", "1"))
        assertEquals("*544*1*ph*2#", UssdSessionEngine.appendStep("*544*1*ph#", "2"))
        // Non-# terminated codes simply append with a separator.
        assertEquals("*544*1*ph*1", UssdSessionEngine.appendStep("*544*1*ph", "1"))
        assertEquals("1", UssdSessionEngine.appendStep("", "1"))
    }

    @Test
    fun parseSteps_handlesBlankAndSpacing() {
        assertTrue(UssdSessionEngine.parseSteps(null).isEmpty())
        assertTrue(UssdSessionEngine.parseSteps("").isEmpty())
        assertEquals(listOf("1", "2", "1"), UssdSessionEngine.parseSteps("1, 2 ,1"))
    }
}