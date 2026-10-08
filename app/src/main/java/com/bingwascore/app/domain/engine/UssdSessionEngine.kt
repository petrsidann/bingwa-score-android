package com.bingwascore.app.domain.engine

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdResponses

/**
 * U1 — the USSD session truth.
 *
 * One classification pass after every network/overlay response:
 *  - **terminal** (success regex or one of the failure literals) -> [Complete],
 *    the pipeline closes the row exactly as before;
 *  - **MENU** (a screen that says MORE/BACK/REPLY or offers numbered options)
 *    -> [Menu] with the next step to send, so the session auto-continues
 *    instead of dying on Safaricom's "Invalid choice".
 *
 * The next step is the offer's own step list when it has one, otherwise `1` —
 * never a hard-coded `2`: picking the wrong parameter is exactly the bug this
 * class exists to kill (see `generatedDialString_equalsStoredCodeWithPhoneOnly`
 * in the unit tests).
 *
 * Loop bound: [MAX_STEPS] re-submissions per session, each with a per-step
 * timeout owned by the caller. Every transition logs `[USSD-STEP]`.
 */
object UssdSessionEngine {

    /** Hard cap on menu continuations — a menu loop must never spin forever. */
    const val MAX_STEPS = 6

    /** Log tag for every step decision — `adb logcat -s USSD | grep USSD-STEP`. */
    const val STEP_TAG = "[USSD-STEP]"

    sealed interface Verdict {
        /** Terminal response: close the session with [status]. */
        data class Complete(val status: TransactionStatus, val response: String) : Verdict

        /** A menu: send [choice] (already resolved) to continue. */
        data class Menu(val choice: String, val response: String) : Verdict
    }

    private val NUMBERED_OPTION = Regex("(?m)^\\s*\\d+[.)]\\s+")
    private val MENU_HINTS = listOf("MORE", "BACK", "REPLY")

    /** True when [text] is an interactive menu rather than a final answer. */
    fun isMenu(text: String): Boolean {
        if (text.isBlank()) return false
        val upper = text.uppercase(java.util.Locale.ROOT)
        return MENU_HINTS.any { upper.contains(it) } || NUMBERED_OPTION.containsMatchIn(text)
    }

    /**
     * The one classification entry point. Menu wins over the success regex:
     * a screen offering choices is never a verdict, even when it happens to
     * contain a success-ish word.
     */
    fun classify(response: String, steps: List<String>, stepIndex: Int): Verdict {
        if (isMenu(response)) return Verdict.Menu(nextChoice(steps, stepIndex), response)
        return Verdict.Complete(UssdResponses.classify(response), response)
    }

    /**
     * U1 — the offer's step list is consulted FIRST; `1` is the default only
     * when the offer declares no steps. This is the "2 vs 1" parameter guard.
     */
    fun nextChoice(steps: List<String>, stepIndex: Int): String =
        steps.getOrNull(stepIndex)?.takeIf { it.isNotBlank() } ?: "1"

    /**
     * U1 — THE dial-string generator. The final dial string is the stored offer
     * code with ONLY the phone placeholder substituted (`ph` / legacy `BH`
     * as a whole `*`-delimited segment); nothing else is appended, reordered
     * or re-parameterised. Substring matching is banned here: a naive
     * `replace("ph")` would eat real parameter digits if a code ever carried
     * them as letters — the unit test `generatedDialString_equalsStoredCodeWithPhoneOnly`
     * pins exactly that and kills any "wrong parameter" regression.
     *
     * Every dial path (dialer, batch, autopilot, preview) must come through
     * here so the string the agent sees is byte-for-byte the string the
     * radio dials.
     */
    fun generateDialString(storedCode: String, phone: String): String {
        if (storedCode.isBlank() || phone.isBlank()) return storedCode
        val trailingHash = storedCode.endsWith("#")
        val core = if (trailingHash) storedCode.dropLast(1) else storedCode
        val expanded = core.split('*').joinToString("*") { segment ->
            if (segment.equals("ph", ignoreCase = true) ||
                segment.equals("bh", ignoreCase = true)
            ) {
                phone
            } else {
                segment
            }
        }
        return if (trailingHash) "$expanded#" else expanded
    }

    /** Parses an offer's comma-separated step declaration ("1,2,1" or ""). */
    fun parseSteps(raw: String?): List<String> =
        raw.orEmpty().split(',').map { it.trim() }.filter { it.isNotEmpty() }

    /**
     * Appends one menu reply to a dial string: `*544*1*ph#` + `1` ->
     * `*544*1*ph*1#` (the reply lands before the terminating `#`).
     */
    fun appendStep(code: String, choice: String): String = when {
        code.isBlank() -> choice
        code.endsWith("#") -> code.dropLast(1) + "*" + choice + "#"
        else -> code + "*" + choice
    }
}