package com.bingwascore.app.data.local

/**
 * Inserts demo data on first launch so the UI shows life immediately.
 * Only runs when the respective tables are empty.
 */

/**
 * POLISH P4 - the default offer shelf: exactly four real Safaricom bundles.
 *
 * Four, not twelve. The old seed shipped invented clones ("250MBs, 24hrs",
 * "400MBs, 7Days", "750MBs+50SMS") whose codes were guesses, which taught the
 * agent nothing and made the first screen look fuller than the business was.
 * These are the four an M-Pesa agent actually sells, at the prices Safaricom
 * charges, spread across three categories so the category chips have something
 * to filter (and SMS is deliberately empty, because the empty state is part of
 * the product now).
 */
val DEFAULT_OFFERS: List<Offer> = listOf(
    Offer(
        id = "offer_data_1gb_daily",
        name = "1GB Daily Data",
        ussdCode = "*544*1*1*ph#",
        price = 20,
        isActive = true,
        autoRenewable = true,
        validityHours = 24,
        isVerified = true,
        autoRetry = true,
        numberOfRetries = 2,
        retryIntervalMins = 5,
        type = Offer.TYPE_DATA
    ),
    Offer(
        id = "offer_data_5gb_weekly",
        name = "5GB Weekly Data",
        ussdCode = "*544*5*1*ph#",
        price = 100,
        isActive = true,
        autoRenewable = true,
        validityHours = 168,
        isVerified = true,
        autoRetry = true,
        numberOfRetries = 2,
        retryIntervalMins = 5,
        type = Offer.TYPE_DATA
    ),
    Offer(
        id = "offer_airtime_1min",
        name = "1 Minute Airtime",
        ussdCode = "*682*1*ph#",
        price = 10,
        isActive = true,
        validityHours = 24,
        isVerified = true,
        type = Offer.TYPE_AIRTIME
    ),
    Offer(
        id = "offer_combo_all_access",
        name = "All Access Unlimited",
        ussdCode = "*999*1*ph#",
        price = 1500,
        isActive = true,
        autoRenewable = true,
        validityHours = 720,
        isVerified = true,
        type = Offer.TYPE_COMBO
    )
)

/**
 * POLISH P4 - dedupe helper: one row per (name, code), first one wins.
 *
 * Seeds get re-run, catalogues get imported, and a duplicate offer row is
 * invisible until an agent dials the wrong one twice in a row.
 */
internal fun List<Offer>.deduplicated(): List<Offer> =
    distinctBy { "${it.name.trim().lowercase()}|${it.ussdCode.trim()}" }


object DatabaseSeeder {

    suspend fun seedIfEmpty(database: AppDatabase) {
        val now = System.currentTimeMillis()

        if (database.offerDao().count() == 0) {
            // POLISH P4 - deduped: the shelf is four real offers, never clones.
            DEFAULT_OFFERS.deduplicated().forEach { database.offerDao().insert(it) }
        }

        if (database.transactionDao().count() == 0) {
            listOf(
                Transaction(
                    id = "seed_t1",
                    phoneNumber = "0712000001",
                    customerName = "Amina W.",
                    offerId = "offer_data_1gb_daily",
                    offerName = "1GB Daily Data",
                    ussdCode = "*544*1*1*0712000001#",
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
                    offerId = "offer_data_5gb_weekly",
                    offerName = "5GB Weekly Data",
                    amount = 100.0,
                    ussdCode = "*544*5*1*0722333444#",
                    commission = 10.0,
                    status = "SUCCESSFUL",
                    createdAt = now - 3L * 60 * 60_000L,
                    mpesaReceipt = "SJ2KD81LM"
                ),
                Transaction(
                    id = "seed_t3",
                    phoneNumber = "0733444555",
                    customerName = "Cynthia A.",
                    offerId = "offer_combo_all_access",
                    offerName = "All Access Unlimited",
                    ussdCode = "*999*1*0733444555#",
                    amount = 1500.0,
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
                    offerId = "offer_data_1gb_daily",
                    offerName = "1GB Daily Data",
                    ussdCode = "*544*1*1*0745566778#",
                    amount = 20.0,
                    commission = 2.0,
                    status = "PENDING",
                    createdAt = now - 40L * 60_000L
                ),
                Transaction(
                    id = "seed_t5",
                    phoneNumber = "0712000001",
                    customerName = "Amina W.",
                    offerId = "offer_data_5gb_weekly",
                    offerName = "5GB Weekly Data",
                    ussdCode = "*544*5*1*0712000001#",
                    amount = 100.0,
                    status = "SCHEDULED",
                    createdAt = now - 1L * 60 * 60_000L,
                    commission = 10.0,
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
