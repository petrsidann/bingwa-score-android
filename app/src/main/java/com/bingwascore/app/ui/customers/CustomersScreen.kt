package com.bingwascore.app.ui.customers

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.People
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.bingwascore.app.ui.components.GlassBottomSheet
import com.bingwascore.app.ui.components.GlassDialog
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.domain.CustomerBook
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassSearchBar
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.theme.DesignTokens
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Stage 53 — the Customers book as a linear CRM. Every row is a tactile
 * GlassCard (avatar, info column, status badge) with a spring press and
 * mandatory haptics. Search + Blacklisted filter chip up top. ViewModel and
 * data fetching are untouched — only UI composition changed.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomersScreen(viewModel: CustomersViewModel = hiltViewModel()) {
    val customers by viewModel.customers.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()
    val blacklistFilter by viewModel.blacklistFilter.collectAsStateWithLifecycle()
    val selected by viewModel.selected.collectAsStateWithLifecycle()
    val stats by viewModel.selectedStats.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.Color.Bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(
                "Customers",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Headline,
                fontWeight = FontWeight.Bold
            )
            Text(
                "${customers.size} customer(s)",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Caption
            )
            Spacer(modifier = Modifier.height(14.dp))
            GlassSearchBar(query = query, onQueryChange = viewModel::setQuery)
            Spacer(modifier = Modifier.height(12.dp))
            BlacklistFilterChip(
                active = blacklistFilter,
                onToggle = viewModel::toggleBlacklistFilter
            )
        }

        if (customers.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                CustomerEmptyState()
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(customers, key = { _, customer -> customer.phoneNumber }) { index, customer ->
                    CustomerRow(
                        customer = customer,
                        enterDelayMillis = minOf(index, 6) * 40,
                        onOpen = { viewModel.openDetail(customer) }
                    )
                }
            }
        }
    }

    val open = selected
    GlassBottomSheet(
        visible = open != null,
        onDismiss = viewModel::closeDetail
    ) {
        if (open != null) {
            CustomerDetailSheet(
                customer = open,
                stats = stats,
                onClose = viewModel::closeDetail,
                onToggleBlacklist = { viewModel.toggleBlacklisted(open) }
            )
        }
    }
}

@Composable
private fun CustomerEmptyState() {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.People,
                contentDescription = null,
                tint = DesignTokens.Color.Brand.Primary.copy(alpha = 0.2f),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "No customers yet",
                color = DesignTokens.Color.Ink,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Customers save themselves here every time a bundle completes.",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Caption
            )
        }
    }
}

