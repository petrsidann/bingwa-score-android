package com.bingwascore.app.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.SystemUpdate
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bingwascore.app.data.updates.UpdateState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateToAppearance: () -> Unit,
    onNavigateToAbout: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val updateState by viewModel.updateState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Settings") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            
            // Appearance
            ListItem(
                headlineContent = { Text("Appearance") },
                supportingContent = { Text("Theme, Colors") },
                leadingContent = { Icon(Icons.Default.Palette, null) },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            
            // Updates
            Card(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Software Update", style = MaterialTheme.typography.titleMedium)
                    Text("Current Version: 1.1.0", style = MaterialTheme.typography.bodySmall)
                    
                    when (val state = updateState) {
                        is UpdateState.UpToDate -> Text("You are up to date!", color = MaterialTheme.colorScheme.primary)
                        is UpdateState.UpdateRequired -> {
                            Text("Update Available: v${state.version}", color = MaterialTheme.colorScheme.error)
                            Button(onClick = { state.url?.let { viewModel.downloadAndInstall(it) } }) {
                                Text("Download & Install")
                            }
                        }
                        is UpdateState.Downloading -> Text("Downloading... ${state.progress}%")
                        is UpdateState.Error -> Text("Error: ${state.message}", color = MaterialTheme.colorScheme.error)
                        else -> {}
                    }
                    
                    Button(onClick = { viewModel.checkForUpdates() }, modifier = Modifier.padding(top = 8.dp)) {
                        Text("Check for Updates")
                    }
                }
            }

            // About
            ListItem(
                headlineContent = { Text("About") },
                supportingContent = { Text("Legal, Credits") },
                leadingContent = { Icon(Icons.Default.Info, null) },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
