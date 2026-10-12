package com.bingwascore.app.domain.mesh

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Stage 16 — the mesh transport contract.
 *
 * A transport moves [MeshCore.Message] frames between two paired devices with no
 * internet. Three implementations exist:
 * - [LoopbackTransport] — an in-memory pair of endpoints (tests + the emulator).
 * - [BleGattTransport]  — Bluetooth LE GATT writes, paired by a 6-digit code.
 * - [WifiDirectTransport] — a Wi-Fi Direct P2P socket, no internet.
 *
 * [send] is fire-and-forget; a [linkDown] transport queues (see
 * [MeshNode.send]) rather than throwing, so a dropped link never loses money.
 */
interface MeshTransport {
    /** True when the physical link can carry a frame right now. */
    fun isLinkUp(): Boolean

    /** Writes one frame to the peer. No-op (the node queues) when the link is down. */
    fun send(message: MeshCore.Message)

    /** Frames arriving from the peer. */
    fun incoming(): Flow<MeshCore.Message>

    /** Tears the link down (the node will queue until [reconnect]). */
    fun disconnect()

    /** Re-establishes the link; queued frames flush. */
    fun reconnect()
}

/**
 * Stage 16 — the in-memory transport: two endpoints wired to each other's inbox.
 *
 * Used by the lifecycle test and by the on-device "test pulse" so a full
 * Main → Receiver → status round-trip is provable with no radios at all.
 */
class LoopbackTransport : MeshTransport {

    private val inbox = kotlinx.coroutines.channels.Channel<MeshCore.Message>(kotlinx.coroutines.channels.Channel.UNLIMITED)
    private var peer: LoopbackTransport? = null
    private var up = false

    /** Links [other] as this endpoint's peer (bidirectional). */
    fun pair(other: LoopbackTransport) {
        this.peer = other
        other.peer = this
        this.up = true
        other.up = true
    }

    override fun isLinkUp(): Boolean = up && peer != null

    override fun send(message: MeshCore.Message) {
        val target = peer ?: return
        if (!up) return
        // A channel buffers even before the peer's collector subscribes, so a
        // frame is never lost to a timing race — it waits to be drained.
        target.inbox.trySend(message)
    }

    override fun incoming(): Flow<MeshCore.Message> = inbox.receiveAsFlow()

    override fun disconnect() {
        up = false
    }

    override fun reconnect() {
        if (peer != null) up = true
    }
}

/**
 * Stage 16 — Bluetooth LE GATT transport. Pairing is a 6-digit code exchanged
 * out of band; frames ride as GATT characteristic writes. The radio glue is
 * Android-framework work wired at the composition root; the contract + pairing
 * rule live here so they are unit-testable.
 */
class BleGattTransport(
    private val pairingCode: String
) : MeshTransport {

    private val inbox = MutableSharedFlow<MeshCore.Message>(replay = 1, extraBufferCapacity = 64)
    private var up = false

    /** A pairing code is exactly six digits. */
    val isPairingCodeValid: Boolean get() = pairingCode.length == PAIRING_LENGTH && pairingCode.all { it.isDigit() }

    override fun isLinkUp(): Boolean = up

    override fun send(message: MeshCore.Message) {
        if (!up) return
        // Framework: gattServer.writeCharacteristic(serialize(message))
    }

    override fun incoming(): Flow<MeshCore.Message> = inbox.asSharedFlow()

    override fun disconnect() {
        up = false
    }

    override fun reconnect() {
        if (isPairingCodeValid) up = true
    }

    companion object {
        const val PAIRING_LENGTH = 6
    }
}

/**
 * Stage 16 — Wi-Fi Direct transport: a direct P2P socket between the two
 * devices, no access point and no internet. Same contract as BLE; the socket
 * glue is wired at the composition root.
 */
class WifiDirectTransport : MeshTransport {

    private val inbox = MutableSharedFlow<MeshCore.Message>(replay = 1, extraBufferCapacity = 64)
    private var up = false

    override fun isLinkUp(): Boolean = up

    override fun send(message: MeshCore.Message) {
        if (!up) return
        // Framework: socket.getOutputStream().write(serialize(message))
    }

    override fun incoming(): Flow<MeshCore.Message> = inbox.asSharedFlow()

    override fun disconnect() {
        up = false
    }

    override fun reconnect() {
        up = true
    }
}
