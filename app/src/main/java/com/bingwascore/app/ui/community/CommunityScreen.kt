package com.bingwascore.app.ui.community

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Verified
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.domain.engine.OfferSignature
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferType
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.Orange500
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

data class PresetOffer(val name: String, val ussd: String, val price: Int, val type: OfferType)

object OfferPresets {
    val all: List<PresetOffer> = listOf(
        PresetOffer("250Mbs, 24hrs!", "*180*5*2#", 20, OfferType.DATA),
        PresetOffer("750MBs+50SMS, 24Hrs", "*180*5*2#", 55, OfferType.DATA),
        PresetOffer("1GB, 1Hr", "*180*5*2*BH*1*1#", 19, OfferType.DATA),
        PresetOffer("1.5GB, 24Hrs", "*180*5*2#", 99, OfferType.DATA),
        PresetOffer("250MBS, 24Hrs Multiple", "*544*1*1*1*6*BH*3*1#", 24, OfferType.DATA),
        PresetOffer("750Mbs, Multiple", "*544*1*1*1*6*BH*2*1#", 58, OfferType.DATA),
        PresetOffer("1.5GB, 24Hrs - Multiple", "*544*1*1*1*6*BH*1*1#", 102, OfferType.DATA),
        PresetOffer("400MBs, 7Days", "*180*5*2#", 49, OfferType.DATA),
        PresetOffer("20 SMS Daily", "*188#", 5, OfferType.SMS),
        PresetOffer("45Mins - 3Hrs", "*444#", 22, OfferType.MINUTES),
        PresetOffer("50Mins till Midnight", "*444#", 51, OfferType.MINUTES),
        PresetOffer("300Mins Monthly", "*180#", 500, OfferType.MINUTES)
    )
}

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val offerDao: OfferDao
) : ViewModel() {
    val offers: StateFlow<List<Offer>> = offerDao.getAllOffers().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun isAdded(preset: PresetOffer): Boolean = offers.value.any { it.ussdCode == preset.ussd && it.name == preset.name }

    fun download(preset: PresetOffer) {
        viewModelScope.launch {
            if (isAdded(preset)) return@launch
            offerDao.insertOffer(Offer(id = UUID.randomUUID().toString(), name = preset.name, ussdCode = preset.ussd, price = preset.price, type = preset.type, isVerified = OfferSignature.isBingwaOffer(preset.ussd), isActive = true))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(onNavigateBack: () -> Unit) {
    val vm: CommunityViewModel = hiltViewModel()
    val presets = OfferPresets.all

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Intelligent USSD", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(presets) { preset ->
                val verified = OfferSignature.isBingwaOffer(preset.ussd)
                val added = vm.isAdded(preset)
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Language, null, tint = EmeraldGreen, modifier = Modifier.size(22.dp))
                        Spacer(Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(preset.name, color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Spacer(Modifier.width(6.dp))
                                if (verified) Icon(Icons.Default.Verified, null, tint = EmeraldGreen, modifier = Modifier.size(16.dp)) else Icon(Icons.Default.Lock, null, tint = Orange500, modifier = Modifier.size(14.dp))
                            }
                            Text(preset.ussd, color = MaterialTheme.colorScheme.onSurfaceVariant, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        Text("KES ${preset.price}", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        IconButton(onClick = { vm.download(preset) }, enabled = !added) { Icon(Icons.Default.Download, null, tint = if (added) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f) else EmeraldGreen) }
                    }
                }
            }
        }
    }
}
