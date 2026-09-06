package com.bingwascore.app.ui.blacklist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

/** Blacklist: customers blocked from offers and bot messages. */
@Composable
fun BlacklistScreen(viewModel: BlacklistViewModel = hiltViewModel()) {
    val blacklisted by viewModel.blacklisted.collectAsStateWithLifecycle()

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
            Text("Blacklist", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${blacklisted.size} blocked customer(s)",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        if (blacklisted.isEmpty()) {
            EmptyState(
                icon = Icons.Rounded.Block,
                title = "All clear, nobody blocked",
                message = "Block a customer from the Customers screen to stop their offers and bot replies.",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(blacklisted, key = { _, customer -> customer.phoneNumber }) { index, customer ->
                    BlacklistRow(
                        customer = customer,
                        enterDelayMillis = minOf(index, 6) * 35,
                        onUnblock = { viewModel.unblock(customer) }
                    )
                }
            }
        }
    }
}

@Composable
private fun BlacklistRow(
    customer: Customer,
    enterDelayMillis: Int,
    onUnblock: () -> Unit
) {
    GlassCard(modifier = Modifier.fillMaxWidth(), enterDelayMillis = enterDelayMillis) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(EmeraldGreen, TealBlue))),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    (customer.name ?: customer.phoneNumber).take(1).uppercase(),
                    color = Color(0xFF0A0A0F),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    customer.name ?: customer.phoneNumber,
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    customer.phoneNumber,
                    color = White.copy(alpha = 0.5f),
                    fontSize = 11.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, EmeraldGreen.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .clickable(onClick = onUnblock)
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(
                    "Unblock",
                    color = EmeraldGreen,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

