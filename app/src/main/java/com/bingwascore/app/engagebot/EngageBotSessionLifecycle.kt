package com.bingwascore.app.engagebot

import android.content.Context
import android.os.Build
import android.telephony.SmsManager
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

/** A customer currently being engaged by the bot. */
data class BotSession(
    val phone: String,
    val customerName: String?,
    val transactionId: String?,
    val engagedAmount: Double,
    val startedAt: Long,
    val lastActivity: Long
)

/** Severity/source of a bot activity line. */
enum class BotLogKind { ENGAGE, SUCCESS, INVALID, INFO, ERROR }

/** One line of bot activity shown in the Botted Replies screen. */
data class BotLog(
    val id: Long,
    val timestamp: Long,
    val phone: String?,
    val message: String,
    val kind: BotLogKind
)

/**
 * Tracks which customers the Engage Bot is currently talking to and drives the
 * bot SMS conversation.
 *
 * A session is opened per transaction via [engageForTransaction]; the customer
 * is asked for the number to buy for. Their reply lands in
 * [onCustomerMessage] — an alternate phone (0XXXXXXXXX / 254XXXXXXXXX) closes
 * the session with a success SMS, anything else gets a retry prompt. Sessions
 * idle for more than [SESSION_TIMEOUT_MILLIS] are dropped by [expireAll].
 */
@Singleton
class EngageBotSessionLifecycle @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferences: UserPreferences
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val sessions = ConcurrentHashMap<String, BotSession>()
    private val logIds = AtomicLong(0)

    private val altPhoneRegex = Regex("0\\d{9}|254\\d{9}")

    private val _logs = MutableStateFlow<List<BotLog>>(emptyList())
    val logs: StateFlow<List<BotLog>> = _logs.asStateFlow()

    /** The Engage Bot master switch, backed by UserPreferences. */
    suspend fun isEnabled(): Boolean =
        try {
            userPreferences.engageBotActive.first()
        } catch (t: Throwable) {
            Timber.e(t, "Failed to read engage bot switch")
            false
        }

    /** Opens a session and sends the engage SMS for a completed sale. */
    fun engageForTransaction(phone: String, name: String?, amount: Double, txId: String) {
        scope.launch {
            try {
                expireAll()
                if (!isEnabled()) {
                    addLog(phone, "Engage bot is off — skipped $phone", BotLogKind.INFO)
                    return@launch
                }
                val now = System.currentTimeMillis()
                sessions[phone] = BotSession(
                    phone = phone,
                    customerName = name,
                    transactionId = txId,
                    engagedAmount = amount,
                    startedAt = now,
                    lastActivity = now
                )
                sendSms(
                    phone,
                    "Hi ${name ?: "there"}! Thanks for your Ksh ${amount.toInt()} purchase. " +
                        "Reply with the number to buy for (e.g. 07XXXXXXXX) and we'll sort you out. - Bingwa Score"
                )
                addLog(
                    phone,
                    "Engaged ${name ?: phone} for Ksh ${amount.toInt()} (tx ${txId.takeLast(8)})",
                    BotLogKind.ENGAGE
                )
            } catch (t: Throwable) {
                Timber.e(t, "engageForTransaction failed for %s", phone)
                addLog(phone, "Engage failed for $phone: ${t.message}", BotLogKind.ERROR)
            }
        }
    }

    /**
     * Handles an inbound customer reply: an alternate phone number closes the
     * session with a success SMS, anything else gets a retry prompt.
     */
    fun onCustomerMessage(phone: String, body: String) {
        scope.launch {
            try {
                expireAll()
                val session = sessions[phone] ?: return@launch
                sessions[phone] = session.copy(lastActivity = System.currentTimeMillis())

                val altPhone = altPhoneRegex.find(body)?.value
                if (altPhone != null) {
                    sessions.remove(phone)
                    sendSms(
                        altPhone,
                        "Asante! Your Ksh ${session.engagedAmount.toInt()} bundle is on its way to " +
                            "$altPhone. Thank you for choosing Bingwa Score."
                    )
                    addLog(
                        phone,
                        "Alt number $altPhone captured for ${session.customerName ?: phone} — session complete",
                        BotLogKind.SUCCESS
                    )
                } else {
                    sendSms(
                        phone,
                        "Sorry, we didn't get that. Reply with the number to buy for, e.g. 07XXXXXXXX. - Bingwa Score"
                    )
                    addLog(phone, "Invalid reply from $phone — asked to retry", BotLogKind.INVALID)
                }
            } catch (t: Throwable) {
                Timber.e(t, "onCustomerMessage failed for %s", phone)
                addLog(phone, "Failed handling message from $phone: ${t.message}", BotLogKind.ERROR)
            }
        }
    }

    /** Ends every session idle for longer than [SESSION_TIMEOUT_MILLIS]. */
    fun expireAll() {
        try {
            val now = System.currentTimeMillis()
            sessions.values
                .filter { now - it.lastActivity > SESSION_TIMEOUT_MILLIS }
                .forEach { session ->
                    sessions.remove(session.phone)
                    addLog(
                        session.phone,
                        "Session with ${session.customerName ?: session.phone} expired",
                        BotLogKind.INFO
                    )
                }
        } catch (t: Throwable) {
            Timber.e(t, "expireAll failed")
        }
    }

    fun activeSessionCount(): Int = sessions.size

    private fun sendSms(phone: String, body: String) {
        try {
            val smsManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                context.getSystemService(SmsManager::class.java)
            } else {
                @Suppress("DEPRECATION")
                SmsManager.getDefault()
            }
            if (smsManager == null) {
                Timber.w("SmsManager unavailable — bot SMS not sent to %s", phone)
                return
            }
            smsManager.sendTextMessage(phone, null, body, null, null)
            Timber.d("Bot SMS sent to %s", phone)
        } catch (t: Throwable) {
            // Missing SEND_SMS runtime permission, no SIM, invalid number, etc.
            Timber.e(t, "Failed to send bot SMS to %s", phone)
        }
    }

    private fun addLog(phone: String?, message: String, kind: BotLogKind) {
        try {
            val log = BotLog(
                id = logIds.incrementAndGet(),
                timestamp = System.currentTimeMillis(),
                phone = phone,
                message = message,
                kind = kind
            )
            _logs.update { current -> (listOf(log) + current).take(MAX_LOGS) }
        } catch (t: Throwable) {
            Timber.e(t, "Failed to record bot log")
        }
    }


    companion object {
        const val SESSION_TIMEOUT_MILLIS = 10L * 60 * 1000

        private const val MAX_LOGS = 100
    }
}
