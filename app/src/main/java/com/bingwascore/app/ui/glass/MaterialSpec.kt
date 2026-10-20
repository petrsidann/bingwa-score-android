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
    /** 4×5 row-major matrix (Android ColorMatrix layout): saturation × contrast. */
    fun colorMatrix(): FloatArray {
        val s = SATURATION; val c = CONTRAST
        val rW = 0.213f; val gW = 0.715f; val bW = 0.072f
        val t = 0.5f * (1 - c)
        return floatArrayOf(
            (rW + (1 - rW) * s) * c, gW * (1 - s) * c, bW * (1 - s) * c, 0f, t,
            rW * (1 - s) * c, (gW + (1 - gW) * s) * c, bW * (1 - s) * c, 0f, t,
            rW * (1 - s) * c, gW * (1 - s) * c, (bW + (1 - bW) * s) * c, 0f, t,
            0f, 0f, 0f, 1f, 0f
        )
    }
}
