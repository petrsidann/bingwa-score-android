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
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.rememberHaptics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
                // Account Type Toggle
                Text("Account Type", color = TextFaint, fontSize = 11.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(Bubble)
                        .border(1.dp, Hairline, RoundedCornerShape(14.dp))
                        .padding(4.dp)
                ) {
                    listOf("Individual", "Business").forEach { type ->
                        val selected = state.accountType.equals(type, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (selected) AccentBlue else androidx.compose.ui.graphics.Color.Transparent)
                                .clickable {
                                    haptics.tick()
                                    viewModel.updateAccountType(type)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                type,
                                color = if (selected) com.bingwascore.app.ui.theme.BgBlack else TextWhite,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = if (state.accountType == "Business") "Business Name" else "Full Name",
                    value = state.name,
                    onValueChange = viewModel::updateName,
                    placeholder = if (state.accountType == "Business") "e.g. Bingwa Telecoms" else "e.g. Jane Doe",
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

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "Email Address",
                    value = state.email,
                    onValueChange = viewModel::updateEmail,
                    placeholder = "agent@example.com",
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "PIN (4 digits)",
                    value = state.pin,
                    onValueChange = viewModel::updatePin,
                    placeholder = "4 digits",
                    isPassword = true,
                    keyboardType = KeyboardType.NumberPassword
                )

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "Confirm PIN",
                    value = state.confirmPin,
                    onValueChange = viewModel::updateConfirmPin,
                    placeholder = "4 digits",
                    isPassword = true,
                    keyboardType = KeyboardType.NumberPassword
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
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
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
