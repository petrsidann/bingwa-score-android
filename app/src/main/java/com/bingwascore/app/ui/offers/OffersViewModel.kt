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
    
    private val _filter = MutableStateFlow("all")
    val filter: StateFlow<String> = _filter.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllOffers().collect {
                _offers.value = it
            }
        }
    }
    
    fun setFilter(id: String) {
        _filter.value = id
    }

    fun toggleActive(offer: Offer) {
        viewModelScope.launch {
            repository.updateOffer(offer.copy(isActive = !offer.isActive))
        }
    }
    
    fun saveOffer(offer: Offer) {
        viewModelScope.launch {
            repository.saveOffer(offer)
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
}
