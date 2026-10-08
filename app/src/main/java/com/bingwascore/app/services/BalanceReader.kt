package com.bingwascore.app.services

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Handler
import android.os.Looper
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import com.bingwascore.app.data.preferences.UserPreferences
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean

/**
 * POLISH P1 — the ONE silent `*144#` balance reader.
 *
 * Every balance surface in the app (Home foreground refresh, the 30-minute
 * WorkManager sweep, the pull-to-refresh button) goes through here, so there is
 * a single definition of "read the airtime balance":
 *
 * - **Never a UI pop.** The request is issued with
 *   [TelephonyManager.sendUssdRequest] on the **main looper**, which the
 *   platform requires, and the network reply is handed straight back to the
 *   caller. No USSD dialog, no system toast, nothing the agent has to dismiss.
 * - **Default-subscription fallback.** The SIM chosen in Settings wins when it
 *   maps to a real subscription id; otherwise the system default is used, and a
 *   failure on the preferred SIM is retried **exactly once** on the default.
 * - **Permission pre-check.** `CALL_PHONE` + `READ_PHONE_STATE` are checked
 *   before the request; when either is missing the caller is told the same
 *   sentence instead of a raw framework failure code.
 */
object BalanceReader {

    /** The Safaricom airtime-balance short code. */
    const val USSD_CODE = "*144#"

    /** Every USSD log line carries this tag: `adb logcat -s USSD`. */
    const val TAG = "USSD"

    /** The one sentence the agent ever reads when the balance cannot be read. */
    const val UNAVAILABLE_MESSAGE = "Balance unavailable - run Diagnostics"

    /** Shown when the handset has no telephony service at all. */
    const val NO_TELEPHONY_MESSAGE = "Balance unavailable - no telephony service"

    private const val DEFAULT_TIMEOUT_MILLIS = 20_000L

    /**
     * The framework's generic USSD failure code. Used only as a log value when
     * the platform refuses the request outright — the agent never sees a code.
     */
    private const val USSD_FAILURE_GENERIC = 1

    /**
     * Primary pattern: Safaricom's `*144#` reply labels the line
     * `"Airtime Bal: 1,234.56 Ksh..."` — match across the label so a reply that
     * also contains other Ksh figures still yields the airtime balance.
     */
    private const val BALANCE_REGEX = "Airtime Bal\\s*:.*?Ksh\\.?\\s*([\\d,]+\\.\\d{2})"

    /**
     * Same label, currency-first wording ("Airtime Bal: Ksh 87.50"), which is
     * what some firmware builds return after a localisation update.
     */
    private const val BALANCE_REGEX_CURRENCY_FIRST = "Airtime Bal\\s*:\\s*(?:Ksh\\.?\\s*)?([\\d,]+\\.\\d{2})"

    /** Fallback for providers that omit the "Airtime Bal:" label entirely. */
    private const val BALANCE_REGEX_FALLBACK = "Ksh\\.?\\s?([\\d,]+\\.\\d{2})"

    private val log = Timber.tag(TAG)

    /** The result of one silent read. */
    sealed interface Outcome {
        /** The reply parsed. [raw] is the operator's exact text, kept for the UI. */
        data class Ok(val amount: Double, val raw: String) : Outcome

        /** The read could not complete; [reason] is agent-facing, never a code. */
        data class Failed(val reason: String) : Outcome
    }

    /**
     * Extracts the airtime balance from a `*144#` reply.
     *
     * Tries the labelled pattern first ("Airtime Bal: 1,234.56 Ksh") because a
     * real reply can carry several Ksh figures; falls back to a bare "Ksh 12.34"
     * match for providers that omit the label. Returns null when neither
     * matches so the caller can report a failure instead of showing 0.00.
     */
    fun parse(response: String?): Double? {
        if (response.isNullOrBlank()) return null
        Regex(BALANCE_REGEX).find(response)?.let { return it.digitsAsDouble() }
        Regex(BALANCE_REGEX_CURRENCY_FIRST).find(response)?.let { return it.digitsAsDouble() }
        Regex(BALANCE_REGEX_FALLBACK).find(response)?.let { return it.digitsAsDouble() }
        return null
    }

    /** "1,234.56" -> 1234.56 (null when unparseable). */
    private fun MatchResult.digitsAsDouble(): Double? =
        groupValues.getOrNull(1)?.replace(",", "")?.toDoubleOrNull()

    /** True when the balance path still needs a runtime grant. */
    fun missingPermissions(context: Context): List<String> = REQUIRED_PERMISSIONS.filter {
        ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
    }

    private val REQUIRED_PERMISSIONS = arrayOf(
        Manifest.permission.CALL_PHONE,
        Manifest.permission.READ_PHONE_STATE
    )

