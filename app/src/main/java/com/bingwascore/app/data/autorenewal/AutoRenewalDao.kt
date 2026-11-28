package com.bingwascore.app.data.autorenewal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AutoRenewalDao {
    @Query("SELECT * FROM auto_renewals ORDER BY nextRenewalAtMillis ASC")
    fun observeAll(): Flow<List<AutoRenewalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: AutoRenewalEntity)

    @Query("UPDATE auto_renewals SET isActive = :isActive WHERE id = :id")
    suspend fun updateActive(id: String, isActive: Boolean)

    @Query("DELETE FROM auto_renewals WHERE id = :id")
    suspend fun delete(id: String)
}
