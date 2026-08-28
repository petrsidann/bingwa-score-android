package com.bingwascore.app.ui.dialer

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.services.UssdAutomationService
import com.bingwascore.app.ui.theme.EmeraldGreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DialerViewModel @Inject constructor(
    offerRepository: OfferRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val offers: StateFlow<List<Offer>> = offerRepository.getActiveOffers()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun dial(context: Context, phone: String, offer: Offer, onResult: (String) -> Unit) {
        viewModelScope.launch {
            if (phone.length < 10) { onResult("Enter a valid customer phone number"); return@launch }
            val code = offer.ussdCode.replace("ph", phone).replace("BH", phone, ignoreCase = true)
            val tx = Transaction(
                id = UUID.randomUUID().toString(),
                phoneNumber = phone,
                customerName = null,
                offerId = offer.id,
                offerName = offer.name,
                ussdCode = code,
                amount = offer.price.toDouble(),
                status = TransactionStatus.PENDING
            )
            transactionRepository.insertTransaction(tx)
            context.startService(Intent(context, UssdAutomationService::class.java).apply {
                putExtra("USSD_CODE", code)
                putExtra("TRANSACTION_ID", tx.id)
                putExtra("CUSTOMER_PHONE", phone)
            })
            onResult("Dialing ${offer.name} for $phone (SIM 1)")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DialerScreen(onNavigateBack: () -> Unit) {
    val vm: DialerViewModel = hiltViewModel()
    val context = LocalContext.current
    val offers by vm.offers.collectAsState()
    var phone by remember { mutableStateOf("") }
    var selectedOffer by remember { mutableStateOf<Offer?>(null) }
    var feedback by remember { mutableStateOf("") }
    val onSurface = MaterialTheme.colorScheme.onSurface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Dialer", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it.filter { c -> c.isDigit() } },
                label = { Text("Customer phone") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )
            Text("Select offer", color = onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                offers.forEach { offer ->
                    val isSelected = selectedOffer?.id == offer.id
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isSelected) EmeraldGreen.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { selectedOffer = offer }
                            .padding(horizontal = 14.dp, vertical = 10.dp)
                    ) {
                        Text("${offer.name} - K${offer.price}", color = if (isSelected) EmeraldGreen else MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(16.dp)).background(EmeraldGreen)
                    .clickable {
                        selectedOffer?.let { o -> vm.dial(context, phone, o) { feedback = it } }
                            ?: run { feedback = "Select an offer first" }
                    },
                contentAlignment = Alignment.Center
            ) { Text("Dial Now", color = Color.White, fontWeight = FontWeight.Bold) }
            if (feedback.isNotEmpty()) Text(feedback, color = EmeraldGreen, fontSize = 13.sp)
        }
    }
}
