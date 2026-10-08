package com.bingwascore.app.services

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import com.bingwascore.app.util.EngineLog

/** E1 — the 6 on-screen engine checks + the 8s silent USSD ping. */
object EngineDiagnostics {

    data class Check(val name: String, val passed: Boolean, val detail: String)

    fun subscriptionInfo(context: Context): Pair<Int, String> {
        val subId = runCatching { SubscriptionManager.getDefaultSubscriptionId() }.getOrDefault(-1)
        val opName = runCatching {
            val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            (tm?.networkOperatorName ?: tm?.simOperatorName).orEmpty()
        }.getOrDefault("")
        return subId to opName
    }

    fun isAccessibilityEnabled(context: Context): Boolean {
        val expected = ComponentName(context, UssdAccessibilityService::class.java).flattenToString()
        val enabled = Settings.Secure.getString(
            context.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        ).orEmpty()
        return enabled.split(':').any { it.equals(expected, ignoreCase = true) }
    }

    fun runSync(context: Context): List<Check> {
        val callOk = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) ==
            PackageManager.PERMISSION_GRANTED
        val readOk = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) ==
            PackageManager.PERMISSION_GRANTED
        val (subId, opName) = subscriptionInfo(context)
        val subOk = subId != SubscriptionManager.INVALID_SUBSCRIPTION_ID && subId >= 0
        val accOk = isAccessibilityEnabled(context)
        val list = listOf(
            Check("CALL_PHONE", callOk, if (callOk) "granted" else "not granted"),
            Check("READ_PHONE_STATE", readOk, if (readOk) "granted" else "not granted"),
            Check("Subscription", subOk, "sub=$subId op=${opName.ifBlank { "?" }}"),
            Check("Accessibility", accOk, if (accOk) "enabled" else "disabled"),
        )
        list.forEach { EngineLog.append(context, "DIAG ${it.name}=${if (it.passed) "PASS" else "FAIL"} ${it.detail}") }
        return list
    }

    /** Silent *144# ping; reports callback code within 8s. */
    fun pingUssd(context: Context, onDone: (code: Int, ok: Boolean, detail: String) -> Unit) {
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
        if (tm == null) {
            EngineLog.append(context, "DIAG USSD=FAIL no-telephony")
            onDone(-1, false, "no telephony"); return
        }
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            EngineLog.append(context, "DIAG USSD=FAIL no-permission")
            onDone(-1, false, "no permission"); return
        }
        val handler = Handler(Looper.getMainLooper())
        var done = false
        val timeout = Runnable {
            if (!done) {
                done = true
                EngineLog.append(context, "DIAG USSD=FAIL timeout-8s")
                onDone(-2, false, "timeout 8s")
            }
        }
        handler.postDelayed(timeout, 8_000L)
        runCatching {
            tm.sendUssdRequest(
                BalanceReader.USSD_CODE,
                object : TelephonyManager.UssdResponseCallback() {
                    override fun onReceiveUssdResponse(t: TelephonyManager?, r: String?, resp: CharSequence?) {
                        if (done) return; done = true
                        handler.removeCallbacks(timeout)
                        EngineLog.append(context, "DIAG USSD=PASS callback-ok")
                        onDone(0, true, "callback ok")
                    }
                    override fun onReceiveUssdResponseFailed(t: TelephonyManager?, r: String?, code: Int) {
                        if (done) return; done = true
                        handler.removeCallbacks(timeout)
                        EngineLog.append(context, "DIAG USSD code=$code")
                        onDone(code, false, "code $code")
                    }
                }, handler
            )
        }.onFailure {
            if (!done) {
                done = true
                handler.removeCallbacks(timeout)
                EngineLog.append(context, "DIAG USSD=FAIL threw ${it.message}")
                onDone(-1, false, "threw")
            }
        }
    }
}
