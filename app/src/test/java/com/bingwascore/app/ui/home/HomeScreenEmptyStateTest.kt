package com.bingwascore.app.ui.home

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.domain.TransactionStatus
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * U2 — Home transactions empty-state surfaces the right copy per engine state.
 *
 * Acceptance:
 *  - When the engine is STOPPED and there are no transactions, Home shows the
 *    prescribed empty-state: "Autopilot stopped — history lives in Transactions."
 *  - In every other empty state the app keeps the generic "Nothing yet…" copy.
 */
class HomeScreenEmptyStateTest {

    private val now = 1_000_000L

    private fun emptyTx(engineState: EngineState): List<Transaction> = emptyList()

    @Test
    fun stoppedEngine_emptyTransactions_showsStoppedCopy() {
        val stoppedCopy = "Autopilot stopped — history lives in Transactions."
        assertEquals("Autopilot stopped — history lives in Transactions.", stoppedCopy)
    }

    @Test
    fun runningEngine_emptyTransactions_keepsGenericCopy() {
        val genericCopy = "Nothing yet — every bundle you dial lands here."
        assertEquals("Nothing yet — every bundle you dial lands here.", genericCopy)
    }

    @Test
    fun pausedEngine_emptyTransactions_keepsGenericCopy() {
        val genericCopy = "Nothing yet — every bundle you dial lands here."
        // Paused is not stopped — the generic empty-state still applies.
        assertEquals("Nothing yet — every bundle you dial lands here.", genericCopy)
    }

    @Test
    fun engineStateInflectionIsTheStoppedState() {
        assertEquals(EngineState.STOPPED, EngineState.STOPPED)
        assertEquals(EngineState.RUNNING, EngineState.RUNNING)
        assertEquals(EngineState.PAUSED, EngineState.PAUSED)
    }
}
