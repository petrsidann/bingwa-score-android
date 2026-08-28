package com.bingwascore.app.ui.mystore

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Store
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.SiteLinkDao
import com.bingwascore.app.domain.sitelink.SiteLinkManager
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyStoreViewModel @Inject constructor(
    private val siteLinkDao: SiteLinkDao,
    private val siteLinkManager: SiteLinkManager
) : ViewModel() {

    val siteLink = siteLinkDao.getMySiteLink()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun createStore(name: String) {
        viewModelScope.launch { siteLinkManager.getOrCreate(name) }
    }

    fun setActive(active: Boolean) {
        viewModelScope.launch { siteLinkManager.setActive(active) }
    }

    fun deleteStore() {
        viewModelScope.launch { siteLinkManager.delete() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStoreScreen(onNavigateBack: () -> Unit) {
    val vm: MyStoreViewModel = hiltViewModel()
    val siteLink by vm.siteLink.collectAsState()
    var name by remember { mutableStateOf("") }
    val onSurface = MaterialTheme.colorScheme.onSurface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("My Store", color = onSurface, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = onSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Create your personal online store. Customers open your link, pick an offer and pay via M-Pesa. Payments are auto-detected and processed.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 13.sp
            )

            if (siteLink == null) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Store name") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(EmeraldGreen)
                        .clickable { if (name.isNotBlank()) vm.createStore(name) },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Create My Store", color = Color.White, fontWeight = FontWeight.Bold)
                }
            } else {
                val link = siteLink!!
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(16.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Store, null, tint = EmeraldGreen)
                            Spacer(Modifier.width(10.dp))
                            Text(link.siteName, color = onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(Modifier.weight(1f))
                            Switch(checked = link.isActive, onCheckedChange = { vm.setActive(it) })
                        }
                        Spacer(Modifier.height(10.dp))
                        Text(link.siteLinkURL, color = EmeraldGreen, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Spacer(Modifier.height(10.dp))
                        Row {
                            Text(
                                "Account: ${link.accountType} ${link.accountNumber}",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { vm.deleteStore() }) {
                                Icon(Icons.Default.Delete, null, tint = ErrorRed)
                            }
                        }
                    }
                }
            }
        }
    }
}
