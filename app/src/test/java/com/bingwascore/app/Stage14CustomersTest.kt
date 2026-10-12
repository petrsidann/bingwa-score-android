package com.bingwascore.app

import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.domain.CustomerBook
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 14 — Customers book: autosave roll-up + contact chooser.
 *
 * Pure logic in [CustomerBook] (upsert roll-up, recent-first, blacklist filter,
 * search pad, detail stats, contact URIs) plus source guards for the wiring
 * (pipeline autosave hook, autosave toggle, Room migration, drawer cleanup) —
 * the house style for Composable/persistence contracts.
 */
class Stage14CustomersTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    private fun sale(
        phone: String = "0712345678",
        name: String? = "Dennis Wachira",
        offer: String = "1GB, 30Days",
        amount: Double = 300.0,
        at: Long = 1_000L
    ) = CustomerBook.Sale(phone, name, offer, amount, at)

    // ── Autosave: tx -> customer ────────────────────────────────────────────

    @Test
    fun `first sale mints a customer with the roll-up seeded`() {
        val customer = CustomerBook.upsert(existing = null, sale = sale(at = 5_000L), now = 5_000L)
        assertEquals("0712345678", customer.phoneNumber)
        assertEquals("Dennis Wachira", customer.name)
        assertEquals(300.0, customer.totalSpent, 0.001)
        assertEquals(1, customer.txCount)
        assertEquals(5_000L, customer.firstPurchaseAt)
        assertEquals(5_000L, customer.lastActivityAt)
        assertEquals("1GB, 30Days", customer.lastOfferName)
        assertFalse(customer.isBlacklisted)
    }

    @Test
    fun `a later sale accrues spend count and last offer`() {
        var customer = CustomerBook.upsert(null, sale(offer = "250MBs", amount = 20.0, at = 1_000L), now = 1_000L)
        customer = CustomerBook.upsert(customer, sale(offer = "1GB", amount = 300.0, at = 9_000L), now = 9_000L)
        assertEquals(320.0, customer.totalSpent, 0.001)
        assertEquals(2, customer.txCount)
        assertEquals(9_000L, customer.lastActivityAt)
        assertEquals(1_000L, customer.firstPurchaseAt) // first purchase is frozen
        assertEquals("1GB", customer.lastOfferName)
    }

    @Test
    fun `a fresh sale never silently unblocks a blacklisted customer`() {
        val blocked = Customer(phoneNumber = "0712345678", createdAt = 1L, isBlacklisted = true, lastActivityAt = 1L)
        val updated = CustomerBook.upsert(blocked, sale(at = 2_000L), now = 2_000L)
        assertTrue("blacklist survives an autosave", updated.isBlacklisted)
    }

    @Test
    fun `a sale fills a missing name but never overwrites a known one`() {
        val named = CustomerBook.upsert(null, sale(name = "Dennis Wachira", at = 1L), now = 1L)
        val anon = CustomerBook.upsert(named, sale(name = null, at = 2L), now = 2L)
        assertEquals("Dennis Wachira", anon.name)
    }

    // ── Recent-first + blacklist filter ─────────────────────────────────────

    @Test
    fun `recent-first orders by last activity descending`() {
        val a = Customer("0700000001", createdAt = 1L, lastActivityAt = 100L)
        val b = Customer("0700000002", createdAt = 2L, lastActivityAt = 300L)
        val c = Customer("0700000003", createdAt = 3L, lastActivityAt = 200L)
        val ordered = CustomerBook.recentFirst(listOf(a, b, c))
        assertEquals(listOf("0700000002", "0700000003", "0700000001"), ordered.map { it.phoneNumber })
    }

    @Test
    fun `blacklist filter keeps only blocked customers`() {
        val keep = Customer("0700000001", createdAt = 1L, lastActivityAt = 1L, isBlacklisted = true)
        val drop = Customer("0700000002", createdAt = 2L, lastActivityAt = 2L)
        val blocked = CustomerBook.blacklistedOnly(listOf(drop, keep))
        assertEquals(listOf("0700000001"), blocked.map { it.phoneNumber })
    }

    // ── Search pad ──────────────────────────────────────────────────────────

    @Test
    fun `search matches name or phone and a blank query is a noop`() {
        val list = listOf(
            Customer("0712345678", name = "Dennis Wachira", createdAt = 1L, lastActivityAt = 1L),
            Customer("0722000000", name = "Mary Atieno", createdAt = 2L, lastActivityAt = 2L)
        )
        assertEquals(2, CustomerBook.search(list, "  ").size)
        assertEquals(listOf("0712345678"), CustomerBook.search(list, "wachira").map { it.phoneNumber })
        assertEquals(listOf("0722000000"), CustomerBook.search(list, "0722").map { it.phoneNumber })
        assertTrue(CustomerBook.search(list, "zzz").isEmpty())
    }

    // ── Detail stats ────────────────────────────────────────────────────────

    @Test
    fun `stats totals spend counts first purchase and most-bought`() {
        val stats = CustomerBook.stats(
            listOf(
                sale(offer = "250MBs", amount = 20.0, at = 1_000L),
                sale(offer = "1GB", amount = 300.0, at = 2_000L),
                sale(offer = "1GB", amount = 300.0, at = 3_000L),
                sale(offer = "1GB", amount = 300.0, at = 4_000L)
            )
        )
        assertEquals(920.0, stats.totalSpent, 0.001)
        assertEquals(4, stats.txCount)
        assertEquals(1_000L, stats.firstPurchaseAt)
        assertEquals("1GB", stats.mostBoughtOffer)
        assertEquals(4, stats.lastFive.size)
        assertEquals(4_000L, stats.lastFive.first().at)
    }

    @Test
    fun `most-bought breaks a tie on the offer bought first`() {
        val stats = CustomerBook.stats(
            listOf(
                sale(offer = "250MBs", at = 1_000L),
                sale(offer = "1GB", at = 2_000L)
            )
        )
        assertEquals("250MBs", stats.mostBoughtOffer)
    }

    @Test
    fun `last-five caps at the five newest purchases`() {
        val stats = CustomerBook.stats(
            (1..7).map { sale(offer = "offer$it", at = it * 1_000L) }
        )
        assertEquals(5, stats.lastFive.size)
        assertEquals("offer7", stats.lastFive.first().offerName)
        assertEquals("offer3", stats.lastFive.last().offerName)
    }

    @Test
    fun `empty stats is a zeroed roll-up with no most-bought`() {
        val stats = CustomerBook.stats(emptyList())
        assertEquals(0.0, stats.totalSpent, 0.001)
        assertEquals(0, stats.txCount)
        assertNull(stats.mostBoughtOffer)
        assertTrue(stats.lastFive.isEmpty())
    }

    // ── Contact chooser URIs ────────────────────────────────────────────────

    @Test
    fun `whatsapp uri normalises to the wa-me msisdn`() {
        assertEquals("https://wa.me/254712345678", CustomerBook.whatsappUri("0712345678"))
        assertEquals("https://wa.me/254712345678", CustomerBook.whatsappUri("+254 712 345 678"))
        assertEquals("https://wa.me/254712345678", CustomerBook.whatsappUri("712345678"))
        assertEquals("https://wa.me/254712345678", CustomerBook.whatsappUri("254712345678"))
    }

    @Test
    fun `dial and sms use the raw number`() {
        assertEquals("tel:0712345678", CustomerBook.dialUri("0712345678"))
        assertEquals("smsto:0712345678", CustomerBook.smsUri("0712345678"))
    }

    // ── Wiring (source guards) ──────────────────────────────────────────────

    @Test
    fun `the pipeline autosaves a customer on both success paths`() {
        val pipeline = source("app/src/main/java/com/bingwascore/app/domain/engine/TransactionPipeline.kt")
        assertTrue("onUssdSuccess upserts the customer", pipeline.contains("autosaveCustomer(transaction)"))
        assertTrue(
            "the autosave is gated by the settings toggle",
            pipeline.contains("userPreferences.customersAutosave.first()")
        )
        assertTrue(
            "the autosave is fully guarded",
            pipeline.contains("private suspend fun autosaveCustomer(transaction: Transaction)")
        )
    }

    @Test
    fun `the autosave toggle defaults on`() {
        val prefs = source("app/src/main/java/com/bingwascore/app/data/preferences/UserPreferences.kt")
        assertTrue("autosave reads the key", prefs.contains("it[Keys.CUSTOMERS_AUTOSAVE] ?: true"))
    }

    @Test
    fun `the customer roll-up columns migrate in place`() {
        val db = source("app/src/main/java/com/bingwascore/app/data/local/AppDatabase.kt")
        assertTrue("db is at version 7", db.contains("version = 7"))
        assertTrue("v6->v7 migration exists", db.contains("MIGRATION_6_7"))
        assertTrue("lastActivityAt is added", db.contains("ADD COLUMN `lastActivityAt`"))
        assertTrue("migration is registered", db.contains("MIGRATION_6_7"))
    }

    @Test
    fun `the drawer retires the four routes`() {
        val nav = source("app/src/main/java/com/bingwascore/app/ui/navigation/AppNavHost.kt")
        assertFalse("no Trusted Partners item", nav.contains("\"Trusted Partners\""))
        assertFalse("no QR Scanner item", nav.contains("\"QR Scanner\""))
        assertFalse("no Blocked Contacts item", nav.contains("\"Blocked Contacts\""))
        assertFalse("no Subscriptions item", nav.contains("\"Subscriptions\""))
    }
}

