package com.bingwascore.app.ui.admin

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.Sp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.Purple500

@Composable
fun AdminScreen(
    viewModel: AdminViewModel,
    onLogout: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Header
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Purple500)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "ADMIN CONSOLE",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = TextUnit(1.5f, Sp)
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                "Command center",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
        }

        // Success / error banners
        state.successMessage?.let {
            Banner(it, isError = false, onDismiss = { viewModel.clearMessages() })
        }
        state.error?.let {
            Banner(it, isError = true, onDismiss = { viewModel.clearMessages() })
        }

        // Tabs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AdminTab("dashboard", "📊", state.activeTab) { viewModel.setTab(it) }
            AdminTab("bundles", "📦", state.activeTab) { viewModel.setTab(it) }
            AdminTab("orders", "🧾", state.activeTab) { viewModel.setTab(it) }
            AdminTab("users", "👥", state.activeTab) { viewModel.setTab(it) }
        }

        // Content
        when (state.activeTab) {
            "dashboard" -> AdminDashboardTab(state)
            "bundles" -> AdminBundlesTab(state, viewModel)
            "orders" -> AdminOrdersTab(state, viewModel)
            "users" -> AdminUsersTab(state)
        }

        // Logout
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.error.copy(alpha = 0.1f))
                .clickable {
                    viewModel.logout()
                    onLogout()
                }
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Logout,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Sign out",
                    color = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun AdminTab(id: String, emoji: String, active: String, onClick: (String) -> Unit) {
    val isActive = active == id
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(14.dp))
            .background(
                if (isActive) MaterialTheme.colorScheme.onSurface
                else MaterialTheme.colorScheme.surface
            )
            .clickable { onClick(id) }
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            emoji,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun Banner(message: String, isError: Boolean, onDismiss: () -> Unit) {
    val color = if (isError) MaterialTheme.colorScheme.error
    else com.bingwascore.app.ui.theme.Emerald500
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color.copy(alpha = 0.1f))
            .clickable { onDismiss() }
            .padding(12.dp)
    ) {
        Text(message, color = color, style = MaterialTheme.typography.bodyMedium)
    }
}
