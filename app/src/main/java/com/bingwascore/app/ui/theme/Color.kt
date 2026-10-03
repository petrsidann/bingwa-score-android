package com.bingwascore.app.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.bingwascore.app.domain.ThemeMode

/**
 * REBRAND R1 — the Bingwa Score colour system.
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are *mode aware* — they read [DisplayModeState], which the theme writes
 * on every recomposition, so switching display mode repaints the whole app on
 * the next frame without restarting anything or touching a single screen.
 *
 * Modes (Settings > Appearance, there is deliberately NO light mode):
 * - [ThemeMode.DARK]             — the product truth: black + electric blue.
 * - [ThemeMode.GRAYSCALE]        — monochrome dark; accents fall back to #BDBDBD.
 * - [ThemeMode.BLUE_LIGHT_FILTER]— warm dark that tames blue light (night use).
 */
internal object DisplayModeState {
    var mode: ThemeMode by mutableStateOf(ThemeMode.DARK)
}

/** Written by the theme after a successful composition; read by every token. */
internal fun installDisplayMode(value: ThemeMode) {
    if (DisplayModeState.mode != value) DisplayModeState.mode = value
}

/** The display mode currently painted by the app. */
val currentDisplayMode: ThemeMode get() = DisplayModeState.mode

/**
 * True in the two alternate modes, where a blue CTA can no longer read as blue:
 * buttons drop to solid near-black chips with a hairline border instead.
 */
val usesSolidChips: Boolean get() = DisplayModeState.mode != ThemeMode.DARK

// ─── Surfaces ─────────────────────────────────────────────────────────────────
val BgBlack: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF0A0806)
    else -> Color(0xFF000000)
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF140F0B)
    else -> Color(0xFF141414)
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF1D1712)
    else -> Color(0xFF1C1C1C)
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF2E241B)
    else -> Color(0xFF2A2A2A)
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF1B1409)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────
val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFFFE9C9)
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFA3907A)
    else -> Color(0xFF9E9E9E)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF7A6A57)
    else -> Color(0xFF6B6B6B)
}

// ─── Accents + statuses ───────────────────────────────────────────────────────
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFFFB74D)
    ThemeMode.DARK -> Color(0xFF2962FF)
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFFFB74D)
    ThemeMode.DARK -> Color(0xFF3D6FFF)
}

val FailRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF757575)
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFE57373)
    ThemeMode.DARK -> Color(0xFFFF5252)
}

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF9E9E9E)
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFFA3907A)
    ThemeMode.DARK -> Color(0xFF9E9E9E)
}

/** Reserved for the "mark complete" tick and nothing else. */
val TickGreen: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    ThemeMode.BLUE_LIGHT_FILTER -> Color(0xFF9CCC65)
    ThemeMode.DARK -> Color(0xFF00C853)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/** Blue in DARK; a solid near-black chip in GRAYSCALE / BLUE LIGHT FILTER. */
val CtaFill: Color get() = if (usesSolidChips) BgBlack else AccentBlue

/** Ink drawn on [CtaFill] — always the strongest readable colour. */
val CtaInk: Color get() = TextWhite

/** The hairline that separates a solid chip from the background. */
val CtaBorder: Color get() = if (usesSolidChips) Hairline else Color.Transparent

/** Shared chrome for tracks, dividers and inactive dots. */
val DotTrack: Color get() = Raised
val FaintDivider: Color get() = Hairline

/** Solid accent brush — the brand has no gradients any more. */
fun accentBrush(): Brush = SolidColor(AccentBlue)

/** Agent level badges — a neutral ladder, never a warm hue. */
val Bronze: Color get() = Color(0xFF8D8D8D)
val Silver: Color get() = Color(0xFFB0B0B0)
val Gold: Color get() = Color(0xFFD0D0D0)
val Platinum: Color get() = Color(0xFFFFFFFF)

/** Accent that must stay legible on top of [AccentBlue]. */
val OnAccent: Color get() = Color(0xFFFFFFFF)

/** Offer tag buckets (Hybrid OfferTag OFFER_1..OFFER_4). */
object OfferTags {
    const val OFFER_1 = "OFFER_1"
    const val OFFER_2 = "OFFER_2"
    const val OFFER_3 = "OFFER_3"
    const val OFFER_4 = "OFFER_4"
    val ALL = listOf(OFFER_1, OFFER_2, OFFER_3, OFFER_4)
}
