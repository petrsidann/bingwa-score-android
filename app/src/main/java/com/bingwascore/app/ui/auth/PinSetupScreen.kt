package com.bingwascore.app.ui.auth

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
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
import androidx.compose.material.icons.rounded.Check
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.glass.PhaseChips
import com.bingwascore.app.ui.glass.PhaseCta
import com.bingwascore.app.ui.glass.PhaseDisplay
import com.bingwascore.app.ui.glass.PhaseKeypad
import com.bingwascore.app.ui.glass.PhaseMedallion
import com.bingwascore.app.ui.glass.PhaseScreen
import com.bingwascore.app.ui.glass.PhaseSurface
import com.bingwascore.app.ui.glass.PhaseTextField
import com.bingwascore.app.util.formatPhoneToTenDigits
import com.bingwascore.app.util.isTenDigitPhone
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
    val haptics = rememberHaptics()
    var step by remember { mutableStateOf(SetupStep.IDENTITY) }
    var focusedPinField by remember { mutableStateOf(SignUpPinField.PIN) }

    LaunchedEffect(completed) { if (completed) onComplete() }

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
                    if (step == SetupStep.IDENTITY) onBack() else {
                        step = SetupStep.values()[step.ordinal - 1]
                    }
                }
            )
            Box(
                Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    step.name,
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
            SetupStep.IDENTITY -> IdentityStep(
                state = state,
                viewModel = viewModel,
                onContinue = { step = SetupStep.PHONE }
            )
            SetupStep.PHONE -> PhoneStep(
                state = state,
                viewModel = viewModel,
                onContinue = { step = SetupStep.SECURE }
            )
            SetupStep.SECURE -> SecureStep(
                state = state,
                viewModel = viewModel,
                focusedPinField = focusedPinField,
                onFocusedPinFieldChange = { focusedPinField = it },
                onSubmit = {
                    haptics.press()
                    viewModel.submit()
                }
            )
        }

        if (state.isSuccess) {
            Spacer(Modifier.height(24.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PhaseMedallion(icon = Icons.Rounded.Check, violet = false)
                Spacer(Modifier.height(16.dp))
                Text(
                    "Account Created!",
                    color = PhaseSurface.Lime,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            LaunchedEffect(Unit) { haptics.tick() }
        }
    }
}

@Composable
private fun IdentityStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    onContinue: () -> Unit
) {
    Column {
        PhaseTextField(
            label = "Name or business name",
            value = state.name,
            onValueChange = viewModel::updateName,
            placeholder = "e.g. Jane Doe or Bingwa Telecoms",
            isError = false,
            errorMsg = "",
            keyboardType = KeyboardType.Text
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

@Composable
private fun PhoneStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    onContinue: () -> Unit
) {
    val valid = isTenDigitPhone(formatPhoneToTenDigits(state.phone))
    val utilityText = "+254"
    Column {
        PhaseDisplay(
            label = "Phone",
            value = displayPhone(state.phone),
            placeholder = "0712345678",
            hint = state.phoneError ?: "Enter your Kenyan phone number",
            hintBad = !state.phoneError.isNullOrBlank(),
            showCaret = state.phone.isNotEmpty()
        )
        Spacer(Modifier.height(24.dp))
        PhaseKeypad(
            onDigit = { viewModel.updatePhone(state.phone + it) },
            onBackspace = { if (state.phone.isNotEmpty()) viewModel.updatePhone(state.phone.dropLast(1)) },
            onClear = { viewModel.updatePhone("") },
            onSubmit = onContinue,
            onNext = onContinue,
            submitEnabled = valid,
            onUtil = null,
            utilityIcon = null
        )
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 14.dp)
        ) {
            PhaseCta(label = "Continue", ready = valid, onClick = onContinue)
        }
    }
}

@Composable
private fun SecureStep(
    state: PinSetupState,
    viewModel: PinSetupViewModel,
    focusedPinField: SignUpPinField,
    onFocusedPinFieldChange: (SignUpPinField) -> Unit,
    onSubmit: () -> Unit
) {
    val utilityIcon = Icons.Rounded.Fingerprint
    val activeValue = if (focusedPinField == SignUpPinField.PIN) state.pin else state.confirmPin
    val activeError = if (focusedPinField == SignUpPinField.PIN) state.pinError else state.confirmPinError
    val hint = when {
        state.pinsMismatch && focusedPinField == SignUpPinField.CONFIRM -> "PINs don't match"
        !activeError.isNullOrBlank() -> activeError
        else -> "Enter your 4-digit PIN"
    }
    Column {
        PhaseDisplay(
            label = if (focusedPinField == SignUpPinField.PIN) "PIN" else "Confirm PIN",
            value = "",
            placeholder = "",
            hint = hint,
            hintBad = !activeError.isNullOrBlank() || state.pinsMismatch && focusedPinField == SignUpPinField.CONFIRM,
            showCaret = false,
            pinCount = activeValue.length
        )
        Spacer(Modifier.height(16.dp))
        PhaseChips(
            labels = listOf("PIN", "Confirm"),
            selected = if (focusedPinField == SignUpPinField.PIN) 0 else 1,
            onSelect = { onFocusedPinFieldChange(if (it == 0) SignUpPinField.PIN else SignUpPinField.CONFIRM) }
        )
        Spacer(Modifier.height(24.dp))
        PhaseKeypad(
            onDigit = {
                when (focusedPinField) {
                    SignUpPinField.PIN -> viewModel.appendPinDigit(it)
                    SignUpPinField.CONFIRM -> viewModel.appendConfirmPinDigit(it)
                }
            },
            onBackspace = {
                when (focusedPinField) {
                    SignUpPinField.PIN -> viewModel.backspacePin()
                    SignUpPinField.CONFIRM -> viewModel.backspaceConfirmPin()
                }
            },
            onClear = {
                if (focusedPinField == SignUpPinField.PIN) {
                    repeat(state.pin.length) { viewModel.backspacePin() }
                } else {
                    repeat(state.confirmPin.length) { viewModel.backspaceConfirmPin() }
                }
            },
            onSubmit = onSubmit,
            onNext = { onFocusedPinFieldChange(if (focusedPinField == SignUpPinField.PIN) SignUpPinField.CONFIRM else SignUpPinField.PIN) },
            submitEnabled = state.isSubmittable,
            onUtil = null,
            utilIcon = utilityIcon
        )
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 14.dp)
        ) {
            PhaseCta(
                label = if (state.isLoading) "Creating Account..." else "Create account",
                ready = state.isSubmittable && !state.isLoading,
                onClick = onSubmit
            )
        }
    }
}

private fun displayPhone(digits: String): String {
    if (digits.length <= 4) return digits
    val first = digits.take(4)
    val rest = digits.drop(4).chunked(3)
    return listOf(first, *rest.toTypedArray()).joinToString(" ")
}
