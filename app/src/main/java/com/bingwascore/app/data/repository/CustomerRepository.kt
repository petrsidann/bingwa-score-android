package com.bingwascore.app.data.repository

import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.domain.model.Customer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomerRepository @Inject constructor(
    private val customerDao: CustomerDao
) {
    fun getAllCustomers(): Flow<List<Customer>> = customerDao.getAllCustomers()
    
    suspend fun getCustomerByPhone(phoneNumber: String): Customer? = 
        customerDao.getCustomerByPhone(phoneNumber)
    
    suspend fun getCustomerById(id: String): Customer? = 
        customerDao.getCustomerById(id)
    
    suspend fun insertCustomer(customer: Customer) = 
        customerDao.insertCustomer(customer)
    
    suspend fun updateCustomer(customer: Customer) = 
        customerDao.updateCustomer(customer)
    
    suspend fun deleteCustomer(customer: Customer) = 
        customerDao.deleteCustomer(customer)
    
    suspend fun updateBlacklistStatus(id: String, isBlacklisted: Boolean) = 
        customerDao.updateBlacklistStatus(id, isBlacklisted)
}
