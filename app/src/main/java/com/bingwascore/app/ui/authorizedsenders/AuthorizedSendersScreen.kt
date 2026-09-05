package com.bingwascore.app.ui.authorizedsenders

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

/**
 * Authorized Senders: trusted numbers whose SMS the bot may act on.
 * Everything else is ignored by the auto-reply engine.
 */
@Composable
fun AuthorizedSendersScreen(viewModel: AuthorizedSendersViewModel = hiltViewModel()) {
    val senders by viewModel.senders.collectAsStateWithLifecycle()

    var input by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    val submit: () -> Unit = {
        if (viewModel.addSender(input)) {
            input = ""
            error = null
        } else {
            error = if (input.isBlank()) "Enter a phone number" else "Number is empty or already trusted"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Authorized Senders", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${senders.size} trusted number(s)",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(14.dp))
            SenderInput(value = input, onValueChange = { input = it; error = null }, onSubmit = submit)
            if (error != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(error.orEmpty(), color = ErrorRed, fontSize = 12.sp)
            }
        }

        if (senders.isEmpty()) {
            GlassCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.VerifiedUser,
                    contentDescription = null,
                    tint = TealBlue,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("No trusted numbers", color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Add the numbers you trust. Only these senders trigger bot replies and offer flows.",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 12.sp
                )
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp)
            ) {
                items(senders.sorted(), key = { it }) { number ->
                    SenderRow(number = number, onRemove = { viewModel.removeSender(number) })
                }
            }
        }
    }
}

@Composable
private fun SenderInput(value: String, onValueChange: (String) -> Unit, onSubmit: () -> Unit) {
    val shape = RoundedCornerShape(16.dp)
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clip(shape)
                .background(Color(0x14FFFFFF))
                .border(1.dp, Color(0x1FFFFFFF), shape)
                .padding(horizontal = 14.dp, vertical = 13.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(color = White, fontSize = 14.sp),
                    cursorBrush = SolidColor(EmeraldGreen),
                    modifier = Modifier.fillMaxWidth()
                )
                if (value.isEmpty()) {
                    Text("e.g. 0712345678", color = White.copy(alpha = 0.4f), fontSize = 14.sp)
                }
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
                .clickable(onClick = onSubmit),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add trusted number",
                tint = Color(0xFF0A0A0F),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun SenderRow(number: String, onRemove: () -> Unit) {
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(TealBlue.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.VerifiedUser,
                    contentDescription = null,
                    tint = TealBlue,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(number, color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(
                    "Trusted sender",
                    color = EmeraldGreen,
                    fontSize = 11.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Remove $number",
                tint = White.copy(alpha = 0.55f),
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onRemove)
                    .padding(2.dp)
            )
        }
    }
}

