package com.bingwascore.app.ui.glass

/** Stage 18 — pure material constants (zero Compose imports: JVM-testable). */
object MaterialSpec {
    const val BLUR_DP = 24
    const val MAX_BLUR_DP = 28
    const val VIBRANCY_ALPHA = 0.10f
    const val SATURATION = 1.2f
    const val CONTRAST = 1.1f
    val LAYER_ORDER = listOf("blur", "vibrancy", "sat_contrast", "content")
    fun canBlur(sdk: Int = 33): Boolean = sdk >= 31
    fun vibrancyAlpha(): Float = VIBRANCY_ALPHA
    fun colorMatrix(): FloatArray {
        val s = SATURATION; val c = CONTRAST
        val rW = 0.213f; val gW = 0.715f; val bW = 0.072f
        val sat = floatArrayOf(rW+(1-rW)*s, gW*s, bW*s, 0f, rW*s, gW+(1-gW)*s, bW*s, 0f, rW*s, gW*s, bW+(1-bW)*s, 0f, 0f, 0f, 0f, 1f)
        val t = 0.5f * (1 - c); val out = FloatArray(16)
        for (r in 0..2) { for (col in 0..2) out[r*4+col] = sat[r*4+col]*c; out[r*4+3] = t }
        out[15] = 1f; return out
    }
}
