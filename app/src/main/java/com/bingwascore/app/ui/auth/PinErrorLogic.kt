package com.bingwascore.app.ui.auth

import com.bingwascore.app.data.auth.AuthConstants

/**
 * Stage 57 — pure PIN error logic. No Android dependencies; testable with plain JUnit.
 *
 * Rule:
 *   pinError = when {
 *       overflowFlag -> "PIN is 4 digits"   // set ONLY on a 5th digit press
 *       submitted && pin.length != 4 -> "PIN is 4 digits"
 *       else -> null                        // null at length == 4 unsubmitted
 *   }
 *
 * Backspace below 5 clears overflowFlag immediately.
 */
class PinErrorLogic {
    private val digits = mutableListOf<Char>()
    private var overflowFlag = false
    private var submitted = false

    fun press(digit: Char) {
        if (digits.size >= AuthConstants.MIN_PIN_LENGTH) {
            overflowFlag = true
            return
        }
        digits.add(digit)
    }

    fun backspace() {
        if (digits.isNotEmpty()) {
            digits.removeAt(digits.size - 1)
            overflowFlag = false
        }
    }

    fun submit() {
        submitted = true
    }

    val pin: String get() = digits.joinToString("")
    val length: Int get() = digits.size

    val pinError: String?
        get() = when {
            overflowFlag -> "PIN is 4 digits"
            submitted && digits.size != AuthConstants.MIN_PIN_LENGTH -> "PIN is 4 digits"
            else -> null
        }
}
