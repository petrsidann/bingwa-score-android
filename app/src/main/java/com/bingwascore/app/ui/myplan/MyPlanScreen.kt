package com.bingwascore.app.ui.myplan

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Payments
import androidx.compose.material.icons.rounded.Schedule
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.PlanCatalog
import com.bingwascore.app.domain.PlanCountdown
import com.bingwascore.app.domain.PlanFamily
import com.bingwascore.app.domain.PlanOffer
import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BandWhite
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.glass.frostedGlass
import com.bingwascore.app.ui.glass.GlassSpec
import com.bingwascore.app.util.Haptics
import com.bingwascore.app.util.rememberHaptics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Stage 13 — where the simulated M-Pesa STK push stands.
 *
 * Idle -> Paying (push sent, PIN prompt on the "phone") -> Success (receipt
 * minted, plan written). The paywall page shows each beat in place, so the
 * agent never loses context mid-payment.
 */
sealed interface PurchaseState {
    object Idle : PurchaseState
    data class Paying(val planId: String) : PurchaseState
    data class Success(val planId: String, val receipt: String) : PurchaseState
}

/**
 * Stage 13 — the state behind [MyPlanScreen].
 *
 * Hero data (active plan + earned-credit count) plus the purchase flow: a plan
 * tap simulates the M-Pesa STK round-trip, mints a receipt and writes the new
 * [PlanState] straight into [UserPreferences], which is what the Home credits
 * bubble and the expiry worker both read.
 */
@HiltViewModel
class MyPlanViewModel @Inject constructor(
    transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    val planState: StateFlow<PlanState> = userPreferences.planState
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), PlanState())

    val credits: StateFlow<Int> = transactionRepository.liveTransactions
        .map { list -> list.count { it.status == TransactionStatus.SUCCESSFUL.value } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    private val _purchase = MutableStateFlow<PurchaseState>(PurchaseState.Idle)
    val purchaseState: StateFlow<PurchaseState> = _purchase

    /**
     * Stage 13 — the purchase: hold the page in Paying across a simulated
     * STK push, then mint the receipt and activate the plan in one beat.
     */
    fun purchase(planId: String) {
        val offer = PlanCatalog.byId(planId) ?: return
        if (_purchase.value is PurchaseState.Paying) return
        viewModelScope.launch {
            _purchase.value = PurchaseState.Paying(planId)
            delay(PAY_MILLIS)
            val now = System.currentTimeMillis()
            val receipt = PlanCatalog.receiptFor(planId, now)
            userPreferences.setPlanState(offer.toPlanState(now))
            _purchase.value = PurchaseState.Success(planId, receipt)
        }
    }

    companion object {
        /** The simulated STK push round-trip: long enough to read, short enough to trust. */
        const val PAY_MILLIS = 1_200L
    }
}
/**
 * Stage 20 — the state behind the My Plan paywall.
 *
 * [family] is the segment the agent is looking at (STEADY or BULK ENGINE) and
 * [nowMillis] is the clock the countdown reads, so a snapshot renders the same
 * picture every time.
 */
data class MyPlanScreenState(
    val plan: PlanState = PlanState(),
    val credits: Int = 0,
    val purchase: PurchaseState = PurchaseState.Idle,
    val family: PlanFamily = PlanFamily.STEADY,
    val nowMillis: Long = System.currentTimeMillis()
)

/** Stage 20 — every My Plan side effect as a plain callback. */
data class MyPlanScreenCallbacks(
    val onPurchase: (offer: PlanOffer) -> Unit = {}
)

/**
 * Stage 13 — My Plan: the M-Y monogram hero, the plan matrix and the ledger.
 *
 * The hero answers "what do I have left?" (plan + countdown, or earned-credit
 * count). The matrix sells the catalogue: four individual pulls plans, four
 * bulk unlimited plans, each tap opening the M-Pesa confirm sheet.
 */
@Composable
fun MyPlanScreen(viewModel: MyPlanViewModel = hiltViewModel()) {
    // STAGE 19.7 — the wrapper owns the ViewModel; the content below is pure.
    val plan by viewModel.planState.collectAsStateWithLifecycle()
    val credits by viewModel.credits.collectAsStateWithLifecycle()
    val purchase by viewModel.purchaseState.collectAsStateWithLifecycle()
    val clock = remember { System.currentTimeMillis() }

    MyPlanScreenContent(
        state = MyPlanScreenState(
            plan = plan,
            credits = credits,
            purchase = purchase,
            nowMillis = clock
        ),
        callbacks = MyPlanScreenCallbacks(
            onPurchase = { offer -> viewModel.purchase(offer.planId) }
        )
    )
}

