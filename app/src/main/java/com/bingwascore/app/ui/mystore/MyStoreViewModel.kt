package com.bingwascore.app.ui.mystore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.OfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyStoreViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    private val offerRepository: OfferRepository
) : ViewModel() {

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    /**
     * Active offers the storefront would publish. The Agent Portal is a
     * storefront, so it is only worth sharing once there is something to sell —
     * the empty state says exactly that instead of showing a bare link.
     */
    val activeOffers: StateFlow<List<Offer>> = offerRepository.activeOffers
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    /** True until the first Room emission, so the portal can shimmer. */
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    /** True only once we KNOW the list is genuinely empty (not just loading). */
    val isEmpty: StateFlow<Boolean> = activeOffers
        .map { it.isEmpty() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    init {
        viewModelScope.launch {
            runCatching { offerRepository.activeOffers.first() }
            _isLoading.value = false
        }
    }

    val storeLink: StateFlow<String> = userPreferences.storeLink
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val isActive: StateFlow<Boolean> = userPreferences.storeActive
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    /**
     * Builds the public store URL from the agent's display name, e.g.
     * "Bingwa User" -> https://bingwascore.com/store/bingwa-user
     */
    fun generateStoreLink() {
        viewModelScope.launch {
            val name = userPreferences.userName.first()
            val url = STORE_BASE_URL + slugify(name)
            userPreferences.setStoreLink(url)
            userPreferences.setStoreActive(true)
        }
    }

    fun setActive(value: Boolean) {
        viewModelScope.launch { userPreferences.setStoreActive(value) }
    }

    fun deleteStore() {
        viewModelScope.launch {
            userPreferences.setStoreLink("")
            userPreferences.setStoreActive(false)
        }
    }

    companion object {
        private const val STORE_BASE_URL = "https://bingwascore.com/store/"

        /** Lowercase, keeps a-z0-9, collapses every other run into a single dash. */
        fun slugify(name: String): String = name
            .trim()
            .lowercase()
            .replace(Regex("[^a-z0-9]+"), "-")
            .trim('-')
            .ifEmpty { "agent" }
    }
}
