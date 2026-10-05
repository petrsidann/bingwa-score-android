package com.bingwascore.app

import com.bingwascore.app.data.local.DEFAULT_OFFERS
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.deduplicated
import com.bingwascore.app.ui.offers.OfferCategory
import com.bingwascore.app.ui.offers.offerCategoryOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * POLISH P4 â€” the offer shelf.
 *
 * Two rules, both easy to break by eye:
 * - The default shelf is **exactly four** real Safaricom offers, deduped. An
 *   invented clone reads as a real bundle until an agent tries to dial it.
 * - Every offer lands in exactly one category, and an unknown type still appears
 *   under All rather than vanishing.
 */
class OfferShelfTest {

    @Test
    fun `the default shelf has exactly four offers`() {
        assertEquals(4, DEFAULT_OFFERS.size)
    }

    @Test
    fun `the default shelf has no duplicates`() {
        val unique = DEFAULT_OFFERS.deduplicated()
        assertEquals(DEFAULT_OFFERS.size, unique.size)
    }

    @Test
    fun `the default offers are real Safaricom codes and prices`() {
        val codes = DEFAULT_OFFERS.map { it.ussdCode }
        assertTrue(codes.all { it.startsWith("*") && it.contains("ph") && it.endsWith("#") })
        assertTrue(codes.contains("*544*1*1*ph#"))   // 1GB daily data
        assertTrue(codes.contains("*682*1*ph#"))     // 1 minute airtime
        assertTrue(codes.contains("*999*1*ph#"))     // all access unlimited
        assertTrue(DEFAULT_OFFERS.all { it.price > 0 })
        assertTrue(DEFAULT_OFFERS.all { it.isActive })
    }

    @Test
    fun `dedupe keeps the first of two identical offers`() {
        val twin = DEFAULT_OFFERS.first()
        val doubled = DEFAULT_OFFERS + twin
        assertEquals(4, doubled.deduplicated().size)
    }

    @Test
    fun `offers land in the category their type declares`() {
        val data = DEFAULT_OFFERS.first { it.type == Offer.TYPE_DATA }
        assertEquals(OfferCategory.DATA, offerCategoryOf(data))
        val airtime = DEFAULT_OFFERS.first { it.type == Offer.TYPE_AIRTIME }
        assertEquals(OfferCategory.AIRTIME, offerCategoryOf(airtime))
        val combo = DEFAULT_OFFERS.first { it.type == Offer.TYPE_COMBO }
        assertEquals(OfferCategory.COMBO, offerCategoryOf(combo))
    }

    @Test
    fun `an unknown type still shows under All`() {
        val odd = DEFAULT_OFFERS.first().copy(type = "SOMETHING_ELSE")
        assertEquals(OfferCategory.ALL, offerCategoryOf(odd))
        assertTrue(OfferCategory.ALL.matches(odd))
    }

    @Test
    fun `filtering by category keeps only that category`() {
        val data = OfferCategory.filter(DEFAULT_OFFERS, OfferCategory.DATA)
        assertEquals(2, data.size)
        assertTrue(data.all { it.type == Offer.TYPE_DATA })
        assertEquals(
            4,
            OfferCategory.filter(DEFAULT_OFFERS, OfferCategory.ALL).size
        )
        assertTrue(OfferCategory.filter(DEFAULT_OFFERS, OfferCategory.SMS).isEmpty())
    }
}
