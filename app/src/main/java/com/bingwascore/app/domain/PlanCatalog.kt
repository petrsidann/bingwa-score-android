package com.bingwascore.app.domain

/**
 * Stage 20 — the two paywall families.
 *
 * **STEADY** is the everyday pull pack: a counted number of USSD dials you
 * spend down. **BULK ENGINE** is the office-hours plan: unlimited dials inside
 * a window. The pill on the paywall switches between them; each family is four
 * pages of one plan each.
 */
enum class PlanFamily(val label: String) {
    STEADY("STEADY"),
    BULK_ENGINE("BULK ENGINE")
}

/**
 * Stage 20 — one entry of the plan matrix.
 *
 * Two families, deliberately different currencies:
 *
 * - **individual** (`bulk = false`) — the STEADY family: a pulls budget with a
 *   validity window (Starter / Basic / Noob / Pro). Starter is the one-day
 *   unlimited pass.
 * - **bulk** (`bulk = true`) — the BULK ENGINE family: unlimited dials inside a
 *   days window (Small / Medium / Mega / Ultimate). The "office hours" plans
 *   for heavy sellers.
 *
 * Pure data, unit-tested through [PlanCatalog] in `PlanMatrixTest` and
 * `Stage13MyPlanTest`.
 */
data class PlanOffer(
    val planId: String,
    val displayName: String,
    /** KSh whole-shilling price — the same integer the M-Pesa STK push asks for. */
    val priceKes: Int,
    /** Dials included; 0 means unlimited. */
    val pulls: Int,
    /** Validity window in days — applies to both families. */
    val days: Int,
    /** True = bulk (unlimited within the window); false = pulls-based individual. */
    val bulk: Boolean
) {
    /**
     * Unlimited = a bulk engine, or a steady plan that is unlimited for its
     * window (Starter: unlimited dials for one day).
     */
    val unlimited: Boolean get() = bulk || pulls <= 0

    /** The family this offer is sold in. */
    val family: PlanFamily get() = if (bulk) PlanFamily.BULK_ENGINE else PlanFamily.STEADY

    /** The window, in words: "1 day", "7 days", "1 month", "3 months". */
    val durationLabel: String get() = when (days) {
        1 -> "1 day"
        30 -> "1 month"
        90 -> "3 months"
        else -> "$days days"
    }

    /** What the agent gets: "Unlimited USSD pulls" or "1,000 pulls". */
    val allowanceLabel: String get() =
        if (unlimited) "Unlimited USSD pulls" else "${group(pulls)} pulls"

    /**
     * Stage 20 — the truth line under the plan title: what you get, and for
     * how long. Never a promise the plan facts cannot keep.
     */
    val truthSubtitle: String get() = "$allowanceLabel · $durationLabel"

    /** The matrix line under the plan name (the confirm copy reads it). */
    val detail: String get() = truthSubtitle

    // ── Stage 20 — the three benefit rows, derived only from plan facts ──────

    /** Benefit 1 — what the plan gives. */
    val allowanceTitle: String get() =
        if (unlimited) "Unlimited USSD pulls" else "${group(pulls)} USSD pulls"

    /** Benefit 1 — in words. */
    val allowanceDesc: String get() = if (unlimited) {
        "Dial as many bundles as you like."
    } else {
        "Dial up to ${group(pulls)} bundles on this plan."
    }

    /** Benefit 2 — how long it lives. */
    val windowTitle: String get() = "Valid for $durationLabel"

    /** Benefit 2 — in words. */
    val windowDesc: String get() = "Opens when you activate. Closes on its own."

    /** Benefit 3 — what it costs. */
    val priceTitle: String get() = "Ksh $priceKes, paid once"

    /** Benefit 3 — in words. */
    val priceDesc: String get() = "One M-Pesa payment, nothing more to pay."

    /** The legal microcopy under the CTA. */
    val legalLine: String get() =
        "One M-Pesa payment of Ksh $priceKes · $durationLabel · no auto-renew."

    /** The full-width CTA: "Activate <Plan> - Ksh <price>". */
    val ctaLabel: String get() = "Activate $displayName - Ksh $priceKes"

    /** The month count when the window is sold in months (0 = sold in days). */
    val monthCount: Int get() = when (days) {
        30 -> 1
        90 -> 3
        else -> 0
    }

    /** Converts a confirmed purchase into the live [PlanState] at [nowMillis]. */
    fun toPlanState(nowMillis: Long): PlanState = PlanState(
        planId = planId,
        displayName = displayName,
        pullsLeft = pulls,
        unlimited = unlimited,
        expiresAtMillis = nowMillis + days * PlanState.DAY_MILLIS
    )

    companion object {
        /** 1000 -> "1,000" — the thousands separator the paywall prints. */
        fun group(value: Int): String {
            val raw = value.toString()
            if (raw.length <= 3) return raw
            return raw.dropLast(3) + "," + raw.takeLast(3)
        }
    }
}

