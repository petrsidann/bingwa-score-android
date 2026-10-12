package com.bingwascore.app.ui.autorenewals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.SelfRenewalSchedule
import com.bingwascore.app.workers.SelfRenewalWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Stage 15 — Self-Renewal. An agent schedules offer + phone + datetime; the app
 * stores a SCHEDULED ledger row and arms a WorkManager alarm for that instant.
 * The list is every SCHEDULED row (countdown chips); once one fires and the dial
 * completes it becomes SUCCESSFUL and drops out (it lives in Completed tx).
 */
@HiltViewModel
class SelfRenewalViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val offerRepository: OfferRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    /** Active offers the agent can renew. */
    val offers: StateFlow<List<Offer>> = offerRepository.activeOffers
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /** The renewal queue: SCHEDULED rows, soonest first. */
    val scheduled: StateFlow<List<Transaction>> =
        transactionRepository.transactionsByStatus(com.bingwascore.app.domain.TransactionStatus.SCHEDULED.value)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _saved = MutableStateFlow(false)
    val saved: StateFlow<Boolean> = _saved.asStateFlow()

    /**
     * Validates [draft], stores the SCHEDULED row and arms the exact alarm.
     * Returns false (and sets [error]) when the draft is not schedulable.
     */
    fun schedule(draft: SelfRenewalSchedule.Draft) {
        val now = System.currentTimeMillis()
        val problem = SelfRenewalSchedule.validate(draft, now)
        if (problem != null) {
            _error.value = problem
            return
        }
        _error.value = null
        viewModelScope.launch {
            try {
                val tx = SelfRenewalSchedule.toScheduledTx(draft, now)
                transactionRepository.insert(tx)
                val delayMinutes = SelfRenewalSchedule.delayMillis(draft.fireAt, now) / 60_000L
                SelfRenewalWorker.arm(context, tx.id, delayMinutes)
                _saved.value = true
            } catch (t: Throwable) {
                Timber.e(t, "Failed to schedule a self-renewal")
                _error.value = "Could not schedule — try again"
            }
        }
    }

    /** Cancels a scheduled renewal and removes its ledger row. */
    fun cancel(transaction: Transaction) {
        viewModelScope.launch {
            try {
                SelfRenewalWorker.cancel(context, transaction.id)
                transactionRepository.deleteById(transaction.id)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to cancel self-renewal %s", transaction.id)
            }
        }
    }

    fun consumeSaved() {
        _saved.value = false
    }

    fun clearError() {
        _error.value = null
    }
}
