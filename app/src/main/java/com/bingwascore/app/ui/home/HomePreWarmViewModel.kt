package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Stage 11 — kills the sign-in → home blank frame.
 *
 * [HomeViewModel] opens with `liveTransactions.first()`, which pays the Room
 * first-query cost while Home is already on screen (a shimmer flash at best, a
 * blank frame at worst). This shell warms the exact same read at app start —
 * while the splash cinematic plays — so by the time the agent reaches Home the
 * database is open, the first snapshot is cached, and Home's own `init`
 * resolves near-instantly. It owns no state; it exists only to move the cost
 * off the hand-off frame.
 */
@HiltViewModel
class HomePreWarmViewModel @Inject constructor(
    transactionRepository: TransactionRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                transactionRepository.liveTransactions.first()
            } catch (t: Throwable) {
                // A failed pre-warm is not fatal: HomeViewModel still performs
                // the same read itself on entry.
                Timber.w(t, "Home pre-warm failed (non-fatal)")
            }
        }
    }
}