package com.bingwascore.app.domain.usecase

import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.domain.model.Customer
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetOrCreateCustomerUseCase @Inject constructor(
    private val customerDao: CustomerDao
) {

    suspend operator fun invoke(phone: String, name: String? = null): Customer {
        val normalized = phone.replace(" ", "").replace("-", "")

        val existing = customerDao.getCustomerByPhone(normalized)
        if (existing != null) {
            return if (name != null && existing.name == "Unknown") {
                val updated = existing.copy(name = name)
                customerDao.updateCustomer(updated)
                updated
            } else {
                existing
            }
        }

        val customer = Customer(
            id = UUID.randomUUID().toString(),
            phoneNumber = normalized,
            name = name ?: "Unknown",
            email = null
        )
        customerDao.insertCustomer(customer)
        return customer
    }
}
