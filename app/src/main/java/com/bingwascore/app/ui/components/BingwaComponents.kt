package com.bingwascore.app.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.Gray100
import com.bingwascore.app.ui.theme.Gray200
import com.bingwascore.app.ui.theme.Gray800
import com.bingwascore.app.ui.theme.Orange500
import com.bingwascore.app.ui.theme.Orange600
import com.bingwascore.app.ui.theme.Purple500
import com.bingwascore.app.ui.theme.Purple600
import com.bingwascore.app.ui.theme.White

@Composable
fun BingwaButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    isDarkTheme: Boolean = false
) {
    val gradient = if (isDarkTheme) {
        Brush.linearGradient(listOf(Purple500, Purple600))
    } else {
        Brush.linearGradient(listOf(Orange500, Orange600))
    }

    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    brush = if (enabled) gradient else Brush.linearGradient(listOf(Gray200, Gray200)),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            if (loading) {
                CircularProgressIndicator(
                    color = White,
                    strokeWidth = 2.dp,
                    modifier = Modifier.height(24.dp)
                )
            } else {
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelLarge,
                    color = White
                )
            }
        }
    }
}

@Composable
fun BingwaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false,
    isMono: Boolean = false,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        leadingIcon = leadingIcon,
        singleLine = true,
        isError = isError,
        textStyle = if (isMono) MaterialTheme.typography.bodyLarge.copy(
            fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
        ) else MaterialTheme.typography.bodyLarge,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (true) Orange500 else Purple500,
            unfocusedBorderColor = Gray200,
            focusedLabelColor = if (true) Orange500 else Purple500
        )
    )
}

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 16.dp
) {
    val transition = rememberInfiniteTransition(label = "skeleton")
    val translate by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "skeleton"
    )
    val brush = Brush.linearGradient(
        colors = listOf(Gray100, Gray200, Gray100),
        start = Offset(translate - 300f, 0f),
        end = Offset(translate, 0f)
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(8.dp))
            .background(brush)
    )
}
