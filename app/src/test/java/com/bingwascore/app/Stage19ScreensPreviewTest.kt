package com.bingwascore.app

import app.cash.paparazzi.Paparazzi
import com.bingwascore.app.data.local.Offer
import com.bingwascore.app.data.local.Transaction
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.domain.PlanState
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.domain.engine.UssdConsoleLine
import com.bingwascore.app.profile.ProfileScreenContent
import com.bingwascore.app.profile.ProfileScreenState
import com.bingwascore.app.ui.dialer.DialerScreenContent
import com.bingwascore.app.ui.dialer.DialerScreenState
import com.bingwascore.app.ui.home.HomeScreenContent
import com.bingwascore.app.ui.home.HomeScreenState
import com.bingwascore.app.ui.myplan.MyPlanScreenContent
import com.bingwascore.app.ui.myplan.MyPlanScreenState
import com.bingwascore.app.ui.offers.OffersScreenContent
import com.bingwascore.app.ui.offers.OffersScreenState
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import com.bingwascore.app.ui.transactions.TransactionFilter
import com.bingwascore.app.ui.transactions.TransactionsScreenContent
import com.bingwascore.app.ui.transactions.TransactionsScreenState
import com.bingwascore.app.util.Haptics
import org.junit.Rule
import org.junit.Test

/**
 * Stage 19.7 — the EYES: Paparazzi snapshots of every pure screen Content.
 *
 * Each screen is rendered from fake state in BOTH themes (Obsidian + Porcelain),
 * so a theme regression, a spacing break or a wordmark typo shows up as a
 * picture, not as a line of code.
 *
 * The screens are rendered through their `XxxScreenContent` composables: no
 * ViewModel, no Activity, no lifecycle — exactly the purity the refactor
 * promises. Haptics are [Haptics.Disabled] so a snapshot never buzzes.
 */
class Stage19ScreensPreviewTest {

    @get:Rule
    val paparazzi = Paparazzi()

    // ── Home ────────────────────────────────────────────────────────────────

    @Test
    fun homeDark() = snapshot(ThemeMode.DARK) {
        HomeScreenContent(state = FakeHome.state, haptics = Haptics.Disabled)
    }

    @Test
    fun homeLight() = snapshot(ThemeMode.LIGHT) {
        HomeScreenContent(state = FakeHome.state, haptics = Haptics.Disabled)
    }

    @Test
    fun homeEmptyDark() = snapshot(ThemeMode.DARK) {
        HomeScreenContent(
            state = FakeHome.state.copy(
                transactions = emptyList(),
                creditsLabel = "0",
                engineState = EngineState.STOPPED
            ),
            haptics = Haptics.Disabled
        )
    }

    @Test
    fun homeEmptyLight() = snapshot(ThemeMode.LIGHT) {
        HomeScreenContent(
            state = FakeHome.state.copy(
                transactions = emptyList(),
                creditsLabel = "0",
                engineState = EngineState.STOPPED
            ),
            haptics = Haptics.Disabled
        )
    }

    // ── Offers ──────────────────────────────────────────────────────────────

    @Test
    fun offersDark() = snapshot(ThemeMode.DARK) {
        OffersScreenContent(state = FakeOffers.state, haptics = Haptics.Disabled)
    }

    @Test
    fun offersLight() = snapshot(ThemeMode.LIGHT) {
        OffersScreenContent(state = FakeOffers.state, haptics = Haptics.Disabled)
    }

    // ── Dialer ──────────────────────────────────────────────────────────────

    @Test
    fun dialerDark() = snapshot(ThemeMode.DARK) {
        DialerScreenContent(state = FakeDialer.state)
    }

    @Test
    fun dialerLight() = snapshot(ThemeMode.LIGHT) {
        DialerScreenContent(state = FakeDialer.state)
    }

    // ── Transactions ────────────────────────────────────────────────────────

    @Test
    fun transactionsDark() = snapshot(ThemeMode.DARK) {
        TransactionsScreenContent(state = FakeTransactions.state)
    }

