package com.bingwascore.app.domain.engine

import timber.log.Timber

/**
 * PARITY BLOCK B — Hybrid AutoReply placeholder engine (exact regex logic).
 *
 * Hybrid's EXACT regexes for the `@key?='default'` syntax:
 * - `new Regex("\\{([^}]+)\\}")`
 * - `new Regex("@(\\w+)\\?='([^']+)'")`
 * - `new Regex("@(\\w+)(?!\\?=')")`
 * - `new Regex("@(\\w+)(?:\\?='[^']+')?")`
 *
 * Behaviour: `{...}` blocks are expanded; inside them `@key?='default'`
 * resolves to the transaction value for `key` or to `default` when missing;
 * bare `@key` resolves to the value or "" when missing. Outside braces,
 * `@key?='default'` / `@key` are substituted the same way. Unknown keys
 * resolve to "" (or their inline default when one is given).
 */
object AutoReplyEngine {

    /** Hybrid: `new Regex("\\{([^}]+)\\}")` — brace blocks. */
    private val BRACE_PATTERN = Regex("\\{([^}]+)\\}")

    /** Hybrid: `new Regex("@(\\w+)\\?='([^']+)'")` — key + inline default. */
    private val KEY_DEFAULT_PATTERN = Regex("@(\\w+)\\?='([^']+)'")

    /** Hybrid: `new Regex("@(\\w+)(?!\\?=')")` — bare key (not followed by ?='). */
    @Suppress("unused")
    private val KEY_BARE_PATTERN = Regex("@(\\w+)(?!\\?=')")

    /** Hybrid: `new Regex("@(\\w+)(?:\\?='[^']+')?")` — key with optional default. */
    private val KEY_ANY_PATTERN = Regex("@(\\w+)(?:\\?='[^']+')?")

    /**
     * Transaction-shaped data available to placeholders. Keys are matched
     * case-insensitively: name/firstName, phone, amount, offer/offerName,
     * receipt/mpesaCode/code, time/date.
     */
    data class TxData(
        val name: String? = null,
        val firstName: String? = null,
        val phone: String? = null,
        val amount: String? = null,
        val offerName: String? = null,
        val receipt: String? = null,
        val time: String? = null
    ) {
        fun valueFor(key: String): String? = when (key.lowercase()) {
            "name", "sender", "payer", "customer", "customername" -> name ?: firstName
            "firstname", "first_name", "first" -> firstName ?: name?.substringBefore(" ")
            "phone", "phonenumber", "msisdn", "number" -> phone
            "amount", "price", "ksh" -> amount
            "offer", "offername", "bundle", "product" -> offerName
            "receipt", "mpesacode", "mpesa", "code", "receiptnumber" -> receipt
            "time", "date", "timestamp" -> time
            else -> null
        }
    }

    /** Renders [template] against [data] using Hybrid's exact regex logic. */
    fun render(template: String, data: TxData): String {
        try {
            // 1. Expand {...} blocks: resolve @key?='default' first, then bare @key.
            var out = BRACE_PATTERN.replace(template) { brace ->
                var inner = brace.groupValues[1]
                inner = KEY_DEFAULT_PATTERN.replace(inner) { m ->
                    data.valueFor(m.groupValues[1]) ?: m.groupValues[2]
                }
                inner = KEY_ANY_PATTERN.replace(inner) { m ->
                    data.valueFor(m.groupValues[1]) ?: ""
                }
                inner
            }
            // 2. Remaining @key?='default' outside braces.
            out = KEY_DEFAULT_PATTERN.replace(out) { m ->
                data.valueFor(m.groupValues[1]) ?: m.groupValues[2]
            }
            // 3. Remaining bare @key outside braces.
            out = KEY_ANY_PATTERN.replace(out) { m ->
                data.valueFor(m.groupValues[1]) ?: ""
            }
            return out
        } catch (t: Throwable) {
            Timber.e(t, "AutoReplyEngine.render failed")
            return template
        }
    }
}
