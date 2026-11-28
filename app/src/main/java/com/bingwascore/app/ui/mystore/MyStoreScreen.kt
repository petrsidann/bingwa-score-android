package com.bingwascore.app.ui.mystore

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.HourglassTop
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.glass.GlassCard
import com.bingwascore.app.ui.components.StatusStyle
import com.bingwascore.app.ui.components.forStatus
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.screenEnter

@Composable
fun MyStoreScreen(viewModel: MyStoreViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        // S2.1 Back row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = DesignTokens.LocalBingwaRoles.current.textPrimary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Navigate back */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Agent Portal",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // S2.2 Storefront glass card
            item {
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        KVRow(label = "Storefront", value = state.storefrontLink, monospace = true)
                        Spacer(modifier = Modifier.height(8.dp))
                        KVRow(label = "Published", value = "${state.publishedCount} of ${state.totalOffers}")
                        Spacer(modifier = Modifier.height(8.dp))
                        KVRow(label = "SiteLink orders", value = "${state.siteLinkOrders}")
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = "Copy link",
                                color = DesignTokens.LocalBingwaRoles.current.brand,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable { /* Copy link */ }
                            )
                            Text(
                                text = "·",
                                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.4f),
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Share",
                                color = DesignTokens.LocalBingwaRoles.current.brand,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable { /* Share */ }
                            )
                        }
                    }
                }
            }

            // S2.3 Published offers section
            item {
                SectionHeader(title = "Published offers")
            }

            itemsIndexed(state.offers) { index, offer ->
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    OfferRow(offer = offer, onToggle = { viewModel.toggleOfferPublished(index) })
                }
            }

            // S2.4 Recent orders section
            item {
                SectionHeader(title = "Recent orders")
            }

            items(state.orders) { order ->
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    OrderRow(order = order)
                }
            }
        }
    }
}

@Composable
private fun KVRow(label: String, value: String, monospace: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Text(
            text = value,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = if (monospace) androidx.compose.ui.text.font.FontFamily.Monospace else null
        )
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
}

/**
 * S2.3 — 44x26dp lime toggle with black thumb.
 * Off = muted gray; on = lime fill. Thumb moves right when on.
 */
@Composable
private fun LimeToggle(checked: Boolean, onCheckedChange: () -> Unit) {
    val trackWidth = 44.dp
    val trackHeight = 26.dp
    val thumbSize = 20.dp
    val pad = 3.dp

    Box(
        modifier = Modifier
            .size(trackWidth, trackHeight)
            .clip(RoundedCornerShape(trackHeight / 2))
            .background(
                if (checked) DesignTokens.LocalBingwaRoles.current.brand
                else Color.Gray.copy(alpha = 0.4f)
            )
            .clickable(onClick = onCheckedChange)
    ) {
        Box(
            modifier = Modifier
                .size(thumbSize)
                .clip(androidx.compose.foundation.shape.CircleShape)
                .background(Color.Black)
                .align(if (checked) Alignment.CenterEnd else Alignment.CenterStart)
                .padding(if (checked) pad else pad)
        )
    }
}

@Composable
private fun OfferRow(offer: StoreOffer, onToggle: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = offer.name,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        LimeToggle(checked = offer.published, onCheckedChange = onToggle)
    }
}

@Composable
private fun OrderRow(order: StoreOrder) {
    val style = forStatus(order.status)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Status glyph tile
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(style.tileColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = style.glyph,
                color = style.chipColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = order.name,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "${order.offer} · ${order.ago}",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                fontSize = 11.sp
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "Ksh ${order.amount.toInt()}",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = style.chipLabel,
                color = style.chipColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(style.chipColor.copy(alpha = 0.16f))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            )
        }
    }
}
