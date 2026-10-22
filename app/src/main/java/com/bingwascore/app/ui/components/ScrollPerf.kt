package com.bingwascore.app.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState

/**
 * Stage 22 — the lag sweep's one helper: a scroll-path action that keeps its
 * identity.
 *
 * A row's callback is usually written inline:
 *
 * ```kotlin
 * items(rows, key = { it.id }) { row ->
 *     Row(onClick = { callbacks.onRowClick(row) })   // a NEW lambda every frame
 * }
 * ```
 *
 * Inline, that lambda is a new object on every recomposition, so Compose can
 * never skip the row: one arriving transaction and the whole visible list
 * recomposes — the >16ms hitch this sweep exists to kill.
 *
 * [rememberAction] hands back ONE lambda per [key]. Its identity never changes,
 * so the row skips; the action it runs is always the latest one, because
 * [rememberUpdatedState] keeps the newest closure underneath.
 */
@Composable
fun rememberAction(key: Any?, action: () -> Unit): () -> Unit {
    val latest = rememberUpdatedState(action)
    return remember(key) { { latest.value() } }
}
