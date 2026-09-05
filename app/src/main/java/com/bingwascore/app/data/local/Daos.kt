package com.bingwascore.app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions ORDER BY createdAt DESC")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE status = :status ORDER BY createdAt DESC")
    fun getTransactionsByStatus(status: String): Flow<List<Transaction>>

    @Query(
        "SELECT * FROM transactions WHERE status = 'SCHEDULED' " +
            "AND scheduledAt IS NOT NULL AND scheduledAt <= :time ORDER BY scheduledAt ASC"
    )
    fun getDueScheduled(time: Long): Flow<List<Transaction>>

    @Query(
        "SELECT * FROM transactions WHERE status = 'SCHEDULED' " +
            "AND scheduledAt IS NOT NULL AND scheduledAt <= :time ORDER BY scheduledAt ASC"
    )
    suspend fun getDueScheduledList(time: Long): List<Transaction>

    @Query(
        "SELECT * FROM transactions WHERE phoneNumber = :phone AND amount = :amount " +
            "AND status = 'SUCCESSFUL' AND createdAt >= :since ORDER BY createdAt DESC"
    )
    fun getRecentSuccessful(phone: String, amount: Double, since: Long): Flow<List<Transaction>>

    @Query(
        "SELECT * FROM transactions WHERE phoneNumber = :phone AND amount = :amount " +
            "AND status = 'SUCCESSFUL' AND createdAt >= :since ORDER BY createdAt DESC"
    )
    suspend fun getRecentSuccessfulList(phone: String, amount: Double, since: Long): List<Transaction>

    @Query("SELECT * FROM transactions WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): Transaction?

    @Query("SELECT * FROM transactions WHERE id = :id LIMIT 1")
    fun getByIdFlow(id: String): Flow<Transaction?>

    @Query("SELECT COUNT(*) FROM transactions")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteById(id: String)

    @Query("SELECT * FROM transactions WHERE createdAt < :before ORDER BY createdAt ASC")
    suspend fun getOlderThan(before: Long): List<Transaction>

    @Query("DELETE FROM transactions WHERE createdAt < :before")
    suspend fun deleteOlderThan(before: Long)
}

@Dao
interface OfferDao {

    @Query("SELECT * FROM offers ORDER BY price ASC")
    fun getAllOffers(): Flow<List<Offer>>

    @Query("SELECT * FROM offers WHERE isActive = 1 ORDER BY price ASC")
    fun getActiveOffers(): Flow<List<Offer>>

    @Query("SELECT * FROM offers WHERE price = :price AND isActive = 1 LIMIT 1")
    fun getOfferByPrice(price: Int): Flow<Offer?>

    @Query("SELECT * FROM offers WHERE price = :price AND isActive = 1 LIMIT 1")
    suspend fun getOfferByPriceOnce(price: Int): Offer?

    @Query("SELECT * FROM offers WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): Offer?

    @Query("SELECT COUNT(*) FROM offers")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: Offer)

    @Update
    suspend fun update(offer: Offer)

    @Delete
    suspend fun delete(offer: Offer)

    @Query("DELETE FROM offers WHERE id = :id")
    suspend fun deleteById(id: String)
}

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customers ORDER BY createdAt DESC")
    fun getAllCustomers(): Flow<List<Customer>>

    @Query("SELECT * FROM customers WHERE phoneNumber = :phone LIMIT 1")
    fun getCustomerByPhone(phone: String): Flow<Customer?>

    @Query("SELECT * FROM customers WHERE phoneNumber = :phone LIMIT 1")
    suspend fun getByPhoneOnce(phone: String): Customer?

    @Query("SELECT * FROM customers WHERE isBlacklisted = 1 ORDER BY createdAt DESC")
    fun getBlacklisted(): Flow<List<Customer>>

    @Query("SELECT COUNT(*) FROM customers")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customer: Customer)

    @Update
    suspend fun update(customer: Customer)

    @Delete
    suspend fun delete(customer: Customer)
}

@Dao
interface AutoReplyDao {

    @Query("SELECT * FROM auto_replies ORDER BY id ASC")
    fun getAllAutoReplies(): Flow<List<AutoReply>>

    @Query("SELECT * FROM auto_replies WHERE type = :type ORDER BY id ASC")
    fun getByType(type: String): Flow<List<AutoReply>>

    @Query("SELECT * FROM auto_replies WHERE isActive = 1")
    suspend fun getActive(): List<AutoReply>

    @Query("SELECT COUNT(*) FROM auto_replies")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(autoReply: AutoReply): Long

    @Update
    suspend fun update(autoReply: AutoReply)

    @Delete
    suspend fun delete(autoReply: AutoReply)

    @Query("UPDATE auto_replies SET isActive = :active WHERE id = :id")
    suspend fun setActive(id: Int, active: Boolean)
}