/**
 * Stage 26 — the paywall with Meta frosted glass per GlassSpec tokens.
 *
 * Header + plan cards use Meta frosted glass (scrim alpha 0.62 in Obsidian,
 * 0.55 in Porcelain Dim, 28dp blur, 1dp top highlight, soft shadow).
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyPlanScreenContent(
    state: MyPlanScreenState = MyPlanScreenState(),
    callbacks: MyPlanScreenCallbacks = MyPlanScreenCallbacks(),
    haptics: Haptics = rememberHaptics()
) {
    var family by remember(state.family) { mutableStateOf(state.family) }
    val plans = PlanCatalog.family(family)
    val activePlanId = state.plan.planId
    val startPage = plans.indexOfFirst { it.planId == activePlanId }.coerceAtLeast(0)
    val pagerState = rememberPagerState(initialPage = startPage, pageCount = { plans.size })
    val now = tickingClock(state.nowMillis)

    // Switching family lands on the active plan's page (or the first one).
    LaunchedEffect(family) {
        val target = PlanCatalog.family(family)
            .indexOfFirst { it.planId == activePlanId }
            .coerceAtLeast(0)
        pagerState.scrollToPage(target)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
    ) {
        PlanBand(
            plan = state.plan,
            credits = state.credits,
            nowMillis = now
        )

        Spacer(modifier = Modifier.height(8.dp))

        FamilyPill(
            family = family,
            onSelect = { picked ->
                if (picked != family) {
                    haptics.tick()
                    family = picked
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            pageSpacing = 12.dp
        ) { index ->
            val offer = plans[index]
            PlanPaywallPage(
                offer = offer,
                isActive = state.plan.isActive && state.plan.planId == offer.planId,
                countdown = PlanCountdown.label(state.plan.expiresAtMillis - now),
                purchase = state.purchase,
                onActivate = {
                    haptics.press()
                    callbacks.onPurchase(offer)
                },
                haptics = haptics
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            plans.indices.forEach { index ->
                val active = index == pagerState.currentPage
                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(if (active) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(if (active) AccentBlue else TextDim)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

/**
 * The live clock behind the countdown.
 *
 * It ticks once a second so the badge is honest, but it never ticks inside an
 * inspection (a snapshot must land on the same picture every run).
 */
@Composable
private fun tickingClock(seedMillis: Long): Long {
    var tick by remember(seedMillis) { mutableLongStateOf(seedMillis) }
    val inspection = LocalInspectionMode.current
    LaunchedEffect(seedMillis, inspection) {
        if (inspection) return@LaunchedEffect
        while (true) {
            delay(1_000L)
            tick = System.currentTimeMillis()
        }
    }
    return tick
}

/**
 * Stage 20 — the aurora band: opaque blue gradient, the M-Y monogram, the
 * screen title and the one line that says what the agent has.
 */
@Composable
private fun PlanBand(
    plan: PlanState,
    credits: Int,
    nowMillis: Long
) {
    val remaining = plan.remainingLabel(nowMillis)
    val line = when {
        plan.isActive && plan.unlimited -> "${plan.displayName} · $remaining left"
        plan.isActive -> "${plan.displayName} · $remaining pulls left"
        else -> "$credits credits earned · activate a plan to start dialing"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .frostedGlass(RoundedCornerShape(20.dp))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            MonogramTile(letters = "MY")
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "My Plan",
                    color = TextWhite,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = line,
                    color = TextGrey,
                    fontSize = 12.sp
                )
            }
        }
    }
}

/**
 * Stage 20 — the M-Y monogram tile: a solid white chip with the blue mark.
 */
