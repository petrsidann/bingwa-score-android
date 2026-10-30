package com.bingwascore.app.ui.screens

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.focusable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.brand.BrandWordmark
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import javax.inject.Inject

data class LoginUiState(
    val phone: String = "",
    val pin: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val failedAttempts: Int = 0,
    val cooldownSeconds: Int = 0,
    val isSuccess: Boolean = false
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            userPreferences.phone.collect { saved ->
                if (saved.isNotEmpty() && _state.value.phone.isEmpty()) {
                    _state.value = _state.value.copy(phone = saved)
                }
            }
        }
    }

    fun updatePhone(value: String) {
        // O(1) pure on state change: the custom keypad writes digits only,
        // so there is no regex, no filter loop, and no per-keystroke scan.
        _state.value = _state.value.copy(phone = value)
    }

    fun updatePin(value: String) {
        _state.value = _state.value.copy(pin = value)
    }

    fun appendPinDigit(digit: Char) {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.pin.length < MAX_PIN_LENGTH) {
            _state.value = current.copy(
                pin = current.pin + digit
            )
        }
    }

    fun backspacePin() {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.pin.isNotEmpty()) {
            _state.value = current.copy(
                pin = current.pin.dropLast(1)
            )
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(errorMessage = null)
    }

    fun signIn(onSuccess: () -> Unit) {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return

        if (current.phone.length < 9) {
            _state.value = current.copy(errorMessage = "Enter a valid phone number")
            return
        }
        if (current.pin.length != 4) {
            _state.value = current.copy(errorMessage = "PIN must be exactly 4 digits")
            return
        }

        _state.value = current.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            when (val result = authRepository.signIn(current.phone, current.pin)) {
                is RemoteResult.Success, is RemoteResult.Offline -> {
                    userPreferences.setLoggedIn(true)
                    _state.value = _state.value.copy(
                        isLoading = false,
                        isSuccess = true,
                        failedAttempts = 0
                    )
                    delay(800)
                    onSuccess()
                }
                is RemoteResult.Failure -> {
                    val newFailed = _state.value.failedAttempts + 1
                    if (newFailed >= 3) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            errorMessage = result.message.ifBlank { "Incorrect phone number or PIN" },
                            failedAttempts = newFailed,
                            cooldownSeconds = 30
                        )
                        startCooldown()
                    } else {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            errorMessage = result.message.ifBlank { "Incorrect phone number or PIN" },
                            failedAttempts = newFailed
                        )
                    }
                }
            }
        }
    }

    private fun startCooldown() {
        viewModelScope.launch {
            while (_state.value.cooldownSeconds > 0) {
                delay(1000)
                _state.value = _state.value.copy(
                    cooldownSeconds = _state.value.cooldownSeconds - 1
                )
            }
            // Reset attempts after cooldown ends
            _state.value = _state.value.copy(failedAttempts = 0)
        }
    }
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onSignIn: () -> Unit = {},
    onCreateAccount: () -> Unit = {}
) {
    val context = LocalContext.current
    val haptics = rememberHaptics()
    var showCrashReport by remember { mutableStateOf(false) }
    val state by viewModel.state.collectAsStateWithLifecycle()

    val phone = state.phone
    val pin = state.pin

    // Clear a shown error on the very next keystroke. The write happens inside
    // LaunchedEffect(snapshotFlow) — never during composition — so typing can
    // never recompose mid-change and jank the frame.
    LaunchedEffect(Unit) {
        var lastPhone = ""
        var lastPin = ""
        snapshotFlow { state }
            .onEach { s ->
                if (s.errorMessage != null && (s.phone != lastPhone || s.pin != lastPin)) {
                    viewModel.clearError()
                }
                lastPhone = s.phone
                lastPin = s.pin
            }
            .launchIn(this)
    }

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
                        haptics.tick()
                        viewModel.signIn(onSignIn)
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        // ignore error
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
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .imePadding()
        ) {
        Spacer(modifier = Modifier.height(32.dp))

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

        // The brand wordmark on SignIn. Long-press it to open the Crash Report
        // dialog showing the last CrashHandler stack — reachable pre-auth,
        // forever, because crash files persist until the user clears them.
        Text(
            text = BrandWordmark.TEXT,
            color = TextWhite,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
                .combinedClickable(onLongClick = { showCrashReport = true }, onClick = {})
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Hard gate inline error card
        state.errorMessage?.let { msg ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(com.bingwascore.app.ui.theme.FailRed.copy(alpha = 0.15f))
                    .border(1.dp, com.bingwascore.app.ui.theme.FailRed, RoundedCornerShape(12.dp))
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.ErrorOutline,
                        contentDescription = "Error",
                        tint = com.bingwascore.app.ui.theme.FailRed,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        msg,
                        color = TextWhite,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Cooldown notification
        if (state.cooldownSeconds > 0) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(com.bingwascore.app.ui.theme.PendGrey.copy(alpha = 0.2f))
                    .border(1.dp, com.bingwascore.app.ui.theme.PendGrey, RoundedCornerShape(12.dp))
                    .padding(14.dp)
            ) {
                Text(
                    "Too many failed attempts. Try again in ${state.cooldownSeconds}s",
                    color = TextWhite,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        BubbleCard(modifier = Modifier.fillMaxWidth()) {
            GlassField(
                value = phone,
                onValueChange = viewModel::updatePhone,
                hint = "Phone (e.g. 0712345678)",
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            GlassField(
                value = pin,
                onValueChange = viewModel::updatePin,
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
                    viewModel.appendPinDigit(digit)
                },
                onBackspace = {
                    viewModel.backspacePin()
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (state.isSuccess) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = "Success",
                    tint = TickGreen,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Verified!",
                    color = TickGreen,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            LaunchedEffect(Unit) {
                haptics.tick()
            }
        } else {
            PrimaryButton(
                text = if (state.cooldownSeconds > 0) "Cooldown (${state.cooldownSeconds}s)" else "Sign In",
                onClick = {
                    viewModel.signIn(onSignIn)
                },
                loading = state.isLoading,
                loadingText = "Verifying…",
                enabled = state.cooldownSeconds == 0 && !state.isLoading,
                modifier = Modifier.fillMaxWidth().height(52.dp)
            )
        }

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

        if (showCrashReport) {
            CrashReportDialog(onDismiss = { showCrashReport = false }, context = context)
        }
    }
}

@Composable
private fun CrashReportDialog(onDismiss: () -> Unit, context: Context) {
    val report = CrashHandler.readLatestCrashReport(context)
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("OK")
            }
        },
        title = { Text("Crash Report") },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Last CrashHandler stack",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = report ?: "No crashes recorded.",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
    )
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
    val focusRequester = remember { FocusRequester() }

    // Phone and PIN fields are driven by the custom glass keypad, so the
    // system keyboard must never rise when they gain focus.
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
            readOnly = true,
            textStyle = TextStyle(color = TextWhite, fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            cursorBrush = SolidColor(AccentBlue),
            modifier = Modifier
                .fillMaxWidth()
                .focusable()
                .focusRequester(focusRequester)
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

/** PINs are exactly 4 digits so the keypad and field can never disagree. */
private const val MAX_PIN_LENGTH = 4

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
                colors = listOf(AccentBlue.copy(alpha = 0.16f), Color.Transparent)
            ),
            radius = size.width * 0.95f,
            center = Offset(size.width * 0.95f, size.height * 0.92f)
        )
    }
}
