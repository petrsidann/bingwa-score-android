package com.bingwascore.app.services

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import timber.log.Timber

class UssdAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return
        
        // Advanced Mode: Auto-click USSD buttons and input fields
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED || 
            event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            
            val rootNode = rootInActiveWindow ?: return
            processNode(rootNode)
        }
    }

    private fun processNode(node: AccessibilityNodeInfo) {
        // Auto-click "Send" or "OK" buttons in USSD dialogs
        if (node.text?.toString()?.contains("Send", ignoreCase = true) == true ||
            node.text?.toString()?.contains("OK", ignoreCase = true) == true) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            Timber.d("Accessibility: Auto-clicked ${node.text}")
        }

        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { processNode(it) }
        }
    }

    override fun onInterrupt() {
        Timber.d("Accessibility Service Interrupted")
    }
}
