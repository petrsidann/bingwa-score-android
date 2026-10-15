package com.bingwascore.app

import com.bingwascore.app.domain.MyScore
import com.bingwascore.app.domain.SelfRenewalSchedule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.util.Calendar

/**
 * Stage 15 — Self-Renewal scheduling + My Score analytics.
 *
 * - A renewal validates (offer, ten-digit phone, future time), becomes a
 *   SCHEDULED row and a countdown; [SelfRenewalSchedule] is pure so the whole
 *   schedule→fire→complete contract is pinned here (the dial itself is the
 *   existing pipeline, guarded by source checks below).
 * - My Score rolls the last-24h sales into top offers (most→least), busiest /
 *   quietest hour ranges, a success rate and the best weekday — all pure.
 */
class Stage15SelfRenewalTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String =
        File(repoRoot, path).readText()

    private val now = 1_000_000L
    private fun draft(
        phone: String = "0712345678",
        offer: String = "1GB, 30Days",
        fireAt: Long = now + 60_000L
    ) = SelfRenewalSchedule.Draft(
        offerId = "o1", offerName = offer, ussdCode = "*544#",
        phone = phone, amount = 300.0, commission = 0.0, fireAt = fireAt
    )

    // ── Self-Renewal validation ─────────────────────────────────────────────

    @Test
    fun `a valid draft is schedulable`() {
        assertNull(SelfRenewalSchedule.validate(draft(), now))
    }

    @Test
    fun `a renewal needs an offer`() {
        val bad = draft().copy(offerId = "", offerName = "")
        assertEquals("Pick an offer to renew", SelfRenewalSchedule.validate(bad, now))
    }

    @Test
    fun `a renewal needs a valid ten-digit phone`() {
        assertEquals(
            "Enter the customer's phone number",
            SelfRenewalSchedule.validate(draft(phone = ""), now)
        )
        assertEquals(
            "That phone number is not a valid 10-digit number",
            SelfRenewalSchedule.validate(draft(phone = "0712"), now)
        )
    }

    @Test
    fun `a renewal must be in the future`() {
        assertEquals(
            "Pick a time in the future",
            SelfRenewalSchedule.validate(draft(fireAt = now), now)
        )
        assertEquals(
            "Pick a time in the future",
            SelfRenewalSchedule.validate(draft(fireAt = now - 1_000L), now)
        )
    }

    // ── SCHEDULED row + due/delay ───────────────────────────────────────────

    @Test
    fun `a scheduled row is a SCHEDULED auto-renewal carrying the fire time`() {
        val tx = SelfRenewalSchedule.toScheduledTx(draft(fireAt = now + 500_000L), now)
        assertEquals(com.bingwascore.app.domain.TransactionStatus.SCHEDULED.value, tx.status)
        assertTrue("flagged as an auto renewal", tx.isAutoRenewal)
        assertEquals(now + 500_000L, tx.scheduledAt)
        assertEquals("0712345678", tx.phoneNumber)
        assertTrue("id is namespaced", tx.id.startsWith("SR-"))
    }

    @Test
    fun `due and delay track the fire time`() {
        assertFalse(SelfRenewalSchedule.isDue(now + 1_000L, now))
        assertTrue(SelfRenewalSchedule.isDue(now, now))
        assertEquals(0L, SelfRenewalSchedule.delayMillis(now, now))
        assertEquals(5_000L, SelfRenewalSchedule.delayMillis(now + 5_000L, now))
        assertEquals(0L, SelfRenewalSchedule.delayMillis(now - 5_000L, now)) // never negative
    }

    // ── Countdown chip ──────────────────────────────────────────────────────

    @Test
    fun `countdown label reads days hours minutes and any moment`() {
        assertEquals("2d 3h", SelfRenewalSchedule.countdownLabel(now + (2L * 86_400_000 + 3L * 3_600_000), now))
        assertEquals("5h 12m", SelfRenewalSchedule.countdownLabel(now + (5L * 3_600_000 + 12L * 60_000), now))
        assertEquals("45m", SelfRenewalSchedule.countdownLabel(now + 45L * 60_000, now))
        assertEquals("any moment", SelfRenewalSchedule.countdownLabel(now + 5_000L, now))
        assertEquals("any moment", SelfRenewalSchedule.countdownLabel(now - 5_000L, now))
    }

    @Test
    fun `a countdown under an hour is urgent`() {
        assertTrue(SelfRenewalSchedule.isUrgent(now + 30L * 60_000, now))
        assertFalse(SelfRenewalSchedule.isUrgent(now + 2L * 3_600_000, now))
        assertTrue(SelfRenewalSchedule.isUrgent(now - 1L, now)) // already due
    }

    // ── My Score: top offers ────────────────────────────────────────────────

    @Test
    fun `top offers rank most to least`() {
        val score = MyScore.compute(
            listOf(
                MyScore.Sale("1GB", now), MyScore.Sale("1GB", now), MyScore.Sale("1GB", now),
                MyScore.Sale("250MBs", now), MyScore.Sale("250MBs", now),
                MyScore.Sale("50MBs", now)
            ),
            emptyList()
        )
        assertEquals(listOf("1GB" to 3, "250MBs" to 2, "50MBs" to 1), score.topOffers)
    }

    @Test
    fun `top offers break a tie alphabetically for a stable order`() {
        val score = MyScore.compute(
            listOf(MyScore.Sale("Zeta", now), MyScore.Sale("Alpha", now)),
            emptyList()
        )
        assertEquals(listOf("Alpha" to 1, "Zeta" to 1), score.topOffers)
    }

    // ── My Score: hours ─────────────────────────────────────────────────────

    @Test
    fun `busiest and quietest hours come from the sales clock`() {
        val at = { h: Int ->
            Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, h); set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }.timeInMillis
        }
        val score = MyScore.compute(
            listOf(
                MyScore.Sale("a", at(18)), MyScore.Sale("a", at(18)), MyScore.Sale("a", at(18)),
                MyScore.Sale("a", at(9)),
                MyScore.Sale("a", at(3))
            ),
            emptyList()
        )
        assertEquals(18, score.busiestHours.first().startHour)
        assertEquals(3, score.quietestHours.first().startHour)
        assertTrue("bucket labels are a range", score.busiestHours.first().label.contains("–"))
    }

    // ── My Score: success rate + weekday ────────────────────────────────────

    @Test
    fun `success rate is completed over settled`() {
        val score = MyScore.compute(
            emptyList(),
            listOf(
                MyScore.Outcome(true), MyScore.Outcome(true),
                MyScore.Outcome(true), MyScore.Outcome(false),
                MyScore.Outcome(false)
            )
        )
        assertEquals(0.6f, score.successRate!!, 0.001f)
        assertEquals("60%", MyScore.successRateLabel(score.successRate))
    }

    @Test
    fun `success rate is null with no settled rows`() {
        val score = MyScore.compute(emptyList(), emptyList())
        assertNull(score.successRate)
        assertEquals("—", MyScore.successRateLabel(null))
    }

    @Test
    fun `best weekday is the day with most sales`() {
        val on = { dow: Int ->
            Calendar.getInstance().apply {
                set(Calendar.DAY_OF_WEEK, dow); set(Calendar.HOUR_OF_DAY, 12)
                set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
            }.timeInMillis
        }
        val score = MyScore.compute(
            listOf(
                MyScore.Sale("a", on(Calendar.MONDAY)), MyScore.Sale("a", on(Calendar.MONDAY)),
                MyScore.Sale("a", on(Calendar.FRIDAY))
            ),
            emptyList()
        )
        assertEquals(Calendar.MONDAY, score.bestWeekday)
        assertEquals("Monday", MyScore.weekdayName(score.bestWeekday!!))
    }

    @Test
    fun `empty input is the empty score`() {
        assertEquals(MyScore.EMPTY, MyScore.compute(emptyList(), emptyList()))
    }

    // ── Wiring (source guards) ──────────────────────────────────────────────

    @Test
    fun `the self-renewal worker dials due schedules through the pipeline`() {
        val worker = source("app/src/main/java/com/bingwascore/app/workers/SelfRenewalWorker.kt")
        assertTrue("worker runs the pipeline sweep", worker.contains("entryPoint.pipeline().processDueScheduled()"))
        assertTrue("worker arms a delayed alarm", worker.contains("setInitialDelay"))
        assertTrue("worker uses REPLACE so alarms never stack", worker.contains("ExistingWorkPolicy.REPLACE"))
    }

    @Test
    fun `the schedule stores a SCHEDULED row and arms the alarm`() {
        val vm = source("app/src/main/java/com/bingwascore/app/ui/autorenewals/SelfRenewalViewModel.kt")
        assertTrue("the draft validates first", vm.contains("SelfRenewalSchedule.validate(draft, now)"))
        assertTrue("a SCHEDULED row is inserted", vm.contains("SelfRenewalSchedule.toScheduledTx(draft, now)"))
        assertTrue("the alarm is armed", vm.contains("SelfRenewalWorker.arm(context, tx.id, delayMinutes)"))
    }

    @Test
    fun `the autopilot pill stays on home and my score lives in the drawer`() {
        // Stage 19 — Home = greeting+credits, autopilot pill, tiles, chart,
        // airtime, transactions ONLY; My Score moved to the drawer.
        val home = source("app/src/main/java/com/bingwascore/app/ui/home/HomeScreen.kt")
        assertTrue("AutopilotPill is Home's autopilot surface", home.contains("AutopilotPill("))
        assertFalse("no score UI on Home", home.contains("MyScoreCard("))
        val nav = source("app/src/main/java/com/bingwascore/app/ui/navigation/AppNavHost.kt")
        assertTrue("My Score is a drawer item", nav.contains("\"My Score\""))
    }

    @Test
    fun `auto-replies send with zero delay`() {
        val pipeline = source("app/src/main/java/com/bingwascore/app/domain/engine/TransactionPipeline.kt")
        assertTrue(
            "the zero-delay contract is pinned",
            pipeline.contains("const val AUTO_REPLY_DELAY_MILLIS = 0L")
        )
    }
}

