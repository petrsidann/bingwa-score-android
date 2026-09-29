package com.bingwascore.app.services

import com.bingwascore.app.domain.TransactionStatus
import java.util.Locale

/**
 * Pure USSD response classifier (Audit G8/G9): maps a raw USSD reply onto a
 * [TransactionStatus]. Kept outside the Service so plain JVM unit tests can
 * cover it via `./gradlew test`.
 */
object UssdResponses {

    private val FAILURE_KEYWORDS = listOf("failed", "error", "invalid", "not allowed")

    fun classify(response: String): TransactionStatus {
        val body = response.lowercase(Locale.ROOT)
        return when {
            body.contains("already recommended") -> TransactionStatus.FAILED_ALREADY_RECOMMENDED
            FAILURE_KEYWORDS.any { body.contains(it) } -> TransactionStatus.FAILED
            else -> TransactionStatus.SUCCESSFUL
        }
    }
}
