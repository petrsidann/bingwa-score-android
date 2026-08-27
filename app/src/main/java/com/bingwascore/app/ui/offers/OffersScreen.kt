package com.bingwascore.app.ui.offers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bingwascore.app.domain.model.Offer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersScreen(
    onNavigateToOfferSettings: (String) -> Unit,
    viewModel: OffersViewModel = hiltViewModel()
) {
    val offers by viewModel.offers.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("My Offers") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(offers) { offer ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(offer.name, style = MaterialTheme.typography.titleMedium)
                            Text(offer.ussdCode, style = MaterialTheme.typography.bodyMedium)
                            Text("KES ${offer.price}", color = MaterialTheme.colorScheme.primary)
                        }
                        
                        IconButton(onClick = { onNavigateToOfferSettings(offer.id) }) {
                            Icon(Icons.Default.Settings, contentDescription = "Settings")
                        }
                        
                        Switch(
                            checked = offer.isActive,
                            onCheckedChange = { viewModel.toggleOfferActive(offer) }
                        )
                    }
                }
            }
        }
    }
}
