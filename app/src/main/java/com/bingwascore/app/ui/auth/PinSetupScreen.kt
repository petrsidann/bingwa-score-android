package com.bingwascore.app.ui.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.CheckCircle
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassInputField
import com.bingwascore.app.ui.components.KeypadKey
import com.bingwascore.app.ui.components.NeoButton
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter

/**
 * MEGA B — create your agent account with a phone number and PIN.
 *
 * The PIN is validated (length + confirmation) before anything is written, so a
 * mismatch is reported inline instead of creating an unusable account.
 *
 * UI-only overhaul: ViewModel, Hilt injections and data fetching are unchanged.
 * All colours, typography, spacing and elevation come from DesignTokens.
 */
@Composable
fun PinSetupScreen(
    viewModel: PinSetupViewModel = hiltViewModel(),
    onComplete: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val completed by viewModel.completed.collectAsStateWithLifecycle()
    val haptics = rememberHaptics()

    LaunchedEffect(completed) {
        if (completed) onComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .imePadding(),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Create Account",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Display,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusSm))
                        .background(DesignTokens.LocalBingwaRoles.current.elevated)
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Back",
                        color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Body
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Sign up as an agent. Your PIN unlocks transactions on this device.",
                color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                fontSize = DesignTokens.Typography.Body
            )

            Spacer(modifier = Modifier.height(24.dp))

            GlassCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                    Text(
                        text = "Your name or business name",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    GlassInputField(
                        value = state.name,
                        onValueChange = viewModel::updateName,
                        placeholder = "e.g. Jane Doe or Bingwa Telecoms"
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Phone Number (Kenyan)",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    GlassInputField(
                        value = state.phone,
                        onValueChange = viewModel::updatePhone,
                        placeholder = "0712345678"
                    )
                    state.phoneError?.let { message ->
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            message,
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Email Address",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    GlassInputField(
                        value = state.email,
                        onValueChange = viewModel::updateEmail,
                        placeholder = "agent@example.com"
                    )
                    state.emailError?.let { message ->
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            message,
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    var focusedPinField by remember { mutableStateOf(SignUpPinField.PIN) }

                    PinDotInput(
                        label = "PIN (4 digits)",
                        value = state.pin,
                        isFocused = focusedPinField == SignUpPinField.PIN,
                        onClick = { focusedPinField = SignUpPinField.PIN }
                    )
                    state.pinError?.let { message ->
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            message,
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    PinDotInput(
                        label = "Confirm PIN",
                        value = state.confirmPin,
                        isFocused = focusedPinField == SignUpPinField.CONFIRM,
                        onClick = { focusedPinField = SignUpPinField.CONFIRM }
                    )
                    state.confirmPinError?.let { message ->
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            message,
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    if (state.pinsMismatch) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            "PINs don't match",
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    TactileKeypad(
                        onDigit = { digit ->
                            when (focusedPinField) {
                                SignUpPinField.PIN -> viewModel.appendPinDigit(digit)
                                SignUpPinField.CONFIRM -> viewModel.appendConfirmPinDigit(digit)
                            }
                        },
                        onBackspace = {
                            when (focusedPinField) {
                                SignUpPinField.PIN -> viewModel.backspacePin()
                                SignUpPinField.CONFIRM -> viewModel.backspaceConfirmPin()
                            }
                        }
                    )

                    state.errorMessage?.let { message ->
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            message,
                            color = DesignTokens.LocalBingwaRoles.current.error,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (state.isSuccess) {
                        Row(
                            modifier = Modifier.fillMaxWidth().height(48.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.CheckCircle,
                                contentDescription = "Success",
                                tint = DesignTokens.LocalBingwaRoles.current.success,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Account Created!",
                                color = DesignTokens.LocalBingwaRoles.current.success,
                                fontWeight = FontWeight.Bold,
                                fontSize = DesignTokens.Typography.Body
                            )
                        }
                        LaunchedEffect(Unit) {
                            haptics.tick()
                        }
                    } else {
                    NeoButton(
                        onClick = {
                            haptics.press()
                            viewModel.submit()
                        },
                        enabled = state.isSubmittable && !state.isLoading,
                        text = if (state.isLoading) "Creating Account…" else "Create Account"
                    )
                        if (!state.isSubmittable) {
                            state.submitDisabledReason?.let { reason ->
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    reason,
                                    color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                                    fontSize = DesignTokens.Typography.Caption,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

/** STAGE 44 — which PIN readout the keypad is writing to. */
private enum class SignUpPinField { PIN, CONFIRM }

/**
 * One labelled glass input with a label above the field. ReadOnly — the system
 * keyboard never rises; phone/PIN are driven by TactileKeypad, name/email are
 * editable text fields without explicit keyboard type triggers.
 */
@Composable
private fun GlassInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    Column {
        Text(
            label,
            color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
            fontSize = DesignTokens.Typography.Caption,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                .background(DesignTokens.LocalBingwaRoles.current.card)
                .border(1.dp, DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f), RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                .padding(horizontal = 14.dp, vertical = 14.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                readOnly = false,
                textStyle = TextStyle(
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Body
                ),
                visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(
                    placeholder,
                    color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                    fontSize = DesignTokens.Typography.Body
                )
            }
        }
    }
}

/**
 * 4-dot PIN readout inside a GlassCard. Keypad-driven only; tapping focuses it.
 * The system keyboard never appears.
 */
@Composable
private fun PinDotInput(
    label: String,
    value: String,
    isFocused: Boolean,
    onClick: () -> Unit
) {
    val density = LocalDensity.current
    val glow by animateFloatAsState(
        targetValue = if (isFocused) 1f else 0f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "PinDotFocusGlow"
    )

    val baseBorder = DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f)
    val focusedBorder = DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.8f)
    val borderColor = Color(
        red = baseBorder.red + (focusedBorder.red - baseBorder.red) * glow,
        green = baseBorder.green + (focusedBorder.green - baseBorder.green) * glow,
        blue = baseBorder.blue + (focusedBorder.blue - baseBorder.blue) * glow,
        alpha = baseBorder.alpha + (focusedBorder.alpha - baseBorder.alpha) * glow
    )

    Column {
        Text(
            label,
            color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
            fontSize = DesignTokens.Typography.Caption,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(6.dp))
        GlassCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 14.dp)
                    .border(1.dp, borderColor, RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .clickable { onClick() }
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    repeat(4) { index ->
                        val filled = index < value.length
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(if (filled) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.card)
                                .border(1.dp, DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f), CircleShape)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Tactile keypad: 3x4 grid of NeoButton keys (scale 0.95f on press, LongPress
 * haptic) using Obsidian.card with Elevation.Level1. Backspace has a distinct
 * icon. Drives PIN + Confirm PIN fields; system keyboard never rises.
 */
@Composable
private fun TactileKeypad(
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rows = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9")
        )
        rows.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                row.forEach { digit ->
                    KeypadKey(
                        d = digit,
                        onKey = { onDigit(digit.first()) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.size(64.dp))
            KeypadKey(
                d = "0",
                onKey = { onDigit('0') }
            )
            KeypadKey(
                d = "",
                icon = Icons.Rounded.Backspace,
                onKey = { onBackspace() }
            )
        }
    }
}