@Composable
private fun MonogramTile(letters: String, size: Dp = 40.dp) {
    val shape = RoundedCornerShape(size * 0.3f)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size)
            .clip(shape)
            .background(BandWhite)
    ) {
        Text(
            text = letters,
            color = AccentBlue,
            fontSize = (size.value * 0.32f).sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Stage 20 — the family pill: STEADY on the left, BULK ENGINE on the right.
 */
@Composable
private fun FamilyPill(
    family: PlanFamily,
    onSelect: (PlanFamily) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .frostedGlass(RoundedCornerShape(22.dp))
                .padding(4.dp)
        ) {
            PlanFamily.entries.forEach { candidate ->
                val selected = candidate == family
                val interactionSource = remember { MutableInteractionSource() }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .pressScale(interactionSource)
                        .clip(RoundedCornerShape(18.dp))
                        .background(if (selected) AccentBlue else Color.Transparent)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = { onSelect(candidate) }
                        )
                        .padding(horizontal = 20.dp, vertical = 9.dp)
                ) {
                    Text(
                        text = candidate.label,
                        color = if (selected) CtaInk else TextGrey,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

/**
 * Stage 20 — one plan, one page: title, truth subtitle, price, three benefit
 * rows, the expander, the legal line and the CTA. The ACTIVE plan swaps the
 * CTA for its badge and the live countdown.
 */
@Composable
private fun PlanPaywallPage(
    offer: PlanOffer,
    isActive: Boolean,
    countdown: String,
    purchase: PurchaseState,
    onActivate: () -> Unit,
    haptics: Haptics
) {
    var expanded by remember { mutableStateOf(false) }
    val paying = purchase is PurchaseState.Paying && purchase.planId == offer.planId
    val success = purchase as? PurchaseState.Success
    val justActivated = success != null && success.planId == offer.planId

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .frostedGlass(RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = offer.displayName,
                    color = TextWhite,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                if (isActive) {
                    Spacer(modifier = Modifier.width(8.dp))
                    ActiveBadge()
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = offer.truthSubtitle,
                color = TextGrey,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Ksh ${offer.priceKes}",
                    color = AccentBlue,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "once · via M-Pesa",
                    color = TextDim,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            BenefitRow(
                icon = Icons.Rounded.Bolt,
                title = offer.allowanceTitle,
                desc = offer.allowanceDesc
            )
            BenefitRow(
                icon = Icons.Rounded.Schedule,
                title = offer.windowTitle,
                desc = offer.windowDesc
            )
            BenefitRow(
                icon = Icons.Rounded.Payments,
                title = offer.priceTitle,
                desc = offer.priceDesc
            )

            Spacer(modifier = Modifier.height(4.dp))

            BenefitsExpander(
                expanded = expanded,
                onToggle = {
                    haptics.tick()
                    expanded = !expanded
                }
            )

            if (expanded) {
                FactsBlock(offer)
            }
        }

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Hairline)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = offer.legalLine,
                color = TextDim,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            when {
                justActivated -> ActivePanel(countdown = countdown, receipt = success!!.receipt)
                isActive -> ActivePanel(countdown = countdown, receipt = null)
                else -> PrimaryButton(
                    text = offer.ctaLabel,
                    onClick = onActivate,
                    loading = paying,
                    loadingText = "Waiting for M-Pesa…"
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

/** Stage 20 — the ACTIVE badge: a solid blue pill. */
@Composable
private fun ActiveBadge() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(AccentBlue)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text = "ACTIVE",
            color = BandWhite,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Stage 20 — one benefit row: icon, bold title, grey description. */
@Composable
private fun BenefitRow(icon: ImageVector, title: String, desc: String) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(AccentBlue.copy(alpha = 0.14f))
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AccentBlue,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = TextWhite,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = desc,
                color = TextGrey,
                fontSize = 11.sp
            )
        }
    }
}

/** Stage 20 — the "Explore all benefits" expander. */
@Composable
private fun BenefitsExpander(expanded: Boolean, onToggle: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .pressScale(interactionSource)
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onToggle
            )
            .padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = if (expanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
            contentDescription = null,
            tint = AccentBlue,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "Explore all benefits",
            color = AccentBlue,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/** Stage 20 — the expanded facts: nothing but the plan's own numbers. */
@Composable
private fun FactsBlock(offer: PlanOffer) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Raised)
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        FactRow("Plan", offer.displayName)
        FactRow("Allowance", offer.allowanceLabel)
        FactRow("Window", "${offer.durationLabel} from activation")
        FactRow("Payment", "Ksh ${offer.priceKes} via M-Pesa")
    }
}

@Composable
private fun FactRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
        Text(
            text = label,
            color = TextGrey,
            fontSize = 12.sp,
            modifier = Modifier.width(88.dp)
        )
        Text(
            text = value,
            color = TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * Stage 20 — the active plan: no CTA, the badge and the live countdown. Right
 * after a purchase it also shows the receipt the STK push returned.
 */
@Composable
private fun ActivePanel(countdown: String, receipt: String?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AccentBlue.copy(alpha = 0.12f))
            .border(1.dp, AccentBlue.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = if (receipt == null) AccentBlue else TickGreen,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = if (receipt == null) "Active plan" else "Plan activated",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = receipt ?: countdown,
                color = if (receipt == null) AccentBlue else TickGreen,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            if (receipt != null) {
                Text(
                    text = countdown,
                    color = TextGrey,
                    fontSize = 12.sp
                )
            }
        }
    }
}
