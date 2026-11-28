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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bingwascore.app.domain.autorenewal.RenewInterval
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassInputField
import com.bingwascore.app.ui.components.GlassPill
import com.bingwascore.app.ui.theme.DesignTokens

@Composable
fun AddAutoRenewalScreen(
    navController: NavController,
    onNavigateBack: () -> Unit,
    viewModel: AutoRenewalsViewModel = hiltViewModel()
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    var step by remember { mutableStateOf(1) }
    var customerPhone by remember { mutableStateOf("") }
    var selectedOfferId by remember { mutableStateOf<String?>(null) }
    var selectedInterval by remember { mutableStateOf<RenewInterval?>(null) }

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
                        .clickable { onNavigateBack() }
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Sm))
                Text(
                    text = "Add Auto-Renewal",
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
            // Step indicator
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = DesignTokens.Spacing.Sm),
                horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Xs)
            ) {
                for (i in 1..4) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                            .background(if (i <= step) roles.brand else roles.border)
                    )
                }
            }

            when (step) {
                1 -> StepSelectCustomer(
                    customerPhone = customerPhone,
                    onPhoneChange = { customerPhone = it },
                    onNext = { if (customerPhone.isNotBlank()) step = 2 }
                )
                2 -> StepSelectOffer(
                    selectedOfferId = selectedOfferId,
                    onSelect = { selectedOfferId = it },
                    onNext = { if (selectedOfferId != null) step = 3 },
                    onBack = { step = 1 }
                )
                3 -> StepChooseInterval(
                    selectedInterval = selectedInterval,
                    onSelect = { selectedInterval = it },
                    onNext = { if (selectedInterval != null) step = 4 },
                    onBack = { step = 2 }
                )
                4 -> StepConfirm(
                    customerPhone = customerPhone,
                    offerId = selectedOfferId ?: "",
                    interval = selectedInterval ?: RenewInterval.DAILY,
                    onSchedule = {
                        viewModel.add(customerPhone, selectedOfferId!!, selectedInterval!!)
                        onNavigateBack()
                    },
                    onBack = { step = 3 }
                )
            }
        }
    }
}

@Composable
private fun StepSelectCustomer(
    customerPhone: String,
    onPhoneChange: (String) -> Unit,
    onNext: () -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        Text(
            text = "Step 1: Customer Phone",
            style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
        )
        GlassInputField(
            value = customerPhone,
            onValueChange = onPhoneChange,
            placeholder = "Enter phone number",
            focused = true
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                .background(roles.brand)
                .clickable(enabled = customerPhone.isNotBlank(), onClick = onNext)
                .padding(DesignTokens.Spacing.Md),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Next",
                style = DesignTokens.Typography.Subhead.copy(
                    color = roles.onBrand,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
private fun StepSelectOffer(
    selectedOfferId: String?,
    onSelect: (String) -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        Text(
            text = "Step 2: Select Offer",
            style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
        )
        // Placeholder offer list (would be filtered by customer's SiteLink in production)
        val offers = listOf("Offer A", "Offer B", "Offer C")
        LazyColumn(
            modifier = Modifier.height(200.dp),
            verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Xs)
        ) {
            items(offers) { offer ->
                val isSelected = offer == selectedOfferId
                GlassCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelect(offer) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(DesignTokens.Spacing.Md),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                                .background(if (isSelected) roles.brand else roles.border)
                        )
                        Spacer(modifier = Modifier.width(DesignTokens.Spacing.Sm))
                        Text(
                            text = offer,
                            style = DesignTokens.Typography.Body.copy(color = roles.textPrimary)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(roles.elevated)
                    .clickable(onClick = onBack)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Back",
                    style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(if (selectedOfferId != null) roles.brand else roles.border)
                    .clickable(enabled = selectedOfferId != null, onClick = onNext)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Next",
                    style = DesignTokens.Typography.Subhead.copy(
                        color = if (selectedOfferId != null) roles.onBrand else roles.textSecondary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
private fun StepChooseInterval(
    selectedInterval: RenewInterval?,
    onSelect: (RenewInterval) -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val intervals = listOf(RenewInterval.DAILY, RenewInterval.WEEKLY, RenewInterval.BIWEEKLY, RenewInterval.MONTHLY)

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        Text(
            text = "Step 3: Choose Interval",
            style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
        ) {
            intervals.forEach { interval ->
                val isSelected = interval == selectedInterval
                GlassPill(
                    modifier = Modifier.weight(1f),
                    fill = if (isSelected) roles.brand.copy(alpha = 0.2f) else roles.elevated,
                    borderWidth = if (isSelected) 1.dp else 0.dp,
                    borderColor = if (isSelected) roles.brand else Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelect(interval) }
                            .padding(vertical = DesignTokens.Spacing.Md),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = interval.label,
                            style = DesignTokens.Typography.Caption.copy(
                                color = if (isSelected) roles.brand else roles.textPrimary
                            )
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(roles.elevated)
                    .clickable(onClick = onBack)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Back",
                    style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(if (selectedInterval != null) roles.brand else roles.border)
                    .clickable(enabled = selectedInterval != null, onClick = onNext)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Next",
                    style = DesignTokens.Typography.Subhead.copy(
                        color = if (selectedInterval != null) roles.onBrand else roles.textSecondary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
private fun StepConfirm(
    customerPhone: String,
    offerId: String,
    interval: RenewInterval,
    onSchedule: () -> Unit,
    onBack: () -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        Text(
            text = "Step 4: Confirm",
            style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
        )
        GlassCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DesignTokens.Spacing.Md),
                verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
            ) {
                ConfirmRow(label = "Customer", value = customerPhone)
                ConfirmRow(label = "Offer", value = offerId)
                ConfirmRow(label = "Interval", value = interval.label)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(roles.elevated)
                    .clickable(onClick = onBack)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Back",
                    style = DesignTokens.Typography.Subhead.copy(color = roles.textPrimary)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(roles.brand)
                    .clickable(onClick = onSchedule)
                    .padding(DesignTokens.Spacing.Md),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Schedule",
                    style = DesignTokens.Typography.Subhead.copy(
                        color = roles.onBrand,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
private fun ConfirmRow(label: String, value: String) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = DesignTokens.Typography.Caption.copy(color = roles.textSecondary)
        )
        Text(
            text = value,
            style = DesignTokens.Typography.Caption.copy(color = roles.textPrimary)
        )
    }
}

private fun RenewInterval.label: String = when (this) {
    RenewInterval.DAILY -> "Daily"
    RenewInterval.WEEKLY -> "Weekly"
    RenewInterval.BIWEEKLY -> "Biweekly"
    RenewInterval.MONTHLY -> "Monthly"
}
