package com.bingwascore.app.ui.autoreplies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.engagebot.BotLog
import com.bingwascore.app.engagebot.BotLogKind
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** "Botted Replies": Engage Bot switch, reply templates and bot activity. */
@Composable
fun AutoRepliesScreen(viewModel: AutoRepliesViewModel = hiltViewModel()) {
    val templates by viewModel.templates.collectAsStateWithLifecycle()
    val engageBotActive by viewModel.engageBotActive.collectAsStateWithLifecycle()
    val botLogs by viewModel.botLogs.collectAsStateWithLifecycle()
    var editing by remember { mutableStateOf<AutoReply?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Botted Replies", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${templates.size} template(s)",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                "Engage Bot",
                                color = White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                if (engageBotActive) {
                                    "On — customers are engaged after every sale"
                                } else {
                                    "Off — no engage messages will be sent"
                                },
                                color = White.copy(alpha = 0.5f),
                                fontSize = 11.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Switch(
                            checked = engageBotActive,
                            onCheckedChange = { viewModel.setEngageBotActive(it) },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = NightBlack,
                                checkedTrackColor = EmeraldGreen,
                                checkedBorderColor = EmeraldGreen,
                                uncheckedThumbColor = White.copy(alpha = 0.7f),
                                uncheckedTrackColor = Color(0x22FFFFFF),
                                uncheckedBorderColor = Color(0x33FFFFFF)
                            )
                        )
                    }
                }
            }

            item {
                Text(
                    "Templates",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            items(templates, key = { it.id }) { template ->
                TemplateCard(
                    template = template,
                    onToggle = { viewModel.toggleTemplate(template) },
                    onEdit = { editing = template }
                )
            }

            if (botLogs.isNotEmpty()) {
                item {
                    Text(
                        "Bot Activity",
                        color = White.copy(alpha = 0.5f),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                items(botLogs.take(20), key = { it.id }) { log ->
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
private fun TemplateCard(template: AutoReply, onToggle: () -> Unit, onEdit: () -> Unit) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onEdit)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        template.title,
                        color = White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        template.type.replace('_', ' ').lowercase()
                            .replaceFirstChar { it.uppercase() },
                        color = TealBlue,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0x14FFFFFF))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    template.message,
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    maxLines = 2
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = template.isActive,
                onCheckedChange = { onToggle() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = NightBlack,
                    checkedTrackColor = EmeraldGreen,
                    checkedBorderColor = EmeraldGreen,
                    uncheckedThumbColor = White.copy(alpha = 0.7f),
                    uncheckedTrackColor = Color(0x22FFFFFF),
                    uncheckedBorderColor = Color(0x33FFFFFF)
                )
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
        containerColor = SurfaceDark,
        title = {
            Text("Edit template", color = White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
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
                Text("Save", color = EmeraldGreen, fontWeight = FontWeight.SemiBold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = White.copy(alpha = 0.6f))
            }
        }
    )
}

@Composable
private fun DialogField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = White.copy(alpha = 0.55f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        val shape = RoundedCornerShape(12.dp)
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Color(0x14FFFFFF))
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(color = White, fontSize = 14.sp),
                cursorBrush = SolidColor(EmeraldGreen),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun BotLogRow(log: BotLog) {
    val timeFormat = remember { SimpleDateFormat("HH:mm:ss", Locale.getDefault()) }
    val kindColor = when (log.kind) {
        BotLogKind.ENGAGE -> TealBlue
        BotLogKind.SUCCESS -> EmeraldGreen
        BotLogKind.INVALID -> Orange500
        BotLogKind.ERROR -> ErrorRed
        BotLogKind.INFO -> White.copy(alpha = 0.5f)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(kindColor)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(log.message, color = White.copy(alpha = 0.85f), fontSize = 12.sp)
            Text(
                timeFormat.format(Date(log.timestamp)),
                color = White.copy(alpha = 0.4f),
                fontSize = 10.sp
            )
        }
    }
}


