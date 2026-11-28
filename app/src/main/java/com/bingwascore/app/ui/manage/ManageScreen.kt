package com.bingwascore.app.ui.manage

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
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.domain.CustomerBook
import com.bingwascore.app.domain.PlanOffer
import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.ui.components.GlassBottomSheet
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GlassSearchBar
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.formatCustomerName
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ManageScreen(
    onBack: () -> Unit = {},
    viewModel: ManageViewModel = hiltViewModel()
) {
    val tab by viewModel.selectedTab.collectAsStateWithLifecycle()
    val customers by viewModel.customers.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()
    val selected by viewModel.selected.collectAsStateWithLifecycle()
    val stats by viewModel.selectedStats.collectAsStateWithLifecycle()
    val plan by viewModel.planState.collectAsStateWithLifecycle()

    ManageScreenContent(
        tab = tab,
        onTabChange = viewModel::selectTab,
        customers = customers,
        query = query,
        onQueryChange = viewModel::setQuery,
        selected = selected,
        stats = stats,
        onSelectCustomer = viewModel::selectCustomer,
        onCloseDetail = viewModel::closeDetail,
        plan = plan,
        allPlans = viewModel.allPlans,
        onBack = onBack
    )
}

@Composable
internal fun ManageScreenContent(
    tab: ManageTab = ManageTab.OVERVIEW,
    onTabChange: (ManageTab) -> Unit = {},
    customers: List<Customer> = emptyList(),
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    selected: Customer? = null,
    stats: CustomerBook.Stats? = null,
    onSelectCustomer: (Customer) -> Unit = {},
    onCloseDetail: () -> Unit = {},
    plan: PlanState = PlanState(),
    allPlans: List<PlanOffer> = emptyList(),
    onBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        TopBar(title = "Manage", onBack = onBack)

        Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))

        Subtabs(tab = tab, onSelect = onTabChange)

        Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))

        when (tab) {
            ManageTab.OVERVIEW -> OverviewTab()
            ManageTab.OFFERS -> EmptyTab(title = "Offers", message = "No offers configured yet")
            ManageTab.CUSTOMERS -> CustomersTab(
                customers = customers,
                query = query,
                onQueryChange = onQueryChange,
                onSelect = onSelectCustomer
            )
            ManageTab.RENEWALS -> EmptyTab(title = "Renewals", message = "No auto-renewals set up yet")
            ManageTab.REPLIES -> EmptyTab(title = "Replies", message = "No auto-replies configured yet")
        }
    }

    GlassBottomSheet(
        visible = selected != null,
        onDismiss = onCloseDetail
    ) {
        if (selected != null) {
            CustomerDetailSheet(customer = selected, stats = stats, onClose = onCloseDetail)
        }
    }
}

@Composable
private fun TopBar(title: String, onBack: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DesignTokens.Spacing.Md)
            .padding(top = DesignTokens.Spacing.Md)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = DesignTokens.LocalBingwaRoles.current.textPrimary,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBack() }
        )
        Spacer(modifier = Modifier.width(DesignTokens.Spacing.Md))
        Text(
            text = title,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = DesignTokens.Typography.Headline.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun Subtabs(tab: ManageTab, onSelect: (ManageTab) -> Unit) {
    val tabs = listOf(
        ManageTab.OVERVIEW to "Overview",
        ManageTab.OFFERS to "Offers",
        ManageTab.CUSTOMERS to "Customers",
        ManageTab.RENEWALS to "Renewals",
        ManageTab.REPLIES to "Replies"
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Sm),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DesignTokens.Spacing.Md)
    ) {
        tabs.forEach { (item, label) ->
            val active = item == tab
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                    .background(if (active) DesignTokens.Hero.surface else Color.Transparent)
                    .clickable { onSelect(item) }
                    .padding(vertical = DesignTokens.Spacing.Sm),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = if (active) DesignTokens.Hero.ink else DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun CustomersTab(
    customers: List<Customer>,
    query: String,
    onQueryChange: (String) -> Unit,
    onSelect: (Customer) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DesignTokens.Spacing.Md)
    ) {
        GlassSearchBar(query = query, onQueryChange = onQueryChange)
        Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
        if (customers.isEmpty()) {
            EmptyCustomers(query = query)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = DesignTokens.Spacing.Sm),
                verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
            ) {
                itemsIndexed(customers, key = { _, customer -> customer.phoneNumber }) { index, customer ->
                    CustomerRow(
                        customer = customer,
                        onClick = { onSelect(customer) }
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyCustomers(query: String) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = DesignTokens.Spacing.Lg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = DesignTokens.Spacing.Lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = null,
                tint = DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.2f),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Text(
                text = if (query.isBlank()) "No customers yet" else "No matches",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold
            )
            if (query.isBlank()) {
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Sm))
                Text(
                    text = "Every completed purchase saves a customer here.",
                    color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                    fontSize = DesignTokens.Typography.Caption
                )
            }
        }
    }
}

