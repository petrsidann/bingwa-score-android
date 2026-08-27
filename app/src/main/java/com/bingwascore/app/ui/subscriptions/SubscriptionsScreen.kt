package com.bingwascore.app.ui.subscriptions

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.TealBlue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _endsAt = MutableStateFlow(settingsRepository.getLong(AppSetting.SUBSCRIPTION_ENDS_AT))
    val endsAt: StateFlow<Long> = _endsAt.asStateFlow()

    fun activate(durationMs: Long) {
        viewModelScope.launch {
            val base = maxOf(System.currentTimeMillis(), _endsAt.value)
            val next = base + durationMs
            settingsRepository.saveLong(AppSetting.SUBSCRIPTION_ENDS_AT, next)
            _endsAt.value = next
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionsScreen(onNavigateBack: () -> Unit) {
    val vm: SubscriptionsViewModel = hiltViewModel()
    val endsAt by vm.endsAt.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Subscriptions", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(TealBlue.copy(alpha = 0.14f)).padding(16.dp)) {
                Column {
                    Text("Engine Subscription", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(if (endsAt > System.currentTimeMillis()) "${(endsAt - System.currentTimeMillis()) / 86400000}d remaining" else "No active subscription", color = TealBlue, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                }
            }
            PlanCard("Daily Subscription", "KES 30", "Unlimited processing for 1 day") { vm.activate(86_400_000L) }
            PlanCard("1 Week Subscription", "KES 200", "Unlimited processing for 1 week") { vm.activate(7 * 86_400_000L) }
            PlanCard("1 Month Subscription", "KES 900", "Unlimited processing for 1 month") { vm.activate(30 * 86_400_000L) }
            PlanCard("300 USSD Requests", "KES 50", "One-time bundle of 300 USSD requests") { vm.activate(30 * 86_400_000L) }
        }
    }
}

@Composable
private fun PlanCard(title: String, price: String, subtitle: String, onActivate: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(MaterialTheme.colorScheme.surfaceVariant).clickable { onActivate() }.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                Spacer(Modifier.height(4.dp))
                Text(subtitle, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
            }
            Spacer(Modifier.width(12.dp))
            Text(price, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
    }
}
