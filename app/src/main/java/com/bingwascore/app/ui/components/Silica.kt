package com.bingwascore.app.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.iosPillBorderBrush

/**
 * Stage 10 — iOS materials. Blur lives ONLY here (nav bars + page sheets):
 * a translucent material fill + hairline + backdrop blur where the platform
 * can do one (API 31+). Cards NEVER blur — they are flat grouped surfaces.
 */
object IosMaterial {

    /** True when the running device can render a real backdrop blur. */
    val canBlur: Boolean get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    /** Blur radius for nav bars + sheets. */
    val BAR_BLUR: Dp = 24.dp
}

/**
 * Stage 10 — the iOS material modifier for nav bars + page sheets ONLY.
 * Everywhere else use [bubbleSurface] (flat, no blur).
 */
@Composable
fun Modifier.iosMaterial(
    shape: Shape,
    fill: Color = IosMaterialFill
): Modifier {
    val resolved = this
        .clip(shape)
        .background(fill)
        .border(1.dp, iosPillBorderBrush(), shape)
    return if (IosMaterial.canBlur) resolved.blur(IosMaterial.BAR_BLUR) else resolved
}