    @Test
    fun transactionsLight() = snapshot(ThemeMode.LIGHT) {
        TransactionsScreenContent(state = FakeTransactions.state)
    }

    // ── Profile ─────────────────────────────────────────────────────────────

    @Test
    fun profileDark() = snapshot(ThemeMode.DARK) {
        ProfileScreenContent(state = FakeProfile.state)
    }

    @Test
    fun profileLight() = snapshot(ThemeMode.LIGHT) {
        ProfileScreenContent(state = FakeProfile.state)
    }

    // Stage 21 — the onboarding and the splash moved to their own suite
    // (Stage21FirstRunPreviewTest): the first run is the one surface that
    // must be proven in EVERY page, BOTH themes and in landscape.

    // ── My Plan ─────────────────────────────────────────────────────────────

    /** STEADY family, on the active plan's page: badge + countdown, no CTA. */
    @Test
    fun myPlanDark() = snapshot(ThemeMode.DARK) {
        MyPlanScreenContent(state = FakeMyPlan.state, haptics = Haptics.Disabled)
    }

    @Test
    fun myPlanLight() = snapshot(ThemeMode.LIGHT) {
        MyPlanScreenContent(state = FakeMyPlan.state, haptics = Haptics.Disabled)
    }

    /** BULK ENGINE family, on a plan with no CTA-blocked page: the price CTA. */
    @Test
    fun myPlanBulkDark() = snapshot(ThemeMode.DARK) {
        MyPlanScreenContent(state = FakeMyPlan.bulkState, haptics = Haptics.Disabled)
    }

    @Test
    fun myPlanBulkLight() = snapshot(ThemeMode.LIGHT) {
        MyPlanScreenContent(state = FakeMyPlan.bulkState, haptics = Haptics.Disabled)
    }

    /** Renders one screen in one theme, with haptics muted. */
    private fun snapshot(mode: ThemeMode, content: @androidx.compose.runtime.Composable () -> Unit) {
        paparazzi.snapshot {
            // LocalInspectionMode: the enter clock does not run outside a live
            // frame, so this draws every screen exactly as it lands.
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalInspectionMode provides true
            ) {
                BingwaScoreTheme(themeMode = mode) {
                    content()
                }
            }
        }
    }
}

/** Fake state for the snapshots: the shapes an agent would actually see. */
private object FakeHome {

    val state = HomeScreenState(
        greetingBucket = com.bingwascore.app.ui.home.Greetings.Bucket.MORNING,
        greetingLanguage = com.bingwascore.app.ui.home.Greetings.Language.SWAHILI,
        creditsLabel = "417",
        successful = 128,
        failed = 3,
        pending = 6,
        commission = listOf(420.0, 610.0, 380.0, 900.0, 720.0, 1_040.0, 860.0),
        airtimeToday = 2_450.0,
        balance = 18_320.5,
        balanceLoading = false,
        statsLoading = false,
        engineState = EngineState.RUNNING,
        transactions = listOf(
            FakeTransactions.tx(1, "DENNIS K WACHIRA", "Safaricom 1GB", 50.0, TransactionStatus.SUCCESSFUL.value),
            FakeTransactions.tx(2, "MARY WANGARI", "Safaricom 500MB", 30.0, TransactionStatus.PENDING.value),
            FakeTransactions.tx(3, "JOSEPH MUSA", "Safaricom 5GB", 100.0, TransactionStatus.SUCCESSFUL.value),
            FakeTransactions.tx(4, "PETER ODHIAMBO", "Safaricom 1GB", 50.0, TransactionStatus.FAILED.value)
        ),
        permissionsMissing = false,
        valuesVisible = true
    )
}

private object FakeOffers {

