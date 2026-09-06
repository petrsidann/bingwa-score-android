package com.bingwascore.app.announcements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnnouncementsViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val seed = listOf(
        Announcement("a1", "Today", "Welcome to Bingwa Score!",
            "Your bundle business is now on autopilot. Watch for M-Pesa confirmations and we'll handle the rest.", true),
        Announcement("a2", "Tip", "Use the dialer for fast purchases",
            "Tap the center dialer button to quickly buy bundles for any customer. One tap, done.", true),
        Announcement("a3", "Tip", "Track your growth",
            "Check your Score tab to see your level, streak and achievements. Sell more to level up!", true)
    )

    val announcements: StateFlow<List<Announcement>> = kotlinx.coroutines.flow.flow {
        val seeded = userPreferences.announcementsSeeded.first()
        if (!seeded) {
            userPreferences.setAnnouncementsSeeded(true)
        }
        emit(seed)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), seed)
}
