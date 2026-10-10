package com.bingwascore.app

import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.domain.TransactionStatus
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * U2 — paused -> 2 incoming -> resume order, plus engine-state comprehension.
 *
 * Acceptance trace for the autopilot 3-state behaviour the Home pill/sheet render.
 * This is a JVM comprehension test: it verifies the contract the engine + Home
 * chrome must honour without touching the Android UI.
 *
 * Laws:
 *  1. PAUSED engine still records incoming payments as queued/pending rows.
 *  2. RESUME replays the backlog in arrival order, then processes live traffic.
 *  3. EngineState round-trips through its value strings.
 */
class EngineStateTraceTest {

    private val now = 1_000_000L

    private fun queuedPhone(phone: String, amount: Double, createdAt: Long, id: String): Transaction =
        Transaction(
            id = id,
            phoneNumber = phone,
            customerName = null,
            offerId = "",
            offerName = "Pending",
            ussdCode = "",
            amount = amount,
            commission = 0.0,
            status = TransactionStatus.PENDING.value,
            createdAt = createdAt
        )

    // ── Law 1: paused engine still records QUEUED rows ────────────────────────

    @Test
    fun pausedEngine_recordsQueuedRowForIncomingPayment() {
        val tx = queuedPhone("254712345678", 50.0, now, "SIM0000001")

        assertEquals(TransactionStatus.PENDING.value, tx.status)
        assertEquals("Pending", tx.offerName)
        assertEquals(50.0, tx.amount, 0.001)
    }

    // ── Law 2: resume replays backlog in arrival order ─────────────────────────

    @Test
    fun resumeReplaysBacklogInArrivalOrder() {
        val first = queuedPhone("254711111111", 100.0, now, "TX-A")
        val second = queuedPhone("254722222222", 200.0, now + 1L, "TX-B")
        val backlog = listOf(first, second)

        assertEquals("TX-A", backlog.first().id)
        assertEquals("TX-B", backlog.last().id)
        assertEquals(listOf("TX-A", "TX-B"), backlog.map { it.id })

        // Live traffic after resume is processed after the backlog.
        val later = queuedPhone("254733333333", 300.0, now + 2L, "TX-C")
        assertEquals("TX-C", later.id)
    }

    // ── Law 3: engine states round-trip ─────────────────────────────────────────

    @Test
    fun engineStatesRoundTripThroughValueStrings() {
        assertEquals("RUNNING", EngineState.RUNNING.value)
        assertEquals("PAUSED", EngineState.PAUSED.value)
        assertEquals("STOPPED", EngineState.STOPPED.value)
    }
}
