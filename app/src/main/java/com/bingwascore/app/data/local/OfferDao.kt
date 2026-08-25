package com.bingwascore.app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferType
import kotlinx.coroutines.flow.Flow

@Dao
interface OfferDao {

    @Query("SELECT * FROM offers ORDER BY name ASC")
    fun getAllOffers(): Flow<List<Offer>>

    @Query("SELECT * FROM offers WHERE isActive = 1 ORDER BY name ASC")
    fun getActiveOffers(): Flow<List<Offer>>

    @Query("SELECT * FROM offers WHERE id = :id")
    suspend fun getOfferById(id: String): Offer?

    @Query("SELECT * FROM offers WHERE price = :price AND isActive = 1 LIMIT 1")
    suspend fun getOfferByPrice(price: Int): Offer?

    @Query("SELECT * FROM offers WHERE type = :type ORDER BY name ASC")
    fun getOffersByType(type: OfferType): Flow<List<Offer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(offer: Offer)

    @Update
    suspend fun updateOffer(offer: Offer)

    @Delete
    suspend fun deleteOffer(offer: Offer)

    @Query("UPDATE offers SET isActive = :isActive, updatedAt = :time WHERE id = :id")
    suspend fun toggleOfferActive(id: String, isActive: Boolean, time: Long = System.currentTimeMillis())
}
