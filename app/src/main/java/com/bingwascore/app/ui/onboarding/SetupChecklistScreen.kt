package com.bingwascore.app.ui.onboarding

import android.app.Activity
import android.content.Intent
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.glass.PhaseCta
import com.bingwascore.app.ui.glass.PhaseGrantRow
import com.bingwascore.app.ui.glass.PhaseScreen
import com.bingwascore.app.ui.glass.PhaseSurface
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

    PhaseScreen {
        Text(
            "Lock in your engine",
            color = PhaseSurface.Ink,
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "Grant these so Bingwa never misses an M-Pesa credit or USSD step.",
            color = PhaseSurface.Mut,
            fontSize = 13.sp
        )
        Spacer(Modifier.height(24.dp))

        PhaseGrantRow(
            icon = Icons.Rounded.SimCard,
            title = "Phone & SMS permissions",
            caption = "Allow Bingwa to read SMS and access phone state.",
            done = permissionsGranted,
            onAction = { permissionLauncher.launch(SetupChecklistViewModel.REQUIRED_PERMISSIONS.toTypedArray()) }
        )
        PhaseGrantRow(
            icon = Icons.Rounded.Inbox,
            title = "Notifications enabled",
            caption = "Receive transaction and engine alerts.",
            done = notificationsEnabled,
            onAction = {
                val host = activity ?: context
                val settings = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    putExtra(Settings.EXTRA_APP_PACKAGE, host.packageName)
                    putExtra(Settings.EXTRA_CHANNEL_ID, "")
                }
                host.startActivity(settings)
            }
        )
        PhaseGrantRow(
            icon = Icons.Rounded.Warning,
            title = "Battery optimisation off",
            caption = "Prevent the OS from killing the engine in the background.",
            done = batteryIgnored,
            onAction = {
                if (activity != null) PowerUtils.requestIgnoreBatteryOptimizations(activity)
                else PowerUtils.openAppDetailsSettings(context)
            }
        )
        PhaseGrantRow(
            icon = Icons.Rounded.Bolt,
            title = "Engine running",
            caption = "The USSD engine must be active to process transactions.",
            done = engineEnabled,
            onAction = { if (!engineEnabled) viewModel.startEngine() }
        )

        Spacer(Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(bottom = 16.dp)
        ) {
            PhaseCta(
                label = "Start earning",
                ready = permissionsGranted && notificationsEnabled && batteryIgnored && engineEnabled,
                onClick = { viewModel.completeSetup() }
            )
        }
    }
}
