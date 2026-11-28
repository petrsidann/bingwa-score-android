package com.bingwascore.app.data.autorenewal

import com.bingwascore.app.domain.autorenewal.AutoRenewal
import com.bingwascore.app.domain.autorenewal.AutoRenewalRepository
import com.bingwascore.app.domain.autorenewal.RenewInterval
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import javax.inject.Inject

class AutoRenewalRepositoryImpl @Inject constructor(
    private val dao: AutoRenewalDao
) : AutoRenewalRepository {

    override fun observeAll(): Flow<List<AutoRenewal>> {
        return dao.observeAll().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insert(autoRenewal: AutoRenewal) {
        dao.insert(autoRenewal.toEntity())
    }

    override suspend fun update(autoRenewal: AutoRenewal) {
        dao.updateActive(autoRenewal.id, autoRenewal.isActive)
    }

    override suspend fun delete(id: String) {
        dao.delete(id)
    }
}

private fun AutoRenewalEntity.toDomain(): AutoRenewal {
    return AutoRenewal(
        id = id,
        offerId = offerId,
        customerId = customerId,
        interval = RenewInterval.valueOf(interval),
        nextRenewalAt = Instant.ofEpochMilli(nextRenewalAtMillis),
        isActive = isActive,
        createdAt = Instant.ofEpochMilli(createdAtMillis)
    )
}

private fun AutoRenewal.toEntity(): AutoRenewalEntity {
    return AutoRenewalEntity(
        id = id,
        offerId = offerId,
        customerId = customerId,
        interval = interval.name,
        nextRenewalAtMillis = nextRenewalAt.toEpochMilli(),
        isActive = isActive,
        createdAtMillis = createdAt.toEpochMilli()
    )
}
