package com.bingwascore.app.ui.customers

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.intelligence.ChurnRisk
import com.bingwascore.app.domain.intelligence.CustomerProfile
import com.bingwascore.app.domain.intelligence.IntelligenceEngine
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.sms.SmsDispatcher
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Orange500
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    customerRepository: CustomerRepository,
    transactionRepository: TransactionRepository,
    private val offerRepository: OfferRepository,
    private val smsDispatcher: SmsDispatcher
) : ViewModel() {

    val profiles: StateFlow<List<CustomerProfile>> =
        combine(
            customerRepository.getAllCustomers(),
            transactionRepository.getAllTransactions()
        ) { customers, txs ->
            customers
                .map { IntelligenceEngine.profile(it, txs) }
                .sortedByDescending { it.churnRisk.ordinal }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val offers: StateFlow<List<Offer>> = offerRepository.getActiveOffers()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun sendReminder(profile: CustomerProfile, offerName: String) {
        viewModelScope.launch {
            smsDispatcher.send(
                destination = profile.phone,
                template = "Hi <firstName>, your <offerName> bundle is due for renewal. We've got you covered. - Bingwa Score",
                values = mapOf(
                    "firstName" to (profile.name?.split(" ")?.firstOrNull() ?: "customer"),
                    "offerName" to offerName
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomersScreen(onNavigateBack: () -> Unit) {
    val vm: CustomersViewModel = hiltViewModel()
    val profiles by vm.profiles.collectAsState()
    val offers by vm.offers.collectAsState()
    var selected by remember { mutableStateOf<CustomerProfile?>(null) }
    val onSurface = MaterialTheme.colorScheme.onSurface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("My Customers", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(profiles) { profile ->
                val (badge, tint) = when (profile.churnRisk) {
                    ChurnRisk.HIGH -> "High churn" to ErrorRed
                    ChurnRisk.LOW -> "At risk" to Orange500
                    else -> "Active" to EmeraldGreen
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable { selected = profile }
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(40.dp).clip(CircleShape).background(tint.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                (profile.name ?: profile.phone).take(1).uppercase(),
                                color = tint,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(profile.name ?: profile.phone, color = onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                            Text(
                                "${profile.purchases} buys - Ksh %.0f".format(profile.totalSpent),
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 12.sp
                            )
                        }
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(tint.copy(alpha = 0.15f)).padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(badge, color = tint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }

        selected?.let { profile ->
            val recommended = IntelligenceEngine.recommend(profile, offers)
            AlertDialog(
                onDismissRequest = { selected = null },
                title = { Text(profile.name ?: profile.phone) },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Favorite: ${profile.favoriteOffer ?: "-"}", fontSize = 13.sp)
                        Text("Last purchase: ${profile.daysSinceLast}d ago", fontSize = 13.sp)
                        Text("Recommended offer:", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Text(recommended.firstOrNull()?.name ?: "-", color = EmeraldGreen, fontWeight = FontWeight.Bold)
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        vm.sendReminder(profile, recommended.firstOrNull()?.name ?: profile.favoriteOffer ?: "bundle")
                        selected = null
                    }) { Text("Send reminder") }
                },
                dismissButton = {
                    TextButton(onClick = { selected = null }) { Text("Close") }
                }
            )
        }
    }
}
