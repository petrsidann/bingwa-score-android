package com.bingwascore.app.data.showcase

import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.AutoReply
import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import timber.log.Timber
import java.util.Calendar
import java.util.Random
import kotlinx.coroutines.flow.first
import java.util.concurrent.TimeUnit

/**
 * SHOWCASE S2 — fills a freshly created **demo** database with a believable month
 * of work, so a first-time viewer sees a populated app on the very first frame.
 *
 * Runs once, only when Showcase Mode is on and the demo database is empty. The
 * production [com.bingwascore.app.data.local.DatabaseSeeder] is never involved, so
 * a real agent's default offers and customers are never overwritten.
 */
object DemoSeeder {

    private const val TAG = "Showcase"
    private const val SEED = 1_404L

    suspend fun seedIfEmpty(database: AppDatabase) {
        val existing = database.transactionDao().getAllTransactions().first().size
        if (existing > 0) {
            Timber.i("$TAG demo database already has %s rows", existing)
            return
        }

        val random = Random(SEED)
        val now = System.currentTimeMillis()
        val windowStart = now - TimeUnit.DAYS.toMillis(DemoCatalog.HISTORY_DAYS.toLong())

        val customers = DemoCatalog.CUSTOMERS.mapIndexed { index, customer ->
            Customer(
                phoneNumber = customer.phone,
                name = customer.name,
                isBlacklisted = false,
                createdAt = now - TimeUnit.DAYS.toMillis((index + 2).toLong())
            )
        } + Customer(
            phoneNumber = DemoCatalog.BLOCKED_CONTACT_PHONE,
            name = DemoCatalog.BLOCKED_CONTACT_NAME,
            isBlacklisted = true,
            createdAt = now - TimeUnit.DAYS.toMillis(12)
        ) + Customer(
            phoneNumber = DemoCatalog.TRUSTED_PARTNER_PHONE,
            name = DemoCatalog.TRUSTED_PARTNER_NAME,
            isBlacklisted = false,
            createdAt = now - TimeUnit.DAYS.toMillis(9)
        )

        val offers = DemoCatalog.OFFERS.distinctBy { it.ussdCode }.map { demo ->
            Offer(
                id = "demo_offer_${demo.ussdCode.hashCode().toUInt().toString(16)}",
                name = demo.name,
                ussdCode = demo.ussdCode,
                price = demo.price,
                isActive = true,
                autoRenewable = demo.price >= 100,
                validityHours = demo.validityHours,
                isVerified = true,
                ussdTimeoutSeconds = 20,
                type = demo.type
            )
        }

        val transactions = (0 until DemoCatalog.TRANSACTION_COUNT).map { index ->
            val customer = customers[random.nextInt(DemoCatalog.CUSTOMERS.size)]
            val offer = offers[random.nextInt(offers.size)]
            val status = DemoCatalog.statusFor(random)
            val createdAt = windowStart +
                (now - windowStart) * ((index + random.nextInt(6)) / DemoCatalog.TRANSACTION_COUNT.toDouble()).toLong()
            Transaction(
                id = "demo_tx_$index",
                phoneNumber = customer.phoneNumber,
                customerName = customer.name,
                offerId = offer.id,
                offerName = offer.name,
                ussdCode = offer.ussdCode,
                amount = offer.price.toDouble(),
                commission = DemoCatalog.commissionFor(offer.price.toDouble()),
                status = status,
                createdAt = createdAt,
                retryCount = if (status == TransactionStatus.FAILED.value) random.nextInt(2) + 1 else 0,
                responseMessage = demoResponse(status, offer.name),
                mpesaReceipt = if (status == TransactionStatus.SUCCESSFUL.value) {
                    DemoCatalog.incomingPaymentSms(
                        receipt = "DEMO${index.toString().padStart(4, '0')}",
                        name = customer.name ?: "CUSTOMER",
                        phone = customer.phoneNumber,
                        amount = offer.price.toDouble(),
                        newBalance = 500.0 + offer.price,
                        timestamp = createdAt
                    )
                } else {
                    null
                }
            )
        }.sortedByDescending { it.createdAt }

        val replies = DemoCatalog.AUTO_REPLIES.map { (keyword, body) ->
            AutoReply(
                title = keyword,
                message = body,
                type = "KEYWORD",
                isActive = true
            )
        }

        customers.forEach { database.customerDao().insert(it) }
        offers.forEach { database.offerDao().insert(it) }
        replies.forEach { database.autoReplyDao().insert(it) }
        transactions.forEach { database.transactionDao().insert(it) }

        Timber.i(
            "$TAG seeded %s customers, %s offers, %s transactions, %s auto-replies",
            customers.size, offers.size, transactions.size, replies.size
        )
    }

    /** A believable stored reply so the detail sheet is never blank. */
    private fun demoResponse(status: String, offerName: String): String = when (status) {
        TransactionStatus.SUCCESSFUL.value -> DemoCatalog.ussdSuccessReply(offerName)
        TransactionStatus.FAILED_ALREADY_RECOMMENDED.value -> DemoCatalog.ussdAlreadyRecommendedReply()
        TransactionStatus.FAILED.value -> DemoCatalog.ussdConnectionProblemReply()
        else -> ""
    }

    /** Start of the current day, used when a demo payment is simulated live. */
    fun startOfToday(): Long = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis
}