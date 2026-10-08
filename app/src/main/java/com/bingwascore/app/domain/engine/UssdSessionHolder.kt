package com.bingwascore.app.domain.engine

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Process-wide memory of the last USSD overlay text captured by
 * [com.bingwascore.app.services.UssdAccessibilityService]. The pipeline reads
 * it when classifying advanced-mode sessions and failed confirmations; the
 * accessibility service writes it on every overlay change.
 *
 * U1 — also carries the live session's step state (base dial code, offer step
 * list, current index, per-step deadline) so the accessibility service and the
 * automation service agree on which menu reply to send next.
 */
@Singleton
class UssdSessionHolder @Inject constructor() {

    private val _lastSessionText = MutableStateFlow<String?>(null)

    /** Latest captured overlay as a Flow (pipeline-friendlier). */
    val lastSessionText: StateFlow<String?> = _lastSessionText.asStateFlow()

    /** Latest captured overlay for thread-safe one-off reads. */
    @Volatile
    var lastSessionRaw: String? = null
        private set

    // ── U1 — active session step state ────────────────────────────────────────

    /** The dial string the current session started from (phone already in). */
    @Volatile
    var baseCode: String? = null
        private set

    /** The offer's declared menu steps for the current session. */
    @Volatile
    var steps: List<String> = emptyList()
        private set

    /** How many menu continuations have already been sent (cap: MAX_STEPS). */
    @Volatile
    var stepIndex: Int = 0
        private set

    /** Epoch millis the current step must be answered by (per-step timeout). */
    @Volatile
    var stepDeadline: Long = 0L
        private set

    fun store(text: String) {
        _lastSessionText.value = text
        lastSessionRaw = text
    }

    fun clear() {
        _lastSessionText.value = null
        lastSessionRaw = null
    }

    /**
     * Opens a session for [code]; returns false when the step cap is spent.
     * [stepTimeoutMillis] is remembered so every later [reserveStep] re-arms
     * the same per-step budget.
     */
    @Synchronized
    fun beginSession(code: String, offerSteps: List<String>, stepTimeoutMillis: Long): Boolean {
        baseCode = code
        steps = offerSteps
        stepTimeout = stepTimeoutMillis
        stepIndex = 0
        stepDeadline = System.currentTimeMillis() + stepTimeoutMillis
        return true
    }

    /** Per-step budget recorded by [beginSession]. */
    @Volatile
    var stepTimeout: Long = 0L
        private set

    /**
     * U1 — a menu reply waiting to be typed into the overlay (ADVANCED).
     * Staged by [com.bingwascore.app.services.UssdAutomationService], consumed
     * by [com.bingwascore.app.services.UssdAccessibilityService] exactly once.
     */
    @Volatile
    var pendingInput: String? = null
        private set

    fun stageInput(choice: String) {
        pendingInput = choice
    }

    /** Atomically takes the staged input (null when nothing is waiting). */
    @Synchronized
    fun consumeInput(): String? = pendingInput.also { pendingInput = null }

    /**
     * Reserves the next menu continuation. Returns the choice to send, or null
     * when the session is closed or [UssdSessionEngine.MAX_STEPS] is reached.
     */
    @Synchronized
    fun reserveStep(): String? {
        val code = baseCode ?: return null
        if (code.isBlank() || stepIndex >= UssdSessionEngine.MAX_STEPS) return null
        val choice = UssdSessionEngine.nextChoice(steps, stepIndex)
        stepIndex += 1
        stepDeadline = System.currentTimeMillis() + stepTimeout.coerceAtLeast(1L)
        return choice
    }

    /** True while the current step's timeout has not elapsed yet. */
    val stepActive: Boolean
        get() = baseCode != null && System.currentTimeMillis() <= stepDeadline

    @Synchronized
    fun endSession() {
        baseCode = null
        steps = emptyList()
        stepIndex = 0
        stepDeadline = 0L
    }
}
