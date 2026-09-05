package com.bingwascore.app.ui.offers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.preferences.OfferTransitionRule
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.SurfaceDark
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

/** Statuses a fallback dial rule can trigger on. */
private val FALLBACK_STATUSES = listOf(
    TransactionStatus.FAILED,
    TransactionStatus.FAILED_ALREADY_RECOMMENDED,
    TransactionStatus.UNMATCHED
)

@Composable
fun OffersScreen(viewModel: OffersViewModel = hiltViewModel()) {
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val rules by viewModel.transitionRules.collectAsStateWithLifecycle()

    var showAddSheet by remember { mutableStateOf(false) }
    var settingsOffer by remember { mutableStateOf<Offer?>(null) }
    var actionsOffer by remember { mutableStateOf<Offer?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text("Offers", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "${offers.size} offer(s)",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            if (offers.isEmpty()) {
                GlassCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        "No offers yet",
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Tap + to add your first bundle offer.",
                        color = White.copy(alpha = 0.55f),
                        fontSize = 13.sp
                    )
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(offers, key = { it.id }) { offer ->
                        OfferCard(
                            offer = offer,
                            onToggle = { viewModel.toggleActive(offer) },
                            onOpenSettings = { settingsOffer = offer },
                            onOpenActions = { actionsOffer = offer }
                        )
                    }
                }
            }
        }

        AddOfferFab(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
            onClick = { showAddSheet = true }
        )
    }

    if (showAddSheet) {
        AddOfferSheet(
            onDismiss = { showAddSheet = false },
            onAdd = { name, price, code ->
                viewModel.addOffer(name, price, code)
                showAddSheet = false
            }
        )
    }

    settingsOffer?.let { offer ->
        OfferSettingsSheet(
            offer = offer,
            onDismiss = { settingsOffer = null },
            onSave = { updated ->
                viewModel.saveSettings(
                    offer = updated,
                    strictMode = updated.strictMode,
                    autoRetry = updated.autoRetry,
                    numberOfRetries = updated.numberOfRetries,
                    retryIntervalMins = updated.retryIntervalMins,
                    ussdTimeoutMillis = updated.ussdTimeoutMillis,
                    autoReschedule = updated.autoReschedule,
                    autoRescheduleRunTime = updated.autoRescheduleRunTime,
                    completionMessage = updated.completionMessage
                )
                settingsOffer = null
            }
        )
    }

    actionsOffer?.let { offer ->
        OfferActionsSheet(
            offer = offer,
            offers = offers,
            rules = rules,
            onDismiss = { actionsOffer = null },
            onSaveRule = viewModel::saveTransitionRule,
            onDeleteRule = viewModel::deleteTransitionRule
        )
    }
}

