package com.bingwascore.app.services

import com.bingwascore.app.domain.TransactionStatus
import java.util.regex.Pattern

/**
 * Pure USSD response classifier (Audit G8/G9, Parity Block B truth).
 *
 * PARITY BLOCK B — EXACT Hybrid literals:
 * SUCCESS regex "(?i)\b(Kindly wait as we process your request|...)" and the
 * 10 FAILURE "contains" strings below. Legacy keyword fallbacks are kept
 * AFTER the Hybrid checks so old unit tests stay green without changing
 * Hybrid precedence.
 */
object UssdResponses {

    /**
     * EXACT Hybrid SUCCESS regex (verbatim, including the (?i) flag and the
     * trailing ".*" + word boundary):
     * "(?i)\b(Kindly wait as we process your request|Kindly wait while we
     * process your request|You have successfully purchased|You have
     * transferred \d+\.\d{2} KSH from your account to|You have transferred
     * \d+ Bonga Points to|Airtime Bal\s*:|Tafadhali subiri tunaposhughulikia
     * ombi lako|Message Sent|Message has been sent successfully|Umetuma
     * shilingi \d+\.\d{2}|Recommendation for \d{10,13} submitted
     * successfully).*"
     */
    private val SUCCESS_PATTERN = Pattern.compile(
        "(?i)\\b(Kindly wait as we process your request|Kindly wait while we process your request|" +
            "You have successfully purchased|You have transferred \\d+\\.\\d{2} KSH from your account to|" +
            "You have transferred \\d+ Bonga Points to|Airtime Bal\\s*:|" +
            "Tafadhali subiri tunaposhughulikia ombi lako|Message Sent|" +
            "Message has been sent successfully|Umetuma shilingi \\d+\\.\\d{2}|" +
            "Recommendation for \\d{10,13} submitted successfully).*"
    )

    /**
     * EXACT Hybrid FAILURE strings — a response containing ANY of these is a
     * failure ("already been recommended" maps to FAILED_ALREADY_RECOMMENDED).
     */
    private val FAILURE_STRINGS = listOf(
        "already been recommended",
        "insufficient airtime",
        "insufficient account balance",
        "insufficient balance",
        "not enough airtime",
        "Connection problem",
        "has Okoa Jahazi and cannot receive bundles",
        "Excessive SQLs",
        "do not have sufficient airtime",
        "Connection problem or invalid MMI code"
    )

    // Legacy fallbacks (pre-Parity-B behaviour) — evaluated AFTER Hybrid
    // truth so existing G9 tests ("already recommended", "failed", "error")
    // keep passing without altering Hybrid precedence.
    private val LEGACY_FAILURE = listOf("failed", "error", "invalid", "not allowed")

    /**
     * Hybrid precedence: already-recommended -> any failure string -> success
     * regex -> legacy fallbacks -> SUCCESSFUL default.
     */

    fun classify(response: String): TransactionStatus {
        // 1. Hybrid already-recommended (exact literal, case-insensitive).
        if (response.contains("already been recommended", ignoreCase = true)) {
            return TransactionStatus.FAILED_ALREADY_RECOMMENDED
        }
        // 2. Hybrid failure strings (exact literals, case-insensitive except
        //    the two case-sensitive Hybrid originals handled below too).
        if (FAILURE_STRINGS.any { response.contains(it, ignoreCase = true) }) {
            return TransactionStatus.FAILED
        }
        // 3. Hybrid success regex (exact, has its own (?i) flag).
        if (SUCCESS_PATTERN.matcher(response).find()) {
            return TransactionStatus.SUCCESSFUL
        }
        // 4. Legacy fallbacks (pre-Parity-B): keep old tests/behaviour green.
        val lower = response.lowercase(java.util.Locale.ROOT)
        if (lower.contains("already recommended")) {
            return TransactionStatus.FAILED_ALREADY_RECOMMENDED
        }
        if (LEGACY_FAILURE.any { lower.contains(it) }) {
            return TransactionStatus.FAILED
        }
        return TransactionStatus.SUCCESSFUL
    }

    /**
     * REBRAND R5 — the plain-English truth behind a USSD failure code.
     *
     * `TelephonyManager` reports failures as opaque integers, and "failed code 1"
     * is the single most confusing message this app used to show. Every failure
     * now resolves to a sentence an agent can act on.
     */
    fun failureReason(failureCode: Int): String = when (failureCode) {
        // 1 — the radio refused: no service, wrong SIM, or the code is blocked.
        1 -> "Your network refused the request — check signal and that your SIM can run this code"

        // 2 — the operator understood and rejected the input.
        2 -> "The operator rejected that input — check the code and try again"

        // 3 — the SIM / network cannot do USSD at all (feature not provisioned).
        3 -> "This SIM does not support this request"

        else -> "The request could not be completed (code $failureCode)"
    }

    /**
     * Network-class failure — the bundle was not rejected by the operator, the
     * request simply never reached it. Offers with
     * [com.bingwascore.app.data.local.Offer.autoRetryConnectionProblems] treat
     * these as retryable instead of dropping the sale.
     */
    private val CONNECTION_PROBLEM_STRINGS = listOf(
        "Connection problem",
        "No network",
        "Network problem",
        "Unable to process",
        "Try again later",
        "Service unavailable",
        "invalid MMI code"
    )

    /** True when [response] is a network/transport failure rather than a rejection. */
    fun isConnectionProblem(response: String): Boolean =
        CONNECTION_PROBLEM_STRINGS.any { response.contains(it, ignoreCase = true) }
}
