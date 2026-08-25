package com.bingwascore.app.ui.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.domain.model.Offer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val offerRepository: OfferRepository
) : ViewModel() {

    private val _filter = MutableStateFlow("all")
    val filter: StateFlow<String> = _filter.asStateFlow()

    val offers: StateFlow<List<Offer>> = offerRepository.getAllOffers()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun setFilter(f: String) {
        _filter.value = f
    }

    fun toggleActive(offer: Offer) {
        viewModelScope.launch {
            offerRepository.toggleOfferActive(offer.id, !offer.isActive)
        }
    }

    fun saveOffer(offer: Offer) {
        viewModelScope.launch {
            if (offerRepository.getOfferById(offer.id) == null) {
                offerRepository.insertOffer(offer)
            } else {
                offerRepository.updateOffer(offer)
            }
        }
    }
}
