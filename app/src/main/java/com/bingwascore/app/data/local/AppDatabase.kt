package com.bingwascore.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Transaction::class, Offer::class, Customer::class, AutoReply::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun offerDao(): OfferDao
    abstract fun customerDao(): CustomerDao
    abstract fun autoReplyDao(): AutoReplyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * v1 → v2: add the query-supporting indices declared on the entities.
         * Non-destructive — existing user data is preserved.
         */
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_transactions_status_createdAt` " +
                        "ON `transactions` (`status`, `createdAt`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_transactions_status_scheduledAt` " +
                        "ON `transactions` (`status`, `scheduledAt`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_transactions_phoneNumber` " +
                        "ON `transactions` (`phoneNumber`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_transactions_createdAt` " +
                        "ON `transactions` (`createdAt`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_offers_isActive` ON `offers` (`isActive`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_customers_isBlacklisted` " +
                        "ON `customers` (`isBlacklisted`)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_auto_replies_type` ON `auto_replies` (`type`)"
                )
            }
        }

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bingwa_score.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
    }
}