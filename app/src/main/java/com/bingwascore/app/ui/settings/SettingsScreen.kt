package com.bingwascore.app.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material.icons.automirrored.filled.ChevronRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.BingwaButton
import com.bingwascore.app.ui.theme.Emerald500
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.Rose500
import com.bingwascore.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onNavigateBack: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val systemDark = isSystemInDarkTheme()
    val onSurface = MaterialTheme.colorScheme.onSurface
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant
    val surface = MaterialTheme.colorScheme.surface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Settings", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
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
            // Appearance
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(surface)
                    .padding(20.dp)
            ) {
                Column {
                    Text("Appearance", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text("Choose how Bingwa Score looks", color = onSurfaceVariant, fontSize = 13.sp)
                    Spacer(Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        ThemeCard(
                            label = "Light",
                            icon = Icons.Default.WbSunny,
                            iconTint = Orange500,
                            preview = White,
                            selected = !systemDark && state.themeMode == 0,
                            accent = Orange500,
                            onClick = { viewModel.setTheme(0) },
                            modifier = Modifier.weight(1f)
                        )
                        ThemeCard(
                            label = "Dark",
                            icon = Icons.Default.DarkMode,
                            iconTint = Purple500,
                            preview = androidx.compose.ui.graphics.Color(0xFF0B0B0F),
                            selected = systemDark || state.themeMode == 1,
                            accent = Purple500,
                            onClick = { viewModel.setTheme(1) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Software update
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(surface)
                    .padding(20.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Emerald500)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "SOFTWARE UPDATE",
                            color = onSurfaceVariant,
                            fontSize = 11.sp,
                            letterSpacing = 1.5.sp
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Text("Check for updates", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text("Current version ${state.currentVersion}", color = onSurfaceVariant, fontSize = 13.sp)
                    Spacer(Modifier.height(16.dp))

                    Text("Update Key", color = onSurfaceVariant, fontSize = 12.sp)
                    Spacer(Modifier.height(6.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = state.updateKey,
                            onValueChange = { viewModel.setKey(it) },
                            placeholder = { Text("BINGWA-XXXXXXXX") },
                            leadingIcon = { Icon(Icons.Default.Key, contentDescription = null) },
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(14.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline
                            )
                        )
                        Box(
                            modifier = Modifier
                                .height(56.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f))
                                .clickable { viewModel.generateKey() }
                                .padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Generate", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                        }
                    }

                    state.error?.let {
                        Spacer(Modifier.height(12.dp))
                        Text(it, color = Rose500, fontSize = 13.sp)
                    }

                    Spacer(Modifier.height(16.dp))
                    BingwaButton(
                        text = if (state.isChecking) "Checking..." else "Check for updates",
                        onClick = { viewModel.checkForUpdates() },
                        loading = state.isChecking,
                        enabled = state.updateKey.isNotBlank()
                    )

                    state.versionInfo?.let { info ->
                        Spacer(Modifier.height(12.dp))
                        Text(
                            if (info.isOutdated) "Update available: v${info.latestVersion}" else "You're up to date",
                            color = if (info.isOutdated) Orange500 else Emerald500,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            // About — professional
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(surface)
                    .padding(20.dp)
            ) {
                Column {
                    Text("About", color = onSurface, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Spacer(Modifier.height(12.dp))
                    AboutRow("Version", "${state.currentVersion} (Build 1)")
                    AboutRow("Platform", "Android")
                    AboutRow("Release Channel", "Genesis")
                    Spacer(Modifier.height(4.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* open terms url later */ }
                            .padding(vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Terms of Service", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, modifier = Modifier.weight(1f))
                        Icon(Icons.AutoMirrored.Filled.ChevronRight, contentDescription = null, tint = onSurfaceVariant)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* open privacy url later */ }
                            .padding(vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Privacy Policy", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, modifier = Modifier.weight(1f))
                        Icon(Icons.AutoMirrored.Filled.ChevronRight, contentDescription = null, tint = onSurfaceVariant)
                    }
                }
            }

            Text(
                "© 2026 Bingwa Score. All rights reserved.",
                color = onSurfaceVariant.copy(alpha = 0.7f),
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun ThemeCard(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: androidx.compose.ui.graphics.Color,
    preview: androidx.compose.ui.graphics.Color,
    selected: Boolean,
    accent: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) accent.copy(alpha = 0.1f)
                else MaterialTheme.colorScheme.surfaceVariant
            )
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
                Icon(icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(26.dp))
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
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(accent),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = White, modifier = Modifier.size(11.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
        Text(value, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, fontFamily = FontFamily.Monospace)
    }
}
