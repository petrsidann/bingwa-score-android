package com.bingwascore.app.ui.theme

/**
 * Animation timing tokens — tuned for a premium iOS-style motion curve.
 *
 * Every motion value in the app reads from here so the feel stays consistent
 * across screens, lists and buttons.
 */
object Motion {
    /** Standard screen-level enter duration in milliseconds. */
    const val ENTER: Int = 350

    /** Stagger delay (ms) between successive list rows / cards. */
    const val STAGGER: Int = 40

    /** Spring damping ratio — 0.8f gives a soft, slightly bouncy feel. */
    const val DAMPING: Float = 0.8f
}