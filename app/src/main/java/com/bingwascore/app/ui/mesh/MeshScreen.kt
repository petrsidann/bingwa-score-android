package com.bingwascore.app.ui.mesh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.infrastructure.mesh.BingwaMeshClient
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Purple500
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MeshViewModel @Inject constructor(
    private val settings: SettingsRepository,
    private val meshClient: BingwaMeshClient
) : ViewModel() {

    private val _connectId = androidx.compose.runtime.MutableStateFlow(
        settings.getConnectId() ?: ""
    )
    val connectId = _connectId

    private val _connected = androidx.compose.runtime.MutableStateFlow(false)
    val connected = _connected

    fun generateId() {
        val chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
        val id = "BSC-" + (1..5).map { chars.random() }.joinToString("")
        settings.saveConnectId(id)
        _connectId.value = id
    }

    fun connect(url: String) {
        if (_connectId.value.isEmpty()) generateId()
        settings.saveString(AppSetting.MESH_SERVER_URL, url)
        meshClient.connect(_connectId.value, url)
        meshClient.sendConnectMessage(_connectId.value, _connectId.value)
        _connected.value = true
    }

    fun disconnect() {
        meshClient.disconnect(_connectId.value)
        _connected.value = false
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeshScreen(onNavigateBack: () -> Unit) {
    val vm: MeshViewModel = hiltViewModel()
    val connectId by vm.connectId.collectAsState()
    val connected by vm.connected.collectAsState()
    var url by remember { mutableStateOf("wss://mesh.bingwascore.com/ws") }
    val onSurface = MaterialTheme.colorScheme.onSurface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Bingwa Mesh", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Link multiple devices. Assign different offers to each device and process them as one team.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 13.sp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Wifi, null, tint = if (connected) EmeraldGreen else Purple500)
                    Spacer(Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Device ID", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                        Text(
                            connectId.ifEmpty { "Not generated" },
                            color = if (connected) EmeraldGreen else onSurface,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    Text(
                        if (connected) "ONLINE" else "OFFLINE",
                        color = if (connected) EmeraldGreen else ErrorRed,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }

            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("Mesh server URL") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (connected) ErrorRed else Purple500)
                    .clickable {
                        if (connected) vm.disconnect() else vm.connect(url)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    if (connected) "Disconnect" else "Connect to Mesh",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
