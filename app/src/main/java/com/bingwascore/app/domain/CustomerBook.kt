package com.bingwascore.app.domain

import com.bingwascore.app.data.local.Customer

/**
 * Stage 14 — the Customers book, as pure logic.
 *
 * A customer row is an autosave roll-up of every SUCCESSFUL transaction for one
 * phone number: the newest offer drives "last offer", the newest timestamp
 * drives "recent-activity first", and the running totals (spend, count, first
 * purchase) accrue on the row so the list never has to re-scan the ledger.
 *
 * Everything here is pure and JVM-tested; persistence lives in Room
 * ([com.bingwascore.app.data.local.CustomerDao]) and the pipeline is what calls
 * [upsert] on every completed sale.
 */
object CustomerBook {

    /** One purchase, reduced to just what the book needs. */
    data class Sale(
        val phone: String,
        val name: String?,
        val offerName: String,
        val amount: Double,
        val at: Long
    )

    /** The per-customer roll-up shown on the detail sheet. */
    data class Stats(
        val totalSpent: Double,
        val txCount: Int,
        val firstPurchaseAt: Long,
        val mostBoughtOffer: String?,
        val lastFive: List<Sale>
    )

    /**
     * Folds one successful [sale] into [existing] (or mints a new customer).
     * A successful purchase never clears the blacklist flag — serving someone
     * again must not silently unblock them.
     */
    fun upsert(existing: Customer?, sale: Sale, now: Long = sale.at): Customer {
        val base = existing
        return Customer(
            phoneNumber = sale.phone,
            name = sale.name?.takeIf { it.isNotBlank() } ?: base?.name,
            isBlacklisted = base?.isBlacklisted ?: false,
            createdAt = base?.createdAt?.takeIf { it > 0L } ?: now,
            lastActivityAt = now,
            lastOfferName = sale.offerName,
            totalSpent = (base?.totalSpent ?: 0.0) + sale.amount,
            txCount = (base?.txCount ?: 0) + 1,
            firstPurchaseAt = base?.firstPurchaseAt?.takeIf { it > 0L } ?: now
        )
    }

    /** Recent-activity first; ties break on the newest phone so it is stable. */
    fun recentFirst(customers: List<Customer>): List<Customer> =
        customers.sortedWith(
            compareByDescending<Customer> { it.lastActivityAt }.thenByDescending { it.phoneNumber }
        )

    /** Only the blacklisted customers, still recent-first. */
    fun blacklistedOnly(customers: List<Customer>): List<Customer> =
        recentFirst(customers.filter { it.isBlacklisted })

    /**
     * Search pad across name + phone. A blank [query] returns the list as-is.
     * Matching is case-insensitive and matches a substring anywhere.
     */
    fun search(customers: List<Customer>, query: String): List<Customer> {
        val needle = query.trim().lowercase()
        if (needle.isEmpty()) return customers
        return customers.filter { customer ->
            customer.name?.lowercase()?.contains(needle) == true ||
                customer.phoneNumber.lowercase().contains(needle)
        }
    }

    /**
     * Detail-sheet roll-up from a phone's SUCCESSFUL sales (newest last is
     * fine — order is normalised here). Most-bought breaks ties on the offer
     * that was bought first.
     */
    fun stats(sales: List<Sale>): Stats {
        if (sales.isEmpty()) {
            return Stats(0.0, 0, 0L, null, emptyList())
        }
        val ordered = sales.sortedBy { it.at }
        val total = sales.sumOf { it.amount }
        val mostBought = sales
            .groupingBy { it.offerName }
            .eachCount()
            .entries
            .sortedWith(
                compareByDescending<Map.Entry<String, Int>> { it.value }
                    .thenBy { entry -> ordered.indexOfFirst { it.offerName == entry.key } }
            )
            .firstOrNull()?.key
        val lastFive = sales.sortedByDescending { it.at }.take(5)
        return Stats(
            totalSpent = total,
            txCount = sales.size,
            firstPurchaseAt = ordered.first().at,
            mostBoughtOffer = mostBought,
            lastFive = lastFive
        )
    }

    // ── Contact chooser URIs ────────────────────────────────────────────────

    /**
     * WhatsApp deep link. `0712345678` -> `https://wa.me/254712345678` (country
     * code, no `+`, no trunk zero) — exactly what wa.me expects.
     */
    fun whatsappUri(phone: String): String = "https://wa.me/${toWaNumber(phone)}"

    /** Dialer intent body: `tel:0712345678`. */
    fun dialUri(phone: String): String = "tel:$phone"

    /** Default SMS app intent body: `smsto:0712345678`. */
    fun smsUri(phone: String): String = "smsto:$phone"

    /**
     * The wa.me MSISDN: strip non-digits, drop a leading `0`, prepend `254`.
     * A number already carrying the country code is left alone.
     */
    fun toWaNumber(phone: String): String {
        val digits = phone.filter { it.isDigit() }
        return when {
            digits.isEmpty() -> ""
            digits.startsWith("254") -> digits
            digits.startsWith("0") -> "254" + digits.removePrefix("0")
            digits.length == 9 -> "254$digits"
            else -> digits
        }
    }
}
