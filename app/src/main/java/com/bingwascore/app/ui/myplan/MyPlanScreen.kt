package com.bingwascore.app.ui.myplan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.home.CreditRow
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.IOS_CARD_RADIUS
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.formatCustomerName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Stage 12 — the state behind [MyPlanScreen].
 *
 * Hero data only: the active plan (what is LEFT) plus the earned-credit ledger.
 * Stage 13 grows this into the full plan catalogue + purchase flow.
 */
@HiltViewModel
class MyPlanViewModel @Inject constructor(
    transactionRepository: TransactionRepository,
    userPreferences: UserPreferences
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
}

/**
 * Stage 12 — My Plan (hero card + ledger).
 *
 * The credits bubble opens here because this is where "what do I have left?"
 * is answered: the active plan with its countdown, or the earned-credit count
 * when no plan is active. Stage 13 adds the plan catalogue and purchase flow.
 */
@Composable
fun MyPlanScreen(viewModel: MyPlanViewModel = hiltViewModel()) {
    val plan by viewModel.planState.collectAsStateWithLifecycle()
    val credits by viewModel.credits.collectAsStateWithLifecycle()
    val rows by viewModel.creditRows.collectAsStateWithLifecycle()
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

        // ── Hero card ─────────────────────────────────────────────────────
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                .background(Raised)
                .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Stars,
                contentDescription = null,
                tint = AccentBlue,
                modifier = Modifier.size(20.dp)
            )
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
        Text(
            text = "CREDITS EARNED",
            color = TextGrey,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(6.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (rows.isEmpty()) {
                item {
                    Text(
                        text = "No credits yet. Your first completed bundle will land here.",
                        color = TextGrey,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(vertical = 18.dp)
                    )
                }
            } else {
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
    }
}