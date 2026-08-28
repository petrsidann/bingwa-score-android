package com.bingwascore.app.ui.authorizedsenders

import android.content.Context
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed

class AuthorizedSendersStore(context: Context) {
    private val prefs = context.getSharedPreferences("authorized_senders", Context.MODE_PRIVATE)

    fun getAll(): List<String> =
        prefs.getStringSet("senders", emptySet())?.toList()?.sorted() ?: emptyList()

    fun add(phone: String) {
        val current = getAll().toMutableSet()
        current.add(phone)
        prefs.edit().putStringSet("senders", current).apply()
    }

    fun remove(phone: String) {
        val current = getAll().toMutableSet()
        current.remove(phone)
        prefs.edit().putStringSet("senders", current).apply()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizedSendersScreen(
    onNavigateBack: () -> Unit,
    store: AuthorizedSendersStore
) {
    var senders by remember { mutableStateOf(store.getAll()) }
    var phone by remember { mutableStateOf("") }
    val onSurface = MaterialTheme.colorScheme.onSurface

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Authorized Senders", color = onSurface, fontWeight = FontWeight.Bold) },
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
            modifier = Modifier.fillMaxSize().padding(padding).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "M-Pesa messages from these senders are always trusted and processed.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 13.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it.filter { c -> c.isDigit() } },
                    label = { Text("Sender number") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        if (phone.length >= 10) {
                            store.add(phone)
                            senders = store.getAll()
                            phone = ""
                        }
                    }
                ) {
                    Icon(Icons.Default.Add, null, tint = EmeraldGreen)
                }
            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(senders) { sender ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(sender, color = onSurface, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                            IconButton(onClick = {
                                store.remove(sender)
                                senders = store.getAll()
                            }) {
                                Icon(Icons.Default.Delete, null, tint = ErrorRed)
                            }
                        }
                    }
                }
            }
        }
    }
}
