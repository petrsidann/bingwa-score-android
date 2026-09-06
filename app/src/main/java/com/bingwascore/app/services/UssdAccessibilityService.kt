package com.bingwascore.app.services

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.AppProcessingMode
import com.bingwascore.app.domain.engine.UssdSessionHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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
                    if (userPreferences.processingMode.first() == AppProcessingMode.ADVANCED) {
                        tapPositiveAction(root)
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
    private fun tapPositiveAction(root: AccessibilityNodeInfo) {
        val targets = mutableListOf<AccessibilityNodeInfo>()
        collectNodes(root, targets)

        val clicked = targets.firstOrNull { node ->
            val label = node.resolveLabel().lowercase(Locale.ROOT)
            POSITIVE_ACTIONS.contains(label)
        }?.let { target ->
            if (target.performAction(AccessibilityNodeInfo.ACTION_CLICK)) {
                Timber.i("USSD auto-tapped positive action")
                true
            } else {
                false
            }
        } ?: false

        if (clicked) {
            Timber.d("USSD advanced auto-action fired")
        }
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

    companion object {
        /** Standard positive SS/USSD action labels (case-insensitive). */
        private val POSITIVE_ACTIONS = setOf("send", "ok", "yes", "1")
    }
}