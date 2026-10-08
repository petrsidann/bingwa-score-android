package com.bingwascore.app.services

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.engine.UssdSessionEngine
import com.bingwascore.app.domain.engine.UssdSessionHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Locale
import javax.inject.Inject

/**
 * Advanced Mode automation over the USSD overlay.
 *
 * Watches the telephony USSD dialog, captures its full text into
 * [UssdSessionHolder] for the pipeline, and — when the user has selected
 * [AppProcessingMode.ADVANCED] — auto-taps the positive action
 * ("Send", "OK", "Yes" or "1") so multi-step Safaricom flows complete with
 * zero manual tapping.
 */
@AndroidEntryPoint
class UssdAccessibilityService : AccessibilityService() {

    @Inject
    lateinit var userPreferences: UserPreferences

    @Inject
    lateinit var sessionHolder: UssdSessionHolder

    /** Timestamp of the last successful auto-tap (debounce guard). */
    @Volatile
    private var lastTapAt = 0L

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.i("USSD accessibility service connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        try {
            if (event?.eventType != AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
                event?.eventType != AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
            ) {
                return
            }

            val root = rootInActiveWindow ?: return
            if (!root.packageName?.toString().orEmpty().isUssdWindow()) return

            val text = collectText(root)
            if (text.isBlank()) return

            if (text != sessionHolder.lastSessionRaw) {
                sessionHolder.store(text)
                Timber.d("USSD overlay: %s", text.replace('\n', '|'))
            }

            serviceScope.launch {
                try {
                    // Debounce: window-content events arrive in bursts; without this
                    // guard the same dialog could be tapped twice in quick succession.
                    val sinceLast = System.currentTimeMillis() - lastTapAt
                    if (sinceLast < TAP_DEBOUNCE_MILLIS) {
                        Timber.tag("USSD").d(
                            "USSD: auto-tap skipped (debounced, %dms since last)", sinceLast
                        )
                        return@launch
                    }

                    // R5 — both modes are logged so a field report can say exactly
                    // which one was running when a tap did or did not happen.
                    val mode = userPreferences.processingMode.first()
                    if (mode == AppProcessingMode.ADVANCED) {
                        // U1 — a MENU must continue, not die on "Invalid choice":
                        // type the reserved step into the input + press SEND first.
                        if (UssdSessionEngine.isMenu(text)) {
                            val choice = sessionHolder.pendingInput ?: sessionHolder.reserveStep()
                            if (choice != null && sessionHolder.stepActive) {
                                Timber.tag("USSD").i(
                                    "%s accessibility input '%s' tx=%s",
                                    UssdSessionEngine.STEP_TAG, choice, sessionHolder.baseCode
                                )
                                if (enterMenuChoice(root, choice)) {
                                    lastTapAt = System.currentTimeMillis()
                                    return@launch
                                }
                            }
                        }
                        Timber.tag("USSD").i("USSD: ADVANCED auto-tap on `%s`", text.take(40))
                        val tapped = tapPositiveAction(root)
                        Timber.tag("USSD").i(
                            "USSD: ADVANCED auto-tap %s", if (tapped) "delivered" else "no button found"
                        )
                    } else if (UssdSessionEngine.isMenu(text)) {
                        // U1 — EXPRESS: re-dial the appended code (the phone app
                        // owns the current dialog, so a fresh dial carries the reply).
                        val choice = sessionHolder.reserveStep()
                        val base = sessionHolder.baseCode
                        if (choice != null && base != null && sessionHolder.stepActive) {
                            val next = UssdSessionEngine.appendStep(base, choice)
                            Timber.tag("USSD").i(
                                "%s EXPRESS re-dial choice=%s -> %s",
                                UssdSessionEngine.STEP_TAG, choice, next
                            )
                            sessionHolder.beginSession(next, sessionHolder.steps, sessionHolder.stepTimeout)
                            runCatching {
                                startActivity(
                                    android.content.Intent(
                                        android.content.Intent.ACTION_CALL,
                                        android.net.Uri.parse("tel:${android.net.Uri.encode(next)}")
                                    ).addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                                )
                            }
                        } else {
                            Timber.tag("USSD").i("USSD: EXPRESS — no auto-tap, waiting for the agent")
                        }
                    } else {
                        Timber.tag("USSD").i("USSD: EXPRESS — no auto-tap, waiting for the agent")
                    }
                } catch (t: Throwable) {
                    Timber.e(t, "Advanced-mode USSD tap failed")
                }
            }
        } catch (t: Throwable) {
            Timber.e(t, "UssdAccessibilityService event crashed")
        }
    }

    override fun onInterrupt() {
        Timber.w("USSD accessibility service interrupted")
    }

    override fun onDestroy() {
        Timber.i("USSD accessibility service disconnected")
        serviceScope.cancel()
        super.onDestroy()
    }

    /** Only the telephony dialer windows are interesting — never other apps. */
    private fun String.isUssdWindow(): Boolean {
        if (isBlank()) return false
        val lower = lowercase(Locale.ROOT)
        return lower.contains("phone") || lower.contains("telecom") || lower.contains("telephony")
    }

    /** Flatten the whole visible tree into text lines. */
    private fun collectText(node: AccessibilityNodeInfo?): String {
        if (node == null) return ""
        return buildString {
            node.text?.toString()?.trim()?.takeIf { it.isNotEmpty() }?.let { append(it).append('\n') }
            for (i in 0 until node.childCount) {
                node.getChild(i)?.let { append(collectText(it)) }
            }
        }.trim()
    }

    /** Clicks the first visible positive-action button, if any. */
    /** R5 — returns whether a positive action was actually found and clicked. */
    private fun tapPositiveAction(root: AccessibilityNodeInfo): Boolean {
        val targets = mutableListOf<AccessibilityNodeInfo>()
        collectNodes(root, targets)

        val clicked = targets.firstOrNull { node ->
            val label = node.resolveLabel().lowercase(Locale.ROOT)
            POSITIVE_ACTIONS.contains(label)
        }?.let { target ->
            if (target.performAction(AccessibilityNodeInfo.ACTION_CLICK)) {
                lastTapAt = System.currentTimeMillis()
                Timber.i("USSD auto-tapped positive action")
                true
            } else {
                false
            }
        } ?: false

        if (clicked) {
            Timber.d("USSD advanced auto-action fired")
        }
        return clicked
    }

    private fun collectNodes(node: AccessibilityNodeInfo, out: MutableList<AccessibilityNodeInfo>) {
        out.add(node)
        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { collectNodes(it, out) }
        }
    }

    private fun AccessibilityNodeInfo.resolveLabel(): String {
        text?.toString()?.trim()?.takeIf { it.isNotEmpty() }?.let { return it }
        contentDescription?.toString()?.trim()?.takeIf { it.isNotEmpty() }?.let { return it }
        return ""
    }

    /**
     * U1 — types [choice] into the overlay's input field (ACTION_SET_TEXT) and
     * presses SEND, so a multi-step menu continues with zero manual tapping.
     * Returns false when the dialog has no editable input, letting the caller
     * fall back to the plain positive-action tap.
     */
    private fun enterMenuChoice(root: AccessibilityNodeInfo, choice: String): Boolean {
        val nodes = mutableListOf<AccessibilityNodeInfo>()
        collectNodes(root, nodes)
        val input = nodes.firstOrNull { node ->
            node.isEditable && node.className?.contains("EditText", ignoreCase = true) == true
        } ?: return false

        val args = android.os.Bundle().apply { putCharSequence("viewText", choice) }
        if (!input.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, args)) return false

        // The keyboard's SEND/OK (or the dialog's Send button) submits it.
        val sent = nodes.firstOrNull { node ->
            val label = node.resolveLabel().lowercase(Locale.ROOT)
            label == "send" || label == "ok" || label == "done" || label == "yes"
        }?.let { it.performAction(AccessibilityNodeInfo.ACTION_CLICK) } ?: false

        Timber.i("USSD: menu choice '%s' typed (%s)", choice, if (sent) "sent" else "awaiting SEND")
        return true
    }

    companion object {
        /** Standard positive SS/USSD action labels (case-insensitive). */
        private val POSITIVE_ACTIONS = setOf("send", "ok", "yes", "1")

        /** Ignore further auto-taps within this window to avoid double-taps. */
        private const val TAP_DEBOUNCE_MILLIS = 1500L
    }
}
