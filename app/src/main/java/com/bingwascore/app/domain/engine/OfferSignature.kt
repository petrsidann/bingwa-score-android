package com.bingwascore.app.domain.engine

object OfferSignature {

    const val DEFAULT_STRICT_TEMPLATE =
        "You have successfully recommended offer to @phone. Total Commission this week is @amount. Keep Selling, be a Bingwa Sokoni!!"

    fun normalize(code: String): String {
        return code.trim()
            .removePrefix("*")
            .removeSuffix("#")
            .replace("[", "")
            .replace("]", "")
    }

    fun tokens(code: String): List<String> =
        normalize(code).split('*').filter { it.isNotBlank() }

    // Spec §2: adjacent 180 -> 5 token pair classifies a Bingwa offer
    fun isBingwaOffer(code: String): Boolean {
        val t = tokens(code)
        for (i in 0 until t.size - 1) {
            if (t[i] == "180" && t[i + 1] == "5") return true
        }
        return false
    }

    fun hasPhonePlaceholder(message: String?): Boolean =
        message != null && (message.contains("@phone") || message.contains("<phone>"))

    fun canEnableStrictMode(completionMessage: String?): Boolean =
        !completionMessage.isNullOrBlank() && hasPhonePlaceholder(completionMessage)

    fun awaitingCompletionMessage(
        code: String,
        strictMode: Boolean,
        completionMessage: String?
    ): Boolean {
        if (!strictMode) return false
        return canEnableStrictMode(completionMessage) || isBingwaOffer(code)
    }
}
