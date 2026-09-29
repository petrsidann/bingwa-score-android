package com.bingwascore.app.ui.engagebot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.engagebot.BotLog
import com.bingwascore.app.engagebot.EngageBotSessionLifecycle
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/** State for the Engage Bot screen: master switch + live bot activity. */
@HiltViewModel
class EngageBotViewModel @Inject constructor(
    private val prefs: UserPreferences,
    botLifecycle: EngageBotSessionLifecycle
) : ViewModel() {

    /** Engage Bot master switch, backed by UserPreferences. */
    val isEnabled: StateFlow<Boolean> = prefs.engageBotActive
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    /** Live bot conversation log from the session lifecycle. */
    val logs: StateFlow<List<BotLog>> = botLifecycle.logs
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setEnabled(value: Boolean) {
        viewModelScope.launch { prefs.setEngageBotActive(value) }
    }
}