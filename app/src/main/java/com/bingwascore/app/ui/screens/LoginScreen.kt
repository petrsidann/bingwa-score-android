package com.bingwascore.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.White

@Composable
fun LoginScreen(
    onSignIn: () -> Unit = {},
    onCreateAccount: () -> Unit = {}
) {
    var phone by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0A0F))
            .padding(horizontal = 24.dp)
            .navigationBarsPadding()
            .imePadding()
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        Text(
            "Welcome back",
            color = White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Sign in to continue",
            color = White.copy(alpha = 0.6f),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        GlassCard(modifier = Modifier.fillMaxWidth()) {
            GlassField(
                value = phone,
                onValueChange = { phone = it },
                hint = "Phone",
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            GlassField(
                value = pin,
                onValueChange = { pin = it },
                hint = "PIN",
                isPassword = true,
                keyboardType = KeyboardType.NumberPassword
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        GradientButton(
            text = "Sign In",
            onClick = onSignIn,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Create account",
            color = White.copy(alpha = 0.6f),
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { onCreateAccount() }
        )

        Spacer(modifier = Modifier.height(24.dp))
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
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x1FFFFFFF), shape)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            cursorBrush = SolidColor(EmeraldGreen),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isEmpty()) {
            Text(
                hint,
                color = White.copy(alpha = 0.45f),
                fontSize = 16.sp
            )
        }
    }
}
