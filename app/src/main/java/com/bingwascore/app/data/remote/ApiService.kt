package com.bingwascore.app.data.remote

import com.bingwascore.app.data.local.Offer

/** One catalogue entry as the server returns it, before it becomes a local [Offer]. */
data class VerifiedOfferDto(
    val code: String = "",
    val name: String = "",
    val price: Int = 0,
    val ussdCode: String = "",
    val verified: Boolean = false,
    val type: String = Offer.TYPE_DATA
)

/** A purchasable feature/pass in the server catalogue. */
data class FeatureDto(
    val id: String = "",
    val code: String = "",
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val active: Boolean = true
)

/** A pass attached to a feature. */
data class PassDto(
    val id: String = "",
    val featureId: String = "",
    val name: String = "",
    val durationDays: Int = 0,
    val price: Int = 0
)

/**
 * A push message addressed to one device.
 *
 * Mirrors the server's `sendMessageToDevice(FcmMessageRequest)` contract so the
 * wire format does not change when PART B goes live.
 */
data class FcmMessageRequest(
    val deviceId: String = "",
    val title: String = "",
    val body: String = "",
    val data: Map<String, String> = emptyMap()
)

/**
 * MEGA B — the server contract, expressed exactly as the backend will expose it.
 *
 * Every method returns a [RemoteResult], never a raw value and never a thrown
 * exception. An implementation that has no backend answers
 * [RemoteResult.Offline] carrying local/demo data.
 */
interface ApiService {

    /** Catalogue of operator-verified offers. */
    suspend fun getVerifiedOffers(token: String? = null): RemoteResult<List<VerifiedOfferDto>>

    /** Every feature the account can access. */
    suspend fun getAllFeatures(token: String? = null): RemoteResult<List<FeatureDto>>

    /** A single feature by its stable code (e.g. "data_250mb_24h"). */
    suspend fun getFeatureByCode(code: String, token: String? = null): RemoteResult<FeatureDto?>

    /** All passes offered for one feature id. */
    suspend fun getPassesForFeatureId(featureId: String, token: String? = null): RemoteResult<List<PassDto>>

    /** Pushes a message to one device via the relay server. */
    suspend fun sendMessageToDevice(
        request: FcmMessageRequest,
        token: String? = null
    ): RemoteResult<Boolean>
}
