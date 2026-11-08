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
import com.bingwascore.app.ui.components.GlassInputField
import com.bingwascore.app.ui.components.KeypadKey
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
            Text(
                "Welcome back",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                style = DesignTokens.Typography.Display,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.combinedClickable(onLongClick = { showCrashReport = true }, onClick = {})
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Sign in to continue",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Body
            )

            Spacer(modifier = Modifier.height(32.dp))

            state.errorMessage?.let { msg ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .background(DesignTokens.LocalBingwaRoles.current.error.copy(alpha = 0.1f))
                        .border(1.dp, DesignTokens.LocalBingwaRoles.current.error, RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .padding(14.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Rounded.ErrorOutline,
                            contentDescription = "Error",
                            tint = DesignTokens.LocalBingwaRoles.current.error,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            msg,
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
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
                        .background(DesignTokens.LocalBingwaRoles.current.elevated.copy(alpha = 0.5f))
                        .padding(14.dp)
                ) {
                    Text(
                        "Too many failed attempts. Try again in ${state.cooldownSeconds}s",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
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
                        placeholder = "Phone (e.g. 0712345678)",
                        focused = focusedField == LoginField.PHONE,
                        readOnly = true,
                        focusRequester = phoneFocusRequester,
                        onClick = {
                            focusedField = LoginField.PHONE
                            phoneFocusRequester.requestFocus()
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    GlassInputField(
                        value = pin,
                        onValueChange = viewModel::updatePin,
                        placeholder = "PIN",
                        focused = focusedField == LoginField.PIN,
                        readOnly = true,
                        isPassword = true,
                        focusRequester = pinFocusRequester,
                        onClick = {
                            focusedField = LoginField.PIN
                            pinFocusRequester.requestFocus()
                        }
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
                                    .background(DesignTokens.LocalBingwaRoles.current.elevated)
                                    .border(1.dp, DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.3f), CircleShape)
                                    .clickable { launchBiometric() },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Fingerprint,
                                    contentDescription = "Sign in with fingerprint",
                                    tint = DesignTokens.LocalBingwaRoles.current.brand,
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
                        tint = DesignTokens.LocalBingwaRoles.current.success,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Verified!",
                        color = DesignTokens.LocalBingwaRoles.current.success,
                        style = DesignTokens.Typography.Headline,
                        fontWeight = FontWeight.Bold
                    )
                }
                LaunchedEffect(Unit) {
                    haptics.tick()
                }
            } else {
                NeoButton(
                    onClick = { viewModel.signIn(onSignIn) },
                    enabled = state.isSubmittable && state.cooldownSeconds == 0 && !state.isLoading,
                    text = if (state.isLoading) "Verifying…" else if (state.cooldownSeconds > 0) "Cooldown (${state.cooldownSeconds}s)" else "Sign In"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Create account",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
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
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
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
 * Tactile keypad: 3x4 grid of KeypadKey keys plus a 4-dot PIN readout.
 * KeypadKey carries the TextHandleMove haptic internally; the system keyboard
 * never rises — PIN and phone fields are driven only by the keypad.
 */
@Composable
private fun TactileKeypad(
    pin: String,
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit
) {
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
                        .background(if (filled) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.card)
                        .border(1.dp, DesignTokens.LocalBingwaRoles.current.border.copy(alpha = 0.2f), CircleShape)
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
                    KeypadKey(
                        d = digit,
                        onKey = { onDigit(digit.first()) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.size(64.dp))
            KeypadKey(
                d = "0",
                onKey = { onDigit('0') }
            )
            KeypadKey(
                d = "",
                icon = Icons.Rounded.Backspace,
                onKey = { onBackspace() }
            )
        }
    }
}
