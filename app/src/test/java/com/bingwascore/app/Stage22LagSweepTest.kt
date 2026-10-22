package com.bingwascore.app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 22 — the LAG SWEEP, pinned by composition counts.
 *
 * A frame that changes nothing about the rows must compose ZERO rows. That is
 * the 60fps-equivalent invariant: work is proportional to what moved, never to
 * how many rows happen to be on screen.
 *
 * This is a pure-JVM model of Compose's skipping law: a row's body re-runs iff
 * one of its parameters changed since the last composition. A remembered action
 * keeps its identity, so an unrelated recomposition passes identical params and
 * the row skips; an inline action is a new object every frame, so the row's
 * params differ and it recomposes — exactly the >16ms hitch the sweep removed.
 *
 * The source checks below pin the same law on the three real scroll paths that
 * matter: Home, Offers and Transactions.
 */
class Stage22LagSweepTest {

    /** One row's composition state in the model. */
    private data class RowState(
        val id: String,
        var params: List<Any?>,
        var compositions: Int = 1   // the initial composition
    )

    /** A tiny composition engine: renderRow returns true iff the row's body ran. */
    private class ScrollModel {
        val rows = mutableMapOf<String, RowState>()

        /** The initial composition has already happened; params are frozen as-is. */
        fun register(initial: Map<String, List<Any?>>) {
            initial.forEach { (id, params) -> rows[id] = RowState(id, params, compositions = 1) }
        }

        /** One frame: the parent re-renders and re-invokes the row. */
        fun renderRow(id: String, newParams: List<Any?>): Boolean {
            val row = rows[id] ?: return false
            if (row.params == newParams) return false // skipped
            row.params = newParams.toList()
            row.compositions++
            return true
        }
    }

    /** A stable action: one instance per id, exactly like [rememberAction]. */
    private val stableCache = mutableMapOf<String, () -> Unit>()
    private fun stableAction(id: String): () -> Unit =
        stableCache.getOrPut(id) { { val captured = id } }

    /** An inline action: a new instance every call, like the old app code. */
    private fun inlineAction(id: String): () -> Unit = { val captured = id }

    // ── The invariants ───────────────────────────────────────────────────────

    @Test
    fun `a frame that moves nothing composes no rows`() {
        val model = ScrollModel()
        val actions = mapOf("a" to stableAction("a"), "b" to stableAction("b"), "c" to stableAction("c"))
        model.register(mapOf(
            "a" to listOf("a", "row-a", actions["a"]),
            "b" to listOf("b", "row-b", actions["b"]),
            "c" to listOf("c", "row-c", actions["c"])
        ))
        // Two frames whose row inputs did not change: the rows must skip.
        repeat(2) {
            model.renderRow("a", listOf("a", "row-a", actions["a"]))
            model.renderRow("b", listOf("b", "row-b", actions["b"]))
            model.renderRow("c", listOf("c", "row-c", actions["c"]))
        }
        listOf("a", "b", "c").forEach { id ->
            assertEquals("row $id must compose once, not per frame", 1, model.rows[id]!!.compositions)
        }
    }

    @Test
    fun `inline actions recompose every row every frame`() {
        val model = ScrollModel()
        val params = mapOf(
            "a" to listOf("a", "row-a", inlineAction("a")),
            "b" to listOf("b", "row-b", inlineAction("b")),
            "c" to listOf("c", "row-c", inlineAction("c"))
        )
        model.register(params)
        model.renderRow("a", listOf("a", "row-a", inlineAction("a")))
        model.renderRow("b", listOf("b", "row-b", inlineAction("b")))
        model.renderRow("c", listOf("c", "row-c", inlineAction("c")))
        // The inline lambda is a new object every frame, so every row
        // recomposes — the hitch the sweep removed.
        listOf("a", "b", "c").forEach { id ->
            assertEquals("row $id must recompose with an inline action", 2, model.rows[id]!!.compositions)
        }
    }