    val state = OffersScreenState(
        offers = listOf(
            Offer(
                id = "offer-1",
                name = "Safaricom 1GB Daily",
                price = 50,
                ussdCode = "*544*2*1*1*ph#",
                isActive = true,
                type = "DATA",
                isVerified = true
            ),
            Offer(
                id = "offer-2",
                name = "Safaricom 500MB",
                price = 30,
                ussdCode = "*544*2*2*1*ph#",
                isActive = true,
                type = "DATA"
            ),
            Offer(
                id = "offer-3",
                name = "Safaricom 5GB",
                price = 100,
                ussdCode = "*544*2*3*1*ph#",
                isActive = true,
                type = "DATA"
            ),
            Offer(
                id = "offer-4",
                name = "Airtime 100",
                price = 100,
                ussdCode = "*544*1*1*ph#",
                isActive = false,
                type = "AIRTIME"
            )
        ),
        isLoading = false,
        isBatching = false,
        lastDialPhone = "0712345678",
        category = com.bingwascore.app.ui.offers.OfferCategory.ALL,
        selectionMode = false
    )
}

private object FakeDialer {

    val state = DialerScreenState(
        offers = listOf(
            Offer(
                id = "offer-1",
                name = "Safaricom 1GB Daily",
                price = 50,
                ussdCode = "*544*2*1*1*ph#",
                isActive = true,
                type = "DATA"
            ),
            Offer(
                id = "offer-2",
                name = "Safaricom 500MB",
                price = 30,
                ussdCode = "*544*2*2*1*ph#",
                isActive = true,
                type = "DATA"
            )
        ),
        phone = "0712345678",
        selectedOfferId = "offer-1",
        isDialing = false,
        consoleLines = listOf(
            UssdConsoleLine("code", "Sent *544*2*1*1*0712345678#"),
            UssdConsoleLine("response", "1. Safaricom 1GB Daily")
        ),
        consoleOpen = true
    )
}

private object FakeTransactions {

    /**
     * A FIXED clock anchor (2026-01-15 10:00 UTC).
     *
     * The rows are older than a week on purpose: both the row stamp and the day
     * header then render an absolute date, so the golden image is byte-stable
     * forever instead of drifting every hour ("1h ago" -> "2h ago").
     */
    const val ANCHOR = 1_768_471_200_000L

    fun tx(
        id: Long,
        name: String,
        offer: String,
        amount: Double,
        status: String
    ): Transaction = Transaction(
        id = "tx-$id",
        phoneNumber = "0712345678",
        customerName = name,
        offerId = "offer-1",
        offerName = offer,
        ussdCode = "*544*2*1*1*ph#",
        amount = amount,
        commission = amount / 10.0,
        status = status,
        createdAt = ANCHOR - id * 3_600_000L
    )

    val state = TransactionsScreenState(
        transactions = listOf(
            tx(1, "DENNIS K WACHIRA", "Safaricom 1GB", 50.0, TransactionStatus.SUCCESSFUL.value),
            tx(2, "MARY WANGARI", "Safaricom 500MB", 30.0, TransactionStatus.PENDING.value),
            tx(3, "JOSEPH MUSA", "Safaricom 5GB", 100.0, TransactionStatus.SUCCESSFUL.value),
            tx(4, "PETER ODHIAMBO", "Safaricom 1GB", 50.0, TransactionStatus.FAILED.value)
        ),
        selectedFilter = TransactionFilter.ALL,
        isLoading = false,
        hasSelection = false,
        searchQuery = "",
        phoneFilter = null
    )
}

private object FakeProfile {

    val state = ProfileScreenState(
        userName = "Dennis K. Wachira",
        phone = "0712345678",
        levelName = "Gold",
        score = 1_240,
        engineEnabled = true,
        engineState = EngineState.RUNNING
    )
}

private object FakeMyPlan {

    /**
     * A FIXED clock anchor, so the countdown and the plan window render the
     * same numbers in every recording.
     */
    val state = MyPlanScreenState(
        plan = PlanState(
            planId = "basic",
            displayName = "Basic",
            pullsLeft = 417,
            unlimited = false,
            expiresAtMillis = FakeTransactions.ANCHOR + 3 * PlanState.DAY_MILLIS + 4 * 3_600_000L
        ),
        credits = 12,
        nowMillis = FakeTransactions.ANCHOR
    )

    /** The same agent, looking at the BULK ENGINE family. */
    val bulkState = state.copy(family = com.bingwascore.app.domain.PlanFamily.BULK_ENGINE)
}
