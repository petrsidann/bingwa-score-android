package com.bingwascore.app.ui.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.ui.theme.OfferTags
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * A marketplace row. Purely a projection of a local [Offer] — a shared
 * listing IS an offer the agent has published, so nothing new is persisted.
 */
data class CommunityListing(
    val id: String,
    val name: String,
    val price: Int,
    val seller: String,
    val tagLabel: String,
    val isVerified: Boolean,
    val validityHours: Int,
    val autoRenewable: Boolean,
    val silentEligible: Boolean
)

/**
 * PREMIUM LOCK — Community screen state.
 *
 * Maps the local offer table into marketplace rows and holds the active tag
 * filter. Reads are all local Room flows, so the screen renders instantly
 * offline; `loading` only covers the first snapshot.
 */
@HiltViewModel
class CommunityViewModel @Inject constructor(
    offerRepository: OfferRepository
) : ViewModel() {

    private val _selectedTag = MutableStateFlow<String?>(null)
    val selectedTag: StateFlow<String?> = _selectedTag.asStateFlow()

    /** True until the first Room snapshot lands, so the shimmer can show. */
    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val offers = offerRepository.activeOffers
        .map { list ->
            _loading.value = false
            list
        }

    val listings: StateFlow<List<CommunityListing>> = combine(offers, _selectedTag) { list, tag ->
        list.filter { tag == null || it.tag == tag }.map { it.toListing() }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun selectTag(tag: String?) {
        _selectedTag.value = tag
    }
}

/** "OFFER_2" -> "Offer 2"; an untagged offer reports itself as untagged. */
private fun Offer.tagLabel(): String =
    tag?.takeIf { it.isNotBlank() }?.let { "Offer ${it.removePrefix("OFFER_")}" } ?: "Untagged"

/**
 * "Shared by <relay device>" when the offer is served by another agent's
 * relay, otherwise it reads as a self-published listing — which is what an
 * offer with no relay device actually is.
 */
private fun Offer.sellerLabel(): String =
    relayDevice?.takeIf { it.isNotBlank() }?.let { "Shared via $it" } ?: "Published by you"

private fun Offer.toListing() = CommunityListing(
    id = id,
    name = name,
    price = price,
    seller = sellerLabel(),
    tagLabel = tagLabel(),
    isVerified = isVerified,
    validityHours = validityHours,
    autoRenewable = autoRenewable,
    silentEligible = silentBatch && tag in OfferTags.ALL
)