package com.bingwascore.app.ui.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.data.local.DbNameHolder
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TextGrey

/**
 * SHOWCASE S3 — the honesty badge.
 *
 * While Showcase Mode is on, a blue-outlined DEMO chip sits in the top bar of the
 * main screens. Anyone watching must be able to tell, at a glance, that the
 * counters moving on screen are simulated.
 */
@Composable
fun DemoChip(modifier: Modifier = Modifier) {
    if (!DbNameHolder.showcaseMode) return

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .border(1.dp, AccentBlue, RoundedCornerShape(6.dp))
            .background(AccentBlue.copy(alpha = 0.12f))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            "DEMO",
            color = AccentBlue,
            fontSize = 11.sp,
            letterSpacing = 1.sp
        )
    }
}

/** Spacer so the chip never collides with a title on narrow screens. */
@Composable
fun DemoChipSpacer() {
    if (!DbNameHolder.showcaseMode) return
    Box(modifier = Modifier.size(4.dp))
}