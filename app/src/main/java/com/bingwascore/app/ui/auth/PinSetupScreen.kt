package com.bingwascore.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.rememberHaptics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.screenEnter

/**
 * MEGA B — create your agent account with a phone number and PIN.
 *
 * The PIN is validated (length + confirmation) before anything is written, so a
 * mismatch is reported inline instead of creating an unusable account.
 */
@Composable
fun PinSetupScreen(
    viewModel: PinSetupViewModel = hiltViewModel(),
    onComplete: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val completed by viewModel.completed.collectAsStateWithLifecycle()

    LaunchedEffect(completed) {
        if (completed) onComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {

        val haptics = rememberHaptics()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .imePadding()
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Create Account",
                    color = TextWhite,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Back",
                        color = TextWhite.copy(alpha = 0.6f),
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Sign up as an agent. Your PIN unlocks transactions on this device.",
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            BubbleCard(modifier = Modifier.fillMaxWidth()) {
                // STAGE 44 — ONE account type (AGENT). No Individual/Business
                // toggle; one name field covers both cases.
                PinField(
                    label = "Your name or business name",
                    value = state.name,
                    onValueChange = viewModel::updateName,
                    placeholder = "e.g. Jane Doe or Bingwa Telecoms",
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "Phone Number (Kenyan)",
                    value = state.phone,
                    onValueChange = viewModel::updatePhone,
                    placeholder = "0712345678",
                    keyboardType = KeyboardType.Phone
                )
                state.phoneError?.let { message ->
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(message, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "Email Address",
                    value = state.email,
                    onValueChange = viewModel::updateEmail,
                    placeholder = "agent@example.com",
                    keyboardType = KeyboardType.Email
                )
                state.emailError?.let { message ->
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(message, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Spacer(modifier = Modifier.height(14.dp))

                // STAGE 44 — keypad-only PINs. PIN and Confirm PIN are 4-dot
                // readouts driven by the SAME custom keypad as login; the
                // system keyboard never appears for them.
                var focusedPinField by remember { mutableStateOf(SignUpPinField.PIN) }

                PinDotField(
                    label = "PIN (4 digits)",
                    value = state.pin,
                    isFocused = focusedPinField == SignUpPinField.PIN,
                    onClick = { focusedPinField = SignUpPinField.PIN }
                )
                state.pinError?.let { message ->
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(message, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Spacer(modifier = Modifier.height(14.dp))

                PinDotField(
                    label = "Confirm PIN",
                    value = state.confirmPin,
                    isFocused = focusedPinField == SignUpPinField.CONFIRM,
                    onClick = { focusedPinField = SignUpPinField.CONFIRM }
                )
                state.confirmPinError?.let { message ->
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(message, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }
                if (state.pinsMismatch) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("PINs don't match", color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Spacer(modifier = Modifier.height(16.dp))

                SignUpKeypad(
                    onDigit = { digit ->
                        haptics.tick()
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
                    Text(message, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
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
                            tint = TickGreen,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Account Created!", color = TickGreen, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    LaunchedEffect(Unit) {
                        haptics.tick()
                    }
                } else {
                    PrimaryButton(
                        text = "Create Account",
                        loading = state.isLoading,
                        loadingText = "Creating Account…",
                        enabled = state.isSubmittable && !state.isLoading,
                        onClick = {
                            haptics.press()
                            viewModel.submit()
                        },
                        modifier = Modifier.fillMaxWidth().height(48.dp)
                    )
                    // STAGE 44 — a disabled button always says WHY.
                    if (!state.isSubmittable) {
                        state.submitDisabledReason?.let { reason ->
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                reason,
                                color = TextFaint,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
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
 * STAGE 44 — a 4-dot PIN readout, keypad-driven only. Tapping focuses it
 * (2dp brand-blue border); the system keyboard never appears.
 */
@Composable
private fun PinDotField(
    label: String,
    value: String,
    isFocused: Boolean,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(14.dp)
    val focusedBorderColor = if (com.bingwascore.app.ui.theme.isPorcelain)
        androidx.compose.ui.graphics.Color(0xFF2F6AE0)
    else
        androidx.compose.ui.graphics.Color(0xFF2563EB)
    Column {
        Text(label, color = TextFaint, fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Bubble)
                .border(if (isFocused) 2.dp else 1.dp, if (isFocused) focusedBorderColor else Hairline, shape)
                .clickable { onClick() }
                .padding(horizontal = 14.dp, vertical = 14.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                repeat(4) { index ->
                    val filled = index < value.length
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(androidx.compose.foundation.shape.CircleShape)
                            .background(if (filled) AccentBlue else Bubble)
                            .border(1.dp, Hairline, androidx.compose.foundation.shape.CircleShape)
                    )
                }
            }
        }
    }
}

/** STAGE 44 — the SAME custom keypad contract as login: 3x4 grid + backspace. */
@Composable
private fun SignUpKeypad(
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
                    SignUpKeypadKey(label = digit) { onDigit(digit.first()) }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.size(64.dp))
            SignUpKeypadKey(label = "0") { onDigit('0') }
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(androidx.compose.foundation.shape.CircleShape)
                    .background(Bubble)
                    .border(1.dp, Hairline, androidx.compose.foundation.shape.CircleShape)
                    .clickable { onBackspace() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Backspace,
                    contentDescription = "Delete",
                    tint = TextWhite.copy(alpha = 0.7f),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
private fun SignUpKeypadKey(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(androidx.compose.foundation.shape.CircleShape)
            .background(Bubble)
            .border(1.dp, Hairline, androidx.compose.foundation.shape.CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = TextWhite,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/** One labelled glass input. */
@Composable
private fun PinField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(label, color = TextFaint, fontSize = 11.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Bubble)
                .border(1.dp, Hairline, RoundedCornerShape(14.dp))
                .padding(horizontal = 14.dp, vertical = 14.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = TextWhite, fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
                cursorBrush = SolidColor(AccentBlue),
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(placeholder, color = TextFaint, fontSize = 15.sp)
            }
        }
    }
}
