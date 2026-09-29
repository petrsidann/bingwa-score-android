package com.bingwascore.app.util

/**
 * Parity E — dial-pad normaliser (the "Parity A" helper every entry point
 * should funnel through before a USSD code is expanded).
 *
 * Collapses the formats a Kenyan operator can hand us into the canonical
 * `0XXXXXXXXX` ten-digit form:
 *
 * ```
 * "+254 712 345 678" -> "0712345678"
 * "254712345678"     -> "0712345678"
 * "712345678"        -> "0712345678"
 * "0712345678"       -> "0712345678"
 * ```
 *
 * Anything that does not look like a mobile number is returned as its bare
 * digits so the caller can still validate/warn instead of losing input.
 */
fun formatPhoneToTenDigits(raw: String): String {
    val digits = raw.filter { it.isDigit() }
    return when {
        digits.isEmpty() -> ""
        // 254 7XX XXX XXX (country code, no plus) -> 07XX XXX XXX
        digits.startsWith(COUNTRY_CODE) && digits.length == COUNTRY_CODE.length + 9 ->
            "0" + digits.substring(COUNTRY_CODE.length)
        // Already canonical.
        digits.length == 10 && digits.startsWith("0") -> digits
        // Missing the trunk zero, e.g. 712345678 / 112345678.
        digits.length == 9 && (digits.startsWith("7") || digits.startsWith("1")) -> "0$digits"
        else -> digits
    }
}

/** True when [value] is a canonical ten-digit `0XXXXXXXXX` number. */
fun isTenDigitPhone(value: String): Boolean =
    value.length == 10 && value.startsWith("0") && value.all { it.isDigit() }

private const val COUNTRY_CODE = "254"
