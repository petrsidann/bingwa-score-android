package com.bingwascore.app.data.remote

import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.repository.OfferRepository
import kotlinx.coroutines.flow.first
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MEGA B — the [ApiService] implementation.
 *
 * The design rule: the LOCAL answer is computed FIRST and handed in as the
 * fallback, so a caller always gets usable data whether or not a backend
 * exists. A remote attempt only ever upgrades that answer.
 *
 * Parsing uses `org.json` (already a dependency) and every parse is guarded —
 * a malformed payload degrades to the local fallback rather than throwing.
 */
@Singleton
class OfflineFirstApiService @Inject constructor(
    private val http: RemoteHttpClient,
    private val fallback: OfflineFallback,
    private val remoteConfig: RemoteConfig,
    private val offerRepository: OfferRepository
) : ApiService {

    override suspend fun getVerifiedOffers(token: String?): RemoteResult<List<VerifiedOfferDto>> {
        // The local catalogue doubles as the offline answer.
        val local = runCatching { offerRepository.activeOffers.first() }
            .getOrDefault(emptyList())
            .map { it.toDto() }

        return fallback.guard(
            flag = remoteConfig.offerSyncEnabled,
            operation = "getVerifiedOffers",
            fallback = local
        ) {
            val body = http.getRaw(PATH_VERIFIED_OFFERS, token) ?: return@guard local
            parseOfferList(body)
        }
    }

    override suspend fun getAllFeatures(token: String?): RemoteResult<List<FeatureDto>> {
        // Offline: derive features from the offers we already hold.
        val local = runCatching { offerRepository.allOffers.first() }
            .getOrDefault(emptyList())
            .map { offer -> offer.toFeatureDto() }

        return fallback.guard(
            flag = remoteConfig.offerSyncEnabled,
            operation = "getAllFeatures",
            fallback = local
        ) {
            val body = http.getRaw(PATH_FEATURES, token) ?: return@guard local
            parseFeatureList(body)
        }
    }

    override suspend fun getFeatureByCode(
        code: String,
        token: String?
    ): RemoteResult<FeatureDto?> {
        val local = runCatching { offerRepository.allOffers.first() }
            .getOrDefault(emptyList())
            .firstOrNull { it.ussdCode == code || it.id == code }
            ?.toFeatureDto()

        return fallback.guard(
            flag = remoteConfig.offerSyncEnabled,
            operation = "getFeatureByCode",
            fallback = local
        ) {
            val body = http.getRaw("$PATH_FEATURES/$code", token) ?: return@guard local
            parseFeature(body)
        }
    }

    override suspend fun getPassesForFeatureId(
        featureId: String,
        token: String?
    ): RemoteResult<List<PassDto>> {
        // Offline: one implied pass derived from the local offer's validity.
        val local = runCatching { offerRepository.getOffer(featureId) }.getOrNull()
            ?.let { offer ->
                listOf(
                    PassDto(
                        id = "local_${offer.id}",
                        featureId = offer.id,
                        name = offer.name,
                        durationDays = (offer.validityHours / 24).coerceAtLeast(1),
                        price = offer.price
                    )
                )
            }
            ?: emptyList()

        return fallback.guard(
            flag = remoteConfig.offerSyncEnabled,
            operation = "getPassesForFeatureId",
            fallback = local
        ) {
            val body = http.getRaw("$PATH_FEATURES/$featureId/passes", token) ?: return@guard local
            parsePassList(body)
        }
    }

    override suspend fun sendMessageToDevice(
        request: FcmMessageRequest,
        token: String?
    ): RemoteResult<Boolean> {
        // Offline: report "not queued" but return normally — never throw.
        return fallback.guard(
            flag = remoteConfig.pushEnabled,
            operation = "sendMessageToDevice",
            fallback = false
        ) {
            val payload = JSONObject().apply {
                put("deviceId", request.deviceId)
                put("title", request.title)
                put("body", request.body)
                put("data", JSONObject(request.data))
            }
            val body = http.postRaw(PATH_SEND_MESSAGE, payload.toString(), token)
            body != null && !body.contains("\"error\"", ignoreCase = true)
        }
    }

    // ---- Guarded JSON parsing --------------------------------------------

    private fun parseOfferList(body: String): List<VerifiedOfferDto> = runCatching {
        val array = JSONArray(body)
        List(array.length()) { index ->
            val item = array.getJSONObject(index)
            VerifiedOfferDto(
                code = item.optString("code"),
                name = item.optString("name"),
                price = item.optInt("price"),
                ussdCode = item.optString("ussdCode"),
                verified = item.optBoolean("verified"),
                type = item.optString("type", Offer.TYPE_DATA)
            )
        }
    }.getOrDefault(emptyList())

    private fun parseFeatureList(body: String): List<FeatureDto> = runCatching {
        val array = JSONArray(body)
        List(array.length()) { index -> array.getJSONObject(index).toFeatureDto() }
    }.getOrDefault(emptyList())

    private fun parseFeature(body: String): FeatureDto? = runCatching {
        JSONObject(body).toFeatureDto()
    }.getOrNull()

    private fun parsePassList(body: String): List<PassDto> = runCatching {
        val array = JSONArray(body)
        List(array.length()) { index ->
            val item = array.getJSONObject(index)
            PassDto(
                id = item.optString("id"),
                featureId = item.optString("featureId"),
                name = item.optString("name"),
                durationDays = item.optInt("durationDays"),
                price = item.optInt("price")
            )
        }
    }.getOrDefault(emptyList())

    private fun JSONObject.toFeatureDto() = FeatureDto(
        id = optString("id"),
        code = optString("code"),
        name = optString("name"),
        description = optString("description"),
        price = optInt("price"),
        active = optBoolean("active", true)
    )

    private fun Offer.toDto() = VerifiedOfferDto(
        code = id,
        name = name,
        price = price,
        ussdCode = ussdCode,
        verified = isVerified,
        type = type
    )

    private fun Offer.toFeatureDto() = FeatureDto(
        id = id,
        code = ussdCode,
        name = name,
        description = completionMessage.orEmpty(),
        price = price,
        active = isActive
    )

    companion object {
        const val PATH_VERIFIED_OFFERS = "/api/offers/verified"
        const val PATH_FEATURES = "/api/features"
        const val PATH_SEND_MESSAGE = "/api/messages/send"
    }
}