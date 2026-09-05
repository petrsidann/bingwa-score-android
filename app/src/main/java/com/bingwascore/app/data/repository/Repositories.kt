package com.bingwascore.app.data.repository

import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.data.local.TransactionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepository @Inject constructor(
    private val dao: TransactionDao
) {
    val allTransactions: Flow<List<Transaction>> = dao.getAllTransactions()

    fun transactionsByStatus(status: String): Flow<List<Transaction>> =
        dao.getTransactionsByStatus(status)

    fun dueScheduled(time: Long): Flow<List<Transaction>> = dao.getDueScheduled(time)

    fun recentSuccessful(phone: String, amount: Double, since: Long): Flow<List<Transaction>> =
        dao.getRecentSuccessful(phone, amount, since)

    suspend fun getTransaction(id: String): Transaction? = dao.getById(id)

    suspend fun insert(transaction: Transaction) = dao.insert(transaction)

    suspend fun update(transaction: Transaction) = dao.update(transaction)

    suspend fun delete(transaction: Transaction) = dao.delete(transaction)

    suspend fun deleteById(id: String) = dao.deleteById(id)

    suspend fun getOlderThan(before: Long): List<Transaction> = dao.getOlderThan(before)

    suspend fun deleteOlderThan(before: Long) = dao.deleteOlderThan(before)

    suspend fun getDueScheduledOnce(time: Long): List<Transaction> =
        dao.getDueScheduledList(time)

    suspend fun getRecentSuccessfulOnce(
        phone: String,
        amount: Double,
        since: Long
    ): List<Transaction> = dao.getRecentSuccessfulList(phone, amount, since)
}

@Singleton
class OfferRepository @Inject constructor(
    private val dao: OfferDao
) {
    val allOffers: Flow<List<Offer>> = dao.getAllOffers()

    val activeOffers: Flow<List<Offer>> = dao.getActiveOffers()

    fun offerByPrice(price: Int): Flow<Offer?> = dao.getOfferByPrice(price)

    suspend fun getOfferByPriceOnce(price: Int): Offer? = dao.getOfferByPriceOnce(price)

    suspend fun getOffer(id: String): Offer? = dao.getById(id)

    suspend fun insert(offer: Offer) = dao.insert(offer)

    suspend fun update(offer: Offer) = dao.update(offer)

    suspend fun delete(offer: Offer) = dao.delete(offer)

    suspend fun deleteById(id: String) = dao.deleteById(id)
}

@Singleton
class CustomerRepository @Inject constructor(
    private val dao: CustomerDao
) {
    val allCustomers: Flow<List<Customer>> = dao.getAllCustomers()

    val blacklisted: Flow<List<Customer>> = dao.getBlacklisted()

    fun customerByPhone(phone: String): Flow<Customer?> = dao.getCustomerByPhone(phone)

    suspend fun getCustomerOnce(phone: String): Customer? = dao.getByPhoneOnce(phone)

    suspend fun insert(customer: Customer) = dao.insert(customer)

    suspend fun update(customer: Customer) = dao.update(customer)

    suspend fun delete(customer: Customer) = dao.delete(customer)
}

@Singleton
class AutoReplyRepository @Inject constructor(
    private val dao: AutoReplyDao
) {
    val allAutoReplies: Flow<List<AutoReply>> = dao.getAllAutoReplies()

    fun byType(type: String): Flow<List<AutoReply>> = dao.getByType(type)

    suspend fun getActive(): List<AutoReply> = dao.getActive()

    suspend fun insert(autoReply: AutoReply): Long = dao.insert(autoReply)

    suspend fun update(autoReply: AutoReply) = dao.update(autoReply)

    suspend fun delete(autoReply: AutoReply) = dao.delete(autoReply)

    suspend fun setActive(id: Int, active: Boolean) = dao.setActive(id, active)
}