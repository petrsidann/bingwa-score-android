package com.bingwascore.app.ui.mesh

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.DeviceHub
import androidx.compose.material.icons.rounded.Payments
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.domain.mesh.MeshCore
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * Stage 16 — Mesh v2 offline P2P. Pick a role (Main holds the till / Receiver
 * serves it), see linked devices with signal dots, edit the routing table
 * (amount → Receiver) and fire a test-pulse that round-trips with no internet.
 */
@Composable
fun MeshScreen(viewModel: MeshViewModel = hiltViewModel()) {
    val role by viewModel.role.collectAsStateWithLifecycle()
    val devices by viewModel.devices.collectAsStateWithLifecycle()
    val routes by viewModel.routes.collectAsStateWithLifecycle()
    val queueSize by viewModel.queueSize.collectAsStateWithLifecycle()
    val pulseResult by viewModel.pulseResult.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.DeviceHub, contentDescription = null, tint = DesignTokens.LocalBingwaRoles.current.brand, modifier = Modifier.size(22.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Bingwa Mesh", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                if (queueSize > 0) {
                    Text(
                        "$queueSize queued",
                        color = DesignTokens.LocalBingwaRoles.current.error,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(DesignTokens.LocalBingwaRoles.current.error.copy(alpha = 0.14f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
            Text(
                "Offline P2P — payments route to a Receiver with no internet.",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { RolePicker(role = role, onPick = viewModel::setRole) }
            item { DevicesCard(devices = devices) }
            item { RoutingCard(devices = devices, routes = routes, onSet = viewModel::setRoute, onRemove = viewModel::removeRoute) }
            item { TestPulseCard(result = pulseResult, onPulse = viewModel::testPulse, onClear = viewModel::clearPulse) }
        }
    }
}

@Composable
private fun RolePicker(role: MeshCore.Role, onPick: (MeshCore.Role) -> Unit) {
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("THIS DEVICE", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            RoleChip(
                title = "Main",
                subtitle = "Holds till + receives M-Pesa",
                selected = role == MeshCore.Role.MAIN,
                modifier = Modifier.weight(1f),
                onClick = { onPick(MeshCore.Role.MAIN) }
            )
            Spacer(modifier = Modifier.width(10.dp))
            RoleChip(
                title = "Receiver",
                subtitle = "Serves routed payments",
                selected = role == MeshCore.Role.RECEIVER,
                modifier = Modifier.weight(1f),
                onClick = { onPick(MeshCore.Role.RECEIVER) }
            )
        }
    }
}

@Composable
private fun RoleChip(title: String, subtitle: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(if (selected) DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.16f) else DesignTokens.LocalBingwaRoles.current.card)
            .border(1.dp, if (selected) DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.6f) else DesignTokens.LocalBingwaRoles.current.border, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Text(title, color = if (selected) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Text(subtitle, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 11.sp)
    }
}


@Composable
private fun DevicesCard(devices: List<MeshCore.Device>) {
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("LINKED DEVICES", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))
        if (devices.isEmpty()) {
            Text("No devices linked yet.", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 13.sp)
        } else {
            devices.forEach { device ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(device.name, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        Text(
                            if (device.role == MeshCore.Role.MAIN) "Main" else "Receiver",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                            fontSize = 11.sp
                        )
                    }
                    SignalDots(link = device.link)
                }
            }
        }
    }
}

/** Three signal dots: green full, amber partial, red down. */
@Composable
private fun SignalDots(link: MeshCore.LinkState) {
    val (lit, color) = when (link) {
        MeshCore.LinkState.CONNECTED -> 3 to DesignTokens.LocalBingwaRoles.current.success
        MeshCore.LinkState.WEAK -> 2 to DesignTokens.LocalBingwaRoles.current.textSecondary
        MeshCore.LinkState.DOWN -> 0 to DesignTokens.LocalBingwaRoles.current.error
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        (1..3).forEach { i ->
            Box(
                modifier = Modifier
                    .padding(start = 3.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(if (i <= lit) color else DesignTokens.LocalBingwaRoles.current.border)
            )
        }
    }
}


@Composable
private fun RoutingCard(
    devices: List<MeshCore.Device>,
    routes: List<MeshCore.Route>,
    onSet: (Int, String) -> Unit,
    onRemove: (Int) -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var target by remember { mutableStateOf(devices.firstOrNull()?.id ?: "") }

    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("ROUTING TABLE", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Payments of an amount route to its Receiver.", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(12.dp))

        if (routes.isEmpty()) {
            Text("No routes yet — add one below.", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 12.sp)
        } else {
            routes.forEach { route ->
                val deviceName = devices.firstOrNull { it.id == route.deviceId }?.name ?: route.deviceId
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Ksh ${route.amount}", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                    Text("→ $deviceName", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 12.sp, modifier = Modifier.weight(1f))
                    Text("Remove", color = DesignTokens.LocalBingwaRoles.current.error, fontSize = 12.sp, modifier = Modifier.clickable { onRemove(route.amount) })
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DesignTokens.LocalBingwaRoles.current.card)
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                BasicTextField(
                    value = amount,
                    onValueChange = { amount = it.filter { ch -> ch.isDigit() } },
                    singleLine = true,
                    textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp),
                    cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
                    modifier = Modifier.fillMaxWidth()
                )
                if (amount.isEmpty()) Text("Amount", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            LazyRow(modifier = Modifier.weight(1f)) {
                items(devices, key = { it.id }) { device ->
                    val sel = target == device.id
                    Text(
                        device.name,
                        color = if (sel) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (sel) DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.16f) else DesignTokens.LocalBingwaRoles.current.card)
                            .clickable { target = device.id }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        PrimaryButton(
            text = "Add route",
            enabled = amount.isNotBlank() && target.isNotBlank(),
            onClick = {
                onSet(amount.toIntOrNull() ?: 0, target)
                amount = ""
            }
        )
    }
}


@Composable
private fun TestPulseCard(result: String?, onPulse: (Int) -> Unit, onClear: () -> Unit) {
    var amount by remember { mutableStateOf("19") }
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Rounded.Payments, contentDescription = null, tint = DesignTokens.LocalBingwaRoles.current.brand, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Test pulse", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text("Fire a synthetic payment and watch it route + sync back.", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DesignTokens.LocalBingwaRoles.current.card)
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                BasicTextField(
                    value = amount,
                    onValueChange = { amount = it.filter { ch -> ch.isDigit() } },
                    singleLine = true,
                    textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp),
                    cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
                    modifier = Modifier.fillMaxWidth()
                )
                if (amount.isEmpty()) Text("Amount", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(DesignTokens.LocalBingwaRoles.current.brand)
                    .clickable { onPulse(amount.toIntOrNull() ?: 0) }
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Icon(Icons.Rounded.Bolt, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Pulse", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        val r = result
        if (r != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(r, color = if (r.startsWith("Pulse OK")) DesignTokens.LocalBingwaRoles.current.success else DesignTokens.LocalBingwaRoles.current.error, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

