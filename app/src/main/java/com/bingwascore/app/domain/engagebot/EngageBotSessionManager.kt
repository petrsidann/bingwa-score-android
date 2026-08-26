package com.bingwascore.app.domain.engagebot

import com.bingwascore.app.data.local.AutoReplyDao
import com.bingwascore.app.domain.enums.AutoReplyType
import com.bingwascore.app.domain.intelligence.IntelligenceEngine
import com.bingwascore.app.domain.sms.SmsDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EngageBotSessionManager @Inject constructor(
    private val autoReplyDao: AutoReplyDao,
    private val smsDispatcher: SmsDispatcher
) {

    private data class Session(val phone: String, val startedAt: Long)

    private val sessions = mutableMapOf<String, Session>()
    private val timeoutMs = 10 * 60 * 1000L

    suspend fun onCustomerMessage(phone: String, body: String, customerName: String?) =
        withContext(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            sessions.values.removeAll { now - it.startedAt > timeoutMs }

            val templates = mutableMapOf<AutoReplyType, String>()
            autoReplyDao.getAll().collect { list ->
                list.filter { it.isActive }.forEach { reply ->
                    try {
                        templates[AutoReplyType.valueOf(reply.type)] = reply.message
                    } catch (e: Exception) { }
                }
            }

            val reply = IntelligenceEngine.engageReply(body, templates) ?: return@withContext

            sessions[phone] = Session(phone, now)
            smsDispatcher.send(
                destination = phone,
                template = reply,
                values = mapOf(
                    "firstName" to (customerName?.split(" ")?.firstOrNull() ?: "customer"),
                    "phone" to phone
                )
            )
            Timber.d("EngageBot replied to $phone")
        }
}
