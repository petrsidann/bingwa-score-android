package com.bingwascore.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        Transaction::class, Offer::class, Customer::class, AutoReply::class,
        AgentCommission::class
    ],
    version = 5,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun offerDao(): OfferDao
    abstract fun customerDao(): CustomerDao
    abstract fun autoReplyDao(): AutoReplyDao
    abstract fun agentCommissionDao(): AgentCommissionDao

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

        /**
         * v2 → v3 (Parity C — Hybrid schema): add Hybrid columns without
         * deleting existing data. All columns are nullable or carry a
         * NOT NULL DEFAULT so old rows migrate cleanly:
         * - transactions: internalRetries, externalRetries (0),
         *   deletedAt + responseMessage (NULL).
         * - offers: tag + relayDevice (NULL).
         */
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE `transactions` " +
                        "ADD COLUMN `internalRetries` INTEGER NOT NULL DEFAULT 0"
                )
                db.execSQL(
                    "ALTER TABLE `transactions` " +
                        "ADD COLUMN `externalRetries` INTEGER NOT NULL DEFAULT 0"
                )
                db.execSQL("ALTER TABLE `transactions` ADD COLUMN `deletedAt` INTEGER")
                db.execSQL("ALTER TABLE `transactions` ADD COLUMN `responseMessage` TEXT")
                db.execSQL("ALTER TABLE `offers` ADD COLUMN `tag` TEXT")
                db.execSQL("ALTER TABLE `offers` ADD COLUMN `relayDevice` TEXT")
            }
        }

        /**
         * v3 → v4 (Parity F — silent batch dial + commission ledger). One
         * migration carries both schema changes:
         * - offers: silentBatch (INTEGER NOT NULL DEFAULT 0 → existing offers
         *   stay "advanced", so a batch dial always confirms first).
         * - agent_commissions: new ledger table (id autoincrement PK) plus the
         *   createdAt index Room expects.
         */
        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE `offers` " +
                        "ADD COLUMN `silentBatch` INTEGER NOT NULL DEFAULT 0"
                )
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `agent_commissions` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`txId` TEXT NOT NULL, " +
                        "`amount` REAL NOT NULL, " +
                        "`commission` REAL NOT NULL, " +
                        "`createdAt` INTEGER NOT NULL)"
                )
                db.execSQL(
                    "CREATE INDEX IF NOT EXISTS `index_agent_commissions_createdAt` " +
                        "ON `agent_commissions` (`createdAt`)"
                )
            }
        }

        /**
         * v4 → v5 (MEGA A — per-offer personality). Adds the four columns that let
         * each offer carry its own engine behaviour:
         * - `type` — AIRTIME/DATA/SMS/COMBO bucket (Agent Portal grouping).
         * - `ussdTimeoutSeconds` — per-offer watchdog timeout in seconds.
         * - `autoRetryConnectionProblems` — retry even when autoRetry is off.
         * - `isDirty` — locally edited, not yet synced (PART B gate).
         *
         * Every column is NOT NULL with a default so existing rows migrate in
         * place with no data loss and no destructive fallback.
         */
        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE `offers` ADD COLUMN `type` TEXT NOT NULL DEFAULT 'DATA'"
                )
                db.execSQL(
                    "ALTER TABLE `offers` ADD COLUMN `ussdTimeoutSeconds` INTEGER NOT NULL DEFAULT 20"
                )
                db.execSQL(
                    "ALTER TABLE `offers` ADD COLUMN `autoRetryConnectionProblems` INTEGER NOT NULL DEFAULT 0"
                )
                db.execSQL(
                    "ALTER TABLE `offers` ADD COLUMN `isDirty` INTEGER NOT NULL DEFAULT 0"
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
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5)
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
    }
}