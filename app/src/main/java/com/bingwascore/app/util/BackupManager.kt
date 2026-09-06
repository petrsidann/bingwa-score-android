package com.bingwascore.app.util

import android.content.Context
import com.bingwascore.app.data.local.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

/**
 * Exports the full local dataset (transactions, offers, customers, auto-replies) to
 * a single JSON file under getExternalFilesDir("backups"), and restores it back -
 * clearing first, then re-inserting every row. Uses org.json (no new dependencies).
 */
class BackupManager {

    companion object {
        private const val FIELD_VERSION = "backupVersion"
        private const val FIELD_EXPORTED_AT = "exportedAt"
        private const val FIELD_TRANSACTIONS = "transactions"
        private const val FIELD_OFFERS = "offers"
        private const val FIELD_CUSTOMERS = "customers"
        private const val FIELD_AUTO_REPLIES = "autoReplies"

        /**
         * Writes the current dataset to a timestamped JSON file in the backups dir.
         * Returns the file written, or null on any failure.
         */
        suspend fun exportAll(context: Context): File? = withContext(Dispatchers.IO) {
            try {
                val db = AppDatabase.getDatabase(context)

                val root = JSONObject()
                root.put(FIELD_VERSION, 1)
                root.put(FIELD_EXPORTED_AT, System.currentTimeMillis())

                root.put(FIELD_TRANSACTIONS, db.transactionDao().getAllTransactions().first().toJsonArray { it.toJson() })
                root.put(FIELD_OFFERS, db.offerDao().getAllOffers().first().toJsonArray { it.toJson() })
                root.put(FIELD_CUSTOMERS, db.customerDao().getAllCustomers().first().toJsonArray { it.toJson() })
                root.put(FIELD_AUTO_REPLIES, db.autoReplyDao().getAllAutoReplies().first().toJsonArray { it.toJson() })

                val dir = context.getExternalFilesDir("backups") ?: context.filesDir
                if (!dir.exists()) dir.mkdirs()

                val file = File(dir, "bingwa_backup_${System.currentTimeMillis()}.json")
                file.writeText(root.toString(2))
                file
            } catch (t: Throwable) {
                null
            }
        }

        /**
         * Reads [file], clears every table, then re-inserts the contained rows.
         * Returns true on success, false on any failure.
         */
        suspend fun importAll(context: Context, file: File): Boolean = withContext(Dispatchers.IO) {
            try {
                if (!file.exists() || !file.canRead()) return@withContext false

                val root = JSONObject(file.readText())
                val db = AppDatabase.getDatabase(context)

                db.clearAllTables()

                root.optJsonArray(FIELD_TRANSACTIONS)?.let { array ->
                    for (i in 0 until array.length()) {
                        db.transactionDao().insert(transactionFromJson(array.getJSONObject(i)))
                    }
                }
                root.optJsonArray(FIELD_OFFERS)?.let { array ->
                    for (i in 0 until array.length()) {
                        db.offerDao().insert(offerFromJson(array.getJSONObject(i)))
                    }
                }
                root.optJsonArray(FIELD_CUSTOMERS)?.let { array ->
                    for (i in 0 until array.length()) {
                        db.customerDao().insert(customerFromJson(array.getJSONObject(i)))
                    }
                }
                root.optJsonArray(FIELD_AUTO_REPLIES)?.let { array ->
                    for (i in 0 until array.length()) {
                        db.autoReplyDao().insert(autoReplyFromJson(array.getJSONObject(i)))
                    }
                }

                true
            } catch (t: Throwable) {
                false
            }
        }
    }
}

private fun <T> List<T>.toJsonArray(transform: (T) -> JSONObject): JSONArray =
    JSONArray().also { arr -> forEach { arr.put(transform(it)) } }

private fun JSONObject.optJsonArray(key: String): JSONArray? =
    if (has(key) && !isNull(key)) optJSONArray(key) else null
