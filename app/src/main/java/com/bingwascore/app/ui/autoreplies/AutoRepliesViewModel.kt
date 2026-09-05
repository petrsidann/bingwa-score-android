package com.bingwascore.app.ui.autoreplies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.repository.AutoReplyRepository
import com.bingwascore.app.engagebot.BotLog
import com.bingwascore.app.engagebot.EngageBotSessionLifecycle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AutoRepliesViewModel @Inject constructor(
    private val autoReplyRepository: AutoReplyRepository,
    private val userPreferences: UserPreferences,
    botLifecycle: EngageBotSessionLifecycle
) : ViewModel() {

    val templates: StateFlow<List<AutoReply>> =
        autoReplyRepository.allAutoReplies.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    /** Engage Bot master switch (UserPreferences.engage_bot_active). */
    val engageBotActive: StateFlow<Boolean> =
        userPreferences.engageBotActive.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), false
        )

    /** Live bot conversation log from the session lifecycle. */
    val botLogs: StateFlow<List<BotLog>> =
        botLifecycle.logs.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
        )

    fun setEngageBotActive(value: Boolean) {
        viewModelScope.launch {
            try {
                userPreferences.setEngageBotActive(value)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to toggle engage bot")
            }
        }
    }

    fun toggleTemplate(template: AutoReply) {
        viewModelScope.launch {
            try {
                autoReplyRepository.setActive(template.id, !template.isActive)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to toggle template %s", template.id)
            }
        }
    }

    fun saveTemplate(template: AutoReply) {
        viewModelScope.launch {
            try {
                autoReplyRepository.update(template)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to save template %s", template.id)
            }
        }
    }
}
