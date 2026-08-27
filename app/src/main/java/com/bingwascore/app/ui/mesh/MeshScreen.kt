package com.bingwascore.app.ui.mesh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.infrastructure.mesh.BingwaMeshClient
import com.bingwascore.app.ui.theme.Purple500
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeshViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val meshClient: BingwaMeshClient
) : ViewModel() {
    private val _connectId = MutableStateFlow("")
    val connectId: StateFlow<String> = _connectId.asStateFlow()

    private val _serverUrl = MutableStateFlow("")
    val serverUrl: StateFlow<String> = _serverUrl.asStateFlow()

    init {
        viewModelScope.launch {
            _connectId.value = settingsRepository.getString(AppSetting.APP_CONNECT_ID) ?: generateId()
            _serverUrl.value = settingsRepository.getString(AppSetting.MESH_SERVER_URL) ?: "wss://mesh.bingwascore.com/ws"
        }
    }

    private fun generateId(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return "BSC-" + (1..5).map { chars.random() }.joinToString("")
    }

    fun saveAndConnect(url: String) {
        viewModelScope.launch {
            settingsRepository.saveString(AppSetting.MESH_SERVER_URL, url)
            settingsRepository.saveString(AppSetting.APP_CONNECT_ID, _connectId.value)
            meshClient.connect(_connectId.value, url)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeshScreen(onNavigateBack: () -> Unit) {
    val vm: MeshViewModel = hiltViewModel()
    val connectId by vm.connectId.collectAsState()
    val serverUrl by vm.serverUrl.collectAsState()
    var urlInput by remember { mutableStateOf(serverUrl) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Bingwa Mesh", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Link multiple devices to process offers simultaneously. One device can handle Data, another Minutes.", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
            
            Box(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(16.dp)
            ) {
                Column {
                    Text("Your Device ID:", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(connectId, color = Purple500, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }

            OutlinedTextField(
                value = urlInput,
                onValueChange = { urlInput = it },
                label = { Text("Mesh Server URL") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(16.dp)).background(Purple500).clickable { vm.saveAndConnect(urlInput) },
                contentAlignment = Alignment.Center
            ) {
                Text("Connect to Mesh", color = androidx.compose.ui.graphics.Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
