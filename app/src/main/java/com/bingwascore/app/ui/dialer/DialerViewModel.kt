package com.bingwascore.app.ui.dialer

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.BatchDialPlanner
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.services.UssdAutomationService
import com.bingwascore.app.util.formatPhoneToTenDigits
import com.bingwascore.app.util.isTenDigitPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

/** One line of user-facing dialer feedback. */
data class DialerFeedback(val message: String, val isError: Boolean)

/**
 * POLISH P1 — the outcome of a dial, with the operator's own words.
 *
 * [message] is the **exact** Safaricom reply the modem returned (persisted by
 * [com.bingwascore.app.services.UssdAutomationService] onto the transaction), so
 * the dialog never paraphrases a carrier message the agent may need to quote back
 * to a customer or to Safaricom support.
 */
data class DialResult(
    val transactionId: String,
    val successful: Boolean,
    val response: String?
)

@HiltViewModel
class DialerViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences,
    offerRepository: OfferRepository
) : ViewModel() {

    val offers: StateFlow<List<Offer>> =
        offerRepository.activeOffers.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    private val _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone.asStateFlow()

    private val _selectedOfferId = MutableStateFlow<String?>(null)
    val selectedOfferId: StateFlow<String?> = _selectedOfferId.asStateFlow()

    private val _feedback = MutableStateFlow<DialerFeedback?>(null)
    val feedback: StateFlow<DialerFeedback?> = _feedback.asStateFlow()

    // Parity E — drives the "Dialing…" spinner on the gradient CTA.
    private val _isDialing = MutableStateFlow(false)

    // R5 — non-empty when the dial is blocked on a runtime permission; the
    // screen turns this into a redirect straight to the system prompt.
    private val _missingPermissions = MutableStateFlow<List<String>>(emptyList())
    val isDialing: StateFlow<Boolean> = _isDialing.asStateFlow()

    val missingPermissions: StateFlow<List<String>> = _missingPermissions.asStateFlow()

    // POLISH P1 — the dial result dialog. Held in the ViewModel so it survives
    // the sheet being rebuilt, and dismissed by exactly one call.
    private val _result = MutableStateFlow<DialResult?>(null)
    val result: StateFlow<DialResult?> = _result.asStateFlow()

    /** Acknowledges the result dialog. */
    fun consumeResult() {
        _result.value = null
    }

    /**
     * POLISH P1 — waits for the engine to close [transactionId] and reports the
     * verdict plus the exact carrier wording.
     *
     * Polls (rather than holding a Flow) because the row is written by a
     * *service*, which may be a different process lifetime; the poll is bounded,
     * and a dial that never resolves simply leaves the transaction in flight
     * instead of lying to the agent with a fabricated result.
     */
    private suspend fun awaitDialResult(transactionId: String) {
        repeat(DIAL_RESULT_POLLS) {
            val tx = transactionRepository.getLiveTransaction(transactionId) ?: return
            when (tx.status) {
                TransactionStatus.SUCCESSFUL.value -> {
                    _result.value = DialResult(transactionId, true, tx.responseMessage)
                    return
                }
                TransactionStatus.FAILED.value,
                TransactionStatus.FAILED_ALREADY_RECOMMENDED.value,
                TransactionStatus.UNMATCHED.value,
                TransactionStatus.CANCELLED.value -> {
                    _result.value = DialResult(
                        transactionId = transactionId,
                        successful = false,
                        response = tx.responseMessage?.takeIf { it.isNotBlank() } ?: tx.errorMessage
                    )
                    return
                }
            }
            delay(DIAL_RESULT_POLL_MILLIS)
        }
    }

    fun setPhone(value: String) {
        _phone.value = value.filter { it.isDigit() }.take(12)
        _feedback.value = null
    }

    /**
     * Parity E — on blur, collapse `+254 712…`, `254712…` and `712…` into the
     * canonical ten-digit `0712…` form so the USSD code expands correctly.
     */
    fun formatPhone() {
        val formatted = formatPhoneToTenDigits(_phone.value)
        if (formatted != _phone.value) _phone.value = formatted
    }

    fun selectOffer(offer: Offer) {
        _selectedOfferId.value = offer.id
        _feedback.value = null
    }

    /** Resolves the dial code, records a PROCESSING transaction and fires the USSD service. */
    fun dialNow() {
        if (_isDialing.value) return
        val offer = offers.value.firstOrNull { it.id == _selectedOfferId.value }
            ?: offers.value.firstOrNull()
        val phoneValue = formatPhoneToTenDigits(_phone.value)

        if (!isTenDigitPhone(phoneValue)) {
            _feedback.value = DialerFeedback("Enter a valid customer phone number", isError = true)
            return
        }
        if (offer == null) {
            _feedback.value = DialerFeedback("No active offer to dial", isError = true)
            return
        }

        // REBRAND R5 — check the two runtime permissions before anything is
        // written. Without them sendUssdRequest throws SecurityException deep
        // inside a service the agent cannot see, which is why "dial never fires".
        val missing = missingDialPermissions()
        if (missing.isNotEmpty()) {
            _feedback.value = DialerFeedback(
                "Grant ${missing.joinToString(" and ")} to dial",
                isError = true
            )
            _missingPermissions.value = missing
            return
        }

        val dialCode = BatchDialPlanner.expand(offer.ussdCode, phoneValue)
        val transactionId = "tx_${UUID.randomUUID()}"

        viewModelScope.launch {
            _isDialing.value = true
            try {
                // R5 — the row flips to PROCESSING as it is written, so the list
                // shows work in flight the instant the dial is accepted.
                transactionRepository.insert(
                    Transaction(
                        id = transactionId,
                        phoneNumber = phoneValue,
                        customerName = null,
                        offerId = offer.id,
                        offerName = offer.name,
                        ussdCode = dialCode,
                        amount = offer.price.toDouble(),
                        commission = offer.price * 0.1,
                        status = TransactionStatus.PROCESSING.value,
                        createdAt = System.currentTimeMillis()
                    )
                )

                val intent = Intent(context, UssdAutomationService::class.java).apply {
                    putExtra(UssdAutomationService.EXTRA_USSD_CODE, dialCode)
                    putExtra(UssdAutomationService.EXTRA_TRANSACTION_ID, transactionId)
                    putExtra(UssdAutomationService.EXTRA_CUSTOMER_PHONE, phoneValue)
                }
                try {
                    // R5 — startForegroundService, not startService: a plain start
                    // is refused once the app leaves the foreground.
                    androidx.core.content.ContextCompat.startForegroundService(context, intent)
                    Timber.tag(USSD_TAG).i(
                        "USSD: dial fired %s for %s (tx %s)",
                        dialCode,
                        phoneValue,
                        transactionId
                    )
                } catch (t: Throwable) {
                    Timber.e(t, "USSD: failed to start UssdAutomationService")
                    _feedback.value = DialerFeedback("Could not start the dialer service", isError = true)
                    transactionRepository.softDelete(transactionId)
                    return@launch
                }

                _phone.value = phoneValue
                // Parity F — remember the target so the silent batch dial can prefill it.
                try {
                    userPreferences.setLastDialPhone(phoneValue)
                } catch (t: Throwable) {
                    Timber.e(t, "Could not persist the last dialled phone")
                }
                _feedback.value = DialerFeedback("Dialing $dialCode", isError = false)
                // POLISH P1 — the dial is not finished when the service starts;
                // it is finished when the operator answers. Report the real
                // verdict, with the exact Safaricom wording, once it lands.
                awaitDialResult(transactionId)
            } catch (t: Throwable) {
                Timber.e(t, "Dial failed")
                _feedback.value = DialerFeedback("Dial failed: ${t.message}", isError = true)
            } finally {
                _isDialing.value = false
            }
        }
    }

    /**
     * R5 — the permissions the dial path genuinely needs. Exposed so the screen
     * can send the agent straight to the system prompt instead of failing later.
     */
    fun missingDialPermissions(): List<String> = REQUIRED_DIAL_PERMISSIONS.filter {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }

    companion object {
        /** Every USSD log line uses this tag: `adb logcat -s USSD`. */
        const val USSD_TAG = "USSD"

        private val REQUIRED_DIAL_PERMISSIONS = arrayOf(
            android.Manifest.permission.CALL_PHONE,
            android.Manifest.permission.READ_PHONE_STATE
        )

        /** POLISH P1 — how long the dialer waits for the operator's verdict. */
        private const val DIAL_RESULT_POLL_MILLIS = 700L
        private const val DIAL_RESULT_POLLS = 86 // ~60s, comfortably past any offer timeout
    }
}
