package com.bingwascore.app.ui.offers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.preferences.OfferTransitionRule
import com.bingwascore.app.data.preferences.OfferTransitionStore
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import com.bingwascore.app.domain.BatchDialPlanner
import com.bingwascore.app.domain.BatchDialTarget
import com.bingwascore.app.domain.DuplicateOfferTransitionRuleException
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdAutomationService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val offerRepository: OfferRepository,
    private val transactionRepository: TransactionRepository,
    private val userPreferences: UserPreferences,
    private val transitionStore: OfferTransitionStore
) : ViewModel() {

    val offers: StateFlow<List<Offer>> =
        offerRepository.allOffers.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    // Parity E — offer cards shimmer (skeleton) until the first Room emission.
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Parity F — silent batch dial state.
    private val _isBatching = MutableStateFlow(false)
    val isBatching: StateFlow<Boolean> = _isBatching.asStateFlow()

    /** Parity F — last dialled customer, prefilled into the batch dial bar. */
    val lastDialPhone: StateFlow<String> =
        userPreferences.lastDialPhone.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), ""
        )

    /** Parity F — red error text shown inside the offer actions sheet. */
    private val _ruleError = MutableStateFlow<String?>(null)
    val ruleError: StateFlow<String?> = _ruleError.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                offerRepository.allOffers.first()
            } catch (t: Throwable) {
                Timber.e(t, "Initial offer load failed")
            }
            _isLoading.value = false
        }
    }

    val transitionRules: StateFlow<List<OfferTransitionRule>> =
        transitionStore.rules.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    /** Creates a new active offer from the add-offer sheet. */
    fun addOffer(name: String, price: Int, ussdCode: String) {
        viewModelScope.launch {
            try {
                offerRepository.insert(
                    Offer(
                        id = "offer_${UUID.randomUUID()}",
                        name = name.trim(),
                        ussdCode = ussdCode.trim(),
                        price = price,
                        isActive = true
                    )
                )
            } catch (t: Throwable) {
                Timber.e(t, "Failed to add offer")
            }
        }
    }

    /** Flips the offer's active flag (the card Switch). */
    fun toggleActive(offer: Offer) {
        update(offer.copy(isActive = !offer.isActive))
    }

    /** Persists everything edited in the OfferSettings sheet (Parity D: + tag/relay). */
    fun saveSettings(
        offer: Offer,
        strictMode: Boolean,
        autoRetry: Boolean,
        numberOfRetries: Int,
        retryIntervalMins: Int,
        ussdTimeoutMillis: Long,
        autoReschedule: Boolean,
        autoRescheduleRunTime: String,
        completionMessage: String?,
        tag: String? = offer.tag,
        relayDevice: String? = offer.relayDevice,
        silentBatch: Boolean = offer.silentBatch
    ) {
        update(
            offer.copy(
                strictMode = strictMode,
                autoRetry = autoRetry,
                numberOfRetries = numberOfRetries,
                retryIntervalMins = retryIntervalMins,
                ussdTimeoutMillis = ussdTimeoutMillis,
                autoReschedule = autoReschedule,
                autoRescheduleRunTime = autoRescheduleRunTime,
                completionMessage = completionMessage,
                tag = tag,
                relayDevice = relayDevice,
                silentBatch = silentBatch
            )
        )
    }

    /**
     * Parity F — a rule for the same (fromStatus, toOfferId) pair already exists:
     * reject it with [DuplicateOfferTransitionRuleException] and surface red error
     * text in the sheet instead of silently overwriting the saved rule.
     */
    fun saveTransitionRule(rule: OfferTransitionRule) {
        viewModelScope.launch {
            try {
                val existing = transitionStore.rules.first()
                if (existing.any {
                        it.fromStatus == rule.fromStatus && it.toOfferId == rule.toOfferId
                    }
                ) {
                    throw DuplicateOfferTransitionRuleException(rule.fromStatus, rule.toOfferId)
                }
                transitionStore.save(rule)
                _ruleError.value = null
            } catch (e: DuplicateOfferTransitionRuleException) {
                _ruleError.value =
                    "That rule already exists — pick another status or offer"
                Timber.w(e, "Duplicate offer transition rule rejected")
            } catch (t: Throwable) {
                Timber.e(t, "Failed to save offer transition rule")
                _ruleError.value = "Could not save the rule — try again"
            }
        }
    }

    /** Clears the red error text in the sheet (fired when the selection changes). */
    fun clearRuleError() {
        _ruleError.value = null
    }

    /**
     * Parity F — silent batch dial.
     *
     * [BatchDialPlanner] normalises [phoneRaw], expands every USSD code and can
     * only make silent offers reach the queue without a confirmation (the screen
     * shows that single dialog before calling us). Each dial writes a PENDING
     * transaction and starts [UssdAutomationService] with a
     * [BatchDialPlanner.GAP_MILLIS] gap so consecutive USSD sessions never
     * overlap. The outcome is announced with a toast.
     */
    fun batchDial(offers: List<Offer>, phoneRaw: String) {
        if (_isBatching.value) return
        val plan = BatchDialPlanner.plan(offers, phoneRaw)
        if (plan.isEmpty()) {
            toast("Enter a valid customer phone number")
            return
        }
        viewModelScope.launch {
            _isBatching.value = true
            var queued = 0
            try {
                userPreferences.setLastDialPhone(plan.first().phoneNumber)
                plan.forEachIndexed { index, target ->
                    if (dialSilently(target)) queued++
                    if (index != plan.lastIndex) delay(BatchDialPlanner.GAP_MILLIS)
                }
            } catch (t: Throwable) {
                Timber.e(t, "Silent batch dial stopped after %d queued", queued)
            } finally {
                _isBatching.value = false
            }
            Timber.i("Silent batch dial queued %d of %d", queued, plan.size)
            toast(BatchDialPlanner.queuedMessage(queued))
        }
    }

    /** One queued dial: PENDING transaction + USSD service. Never throws. */
    private suspend fun dialSilently(target: BatchDialTarget): Boolean = try {
        val transactionId = "tx_${UUID.randomUUID()}"
        transactionRepository.insert(
            Transaction(
                id = transactionId,
                phoneNumber = target.phoneNumber,
                customerName = null,
                offerId = target.offerId,
                offerName = target.offerName,
                ussdCode = target.ussdCode,
                amount = target.price.toDouble(),
                commission = target.price * 0.1,
                status = TransactionStatus.PENDING.value,
                createdAt = System.currentTimeMillis()
            )
        )
        context.startService(
            Intent(context, UssdAutomationService::class.java)
                .putExtra(UssdAutomationService.EXTRA_USSD_CODE, target.ussdCode)
                .putExtra(UssdAutomationService.EXTRA_TRANSACTION_ID, transactionId)
                .putExtra(UssdAutomationService.EXTRA_CUSTOMER_PHONE, target.phoneNumber)
        )
        true
    } catch (t: Throwable) {
        Timber.e(t, "Silent dial failed for offer %s", target.offerId)
        false
    }

    private fun toast(message: String) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        } catch (t: Throwable) {
            Timber.e(t, "Could not show toast: %s", message)
        }
    }

    fun deleteTransitionRule(rule: OfferTransitionRule) {
        viewModelScope.launch { transitionStore.delete(rule) }
    }

    private fun update(offer: Offer) {
        viewModelScope.launch {
            try {
                offerRepository.update(offer)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to update offer %s", offer.id)
            }
        }
    }
}
