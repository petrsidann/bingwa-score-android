package com.bingwascore.app.ui.dialer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.domain.engine.UssdSessionEngine
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import kotlinx.coroutines.delay
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.accentBrush
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite

/** Full-screen quick dialer opened from the glass bottom bar call FAB. */
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

    // REBRAND R5 — the dial cannot work without these, so we ask up front instead
    // of letting a service fail silently in the background.
    val permissionLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions()
    ) { granted -> granted.values.forEach { if (it) haptics.tick() } }

    LaunchedEffect(Unit) {
        val missing = viewModel.missingDialPermissions()
        if (missing.isNotEmpty()) {
            haptics.error()
            permissionLauncher.launch(
                arrayOf(
                    android.Manifest.permission.CALL_PHONE,
                    android.Manifest.permission.READ_PHONE_STATE
                )
            )
        }
    }

    // Parity E — every dial outcome gets a tactile confirmation.
    LaunchedEffect(feedback) {
        feedback?.let { if (it.isError) haptics.error() else haptics.success() }
    }

    // POLISH P1 — the verdict is its own moment: haptic, then the dialog that
    // quotes Safaricom back to the agent word for word.
    LaunchedEffect(result) {
        result?.let { if (it.successful) haptics.success() else haptics.error() }
    }

    val selectedOffer = offers.firstOrNull { it.id == selectedOfferId } ?: offers.firstOrNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Quick dial", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Dial a bundle straight from the app",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onClose)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close dialer",
                    tint = TextWhite.copy(alpha = 0.7f),
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        GlassPhoneField(
            value = phone,
            onValueChange = viewModel::setPhone,
            // Parity E — normalise to 07XXXXXXXX the moment the field blurs.
            onBlur = viewModel::formatPhone
        )

        Spacer(modifier = Modifier.height(22.dp))
        Text("Active offers", color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
        Spacer(modifier = Modifier.height(10.dp))

        if (offers.isEmpty()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Inbox,
                    contentDescription = null,
                    tint = TextFaint,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "No active offers yet — add one in the Offers tab.",
                    color = TextFaint,
                    fontSize = 13.sp
                )
            }
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(offers, key = { it.id }) { offer ->
                    OfferChip(
                        offer = offer,
                        selected = offer.id == selectedOffer?.id,
                        onClick = {
                            haptics.tick()
                            viewModel.selectOffer(offer)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        if (phone.isNotBlank() && selectedOffer != null) {
            // U1 — live dial truth: the real dial string, split on '*', each
            // segment lighting white -> accent left-to-right while the dial runs.
            DialSegments(
                code = UssdSessionEngine.generateDialString(selectedOffer.ussdCode, phone),
                dialing = isDialing
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        feedback?.let { value ->
            Text(
                value.message,
                color = if (value.isError) FailRed else TickGreen,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        PrimaryButton(
            text = "Dial Now",
            enabled = phone.isNotBlank() && selectedOffer != null,
            loading = isDialing,
            loadingText = "Dialing...",
            onClick = viewModel::dialNow
        )
    }

    // POLISH P1 — the result dialog. The headline is the verdict; the body is the
    // operator's exact reply, because "it failed" without the carrier's wording
    // is the one thing an agent cannot take to Safaricom support.
    result?.let { outcome ->
        androidx.compose.material3.AlertDialog(
            onDismissRequest = viewModel::consumeResult,
            containerColor = Bubble,
            titleContentColor = TextWhite,
            textContentColor = TextGrey,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (outcome.successful) {
                            Icons.Rounded.CheckCircle
                        } else {
                            Icons.Rounded.ErrorOutline
                        },
                        contentDescription = null,
                        tint = if (outcome.successful) TickGreen else FailRed,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        if (outcome.successful) "Dial successful" else "Dial failed",
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
            },
            text = {
                Text(
                    text = outcome.response?.takeIf { it.isNotBlank() }
                        ?: "Safaricom did not return a message for this dial.",
                    color = TextGrey,
                    fontSize = 13.sp
                )
            },
            confirmButton = {
                androidx.compose.material3.TextButton(onClick = viewModel::consumeResult) {
                    Text("Done", color = AccentBlue, fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}

/**
 * U1 — the dial string as it is actually being dialled: split on `*`, every
 * segment rendered. Idle: all white. Dialing: segments turn accent one at a
 * time left-to-right (the `180` in `*180*...` reads white the instant it is
 * in flight), then all settle to accent. The green status line below it is
 * unchanged — this row is truth, not decoration.
 */
@Composable
private fun DialSegments(code: String, dialing: Boolean) {
    val segments = remember(code) { code.split('*') }
    // Index of the segment currently in flight; -1 when idle.
    var progress by remember(code) { mutableIntStateOf(-1) }

    LaunchedEffect(dialing, code) {
        if (!dialing) {
            progress = -1
        } else {
            // Walk the segments at a steady clip; the dial itself decides when
            // it ends — this only mirrors "where are we in the string".
            for (i in segments.indices) {
                progress = i
                delay(U1_SEGMENT_STEP_MILLIS)
            }
            progress = segments.size
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        segments.forEachIndexed { index, segment ->
            if (index > 0) {
                Text("*", color = TextFaint, fontSize = 12.sp)
            }
            val color = when {
                !dialing -> TextWhite
                index < progress -> AccentBlue
                index == progress -> TextWhite
                else -> TextFaint
            }
            Text(
                text = segment,
                color = color,
                fontSize = 12.sp,
                fontWeight = if (index == progress && dialing) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

/** U1 — cadence of the segment walk (visual only; the verdict is the engine's). */
private const val U1_SEGMENT_STEP_MILLIS = 260L

@Composable
private fun GlassPhoneField(
    value: String,
    onValueChange: (String) -> Unit,
    onBlur: () -> Unit = {}
) {
    val shape = RoundedCornerShape(18.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Brush.verticalGradient(listOf(Hairline, Color.Transparent)), shape)
            .padding(horizontal = 16.dp, vertical = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null,
                tint = TextFaint,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier.weight(1f)) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    textStyle = TextStyle(
                        color = TextWhite,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    ),
                    cursorBrush = SolidColor(AccentBlue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState -> if (!focusState.isFocused) onBlur() }
                )
                if (value.isEmpty()) {
                    Text(
                        "07XX XXX XXX",
                        color = TextFaint,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun OfferChip(offer: Offer, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(16.dp)
    val interactionSource = remember { MutableInteractionSource() }
    val base = if (selected) {
        Modifier
            .clip(shape)
            .pressScale(interactionSource)
            .background(accentBrush())
    } else {
        Modifier
            .clip(shape)
            .pressScale(interactionSource)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
    }
    Column(
        modifier = base
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Text(
            offer.name,
            color = if (selected) BgBlack else TextWhite,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Ksh ${offer.price}",
            color = if (selected) BgBlack.copy(alpha = 0.7f) else TextWhite.copy(alpha = 0.5f),
            fontSize = 11.sp
        )
    }
}

