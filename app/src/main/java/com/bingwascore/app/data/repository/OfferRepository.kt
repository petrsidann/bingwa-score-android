package com.bingwascore.app.data.repository

import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferRepository @Inject constructor(
    private val offerDao: OfferDao
) {
    fun getAllOffers(): Flow<List<Offer>> = offerDao.getAllOffers()
    
    fun getActiveOffers(): Flow<List<Offer>> = offerDao.getActiveOffers()
    
    suspend fun getOfferById(id: String): Offer? = offerDao.getOfferById(id)
    
    fun getOffersByType(type: OfferType): Flow<List<Offer>> = offerDao.getOffersByType(type)
    
    suspend fun insertOffer(offer: Offer) = offerDao.insertOffer(offer)
    
    suspend fun updateOffer(offer: Offer) = offerDao.updateOffer(offer)
    
    suspend fun deleteOffer(offer: Offer) = offerDao.deleteOffer(offer)
    
    suspend fun toggleOfferActive(id: String, isActive: Boolean) = 
        offerDao.toggleOfferActive(id, isActive)
}
