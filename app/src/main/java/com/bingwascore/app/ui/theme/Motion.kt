package com.bingwascore.app.ui.theme

/**
 * Animation timing tokens — tuned for a premium iOS-style motion curve.
 *
 * Every motion value in the app reads from here so the feel stays consistent
 * across screens, lists and buttons. Sequencing pauses (e.g. the splash
 * choreography `delay(...)` steps) stay literal at the call site — these
 * tokens cover animation *durations* and shared timing constants.
 */
object Motion {
    /** Stagger delay (ms) between successive list rows / cards. */
    const val STAGGER: Int = 40

    /** Spring damping ratio — 0.8f gives a soft, slightly bouncy feel. */
    const val DAMPING: Float = 0.8f

    // ── Durations (ms) ────────────────────────────────────────────────────────

    /** Card enter: fade-in (see [com.bingwascore.app.ui.components.enterAnimation]). */
    const val FADE: Int = 320

    /** Card enter: slide-up (see [com.bingwascore.app.ui.components.enterAnimation]). */
    const val SLIDE: Int = 360

    /** Splash: logo & wordmark fade duration. */
    const val SPLASH_FADE: Int = 300

    /** R1 splash: the monogram draws itself on over 900ms via PathMeasure trim. */
    const val SPLASH_DRAW: Int = 900

    /** R1 splash: whole choreography before the next screen (ms). */
    const val SPLASH_TOTAL: Int = 1600

    /** Splash: wordmark → tagline step duration. */
    const val SPLASH_STEP: Int = 250

    /** Score: hero count-up duration. */
    const val COUNT_UP: Int = 700

    /** Stats: chart draw-in duration. */
    const val CHART: Int = 900

    /** Shimmer skeleton loop duration. */
    const val SHIMMER: Int = 1200

    /** Confetti burst duration. */
    const val CONFETTI: Int = 1200

    /** Dialer FAB glow pulse period. */
    const val GLOW: Int = 1800

    /** Ambient background blob drift — slow reversed loops. */
    const val AMBIENT_MIN: Int = 22_000
    const val AMBIENT_MID: Int = 28_000
    const val AMBIENT_MAX: Int = 34_000
}
