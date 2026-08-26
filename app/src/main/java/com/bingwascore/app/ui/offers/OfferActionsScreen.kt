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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.OfferTransitionRuleDao
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferTransitionRule
import com.bingwascore.app.domain.model.TransactionStatus
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Orange500
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferActionsViewModel @Inject constructor(
    private val ruleDao: OfferTransitionRuleDao,
    private val offerDao: OfferDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val offerId: String = savedStateHandle.get<String>("offerId") ?: ""

    private val _tab = MutableStateFlow(TransactionStatus.FAILED_ALREADY_RECOMMENDED.name)
    val tab: StateFlow<String> = _tab.asStateFlow()

    private val _rules = MutableStateFlow<List<OfferTransitionRule>>(emptyList())
    val rules: StateFlow<List<OfferTransitionRule>> = _rules.asStateFlow()

    private val _offers = MutableStateFlow<List<Offer>>(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    init { reload() }

    fun setTab(t: String) { _tab.value = t; reload() }

    fun reload() {
        viewModelScope.launch {
            _rules.value = ruleDao.getRulesFor(offerId, _tab.value)
            _offers.value = offerDao.getAllOffers().let { flow ->
                var list = emptyList<Offer>()
                flow.collect { list = it }
                list
            }
        }
    }

    fun addRule(nextOfferId: String) {
        viewModelScope.launch {
            ruleDao.insertRule(
                OfferTransitionRule(
                    sourceOfferId = offerId,
                    sourceStatus = _tab.value,
                    nextOfferId = nextOfferId,
                    priority = _rules.value.size
                )
            )
            reload()
        }
    }

    fun deleteRule(id: String) {
        viewModelScope.launch { ruleDao.deleteRule(id); reload() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferActionsScreen(offerId: String, onNavigateBack: () -> Unit) {
    val vm: OfferActionsViewModel = hiltViewModel()
    val tab by vm.tab.collectAsState()
    val rules by vm.rules.collectAsState()
    val offers by vm.offers.collectAsState()
    var showAdd by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Offer Actions", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onSurface) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAdd = true }, containerColor = EmeraldGreen) { Icon(Icons.Default.Add, null) }
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            LazyRow(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { TabChip("Already Recommended", TransactionStatus.FAILED_ALREADY_RECOMMENDED.name, tab, Orange500) { vm.setTab(it) } }
                item { TabChip("Failed", TransactionStatus.FAILED.name, tab, ErrorRed) { vm.setTab(it) } }
                item { TabChip("Successful", TransactionStatus.SUCCESSFUL.name, tab, EmeraldGreen) { vm.setTab(it) } }
            }

            LazyColumn(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(rules) { rule ->
                    val target = offers.firstOrNull { it.id == rule.nextOfferId }
                    Box(
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Then run: ${target?.name ?: "unknown offer"}", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text("Priority ${rule.priority}", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 11.sp)
                            }
                            IconButton(onClick = { vm.deleteRule(rule.id) }) { Icon(Icons.Default.Delete, null, tint = ErrorRed) }
                        }
                    }
                }
            }
        }

        if (showAdd) {
            AlertDialog(
                onDismissRequest = { showAdd = false },
                title = { Text("Add fallback offer") },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        offers.filter { it.id != offerId }.forEach { o ->
                            Box(
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant).clickable {
                                    vm.addRule(o.id); showAdd = false
                                }.padding(12.dp)
                            ) { Text(o.name, color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp) }
                        }
                    }
                },
                confirmButton = { TextButton(onClick = { showAdd = false }) { Text("Close") } }
            )
        }
    }
}

@Composable
private fun androidx.compose.foundation.lazy.LazyListScope.TabChip(
    label: String,
    value: String,
    current: String,
    tint: androidx.compose.ui.graphics.Color,
    onClick: (String) -> Unit
) {
    // no-op placeholder to keep structure; chips rendered below instead.
}

@Composable
private fun TabChip(label: String, value: String, current: String, tint: androidx.compose.ui.graphics.Color, onClick: (String) -> Unit) {
    val selected = current == value
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) tint.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick(value) }
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(label, color = if (selected) tint else MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
    }
}
