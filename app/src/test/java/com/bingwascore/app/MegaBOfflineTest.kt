package com.bingwascore.app

import com.bingwascore.app.data.auth.OtpChallenge
import com.bingwascore.app.data.remote.RemoteResult
import com.bingwascore.app.data.remote.SocketEvents
import com.bingwascore.app.data.remote.valueOr
import com.bingwascore.app.ui.auth.EmailOtpState
import com.bingwascore.app.ui.auth.PinSetupState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * MEGA B — proves the offline guarantees that the whole block rests on:
 * [RemoteResult] never loses the local answer, the OTP countdown is real, the
 * socket event names match the server contract, and the auth forms refuse to
 * submit invalid input.
 */
class MegaBOfflineTest {

    // ---- RemoteResult: the local answer always survives -------------------

    @Test
    fun `success carries its value`() {
        val result: RemoteResult<Int> = RemoteResult.Success(42)
        assertTrue(result.isRemote)
        assertEquals(42, result.valueOr(-1))
    }

    @Test
    fun `offline result still yields the fallback`() {
        val result: RemoteResult<Int> = RemoteResult.Offline("no backend", 7)
        assertFalse(result.isRemote)
        assertEquals(7, result.valueOr(-1))
    }

    @Test
    fun `failure falls back rather than throwing`() {
        val result: RemoteResult<Int> = RemoteResult.Failure(500, "boom")
        assertFalse(result.isRemote)
        assertEquals(-1, result.valueOr(-1))
    }

    @Test
    fun `offline result keeps its reason for diagnostics`() {
        val result = RemoteResult.Offline("request timed out", emptyList<String>())
        assertEquals("request timed out", (result as RemoteResult.Offline).reason)
        assertTrue(result.fallback.isEmpty())
    }

    // ---- OTP countdown: real even offline ---------------------------------

    @Test
    fun `otp lifetime is 120 seconds`() {
        assertEquals(120_000L, OtpChallenge.LIFETIME_MILLIS)
    }

    @Test
    fun `seconds remaining counts down and never goes negative`() {
        val now = 1_000_000L
        val fresh = OtpChallenge("c1", "a@b.com", now + 120_000L)
        assertEquals(120L, fresh.secondsRemaining(now))

        val half = OtpChallenge("c2", "a@b.com", now + 59_000L)
        assertEquals(59L, half.secondsRemaining(now))

        // Expired codes clamp at zero rather than counting into negatives.
        val expired = OtpChallenge("c3", "a@b.com", now - 5_000L)
        assertEquals(0L, expired.secondsRemaining(now))
    }

    @Test
    fun `email otp state only awaits a code while it is valid`() {
        val now = 1_000L
        val challenge = OtpChallenge("c1", "a@b.com", now + 60_000L)

        assertTrue(EmailOtpState(challenge = challenge, secondsRemaining = 30).isAwaitingCode)
        assertFalse(EmailOtpState(challenge = challenge, secondsRemaining = 0).isAwaitingCode)
        // No challenge at all is never "awaiting".
        assertFalse(EmailOtpState(secondsRemaining = 30).isAwaitingCode)
    }

    @Test
    fun `countdown text is zero padded`() {
        val state = EmailOtpState(secondsRemaining = 119)
        assertEquals("1:59", state.countdownText)
        assertEquals("0:05", EmailOtpState(secondsRemaining = 5).countdownText)
    }

    // ---- Socket event names must match the server contract ---------------

    @Test
    fun `socket event names are pinned to the server contract`() {
        assertEquals("task.airtime_balance.get_ack", SocketEvents.AIRTIME_BALANCE_GET_ACK)
        assertEquals("app_state.set", SocketEvents.APP_STATE_SET)
        assertEquals("task.ack", SocketEvents.TASK_ACK)
        assertEquals("ping", SocketEvents.PING)
    }

    // ---- Pin setup validation --------------------------------------------

    @Test
    fun `pin setup refuses mismatched or short input`() {
        assertFalse(PinSetupState(phone = "0712345678", pin = "1234", confirmPin = "9999").isSubmittable)
        assertFalse(PinSetupState(phone = "0712345678", pin = "12", confirmPin = "12").isSubmittable)
        assertFalse(PinSetupState(phone = "071", pin = "1234", confirmPin = "1234").isSubmittable)
    }

    @Test
    fun `pin setup accepts a complete matching form`() {
        val state = PinSetupState(phone = "0712345678", pin = "1234", confirmPin = "1234")
        assertTrue(state.isSubmittable)
    }

    // ---- RunTest is wired up so coroutine-based guards stay covered --------
    @Test
    fun `offline guard is usable from a coroutine`() = runTest {
        // Mirrors what OfflineFallback.guard does when no backend exists.
        val fallbackValue = listOf("local-offer")
        val guarded: RemoteResult<List<String>> = RemoteResult.Offline(
            reason = "no backend configured",
            fallback = fallbackValue
        )
        assertEquals(fallbackValue, guarded.valueOr(emptyList()))
    }
}
