package com.bingwascore.app

import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.domain.AppState
import com.bingwascore.app.domain.ProcessingActivity
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.services.UssdResponses
import com.bingwascore.app.ui.coupons.RedeemCouponViewModel
import com.bingwascore.app.ui.offers.OfferSettingsValidation
import com.bingwascore.app.ui.offers.OfferSettingsValidator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * MEGA A — covers the engine-facing logic with no Android dependency:
 * per-offer timeout resolution, the USSD classifier's connection-problem rules,
 * the offer-settings validator, coupon codes and the startup-gate enums.
 */
class MegaAEngineTest {

    private fun offer(
        timeoutSeconds: Int = 20,
        autoRetry: Boolean = false,
        strictMode: Boolean = false,
        retryOnConnectionProblem: Boolean = false,
        legacyTimeoutMillis: Long = 15000L
    ) = Offer(
        id = "o1",
        name = "250MBs, 24hrs",
        ussdCode = "*544*2*1*1*ph#",
        price = 20,
        ussdTimeoutSeconds = timeoutSeconds,
        autoRetry = autoRetry,
        strictMode = strictMode,
        autoRetryConnectionProblems = retryOnConnectionProblem,
        ussdTimeoutMillis = legacyTimeoutMillis
    )

    // ---- Offer personality -------------------------------------------------

    @Test
    fun `timeout uses per-offer seconds`() {
        assertEquals(45_000L, Offer.timeoutMillisFor(offer(timeoutSeconds = 45)))
    }

    @Test
    fun `timeout falls back to legacy millis when seconds unset`() {
        // An offer that predates the seconds field has 0 — use the old value.
        assertEquals(
            9_000L,
            Offer.timeoutMillisFor(offer(timeoutSeconds = 0, legacyTimeoutMillis = 9000L))
        )
    }

    @Test
    fun `coupon flag derives from the coupon tag`() {
        assertFalse(offer().isCoupon)
        assertTrue(offer().copy(tag = Offer.TAG_COUPON).isCoupon)
    }

    // ---- USSD classification ----------------------------------------------

    @Test
    fun `connection problems are detected for retry purposes`() {
        assertTrue(UssdResponses.isConnectionProblem("Connection problem or invalid MMI code"))
        assertTrue(UssdResponses.isConnectionProblem("No network. Try again later"))
        assertFalse(UssdResponses.isConnectionProblem("You have successfully purchased 250MBs"))
    }

    @Test
    fun `already recommended still classifies before the success regex`() {
        assertEquals(
            TransactionStatus.FAILED_ALREADY_RECOMMENDED,
            UssdResponses.classify("Number already been recommended")
        )
    }

    @Test
    fun `airtime balance label counts as a successful reply`() {
        assertEquals(
            TransactionStatus.SUCCESSFUL,
            UssdResponses.classify("Airtime Bal: 1,234.56 Ksh, M-PESA")
        )
    }

    // ---- Startup gate enums ------------------------------------------------

    @Test
    fun `app state round trips through its value`() {
        AppState.entries.forEach { state ->
            assertEquals(state, AppState.fromValue(state.value))
        }
        // An unknown persisted value must not crash the splash.
        assertEquals(AppState.STATE_SETUP, AppState.fromValue("nonsense"))
        assertEquals(AppState.STATE_SETUP, AppState.fromValue(null))
    }

    @Test
    fun `processing activity carries the notification wording`() {
        assertEquals("Processing", ProcessingActivity.DIALING.notificationText)
        assertEquals("Processing transaction", ProcessingActivity.SENDING_REPLY.notificationText)
        assertEquals(ProcessingActivity.IDLE, ProcessingActivity.fromValue("unknown"))
    }

    // ---- Coupon codes ------------------------------------------------------

    @Test
    fun `coupon code normalisation uppercases and trims`() {
        assertEquals("BINGWA20", RedeemCouponViewModel.normalize("  bingwa20 "))
    }

