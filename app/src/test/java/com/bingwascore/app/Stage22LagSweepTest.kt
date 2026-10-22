package com.bingwascore.app

import androidx.compose.runtime.AbstractApplier
import androidx.compose.runtime.BroadcastFrameClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot
import com.bingwascore.app.ui.components.rememberAction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
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
 * The harness is a REAL Compose runtime (Recomposer + Composition, no pixels),
 * so the counts are real composition counts. The control case — the same rows
 * with an inline lambda — proves the invariant has teeth: it recomposes every
 * row on every frame, which is exactly the >16ms hitch the sweep removed.
 *
 * The source checks below pin the same law on the three scroll paths that
 * matter: Home, Offers and Transactions.
 */
class Stage22LagSweepTest {

    // ── The harness ──────────────────────────────────────────────────────────

    /** A composition that emits no nodes: the rows are counters, not pixels. */
    private class NoOpApplier : AbstractApplier<Unit>(Unit) {
        override fun insertBottomUp(index: Int, instance: Unit) = Unit
        override fun insertTopDown(index: Int, instance: Unit) = Unit
        override fun move(from: Int, to: Int, count: Int) = Unit
        override fun remove(index: Int, count: Int) = Unit
        override fun onClear() = Unit
    }

    /** How many times each row's body ran. */
    private object RowCount {
        val counts = mutableMapOf<String, Int>()
        val lastFrame = mutableMapOf<String, Int>()
        val lastLabel = mutableMapOf<String, String>()
        val lastAction = mutableMapOf<String, () -> Unit>()
        fun reset() {
            counts.clear()
            lastFrame.clear()
            lastLabel.clear()
            lastAction.clear()
        }
        fun of(id: String): Int = counts[id] ?: 0
        fun bump(id: String) {
            counts[id] = (counts[id] ?: 0) + 1
        }
    }

    /** One row: the body runs only when Compose decides to recompose it. */
    @Composable
    private fun CountingRow(id: String, label: String, onClick: () -> Unit) {
        RowCount.bump(id)
        // The row READS its inputs, so Compose cannot treat them as unused.
        RowCount.lastLabel[id] = label
        RowCount.lastAction[id] = onClick
    }

    /**
     * One list item.
     *
     * [stable] mirrors the app: a production row gets its action from
     * [rememberAction] (one lambda per key, stable identity). The control
     * writes the lambda inline, which is what the app used to do.
     *
     * [frame] is read INSIDE the item, so bumping it re-renders the item —
     * the same thing a LazyColumn does when the feed is refreshed.
     */
    @Composable
    private fun RowSlot(
        id: String,
        label: String,
        stable: Boolean,
        frame: MutableState<Int>,
        onPick: (String) -> Unit
    ) {
        RowCount.lastFrame[id] = frame.value
        val action = if (stable) {
            rememberAction(id) { onPick(id) }
        } else {
            { onPick(id) }
        }
        CountingRow(id, label, action)
    }

    /** The list: it re-renders its items whenever the frame moves. */
    @Composable
    private fun ScrollParent(
        labels: Map<String, MutableState<String>>,
        stable: Boolean,
        frame: MutableState<Int>,
        onPick: (String) -> Unit
    ) {
        RowSlot("a", labels.getValue("a").value, stable, frame, onPick)
        RowSlot("b", labels.getValue("b").value, stable, frame, onPick)
        RowSlot("c", labels.getValue("c").value, stable, frame, onPick)
    }

    /** One frame of the scroll: a mutation of the feed. */
    private class Frame(
        val mutate: (
            frame: MutableState<Int>,
            labels: Map<String, MutableState<String>>
        ) -> Unit
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun TestScope.scrollFrames(
        stable: Boolean,
        rows: List<String>,
        frames: List<Frame>
    ) {
        RowCount.reset()
        val clock = BroadcastFrameClock()
        // The recomposer's own job hangs off a standalone Job, not the test's,
        // so runTest never waits on a frame loop that only a device drives.
        val effectJob = Job()
        val recomposer = Recomposer(coroutineContext + clock + effectJob)
        val composition = Composition(NoOpApplier(), recomposer)
        val job = launch(clock) { recomposer.runRecomposeAndApplyChanges() }
        try {
            val frame = mutableStateOf(0)
            val labels = rows.associateWith { mutableStateOf("row-$it") }
            var picks = 0

            composition.setContent {
                ScrollParent(labels, stable, frame) { picks++ }
            }
            advanceUntilIdle()

            frames.forEach { scrollFrame ->
                scrollFrame.mutate(frame, labels)
                // On a device the frame callback sends the apply notifications;
                // off-device nothing does, so the harness does it.
                Snapshot.sendApplyNotifications()
                // Let the recomposer wake up and ask for a frame, then give it
                // one, then let the frame land.
                advanceUntilIdle()
                clock.sendFrame(0)
                advanceUntilIdle()
            }
        } finally {
            job.cancel()
            effectJob.cancel()
        }
    }

    // ── The invariants ───────────────────────────────────────────────────────

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `a frame that moves nothing composes no rows`() = runTest {
        scrollFrames(
            stable = true,
            rows = listOf("a", "b", "c"),
            frames = listOf(
                Frame { frame, _ -> frame.value = frame.value + 1 },
                Frame { frame, _ -> frame.value = frame.value + 1 }
            )
        )
        // One composition per row, at the start. The two later frames composed
        // NOTHING: the rows skipped.
        listOf("a", "b", "c").forEach { id ->
            assertEquals("row $id must compose once, not per frame", 1, RowCount.of(id))
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `the control case proves the invariant has teeth`() = runTest {
        scrollFrames(
            stable = false,
            rows = listOf("a", "b", "c"),
            frames = listOf(
                Frame { frame, _ -> frame.value = frame.value + 1 }
            )
        )
        // The inline lambda is a new object every frame, so every row
        // recomposes — the hitch the sweep removed.
        listOf("a", "b", "c").forEach { id ->
            assertEquals("row $id must recompose with an inline action", 2, RowCount.of(id))
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `only the row that changed recomposes`() = runTest {
        scrollFrames(
            stable = true,
            rows = listOf("a", "b", "c"),
            frames = listOf(
                Frame { frame, labels ->
                    frame.value = frame.value + 1
                    labels.getValue("b").value = "row-b-updated"
                }
            )
        )
        assertEquals("the changed row must recompose", 2, RowCount.of("b"))
        assertEquals("an untouched row must skip", 1, RowCount.of("a"))
        assertEquals("an untouched row must skip", 1, RowCount.of("c"))
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
