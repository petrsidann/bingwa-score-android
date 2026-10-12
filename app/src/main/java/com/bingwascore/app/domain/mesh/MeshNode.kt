package com.bingwascore.app.domain.mesh

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * Stage 16 — one device on the mesh, driven by a [MeshTransport].
 *
 * A **Main** receives an M-Pesa payment, looks the amount up in its routing
 * table, builds a [MeshCore.PaymentRequest] and sends it to the assigned
 * Receiver. A **Receiver** auto-creates + processes the transaction the moment
 * the request lands, then syncs the status back to the Main. When a link is
 * down the message queues offline and flushes on reconnect — the money path
 * never drops a frame.
 *
 * The node keeps the outbound queue and link state as observable [StateFlow]s so
 * the UI can show a queue badge when the link is down.
 */
class MeshNode(
    val id: String,
    val role: MeshCore.Role,
    private val transport: MeshTransport,
    /** Processor that turns a request into a transaction + outcome (injected). */
    private val processor: PaymentProcessor = PaymentProcessor.Noop
) {
    /** What a Receiver does with an incoming payment: create + process it. */
    fun interface PaymentProcessor {
        /** Returns the resulting status (and a receipt when it completed). */
        fun process(requestId: String, request: MeshCore.PaymentRequest): MeshCore.StatusUpdate

        companion object {
            /** Test/default processor: instantly succeeds with a synthetic receipt. */
            val Noop = PaymentProcessor { requestId, _ ->
                MeshCore.StatusUpdate(requestId, MeshCore.TxStatus.SUCCESSFUL, "R-${requestId.takeLast(6)}")
            }
        }
    }

    private val _routes = MutableStateFlow<List<MeshCore.Route>>(emptyList())
    val routes: StateFlow<List<MeshCore.Route>> = _routes.asStateFlow()

    private val _devices = MutableStateFlow<List<MeshCore.Device>>(emptyList())
    val devices: StateFlow<List<MeshCore.Device>> = _devices.asStateFlow()

    private val _queue = MutableStateFlow<List<MeshCore.Message>>(emptyList())
    /** Outbound frames held while a link is down (visible in the UI). */
    val queue: StateFlow<List<MeshCore.Message>> = _queue.asStateFlow()

    private val _statuses = MutableStateFlow<Map<String, MeshCore.StatusUpdate>>(emptyMap())
    /** requestId → latest status (Main watches this to sync its ledger). */
    val statuses: StateFlow<Map<String, MeshCore.StatusUpdate>> = _statuses.asStateFlow()

    /** Starts listening for inbound frames. Returns the collector [Job] so the
     * caller (a test) can cancel it before the scope is torn down. */
    fun start(scope: CoroutineScope): kotlinx.coroutines.Job =
        transport.incoming()
            .onEach { message -> onReceive(message) }
            .launchIn(scope)

    /** The transport this node rides (exposed so a test can drop/raise the link). */
    fun transport(): MeshTransport = transport

    /** Suspends, processing inbound frames until cancelled (test helper). */
    suspend fun collectInbound() {
        transport.incoming().collect { message -> onReceive(message) }
    }

    /** Adds a linked device (respecting the four-deep chain limit). */
    fun linkDevice(device: MeshCore.Device): Boolean {
        if (!MeshCore.canAddDevice(_devices.value.size)) return false
        _devices.value = _devices.value.filterNot { it.id == device.id } + device
        return true
    }

    fun setRoute(amount: Int, deviceId: String) {
        _routes.value = MeshCore.upsertRoute(_routes.value, amount, deviceId)
    }

    /**
     * MAIN — a payment landed. Routes by amount and sends the request to the
     * assigned Receiver (or queues it if that link is down).
     */
    fun onPayment(amount: Int, request: MeshCore.PaymentRequest) {
        val target = MeshCore.routeFor(_routes.value, amount) ?: return
        val requestId = UUID.randomUUID().toString()
        send(MeshCore.Message.Pay(target, id, requestId, request))
    }

    /** Sends [message], queueing it when the target link is down. */
    fun send(message: MeshCore.Message) {
        val device = _devices.value.firstOrNull { it.id == message.to }
        val deviceDown = device != null && device.link == MeshCore.LinkState.DOWN
        val transportDown = !transport.isLinkUp()
        if (!deviceDown && !transportDown) {
            transport.send(message)
        } else {
            _queue.value = MeshCore.enqueue(_queue.value, message)
        }
    }

    /** Flushes the offline queue for every device whose link is back up. */
    fun flushQueue() {
        var remaining = _queue.value
        val toSend = mutableListOf<MeshCore.Message>()
        _devices.value.forEach { device ->
            if (device.link == MeshCore.LinkState.DOWN) return@forEach
            val (send, rest) = MeshCore.flush(remaining, device.id, linkUp = true)
            toSend += send
            remaining = rest
        }
        _queue.value = remaining
        toSend.forEach { transport.send(it) }
    }

    private fun onReceive(message: MeshCore.Message) {
        when (message) {
            is MeshCore.Message.Pay -> {
                // RECEIVER — auto-create + process, then sync the status back
                // to whoever sent it (message.from).
                val update = processor.process(message.requestId, message.request)
                recordStatus(update)
                send(MeshCore.Message.Status(message.from, update))
            }
            is MeshCore.Message.Status -> recordStatus(message.update)
            is MeshCore.Message.Ping -> Unit
        }
    }

    private fun recordStatus(update: MeshCore.StatusUpdate) {
        _statuses.value = _statuses.value + (update.requestId to update)
    }
}
