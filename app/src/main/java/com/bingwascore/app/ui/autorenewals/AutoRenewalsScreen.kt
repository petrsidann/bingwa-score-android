package com.bingwascore.app.ui.autorenewals

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bingwascore.app.domain.autorenewal.AutoRenewal
import com.bingwascore.app.domain.autorenewal.RenewInterval
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.DesignTokens
import java.time.Instant
import java.time.temporal.ChronoUnit

@Composable
fun AutoRenewalsScreen(
    navController: NavController,
    onAddClick: () -> Unit,
    viewModel: AutoRenewalsViewModel = hiltViewModel()
) {
    val renewals by viewModel.autoRenewals.collectAsState(initial = emptyList())
    val roles = DesignTokens.LocalBingwaRoles.current

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DesignTokens.Spacing.Md),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = roles.textPrimary,
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Sm))
                Text(
                    text = "Auto-Renewals",
                    style = DesignTokens.Typography.Headline.copy(color = roles.textPrimary)
                )
            }
        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = DesignTokens.Spacing.Md)
        ) {
            // Stats glass card
            GlassCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = DesignTokens.Spacing.Sm)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DesignTokens.Spacing.Md),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Active",
                            style = DesignTokens.Typography.Caption.copy(color = roles.textSecondary)
                        )
                        Text(
                            text = "${renewals.count { it.isActive }}",
                            style = DesignTokens.Typography.Display.copy(color = roles.textPrimary)
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Next renewal",
                            style = DesignTokens.Typography.Caption.copy(color = roles.textSecondary)
                        )
                        val nextRenewal = renewals
                            .filter { it.isActive }
                            .minByOrNull { it.nextRenewalAt.toEpochMilli() }
                        Text(
                            text = nextRenewal?.let { formatRelativeTime(it.nextRenewalAt) } ?: "—",
                            style = DesignTokens.Typography.Subhead.copy(color = roles.brand)
                        )
                    }
                }
            }

            // + Add button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = DesignTokens.Spacing.Sm)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(roles.brand.copy(alpha = 0.15f))
                    .clickable { onAddClick() }
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+ Add",
                    style = DesignTokens.Typography.Subhead.copy(
                        color = roles.brand,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // List or empty state
            if (renewals.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No auto-renewals yet",
                        style = DesignTokens.Typography.Body.copy(color = roles.textSecondary)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
                ) {
                    items(renewals) { renewal ->
                        AutoRenewalCard(
                            renewal = renewal,
                            onToggle = { viewModel.toggleActive(renewal.id) },
                            onDelete = { viewModel.delete(renewal.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AutoRenewalCard(
    renewal: AutoRenewal,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DesignTokens.Spacing.Md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Customer ${renewal.customerId.takeLast(4)}",
                    style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
                )
                Text(
                    text = "Offer ${renewal.offerId.takeLast(4)}",
                    style = DesignTokens.Typography.Body.copy(color = roles.textSecondary)
                )
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                // Interval chip
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                        .background(roles.elevated)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = renewal.interval.label,
                        style = DesignTokens.Typography.Caption.copy(color = roles.textPrimary)
                    )
                }
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                Text(
                    text = "Next: ${formatRelativeTime(renewal.nextRenewalAt)}",
                    style = DesignTokens.Typography.Caption.copy(color = roles.brand)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = renewal.isActive,
                    onCheckedChange = { onToggle() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = roles.onBrand,
                        checkedTrackColor = roles.brand,
                        uncheckedThumbColor = roles.textSecondary,
                        uncheckedTrackColor = roles.border
                    )
                )
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Xs))
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color(0xFFBE123C),
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onDelete() }
                )
            }
        }
    }
}

private fun RenewInterval.label: String = when (this) {
    RenewInterval.DAILY -> "Daily"
    RenewInterval.WEEKLY -> "Weekly"
    RenewInterval.BIWEEKLY -> "Biweekly"
    RenewInterval.MONTHLY -> "Monthly"
}

private fun formatRelativeTime(instant: Instant): String {
    val now = Instant.now()
    val diff = ChronoUnit.HOURS.between(now, instant)
    val days = diff / 24
    val hours = diff % 24
    return if (days > 0) {
        "in ${days}d ${hours}h"
    } else {
        "in ${hours}h"
    }
}
