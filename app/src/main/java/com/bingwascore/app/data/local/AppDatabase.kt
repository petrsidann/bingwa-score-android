package com.bingwascore.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bingwascore.app.domain.model.Customer
import com.bingwascore.app.domain.model.Offer
import com.bingwascore.app.domain.model.OfferTransitionRule
import com.bingwascore.app.domain.model.Transaction

@Database(
    entities = [
        Transaction::class,
        Offer::class,
        Customer::class,
        OfferTransitionRule::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun offerDao(): OfferDao
    abstract fun customerDao(): CustomerDao
    abstract fun offerTransitionRuleDao(): OfferTransitionRuleDao

    companion object {
        const val DATABASE_NAME = "bingwa_score_db"
    }
}
