package com.bingwascore.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bingwascore.app.domain.model.OfferTransitionRule

@Dao
interface OfferTransitionRuleDao {

    @Query("SELECT * FROM offer_transition_rules WHERE sourceOfferId = :offerId AND sourceStatus = :status ORDER BY priority ASC")
    suspend fun getRulesFor(offerId: String, status: String): List<OfferTransitionRule>

    @Query("SELECT * FROM offer_transition_rules WHERE sourceOfferId = :offerId ORDER BY priority ASC")
    suspend fun getRulesForOffer(offerId: String): List<OfferTransitionRule>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRule(rule: OfferTransitionRule)

    @Query("DELETE FROM offer_transition_rules WHERE id = :id")
    suspend fun deleteRule(id: String)
}
