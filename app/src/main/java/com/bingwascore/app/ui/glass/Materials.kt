package com.bingwascore.app.ui.glass

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.iosPillBorderBrush

/** Stage 18 — iOS 27 material engine: blur + vibrancy + sat/contrast. Layer order back→front: blur → vibrancy → sat/contrast → content. Pure constants live in [MaterialSpec] (MaterialSpec.kt). Chrome-only (pill, drawer, sheets, top bars). Never in list items; never nested; radius ≤28dp. */
/** Compose-only tint (kept out of MaterialSpec so JVM tests stay pure). */
@Composable
internal fun materialVibrancyTint(): Color = AccentBlue.copy(alpha = MaterialSpec.VIBRANCY_ALPHA)

val canMaterialBlur: Boolean get() = MaterialSpec.canBlur(Build.VERSION.SDK_INT)
@Composable
fun Modifier.iosMaterial(shape: Shape, tint: Color = IosMaterialFill): Modifier = this.clip(shape).background(tint).background(materialVibrancyTint(), shape).border(1.dp, iosPillBorderBrush(), shape)
