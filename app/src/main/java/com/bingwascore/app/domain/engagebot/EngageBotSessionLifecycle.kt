package com.bingwascore.app.domain.engagebot

import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.domain.enums.AutoReplyType
import com.bingwascore.app.domain.sms.SmsDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EngageBotSessionLifecycle @Inject constructor(
    private val autoReplyDao: AutoReplyDao,
    private val smsDispatcher: SmsDispatcher
) {

    private data class Session(val phone: String, val startedAt: Long, var lastActivity: Long)
    private val sessions = ConcurrentHashMap<String, Session>()
    private val timeoutMs = 10 * 60 * 1000L // 10 minutes

    suspend fun onCustomerMessage(phone: String, body: String, customerName: String?) = withContext(Dispatchers.IO) {
        val now = System.currentTimeMillis()
        
        // Cleanup expired sessions
        sessions.entries.removeAll { now - it.value.lastActivity > timeoutMs }

        val session = sessions.getOrPut(phone) { Session(phone, now, now) }
        session.lastActivity = now

        // Load active templates
        val templates = mutableMapOf<AutoReplyType, String>()
        autoReplyDao.getAll().collect { list ->
            list.filter { it.isActive }.forEach { reply ->
                try {
                    templates[AutoReplyType.valueOf(reply.type)] = reply.message
                } catch (e: Exception) { }
            }
        }

        // Determine reply based on keywords (Intelligent USSD logic)
        val lower = body.lowercase()
        val type = when {
            lower.contains("not received") || lower.contains("failed") || lower.contains("problem") -> AutoReplyType.FAILED_REQUEST
            lower.contains("thank") -> AutoReplyType.SUCCESSFUL_RESPONSE
            lower.contains("price") || lower.contains("offer") || lower.contains("bundle") -> AutoReplyType.UNAVAILABLE_OFFER
            else -> null
        }

        val replyTemplate = type?.let { templates[it] } ?: return@withContext

        // Replace placeholders: <firstName>, @phone, etc.
        val firstName = customerName?.split(" ")?.firstOrNull() ?: "customer"
        val finalMessage = replyTemplate
            .replace("<firstName>", firstName, ignoreCase = true)
            .replace("<phone>", phone, ignoreCase = true)
            .replace("@phone", phone)

        smsDispatcher.send(phone, finalMessage, emptyMap())
        Timber.d("EngageBot replied to $phone: $finalMessage")
    }

    fun endSession(phone: String) {
        sessions.remove(phone)
    }
}
