package com.bingwascore.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Fingerprint
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.glass.PhaseCta
import com.bingwascore.app.ui.glass.PhaseDisplay
import com.bingwascore.app.ui.glass.PhaseKeypad
import com.bingwascore.app.ui.glass.PhasePinDots
import com.bingwascore.app.ui.glass.PhaseScreen
import com.bingwascore.app.ui.glass.PhaseSurface
import com.bingwascore.app.ui.glass.PhaseTextField
import com.bingwascore.app.util.rememberHaptics

private enum class SetupStep { IDENTITY, PHONE, SECURE }

private enum class SignUpPinField { PIN, CONFIRM }

@Composable
fun PinSetupScreen(
    viewModel: PinSetupViewModel = hiltViewModel(),
    onComplete: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val completed by viewModel.completed.collectAsStateWithLifecycle()
    var step by remember { mutableStateOf(SetupStep.IDENTITY) }
    var focusedPinField by remember { mutableStateOf(SignUpPinField.PIN) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val haptics = rememberHaptics()

    LaunchedEffect(completed) { if (completed) onComplete() }

    val title = when (step) {
        SetupStep.IDENTITY -> "Create Account"
        SetupStep.PHONE -> "Phone Number"
        SetupStep.SECURE -> "Create PIN"
    }

    PhaseScreen {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = PhaseSurface.Ink,
                modifier = Modifier.size(24.dp).clickable {
                    if (step == SetupStep.IDENTITY) onBack() else step = SetupStep.values()[step.ordinal - 1]
                }
            )
            Box(Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
                Text(
                    step.name.uppercase(),
                    color = PhaseSurface.Mut,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.6.sp
                )
            }
        }

        Spacer(Modifier.height(18.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            SetupStep.values().forEach { s ->
                Box(
                    Modifier.weight(1f).height(4.dp)
                        .background(if (s.ordinal <= step.ordinal) PhaseSurface.Lime else Color.White.copy(alpha = 0.1f))
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        when (step) {
            SetupStep.IDENTITY -> IdentityStep(state, viewModel) { step = SetupStep.PHONE }
            SetupStep.PHONE -> PhoneStep(state, viewModel) { step = SetupStep.SECURE }
            SetupStep.SECURE -> SecureStep(state, viewModel, focusedPinField, { focusedPinField = it })
        }

        Spacer(Modifier.height(24.dp))

        if (state.isSuccess) {
            Row(
                modifier = Modifier.fillMaxWidth().height(48.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = "Success",
                    tint = PhaseSurface.Lime,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Account Created!",
                    color = PhaseSurface.Lime,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            LaunchedEffect(Unit) { haptics.tick() }
        }

        state.errorMessage?.let { message ->
            Spacer(Modifier.height(12.dp))
            Text(
                message,
                color = PhaseSurface.Lime,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(Modifier.navigationBarsPadding())
    }
}

@Composable
private fun IdentityStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    onContinue: () -> Unit
) {
    Column {
        Text(
            "Create Account",
            color = PhaseSurface.Ink,
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "Sign up as an agent. Your PIN unlocks transactions on this device.",
            color = PhaseSurface.Mut,
            fontSize = 13.sp
        )
        Spacer(Modifier.height(24.dp))
        PhaseTextField(
            label = "Name or business name",
            value = state.name,
            onValueChange = viewModel::updateName,
            placeholder = "e.g. Jane Doe or Bingwa Telecoms",
            isError = false,
            errorMsg = ""
        )
        Spacer(Modifier.height(16.dp))
        PhaseTextField(
            label = "Email address",
            value = state.email,
            onValueChange = viewModel::updateEmail,
            placeholder = "agent@example.com",
            isError = !state.emailError.isNullOrBlank(),
            errorMsg = state.emailError ?: "",
            keyboardType = KeyboardType.Email
        )
        Spacer(Modifier.height(24.dp))
        PhaseCta(
            label = "Continue",
            ready = state.name.isNotBlank() && state.isEmailValid,
            onClick = onContinue
        )
    }
}

private fun displayPhone(digits: String): String {
    if (digits.length <= 4) return digits
    val first = digits.take(4)
    val rest = digits.drop(4).chunked(3)
    return listOf(first, *rest.toTypedArray()).joinToString(" ")
}

@Composable
private fun PhoneStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    onContinue: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val hint = state.phoneError ?: "Enter your Kenyan phone number"
    Column {
        PhaseDisplay(
            label = "Phone",
            value = displayPhone(state.phone),
            placeholder = "0712345678",
            hint = hint,
            hintBad = !state.phoneError.isNullOrBlank(),
            showCaret = state.phone.isNotEmpty()
        )
        Spacer(Modifier.height(16.dp))
        PhaseKeypad(
            onDigit = { viewModel.updatePhone(state.phone + it) },
            onBackspace = { viewModel.updatePhone(state.phone.dropLast(1)) },
            onClear = { viewModel.updatePhone("") },
            onSubmit = { },
            onNext = {
                if (com.bingwascore.app.util.isTenDigitPhone(state.phone)) onContinue()
            },
            onUtilityClick = { },
            utilityIcon = null,
            utilityText = "+254",
            submitEnabled = false
        )
    }
}

@Composable
private fun SecureStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    focusedPinField: SignUpPinField,
    onFocusedPinFieldChange: (SignUpPinField) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        PhasePinDots(
            count = state.pin.length,
            active = focusedPinField == SignUpPinField.PIN,
            onTap = {
                onFocusedPinFieldChange(SignUpPinField.PIN)
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        )
        state.pinError?.let { error ->
            Spacer(Modifier.height(6.dp))
            Text(error, color = PhaseSurface.Lime, fontSize = 12.sp)
        }
        Spacer(Modifier.height(16.dp))
        PhasePinDots(
            count = state.confirmPin.length,
            active = focusedPinField == SignUpPinField.CONFIRM,
            onTap = {
                onFocusedPinFieldChange(SignUpPinField.CONFIRM)
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        )
        state.confirmPinError?.let { error ->
            Spacer(Modifier.height(6.dp))
            Text(error, color = PhaseSurface.Lime, fontSize = 12.sp)
        }
        if (state.pinsMismatch) {
            Spacer(Modifier.height(6.dp))
            Text("PINs don't match", color = PhaseSurface.Lime, fontSize = 12.sp)
        }
        Spacer(Modifier.height(16.dp))
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
            },
            onClear = {
                when (focusedPinField) {
                    SignUpPinField.PIN -> {
                        var current = state.pin
                        while (current.isNotEmpty()) {
                            viewModel.backspacePin()
                            current = current.dropLast(1)
                        }
                    }
                    SignUpPinField.CONFIRM -> {
                        var current = state.confirmPin
                        while (current.isNotEmpty()) {
                            viewModel.backspaceConfirmPin()
                            current = current.dropLast(1)
                        }
                    }
                }
            },
            onSubmit = { viewModel.submit() },
            onNext = { },
            onUtilityClick = { },
            utilityIcon = Icons.Rounded.Fingerprint,
            utilityText = null,
            submitEnabled = state.isSubmittable && !state.isLoading
        )
    }
}
