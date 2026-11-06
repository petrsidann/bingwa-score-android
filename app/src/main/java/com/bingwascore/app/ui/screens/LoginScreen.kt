package com.bingwascore.app.ui.screens

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.focusable
import androidx.compose.foundation.text.BasicTextField
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
import com.bingwascore.app.ui.components.GlassDialog
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.NeoButton
import com.bingwascore.app.ui.theme.DesignTokens
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

enum class LoginField {
    PHONE,
    PIN
}

const val MAX_PHONE_LENGTH = 10

data class LoginUiState(
    val phone: String = "",
    val pin: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val failedAttempts: Int = 0,
    val cooldownSeconds: Int = 0,
    val isSuccess: Boolean = false
) {
    val isSubmittable: Boolean
        get() = phone.length >= AuthConstants.MIN_PHONE_DIGITS && pin.length == AuthConstants.MIN_PIN_LENGTH
}

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
        _state.value = _state.value.copy(phone = value)
    }

    fun updatePin(value: String) {
        _state.value = _state.value.copy(pin = value)
    }

    fun appendPhoneDigit(digit: Char) {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.phone.length < MAX_PHONE_LENGTH) {
            _state.value = current.copy(
                phone = current.phone + digit
            )
        } else {
            _state.value = current.copy(errorMessage = "Phone number is 10 digits")
        }
    }

    fun backspacePhone() {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.phone.isNotEmpty()) {
            _state.value = current.copy(
                phone = current.phone.dropLast(1)
            )
        }
    }

    fun appendPinDigit(digit: Char) {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.pin.length < MAX_PIN_LENGTH) {
            _state.value = current.copy(
                pin = current.pin + digit
            )
        } else {
            _state.value = current.copy(errorMessage = "PIN is 4 digits")
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
            _state.value = _state.value.copy(failedAttempts = 0)
        }
    }
}

