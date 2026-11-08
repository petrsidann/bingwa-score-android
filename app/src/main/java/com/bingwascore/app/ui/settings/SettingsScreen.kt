package com.bingwascore.app.ui.settings

import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Brightness2
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Nightlight
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material.icons.rounded.SaveAlt
import androidx.compose.material.icons.rounded.SimCard
import androidx.compose.material.icons.rounded.SystemUpdateAlt
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.foundation.text.BasicTextField
import com.bingwascore.app.ui.components.GlassBottomSheet
import com.bingwascore.app.ui.components.GlassDialog
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.showcase.ShowcaseController
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.ExplanationDialog
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.SecondaryButton
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.home.ThemeToggle
import com.bingwascore.app.updates.UpdateDownloader
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import com.bingwascore.app.ui.glass.frostedGlass
import com.bingwascore.app.util.BackupManager
import com.bingwascore.app.util.CrashHandler
import kotlinx.coroutines.launch
import java.io.File

private enum class SettingsPage(val title: String) {
    APPEARANCE("Appearance"),
    PROCESSING_MODE("Processing Mode"),
    SERVER("Server"),
    SIM_SELECTION("SIM Selection"),
    SIMULATE_PAYMENT("Test Drive"),
    BACKUP_RESTORE("Backup & Restore"),
    ABOUT("About"),
    TERMS("Terms of Service"),
    PRIVACY("Privacy Policy"),
    SHOWCASE("Showcase Mode")
}

/**
 * Stage 51 — premium toggle: transparent track with a 1dp Obsidian border,
 * sliding thumb (animateDpAsState, SpringStiffness), Brand.Primary active fill
 * and a Level1 shadow on the thumb when on. Haptic TextHandleMove on toggle.
 */
@Composable
fun PremiumToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val haptic = LocalHapticFeedback.current

    val trackWidth = 44.dp
    val trackHeight = 24.dp
    val thumbSize = 18.dp
    val pad = 3.dp

    val thumbX by animateDpAsState(
        targetValue = if (checked) trackWidth - thumbSize - pad else pad,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "PremiumToggleThumb"
    )
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "PremiumTogglePress"
    )

    val radiusPx = with(density) { DesignTokens.Shape.RadiusFull.toPx() }
    val thumbPx = with(density) { thumbSize.toPx() }
    val trackHeightPx = with(density) { trackHeight.toPx() }
    val shadowY = with(density) { DesignTokens.Elevation.Level1.first().offsetY.toPx() }
    val shadowColor = DesignTokens.Elevation.Level1.first().color
    val borderColor = DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.5f)
    val trackShape = RoundedCornerShape(DesignTokens.Shape.RadiusFull)
    val brand = DesignTokens.LocalBingwaRoles.current.brand

    Box(
        modifier = modifier
            .size(trackWidth, trackHeight)
            .graphicsLayer { scaleX = pressScale; scaleY = pressScale }
            .border(1.dp, borderColor, trackShape)
            .clickable(interactionSource = interactionSource, indication = null, onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                onCheckedChange(!checked)
            })
            .drawBehind {
                val fill = if (checked) brand else Color.Transparent
                drawRoundRect(
                    brush = SolidColor(fill),
                    cornerRadius = CornerRadius(radiusPx, radiusPx)
                )
            }
    ) {
        Box(
            modifier = Modifier
                .size(thumbSize, thumbSize)
                .clip(CircleShape)
                .background(DesignTokens.LocalBingwaRoles.current.textPrimary)
                .graphicsLayer {
                    translationX = with(density) { thumbX.toPx() }
                    translationY = with(density) { ((trackHeight - thumbSize) / 2).toPx() }
                }
                .drawBehind {
                    if (checked) {
                        val cx = with(density) { thumbPx / 2f }
                        val cy = with(density) { thumbPx / 2f + shadowY }
                        drawCircle(
                            color = shadowColor.copy(alpha = 0.5f),
                            center = Offset(cx, cy),
                            radius = with(density) { thumbPx / 2f }
                        )
                    }
                }
        )
    }
}

