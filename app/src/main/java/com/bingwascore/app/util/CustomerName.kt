package com.bingwascore.app.util

/**
 * U5 — one customer name, formatted the same way on every surface.
 *
 * M-Pesa delvers the payer name in the operator's own casing ("DENNIS K
 * WACHIRA"), which reads as shouting in a ledger. This normalises it to a name a
 * human wrote: the first and last tokens keep their full word, middle tokens
 * collapse to an initial with a full stop — `DENNIS K WACHIRA` -> `Dennis K.
 * Wachira`.
 *
 * Pure, so it is unit-tested once and trusted everywhere.
 */
fun formatCustomerName(raw: String?): String {
    val trimmed = raw?.trim().orEmpty()
    if (trimmed.isEmpty()) return ""
    val parts = trimmed.split(Regex("\\s+")).filter { it.isNotBlank() }
    if (parts.isEmpty()) return ""
    if (parts.size == 1) return titleCase(parts.first())

    val first = titleCase(parts.first())
    val last = titleCase(parts.last())
    val middle = parts.subList(1, parts.size - 1)
        .joinToString(" ") { token -> "${token.first().uppercaseChar()}." }
    return if (middle.isBlank()) "$first $last" else "$first $middle $last"
}

/** "WACHIRA" -> "Wachira", "o'brien" -> "O'brien". */
private fun titleCase(token: String): String =
    token.lowercase().replaceFirstChar { it.uppercaseChar() }
