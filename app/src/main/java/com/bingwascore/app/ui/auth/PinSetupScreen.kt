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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.NeoButton
import com.bingwascore.app.ui.glass.PhaseKeypad
import com.bingwascore.app.ui.glass.PhasePinDots
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
    var mode by remember { mutableStateOf(EntryMode.PIN) }
    var focusedPinField by remember { mutableStateOf(SignUpPinField.PIN) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

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
                    style = DesignTokens.Typography.Display,
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                    .background(DesignTokens.LocalBingwaRoles.current.card)
                    .border(1.dp, DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f), RoundedCornerShape(DesignTokens.Shape.RadiusMd))
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
                        placeholder = "e.g. Jane Doe or Bingwa Telecoms",
                        onFocusChange = { if (it) mode = EntryMode.TEXT }
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
                        placeholder = "0712345678",
                        onFocusChange = { if (it) mode = EntryMode.TEXT }
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
                        placeholder = "agent@example.com",
                        onFocusChange = { if (it) mode = EntryMode.TEXT }
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

                    Text(
                        text = "PIN (4 digits)",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    PhasePinDots(
                        count = state.pin.length,
                        active = mode == EntryMode.PIN && focusedPinField == SignUpPinField.PIN,
                        onTap = {
                            focusedPinField = SignUpPinField.PIN
                            mode = EntryMode.PIN
                            focusManager.clearFocus()
                            keyboardController?.hide()
                        }
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

                    Text(
                        text = "Confirm PIN",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary.copy(alpha = 0.6f),
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    PhasePinDots(
                        count = state.confirmPin.length,
                        active = mode == EntryMode.PIN && focusedPinField == SignUpPinField.CONFIRM,
                        onTap = {
                            focusedPinField = SignUpPinField.CONFIRM
                            mode = EntryMode.PIN
                            focusManager.clearFocus()
                            keyboardController?.hide()
                        }
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

                    if (mode == EntryMode.PIN) {
                        Spacer(modifier = Modifier.height(16.dp))
                        PhaseKeypad(
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
                    }

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

private enum class EntryMode { TEXT, PIN }

/**
 * One labelled glass input with a label above the field. ReadOnly — the system
 * keyboard never rises; phone/PIN are driven by TactileKeypad, name/email are
 * editable text fields without explicit keyboard type triggers.
 */
@Composable
private fun GlassInputField(
    label: String = "",
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    onFocusChange: (Boolean) -> Unit = {}
) {
    var focused by remember { mutableStateOf(false) }
    val borderColor = if (focused) DesignTokens.Launch.lime else DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f)
    val borderWidth = if (focused) 1.5.dp else 1.dp
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
                .border(borderWidth, borderColor, RoundedCornerShape(DesignTokens.Shape.RadiusMd))
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
                modifier = Modifier.fillMaxWidth().onFocusChanged {
                    focused = it.isFocused
                    onFocusChange(it.isFocused)
                }
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
