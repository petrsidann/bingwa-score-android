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

    /**
     * POLISH P6 — the full choreography, budgeted to stay under two seconds.
     *
     * Uber and Airbnb restraint: one mark, one breath, one sentence. The order is
     * deliberate — the stroke finishes (900), a single soft radial glow pulses
     * once behind it (a light has to arrive *after* the shape it belongs to),
     * then the wordmark letters stagger in 30ms apart, then the tagline fades.
     * Nothing loops, nothing bounces, and the hand-off lands at
     * [SPLASH_TOTAL] with room to spare for a slow first frame.
     */
    const val SPLASH_GLOW_START: Int = 880
    const val SPLASH_GLOW_PULSE: Int = 460
    const val SPLASH_WORDMARK_START: Int = 1150

    /** Stagger between wordmark letters. */
    const val SPLASH_LETTER_STAGGER: Int = 30

    /** Tagline begins once the last letter has landed. */
    const val SPLASH_TAGLINE_START: Int = 1530

    /** Splash: whole choreography before the next screen (ms) — under 2.0s. */
    const val SPLASH_TOTAL: Int = 1900

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

    // ── POLISH P2 ─────────────────────────────────────────────────────────────

    /** POLISH P2 — how long a status dot takes to light up (or go dark). */
    const val DOT_FADE: Int = 300

    /** POLISH P2 — the spring behind the chart tooltip bubble. */
    const val TOOLTIP_SPRING_STIFFNESS: Float = 420f

    /** POLISH P2 — long-press that arms the Autopilot stop, in ms. */
    const val ARM_HOLD_MILLIS: Long = 600L
}
