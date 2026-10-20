package com.bingwascore.app.ui.mesh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.domain.mesh.LoopbackTransport
import com.bingwascore.app.domain.mesh.MeshCore
import com.bingwascore.app.domain.mesh.MeshNode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Stage 16 — Mesh v2 UI state: role picker, linked devices (signal dots),
 * routing editor (amount → Receiver) and a test-pulse button.
 *
 * Runs on the in-memory [LoopbackTransport] so a full Main → Receiver →
 * status round-trip is provable on-device with no radios; the BLE / Wi-Fi
 * transports drop in behind the same [MeshNode] contract.
 */
@HiltViewModel
class MeshViewModel @Inject constructor() : ViewModel() {

    private val _role = MutableStateFlow(MeshCore.Role.MAIN)
    val role: StateFlow<MeshCore.Role> = _role.asStateFlow()

    private val _devices = MutableStateFlow<List<MeshCore.Device>>(emptyList())
    val devices: StateFlow<List<MeshCore.Device>> = _devices.asStateFlow()

    private val _routes = MutableStateFlow<List<MeshCore.Route>>(emptyList())
    val routes: StateFlow<List<MeshCore.Route>> = _routes.asStateFlow()

    private val _queueSize = MutableStateFlow(0)
    val queueSize: StateFlow<Int> = _queueSize.asStateFlow()

    private val _pulseResult = MutableStateFlow<String?>(null)
    val pulseResult: StateFlow<String?> = _pulseResult.asStateFlow()

    private var node: MeshNode? = null
    private var receiverNode: MeshNode? = null
    private var collector: Job? = null

    /** Picks this device's role and stands up a mesh node on the loopback bus. */
    fun setRole(role: MeshCore.Role) {
        _role.value = role
        if (node == null) startNode()
    }

    private fun startNode() {
        // Two nodes on one loopback bus: "me" (this device) + a paired Receiver
        // on the far end, so the test-pulse genuinely round-trips with no radios.
        val myBus = LoopbackTransport()
        val peerBus = LoopbackTransport()
        myBus.pair(peerBus)
        val meshNode = MeshNode("me", _role.value, myBus)
        val peer = MeshNode("rx1", MeshCore.Role.RECEIVER, peerBus)
        node = meshNode
        receiverNode = peer
        collector = viewModelScope.launch {
            launch { meshNode.collectInbound() }
            launch { peer.collectInbound() }
        }
        meshNode.linkDevice(MeshCore.Device("rx1", "Shop Receiver", MeshCore.Role.RECEIVER))
        _devices.value = meshNode.devices.value
    }

    /** Links a new device, respecting the four-deep chain limit. */
    fun linkDevice(name: String, role: MeshCore.Role) {
        val meshNode = node ?: return
        val id = "d${_devices.value.size + 1}"
        val added = meshNode.linkDevice(MeshCore.Device(id, name.ifBlank { "Device $id" }, role))
        if (added) _devices.value = meshNode.devices.value
    }

    /** Adds/updates a routing rule (amount → Receiver device). */
    fun setRoute(amount: Int, deviceId: String) {
        val meshNode = node ?: return
        meshNode.setRoute(amount, deviceId)
        _routes.value = meshNode.routes.value
    }

    fun removeRoute(amount: Int) {
        val meshNode = node ?: return
        _routes.value = MeshCore.removeRoute(meshNode.routes.value, amount)
    }

    /**
     * Test-pulse: fires a synthetic payment for [amount] through the node and
     * reports whether it routed + the Receiver synced SUCCESSFUL back.
     */
    fun testPulse(amount: Int) {
        val meshNode = node ?: return
        viewModelScope.launch {
            _pulseResult.value = null
            meshNode.onPayment(
                amount,
                MeshCore.PaymentRequest("Test Customer", "Test pulse Ksh $amount", "0712345678", amount)
            )
            // Let the Receiver process + sync the status back over the bus.
            kotlinx.coroutines.delay(150)
            val routed = meshNode.statuses.value.values.firstOrNull()
            _pulseResult.value = when {
                routed == null -> "No route for Ksh $amount — add one first"
                routed.status == MeshCore.TxStatus.SUCCESSFUL -> "Pulse OK — Receiver synced SUCCESSFUL"
                else -> "Pulse ${routed.status}"
            }
            _queueSize.value = meshNode.queue.value.size
        }
    }

    fun clearPulse() {
        _pulseResult.value = null
    }

    override fun onCleared() {
        collector?.cancel()
        super.onCleared()
    }
}
