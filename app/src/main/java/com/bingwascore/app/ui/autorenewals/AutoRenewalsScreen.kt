package com.bingwascore.app.ui.autorenewals

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.bingwascore.app.ui.components.GlassBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.DisposableEffect
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
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.SelfRenewalSchedule
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.settings.PremiumToggle
import com.bingwascore.app.ui.theme.DesignTokens
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Stage 53 — Self-Renewal as an automation dashboard. The scheduled queue is
 * rendered as tactile GlassCard automation cards (icon, title, reused
 * PremiumToggle). Toggling a rule off fades its content to 0.5 alpha.
 * ViewModel and data fetching are untouched — only UI composition changed.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoRenewalsScreen(viewModel: SelfRenewalViewModel = hiltViewModel()) {
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val scheduled by viewModel.scheduled.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val saved by viewModel.saved.collectAsStateWithLifecycle()

    var showComposer by remember { mutableStateOf(false) }
    var now by remember { mutableStateOf(System.currentTimeMillis()) }
    LaunchedEffect(Unit) {
        while (true) {
            now = System.currentTimeMillis()
            kotlinx.coroutines.delay(1_000)
        }
    }
    LaunchedEffect(saved) {
        if (saved) {
            showComposer = false
            viewModel.consumeSaved()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Auto-Renewals",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                    fontSize = DesignTokens.Typography.Headline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "${scheduled.size} scheduled renewal(s)",
                    color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                    fontSize = DesignTokens.Typography.Caption
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
                    .background(DesignTokens.LocalBingwaRoles.current.brand)
                    .clickable { showComposer = true }
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.Add, contentDescription = null, tint = DesignTokens.LocalBingwaRoles.current.textPrimary, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Schedule", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = DesignTokens.Typography.Caption, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Scheduled",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = DesignTokens.Typography.Headline,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        if (scheduled.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 16.dp)) {
                AutomationEmptyState()
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(scheduled, key = { _, tx -> tx.id }) { index, tx ->
                    AutomationCard(
                        tx = tx,
                        enterDelayMillis = minOf(index, 6) * 40
                    )
                }
            }
        }
    }

    if (showComposer) {
        GlassBottomSheet(
            visible = true,
            onDismiss = { showComposer = false; viewModel.clearError() }
        ) {
            ScheduleComposer(
                offers = offers,
                error = error,
                onSubmit = { draft -> viewModel.schedule(draft) }
            )
        }
    }
}

@Composable
private fun AutomationEmptyState() {
    GlassCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.Autorenew,
                contentDescription = null,
                tint = DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.2f),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "No automations yet",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = DesignTokens.Typography.Body,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Schedule an offer and it dials itself when the moment comes.",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                fontSize = DesignTokens.Typography.Caption
            )
        }
    }
}

@Composable
private fun AutomationCard(
    tx: Transaction,
    enterDelayMillis: Int
) {
    val fireAt = tx.scheduledAt ?: tx.createdAt
    val dateFmt = remember { SimpleDateFormat("d MMM, HH:mm", Locale.getDefault()) }
    var enabled by remember { mutableStateOf(true) }
    val contentAlpha by animateFloatAsState(
        targetValue = if (enabled) 1f else 0.5f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "AutomationCardAlpha"
    )

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { alpha = contentAlpha }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Autorenew,
                    contentDescription = null,
                    tint = DesignTokens.LocalBingwaRoles.current.brand,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        tx.offerName,
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                PremiumToggle(checked = enabled, onCheckedChange = { enabled = it })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "${tx.phoneNumber}  •  ${dateFmt.format(Date(fireAt))}",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                fontSize = DesignTokens.Typography.Caption,
                maxLines = 2
            )
        }
    }
}

/**
 * The schedule composer: an iOS-style stack of choices — pick an offer (chips),
 * type the phone, then pick a day (Today/Tomorrow chips) and an hour. Submits a
 * [SelfRenewalSchedule.Draft]; the ViewModel validates and stores it.
 */