    @Test
    fun `coupon code well formedness respects length and charset`() {
        assertTrue(RedeemCouponViewModel.isWellFormed("BINGWA20"))
        assertFalse(RedeemCouponViewModel.isWellFormed("BING"))
        assertFalse(RedeemCouponViewModel.isWellFormed("BINGWA-20"))
        assertFalse(RedeemCouponViewModel.isWellFormed(""))
    }

    // ---- Offer settings validation ----------------------------------------

    @Test
    fun `valid settings are applied and marked dirty`() {
        val result = OfferSettingsValidator.validate(
            offer = offer(),
            numberOfRetries = "4",
            retryIntervalMins = "7",
            ussdTimeoutSeconds = "30",
            rescheduleTime = "08:00",
            autoReschedule = true,
            completionMessage = "Enjoy!",
            type = Offer.TYPE_DATA,
            autoRetryConnectionProblems = true
        )
        assertTrue(result is OfferSettingsValidation.Valid)
        val saved = (result as OfferSettingsValidation.Valid).offer
        assertEquals(4, saved.numberOfRetries)
        assertEquals(7, saved.retryIntervalMins)
        assertEquals(30, saved.ussdTimeoutSeconds)
        // Legacy millis stays in sync with the seconds field.
        assertEquals(30_000L, saved.ussdTimeoutMillis)
        assertTrue(saved.autoRetryConnectionProblems)
        assertTrue(saved.isDirty)
        assertEquals("Enjoy!", saved.completionMessage)
    }

    @Test
    fun `non-numeric retries are rejected with a message`() {
        val result = OfferSettingsValidator.validate(
            offer = offer(),
            numberOfRetries = "",
            retryIntervalMins = "5",
            ussdTimeoutSeconds = "20",
            rescheduleTime = "",
            autoReschedule = false,
            completionMessage = "",
            type = Offer.TYPE_DATA,
            autoRetryConnectionProblems = false
        )
        assertTrue(result is OfferSettingsValidation.Invalid)
        assertTrue((result as OfferSettingsValidation.Invalid).message.isNotBlank())
    }

    @Test
    fun `timeout outside the allowed range is rejected`() {
        val result = OfferSettingsValidator.validate(
            offer = offer(),
            numberOfRetries = "1",
            retryIntervalMins = "5",
            ussdTimeoutSeconds = "9999",
            rescheduleTime = "",
            autoReschedule = false,
            completionMessage = "",
            type = Offer.TYPE_DATA,
            autoRetryConnectionProblems = false
        )
        assertTrue(result is OfferSettingsValidation.Invalid)
    }

    @Test
    fun `bad reschedule time is only rejected when reschedule is on`() {
        val bad = OfferSettingsValidator.validate(
            offer = offer(),
            numberOfRetries = "1",
            retryIntervalMins = "5",
            ussdTimeoutSeconds = "20",
            rescheduleTime = "99:99",
            autoReschedule = true,
            completionMessage = "",
            type = Offer.TYPE_DATA,
            autoRetryConnectionProblems = false
        )
        assertTrue(bad is OfferSettingsValidation.Invalid)

        val ignored = OfferSettingsValidator.validate(
            offer = offer(),
            numberOfRetries = "1",
            retryIntervalMins = "5",
            ussdTimeoutSeconds = "20",
            rescheduleTime = "99:99",
            autoReschedule = false,
            completionMessage = "",
            type = Offer.TYPE_DATA,
            autoRetryConnectionProblems = false
        )
        assertTrue(ignored is OfferSettingsValidation.Valid)
    }

    @Test
    fun `run time validation accepts 24-hour forms and rejects nonsense`() {
        assertTrue(OfferSettingsValidator.isValidRunTime("08:00"))
        assertTrue(OfferSettingsValidator.isValidRunTime("8:00"))
        assertTrue(OfferSettingsValidator.isValidRunTime("23:59"))
        assertFalse(OfferSettingsValidator.isValidRunTime("24:00"))
        assertFalse(OfferSettingsValidator.isValidRunTime("12:60"))
        assertFalse(OfferSettingsValidator.isValidRunTime("nope"))
    }
}
