package com.bingwascore.app.ui.dialer

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

/** Full-screen quick dialer opened from the glass bottom bar call FAB. */
@Composable
fun DialerScreen(onClose: () -> Unit, viewModel: DialerViewModel = hiltViewModel()) {
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val phone by viewModel.phone.collectAsStateWithLifecycle()
    val selectedOfferId by viewModel.selectedOfferId.collectAsStateWithLifecycle()
    val feedback by viewModel.feedback.collectAsStateWithLifecycle()

    val selectedOffer = offers.firstOrNull { it.id == selectedOfferId } ?: offers.firstOrNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Quick dial", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Dial a bundle straight from the app",
                    color = White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onClose)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close dialer",
                    tint = White.copy(alpha = 0.7f),
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        GlassPhoneField(value = phone, onValueChange = viewModel::setPhone)

        Spacer(modifier = Modifier.height(22.dp))
        Text("Active offers", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        Spacer(modifier = Modifier.height(10.dp))

        if (offers.isEmpty()) {
            Text(
                "No active offers — add one in the Offers tab.",
                color = White.copy(alpha = 0.4f),
                fontSize = 13.sp
            )
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(offers, key = { it.id }) { offer ->
                    OfferChip(
                        offer = offer,
                        selected = offer.id == selectedOffer?.id,
                        onClick = { viewModel.selectOffer(offer) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        if (phone.isNotBlank() && selectedOffer != null) {
            Text(
                "*${selectedOffer.ussdCode.replace("ph", phone).replace("BH", phone, true)}",
                color = White.copy(alpha = 0.45f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        feedback?.let { value ->
            Text(
                value.message,
                color = if (value.isError) ErrorRed else EmeraldGreen,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        GradientButton(
            text = "Dial Now",
            enabled = phone.isNotBlank() && selectedOffer != null,
            onClick = viewModel::dialNow
        )
    }
}

@Composable
private fun GlassPhoneField(value: String, onValueChange: (String) -> Unit) {
    val shape = RoundedCornerShape(18.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Brush.verticalGradient(listOf(Color(0x33FFFFFF), Color.Transparent)), shape)
            .padding(horizontal = 16.dp, vertical = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null,
                tint = White.copy(alpha = 0.45f),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier.weight(1f)) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    textStyle = TextStyle(
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    ),
                    cursorBrush = SolidColor(EmeraldGreen),
                    modifier = Modifier.fillMaxWidth()
                )
                if (value.isEmpty()) {
                    Text(
                        "07XX XXX XXX",
                        color = White.copy(alpha = 0.35f),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun OfferChip(offer: Offer, selected: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(16.dp)
    val base = if (selected) {
        Modifier
            .clip(shape)
            .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue)))
    } else {
        Modifier
            .clip(shape)
            .background(Color(0x14FFFFFF))
            .border(1.dp, Color(0x1FFFFFFF), shape)
    }
    Column(
        modifier = base
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Text(
            offer.name,
            color = if (selected) NightBlack else White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            "Ksh ${offer.price}",
            color = if (selected) NightBlack.copy(alpha = 0.7f) else White.copy(alpha = 0.5f),
            fontSize = 11.sp
        )
    }
}

