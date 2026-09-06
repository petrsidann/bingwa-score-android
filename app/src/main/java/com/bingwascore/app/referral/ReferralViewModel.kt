package com.bingwascore.app.referral

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReferralViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    val referralCode: StateFlow<String> = userPreferences.referralCode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val referralCount: StateFlow<Int> = userPreferences.referralCount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val storeLink: StateFlow<String> = userPreferences.storeLink
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val userName: StateFlow<String> = userPreferences.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "Bingwa User")

    init {
        viewModelScope.launch {
            val existing = userPreferences.referralCode.first()
            if (existing.isEmpty()) {
                val name = userPreferences.userName.first()
                val code = slugify(name).uppercase().ifEmpty { "AGENT" }
                userPreferences.setReferralCode(code)
            }
        }
    }

    fun recordShare() {
        viewModelScope.launch {
            val current = userPreferences.referralCount.first()
            userPreferences.setReferralCount(current + 1)
        }
    }

    private fun slugify(name: String): String =
        name.trim().lowercase().replace(Regex("[^a-z0-9]+"), "-").trim('-')
}
