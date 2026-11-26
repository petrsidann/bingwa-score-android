package com.bingwascore.app.ui.community

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class CommunityPost(
    val author: String,
    val initials: String,
    val body: String,
    val likes: Int,
    val liked: Boolean
)

data class CommunityScreenState(
    val agentsOnline: Int = 212,
    val yourRank: Int = 48,
    val streakDays: Int = 1,
    val posts: List<CommunityPost> = listOf(
        CommunityPost(
            author = "AgentKen",
            initials = "AK",
            body = "120 dials today with autopilot. The retry queue saved six sales.",
            likes = 14,
            liked = false
        ),
        CommunityPost(
            author = "WanjikuB",
            initials = "WB",
            body = "SiteLink orders auto-match now. Zero manual entry this week.",
            likes = 9,
            liked = false
        ),
        CommunityPost(
            author = "MwangiD",
            initials = "MD",
            body = "Pin your best Data offer first. Conversion doubled.",
            likes = 21,
            liked = true
        )
    )
)

@HiltViewModel
class CommunityViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CommunityScreenState())
    val state: StateFlow<CommunityScreenState> = _state.asStateFlow()

    fun toggleLike(index: Int) {
        _state.value = _state.value.copy(
            posts = _state.value.posts.toMutableList().also { list ->
                val post = list[index]
                list[index] = post.copy(
                    liked = !post.liked,
                    likes = if (post.liked) post.likes - 1 else post.likes + 1
                )
            }
        )
    }
}
