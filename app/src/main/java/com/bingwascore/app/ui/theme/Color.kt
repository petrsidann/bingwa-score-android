package com.bingwascore.app.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.ThemeMode

/**
 * Stage 10 — iOS design system colour tokens: Obsidian (dark) + Porcelain (light).
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are *mode aware* — they read [DisplayModeState], which the theme writes
 * on every recomposition, so switching mode repaints the whole app instantly.
 *
 * Porcelain (iMessage-grade): bg #F2F2F7, cards #FFFFFF,
 * separators rgba(60,60,67,0.29) inset 0.33dp, text #000 / #3C3C43,
 * accents brand blue #2563EB family (+ iOS #007AFF allowed).
 * Obsidian (dark): keeps the #0B0E15 family.
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

/** True in Porcelain. */
val isPorcelain: Boolean get() = DisplayModeState.mode == ThemeMode.LIGHT

/** Stage 10 — porcelain light tokens (iMessage-grade). */
val PorcelainBg: Color = Color(0xFFF2F2F7)
val PorcelainCard: Color = Color(0xFFFFFFFF)
val PorcelainSeparator: Color = Color(0x4A3C3C43)
val PorcelainText: Color = Color(0xFF000000)
val PorcelainSecondaryText: Color = Color(0xFF3C3C43)
val IosBlue: Color = Color(0xFF007AFF)
/** Brand blue family. */
val BrandBlue: Color = Color(0xFF2563EB)

// ─── Surfaces ─────────────────────────────────────────────────────────────────
val BgBlack: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> PorcelainBg
    else -> Color(0xFF0B0E15)
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> PorcelainCard
    else -> Color(0xFF131824)
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFFE5E5EA)
    else -> Color(0xFF1B2233)
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> PorcelainSeparator
    else -> Color(0xFF232C42)
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0x1A007AFF)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────
val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> PorcelainText
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFF4B5563)
    else -> Color(0xFF9E9E9E)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFF6D6D72)
    else -> Color(0xFF6B6B6B)
}

// ─── Accents + statuses ───────────────────────────────────────────────────────

/**
 * Stage 10 — the semantic status palette: identical in BOTH themes.
 */

/** Stage 10 — the semantic status palette: identical in BOTH themes. */
val SemanticBlue: Color = Color(0xFF3E6BFF)
val SemanticRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFFFC1E1E)
    else -> Color(0xFFFF5252)
}
val SemanticGrey: Color = Color(0xFF4B5563)

/** Stage 10 — Done/Failed/Queued are the semantic trio in every theme. */
val StatusDone: Color get() = SemanticBlue
val StatusFailedTint: Color get() = SemanticRed

/** Queued stays **neutral** in every mode: light in Porcelain, light charcoal in Obsidian so the label stays readable. */
val StatusQueued: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFF4B5563)
    else -> Color(0xFF9CA3AF)
}

/** Stage 10 — chrome accent: brand blue family; iOS blue in Porcelain. */
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> IosBlue
    else -> BrandBlue
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> IosBlue
    else -> Color(0xFF5482FF)
}

val FailRed: Color get() = SemanticRed

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = SemanticGrey

/**
 * Stage 10 — secondary text floor: 60% ink clears AA on every surface
 * in both themes.
 */
val TextFaint: Color get() = TextWhite.copy(alpha = 0.6f)

/**
 * POLISH P2 — the card wash.
 *
 * A status tile (or a status row) is the bubble surface with a 12% tint of its
 * own status colour laid over it. The colour is the *semantic* one, identical
 * in both themes.
 */
fun statusWash(statusColor: Color, alpha: Float = 0.12f): Color = statusColor.copy(alpha = alpha)

/** Reserved for the "mark complete" tick and nothing else. */
val TickGreen: Color get() = Color(0xFF00C853)

// ─── Stage 10 — iOS materials (blur ONLY here: nav bars + sheets) ────────────

/** Translucent material fill for nav bars + page sheets. */
val IosMaterialFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xB8F2F2F7)
    else -> Color(0xB80B0E15)
}

/** iOS hairline border for the floating tab pill. */
fun iosPillBorderBrush(): Brush = Brush.linearGradient(
    colors = listOf(
        Color(0x1A000000),
        Color(0x0D000000)
    )
)

/** Stage 10 — iOS language: inset grouped cards use a 12dp radius. */
val IOS_CARD_RADIUS: androidx.compose.ui.unit.Dp = 12.dp

/**
 * Stage 10 — iOS grouped-list separator: rgba(60,60,67,0.29) in Porcelain,
 * hairline on the dark canvas.
 */
val IosSeparator: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> PorcelainSeparator
    else -> Hairline
}

/**
 * Stage 10 — the disabled pair: clears AA in BOTH themes. Porcelain inks grey
 * on a light fill; Obsidian keeps light ink on a raised fill.
 */
val DisabledFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFFD1D1D6)
    else -> Color(0xFF232323)
}

val DisabledInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFF3A3A3C)
    else -> Color(0xFF9E9E9E)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/** Stage 10 — capsule CTA: brand blue fill, white ink, both themes. */
val CtaFill: Color get() = AccentBlue

/** Ink drawn on [CtaFill]. */
val CtaInk: Color get() = TextWhite

/** The hairline that separates a solid chip from the background. */
val CtaBorder: Color get() = Color.Transparent

/** Stage 10 — secondary outline: hairline dark, grey light. */
val SecondaryOutline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.LIGHT -> Color(0xFF8E8E93)
    else -> Hairline
}

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
