package com.bingwascore.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

private val Context.offerTransitionStore: DataStore<Preferences> by preferencesDataStore(
    name = "offer_transitions"
)

/**
 * Fallback dial rule: when a transaction ends in [fromStatus], dial offer
 * [toOfferId] next. No OfferTransitionRule Room table exists yet, so rules are
 * kept as a simple JSON list in DataStore.
 */
data class OfferTransitionRule(
    val fromStatus: String,
    val toOfferId: String,
    val toOfferName: String
)

@Singleton
class OfferTransitionStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val gson = Gson()

    private object Keys {
        val RULES = stringPreferencesKey("offer_transition_rules")
    }

    val rules: Flow<List<OfferTransitionRule>> =
        context.offerTransitionStore.data.map { prefs -> decode(prefs[Keys.RULES]) }

    /** Saves [rule], replacing any previous rule with the same status + target pair. */
    suspend fun save(rule: OfferTransitionRule) {
        try {
            context.offerTransitionStore.edit { prefs ->
                val current = decode(prefs[Keys.RULES]).toMutableList()
                current.removeAll {
                    it.fromStatus == rule.fromStatus && it.toOfferId == rule.toOfferId
                }
                current.add(rule)
                prefs[Keys.RULES] = encode(current)
            }
        } catch (t: Throwable) {
            Timber.e(t, "Failed to save offer transition rule")
        }
    }

    suspend fun delete(rule: OfferTransitionRule) {
        try {
            context.offerTransitionStore.edit { prefs ->
                val current = decode(prefs[Keys.RULES]).filterNot { it == rule }
                prefs[Keys.RULES] = encode(current)
            }
        } catch (t: Throwable) {
            Timber.e(t, "Failed to delete offer transition rule")
        }
    }

    private fun encode(rules: List<OfferTransitionRule>): String = gson.toJson(rules)

    private fun decode(raw: String?): List<OfferTransitionRule> {
        if (raw.isNullOrBlank()) return emptyList()
        return try {
            val type = object : TypeToken<List<OfferTransitionRule>>() {}.type
            gson.fromJson<List<OfferTransitionRule>>(raw, type).orEmpty()
        } catch (t: Throwable) {
            Timber.e(t, "Failed to decode offer transition rules")
            emptyList()
        }
    }
}
