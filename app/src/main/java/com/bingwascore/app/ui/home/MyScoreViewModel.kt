package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.MyScore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Stage 15 — "My Score" analytics, fed by Room aggregates.
 *
 * The last-24h SUCCESSFUL purchases drive top-offers / busiest+quietest hours /
 * best weekday; the SUCCESSFUL+FAILED rows in the same window are the success
 * rate's denominator. All the maths is the pure [MyScore] object — this just
 * maps rows into its inputs.
 */
@HiltViewModel
class MyScoreViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val score: StateFlow<MyScore.Score> =
        combine(
            transactionRepository.successfulSince(windowStart()),
            transactionRepository.settledSince(windowStart())
        ) { successful, settled ->
            val sales = successful.map { MyScore.Sale(it.offerName, it.createdAt) }
            val outcomes = settled.map {
                MyScore.Outcome(it.status == com.bingwascore.app.domain.TransactionStatus.SUCCESSFUL.value)
            }
            MyScore.compute(sales, outcomes)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), MyScore.EMPTY)

    private fun windowStart(): Long =
        System.currentTimeMillis() - WINDOW_MILLIS

    private companion object {
        const val WINDOW_MILLIS = 24L * 60 * 60 * 1000
    }
}
