package com.bingwascore.app.data.repository

import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.domain.model.Transaction
import com.bingwascore.app.domain.model.TransactionStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao,
    private val offerDao: OfferDao,
    private val customerDao: CustomerDao
) {
    fun getAllTransactions(): Flow<List<Transaction>> = transactionDao.getAllTransactions()
    
    fun getTransactionsByStatus(status: TransactionStatus): Flow<List<Transaction>> = 
        transactionDao.getTransactionsByStatus(status)
    
    suspend fun getTransactionById(id: String): Transaction? = 
        transactionDao.getTransactionById(id)
    
    fun getTransactionsByPhone(phoneNumber: String): Flow<List<Transaction>> = 
        transactionDao.getTransactionsByPhone(phoneNumber)
    
    suspend fun getDueScheduled(time: Long = System.currentTimeMillis()): List<Transaction> = 
        transactionDao.getDueScheduled(time)
    
    fun getTransactionsByDateRange(startTime: Long, endTime: Long): Flow<List<Transaction>> = 
        transactionDao.getTransactionsByDateRange(startTime, endTime)
    
    suspend fun insertTransaction(transaction: Transaction) = 
        transactionDao.insertTransaction(transaction)
    
    suspend fun updateTransaction(transaction: Transaction) = 
        transactionDao.updateTransaction(transaction)
    
    suspend fun deleteTransaction(transaction: Transaction) = 
        transactionDao.deleteTransaction(transaction)
    
    suspend fun deleteTransactionById(id: String) = 
        transactionDao.deleteTransactionById(id)
    
    suspend fun updateTransactionStatus(id: String, status: TransactionStatus, updatedAt: Long = System.currentTimeMillis()) = 
        transactionDao.updateTransactionStatus(id, status, updatedAt)
    
    fun getTransactionCountByStatus(status: TransactionStatus): Flow<Int> = 
        transactionDao.getTransactionCountByStatus(status)
    
    fun getTotalCommission(): Flow<Double?> = 
        transactionDao.getTotalCommission()
}
