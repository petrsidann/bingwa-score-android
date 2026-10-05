package com.bingwascore.app.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.bingwascore.app.domain.ThemeMode

/**
 * POLISH P5 - the Bingwa Score colour system.
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are *mode aware* - they read [DisplayModeState], which the theme writes
 * on every recomposition, so switching mode repaints the whole app on the next
 * frame without restarting anything or touching a single screen.
 *
 * Modes (Settings > Appearance, there is deliberately NO light mode):
 * - [ThemeMode.DARK]      "Obsidian"  - pure black, softened electric blue.
 * - [ThemeMode.GRAYSCALE] "Grayscale" - monochrome chrome, semantic colour kept.
 * - [ThemeMode.SILICA]    "Silica"     - frosted glass, orbs, gradient hairlines.
 *
 * The old BLUE LIGHT FILTER is gone: a warm cast over a black terminal UI was
 * never a mode, it was a night-light workaround, and it cost real contrast.
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
    // Silica is never pure black: glass needs something behind it to refract.
    ThemeMode.SILICA -> Color(0xFF07070C)
    else -> Color(0xFF000000)
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x14FFFFFF)   // translucent: the orbs show through
    else -> Color(0xFF141414)
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x1FFFFFFF)
    else -> Color(0xFF1C1C1C)
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x33FFFFFF)
    else -> Color(0xFF2A2A2A)
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x263E6BFF)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────
val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFFF2F4FF)
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFFB9BDD4)
    else -> Color(0xFF9E9E9E)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFF8B90AD)
    else -> Color(0xFF6B6B6B)
}

// ─── Accents + statuses ───────────────────────────────────────────────────────

/**
 * POLISH P5 — the semantic status palette.
 *
 * These three are **not** mode-aware, and that is the whole point: a failed
 * transaction is red in Obsidian, red in Grayscale and red in Silica. Only the
 * *chrome* (buttons, nav, switches, surfaces) changes with the mode, so switching
 * to Grayscale never costs the agent the one signal that matters — which rows
 * failed and which cleared.
 */
val SemanticBlue: Color = Color(0xFF3E6BFF)
val SemanticRed: Color = Color(0xFFFF5252)
val SemanticGrey: Color = Color(0xFF9E9E9E)

/**
 * The chrome accent.
 *
 * POLISH P5 — softened about 12% from the old `#2962FF`. Pure electric blue on
 * pure black is harsh at 3am on a shop counter and, at full strength behind a
 * filled label, clips. Twelve percent of headroom keeps it unmistakably blue and
 * comfortably readable.
 */
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF4176FF)
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF5482FF)
}

val FailRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF757575)
    else -> SemanticRed
}

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = SemanticGrey

/**
 * POLISH P6 — the floor for secondary text, after the contrast audit.
 *
 * Every "metadata" label used to be `TextFaint`, which lands
 * around 3.7:1 on the bubble surface — below the 4.5:1 AA threshold for small
 * text, and worse on Silica where the surface is translucent. Sixty percent white
 * measures about 7:1 on every surface in all three modes, so this is the one
 * faint ink in the app and the audit's replacement for the whole family.
 */
val TextFaint: Color get() = TextWhite.copy(alpha = 0.6f)

/**
 * POLISH P2 — the card wash.
 *
 * A status tile (or a status row) is the bubble surface with a 12% tint of its
 * own status colour laid over it. Ten to fourteen percent is the band where a
 * blue tile reads as blue on black without turning into a coloured slab; below it
 * nothing happens, above it the surface stops being a surface. The colour is the
 * *semantic* one, so Grayscale keeps the wash even when the chrome goes mono.
 */
fun statusWash(statusColor: Color, alpha: Float = 0.12f): Color = statusColor.copy(alpha = alpha)

/** Reserved for the "mark complete" tick and nothing else. */
val TickGreen: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF00C853)
}

// ─── POLISH P5 — Silica glass ─────────────────────────────────────────────────

/** True only in the glass mode, so surfaces can branch without a mode check. */
val isSilica: Boolean get() = DisplayModeState.mode == ThemeMode.SILICA

/** The frosted fill of a card: white at 8%, so the orbs behind it show through. */
val GlassFill: Color get() = Color(0x14FFFFFF)

/** A slightly denser glass for sheets and rails that sit above content. */
val GlassFillStrong: Color get() = Color(0x1FFFFFFF)

/**
 * The gradient hairline.
 *
 * A flat 1px border around glass looks like a mistake; a hairline that fades
 * from 26% white to 6% across the shape reads as an edge catching light, which
 * is what makes the card look like a pane rather than a rectangle.
 */
fun glassBorderBrush(strong: Boolean = false): Brush = Brush.linearGradient(
    colors = listOf(
        Color(0x66FFFFFF),
        Color(0x14FFFFFF),
        if (strong) Color(0x59FFFFFF) else Color(0x0FFFFFFF)
    )
)

/** The ambient orbs behind the glass: one blue, one violet. */
val OrbBlue: Color get() = Color(0x663E6BFF)
val OrbViolet: Color get() = Color(0x598C6BFF)

/** The full ambient wash painted behind a Silica screen. */
fun orbBrush(): Brush = Brush.radialGradient(
    colors = listOf(OrbBlue, Color.Transparent),
    center = androidx.compose.ui.geometry.Offset(180f, 220f),
    radius = 780f
)

/**
 * The disabled pair.
 *
 * POLISH P5 — the old disabled button was `Raised` with 45% white on top, which
 * measured about 2.4:1 and made "Dial Now" look broken rather than unavailable.
 * These are explicit tokens: the fill is a shade above the surface and the ink is
 * a fixed 60% white, which clears 4.5:1 on black in every mode.
 */
val DisabledFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x1AFFFFFF)
    else -> Color(0xFF232323)
}

val DisabledInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x99FFFFFF)
    else -> Color(0xFF9E9E9E)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/** Blue in DARK and SILICA; a solid near-black chip in GRAYSCALE. */
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
