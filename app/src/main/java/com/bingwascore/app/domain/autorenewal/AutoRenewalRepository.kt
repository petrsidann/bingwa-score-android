package com.bingwascore.app.domain.autorenewal

import kotlinx.coroutines.flow.Flow

interface AutoRenewalRepository {
    fun observeAll(): Flow<List<AutoRenewal>>
    suspend fun insert(autoRenewal: AutoRenewal)
    suspend fun update(autoRenewal: AutoRenewal)
    suspend fun delete(id: String)
}
