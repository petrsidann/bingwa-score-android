package com.bingwascore.app.ui.dialer

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.domain.engine.UssdConsoleLine
import com.bingwascore.app.ui.components.GlassBottomSheet
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassDialog
import com.bingwascore.app.ui.components.GlassPill
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter

/**
 * Stage 70 — Quick Dial surface per Phase 1 spec 6.
 *
 * Lime-bordered phone field, enabled-offer chips, selected-offer card and a
 * confirm sheet with Live dial / Offline queue mode. The wrapper owns the
 * ViewModel and runtime permissions; the content is a pure function of
 * [DialerScreenState] + [DialerScreenCallbacks].
 */

data class DialerScreenState(
    val offers: List<Offer> = emptyList(),
    val phone: String = "",
    val selectedOfferId: String? = null,
    val feedback: DialerFeedback? = null,
    val isDialing: Boolean = false,
    val missingPermissions: List<String> = emptyList(),
    val result: DialResult? = null,
    val consoleLines: List<UssdConsoleLine> = emptyList(),
    val consoleOpen: Boolean = false,
    val confirmOpen: Boolean = false,
    val confirmMode: DialMode = DialMode.LIVE
)

data class DialerScreenCallbacks(
    val onClose: () -> Unit = {},
    val onPhoneChange: (String) -> Unit = {},
    val onPhoneBlur: () -> Unit = {},
    val onSelectOffer: (Offer) -> Unit = {},
    val onOpenConfirm: () -> Unit = {},
    val onCloseConfirm: () -> Unit = {},
    val onSetMode: (DialMode) -> Unit = {},
    val onConfirm: () -> Unit = {},
    val onRequestPermissions: () -> Unit = {},
    val onConsumeResult: () -> Unit = {}
)

enum class DialMode { LIVE, OFFLINE }

@Composable
fun DialerScreen(onClose: () -> Unit, viewModel: DialerViewModel = hiltViewModel()) {
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val phone by viewModel.phone.collectAsStateWithLifecycle()
    val selectedOfferId by viewModel.selectedOfferId.collectAsStateWithLifecycle()
    val feedback by viewModel.feedback.collectAsStateWithLifecycle()
    val isDialing by viewModel.isDialing.collectAsStateWithLifecycle()
    val missingPermissions by viewModel.missingPermissions.collectAsStateWithLifecycle()
    val result by viewModel.result.collectAsStateWithLifecycle()
    val haptics = rememberHaptics()

    val permissionLauncher = rememberLauncherForActivityResult(
        RequestMultiplePermissions()
    ) { granted -> granted.values.forEach { if (it) haptics.tick() } }

    LaunchedEffect(Unit) {
        val missing = viewModel.missingDialPermissions()
        if (missing.isNotEmpty()) {
            haptics.error()
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_PHONE_STATE
                )
            )
        }
    }

    LaunchedEffect(feedback) {
        feedback?.let { if (it.isError) haptics.error() else haptics.success() }
    }

    LaunchedEffect(result) {
        result?.let { if (it.successful) haptics.success() else haptics.error() }
    }

    var confirmOpen by remember { mutableStateOf(false) }
    var confirmMode by remember { mutableStateOf(DialMode.LIVE) }

    val state = DialerScreenState(
        offers = offers,
        phone = phone,
        selectedOfferId = selectedOfferId,
        feedback = feedback,
        isDialing = isDialing,
        missingPermissions = missingPermissions,
        result = result,
        confirmOpen = confirmOpen,
        confirmMode = confirmMode
    )

    val callbacks = DialerScreenCallbacks(
        onClose = onClose,
        onPhoneChange = viewModel::setPhone,
        onPhoneBlur = viewModel::formatPhone,
        onSelectOffer = {
            haptics.tick()
            viewModel.selectOffer(it)
        },
        onOpenConfirm = { confirmOpen = true },
        onCloseConfirm = { confirmOpen = false },
        onSetMode = { confirmMode = it },
        onConfirm = {
            confirmOpen = false
            if (confirmMode == DialMode.LIVE) viewModel.dialNow() else viewModel.queueNow()
        },
        onRequestPermissions = {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_PHONE_STATE
                )
            )
        },
        onConsumeResult = viewModel::consumeResult
    )

    DialerScreenContent(state = state, callbacks = callbacks)
}

