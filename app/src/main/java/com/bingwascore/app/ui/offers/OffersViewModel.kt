package com.bingwascore.app.ui.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.domain.model.Offer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val repository: OfferRepository
) : ViewModel() {

    private val _offers = MutableStateFlow<List<Offer>>(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllOffers().collect {
                _offers.value = it
            }
        }
    }

    fun toggleOfferActive(offer: Offer) {
        viewModelScope.launch {
            repository.updateOffer(offer.copy(isActive = !offer.isActive))
        }
    }
    
    fun deleteOffer(offer: Offer) {
        viewModelScope.launch {
            repository.deleteOffer(offer)
        }
    }
    
    fun saveOffer(offer: Offer) {
        viewModelScope.launch {
            repository.insertOffer(offer)
        }
    }
}
