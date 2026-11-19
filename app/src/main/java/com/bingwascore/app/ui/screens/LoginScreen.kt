package com.bingwascore.app.ui.screens

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.auth.AuthConstants
import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.ui.components.GlassDialog
import com.bingwascore.app.ui.glass.PhaseChips
import com.bingwascore.app.ui.glass.PhaseCta
import com.bingwascore.app.ui.glass.PhaseDisplay
import com.bingwascore.app.ui.glass.PhaseKeypad
import com.bingwascore.app.ui.glass.PhaseScreen
import com.bingwascore.app.ui.glass.PhaseSurface
import com.bingwascore.app.util.CrashHandler
import com.bingwascore.app.util.rememberHaptics
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.Executor

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
    val isSuccess: Boolean = false,
    val offlineSignIn: Boolean = false
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
            _state.value = current.copy(phone = current.phone + digit)
        } else {
            _state.value = current.copy(errorMessage = "Phone number is 10 digits")
        }
    }

    fun backspacePhone() {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.phone.isNotEmpty()) {
            _state.value = current.copy(phone = current.phone.dropLast(1))
        }
    }

    fun appendPinDigit(digit: Char) {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.pin.length < AuthConstants.MIN_PIN_LENGTH) {
            _state.value = current.copy(pin = current.pin + digit)
        } else {
            _state.value = current.copy(errorMessage = "PIN is 4 digits")
        }
    }

    fun backspacePin() {
        val current = _state.value
        if (current.cooldownSeconds > 0 || current.isLoading || current.isSuccess) return
        if (current.pin.isNotEmpty()) {
            _state.value = current.copy(pin = current.pin.dropLast(1))
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
                        failedAttempts = 0,
                        offlineSignIn = result is RemoteResult.Offline
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
                _state.value = _state.value.copy(cooldownSeconds = _state.value.cooldownSeconds - 1)
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

    var mode by remember { mutableStateOf(LoginField.PHONE) }

    val activity = context as? FragmentActivity
    val biometricAvailable = remember {
        runCatching {
            val manager = BiometricManager.from(context)
            manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS
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

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {}
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
        if (biometricAvailable) launchBiometric()
    }

    val ready = state.isSubmittable && state.cooldownSeconds == 0 && !state.isLoading

    val hint = when {
        state.cooldownSeconds > 0 -> "Too many failed attempts. Try again in ${state.cooldownSeconds}s"
        !state.errorMessage.isNullOrBlank() -> state.errorMessage.orEmpty()
        mode == LoginField.PHONE -> "Enter your 10-digit phone number"
        else -> "Enter your 4-digit PIN"
    }

    PhaseScreen {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Bingwa Score",
                color = PhaseSurface.Ink,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.combinedClickable(onLongClick = { showCrashReport = true }, onClick = {})
            )
            Box(
                Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    if (mode == LoginField.PHONE) "PHONE" else "PIN",
                    color = PhaseSurface.Mut,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.6.sp
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        if (mode == LoginField.PHONE) {
            PhaseDisplay(
                label = "Phone",
                value = displayPhone(state.phone),
                placeholder = "0712345678",
                hint = hint,
                hintBad = state.cooldownSeconds > 0 || !state.errorMessage.isNullOrBlank(),
                showCaret = state.phone.isNotEmpty()
            )
        } else {
            PhaseDisplay(
                label = "PIN",
                value = "",
                placeholder = "",
                hint = hint,
                hintBad = state.cooldownSeconds > 0 || !state.errorMessage.isNullOrBlank(),
                showCaret = false,
                pinCount = state.pin.length
            )
        }

        Spacer(Modifier.height(16.dp))

        PhaseChips(
            labels = listOf("Phone", "PIN"),
            selected = if (mode == LoginField.PHONE) 0 else 1,
            onSelect = { mode = if (it == 0) LoginField.PHONE else LoginField.PIN }
        )

        Spacer(Modifier.height(24.dp))

        val utilityIcon = Icons.Rounded.Fingerprint
        if (!state.isSuccess) {
            PhaseKeypad(
                onDigit = {
                    when (mode) {
                        LoginField.PHONE -> viewModel.appendPhoneDigit(it)
                        LoginField.PIN -> viewModel.appendPinDigit(it)
                    }
                },
                onBackspace = {
                    when (mode) {
                        LoginField.PHONE -> viewModel.backspacePhone()
                        LoginField.PIN -> viewModel.backspacePin()
                    }
                },
                onClear = {
                    if (mode == LoginField.PHONE) viewModel.updatePhone("") else viewModel.updatePin("")
                },
                onSubmit = { viewModel.signIn(onSignIn) },
                onNext = { mode = if (mode == LoginField.PHONE) LoginField.PIN else LoginField.PHONE },
                submitEnabled = ready,
                onUtil = if (biometricAvailable) ({ launchBiometric() }) else null,
                utilIcon = utilityIcon
            )
        } else {
            Box(Modifier.fillMaxWidth().height(180.dp), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.CheckCircle, null, tint = PhaseSurface.Lime, modifier = Modifier.size(32.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        if (state.offlineSignIn) "Signed in (offline)" else "Verified!",
                        color = PhaseSurface.Lime,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            LaunchedEffect(Unit) { haptics.tick() }
        }

        Spacer(Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 14.dp)
        ) {
            PhaseCta(
                label = if (state.isLoading) "Verifying..." else if (state.cooldownSeconds > 0) "Cooldown (${state.cooldownSeconds}s)" else "Sign in",
                ready = ready,
                onClick = { viewModel.signIn(onSignIn) }
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Create account",
                color = PhaseSurface.Mut,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.combinedClickable(onClick = { onCreateAccount() }, onLongClick = null)
            )
        }

        if (showCrashReport) {
            CrashReportDialog(onDismiss = { showCrashReport = false }, context = context)
        }
    }
}

private fun displayPhone(digits: String): String {
    if (digits.length <= 4) return digits
    val first = digits.take(4)
    val rest = digits.drop(4).chunked(3)
    return listOf(first, *rest.toTypedArray()).joinToString(" ")
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
                    color = PhaseSurface.Ink,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
                Text(report ?: "No crashes recorded.", color = PhaseSurface.Mut, fontSize = 12.sp)
            }
        },
        dismissLabel = "OK",
        confirmLabel = "OK",
        onConfirm = onDismiss
    )
}
