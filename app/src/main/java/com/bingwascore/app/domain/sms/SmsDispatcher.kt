package com.bingwascore.app.domain.sms

import android.telephony.SmsManager
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmsDispatcher @Inject constructor() {

    private val placeholderRegex = Regex("@(\\w+)(?:\\?='[^']+')?")
    private val fallbackRegex = Regex("\\?='([^']*)'")

    fun send(destination: String, template: String, values: Map<String, String>) {
        try {
            val message = substitute(template, values)
            @Suppress("DEPRECATION")
            val manager = SmsManager.getDefault()
            @Suppress("DEPRECATION")
            manager.sendTextMessage(destination, null, message, null, null)
            Timber.d("Auto-reply sent to $destination")
        } catch (e: Exception) {
            Timber.e(e, "Failed to send auto-reply")
        }
    }

    private fun substitute(template: String, values: Map<String, String>): String {
        var out = placeholderRegex.replace(template) { match ->
            val key = match.groupValues[1]
            val fallback = fallbackRegex.find(match.value)?.groupValues?.get(1)
            values[key] ?: fallback ?: match.value // unknown @key preserved
        }
        values.forEach { (key, value) ->
            out = out.replace("<$key>", value)
        }
        return out
    }
}
