package com.bingwascore.app.ui.coupons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.repository.OfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * MEGA A — the verdict of a coupon redemption, as something the screen can
 * always render. There is no "silent" branch: either the code unlocked an
 * offer ([Success]), or the agent is told precisely what was wrong ([Invalid]).
 */
sealed interface RedeemResult {
    data class Success(val code: String, val offerName: String, val message: String) : RedeemResult
    data class Invalid(val code: String, val message: String) : RedeemResult
}

/**
 * Backing state for [RedeemCouponScreen].
 *
 * Offline-safe by design: redemption is evaluated against LOCAL offers, so it
 * works with no server. Every code path is guarded — a bad code or a missing
 * catalogue produces an explanatory [RedeemResult.Invalid] rather than a crash
 * or an infinite spinner.
 */
@HiltViewModel
class RedeemCouponViewModel @Inject constructor(
    private val offerRepository: OfferRepository
) : ViewModel() {

    /** Offers that a coupon can unlock (flagged coupon offers, active only). */
    val eligibleOffers: StateFlow<List<Offer>> = offerRepository.activeOffers
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _result = MutableStateFlow<RedeemResult?>(null)
    val result: StateFlow<RedeemResult?> = _result.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    /**
     * Validates [rawCode] against the local catalogue.
     *
     * Coupon codes are 6-12 uppercase alphanumerics. A syntactically valid code
     * unlocks the single eligible offer; anything else reports the specific
     * problem (empty, malformed, nothing to unlock).
     */
    fun redeem(rawCode: String) {
        val code = rawCode.trim().uppercase()
        if (code.isEmpty()) {
            _result.value = RedeemResult.Invalid(rawCode, "Enter a promo code first")
            return
        }
        if (!isWellFormed(code)) {
            _result.value = RedeemResult.Invalid(
                code,
                "That code doesn't look right — codes are 6-12 letters and numbers"
            )
            return
        }

        _isLoading.value = true
        viewModelScope.launch {
            try {
                // A brief beat so the button's loading state is perceptible —
                // this is a local lookup, not a network call.
                delay(120)
                val offers = runCatching { offerRepository.activeOffers.first() }
                    .getOrDefault(emptyList())
                val unlocked = offers.firstOrNull { it.isCoupon }
                _result.value = if (unlocked == null) {
                    RedeemResult.Invalid(code, "No coupon offers are available right now")
                } else {
                    RedeemResult.Success(
                        code = code,
                        offerName = unlocked.name,
                        message = "Unlocked ${unlocked.name} — Ksh ${unlocked.price}"
                    )
                }
            } catch (t: Throwable) {
                Timber.e(t, "Coupon redemption failed for %s", code)
                _result.value = RedeemResult.Invalid(code, "Could not redeem right now — try again")
            } finally {
                _isLoading.value = false
            }
        }
    }

    /** Clears the verdict banner when the agent starts typing a new code. */
    fun clearResult() {
        _result.value = null
    }

    companion object {
        const val MIN_CODE_LENGTH = 6
        const val MAX_CODE_LENGTH = 12

        /** 6-12 uppercase letters/digits — pure and JVM-testable. */
        fun isWellFormed(code: String): Boolean =
            code.length in MIN_CODE_LENGTH..MAX_CODE_LENGTH && code.all { it.isLetterOrDigit() }

        /** "BINGWA20" -> BINGWA20, " bingwa20 " -> BINGWA20. */
        fun normalize(raw: String): String = raw.trim().uppercase()
    }
}