private const val MAX_PIN_LENGTH = 4

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

    var focusedField by remember { mutableStateOf(LoginField.PHONE) }
    val phoneFocusRequester = remember { FocusRequester() }
    val pinFocusRequester = remember { FocusRequester() }

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

    val activity = context as? FragmentActivity
    val biometricAvailable = remember {
        runCatching {
            val manager = BiometricManager.from(context)
            manager.canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_WEAK
            ) == BiometricManager.BIOMETRIC_SUCCESS
        }.getOrDefault(false)
    }

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
        runCatching { phoneFocusRequester.requestFocus() }
        if (biometricAvailable) launchBiometric()
    }

    LaunchedEffect(Unit) {
        snapshotFlow { phone.length }
            .collect { len ->
                if (len >= 10 && focusedField == LoginField.PHONE) {
                    focusedField = LoginField.PIN
                    runCatching { pinFocusRequester.requestFocus() }
                }
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.Color.Obsidian.Bg)
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
            Text(
                "Welcome back",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Display,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.combinedClickable(onLongClick = { showCrashReport = true }, onClick = {})
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Sign in to continue",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Body
            )

            Spacer(modifier = Modifier.height(32.dp))

            state.errorMessage?.let { msg ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .background(DesignTokens.Color.Brand.Error.copy(alpha = 0.1f))
                        .border(1.dp, DesignTokens.Color.Brand.Error, RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .padding(14.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Rounded.ErrorOutline,
                            contentDescription = "Error",
                            tint = DesignTokens.Color.Brand.Error,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            msg,
                            color = DesignTokens.Color.Ink,
                            fontSize = DesignTokens.Typography.Caption,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            if (state.cooldownSeconds > 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .background(DesignTokens.Color.Obsidian.Elevated.copy(alpha = 0.5f))
                        .padding(14.dp)
                ) {
                    Text(
                        "Too many failed attempts. Try again in ${state.cooldownSeconds}s",
                        color = DesignTokens.Color.Ink,
                        fontSize = DesignTokens.Typography.Caption,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            GlassCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                    GlassInputField(
                        value = phone,
                        onValueChange = viewModel::updatePhone,
                        hint = "Phone (e.g. 0712345678)",
                        isFocused = focusedField == LoginField.PHONE,
                        focusRequester = phoneFocusRequester,
                        onClick = {
                            focusedField = LoginField.PHONE
                            phoneFocusRequester.requestFocus()
                        },
                        isPassword = false
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    GlassInputField(
                        value = pin,
                        onValueChange = viewModel::updatePin,
                        hint = "PIN",
                        isFocused = focusedField == LoginField.PIN,
                        focusRequester = pinFocusRequester,
                        onClick = {
                            focusedField = LoginField.PIN
                            pinFocusRequester.requestFocus()
                        },
                        isPassword = true
                    )

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
                                    .background(DesignTokens.Color.Obsidian.Elevated)
                                    .border(1.dp, DesignTokens.Color.Obsidian.Border.copy(alpha = 0.3f), CircleShape)
                                    .clickable { launchBiometric() },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Fingerprint,
                                    contentDescription = "Sign in with fingerprint",
                                    tint = DesignTokens.Color.Brand.Primary,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    TactileKeypad(
                        pin = pin,
                        onDigit = { digit ->
                            when (focusedField) {
                                LoginField.PHONE -> viewModel.appendPhoneDigit(digit)
                                LoginField.PIN -> viewModel.appendPinDigit(digit)
                            }
                        },
                        onBackspace = {
                            when (focusedField) {
                                LoginField.PHONE -> viewModel.backspacePhone()
                                LoginField.PIN -> viewModel.backspacePin()
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (state.isSuccess) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CheckCircle,
                        contentDescription = "Success",
                        tint = DesignTokens.Color.Brand.Success,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Verified!",
                        color = DesignTokens.Color.Brand.Success,
                        fontSize = DesignTokens.Typography.Headline,
                        fontWeight = FontWeight.Bold
                    )
                }
                LaunchedEffect(Unit) {
                    haptics.tick()
                }
            } else {
                NeoButton(
                    onClick = {
                        viewModel.signIn(onSignIn)
                    },
                    enabled = state.isSubmittable && state.cooldownSeconds == 0 && !state.isLoading,
                    modifier = Modifier.fillMaxWidth().height(52.dp)
                ) {
                    Text(
                        text = if (state.isLoading) "Verifying…" else if (state.cooldownSeconds > 0) "Cooldown (${state.cooldownSeconds}s)" else "Sign In",
                        color = DesignTokens.Color.Ink,
                        fontSize = DesignTokens.Typography.Headline,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Create account",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Body,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { onCreateAccount() }
            )

            Spacer(modifier = Modifier.height(32.dp))
        }

        if (showCrashReport) {
            CrashReportDialog(onDismiss = { showCrashReport = false }, context = context)
        }
    }
}

@Composable
private fun CrashReportDialog(onDismiss: () -> Unit, context: Context) {
    val report = CrashHandler.readLatestCrashReport(context)
    GlassDialog(
        visible = true,
        onDismiss = onDismiss,
        title = "Crash Report",
        body = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Last CrashHandler stack",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Caption,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = report ?: "No crashes recorded.",
                    style = TextStyle(fontSize = DesignTokens.Typography.Caption)
                )
            }
        },
        dismissLabel = "OK",
        confirmLabel = "OK",
        onConfirm = onDismiss
    )
}

/**
 * Custom glass input field: looks like a GlassCard (blur, scrim, 12dp radius).
 * Focused border glows with Brand.Primary (1dp, alpha 0.8).
 * Unfocused border is Obsidian.border at alpha 0.2.
 * Text uses Typography.Body. Focus glow is animated with animateFloatAsState.
 * ReadOnly — the system keyboard never rises; input comes from TactileKeypad.
 */
@Composable
private fun GlassInputField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    isFocused: Boolean = false,
    focusRequester: FocusRequester = remember { FocusRequester() },
    onClick: () -> Unit = {},
    isPassword: Boolean = false
) {
    val density = LocalDensity.current
    val glow by animateFloatAsState(
        targetValue = if (isFocused) 1f else 0f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "GlassInputFocusGlow"
    )

    val baseBorder = DesignTokens.Color.Obsidian.Border.copy(alpha = 0.2f)
    val focusedBorder = DesignTokens.Color.Brand.Primary.copy(alpha = 0.8f)
    val borderColor = Color(
        red = baseBorder.red + (focusedBorder.red - baseBorder.red) * glow,
        green = baseBorder.green + (focusedBorder.green - baseBorder.green) * glow,
        blue = baseBorder.blue + (focusedBorder.blue - baseBorder.blue) * glow,
        alpha = baseBorder.alpha + (focusedBorder.alpha - baseBorder.alpha) * glow
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "GlassInputPressScale"
    )

    GlassCard(
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer { scaleX = pressScale; scaleY = pressScale },
        shape = RoundedCornerShape(DesignTokens.Shape.RadiusMd)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .border(1.dp, borderColor, RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick
                ),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                readOnly = true,
                textStyle = TextStyle(
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Body
                ),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusable()
                    .focusRequester(focusRequester)
            )
            if (value.isEmpty()) {
                Text(
                    hint,
                    color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                    fontSize = DesignTokens.Typography.Body
                )
            }
        }
    }
}

