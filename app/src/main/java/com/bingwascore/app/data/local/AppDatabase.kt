package com.bingwascore.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * SHOWCASE S1 — which database file this process talks to.
 *
 * Showcase Mode runs on a completely separate database so a demo can never touch
 * real agent data, and switching the mode only requires a restart because the
 * flag is read **once**, here, before Room builds anything.
 *
 * Read order is guaranteed by [BingwaScoreApp.onCreate], which calls
 * [loadFrom] before any Hilt graph (and therefore any Room instance) exists.
 */
object DbNameHolder {

    const val REAL_DB = "bingwa_score.db"
    const val DEMO_DB = "bingwa_score_demo.db"

    /** Mirror of the persisted flag, read once at process start. */
    @Volatile
    var showcaseMode: Boolean = false
        private set

    /** The file name Room must use — never branch on [showcaseMode] anywhere else. */
    val dbName: String
        get() = if (showcaseMode) DEMO_DB else REAL_DB

    /**
     * Called exactly once from Application.onCreate, before Room is initialised.
     * Uses a dedicated SharedPreferences file so it is readable synchronously —
     * a DataStore read would be too late.
     */
    fun loadFrom(context: Context) {
        showcaseMode = prefs(context).getBoolean(KEY_SHOWCASE, false)
    }

    /** Persists the flag. The database itself is only swapped on the next launch. */
    fun persist(context: Context, enabled: Boolean) {
        prefs(context).edit().putBoolean(KEY_SHOWCASE, enabled).apply()
    }

    /** True on the very first ever launch, used to offer demo data up front. */
    fun isFirstEverLaunch(context: Context): Boolean =
        !prefs(context).contains(KEY_SEEN_FIRST_LAUNCH)

    fun markFirstLaunchSeen(context: Context) {
        prefs(context).edit().putBoolean(KEY_SEEN_FIRST_LAUNCH, true).apply()
    }

    /** Wipes only the demo database file so Showcase can reseed from scratch. */
    fun deleteDemoDatabase(context: Context) {
        context.deleteDatabase(DEMO_DB)
    }

    private fun prefs(context: Context) =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private const val PREFS_NAME = "bingwa_showcase"
    private const val KEY_SHOWCASE = "showcase_mode"
    private const val KEY_SEEN_FIRST_LAUNCH = "seen_first_launch"
}

@Database(
    entities = [
        Transaction::class, Offer::class, Customer::class, AutoReply::class,
        AgentCommission::class
    ],
    version = 6,
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

        /**
         * v5 → v6 (U1 — session truth). One column: `offers.ussdSteps`, the
         * comma-separated menu replies the engine sends when Safaricom answers
         * with a menu instead of a verdict. Empty default = choice "1".
         */
        private val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `offers` ADD COLUMN `ussdSteps` TEXT NOT NULL DEFAULT ''")
            }
        }

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DbNameHolder.dbName
                )
                    .addMigrations(
                        MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
