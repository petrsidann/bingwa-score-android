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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Set up your PIN",
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
                "Create an agent account. Your PIN unlocks purchases on this phone.",
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(20.dp))
            BubbleCard(modifier = Modifier.fillMaxWidth()) {
                PinField(
                    label = "Phone number",
                    value = state.phone,
                    onValueChange = viewModel::updatePhone,
                    placeholder = "0712345678"
                )

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "PIN",
                    value = state.pin,
                    onValueChange = viewModel::updatePin,
                    placeholder = "At least 4 digits"
                )

                Spacer(modifier = Modifier.height(14.dp))

                PinField(
                    label = "Confirm PIN",
                    value = state.confirmPin,
                    onValueChange = viewModel::updateConfirmPin,
                    placeholder = "Repeat your PIN"
                )

                state.errorMessage?.let { message ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(message, color = FailRed, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(18.dp))
                PrimaryButton(
                    text = if (state.isLoading) "Creating…" else "Create account",
                    enabled = state.isSubmittable && !state.isLoading,
                    onClick = viewModel::submit
                )
            }
        }
    }
}

/** One labelled glass input. */
@Composable
private fun PinField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column {
        Text(label, color = TextWhite.copy(alpha = 0.45f), fontSize = 11.sp)
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
                textStyle = TextStyle(color = TextWhite, fontSize = 16.sp, letterSpacing = 1.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                cursorBrush = SolidColor(AccentBlue),
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(placeholder, color = TextWhite.copy(alpha = 0.45f), fontSize = 15.sp)
            }
        }
    }
}
