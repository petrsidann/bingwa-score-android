package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Stage 10 — iOS material tokens (kept for bar blur radius reference).
 * Stage 18 — the live modifier moved to ui.glass.iosMaterial (single source).
 * This file keeps only the radius constant; do NOT add another modifier here.
 */
object IosMaterial {

    /** True when the running device can render a real backdrop blur. */
    val canBlur: Boolean get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    /** Blur radius for nav bars + sheets. */
    val BAR_BLUR: Dp = 24.dp
}

/** Stage 18 — the live modifier lives in ui.glass.iosMaterial (single source). */

