package com.bingwascore.app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions ORDER BY createdAt DESC")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE status = :status ORDER BY createdAt DESC")
    fun getTransactionsByStatus(status: TransactionStatus): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: String): Transaction?

    @Query("SELECT * FROM transactions WHERE status = :status ORDER BY createdAt DESC LIMIT 1")
    suspend fun getLatestByStatus(status: TransactionStatus): Transaction?

    @Query("SELECT * FROM transactions WHERE status = 'SCHEDULED' AND scheduledAt <= :time ORDER BY scheduledAt ASC")
    suspend fun getDueScheduled(time: Long): List<Transaction>

    @Query("SELECT * FROM transactions WHERE phoneNumber = :phone ORDER BY createdAt DESC")
    fun getTransactionsByPhone(phone: String): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE phoneNumber = :phone AND amount = :amount AND status = 'SUCCESSFUL' AND createdAt > :since LIMIT 1")
    suspend fun getRecentSuccessful(phone: String, amount: Double, since: Long): Transaction?

    @Query("SELECT * FROM transactions WHERE createdAt < :before ORDER BY createdAt ASC")
    suspend fun getOlderThan(before: Long): List<Transaction>

    @Query("SELECT * FROM transactions WHERE isAutoRenewal = 0 AND status = 'SUCCESSFUL' ORDER BY createdAt DESC")
    suspend fun getAutoRenewalParentTransactions(): List<Transaction>

    @Query("SELECT * FROM transactions WHERE createdAt >= :start AND createdAt <= :end ORDER BY createdAt DESC")
    fun getTransactionsByDateRange(start: Long, end: Long): Flow<List<Transaction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransactionById(id: String)

    @Query("DELETE FROM transactions WHERE createdAt < :before")
    suspend fun deleteOlderThan(before: Long): Int

    @Query("UPDATE transactions SET status = :status, updatedAt = :updatedAt WHERE id = :id")
    suspend fun updateTransactionStatus(id: String, status: TransactionStatus, updatedAt: Long = System.currentTimeMillis())

    @Query("UPDATE transactions SET commission = :commission, status = :status, completedAt = :time, updatedAt = :time WHERE id = :id")
    suspend fun completeTransaction(id: String, commission: Double, status: TransactionStatus, time: Long)

    @Query("UPDATE transactions SET commission = :commission, status = :newStatus, updatedAt = :time WHERE id = (SELECT id FROM transactions WHERE status = 'PROCESSING' ORDER BY createdAt DESC LIMIT 1)")
    suspend fun updateLatestProcessingWithCommission(commission: Double, newStatus: TransactionStatus, time: Long = System.currentTimeMillis())

    @Query("SELECT COUNT(*) FROM transactions WHERE status = :status")
    fun getTransactionCountByStatus(status: TransactionStatus): Flow<Int>

    @Query("SELECT SUM(commission) FROM transactions WHERE status = 'SUCCESSFUL'")
    fun getTotalCommission(): Flow<Double?>
}
