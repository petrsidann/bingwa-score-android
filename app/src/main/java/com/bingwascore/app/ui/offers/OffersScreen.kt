package com.bingwascore.app.ui.offers

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferType
import com.bingwascore.app.ui.theme.EmeraldGreen
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersScreen(
    viewModel: OffersViewModel,
    onNavigateBack: () -> Unit,
    onOpenOfferSettings: (String) -> Unit,
    onOpenOfferActions: (String) -> Unit
) {
    val allOffers by viewModel.offers.collectAsState()
    val filter by viewModel.filter.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    var editingOffer by remember { mutableStateOf<Offer?>(null) }

    val offers = when (filter) {
        "data" -> allOffers.filter { it.type == OfferType.DATA }
        "minutes" -> allOffers.filter { it.type == OfferType.MINUTES }
        "sms" -> allOffers.filter { it.type == OfferType.SMS }
        else -> allOffers
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("My Offers", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { editingOffer = null; showAddDialog = true }, containerColor = EmeraldGreen) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            LazyRow(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf("all" to "All", "data" to "Data", "minutes" to "Minutes", "sms" to "SMS")) { (id, label) ->
                    val active = filter == id
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (active) EmeraldGreen.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { viewModel.setFilter(id) }
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(label, color = if (active) EmeraldGreen else MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            LazyColumn(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(offers) { offer ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(16.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Language, null, tint = EmeraldGreen, modifier = Modifier.size(22.dp))
                                Spacer(Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(offer.name, color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                    Text("KES ${offer.price}", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }
                                Switch(checked = offer.isActive, onCheckedChange = { viewModel.toggleActive(offer) })
                            }
                            Spacer(Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    offer.ussdCode,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 12.sp,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(onClick = { onOpenOfferSettings(offer.id) }) {
                                    Icon(Icons.Default.Settings, null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(20.dp))
                                }
                                IconButton(onClick = { onOpenOfferActions(offer.id) }) {
                                    Icon(Icons.Default.SwapHoriz, null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(20.dp))
                                }
                            }
                        }
                    }
                }
            }
        }

        if (showAddDialog) {
            OfferDialog(
                editing = editingOffer,
                onDismiss = { showAddDialog = false },
                onSave = { name, ussd, price, type ->
                    val offer = Offer(
                        id = editingOffer?.id ?: UUID.randomUUID().toString(),
                        name = name,
                        ussdCode = ussd,
                        price = price,
                        type = type,
                        isActive = editingOffer?.isActive ?: true
                    )
                    viewModel.saveOffer(offer)
                    showAddDialog = false
                }
            )
        }
    }
}

@Composable
private fun OfferDialog(
    editing: Offer?,
    onDismiss: () -> Unit,
    onSave: (String, String, Int, OfferType) -> Unit
) {
    var name by remember { mutableStateOf(editing?.name ?: "") }
    var ussd by remember { mutableStateOf(editing?.ussdCode ?: "") }
    var price by remember { mutableStateOf(editing?.price?.toString() ?: "") }
    var type by remember { mutableStateOf(editing?.type ?: OfferType.DATA) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(20.dp)
        ) {
            Text(if (editing != null) "Edit Offer" else "New Offer", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Offer Name") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = ussd, onValueChange = { ussd = it }, label = { Text("USSD Code e.g. *180*5*2#") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = price, onValueChange = { price = it.filter { c -> c.isDigit() } }, label = { Text("Price (KES)") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf(OfferType.DATA, OfferType.MINUTES, OfferType.SMS).forEach { t ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (type == t) EmeraldGreen else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { type = t }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(t.name, color = if (type == t) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(EmeraldGreen)
                    .clickable {
                        val p = price.toIntOrNull() ?: 0
                        if (name.isNotBlank() && ussd.isNotBlank()) onSave(name, ussd, p, type)
                    }
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Save Offer", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold)
            }
        }
    }
}
