package com.bingwascore.app.ui.autoreplies

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.data.local.entity.AutoReplyEntity
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.domain.enums.AutoReplyType
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Orange500
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AutoRepliesViewModel @Inject constructor(
    private val autoReplyDao: AutoReplyDao,
    private val settingsRepository: SettingsRepository,
    val engageBot: EngageBotSessionLifecycle
) : ViewModel() {

    val replies: StateFlow<List<AutoReplyEntity>> = autoReplyDao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _botEnabled = MutableStateFlow(settingsRepository.getBoolean(AppSetting.ENGAGE_BOT_ACTIVE, false))
    val botEnabled: StateFlow<Boolean> = _botEnabled.asStateFlow()

    init {
        viewModelScope.launch { if (autoReplyDao.getAll().first().isEmpty()) seed() }
    }

    fun toggleBot(enabled: Boolean) {
        _botEnabled.value = enabled
        settingsRepository.saveBoolean(AppSetting.ENGAGE_BOT_ACTIVE, enabled)
    }

    fun toggle(reply: AutoReplyEntity) {
        viewModelScope.launch { autoReplyDao.update(reply.copy(isActive = !reply.isActive)) }
    }

    fun updateMessage(reply: AutoReplyEntity, message: String) {
        viewModelScope.launch { autoReplyDao.update(reply.copy(message = message)) }
    }

    private suspend fun seed() {
        val defaults = listOf(
            Triple("Successful Response", "Hi <firstName>, Thank you for purchasing from Bingwa Score", AutoReplyType.SUCCESSFUL_RESPONSE),
            Triple("Offer Already Recommended", "Hello <firstName>, you have already purchased this offer today. Please try again tomorrow", AutoReplyType.OFFER_ALREADY_RECOMMENDED),
            Triple("Failed Request", "Hello <firstName>, Your request failed. Please hold as we look into the issue", AutoReplyType.FAILED_REQUEST),
            Triple("Unavailable Offer", "Hi <firstName>, there is no offer matching the amount you have paid. Please pay the correct amount", AutoReplyType.UNAVAILABLE_OFFER),
            Triple("App Paused", "Hi <firstName>, there is an issue affecting our systems. You will however get your offer as soon as we resume", AutoReplyType.APP_PAUSED),
            Triple("Customer Blacklisted", "Hi <firstName>, there is an issue affecting your account. Please reach out to us for assistance", AutoReplyType.CUSTOMER_BLACKLISTED)
        )
        defaults.forEach { (title, message, type) ->
            autoReplyDao.insert(AutoReplyEntity(title = title, message = message, type = type.name, isActive = type == AutoReplyType.SUCCESSFUL_RESPONSE))
        }
    }
}

private fun triggerFor(type: String): String = when (type) {
    AutoReplyType.SUCCESSFUL_RESPONSE.name -> "Sent when a transaction completes"
    AutoReplyType.OFFER_ALREADY_RECOMMENDED.name -> "When customer pays again for same offer (bot off)"
    AutoReplyType.FAILED_REQUEST.name -> "When USSD dial fails"
    AutoReplyType.UNAVAILABLE_OFFER.name -> "When payment matches no offer"
    AutoReplyType.APP_PAUSED.name -> "When payment arrives while app paused"
    AutoReplyType.CUSTOMER_BLACKLISTED.name -> "When blacklisted customer pays"
    else -> "Manual"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoRepliesScreen(onNavigateBack: () -> Unit) {
    val vm: AutoRepliesViewModel = hiltViewModel()
    val replies by vm.replies.collectAsState()
    val botEnabled by vm.botEnabled.collectAsState()
    val logs by vm.engageBot.logs.collectAsState()
    var editing by remember { mutableStateOf<AutoReplyEntity?>(null) }
    var draft by remember { mutableStateOf("") }
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Botted Replies", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Engage Bot", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            Text("When a customer pays twice, bot asks for an alternative number and redirects the offer. Sessions last 10 minutes.", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
                        }
                        Switch(checked = botEnabled, onCheckedChange = { vm.toggleBot(it) }, colors = SwitchDefaults.colors(checkedTrackColor = EmeraldGreen))
                    }
                }
            }

            item { Text("Reply Templates", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp) }

            items(replies) { reply ->
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(MaterialTheme.colorScheme.surfaceVariant).clickable { editing = reply; draft = reply.message }.padding(16.dp)) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(reply.title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, modifier = Modifier.weight(1f))
                            Switch(checked = reply.isActive, onCheckedChange = { vm.toggle(reply) })
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(triggerFor(reply.type), color = Orange500, fontSize = 11.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(reply.message, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                    }
                }
            }

            item { Text("Bot Activity", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp) }

            if (logs.isEmpty()) {
                item { Text("No bot conversations yet.", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp) }
            }

            items(logs) { log ->
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(12.dp)) {
                    Column {
                        Row {
                            Text(log.customerName ?: log.phone, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, modifier = Modifier.weight(1f))
                            Text(timeFormat.format(Date(log.time)), color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
                        }
                        log.received?.let { Text("Customer: $it", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp) }
                        Text("Bot sent: ${log.sent}", color = EmeraldGreen, fontSize = 12.sp)
                    }
                }
            }
            item { Spacer(Modifier.height(60.dp)) }
        }

        editing?.let { reply ->
            Dialog(onDismissRequest = { editing = null }) {
                Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surface).padding(20.dp)) {
                    Text(reply.title, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(value = draft, onValueChange = { draft = it }, label = { Text("Message") }, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                    Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.primary).clickable { vm.updateMessage(reply, draft); editing = null }.padding(12.dp), contentAlignment = Alignment.Center) {
                        Text("Save", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
