package com.bingwascore.app.data.local

import androidx.room.*
import com.bingwascore.app.domain.model.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    
    @Query("SELECT * FROM customers ORDER BY name ASC")
    fun getAllCustomers(): Flow<List<Customer>>
    
    @Query("SELECT * FROM customers WHERE phoneNumber = :phoneNumber")
    suspend fun getCustomerByPhone(phoneNumber: String): Customer?
    
    @Query("SELECT * FROM customers WHERE id = :id")
    suspend fun getCustomerById(id: String): Customer?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)
    
    @Update
    suspend fun updateCustomer(customer: Customer)
    
    @Delete
    suspend fun deleteCustomer(customer: Customer)
    
    @Query("UPDATE customers SET isBlacklisted = :isBlacklisted WHERE id = :id")
    suspend fun updateBlacklistStatus(id: String, isBlacklisted: Boolean)
}