@Composable
fun DialerScreenContent(
    state: DialerScreenState,
    callbacks: DialerScreenCallbacks = DialerScreenCallbacks()
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val scrollState = rememberScrollState()
    val selectedOffer = state.offers.firstOrNull { it.id == state.selectedOfferId }
        ?: state.offers.firstOrNull()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(roles.bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .screenEnter()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            TopBar(title = "Quick Dial", onBack = callbacks.onClose)

            Spacer(modifier = Modifier.height(24.dp))

            SectionLabel("Customer phone")
            Spacer(modifier = Modifier.height(8.dp))

            PhoneField(
                value = state.phone,
                onValueChange = callbacks.onPhoneChange,
                onBlur = callbacks.onPhoneBlur,
                onCall = callbacks.onOpenConfirm,
                enabled = !state.isDialing
            )

            Spacer(modifier = Modifier.height(24.dp))

            SectionLabel("Select offer")
            Spacer(modifier = Modifier.height(8.dp))

            if (state.offers.isEmpty()) {
                EmptyOffersMessage()
            } else {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 4.dp)
                ) {
                    items(state.offers, key = { it.id }) { offer ->
                        OfferChip(
                            offer = offer,
                            selected = offer.id == selectedOffer?.id,
                            onClick = { callbacks.onSelectOffer(offer) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            selectedOffer?.let { offer ->
                SelectedOfferCard(offer = offer)
                Spacer(modifier = Modifier.height(24.dp))
            }

            state.feedback?.let { value ->
                Text(
                    text = value.message,
                    color = if (value.isError) roles.error else roles.success,
                    fontSize = BingwaType.Caption,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        ConfirmSheet(
            visible = state.confirmOpen,
            onDismiss = callbacks.onCloseConfirm,
            phone = state.phone,
            offer = selectedOffer,
            mode = state.confirmMode,
            onModeChange = callbacks.onSetMode,
            onConfirm = callbacks.onConfirm,
            enabled = !state.isDialing
        )

        state.result?.let { outcome ->
            ResultDialog(outcome = outcome, onDismiss = callbacks.onConsumeResult)
        }
    }
}

@Composable
private fun TopBar(title: String, onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onBack)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = DesignTokens.LocalBingwaRoles.current.textPrimary,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            style = DesignTokens.Typography.Headline,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
        fontSize = BingwaType.Caption,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun PhoneField(
    value: String,
    onValueChange: (String) -> Unit,
    onBlur: () -> Unit,
    onCall: () -> Unit,
    enabled: Boolean
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val lime = DesignTokens.Launch.lime
    val haptic = LocalHapticFeedback.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .clip(RoundedCornerShape(14.dp))
                .border(2.dp, lime, RoundedCornerShape(14.dp))
                .background(roles.card)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = roles.textPrimary,
                    fontSize = BingwaType.Body,
                    fontWeight = FontWeight.SemiBold
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                enabled = enabled,
                decorationBox = { innerTextField ->
                    Box {
                        innerTextField()
                        if (value.isEmpty()) {
                            Text(
                                text = "07XX XXX XXX",
                                color = roles.textPrimary.copy(alpha = 0.35f),
                                fontSize = BingwaType.Body
                            )
                        }
                    }
                }
            )
        }

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(if (enabled && value.isNotBlank()) lime else lime.copy(alpha = 0.5f))
                .clickable(enabled = enabled && value.isNotBlank(), onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onCall()
                }),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "Dial",
                tint = roles.onBrand,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun EmptyOffersMessage() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "No active offers yet — add one in the Offers tab.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
            fontSize = BingwaType.Body
        )
    }
}

@Composable
private fun OfferChip(offer: Offer, selected: Boolean, onClick: () -> Unit) {
    val roles = DesignTokens.LocalBingwaRoles.current
    GlassPill(
        shape = RoundedCornerShape(DesignTokens.Shape.RadiusLg),
        fill = if (selected) roles.brand.copy(alpha = 0.12f) else Color.Transparent,
        borderWidth = if (selected) 2.dp else 1.dp,
        borderColor = if (selected) roles.brand else roles.border.copy(alpha = 0.3f),
        onClick = onClick
    ) {
        Text(
            text = offer.name,
            color = if (selected) roles.textPrimary else roles.textPrimary.copy(alpha = 0.8f),
            fontSize = BingwaType.Label,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        )
    }
}