    /**
     * Dials `*144#` in the background and answers exactly once.
     *
     * [onOutcome] is always invoked on the **main looper**, exactly once, either
     * with the parsed balance or with an agent-facing reason. It can never hang:
     * [timeoutMillis] is a hard ceiling that also covers a carrier that simply
     * never answers.
     */
    @SuppressLint("MissingPermission")
    fun read(
        context: Context,
        simSelection: String = UserPreferences.SIM_1,
        timeoutMillis: Long = DEFAULT_TIMEOUT_MILLIS,
        onOutcome: (Outcome) -> Unit
    ) {
        val handler = Handler(Looper.getMainLooper())
        val settled = AtomicBoolean(false)

        fun finish(outcome: Outcome) {
            if (!settled.compareAndSet(false, true)) return
            handler.removeCallbacksAndMessages(null)
            onOutcome(outcome)
        }

        handler.post {
            if (missingPermissions(context).isNotEmpty()) {
                log.w("USSD: balance skipped, phone permissions missing")
                finish(Outcome.Failed(UNAVAILABLE_MESSAGE))
                return@post
            }

            val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            if (telephony == null) {
                finish(Outcome.Failed(NO_TELEPHONY_MESSAGE))
                return@post
            }

            val defaultSub = runCatching { SubscriptionManager.getDefaultSubscriptionId() }
                .getOrDefault(SubscriptionManager.INVALID_SUBSCRIPTION_ID)
            val preferredSub = resolveSimSubscription(context, simSelection, defaultSub)

            val timeout = Runnable { finish(Outcome.Failed(UNAVAILABLE_MESSAGE)) }
            handler.postDelayed(timeout, timeoutMillis)

            fun send(manager: TelephonyManager, label: String, onFailed: (Int) -> Unit) {
                try {
                    log.i("USSD: balance request on subscription %s (%s)", label, simSelection)
                    manager.sendUssdRequest(
                        USSD_CODE,
                        object : TelephonyManager.UssdResponseCallback() {
                            override fun onReceiveUssdResponse(
                                telephonyManager: TelephonyManager,
                                request: String?,
                                response: CharSequence?
                            ) {
                                val raw = response?.toString().orEmpty()
                                val parsed = parse(raw)
                                if (parsed == null) {
                                    log.w("USSD: unreadable balance reply: %s", raw)
                                    finish(Outcome.Failed(UNAVAILABLE_MESSAGE))
                                } else {
                                    log.i("USSD: balance ok (%s) = %.2f", label, parsed)
                                    finish(Outcome.Ok(parsed, raw))
                                }
                            }

                            override fun onReceiveUssdResponseFailed(
                                telephonyManager: TelephonyManager,
                                request: String?,
                                failureCode: Int
                            ) {
                                onFailed(failureCode)
                            }
                        },
                        handler
                    )
                } catch (t: Throwable) {
                    log.e(t, "USSD: balance request threw")
                    onFailed(USSD_FAILURE_GENERIC)
                }
            }

            val scoped = managerForSubscription(telephony, preferredSub)
            send(scoped, "sub=$preferredSub") { code ->
                log.w("USSD: balance failed on %s (code %d)", simSelection, code)
                if (preferredSub != defaultSub) {
                    // One retry, always on the default subscription.
                    log.i("USSD: retrying balance on default subscription %s", defaultSub)
                    send(managerForSubscription(telephony, defaultSub), "default=$defaultSub") {
                        finish(Outcome.Failed(UNAVAILABLE_MESSAGE))
                    }
                } else {
                    finish(Outcome.Failed(UNAVAILABLE_MESSAGE))
                }
            }
        }
    }

    /**
     * REBRAND R5 — maps "SIM 1" / "SIM 2" onto a real subscription id. Anything
     * that cannot be resolved (single-SIM handset, revoked slot) falls back to
     * the system default, which is the classic silent-dial killer on dual-SIM.
     */
    private fun resolveSimSubscription(
        context: Context,
        selected: String,
        defaultSub: Int
    ): Int {
        if (selected != UserPreferences.SIM_2) return defaultSub
        val slots = runCatching {
            context.getSystemService(SubscriptionManager::class.java)?.activeSubscriptionInfoList
        }.getOrNull()
        return slots?.getOrNull(1)?.subscriptionId
            ?.takeIf { it != SubscriptionManager.INVALID_SUBSCRIPTION_ID }
            ?: defaultSub
    }

    private fun managerForSubscription(base: TelephonyManager, subscriptionId: Int): TelephonyManager =
        if (subscriptionId == SubscriptionManager.INVALID_SUBSCRIPTION_ID) {
            base
        } else {
            runCatching { base.createForSubscriptionId(subscriptionId) }.getOrDefault(base)
        }
}
