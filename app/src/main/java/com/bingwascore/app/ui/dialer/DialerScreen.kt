package com.bingwascore.app.ui.dialer

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.bingwascore.app.ui.components.GlassDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.domain.engine.UssdConsoleLine
import com.bingwascore.app.domain.engine.UssdSessionEngine
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassPill
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.core.content.ContextCompat

/**
 * Stage 52 — the PURE quick dial surface: tactile POS terminal.
 *
 * A digit-only keypad (no system keyboard), glass bundle cards, a massive Dial
 * Now button and a glass session log. The ViewModel, Hilt wiring, permissions
 * and data fetching are untouched — only UI composition changed.
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
    val consoleOpen: Boolean = false
)

/** Stage 52 — every dialer side effect as a plain callback. */
data class DialerScreenCallbacks(
    val onClose: () -> Unit = {},
    val onPhoneChange: (String) -> Unit = {},
    val onPhoneBlur: () -> Unit = {},
    val onSelectOffer: (Offer) -> Unit = {},
    val onDialNow: () -> Unit = {},
    val onToggleConsole: () -> Unit = {},
    val onRequestPermissions: () -> Unit = {},
    val onConsumeResult: () -> Unit = {}
)

/** Full-screen quick dialer opened from the glass bottom bar call FAB. */
@Composable
fun DialerScreen(onClose: () -> Unit, viewModel: DialerViewModel = hiltViewModel()) {
    // STAGE 19.7 — the wrapper owns the ViewModel, the permission launcher and
    // every one-shot effect the content only reports.
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
    // Stage 9 — live USSD session console lines.
    val consoleLines by viewModel.console.collectAsStateWithLifecycle()
    var consoleOpen by remember { mutableStateOf(false) }

    val state = DialerScreenState(
        offers = offers,
        phone = phone,
        selectedOfferId = selectedOfferId,
        feedback = feedback,
        isDialing = isDialing,
        missingPermissions = missingPermissions,
        result = result,
        consoleLines = consoleLines,
        consoleOpen = consoleOpen
    )

    val callbacks = DialerScreenCallbacks(
        onClose = onClose,
        onPhoneChange = viewModel::setPhone,
        onPhoneBlur = viewModel::formatPhone,
        onSelectOffer = {
            haptics.tick()
            viewModel.selectOffer(it)
        },
        onDialNow = viewModel::dialNow,
        onToggleConsole = {
            haptics.tick()
            consoleOpen = !consoleOpen
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

/**
 * Stage 52 — the pure dialer body: phone display, tactile keypad, glass bundle
 * cards, the Dial Now button and the session log.
 *
 * Nothing here touches a ViewModel, an Activity or a lifecycle: the state comes
 * in, the callbacks go out. No system keyboard ever rises — digits are entered
 * through [TactileKeypad] only.
 */
@Composable
fun DialerScreenContent(
    state: DialerScreenState,
    callbacks: DialerScreenCallbacks = DialerScreenCallbacks()
) {
    val selectedOffer = state.offers.firstOrNull { it.id == state.selectedOfferId }
        ?: state.offers.firstOrNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Quick dial",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Headline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Dial a bundle straight from the terminal",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = callbacks.onClose)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close dialer",
                    tint = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ── Phone input: glass display + tactile keypad, no system keyboard ──
        Text(
            "Phone number",
            color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
            fontSize = DesignTokens.Typography.Caption
        )
        Spacer(modifier = Modifier.height(8.dp))

        val display = formatPhoneDisplay(state.phone)
        GlassCard(
            modifier = Modifier.fillMaxWidth().height(80.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = if (display.isNotBlank()) display else "07XX XXX XXX",
                    color = if (display.isNotBlank()) DesignTokens.Color.Ink else DesignTokens.Color.Ink.copy(alpha = 0.35f),
                    fontSize = DesignTokens.Typography.Display,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        TactileKeypad(
            phone = state.phone,
            onDigit = { callbacks.onPhoneChange(state.phone + it) },
            onBackspace = { callbacks.onPhoneChange(state.phone.dropLast(1)) }
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text("Active offers", color = DesignTokens.Color.Ink.copy(alpha = 0.6f), fontSize = DesignTokens.Typography.Caption)
        Spacer(modifier = Modifier.height(10.dp))

        if (state.offers.isEmpty()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Inbox,
                    contentDescription = null,
                    tint = DesignTokens.Color.Ink.copy(alpha = 0.4f),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "No active offers yet — add one in the Offers tab.",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Body
                )
            }
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(state.offers, key = { it.id }) { offer ->
                    OfferCard(
                        offer = offer,
                        selected = offer.id == selectedOffer?.id,
                        onClick = { callbacks.onSelectOffer(offer) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (state.phone.isNotBlank() && selectedOffer != null) {
            // U1 — live dial truth: the real dial string, split on '*', each
            // segment lighting white -> accent left-to-right while the dial runs.
            DialSegments(
                code = UssdSessionEngine.generateDialString(selectedOffer.ussdCode, state.phone),
                dialing = state.isDialing
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        state.feedback?.let { value ->
            Text(
                text = value.message,
                color = if (value.isError) DesignTokens.Color.Brand.Error else DesignTokens.Color.Brand.Success,
                fontSize = DesignTokens.Typography.Caption,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        DialNowButton(
            enabled = state.phone.isNotBlank() && selectedOffer != null,
            loading = state.isDialing,
            onClick = callbacks.onDialNow
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Stage 9 — collapsible on-screen USSD session console: live step log
        // (code sent, response text, next input, escalation) so every stall
        // is visible without logcat.
        SessionLog(
            lines = state.consoleLines,
            open = state.consoleOpen,
            onToggle = callbacks.onToggleConsole
        )
    }

    // POLISH P1 — the result dialog. The headline is the verdict; the body is the
    // operator's exact reply, because "it failed" without the carrier's wording
    // is the one thing an agent cannot take to Safaricom support.
    state.result?.let { outcome ->
    GlassDialog(
        visible = true,
        onDismiss = callbacks.onConsumeResult,
        title = if (outcome.successful) "Dial successful" else "Dial failed",
        body = {
            Text(
                text = outcome.response?.takeIf { it.isNotBlank() }
                    ?: "Safaricom did not return a message for this dial.",
                color = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                fontSize = DesignTokens.Typography.Caption
            )
        },
        dismissLabel = "Done",
        confirmLabel = "Done",
        onConfirm = callbacks.onConsumeResult
    )
    }
}

/** Formats digits for the terminal display: 07XX XXX XXX. */
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

/** Stage 52 — the tactile keypad: 3x4 grid of pressable keys, no system keyboard. */
@Composable
private fun TactileKeypad(
    phone: String,
    onDigit: (String) -> Unit,
    onBackspace: () -> Unit
) {
    val keys = listOf(
        KeySpec("1"), KeySpec("2"), KeySpec("3"),
        KeySpec("4"), KeySpec("5"), KeySpec("6"),
        KeySpec("7"), KeySpec("8"), KeySpec("9"),
        KeySpec("", icon = Icons.Rounded.Backspace, onClick = onBackspace),
        KeySpec("0"),
        KeySpec("")
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        repeat(4) { rowIndex ->
            Row(
                modifier = Modifier.size(KeypadGrid),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                repeat(3) { colIndex ->
                    val spec = keys[rowIndex * 3 + colIndex]
                    TactileKey(
                        label = spec.label,
                        icon = spec.icon,
                        enabled = spec.label.isNotBlank() || spec.icon != null,
                        onClick = spec.onClick
                    )
                }
            }
            if (rowIndex < 3) Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

private val KeypadGrid: Dp = 216.dp // 3 x 64dp keys + 2 x 12dp gaps

private data class KeySpec(
    val label: String = "",
    val icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    val onClick: () -> Unit = {}
)

/** One tactile key: 64dp circle, springs to 0.95 on press with a haptic LongPress. */
@Composable
private fun TactileKey(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector?,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.95f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "TactileKeyScale"
    )
    val hapticFeedback = LocalHapticFeedback.current

    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(DesignTokens.Color.Card)
            .border(1.dp, DesignTokens.Color.Border, CircleShape)
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                    onClick()
                }
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = DesignTokens.Color.Ink,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(
                    text = label,
                    color = DesignTokens.Color.Ink,
                    fontSize = BingwaType.Label,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

/** Stage 52 — glass bundle card: active tints Brand.Primary, inactive reads the hairline. */
@Composable
private fun OfferCard(offer: Offer, selected: Boolean, onClick: () -> Unit) {
    GlassPill(
        shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd),
        fill = if (selected) DesignTokens.Color.Brand.Primary.copy(alpha = 0.1f) else Color.Transparent,
        borderWidth = if (selected) 2.dp else 1.dp,
        borderColor = if (selected) DesignTokens.Color.Brand.Primary else DesignTokens.Color.Obsidian.Border.copy(alpha = 0.2f),
        baseScale = if (selected) 1.02f else 1f,
        pressScale = 0.98f,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = offer.name,
                color = if (selected) DesignTokens.Color.Ink else DesignTokens.Color.Ink.copy(alpha = 0.9f),
                fontSize = BingwaType.Label,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Ksh ${offer.price}",
                color = if (selected) DesignTokens.Color.Ink.copy(alpha = 0.8f) else DesignTokens.Color.Ink.copy(alpha = 0.5f),
                fontSize = DesignTokens.Typography.Caption
            )
        }
    }
}

/**
 * Stage 52 — the massive Dial Now CTA: full-width button that presses to 0.98,
 * shifts Brand.Primary -> Brand.DimAccent and fires an intense haptic.
 */
@Composable
private fun DialNowButton(
    enabled: Boolean,
    loading: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "DialNowScale"
    )
    val fill by animateColorAsState(
        targetValue = if (isPressed && enabled) DesignTokens.Color.Brand.DimAccent else DesignTokens.Color.Brand.Primary,
        animationSpec = tween(DesignTokens.Motion.DurationFast.toInt()),
        label = "DialNowFill"
    )
    val hapticFeedback = LocalHapticFeedback.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusLg))
            .background(if (enabled) fill else DesignTokens.Color.Brand.Primary.copy(alpha = 0.5f))
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled && !loading,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                    onClick()
                }
            )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = if (loading) "Dialing…" else "Dial Now",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Stage 52 — the session log glass card: real-time dialing steps in monospace
 * Caption, fading in with [animateFloatAsState].
 */
@Composable
private fun SessionLog(
    lines: List<UssdConsoleLine>,
    open: Boolean,
    onToggle: () -> Unit
) {
    val logAlpha by animateFloatAsState(
        targetValue = if (open) 1f else 0f,
        animationSpec = tween(DesignTokens.Motion.DurationNormal.toInt()),
        label = "SessionLogAlpha"
    )

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { alpha = logAlpha }
            .clickable(onClick = onToggle)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Session log",
                    color = DesignTokens.Color.Ink,
                    fontSize = BingwaType.Label,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = if (lines.isEmpty()) "idle" else "${lines.size} steps",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Caption
                )
                Text(
                    text = if (open) "▾" else "▸",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            if (open && lines.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    lines.forEach { line ->
                        Row(modifier = Modifier.padding(vertical = 2.dp)) {
                            Text(
                                text = "[${line.kind}] ",
                                color = when (line.kind) {
                                    "escalation" -> DesignTokens.Color.Brand.Error
                                    "input" -> DesignTokens.Color.Brand.Primary
                                    else -> DesignTokens.Color.Brand.Success
                                },
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(
                                text = line.text,
                                color = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                                fontSize = DesignTokens.Typography.Caption,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            } else if (open) {
                Text(
                    text = "No session yet — dial to watch each step land here.",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
        }
    }
}

/**
 * U1 — the dial string as it is actually being dialled: split on `*`, every
 * segment rendered. Idle: all ink. Dialing: segments turn accent one at a
 * time left-to-right, then all settle to accent.
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
                Text("*", color = DesignTokens.Color.Ink.copy(alpha = 0.3f), fontSize = 12.sp)
            }
            val color = when {
                !dialing -> DesignTokens.Color.Ink
                index < progress -> DesignTokens.Color.Brand.Primary
                index == progress -> DesignTokens.Color.Ink
                else -> DesignTokens.Color.Ink.copy(alpha = 0.4f)
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
