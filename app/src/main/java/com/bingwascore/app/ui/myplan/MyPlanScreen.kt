package com.bingwascore.app.ui.myplan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
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
import com.bingwascore.app.domain.PlanOffer
import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.SecondaryButton
import com.bingwascore.app.ui.components.pressScale
import com.bingwascore.app.ui.home.CreditRow
import com.bingwascore.app.ui.glass.LocalGlassBackdrop
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.IOS_CARD_RADIUS
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.Haptics
import com.bingwascore.app.util.formatCustomerName
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
 * Idle (sheet open, button armed) -> Paying (push sent, PIN prompt on the
 * "phone") -> Success (receipt minted, plan written). The sheet stays open
 * through all three so the agent never loses context mid-payment.
 */
sealed interface PurchaseState {
    object Idle : PurchaseState
    object Paying : PurchaseState
    data class Success(val receipt: String) : PurchaseState
}

/**
 * Stage 13 — the state behind [MyPlanScreen].
 *
 * Hero data (active plan + earned-credit ledger) plus the purchase flow: a
 * plan tap simulates the M-Pesa STK round-trip, mints a receipt and writes
 * the new [PlanState] straight into [UserPreferences], which is what the
 * Home credits bubble and the expiry worker both read.
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

    val creditRows: StateFlow<List<CreditRow>> = transactionRepository.liveTransactions
        .map { list ->
            list.filter { it.status == TransactionStatus.SUCCESSFUL.value }
                .take(12)
                .map { tx ->
                    CreditRow(
                        title = formatCustomerName(tx.customerName).ifBlank { tx.phoneNumber },
                        subtitle = "${tx.offerName} · ${tx.phoneNumber}",
                        amount = tx.commission
                    )
                }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _purchase = MutableStateFlow<PurchaseState>(PurchaseState.Idle)
    val purchaseState: StateFlow<PurchaseState> = _purchase

    /**
     * Stage 13 — the purchase: hold the sheet in Paying across a simulated
     * STK push, then mint the receipt and activate the plan in one beat.
     */
    fun purchase(planId: String) {
        val offer = PlanCatalog.byId(planId) ?: return
        if (_purchase.value is PurchaseState.Paying) return
        viewModelScope.launch {
            _purchase.value = PurchaseState.Paying
            delay(PAY_MILLIS)
            val now = System.currentTimeMillis()
            val receipt = PlanCatalog.receiptFor(planId, now)
            userPreferences.setPlanState(offer.toPlanState(now))
            _purchase.value = PurchaseState.Success(receipt)
        }
    }

    /** Closing the sheet resets the flow so the next tap starts clean. */
    fun resetPurchase() {
        _purchase.value = PurchaseState.Idle
    }

    companion object {
        /** The simulated STK push round-trip: long enough to read, short enough to trust. */
        const val PAY_MILLIS = 1_200L
    }
}

/**
 * Stage 19.7 — the PURE My Plan surface: the hero card, the plan matrix and the
 * earned-credit ledger.
 */
data class MyPlanScreenState(
    val plan: PlanState = PlanState(),
    val credits: Int = 0,
    val creditRows: List<CreditRow> = emptyList(),
    val purchase: PurchaseState = PurchaseState.Idle
)

/** Stage 19.7 — every My Plan side effect as a plain callback. */
data class MyPlanScreenCallbacks(
    val onPurchase: (offer: PlanOffer) -> Unit = {},
    val onResetPurchase: () -> Unit = {}
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
    val rows by viewModel.creditRows.collectAsStateWithLifecycle()
    val purchase by viewModel.purchaseState.collectAsStateWithLifecycle()

    MyPlanScreenContent(
        state = MyPlanScreenState(
            plan = plan,
            credits = credits,
            creditRows = rows,
            purchase = purchase
        ),
        callbacks = MyPlanScreenCallbacks(
            onPurchase = { offer -> viewModel.purchase(offer.planId) },
            onResetPurchase = { viewModel.resetPurchase() }
        )
    )
}

/**
 * Stage 19.7 — the pure My Plan body.
 */
