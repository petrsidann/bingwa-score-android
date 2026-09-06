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

    fun store(text: String) {
        _lastSessionText.value = text
        lastSessionRaw = text
    }

    fun clear() {
        _lastSessionText.value = null
        lastSessionRaw = null
    }
}