@Composable
private fun OfferCard(
    offer: Offer,
    onToggle: () -> Unit,
    onOpenSettings: () -> Unit,
    onOpenActions: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onOpenSettings)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        offer.name,
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    if (offer.isVerified) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Rounded.Verified,
                            contentDescription = "Verified",
                            tint = EmeraldGreen,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                PriceChip(price = offer.price)
                offer.completionMessage?.takeIf { it.isNotBlank() }?.let { message ->
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        message,
                        color = White.copy(alpha = 0.45f),
                        fontSize = 11.sp,
                        maxLines = 1
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = offer.isActive,
                onCheckedChange = { onToggle() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = NightBlack,
                    checkedTrackColor = EmeraldGreen,
                    checkedBorderColor = EmeraldGreen,
                    uncheckedThumbColor = White.copy(alpha = 0.7f),
                    uncheckedTrackColor = Color(0x22FFFFFF),
                    uncheckedBorderColor = Color(0x33FFFFFF)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onOpenActions)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Tune,
                    contentDescription = "Offer actions",
                    tint = White.copy(alpha = 0.6f),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun PriceChip(price: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
            .padding(horizontal = 12.dp, vertical = 5.dp)
    ) {
        Text(
            "Ksh $price",
            color = NightBlack,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AddOfferFab(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(58.dp)
            .clip(CircleShape)
            .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add offer",
            tint = NightBlack,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Composable
private fun AddOfferSheet(onDismiss: () -> Unit, onAdd: (name: String, price: Int, code: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var ussdCode by remember { mutableStateOf("") }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = SurfaceDark) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Add offer", color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(
                "A bundle customers can buy from you",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            SheetTextField(label = "Offer name", value = name, onValueChange = { name = it })
            SheetTextField(
                label = "Price (Ksh)",
                value = price,
                onValueChange = { price = it.filter { char -> char.isDigit() } }
            )
            SheetTextField(
                label = "USSD code",
                value = ussdCode,
                onValueChange = { ussdCode = it },
                placeholder = "*544*2*1*1*ph#"
            )
            Text(
                "Use \"ph\" where the customer number goes — the dialer swaps it in automatically.",
                color = White.copy(alpha = 0.45f),
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(18.dp))
            val valid = name.isNotBlank() && ussdCode.isNotBlank() && price.toIntOrNull() != null
            GradientButton(
                text = "Add offer",
                enabled = valid,
                onClick = { onAdd(name, price.toIntOrNull() ?: 0, ussdCode) }
            )
        }
    }
}

@Composable
private fun SheetTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(label, color = White.copy(alpha = 0.55f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        val shape = RoundedCornerShape(14.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Color(0x14FFFFFF))
                .border(1.dp, Color(0x1FFFFFFF), shape)
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Box {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(color = White, fontSize = 14.sp),
                    cursorBrush = SolidColor(EmeraldGreen),
                    modifier = Modifier.fillMaxWidth()
                )
                if (value.isEmpty() && placeholder.isNotEmpty()) {
                    Text(
                        placeholder,
                        color = White.copy(alpha = 0.35f),
                        fontSize = 14.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun SwitchRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            color = White,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = NightBlack,
                checkedTrackColor = EmeraldGreen,
                checkedBorderColor = EmeraldGreen,
                uncheckedThumbColor = White.copy(alpha = 0.7f),
                uncheckedTrackColor = Color(0x22FFFFFF),
                uncheckedBorderColor = Color(0x33FFFFFF)
            )
        )
    }
}

@Composable
private fun OfferSettingsSheet(offer: Offer, onDismiss: () -> Unit, onSave: (Offer) -> Unit) {
    var strictMode by remember { mutableStateOf(offer.strictMode) }
    var autoRetry by remember { mutableStateOf(offer.autoRetry) }
    var numberOfRetries by remember { mutableStateOf(offer.numberOfRetries.toString()) }
    var retryIntervalMins by remember { mutableStateOf(offer.retryIntervalMins.toString()) }
    var ussdTimeout by remember { mutableStateOf(offer.ussdTimeoutMillis.toString()) }
    var autoReschedule by remember { mutableStateOf(offer.autoReschedule) }
    var rescheduleTime by remember { mutableStateOf(offer.autoRescheduleRunTime) }
    var completionMessage by remember { mutableStateOf(offer.completionMessage.orEmpty()) }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = SurfaceDark) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Offer settings", color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(offer.name, color = White.copy(alpha = 0.5f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(14.dp))

            SwitchRow("Strict mode", strictMode) { strictMode = it }
            SwitchRow("Auto retry", autoRetry) { autoRetry = it }
            SheetTextField(
                label = "Number of retries",
                value = numberOfRetries,
                onValueChange = { numberOfRetries = it.filter { char -> char.isDigit() } }
            )
            SheetTextField(
                label = "Retry interval (mins)",
                value = retryIntervalMins,
                onValueChange = { retryIntervalMins = it.filter { char -> char.isDigit() } }
            )
            SheetTextField(
                label = "USSD timeout (ms)",
                value = ussdTimeout,
                onValueChange = { ussdTimeout = it.filter { char -> char.isDigit() } }
            )
            SwitchRow("Auto reschedule", autoReschedule) { autoReschedule = it }
            if (autoReschedule) {
                SheetTextField(
                    label = "Run time (HH:mm)",
                    value = rescheduleTime,
                    onValueChange = { rescheduleTime = it },
                    placeholder = "08:00"
                )
            }
            SheetTextField(
                label = "Completion message",
                value = completionMessage,
                onValueChange = { completionMessage = it },
                placeholder = "Sent to the customer after a successful dial"
            )

            Spacer(modifier = Modifier.height(16.dp))
            GradientButton(
                text = "Save settings",
                onClick = {
                    onSave(
                        offer.copy(
                            strictMode = strictMode,
                            autoRetry = autoRetry,
                            numberOfRetries = numberOfRetries.toIntOrNull() ?: offer.numberOfRetries,
                            retryIntervalMins = retryIntervalMins.toIntOrNull() ?: offer.retryIntervalMins,
                            ussdTimeoutMillis = ussdTimeout.toLongOrNull() ?: offer.ussdTimeoutMillis,
                            autoReschedule = autoReschedule,
                            autoRescheduleRunTime = rescheduleTime.ifBlank { offer.autoRescheduleRunTime },
                            completionMessage = completionMessage.ifBlank { null }
                        )
                    )
                }
            )
        }
    }
}

