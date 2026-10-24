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
 * Stage 24 â€” iOS design system colour tokens: Obsidian (dark) + Porcelain Dim (default).
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are *mode aware* — they read [DisplayModeState], which the theme writes
 * on every recomposition, so switching mode repaints the whole app instantly.
 *
 * Obsidian (dark): keeps the #0B0E15 family.
 * Porcelain Dim (#C9CED6 canvas): dimmed lights, soft blue accent #2F6AE0.
 */
internal object DisplayModeState {
    var mode: ThemeMode by mutableStateOf(ThemeMode.PORCELAIN_DIM)
}

/** Written by the theme after a successful composition; read by every token. */
internal fun installDisplayMode(value: ThemeMode) {
    if (DisplayModeState.mode != value) DisplayModeState.mode = value
}

/** The display mode currently painted by the app. */
val currentDisplayMode: ThemeMode get() = DisplayModeState.mode

/** True in Porcelain Dim â€” the only light canvas left. */
val isPorcelain: Boolean get() = DisplayModeState.mode != ThemeMode.DARK

/**
 * Stage 22 — PORCELAIN DIM: the lights dimmed, not the sun turned off.
 *
 * A dim porcelain canvas (a cool grey, never Obsidian black), cards lifted a
 * step above it, near-black ink, and the brand blue kept but SOFTENED so a
 * dimmed screen never shouts. Every pair below is contrast-pinned against the
 * dim canvas by `Stage22PorcelainDimTest`.
 */
val PorcelainDimBg: Color = Color(0xFFC9CED6)
val PorcelainDimCard: Color = Color(0xFFDBDFE5)
val PorcelainDimSurface: Color = Color(0xFFD3D8DF)
val PorcelainDimRaised: Color = Color(0xFFBFC4CD)
val PorcelainDimSeparator: Color = Color(0x593C3C43)
val PorcelainDimText: Color = Color(0xFF111419)
val PorcelainDimSecondaryText: Color = Color(0xFF3E4650)
val PorcelainDimTertiaryText: Color = Color(0xFF565E69)
/** The soft blue accent: the brand family, one step down. */
val PorcelainDimAccent: Color = Color(0xFF2F6AE0)
val PorcelainDimChartBlue: Color = Color(0xFF4F86F2)
/** The dimmed signal red: the same hue, deepened so it still clears 3:1. */
val PorcelainDimFailed: Color = Color(0xFFC41B1B)
val PorcelainDimDisabledFill: Color = Color(0xFFAEB4BE)
val PorcelainDimDisabledInk: Color = Color(0xFF2A2F37)

/** Brand blue family. */
val BrandBlue: Color = Color(0xFF2563EB)

// ─── Surfaces ─────────────────────────────────────────────────────────────────
val BgBlack: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimBg
    else -> Color(0xFF0B0E15)
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimCard
    else -> Color(0xFF131824)
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimRaised
    else -> Color(0xFF1B2233)
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimSeparator
    else -> Color(0xFF232C42)
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> Color(0x1A2F6AE0)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────
val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimText
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimSecondaryText
    else -> Color(0xFF9E9E9E)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimTertiaryText
    else -> Color(0xFF6B6B6B)
}

// ─── Accents + statuses ───────────────────────────────────────────────────────

/**
 * Stage 10 — the semantic status palette: identical in Obsidian and Porcelain.
 *
 * Stage 22 — Porcelain Dim DEEPENS them. The dim canvas is darker than
 * porcelain, and the shared tints drop below 3:1 on it; the dim theme uses the
 * brand blue and a deepened signal red so a status still reads at a glance.
 */
val SemanticBlue: Color = Color(0xFF3E6BFF)
val SemanticRed: Color = Color(0xFFFC1E1E)
/** Mid-grey clears 3:1 on BOTH canvases (Obsidian #0B0E15 and Porcelain Dim #C9CED6). */
val SemanticGrey: Color = Color(0xFF6B7280)

/** Stage 10 — Done/Failed/Queued are the semantic trio in every theme. */
val StatusDone: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> BrandBlue
    else -> SemanticBlue
}

val StatusFailedTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimFailed
    else -> SemanticRed
}

/** Queued stays **neutral** and identical across themes. */
val StatusQueued: Color = SemanticGrey

/** Stage 10 — chrome accent: brand blue family; iOS blue in Porcelain Dim. */
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimAccent
    else -> BrandBlue
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimChartBlue
    else -> Color(0xFF5482FF)
}

/** The error ink. Stage 22 — the dim canvas gets the deepened signal red. */
val FailRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimFailed
    else -> SemanticRed
}

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = SemanticGrey

/**
 * Stage 24 — vibrancy gradients for the Done/Failed/Queued counter tiles.
 *
 * Done   = blue gradient,  Failed = rose gradient, Queued = slate gradient.
 * Tinted surfaces replace the flat wash so nothing reads as dull grey.
 */
val StatusDoneGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusDone.copy(alpha = 0.18f), StatusDone.copy(alpha = 0.06f))
)
val StatusFailedGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusFailedTint.copy(alpha = 0.18f), StatusFailedTint.copy(alpha = 0.06f))
)
val StatusQueuedGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusQueued.copy(alpha = 0.14f), StatusQueued.copy(alpha = 0.04f))
)

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

/** Translucent material fill for nav bars + page sheets (Stage 21 — porcelain dim). */
val IosMaterialFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> Color(0xB8C9CED6)
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
    ThemeMode.PORCELAIN_DIM -> PorcelainDimSeparator
    else -> Hairline
}

/**
 * Stage 10 — the disabled pair: clears AA in BOTH themes. Porcelain inks grey
 * on a light fill; Obsidian keeps light ink on a raised fill.
 */
val DisabledFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimDisabledFill
    else -> Color(0xFF232323)
}

val DisabledInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimDisabledInk
    else -> Color(0xFF9E9E9E)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/** Stage 10 — capsule CTA: brand blue fill, white ink, both themes. */
val CtaFill: Color get() = AccentBlue

/** Ink drawn on [CtaFill]. */
val CtaInk: Color get() = Color(0xFFFFFFFF)

/** The hairline that separates a solid chip from the background. */
val CtaBorder: Color = Color.Transparent

/** Stage 10 — secondary outline: hairline dark, grey light. */
val SecondaryOutline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> Color(0xFF7C828C)
    else -> Hairline
}

/** Shared chrome for tracks, dividers and inactive dots. */
val DotTrack: Color get() = Raised
val FaintDivider: Color get() = Hairline

/** Solid accent brush — the brand has no gradients any more. */
fun accentBrush(): Brush = SolidColor(AccentBlue)

// ─── Stage 20 — the My Plan paywall band ────────────────────────────────────

/**
 * The paywall band is the one gradient the brand allows: three **opaque** blue
 * stops, no warm hue, no translucency, no glass. White ink clears AA on every
 * stop, so the band reads the same in both themes.
 */
val AuroraDeep: Color = Color(0xFF0B2A6B)
val AuroraMid: Color = Color(0xFF1D4ED8)
val AuroraEdge: Color = Color(0xFF2563EB)

/** Solid white — the band ink and the solid chip that sits on the band. */
val BandWhite: Color = Color(0xFFFFFFFF)

/** The band brush: an aurora sweep across the blue family. */
fun auroraBrush(): Brush = Brush.linearGradient(listOf(AuroraDeep, AuroraMid, AuroraEdge))

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
