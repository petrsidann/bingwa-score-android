package com.bingwascore.app.domain.sms

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReceivedSmsCache @Inject constructor() {

    private val cache = LinkedHashMap<String, Long>()
    private val maxEntries = 500
    private val windowMillis = 10 * 60 * 1000L // 10 minutes

    @Synchronized
    fun isSeen(sender: String, body: String): Boolean {
        val key = fingerprint(sender, body)
        val now = System.currentTimeMillis()
        val seenAt = cache[key]
        return seenAt != null && (now - seenAt) < windowMillis
    }

    @Synchronized
    fun mark(sender: String, body: String) {
        val key = fingerprint(sender, body)
        cache[key] = System.currentTimeMillis()

        if (cache.size > maxEntries) {
            val oldest = cache.entries.firstOrNull()?.key
            if (oldest != null) cache.remove(oldest)
        }
    }

    private fun fingerprint(sender: String, body: String): String {
        val timeBucket = System.currentTimeMillis() / 60000L
        return "$sender|${body.hashCode()}|$timeBucket"
    }
}
