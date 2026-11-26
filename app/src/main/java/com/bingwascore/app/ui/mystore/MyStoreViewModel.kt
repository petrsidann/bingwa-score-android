package com.bingwascore.app.ui.mystore

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class StoreOffer(
    val name: String,
    val published: Boolean
)

data class StoreOrder(
    val id: String,
    val name: String,
    val offer: String,
    val ago: String,
    val amount: Double,
    val status: OrderStatus
)

enum class OrderStatus {
    COMPLETED, FAILED, QUEUED, AWAITING
}

data class StoreScreenState(
    val storefrontLink: String = "bingwa.app/vibez",
    val publishedCount: Int = 3,
    val totalOffers: Int = 4,
    val siteLinkOrders: Int = 2,
    val offers: List<StoreOffer> = listOf(
        StoreOffer("1 Minute Airtime", true),
        StoreOffer("1GB Daily Data", true),
        StoreOffer("5GB Weekly Data", true),
        StoreOffer("All Access Unlimited", false)
    ),
    val orders: List<StoreOrder> = listOf(
        StoreOrder("1042", "SiteLink #1042", "1GB Daily Data", "12m ago", 20.0, OrderStatus.COMPLETED),
        StoreOrder("1041", "SiteLink #1041", "250MB", "1h ago", 22.0, OrderStatus.QUEUED)
    )
)

@HiltViewModel
class MyStoreViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(StoreScreenState())
    val state: StateFlow<StoreScreenState> = _state.asStateFlow()

    fun toggleOfferPublished(index: Int) {
        _state.value = _state.value.copy(
            offers = _state.value.offers.toMutableList().also { list ->
                list[index] = list[index].copy(published = !list[index].published)
            },
            publishedCount = _state.value.offers.count { it.published }.let { count ->
                if (_state.value.offers[index].published) count - 1 else count + 1
            }
        )
    }
}
