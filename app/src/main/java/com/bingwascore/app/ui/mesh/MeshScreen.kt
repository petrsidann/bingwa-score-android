package com.bingwascore.app.ui.mesh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DeviceHub
import androidx.compose.material.icons.rounded.Language
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
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.White

/** Bingwa Mesh: links this device to a mesh server for multi-device sync. */
@Composable
fun MeshScreen(viewModel: MeshViewModel = hiltViewModel()) {
    val deviceId by viewModel.deviceId.collectAsStateWithLifecycle()
    val serverUrl by viewModel.serverUrl.collectAsStateWithLifecycle()
    val connected by viewModel.connected.collectAsStateWithLifecycle()
    val connecting by viewModel.connecting.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    var urlInput by remember(serverUrl) { mutableStateOf(serverUrl) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Bingwa Mesh", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                if (connected) "Connected to the mesh network"
                else "Link this device to the mesh network",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(EmeraldGreen.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.DeviceHub,
                        contentDescription = null,
                        tint = EmeraldGreen,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("DEVICE ID", color = White.copy(alpha = 0.45f), fontSize = 10.sp)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        deviceId.ifEmpty { "Generating..." },
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                StatusBadge(online = connected)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("SERVER URL", color = White.copy(alpha = 0.45f), fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            MeshUrlField(
                value = urlInput,
                onValueChange = {
                    urlInput = it
                    if (error != null) viewModel.clearError()
                }
            )
            if (error != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(error.orEmpty(), color = ErrorRed, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            GradientButton(
                text = when {
                    connecting -> "Connecting..."
                    connected -> "Disconnect"
                    else -> "Connect"
                },
                enabled = !connecting,
                onClick = {
                    if (connected) viewModel.disconnect() else viewModel.connect(urlInput)
                }
            )
        }
    }
}

@Composable
private fun StatusBadge(online: Boolean) {
    val color = if (online) EmeraldGreen else ErrorRed
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color.copy(alpha = 0.15f))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            if (online) "ONLINE" else "OFFLINE",
            color = color,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun MeshUrlField(value: String, onValueChange: (String) -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Language,
            contentDescription = null,
            tint = White.copy(alpha = 0.45f),
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.weight(1f)) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = White, fontSize = 13.sp),
                cursorBrush = SolidColor(EmeraldGreen),
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(
                    "https://mesh.bingwascore.com",
                    color = White.copy(alpha = 0.4f),
                    fontSize = 13.sp
                )
            }
        }
    }
}

