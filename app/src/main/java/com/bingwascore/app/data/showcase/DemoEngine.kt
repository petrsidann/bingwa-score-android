package com.bingwascore.app.data.showcase

import android.content.Context
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.domain.engine.TransactionPipeline
import com.bingwascore.app.utils.SmsParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Random
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * SHOWCASE S2 — the live simulator.
 *
 * While Showcase Mode is on, this emits a real, Hybrid-formatted incoming M-Pesa
 * confirmation every 20–45 seconds and feeds it to the **real**
 * [SmsParser] and the **real** [TransactionPipeline]. Nothing is faked downstream:
 * the counters climb, the chart ticks and rows walk PENDING → PROCESSING →
 * SUCCESSFUL because the production engine is genuinely doing the work.
 *
 * Nothing here touches the radio: no USSD is dialled and no SMS is sent.
 *
 * [start] is a no-op unless Showcase Mode is on — the guard is at the entry
 * point as well as inside the loop, so the engine can never outlive the flag.
 */
@Singleton
class DemoEngine @Inject constructor(
    private val pipeline: TransactionPipeline
) {

    companion object {
        private const val TAG = "Showcase"
        const val MPESA_SENDER = "MPESA"

        /** Cadence of the demo reel. */
        const val MIN_INTERVAL_MILLIS = 20_000L
        const val MAX_INTERVAL_MILLIS = 45_000L

        /** How often a Safaricom commission summary follows a sale. */
        const val COMMISSION_CHANCE = 0.15

        /** How often the same customer pays twice — the Engage Bot duplicate path. */
        const val DUPLICATE_CHANCE = 0.10

        /** Commission SMS sender, exactly like the operator's short code. */
        const val COMMISSION_SENDER = "Safaricom"
    }

    private var job: Job? = null
    private val random = Random(System.currentTimeMillis())

    /**
     * Starts the simulator. Safe to call repeatedly; a second call while running
     * is ignored so a configuration change cannot double the traffic.
     */
    fun start(scope: CoroutineScope) {
        if (!isShowcase()) return
        if (job?.isActive == true) return
        Timber.i("$TAG simulator started")
        job = scope.launch(Dispatchers.Default) {
            // A short beat so the seed has landed before the first payment.
            delay(TimeUnit.SECONDS.toMillis(12))
            while (isActive && isShowcase()) {
                val wait = MIN_INTERVAL_MILLIS + (random.nextDouble() * (MAX_INTERVAL_MILLIS - MIN_INTERVAL_MILLIS)).toLong()
                delay(wait)
                if (!isActive || !isShowcase()) break
                runCatching { emitOnePayment() }
                    .onFailure { Timber.e(it, "$TAG simulator tick failed") }
            }
        }
    }

    fun stop() {
        job?.cancel()
        job = null
        Timber.i("$TAG simulator stopped")
    }

    /** True when this process is running against the demo database. */
    private fun isShowcase(): Boolean = DbNameHolder.showcaseMode

    /**
     * One simulated payment: build the Hybrid SMS, prove the real parser reads
     * it, then hand it to the real pipeline.
     */
    private suspend fun emitOnePayment() {
        val customer = DemoCatalog.CUSTOMERS[random.nextInt(DemoCatalog.CUSTOMERS.size)]
        val offer = DemoCatalog.OFFERS[random.nextInt(DemoCatalog.OFFERS.size)]
        val now = System.currentTimeMillis()
        val receipt = "DEMO" + (100000 + random.nextInt(900000)).toString()

        val body = DemoCatalog.incomingPaymentSms(
            receipt = receipt,
            name = customer.name,
            phone = customer.phone,
            amount = offer.price.toDouble(),
            newBalance = 250.0 + random.nextInt(750),
            timestamp = now
        )

        // The demo never fakes a parse: if the classifier does not read this as
        // an incoming payment, that is a real regression worth failing loudly.
        val type = SmsParser.classify(body)
        check(type == SmsParser.SmsType.INCOMING_PAYMENT) {
            "Demo SMS did not classify as an incoming payment (got $type)"
        }

        Timber.i("$TAG %s paid Ksh %s for %s", customer.name, offer.price, offer.name)
        pipeline.onMpesaReceived(MPESA_SENDER, body)
        DemoNotifier.notify(context, customer.name, offer.name, offer.price.toDouble())

        if (random.nextDouble() < COMMISSION_CHANCE) {
            delay(2_500)
            pipeline.onMpesaReceived(
                COMMISSION_SENDER,
                DemoCatalog.commissionSms(DemoCatalog.commissionFor(offer.price.toDouble()), now)
            )
        }

        if (random.nextDouble() < DUPLICATE_CHANCE) {
            // Same receipt, same amount: the real duplicate detector routes this
            // into the Engage Bot instead of dialling twice.
            delay(3_000)
            Timber.i("$TAG duplicate payment from %s — engage bot path", customer.name)
            pipeline.onMpesaReceived(MPESA_SENDER, body)
        }
    }

    /**
     * S2 — simulated *144# balance: a random walk so the number moves believably
     * without ever touching the radio.
     */


    /** Held so the notifier can reach an application context. */
    private var context: Context? = null

    /** S3 — called from the Application once the graph exists. */
    fun attachContext(appContext: Context) {
        context = appContext
    }
}