@Composable
private fun CustomerRow(
    customer: Customer,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(DesignTokens.Spacing.Md)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initialsOf(customer.name ?: customer.phoneNumber),
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(DesignTokens.Spacing.Md))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = formatCustomerName(customer.name).ifBlank { customer.phoneNumber },
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${customer.phoneNumber} · Ksh ${money(customer.totalSpent)}",
                    color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                    fontSize = DesignTokens.Typography.Caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(DesignTokens.Spacing.Sm))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                    .background(DesignTokens.LocalBingwaRoles.current.card.copy(alpha = 0.06f))
                    .border(
                        1.dp,
                        DesignTokens.LocalBingwaRoles.current.border,
                        RoundedCornerShape(DesignTokens.Shape.RadiusFull)
                    )
                    .padding(horizontal = 14.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "View",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Caption,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun CustomerDetailSheet(
    customer: Customer,
    stats: CustomerBook.Stats?,
    onClose: () -> Unit
) {
    val dateFmt = remember { SimpleDateFormat("d MMM yyyy", Locale.getDefault()) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DesignTokens.Spacing.Md)
            .padding(top = DesignTokens.Spacing.Md, bottom = DesignTokens.Spacing.Sm)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initialsOf(customer.name ?: customer.phoneNumber),
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(DesignTokens.Spacing.Md))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = formatCustomerName(customer.name).ifBlank { customer.phoneNumber },
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = customer.phoneNumber,
                    color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            Text(
                text = "Close",
                color = DesignTokens.LocalBingwaRoles.current.brand,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { onClose() }
            )
        }

        Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))

        if (stats == null || stats.txCount == 0) {
            Text(
                text = "No completed purchases recorded yet.",
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = DesignTokens.Typography.Body,
                modifier = Modifier.padding(vertical = DesignTokens.Spacing.Md)
            )
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                DetailStat(label = "Total spent", value = "Ksh ${money(stats.totalSpent)}", modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Md))
                DetailStat(label = "Purchases", value = "${stats.txCount}", modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Row(modifier = Modifier.fillMaxWidth()) {
                DetailStat(
                    label = "Most bought",
                    value = stats.mostBoughtOffer ?: "—",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Md))
                DetailStat(
                    label = "Churn risk",
                    value = churnRisk(stats.lastFive.firstOrNull()?.at),
                    modifier = Modifier.weight(1f)
                )
            }
            if (stats.lastFive.isNotEmpty()) {
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
                Text(
                    text = "History",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(DesignTokens.Spacing.Sm))
                stats.lastFive.forEach { sale ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = sale.offerName,
                                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                fontSize = 13.sp,
                                maxLines = 1
                            )
                            Text(
                                text = dateFmt.format(Date(sale.at)),
                                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                                fontSize = 11.sp
                            )
                        }
                        Text(
                            text = "Ksh ${money(sale.amount)}",
                            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailStat(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
            .background(DesignTokens.LocalBingwaRoles.current.card.copy(alpha = 0.06f))
            .padding(DesignTokens.Spacing.Md)
    ) {
        Text(
            text = label,
            color = DesignTokens.LocalBingwaRoles.current.textSecondary,
            fontSize = DesignTokens.Typography.Caption
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = DesignTokens.Typography.Body,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun CreditsTab(plan: PlanState, allPlans: List<PlanOffer>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = DesignTokens.Spacing.Md),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        itemsIndexed(allPlans, key = { _, offer -> offer.planId }) { index, offer ->
            PlanCard(offer = offer, isCurrent = plan.planId == offer.planId, expiresAt = plan.expiresAtMillis)
        }
    }
}

@Composable
private fun PlanCard(offer: PlanOffer, isCurrent: Boolean, expiresAt: Long) {
    val borderColor = if (isCurrent) DesignTokens.Semantic.complete else DesignTokens.LocalBingwaRoles.current.border
    val now = tickingClock()
    val remaining = (expiresAt - now).coerceAtLeast(0L)
    val countdown = if (isCurrent && remaining > 0L) countdownLabel(remaining) else ""

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isCurrent) 2.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(DesignTokens.Shape.RadiusLg)
            )
    ) {
        Column(modifier = Modifier.padding(DesignTokens.Spacing.Md)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = offer.displayName,
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Headline.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = offer.truthSubtitle,
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Body
                    )
                }
                if (isCurrent) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                            .background(DesignTokens.Semantic.complete.copy(alpha = 0.14f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "CURRENT",
                            color = DesignTokens.LocalBingwaRoles.current.onBrand,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Md))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Ksh ${offer.priceKes}",
                    color = DesignTokens.LocalBingwaRoles.current.brand,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(DesignTokens.Spacing.Sm))
                Text(
                    text = if (isCurrent && countdown.isNotBlank()) countdown else "",
                    color = DesignTokens.Semantic.complete,
                    fontSize = DesignTokens.Typography.Body,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun tickingClock(): Long {
    var tick by remember { mutableLongStateOf(System.currentTimeMillis()) }
    val inspection = LocalInspectionMode.current
    LaunchedEffect(Unit) {
        if (inspection) return@LaunchedEffect
        while (true) {
            delay(1_000L)
            tick = System.currentTimeMillis()
        }
    }
    return tick
}

private fun countdownLabel(remainingMillis: Long): String {
    val seconds = remainingMillis / 1000
    val days = seconds / 86400
    val hours = (seconds % 86400) / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return "%d:%02d:%02d:%02d".format(days, hours, minutes, secs)
}

private fun churnRisk(lastPurchaseAt: Long?): String {
    if (lastPurchaseAt == null || lastPurchaseAt == 0L) return "—"
    val daysAgo = (System.currentTimeMillis() - lastPurchaseAt) / (24 * 60 * 60 * 1000)
    return when {
        daysAgo > 30 -> "High"
        daysAgo > 14 -> "Medium"
        else -> "Low"
    }
}

private fun initialsOf(name: String): String {
    val parts = name.trim().split(Regex("\\s+")).filter { it.isNotBlank() }
    return when {
        parts.isEmpty() -> "?"
        parts.size == 1 -> parts.first().take(1).uppercase(Locale.ROOT)
        else -> (parts[0].take(1) + parts[1].take(1)).uppercase(Locale.ROOT)
    }
}

private fun money(value: Double): String =
    String.format(Locale.US, "%,.2f", value)

@Composable
private fun OverviewTab() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = DesignTokens.Spacing.Md),
        contentPadding = PaddingValues(vertical = DesignTokens.Spacing.Md),
        verticalArrangement = Arrangement.spacedBy(DesignTokens.Spacing.Md)
    ) {
        item {
            Text(
                text = "Overview",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = DesignTokens.Typography.Headline.fontSize,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Sm))
            Text(
                text = "Dashboard metrics and quick actions moved here from Home.",
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = DesignTokens.Typography.Body
            )
        }
        
        // Placeholder cards for migrated Home sections
        item {
            GlassCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(DesignTokens.Spacing.Md)) {
                    Text(
                        text = "Hero section — greeting, credits, autopilot eye, completed today, failed bulb, quick action tiles",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                    Text(
                        text = "To be restored from pre-R1 HomeScreen in next iteration.",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Caption
                    )
                }
            }
        }
        
        item {
            GlassCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(DesignTokens.Spacing.Md)) {
                    Text(
                        text = "Activation Ladder — engine armed, test drive, import book, recover failure steps",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                    Text(
                        text = "To be restored from pre-R1 HomeScreen in next iteration.",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Caption
                    )
                }
            }
        }
        
        item {
            GlassCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(DesignTokens.Spacing.Md)) {
                    Text(
                        text = "Payout & Offers — weekly commission, active offers with toggles",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                    Text(
                        text = "To be restored from pre-R1 HomeScreen in next iteration.",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Caption
                    )
                }
            }
        }
        
        item {
            GlassCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(DesignTokens.Spacing.Md)) {
                    Text(
                        text = "Repeat Buyers — customer list with initials, phone, total spent",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(DesignTokens.Spacing.Xs))
                    Text(
                        text = "To be restored from pre-R1 HomeScreen in next iteration.",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Caption
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyTab(title: String, message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(DesignTokens.Spacing.Md),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = DesignTokens.Typography.Headline.fontSize,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(DesignTokens.Spacing.Sm))
            Text(
                text = message,
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = DesignTokens.Typography.Body
            )
        }
    }
}
