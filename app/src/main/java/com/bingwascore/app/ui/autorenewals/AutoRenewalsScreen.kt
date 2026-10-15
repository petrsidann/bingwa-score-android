package com.bingwascore.app.ui.autorenewals

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.SelfRenewalSchedule
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Stage 15 — Self-Renewal. Schedule offer + phone + datetime; a WorkManager
 * alarm fires the dial through the normal pipeline. The list shows every pending
 * renewal with a live countdown chip; once one completes it drops out (it now
 * lives in Completed transactions).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoRenewalsScreen(viewModel: SelfRenewalViewModel = hiltViewModel()) {
    val offers by viewModel.offers.collectAsStateWithLifecycle()
    val scheduled by viewModel.scheduled.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val saved by viewModel.saved.collectAsStateWithLifecycle()

    var showComposer by remember { mutableStateOf(false) }
    // A ticking clock so every countdown chip re-renders each second.
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
            .background(BgBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Self-Renewal", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    "${scheduled.size} scheduled renewal(s)",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(AccentBlue)
                    .clickable { showComposer = true }
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.Add, contentDescription = null, tint = TextWhite, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Schedule", color = TextWhite, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        if (scheduled.isEmpty()) {
            EmptyState(
                icon = Icons.Rounded.Autorenew,
                title = "No renewals scheduled",
                message = "Pick an offer, a number and a time — it dials itself when the moment comes.",
                modifier = Modifier.padding(20.dp),
                action = {
                    PrimaryButton(text = "Schedule a renewal", onClick = { showComposer = true })
                }
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(scheduled, key = { _, tx -> tx.id }) { index, tx ->
                    RenewalCard(
                        tx = tx,
                        now = now,
                        enterDelayMillis = minOf(index, 6) * Motion.STAGGER,
                        onCancel = { viewModel.cancel(tx) }
                    )
                }
            }
        }
    }

    if (showComposer) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        // Stage 18 — the sheet owns the modal backdrop: screens blur behind it.
        val glassBackdrop = LocalGlassBackdrop.current
        DisposableEffect(glassBackdrop) {
            glassBackdrop?.pushModal()
            onDispose { glassBackdrop?.popModal() }
        }
        ModalBottomSheet(
            onDismissRequest = { showComposer = false; viewModel.clearError() },
            sheetState = sheetState,
            containerColor = IosMaterialFill,
            dragHandle = null
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
private fun RenewalCard(
    tx: Transaction,
    now: Long,
    enterDelayMillis: Int,
    onCancel: () -> Unit
) {
    val fireAt = tx.scheduledAt ?: tx.createdAt
    val dateFmt = remember { SimpleDateFormat("d MMM, HH:mm", Locale.getDefault()) }
    BubbleCard(modifier = Modifier.fillMaxWidth(), enterDelayMillis = enterDelayMillis) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(tx.offerName, color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(tx.phoneNumber, color = TextWhite.copy(alpha = 0.5f), fontSize = 11.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "Dials ${dateFmt.format(Date(fireAt))}",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                CountdownChip(
                    label = "In ${SelfRenewalSchedule.countdownLabel(fireAt, now)}",
                    urgent = SelfRenewalSchedule.isUrgent(fireAt, now)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text("Ksh ${tx.amount.toLong()}", color = TextWhite.copy(alpha = 0.7f), fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Cancel renewal",
                tint = TextWhite.copy(alpha = 0.5f),
                modifier = Modifier.size(20.dp).clickable { onCancel() }
            )
        }
    }
}

@Composable
private fun CountdownChip(label: String, urgent: Boolean) {
    val color = if (urgent) FailRed else PendGrey
    Text(
        label,
        color = color,
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Bubble)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
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
    // Day offset from today (0 = today, 1 = tomorrow, 2 = day after).
    var dayOffset by remember { mutableStateOf(0) }
    var hour by remember { mutableStateOf(nextRoundHour()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 18.dp, bottom = 12.dp)
    ) {
        Text("Schedule a renewal", color = TextWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "It dials itself at the time you pick — no reminders needed.",
            color = TextWhite.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("OFFER", color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
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
        Text("PHONE", color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        GlassField(value = phone, onValueChange = { phone = it }, placeholder = "0712 345 678")

        Spacer(modifier = Modifier.height(16.dp))
        Text("DAY", color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DayChip("Today", 0, dayOffset) { dayOffset = 0 }
            DayChip("Tomorrow", 1, dayOffset) { dayOffset = 1 }
            DayChip(dayAfterLabel(), 2, dayOffset) { dayOffset = 2 }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("TIME", color = TextFaint, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
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
            Text(error, color = FailRed, fontSize = 12.sp)
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
    val bg = if (selected) AccentBlue.copy(alpha = 0.16f) else Bubble
    val border = if (selected) AccentBlue.copy(alpha = 0.6f) else Hairline
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
            color = if (selected) AccentBlue else TextWhite,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
        if (sublabel != null) {
            Text(sublabel, color = TextWhite.copy(alpha = 0.5f), fontSize = 11.sp)
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
            .background(Bubble)
            .border(1.dp, Hairline, shape)
            .padding(horizontal = 14.dp, vertical = 13.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = TextWhite, fontSize = 15.sp),
                cursorBrush = SolidColor(AccentBlue),
                modifier = Modifier.fillMaxWidth()
            )
            if (value.isEmpty()) {
                Text(placeholder, color = TextFaint, fontSize = 15.sp)
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

