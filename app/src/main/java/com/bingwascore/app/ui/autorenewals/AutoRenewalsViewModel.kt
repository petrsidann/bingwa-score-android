package com.bingwascore.app.ui.autorenewals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.domain.autorenewal.AutoRenewal
import com.bingwascore.app.domain.autorenewal.AutoRenewalRepository
import com.bingwascore.app.domain.autorenewal.RenewInterval
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AutoRenewalsViewModel @Inject constructor(
    private val repository: AutoRenewalRepository
) : ViewModel() {

    val autoRenewals: StateFlow<List<AutoRenewal>> = repository.observeAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleActive(id: String) {
        viewModelScope.launch {
            val renewal = autoRenewals.value.find { it.id == id } ?: return@launch
            repository.update(renewal.copy(isActive = !renewal.isActive))
        }
    }

    fun delete(id: String) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }

    fun add(customerId: String, offerId: String, interval: RenewInterval) {
        viewModelScope.launch {
            val renewal = AutoRenewal(
                id = UUID.randomUUID().toString(),
                offerId = offerId,
                customerId = customerId,
                interval = interval,
                nextRenewalAt = computeNextRenewal(interval),
                isActive = true,
                createdAt = Instant.now()
            )
            repository.insert(renewal)
        }
    }

    private fun computeNextRenewal(interval: RenewInterval): Instant {
        val now = Instant.now()
        return when (interval) {
            RenewInterval.DAILY -> now.plusSeconds(86400)
            RenewInterval.WEEKLY -> now.plusSeconds(604800)
            RenewInterval.BIWEEKLY -> now.plusSeconds(1209600)
            RenewInterval.MONTHLY -> now.plusSeconds(2592000L)
        }
    }
}
