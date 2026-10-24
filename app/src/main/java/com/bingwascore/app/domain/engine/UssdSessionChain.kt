package com.bingwascore.app.domain.engine

import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdResponses

/**
 * Stage 23 — USSD Session Chain parser and execution model.
 *
 * Parses full USSD codes like `*544*1*1*6*<phone>*1#` into root dial code (`*544#`)
 * and ordered segments (`["1", "1", "6", "<phone>", "1"]`).
 *
 * Supports multi-hop auto-submission, 12s timeout per hop with exactly 1 retry per hop,
 * session logging (sent, received, next), and thread-safe manual abort.
 */
data class UssdHopLog(
    val hopIndex: Int,
    val sent: String,
    val received: String,
    val next: String?,
    val timestamp: Long = System.currentTimeMillis()
)

data class UssdChainParsed(
    val rawCode: String,
    val rootDial: String,
    val segments: List<String>
) {
    val totalHops: Int get() = segments.size + 1
}

class UssdSessionChain(
    val parsed: UssdChainParsed,
    val hopTimeoutMillis: Long = HOP_TIMEOUT_MILLIS,
    val maxRetriesPerHop: Int = MAX_RETRIES_PER_HOP
) {

    enum class State {
        IDLE,
        RUNNING,
        AWAITING_RESPONSE,
        COMPLETED,
        FAILED,
        ABORTED
    }

    @Volatile
    var state: State = State.IDLE
        private set

    @Volatile
    var currentHopIndex: Int = 0
        private set

    @Volatile
    var currentRetryCount: Int = 0
        private set

    private val _logs = mutableListOf<UssdHopLog>()
    val logs: List<UssdHopLog>
        @Synchronized get() = _logs.toList()

    @Synchronized
    fun start(): String {
        if (state != State.IDLE) throw IllegalStateException("Chain already started")
        state = State.RUNNING
        currentHopIndex = 0
        currentRetryCount = 0
        return currentHopCode()
    }

    /**
     * Gets the code/choice to send for the current hop.
     * Hop 0 is the root dial code (e.g., `*544#`).
     * Subsequent hops return segment `segments[currentHopIndex - 1]`.
     */
    fun currentHopCode(): String {
        return if (currentHopIndex == 0) {
            parsed.rootDial
        } else {
            parsed.segments.getOrNull(currentHopIndex - 1).orEmpty()
        }
    }

    /**
     * Advances the chain with the received USSD response.
     * Returns the next action to perform:
     * - [HopOutcome.Next] with the segment/code to send next.
     * - [HopOutcome.Retry] with the code to re-send for the current hop.
     * - [HopOutcome.Complete] with the final status and message.
     * - [HopOutcome.Failed] or [HopOutcome.Aborted].
     */
    @Synchronized
    fun onResponse(receivedResponse: String): HopOutcome {
        if (state == State.ABORTED) {
            return HopOutcome.Aborted("Session was aborted by user")
        }
        if (state != State.RUNNING && state != State.AWAITING_RESPONSE) {
            return HopOutcome.Failed("Invalid state $state")
        }

        val currentSent = currentHopCode()
        val isLastHop = currentHopIndex >= parsed.segments.size

        val classified = UssdResponses.classify(receivedResponse)
        val isMenu = UssdSessionEngine.isMenu(receivedResponse)

        if (classified == TransactionStatus.SUCCESSFUL && isLastHop) {
            val logEntry = UssdHopLog(hopIndex = currentHopIndex, sent = currentSent, received = receivedResponse, next = null)
            _logs.add(logEntry)
            state = State.COMPLETED
            return HopOutcome.Complete(TransactionStatus.SUCCESSFUL, receivedResponse)
        }

        if (classified == TransactionStatus.FAILED_ALREADY_RECOMMENDED) {
            val logEntry = UssdHopLog(hopIndex = currentHopIndex, sent = currentSent, received = receivedResponse, next = null)
            _logs.add(logEntry)
            state = State.FAILED
            return HopOutcome.Complete(TransactionStatus.FAILED_ALREADY_RECOMMENDED, receivedResponse)
        }

        if (!isMenu && classified == TransactionStatus.FAILED) {
            val logEntry = UssdHopLog(hopIndex = currentHopIndex, sent = currentSent, received = receivedResponse, next = null)
            _logs.add(logEntry)
            if (currentRetryCount < maxRetriesPerHop) {
                currentRetryCount++
                state = State.AWAITING_RESPONSE
                return HopOutcome.Retry(currentHopCode(), "Hop failed; retrying ($currentRetryCount/$maxRetriesPerHop)")
            }
            state = State.FAILED
            return HopOutcome.Complete(TransactionStatus.FAILED, receivedResponse)
        }

        if (!isLastHop) {
            val nextCode = parsed.segments.getOrNull(currentHopIndex)
            val logEntry = UssdHopLog(
                hopIndex = currentHopIndex,
                sent = currentSent,
                received = receivedResponse,
                next = nextCode
            )
            _logs.add(logEntry)

            currentHopIndex++
            currentRetryCount = 0
            state = State.AWAITING_RESPONSE
            val nextHopChoice = currentHopCode()
            return HopOutcome.Next(nextHopChoice, logEntry)
        } else {
            val logEntry = UssdHopLog(hopIndex = currentHopIndex, sent = currentSent, received = receivedResponse, next = null)
            _logs.add(logEntry)
            val finalStatus = if (classified != TransactionStatus.PENDING) classified else TransactionStatus.SUCCESSFUL
            state = State.COMPLETED
            return HopOutcome.Complete(finalStatus, receivedResponse)
        }
    }

    /**
     * Called on per-hop timeout. Triggers a retry if retries remain, else fails.
     */
    @Synchronized
    fun onTimeout(): HopOutcome {
        if (state == State.ABORTED) {
            return HopOutcome.Aborted("Session was aborted by user")
        }
        if (currentRetryCount < maxRetriesPerHop) {
            currentRetryCount++
            state = State.AWAITING_RESPONSE
            return HopOutcome.Retry(currentHopCode(), "12s timeout on hop $currentHopIndex; retrying ($currentRetryCount/$maxRetriesPerHop)")
        }
        state = State.FAILED
        return HopOutcome.Failed("12s hop timeout exceeded for hop $currentHopIndex")
    }

    @Synchronized
    fun abort(): HopOutcome {
        state = State.ABORTED
        return HopOutcome.Aborted("Session aborted by user")
    }

    sealed interface HopOutcome {
        data class Next(val nextSegment: String, val log: UssdHopLog) : HopOutcome
        data class Retry(val codeToResend: String, val reason: String) : HopOutcome
        data class Complete(val status: TransactionStatus, val response: String) : HopOutcome
        data class Failed(val reason: String) : HopOutcome
        data class Aborted(val reason: String) : HopOutcome
    }

    companion object {
        const val HOP_TIMEOUT_MILLIS = 12_000L
        const val MAX_RETRIES_PER_HOP = 1

        /**
         * Parses a USSD string into a [UssdChainParsed].
         * e.g., `*544*1*1*6*0712345678*1#` ->
         * rootDial = `*544#`, segments = `["1", "1", "6", "0712345678", "1"]`.
         * e.g., `*544#` -> rootDial = `*544#`, segments = `[]`.
         */
        fun parse(code: String, phone: String = ""): UssdChainParsed {
            val formatted = UssdSessionEngine.generateDialString(code.trim(), phone.trim())
            if (!formatted.startsWith("*")) {
                return UssdChainParsed(rawCode = code, rootDial = formatted, segments = emptyList())
            }

            val hasHash = formatted.endsWith("#")
            val clean = if (hasHash) formatted.drop(1).dropLast(1) else formatted.drop(1)
            val parts = clean.split('*').filter { it.isNotBlank() }

            if (parts.isEmpty()) {
                return UssdChainParsed(rawCode = code, rootDial = formatted, segments = emptyList())
            }

            val rootCode = "*${parts.first()}#"
            val segs = parts.drop(1)

            return UssdChainParsed(
                rawCode = code,
                rootDial = rootCode,
                segments = segs
            )
        }
    }
}
