package com.bingwascore.app.ui.offers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.domain.engine.OfferSignature
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.ui.theme.EmeraldGreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferSettingsViewModel @Inject constructor(
    private val offerDao: OfferDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val offerId: String = savedStateHandle.get<String>("offerId") ?: ""
    private val _offer = MutableStateFlow<Offer?>(null)
    val offer: StateFlow<Offer?> = _offer.asStateFlow()

    init {
        viewModelScope.launch { _offer.value = offerDao.getOfferById(offerId) }
    }

    fun update(transform: (Offer) -> Offer) {
        viewModelScope.launch {
            val current = _offer.value ?: return@launch
            val next = transform(current)
            offerDao.updateOffer(next.copy(updatedAt = System.currentTimeMillis()))
            _offer.value = next
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferSettingsScreen(offerId: String, onNavigateBack: () -> Unit) {
    val vm: OfferSettingsViewModel = hiltViewModel()
    val offer by vm.offer.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Offer Settings", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        val o = offer
        if (o == null) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) { Text("Loading offer...") }
        } else {
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(o.name, color = EmeraldGreen, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(o.ussdCode, color = MaterialTheme.colorScheme.onSurfaceVariant, fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace, fontSize = 13.sp)

                ToggleRow("Auto Reschedule", "Re-run at ${o.autoRescheduleRunTime} next day if already recommended", o.autoReschedule) {
                    vm.update { it.copy(autoReschedule = it.autoReschedule.not()) }
                }

                StepperRow("USSD Timeout", "${o.ussdTimeoutMillis / 1000}s", {
                    vm.update { it.copy(ussdTimeoutMillis = (it.ussdTimeoutMillis - 5000).coerceAtLeast(10000)) }
                }, {
                    vm.update { it.copy(ussdTimeoutMillis = (it.ussdTimeoutMillis + 5000).coerceAtMost(120000)) }
                })

                ToggleRow("Auto Retry", "Retry failed requests automatically", o.autoRetry) {
                    vm.update { it.copy(autoRetry = it.autoRetry.not()) }
                }

                StepperRow("Retries", "${o.numberOfRetries}", {
                    vm.update { it.copy(numberOfRetries = (it.numberOfRetries - 1).coerceAtLeast(0)) }
                }, {
                    vm.update { it.copy(numberOfRetries = (it.numberOfRetries + 1).coerceAtMost(5)) }
                })

                StepperRow("Retry Interval", "${o.retryIntervalMins}min", {
                    vm.update { it.copy(retryIntervalMins = (it.retryIntervalMins - 1).coerceAtLeast(1)) }
                }, {
                    vm.update { it.copy(retryIntervalMins = (it.retryIntervalMins + 1).coerceAtMost(30)) }
                })

                ToggleRow("Auto Retry Connection Problems", "Retry when network drops", o.autoRetryConnectionProblems) {
                    vm.update { it.copy(autoRetryConnectionProblems = it.autoRetryConnectionProblems.not()) }
                }

                val canStrict = OfferSignature.canEnableStrictMode(o.completionMessage) || OfferSignature.isBingwaOffer(o.ussdCode)
                ToggleRow("Strict Mode", if (canStrict) "Wait for completion message before success" else "Requires a completion message with @phone", o.strictMode && canStrict) {
                    if (canStrict) vm.update { it.copy(strictMode = it.strictMode.not()) }
                }

                OutlinedTextField(
                    value = o.completionMessage ?: "",
                    onValueChange = { msg -> vm.update { it.copy(completionMessage = msg.ifBlank { null }) } },
                    label = { Text("Completion message (@phone placeholder)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                )
            }
        }
    }
}

@Composable
private fun ToggleRow(title: String, subtitle: String, checked: Boolean, onToggle: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Text(subtitle, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
            }
            Switch(checked = checked, onCheckedChange = { onToggle() })
        }
    }
}

@Composable
private fun StepperRow(title: String, value: String, onMinus: () -> Unit, onPlus: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, modifier = Modifier.weight(1f))
            IconButton(onClick = onMinus) { Icon(Icons.Default.Remove, null, tint = EmeraldGreen) }
            Text(value, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, modifier = Modifier.width(64.dp), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            IconButton(onClick = onPlus) { Icon(Icons.Default.Add, null, tint = EmeraldGreen) }
        }
    }
}
