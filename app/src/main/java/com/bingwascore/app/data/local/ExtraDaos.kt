package com.bingwascore.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bingwascore.app.data.local.entity.AutoReplyEntity
import com.bingwascore.app.data.local.entity.SiteLinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AutoReplyDao {

    @Query("SELECT * FROM auto_replies ORDER BY id ASC")
    fun getAll(): Flow<List<AutoReplyEntity>>

    @Query("SELECT * FROM auto_replies WHERE id = :id")
    suspend fun getById(id: Long): AutoReplyEntity?

    @Query("SELECT * FROM auto_replies WHERE type = :type AND isActive = 1 LIMIT 1")
    suspend fun getActiveByType(type: String): AutoReplyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reply: AutoReplyEntity): Long

    @Update
    suspend fun update(reply: AutoReplyEntity)

    @Query("DELETE FROM auto_replies WHERE id = :id")
    suspend fun delete(id: Long)
}

@Dao
interface SiteLinkDao {

    @Query("SELECT * FROM sitelink LIMIT 1")
    fun getMySiteLink(): Flow<SiteLinkEntity?>

    @Query("SELECT * FROM sitelink LIMIT 1")
    suspend fun getSiteLinkSync(): SiteLinkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(site: SiteLinkEntity)

    @Query("UPDATE sitelink SET isActive = :active WHERE id = :id")
    suspend fun setActive(id: String, active: Boolean)

    @Query("DELETE FROM sitelink WHERE id = :id")
    suspend fun delete(id: String)
}
