package com.bingwascore.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MarkEmailRead
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
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.screenEnter

/**
 * MEGA B — verify your email with a one-time code.
 *
 * The 120-second countdown is real and starts the moment a code is requested,
 * including in the offline stub, so the whole flow is testable today.
 */
@Composable
fun EmailOtpScreen(
    viewModel: EmailOtpViewModel = hiltViewModel(),
    onVerified: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val verified by viewModel.verified.collectAsStateWithLifecycle()

    var code by remember { mutableStateOf("") }

    // Start the countdown as soon as a challenge exists.
    LaunchedEffect(state.challenge) {
        if (state.challenge != null) viewModel.startCountdown()
    }
    LaunchedEffect(verified) {
        if (verified) onVerified()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Verify your email",
                    color = TextWhite,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "Back",
                    color = TextWhite.copy(alpha = 0.6f),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onBack() }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                if (state.isAwaitingCode) {
                    "We sent a 6-digit code to ${state.email}"
                } else {
                    "Enter your email and we'll send a one-time code."
                },
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(20.dp))
            BubbleCard(modifier = Modifier.fillMaxWidth()) {
                OtpField(
                    value = if (state.isAwaitingCode) code else state.email,
                    onValueChange = {
                        if (state.isAwaitingCode) {
                            code = it.filter { char -> char.isDigit() }
                            viewModel.clearError()
                        } else {
                            viewModel.updateEmail(it)
                        }
                    },
                    placeholder = if (state.isAwaitingCode) "6-digit code" else "you@example.com",
                    numeric = state.isAwaitingCode
                )

                // The live countdown, only while a code is still valid.
                if (state.isAwaitingCode) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Rounded.MarkEmailRead,
                            contentDescription = null,
                            tint = TickGreen,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Code expires in ${state.countdownText}",
                            color = TickGreen,
                            fontSize = 12.sp
                        )
                    }
                }

                state.errorMessage?.let { message ->
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(message, color = FailRed, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))
                PrimaryButton(
                    text = when {
                        state.isLoading -> "Working…"
                        state.isAwaitingCode -> "Verify code"
                        else -> "Send code"
                    },
                    enabled = !state.isLoading,
                    onClick = {
                        if (state.isAwaitingCode) {
                            viewModel.verifyCode(code)
                            code = ""
                        } else {
                            viewModel.requestCode(state.email)
                        }
                    }
                )
            }
        }
    }
}

/** One glass input, used for both the email and the OTP. */
@Composable
private fun OtpField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    numeric: Boolean
) {
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
            textStyle = TextStyle(
                color = TextWhite,
                fontSize = 16.sp,
                letterSpacing = if (numeric) 4.sp else 1.sp
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = if (numeric) KeyboardType.NumberPassword else KeyboardType.Email
            ),
            cursorBrush = SolidColor(AccentBlue),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isEmpty()) {
            Text(placeholder, color = TextWhite.copy(alpha = 0.45f), fontSize = 16.sp)
        }
    }
}