/**
 * Stage 13 — the plan matrix, as pure logic.
 *
 * Prices and allowances are fixed here (not fetched), so the paywall pages, the
 * purchase flow and the tests all read the same source of truth. [receiptFor]
 * mints the simulated M-Pesa receipt this build shows after the STK push
 * completes; [monogramLetters] feeds the M-Y monogram mark.
 */
object PlanCatalog {

    /** Daily-driver plans: pulls budget + validity window. Ascending price. */
    val individual: List<PlanOffer> = listOf(
        PlanOffer("starter", "Starter", priceKes = 20, pulls = 0, days = 1, bulk = false),
        PlanOffer("basic", "Basic", priceKes = 25, pulls = 1_000, days = 7, bulk = false),
        PlanOffer("noob", "Noob", priceKes = 55, pulls = 2_500, days = 30, bulk = false),
        PlanOffer("pro", "Pro", priceKes = 110, pulls = 5_000, days = 30, bulk = false),
    )

    /** Office-hours plans: unlimited dials inside a days window. Ascending price. */
    val bulk: List<PlanOffer> = listOf(
        PlanOffer("small", "Small", priceKes = 60, pulls = 0, days = 3, bulk = true),
        PlanOffer("medium", "Medium", priceKes = 140, pulls = 0, days = 7, bulk = true),
        PlanOffer("mega", "Mega", priceKes = 600, pulls = 0, days = 30, bulk = true),
        PlanOffer("ultimate", "Ultimate", priceKes = 1_800, pulls = 0, days = 90, bulk = true),
    )

    /** The STEADY family under its paywall name. */
    val steady: List<PlanOffer> get() = individual

    /** The BULK ENGINE family under its paywall name. */
    val bulkEngine: List<PlanOffer> get() = bulk

    /** The whole matrix, in the order the screen renders it. */
    val all: List<PlanOffer> = individual + bulk

    /** Lookup by id; null for anything not in the matrix. */
    fun byId(planId: String): PlanOffer? = all.firstOrNull { it.planId == planId }

    /** The four pages of one family. */
    fun family(family: PlanFamily): List<PlanOffer> =
        if (family == PlanFamily.BULK_ENGINE) bulk else individual

    /**
     * The simulated M-Pesa receipt: "S" + nine digits, like the real ones.
     * Deterministic in (planId, nowMillis) so the unit test can pin it.
     */
    fun receiptFor(planId: String, nowMillis: Long): String {
        val seed = (nowMillis / 1000 + planId.hashCode()).let { if (it < 0) -it else it }
        return "S%09d".format(seed % 1_000_000_000L)
    }

    /**
     * The M-Y monogram tile: first two letters of the plan name, or the
     * "MY" (from *My* Plan) mark while no plan is active.
     */
    fun monogramLetters(displayName: String): String =
        displayName.trim().take(2).uppercase().ifBlank { "MY" }
}
