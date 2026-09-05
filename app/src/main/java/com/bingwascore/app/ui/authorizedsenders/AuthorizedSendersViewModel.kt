package com.bingwascore.app.ui.authorizedsenders

import androidx.lifecycle.ViewModel
import com.bingwascore.app.data.preferences.AuthorizedSendersStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthorizedSendersViewModel @Inject constructor(
    private val store: AuthorizedSendersStore
) : ViewModel() {

    val senders: StateFlow<Set<String>> = store.senders

    /**
     * Adds a trusted number. Returns false (and changes nothing) when the
     * input is not a usable number or is already trusted.
     */
    fun addSender(rawNumber: String): Boolean = store.add(rawNumber)

    fun removeSender(number: String) = store.remove(number)
}