@Composable
private fun BlacklistFilterChip(active: Boolean, onToggle: () -> Unit) {
    val bg = if (active) DesignTokens.Color.Brand.Error else Color.Transparent
    val border = if (active) DesignTokens.Color.Brand.Error else DesignTokens.Color.Border
    val ink = DesignTokens.Color.Ink
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bg)
            .border(1.dp, border, RoundedCornerShape(50))
            .clickable { onToggle() }
            .padding(horizontal = 14.dp, vertical = 7.dp)
    ) {
        Icon(
            Icons.Rounded.Block,
            contentDescription = null,
            tint = ink,
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            "Blacklisted",
            color = ink,
            fontSize = DesignTokens.Typography.Caption,
            fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun CustomerRow(
    customer: Customer,
    enterDelayMillis: Int,
    onOpen: () -> Unit
) {
    val isBlocked = customer.isBlacklisted
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val haptic = LocalHapticFeedback.current
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "CustomerCardPress"
    )

    val ringBrush: Brush = if (isBlocked) {
        SolidColor(DesignTokens.Color.Brand.Error)
    } else {
        Brush.linearGradient(
            colors = listOf(DesignTokens.Color.Brand.Primary, DesignTokens.Color.Brand.DimAccent)
        )
    }
    val badgeColor = if (isBlocked) DesignTokens.Color.Brand.Error else DesignTokens.Color.Brand.Success

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onOpen()
                }
            )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(ringBrush)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(DesignTokens.Color.Card),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        initialsOf(customer.name ?: customer.phoneNumber),
                        color = DesignTokens.Color.Ink,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber,
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    customer.phoneNumber,
                    color = DesignTokens.Color.Ink.copy(alpha = 0.7f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .background(badgeColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
            .drawBehind {
                drawRoundRect(
                    brush = SolidColor(badgeColor.copy(alpha = 0.3f)),
                    cornerRadius = CornerRadius(14f, 14f)
                )
            }
            ) {
                Text(
                    if (isBlocked) "Blocked" else "Active",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Caption,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

/** First letters of the first two words, uppercased ("Dennis Wachira" -> "DW"). */
private fun initialsOf(name: String): String {
    val parts = name.trim().split(Regex("\\s+")).filter { it.isNotBlank() }
    return when {
        parts.isEmpty() -> "?"
        parts.size == 1 -> parts.first().take(1).uppercase(Locale.ROOT)
        else -> (parts[0].take(1) + parts[1].take(1)).uppercase(Locale.ROOT)
    }
}

@Composable
private fun CustomerDetailSheet(
    customer: Customer,
    stats: CustomerBook.Stats?,
    onClose: () -> Unit,
    onToggleBlacklist: () -> Unit
) {
    val context = LocalContext.current
    var confirmBlacklist by remember { mutableStateOf(false) }
    var showContacts by remember { mutableStateOf(false) }
    val dateFmt = remember { SimpleDateFormat("d MMM yyyy", Locale.getDefault()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp, bottom = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(DesignTokens.Color.Brand.Primary.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    initialsOf(customer.name ?: customer.phoneNumber),
                    color = DesignTokens.Color.Ink,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber,
                    color = DesignTokens.Color.Ink,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(customer.phoneNumber, color = DesignTokens.Color.Ink.copy(alpha = 0.5f), fontSize = 12.sp)
            }
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Close",
                tint = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                modifier = Modifier.size(22.dp).clickable { onClose() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (stats == null || stats.txCount == 0) {
            Text(
                "No completed purchases recorded yet.",
                color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
                fontSize = 13.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                StatTile("Total spent", "Ksh ${formatAmount(stats.totalSpent)}", Modifier.weight(1f))
                Spacer(modifier = Modifier.width(10.dp))
                StatTile("Purchases", "${stats.txCount}", Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                StatTile(
                    "First purchase",
                    if (stats.firstPurchaseAt > 0) dateFmt.format(Date(stats.firstPurchaseAt)) else "—",
                    Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                StatTile(
                    "Most bought",
                    stats.mostBoughtOffer ?: "—",
                    Modifier.weight(1f)
                )
            }

            if (stats.lastFive.isNotEmpty()) {
                Spacer(modifier = Modifier.height(18.dp))
                Text("Recent purchases", color = DesignTokens.Color.Ink.copy(alpha = 0.6f), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                stats.lastFive.forEach { sale ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(sale.offerName, color = DesignTokens.Color.Ink, fontSize = 13.sp, maxLines = 1)
                            Text(
                                dateFmt.format(Date(sale.at)),
                                color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                                fontSize = 11.sp
                            )
                        }
                        Text(
                            "Ksh ${formatAmount(sale.amount)}",
                            color = DesignTokens.Color.Ink.copy(alpha = 0.8f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            ActionPill(
                label = "Contact",
                icon = Icons.Rounded.Call,
                tint = DesignTokens.Color.Brand.Primary,
                modifier = Modifier.weight(1f),
                onClick = { showContacts = true }
            )
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(if (customer.isBlacklisted) DesignTokens.Color.Brand.Error.copy(alpha = 0.14f) else DesignTokens.Color.Card.copy(alpha = 0.08f))
                    .border(
                        1.dp,
                        if (customer.isBlacklisted) DesignTokens.Color.Brand.Error.copy(alpha = 0.5f) else DesignTokens.Color.Border,
                        RoundedCornerShape(14.dp)
                    )
                    .clickable { confirmBlacklist = true }
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                Icon(
                    Icons.Rounded.Block,
                    contentDescription = null,
                    tint = if (customer.isBlacklisted) DesignTokens.Color.Brand.Error else DesignTokens.Color.Ink.copy(alpha = 0.7f),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    if (customer.isBlacklisted) "Unblock" else "Blacklist",
                    color = if (customer.isBlacklisted) DesignTokens.Color.Brand.Error else DesignTokens.Color.Ink,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
    }

    if (confirmBlacklist) {
        val willBlock = !customer.isBlacklisted
        GlassDialog(
            visible = true,
            onDismiss = { confirmBlacklist = false },
            title = if (willBlock) "Blacklist this customer?" else "Remove from blacklist?",
            body = {
                Text(
                    if (willBlock) {
                        "${customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber} will be " +
                            "flagged so you can filter them out in one tap."
                    } else {
                        "They will return to your normal customer list."
                    },
                    color = DesignTokens.Color.Ink.copy(alpha = 0.7f)
                )
            },
            dismissLabel = "Cancel",
            confirmLabel = if (willBlock) "Blacklist" else "Unblock",
            onConfirm = {
                confirmBlacklist = false
                onToggleBlacklist()
            },
            confirmDangerous = willBlock
        )
    }

    GlassBottomSheet(
        visible = showContacts,
        onDismiss = { showContacts = false }
    ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 18.dp, bottom = 12.dp)
            ) {
                Text("Contact", color = DesignTokens.Color.Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(
                    customer.phoneNumber,
                    color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                ContactRow("WhatsApp", Icons.Rounded.Message, DesignTokens.Color.Brand.Primary) {
                    openUri(context, CustomerBook.whatsappUri(customer.phoneNumber))
                }
                ContactRow("Phone call", Icons.Rounded.Call, DesignTokens.Color.Brand.Primary) {
                    openUri(context, CustomerBook.dialUri(customer.phoneNumber))
                }
                ContactRow("SMS", Icons.Rounded.Message, DesignTokens.Color.Brand.Primary) {
                    openUri(context, CustomerBook.smsUri(customer.phoneNumber))
                }
                Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
            }
    }
}

@Composable
private fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(DesignTokens.Color.Card.copy(alpha = 0.06f))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Text(label, color = DesignTokens.Color.Ink.copy(alpha = 0.5f), fontSize = 10.sp)
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            value,
            color = DesignTokens.Color.Ink,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
    }
}

@Composable
private fun ActionPill(
    label: String,
    icon: ImageVector,
    tint: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(DesignTokens.Color.Card.copy(alpha = 0.06f))
            .border(1.dp, DesignTokens.Color.Border, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, color = DesignTokens.Color.Ink, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun ContactRow(label: String, icon: ImageVector, tint: androidx.compose.ui.graphics.Color, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(horizontal = 4.dp, vertical = 12.dp)
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(label, color = DesignTokens.Color.Ink, fontSize = 15.sp, modifier = Modifier.weight(1f))
    }
}

/** Fires an implicit intent for [uri] (wa.me / tel: / smsto:) with a guarded launch. */
private fun openUri(context: Context, uri: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    } catch (t: Throwable) {
        try {
            val fallback = if (uri.startsWith("smsto:")) uri.replace("smsto:", "tel:") else uri
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(fallback)))
        } catch (_: Throwable) {
        }
    }
}

/** "1234.0" -> "1234", "1234.5" -> "1234.5" — no trailing ".0" in a money line. */
private fun formatAmount(value: Double): String =
    if (value % 1.0 == 0.0) value.toLong().toString() else String.format(Locale.US, "%.2f", value)
