package com.bingwascore.app.ui.dialer

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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

@HiltViewModel
class DialerViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val transactionRepository: TransactionRepository,
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

    fun setPhone(value: String) {
        _phone.value = value.filter { it.isDigit() }.take(12)
        _feedback.value = null
    }

    fun selectOffer(offer: Offer) {
        _selectedOfferId.value = offer.id
        _feedback.value = null
    }

    /** Resolves the dial code, records a PENDING transaction and fires the USSD service. */
    fun dialNow() {
        val offer = offers.value.firstOrNull { it.id == _selectedOfferId.value }
            ?: offers.value.firstOrNull()
        val phoneValue = _phone.value.trim()

        if (phoneValue.length < MIN_PHONE_LENGTH) {
            _feedback.value = DialerFeedback("Enter a valid customer phone number", isError = true)
            return
        }
        if (offer == null) {
            _feedback.value = DialerFeedback("No active offer to dial", isError = true)
            return
        }

        val dialCode = offer.ussdCode.replace("ph", phoneValue).replace("BH", phoneValue, true)
        val transactionId = "tx_${UUID.randomUUID()}"

        viewModelScope.launch {
            try {
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
                        status = TransactionStatus.PENDING.value,
                        createdAt = System.currentTimeMillis()
                    )
                )

                val intent = Intent(context, UssdAutomationService::class.java).apply {
                    putExtra(UssdAutomationService.EXTRA_USSD_CODE, dialCode)
                    putExtra(UssdAutomationService.EXTRA_TRANSACTION_ID, transactionId)
                    putExtra(UssdAutomationService.EXTRA_CUSTOMER_PHONE, phoneValue)
                }
                try {
                    context.startService(intent)
                } catch (t: Throwable) {
                    Timber.e(t, "Failed to start UssdAutomationService")
                    _feedback.value = DialerFeedback("Could not start the dialer service", isError = true)
                    return@launch
                }

                _feedback.value =
                    DialerFeedback("Dialing ${offer.name} for $phoneValue — watch for the USSD reply", isError = false)
            } catch (t: Throwable) {
                Timber.e(t, "Dial failed")
                _feedback.value = DialerFeedback("Dial failed: ${t.message}", isError = true)
            }
        }
    }

    private companion object {
        const val MIN_PHONE_LENGTH = 9
    }
}