    @Test
    fun `only the row that changed recomposes`() {
        val model = ScrollModel()
        val actions = mapOf("a" to stableAction("a"), "b" to stableAction("b"), "c" to stableAction("c"))
        model.register(mapOf(
            "a" to listOf("a", "row-a", actions["a"]),
            "b" to listOf("b", "row-b", actions["b"]),
            "c" to listOf("c", "row-c", actions["c"])
        ))
        model.renderRow("a", listOf("a", "row-a", actions["a"]))
        model.renderRow("b", listOf("b", "row-b-updated", actions["b"]))
        model.renderRow("c", listOf("c", "row-c", actions["c"]))
        assertEquals("the changed row must recompose", 2, model.rows["b"]!!.compositions)
        assertEquals("an untouched row must skip", 1, model.rows["a"]!!.compositions)
        assertEquals("an untouched row must skip", 1, model.rows["c"]!!.compositions)
    }

    // ── The same law, pinned on the three real scroll paths ─────────────────

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun source(path: String): String = File(repoRoot, path).readText()

    private val scrollPaths = listOf(
        "app/src/main/java/com/bingwascore/app/ui/home/HomeScreen.kt",
        "app/src/main/java/com/bingwascore/app/ui/offers/OffersScreen.kt",
        "app/src/main/java/com/bingwascore/app/ui/transactions/TransactionsScreen.kt"
    )

    /** Every `items(` / `itemsIndexed(` call in the file, as raw argument text. */
    private fun lazyItemCalls(src: String): List<String> {
        val calls = mutableListOf<String>()
        var index = 0
        while (index < src.length) {
            val hit = listOf("itemsIndexed(", "items(")
                .map { it to src.indexOf(it, index) }
                .filter { it.second >= 0 }
                .minByOrNull { it.second }
            if (hit == null) break
            val start = hit.second + hit.first.length - 1
            var depth = 0
            var i = start
            while (i < src.length) {
                when (src[i]) {
                    '(' -> depth++
                    ')' -> {
                        depth--
                        if (depth == 0) break
                    }
                }
                i++
            }
            calls += src.substring(start + 1, i)
            index = i
        }
        return calls
    }

    @Test
    fun `every lazy list on the scroll paths has a stable key`() {
        scrollPaths.forEach { path ->
            val calls = lazyItemCalls(source(path))
            assertTrue("$path has no lazy list to check", calls.isNotEmpty())
            calls.forEach { call ->
                assertTrue("$path has a lazy list without a key: ${call.take(60)}", call.contains("key ="))
            }
        }
    }

    @Test
    fun `the rows of offers and transactions keep their action identity`() {
        val offers = source("app/src/main/java/com/bingwascore/app/ui/offers/OffersScreen.kt")
        assertTrue(
            "the offer cards must use a remembered action",
            offers.contains("rememberAction(offer.id)")
        )
        val transactions = source("app/src/main/java/com/bingwascore/app/ui/transactions/TransactionsScreen.kt")
        assertTrue(
            "the transaction rows must use a remembered action",
            transactions.contains("rememberAction(transaction.id)")
        )
    }

    @Test
    fun `the clock is read once per frame, not once per row`() {
        val home = source("app/src/main/java/com/bingwascore/app/ui/home/HomeScreen.kt")
        assertTrue("home must bucket the clock", home.contains("CLOCK_BUCKET_MILLIS"))
        assertTrue(
            "the row must take the clock from above",
            home.contains("timeAgo(tx.createdAt, now)")
        )
    }

    @Test
    fun `the derived lists are remembered`() {
        val offers = source("app/src/main/java/com/bingwascore/app/ui/offers/OffersScreen.kt")
        assertTrue(
            "the selected offers must be remembered",
            offers.contains("remember(offers, state.selectedIds)")
        )
        val transactions = source("app/src/main/java/com/bingwascore/app/ui/transactions/TransactionsScreen.kt")
        assertTrue(
            "the selected statuses must be remembered",
            transactions.contains("remember(state.transactions, state.selectedIds)")
        )
    }
}
