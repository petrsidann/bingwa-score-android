package com.bingwascore.app.ui.onboarding

import android.app.Activity
import android.content.Intent
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material.icons.rounded.SimCard
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.PowerUtils

@Composable
fun SetupChecklistScreen(
    viewModel: SetupChecklistViewModel = hiltViewModel(),
    onSetupComplete: () -> Unit
) {
    val context = LocalContext.current
    val activity = context as? Activity

    val setupComplete by viewModel.setupComplete.collectAsStateWithLifecycle()
    val permissionsGranted by viewModel.permissionsGranted.collectAsStateWithLifecycle()
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsStateWithLifecycle()
    val batteryIgnored by viewModel.batteryIgnored.collectAsStateWithLifecycle()
    val engineEnabled by viewModel.engineEnabled.collectAsStateWithLifecycle()

    LaunchedEffect(setupComplete) { if (setupComplete) onSetupComplete() }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { viewModel.refreshChecks() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
            .verticalScroll(rememberScrollState())
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text("Finish setup — let's lock in your engine", color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "Grant these so Bingwa never misses an M-Pesa credit or USSD step.",
            color = White.copy(alpha = 0.6f),
            fontSize = 13.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        ChecklistRow(
            icon = Icons.Rounded.SimCard,
            title = "Phone & SMS permissions",
            done = permissionsGranted,
            actionLabel = if (permissionsGranted) "Granted" else "Grant",
            onTap = { permissionLauncher.launch(SetupChecklistViewModel.REQUIRED_PERMISSIONS.toTypedArray()) }
        )
        ChecklistRow(
            icon = Icons.Rounded.Inbox,
            title = "Notifications enabled",
            done = notificationsEnabled,
            actionLabel = if (notificationsEnabled) "On" else "Enable",
                        onTap = {
                val host = activity ?: context
                                val settings = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    putExtra(Settings.EXTRA_APP_PACKAGE, host.packageName)
                    putExtra(Settings.EXTRA_CHANNEL_ID, "")
                }
                host.startActivity(settings)
            }
        )
        ChecklistRow(
            icon = Icons.Rounded.Warning,
            title = "Battery optimisation off",
            done = batteryIgnored,
            actionLabel = if (batteryIgnored) "Excluded" else "Fix",
            onTap = {
                if (activity != null) PowerUtils.requestIgnoreBatteryOptimizations(activity)
                else PowerUtils.openAppDetailsSettings(context)
            }
        )
        ChecklistRow(
            icon = Icons.Rounded.Bolt,
            title = "Engine running",
            done = engineEnabled,
            actionLabel = if (engineEnabled) "Running" else "Start",
            onTap = { if (!engineEnabled) viewModel.startEngine() }
        )

        Spacer(modifier = Modifier.weight(1f))
        GradientButton(
            text = "Start Earning",
            onClick = { viewModel.completeSetup() },
            modifier = Modifier.fillMaxWidth(),
                        enabled = true
        )
    }
}

@Composable
private fun ChecklistRow(
    icon: ImageVector,
    title: String,
    done: Boolean,
    actionLabel: String,
    onTap: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        onClick = if (done) null else { onTap }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (done) EmeraldGreen else Orange500,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(actionLabel, color = if (done) EmeraldGreen else Orange500, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            StatusChip(text = if (done) "DONE" else "ACTION", color = if (done) EmeraldGreen else Orange500)
        }
    }
}

@Composable
private fun StatusChip(text: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(alpha = 0.14f))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(text, color = color, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
}
