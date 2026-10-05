package com.bingwascore.app.ui.offers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material.icons.rounded.SignalCellularAlt
import androidx.compose.material.icons.rounded.Sms
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
import com.bingwascore.app.domain.BatchDialPlanner
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.OfferTags
import com.bingwascore.app.ui.theme.accentBrush
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import androidx.compose.ui.text.style.TextOverflow
import java.util.Locale

/** Statuses a fallback dial rule can trigger on. */
private val FALLBACK_STATUSES = listOf(
    TransactionStatus.FAILED,
    TransactionStatus.FAILED_ALREADY_RECOMMENDED,
    TransactionStatus.UNMATCHED
)

@Composable
fun OffersScreen(viewModel: OffersViewModel = hiltViewModel()) {
    val haptics = rememberHaptics()
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val rules by viewModel.transitionRules.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    // Parity F — batch dial + duplicate-rule feedback.
    val ruleError by viewModel.ruleError.collectAsStateWithLifecycle()
    // MEGA A — Offer Settings form state (isLoading + inline errorMessage).
    val settingsState by viewModel.settingsState.collectAsStateWithLifecycle()
    val isBatching by viewModel.isBatching.collectAsStateWithLifecycle()
    val lastDialPhone by viewModel.lastDialPhone.collectAsStateWithLifecycle()

    var showAddSheet by remember { mutableStateOf(false) }
    var settingsOffer by remember { mutableStateOf<Offer?>(null) }
    var actionsOffer by remember { mutableStateOf<Offer?>(null) }

    // POLISH P4 — which category the grid is showing. All, by default, because
    // an agent who opens Offers wants to see their shelf, not a filtered view
    // they have to undo.
    var category by remember { mutableStateOf(OfferCategory.ALL) }

    // Parity F — multi-select (long-press a card), batch phone and the single
    // confirmation dialog listing the non-silent offers.
    var selectionMode by remember { mutableStateOf(false) }
    var selectedIds by remember { mutableStateOf<Set<String>>(emptySet()) }
    var batchPhone by remember { mutableStateOf("") }
    var confirmOffers by remember { mutableStateOf<List<Offer>?>(null) }

    val selectedOffers = offers.filter { it.id in selectedIds }

    fun exitSelection() {
        selectionMode = false
        selectedIds = emptySet()
    }

    // Prefill the batch phone with the last dialled customer (Dialer parity).
    LaunchedEffect(lastDialPhone) {
        if (batchPhone.isBlank() && lastDialPhone.isNotBlank()) batchPhone = lastDialPhone
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {
        // REBRAND R1 — flat black stage; the offer cards are bubbles, so there
        // is no ambient art left to refract behind them.

        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 6.dp)
            ) {
                Text("Offers", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    if (selectionMode) "${selectedOffers.size} selected"
                    else "${offers.size} offer(s)",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            // POLISH P4 — the category chips, derived from the offer type.
            CategoryChips(
                selected = category,
                counts = remember(offers) { OfferCategory.entries.associateWith { cat ->
                    OfferCategory.filter(offers, cat).size
                } },
                onSelect = {
                    haptics.tick()
                    category = it
                }
            )

            if (isLoading) {
                // Parity E — shimmer skeletons while the offers load.
                OfferSkeleton()
            } else if (offers.isEmpty()) {
                EmptyState(
                    icon = Icons.Rounded.LocalOffer,
                    title = "No offers yet",
                    message = "Tap the + button to add your first bundle offer — then dial it in one tap.",
                    modifier = Modifier.padding(20.dp)
                )
            } else {
                val visible = remember(offers, category) { OfferCategory.filter(offers, category) }
                if (visible.isEmpty()) {
                    // POLISH P4 — an empty category says so, in its own words.
                    EmptyState(
                        icon = categoryIcon(category),
                        title = "No ${category.label.lowercase(Locale.ROOT)} offers",
                        message = "Add a ${category.label.lowercase(Locale.ROOT)} bundle with the + " +
                            "button, or pick another category.",
                        modifier = Modifier.padding(20.dp)
                    )
                } else {
                    // POLISH P4 — a two-column grid, so an agent with eight offers
                    // sees all eight without scrolling past one giant card at a
                    // time.
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = OFFER_GRID_MIN_WIDTH.dp),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = if (selectionMode) 280.dp else 96.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        itemsIndexed(visible, key = { _, offer -> offer.id }) { index, offer ->
                            OfferCard(
                                offer = offer,
                                enterDelayMillis = minOf(index, 6) * Motion.STAGGER,
                                selectionMode = selectionMode,
                                selected = offer.id in selectedIds,
                                onToggle = { viewModel.toggleActive(offer) },
                                onOpenSettings = { settingsOffer = offer },
                                onOpenActions = { actionsOffer = offer },
                                onLongPress = {
                                    selectionMode = true
                                    selectedIds = selectedIds + offer.id
                                },
                                onSelectToggle = {
                                    selectedIds = if (offer.id in selectedIds) {
                                        selectedIds - offer.id
                                    } else {
                                        selectedIds + offer.id
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }

        if (!selectionMode) {
            AddOfferFab(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp),
                onClick = { showAddSheet = true }
            )
        }

        // Parity F — floating silent batch bar (replaces the FAB while selecting).
        if (selectionMode) {
            BatchDialBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                count = selectedOffers.size,
                silentCount = selectedOffers.count { it.silentBatch },
                phone = batchPhone,
                onPhoneChange = { batchPhone = it },
                isBatching = isBatching,
                onCancel = { exitSelection() },
                onDial = {
                    val targets = selectedOffers
                    if (targets.isNotEmpty()) {
                        // Silent offers need no confirmation; anything else gets
                        // exactly ONE dialog listing them before queueing.
                        if (BatchDialPlanner.requiresConfirmation(targets)) {
                            confirmOffers = targets
                        } else {
                            viewModel.batchDial(targets, batchPhone)
                            exitSelection()
                        }
                    }
                }
            )
        }
    }

    // Parity F — the single confirmation for non-silent offers.
    confirmOffers?.let { targets ->
        AlertDialog(
            onDismissRequest = { confirmOffers = null },
            containerColor = Raised,
            title = {
                Text(
                    "Queue ${targets.size} dials?",
                    color = TextWhite,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {
                    Text(
                        "These offers are not marked SILENT, so the Ghost Queue will dial them one after the other:",
                        color = TextWhite.copy(alpha = 0.6f),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        BatchDialPlanner.confirmationMessage(targets),
                        color = TextWhite,
                        fontSize = 13.sp
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.batchDial(targets, batchPhone)
                        confirmOffers = null
                        exitSelection()
                    }
                ) {
                    Text("Queue anyway", color = AccentBlue, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmOffers = null }) {
                    Text("Cancel", color = TextWhite.copy(alpha = 0.6f))
                }
            }
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
            settingsState = settingsState,
            onDismiss = { settingsOffer = null },
            onClearError = { viewModel.clearSettingsError() },
            onSave = { retries, intervalMins, timeoutSeconds, reschedule, runTime,
                      completionMsg, type, strict, retry, retryNetwork, silent,
                      tagValue, relay ->
                viewModel.saveOfferSettings(
                    offer = offer,
                    numberOfRetries = retries,
                    retryIntervalMins = intervalMins,
                    ussdTimeoutSeconds = timeoutSeconds,
                    autoReschedule = reschedule,
                    rescheduleTime = runTime,
                    completionMessage = completionMsg,
                    type = type,
                    strictMode = strict,
                    autoRetry = retry,
                    autoRetryConnectionProblems = retryNetwork,
                    silentBatch = silent,
                    tag = tagValue,
                    relayDevice = relay
                )
                // Only dismiss once the write actually succeeded — the sheet
                // stays open showing the inline error otherwise.
                if (settingsState.errorMessage == null && !settingsState.isLoading) {
                    settingsOffer = null
                }
            }
        )
    }

    actionsOffer?.let { offer ->
        OfferActionsSheet(
            offer = offer,
            offers = offers,
            rules = rules,
            ruleError = ruleError,
            onClearRuleError = viewModel::clearRuleError,
            onDismiss = { actionsOffer = null },
            onSaveRule = viewModel::saveTransitionRule,
            onDeleteRule = viewModel::deleteTransitionRule
        )
    }
}

/**
 * Parity E — offer-card skeleton: two bubble cards with shimmering bars while
 * `isLoading` is true (i.e. before Room delivers its first snapshot).
 */
@Composable
private fun OfferSkeleton() {
    LazyColumn(
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(2) { index ->
            BubbleCard(
                modifier = Modifier.fillMaxWidth(),
                enterDelayMillis = index * Motion.STAGGER
            ) {
                ShimmerBlock(modifier = Modifier.fillMaxWidth(0.5f))
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ShimmerBlock(modifier = Modifier.width(72.dp), cornerRadius = 10.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    ShimmerBlock(modifier = Modifier.width(54.dp), cornerRadius = 10.dp)
                }
                Spacer(modifier = Modifier.height(14.dp))
                ShimmerBlock(modifier = Modifier.fillMaxWidth(0.7f), cornerRadius = 8.dp)
            }
        }
    }
}

/**
 * POLISH P4 — one grid card.
 *
 * The old row was a full-width card with a name, two chips, an optional relay
 * line, an optional completion message, a switch and a gear — around 96dp tall,
 * so four offers filled a phone screen. A grid cell has to earn its space: name
 * on two lines, price chip, type icon, switch and gear, and nothing that can be
 * one tap longer. Everything that used to live on the card (relay, completion
 * message, tags, silent-batch) moved into the gear sheet it always opened.
 */
@Composable
private fun OfferCard(
    offer: Offer,
    enterDelayMillis: Int,
    selectionMode: Boolean = false,
    selected: Boolean = false,
    onToggle: () -> Unit,
    onOpenSettings: () -> Unit,
    onOpenActions: () -> Unit,
    onLongPress: () -> Unit = {},
    onSelectToggle: () -> Unit = {}
) {
    BubbleCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 18.dp,
        onClick = if (selectionMode) onSelectToggle else onOpenSettings,
        // Parity F — long-press anywhere on the card starts multi-select.
        onLongClick = onLongPress,
        enterDelayMillis = enterDelayMillis
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = categoryIcon(offerCategoryOf(offer)),
                contentDescription = offer.type,
                tint = if (offer.isActive) AccentBlue else TextDim,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                offer.name,
                color = if (offer.isActive) TextWhite else TextGrey,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            if (offer.isVerified) {
                Icon(
                    imageVector = Icons.Rounded.Verified,
                    contentDescription = "Verified",
                    tint = TickGreen,
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            PriceChip(price = offer.price)
            Spacer(modifier = Modifier.weight(1f))
            if (selectionMode) {
                // Parity F — multi-select: the switch/gear give way to a checkbox.
                SelectionCheckbox(checked = selected)
            } else {
                HapticSwitch(
                    checked = offer.isActive,
                    onCheckedChange = { onToggle() },
                    modifier = Modifier.scale(0.82f),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = BgBlack,
                        checkedTrackColor = AccentBlue,
                        checkedBorderColor = AccentBlue,
                        uncheckedThumbColor = TextWhite.copy(alpha = 0.7f),
                        uncheckedTrackColor = Raised,
                        uncheckedBorderColor = Hairline
                    )
                )
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .clickable(onClick = onOpenActions),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Tune,
                        contentDescription = "Offer actions",
                        tint = TextWhite.copy(alpha = 0.6f),
                        modifier = Modifier.size(17.dp)
                    )
                }
            }
        }
    }
}

/**
 * POLISH P4 — the category chips.
 *
 * Each chip carries its own count, so a category with nothing in it is visibly
 * empty before it is tapped, and the empty state it leads to is a sentence
 * rather than a blank grid.
 */
@Composable
private fun CategoryChips(
    selected: OfferCategory,
    counts: Map<OfferCategory, Int>,
    onSelect: (OfferCategory) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(OfferCategory.entries.toList(), key = { it.name }) { category ->
            val count = counts[category] ?: 0
            val isSelected = category == selected
            val shape = RoundedCornerShape(12.dp)
            val interactionSource = remember { MutableInteractionSource() }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .pressScale(interactionSource)
                    .clip(shape)
                    .background(if (isSelected) AccentBlue else Bubble)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { onSelect(category) }
                    )
                    .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
                Text(
                    category.label,
                    color = if (isSelected) TextWhite else TextGrey,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "$count",
                    color = if (isSelected) TextWhite.copy(alpha = 0.7f) else TextDim,
                    fontSize = 11.sp
                )
            }
        }
    }
}

