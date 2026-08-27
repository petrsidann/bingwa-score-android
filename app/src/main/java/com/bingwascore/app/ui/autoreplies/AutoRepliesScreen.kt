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
import com.bingwascore.app.domain.enums.AutoReplyType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutoRepliesViewModel @Inject constructor(
    private val autoReplyDao: AutoReplyDao
) : ViewModel() {
    val replies: StateFlow<List<AutoReplyEntity>> = autoReplyDao.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            if (autoReplyDao.getAll().first().isEmpty()) seed()
        }
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

    fun toggle(reply: AutoReplyEntity) { viewModelScope.launch { autoReplyDao.update(reply.copy(isActive = !reply.isActive)) } }
    fun updateMessage(reply: AutoReplyEntity, message: String) { viewModelScope.launch { autoReplyDao.update(reply.copy(message = message)) } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoRepliesScreen(onNavigateBack: () -> Unit) {
    val vm: AutoRepliesViewModel = hiltViewModel()
    val replies by vm.replies.collectAsState()
    var editing by remember { mutableStateOf<AutoReplyEntity?>(null) }
    var draft by remember { mutableStateOf("") }

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
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(replies) { reply ->
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(MaterialTheme.colorScheme.surfaceVariant).clickable { editing = reply; draft = reply.message }.padding(16.dp)) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(reply.title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 15.sp, modifier = Modifier.weight(1f))
                            Switch(checked = reply.isActive, onCheckedChange = { vm.toggle(reply) })
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(reply.message, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                    }
                }
            }
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