@Composable
private fun OfferActionsSheet(
    offer: Offer,
    offers: List<Offer>,
    rules: List<OfferTransitionRule>,
    onDismiss: () -> Unit,
    onSaveRule: (OfferTransitionRule) -> Unit,
    onDeleteRule: (OfferTransitionRule) -> Unit
) {
    var selectedStatus by remember { mutableStateOf(FALLBACK_STATUSES.first()) }
    var selectedTarget by remember { mutableStateOf<Offer?>(null) }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = SurfaceDark) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Offer actions", color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(offer.name, color = White.copy(alpha = 0.5f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Fallback rule",
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "When a transaction ends in status X, dial offer Y",
                color = White.copy(alpha = 0.45f),
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FALLBACK_STATUSES.forEach { status ->
                    StatusChip(
                        status = status,
                        selected = selectedStatus == status,
                        onClick = { selectedStatus = status }
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            Text(
                "Then dial offer",
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            val targets = offers.filter { it.id != offer.id }
            if (targets.isEmpty()) {
                Text(
                    "No other offers available yet.",
                    color = White.copy(alpha = 0.4f),
                    fontSize = 12.sp
                )
            } else {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(targets, key = { it.id }) { target ->
                        OfferPickChip(
                            offer = target,
                            selected = selectedTarget?.id == target.id,
                            onClick = { selectedTarget = target }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            GradientButton(
                text = "Save fallback rule",
                enabled = selectedTarget != null,
                onClick = {
                    selectedTarget?.let { target ->
                        onSaveRule(
                            OfferTransitionRule(
                                fromStatus = selectedStatus.value,
                                toOfferId = target.id,
                                toOfferName = target.name
                            )
                        )
                        selectedTarget = null
                    }
                }
            )

            if (rules.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Saved rules",
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                rules.forEach { rule ->
                    RuleRow(rule = rule, onDelete = { onDeleteRule(rule) })
                }
            }
        }
    }
}

@Composable
private fun StatusChip(status: TransactionStatus, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(12.dp)
    val base = if (selected) {
        Modifier
            .clip(shape)
            .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
    } else {
        Modifier
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x1FFFFFFF), shape)
    }
    Text(
        status.value.replace('_', ' ').lowercase()
            .replaceFirstChar { it.uppercase() },
        color = if (selected) NightBlack else White.copy(alpha = 0.75f),
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = base.clickable(onClick = onClick).padding(horizontal = 10.dp, vertical = 8.dp)
    )
}

@Composable
private fun OfferPickChip(offer: Offer, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(12.dp)
    val base = if (selected) {
        Modifier
            .clip(shape)
            .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
    } else {
        Modifier
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x1FFFFFFF), shape)
    }
    Column(
        modifier = base.clickable(onClick = onClick).padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            offer.name,
            color = if (selected) NightBlack else White,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            "Ksh ${offer.price}",
            color = if (selected) NightBlack.copy(alpha = 0.7f) else White.copy(alpha = 0.5f),
            fontSize = 10.sp
        )
    }
}

@Composable
private fun RuleRow(rule: OfferTransitionRule, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0x14FFFFFF))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                rule.fromStatus.replace('_', ' ').lowercase()
                    .replaceFirstChar { it.uppercase() },
                color = ErrorRed,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Dial ${rule.toOfferName}",
                color = White,
                fontSize = 12.sp
            )
        }
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = "Delete rule",
            tint = White.copy(alpha = 0.55f),
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onDelete)
                .padding(6.dp)
                .size(18.dp)
        )
    }
}






