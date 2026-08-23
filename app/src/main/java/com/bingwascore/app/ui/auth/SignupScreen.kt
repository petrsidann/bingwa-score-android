package com.bingwascore.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.domain.model.User
import com.bingwascore.app.ui.components.BingwaButton
import com.bingwascore.app.ui.components.BingwaTextField
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Purple600
import com.bingwascore.app.ui.theme.White

@Composable
fun SignupScreen(
    viewModel: AuthViewModel,
    onSignupSuccess: (User) -> Unit,
    onNavigateBack: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val isDark = isSystemInDarkTheme()
    var fullName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    LaunchedEffect(state.user) {
        state.user?.let { onSignupSuccess(it) }
    }

    val passwordStrength = remember(password) {
        when {
            password.isEmpty() -> 0 to ""
            password.length < 6 -> 1 to "Weak"
            password.length < 8 -> 2 to "Fair"
            password.any { it.isDigit() } && password.any { it.isUpperCase() } -> 4 to "Strong"
            else -> 3 to "Good"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(28.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(
                    Brush.linearGradient(listOf(Orange500, Purple600)),
                    RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text("B", color = White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Create your account",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Join thousands buying bundles instantly",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(24.dp))

        if (state.error != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.error.copy(alpha = 0.1f),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(state.error ?: "", color = MaterialTheme.colorScheme.error)
            }
            Spacer(Modifier.height(16.dp))
        }

        BingwaTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full name",
            placeholder = "Jane Wanjiku",
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
        Spacer(Modifier.height(12.dp))

        BingwaTextField(
            value = phone,
            onValueChange = { phone = it },
            label = "Phone number",
            placeholder = "7XXXXXXXX",
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
            isMono = true,
            keyboardType = KeyboardType.Phone
        )
        Spacer(Modifier.height(12.dp))

        BingwaTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email (optional)",
            placeholder = "you@example.com",
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            keyboardType = KeyboardType.Email
        )
        Spacer(Modifier.height(12.dp))

        BingwaTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            isPassword = true
        )

        if (password.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                repeat(4) { i ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(
                                when {
                                    i < passwordStrength.first -> when (passwordStrength.first) {
                                        1 -> MaterialTheme.colorScheme.error
                                        2 -> MaterialTheme.colorScheme.tertiary
                                        3 -> Orange500
                                        else -> MaterialTheme.colorScheme.primary
                                    }
                                    else -> MaterialTheme.colorScheme.surfaceVariant
                                }
                            )
                    )
                }
            }
            Text(
                text = "Strength: ${passwordStrength.second}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        BingwaTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm password",
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            isPassword = true,
            isError = confirmPassword.isNotEmpty() && confirmPassword != password
        )

        Spacer(Modifier.height(20.dp))

        BingwaButton(
            text = if (state.isLoading) "Creating account..." else "Create account",
            onClick = {
                viewModel.signup(fullName, phone, email.ifBlank { null }, password)
            },
            loading = state.isLoading,
            enabled = fullName.isNotBlank() &&
                    phone.isNotBlank() &&
                    password.length >= 6 &&
                    password == confirmPassword
        )

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already have an account? ", color = MaterialTheme.colorScheme.onSurfaceVariant)
            TextButton(onClick = onNavigateBack) {
                Text(
                    "Sign in",
                    color = if (isDark) Purple600 else Orange500,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
