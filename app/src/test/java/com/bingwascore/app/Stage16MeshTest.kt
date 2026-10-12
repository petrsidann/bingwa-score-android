package com.bingwascore.app

import com.bingwascore.app.domain.mesh.BleGattTransport
import com.bingwascore.app.domain.mesh.LoopbackTransport
import com.bingwascore.app.domain.mesh.MeshCore
import com.bingwascore.app.domain.mesh.MeshNode
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 16 — Mesh v2 offline P2P.
 *
 * The full Main → Receiver → status round-trip runs over the in-memory
 * [LoopbackTransport] (no radios): a payment routes by amount, the Receiver
 * auto-creates + processes it and syncs SUCCESSFUL back to the Main. When the
 * link is down the frame queues (visible) and flushes on reconnect.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class Stage16MeshTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    private fun request(amount: Int = 19, phone: String = "0712345678") =
        MeshCore.PaymentRequest("Dennis Wachira", "You have received Ksh $amount", phone, amount)

    /** Boots a linked Main + Receiver pair over a loopback bus in [this] scope. */
    private fun TestScope.pair(): Triple<MeshNode, MeshNode, Job> {
        val mainBus = LoopbackTransport()
        val receiverBus = LoopbackTransport()
        mainBus.pair(receiverBus)
        val main = MeshNode("main", MeshCore.Role.MAIN, mainBus)
        val receiver = MeshNode("rx", MeshCore.Role.RECEIVER, receiverBus)
        main.linkDevice(MeshCore.Device("rx", "Shop Receiver", MeshCore.Role.RECEIVER))
        // One foreground job drives BOTH collectors so advanceUntilIdle() pumps
        // the whole round-trip deterministically.
        val job = launch {
            launch { main.collectInbound() }
            launch { receiver.collectInbound() }
        }
        return Triple(main, receiver, job)
    }

    // ── Routing table ───────────────────────────────────────────────────────

    @Test
    fun `routing maps an amount to its receiver and reassignment replaces it`() {
        var routes = MeshCore.upsertRoute(emptyList(), 19, "rx1")
        routes = MeshCore.upsertRoute(routes, 20, "rx2")
        assertEquals("rx1", MeshCore.routeFor(routes, 19))
        assertEquals("rx2", MeshCore.routeFor(routes, 20))
        assertNull(MeshCore.routeFor(routes, 55)) // no rule
        routes = MeshCore.upsertRoute(routes, 19, "rx3")
        assertEquals("rx3", MeshCore.routeFor(routes, 19))
        assertEquals(2, routes.size)
    }

    @Test
    fun `removing a route drops its rule`() {
        val routes = listOf(MeshCore.Route(19, "rx1"), MeshCore.Route(20, "rx2"))
        val after = MeshCore.removeRoute(routes, 19)
        assertNull(MeshCore.routeFor(after, 19))
        assertEquals("rx2", MeshCore.routeFor(after, 20))
    }

    @Test
    fun `a chain never runs deeper than four devices`() {
        assertTrue(MeshCore.canAddDevice(0))
        assertTrue(MeshCore.canAddDevice(3))
        assertFalse(MeshCore.canAddDevice(4))
        assertFalse(MeshCore.canAddDevice(5))
        assertEquals(4, MeshCore.MAX_CHAIN)
    }

    // ── Offline queue ───────────────────────────────────────────────────────

    @Test
    fun `a down link queues and flush sends oldest first`() {
        val m1 = MeshCore.Message.Ping("rx", "main")
        val m2 = MeshCore.Message.Ping("rx", "main")
        var queue = MeshCore.enqueue(emptyList(), m1)
        queue = MeshCore.enqueue(queue, m2)

        val (sendDown, remainDown) = MeshCore.flush(queue, "rx", linkUp = false)
        assertTrue("nothing flushes while down", sendDown.isEmpty())
        assertEquals(2, remainDown.size)

        val (sendUp, remainUp) = MeshCore.flush(queue, "rx", linkUp = true)
        assertEquals(listOf(m1, m2), sendUp)
        assertTrue(remainUp.isEmpty())
    }

    @Test
    fun `backlog is visible for a device whose link is down`() {
        val queue = listOf<MeshCore.Message>(MeshCore.Message.Ping("rx", "main"))
        assertTrue(MeshCore.hasBacklog(queue, setOf("rx")))
        assertFalse(MeshCore.hasBacklog(queue, setOf("other")))
    }

    // ── Full lifecycle: Main -> Receiver -> status (loopback) ───────────────

    @Test
    fun `a payment routes processes on the receiver and syncs status back`() = runTest {
        val (main, receiver, job) = pair()
        main.setRoute(19, "rx")

        main.onPayment(19, request(amount = 19))
        advanceUntilIdle()

        val statuses = receiver.statuses.value
        assertEquals(1, statuses.size)
        val status = statuses.values.first()
        assertEquals(MeshCore.TxStatus.SUCCESSFUL, status.status)
        assertTrue("a receipt is minted", status.receipt?.startsWith("R-") == true)

        advanceUntilIdle()
        val synced = main.statuses.value
        assertEquals(status.requestId, synced.keys.first())
        assertEquals(MeshCore.TxStatus.SUCCESSFUL, synced.values.first().status)
        job.cancel()
    }

    @Test
    fun `a payment with no matching route is not sent`() = runTest {
        val (main, receiver, job) = pair()
        main.onPayment(55, request(amount = 55))
        advanceUntilIdle()
        assertTrue("nothing processed", receiver.statuses.value.isEmpty())
        assertTrue("nothing queued", main.queue.value.isEmpty())
        job.cancel()
    }

    @Test
    fun `a down link queues the payment and flush delivers it on reconnect`() = runTest {
        val (main, receiver, job) = pair()
        main.setRoute(19, "rx")
        val bus = main.transport() as LoopbackTransport

        bus.disconnect()
        main.onPayment(19, request(amount = 19))
        advanceUntilIdle()

        assertTrue("the payment is queued while the link is down", main.queue.value.isNotEmpty())
        assertTrue("the receiver has not processed it", receiver.statuses.value.isEmpty())

        bus.reconnect()
        main.flushQueue()
        advanceUntilIdle()

        assertTrue("the queue drained", main.queue.value.isEmpty())
        assertEquals(1, receiver.statuses.value.size)
        assertEquals(MeshCore.TxStatus.SUCCESSFUL, receiver.statuses.value.values.first().status)
        job.cancel()
    }

    // ── Wiring (source guards) ──────────────────────────────────────────────

    @Test
    fun `the transport interface has all three implementations`() {
        val transport = source("app/src/main/java/com/bingwascore/app/domain/mesh/MeshTransport.kt")
        assertTrue("loopback exists", transport.contains("class LoopbackTransport"))
        assertTrue("ble exists", transport.contains("class BleGattTransport"))
        assertTrue("wifi direct exists", transport.contains("class WifiDirectTransport"))
        assertTrue("ble pairs by a 6-digit code", transport.contains("PAIRING_LENGTH = 6"))
    }

    @Test
    fun `the ble pairing code must be six digits`() {
        assertTrue(BleGattTransport("123456").isPairingCodeValid)
        assertFalse(BleGattTransport("12345").isPairingCodeValid)
        assertFalse(BleGattTransport("12345a").isPairingCodeValid)
    }
}

