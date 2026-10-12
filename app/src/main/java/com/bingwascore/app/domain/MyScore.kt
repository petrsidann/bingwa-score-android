package com.bingwascore.app.domain

import java.util.Calendar

/**
 * Stage 15 — "My Score" analytics, as pure logic computed from Room aggregates.
 *
 * Every field is a single honest number an agent can act on, all derived from
 * SUCCESSFUL purchases in the last 24 hours (plus the success-rate denominator):
 *
 * - [topOffers]       — offers bought most→least in the window.
 * - [busiestHours]    — the contiguous run of hours with the most sales.
 * - [quietestHours]   — the contiguous run of hours with the fewest sales.
 * - [successRate]     — completed ÷ (completed + failed) as 0..1, or null with
 *                       no settled transactions yet.
 * - [bestWeekday]     — the weekday (Calendar.SUNDAY..SATURDAY) with most sales.
 *
 * Pure + JVM-tested; the screen feeds it rows and Room does the heavy lifting.
 */
object MyScore {

    /** One completed purchase, reduced to what the score needs. */
    data class Sale(val offerName: String, val at: Long)

    /** One settled transaction for the success-rate denominator. */
    data class Outcome(val successful: Boolean)

    /** A named hour bucket, e.g. ("18:00–19:00", 7). */
    data class HourBucket(val label: String, val count: Int, val startHour: Int)

    data class Score(
        val topOffers: List<Pair<String, Int>>,
        val busiestHours: List<HourBucket>,
        val quietestHours: List<HourBucket>,
        val successRate: Float?,
        val bestWeekday: Int?
    )

    val EMPTY = Score(emptyList(), emptyList(), emptyList(), null, null)

    /**
     * Rolls the last-24h [sales] and the settled [outcomes] into a [Score].
     * Hour buckets are single hours ranked by count, so a "range" is simply the
     * busiest/quietest hours read top-to-bottom.
     */
    fun compute(sales: List<Sale>, outcomes: List<Outcome>): Score {
        if (sales.isEmpty() && outcomes.isEmpty()) return EMPTY

        val topOffers = sales
            .groupingBy { it.offerName }
            .eachCount()
            .entries
            .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
            .map { it.key to it.value }

        val byHour = IntArray(24)
        val byWeekday = IntArray(8) // Calendar DAY_OF_WEEK is 1..7
        sales.forEach { sale ->
            val cal = Calendar.getInstance().apply { timeInMillis = sale.at }
            byHour[cal.get(Calendar.HOUR_OF_DAY)]++
            byWeekday[cal.get(Calendar.DAY_OF_WEEK)]++
        }

        val hourBuckets = byHour.withIndex()
            .filter { it.value > 0 }
            .map { HourBucket(bucketLabel(it.index), it.value, it.index) }

        val busiest = hourBuckets.sortedWith(compareByDescending<HourBucket> { it.count }.thenBy { it.startHour }).take(3)
        val quietest = hourBuckets.sortedWith(compareBy<HourBucket> { it.count }.thenBy { it.startHour }).take(3)

        val successRate = if (outcomes.isEmpty()) {
            null
        } else {
            val done = outcomes.count { it.successful }
            done.toFloat() / outcomes.size.toFloat()
        }

        val bestWeekday = byWeekday.withIndex()
            .filter { it.index in 1..7 && it.value > 0 }
            .maxByOrNull { it.value }?.index

        return Score(
            topOffers = topOffers,
            busiestHours = busiest,
            quietestHours = quietest,
            successRate = successRate,
            bestWeekday = bestWeekday
        )
    }

    /** "18:00" for 18, "00:00" for 0 — a 24h zero-padded hour label. */
    fun hourLabel(hour: Int): String = "%02d:00".format(hour)

    /** "18:00–19:00" style bucket label. */
    private fun bucketLabel(startHour: Int): String = "${hourLabel(startHour)}–${hourLabel((startHour + 1) % 24)}"

    /** "Sunday".."Saturday" for a Calendar weekday constant. */
    fun weekdayName(weekday: Int): String = when (weekday) {
        Calendar.MONDAY -> "Monday"
        Calendar.TUESDAY -> "Tuesday"
        Calendar.WEDNESDAY -> "Wednesday"
        Calendar.THURSDAY -> "Thursday"
        Calendar.FRIDAY -> "Friday"
        Calendar.SATURDAY -> "Saturday"
        Calendar.SUNDAY -> "Sunday"
        else -> "—"
    }

    /** The success-rate ring's whole-percent label ("82%"). */
    fun successRateLabel(rate: Float?): String =
        if (rate == null) "—" else "${Math.round(rate * 100)}%"
}
