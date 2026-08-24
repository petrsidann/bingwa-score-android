package com.bingwascore.app.data.local

import androidx.room.*
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
    
    @Query("SELECT * FROM transactions WHERE phoneNumber = :phoneNumber ORDER BY createdAt DESC")
    fun getTransactionsByPhone(phoneNumber: String): Flow<List<Transaction>>
    
    @Query("SELECT * FROM transactions WHERE scheduledAt IS NOT NULL AND status = :status")
    suspend fun getScheduledTransactions(status: TransactionStatus = TransactionStatus.SCHEDULED): List<Transaction>
    
    @Query("SELECT * FROM transactions WHERE createdAt >= :startTime AND createdAt <= :endTime")
    fun getTransactionsByDateRange(startTime: Long, endTime: Long): Flow<List<Transaction>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)
    
    @Update
    suspend fun updateTransaction(transaction: Transaction)
    
    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
    
    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransactionById(id: String)
    
    @Query("UPDATE transactions SET status = :status, updatedAt = :updatedAt WHERE id = :id")
    suspend fun updateTransactionStatus(id: String, status: TransactionStatus, updatedAt: Long = System.currentTimeMillis())
    
    @Query("UPDATE transactions SET mpesaReceipt = :receipt, amount = :amount, updatedAt = :updatedAt WHERE id = (SELECT id FROM transactions ORDER BY createdAt DESC LIMIT 1)")
    suspend fun updateMpesaReceipt(receipt: String, amount: Double?, updatedAt: Long = System.currentTimeMillis())
    
    @Query("UPDATE transactions SET commission = :commission, updatedAt = :updatedAt WHERE id = (SELECT id FROM transactions ORDER BY createdAt DESC LIMIT 1)")
    suspend fun updateCommission(commission: Double, updatedAt: Long = System.currentTimeMillis())
    
    @Query("UPDATE transactions SET status = :status, updatedAt = :updatedAt WHERE id = (SELECT id FROM transactions ORDER BY createdAt DESC LIMIT 1)")
    suspend fun updateStatus(status: TransactionStatus, updatedAt: Long = System.currentTimeMillis())
    
    @Query("SELECT COUNT(*) FROM transactions WHERE status = :status")
    fun getTransactionCountByStatus(status: TransactionStatus): Flow<Int>
    
    @Query("SELECT SUM(commission) FROM transactions WHERE status = 'SUCCESSFUL'")
    fun getTotalCommission(): Flow<Double?>
}