@Composable
fun MyPlanScreenContent(
    state: MyPlanScreenState = MyPlanScreenState(),
    callbacks: MyPlanScreenCallbacks = MyPlanScreenCallbacks(),
    haptics: Haptics = rememberHaptics()
) {
    var pendingPlan by remember { mutableStateOf<PlanOffer?>(null) }
    val plan = state.plan
    val credits = state.credits
    val rows = state.creditRows
    val purchase = state.purchase
    val label = plan.remainingLabel(System.currentTimeMillis()) ?: "$credits"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "My Plan",
            color = TextWhite,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        // ── Hero card — M-Y monogram + what is LEFT ─────────────────────────
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                .background(Raised)
                .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
                .padding(16.dp)
        ) {
            // Stage 13 — the M-Y monogram tile: the plan's initials, "MY" with no plan.
            MonogramTile(letters = PlanCatalog.monogramLetters(plan.displayName))
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = plan.displayName.ifBlank { "No active plan" },
                    color = TextWhite,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = if (plan.isActive) {
                        if (plan.unlimited) "Unlimited · $label left" else "$label pulls left"
                    } else {
                        "$credits earned · buy a plan to put them to work"
                    },
                    color = TextGrey,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "PLAN MATRIX",
                    color = TextGrey,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "INDIVIDUAL · PULLS BUDGET",
                    color = TextDim,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            items(PlanCatalog.individual, key = { it.planId }) { offer ->
                PlanMatrixCard(offer) {
                    haptics.tick()
                    pendingPlan = offer
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "BULK · UNLIMITED DAYS",
                    color = TextDim,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            items(PlanCatalog.bulk, key = { it.planId }) { offer ->
                PlanMatrixCard(offer) {
                    haptics.tick()
                    pendingPlan = offer
                }
            }
            item {
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "CREDITS EARNED",
                    color = TextGrey,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (rows.isEmpty()) {
                    Text(
                        text = "No credits yet. Your first completed bundle will land here.",
                        color = TextGrey,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(vertical = 18.dp)
                    )
                }
            }
            items(rows, key = { it.title + it.subtitle }) { row ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = row.title,
                            color = TextWhite,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1
                        )
                        Text(
                            text = row.subtitle,
                            color = TextGrey,
                            fontSize = 11.sp,
                            maxLines = 1
                        )
                    }
                    Text(
                        text = "+1",
                        color = AccentBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

    pendingPlan?.let { offer ->
        PlanConfirmSheet(
            offer = offer,
            purchase = purchase,
            onPay = { callbacks.onPurchase(offer) },
            onDismiss = {
                callbacks.onResetPurchase()
                pendingPlan = null
            }
        )
    }
}

/**
 * Stage 13 — one row of the plan matrix: name, allowance detail, KSh price.
 */
@Composable
private fun PlanMatrixCard(offer: PlanOffer, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .pressScale(interactionSource)
            .clip(RoundedCornerShape(IOS_CARD_RADIUS))
            .background(Raised)
            .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        MonogramTile(letters = PlanCatalog.monogramLetters(offer.displayName), size = 34.dp)
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = offer.displayName,
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = offer.detail,
                color = TextGrey,
                fontSize = 11.sp
            )
        }
        Text(
            text = "KSh ${offer.priceKes}",
            color = AccentBlue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Stage 13 — the M-Y monogram tile: two letters in an accent-washed square.
 * "MY" (from *My* Plan) while no plan is active, the plan's initials after.
 */
@Composable
private fun MonogramTile(letters: String, size: Dp = 40.dp) {
    val shape = RoundedCornerShape(size * 0.3f)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size)
            .clip(shape)
            .background(AccentBlue.copy(alpha = 0.14f))
            .border(1.dp, AccentBlue.copy(alpha = 0.45f), shape)
    ) {
        Text(
            text = letters,
            color = AccentBlue,
            fontSize = (size.value * 0.34f).sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Stage 13 — the M-Pesa confirm sheet.
 *
 * One tap on a matrix card opens this. It names the plan, the KSh amount the
 * STK push will ask for, and walks the three [PurchaseState] beats: Idle shows
 * the armed Pay button, Paying swaps it for a "Waiting for M-Pesa…" spinner,
 * Success mints the receipt in green and offers Done. The sheet stays open
 * through the whole round-trip so the agent never loses the plan mid-payment.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlanConfirmSheet(
    offer: PlanOffer,
    purchase: PurchaseState,
    onPay: () -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val paying = purchase is PurchaseState.Paying
    val success = purchase as? PurchaseState.Success
    // Stage 18 — the sheet owns the modal backdrop: screens blur behind it.
    val glassBackdrop = LocalGlassBackdrop.current
    DisposableEffect(glassBackdrop) {
        glassBackdrop?.pushModal()
        onDispose { glassBackdrop?.popModal() }
    }

    ModalBottomSheet(
        onDismissRequest = { if (!paying) onDismiss() },
        sheetState = sheetState,
        containerColor = IosMaterialFill,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Stars,
                    contentDescription = null,
                    tint = AccentBlue,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (success != null) "Plan activated" else "Confirm purchase",
                    color = TextWhite,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                if (success == null) {
                    Text(
                        text = "KSh ${offer.priceKes}",
                        color = AccentBlue,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))

            if (success != null) {
                Text(
                    text = "${offer.displayName} is live — ${offer.detail}.",
                    color = TextGrey,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                        .background(AccentBlue.copy(alpha = 0.12f))
                        .border(1.dp, AccentBlue.copy(alpha = 0.45f), RoundedCornerShape(IOS_CARD_RADIUS))
                        .padding(horizontal = 14.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "M-Pesa",
                        color = AccentBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = success.receipt,
                        color = TickGreen,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                Text(
                    text = "${offer.displayName} · ${offer.detail}. An M-Pesa prompt will land on your phone to approve KSh ${offer.priceKes}.",
                    color = TextGrey,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (success != null) {
                PrimaryButton(text = "Done", onClick = onDismiss)
            } else {
                PrimaryButton(
                    text = "Pay KSh ${offer.priceKes}",
                    onClick = onPay,
                    enabled = !paying,
                    loading = paying,
                    loadingText = "Waiting for M-Pesa…"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SecondaryButton(text = "Cancel", onClick = onDismiss, enabled = !paying)
            }
            Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
        }
    }
}