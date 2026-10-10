package com.bingwascore.app.ui.transactions

import com.bingwascore.app.domain.TransactionStatus

/**
 * U5 — which write actions a row (or a whole selection) is allowed to take.
 *
 * The rule is one-directional on purpose: **a completed sale is finished**. There
 * is no Retry and no Complete on a SUCCESSFUL row, because re-dialing a bundle the
 * customer already has is a double charge, and marking it complete again is a
 * no-op that only invites a mistake. Both are greyed out and answer a tap with a
 * reject haptic.
 *
 * Retry is the re-queue path: it is only meaningful for a row that is not
 * finished — FAILED (incl. already-recommended), QUEUED (PENDING / PROCESSING) or
 * SCHEDULED. Complete is allowed for anything that is not already SUCCESSFUL.
 */
data class TxActionRules(val canRetry: Boolean, val canComplete: Boolean)

/** QUEUED, as the engine stores it — the enum value is unchanged. */
private val RETRYABLE = setOf(
    TransactionStatus.FAILED.value,
    TransactionStatus.FAILED_ALREADY_RECOMMENDED.value,
    TransactionStatus.PENDING.value,
    TransactionStatus.PROCESSING.value,
    TransactionStatus.SCHEDULED.value
)

/** Rules for one row's status. Unknown/absent statuses allow nothing. */
fun rulesFor(status: String?): TxActionRules {
    if (status.isNullOrBlank()) return TxActionRules(canRetry = false, canComplete = false)
    return TxActionRules(
        canRetry = status in RETRYABLE,
        canComplete = status != TransactionStatus.SUCCESSFUL.value
    )
}

/**
 * Rules for a multi-select: the batch action is only offered when EVERY selected
 * row may take it, so one completed sale in the selection cannot be re-dialed.
 */
fun rulesForSelection(statuses: Collection<String>): TxActionRules {
    if (statuses.isEmpty()) return TxActionRules(canRetry = false, canComplete = false)
    val perRow = statuses.map { rulesFor(it) }
    return TxActionRules(
        canRetry = perRow.all { it.canRetry },
        canComplete = perRow.all { it.canComplete }
    )
}