/**
 * Tactile keypad: 3x4 grid at the bottom of the screen. Each key is a NeoButton
 * (scale 0.95f on press, LongPress haptic) using Obsidian.card with Elevation.Level1.
 * Backspace key has a distinct icon. Drives phone + PIN fields; system keyboard never rises.
 */
@Composable
private fun TactileKeypad(
    pin: String,
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    val keySizePx = with(density) { 64.dp.toPx() }
    val keyRadius = keySizePx / 2f

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(MAX_PIN_LENGTH) { index ->
                val filled = index < pin.length
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(if (filled) DesignTokens.Color.Brand.Primary else DesignTokens.Color.Obsidian.Card)
                        .border(1.dp, DesignTokens.Color.Obsidian.Border.copy(alpha = 0.2f), CircleShape)
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
                    TactileKeypadKey(
                        label = digit,
                        keySizePx = keySizePx,
                        keyRadius = keyRadius,
                        onClick = {
                            try {
                                haptic.performHapticFeedback(
                                    androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove
                                )
                            } catch (_: Throwable) {
                                // Haptics are optional polish; never block the tap.
                            }
                            onDigit(digit.first())
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.size(64.dp))
            TactileKeypadKey(
                label = "0",
                keySizePx = keySizePx,
                keyRadius = keyRadius,
                onClick = {
                    try {
                        haptic.performHapticFeedback(
                            androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove
                        )
                    } catch (_: Throwable) {
                        // Haptics are optional polish; never block the tap.
                    }
                    onDigit('0')
                }
            )
            TactileKeypadKey(
                label = "",
                keySizePx = keySizePx,
                keyRadius = keyRadius,
                icon = Icons.Rounded.Backspace,
                onClick = {
                    try {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    } catch (_: Throwable) {
                        // Haptics are optional polish; never block the tap.
                    }
                    onBackspace()
                }
            )
        }
    }
}

@Composable
private fun TactileKeypadKey(
    label: String,
    keySizePx: Float,
    keyRadius: Float,
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "TactileKeypadKeyScale"
    )

    val density = LocalDensity.current
    val level1 = DesignTokens.Elevation.Level1.first()
    val offsetY = with(density) { level1.offsetY.toPx() }
    val haptics = rememberHaptics()

    Box(
        modifier = Modifier
            .size(64.dp)
            .drawBehind {
                drawRoundRect(
                    color = level1.color,
                    topLeft = Offset(0f, offsetY),
                    cornerRadius = CornerRadius(keyRadius, keyRadius)
                )
            }
            .clip(CircleShape)
            .background(DesignTokens.Color.Obsidian.Card)
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    haptics.press()
                    onClick()
                }
            )
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "Delete",
                tint = DesignTokens.Color.Ink,
                modifier = Modifier.size(22.dp)
            )
        } else {
            Text(
                label,
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Subhead,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
