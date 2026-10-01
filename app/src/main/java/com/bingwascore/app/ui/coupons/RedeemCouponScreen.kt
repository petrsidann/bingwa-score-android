package com.bingwascore.app.ui.coupons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Redeem
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.AmbientBackground
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.BingwaOrange
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.rememberHaptics
import com.bingwascore.app.util.screenEnter

/**
 * Redeem Coupon — where an agent spends a promo code to unlock a bundle.
 *
 * The screen always explains its verdict: green for a redemption, red for a
 * rejected code. An empty catalogue gets a real EmptyState rather than a blank
 * list.
 */
@Composable
fun RedeemCouponScreen(
    viewModel: RedeemCouponViewModel = hiltViewModel(),
    onBack: () -> Unit = {}
) {
    val haptics = rememberHaptics()
    val eligibleOffers by viewModel.eligibleOffers.collectAsStateWithLifecycle()
    val result by viewModel.result.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    var code by remember { mutableStateOf("") }

    // Confirm the outcome by feel as well as by text.
    LaunchedEffect(result) {
        when (result) {
            is RedeemResult.Success -> haptics.success()
            is RedeemResult.Invalid -> haptics.error()
            null -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        AmbientBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Redeem Coupon",
                    color = White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "Back",
                    color = White.copy(alpha = 0.6f),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onBack() }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Enter a promo code to unlock a bundle.",
                color = White.copy(alpha = 0.5f),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(GlassFill)
                        .padding(horizontal = 14.dp, vertical = 14.dp)
                ) {
                    BasicTextField(
                        value = code,
                        onValueChange = {
                            code = it.uppercase()
                            viewModel.clearResult()
                        },
                        singleLine = true,
                        textStyle = TextStyle(color = White, fontSize = 16.sp, letterSpacing = 2.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        cursorBrush = SolidColor(BingwaOrange),
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (code.isEmpty()) {
                        Text(
                            "Promo code",
                            color = White.copy(alpha = 0.45f),
                            fontSize = 16.sp
                        )
                    }
                }

                // MEGA A — the form always states its verdict, never a silent no-op.
                when (val current = result) {
                    is RedeemResult.Success -> {
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Rounded.CheckCircle,
                                contentDescription = null,
                                tint = EmeraldGreen,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(current.message, color = EmeraldGreen, fontSize = 13.sp)
                        }
                    }

                    is RedeemResult.Invalid -> {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(current.message, color = ErrorRed, fontSize = 13.sp)
                    }

                    null -> Unit
                }

                Spacer(modifier = Modifier.height(16.dp))
                GradientButton(
                    text = if (isLoading) "Checking…" else "Redeem",
                    enabled = code.isNotBlank() && !isLoading,
                    onClick = { viewModel.redeem(code) }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (eligibleOffers.isEmpty()) {
                EmptyState(
                    icon = Icons.Rounded.Redeem,
                    title = "No coupon offers yet",
                    message = "Coupon bundles appear here as soon as you create one. " +
                        "Add it on the Offers tab to start redeeming.",
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    "Available with a coupon",
                    color = White.copy(alpha = 0.7f),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                eligibleOffers.forEach { offer ->
                    GlassCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Rounded.Redeem,
                                contentDescription = null,
                                tint = BingwaOrange,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    offer.name,
                                    color = White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    "Ksh ${offer.price}",
                                    color = White.copy(alpha = 0.55f),
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}