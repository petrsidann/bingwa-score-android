package com.bingwascore.app.ui.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.preferences.OfferTransitionRule
import com.bingwascore.app.data.preferences.OfferTransitionStore
import com.bingwascore.app.data.repository.OfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val offerRepository: OfferRepository,
    private val transitionStore: OfferTransitionStore
) : ViewModel() {

    val offers: StateFlow<List<Offer>> =
        offerRepository.allOffers.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

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

    /** Persists everything edited in the OfferSettings sheet. */
    fun saveSettings(
        offer: Offer,
        strictMode: Boolean,
        autoRetry: Boolean,
        numberOfRetries: Int,
        retryIntervalMins: Int,
        ussdTimeoutMillis: Long,
        autoReschedule: Boolean,
        autoRescheduleRunTime: String,
        completionMessage: String?
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
                completionMessage = completionMessage
            )
        )
    }

    fun saveTransitionRule(rule: OfferTransitionRule) {
        viewModelScope.launch { transitionStore.save(rule) }
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
