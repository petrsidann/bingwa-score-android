package com.bingwascore.app.ui.screens

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.util.screenEnter
import java.util.concurrent.Executor

@Composable
fun LoginScreen(
    onSignIn: () -> Unit = {},
    onCreateAccount: () -> Unit = {}
) {
    val context = LocalContext.current
    var phone by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    // MEGA A — a numeric keypad with a fingerprint affordance. Biometrics is a
    // shortcut for the *same* sign-in action; if the device has no sensor (or
    // enrolment fails) we simply fall back to typing the PIN below.
    val activity = context as? FragmentActivity
    val biometricAvailable = remember {
        runCatching {
            val manager = BiometricManager.from(context)
            manager.canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_WEAK
            ) == BiometricManager.BIOMETRIC_SUCCESS
        }.getOrDefault(false)
    }

    // The prompt is remembered across recompositions so a rotation mid-prompt
    // does not leak a second BiometricPrompt instance.
    val biometricPrompt = remember(activity) {
        activity?.let {
            val executor: Executor = androidx.core.content.ContextCompat.getMainExecutor(it)
            BiometricPrompt(
                it,
                executor,
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        onSignIn()
                    }

                    // A failed/cancelled fingerprint must never block the PIN path —
                    // the user can still type their PIN and press Sign In.
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        pin = ""
                    }
                }
            )
        }
    }

    fun launchBiometric() {
        val prompt = biometricPrompt ?: return
        runCatching {
            prompt.authenticate(
                BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Sign in to Bingwa Score")
                    .setSubtitle("Confirm it's you to continue")
                    .setNegativeButtonText("Use PIN")
                    .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK)
                    .build()
            )
        }
    }

    LaunchedEffect(Unit) {
        // Offer the sensor once on entry when the device supports it.
        if (biometricAvailable) launchBiometric()
    }

        Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {
        // POLISH P6 — the hero behind the card. Login is the first screen a new
        // agent sees and the last thing they look at, so it gets the one piece
        // of colour the product allows itself: two soft gradient orbs, sitting
        // behind a card that is otherwise identical to every other card.
        LoginHeroOrbs()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .imePadding()
        ) {
        Spacer(modifier = Modifier.height(48.dp))

        Text(
            "Welcome back",
            color = TextWhite,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Sign in to continue",
            color = TextWhite.copy(alpha = 0.6f),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        BubbleCard(modifier = Modifier.fillMaxWidth()) {
            GlassField(
                value = phone,
                onValueChange = { phone = it },
                hint = "Phone",
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            GlassField(
                value = pin,
                onValueChange = { if (it.length <= MAX_PIN_LENGTH) pin = it },
                hint = "PIN",
                isPassword = true,
                keyboardType = KeyboardType.NumberPassword
            )

            // MEGA A — fingerprint shortcut. Tapping it re-opens the sensor;
            // it is purely an accelerator, the PIN path below always works.
            if (biometricAvailable) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Bubble)
                            .border(1.dp, Hairline, CircleShape)
                            .clickable { launchBiometric() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Fingerprint,
                            contentDescription = "Sign in with fingerprint",
                            tint = AccentBlue,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            PinKeypad(
                pin = pin,
                onDigit = { digit ->
                    if (pin.length < MAX_PIN_LENGTH) pin += digit
                },
                onBackspace = { if (pin.isNotEmpty()) pin = pin.dropLast(1) }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = "Sign In",
            onClick = onSignIn,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Create account",
            color = TextWhite.copy(alpha = 0.6f),
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { onCreateAccount() }
        )

                Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun GlassField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val shape = RoundedCornerShape(16.dp)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            cursorBrush = SolidColor(AccentBlue),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isEmpty()) {
            Text(
                hint,
                color = TextFaint,
                fontSize = 16.sp
            )
        }
    }
}

/** PINs are capped at 6 digits so the keypad and field can never disagree. */
private const val MAX_PIN_LENGTH = 6

/**
 * MEGA A — the login keypad: a 3x4 glass grid with a filled PIN readout, so a
 * user with no fingerprint sensor (or who cancels the prompt) has a complete,
 * obvious way in without ever opening the system keyboard.
 */
@Composable
private fun PinKeypad(
    pin: String,
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit
) {
    val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Filled / empty PIN dots.
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(MAX_PIN_LENGTH) { index ->
                val filled = index < pin.length
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(if (filled) AccentBlue else Bubble)
                        .border(1.dp, Hairline, CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        val rows = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9")
        )
        rows.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                row.forEach { digit ->
                    KeypadKey(label = digit) {
                        try {
                            haptic.performHapticFeedback(
                                androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove
                            )
                        } catch (_: Throwable) {
                            // Haptics are optional polish; never block the tap.
                        }
                        onDigit(digit.first())
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.size(64.dp))
            KeypadKey(label = "0") { onDigit('0') }
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Bubble)
                    .border(1.dp, Hairline, CircleShape)
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

/** One round glass key. Press-scale 0.98 for the same tactile feel as the app. */
@Composable
private fun KeypadKey(label: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .size(64.dp)
            .pressScale(interactionSource)
            .clip(CircleShape)
            .background(Bubble)
            .border(1.dp, Hairline, CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
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

/**
 * POLISH P6 — the login hero.
 *
 * Two gradient orbs, one bleeding off the top-left, one off the bottom-right,
 * meeting behind the card. They are drawn (not blurred) from radial gradients,
 * so the effect is identical on every device from API 26 up — the login screen
 * is the one place the product spends colour, and it must never look cheaper on
 * an older phone than on a new one.
 */
@Composable
private fun LoginHeroOrbs() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(AccentBlue.copy(alpha = 0.22f), Color.Transparent)
            ),
            radius = size.width * 0.85f,
            center = Offset(size.width * 0.12f, size.height * 0.12f)
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFF8C6BFF).copy(alpha = 0.16f), Color.Transparent)
            ),
            radius = size.width * 0.95f,
            center = Offset(size.width * 0.95f, size.height * 0.92f)
        )
    }
}
