package com.bingwascore.app.ui.settings.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.data.updates.AppUpdateRepository
import com.bingwascore.app.data.updates.UpdateState
import com.bingwascore.app.domain.enums.ProcessingMode
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.ThemeViewModel
import com.bingwascore.app.ui.theme.White
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatesViewModel @Inject constructor(
    val updateRepository: AppUpdateRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    val updateKey: String get() = settingsRepository.getString(AppSetting.UPDATE_KEY) ?: ""

    fun generateKey() {
        val chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
        val key = "BINGWA-" + (1..8).map { chars.random() }.joinToString("")
        settingsRepository.saveString(AppSetting.UPDATE_KEY, key)
    }

    fun check() {
        viewModelScope.launch { updateRepository.checkForUpdates() }
    }

    fun install(url: String) {
        viewModelScope.launch { updateRepository.downloadAndInstall(url) }
    }
}

@HiltViewModel
class ProcessingModeViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    val mode: ProcessingMode get() = settingsRepository.getProcessingMode()
    fun setMode(mode: ProcessingMode) = settingsRepository.setProcessingMode(mode)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PageScaffold(title: String, onBack: () -> Unit, content: @Composable () -> Unit) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text(title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface)
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
                .padding(20.dp)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppearanceScreen(onBack: () -> Unit) {
    val themeViewModel: ThemeViewModel = hiltViewModel()
    val isDark by themeViewModel.isDark.collectAsState()

    PageScaffold("Appearance", onBack) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ThemeCard("Light", Icons.Default.WbSunny, Orange500, White, !isDark, Orange500, { themeViewModel.setTheme(0) }, Modifier.weight(1f))
            ThemeCard("Dark", Icons.Default.DarkMode, Purple500, Color(0xFF0B0B0F), isDark, Purple500, { themeViewModel.setTheme(1) }, Modifier.weight(1f))
        }
        
        Spacer(Modifier.height(24.dp))
        Text("Processing Mode", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(12.dp))
        
        val modeVm: ProcessingModeViewModel = hiltViewModel()
        val currentMode = modeVm.mode
        
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().clickable { modeVm.setMode(ProcessingMode.EXPRESS) }) {
            RadioButton(selected = currentMode == ProcessingMode.EXPRESS, onClick = { modeVm.setMode(ProcessingMode.EXPRESS) })
            Spacer(Modifier.width(8.dp))
            Column {
                Text("Direct Mode (Express)", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold)
                Text("Fast single-step USSD dialing", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
            }
        }
        
        Spacer(Modifier.height(8.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().clickable { modeVm.setMode(ProcessingMode.ADVANCED) }) {
            RadioButton(selected = currentMode == ProcessingMode.ADVANCED, onClick = { modeVm.setMode(ProcessingMode.ADVANCED) })
            Spacer(Modifier.width(8.dp))
            Column {
                Text("Advanced Mode", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold)
                Text("Multi-step USSD with Accessibility Service", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatesScreen(onBack: () -> Unit) {
    val vm: UpdatesViewModel = hiltViewModel()
    val state by vm.updateRepository.updateState.collectAsState()
    var key by remember { mutableStateOf(vm.updateKey) }

    PageScaffold("Software Update", onBack) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("Current version", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 13.sp)
            Text("1.1.0", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 20.sp)

            OutlinedTextField(
                value = key,
                onValueChange = { },
                readOnly = true,
                label = { Text("Update Key") },
                leadingIcon = { Icon(Icons.Default.Key, null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            Button(
                onClick = { vm.check() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                if (state is UpdateState.Loading) {
                    CircularProgressIndicator(Modifier.size(18.dp), color = White, strokeWidth = 2.dp)
                } else {
                    Text("Check for updates")
                }
            }

            when (val s = state) {
                is UpdateState.UpToDate -> Text("You're up to date", color = EmeraldGreen)
                is UpdateState.Error -> Text(s.message, color = MaterialTheme.colorScheme.error)
                is UpdateState.Downloading -> Text("Downloading ${s.progress}%", color = MaterialTheme.colorScheme.primary)
                is UpdateState.UpdateRequired -> {
                    Text("Update available: v${s.latestVersion}", color = Orange500, fontWeight = FontWeight.SemiBold)
                    Text(s.message, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 13.sp)
                    if (s.apkUrl != null) {
                        Button(
                            onClick = { vm.install(s.apkUrl!!) },
                            colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen)
                        ) {
                            Text("Install Update")
                        }
                    }
                }
                else -> {}
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(onBack: () -> Unit) {
    PageScaffold("About", onBack) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AboutRow("Version", "1.1.0")
            AboutRow("Platform", "Android")
            AboutRow("Release Channel", "Genesis")
            AboutRow("Engine", "Triple-listen autonomous")
            Spacer(Modifier.height(12.dp))
            Text("© 2026 Bingwa Score. All rights reserved.", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsScreen(onBack: () -> Unit) {
    PageScaffold("Terms of Service", onBack) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("1. Bingwa Score automates bundle recommendations on your behalf. You are responsible for the SIM cards and accounts used.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("2. Commissions shown are estimates from operator messages and may differ from operator records.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("3. Do not use the app for activity that violates operator terms or applicable law.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("4. The software is provided as-is without warranty of any kind.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyScreen(onBack: () -> Unit) {
    PageScaffold("Privacy Policy", onBack) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("1. All transaction and customer data is stored locally on your device.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("2. SMS messages are processed on-device and never uploaded.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("3. Notification access is used only to detect payment messages when SMS delivery is blocked.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Text("4. You may delete all data by uninstalling the app.", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Composable
private fun AboutRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
        Text(value, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, fontFamily = FontFamily.Monospace)
    }
}

@Composable
private fun ThemeCard(
    label: String,
    icon: ImageVector,
    iconTint: Color,
    preview: Color,
    selected: Boolean,
    accent: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (selected) accent.copy(alpha = 0.1f) else MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick() }
            .padding(14.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(preview),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, null, tint = iconTint, modifier = Modifier.size(26.dp))
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(label, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                if (selected) {
                    Box(
                        modifier = Modifier.size(18.dp).clip(CircleShape).background(accent),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Check, null, tint = White, modifier = Modifier.size(11.dp))
                    }
                }
            }
        }
    }
}
