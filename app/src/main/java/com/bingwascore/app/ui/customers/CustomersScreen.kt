package com.bingwascore.app.ui.customers

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.domain.CustomerBook
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.util.formatCustomerName
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.accentBrush
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Stage 14 — the Customers book. An autosave roll-up of every SUCCESSFUL
 * purchase: recent-activity first, searchable by name/phone, each row an
 * initials avatar + name + phone + last offer. Tapping a row opens the detail
 * sheet (spend, first purchase, most-bought, count, last 5) with a Blacklist
 * action (confirm dialog) and a Contact chooser (WhatsApp / Phone / SMS).
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
            .background(BgBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Customers", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                "${customers.size} customer(s)",
                color = TextWhite.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(14.dp))
            GlassSearchField(value = query, onValueChange = viewModel::setQuery)
            Spacer(modifier = Modifier.height(12.dp))
            // Stage 14 — the "Blacklisted" filter chip lives inside the top bar.
            BlacklistFilterChip(
                active = blacklistFilter,
                onToggle = viewModel::toggleBlacklistFilter
            )
        }

        if (customers.isEmpty()) {
            EmptyState(
                icon = Icons.Rounded.People,
                title = if (query.isBlank() && !blacklistFilter) "No customers yet" else "No matches found",
                message = if (query.isBlank() && !blacklistFilter) {
                    "Customers save themselves here every time a bundle completes."
                } else {
                    "Nothing matches — try a different name or number."
                },
                modifier = Modifier.padding(20.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(customers, key = { _, customer -> customer.phoneNumber }) { index, customer ->
                    CustomerRow(
                        customer = customer,
                        enterDelayMillis = minOf(index, 6) * Motion.STAGGER,
                        onOpen = { viewModel.openDetail(customer) }
                    )
                }
            }
        }
    }

    val open = selected
    if (open != null) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        // Stage 18 — the sheet owns the modal backdrop: screens blur behind it.
        val glassBackdrop = LocalGlassBackdrop.current
        DisposableEffect(glassBackdrop) {
            glassBackdrop?.pushModal()
            onDispose { glassBackdrop?.popModal() }
        }
        ModalBottomSheet(
            onDismissRequest = viewModel::closeDetail,
            sheetState = sheetState,
            containerColor = IosMaterialFill,
            dragHandle = null
        ) {
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
private fun BlacklistFilterChip(active: Boolean, onToggle: () -> Unit) {
    val bg = if (active) FailRed.copy(alpha = 0.16f) else Bubble
    val border = if (active) FailRed.copy(alpha = 0.5f) else Hairline
    val ink = if (active) FailRed else TextWhite.copy(alpha = 0.7f)
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
            fontSize = 12.sp,
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
    BubbleCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 18.dp,
        enterDelayMillis = enterDelayMillis,
        onClick = onOpen
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            InitialsAvatar(name = customer.name ?: customer.phoneNumber)
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber,
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    customer.phoneNumber,
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 11.sp
                )
                val lastOffer = customer.lastOfferName
                if (!lastOffer.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Last: $lastOffer",
                        color = AccentBlue,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            if (customer.isBlacklisted) {
                Text(
                    "Blocked",
                    color = FailRed,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun InitialsAvatar(name: String) {
    val initials = remember(name) { initialsOf(name) }
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(accentBrush()),
        contentAlignment = Alignment.Center
    ) {
        Text(
            initials,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold
        )
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


@OptIn(ExperimentalMaterial3Api::class)
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
            InitialsAvatar(name = customer.name ?: customer.phoneNumber)
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber,
                    color = TextWhite,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(customer.phoneNumber, color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
            }
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Close",
                tint = TextWhite.copy(alpha = 0.5f),
                modifier = Modifier.size(22.dp).clickable { onClose() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (stats == null || stats.txCount == 0) {
            Text(
                "No completed purchases recorded yet.",
                color = TextFaint,
                fontSize = 13.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        } else {
            // Stats grid: total spent / purchases / first purchase / most-bought.
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
                Text("Recent purchases", color = TextFaint, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                stats.lastFive.forEach { sale ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(sale.offerName, color = TextWhite, fontSize = 13.sp, maxLines = 1)
                            Text(
                                dateFmt.format(Date(sale.at)),
                                color = TextWhite.copy(alpha = 0.5f),
                                fontSize = 11.sp
                            )
                        }
                        Text(
                            "Ksh ${formatAmount(sale.amount)}",
                            color = TextWhite.copy(alpha = 0.8f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Actions: Contact chooser + Blacklist (confirm dialog).
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            ActionPill(
                label = "Contact",
                icon = Icons.Rounded.Call,
                tint = AccentBlue,
                modifier = Modifier.weight(1f),
                onClick = { showContacts = true }
            )
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(if (customer.isBlacklisted) FailRed.copy(alpha = 0.14f) else Bubble)
                    .border(
                        1.dp,
                        if (customer.isBlacklisted) FailRed.copy(alpha = 0.5f) else Hairline,
                        RoundedCornerShape(14.dp)
                    )
                    .clickable { confirmBlacklist = true }
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                Icon(
                    Icons.Rounded.Block,
                    contentDescription = null,
                    tint = if (customer.isBlacklisted) FailRed else TextWhite.copy(alpha = 0.7f),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    if (customer.isBlacklisted) "Unblock" else "Blacklist",
                    color = if (customer.isBlacklisted) FailRed else TextWhite,
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
        AlertDialog(
            onDismissRequest = { confirmBlacklist = false },
            containerColor = Raised,
            title = {
                Text(
                    if (willBlock) "Blacklist this customer?" else "Remove from blacklist?",
                    color = TextWhite,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    if (willBlock) {
                        "${customer.name?.let { formatCustomerName(it) } ?: customer.phoneNumber} will be " +
                            "flagged so you can filter them out in one tap."
                    } else {
                        "They will return to your normal customer list."
                    },
                    color = TextWhite.copy(alpha = 0.7f)
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    confirmBlacklist = false
                    onToggleBlacklist()
                }) {
                    Text(if (willBlock) "Blacklist" else "Unblock", color = FailRed)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmBlacklist = false }) {
                    Text("Cancel", color = TextWhite.copy(alpha = 0.7f))
                }
            }
        )
    }

    if (showContacts) {
        ModalBottomSheet(
            onDismissRequest = { showContacts = false },
            containerColor = Raised,
            dragHandle = null
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 18.dp, bottom = 12.dp)
            ) {
                Text("Contact", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(
                    customer.phoneNumber,
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                ContactRow("WhatsApp", Icons.Rounded.Message, AccentBlue) {
                    openUri(context, CustomerBook.whatsappUri(customer.phoneNumber))
                }
                ContactRow("Phone call", Icons.Rounded.Call, AccentBlue) {
                    openUri(context, CustomerBook.dialUri(customer.phoneNumber))
                }
                ContactRow("SMS", Icons.Rounded.Message, AccentBlue) {
                    openUri(context, CustomerBook.smsUri(customer.phoneNumber))
                }
                Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
            }
        }
    }
}


@Composable
private fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Bubble)
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Text(label, color = TextFaint, fontSize = 10.sp)
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            value,
            color = TextWhite,
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
    tint: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Bubble)
            .border(1.dp, Hairline, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, color = TextWhite, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun ContactRow(label: String, icon: ImageVector, tint: Color, onClick: () -> Unit) {
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
        Text(label, color = TextWhite, fontSize = 15.sp, modifier = Modifier.weight(1f))
    }
}

/** Fires an implicit intent for [uri] (wa.me / tel: / smsto:) with a guarded launch. */
private fun openUri(context: Context, uri: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    } catch (t: Throwable) {
        // No app can handle it — fall back to the dialer for the tel: family.
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

@Composable
private fun GlassSearchField(value: String, onValueChange: (String) -> Unit) {
    val shape = RoundedCornerShape(16.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = TextFaint,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier.weight(1f)) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(color = TextWhite, fontSize = 15.sp),
                    cursorBrush = SolidColor(AccentBlue),
                    modifier = Modifier.fillMaxWidth()
                )
                if (value.isEmpty()) {
                    Text(
                        "Search name or phone number",
                        color = TextFaint,
                        fontSize = 15.sp
                    )
                }
            }
            if (value.isNotEmpty()) {
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Clear search",
                    tint = TextWhite.copy(alpha = 0.5f),
                    modifier = Modifier
                        .size(18.dp)
                        .clickable { onValueChange("") }
                )
            }
        }
    }
}

