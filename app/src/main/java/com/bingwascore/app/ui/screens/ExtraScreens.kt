package com.bingwascore.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PremiumPlaceholderScreen(
    title: String,
    icon: ImageVector,
    description: String,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(icon, contentDescription = null, tint = EmeraldGreen, modifier = Modifier.size(64.dp))
                Text(title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                Text(
                    description,
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        }
    }
}

@Composable
fun QuickDialScreen(onNavigateBack: () -> Unit) {
    PremiumPlaceholderScreen("Quick Dial", Icons.Default.Dialpad, "Dial any USSD code instantly with one tap. Coming online soon.", onNavigateBack)
}

@Composable
fun AutoRenewalsScreen(onNavigateBack: () -> Unit) {
    PremiumPlaceholderScreen("Auto Renewals", Icons.Default.Cached, "Automatically renew customer bundles before they expire.", onNavigateBack)
}

@Composable
fun SubscriptionsScreen(onNavigateBack: () -> Unit) {
    PremiumPlaceholderScreen("Subscriptions", Icons.Default.Subscriptions, "Manage recurring bundle subscriptions for your customers.", onNavigateBack)
}

@Composable
fun AutoRepliesScreen(onNavigateBack: () -> Unit) {
    PremiumPlaceholderScreen("Auto Replies", Icons.Default.Email, "Smart automatic replies to customer messages.", onNavigateBack)
}

@Composable
fun CommunityScreen(onNavigateBack: () -> Unit) {
    PremiumPlaceholderScreen("Community", Icons.Default.Group, "Share and download verified offers from the Bingwa community.", onNavigateBack)
}
