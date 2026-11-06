package com.bingwascore.app.ui.autoreplies

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SmartToy
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.ui.engagebot.BotLogRow
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.settings.PremiumToggle
import com.bingwascore.app.ui.theme.DesignTokens
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Stage 53 — Smart Follow-Up as an automation dashboard. Templates render as
 * tactile GlassCard automation cards (icon, title, reused PremiumToggle).
 * Toggling a rule off fades its content to 0.5 alpha. ViewModel and data
 * fetching are untouched — only UI composition changed.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoRepliesScreen(viewModel: AutoRepliesViewModel = hiltViewModel()) {
    val templates by viewModel.templates.collectAsStateWithLifecycle()
    val engageBotActive by viewModel.engageBotActive.collectAsStateWithLifecycle()
    val botLogs by viewModel.botLogs.collectAsStateWithLifecycle()
    var editing by remember { mutableStateOf<AutoReply?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.Color.Bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(
                "Smart Follow-Up",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold
            )
            Text(
                "${templates.size} template(s)",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Caption
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

        EngageBotRow(
            active = engageBotActive,
            onToggle = { viewModel.setEngageBotActive(it) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (templates.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                AutomationEmptyState()
            }
        } else {
            Text(
                "Templates",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(templates, key = { _, template -> template.id }) { index, template ->
                    TemplateCard(
                        template = template,
                        onToggle = { viewModel.toggleTemplate(template) },
                        onEdit = { editing = template }
                    )
                }
            }
        }

        if (botLogs.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Bot Activity",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
            ) {
                val recentLogs = botLogs.take(20)
                itemsIndexed(recentLogs, key = { _, log -> log.id }) { _, log ->
                    BotLogRow(log = log)
                }
            }
        }
    }

    editing?.let { template ->
        EditTemplateDialog(
            template = template,
            onDismiss = { editing = null },
            onSave = {
                viewModel.saveTemplate(it)
                editing = null
            }
        )
    }
}

@Composable
private fun AutomationEmptyState() {
    GlassCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.SmartToy,
                contentDescription = null,
                tint = DesignTokens.Color.Brand.Primary.copy(alpha = 0.2f),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "No automations yet",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Create follow-up templates to engage customers after every sale.",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Caption
            )
        }
    }
}

@Composable
private fun EngageBotRow(active: Boolean, onToggle: (Boolean) -> Unit) {
    GlassCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Engage Bot",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    if (active) {
                        "On — customers are engaged after every sale"
                    } else {
                        "Off — no engage messages will be sent"
                    },
                    color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            PremiumToggle(checked = active, onCheckedChange = onToggle)
        }
    }
}

@Composable
private fun TemplateCard(
    template: AutoReply,
    onToggle: () -> Unit,
    onEdit: () -> Unit
) {
    val active = template.isActive
    val contentAlpha by animateFloatAsState(
        targetValue = if (active) 1f else 0.5f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "TemplateCardAlpha"
    )

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { alpha = contentAlpha }
            .clickable(onClick = onEdit)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.SmartToy,
                    contentDescription = null,
                    tint = DesignTokens.Color.Brand.Primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        template.title,
                        color = DesignTokens.Color.Ink,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                PremiumToggle(checked = active, onCheckedChange = { onToggle() })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                template.message,
                color = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                fontSize = DesignTokens.Typography.Caption,
                maxLines = 2
            )
        }
    }
}

@Composable
private fun EditTemplateDialog(
    template: AutoReply,
    onDismiss: () -> Unit,
    onSave: (AutoReply) -> Unit
) {
    var title by remember { mutableStateOf(template.title) }
    var message by remember { mutableStateOf(template.message) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = DesignTokens.Color.Card,
        title = {
            Text("Edit template", color = DesignTokens.Color.Ink, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        },
        text = {
            Column {
                DialogField(label = "Trigger label", value = title, onValueChange = { title = it })
                Spacer(modifier = Modifier.height(4.dp))
                DialogField(label = "Message", value = message, onValueChange = { message = it })
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onSave(template.copy(title = title.trim(), message = message.trim())) },
                enabled = title.isNotBlank() && message.isNotBlank()
            ) {
                Text("Save", color = DesignTokens.Color.Brand.Primary, fontWeight = FontWeight.SemiBold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = DesignTokens.Color.Ink.copy(alpha = 0.6f))
            }
        }
    )
}

@Composable
private fun DialogField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = DesignTokens.Color.Ink.copy(alpha = 0.55f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        val shape = RoundedCornerShape(12.dp)
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(DesignTokens.Color.Card.copy(alpha = 0.08f))
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(color = DesignTokens.Color.Ink, fontSize = 14.sp),
                cursorBrush = SolidColor(DesignTokens.Color.Brand.Primary),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
