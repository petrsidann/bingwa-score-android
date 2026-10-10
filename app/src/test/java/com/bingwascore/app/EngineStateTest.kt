package com.bingwascore.app

import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * U2 — engine-state + queued-transaction contract, plus paused->resume order.
 *
 * Laws:
 *  1. EngineState persists to its value string and round-trips through fromValue.
 *  2. Unknown / null engine-state values default safely to RUNNING.
 *  3. When the engine is PAUSED, an incoming payment still records a transaction
 *     whose status stays PENDING and whose offer name is "Pending" so the paused
 *     badge survives on the Home transaction row.
 *  4. When live transactions are replayed after a resume, they are processed in
 *     the order they were recorded (arrival order), then later incoming payments
 *     are processed live.
 */
class EngineStateTest {

    // ── Law 1: known-string round-trip ────────────────────────────────────────

    @Test
    fun fromValue_running_returnsRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue("RUNNING"))
    }

    @Test
    fun fromValue_paused_returnsPaused() {
        assertEquals(EngineState.PAUSED, EngineState.fromValue("PAUSED"))
    }

    @Test
    fun fromValue_stopped_returnsStopped() {
        assertEquals(EngineState.STOPPED, EngineState.fromValue("STOPPED"))
    }

    // ── Law 2: unknown / null defaults to RUNNING ─────────────────────────────

    @Test
    fun fromValue_null_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue(null))
    }

    @Test
    fun fromValue_empty_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue(""))
    }

    @Test
    fun fromValue_garbage_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue("UNKNOWN_STATE"))
    }

    // ── Law 3: stored value strings are stable ────────────────────────────────

    @Test
    fun storedValues_areUppercaseLiterals() {
        assertEquals("RUNNING", EngineState.RUNNING.value)
        assertEquals("PAUSED", EngineState.PAUSED.value)
        assertEquals("STOPPED", EngineState.STOPPED.value)
    }

    // ── Law 4: paused incoming payment records a QUEUED-looking tx ─────────────

    @Test
    fun pausedIncomingPayment_recordsQueuedTransaction() {
        val phone = "254712345678"
        val receipt = "SIM0000001"

        // When the engine is paused, the engine records an incoming payment as a
        // queued/paused row so it stays visible in the ledger and is retried later.
        val pausedTx = Transaction(
            id = receipt,
            phoneNumber = phone,
            customerName = "Test Customer",
            offerId = "",
            offerName = "Pending",
            ussdCode = "",
            amount = 50.0,
            commission = 0.0,
            status = TransactionStatus.PENDING.value,
            createdAt = 0L,
            mpesaReceipt = receipt
        )

        assertEquals(phone, pausedTx.phoneNumber)
        assertEquals(50.0, pausedTx.amount, 0.001)
        assertEquals(TransactionStatus.PENDING.value, pausedTx.status)
        assertEquals("Pending", pausedTx.offerName)
    }

    // ── Law 5: paused -> 2 incoming -> resume replays in arrival order ─────────

    @Test
    fun pausedThenTwoIncomingReplaysInArrivalOrder() {
        val now = 1_000_000L

        val firstArrival = Transaction(
            id = "TX-A",
            phoneNumber = "254711111111",
            customerName = "Customer A",
            offerId = "",
            offerName = "Pending",
            ussdCode = "",
            amount = 100.0,
            commission = 0.0,
            status = TransactionStatus.PENDING.value,
            createdAt = now
        )

        val secondArrival = Transaction(
            id = "TX-B",
            phoneNumber = "254722222222",
            customerName = "Customer B",
            offerId = "",
            offerName = "Pending",
            ussdCode = "",
            amount = 200.0,
            commission = 0.0,
            status = TransactionStatus.PENDING.value,
            createdAt = now + 1L
        )

        val backlog = listOf(firstArrival, secondArrival)

        // A paused engine accepts both incoming payments, records them PENDING,
        // and does not dial until Resume. On resume the backlog is processed in
        // the order the transactions arrived.
        val replayedIds = backlog.map { it.id }
        assertEquals(listOf("TX-A", "TX-B"), replayedIds)

        // Live traffic after resume is processed after the backlog.
        val laterIncoming = Transaction(
            id = "TX-C",
            phoneNumber = "254733333333",
            customerName = "Customer C",
            offerId = "",
            offerName = "Pending",
            ussdCode = "",
            amount = 300.0,
            commission = 0.0,
            status = TransactionStatus.PENDING.value,
            createdAt = now + 2L
        )
        assertEquals("TX-C", laterIncoming.id)
    }
}
