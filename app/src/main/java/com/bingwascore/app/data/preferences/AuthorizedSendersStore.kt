package com.bingwascore.app.data.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Trusted SMS senders whose messages the auto-reply engine may act on.
 * Kept as a SharedPreferences StringSet (set semantics + cheap synchronous
 * reads from the SMS receiver path), mirrored into a StateFlow for Compose.
 */
@Singleton
class AuthorizedSendersStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _senders = MutableStateFlow(readSenders())
    val senders: StateFlow<Set<String>> = _senders.asStateFlow()

    /** Normalizes and adds a trusted number. Returns true when it was newly added. */
    fun add(rawNumber: String): Boolean {
        val number = normalize(rawNumber)
        if (number.isEmpty()) return false
        val current = readSenders()
        if (number in current) return false
        val updated = current + number
        prefs.edit().putStringSet(KEY_SENDERS, updated).apply()
        _senders.value = updated
        return true
    }

    fun remove(number: String) {
        val updated = readSenders() - number
        prefs.edit().putStringSet(KEY_SENDERS, updated).apply()
        _senders.value = updated
    }

    fun contains(rawNumber: String): Boolean = normalize(rawNumber) in readSenders()

    private fun readSenders(): Set<String> =
        prefs.getStringSet(KEY_SENDERS, emptySet()).orEmpty().toSortedSet()

    private fun normalize(raw: String): String = raw
        .filter { !it.isWhitespace() }
        .trim()

    private companion object {
        const val PREFS_NAME = "authorized_senders"
        const val KEY_SENDERS = "trusted_numbers"
    }
}
