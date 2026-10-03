package com.bingwascore.app.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material.icons.rounded.SaveAlt
import androidx.compose.material.icons.rounded.SimCard
import androidx.compose.material.icons.rounded.SystemUpdateAlt
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.rounded.Science
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.ExplanationDialog
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.BackupManager
import kotlinx.coroutines.launch
import java.io.File

private enum class SettingsPage(val title: String) {
    APPEARANCE("Appearance"),
    PROCESSING_MODE("Processing Mode"),
    SIM_SELECTION("SIM Selection"),
    SIMULATE_PAYMENT("Test Drive"),
    BACKUP_RESTORE("Backup & Restore"),
    UPDATES("Check For Updates"),
    ABOUT("About"),
    TERMS("Terms of Service"),
    PRIVACY("Privacy Policy")
}

/** Settings hub with glass rows plus its own sub-pages. */
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    var currentPage by remember { mutableStateOf<SettingsPage?>(null) }

    val showAdvancedExplanation by viewModel.showAdvancedExplanation.collectAsStateWithLifecycle()
    // MEGA A — inbound routing switches.
    val processMpesaMessages by viewModel.processMpesaMessages.collectAsStateWithLifecycle()
    val processSitelinkMessages by viewModel.processSitelinkMessages.collectAsStateWithLifecycle()
    if (showAdvancedExplanation) {
        ExplanationDialog(
            title = "Advanced Mode",
            message = "Advanced Mode uses an accessibility service to read and auto-tap USSD screens so Safaricom flows complete on their own. Open the system settings to enable the \"Bingwa Score\" accessibility service, then toggle Advanced back on.",
            onDismiss = { viewModel.dismissAdvancedExplanation() },
            onConfirm = { viewModel.confirmAdvancedMode() }
        )
    }


    val page = currentPage
    if (page != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .screenEnter()
                .background(BgBlack)
        ) {
            PageHeader(title = page.title, onBack = { currentPage = null })
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
            ) {
                when (page) {
                    SettingsPage.APPEARANCE -> AppearancePage(viewModel)
                    SettingsPage.PROCESSING_MODE -> ProcessingModePage(viewModel)
                    SettingsPage.SIM_SELECTION -> SimSelectionPage(viewModel)
                    SettingsPage.SIMULATE_PAYMENT -> SimulatePaymentPage(viewModel)
                    SettingsPage.BACKUP_RESTORE -> BackupRestorePage(viewModel)
                    SettingsPage.UPDATES -> UpdatesPage(viewModel)
                    SettingsPage.ABOUT -> AboutPage(viewModel)
                    SettingsPage.TERMS -> TermsPage()
                    SettingsPage.PRIVACY -> PrivacyPage()
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .screenEnter()
                .background(BgBlack)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text("Settings", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Tune how Bingwa Score behaves",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            // MEGA A — inbound message routing switches. Turning M-Pesa off is
            // the panic switch; SiteLink narrows the engine to one channel.
            SectionLabel("Message processing")
            BubbleCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                SettingsSwitchRow(
                    title = "Process M-Pesa Messages",
                    subtitle = "Read inbound M-Pesa payment alerts and auto-dial offers",
                    checked = processMpesaMessages,
                    onCheckedChange = viewModel::setProcessMpesaMessages
                )
                Spacer(modifier = Modifier.height(10.dp))
                SettingsSwitchRow(
                    title = "Process SiteLink Messages",
                    subtitle = "Handle SiteLink storefront order messages",
                    checked = processSitelinkMessages,
                    onCheckedChange = viewModel::setProcessSitelinkMessages
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            SettingsRow(
                icon = Icons.Rounded.Palette,
                title = "Appearance",
                subtitle = "Light, dark or follow system",
                onClick = { currentPage = SettingsPage.APPEARANCE }
            )
            SettingsRow(
                icon = Icons.Rounded.Bolt,
                title = "Processing Mode",
                subtitle = "How transactions are executed",
                onClick = { currentPage = SettingsPage.PROCESSING_MODE }
            )
            SettingsRow(
                icon = Icons.Rounded.SimCard,
                title = "SIM Selection",
                subtitle = "Line used for dialing and balance checks",
                onClick = { currentPage = SettingsPage.SIM_SELECTION }
            )
            SettingsRow(
                icon = Icons.Rounded.Science,
                title = "Test Drive",
                subtitle = "Sandbox: simulate an M-Pesa credit, zero real money",
                trailing = {
                    DevChip()
                },
                onClick = { currentPage = SettingsPage.SIMULATE_PAYMENT }
            )

            SectionLabel("General")
            SettingsRow(
                icon = Icons.Rounded.SaveAlt,
                title = "Backup & Restore",
                subtitle = "Export or import your data as JSON",
                onClick = { currentPage = SettingsPage.BACKUP_RESTORE }
            )
            SettingsRow(
                icon = Icons.Rounded.SystemUpdateAlt,
                title = "Check For Updates",
                subtitle = "Keep the app on the latest release",
                onClick = { currentPage = SettingsPage.UPDATES }
            )
            SettingsRow(
                icon = Icons.Rounded.Info,
                title = "About",
                subtitle = "Version and app information",
                onClick = { currentPage = SettingsPage.ABOUT }
            )
            SettingsRow(
                icon = Icons.Rounded.Description,
                title = "Terms",
                subtitle = "Terms of service",
                onClick = { currentPage = SettingsPage.TERMS }
            )
            SettingsRow(
                icon = Icons.Rounded.PrivacyTip,
                title = "Privacy",
                subtitle = "How your data is handled",
                onClick = { currentPage = SettingsPage.PRIVACY }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun PageHeader(title: String, onBack: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = TextWhite,
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onBack)
                .padding(10.dp)
                .size(22.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(title, color = TextWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

/**
 * MEGA A — a labelled on/off row. Same glass chrome as [SettingsRow] but with a
 * switch instead of a chevron, used for the inbound message-routing toggles.
 */
@Composable
private fun SettingsSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TextWhite, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(
                subtitle,
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 11.sp
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = AccentBlue,
                uncheckedThumbColor = TextWhite.copy(alpha = 0.6f),
                checkedTrackColor = AccentBlue.copy(alpha = 0.35f),
                uncheckedTrackColor = Bubble,
                uncheckedBorderColor = Hairline
            )
        )
    }
}

@Composable
private fun SectionLabel(label: String) {
    Text(
        label.uppercase(),
        color = TextWhite.copy(alpha = 0.4f),
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp)
    )
}

@Composable
private fun SettingsRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    trailing: (@Composable () -> Unit)? = null,
    onClick: () -> Unit
) {
    BubbleCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(AccentBlue.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = AccentBlue,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = TextWhite, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(1.dp))
                Text(subtitle, color = TextWhite.copy(alpha = 0.5f), fontSize = 11.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            if (trailing != null) {
                trailing()
                Spacer(modifier = Modifier.width(8.dp))
            }
            Icon(
                imageVector = Icons.Rounded.ChevronRight,
                contentDescription = null,
                tint = TextWhite.copy(alpha = 0.4f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun OptionCard(
    title: String,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    BubbleCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(description, color = TextWhite.copy(alpha = 0.55f), fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            if (selected) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = "Selected",
                    tint = AccentBlue,
                    modifier = Modifier.size(22.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(Bubble)
                )
            }
        }
    }
}

@Composable
private fun AppearancePage(viewModel: SettingsViewModel) {
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
    val haptics = rememberHaptics()

    PageTitle("Appearance")
    PageIntro("Pick how Bingwa Score looks on this device. Changes apply instantly.")
    ThemeMode.entries.forEach { mode ->
        OptionCard(
            title = mode.label,
            description = when (mode) {
                ThemeMode.DARK -> "Black canvas, electric blue actions"
                ThemeMode.GRAYSCALE -> "Monochrome — every accent drops to grey"
                ThemeMode.BLUE_LIGHT_FILTER -> "Warm dark that tames blue light at night"
            },
            selected = themeMode == mode,
            onClick = {
                // R6 — a mode switch is a deliberate act, so it ticks.
                haptics.tick()
                viewModel.setThemeMode(mode)
            }
        )
    }
}

@Composable
private fun ProcessingModePage(viewModel: SettingsViewModel) {
    val processingMode by viewModel.processingMode.collectAsStateWithLifecycle()

    PageTitle("Processing Mode")
    PageIntro("How transactions are executed when you dial an offer.")
    OptionCard(
        title = "Express",
        description = "Fast single-pass dialing for busy agents",
        selected = processingMode == AppProcessingMode.EXPRESS,
        onClick = { viewModel.setProcessingMode(AppProcessingMode.EXPRESS) }
    )
        OptionCard(
        title = "Advanced",
        description = "Extra verification steps and retries",
        selected = processingMode == AppProcessingMode.ADVANCED,
        onClick = { viewModel.requestAdvancedMode() }
    )
}

@Composable
private fun SimSelectionPage(viewModel: SettingsViewModel) {
    val simSelection by viewModel.simSelection.collectAsStateWithLifecycle()

    PageTitle("SIM Selection")
    PageIntro("The line used for dialing and balance checks.")
    OptionCard(
        title = UserPreferences.SIM_1,
        description = "Use the first SIM for all automated dials",
        selected = simSelection == UserPreferences.SIM_1,
        onClick = { viewModel.setSimSelection(UserPreferences.SIM_1) }
    )
    OptionCard(
        title = UserPreferences.SIM_2,
        description = "Use the second SIM for all automated dials",
        selected = simSelection == UserPreferences.SIM_2,
        onClick = { viewModel.setSimSelection(UserPreferences.SIM_2) }
    )
}

/**
 * Dev test bench (Audit G8): phone/name/amount inputs feed a fake INCOMING
 * M-Pesa confirmation into the real engine so match -> dial -> status ->
 * reply is testable with zero real money.
 */
@Composable
private fun SimulatePaymentPage(viewModel: SettingsViewModel) {
    val result by viewModel.simulateResult.collectAsStateWithLifecycle()
    val simulateFailed by viewModel.simulateFailed.collectAsStateWithLifecycle()
    val haptics = rememberHaptics()

    // Parity E — a simulation that lands feels different from one that fails.
    LaunchedEffect(result) {
        result?.let { if (simulateFailed) haptics.error() else haptics.success() }
    }

    var phone by remember { mutableStateOf("") }
    var payerName by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }

    PageTitle("Test Drive")
    PageIntro("Sandbox — feeds a simulated INCOMING M-Pesa credit into the real pipeline. No real money moves.")
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("DEV", color = BgBlack, fontSize = 10.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.clip(CircleShape).background(AccentBlue).padding(horizontal = 8.dp, vertical = 3.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Test Drive", color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "Phone, payer name and amount become a fake \"received from\" SMS. The engine matches an offer, dials, updates status and replies — exactly like a real payment.",
            color = TextWhite.copy(alpha = 0.55f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(14.dp))
        SimulateField(value = phone, onValueChange = { phone = it }, hint = "e.g. 0712345678")
        Spacer(modifier = Modifier.height(10.dp))
        SimulateField(value = payerName, onValueChange = { payerName = it }, hint = "Payer name e.g. JOHN DOE")
        Spacer(modifier = Modifier.height(10.dp))
        SimulateField(value = amountText, onValueChange = { amountText = it.filter { c -> c.isDigit() || c == '.' } }, hint = "Amount e.g. 20")
        Spacer(modifier = Modifier.height(14.dp))
        PrimaryButton(
            text = "Run Simulation",
            onClick = {
                viewModel.simulatePayment(phone, payerName, amountText.toDoubleOrNull() ?: 0.0)
            }
        )
        result?.let {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                it,
                color = if (simulateFailed) FailRed else TickGreen,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun SimulateField(value: String, onValueChange: (String) -> Unit, hint: String) {
    val shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .padding(horizontal = 14.dp, vertical = 13.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = TextWhite, fontSize = 14.sp),
            cursorBrush = SolidColor(AccentBlue),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isEmpty()) {
            Text(hint, color = TextWhite.copy(alpha = 0.4f), fontSize = 14.sp)
        }
    }
}

@Composable
private fun DevChip() {
    Text(
        "DEV",
        color = BgBlack,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clip(CircleShape)
            .background(AccentBlue)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    )
}


@Composable
private fun BackupRestorePage(viewModel: SettingsViewModel) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var lastResult by remember { mutableStateOf<String?>(null) }

    val importLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri == null) return@rememberLauncherForActivityResult
        scope.launch {
            try {
                val tempFile = File(context.cacheDir, "restore_backup.json")
                context.contentResolver.openInputStream(uri)?.use { input ->
                    tempFile.outputStream().use { output -> input.copyTo(output) } ?: return@launch
                } ?: return@launch
                val ok = BackupManager.importAll(context, tempFile)
                tempFile.delete()
                val msg = if (ok) "Restore successful" else "Restore failed"
                lastResult = msg
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            } catch (_: Throwable) {
                Toast.makeText(context, "Restore failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    PageTitle("Backup & Restore")
    PageIntro("Export your transactions, offers, customers and auto-replies to a JSON file, or restore them later. Restoring replaces all current data.")

    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("Export", color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Save all your app data to a JSON file in Bingwa Score/backups.",
            color = TextWhite.copy(alpha = 0.55f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(14.dp))
        PrimaryButton(
            text = "Export data",
            onClick = {
                scope.launch {
                    val file = BackupManager.exportAll(context)
                    val msg = if (file != null) "Backup saved" else "Backup failed"
                    lastResult = msg
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("Import", color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Restore from a previously exported JSON backup. This clears current data first.",
            color = TextWhite.copy(alpha = 0.55f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(14.dp))
        PrimaryButton(
            text = "Import data",
            onClick = { importLauncher.launch("application/json") }
        )
    }

    lastResult?.let { result ->
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            result,
            color = if (result.contains("successful") || result.contains("saved")) TickGreen else TextWhite,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// __CHUNK5__


// __CHUNK5__

@Composable
private fun UpdatesPage(viewModel: SettingsViewModel) {
    val updateState by viewModel.updateState.collectAsStateWithLifecycle()
    val updateUrl by viewModel.updateUrl.collectAsStateWithLifecycle()
    val context = LocalContext.current

    PageTitle("Check For Updates")
    PageIntro("Compare this build against the latest GitHub release.")
    BubbleCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Text("Current version", color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Bingwa Score v${viewModel.appVersion}",
            color = TextWhite,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            text = when (updateState) {
                is UpdateCheckState.Checking -> "Checking..."
                else -> "Check For Updates"
            },
            enabled = updateState !is UpdateCheckState.Checking,
            onClick = viewModel::checkForUpdates
        )
        when (val state = updateState) {
            is UpdateCheckState.Done -> {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    if (state.upToDate) "You're on the latest version."
                    else "Update available — download the latest release.",
                    color = if (state.upToDate) TickGreen else TextWhite,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                if (!state.upToDate && updateUrl != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    PrimaryButton(
                        text = "Open in browser",
                        onClick = {
                            try {
                                context.startActivity(
                                    android.content.Intent(
                                        android.content.Intent.ACTION_VIEW,
                                        android.net.Uri.parse(updateUrl)
                                    ).addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                                )
                            } catch (_: Throwable) {
                                Toast.makeText(context, "Could not open browser", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
            else -> Unit
        }
    }
}

@Composable
private fun AboutPage(viewModel: SettingsViewModel) {
    PageTitle("About")
    PageIntro("What Bingwa Score is and which build is installed.")
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("Bingwa Score", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Version ${viewModel.appVersion}",
            color = TextWhite.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Bingwa Score helps airtime agents sell Safaricom bundles faster: one-tap dialing, " +
                "auto renewals, smart follow-up and commission tracking — all on your phone.",
            color = TextWhite.copy(alpha = 0.6f),
            fontSize = 13.sp
        )
    }
}

@Composable
private fun TermsPage() {
    PolicyBody(
        title = "Terms of Service",
        paragraphs = listOf(
            "By using Bingwa Score you agree to sell bundles and airtime in line with the " +
                "rates and commissions shown in the app. Prices may change without notice.",
            "You are responsible for the transactions you dial on your own line. Bingwa Score " +
                "automates dialing but does not hold your funds.",
            "Refunds for failed transactions follow the operator's policy. Repeated misuse of " +
                "auto-renewals or the bot engine may lead to account suspension."
        )
    )
}

@Composable
private fun PrivacyPage() {
    PolicyBody(
        title = "Privacy Policy",
        paragraphs = listOf(
            "Bingwa Score stores your customers, transactions and preferences on this device " +
                "only. We do not sell or share your customer list with third parties.",
            "SMS permissions are used solely to detect operator confirmations and to run your " +
                "auto-reply engine on the senders you authorize.",
            "Deleting the app removes all local data, including your Blocked Contacts and " +
                "Trusted Partners."
        )
    )
}

@Composable
private fun PageTitle(title: String) {
    Text(
        title,
        color = TextWhite,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun PageIntro(text: String) {
    Text(
        text,
        color = TextWhite.copy(alpha = 0.55f),
        fontSize = 12.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
private fun PolicyBody(title: String, paragraphs: List<String>) {
    PageTitle(title)
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        paragraphs.forEachIndexed { index, paragraph ->
            if (index > 0) Spacer(modifier = Modifier.height(10.dp))
            Text(paragraph, color = TextWhite.copy(alpha = 0.7f), fontSize = 13.sp)
        }
    }
}
