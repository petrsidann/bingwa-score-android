package com.bingwascore.app.ui.settings

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.rounded.SimCard
import androidx.compose.material.icons.rounded.SystemUpdateAlt
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.White

private enum class SettingsPage(val title: String) {
    APPEARANCE("Appearance"),
    PROCESSING_MODE("Processing Mode"),
    SIM_SELECTION("SIM Selection"),
    UPDATES("Check For Updates"),
    ABOUT("About"),
    TERMS("Terms of Service"),
    PRIVACY("Privacy Policy")
}

/** Settings hub with glass rows plus its own sub-pages. */
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    var currentPage by remember { mutableStateOf<SettingsPage?>(null) }

    val page = currentPage
    if (page != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(NightBlack)
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
                .background(NightBlack)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text("Settings", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Tune how Bingwa Score behaves",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            SectionLabel("Preferences")
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

            SectionLabel("General")
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
            tint = White,
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onBack)
                .padding(10.dp)
                .size(22.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(title, color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun SectionLabel(label: String) {
    Text(
        label.uppercase(),
        color = White.copy(alpha = 0.4f),
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
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onClick)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(EmeraldGreen.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = EmeraldGreen,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(1.dp))
                Text(subtitle, color = White.copy(alpha = 0.5f), fontSize = 11.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Rounded.ChevronRight,
                contentDescription = null,
                tint = White.copy(alpha = 0.4f),
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
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onClick)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(description, color = White.copy(alpha = 0.55f), fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            if (selected) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = "Selected",
                    tint = EmeraldGreen,
                    modifier = Modifier.size(22.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(Color(0x14FFFFFF))
                )
            }
        }
    }
}

@Composable
private fun AppearancePage(viewModel: SettingsViewModel) {
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()

    PageTitle("Appearance")
    PageIntro("Pick how Bingwa Score looks on this device.")
    OptionCard(
        title = "Dark",
        description = "The classic glass-on-black look",
        selected = themeMode == ThemeMode.DARK,
        onClick = { viewModel.setThemeMode(ThemeMode.DARK) }
    )
    OptionCard(
        title = "Light",
        description = "Bright surfaces for outdoor use",
        selected = themeMode == ThemeMode.LIGHT,
        onClick = { viewModel.setThemeMode(ThemeMode.LIGHT) }
    )
    OptionCard(
        title = "System",
        description = "Follow the device setting",
        selected = themeMode == ThemeMode.SYSTEM,
        onClick = { viewModel.setThemeMode(ThemeMode.SYSTEM) }
    )
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
        onClick = { viewModel.setProcessingMode(AppProcessingMode.ADVANCED) }
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

// __CHUNK5__

@Composable
private fun UpdatesPage(viewModel: SettingsViewModel) {
    val updateState by viewModel.updateState.collectAsStateWithLifecycle()

    PageTitle("Check For Updates")
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Text("Current version", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Bingwa Score v${viewModel.appVersion}",
            color = White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        GradientButton(
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
                    else "Update available — check the Play Store.",
                    color = if (state.upToDate) EmeraldGreen else White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            else -> Unit
        }
    }
}

@Composable
private fun AboutPage(viewModel: SettingsViewModel) {
    PageTitle("About")
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Text("Bingwa Score", color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Version ${viewModel.appVersion}",
            color = White.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Bingwa Score helps airtime agents sell Safaricom bundles faster: one-tap dialing, " +
                "auto renewals, botted replies and commission tracking — all on your phone.",
            color = White.copy(alpha = 0.6f),
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
            "Deleting the app removes all local data, including the blacklist and authorized " +
                "senders."
        )
    )
}

@Composable
private fun PageTitle(title: String) {
    Text(
        title,
        color = White,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun PageIntro(text: String) {
    Text(
        text,
        color = White.copy(alpha = 0.55f),
        fontSize = 12.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
private fun PolicyBody(title: String, paragraphs: List<String>) {
    PageTitle(title)
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        paragraphs.forEachIndexed { index, paragraph ->
            if (index > 0) Spacer(modifier = Modifier.height(10.dp))
            Text(paragraph, color = White.copy(alpha = 0.7f), fontSize = 13.sp)
        }
    }
}
