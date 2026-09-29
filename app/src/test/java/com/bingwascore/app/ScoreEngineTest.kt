package com.bingwascore.app

import com.bingwascore.app.data.local.Customer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.score.ScoreEngine
import com.bingwascore.app.engagebot.BotLogKind
import com.bingwascore.app.ui.engagebot.botLogColor
import com.bingwascore.app.ui.theme.Amber
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.Orange500
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Audit G9: ScoreEngine levels/streaks + botLogColor mapping. Pure JVM.
 */
class ScoreEngineTest {

    private val engine = ScoreEngine()

    private fun tx(status: String, commission: Double = 0.0, createdAt: Long = 1_700_000_000_000L) =
        Transaction(
            id = "tx-${Math.random()}",
            phoneNumber = "0712345678",
            customerName = "John",
            offerId = "o1",
            offerName = "1GB",
            ussdCode = "*544#",
            amount = 20.0,
            commission = commission,
            status = status,
            createdAt = createdAt
        )

    private fun customer() = Customer(
        phoneNumber = "0712345678",
        name = "John",
        isBlacklisted = false,
        createdAt = 1_700_000_000_000L
    )

    @Test
    fun levelFor_thresholds() {
        assertEquals("Bronze", engine.levelFor(0).first)
        assertEquals("Silver", engine.levelFor(500).first)
        assertEquals("Gold", engine.levelFor(1500).first)
        assertEquals("Platinum", engine.levelFor(4000).first)
        assertEquals("Diamond", engine.levelFor(10000).first)
        assertEquals(1f, engine.levelFor(99999).third, 0.001f)
    }

    @Test
    fun compute_countsOnlySuccessful() {
        val list = listOf(
            tx(TransactionStatus.SUCCESSFUL.value, commission = 10.0),
            tx(TransactionStatus.FAILED.value, commission = 99.0),
            tx(TransactionStatus.SUCCESSFUL.value, commission = 5.0)
        )
        val state = engine.compute(list, listOf(customer()))
        assertEquals(15.0, state.totalCommission, 0.001)
        assertEquals(2 / 3f, state.successRate, 0.001f)
        assertEquals(1, state.customersServed)
        assertTrue(state.score > 0)
    }

    @Test
    fun botLogColor_mapping() {
        assertEquals(Amber, botLogColor(BotLogKind.ENGAGE))
        assertEquals(EmeraldGreen, botLogColor(BotLogKind.SUCCESS))
        assertEquals(Orange500, botLogColor(BotLogKind.INVALID))
        assertEquals(ErrorRed, botLogColor(BotLogKind.ERROR))
    }
}