/**
 * Stage 51 — a pressable glass row: springs to 0.98 scale while pressed.
 */
@Composable
private fun PressableGlassRow(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "SettingsRowPress"
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .graphicsLayer { scaleX = scale; scaleY = scale }
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, content = content)
    }
}

/** Stage 51 — subtle 1dp separator used between rows inside a glass group. */
@Composable
private fun GroupSeparator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(1.dp)
            .background(DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.1f))
    )
}

/** Stage 51 — section label inside a glass group. */
@Composable
private fun SectionLabel(label: String) {
    Text(
        text = label.uppercase(),
        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.4f),
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
    )
}

/**
 * Stage 51 — a labelled on/off row: GlassCard row with a PremiumToggle.
 */
@Composable
private fun SettingsSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    last: Boolean = false
) {
    PressableGlassRow(onClick = { onCheckedChange(!checked) }) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(
                subtitle,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                fontSize = 11.sp
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        PremiumToggle(checked = checked, onCheckedChange = onCheckedChange)
    }
    if (!last) GroupSeparator()
}

/**
 * Stage 51 — a navigable glass row: icon, title, subtitle, optional trailing,
 * chevron tinted Obsidian.Ink at 0.4 alpha.
 */
@Composable
private fun SettingsRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    trailing: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
    last: Boolean = false
) {
    PressableGlassRow(onClick = onClick) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = DesignTokens.LocalBingwaRoles.current.brand,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(1.dp))
            Text(subtitle, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 11.sp)
        }
        Spacer(modifier = Modifier.width(8.dp))
        if (trailing != null) {
            trailing()
        } else {
            Icon(
                imageVector = Icons.Rounded.ChevronRight,
                contentDescription = null,
                tint = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.4f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
    if (!last) GroupSeparator()
}

/** Stage 51 — the DEV chip used on the Test Drive row. */
@Composable
private fun DevChip() {
    Text(
        text = "DEV",
        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .clip(CircleShape)
            .background(DesignTokens.LocalBingwaRoles.current.brand)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    )
}

/** Settings hub with glass rows plus its own sub-pages. */
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    var currentPage by remember { mutableStateOf<SettingsPage?>(null) }

    val showAdvancedExplanation by viewModel.showAdvancedExplanation.collectAsStateWithLifecycle()
    val updateState by viewModel.updateState.collectAsStateWithLifecycle()
    val updateUrl by viewModel.updateUrl.collectAsStateWithLifecycle()
    var updateDialogOpen by remember { mutableStateOf(false) }
    var crashDialogOpen by remember { mutableStateOf(false) }
    var crashReportText by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    val processMpesaMessages by viewModel.processMpesaMessages.collectAsStateWithLifecycle()
    val processSitelinkMessages by viewModel.processSitelinkMessages.collectAsStateWithLifecycle()
    val customersAutosave by viewModel.customersAutosave.collectAsStateWithLifecycle()
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
    val effectiveServerUrl by viewModel.effectiveServerUrl.collectAsStateWithLifecycle()
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
                .background(DesignTokens.LocalBingwaRoles.current.bg)
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
                    SettingsPage.SERVER -> ServerPage(viewModel)
                    SettingsPage.SIM_SELECTION -> SimSelectionPage(viewModel)
                    SettingsPage.SIMULATE_PAYMENT -> SimulatePaymentPage(viewModel)
                    SettingsPage.BACKUP_RESTORE -> BackupRestorePage(viewModel)
                    SettingsPage.ABOUT -> AboutPage(viewModel)
                    SettingsPage.TERMS -> TermsPage()
                    SettingsPage.PRIVACY -> PrivacyPage()
                    SettingsPage.SHOWCASE -> ShowcasePage()
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .screenEnter()
                .background(DesignTokens.LocalBingwaRoles.current.bg)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Settings",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    style = DesignTokens.Typography.Headline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tune how Bingwa Score behaves",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }

            // Message Processing — grouped glass card with PremiumToggle rows.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Column {
                    SectionLabel("Message Processing")
                    SettingsSwitchRow(
                        title = "Process M-Pesa Messages",
                        subtitle = "Read inbound M-Pesa payment alerts and auto-dial offers",
                        checked = processMpesaMessages,
                        onCheckedChange = viewModel::setProcessMpesaMessages,
                        last = false
                    )
                    SettingsSwitchRow(
                        title = "Process SiteLink Messages",
                        subtitle = "Handle SiteLink storefront order messages",
                        checked = processSitelinkMessages,
                        onCheckedChange = viewModel::setProcessSitelinkMessages,
                        last = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            // Customers book — grouped glass card.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Column {
                    SectionLabel("Customers Book")
                    SettingsSwitchRow(
                        title = "Auto-save Customers",
                        subtitle = "Add every completed bundle's buyer to the Customers book",
                        checked = customersAutosave,
                        onCheckedChange = viewModel::setCustomersAutosave,
                        last = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            // Preferences — grouped glass card.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Column {
                    SectionLabel("Preferences")
                    SettingsRow(
                        icon = Icons.Rounded.Palette,
                        title = "Appearance",
                        subtitle = "Light, dark or follow system",
                        trailing = {
                            ThemeIconPreview(isDark = themeMode == ThemeMode.DARK)
                        },
                        onClick = { currentPage = SettingsPage.APPEARANCE },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Bolt,
                        title = "Processing Mode",
                        subtitle = "How transactions are executed",
                        onClick = { currentPage = SettingsPage.PROCESSING_MODE },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.SimCard,
                        title = "SIM Selection",
                        subtitle = "Line used for dialing and balance checks",
                        onClick = { currentPage = SettingsPage.SIM_SELECTION },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Bolt,
                        title = "Test Drive",
                        subtitle = "Sandbox: simulate an M-Pesa credit, zero real money",
                        trailing = { DevChip() },
                        onClick = { currentPage = SettingsPage.SIMULATE_PAYMENT },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Link,
                        title = "Server",
                        subtitle = "Backend base URL — $effectiveServerUrl",
                        onClick = { currentPage = SettingsPage.SERVER },
                        last = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            // Account & Data — grouped glass card.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Column {
                    SectionLabel("Account & Data")
                    SettingsRow(
                        icon = Icons.Rounded.SaveAlt,
                        title = "Backup & Restore",
                        subtitle = "Export or import your data as JSON",
                        onClick = { currentPage = SettingsPage.BACKUP_RESTORE },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.SystemUpdateAlt,
                        title = "Check for updates",
                        subtitle = "Compare this build against the latest release",
                        onClick = {
                            updateDialogOpen = true
                            viewModel.checkForUpdates()
                        },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Description,
                        title = "Last crash report",
                        subtitle = "Copy the most recent uncaught-exception stack to share",
                        onClick = {
                            crashReportText = CrashHandler.readLatestCrashReport(context)
                            crashDialogOpen = true
                        },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Info,
                        title = "About",
                        subtitle = "Version and app information",
                        onClick = { currentPage = SettingsPage.ABOUT },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Description,
                        title = "Terms",
                        subtitle = "Terms of service",
                        onClick = { currentPage = SettingsPage.TERMS },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.PrivacyTip,
                        title = "Privacy",
                        subtitle = "How your data is handled",
                        onClick = { currentPage = SettingsPage.PRIVACY },
                        last = false
                    )
                    SettingsRow(
                        icon = Icons.Rounded.Bolt,
                        title = "Showcase Mode",
                        subtitle = if (DbNameHolder.showcaseMode) {
                            "On — running on live demo data"
                        } else {
                            "Explore with a separate demo database"
                        },
                        onClick = { currentPage = SettingsPage.SHOWCASE },
                        last = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    // Stage 22 + 31 — the check ran; the answer arrives in a dialog.
    val done = updateState as? UpdateCheckState.Done
    val isCannotCheck = updateState is UpdateCheckState.CannotCheck
    if (updateDialogOpen && done != null) {
        UpdateResultSheet(
            state = done,
            currentVersion = viewModel.appVersion,
            latestVersion = done.latestVersion,
            downloadUrl = updateUrl,
            changelog = viewModel.updateChangelog,
            onDismiss = { updateDialogOpen = false }
        )
    }
    if (updateDialogOpen && isCannotCheck) {
        CannotCheckDialog(
            onDismiss = { updateDialogOpen = false },
            onRetry = { viewModel.checkForUpdates() }
        )
    }
    // Stage 31 — the last crash report, capturable on-phone without adb.
    if (crashDialogOpen) {
        CrashReportDialog(
            report = crashReportText,
            onDismiss = { crashDialogOpen = false; crashReportText = null }
        )
    }
}

/** Theme icon preview: sun/moon that rotates 180 degrees when tapped. */
@Composable
private fun ThemeIconPreview(isDark: Boolean) {
    var rotation by remember { mutableStateOf(0f) }
    val targetRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "ThemeIconRotate"
    )
    val icon = if (isDark) Icons.Rounded.Nightlight else Icons.Rounded.Brightness2
    Box(
        modifier = Modifier
            .size(28.dp)
            .clip(CircleShape)
            .background(DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.12f))
            .clickable(onClick = {
                rotation = if (rotation == 0f) 180f else 0f
            })
            .graphicsLayer { rotationZ = targetRotation },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = if (isDark) "Dark theme" else "Light theme",
            tint = DesignTokens.LocalBingwaRoles.current.brand,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun CannotCheckDialog(
    onDismiss: () -> Unit,
    onRetry: () -> Unit
) {
    GlassDialog(
        visible = true,
        onDismiss = onDismiss,
        title = "Can't check right now",
        body = {
            Text(
                text = "Bingwa Score can't reach the release server at the moment. " +
                    "Check your connection and try again.",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                fontSize = 13.sp
            )
        },
        dismissLabel = "Later",
        confirmLabel = "Retry",
        onConfirm = { onRetry(); onDismiss() }
    )
}
@Composable
private fun CrashReportDialog(
    report: String?,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    GlassDialog(
        visible = true,
        onDismiss = onDismiss,
        title = "Last crash report",
        body = {
            val body = report ?: "No crash report on file yet."
            Text(
                text = body,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .verticalScroll(rememberScrollState())
            )
        },
        dismissLabel = "Later",
        confirmLabel = "Copy",
        onConfirm = {
            report?.let { text ->
                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                clipboard.setPrimaryClip(android.content.ClipData.newPlainText("Bingwa crash report", text))
            }
            onDismiss()
        }
    )
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
            tint = DesignTokens.LocalBingwaRoles.current.textPrimary,
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onBack)
                .padding(10.dp)
                .size(22.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

/**
 * MEGA A — a labelled on/off row with a PremiumToggle, glass chrome matching
 * [SettingsRow], used for the inbound message-routing toggles.
 */
@Composable
private fun PageTitle(title: String) {
    Text(
        text = title,
        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun PageIntro(text: String) {
    Text(
        text = text,
        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.55f),
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
            Text(paragraph, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f), fontSize = 13.sp)
        }
    }
}

@Composable
private fun AppearancePage(viewModel: SettingsViewModel) {
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
    val haptics = rememberHaptics()
    val isDark = themeMode == ThemeMode.DARK

    PageTitle("Appearance")
    PageIntro("Obsidian by night, Porcelain Dim by day. The switch persists and repaints the app instantly.")

    BubbleCard(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Theme",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = themeMode.label,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            ThemeToggle(onToggle = {
                haptics.tick()
                viewModel.setThemeMode(
                    if (isDark) ThemeMode.PORCELAIN_DIM else ThemeMode.DARK
                )
            })
        }
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
private fun ServerPage(viewModel: SettingsViewModel) {
    val haptics = rememberHaptics()
    val serverUrl by viewModel.serverUrl.collectAsStateWithLifecycle()
    val effectiveUrl by viewModel.effectiveServerUrl.collectAsStateWithLifecycle()
    val errorState = viewModel.serverUrlError.collectAsStateWithLifecycle()
    var input by remember(serverUrl) { mutableStateOf(serverUrl) }

    PageTitle("Server")
    PageIntro(
        "Backend base URL. Must use https and overrides the build-time default. " +
            "Changes apply to the next network call."
    )
    BubbleCard(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(DesignTokens.LocalBingwaRoles.current.card)
                    .border(1.dp, if (errorState.value != null) DesignTokens.LocalBingwaRoles.current.error else DesignTokens.LocalBingwaRoles.current.border, RoundedCornerShape(16.dp))
                    .padding(horizontal = 14.dp, vertical = 13.dp)
            ) {
                BasicTextField(
                    value = input,
                    onValueChange = { input = it },
                    singleLine = true,
                    textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp),
                    cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
                    modifier = Modifier.fillMaxWidth()
                )
                if (input.isEmpty()) {
                    Text(
                        text = "https://api.example.com",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                        fontSize = 14.sp
                    )
                }
            }
            if (errorState.value != null) {
                Text(
                    text = errorState.value!!,
                    color = DesignTokens.LocalBingwaRoles.current.error,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 14.dp).padding(top = 6.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryButton(
                text = "Save",
                onClick = {
                    haptics.tick()
                    viewModel.setServerUrl(input.trim())
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            androidx.compose.material3.TextButton(onClick = {
                haptics.tick()
                input = serverUrl
                viewModel.resetServerUrl()
            }) {
                Text("Reset to default", color = DesignTokens.LocalBingwaRoles.current.brand, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Effective URL: $effectiveUrl",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }
    }
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
            Text(
                text = "DEV",
                color = DesignTokens.LocalBingwaRoles.current.bg,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clip(CircleShape).background(DesignTokens.LocalBingwaRoles.current.brand).padding(horizontal = 8.dp, vertical = 3.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Test Drive",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Phone, payer name and amount become a fake \"received from\" SMS. The engine matches an offer, dials, updates status and replies — exactly like a real payment.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.55f),
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
                text = it,
                color = if (simulateFailed) DesignTokens.LocalBingwaRoles.current.error else DesignTokens.LocalBingwaRoles.current.success,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun SimulateField(value: String, onValueChange: (String) -> Unit, hint: String) {
    val shape = RoundedCornerShape(16.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(DesignTokens.LocalBingwaRoles.current.card)
            .border(1.dp, DesignTokens.LocalBingwaRoles.current.border, shape)
            .padding(horizontal = 14.dp, vertical = 13.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 14.sp),
            cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isEmpty()) {
            Text(hint, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 14.sp)
        }
    }
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
        Text("Export", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Save all your app data to a JSON file in Bingwa Score/backups.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.55f),
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
        Text("Import", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Restore from a previously exported JSON backup. This clears current data first.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.55f),
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
            text = result,
            color = if (result.contains("successful") || result.contains("saved")) DesignTokens.LocalBingwaRoles.current.success else DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// __CHUNK5__

@Composable
private fun UpdateResultSheet(
    state: UpdateCheckState.Done,
    currentVersion: String,
    latestVersion: String?,
    downloadUrl: String?,
    changelog: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    GlassBottomSheet(
        visible = true,
        onDismiss = onDismiss
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp)
                .frostedGlass(shape = RoundedCornerShape(20.dp))
        ) {
            Text(
                text = if (state.upToDate) "You're up to date" else "Update available",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = DesignTokens.Typography.Subhead
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (state.upToDate) {
                    "Bingwa Score $currentVersion is the latest release."
                } else {
                    buildString {
                        append("Bingwa Score ")
                        append(latestVersion ?: "a newer build")
                        append(" is available. You are on ")
                        append(currentVersion)
                        append(".")
                        if (changelog.isNotBlank()) {
                            append("\n\n")
                            append(changelog)
                        }
                    }
                },
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                fontSize = DesignTokens.Typography.Body
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (state.upToDate) {
                PrimaryButton(text = "Close", onClick = onDismiss)
            } else {
                Column(modifier = Modifier.fillMaxWidth()) {
                    PrimaryButton(
                        text = "Download",
                        onClick = {
                            if (downloadUrl != null) {
                                UpdateDownloader.enqueue(context, downloadUrl)
                                try {
                                    context.startActivity(
                                        android.content.Intent(
                                            android.content.Intent.ACTION_VIEW,
                                            android.net.Uri.parse(downloadUrl)
                                        ).addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                                    )
                                } catch (_: Throwable) {
                                    Toast.makeText(context, "Could not open browser", Toast.LENGTH_SHORT).show()
                                }
                            }
                            onDismiss()
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    SecondaryButton(text = "Later", onClick = onDismiss)
                }
            }
        }
    }
}

@Composable
private fun AboutPage(viewModel: SettingsViewModel) {
    PageTitle("About")
    PageIntro("What Bingwa Score is and which build is installed.")
    BubbleCard(modifier = Modifier.fillMaxWidth()) {
        Text("Bingwa Score", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Version ${viewModel.appVersion}",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Bingwa Score helps airtime agents sell Safaricom bundles faster: one-tap dialing, " +
                "auto renewals, smart follow-up and commission tracking — all on your phone.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
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

/** One Showcase action row — the third affordance S3 asks for. */
@Composable
private fun ShowcaseActionRow(
    title: String,
    subtitle: String,
    enabled: Boolean,
    destructive: Boolean = false,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(subtitle, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f), fontSize = 12.sp)
            }
            if (destructive) {
                Text(
                    text = "Exit",
                    color = DesignTokens.LocalBingwaRoles.current.error,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

/**
 * SHOWCASE S1 — the switch that decides which database this install uses.
 *
 * The change cannot take effect live (Room has already opened a file), so the
 * dialog says so plainly and the restart is explicit.
 */
@Composable
private fun ShowcasePage() {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    var enabled by remember { mutableStateOf(DbNameHolder.showcaseMode) }
    var pendingRestart by remember { mutableStateOf<Boolean?>(null) }

    PageTitle("Showcase Mode")
    PageIntro(
        "Run the app on a separate demo database filled with realistic data and a " +
            "live simulator. Your real data is never touched."
    )

    GlassCard(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(18.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Demo data + live simulator",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = if (enabled) "On — using ${DbNameHolder.DEMO_DB}" else "Off — using ${DbNameHolder.REAL_DB}",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            PremiumToggle(
                checked = enabled,
                onCheckedChange = { value ->
                    haptics.tick()
                    enabled = value
                    ShowcaseController.setEnabled(context, value)
                    pendingRestart = value
                }
            )
        }
    }

    ShowcaseActionRow(
        title = "Reseed demo data",
        subtitle = "Wipe the demo database and rebuild it from scratch",
        enabled = enabled,
        onClick = {
            haptics.press()
            ShowcaseController.requestDemoReseed(context)
            pendingRestart = true
        }
    )

    ShowcaseActionRow(
        title = "Exit showcase",
        subtitle = "Leave the demo and go back to your own database",
        enabled = enabled,
        destructive = true,
        onClick = {
            haptics.press()
            enabled = false
            ShowcaseController.setEnabled(context, false)
            pendingRestart = false
        }
    )

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        text = "Demo traffic is generated on this device only: no USSD is dialled, no " +
            "SMS is sent, and nothing leaves the phone.",
        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
        fontSize = 12.sp
    )

    if (pendingRestart != null) {
        GlassDialog(
            visible = true,
            onDismiss = { pendingRestart = null },
            title = "Restart to apply",
            body = {
                Text(
                    text = "Showcase Mode switches to a different database, so Bingwa Score " +
                        "needs to restart before the change takes effect.",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            },
            dismissLabel = "Later",
            confirmLabel = "Restart now",
            onConfirm = { ShowcaseController.restart(context) }
        )
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
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(description, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.55f), fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            if (selected) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = "Selected",
                    tint = DesignTokens.LocalBingwaRoles.current.brand,
                    modifier = Modifier.size(22.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(DesignTokens.LocalBingwaRoles.current.card)
                )
            }
        }
    }
}
