package com.bingwascore.app.domain.mesh

/**
 * Stage 16 — Mesh v2 offline P2P core (pure, JVM-tested).
 *
 * Two roles talk over an offline transport with no internet:
 * - **Main**     — holds the till/paybill and receives the M-Pesa money. It owns
 *                  a routing table (amount → assigned Receiver) and, on a
 *                  matching payment, builds a request and sends it to the
 *                  Receiver.
 * - **Receiver** — auto-creates and processes the transaction the Main sent,
 *                  then syncs the status back.
 *
 * A chain is at most [MAX_CHAIN] devices deep. When a link is down, outbound
 * messages queue offline and flush on reconnect — nothing is dropped.
 *
 * Everything here is pure state + pure transitions; the transport is injected
 * (see [MeshTransport]) so the full lifecycle runs in a unit test over the
 * in-memory [LoopbackTransport].
 */
object MeshCore {

    /** A chain never runs deeper than four devices. */
    const val MAX_CHAIN = 4

    /** The two jobs a device can hold on the mesh. */
    enum class Role { MAIN, RECEIVER }

    /** Link state of one connected device. */
    enum class LinkState { CONNECTED, WEAK, DOWN }

    /** A device discovered/linked on the mesh. */
    data class Device(
        val id: String,
        val name: String,
        val role: Role,
        val link: LinkState = LinkState.CONNECTED
    )

    /** One routing rule: payments of [amount] route to the Receiver [deviceId]. */
    data class Route(val amount: Int, val deviceId: String)

    /**
     * The payment a Main hands to a Receiver. Carries everything the Receiver
     * needs to auto-create + process the transaction with no further input.
     */
    data class PaymentRequest(
        val customerName: String?,
        val mpesaMessage: String,
        val phone: String,
        val amount: Int
    )

    /** Status a Receiver reports back to the Main. */
    enum class TxStatus { QUEUED, PROCESSING, SUCCESSFUL, FAILED }

    /** A status sync pushed back up the chain. */
    data class StatusUpdate(val requestId: String, val status: TxStatus, val receipt: String? = null)

    /** Every wire message the mesh moves. */
    sealed interface Message {
        val to: String
        data class Pay(
            override val to: String,
            val from: String,
            val requestId: String,
            val request: PaymentRequest
        ) : Message
        data class Status(override val to: String, val update: StatusUpdate) : Message
        data class Ping(override val to: String, val from: String) : Message
    }

    // ── Routing table ───────────────────────────────────────────────────────

    /** Looks up the Receiver for [amount]; null when no rule matches. */
    fun routeFor(routes: List<Route>, amount: Int): String? =
        routes.firstOrNull { it.amount == amount }?.deviceId

    /**
     * Adds/updates a rule. One amount maps to exactly one Receiver — re-assigning
     * an amount replaces its previous device.
     */
    fun upsertRoute(routes: List<Route>, amount: Int, deviceId: String): List<Route> {
        val withoutAmount = routes.filterNot { it.amount == amount }
        return withoutAmount + Route(amount, deviceId)
    }

    fun removeRoute(routes: List<Route>, amount: Int): List<Route> =
        routes.filterNot { it.amount == amount }

    // ── Chain depth ─────────────────────────────────────────────────────────

    /** True when adding one more device keeps the chain within [MAX_CHAIN]. */
    fun canAddDevice(chainSize: Int): Boolean = chainSize < MAX_CHAIN

    // ── Offline queue ───────────────────────────────────────────────────────

    /**
     * Enqueues an outbound message while its link is down. Returns the grown
     * queue (the caller persists it).
     */
    fun enqueue(queue: List<Message>, message: Message): List<Message> = queue + message

    /**
     * Decides what to flush now: if the link to [to] is up, the queued messages
     * for it go out (oldest first) and leave the queue; if it is down they stay.
     * Returns the messages to send and the remaining queue.
     */
    fun flush(queue: List<Message>, to: String, linkUp: Boolean): Pair<List<Message>, List<Message>> {
        if (!linkUp) return emptyList<Message>() to queue
        val forDevice = queue.filter { it.to == to }
        val rest = queue.filterNot { it.to == to }
        return forDevice to rest
    }

    /** True when the queue holds anything for a device whose link is down. */
    fun hasBacklog(queue: List<Message>, downLinks: Set<String>): Boolean =
        queue.any { it.to in downLinks }
}