/** The category an offer belongs to; an unknown type reads as All. */
internal fun offerCategoryOf(offer: Offer): OfferCategory =
    OfferCategory.entries.firstOrNull { it.type != null && it.matches(offer) } ?: OfferCategory.ALL

/** The glyph that stands for each category, on cards and in empty states. */
internal fun categoryIcon(category: OfferCategory) = when (category) {
    OfferCategory.ALL -> Icons.Rounded.Apps
    OfferCategory.DATA -> Icons.Rounded.SignalCellularAlt
    OfferCategory.AIRTIME -> Icons.Rounded.Call
    OfferCategory.SMS -> Icons.Rounded.Sms
    OfferCategory.COMBO -> Icons.Rounded.AutoAwesome
}

@Composable
private fun TagOptionChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(12.dp)
    val base = if (selected) {
        Modifier
            .clip(shape)
            .background(accentBrush())
    } else {
        Modifier
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
    }
    Text(
        label,
        color = if (selected) BgBlack else TextWhite.copy(alpha = 0.75f),
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = base.clickable(onClick = onClick).padding(horizontal = 10.dp, vertical = 8.dp)
    )
}

@Composable
private fun TagChip(tag: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Bubble)
            .border(1.dp, Hairline, RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            tag,
            color = TextWhite.copy(alpha = 0.8f),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun PriceChip(price: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(accentBrush())
            .padding(horizontal = 12.dp, vertical = 5.dp)
    ) {
        Text(
            "Ksh $price",
            color = BgBlack,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AddOfferFab(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptics = rememberHaptics()
    Box(
        modifier = modifier
            .pressScale(interactionSource)
            .size(58.dp)
            .clip(CircleShape)
            .background(accentBrush())
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    haptics.press()
                    onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add offer",
            tint = BgBlack,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Composable
private fun AddOfferSheet(onDismiss: () -> Unit, onAdd: (name: String, price: Int, code: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var ussdCode by remember { mutableStateOf("") }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = Raised) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Add offer", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(
                "A bundle customers can buy from you",
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            SheetTextField(label = "Offer name", value = name, onValueChange = { name = it })
            SheetTextField(
                label = "Price (Ksh)",
                value = price,
                onValueChange = { price = it.filter { char -> char.isDigit() } },
                placeholder = "Price e.g. 20"
            )
            SheetTextField(
                label = "USSD code",
                value = ussdCode,
                onValueChange = { ussdCode = it },
                placeholder = "*544*2*1*1*ph#"
            )
            Text(
                "Use \"ph\" where the customer number goes — the dialer swaps it in automatically.",
                color = TextFaint,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(18.dp))
            val valid = name.isNotBlank() && ussdCode.isNotBlank() && price.toIntOrNull() != null
            PrimaryButton(
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
        Text(label, color = TextWhite.copy(alpha = 0.55f), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        val shape = RoundedCornerShape(14.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Bubble)
                .border(1.dp, Hairline, shape)
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Box {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(color = TextWhite, fontSize = 14.sp),
                    cursorBrush = SolidColor(AccentBlue),
                    modifier = Modifier.fillMaxWidth()
                )
                if (value.isEmpty() && placeholder.isNotEmpty()) {
                    Text(
                        placeholder,
                        color = TextFaint,
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
            color = TextWhite,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        HapticSwitch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = BgBlack,
                checkedTrackColor = AccentBlue,
                checkedBorderColor = AccentBlue,
                uncheckedThumbColor = TextWhite.copy(alpha = 0.7f),
                uncheckedTrackColor = Raised,
                uncheckedBorderColor = Hairline
            )
        )
    }
}

@Composable
private fun OfferSettingsSheet(
    offer: Offer,
    settingsState: OfferSettingsState,
    onDismiss: () -> Unit,
    onSave: (
        numberOfRetries: String,
        retryIntervalMins: String,
        ussdTimeoutSeconds: String,
        autoReschedule: Boolean,
        rescheduleTime: String,
        completionMessage: String,
        type: String,
        strictMode: Boolean,
        autoRetry: Boolean,
        autoRetryConnectionProblems: Boolean,
        silentBatch: Boolean,
        tag: String?,
        relayDevice: String?
    ) -> Unit,
    onClearError: () -> Unit
) {
    var strictMode by remember { mutableStateOf(offer.strictMode) }
    var autoRetry by remember { mutableStateOf(offer.autoRetry) }
    var numberOfRetries by remember { mutableStateOf(offer.numberOfRetries.toString()) }
    var retryIntervalMins by remember { mutableStateOf(offer.retryIntervalMins.toString()) }
    // MEGA A — the form edits SECONDS; the engine multiplies by 1000.
    var ussdTimeoutSeconds by remember {
        mutableStateOf((offer.ussdTimeoutSeconds.takeIf { it > 0 } ?: 20).toString())
    }
    var autoReschedule by remember { mutableStateOf(offer.autoReschedule) }
    var rescheduleTime by remember { mutableStateOf(offer.autoRescheduleRunTime) }
    var completionMessage by remember { mutableStateOf(offer.completionMessage.orEmpty()) }
    // Parity F — silent batch dial flag (no per-dial confirmation).
    var silentBatch by remember { mutableStateOf(offer.silentBatch) }
    // MEGA A — per-offer personality: type bucket + network-retry opt-in.
    var type by remember { mutableStateOf(offer.type) }
    var retryConnectionProblems by remember { mutableStateOf(offer.autoRetryConnectionProblems) }
    // Parity D — tag + relay editors (offer grouping).
    var tag by remember { mutableStateOf(offer.tag.orEmpty()) }
    var relayDevice by remember { mutableStateOf(offer.relayDevice.orEmpty()) }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = Raised) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Offer settings", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(offer.name, color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(14.dp))

            // MEGA A — type bucket chips (Airtime / Data / SMS / Combo).
            Text("Type", color = TextWhite.copy(alpha = 0.55f), fontSize = 11.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Offer.TYPES.forEach { option ->
                    TagOptionChip(
                        label = option.lowercase().replaceFirstChar { it.uppercase() },
                        selected = type == option
                    ) {
                        type = option
                        onClearError()
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            SwitchRow("Strict mode", strictMode) { strictMode = it }
            Text(
                "Never resell this bundle once Safaricom says the customer was already recommended it.",
                color = TextFaint,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            SwitchRow("Auto retry", autoRetry) { autoRetry = it }
            SwitchRow("Retry network problems", retryConnectionProblems) { retryConnectionProblems = it }
            Text(
                "Silent offers are queued straight away in the Ghost Queue — no per-dial confirmation.",
                color = TextFaint,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
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
                label = "USSD timeout (seconds)",
                value = ussdTimeoutSeconds,
                onValueChange = {
                    ussdTimeoutSeconds = it.filter { char -> char.isDigit() }
                    onClearError()
                }
            )
            SwitchRow("Auto reschedule", autoReschedule) { autoReschedule = it }
            if (autoReschedule) {
                SheetTextField(
                    label = "Run time (HH:mm)",
                    value = rescheduleTime,
                    onValueChange = {
                        rescheduleTime = it
                        onClearError()
                    },
                    placeholder = "08:00"
                )
            }
            SheetTextField(
                label = "Completion message",
                value = completionMessage,
                onValueChange = { completionMessage = it },
                placeholder = "Sent to the customer after a successful dial"
            )

            // Parity D — Hybrid OfferTag bucket (OFFER_1..OFFER_4, optional).
            Spacer(modifier = Modifier.height(4.dp))
            Text("Offer tag", color = TextWhite.copy(alpha = 0.55f), fontSize = 11.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TagOptionChip(label = "None", selected = tag.isBlank()) { tag = "" }
                OfferTags.ALL.forEach { option ->
                    TagOptionChip(label = option, selected = tag == option) { tag = option }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            SheetTextField(
                label = "Relay device (optional)",
                value = relayDevice,
                onValueChange = { relayDevice = it },
                placeholder = "e.g. relay-01 — blank = dial locally"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // MEGA A — inline form feedback: a red error or a green confirmation
            // rendered above the button, so a failed save can never look saved.
            settingsState.errorMessage?.let { message ->
                Text(message, color = FailRed, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }
            settingsState.savedMessage?.let { message ->
                Text(message, color = TickGreen, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }

            PrimaryButton(
                text = if (settingsState.isLoading) "Saving…" else "Save settings",
                enabled = !settingsState.isLoading,
                onClick = {
                    onSave(
                        numberOfRetries,
                        retryIntervalMins,
                        ussdTimeoutSeconds,
                        autoReschedule,
                        rescheduleTime,
                        completionMessage,
                        type,
                        strictMode,
                        autoRetry,
                        retryConnectionProblems,
                        silentBatch,
                        tag,
                        relayDevice
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
    ruleError: String?,
    onClearRuleError: () -> Unit,
    onDismiss: () -> Unit,
    onSaveRule: (OfferTransitionRule) -> Unit,
    onDeleteRule: (OfferTransitionRule) -> Unit
) {
    var selectedStatus by remember { mutableStateOf(FALLBACK_STATUSES.first()) }
    var selectedTarget by remember { mutableStateOf<Offer?>(null) }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = Raised) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp)
        ) {
            Text("Offer actions", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(offer.name, color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Fallback rule",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "When a transaction ends in status X, dial offer Y",
                color = TextFaint,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FALLBACK_STATUSES.forEach { status ->
                    StatusChip(
                        status = status,
                        selected = selectedStatus == status,
                        onClick = {
                            selectedStatus = status
                            onClearRuleError()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            Text(
                "Then dial offer",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            val targets = offers.filter { it.id != offer.id }
            if (targets.isEmpty()) {
                Text(
                    "No other offers available yet.",
                    color = TextFaint,
                    fontSize = 12.sp
                )
            } else {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(targets, key = { it.id }) { target ->
                        OfferPickChip(
                            offer = target,
                            selected = selectedTarget?.id == target.id,
                            onClick = {
                                selectedTarget = target
                                onClearRuleError()
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
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

            // Parity F — duplicate rules are rejected by the ViewModel guard and
            // reported here in red instead of silently overwriting the old rule.
            if (ruleError != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(ruleError, color = FailRed, fontSize = 12.sp)
            }

            if (rules.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Saved rules",
                    color = TextWhite,
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
            .background(accentBrush())
    } else {
        Modifier
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
    }
    Text(
        status.value.replace('_', ' ').lowercase()
            .replaceFirstChar { it.uppercase() },
        color = if (selected) BgBlack else TextWhite.copy(alpha = 0.75f),
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
            .background(accentBrush())
    } else {
        Modifier
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
    }
    Column(
        modifier = base.clickable(onClick = onClick).padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            offer.name,
            color = if (selected) BgBlack else TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            "Ksh ${offer.price}",
            color = if (selected) BgBlack.copy(alpha = 0.7f) else TextWhite.copy(alpha = 0.5f),
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
            .background(Bubble)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                rule.fromStatus.replace('_', ' ').lowercase()
                    .replaceFirstChar { it.uppercase() },
                color = FailRed,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Dial ${rule.toOfferName}",
                color = TextWhite,
                fontSize = 12.sp
            )
        }
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = "Delete rule",
            tint = TextWhite.copy(alpha = 0.55f),
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onDelete)
                .padding(6.dp)
                .size(18.dp)
        )
    }
}







/**
 * Parity F — "SILENT" chip on offers flagged for silent batch dial: they are
 * queued without the per-dial confirmation the advanced offers get.
 */
@Composable
private fun SilentChip() {
    val shape = RoundedCornerShape(12.dp)
    Box(
        modifier = Modifier
            .clip(shape)
            .background(AccentBlue.copy(alpha = 0.16f))
            .border(1.dp, AccentBlue.copy(alpha = 0.55f), shape)
            .padding(horizontal = 8.dp, vertical = 5.dp)
    ) {
        Text(
            "SILENT",
            color = AccentBlue,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Parity F — multi-select checkbox shown in place of the switch/Tune controls. */
@Composable
private fun SelectionCheckbox(checked: Boolean) {
    val shape = RoundedCornerShape(8.dp)
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(shape)
            .background(if (checked) accentBrush() else SolidColor(Bubble))
            .border(1.dp, if (checked) AccentBlue else Hairline, shape),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Rounded.Check,
                contentDescription = "Selected",
                tint = BgBlack,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

/**
 * Parity F — floating batch bar: selected count, the target customer number
 * (prefilled with the last dialled one) and the gradient "Dial N Silent" CTA.
 */
@Composable
private fun BatchDialBar(
    modifier: Modifier = Modifier,
    count: Int,
    silentCount: Int,
    phone: String,
    onPhoneChange: (String) -> Unit,
    isBatching: Boolean,
    onCancel: () -> Unit,
    onDial: () -> Unit
) {
    BubbleCard(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "$count selected — $silentCount run silently",
                    color = TextWhite,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "Silent offers dial straight away; the rest ask once.",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 10.sp
                )
            }
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Cancel selection",
                tint = TextWhite.copy(alpha = 0.6f),
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onCancel)
                    .padding(6.dp)
                    .size(18.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        SheetTextField(
            label = "Batch phone (customer)",
            value = phone,
            onValueChange = { raw -> onPhoneChange(raw.filter { it.isDigit() }) },
            placeholder = "0712345678"
        )
        PrimaryButton(
            text = "Ghost Queue ×$count",
            loading = isBatching,
            enabled = count > 0,
            onClick = onDial
        )
    }
}

