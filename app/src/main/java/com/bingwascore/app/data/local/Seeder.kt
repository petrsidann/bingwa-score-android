package com.bingwascore.app.data.local

/**
 * Inserts demo data on first launch so the UI shows life immediately.
 * Only runs when the respective tables are empty.
 */
object DatabaseSeeder {

    suspend fun seedIfEmpty(database: AppDatabase) {
        val now = System.currentTimeMillis()

        if (database.offerDao().count() == 0) {
            listOf(
                Offer(
                    id = "offer_250mb_24hr",
                    name = "250MBs, 24hrs",
                    ussdCode = "*544*2*1*1*ph#",
                    price = 20,
                    isActive = true,
                    autoRenewable = true,
                    validityHours = 24,
                    isVerified = true,
                    autoRetry = true,
                    numberOfRetries = 3,
                    retryIntervalMins = 5,
                    ussdTimeoutMillis = 20000L
                ),
                Offer(
                    id = "offer_400mb_7days",
                    name = "400MBs, 7Days",
                    ussdCode = "*544*2*2*1*ph#",
                    price = 49,
                    isActive = true,
                    autoRenewable = true,
                    validityHours = 168,
                    isVerified = true,
                    ussdTimeoutMillis = 20000L
                ),
                Offer(
                    id = "offer_750mb_50sms",
                    name = "750MBs+50SMS",
                    ussdCode = "*544*2*3*1*ph#",
                    price = 55,
                    isActive = true,
                    autoRenewable = false,
                    validityHours = 168,
                    isVerified = false,
                    ussdTimeoutMillis = 20000L
                )
            ).forEach { database.offerDao().insert(it) }
        }

        if (database.transactionDao().count() == 0) {
            listOf(
                Transaction(
                    id = "seed_t1",
                    phoneNumber = "0712000001",
                    customerName = "Amina W.",
                    offerId = "offer_250mb_24hr",
                    offerName = "250MBs, 24hrs",
                    ussdCode = "*544*2*1*1*0712000001#",
                    amount = 20.0,
                    commission = 2.0,
                    status = "SUCCESSFUL",
                    createdAt = now - 30L * 60_000L,
                    mpesaReceipt = "QK7GH2X1P"
                ),
                Transaction(
                    id = "seed_t2",
                    phoneNumber = "0722333444",
                    customerName = "Brian K.",
                    offerId = "offer_400mb_7days",
                    offerName = "400MBs, 7Days",
                    ussdCode = "*544*2*2*1*0722333444#",
                    amount = 49.0,
                    commission = 4.9,
                    status = "SUCCESSFUL",
                    createdAt = now - 3L * 60 * 60_000L,
                    mpesaReceipt = "SJ2KD81LM"
                ),
                Transaction(
                    id = "seed_t3",
                    phoneNumber = "0733444555",
                    customerName = "Cynthia A.",
                    offerId = "offer_750mb_50sms",
                    offerName = "750MBs+50SMS",
                    ussdCode = "*544*2*3*1*0733444555#",
                    amount = 55.0,
                    commission = 0.0,
                    status = "FAILED",
                    createdAt = now - 5L * 60 * 60_000L,
                    errorMessage = "USSD session timed out",
                    retryCount = 1
                ),
                Transaction(
                    id = "seed_t4",
                    phoneNumber = "0745566778",
                    customerName = "Dennis M.",
                    offerId = "offer_250mb_24hr",
                    offerName = "250MBs, 24hrs",
                    ussdCode = "*544*2*1*1*0745566778#",
                    amount = 20.0,
                    commission = 2.0,
                    status = "PENDING",
                    createdAt = now - 40L * 60_000L
                ),
                Transaction(
                    id = "seed_t5",
                    phoneNumber = "0712000001",
                    customerName = "Amina W.",
                    offerId = "offer_400mb_7days",
                    offerName = "400MBs, 7Days",
                    ussdCode = "*544*2*2*1*0712000001#",
                    amount = 49.0,
                    commission = 4.9,
                    status = "SCHEDULED",
                    createdAt = now - 1L * 60 * 60_000L,
                    scheduledAt = now + 2L * 60 * 60_000L,
                    isAutoRenewal = true
                )
            ).forEach { database.transactionDao().insert(it) }
        }

        if (database.customerDao().count() == 0) {
            listOf(
                Customer(
                    phoneNumber = "0712000001",
                    name = "Amina W.",
                    isBlacklisted = false,
                    createdAt = now - 6L * 24 * 60 * 60_000L
                ),
                Customer(
                    phoneNumber = "0722333444",
                    name = "Brian K.",
                    isBlacklisted = false,
                    createdAt = now - 4L * 24 * 60 * 60_000L
                ),
                Customer(
                    phoneNumber = "0733444555",
                    name = "Cynthia A.",
                    isBlacklisted = true,
                    createdAt = now - 2L * 24 * 60 * 60_000L
                )
            ).forEach { database.customerDao().insert(it) }
        }

        if (database.autoReplyDao().count() == 0) {
            listOf(
                AutoReply(
                    title = "Successful",
                    message = "Your bundle is live. Asante for choosing Bingwa Score!",
                    type = "SUCCESSFUL",
                    isActive = true
                ),
                AutoReply(
                    title = "Already Recommended",
                    message = "That number already has this bundle. No double charging today.",
                    type = "FAILED_ALREADY_RECOMMENDED",
                    isActive = true
                ),
                AutoReply(
                    title = "Failed",
                    message = "We could not complete your bundle purchase. We will retry shortly.",
                    type = "FAILED",
                    isActive = true
                ),
                AutoReply(
                    title = "Unavailable",
                    message = "That bundle is temporarily unavailable. Please try again later.",
                    type = "UNMATCHED",
                    isActive = true
                ),
                AutoReply(
                    title = "Paused",
                    message = "Your auto-renewal is paused. Reply RESUME to turn it back on.",
                    type = "PAUSED",
                    isActive = false
                ),
                AutoReply(
                    title = "Blacklisted",
                    message = "You have been unsubscribed from Bingwa Score messages.",
                    type = "BLACKLISTED",
                    isActive = true
                )
            ).forEach { database.autoReplyDao().insert(it) }
        }
    }
}