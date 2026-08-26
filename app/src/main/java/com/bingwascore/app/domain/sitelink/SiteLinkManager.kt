package com.bingwascore.app.domain.sitelink

import com.bingwascore.app.data.local.SiteLinkDao
import com.bingwascore.app.data.local.entity.SiteLinkEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SiteLinkManager @Inject constructor(
    private val siteLinkDao: SiteLinkDao
) {

    suspend fun getOrCreate(username: String): SiteLinkEntity = withContext(Dispatchers.IO) {
        siteLinkDao.getSiteLinkSync() ?: run {
            val entity = SiteLinkEntity(
                id = UUID.randomUUID().toString(),
                siteName = username,
                accountType = "MPESA",
                accountNumber = "",
                siteLinkURL = "https://score.bingwascore.app/${username.lowercase().replace(" ", "")}",
                isActive = true,
                username = username
            )
            siteLinkDao.upsert(entity)
            entity
        }
    }

    suspend fun setActive(active: Boolean) = withContext(Dispatchers.IO) {
        siteLinkDao.getSiteLinkSync()?.let { siteLinkDao.setActive(it.id, active) }
    }

    suspend fun delete() = withContext(Dispatchers.IO) {
        siteLinkDao.getSiteLinkSync()?.let { siteLinkDao.delete(it.id) }
    }
}
