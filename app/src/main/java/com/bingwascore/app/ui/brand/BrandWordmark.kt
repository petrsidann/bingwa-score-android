package com.bingwascore.app.ui.brand

/**
 * Stage 21 — the ONE wordmark.
 *
 * The splash and the onboarding both render [TEXT], character for character,
 * so the string can never drift between screens or between themes: there is a
 * single literal in the app, and the regression test asserts it by value
 * (never by pixel).
 */
object BrandWordmark {

    /** Exactly "Bingwa Score" — twelve characters, never truncated. */
    const val TEXT: String = "Bingwa Score"

    /** The same string, split into the glyphs the splash staggers in. */
    val LETTERS: List<String> = TEXT.map { it.toString() }
}
