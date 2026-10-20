package com.bingwascore.app.domain

/**
 * Stage 13 — one entry of the plan matrix.
 *
 * Two families, deliberately different currencies:
 *
 * - **individual** (`bulk = false`) — a pulls budget with a validity window:
 *   Starter / Basic / Noob / Pro. The agent tops up what they dial with.
 * - **bulk** (`bulk = true`) — unlimited dials inside a days window:
 *   Small / Medium / Mega / Ultimate. The "office hours" plans for heavy sellers.
 *
 * Pure data, unit-tested through [PlanCatalog] in `Stage13MyPlanTest`.
 */
data class PlanOffer(
    val planId: String,
    val displayName: String,
    /** KSh whole-shilling price — the same integer the M-Pesa STK push asks for. */
    val priceKes: Int,
    /** Dials included; always 0 for bulk plans (they are unlimited). */
    val pulls: Int,
    /** Validity window in days — applies to both families. */
    val days: Int,
    /** True = bulk (unlimited within the window); false = pulls-based individual. */
    val bulk: Boolean
) {
    /** Mirrors [PlanState.unlimited]: bulk plans run on days, not pulls. */
    val unlimited: Boolean get() = bulk

    /** What the matrix card shows under the plan name. */
    val detail: String get() = if (bulk) "Unlimited · $days days" else "$pulls pulls · $days days"

    /** Converts a confirmed purchase into the live [PlanState] at [nowMillis]. */
    fun toPlanState(nowMillis: Long): PlanState = PlanState(
        planId = planId,
        displayName = displayName,
        pullsLeft = pulls,
        unlimited = bulk,
        expiresAtMillis = nowMillis + days * PlanState.DAY_MILLIS
    )
}

/**
 * Stage 13 — the plan matrix, as pure logic.
 *
 * Prices and allowances are fixed here (not fetched), so the confirm sheet, the
 * hero card and the tests all read the same source of truth. [receiptFor]
 * mints the simulated M-Pesa receipt this build shows after the STK push
 * completes; [monogramLetters] feeds the M-Y monogram tile.
 */
object PlanCatalog {

    /** Daily-driver plans: pulls budget + validity window. Ascending price. */
    val individual: List<PlanOffer> = listOf(
        PlanOffer("starter", "Starter", priceKes = 99, pulls = 100, days = 7, bulk = false),
        PlanOffer("basic", "Basic", priceKes = 249, pulls = 350, days = 14, bulk = false),
        PlanOffer("noob", "Noob", priceKes = 449, pulls = 800, days = 30, bulk = false),
        PlanOffer("pro", "Pro", priceKes = 899, pulls = 2_000, days = 30, bulk = false),
    )

    /** Office-hours plans: unlimited dials inside a days window. Ascending price. */
    val bulk: List<PlanOffer> = listOf(
        PlanOffer("small", "Small", priceKes = 499, pulls = 0, days = 3, bulk = true),
        PlanOffer("medium", "Medium", priceKes = 999, pulls = 0, days = 7, bulk = true),
        PlanOffer("mega", "Mega", priceKes = 1_999, pulls = 0, days = 14, bulk = true),
        PlanOffer("ultimate", "Ultimate", priceKes = 3_499, pulls = 0, days = 30, bulk = true),
    )

    /** The whole matrix, in the order the screen renders it. */
    val all: List<PlanOffer> = individual + bulk

    /** Lookup by id; null for anything not in the matrix. */
    fun byId(planId: String): PlanOffer? = all.firstOrNull { it.planId == planId }

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