@Composable
private fun SelectedOfferCard(offer: Offer) {
    val roles = DesignTokens.LocalBingwaRoles.current
    GlassCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = offer.name,
                color = roles.textPrimary,
                style = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DetailPill(text = offer.type.uppercase())
                DetailPill(text = "Ksh ${offer.price}")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = offer.ussdCode,
                color = roles.textPrimary.copy(alpha = 0.7f),
                fontSize = BingwaType.Footnote,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Float after purchase",
                color = roles.success,
                fontSize = BingwaType.Caption,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun DetailPill(text: String) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .background(roles.brand.copy(alpha = 0.12f))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = roles.brand,
            fontSize = BingwaType.Caption,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun ConfirmSheet(
    visible: Boolean,
    onDismiss: () -> Unit,
    phone: String,
    offer: Offer?,
    mode: DialMode,
    onModeChange: (DialMode) -> Unit,
    onConfirm: () -> Unit,
    enabled: Boolean
) {
    val roles = DesignTokens.LocalBingwaRoles.current

    GlassBottomSheet(visible = visible, onDismiss = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Confirm dial",
                color = roles.textPrimary,
                style = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = formatPhoneDisplay(phone),
                color = roles.textPrimary,
                fontSize = BingwaType.Subhead,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = offer?.name ?: "No offer selected",
                color = roles.textPrimary.copy(alpha = 0.7f),
                fontSize = BingwaType.Body
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Mode",
                color = roles.textPrimary.copy(alpha = 0.6f),
                fontSize = BingwaType.Caption,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ModeChip(
                    label = "Live dial",
                    selected = mode == DialMode.LIVE,
                    onClick = { onModeChange(DialMode.LIVE) }
                )
                ModeChip(
                    label = "Offline queue",
                    selected = mode == DialMode.OFFLINE,
                    onClick = { onModeChange(DialMode.OFFLINE) }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End)
            ) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = onDismiss),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Cancel",
                        color = roles.textSecondary,
                        fontSize = BingwaType.Caption,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusLg))
                        .background(if (enabled) roles.brand else roles.brand.copy(alpha = 0.4f))
                        .clickable(enabled = enabled, onClick = onConfirm)
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Confirm",
                        color = roles.onBrand,
                        fontSize = BingwaType.Label,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun ModeChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val background by animateColorAsState(
        targetValue = if (selected) roles.brand.copy(alpha = 0.12f) else roles.card,
        label = "ModeChipBackground"
    )
    val borderColor by animateColorAsState(
        targetValue = if (selected) roles.brand else roles.border.copy(alpha = 0.4f),
        label = "ModeChipBorder"
    )
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .background(background)
            .border(1.dp, borderColor, RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            color = if (selected) roles.brand else roles.textPrimary.copy(alpha = 0.8f),
            fontSize = BingwaType.Label,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun ResultDialog(outcome: DialResult, onDismiss: () -> Unit) {
    GlassDialog(
        visible = true,
        onDismiss = onDismiss,
        title = if (outcome.successful) "Dial successful" else "Dial failed",
        body = {
            Text(
                text = outcome.response?.takeIf { it.isNotBlank() }
                    ?: "Safaricom did not return a message for this dial.",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                fontSize = BingwaType.Body
            )
        },
        dismissLabel = "Done",
        confirmLabel = "Done",
        onConfirm = onDismiss
    )
}

private fun formatPhoneDisplay(digits: String): String {
    val d = digits.filter { it.isDigit() }
    return when {
        d.isEmpty() -> ""
        d.length <= 2 -> d
        d.length <= 5 -> "${d.substring(0, 2)} ${d.substring(2)}"
        d.length <= 8 -> "${d.substring(0, 2)} ${d.substring(2, 5)} ${d.substring(5)}"
        else -> "${d.substring(0, 2)} ${d.substring(2, 5)} ${d.substring(5, 8)} ${d.substring(8)}"
    }
}
