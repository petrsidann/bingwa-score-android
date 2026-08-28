package com.bingwascore.app.domain.engagebot

import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.settings.AppSetting
import com.bingwascore.app.data.settings.SettingsRepository
import com.bingwascore.app.domain.sms.SmsDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EngageBotSessionLifecycle @Inject constructor(
    private val autoReplyDao: AutoReplyDao,
    private val customerDao: CustomerDao,
    private val smsDispatcher: SmsDispatcher,
    private val settingsRepository: SettingsRepository
) {

    data class Session(
        val phone: String,
        val transactionId: String?,
        val startedAt: Long,
        var lastActivity: Long,
        val engagedAmount: Int
    )

    data class BotLog(
        val phone: String,
        val customerName: String?,
        val received: String?,
        val sent: String,
        val time: Long
    )

    private val sessions = mutableMapOf<String, Session>()
    private val _logs = MutableStateFlow<List<BotLog>>(emptyList())
    val logs: StateFlow<List<BotLog>> = _logs.asStateFlow()

    private val timeoutMs = 10 * 60 * 1000L
    private val phoneRegex = Regex("(0\\d{9}|\\+?254\\d{9})")

    private val ENGAGE_MESSAGE = "You have already purchased a Bingwa Offer today. Please reply with an alternative Safaricom number to recommend instead"
    private val SUCCESS_RESPONSE = "Thank you. Recommending offer to @phone instead"
    private val INVALID_INPUT = "Invalid input. Please try again"
    private val TIMEOUT_RESPONSE = "Session Auto-Closed. Thank you for using Bingwa Score"

    fun isEnabled(): Boolean = settingsRepository.getBoolean(AppSetting.ENGAGE_BOT_ACTIVE, false)

    fun hasActiveSession(phone: String): Boolean {
        val now = System.currentTimeMillis()
        val s = sessions[normalize(phone)] ?: return false
        return now - s.lastActivity <= timeoutMs
    }

    suspend fun engageForTransaction(phone: String, customerName: String?, amount: Int, transactionId: String) =
        withContext(Dispatchers.IO) {
            val p = normalize(phone)
            val now = System.currentTimeMillis()
            sessions[p] = Session(p, transactionId, now, now, amount)
            send(p, ENGAGE_MESSAGE)
            log(p, customerName, "M-Pesa payment Ksh$amount (already recommended)", ENGAGE_MESSAGE)
            Timber.d("EngageBot started for $p")
        }

    suspend fun onCustomerMessage(phone: String, body: String): Boolean = withContext(Dispatchers.IO) {
        val p = normalize(phone)
        val session = sessions[p] ?: return@withContext false
        val now = System.currentTimeMillis()
        if (now - session.lastActivity > timeoutMs) {
            sessions.remove(p)
            return@withContext false
        }
        session.lastActivity = now

        val match = phoneRegex.find(body)
        val customer = customerDao.getCustomerByPhone(p)
        if (match != null) {
            val altPhone = match.value
            val text = SUCCESS_RESPONSE.replace("@phone", altPhone)
            send(p, text)
            sessions.remove(p)
            log(p, customer?.name, body, text)
            Timber.d("EngageBot redirected $p to $altPhone")
        } else {
            send(p, INVALID_INPUT)
            log(p, customer?.name, body, INVALID_INPUT)
        }
        true
    }

    suspend fun expireAll() = withContext(Dispatchers.IO) {
        val now = System.currentTimeMillis()
        val expired = sessions.values.filter { now - it.lastActivity > timeoutMs }
        expired.forEach { s ->
            send(s.phone, TIMEOUT_RESPONSE)
            log(s.phone, null, null, TIMEOUT_RESPONSE)
            sessions.remove(s.phone)
        }
        if (expired.isNotEmpty()) Timber.d("EngageBot expired ${expired.size} sessions")
    }

    private suspend fun send(phone: String, text: String) {
        try {
            smsDispatcher.send(phone, text, emptyMap())
        } catch (e: Exception) {
            Timber.e(e, "EngageBot send failed")
        }
    }

    private fun log(phone: String, name: String?, received: String?, sent: String) {
        val entry = BotLog(phone, name, received, sent, System.currentTimeMillis())
        _logs.value = (listOf(entry) + _logs.value).take(50)
    }

    private fun normalize(phone: String): String = phone.replace(" ", "").replace("-", "")
}