@Composable
private fun ScheduleComposer(
    offers: List<Offer>,
    error: String?,
    onSubmit: (SelfRenewalSchedule.Draft) -> Unit
) {
    var selectedOffer by remember { mutableStateOf<Offer?>(null) }
    var phone by remember { mutableStateOf("") }
    var dayOffset by remember { mutableStateOf(0) }
    var hour by remember { mutableStateOf(nextRoundHour()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 18.dp, bottom = 12.dp)
    ) {
        Text("Schedule a renewal", color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "It dials itself at the time you pick — no reminders needed.",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("OFFER", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(offers, key = { it.id }) { offer ->
                ChoiceChip(
                    label = offer.name,
                    sublabel = "Ksh ${offer.price}",
                    selected = selectedOffer?.id == offer.id,
                    onClick = { selectedOffer = offer }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("PHONE", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        GlassField(value = phone, onValueChange = { phone = it }, placeholder = "0712 345 678")

        Spacer(modifier = Modifier.height(16.dp))
        Text("DAY", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DayChip("Today", 0, dayOffset) { dayOffset = 0 }
            DayChip("Tomorrow", 1, dayOffset) { dayOffset = 1 }
            DayChip(dayAfterLabel(), 2, dayOffset) { dayOffset = 2 }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("TIME", color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(HOURS, key = { it }) { h ->
                ChoiceChip(
                    label = MyScoreLabel(h),
                    sublabel = null,
                    selected = hour == h,
                    onClick = { hour = h }
                )
            }
        }

        if (error != null) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(error, color = DesignTokens.LocalBingwaRoles.current.error, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(18.dp))
        PrimaryButton(
            text = "Schedule renewal",
            onClick = {
                val offer = selectedOffer ?: return@PrimaryButton
                onSubmit(
                    SelfRenewalSchedule.Draft(
                        offerId = offer.id,
                        offerName = offer.name,
                        ussdCode = offer.ussdCode,
                        phone = phone.trim(),
                        amount = offer.price.toDouble(),
                        commission = 0.0,
                        fireAt = fireTimeFor(dayOffset, hour)
                    )
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun ChoiceChip(
    label: String,
    sublabel: String?,
    selected: Boolean,
    onClick: () -> Unit
) {
    val bg = if (selected) DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.16f) else DesignTokens.LocalBingwaRoles.current.card.copy(alpha = 0.08f)
    val border = if (selected) DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.6f) else DesignTokens.LocalBingwaRoles.current.border
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(bg)
            .border(1.dp, border, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Text(
            label,
            color = if (selected) DesignTokens.LocalBingwaRoles.current.brand else DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
        if (sublabel != null) {
            Text(sublabel, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 11.sp)
        }
    }
}

@Composable
private fun DayChip(label: String, offset: Int, selectedOffset: Int, onClick: () -> Unit) {
    ChoiceChip(label = label, sublabel = null, selected = selectedOffset == offset, onClick = onClick)
}

@Composable
private fun GlassField(value: String, onValueChange: (String) -> Unit, placeholder: String) {
    val shape = RoundedCornerShape(14.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(DesignTokens.LocalBingwaRoles.current.card.copy(alpha = 0.08f))
            .border(1.dp, DesignTokens.LocalBingwaRoles.current.border, shape)
            .padding(horizontal = 14.dp, vertical = 13.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = DesignTokens.LocalBingwaRoles.current.textPrimary, fontSize = 15.sp),
                cursorBrush = SolidColor(DesignTokens.LocalBingwaRoles.current.brand),
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(placeholder, color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f), fontSize = 15.sp)
            }
        }
    }
}

/** Hours offered in the time picker (6am → 11pm). */
private val HOURS = listOf(6, 8, 10, 12, 14, 16, 18, 20, 22, 23)

/** "18:00" label for a chosen hour. */
private fun MyScoreLabel(hour: Int): String = "%02d:00".format(hour)

/** The next top-of-hour at or after now, clamped into [HOURS]. */
private fun nextRoundHour(): Int {
    val cal = Calendar.getInstance()
    val h = cal.get(Calendar.HOUR_OF_DAY) + 1
    return HOURS.firstOrNull { it >= h } ?: HOURS.last()
}

/** The epoch millis for [dayOffset] days out at [hour]:00 local. */
private fun fireTimeFor(dayOffset: Int, hour: Int): Long =
    Calendar.getInstance().apply {
        add(Calendar.DAY_OF_YEAR, dayOffset)
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis

/** "In 2 days" chip label for the day-after-tomorrow. */
private fun dayAfterLabel(): String =
    SimpleDateFormat("EEE", Locale.getDefault()).format(Date(fireTimeFor(2, 12)))
